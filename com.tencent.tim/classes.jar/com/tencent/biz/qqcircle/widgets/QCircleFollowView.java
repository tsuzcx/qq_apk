package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import atau.a;
import ausj;
import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoFollowRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView.b;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import ovd;
import pbu;
import pfw;
import pfx;
import rwv;
import rwx;
import sox;

public class QCircleFollowView
  extends TextView
  implements View.OnClickListener, rwx
{
  private a jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView$a;
  private b jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView$b;
  private BaseWidgetView.b jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView$b;
  protected boolean avA;
  private boolean azQ;
  private boolean azR;
  private boolean azS;
  private boolean azT;
  private int bim;
  private int bin;
  private int bip;
  private int biq;
  private FeedCloudMeta.StUser d = new FeedCloudMeta.StUser();
  
  public QCircleFollowView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleFollowView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rs);
    this.bin = paramContext.getResourceId(0, 2130844764);
    this.bim = paramContext.getResourceId(2, 2130844763);
    this.bip = paramContext.getColor(1, getResources().getColor(2131165397));
    this.biq = paramContext.getColor(3, getResources().getColor(2131165381));
    initView();
  }
  
  private void bkA()
  {
    ausj localausj = ausj.b(getContext());
    localausj.setMainTitle(getContext().getResources().getString(2131700185));
    localausj.addButton(2131691042, 0);
    localausj.addCancelButton(2131721058);
    localausj.a(new pfx(this, localausj));
    if (!localausj.isShowing()) {
      localausj.show();
    }
  }
  
  public static void h(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent("action_update_web_user_follow_state");
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("followstate", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void an(int paramInt, boolean paramBoolean)
  {
    if (this.d != null)
    {
      this.d.followState.set(paramInt);
      QLog.d("QCircleFollowView", 1, "uin:" + this.d.id.get() + " state:" + paramInt);
    }
    if (paramInt == 1)
    {
      rv(paramBoolean);
      return;
    }
    bkv();
  }
  
  protected void bkv()
  {
    setVisibility(0);
    setBackgroundResource(this.bim);
    setTextColor(this.biq);
    setText(2131700108);
  }
  
  protected void bkz()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillEnabled(false);
    startAnimation(localAlphaAnimation);
    postDelayed(new QCircleFollowView.1(this), 500L);
  }
  
  public void d(FeedCloudMeta.StUser paramStUser)
  {
    if ((TextUtils.isEmpty(paramStUser.id.get())) || (ovd.a(paramStUser))) {
      setVisibility(8);
    }
    boolean bool;
    do
    {
      do
      {
        return;
      } while (!pbu.a().hasUin(paramStUser.id.get()));
      bool = pbu.a().getUinFollowed(paramStUser.id.get());
      this.d.followState.set(ovd.o(bool));
      vt(ovd.o(bool));
    } while (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView$a == null);
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView$a.a(bool, this.d);
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFollowUpdateEvent.class);
    return localArrayList;
  }
  
  protected void initView()
  {
    setOnClickListener(this);
    bkv();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (!isInEditMode()) {
      rwv.a().a(this);
    }
    if ((this.d != null) && (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView$b != null)) {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView$b.vu(this.d.followState.get());
    }
    d(this.d);
  }
  
  public void onClick(View paramView)
  {
    if ((sox.fY("QCircleFollowViewClick")) || (this.d == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView$b != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView$b.onClick(this.d.followState.get());
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView$b != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView$b.bja();
      }
      if (this.d.followState.get() == 0) {
        rw(true);
      }
      if ((this.d.followState.get() == 1) && (!this.azQ)) {
        bkA();
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
    boolean bool = true;
    if ((this.d != null) && ((paramSimpleBaseEvent instanceof QCircleFollowUpdateEvent)))
    {
      paramSimpleBaseEvent = (QCircleFollowUpdateEvent)paramSimpleBaseEvent;
      if ((this.d.id.get().equals(paramSimpleBaseEvent.mUserId)) && (this.d.followState.get() != paramSimpleBaseEvent.mFollowStatus))
      {
        vt(paramSimpleBaseEvent.mFollowStatus);
        if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView$a != null) {
          if (paramSimpleBaseEvent.mFollowStatus != 1) {
            break label96;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView$a.a(bool, this.d);
      return;
      label96:
      bool = false;
    }
  }
  
  protected void rv(boolean paramBoolean)
  {
    setVisibility(0);
    setBackgroundResource(this.bin);
    setTextColor(this.bip);
    setText(2131700117);
    if (this.azR)
    {
      if (paramBoolean) {
        bkz();
      }
    }
    else {
      return;
    }
    setVisibility(8);
  }
  
  public void rw(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCircleFollowView", 2, "follow");
    }
    if (this.d == null)
    {
      QLog.e("QCircleFollowView", 2, "follow user failed! user is null");
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      VSNetworkHelper.a().a(new QCircleDoFollowRequest(this.d, i, null), new pfw(this, i, paramBoolean));
      return;
    }
  }
  
  public void setFollowStateChangeListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView$a = parama;
  }
  
  public void setFollowedDismiss(boolean paramBoolean)
  {
    this.azR = paramBoolean;
  }
  
  public void setFollowedDrawable(int paramInt)
  {
    this.bin = paramInt;
  }
  
  public void setFollowedShowToast(boolean paramBoolean)
  {
    this.azS = paramBoolean;
  }
  
  public void setFollowedTextColor(int paramInt)
  {
    this.bip = paramInt;
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.avA = paramBoolean;
  }
  
  public void setItemPreClickListener(BaseWidgetView.b paramb)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView$b = paramb;
  }
  
  public void setItemReportListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowView$b = paramb;
  }
  
  public void setOnlyFollowMode(boolean paramBoolean)
  {
    this.azQ = paramBoolean;
  }
  
  public void setUnFollowDrawable(int paramInt)
  {
    this.bim = paramInt;
  }
  
  public void setUnFollowTextColor(int paramInt)
  {
    this.biq = paramInt;
  }
  
  public void setUserData(FeedCloudMeta.StUser paramStUser)
  {
    if (paramStUser != null)
    {
      this.d.id.set(paramStUser.id.get());
      if ((TextUtils.isEmpty(paramStUser.id.get())) || (ovd.a(paramStUser))) {
        setVisibility(8);
      }
    }
    else
    {
      return;
    }
    if (pbu.a().hasUin(paramStUser.id.get()))
    {
      boolean bool = pbu.a().getUinFollowed(paramStUser.id.get());
      this.d.followState.set(ovd.o(bool));
      vt(ovd.o(bool));
      return;
    }
    this.d.followState.set(paramStUser.followState.get());
    vt(this.d.followState.get());
  }
  
  public void vt(int paramInt)
  {
    an(paramInt, false);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, FeedCloudMeta.StUser paramStUser);
  }
  
  public static abstract interface b
  {
    public abstract void bky();
    
    public abstract void onClick(int paramInt);
    
    public abstract void vu(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFollowView
 * JD-Core Version:    0.7.0.1
 */