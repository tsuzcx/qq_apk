import android.view.View;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.open.agent.OpenCardContainer;
import com.tencent.open.agent.OpenCardContainer.e;
import com.tencent.open.agent.OpenCardContainer.f;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import java.util.Iterator;
import java.util.List;

public class arrx
  implements AdapterView.c
{
  public arrx(OpenCardContainer paramOpenCardContainer) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = OpenCardContainer.e.a(this.this$0.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$e).iterator();
    while (paramAdapterView.hasNext()) {
      ((OpenCardContainer.f)paramAdapterView.next()).dcU = false;
    }
    ((OpenCardContainer.f)OpenCardContainer.e.a(this.this$0.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$e).get(paramInt)).dcU = true;
    this.this$0.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(false);
    this.this$0.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$e.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arrx
 * JD-Core Version:    0.7.0.1
 */