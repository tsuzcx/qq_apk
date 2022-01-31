package com.tencent.token.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.token.cv;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.utils.n;
import com.tencent.token.utils.t;

public class FacePKCameraActivity
  extends BaseActivity
{
  private boolean detectsucc;
  private boolean isShowingErrorDialog = false;
  private boolean mCanVideo;
  private FaceView mFaceView;
  private Handler mHandler = new ee(this);
  private FaceRecognitionCameraPreview mPreview;
  private byte[] mServerData;
  private boolean mShowPKDialog = false;
  private TextView mTipTxt;
  
  private void init()
  {
    this.mPreview = ((FaceRecognitionCameraPreview)findViewById(2131296481));
    this.mFaceView = ((FaceView)findViewById(2131296482));
    if (t.i())
    {
      t.j();
      this.mShowPKDialog = true;
      showUserDialog(2131361808, getString(2131362473), 2131362474, new ei(this));
    }
    new Thread(new ej(this)).start();
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    for (;;)
    {
      try
      {
        if (paramKeyEvent.getAction() == 0) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          return super.dispatchKeyEvent(paramKeyEvent);
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        return true;
      }
      if (RqdApplication.c())
      {
        exitToken();
        return true;
      }
      this.mHandler.removeMessages(90);
      if (n.a().c())
      {
        this.mHandler.postDelayed(new em(this), 300L);
        return true;
      }
      finish();
      return true;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    this.detectsucc = false;
    requestWindowFeature(1);
    setContentView(2130903090);
    hideTitle();
    findViewById(2131296572).setOnClickListener(new eh(this));
    this.mTipTxt = ((TextView)findViewById(2131296578));
    init();
    cv.e();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mServerData = null;
    if (this.mPreview != null)
    {
      this.mPreview.a();
      this.mPreview = null;
    }
    this.mHandler = null;
  }
  
  protected void onPause()
  {
    super.onPause();
    RqdApplication.b = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    RqdApplication.b = true;
    if (this.mPreview != null)
    {
      this.mPreview.a(this, 0, this.mHandler, this.mFaceView, this.mTipTxt);
      this.mPreview.a(false);
    }
    if ((this.mShowPKDialog) || (this.detectsucc))
    {
      this.mShowPKDialog = false;
      this.mPreview.a(true);
    }
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new ek(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FacePKCameraActivity
 * JD-Core Version:    0.7.0.1
 */