package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import awit;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService;
import com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadService.a;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kfr;
import knj;
import kxa;
import kxm;
import lbz;
import mgu;
import mit;
import nel;
import nem;
import odd;

public abstract class ReadInJoyBaseListViewGroup
  extends FrameLayout
{
  public final String TAG = "ReadInJoyBaseListViewGroup";
  public KandianVideoUploadService.a a;
  public ReadInJoyXListView a;
  protected kfr a;
  protected kxa a;
  protected boolean aeK;
  KandianProgressView.a b = new nem(this);
  public Map<String, KandianProgressView> eD = new HashMap();
  List<KandianProgressView> jU = new ArrayList();
  public int mChannelID;
  
  public ReadInJoyBaseListViewGroup(kfr paramkfr, int paramInt, kxa paramkxa)
  {
    super(paramkfr.getActivity());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcKandianVideoUploadService$a = new nel(this);
    this.mChannelID = paramInt;
    this.jdField_a_of_type_Kfr = paramkfr;
    if (paramkxa == null)
    {
      this.jdField_a_of_type_Kxa = new kxa();
      this.jdField_a_of_type_Kxa.sT = awit.a(paramInt, (QQAppInterface)kxm.getAppRuntime());
      return;
    }
    this.jdField_a_of_type_Kxa = paramkxa;
    this.jdField_a_of_type_Kxa.aMp = 1;
  }
  
  private void aWe()
  {
    Iterator localIterator = mit.be().iterator();
    while (localIterator.hasNext())
    {
      Intent localIntent = (Intent)localIterator.next();
      String str = localIntent.getStringExtra("mTaskID");
      QLog.d("KandianVideoUpload", 1, "is loading fail view:" + str + "map size" + this.eD.size());
      if (this.eD.get(str) == null) {
        KandianVideoUploadService.a(localIntent.getExtras(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcKandianVideoUploadService$a);
      }
    }
  }
  
  private void b(Bundle paramBundle, String paramString)
  {
    String str = paramBundle.getString("mTaskID");
    Object localObject = (View)this.eD.get(str);
    if (localObject == null)
    {
      if (this.eD.size() < 2)
      {
        if (this.jU.isEmpty()) {
          break label106;
        }
        localObject = (KandianProgressView)this.jU.get(0);
        this.jU.remove(localObject);
      }
      for (;;)
      {
        ((KandianProgressView)localObject).setTag(paramString);
        ((KandianProgressView)localObject).setViewInformation(paramBundle);
        da((View)localObject);
        this.eD.put(str, localObject);
        return;
        label106:
        localObject = new KandianProgressView(getCurrentActivity(), paramBundle, this.b);
      }
    }
    ((View)localObject).setTag(paramString);
  }
  
  private void da(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.addHeaderView(paramView);
    }
  }
  
  private void oe(String paramString)
  {
    KandianProgressView localKandianProgressView = (KandianProgressView)this.eD.get(paramString);
    if (localKandianProgressView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.removeHeaderView(localKandianProgressView);
      this.jU.add(localKandianProgressView);
      this.eD.remove(paramString);
    }
  }
  
  public void F(Map<Integer, mgu> paramMap) {}
  
  public abstract void G(Map<Integer, Boolean> paramMap);
  
  public abstract void H(Map<Integer, Boolean> paramMap);
  
  public void O(boolean paramBoolean, int paramInt) {}
  
  public abstract void a(Map<Long, mgu> paramMap, boolean paramBoolean);
  
  public abstract void a(Set<Long> paramSet, Map<Long, mgu> paramMap);
  
  public void aCz()
  {
    if (!this.aeK)
    {
      this.aeK = true;
      knj.a().T(this.mChannelID, true);
      odd.bU(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE");
      lbz.a().a(this.mChannelID, 20, 9223372036854775807L, true);
    }
  }
  
  public void aWc()
  {
    aWe();
    KandianVideoUploadService.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcKandianVideoUploadService$a);
  }
  
  public void aWd()
  {
    KandianVideoUploadService.a(null);
  }
  
  public Activity getCurrentActivity()
  {
    return this.jdField_a_of_type_Kfr.getActivity();
  }
  
  public abstract void lP(boolean paramBoolean);
  
  public int nh()
  {
    return this.mChannelID;
  }
  
  public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onDestroy();
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public boolean zl()
  {
    return getCurrentActivity() instanceof SplashActivity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup
 * JD-Core Version:    0.7.0.1
 */