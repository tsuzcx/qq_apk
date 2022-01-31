import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import java.util.List;

public class era
  extends Handler
{
  public era(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          this.a.jdField_a_of_type_AndroidWidgetHorizontalScrollView.scrollTo(this.a.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams().width, 0);
          return;
        } while ((this.a.jdField_a_of_type_AndroidAppDialog == null) || (!this.a.jdField_a_of_type_AndroidAppDialog.isShowing()));
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.getString(2131562247));
        this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837960);
        postDelayed(new erb(this), 1500L);
        return;
      } while ((this.a.jdField_a_of_type_AndroidAppDialog == null) || (!this.a.jdField_a_of_type_AndroidAppDialog.isShowing()));
      String str = (String)paramMessage.obj;
      paramMessage = str;
      if (str == null) {
        paramMessage = this.a.getString(2131562090);
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837949);
      postDelayed(new erc(this), 1500L);
      return;
      paramMessage = (List)paramMessage.obj;
    } while ((paramMessage == null) || (SelectMemberActivity.a(this.a) == null));
    SelectMemberActivity.a(this.a).a(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     era
 * JD-Core Version:    0.7.0.1
 */