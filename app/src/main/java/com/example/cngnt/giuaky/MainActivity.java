package com.example.cngnt.giuaky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import AdapterABC.AdapterABC;
import Contact.DanhSach;

public class MainActivity extends AppCompatActivity {
    EditText edtSoA, edtSoB;
    TextView txtHienThi;
    Button btnXuly;
    ListView listKq;
    ArrayList<DanhSach> danhSaches;
    AdapterABC adapterABC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addContact();
        addEvent();
    }

    private void addEvent() {

//        if(TextUtils.isDigitsOnly("a")){
//            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
//        }


        btnXuly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (
                        !TextUtils.isEmpty(edtSoA.getText().toString() ) &&
                                !TextUtils.isEmpty(edtSoB.getText().toString() )

                        ){
                    if (!TextUtils.isDigitsOnly(edtSoA.getText().toString()) ||
                            !TextUtils.isDigitsOnly(edtSoB.getText().toString())){
                        Toast.makeText(MainActivity.this, "Vui lòng nhập kiểu số!!!", Toast.LENGTH_LONG).show();
                    }else {
                    int a = Integer.parseInt(edtSoA.getText().toString());
                    int b = Integer.parseInt(edtSoB.getText().toString());
                    float kq = a/b;
                    txtHienThi.setText(String.valueOf(a)+ " / "+String.valueOf(b)+" = "+String.valueOf(kq));
                    DanhSach danhSach = new DanhSach(Integer.parseInt(edtSoA.getText().toString()),
                            Integer.parseInt(edtSoB.getText().toString()),
                            txtHienThi.getText().toString());
                    danhSaches.add(danhSach);
                    adapterABC.notifyDataSetChanged();
                    }
//                    int a = Integer.parseInt(edtSoA.getText().toString());
//                    int b = Integer.parseInt(edtSoB.getText().toString());
//                    float kq = a/b;
//                    txtHienThi.setText(String.valueOf(a)+ " / "+String.valueOf(b)+" = "+String.valueOf(kq));
//                    DanhSach danhSach = new DanhSach(Integer.parseInt(edtSoA.getText().toString()),
//                            Integer.parseInt(edtSoB.getText().toString()),
//                            txtHienThi.getText().toString());
//                    danhSaches.add(danhSach);
//                    adapterABC.notifyDataSetChanged();

                }else {
                    Toast.makeText(MainActivity.this, "Chưa nhập dữ liệu! ", Toast.LENGTH_LONG).show();
                }
            }
        }
        );
//        listKq.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                danhSaches.remove(position);
//                adapterABC.notifyDataSetChanged();
//            }
//        });
        listKq.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                danhSaches.remove(position);
                adapterABC.notifyDataSetChanged();
                return false;
            }
        });
    }

    private void addContact() {
        edtSoA = (EditText) findViewById(R.id.edtA);
        edtSoB = (EditText) findViewById(R.id.edtB);
        btnXuly = (Button) findViewById(R.id.btnAdd);
        listKq = (ListView) findViewById(R.id.listHT);
        txtHienThi = (TextView) findViewById(R.id.txtHienThi);
        danhSaches = new ArrayList<>();
        adapterABC = new AdapterABC(this, R.layout.items, danhSaches);
        listKq.setAdapter(adapterABC);

    }
}
