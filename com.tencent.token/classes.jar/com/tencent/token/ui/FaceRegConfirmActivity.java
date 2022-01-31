package com.tencent.token.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.token.global.e;

public class FaceRegConfirmActivity
  extends BaseActivity
{
  private void init()
  {
    Object localObject1 = getIntent().getByteArrayExtra("data1");
    Object localObject2 = getIntent().getByteArrayExtra("data2");
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
      localObject2 = BitmapFactory.decodeByteArray((byte[])localObject2, 0, localObject2.length);
      e.a("face bitmap1 w=" + ((Bitmap)localObject1).getWidth() + ",h=" + ((Bitmap)localObject1).getHeight() + ", bitmap2 w=" + ((Bitmap)localObject2).getWidth() + ",h=" + ((Bitmap)localObject2).getHeight());
      ImageView localImageView1 = (ImageView)findViewById(2131296618);
      ImageView localImageView2 = (ImageView)findViewById(2131296621);
      localImageView1.setImageBitmap((Bitmap)localObject1);
      localImageView2.setImageBitmap((Bitmap)localObject2);
    }
    ((Button)findViewById(2131296622)).setOnClickListener(new ji(this));
    ((Button)findViewById(2131296623)).setOnClickListener(new jj(this));
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
    setContentView(2130903097);
    init();
  }
  
  protected void setDefaultBackArrow()
  {
    if ((this.mTitleBar.getVisibility() == 0) && (this.mBackArrow != null))
    {
      this.mBackArrow.setVisibility(0);
      this.mBackArrow.setOnClickListener(new jk(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.FaceRegConfirmActivity
 * JD-Core Version:    0.7.0.1
 */