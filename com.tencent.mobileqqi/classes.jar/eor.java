import android.view.View;
import android.widget.Adapter;
import com.tencent.mobileqq.activity.recent.LocalSearchBar;
import com.tencent.mobileqq.activity.recent.OnRecentUserOpsListener;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class eor
  implements AdapterView.OnItemClickListener
{
  private long jdField_a_of_type_Long = 0L;
  
  public eor(LocalSearchBar paramLocalSearchBar) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramLong = System.currentTimeMillis();
    long l = Math.abs(paramLong - this.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onItemClick() gap = " + l);
    }
    if (l < 250L) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "onItemClick() 点击太快了吧， pos = " + paramInt);
      }
    }
    label189:
    for (;;)
    {
      return;
      this.jdField_a_of_type_Long = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "onItemClick() pos = " + paramInt);
      }
      paramAdapterView = paramAdapterView.a();
      if (paramAdapterView == null) {}
      for (paramAdapterView = null;; paramAdapterView = paramAdapterView.getItem(paramInt))
      {
        if (!(paramAdapterView instanceof ContactsSearchableRecentUser)) {
          break label189;
        }
        paramAdapterView = (ContactsSearchableRecentUser)paramAdapterView;
        if (LocalSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar) == null) {
          break;
        }
        LocalSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentLocalSearchBar).a(paramView, paramAdapterView, paramAdapterView.c(), false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eor
 * JD-Core Version:    0.7.0.1
 */