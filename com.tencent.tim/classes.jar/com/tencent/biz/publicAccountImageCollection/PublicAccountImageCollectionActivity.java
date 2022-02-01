package com.tencent.biz.publicAccountImageCollection;

import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import nov;
import noy;
import noz;
import npf;
import otb;

public class PublicAccountImageCollectionActivity
  extends BaseActivity
{
  PublicAccountImageView a;
  int bfP = 0;
  RelativeLayout fl;
  protected Handler handler = new otb(this);
  
  private Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    try
    {
      paramString = new URL(paramString);
      Object localObject2 = new noz();
      ((noz)localObject2).url = paramString;
      ((noz)localObject2).reqWidth = paramInt1;
      ((noz)localObject2).reqHeight = paramInt2;
      localObject2 = noy.a().a((noz)localObject2);
      paramString = localObject1;
      if (localObject2 != null) {
        paramString = new npf(((nov)localObject2).Q());
      }
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  private void aBB()
  {
    finish();
    if (QLog.isColorLevel()) {
      QLog.d("PublicAccountImageCollectionActivity", 2, "activity finish");
    }
    PublicAccountImageCollectionMainActivity.ayr = false;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    super.doOnCreate(paramBundle);
    super.setContentView(2131559816);
    int i = getWindowManager().getDefaultDisplay().getHeight();
    int j = getWindowManager().getDefaultDisplay().getWidth();
    Object localObject = getIntent();
    paramBundle = ((Intent)localObject).getStringExtra("doubleBitMapPath");
    float[] arrayOfFloat = ((Intent)localObject).getFloatArrayExtra("imageMatrix");
    int k = ((Intent)localObject).getIntExtra("urlImageWidth", 0);
    int m = ((Intent)localObject).getIntExtra("urlImageHeight", 0);
    int n = ((Intent)localObject).getIntExtra("urlImageWidthReal", 0);
    int i1 = ((Intent)localObject).getIntExtra("urlImageHeightReal", 0);
    localObject = new Matrix();
    if (arrayOfFloat != null) {
      ((Matrix)localObject).setValues(arrayOfFloat);
    }
    this.a = new PublicAccountImageView(this, this.handler, (Matrix)localObject, this.bfP, n, i1);
    this.fl = ((RelativeLayout)findViewById(2131373785));
    paramBundle = a(paramBundle, k, m);
    this.a.setImageDrawable(paramBundle);
    ((Matrix)localObject).postScale(3.0F, 3.0F, n / 2, i1 / 2);
    ((Matrix)localObject).postTranslate((j - n) / 2, (i - i1) / 2);
    this.a.setImageMatrix((Matrix)localObject);
    paramBundle = new RelativeLayout.LayoutParams(-1, -1);
    paramBundle.addRule(10, -1);
    this.fl.addView(this.a, paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    PublicAccountImageCollectionMainActivity.ayr = false;
    if (this.handler != null)
    {
      this.handler.removeCallbacksAndMessages(null);
      this.handler = null;
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionActivity
 * JD-Core Version:    0.7.0.1
 */