package com.tencent.mobileqq.filemanager.activity;

import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class BaseFileViewerActivity
  extends IphoneTitleBarActivity
{
  public void i(int paramInt)
  {
    super.f(2130903507);
    ((RelativeLayout)findViewById(2131232758)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    b(getIntent());
  }
  
  public void p()
  {
    d();
  }
  
  public void q()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.BaseFileViewerActivity
 * JD-Core Version:    0.7.0.1
 */