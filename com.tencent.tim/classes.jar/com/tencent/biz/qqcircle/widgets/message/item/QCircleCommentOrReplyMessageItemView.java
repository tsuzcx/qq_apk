package com.tencent.biz.qqcircle.widgets.message.item;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import feedcloud.FeedCloudMeta.StNotice;
import pio;

public class QCircleCommentOrReplyMessageItemView
  extends BaseWidgetView<FeedCloudMeta.StNotice>
{
  private pio a;
  
  public QCircleCommentOrReplyMessageItemView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice)
  {
    a(paramStNotice, -1);
  }
  
  public void a(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramStNotice, paramInt);
    }
  }
  
  public void e(Context paramContext, View paramView)
  {
    this.a = new pio(getViewType());
    this.a.g(paramContext, paramView);
  }
  
  public int getLayoutId()
  {
    return 2131560917;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.message.item.QCircleCommentOrReplyMessageItemView
 * JD-Core Version:    0.7.0.1
 */