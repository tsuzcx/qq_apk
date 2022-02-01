package com.tencent.biz.subscribe.account_folder.recommend_banner;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqcx;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import rwv;
import rwx;
import rzd;
import rzp;
import rzw;
import rzz;
import sqn;

public class RecommendBannerItemView
  extends RelativeLayout
  implements View.OnClickListener, rwx
{
  private FollowTextView a;
  private boolean aKG;
  private boolean aKI;
  private boolean avA;
  private rzp b;
  private int bvU;
  private CertifiedAccountMeta.StUser c;
  private SquareImageView h;
  private TextView mNickName;
  private TextView wG;
  
  public RecommendBannerItemView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public RecommendBannerItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public RecommendBannerItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private void c(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    anot.a(null, "dc00898", "", paramString3, paramString1, paramString2, 0, 0, paramString4, paramString5, paramString6, paramString7);
  }
  
  protected void bxC()
  {
    if (this.c != null) {
      rzd.a(getContext(), this.c);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    return localArrayList;
  }
  
  protected void initView(Context paramContext)
  {
    inflate(paramContext, 2131558864, this);
    setMinimumHeight(aqcx.dip2px(paramContext, 183.0F));
    setPadding(aqcx.dip2px(paramContext, 6.0F), aqcx.dip2px(paramContext, 10.0F), aqcx.dip2px(paramContext, 6.0F), aqcx.dip2px(paramContext, 20.0F));
    setWillNotDraw(false);
    setLayerType(1, null);
    this.h = ((SquareImageView)findViewById(2131363175));
    this.wG = ((TextView)findViewById(2131365720));
    this.mNickName = ((TextView)findViewById(2131372369));
    this.a = ((FollowTextView)findViewById(2131361976));
    setOnClickListener(this);
    setOnLongClickListener(new rzw(this));
  }
  
  protected void onAttachedToWindow()
  {
    rwv.a().a(this);
    super.onAttachedToWindow();
  }
  
  public void onClick(View paramView)
  {
    bxC();
    if (this.aKI) {
      if (this.c != null) {
        sqn.b(this.c.id.get(), "auth_discover", "reco_head_clk", 0, 0, new String[] { "", String.valueOf(this.bvU), this.c.nick.get(), this.c.desc.get() });
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.c != null) {
        c("auth_page", "recom_head", this.c.id.get(), "", "", String.valueOf(this.bvU), this.c.nick.get());
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    rwv.a().b(this);
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = getWidth();
    int m = getPaddingRight();
    int n = getHeight();
    int i1 = getPaddingBottom();
    Paint localPaint = new Paint();
    if (this.avA) {
      localPaint.setColor(-15263977);
    }
    for (;;)
    {
      if (!this.aKG)
      {
        i2 = aqcx.dip2px(getContext(), 5.0F);
        localPaint.setShadowLayer(aqcx.dip2px(getContext(), 15.0F), 0, i2, 436207616);
      }
      int i2 = aqcx.dip2px(getContext(), 6.0F);
      paramCanvas.drawRoundRect(new RectF(i, j, k - m, n - i1), i2, i2, localPaint);
      super.onDraw(paramCanvas);
      return;
      localPaint.setColor(-1);
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    rzp localrzp;
    if (((paramSimpleBaseEvent instanceof FollowUpdateEvent)) && (this.c != null) && (TextUtils.equals(((FollowUpdateEvent)paramSimpleBaseEvent).useId, this.c.id.get())))
    {
      this.c.followState.set(((FollowUpdateEvent)paramSimpleBaseEvent).followStatus);
      if (this.b != null)
      {
        localrzp = this.b;
        if (((FollowUpdateEvent)paramSimpleBaseEvent).followStatus != 1) {
          break label91;
        }
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      localrzp.ag(bool, this.bvU);
      return;
    }
  }
  
  public void setData(CertifiedAccountMeta.StUser paramStUser, int paramInt)
  {
    this.c = paramStUser;
    this.bvU = paramInt;
    if (paramStUser != null)
    {
      this.mNickName.setText(paramStUser.nick.get());
      this.wG.setText(paramStUser.desc.get());
      c("auth_page", "recom_exp", paramStUser.id.get(), "", "", String.valueOf(this.bvU), paramStUser.nick.get());
    }
    try
    {
      this.h.setImageURL(paramStUser.icon.get());
      this.a.setUserData(this.c);
      this.a.setFollowStateChangeListener(new rzz(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("RecommendBannerItemView", 2, "setData() set icon url error! url: " + paramStUser.icon.get(), localThrowable);
      }
    }
  }
  
  public void setInNewFolderPage(boolean paramBoolean)
  {
    this.aKI = paramBoolean;
  }
  
  public void setInNightMode(boolean paramBoolean)
  {
    this.avA = paramBoolean;
    if (this.avA)
    {
      this.h.setFilterColor(1711276032);
      this.wG.setTextColor(-9079435);
      this.mNickName.setTextColor(-5723992);
      this.a.setIsInNightMode(paramBoolean);
    }
  }
  
  public void setIsCloseShadow(boolean paramBoolean)
  {
    this.aKG = paramBoolean;
  }
  
  public void setRecommendBannerFolwListener(rzp paramrzp)
  {
    this.b = paramrzp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView
 * JD-Core Version:    0.7.0.1
 */