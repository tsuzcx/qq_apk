package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import aqhu;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.a;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;
import now;

public class ReadInJoyHeadImageView
  extends NativeReadInjoyImageView
  implements ReadInJoyUserInfoModule.a, IView
{
  private static final Drawable cv = new BitmapDrawable(BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130842559));
  private long mUin;
  
  public ReadInJoyHeadImageView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ReadInJoyHeadImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public ReadInJoyHeadImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void b(ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if (paramReadInJoyUserInfo == null) {
      return;
    }
    QLog.d("ReadInJoyHeadImageView", 1, " [setHeadImg] load avatar from 0xb81 userinfo, uin:" + paramReadInJoyUserInfo.uin);
    try
    {
      setImage(new URL(ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo)));
      return;
    }
    catch (MalformedURLException paramReadInJoyUserInfo)
    {
      QLog.d("ReadInJoyHeadImageView", 2, paramReadInJoyUserInfo.getMessage());
    }
  }
  
  private void init()
  {
    setRound(true);
    setImagePlaceHolder(aqhu.aU());
    this.mController.pV(false);
  }
  
  public void comLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public int getComMeasuredHeight()
  {
    return getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return getMeasuredWidth();
  }
  
  public void measureComponent(int paramInt1, int paramInt2)
  {
    onComMeasure(paramInt1, paramInt2);
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyHeadImageView", 2, "uin: " + paramString1 + " onLoadUserInfoFailed:" + paramString2);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("ReadInJoyHeadImageView", 2, "load uin success: " + paramString + " " + paramReadInJoyUserInfo);
    if ((!TextUtils.equals(paramString, String.valueOf(this.mUin))) || (paramReadInJoyUserInfo == null)) {
      return;
    }
    ThreadManager.getUIHandler().post(new ReadInJoyHeadImageView.1(this, paramReadInJoyUserInfo));
  }
  
  public void setHeadImgByUin(long paramLong)
  {
    setHeadImgByUin(paramLong, true);
  }
  
  public void setHeadImgByUin(long paramLong, boolean paramBoolean)
  {
    if (paramLong <= 0L) {
      QLog.d("ReadInJoyHeadImageView", 2, "Uin is illegal");
    }
    ReadInJoyUserInfo localReadInJoyUserInfo;
    do
    {
      return;
      this.mUin = paramLong;
      if (paramBoolean) {
        setImagePlaceHolder(cv);
      }
      localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(this.mUin, this);
    } while (localReadInJoyUserInfo == null);
    b(localReadInJoyUserInfo);
  }
  
  public void setHeadImgByUin(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("ReadInJoyHeadImageView", 2, "UinStr is illegal");
      return;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        QLog.d("ReadInJoyHeadImageView", 2, paramString.getMessage());
      }
    }
    setHeadImgByUin(l1);
  }
  
  public void setImageSrc(String paramString)
  {
    QLog.d("ReadInJoyHeadImageView", 2, "ReadInJoyHeadImageView imagesrc : " + paramString);
    try
    {
      setImage(new URL(paramString));
      return;
    }
    catch (MalformedURLException paramString)
    {
      QLog.d("ReadInJoyHeadImageView", 2, paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyHeadImageView
 * JD-Core Version:    0.7.0.1
 */