package com.l3ios.fragmentcommunicationusingeventbus.fragment


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.l3ios.fragmentcommunicationusingeventbus.R
import kotlinx.android.synthetic.main.fragment_first.*
import org.greenrobot.eventbus.EventBus

class FirstFragment : Fragment() {

    fun newInstance(): FirstFragment {
        return FirstFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameEditText.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                EventBus.getDefault().post(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }

}
