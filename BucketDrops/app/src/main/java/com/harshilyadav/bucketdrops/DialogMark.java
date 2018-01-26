package com.harshilyadav.bucketdrops;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v7.widget.AppCompatImageButton;
import android.widget.ImageButton;
import android.widget.Toast;

import com.harshilyadav.bucketdrops.adapters.CompleteListener;

/**
 * Created by harshilyadav on 25/01/18.
 */

public class DialogMark extends DialogFragment {
    private ImageButton mBtnCLose;
    private Button mBtnCompleted;

    private View.OnClickListener mBtnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_completed:
                    markAsComplete();
                    break;
            }
            dismiss();
        }
    };
    private CompleteListener mListener;

    private void markAsComplete() {
        Bundle arguements=getArguments();
        if(mListener!=null&& arguements!=null){
            int position=arguements.getInt("Position");
            mListener.onComplete(position);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_mark,container,false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(android.support.v4.app.DialogFragment.STYLE_NORMAL,R.style.DialogTheme);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtnCLose=(ImageButton)view.findViewById(R.id.btn_close);
        mBtnCompleted=(Button) view.findViewById(R.id.btn_completed);
        mBtnCompleted.setOnClickListener(mBtnClickListener);
        mBtnCLose.setOnClickListener(mBtnClickListener);

    }

    public void setCompleteListener(CompleteListener completeListener) {
        mListener=completeListener;
    }
}
