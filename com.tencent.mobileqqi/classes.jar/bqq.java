import android.widget.TextView;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantActivity;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import java.util.List;

public class bqq
  implements Runnable
{
  public bqq(PubAccountAssistantActivity paramPubAccountAssistantActivity, List paramList) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantActivity.b) {
      PubAccountAssistantActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantActivity).setVisibility(0);
    }
    RecentAdapter localRecentAdapter;
    if (PubAccountAssistantActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantActivity) != null)
    {
      localRecentAdapter = PubAccountAssistantActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantActivity);
      if (!this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantActivity.b) {
        break label89;
      }
    }
    label89:
    for (int i = 8;; i = 9)
    {
      localRecentAdapter.a(i);
      PubAccountAssistantActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantActivity).a(this.jdField_a_of_type_JavaUtilList);
      PubAccountAssistantActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantActivity).notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantActivity.a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bqq
 * JD-Core Version:    0.7.0.1
 */