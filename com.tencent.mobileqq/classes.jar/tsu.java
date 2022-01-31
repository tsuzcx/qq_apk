import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.bizparts.QCirclePushFeedPart.1;
import com.tencent.biz.qqcircle.events.QCirclePublishBoxStatusEvent;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class tsu
  extends tvg
  implements View.OnClickListener, yel
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FeedCloudMeta.StUser jdField_a_of_type_FeedcloudFeedCloudMeta$StUser;
  
  public tsu(FeedCloudMeta.StUser paramStUser)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StUser = paramStUser;
  }
  
  private void a(QCirclePublishBoxStatusEvent paramQCirclePublishBoxStatusEvent)
  {
    ThreadManager.getUIHandler().post(new QCirclePushFeedPart.1(this, paramQCirclePublishBoxStatusEvent));
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCirclePublishBoxStatusEvent.class);
    return localArrayList;
  }
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131373182);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373181));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373180));
    }
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCirclePublishBoxStatusEvent)) {
      a((QCirclePublishBoxStatusEvent)paramSimpleBaseEvent);
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    yej.a().b(this);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    yej.a().a(this);
    bjbk.a().a();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131373182)
    {
      tyj.a("", 16, 2L);
      paramView = new Intent();
      paramView.putExtra("key_type_queue", 3);
      bizt localbizt = bizt.a();
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        localbizt.b = ((QQAppInterface)localObject).getCurrentNickname();
        localbizt.a = ((QQAppInterface)localObject).c();
      }
      bizm.c(a(), localbizt, paramView, -1);
      QLog.d("QCirclePushFeedPart", 4, "click publish enter");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tsu
 * JD-Core Version:    0.7.0.1
 */