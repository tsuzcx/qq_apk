import android.view.View;
import android.widget.Adapter;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.search.ContactsSearchableRecentUser;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class ahg
  implements AdapterView.OnItemClickListener
{
  private long jdField_a_of_type_Long = 0L;
  
  public ahg(Conversation paramConversation) {}
  
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
    for (;;)
    {
      return;
      this.jdField_a_of_type_Long = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "onItemClick() pos = " + paramInt);
      }
      paramAdapterView = paramAdapterView.a();
      if (paramAdapterView == null) {}
      for (paramAdapterView = null; (paramAdapterView instanceof ContactsSearchableRecentUser); paramAdapterView = paramAdapterView.getItem(paramInt))
      {
        paramAdapterView = (ContactsSearchableRecentUser)paramAdapterView;
        this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a(paramView, paramAdapterView, paramAdapterView.a(), false);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ahg
 * JD-Core Version:    0.7.0.1
 */