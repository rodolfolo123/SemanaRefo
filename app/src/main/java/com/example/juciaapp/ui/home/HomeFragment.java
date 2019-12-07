package com.example.juciaapp.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.juciaapp.MainActivity;
import com.example.juciaapp.R;
import com.example.juciaapp.ScanCodeActivity;

public class HomeFragment extends Fragment {

    public static TextView resultadoTextView;
    public static Button scan_btn;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        resultadoTextView = (TextView)root.findViewById(R.id.resultado);
        scan_btn = (Button)root.findViewById(R.id.btn_scan);
        final Context _context = this.getActivity().getApplicationContext();
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "hola", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(_context, ScanCodeActivity.class));
            }
        });
        return root;
    }
}