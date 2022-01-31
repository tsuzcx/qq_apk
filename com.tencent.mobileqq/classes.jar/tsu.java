import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.adapter.TroopMessageSettingAdapter;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.widget.QQToast;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class tsu
  extends FriendListObserver
{
  public tsu(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  protected void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter == null) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean1);
      this.a.jdField_a_of_type_JavaUtilMap = TroopAssistantManager.a().a(this.a.app, this.a.jdField_a_of_type_JavaUtilList);
    } while (this.a.jdField_a_of_type_JavaUtilMap == null);
    this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.a(this.a.jdField_a_of_type_JavaUtilMap);
    this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.notifyDataSetChanged();
    this.a.b();
  }
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map paramMap)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter == null) {
      return;
    }
    if ((paramBoolean) && (paramMap != null))
    {
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Integer localInteger = (Integer)paramMap.get(str);
        if (localInteger != null) {
          this.a.jdField_a_of_type_JavaUtilMap.put(str, localInteger);
        }
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.a(this.a.jdField_a_of_type_JavaUtilMap);
      this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.notifyDataSetChanged();
      this.a.b();
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAdapterTroopMessageSettingAdapter.notifyDataSetChanged();
    this.a.b();
    QQToast.a(this.a.app.getApp(), 1, this.a.getString(2131434497), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tsu
 * JD-Core Version:    0.7.0.1
 */