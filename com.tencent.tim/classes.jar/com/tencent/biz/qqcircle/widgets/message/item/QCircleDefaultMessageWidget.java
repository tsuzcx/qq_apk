package com.tencent.biz.qqcircle.widgets.message.item;

import android.content.Context;
import android.view.View;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import feedcloud.FeedCloudMeta.StNotice;
import pii;
import pik;
import pin;
import pit;

public class QCircleDefaultMessageWidget
  extends BaseWidgetView<FeedCloudMeta.StNotice>
{
  private pii a;
  
  public QCircleDefaultMessageWidget(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void S(Context paramContext, int paramInt)
  {
    this.a = a(paramInt);
  }
  
  protected pii a(int paramInt)
  {
    if (paramInt == 3) {
      return new pit(paramInt);
    }
    if ((paramInt == 7) || (paramInt == 6)) {
      return new pin(paramInt);
    }
    return new pik(paramInt);
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
    if (this.a != null) {
      this.a.g(paramContext, paramView);
    }
  }
  
  public int getLayoutId()
  {
    return 2131560918;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.message.item.QCircleDefaultMessageWidget
 * JD-Core Version:    0.7.0.1
 */