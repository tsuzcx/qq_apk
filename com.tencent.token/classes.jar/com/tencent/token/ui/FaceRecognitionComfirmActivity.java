package com.tencent.token.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.global.e;
import com.tencent.token.utils.t;

public class FaceRecognitionComfirmActivity
  extends BaseActivity
{
  private int flag;
  private String mPath;
  
  private void init()
  {
    Object localObject = getIntent().getByteArrayExtra("data");
    if (localObject == null)
    {
      e.a("data is null");
      finish();
    }
    do
    {
      return;
      localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
      ((ImageView)findViewById(2131296559)).setImageBitmap((Bitmap)localObject);
      ((TextView)findViewById(2131296557)).setOnClickListener(new ic(this));
      localObject = (TextView)findViewById(2131296558);
      ((TextView)localObject).setOnClickListener(new id(this));
    } while (this.flag != 3);
    ((TextView)localObject).setText(2131361806);
  }
  
  private void initOrigin()
  {
    e.a("pathpath=" + this.mPath);
    if (TextUtils.isEmpty(this.mPath))
    {
      e.a("data is null");
      finish();
    }
    Object localObject;
    do
    {
      return;
      localObject = (ImageView)findViewById(2131296559);
      ((ImageView)localObject).postDelayed(new ie(this, (ImageView)localObject), 100L);
      Bitmap localBitmap = t.b(this.mPath, Math.max(((ImageView)localObject).getWidth(), ((ImageView)localObject).getHeight()));
      e.a("pathpah" + localBitmap);
      ((ImageView)localObject).setImageBitmap(localBitmap);
      ((TextView)findViewById(2131296557)).setOnClickListener(new if(this));
      localObject = (TextView)findViewById(2131296558);
      ((TextView)localObject).setOnClickListener(new ig(this));
    } while (this.flag != 3);
    ((TextView)localObject).setText(2131361806);
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
    e.a("FaceRecognitionComfirmActivity");
    setNeverShowLockVerifyView();
    this.flag = getIntent().getIntExtra("flag", -1);
    setContentView(2130903081);
    this.mPath = getIntent().getStringExtra("origindata");
    if ((this.mPath != null) && (this.mPath.length() > 0))
    {
      initOrigin();
      return;
    }
    init();
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new ib(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRecognitionComfirmActivity
 * JD-Core Version:    0.7.0.1
 */