import SummaryCard.RespSearch;
import SummaryCard.SearchInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.contact.addcontact.ContactSearchFacade.ISearchListener;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class wf
  implements ContactSearchFacade.ISearchListener
{
  public wf(AddFriendActivity paramAddFriendActivity) {}
  
  public void a(int paramInt1, boolean paramBoolean, Object paramObject, int paramInt2, String paramString)
  {
    AddFriendActivity.b(this.a);
    if ((!paramBoolean) || (paramInt2 != 0))
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.a.a(paramString);
        return;
      }
      this.a.a(2131363380);
      return;
    }
    paramObject = (RespSearch)paramObject;
    if ((paramObject.vRecords == null) || (paramObject.vRecords.isEmpty()))
    {
      this.a.a(2131363505);
      return;
    }
    if (paramObject.vRecords.size() == 1)
    {
      AddFriendActivity.a(this.a, (SearchInfo)paramObject.vRecords.get(0), this.a.app.a(), paramObject.vSecureSig, false);
      return;
    }
    this.a.a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     wf
 * JD-Core Version:    0.7.0.1
 */