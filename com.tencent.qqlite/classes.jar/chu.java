import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.phone.ContactListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.search.ContactsSearchablePhoneContact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class chu
  extends SearchResultDialog
{
  public chu(ContactListView paramContactListView, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, ForwardOperations paramForwardOperations)
  {
    super(paramContext, paramQQAppInterface, paramInt, paramForwardOperations);
  }
  
  @SuppressLint({"UseSparseArrays"})
  protected List a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new ArrayList();
    if ((this.a.jdField_a_of_type_Int == 0) || (this.a.jdField_a_of_type_Int == 2)) {
      if (this.a.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext()) {
          ((ArrayList)localObject).addAll((List)localIterator.next());
        }
      }
    }
    for (;;)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(new ContactsSearchablePhoneContact(paramContext, paramQQAppInterface, (PhoneContact)((Iterator)localObject).next(), 30064771072L));
      }
      if ((this.a.jdField_a_of_type_Int == 3) && (this.a.b != null)) {
        ((ArrayList)localObject).addAll(this.a.b);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     chu
 * JD-Core Version:    0.7.0.1
 */