import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopFileProxyActivity;

public class agob
  implements agnz
{
  private QQAppInterface mApp;
  private Context mContext;
  private long mTroopUin;
  
  public agob(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.mTroopUin = Long.parseLong(paramString);
  }
  
  private void Ol(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("title_type", paramInt);
    localIntent.putExtra("troop_uin", this.mTroopUin);
    TroopFileProxyActivity.c((Activity)this.mContext, localIntent, this.mApp.getCurrentAccountUin());
  }
  
  private void diw()
  {
    Intent localIntent = TroopMemberListActivity.c(this.mContext, String.valueOf(this.mTroopUin), 18);
    localIntent.putExtra("uin", this.mTroopUin);
    localIntent.putExtra("param_from", 23);
    localIntent.putExtra("uintype", 1);
    this.mContext.startActivity(localIntent);
  }
  
  public void Ok(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    default: 
      QLog.i("QFileTroopSearchTypeController", 4, "unknown search type.");
      return;
    case 3: 
      Ol(1);
      anot.a(this.mApp, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 1, 0, "", "", "", "");
      return;
    case 2: 
      Ol(2);
      anot.a(this.mApp, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 2, 0, "", "", "", "");
      return;
    case 0: 
      Ol(4);
      anot.a(this.mApp, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 3, 0, "", "", "", "");
      return;
    case 1: 
      Ol(3);
      anot.a(this.mApp, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 4, 0, "", "", "", "");
      return;
    case 11: 
      Ol(10000);
      anot.a(this.mApp, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 5, 0, "", "", "", "");
      return;
    }
    diw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agob
 * JD-Core Version:    0.7.0.1
 */