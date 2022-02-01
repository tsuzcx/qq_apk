package com.dataline.util.widget;

import afeg;
import ahav;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import aoop;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import eb;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncImageView
  extends ImageView
{
  private boolean bB = true;
  private boolean bC;
  private int dP;
  private int dQ = Color.parseColor("#C8C8C8");
  private int mClipHeight;
  private int mClipWidth;
  private Drawable mDefaultDrawable;
  
  public AsyncImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AsyncImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AsyncImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static URL a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = null;
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {}
    do
    {
      try
      {
        paramString = new URL(paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AsyncImageView", 2, paramString.getMessage(), paramString);
          }
          paramString = null;
        }
      }
      String str2;
      String str1;
      if (ahav.getFileType(paramString) == 2)
      {
        str2 = "videothumb";
        str1 = paramString;
        paramString = str2;
      }
      for (;;)
      {
        try
        {
          paramString = new URL(paramString, "", str1);
          return paramString;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          paramString = localObject;
        }
        str1 = "datalineimage";
        str2 = paramString + "|" + paramInt1 + "|" + paramInt2 + "|" + "0" + "|" + paramBoolean;
        paramString = str1;
        str1 = str2;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AsyncImageView", 2, localMalformedURLException.getMessage(), localMalformedURLException);
    return null;
  }
  
  public void setAsyncClipSize(int paramInt1, int paramInt2)
  {
    this.mClipWidth = paramInt1;
    this.mClipHeight = paramInt2;
  }
  
  public void setAsyncImage(String paramString)
  {
    URL localURL = a(paramString, this.mClipWidth, this.mClipHeight, this.bB);
    if ((getDrawable() instanceof URLDrawable))
    {
      paramString = (URLDrawable)getDrawable();
      if (paramString.getURL().toString().equals(localURL.toString()))
      {
        if ((paramString.getStatus() != 1) && (paramString.getStatus() != 0)) {
          paramString.restartDownload();
        }
        return;
      }
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (this.mDefaultDrawable != null)
    {
      paramString = this.mDefaultDrawable;
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = paramString;
      localURLDrawableOptions.mFailedDrawable = paramString;
      localURLDrawableOptions.mPlayGifImage = false;
      localURLDrawableOptions.mGifRoundCorner = 0.0F;
      localURLDrawableOptions.mDecodeFileStrategy = 3;
      if ((this.mClipWidth <= 0) || (this.mClipHeight <= 0)) {
        break label204;
      }
      localURLDrawableOptions.mRequestWidth = this.mClipWidth;
    }
    for (localURLDrawableOptions.mRequestHeight = this.mClipHeight;; localURLDrawableOptions.mRequestHeight = 0)
    {
      paramString = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      setImageDrawable(paramString);
      paramString.setURLDrawableListener(new eb(this));
      return;
      if (this.bC)
      {
        paramString = new ColorDrawable(this.dQ);
        break;
      }
      paramString = getResources().getDrawable(this.dP);
      break;
      label204:
      localURLDrawableOptions.mRequestWidth = 0;
    }
  }
  
  public void setDefaultColorDrawable(int paramInt)
  {
    this.dQ = paramInt;
    this.bC = true;
  }
  
  public void setDefaultImage(int paramInt)
  {
    this.dP = paramInt;
    this.bC = false;
  }
  
  public void setDefaultImageByMargin()
  {
    int i = this.mClipWidth;
    int j = this.mClipHeight;
    Resources localResources = getResources();
    if ((aoop.am() instanceof SkinnableBitmapDrawable))
    {
      this.mDefaultDrawable = new afeg(localResources, ((SkinnableBitmapDrawable)aoop.am()).getBitmap(), i, j, -921103);
      return;
    }
    if ((aoop.am() instanceof BitmapDrawable))
    {
      this.mDefaultDrawable = new afeg(localResources, ((BitmapDrawable)aoop.am()).getBitmap(), i, j, -921103);
      return;
    }
    this.mDefaultDrawable = aoop.am();
  }
  
  public void setImageDrawableDefault()
  {
    setImageDrawable(this.mDefaultDrawable);
  }
  
  public void setIsDrawRound(boolean paramBoolean)
  {
    this.bB = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.util.widget.AsyncImageView
 * JD-Core Version:    0.7.0.1
 */