import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.bizparts.QCirclePushToastPart.1;
import com.tencent.biz.qqcircle.events.QCirclePushToastEvent;
import com.tencent.biz.qqcircle.widgets.QCirclePushToastView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudToastshowsvr.StGetToastDetailRsp;
import feedcloud.FeedCloudToastshowsvr.StToast;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class vff
  extends vbk
  implements aaam
{
  private QCirclePushToastView a;
  
  public String a()
  {
    return "QCirclePushToastPart";
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    this.a = ((QCirclePushToastView)paramView.findViewById(2131373269));
    aaak.a().a(this);
    aadv.a("https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf");
    aadv.a("https://downv6.qq.com/video_story/qcircle/ttf/qcircle_number_bold_italic.ttf");
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if ((TextUtils.equals(paramString, "tab_changed")) && (this.a != null)) {
      this.a.c();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePushToastEvent.class);
    return localArrayList;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    aaak.a().b(this);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
    if (this.a != null) {
      this.a.c();
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCirclePushToastEvent))
    {
      paramSimpleBaseEvent = (QCirclePushToastEvent)paramSimpleBaseEvent;
      QLog.d("QCirclePushToastPart", 2, "onReceivePushToastEvent: " + paramSimpleBaseEvent.mData);
      if ((paramSimpleBaseEvent.mData != null) && (this.a != null))
      {
        paramSimpleBaseEvent = (FeedCloudToastshowsvr.StToast)paramSimpleBaseEvent.mData.toastInfo.get();
        if (paramSimpleBaseEvent == null) {
          break label89;
        }
        ThreadManager.getUIHandler().post(new QCirclePushToastPart.1(this, paramSimpleBaseEvent));
      }
    }
    return;
    label89:
    QLog.d("QCirclePushToastPart", 2, "onReceivePushToastEvent, not show toast because of stToast is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vff
 * JD-Core Version:    0.7.0.1
 */