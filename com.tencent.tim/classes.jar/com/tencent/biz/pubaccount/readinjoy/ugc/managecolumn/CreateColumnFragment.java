package com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import aqha;
import aqiw;
import aqju;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.widgets.LimitWordCountEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import lcc;
import mix;
import mmy;
import mmz;
import mna;
import mnf.b;
import ntp;
import org.jetbrains.annotations.NotNull;

public class CreateColumnFragment
  extends AbsPublishColumnFragment
{
  private int from;
  
  protected boolean DQ()
  {
    return (!TextUtils.isEmpty(this.ajs)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.ra() > 0);
  }
  
  public void a(@NotNull ColumnInfo paramColumnInfo, boolean paramBoolean)
  {
    super.a(paramColumnInfo, paramBoolean);
    lcc.a().aJF();
    if (paramBoolean)
    {
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("key_publish_result", true);
      if (!TextUtils.isEmpty(this.callback)) {
        ((Intent)localObject).putExtra("arg_callback", this.callback);
      }
      ((Intent)localObject).putExtra("key_column_info", paramColumnInfo);
      getActivity().setResult(2, (Intent)localObject);
      finishActivity();
      if ((this.from == 1) && (mix.pr() == 2))
      {
        localObject = mix.ka() + paramColumnInfo.columnID;
        ntp.a(getActivity(), "", (String)localObject, null, false);
      }
      mna.c(paramColumnInfo);
    }
    QLog.i("RIJUGC.PublishTopicFragment", 1, "onColumnCreated, result = " + paramBoolean + ", id= " + paramColumnInfo.columnID + ", title = " + paramColumnInfo.title);
  }
  
  public void aQy()
  {
    super.aQy();
    aqha.a(getActivity(), 230).setMessage(2131718369).setNegativeButton(2131718366, new mmz(this)).setPositiveButton(2131718368, new mmy(this)).show();
  }
  
  public void aQz()
  {
    super.aQz();
    if (!aqiw.isNetworkAvailable())
    {
      QQToast.a(getActivity(), 0, getString(2131696270), 0).show();
      return;
    }
    this.jdField_a_of_type_Mnf$b.b(a());
  }
  
  protected boolean bU()
  {
    return (!TextUtils.isEmpty(this.ajs)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.ra() > 0) || (this.b.ra() > 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.qV.setText(2131718388);
    this.qW.setText(2131718385);
    this.jdField_a_of_type_Mnf$b.aQI();
    paramViewGroup = getArguments();
    if (paramViewGroup != null) {
      this.from = paramViewGroup.getInt("key_from", 0);
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.CreateColumnFragment
 * JD-Core Version:    0.7.0.1
 */