import android.os.AsyncTask;
import com.tencent.mobileqq.search.ConversationSearchAdapter;
import com.tencent.mobileqq.search.ConversationSearchAdapter.SearchResultCallBack;
import com.tencent.mobileqq.search.ISearchable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class gmq
  extends AsyncTask
{
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList;
  
  public gmq(ConversationSearchAdapter paramConversationSearchAdapter, String paramString1, String paramString2, List paramList)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  protected Void a(Void... paramVarArgs)
  {
    ISearchable localISearchable;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      paramVarArgs = this.jdField_a_of_type_JavaUtilList.iterator();
      if (paramVarArgs.hasNext())
      {
        localISearchable = (ISearchable)paramVarArgs.next();
        if (!isCancelled()) {}
      }
      else
      {
        if (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))
        {
          paramVarArgs = this.jdField_b_of_type_JavaUtilList.iterator();
          label68:
          if (paramVarArgs.hasNext())
          {
            localISearchable = (ISearchable)paramVarArgs.next();
            if (!isCancelled()) {
              break label227;
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchConversationSearchAdapter.b(this.jdField_b_of_type_JavaUtilList);
      }
    }
    for (this.jdField_a_of_type_ComTencentMobileqqSearchConversationSearchAdapter.a = false;; this.jdField_a_of_type_ComTencentMobileqqSearchConversationSearchAdapter.a = true)
    {
      return null;
      localISearchable.a(this.jdField_a_of_type_JavaLangString);
      if (localISearchable.a() == -9223372036854775808L) {
        break;
      }
      if (!this.jdField_b_of_type_JavaUtilList.contains(localISearchable))
      {
        this.jdField_b_of_type_JavaUtilList.add(localISearchable);
        break;
      }
      int i = this.jdField_b_of_type_JavaUtilList.indexOf(localISearchable);
      if (((ISearchable)this.jdField_b_of_type_JavaUtilList.get(i)).a() >= localISearchable.a()) {
        break;
      }
      this.jdField_b_of_type_JavaUtilList.set(i, localISearchable);
      break;
      label227:
      long l = localISearchable.a();
      localISearchable.a(this.jdField_b_of_type_JavaLangString);
      if (localISearchable.a() != -9223372036854775808L) {
        break label68;
      }
      localISearchable.a(l);
      break label68;
    }
  }
  
  protected void a(Void paramVoid)
  {
    ConversationSearchAdapter.a(this.jdField_a_of_type_ComTencentMobileqqSearchConversationSearchAdapter).clear();
    ConversationSearchAdapter.a(this.jdField_a_of_type_ComTencentMobileqqSearchConversationSearchAdapter).addAll(this.jdField_b_of_type_JavaUtilList);
    this.jdField_b_of_type_JavaUtilList.clear();
    if (ConversationSearchAdapter.a(this.jdField_a_of_type_ComTencentMobileqqSearchConversationSearchAdapter) != null)
    {
      int i = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqSearchConversationSearchAdapter.a) {
        i = 0;
      }
      ConversationSearchAdapter.a(this.jdField_a_of_type_ComTencentMobileqqSearchConversationSearchAdapter).a(i);
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchConversationSearchAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gmq
 * JD-Core Version:    0.7.0.1
 */