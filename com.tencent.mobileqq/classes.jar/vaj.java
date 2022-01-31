import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.QQStoryFeedItemBuilder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map.Entry;

public class vaj
  implements View.OnClickListener
{
  public vaj(QQStoryFeedItemBuilder paramQQStoryFeedItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedItemBuilder", 2, "mClickListener.onClick: invoked. info: v: " + paramView);
    }
    paramView = (String)((Map.Entry)QQStoryFeedItemBuilder.a(this.a).get(0)).getKey();
    QQStoryFeedItemBuilder.a(this.a, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vaj
 * JD-Core Version:    0.7.0.1
 */