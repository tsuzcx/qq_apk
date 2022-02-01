import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.QCallDetailActivity.1.1;
import com.tencent.mobileqq.qcall.QCallDetailActivity.1.2;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.Map;

public class alkh
  extends acfd
{
  public alkh(QCallDetailActivity paramQCallDetailActivity) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, QCallDetailActivity.a(this.this$0))))
    {
      QCallDetailActivity.a(this.this$0);
      this.this$0.runOnUiThread(new QCallDetailActivity.1.1(this));
    }
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCallDetailActivity", 2, " === onUpdateCustomHead isSuccess | " + paramBoolean + ", uin | " + paramString);
    }
    Object localObject;
    if ((paramBoolean) && (QCallDetailActivity.a(this.this$0) == 3000) && (!aqft.equalsWithNullCheck(paramString, this.this$0.app.getCurrentAccountUin())))
    {
      localObject = (acdu)this.this$0.app.getManager(53);
      if (localObject != null) {
        break label109;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QCallDetailActivity", 2, " === onUpdateCustomHead dm is null  ====");
      }
    }
    label109:
    do
    {
      do
      {
        return;
        if (((acdu)localObject).a(QCallDetailActivity.a(this.this$0)) != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("QCallDetailActivity", 2, " === onUpdateCustomHead info is null ====");
      return;
      if (TextUtils.isEmpty(paramString))
      {
        QLog.i("QCallDetailActivity", 1, " === onUpdateCustomHead uin is null ====");
        return;
      }
      localObject = ((acdu)localObject).n(QCallDetailActivity.a(this.this$0));
    } while ((localObject == null) || (((Map)localObject).size() <= 0) || (!((Map)localObject).containsKey(paramString)));
    this.this$0.Oo(QCallDetailActivity.a(this.this$0));
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if ((paramBoolean) && (QCallDetailActivity.a(this.this$0) == 3000))
    {
      localObject = (acdu)this.this$0.app.getManager(53);
      if (localObject != null) {
        break label52;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QCallDetailActivity", 2, " === onUpdateFriendInfo dm is null  ====");
      }
    }
    label52:
    do
    {
      DiscussionInfo localDiscussionInfo;
      do
      {
        return;
        localDiscussionInfo = ((acdu)localObject).a(QCallDetailActivity.a(this.this$0));
        if (localDiscussionInfo == null)
        {
          QLog.i("QCallDetailActivity", 1, " ===onUpdateFriendInfo info is null ====");
          return;
        }
        if (TextUtils.isEmpty(paramString))
        {
          QLog.i("QCallDetailActivity", 1, " === onUpdateFriendInfo uin is null ====");
          return;
        }
      } while (localDiscussionInfo.hasRenamed());
      localObject = ((acdu)localObject).n(QCallDetailActivity.a(this.this$0));
    } while ((localObject == null) || (((Map)localObject).size() <= 0) || (!((Map)localObject).containsKey(paramString)));
    this.this$0.Oo(QCallDetailActivity.a(this.this$0));
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    QCallDetailActivity.a(this.this$0);
    this.this$0.runOnUiThread(new QCallDetailActivity.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alkh
 * JD-Core Version:    0.7.0.1
 */