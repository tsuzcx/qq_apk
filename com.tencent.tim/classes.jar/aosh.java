import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

class aosh
  extends BroadcastReceiver
{
  aosh(aosf paramaosf) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION".equals(paramIntent.getAction())) {}
    switch (paramIntent.getIntExtra("ret_action", 1000))
    {
    default: 
      aosf.a(this.this$0, aosf.a(this.this$0).troopUin, 2);
      return;
    case 1000: 
      aosf.a(this.this$0, aosf.a(this.this$0).troopUin, 2);
      return;
    case 1001: 
      aosf.a(this.this$0, aosf.a(this.this$0).troopUin, 2);
      return;
    case 1002: 
      aosf.a(this.this$0, aosf.a(this.this$0).troopUin, 2);
      return;
    case 1003: 
      aosf.a(this.this$0, aosf.a(this.this$0).troopUin, 1);
      return;
    }
    aosf.a(this.this$0, aosf.a(this.this$0).troopUin, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aosh
 * JD-Core Version:    0.7.0.1
 */