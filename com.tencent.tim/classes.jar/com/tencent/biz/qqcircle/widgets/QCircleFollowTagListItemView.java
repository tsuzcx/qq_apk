package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCircleTopTagEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoFollowTagRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StTagInfo;
import pfr;
import pfs;
import rwv;

public class QCircleFollowTagListItemView
  extends BaseWidgetView<FeedCloudMeta.StTagInfo>
{
  private FeedCloudMeta.StTagInfo a;
  private View container;
  private boolean isOwner;
  private ImageView mf;
  private TextView wp;
  private TextView wq;
  
  public QCircleFollowTagListItemView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.isOwner = paramBoolean;
  }
  
  public void a(FeedCloudMeta.StTagInfo paramStTagInfo, int paramInt)
  {
    if (paramStTagInfo == null) {
      return;
    }
    this.a = paramStTagInfo;
    if (!TextUtils.isEmpty(((FeedCloudMeta.StTagInfo)paramStTagInfo.get()).tagName.get())) {
      this.wp.setText(((FeedCloudMeta.StTagInfo)paramStTagInfo.get()).tagName.get());
    }
    this.wq.setText(String.format(getResources().getString(2131700112), new Object[] { String.valueOf(((FeedCloudMeta.StTagInfo)paramStTagInfo.get()).tagTotalUser.get()) }));
    if (this.isOwner)
    {
      if (((FeedCloudMeta.StTagInfo)paramStTagInfo.get()).isTop.get() == 1)
      {
        this.mf.setImageResource(2130844977);
        this.container.setBackgroundResource(2131166513);
        return;
      }
      this.mf.setImageResource(2130844979);
      this.container.setBackgroundResource(2131166512);
      return;
    }
    this.mf.setVisibility(8);
  }
  
  public void c(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    a(paramStTagInfo, -1);
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.wp = ((TextView)paramView.findViewById(2131367410));
    this.mf = ((ImageView)paramView.findViewById(2131367412));
    this.wq = ((TextView)paramView.findViewById(2131367411));
    this.container = paramView.findViewById(2131367409);
    this.mf.setOnClickListener(new pfr(this));
  }
  
  public int getLayoutId()
  {
    return 2131560913;
  }
  
  public void ru(boolean paramBoolean)
  {
    if (this.a == null)
    {
      QLog.e("QCircleFollowTagListItemView", 1, "follow tag failed! mTagInfo == null");
      return;
    }
    int i;
    Object localObject;
    if (paramBoolean)
    {
      i = 2;
      if (this.a != null)
      {
        ((FeedCloudMeta.StTagInfo)this.a.get()).followState.set(i);
        localObject = ((FeedCloudMeta.StTagInfo)this.a.get()).isTop;
        if (!paramBoolean) {
          break label135;
        }
      }
    }
    label135:
    for (int j = 1;; j = 0)
    {
      ((PBUInt32Field)localObject).set(j);
      rwv.a().a(new QCircleTopTagEvent(this.a, i));
      localObject = new QCircleDoFollowTagRequest(this.a.tagName.get(), i, null);
      VSNetworkHelper.a().a((VSBaseRequest)localObject, new pfs(this, paramBoolean));
      return;
      i = 3;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFollowTagListItemView
 * JD-Core Version:    0.7.0.1
 */