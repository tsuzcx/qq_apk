package com.tencent.token.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.global.h;
import com.tencent.token.utils.i;

public class FaceRecognitionComfirmActivity
  extends BaseActivity
{
  private Handler handler = new hb(this);
  private Bitmap mBitmap;
  private int mBrightModeInt = 0;
  private int mFaceOpType = 4;
  private int mFaceScene = 1;
  private int mFlag;
  private String mPath;
  private int mScene;
  private byte[] mUploadData;
  private ProgressBar mUploadPhotoPb;
  private byte[] serverData;
  
  private void init()
  {
    if (this.mScene == 7) {
      setTitle(2131231020);
    }
    for (;;)
    {
      this.mUploadPhotoPb = ((ProgressBar)findViewById(2131558846));
      ((ImageView)findViewById(2131558845)).setImageBitmap(this.mBitmap);
      ((TextView)findViewById(2131558843)).setOnClickListener(new hd(this));
      TextView localTextView = (TextView)findViewById(2131558844);
      localTextView.setOnClickListener(new he(this));
      if (this.mFlag == 3) {
        localTextView.setText(2131231293);
      }
      return;
      setTitle(2131231371);
    }
  }
  
  private void initOriginImg()
  {
    h.a("pathpath=" + this.mPath);
    if (TextUtils.isEmpty(this.mPath))
    {
      h.a("data is null");
      finish();
      return;
    }
    byte[] arrayOfByte = i.a(this.mPath);
    this.mBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
  }
  
  private void initSoImg()
  {
    byte[] arrayOfByte = getIntent().getByteArrayExtra("data");
    if (arrayOfByte == null)
    {
      h.a("data is null");
      finish();
      return;
    }
    this.mBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
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
      setResult(10);
      finish();
      return true;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h.a("FaceRecognitionComfirmActivity");
    setNeverShowLockVerifyView();
    this.mFlag = getIntent().getIntExtra("flag", -1);
    this.mScene = getIntent().getIntExtra("scene", 1);
    this.mFaceScene = getIntent().getIntExtra("face_scene", 1);
    this.mBrightModeInt = getIntent().getIntExtra("bright_mode_int", 0);
    setContentView(2130968647);
    this.mPath = getIntent().getStringExtra("origindata");
    this.mUploadData = getIntent().getByteArrayExtra("data");
    if ((this.mPath != null) && (this.mPath.length() > 0)) {
      initOriginImg();
    }
    for (;;)
    {
      init();
      return;
      initSoImg();
    }
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new hc(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRecognitionComfirmActivity
 * JD-Core Version:    0.7.0.1
 */