package com.tencent.biz.qqstory.msgTabNode.view;

import acfp;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import puz;
import puz.a;
import ram;
import rpq;

public class MsgNodeShotView
  extends StoryMsgNodeFrameLayout
{
  private puz.a b;
  private Drawable mDefaultDrawable;
  
  public MsgNodeShotView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MsgNodeShotView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setDisplayState(4);
    bindData();
  }
  
  public puz.a b()
  {
    return this.b;
  }
  
  public void bindData()
  {
    Object localObject = ((puz)QQStoryContext.a().getManager(252)).a();
    if ((localObject != null) && (((puz.a)localObject).Jg()))
    {
      this.b = new puz.a();
      this.b.a((puz.a)localObject);
      ram.i("Q.qqstory.config.takevideo", "bindData config=" + ((puz.a)localObject).desc + " id=" + ((puz.a)localObject).contentId);
      setNodeName(this.b.desc, false);
      if (this.mDefaultDrawable == null) {
        this.mDefaultDrawable = getContext().getResources().getDrawable(2130847521);
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      if (this.b.imageUrl.endsWith(".gif"))
      {
        ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "msg_tab_thumb";
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject).mGifRoundCorner = rpq.dip2px(getContext(), 3.0F);
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.bkQ;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.bkR;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.mDefaultDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.mDefaultDrawable;
        localObject = URLDrawable.getDrawable(this.b.imageUrl, (URLDrawable.URLDrawableOptions)localObject);
        if ((((URLDrawable)localObject).getStatus() == 1) && (((URLDrawable)localObject).getCurrDrawable() != null))
        {
          ram.b("Q.qqstory.msgTab.MsgNodeShotView", "setImageByURLDrawable() %s, %s, not start download!", this.b.imageUrl, localObject);
          this.a.setImageDrawable((Drawable)localObject);
        }
      }
    }
    for (;;)
    {
      vZ(8);
      this.mz.setVisibility(8);
      return;
      if ((((URLDrawable)localObject).getStatus() == 3) || (((URLDrawable)localObject).getStatus() == 2))
      {
        ((URLDrawable)localObject).restartDownload();
        break;
      }
      ((URLDrawable)localObject).startDownload();
      break;
      rt(this.b.imageUrl);
      continue;
      ram.d("Q.qqstory.msgTab.MsgNodeShotView", "normal info");
      this.a.setImageResource(2130847521);
      setNodeName(acfp.m(2131708521), false);
      this.b = null;
    }
  }
  
  public String mE()
  {
    return this.xb.getText().toString();
  }
  
  public void onPostThemeChanged()
  {
    bindData();
  }
  
  protected void rt(String paramString)
  {
    if (this.mDefaultDrawable == null) {
      this.mDefaultDrawable = getContext().getResources().getDrawable(2130847521);
    }
    rpq.a(this.a, paramString, this.mDefaultDrawable, this.mDefaultDrawable, this.bkR, this.bkQ, "msg_tab_thumb");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgNodeShotView
 * JD-Core Version:    0.7.0.1
 */