import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.SearchResultDialog.HistoryListChangeListener;
import com.tencent.mobileqq.adapter.ContactsSearchResultAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.search.ContactSearchableSearchHistory;
import com.tencent.mobileqq.search.IContactSearchable;

public class exw
  implements View.OnClickListener
{
  public exw(ContactsSearchResultAdapter paramContactsSearchResultAdapter, IContactSearchable paramIContactSearchable) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchIContactSearchable instanceof ContactSearchableSearchHistory))
    {
      paramView = (SearchHistoryManager)ContactsSearchResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter).getManager(50);
      ContactSearchableSearchHistory localContactSearchableSearchHistory = (ContactSearchableSearchHistory)this.jdField_a_of_type_ComTencentMobileqqSearchIContactSearchable;
      if (paramView != null)
      {
        paramView.a(localContactSearchableSearchHistory.e());
        this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqSearchIContactSearchable);
        this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.notifyDataSetChanged();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter.getCount() == 0) && (ContactsSearchResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter) != null)) {
        ContactsSearchResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterContactsSearchResultAdapter).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     exw
 * JD-Core Version:    0.7.0.1
 */