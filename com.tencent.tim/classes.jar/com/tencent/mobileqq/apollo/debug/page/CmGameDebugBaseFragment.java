package com.tencent.mobileqq.apollo.debug.page;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;

public abstract class CmGameDebugBaseFragment
  extends ReportV4Fragment
{
  public a a;
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void cCB()
  {
    if (this.a != null) {
      this.a.cCD();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public static abstract interface a
  {
    public abstract void cCD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.page.CmGameDebugBaseFragment
 * JD-Core Version:    0.7.0.1
 */