package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import kwz;
import kxm;
import lie;
import mas;
import wja;

public class ComponentContentUgcVideo
  extends ComponentContentBigImageVideo
{
  public ComponentContentUgcVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentUgcVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentUgcVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void P(Object paramObject)
  {
    super.P(paramObject);
  }
  
  public URL a(lie paramlie)
  {
    ArticleInfo localArticleInfo = paramlie.a();
    if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.a != null) && (localArticleInfo.mSocialFeedInfo.a.lb.size() > 0))
    {
      Object localObject = (SocializeFeedsInfo.t)localArticleInfo.mSocialFeedInfo.a.lb.get(0);
      int i = ((SocializeFeedsInfo.t)localObject).pic_width;
      int j = ((SocializeFeedsInfo.t)localObject).pic_height;
      if ((this.v != null) && (this.v.getLayoutParams() != null))
      {
        localObject = this.v.getLayoutParams();
        int k = ((ViewGroup.LayoutParams)localObject).width;
        int m = ((ViewGroup.LayoutParams)localObject).height;
        if (k == m)
        {
          localObject = localArticleInfo.getVideoCoverWithSmartCut(k, m);
          if (QLog.isColorLevel())
          {
            if (localObject == null) {
              break label204;
            }
            QLog.d("ComponentContentUgcVideo", 2, "url: " + ((URL)localObject).toString() + ", ivWidth: " + k + ", ivHeight: " + m);
          }
          while (localObject != null)
          {
            paramlie = (lie)localObject;
            return paramlie;
            label204:
            QLog.d("ComponentContentUgcVideo", 2, "ivWidth: " + k + ", ivHeight: " + m);
          }
        }
      }
      if (i * 4 > j * 3)
      {
        i = 1;
        label254:
        if (i != 0) {
          break label321;
        }
      }
      label321:
      for (boolean bool = true;; bool = false)
      {
        localObject = localArticleInfo.getVideoCoverUrlWithSmartCut(bool);
        if (localObject == null) {
          break label327;
        }
        paramlie = (lie)localObject;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ComponentContentUgcVideo", 2, "url: " + ((URL)localObject).toString());
        return localObject;
        i = 0;
        break label254;
      }
    }
    label327:
    return super.a(paramlie);
  }
  
  public void aNf()
  {
    ArticleInfo localArticleInfo;
    ViewGroup.LayoutParams localLayoutParams;
    Object localObject;
    int i;
    int k;
    boolean bool;
    int j;
    if ((this.a.a != null) && (this.a.a.a() != null))
    {
      localArticleInfo = this.a.a.a();
      if ((localArticleInfo.mSocialFeedInfo != null) && (localArticleInfo.mSocialFeedInfo.a != null) && (localArticleInfo.mSocialFeedInfo.a.lb.size() > 0))
      {
        localLayoutParams = getLayoutParams();
        localObject = getResources().getDisplayMetrics();
        i = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
        k = wja.dp2px(12.0F, getResources());
        localObject = this.v.getLayoutParams();
        SocializeFeedsInfo.t localt = (SocializeFeedsInfo.t)localArticleInfo.mSocialFeedInfo.a.lb.get(0);
        if (kxm.X(localt.pic_width, localt.pic_height)) {
          break label299;
        }
        bool = true;
        QLog.d("ComponentContentUgcVideo", 2, "isHorizontalScreen " + bool);
        if (!bool) {
          break label305;
        }
        j = i - k * 2;
        i = j * 9 / 16;
      }
    }
    for (;;)
    {
      ((ViewGroup.LayoutParams)localObject).width = j;
      ((ViewGroup.LayoutParams)localObject).height = i;
      localLayoutParams.width = j;
      localLayoutParams.height = i;
      this.v.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.v.setLayoutParams((ViewGroup.LayoutParams)localObject);
      setLayoutParams(localLayoutParams);
      QLog.d("ComponentContentUgcVideo", 2, "imageParams.width is " + ((ViewGroup.LayoutParams)localObject).width + "; imageParams.height is " + ((ViewGroup.LayoutParams)localObject).height);
      return;
      label299:
      bool = false;
      break;
      label305:
      if (localArticleInfo.mChannelID == 0L)
      {
        i = kwz.a(i, getResources());
        QLog.d("ComponentContentUgcVideo", 2, "main feeds | ivWidth is " + i + "; ivHeight is " + i);
        j = i;
      }
      else
      {
        j = (i - k * 2 + 9) / 2;
        i = (i - k * 2) / 3 * 2;
      }
    }
  }
  
  public void cG(View paramView)
  {
    super.cG(paramView);
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560310, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcVideo
 * JD-Core Version:    0.7.0.1
 */