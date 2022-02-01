import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class uql
  extends accd
{
  public uql(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    boolean bool = true;
    super.a(paramBoolean, paramString1, paramString2, paramString3, paramInt);
    if (TextUtils.equals(this.this$0.a.troopUin, paramString1))
    {
      this.this$0.ath();
      if (!paramBoolean) {
        break label171;
      }
      this.this$0.a.hasSetNewTroopName = true;
      this.this$0.vs(paramString2);
      if ((this.this$0.isResume()) && (this.this$0.aUp))
      {
        this.this$0.b.isNewTroop = false;
        apuh.a(this.this$0.app, this.this$0.b, this.this$0, new uqm(this));
        this.this$0.aUp = false;
      }
      paramString1 = this.this$0;
      if ((this.this$0.aUo) || (this.this$0.a.isNewTroop)) {
        break label166;
      }
      paramBoolean = bool;
      ChatSettingForTroop.b(paramString1, paramBoolean);
    }
    label166:
    label171:
    do
    {
      return;
      paramBoolean = false;
      break;
      if (paramInt == 1328) {
        ChatSettingForTroop.n(this.this$0);
      }
      paramString1 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        paramString1 = acfp.m(2131703763);
      }
      QQToast.a(this.this$0, 1, paramString1, 0).show(this.this$0.getTitleBarHeight());
      if (this.this$0.b != null)
      {
        this.this$0.a.troopName = this.this$0.b.getTroopName();
        this.this$0.bLc();
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.chatopttroop", 2, paramString1);
  }
  
  protected void c(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if ((paramInt2 != 0) && (TextUtils.equals(this.this$0.a.troopUin, paramString1)))
    {
      if ((!this.this$0.isFinishing()) && (this.this$0.isResume()))
      {
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramString1 = this.this$0.getResources().getString(2131696690);
        }
        QQToast.a(this.this$0, 1, paramString1, 0).show(this.this$0.getTitleBarHeight());
      }
      ChatSettingForTroop.m(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uql
 * JD-Core Version:    0.7.0.1
 */