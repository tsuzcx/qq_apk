import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade;
import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade.ISearchListener;
import com.tencent.mobileqq.activity.contact.addcontact.SearchResult;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class wnr
  extends FriendListObserver
{
  public wnr(ContactSearchFacade paramContactSearchFacade) {}
  
  protected void onSearchFriendResult(boolean paramBoolean1, int paramInt1, Object paramObject, int paramInt2, String paramString, boolean paramBoolean2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ContactSearchFacade.a, 2, "onSearchFriendResult  searchType = " + paramInt1 + " isSuccess = " + paramBoolean1);
    }
    int i;
    if (paramInt1 == 87)
    {
      this.a.b();
      i = 1;
    }
    for (;;)
    {
      Object localObject;
      if (ContactSearchFacade.a(this.a) != null)
      {
        localObject = ContactSearchFacade.a(this.a);
        if (i != 0) {
          label81:
          ((ContactSearchFacade.ISearchListener)localObject).a(paramInt1, paramBoolean1, paramObject, paramInt2, paramString);
        }
      }
      else
      {
        label95:
        do
        {
          do
          {
            return;
            if (paramInt1 != 88) {
              break;
            }
          } while (paramLong != ContactSearchFacade.a(this.a));
          this.a.b();
          if (paramBoolean2) {
            break;
          }
        } while (ContactSearchFacade.a(this.a) == null);
        ContactSearchFacade.a(this.a).a(ContactSearchFacade.a(this.a), paramBoolean1, new ArrayList(), paramInt2, paramString);
        return;
        if (!paramBoolean1) {}
      }
      for (;;)
      {
        try
        {
          localObject = (ArrayList)paramObject;
          if ((localObject != null) && (ContactSearchFacade.a(this.a) != 80000005) && (((ArrayList)localObject).size() == 1)) {
            ContactSearchFacade.a(this.a, ((SearchResult)((ArrayList)localObject).get(0)).jdField_b_of_type_Int);
          }
          if ((localObject == null) || (((ArrayList)localObject).size() < 1)) {
            break label582;
          }
          localObject = ((ArrayList)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label570;
          }
          SearchResult localSearchResult = (SearchResult)((Iterator)localObject).next();
          if (localSearchResult.a != 80000003) {
            continue;
          }
          i = 0;
          if (i >= localSearchResult.jdField_b_of_type_JavaUtilList.size()) {
            break label576;
          }
          ((AccountSearchPb.record)localSearchResult.jdField_b_of_type_JavaUtilList.get(i)).number.set(i + 1);
          i += 1;
          continue;
          if (i == 0) {
            break label582;
          }
          if (ContactSearchFacade.a(this.a) != 80000005) {
            PublicAccountReportUtils.a(ContactSearchFacade.a(this.a), "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D96", "0X8005D96", 0, 0, ContactSearchFacade.b(this.a) + "", "", this.a.b, "", false);
          } else {
            PublicAccountReportUtils.a(ContactSearchFacade.a(this.a), "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D94", "0X8005D94", 0, 0, "", "", this.a.b, "", false);
          }
        }
        catch (Exception paramObject)
        {
          if (QLog.isColorLevel()) {
            QLog.e(ContactSearchFacade.a, 2, "", paramObject);
          }
        }
        if (ContactSearchFacade.a(this.a) == null) {
          break label95;
        }
        ContactSearchFacade.a(this.a).a(ContactSearchFacade.a(this.a), paramBoolean1, new ArrayList(), paramInt2, paramString);
        return;
        if (QLog.isColorLevel())
        {
          QLog.d(ContactSearchFacade.a, 2, "search failed error msg = " + paramString);
          i = 0;
          break;
          this.a.b();
        }
        i = 0;
        break;
        paramInt1 = ContactSearchFacade.a(this.a);
        break label81;
        label570:
        i = 0;
        continue;
        label576:
        i = 1;
      }
      label582:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wnr
 * JD-Core Version:    0.7.0.1
 */