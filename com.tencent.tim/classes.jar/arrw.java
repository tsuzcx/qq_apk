import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.open.agent.OpenCardContainer.e;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arrw
  implements View.OnClickListener
{
  public arrw(OpenCardContainer paramOpenCardContainer) {}
  
  public void onClick(View paramView)
  {
    this.this$0.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(true);
    this.this$0.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$e.els();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arrw
 * JD-Core Version:    0.7.0.1
 */