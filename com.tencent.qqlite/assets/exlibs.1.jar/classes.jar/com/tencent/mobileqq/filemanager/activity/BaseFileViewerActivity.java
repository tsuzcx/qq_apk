package com.tencent.mobileqq.filemanager.activity;

import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class BaseFileViewerActivity
  extends IphoneTitleBarActivity
{
  public void setContentViewForImage(int paramInt)
  {
    super.setContentViewNoTitle(2130903428);
    ((RelativeLayout)findViewById(2131298036)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    b(getIntent());
  }
  
  public void startViewerTitleProgress()
  {
    d();
  }
  
  public void stopViewerTitleProgress()
  {
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.BaseFileViewerActivity
 * JD-Core Version:    0.7.0.1
 */