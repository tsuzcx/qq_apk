import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;

public class vzk
  extends acfd
{
  public vzk(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (!aqft.equalsWithNullCheck(paramString, this.this$0.a.troopowneruin))) {}
    String str;
    do
    {
      return;
      this.this$0.baZ = false;
      str = aqgv.A(this.this$0.app, this.this$0.a.troopowneruin);
      if (!TextUtils.isEmpty(str))
      {
        this.this$0.a.troopOwnerNick = str;
        this.this$0.handler.sendEmptyMessage(2);
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.troopinfo", 2, "onUpdateFriendInfo|uin = " + paramString + ", tmpNickName = " + str);
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (aqft.equalsWithNullCheck(paramString, this.this$0.a.troopUin))) {
      this.this$0.handler.sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vzk
 * JD-Core Version:    0.7.0.1
 */