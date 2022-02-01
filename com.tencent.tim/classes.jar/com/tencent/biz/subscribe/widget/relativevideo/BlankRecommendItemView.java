package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFollowRcmd;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StVideo;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import ankt;
import auqt;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ryx;
import rzd;
import sje;
import sjf;
import sqn;

public class BlankRecommendItemView
  extends BaseWidgetView<CertifiedAccountMeta.StFollowRcmd>
  implements View.OnClickListener
{
  private TextView Ab;
  private TextView Ac;
  private boolean avA;
  private FollowTextView e;
  private int mPos;
  private SquareImageView o;
  private ArrayList<a> oc;
  private View pB;
  private TextView qE;
  
  public BlankRecommendItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  private String ck(int paramInt)
  {
    DecimalFormat localDecimalFormat;
    if (paramInt >= 10000)
    {
      localDecimalFormat = new DecimalFormat(".#");
      return localDecimalFormat.format(paramInt / 10000.0D) + "W";
    }
    if (paramInt >= 1000)
    {
      localDecimalFormat = new DecimalFormat(".#");
      return localDecimalFormat.format(paramInt / 1000.0D) + "K";
    }
    return String.valueOf(paramInt);
  }
  
  @RequiresApi(api=8)
  protected void a(CertifiedAccountMeta.StFollowRcmd paramStFollowRcmd)
  {
    if ((paramStFollowRcmd == null) || (!paramStFollowRcmd.user.has())) {
      return;
    }
    CertifiedAccountMeta.StUser localStUser = (CertifiedAccountMeta.StUser)paramStFollowRcmd.user.get();
    this.o.getLayoutParams().width = ankt.dip2px(36.0F);
    this.o.getLayoutParams().height = ankt.dip2px(36.0F);
    ryx.b(localStUser.icon.get(), this.o);
    this.Ab.setText(localStUser.nick.get());
    this.Ac.setText(String.format("%s%s", new Object[] { this.Ac.getContext().getString(2131720627), ck(paramStFollowRcmd.fansCount.get()) }));
    String str = paramStFollowRcmd.reason.get();
    if (TextUtils.isEmpty(str)) {
      str = localStUser.desc.get();
    }
    for (;;)
    {
      this.qE.setText(str);
      this.e.setUserData(localStUser);
      this.e.setExtraTypeInfo(getExtraTypeInfo());
      this.e.setFollowStateChangeListener(new sje(this, localStUser));
      paramStFollowRcmd = paramStFollowRcmd.feedList.get();
      int i = 0;
      if (i < 3)
      {
        if (auqt.b(i, paramStFollowRcmd)) {
          ((a)this.oc.get(i)).s(null);
        }
        for (;;)
        {
          i += 1;
          break;
          ((a)this.oc.get(i)).s((CertifiedAccountMeta.StFeed)paramStFollowRcmd.get(i));
        }
      }
      sqn.c(localStUser.id.get(), "auth_follow", "blank_content_exp", 0, 0, new String[] { "", this.mPos + "", localStUser.nick.get(), str });
      return;
    }
  }
  
  public View aB()
  {
    return this;
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.o = ((SquareImageView)findViewById(2131369666));
    this.Ab = ((TextView)findViewById(2131380565));
    this.Ac = ((TextView)findViewById(2131380564));
    this.qE = ((TextView)findViewById(2131380566));
    this.pB = findViewById(2131365997);
    this.o.setOnClickListener(this);
    this.Ab.setOnClickListener(this);
    this.Ac.setOnClickListener(this);
    this.qE.setOnClickListener(this);
    this.e = ((FollowTextView)findViewById(2131380717));
    if (this.oc == null) {
      this.oc = new ArrayList();
    }
    this.oc.add(new a(findViewById(2131377416), 1));
    this.oc.add(new a(findViewById(2131377417), 2));
    this.oc.add(new a(findViewById(2131377418), 3));
  }
  
  public int getLayoutId()
  {
    return 2131558832;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      CertifiedAccountMeta.StFollowRcmd localStFollowRcmd = (CertifiedAccountMeta.StFollowRcmd)getData();
      rzd.a(getContext(), (CertifiedAccountMeta.StUser)localStFollowRcmd.user.get());
      if (2131369666 == paramView.getId()) {
        sqn.c(localStFollowRcmd.user.id.get(), "auth_follow", "blank_head_clk", 0, 0, new String[] { "", "", localStFollowRcmd.user.nick.get() });
      } else if (2131380565 == paramView.getId()) {
        sqn.c(localStFollowRcmd.user.id.get(), "auth_follow", "blank_name_clk", 0, 0, new String[] { "", "", localStFollowRcmd.user.nick.get() });
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.avA = paramBoolean;
    if (this.avA)
    {
      this.o.setFilterColor(1711276032);
      this.Ab.setTextColor(-5723992);
      this.Ac.setTextColor(-10132123);
      this.qE.setTextColor(-10132123);
      this.e.setIsInNightMode(this.avA);
      this.pB.setBackgroundColor(-9211021);
      Iterator localIterator = this.oc.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          locala.setNightMode();
        }
      }
    }
  }
  
  public void setPos(int paramInt)
  {
    this.mPos = paramInt;
  }
  
  public View.OnClickListener v()
  {
    return null;
  }
  
  public class a
  {
    private RoundCornerImageView f;
    private TextView mDuration;
    private View mRoot;
    private int pos;
    
    public a(View paramView, int paramInt)
    {
      this.mRoot = paramView;
      this.pos = paramInt;
      this.f = ((RoundCornerImageView)this.mRoot.findViewById(2131369745));
      this.mDuration = ((TextView)this.mRoot.findViewById(2131380695));
    }
    
    public void s(CertifiedAccountMeta.StFeed paramStFeed)
    {
      if (paramStFeed != null)
      {
        this.mRoot.setVisibility(0);
        int i = paramStFeed.cover.width.get();
        if (paramStFeed.cover.height.get() > i) {
          this.f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        try
        {
          for (;;)
          {
            this.f.setImageURL(paramStFeed.cover.url.get());
            if (paramStFeed.video.duration.get() <= 0L) {
              break;
            }
            i = paramStFeed.video.duration.get() / 1000 / 60;
            int j = paramStFeed.video.duration.get() / 1000;
            this.mDuration.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j % 60) }));
            this.mDuration.setVisibility(0);
            this.mRoot.setOnClickListener(new sjf(this, paramStFeed));
            return;
            this.f.setScaleType(ImageView.ScaleType.FIT_CENTER);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e("BlankRecommendItemView", 2, "setData() set image url error! url: " + paramStFeed.cover.url.get(), localThrowable);
            continue;
            this.mDuration.setVisibility(8);
          }
        }
      }
      this.mRoot.setVisibility(4);
    }
    
    public void setNightMode()
    {
      this.f.setBackgroundColor(Color.parseColor("#252525"));
      this.f.invalidate();
      this.mDuration.setTextColor(-5723992);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView
 * JD-Core Version:    0.7.0.1
 */