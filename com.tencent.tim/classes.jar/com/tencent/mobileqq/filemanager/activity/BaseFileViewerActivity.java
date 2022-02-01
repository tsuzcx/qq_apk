package com.tencent.mobileqq.filemanager.activity;

import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class BaseFileViewerActivity
  extends IphoneTitleBarActivity
{
  public void setContentViewForImage(int paramInt)
  {
    super.setContentViewNoTitle(2131561033);
    ((RelativeLayout)findViewById(2131368830)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    init(getIntent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.BaseFileViewerActivity
 * JD-Core Version:    0.7.0.1
 */