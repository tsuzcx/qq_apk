package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import aqbn;
import aqcx;
import awit;
import awit.c;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kvl;
import kwz;
import kxm;
import lie;
import lwm.a;
import mas;
import mhr;
import mhr.a;
import muj;
import ndi;
import wja;

public class ComponentContentVerticalSmallVideo
  extends ComponentContentBig
{
  KandianUrlImageView I;
  Pair<Integer, Integer> f;
  public boolean isSingleVideo;
  ImageView jn;
  TextView ll;
  View mMaskView;
  FrameLayout mRootView;
  TextView qu;
  TextView qv;
  TextView qw;
  KandianUrlImageView v;
  
  public ComponentContentVerticalSmallVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentVerticalSmallVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentVerticalSmallVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @SuppressLint({"Range"})
  private void Ib()
  {
    ArticleInfo localArticleInfo = this.a.a.a();
    if (localArticleInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(localArticleInfo.mVideoArticleSubsText))
    {
      String str;
      if (TextUtils.isEmpty(localArticleInfo.mVideoArticleSubsColor)) {
        str = "#FE6c6c";
      }
      try
      {
        for (;;)
        {
          this.qw.setTextColor(Color.parseColor("#ffffff"));
          kvl.setBackground(this.qw, b(Color.parseColor(str), getContext()));
          this.qw.setText(localArticleInfo.mVideoArticleSubsText);
          this.qw.setVisibility(0);
          return;
          str = localArticleInfo.mVideoArticleSubsColor;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 2, "configDefaultItem: ", localException);
          }
          this.qw.setTextColor(Color.parseColor("#ffffff"));
          kvl.setBackground(this.qw, b(Color.parseColor("#FE6c6c"), getContext()));
        }
      }
    }
    this.qw.setVisibility(8);
  }
  
  public static ShapeDrawable b(int paramInt, Context paramContext)
  {
    int i = aqcx.dip2px(paramContext, 2.0F);
    paramContext = new ShapeDrawable(new RoundRectShape(new float[] { i, i, i, i, i, i, i, i }, null, null));
    paramContext.getPaint();
    paramContext.getPaint().setColor(paramInt);
    return paramContext;
  }
  
  public void P(Object paramObject)
  {
    lie locallie;
    if ((paramObject instanceof lie))
    {
      locallie = (lie)paramObject;
      this.a.setModel(locallie);
      if (locallie.getTotal() != 1) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      this.isSingleVideo = bool;
      paramObject = locallie.a();
      if (paramObject != null) {
        break;
      }
      return;
    }
    if (kxm.B(paramObject))
    {
      this.f = new Pair(Integer.valueOf(wja.dp2px(165.0F, getResources())), Integer.valueOf(wja.dp2px(293.0F, getResources())));
      findViewById(2131365739).setVisibility(8);
    }
    for (;;)
    {
      aNf();
      if (this.a.a.nh() == 56)
      {
        this.mRootView.setForeground(getResources().getDrawable(2130843987));
        label144:
        if (!this.isSingleVideo) {
          break label404;
        }
        Object localObject = kwz.a(1, this.a.a.nh());
        localObject = URLDrawable.getDrawable(a(locallie), ((Integer)((Pair)localObject).first).intValue(), ((Integer)((Pair)localObject).second).intValue(), new ColorDrawable(-1447447), new ColorDrawable(-1447447));
        ((URLDrawable)localObject).setDecodeHandler(aqbn.t);
        this.I.setImageDrawable((Drawable)localObject);
        this.I.setVisibility(0);
        this.mMaskView.setVisibility(0);
        this.v.setImagePlaceHolder(new ColorDrawable(-1447447));
      }
      try
      {
        this.v.setImage(a(locallie));
        if (kxm.B(paramObject))
        {
          this.ll.setVisibility(8);
          this.qv.setVisibility(8);
          this.qu.setVisibility(8);
          this.jn.setVisibility(0);
          Ib();
          return;
          if (this.isSingleVideo)
          {
            this.f = kwz.a(3, this.a.a.nh());
            continue;
          }
          this.f = kwz.a(this.a.a.getTotal(), this.a.a.nh());
          continue;
          this.mRootView.setForeground(null);
          break label144;
          label404:
          this.I.setVisibility(8);
          this.mMaskView.setVisibility(8);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, "bindData setVideoCover failed. Exception e = " + localException);
          continue;
          awit.c localc = awit.a(BaseApplicationImpl.getApplication().getRuntime());
          if ((localc != null) && (localc.dqw))
          {
            this.jn.setVisibility(0);
            this.qv.setCompoundDrawablePadding(wja.dp2px(3.0F, getResources()));
            this.qv.setCompoundDrawablesWithIntrinsicBounds(2130850207, 0, 0, 0);
            label514:
            if ((localc == null) || (localc.dqx)) {
              break label578;
            }
            this.qu.setVisibility(8);
          }
          for (;;)
          {
            if ((localc == null) || (localc.dqy)) {
              break label651;
            }
            this.ll.setVisibility(8);
            this.qv.setVisibility(8);
            break;
            this.jn.setVisibility(8);
            break label514;
            label578:
            if ((localc != null) && (localc.eBj > 0)) {
              this.qu.setMaxLines(localc.eBj);
            }
            if (ndi.aa(paramObject)) {
              this.qu.setText(paramObject.mTitle);
            } else {
              this.qu.setText(((SocializeFeedsInfo.t)paramObject.mSocialFeedInfo.a.lb.get(0)).title);
            }
          }
          label651:
          this.ll.setText(getResources().getString(2131718378, new Object[] { paramObject.getCommentCount() + "" }));
          if (paramObject.mVideoPlayCount <= 0) {
            this.qv.setText("0");
          } else {
            this.qv.setText(muj.bw(paramObject.mVideoPlayCount));
          }
        }
      }
    }
  }
  
  public URL a(lie paramlie)
  {
    URL localURL = null;
    Object localObject = paramlie.a();
    if (ComponentPolymericView.n(paramlie))
    {
      paramlie = ((mhr.a)((ArticleInfo)localObject).mNewPolymericInfo.iP.get(0)).ahr;
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, "getUrl new polymeric video cover rawUrl = " + paramlie);
      }
      localURL = ((ArticleInfo)localObject).getVideoCoverUrlWithSmartCut(((Integer)this.f.first).intValue(), ((Integer)this.f.second).intValue(), paramlie);
      if (QLog.isColorLevel())
      {
        if ("getUrl new polymeric video cover after smartcut url = " + localURL != null)
        {
          paramlie = localURL.getFile();
          QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, paramlie);
        }
      }
      else {
        paramlie = localURL;
      }
    }
    do
    {
      return paramlie;
      paramlie = null;
      break;
      paramlie = ((ArticleInfo)localObject).getVideoCoverURL();
      if (paramlie == null) {
        break label275;
      }
      paramlie = paramlie.getFile();
      if (QLog.isColorLevel()) {
        QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, "getUrl old polymeric video cover rawUrl = " + paramlie);
      }
      localObject = ((ArticleInfo)localObject).getVideoCoverUrlWithSmartCut(((Integer)this.f.first).intValue(), ((Integer)this.f.second).intValue(), paramlie);
      paramlie = (lie)localObject;
    } while (!QLog.isColorLevel());
    paramlie = localURL;
    if ("getUrl old polymeric video cover after smartcut url = " + localObject != null) {
      paramlie = ((URL)localObject).getFile();
    }
    QLog.d("PolymericSmallVideo_ComponentContentVerticalSmallVideo", 1, paramlie);
    return localObject;
    label275:
    return ((ArticleInfo)localObject).getVideoCoverURL();
  }
  
  public void a(lwm.a parama)
  {
    this.a.b(parama);
  }
  
  public void aNf()
  {
    ViewGroup.LayoutParams localLayoutParams = this.v.getLayoutParams();
    localLayoutParams.width = ((Integer)this.f.first).intValue();
    localLayoutParams.height = ((Integer)this.f.second).intValue();
    this.v.setLayoutParams(localLayoutParams);
  }
  
  public void cG(View paramView)
  {
    this.I = ((KandianUrlImageView)paramView.findViewById(2131368897));
    this.v = ((KandianUrlImageView)paramView.findViewById(2131368896));
    this.qu = ((TextView)paramView.findViewById(2131364324));
    this.ll = ((TextView)paramView.findViewById(2131365001));
    this.qv = ((TextView)paramView.findViewById(2131381758));
    this.qw = ((TextView)paramView.findViewById(2131378995));
    this.mMaskView = paramView.findViewById(2131368898);
    this.mRootView = ((FrameLayout)paramView.findViewById(2131377565));
    this.jn = ((ImageView)paramView.findViewById(2131373387));
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560311, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentVerticalSmallVideo
 * JD-Core Version:    0.7.0.1
 */