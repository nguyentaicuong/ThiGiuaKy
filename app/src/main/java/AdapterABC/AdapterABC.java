package AdapterABC;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cngnt.giuaky.R;

import java.util.List;

import Contact.DanhSach;

public class AdapterABC  extends ArrayAdapter<DanhSach> {
    Activity context;
    int resource;
    List<DanhSach> objects;
    public AdapterABC(Activity context, int resource, List<DanhSach> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);
        TextView hienthi = (TextView) row.findViewById(R.id.itemKq);
        DanhSach danhSach = this.objects.get(position);
        hienthi.setText(danhSach.getChuoi());
        return row;
    }
}
