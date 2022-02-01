package com.dataline.activities;

import acfp;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import cd;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class PrinterDefaultActivity
  extends IphoneTitleBarActivity
{
  private void bX()
  {
    ((TextView)findViewById(2131369579)).setVisibility(8);
    TextView localTextView = (TextView)findViewById(2131369612);
    localTextView.setVisibility(0);
    localTextView.setText(acfp.m(2131709890));
    localTextView.setOnClickListener(new cd(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.getWindow().setBackgroundDrawableResource(2131165572);
    setContentView(2131559190);
    setTitle(2131692384);
    super.getWindow().setBackgroundDrawable(null);
    bX();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.PrinterDefaultActivity
 * JD-Core Version:    0.7.0.1
 */