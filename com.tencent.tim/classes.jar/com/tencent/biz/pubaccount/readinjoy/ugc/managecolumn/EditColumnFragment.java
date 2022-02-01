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
import mnb;
import mnc;
import mnd;
import mnf.b;
import org.jetbrains.annotations.NotNull;

public class EditColumnFragment
  extends AbsPublishColumnFragment
{
  private ColumnInfo b;
  
  protected boolean DQ()
  {
    return (!TextUtils.isEmpty(this.ajs)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.ra() > 0) && (bU());
  }
  
  public void aQy()
  {
    super.aQy();
    aqha.a(getActivity(), 230).setMessage(2131718371).setNegativeButton(2131718367, new mnd(this)).setPositiveButton(2131718370, new mnc(this)).show();
  }
  
  public void aQz()
  {
    super.aQz();
    if (!aqiw.isNetworkAvailable())
    {
      QQToast.a(getActivity(), 0, getString(2131696270), 0).show();
      return;
    }
    this.jdField_a_of_type_Mnf$b.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo, a());
  }
  
  public void b(@NotNull ColumnInfo paramColumnInfo, boolean paramBoolean)
  {
    super.b(paramColumnInfo, paramBoolean);
    lcc.a().aJF();
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_publish_result", true);
      if (!TextUtils.isEmpty(this.callback)) {
        localIntent.putExtra("arg_callback", this.callback);
      }
      localIntent.putExtra("key_column_info", paramColumnInfo);
      getActivity().setResult(1, localIntent);
      finishActivity();
    }
    QLog.i("RIJUGC.PublishTopicFragment", 1, "onColumnEdited, result = " + paramBoolean + ", id= " + paramColumnInfo.columnID + ", title = " + paramColumnInfo.title);
  }
  
  protected boolean bU()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo == null) {}
    while ((TextUtils.equals(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.coverUrl, this.ajs)) && (TextUtils.equals(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.title, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.getContent())) && (TextUtils.equals(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.intro, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.getContent()))) {
      return false;
    }
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo = ((ColumnInfo)getActivity().getIntent().getParcelableExtra("key_column_info"));
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo == null) {
      QLog.e("RIJUGC.PublishTopicFragment", 1, "EditTopicFragment, mEditedTopicInfo == null");
    }
    this.qW.setText(2131718370);
    this.qV.setText(2131718400);
    b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyWidgetsLimitWordCountEditText.setCountChangeListener(new mnb(this));
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.EditColumnFragment
 * JD-Core Version:    0.7.0.1
 */