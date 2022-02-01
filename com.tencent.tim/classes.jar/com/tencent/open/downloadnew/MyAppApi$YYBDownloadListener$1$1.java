package com.tencent.open.downloadnew;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aroi;
import arwt;
import arxa;

class MyAppApi$YYBDownloadListener$1$1
  implements Runnable
{
  MyAppApi$YYBDownloadListener$1$1(MyAppApi.YYBDownloadListener.1 param1) {}
  
  public void run()
  {
    if (aroi.a().getContext() != null)
    {
      Object localObject1 = new DisplayMetrics();
      ((WindowManager)aroi.a().getContext().getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
      int i = ((DisplayMetrics)localObject1).widthPixels;
      float f = ((DisplayMetrics)localObject1).density;
      Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      localObject1 = new RelativeLayout(aroi.a().getContext());
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((RelativeLayout)localObject1).setBackgroundColor(-855638017);
      ((RelativeLayout)localObject1).setGravity(17);
      ((RelativeLayout)localObject1).setPadding((int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F), (int)(10.0F * f + 0.5F));
      localObject2 = new TextView(aroi.a().getContext());
      ((TextView)localObject2).setWidth((int)(i * 0.9D));
      ((TextView)localObject2).setHeight((int)(96.0F * f + 0.5F));
      ((TextView)localObject2).setBackgroundColor(aroi.a().getContext().getResources().getColor(2131167595));
      ((TextView)localObject2).setText(2131721202);
      ((TextView)localObject2).setTextColor(aroi.a().getContext().getResources().getColor(2131165381));
      ((TextView)localObject2).setSingleLine();
      ((TextView)localObject2).setGravity(17);
      ((RelativeLayout)localObject1).addView((View)localObject2);
      arxa.a().az((View)localObject1, 1);
      arwt.d("MyAppApi", acfp.m(2131708619) + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.1.1
 * JD-Core Version:    0.7.0.1
 */