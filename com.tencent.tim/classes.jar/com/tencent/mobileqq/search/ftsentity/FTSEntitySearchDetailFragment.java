package com.tencent.mobileqq.search.ftsentity;

import amnm;
import amnn;
import amno;
import amnq;
import amns;
import amnv;
import amwe;
import amwu;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import aqdf;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.ListView;
import java.util.List;

public class FTSEntitySearchDetailFragment
  extends Fragment
  implements amwe<amnq>, Handler.Callback
{
  private static List<FTSEntity> FQ;
  private List<FTSEntity> FP;
  private TextView Sw;
  private amnm jdField_a_of_type_Amnm;
  amno jdField_a_of_type_Amno;
  FTSEntitySearchDetailActivity jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity;
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private aqdf c;
  private String caX;
  private String caY;
  private Handler handler = new Handler(this);
  private List<amnq> rc;
  
  public static FTSEntitySearchDetailFragment a(String paramString1, String paramString2, List<FTSEntity> paramList)
  {
    FQ = paramList;
    paramList = new FTSEntitySearchDetailFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("original_keyword", paramString1);
    localBundle.putString("segment_keyword", paramString2);
    paramList.setArguments(localBundle);
    return paramList;
  }
  
  private void mg(List<amnq> paramList)
  {
    this.jdField_a_of_type_Amnm.cS(paramList);
  }
  
  public void a(List<amnq> paramList, amwu paramamwu)
  {
    if (paramamwu.oI(this.caX)) {
      s(paramList, paramamwu.status);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("FTSEntitySearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramamwu.keyword, " keyword2:", this.caX });
  }
  
  public void cR(List<amnq> paramList) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      mg(this.rc);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.FP = FQ;
    FQ = null;
    paramBundle = getArguments();
    this.caX = paramBundle.getString("original_keyword");
    this.caY = paramBundle.getString("segment_keyword");
    this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity = ((FTSEntitySearchDetailActivity)getActivity());
    this.jdField_a_of_type_Amno = amns.a(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.app, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.dCD);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559536, paramViewGroup, false);
    this.Sw = ((TextView)paramLayoutInflater.findViewById(2131368427));
    this.jdField_a_of_type_ComTencentWidgetListView = ((ListView)paramLayoutInflater.findViewById(2131370527));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.c != null) {
      this.c.destory();
    }
    FQ = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    try
    {
      paramView = amns.a(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity, this.FP.size(), this.caX, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.dCD);
      this.Sw.setText(paramView);
      this.c = new aqdf(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.app);
      this.jdField_a_of_type_Amnm = new amnn(this, this.jdField_a_of_type_ComTencentWidgetListView, this.c, this.FP, this.caY, this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity);
      this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Amnm);
      this.jdField_a_of_type_Amno.R(this.caY, this.FP);
      this.jdField_a_of_type_Amnm.initData();
      if ((this.caX != null) && (this.caX.length() > 0) && (!amnv.oH(this.caX)))
      {
        this.jdField_a_of_type_Amno.init();
        paramView = amns.a(this.jdField_a_of_type_ComTencentMobileqqSearchFtsentityFTSEntitySearchDetailActivity.dCD, this.caY, (FTSEntity)this.FP.get(0));
        this.jdField_a_of_type_Amno.b(paramView, this);
      }
      return;
    }
    catch (NullPointerException paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FTSEntitySearchDetailFragment", 2, "onViewCreated: ", paramView);
    }
  }
  
  public void s(List<amnq> paramList, int paramInt)
  {
    this.rc = paramList;
    this.handler.removeMessages(-1);
    this.handler.sendEmptyMessage(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailFragment
 * JD-Core Version:    0.7.0.1
 */