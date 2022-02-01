package com.tencent.biz.richframework.part.demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import java.util.ArrayList;
import rwv;
import rwx;
import rya;

public class DemoBaseWidgetView
  extends BaseWidgetView
  implements rwx
{
  public DemoBaseWidgetView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public void P(Object paramObject)
  {
    getExtraTypeInfo();
  }
  
  public void e(Context paramContext, View paramView)
  {
    VSNetworkHelper.a().a(getContext().hashCode(), new DemoBaseRequest(""), new rya(this));
  }
  
  public ArrayList<Class> getEventClass()
  {
    return null;
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    rwv.a().a(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    rwv.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.demo.DemoBaseWidgetView
 * JD-Core Version:    0.7.0.1
 */