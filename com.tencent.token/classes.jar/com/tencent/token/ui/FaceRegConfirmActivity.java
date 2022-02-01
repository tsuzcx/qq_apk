package com.tencent.token.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.token.global.g;
import com.tencent.token.utils.e;

public class FaceRegConfirmActivity
  extends BaseActivity
{
  private Bitmap mBitmap1;
  private Bitmap mBitmap2;
  private String mPath1;
  private String mPath2;
  
  private void init()
  {
    g.c("pathpath: w=" + this.mBitmap1.getWidth() + ",h=" + this.mBitmap1.getHeight());
    if ((this.mBitmap1 != null) && (this.mBitmap2 != null))
    {
      ImageView localImageView1 = (ImageView)findViewById(2131558907);
      ImageView localImageView2 = (ImageView)findViewById(2131558910);
      localImageView1.setImageBitmap(this.mBitmap1);
      localImageView2.setImageBitmap(this.mBitmap2);
    }
    ((Button)findViewById(2131558911)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        FaceRegConfirmActivity.this.setResult(20);
        FaceRegConfirmActivity.this.finish();
      }
    });
    ((Button)findViewById(2131558912)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        e.b(FaceRegConfirmActivity.this.mPath1);
        e.b(FaceRegConfirmActivity.this.mPath2);
        FaceRegConfirmActivity.this.setResult(10);
        FaceRegConfirmActivity.this.finish();
      }
    });
  }
  
  private void initOriginImg()
  {
    Object localObject = e.a(this.mPath1);
    this.mBitmap1 = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
    localObject = e.a(this.mPath2);
    this.mBitmap2 = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
    localObject = (ImageView)findViewById(2131558907);
    ImageView localImageView = (ImageView)findViewById(2131558910);
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131558905);
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131558906);
    LinearLayout localLinearLayout3 = (LinearLayout)findViewById(2131558908);
    LinearLayout localLinearLayout4 = (LinearLayout)findViewById(2131558909);
    int i = (int)(this.mBitmap1.getHeight() * 140 / this.mBitmap1.getWidth() * IndexActivity.S_DENSITY);
    int j = (int)(i + 6.0F * IndexActivity.S_DENSITY);
    int k = (int)(i + 4.0F * IndexActivity.S_DENSITY);
    ((ImageView)localObject).getLayoutParams().height = i;
    localImageView.getLayoutParams().height = i;
    localLinearLayout1.getLayoutParams().height = j;
    localLinearLayout3.getLayoutParams().height = j;
    localLinearLayout2.getLayoutParams().height = k;
    localLinearLayout4.getLayoutParams().height = k;
  }
  
  private void initSoImg()
  {
    byte[] arrayOfByte1 = getIntent().getByteArrayExtra("data1");
    byte[] arrayOfByte2 = getIntent().getByteArrayExtra("data2");
    if ((arrayOfByte1 != null) && (arrayOfByte2 != null))
    {
      this.mBitmap1 = BitmapFactory.decodeByteArray(arrayOfByte1, 0, arrayOfByte1.length);
      this.mBitmap2 = BitmapFactory.decodeByteArray(arrayOfByte2, 0, arrayOfByte2.length);
    }
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968660);
    this.mPath1 = getIntent().getStringExtra("origindata1");
    this.mPath2 = getIntent().getStringExtra("origindata2");
    if ((!TextUtils.isEmpty(this.mPath1)) && (!TextUtils.isEmpty(this.mPath2))) {
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
      this.mBackArrow.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          g.c("onBackPressed");
          e.b(FaceRegConfirmActivity.this.mPath1);
          e.b(FaceRegConfirmActivity.this.mPath2);
          FaceRegConfirmActivity.this.setResult(10);
          FaceRegConfirmActivity.this.finish();
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRegConfirmActivity
 * JD-Core Version:    0.7.0.1
 */