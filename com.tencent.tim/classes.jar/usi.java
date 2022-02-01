import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class usi
  extends acnd
{
  public usi(Conversation paramConversation) {}
  
  protected void H(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.this$0.n(8, paramString, 1);
      this.this$0.n(8, acbn.bkz, 5000);
      this.this$0.n(8, acbn.blI, 5001);
    }
  }
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.this$0.n(8, acbn.bkz, 5000);
      this.this$0.n(8, acbn.blI, 5001);
      if (paramTroopInfo != null) {
        this.this$0.n(8, paramTroopInfo.troopuin, 1);
      }
    }
  }
  
  protected void a(boolean paramBoolean1, ArrayList<TroopMemberCardInfo> paramArrayList, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (TroopMemberCardInfo)paramArrayList.get(0);
      if (paramArrayList != null)
      {
        this.this$0.n(8, paramArrayList.troopuin, 1);
        this.this$0.n(8, paramArrayList.memberuin, -2147483648);
        this.this$0.n(8, acbn.bkz, 5000);
        this.this$0.n(8, acbn.blI, 5001);
      }
    }
  }
  
  protected void di(String paramString1, String paramString2)
  {
    this.this$0.n(8, paramString1, 1);
  }
  
  protected void dj(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString2.equals(this.this$0.app.getCurrentAccountUin()))) {
      this.this$0.n(8, paramString1, 1);
    }
  }
  
  protected void jc(boolean paramBoolean)
  {
    aizp.a().di(this.this$0.app);
  }
  
  protected void onUpdateRecentList()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.this$0.fI(0L);
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6) {
      if (paramInt2 == 0)
      {
        aizp.a().di(this.this$0.app);
        this.this$0.n(8, paramString, 1);
        this.this$0.n(8, acbn.bkz, 5000);
        this.this$0.n(8, acbn.blI, 5001);
      }
    }
    while ((paramInt1 != 2) || (paramInt2 != 0)) {
      return;
    }
    aizp.a().k(paramString, this.this$0.app);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_ontroopmanagersuccess");
    }
    this.this$0.n(8, paramString, 1);
    this.this$0.n(8, acbn.bkz, 5000);
    this.this$0.n(8, acbn.blI, 5001);
  }
  
  protected void v(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "Conversation.onGetTroopMemberCard isSuccess=" + paramBoolean + " data=" + paramObject);
    }
    if ((paramBoolean) && (paramObject != null))
    {
      long l = ((Long)((Object[])(Object[])paramObject)[0]).longValue();
      this.this$0.n(8, String.valueOf(l), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     usi
 * JD-Core Version:    0.7.0.1
 */