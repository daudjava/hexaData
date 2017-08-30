package com.hexadata.prototype.hexadata.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.hexadata.prototype.hexadata.R;
import com.hexadata.prototype.hexadata.entity.KendaraanInfo;

import java.util.List;


public class KendaraanAdapter extends RecyclerView.Adapter<KendaraanAdapter.KendaraanViewHolder> {

    private List<KendaraanInfo> KendaraanList;
    private Context ctx;

    public KendaraanAdapter(List<KendaraanInfo> KendaraanList, Context ct) {
        this.KendaraanList = KendaraanList;
        this.ctx = ct;

    }


    @Override
    public int getItemCount() {
        return KendaraanList.size();
    }

    @Override
    public void onBindViewHolder(KendaraanViewHolder kendaraanViewHolder, int i) {
        KendaraanInfo ci = KendaraanList.get(i);
        kendaraanViewHolder.vInfo.setText(""+ci.nama+" "+ci.plat+" "+ci.tanggal);

    }

    @Override
    public KendaraanViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.view_kendaraan, viewGroup, false);

        return new KendaraanViewHolder(itemView);
    }

    public static class KendaraanViewHolder extends RecyclerView.ViewHolder {

        protected TextView vInfo;


        public KendaraanViewHolder(View v) {
            super(v);
            vInfo =  (TextView) v.findViewById(R.id.txtInfo);

        }
    }

}

