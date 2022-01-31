import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloPanelManager.PanelClickCallback;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class yvl
  implements ApolloPanelManager.PanelClickCallback
{
  public yvl(ApolloPanel paramApolloPanel) {}
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
    if (this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
    {
      if ((!paramBoolean2) || (paramInt >= 5)) {
        break label110;
      }
      this.a.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (!paramBoolean1) {
        break label94;
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      ThreadManager.getUIHandler().removeCallbacks(ApolloPanel.a(this.a));
    }
    label94:
    label110:
    do
    {
      do
      {
        ThreadManager.getUIHandler().postDelayed(ApolloPanel.a(this.a), 5000L);
        do
        {
          return;
        } while (paramInt <= 0);
        this.a.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        return;
        this.a.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      } while ((paramInt != 0) || (!paramBoolean1));
      this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a == null));
    ApolloPanel.a(this.a, this.a.jdField_b_of_type_AndroidWidgetLinearLayout, 51, this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.getString(2131438213), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yvl
 * JD-Core Version:    0.7.0.1
 */