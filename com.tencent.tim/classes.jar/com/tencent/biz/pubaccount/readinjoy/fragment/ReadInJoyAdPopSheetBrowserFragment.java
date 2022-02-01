package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import aqzl;
import arcd;
import arju;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment;
import com.tencent.qphone.base.util.QLog;
import koj;
import ldh;

public class ReadInJoyAdPopSheetBrowserFragment
  extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
{
  private static final String LOG_TAG = ReadInJoyAdPopSheetBrowserFragment.class.getName();
  private String mAdRl;
  private String mAdTraceId;
  private String mUrl;
  
  private void aKz()
  {
    Object localObject = getActivity().getIntent();
    if (localObject != null)
    {
      this.mUrl = ((Intent)localObject).getStringExtra("h5url");
      this.mAdRl = ((Intent)localObject).getStringExtra("adrl");
      this.mAdTraceId = ((Intent)localObject).getStringExtra("traceId");
    }
    if (QLog.isColorLevel()) {
      QLog.d(LOG_TAG, 2, "onCreate h5Url: " + this.mUrl);
    }
    if (TextUtils.isEmpty(this.mUrl))
    {
      getActivity().finish();
      return;
    }
    localObject = koj.a(getActivity(), this.mUrl, this.mAdRl, this.mAdTraceId);
    ((koj)localObject).a(new ldh(this));
    ((koj)localObject).show();
  }
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    if ((this.jdField_a_of_type_Aqzl != null) && (this.jdField_a_of_type_Aqzl.aK != null)) {
      this.jdField_a_of_type_Aqzl.aK.setVisibility(8);
    }
    if (this.Js != null) {
      this.Js.setVisibility(8);
    }
    if ((this.jdField_a_of_type_Arcd != null) && (this.jdField_a_of_type_Arcd.mProgressBarController != null)) {
      this.jdField_a_of_type_Arcd.mProgressBarController.xW(false);
    }
    getActivity().getWindow().getDecorView().setSystemUiVisibility(514);
    return i;
  }
  
  public void onResume()
  {
    super.onResume();
    aKz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdPopSheetBrowserFragment
 * JD-Core Version:    0.7.0.1
 */