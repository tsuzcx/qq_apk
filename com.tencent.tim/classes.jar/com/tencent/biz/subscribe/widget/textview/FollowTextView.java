package com.tencent.biz.subscribe.widget.textview;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import aqmr;
import ausj;
import awdg;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView.b;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import ocp;
import rwv;
import rwx;
import siu;
import sjx;
import sjy;
import sjz;
import ska;
import sqn;

public class FollowTextView
  extends TextView
  implements View.OnClickListener, rwx
{
  private BaseWidgetView.b jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView$b;
  private a jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView$a;
  private volatile boolean aLO = true;
  protected boolean avA;
  private boolean azQ;
  private boolean azT;
  private CertifiedAccountMeta.StFeed l;
  private ExtraTypeInfo mExtraTypeInfo;
  
  public FollowTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FollowTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FollowTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void b(boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed)
  {
    String str1;
    String str2;
    String str3;
    if (paramStFeed != null)
    {
      if (aqmr.isEmpty(paramStFeed.id.get())) {
        break label100;
      }
      str1 = paramStFeed.id.get();
      str2 = paramStFeed.poster.id.get();
      str3 = "auth_" + siu.b(getExtraTypeInfo());
      if (!paramBoolean) {
        break label114;
      }
    }
    label100:
    label114:
    for (paramStFeed = "follow";; paramStFeed = "un_follow")
    {
      sqn.b(str2, str3, paramStFeed, 0, 0, new String[] { "", "", str1 });
      return;
      str1 = paramStFeed.poster.nick.get();
      break;
    }
  }
  
  private void bkA()
  {
    ausj localausj = ausj.b(getContext());
    localausj.setMainTitle(String.format(getContext().getResources().getString(2131697482), new Object[] { this.l.poster.nick.get() }));
    localausj.addButton(2131698678, 3);
    localausj.addCancelButton(2131721058);
    localausj.setOnDismissListener(new sjz(this));
    localausj.a(new ska(this, localausj));
    if (!localausj.isShowing())
    {
      this.aLO = true;
      localausj.show();
    }
  }
  
  protected boolean MN()
  {
    return (this.l == null) || (aqmr.isEmpty(this.l.poster.nick.get()));
  }
  
  protected void bkv()
  {
    if (this.avA)
    {
      i = 2130839232;
      setBackgroundResource(i);
      if (!this.avA) {
        break label43;
      }
    }
    label43:
    for (int i = -1493172225;; i = -1)
    {
      setTextColor(i);
      setText(2131691357);
      return;
      i = 2130839230;
      break;
    }
  }
  
  protected void bkw()
  {
    if (this.avA)
    {
      i = 2130839145;
      setBackgroundResource(i);
      if (!this.avA) {
        break label43;
      }
    }
    label43:
    for (int i = -9211021;; i = Color.parseColor("#bdbfc9"))
    {
      setTextColor(i);
      setText(2131691351);
      return;
      i = 2130839143;
      break;
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FollowUpdateEvent.class);
    return localArrayList;
  }
  
  public ExtraTypeInfo getExtraTypeInfo()
  {
    return this.mExtraTypeInfo;
  }
  
  protected void initView()
  {
    setGravity(17);
    setTextColor(-1);
    setOnClickListener(this);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      rwv.a().a(this);
    }
  }
  
  public void onClick(View paramView)
  {
    if (MN()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!this.aLO)
      {
        QQToast.a(getContext(), "请勿重复操作", 0).show();
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView$b != null) {
          this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView$b.bja();
        }
        if (this.l.poster.followState.get() == 0) {
          rw(true);
        } else if (!this.azQ) {
          bkA();
        }
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    rwv.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((this.l != null) && ((paramSimpleBaseEvent instanceof FollowUpdateEvent)))
    {
      FollowUpdateEvent localFollowUpdateEvent = (FollowUpdateEvent)paramSimpleBaseEvent;
      if (this.l.poster.id.get().equals(localFollowUpdateEvent.useId))
      {
        vt(localFollowUpdateEvent.followStatus);
        awdg.a(getContext(), (FollowUpdateEvent)paramSimpleBaseEvent);
        SubscribeHybirdFragment.a(getContext(), (FollowUpdateEvent)paramSimpleBaseEvent);
      }
    }
  }
  
  public void rw(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FollowTextView", 2, "follow");
    }
    if (this.l == null) {
      QLog.e("FollowTextView", 2, "follow user failed! user is null");
    }
    do
    {
      return;
      this.aLO = false;
      localObject = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localObject instanceof QQAppInterface));
    Object localObject = (QQAppInterface)localObject;
    if (paramBoolean)
    {
      ocp.a((AppInterface)localObject, getContext(), this.l.poster.id.get(), new sjx(this), false, 0, true);
      return;
    }
    ocp.a((QQAppInterface)localObject, getContext(), this.l.poster.id.get(), false, new sjy(this), true);
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.mExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setFeedData(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      this.l = paramStFeed;
      vt(paramStFeed.poster.followState.get());
    }
  }
  
  public void setFollowStateChangeListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewFollowTextView$a = parama;
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.avA = paramBoolean;
  }
  
  public void setItemPreClickListener(BaseWidgetView.b paramb)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView$b = paramb;
  }
  
  public void setNoneReportType(boolean paramBoolean)
  {
    this.azT = paramBoolean;
  }
  
  public void setOnlyFollowMode(boolean paramBoolean)
  {
    this.azQ = paramBoolean;
  }
  
  public void setUserData(CertifiedAccountMeta.StUser paramStUser)
  {
    setUserData(paramStUser, -1);
  }
  
  public void setUserData(CertifiedAccountMeta.StUser paramStUser, int paramInt)
  {
    CertifiedAccountMeta.StFeed localStFeed = new CertifiedAccountMeta.StFeed();
    localStFeed.poster.set(paramStUser);
    localStFeed.type.set(paramInt);
    this.l = localStFeed;
    if (paramInt == -1) {}
    for (boolean bool = true;; bool = false)
    {
      this.azT = bool;
      vt(localStFeed.poster.followState.get());
      return;
    }
  }
  
  public void vt(int paramInt)
  {
    if (this.l != null) {
      this.l.poster.followState.set(paramInt);
    }
    if (paramInt == 1)
    {
      bkw();
      return;
    }
    bkv();
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.textview.FollowTextView
 * JD-Core Version:    0.7.0.1
 */