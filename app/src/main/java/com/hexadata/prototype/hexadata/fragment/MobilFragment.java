package com.hexadata.prototype.hexadata.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hexadata.prototype.hexadata.R;
import com.hexadata.prototype.hexadata.adapter.KendaraanAdapter;
import com.hexadata.prototype.hexadata.entity.KendaraanInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muadz Nurhasan on 04/08/2017.
 */
public class MobilFragment extends Fragment {

    RecyclerView recList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mobil, container, false);

        recList = (RecyclerView) v.findViewById(R.id.ListMobil);
        recList.setHasFixedSize(true);
        final LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        List<KendaraanInfo> result = new ArrayList<KendaraanInfo>();

        KendaraanInfo ci = new KendaraanInfo();
        ci.plat = "L G765 BT";
        ci.nama = "Nissan";
        ci.tanggal = "12-02-2017";
        result.add(ci);

        KendaraanInfo ci2 = new KendaraanInfo();
        ci2.plat = "L G762 BT";
        ci2.nama = "Honda";
        ci2.tanggal = "12-02-2017";
        result.add(ci2);

        KendaraanInfo ci3 = new KendaraanInfo();
        ci3.plat = "L G763 BT";
        ci3.nama = "Grandong";
        ci3.tanggal = "12-02-2017";
        result.add(ci3);

        KendaraanAdapter ca = new KendaraanAdapter(result,getActivity());
        recList.setAdapter(ca);

        return v;
    }
}
