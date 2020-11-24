package com.example.androidclient.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidclient.R
import com.example.androidclient.adapter.MyRoomAdapter
import com.example.androidclient.adapter.MyTeamAdapter
import com.example.androidclient.data.MyTeamData
import kotlinx.android.synthetic.main.fragment_myteam.*
import kotlinx.android.synthetic.main.fragment_myteam.view.*

class MyTeamFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_myteam, container, false)

        val myTeamList = ArrayList<MyTeamData>()
            myTeamList.add(MyTeamData("team1"))

        val adapter = MyTeamAdapter(myTeamList)
        view.myTeamRcView.adapter = adapter

        view.room_Btn.setOnClickListener {
            setFrag(0)
            myTeamList.clear()
            adapter.notifyDataSetChanged()
        }

        return view
    }

    private fun setFrag(fragNum : Int) {
        val ft = childFragmentManager.beginTransaction() //화면 교체를 위한 트랜잭션
        when(fragNum){
            0 -> {
                ft.replace(R.id.myTeam_Frame, MyRoomFragment()).commit()
            }
        }
    }

    private fun getMyTeam(){

    }
}