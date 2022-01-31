import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.NotificationAdapter;
import com.tencent.mobileqq.activity.contact.troop.NotificationAdapter.ViewHolder;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.List;

public class wki
  implements View.OnClickListener
{
  public wki(NotificationAdapter paramNotificationAdapter) {}
  
  public void onClick(View paramView)
  {
    NotificationAdapter.ViewHolder localViewHolder = (NotificationAdapter.ViewHolder)paramView.getTag();
    if ((localViewHolder == null) || (!(localViewHolder instanceof NotificationAdapter.ViewHolder))) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
    paramView = (View)paramView.getParent();
    if ((paramView instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)paramView).d();
    }
    NotificationAdapter.a(this.a, localViewHolder.a);
    this.a.jdField_a_of_type_JavaUtilList.add(NotificationAdapter.a(this.a).remove(this.a.getCount() - localViewHolder.b - 1));
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wki
 * JD-Core Version:    0.7.0.1
 */