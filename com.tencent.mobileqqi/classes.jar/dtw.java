import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.adapter.TroopMessageSettingAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Map;

public class dtw
  extends FriendListObserver
{
  public dtw(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  protected void a(boolean paramBoolean, Map paramMap)
  {
    if (paramBoolean) {}
    do
    {
      return;
      this.a.jdField_a_of_type_JavaUtilMap = TroopAssistantManager.a().a(this.a.b, this.a.jdField_a_of_type_JavaUtilList);
    } while (this.a.jdField_a_of_type_JavaUtilMap == null);
    this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.a(this.a.jdField_a_of_type_JavaUtilMap);
    this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.notifyDataSetChanged();
    this.a.e();
    QQToast.a(this.a.a(), 2131562192, 0).b(this.a.d());
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.a.jdField_a_of_type_JavaUtilMap = TroopAssistantManager.a().a(this.a.b, this.a.jdField_a_of_type_JavaUtilList);
      if (this.a.jdField_a_of_type_JavaUtilMap != null) {}
    }
    else
    {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.a(this.a.jdField_a_of_type_JavaUtilMap);
    this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.notifyDataSetChanged();
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dtw
 * JD-Core Version:    0.7.0.1
 */