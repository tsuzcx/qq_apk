package com.tencent.biz.pubaccount.readinjoy.video;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ChannelInfo;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Set;
import mtg;
import muj;
import mxv;
import wja;

public class VideoFeedsTopicViewGroup
  extends LinearLayout
{
  private mtg a;
  private final int aVN = 13;
  private final int aVO = 4;
  private int aVP;
  private Set<String> ae;
  private boolean anU;
  private VideoInfo c;
  private Activity mActivity;
  private Context mContext;
  private boolean mIsInited;
  private int mMaxWidth;
  
  public VideoFeedsTopicViewGroup(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public VideoFeedsTopicViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  @TargetApi(11)
  public VideoFeedsTopicViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  private void createContent()
  {
    int j = this.mMaxWidth - getPaddingLeft() - getPaddingRight() - this.aVP;
    if (((j <= 0) && (this.mMaxWidth > 0)) || (this.c == null)) {
      setVisibility(8);
    }
    int i;
    label107:
    VideoInfo.ChannelInfo localChannelInfo;
    Object localObject1;
    if ((j > 0) && (!this.mIsInited) && (this.c != null))
    {
      removeAllViews();
      if ((this.c.jQ == null) || (this.c.jQ.size() == 0))
      {
        setVisibility(8);
        if (this.c.jQ == null) {
          break label510;
        }
        i = 0;
        if (i >= this.c.jQ.size()) {
          break label510;
        }
        localChannelInfo = (VideoInfo.ChannelInfo)this.c.jQ.get(i);
        localObject1 = localChannelInfo.channelName;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label182;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label107;
      setVisibility(0);
      if (getWidth() != 0) {
        break;
      }
      muj.a(this, 200);
      break;
      label182:
      TextView localTextView = new TextView(this.mContext);
      localTextView.setText((CharSequence)localObject1);
      localTextView.setGravity(17);
      localTextView.setTextColor(Color.parseColor("#FFFFFF"));
      localTextView.setTextSize(2, 13.0F);
      localTextView.setId(2131376716);
      Object localObject2 = this.mContext.getResources().getDrawable(2130843831);
      ((Drawable)localObject2).setBounds(0, 0, wja.dp2px(18.0F, getResources()), wja.dp2px(18.0F, getResources()));
      localTextView.setCompoundDrawables((Drawable)localObject2, null, null, null);
      int m = aqcx.dip2px(this.mContext, 4.0F);
      localTextView.setCompoundDrawablePadding(m);
      if (VersionUtils.isJellyBean()) {
        localTextView.setBackground(this.mContext.getResources().getDrawable(2130843576));
      }
      localTextView.setPadding(wja.dp2px(4.0F, this.mContext.getResources()), 0, wja.dp2px(4.0F, this.mContext.getResources()), 0);
      TextPaint localTextPaint = localTextView.getPaint();
      localObject2 = new Rect();
      try
      {
        localTextPaint.getTextBounds((String)localObject1, 0, ((String)localObject1).length(), (Rect)localObject2);
        label386:
        int n = ((Rect)localObject2).width();
        int i1 = localTextView.getCompoundDrawables()[0].getIntrinsicWidth();
        int k;
        if (i == 0)
        {
          k = 0;
          label411:
          k += m * 4 + (n + i1);
          if (j < k) {
            break label497;
          }
          j -= k;
          localObject1 = new LinearLayout.LayoutParams(-2, -1);
          if (i != 0) {
            break label533;
          }
          ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
        }
        for (;;)
        {
          localTextView.setOnClickListener(new mxv(this, localChannelInfo));
          addView(localTextView, (ViewGroup.LayoutParams)localObject1);
          break;
          k = aqcx.dip2px(this.mContext, 4.0F);
          break label411;
          label497:
          if (getChildCount() == 0) {
            setVisibility(8);
          }
          label510:
          this.ae.add(this.c.Wz);
          this.mIsInited = true;
          return;
          label533:
          ((LinearLayout.LayoutParams)localObject1).setMargins(aqcx.dip2px(this.mContext, 4.0F), 0, 0, 0);
        }
      }
      catch (Exception localException)
      {
        break label386;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getDefaultSize(0, paramInt1);
    int i = j;
    if (j == 0) {
      i = this.mMaxWidth;
    }
    this.mMaxWidth = i;
    createContent();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setArticleInfo(Activity paramActivity, mtg parammtg, VideoInfo paramVideoInfo, Set<String> paramSet, boolean paramBoolean)
  {
    this.mActivity = paramActivity;
    this.a = parammtg;
    this.c = paramVideoInfo;
    this.ae = paramSet;
    this.mIsInited = false;
    this.anU = paramBoolean;
    createContent();
  }
  
  public void setHorizontalMargin(int paramInt)
  {
    this.aVP = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsTopicViewGroup
 * JD-Core Version:    0.7.0.1
 */