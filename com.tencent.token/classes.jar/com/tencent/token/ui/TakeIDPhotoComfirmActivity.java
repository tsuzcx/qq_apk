package com.tencent.token.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.aad;
import com.tencent.token.xa;

public class TakeIDPhotoComfirmActivity
  extends BaseActivity
{
  private int mFlag;
  
  private void init()
  {
    final String str = getIntent().getStringExtra("data");
    if (TextUtils.isEmpty(str))
    {
      xa.a("data is null");
      finish();
      return;
    }
    Object localObject = (TextView)findViewById(2131166110);
    if (this.mFlag == 2) {
      ((TextView)localObject).setText(2131493485);
    }
    localObject = (ImageView)findViewById(2131165512);
    ((ImageView)localObject).postDelayed(new Runnable()
    {
      public final void run()
      {
        Bitmap localBitmap = aad.b(str, Math.max(this.b.getWidth(), this.b.getHeight()));
        this.b.setImageBitmap(localBitmap);
      }
    }, 100L);
    ((TextView)findViewById(2131166058)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        TakeIDPhotoComfirmActivity.this.setResult(10);
        TakeIDPhotoComfirmActivity.this.finish();
      }
    });
    ((TextView)findViewById(2131165404)).setOnClickListener(new View.OnClickListener()
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
    xa.a("TakeIDPhotoComfirmActivity");
    this.mFlag = getIntent().getIntExtra("flag", -1);
    setContentView(2131296329);
    init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.TakeIDPhotoComfirmActivity
 * JD-Core Version:    0.7.0.1
 */