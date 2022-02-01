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
import com.tencent.token.aai;
import com.tencent.token.xj;

public class FaceRegConfirmActivity
  extends BaseActivity
{
  private Bitmap mBitmap1;
  private Bitmap mBitmap2;
  private String mPath1;
  private String mPath2;
  
  private void init()
  {
    Object localObject = new StringBuilder("pathpath: w=");
    ((StringBuilder)localObject).append(this.mBitmap1.getWidth());
    ((StringBuilder)localObject).append(",h=");
    ((StringBuilder)localObject).append(this.mBitmap1.getHeight());
    xj.c(((StringBuilder)localObject).toString());
    if ((this.mBitmap1 != null) && (this.mBitmap2 != null))
    {
      localObject = (ImageView)findViewById(2131165675);
      ImageView localImageView = (ImageView)findViewById(2131165676);
      ((ImageView)localObject).setImageBitmap(this.mBitmap1);
      localImageView.setImageBitmap(this.mBitmap2);
    }
    ((Button)findViewById(2131165406)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        FaceRegConfirmActivity.this.setResult(20);
        FaceRegConfirmActivity.this.finish();
      }
    });
    ((Button)findViewById(2131165914)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        aai.b(FaceRegConfirmActivity.this.mPath1);
        aai.b(FaceRegConfirmActivity.this.mPath2);
        FaceRegConfirmActivity.this.setResult(10);
        FaceRegConfirmActivity.this.finish();
      }
    });
  }
  
  private void initOriginImg()
  {
    Object localObject = aai.a(this.mPath1);
    this.mBitmap1 = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
    localObject = aai.a(this.mPath2);
    this.mBitmap2 = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
    localObject = (ImageView)findViewById(2131165675);
    ImageView localImageView = (ImageView)findViewById(2131165676);
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131165670);
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131165671);
    LinearLayout localLinearLayout3 = (LinearLayout)findViewById(2131165672);
    LinearLayout localLinearLayout4 = (LinearLayout)findViewById(2131165673);
    int i = (int)(this.mBitmap1.getHeight() * 140 / this.mBitmap1.getWidth() * IndexActivity.S_DENSITY);
    float f = i;
    int j = (int)(IndexActivity.S_DENSITY * 6.0F + f);
    int k = (int)(f + IndexActivity.S_DENSITY * 4.0F);
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
    try
    {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
      {
        setResult(10);
        finish();
        return true;
      }
      boolean bool = super.dispatchKeyEvent(paramKeyEvent);
      return bool;
    }
    catch (Exception paramKeyEvent)
    {
      paramKeyEvent.printStackTrace();
    }
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296341);
    this.mPath1 = getIntent().getStringExtra("origindata1");
    this.mPath2 = getIntent().getStringExtra("origindata2");
    if ((!TextUtils.isEmpty(this.mPath1)) && (!TextUtils.isEmpty(this.mPath2))) {
      initOriginImg();
    } else {
      initSoImg();
    }
    init();
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          xj.c("onBackPressed");
          aai.b(FaceRegConfirmActivity.this.mPath1);
          aai.b(FaceRegConfirmActivity.this.mPath2);
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