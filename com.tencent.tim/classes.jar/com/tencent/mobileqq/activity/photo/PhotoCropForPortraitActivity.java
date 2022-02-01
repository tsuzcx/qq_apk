package com.tencent.mobileqq.activity.photo;

import acff;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import zsa;

public class PhotoCropForPortraitActivity
  extends PhotoCropActivity
{
  boolean bsX = true;
  Button eR;
  
  void b(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ((acff)this.app.getManager(51)).a(this.app.getCurrentAccountUin());
    super.b(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    if (100 == this.EP) {}
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.bsX = getIntent().getBooleanExtra("PhotoConst.IS_WITH_PENDANT", true);
    boolean bool = super.doOnCreate(paramBundle);
    if ((Build.VERSION.SDK_INT < 11) || ((Build.MODEL.equals("M040")) && (Build.VERSION.SDK_INT == 16))) {}
    for (;;)
    {
      if (getIntent().getBooleanExtra("open_chat_from_avator", false))
      {
        this.eR = ((Button)super.findViewById(2131367836));
        this.eR.setVisibility(0);
        this.eR.setOnClickListener(new zsa(this));
      }
      return bool;
      getWindow().setFlags(16777216, 16777216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity
 * JD-Core Version:    0.7.0.1
 */