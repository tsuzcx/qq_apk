package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import aqha;
import aqju;
import com.tencent.biz.qqcircle.requests.QCircleDoFollowTagRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView.b;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StTagInfo;
import ovd;
import pbz;
import pft;
import pfu;
import pfv;
import sox;

public class QCircleFollowTagView
  extends TextView
  implements View.OnClickListener
{
  private static final String TAG = QCircleFollowTagView.class.getSimpleName();
  private a jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView$a;
  private b jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView$b;
  private BaseWidgetView.b jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView$b;
  private FeedCloudMeta.StTagInfo jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo = new FeedCloudMeta.StTagInfo();
  protected boolean avA;
  private boolean azQ;
  private boolean azR;
  private boolean azS;
  private int bim = 2130844763;
  private int bin = 2130844764;
  
  public QCircleFollowTagView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QCircleFollowTagView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QCircleFollowTagView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  private void bkx()
  {
    aqha.a(getContext(), 230, getContext().getResources().getString(2131700185), null, 2131721058, 2131691042, new pfu(this), new pfv(this)).show();
  }
  
  public static void h(Context paramContext, String paramString, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent("action_update_web_tag_follow_state");
    localIntent.putExtra("tagId", paramString);
    localIntent.putExtra("followstate", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  protected void bkv()
  {
    setVisibility(0);
    setBackgroundResource(this.bim);
    setTextColor(getResources().getColor(2131165381));
    setText(2131700108);
  }
  
  protected void bkw()
  {
    setVisibility(0);
    setBackgroundResource(this.bin);
    setTextColor(getResources().getColor(2131165397));
    setText(2131700117);
  }
  
  protected void initView()
  {
    setOnClickListener(this);
    bkw();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  public void onClick(View paramView)
  {
    if ((sox.fY("QCircleFollowTagViewClick")) || (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView$b != null) {
        this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView$b.onClick(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.followState.get());
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView$b != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView$b.bja();
      }
      if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.followState.get() == 0) {
        ru(true);
      }
      if ((this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.followState.get() == 1) && (!this.azQ)) {
        bkx();
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void ru(boolean paramBoolean)
  {
    int i = 1;
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo == null)
    {
      QLog.e(TAG, 1, "follow tag failed! mTagInfo == null");
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      QCircleDoFollowTagRequest localQCircleDoFollowTagRequest = new QCircleDoFollowTagRequest(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.get(), i, null);
      VSNetworkHelper.a().a(localQCircleDoFollowTagRequest, new pft(this, i, paramBoolean));
      return;
      i = 0;
    }
  }
  
  public void setFollowStateChangeListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView$a = parama;
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
    this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCircleFollowTagView$b = paramb;
  }
  
  public void setOnlyFollowMode(boolean paramBoolean)
  {
    this.azQ = paramBoolean;
  }
  
  public void setTagInfo(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    boolean bool = true;
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagId.set(paramStTagInfo.tagId.get());
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagName.set(paramStTagInfo.tagName.get());
    if (pbz.a().eP(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.tagId.get()))
    {
      bool = pbz.a().eQ(paramStTagInfo.tagId.get());
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.followState.set(ovd.o(bool));
      vt(ovd.o(bool));
      return;
    }
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.followState.set(paramStTagInfo.followState.get());
    pbz localpbz = pbz.a();
    String str = paramStTagInfo.tagId.get();
    if (paramStTagInfo.followState.get() == 1) {}
    for (;;)
    {
      localpbz.as(str, bool);
      vt(this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.followState.get());
      return;
      bool = false;
    }
  }
  
  public void setUnFollowDrawable(int paramInt)
  {
    this.bim = paramInt;
  }
  
  public void vt(int paramInt)
  {
    if (this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo != null) {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo.followState.set(paramInt);
    }
    if (paramInt == 1)
    {
      bkw();
      return;
    }
    bkv();
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void bky();
    
    public abstract void onClick(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFollowTagView
 * JD-Core Version:    0.7.0.1
 */