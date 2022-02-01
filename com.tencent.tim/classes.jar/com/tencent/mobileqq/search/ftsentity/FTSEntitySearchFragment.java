package com.tencent.mobileqq.search.ftsentity;

import amlt;
import amnp;
import amns;
import amnv;
import amwd;
import amwu;
import amxk;
import android.os.Bundle;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.mobileqq.search.fragment.BaseSearchFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class FTSEntitySearchFragment
  extends BaseSearchFragment
{
  public static FTSEntitySearchFragment a(String paramString)
  {
    FTSEntitySearchFragment localFTSEntitySearchFragment = new FTSEntitySearchFragment();
    Bundle localBundle = new Bundle(1);
    localBundle.putString("keyword", paramString);
    localFTSEntitySearchFragment.setArguments(localBundle);
    return localFTSEntitySearchFragment;
  }
  
  public void Id(String paramString)
  {
    super.fO(paramString, 1);
  }
  
  public amlt a()
  {
    return new amnp(this, this.jdField_a_of_type_ComTencentWidgetListView, this.c);
  }
  
  public amwd a()
  {
    BaseSearchActivity localBaseSearchActivity = (BaseSearchActivity)getActivity();
    return amns.a(this.d, localBaseSearchActivity.dCD);
  }
  
  public void a(List paramList, amwu paramamwu)
  {
    if (paramamwu.oI(this.keyword)) {
      s(paramList, paramamwu.status);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("FTSEntitySearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramamwu.keyword, " keyword2:", this.keyword });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getArguments() != null) {
      this.keyword = getArguments().getString("keyword");
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_Amwd.pause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Amwd.resume();
  }
  
  public void onStart()
  {
    super.onStart();
    ((amnv)this.jdField_a_of_type_Amwd).bHZ();
  }
  
  public void onStop()
  {
    super.onStop();
    ((amnv)this.jdField_a_of_type_Amwd).bIa();
  }
  
  public void s(List paramList, int paramInt)
  {
    int i = 0;
    super.s(paramList, paramInt);
    String str;
    StringBuilder localStringBuilder;
    if (!this.isReported)
    {
      str = "" + this.keyword;
      localStringBuilder = new StringBuilder().append("");
      if (paramList != null) {
        break label93;
      }
    }
    label93:
    for (paramInt = i;; paramInt = paramList.size())
    {
      amxk.b("talk", "exp_page", new String[] { str, paramInt });
      this.isReported = true;
      return;
    }
  }
  
  public String vn()
  {
    BaseSearchActivity localBaseSearchActivity = (BaseSearchActivity)getActivity();
    return amns.g(localBaseSearchActivity, localBaseSearchActivity.dCD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.FTSEntitySearchFragment
 * JD-Core Version:    0.7.0.1
 */