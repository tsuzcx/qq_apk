import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;

public class ckf
  implements View.OnClickListener
{
  public ckf(EmosmActivity paramEmosmActivity) {}
  
  public void onClick(View paramView)
  {
    EmosmActivity.b(this.a).setVisibility(0);
    EmosmActivity.c(this.a).setEnabled(false);
    if (!this.a.jdField_b_of_type_Boolean)
    {
      EmosmActivity.a(this.a).setVisibility(8);
      EmosmActivity.a(this.a).setDragEnabled(true);
      EmosmActivity.a(this.a).setEditMode(true);
      this.a.jdField_b_of_type_Boolean = true;
      EmosmActivity.a(this.a).notifyDataSetChanged();
      EmosmActivity.a(this.a).setVisibility(8);
      EmosmActivity.a(this.a).setEnabled(false);
      StatisticAssist.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), "Clk_ep_edit");
    }
    do
    {
      return;
      if (EmosmActivity.d(this.a) == 2)
      {
        EmosmActivity.a(this.a).setVisibility(8);
        EmosmActivity.a(this.a).setDragEnabled(false);
        EmosmActivity.a(this.a).setEditMode(false);
        this.a.a();
        this.a.jdField_b_of_type_Boolean = false;
        EmosmActivity.a(this.a).notifyDataSetChanged();
        EmosmActivity.a(this.a).clearSelectStatus();
        EmosmActivity.a(this.a).setVisibility(8);
        return;
      }
    } while (EmosmActivity.d(this.a) != 1);
    EmosmActivity.a(this.a).clearSelectStatus();
    this.a.a();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ckf
 * JD-Core Version:    0.7.0.1
 */