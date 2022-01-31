import android.os.AsyncTask;
import com.tencent.mobileqq.adapter.BaseSearchResultAdapter;
import com.tencent.mobileqq.search.ConversationSearchAdapter.SearchResultCallBack;
import com.tencent.mobileqq.search.ISearchable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class exl
  extends AsyncTask
{
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList;
  
  public exl(BaseSearchResultAdapter paramBaseSearchResultAdapter, String paramString1, String paramString2, List paramList)
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
              break label226;
            }
          }
        }
        Collections.sort(this.jdField_b_of_type_JavaUtilList, BaseSearchResultAdapter.a());
      }
    }
    for (this.jdField_a_of_type_ComTencentMobileqqAdapterBaseSearchResultAdapter.jdField_a_of_type_Boolean = false;; this.jdField_a_of_type_ComTencentMobileqqAdapterBaseSearchResultAdapter.jdField_a_of_type_Boolean = true)
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
      label226:
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
    BaseSearchResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterBaseSearchResultAdapter).clear();
    BaseSearchResultAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterBaseSearchResultAdapter).addAll(this.jdField_b_of_type_JavaUtilList);
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterBaseSearchResultAdapter.jdField_a_of_type_ComTencentMobileqqSearchConversationSearchAdapter$SearchResultCallBack != null)
    {
      int i = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqAdapterBaseSearchResultAdapter.jdField_a_of_type_Boolean) {
        i = 0;
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterBaseSearchResultAdapter.jdField_a_of_type_ComTencentMobileqqSearchConversationSearchAdapter$SearchResultCallBack.a(i);
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterBaseSearchResultAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     exl
 * JD-Core Version:    0.7.0.1
 */