package com.tencent.mobileqq.ocr.ui;

import akoa;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;

public class BaseOCRTextSearchFragment
  extends ReportV4Fragment
{
  public a a;
  public QQAppInterface app = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  public View.OnTouchListener f = new akoa(this);
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof OCRTextSearchActivity)) {
      this.a = ((OCRTextSearchActivity)paramActivity).a;
    }
    this.app = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public static abstract interface a
  {
    public abstract void MV(boolean paramBoolean);
    
    public abstract void eI(View paramView);
    
    public abstract Activity getActivity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.BaseOCRTextSearchFragment
 * JD-Core Version:    0.7.0.1
 */