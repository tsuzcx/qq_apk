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
import cooperation.qzone.QzoneIPCModule;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class vfe
  extends vbk
  implements aaam, View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  
  public vfe(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = paramStUser;
  }
  
  private void a(QCirclePublishBoxStatusEvent paramQCirclePublishBoxStatusEvent)
  {
    ThreadManager.getUIHandler().post(new QCirclePublishStatusBoxPart.1(this, paramQCirclePublishBoxStatusEvent));
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public String a()
  {
    return "QCirclePushFeedPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131374030);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374029));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374027));
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePublishBoxStatusEvent.class);
    return localArrayList;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    aaak.a().b(this);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    aaak.a().a(this);
    QzoneIPCModule.a().a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131374030)
    {
      vtq.a("", 16, 2, 0, c());
      Intent localIntent = new Intent();
      localIntent.putExtra("key_type_queue", 3);
      bmtk localbmtk = bmtk.a();
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        localbmtk.b = ((QQAppInterface)localObject).getCurrentNickname();
        localbmtk.a = ((QQAppInterface)localObject).c();
      }
      bmtd.c(a(), localbmtk, localIntent, -1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfe
 * JD-Core Version:    0.7.0.1
 */