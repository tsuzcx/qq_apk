import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.bizparts.QCirclePublishStatusBoxPart.1;
import com.tencent.biz.qqcircle.events.QCirclePublishBoxStatusEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class oxg
  extends rxk
  implements View.OnClickListener, rwx
{
  private FeedCloudMeta.StUser a;
  private ImageView lU;
  private View nO;
  private TextView vV;
  
  public oxg(FeedCloudMeta.StUser paramStUser)
  {
    this.a = paramStUser;
  }
  
  private void a(QCirclePublishBoxStatusEvent paramQCirclePublishBoxStatusEvent)
  {
    ThreadManager.getUIHandler().post(new QCirclePublishStatusBoxPart.1(this, paramQCirclePublishBoxStatusEvent));
  }
  
  private void qs(String paramString)
  {
    if (this.vV != null) {
      this.vV.setText(paramString);
    }
  }
  
  public void dC(View paramView)
  {
    super.dC(paramView);
    if (paramView != null)
    {
      this.nO = paramView.findViewById(2131374583);
      this.nO.setOnClickListener(this);
      this.vV = ((TextView)this.nO.findViewById(2131374582));
      this.lU = ((ImageView)this.nO.findViewById(2131374581));
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePublishBoxStatusEvent.class);
    return localArrayList;
  }
  
  public String getLogTag()
  {
    return "QCirclePushFeedPart";
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    rwv.a().b(this);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    rwv.a().a(this);
    avre.a().eBI();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131374583)
    {
      pco.h("", 16, 2L);
      Intent localIntent = new Intent();
      localIntent.putExtra("key_type_queue", 3);
      avpw.d locald = avpw.d.a();
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        locald.nickname = ((QQAppInterface)localObject).getCurrentNickname();
        locald.cMP = ((QQAppInterface)localObject).getCurrentUin();
      }
      avpw.c(getActivity(), locald, localIntent, -1);
      QLog.d("QCirclePushFeedPart", 4, "click publish enter");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCirclePublishBoxStatusEvent)) {
      a((QCirclePublishBoxStatusEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oxg
 * JD-Core Version:    0.7.0.1
 */