import SummaryCard.RespSearch;
import SummaryCard.SearchInfo;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.eqq.EnterpriseDetailActivity;
import com.tencent.mobileqq.activity.AddContactsActivity;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.international.ServerPushStringMap;
import java.util.ArrayList;

public class bth
  extends FriendListObserver
{
  public bth(AddContactsActivity paramAddContactsActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject, int paramInt, String paramString)
  {
    this.a.b(this.a.a);
    this.a.b();
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
      this.a.a(this.a.getString(2131562510));
      return;
    }
    paramString = (RespSearch)paramObject;
    if ((paramString.vRecords == null) || (paramString.vRecords.isEmpty()))
    {
      this.a.a(this.a.getString(2131563023));
      return;
    }
    if (paramString.vRecords.size() == 1)
    {
      paramObject = (SearchInfo)paramString.vRecords.get(0);
      if (paramObject.bIsEnterpriseQQ == 0)
      {
        AddFriendActivity.a(this.a, (SearchInfo)paramString.vRecords.get(0), this.a.b.a(), paramString.vSecureSig);
        return;
      }
      paramString = new Intent(this.a, EnterpriseDetailActivity.class);
      paramString.putExtra("uin", String.valueOf(paramObject.lUIN));
      this.a.startActivity(paramString);
      return;
    }
    this.a.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bth
 * JD-Core Version:    0.7.0.1
 */