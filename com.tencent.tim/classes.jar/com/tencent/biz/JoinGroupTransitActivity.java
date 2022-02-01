package com.tencent.biz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import aqhv;
import aqik;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;
import jmo;
import jmr;

public class JoinGroupTransitActivity
  extends BaseActivity
{
  private String Ti;
  private String Tj = "";
  private a jdField_a_of_type_ComTencentBizJoinGroupTransitActivity$a;
  private jmo jdField_a_of_type_Jmo;
  private int aBI;
  private long qp;
  
  private void init()
  {
    try
    {
      this.Ti = getIntent().getStringExtra("source_scheme");
      if (TextUtils.isEmpty(this.Ti)) {
        finish();
      }
      this.jdField_a_of_type_ComTencentBizJoinGroupTransitActivity$a = new a(this);
      aqhv localaqhv = aqik.c(this.app, this, this.Ti);
      this.Tj = localaqhv.getAttribute("activity_titile_name");
      this.qp = Long.valueOf(localaqhv.getAttribute("group_code")).longValue();
      this.aBI = Integer.valueOf(localaqhv.getAttribute("subsource_id")).intValue();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      finish();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    init();
    this.jdField_a_of_type_Jmo = new jmo(this, this.app, this.aBI, this.Tj, new jmr(this));
    this.jdField_a_of_type_Jmo.onCreate();
    this.jdField_a_of_type_ComTencentBizJoinGroupTransitActivity$a.sendEmptyMessage(0);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Jmo.onDestory();
  }
  
  public static class a
    extends Handler
  {
    private WeakReference<JoinGroupTransitActivity> mWeakReference;
    
    public a(JoinGroupTransitActivity paramJoinGroupTransitActivity)
    {
      this.mWeakReference = new WeakReference(paramJoinGroupTransitActivity);
    }
    
    public void handleMessage(Message paramMessage)
    {
      JoinGroupTransitActivity localJoinGroupTransitActivity = (JoinGroupTransitActivity)this.mWeakReference.get();
      if ((paramMessage == null) || (localJoinGroupTransitActivity == null) || (localJoinGroupTransitActivity.isFinishing())) {
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        JoinGroupTransitActivity.a(localJoinGroupTransitActivity).start(JoinGroupTransitActivity.a(localJoinGroupTransitActivity));
        return;
      }
      localJoinGroupTransitActivity.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.JoinGroupTransitActivity
 * JD-Core Version:    0.7.0.1
 */