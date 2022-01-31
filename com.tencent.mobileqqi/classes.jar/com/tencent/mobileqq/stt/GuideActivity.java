package com.tencent.mobileqq.stt;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.FileInputStream;

public class GuideActivity
  extends BaseActivity
  implements View.OnTouchListener
{
  public static final String a = "k_guide";
  private boolean a = false;
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = BaseActivity.a;
    if ((paramBundle == null) || (!(paramBundle instanceof ChatActivity)) || (paramBundle.isFinishing()))
    {
      finish();
      return false;
    }
    int i = SttManager.a(this.b, false);
    if (i == 0)
    {
      finish();
      return false;
    }
    paramBundle = LayoutInflater.from(this).inflate(2130903629, null);
    paramBundle.setOnTouchListener(this);
    paramBundle.setBackgroundResource(2130839081);
    setContentView(paramBundle);
    paramBundle = (ImageView)findViewById(2131233164);
    if (i == 2) {}
    for (;;)
    {
      try
      {
        paramBundle.setImageBitmap(BitmapFactory.decodeStream(new FileInputStream(new File(this.b.a().getFilesDir(), "VoiceToTextMask"))));
        paramBundle.setOnTouchListener(this);
        ((ImageView)findViewById(2131233165)).setOnTouchListener(this);
        return true;
      }
      catch (Throwable paramBundle)
      {
        paramBundle.printStackTrace();
        finish();
        return false;
      }
      paramBundle.setImageResource(2130839082);
    }
  }
  
  protected void doOnResume()
  {
    if (!this.a)
    {
      BaseActivity localBaseActivity = BaseActivity.a;
      if ((localBaseActivity == null) || (!(localBaseActivity instanceof ChatActivity)) || (localBaseActivity.isFinishing())) {
        finish();
      }
      if (SttManager.a(this.b, true) == 0) {
        finish();
      }
      this.a = true;
    }
    super.doOnResume();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    finish();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.stt.GuideActivity
 * JD-Core Version:    0.7.0.1
 */