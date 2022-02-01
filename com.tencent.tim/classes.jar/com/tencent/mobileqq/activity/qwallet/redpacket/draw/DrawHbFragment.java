package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import aaay;
import aaek;
import aael;
import aaem;
import aaen;
import aaeo;
import aaep;
import aagd;
import acfp;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqmr;
import avor;
import avox;
import avox.a;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.BaseHbFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class DrawHbFragment
  extends BaseHbFragment
  implements View.OnClickListener
{
  private TextView NR;
  private String Rs;
  public ChooseItemView a;
  DrawHbBundleInfo a;
  private EditText aX;
  private Button cU;
  RelativeLayout iH;
  private long iu;
  protected TextWatcher mTextWatcher = new aaep(this);
  private EditText numTxt;
  
  public DrawHbFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo = new DrawHbBundleInfo();
  }
  
  private void Ca(boolean paramBoolean)
  {
    this.cU.setEnabled(paramBoolean);
    if (!paramBoolean) {
      this.cU.setText(getString(2131699008));
    }
  }
  
  private void freshConfirmBtn()
  {
    String str1 = this.NR.getText().toString().trim();
    this.Rs = str1;
    if (TextUtils.isEmpty(str1))
    {
      Ca(false);
      return;
    }
    str1 = this.numTxt.getText().toString();
    String str2 = this.aX.getText().toString();
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      Ca(false);
      return;
    }
    if ((avor.h(str1) <= 0.0F) || (avor.h(str2) <= 0.0F))
    {
      Ca(false);
      return;
    }
    Ca(true);
    str1 = getString(2131699008) + str2 + acfp.m(2131705313);
    this.cU.setText(str1);
  }
  
  private boolean iM(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.drawParam)) {}
    try
    {
      JSONArray localJSONArray = new JSONArray(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.drawParam);
      bool1 = bool2;
      int i;
      if (localJSONArray != null) {
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < localJSONArray.length())
        {
          String str = localJSONArray.optString(i);
          if (!TextUtils.isEmpty(str))
          {
            bool1 = str.equals(paramString);
            if (bool1) {
              bool1 = true;
            }
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void initView(View paramView, Bundle paramBundle)
  {
    avox.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo);
    this.numTxt = ((EditText)paramView.findViewById(2131372567));
    this.aX = ((EditText)paramView.findViewById(2131362698));
    this.aX.addTextChangedListener(this.mTextWatcher);
    this.cU = ((Button)paramView.findViewById(2131363892));
    this.NR = ((TextView)paramView.findViewById(2131380978));
    try
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.drawParam))
      {
        paramBundle = getHbPannelConfig(10);
        if (paramBundle != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.skinId = paramBundle.optString("skinId");
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.drawParam = paramBundle.optString("subjects");
        }
      }
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.biz_params;
      if (QLog.isColorLevel()) {
        QLog.i("DrawHbFragment", 2, "bizParams:" + paramBundle);
      }
      if (!aqmr.isEmpty(paramBundle))
      {
        paramBundle = new JSONObject(paramBundle).optString("subject", "");
        if ((!TextUtils.isEmpty(paramBundle)) && (iM(paramBundle))) {
          this.NR.setText(paramBundle);
        }
      }
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        continue;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.people_num)) {
          this.numTxt.setHint(acfp.m(2131705314) + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.people_num + acfp.m(2131705315));
        }
        this.numTxt.addTextChangedListener(this.mTextWatcher);
      }
    }
    if (avox.LH.contains(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.recv_type))
    {
      this.numTxt.setText("1");
      paramView.findViewById(2131380131).setVisibility(8);
      this.cU.setOnClickListener(this);
      this.NR.addTextChangedListener(this.mTextWatcher);
      this.NR.setOnClickListener(new aael(this));
      aagd.k(this.NR, 0.6F);
      this.iH = ((RelativeLayout)paramView.findViewById(2131370211));
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView = new ChooseItemView(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.drawParam, new aaem(this), new aaen(this), new aaeo(this, paramView));
      this.iH.addView(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView);
      paramView = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.getLayoutParams();
      paramView.width = -1;
      paramView.height = -2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView.dismiss();
      }
      return;
    }
  }
  
  private void onConfirmClick()
  {
    long l = System.currentTimeMillis();
    if (this.iu + 1000L > l) {
      return;
    }
    this.iu = l;
    String str1 = this.numTxt.getText().toString();
    String str2 = this.aX.getText().toString();
    Map localMap = this.mActivity.Y();
    localMap.put("type", "1");
    localMap.put("wishing", this.Rs);
    localMap.put("bus_type", "2");
    localMap.put("total_num", str1);
    localMap.put("total_amount", avor.hX(str2));
    localMap.put("channel", "" + this.channel);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.skinId)) {
      localMap.put("skin_id", this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawHbFragment$DrawHbBundleInfo.skinId);
    }
    this.mLogic.Z(localMap);
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
      this.mActivity.zY("draw.wrappacket.wrap");
      onConfirmClick();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(2131562153, null);
    paramLayoutInflater.setOnClickListener(new aaek(this));
    initView(paramLayoutInflater, getArguments());
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      QLog.i("DrawHbFragment", 2, "DrawHb enter...");
      if (this.mActivity != null) {
        this.mActivity.zY("draw.wrappacket.show");
      }
    }
  }
  
  public static class DrawHbBundleInfo
    extends avox.a
  {
    public String drawParam;
    public String skinId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawHbFragment
 * JD-Core Version:    0.7.0.1
 */