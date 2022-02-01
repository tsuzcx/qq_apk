package com.tencent.mobileqq.activity.qwallet.fragment;

import aaay;
import aabl;
import aabn;
import acfp;
import acgn;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import avor;
import avox.a;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;

public class UsualHbFragment
  extends BaseHbUIFragment
  implements View.OnClickListener
{
  private static final List<Integer> uZ = new UsualHbFragment.1();
  private TextView NK;
  private aabn a;
  private LinearLayout hU;
  
  private void ctn()
  {
    if (!Wb()) {
      return;
    }
    int i = avor.c(this.numTxt.getText().toString(), 1);
    String str = avor.hX(String.valueOf(getAmount()));
    if (TextUtils.isEmpty(str))
    {
      QQToast.a(getActivity(), 2131694575, 0).show();
      return;
    }
    combineUploadData(this.jdField_a_of_type_Avox$a, getChannel(), i, str, "hongbao.wrap.go");
    Object localObject2 = this.aW.getText().toString();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (TextUtils.isEmpty(this.aW.getHint())) {
        localObject1 = getResources().getString(2131699043);
      }
    }
    else
    {
      int j = getChannel();
      localObject2 = this.mActivity.Y();
      ((Map)localObject2).put("channel", String.valueOf(j));
      ((Map)localObject2).put("type", "1");
      ((Map)localObject2).put("wishing", localObject1);
      ((Map)localObject2).put("bus_type", this.bundle.getString("bus_type"));
      ((Map)localObject2).put("total_num", i + "");
      ((Map)localObject2).put("total_amount", str);
      if (512 == j) {
        ((Map)localObject2).put("feeds_sid", this.bundle.getString("feedsid"));
      }
      if (!this.jdField_a_of_type_Aabn.Wf()) {
        break label325;
      }
      ((Map)localObject2).put("skin_id", "" + aabl.cfZ);
    }
    for (;;)
    {
      this.mLogic.Z((Map)localObject2);
      return;
      localObject1 = this.aW.getHint().toString();
      break;
      label325:
      ((Map)localObject2).put("skin_id", "" + this.jdField_a_of_type_Aabn.yy());
    }
  }
  
  public void ao(Bundle paramBundle)
  {
    super.ao(paramBundle);
    QLog.i("UsualHbFragment", 2, "init view...");
    this.jdField_a_of_type_Aabn = this.mActivity.a();
    this.cU.setOnClickListener(this);
    this.NK = ((TextView)this.view.findViewById(2131363295));
    this.NK.setOnClickListener(this);
    paramBundle = (TextView)this.view.findViewById(2131380748);
    if (String.valueOf(2).equals(this.jdField_a_of_type_Avox$a.bus_type)) {
      paramBundle.setText(2131699000);
    }
    for (;;)
    {
      this.view.findViewById(2131378469).setVisibility(8);
      return;
      paramBundle.setText(2131699001);
    }
  }
  
  protected float getAmount()
  {
    float f2 = avor.h(this.aV.getText().toString());
    float f1 = f2;
    if (avor.c(this.jdField_a_of_type_Avox$a.bus_type, 1) == 1) {
      f1 = f2 * avor.c(this.numTxt.getText().toString(), 0);
    }
    return f1;
  }
  
  public int getChannel()
  {
    if ((uZ.contains(Integer.valueOf(this.channel))) && (this.jdField_a_of_type_Aabn.yy() == -2)) {
      return 8;
    }
    return this.channel;
  }
  
  public int getLayout()
  {
    return 2131562119;
  }
  
  public void initData()
  {
    super.initData();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ctn();
      continue;
      addUploadData("hongbao.wrap.vip", "");
      if (512 == this.channel) {
        openUrl("https://h5.qzone.qq.com/redpacket/skin/index?_proxy=1&_wv=16777219&feedsid=" + this.bundle.getString("feedsid"));
      } else {
        openUrl(acgn.a(3, (QQAppInterface)this.mActivity.getAppRuntime()));
      }
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (uZ.contains(Integer.valueOf(this.channel))) {
      this.jdField_a_of_type_Aabn.destroyView(this.hU);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (uZ.contains(Integer.valueOf(this.channel))) {
      this.jdField_a_of_type_Aabn.onResume();
    }
  }
  
  protected String qf()
  {
    return acfp.m(2131716276);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (String.valueOf(2).equals(this.jdField_a_of_type_Avox$a.bus_type)) {
        addUploadData("hongbao.wrap.random", "");
      }
    }
    else {
      return;
    }
    addUploadData("hongbao.wrap.identical", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.UsualHbFragment
 * JD-Core Version:    0.7.0.1
 */