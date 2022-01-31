import SummaryCard.RespSearch;
import SummaryCard.SearchInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.international.ServerPushStringMap;
import java.util.ArrayList;

public class bzh
  extends FriendListObserver
{
  public bzh(AddFriendActivity paramAddFriendActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject, int paramInt, String paramString)
  {
    this.a.b(this.a.jdField_b_of_type_ComTencentMobileqqAppFriendListObserver);
    AddFriendActivity.b(this.a);
    if ((!paramBoolean) || (paramInt != 0))
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramObject = (Integer)ServerPushStringMap.getInstance().get(paramString);
        if (paramObject != null)
        {
          paramObject = this.a.getString(paramObject.intValue());
          this.a.a(paramObject);
          return;
        }
        this.a.a(paramString);
        return;
      }
      this.a.a(2131562510);
      return;
    }
    paramObject = (RespSearch)paramObject;
    if ((paramObject.vRecords == null) || (paramObject.vRecords.isEmpty()))
    {
      this.a.a(2131563023);
      return;
    }
    if (paramObject.vRecords.size() == 1)
    {
      AddFriendActivity.a(this.a, (SearchInfo)paramObject.vRecords.get(0), this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramObject.vSecureSig);
      return;
    }
    this.a.a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bzh
 * JD-Core Version:    0.7.0.1
 */