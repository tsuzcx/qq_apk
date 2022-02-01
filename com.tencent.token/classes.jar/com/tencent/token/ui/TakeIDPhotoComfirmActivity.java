package com.tencent.token.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.aaz;
import com.tencent.token.xv;

public class TakeIDPhotoComfirmActivity
  extends BaseActivity
{
  private int mFlag;
  
  private void init()
  {
    final String str = getIntent().getStringExtra("data");
    if (TextUtils.isEmpty(str))
    {
      xv.a("data is null");
      finish();
      return;
    }
    Object localObject = (TextView)findViewById(2131166152);
    if (this.mFlag == 2) {
      ((TextView)localObject).setText(2131493493);
    }
    localObject = (ImageView)findViewById(2131165527);
    ((ImageView)localObject).postDelayed(new Runnable()
    {
      public final void run()
      {
        Bitmap localBitmap = aaz.b(str, Math.max(this.b.getWidth(), this.b.getHeight()));
        this.b.setImageBitmap(localBitmap);
      }
    }, 100L);
    ((TextView)findViewById(2131166100)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        TakeIDPhotoComfirmActivity.this.setResult(10);
        TakeIDPhotoComfirmActivity.this.finish();
      }
    });
    ((TextView)findViewById(2131165416)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        TakeIDPhotoComfirmActivity.this.setResult(20);
        TakeIDPhotoComfirmActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    xv.a("TakeIDPhotoComfirmActivity");
    this.mFlag = getIntent().getIntExtra("flag", -1);
    setContentView(2131296334);
    init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.TakeIDPhotoComfirmActivity
 * JD-Core Version:    0.7.0.1
 */