import android.os.AsyncTask;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;

class cbm
  extends AsyncTask
{
  cbm(cbl paramcbl) {}
  
  protected TroopGagMgr.SelfGagInfo a(Void... paramVarArgs)
  {
    TroopChatPie.b(this.a.a);
    return ((TroopGagMgr)TroopChatPie.j(this.a.a).getManager(42)).a(this.a.a.a.a, true);
  }
  
  protected void a(TroopGagMgr.SelfGagInfo paramSelfGagInfo)
  {
    TroopChatPie.a(this.a.a, paramSelfGagInfo, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cbm
 * JD-Core Version:    0.7.0.1
 */