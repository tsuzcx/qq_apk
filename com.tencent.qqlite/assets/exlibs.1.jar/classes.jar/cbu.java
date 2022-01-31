import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade;
import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade.ISearchListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResult;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class cbu
  extends FriendListObserver
{
  public cbu(ContactSearchFacade paramContactSearchFacade) {}
  
  protected void a(boolean paramBoolean, int paramInt1, Object paramObject, int paramInt2, String paramString)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d(ContactSearchFacade.a, 2, "onSearchFriendResult  searchType = " + paramInt1 + " isSuccess = " + paramBoolean);
    }
    this.a.b();
    Object localObject;
    if (paramInt1 == 86) {
      if (ContactSearchFacade.a(this.a) != null)
      {
        localObject = ContactSearchFacade.a(this.a);
        if (i == 0) {
          break label203;
        }
      }
    }
    for (;;)
    {
      ((ContactSearchFacade.ISearchListener)localObject).a(paramInt1, paramBoolean, paramObject, paramInt2, paramString);
      return;
      if (paramInt1 == 87)
      {
        if (paramBoolean)
        {
          localObject = (ArrayList)paramObject;
          if ((localObject != null) && (ContactSearchFacade.a(this.a) != 80000002) && (((ArrayList)localObject).size() == 1)) {
            ContactSearchFacade.a(this.a, ((SearchResult)((ArrayList)localObject).get(0)).b);
          }
          i = 0;
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d(ContactSearchFacade.a, 2, "search failed error msg = " + paramString);
        }
      }
      i = 0;
      break;
      label203:
      paramInt1 = ContactSearchFacade.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbu
 * JD-Core Version:    0.7.0.1
 */