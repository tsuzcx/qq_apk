import android.os.AsyncTask;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;

class ceb
  extends AsyncTask
{
  ceb(cea paramcea) {}
  
  protected TroopGagMgr.SelfGagInfo a(Void... paramVarArgs)
  {
    return ((TroopGagMgr)this.a.a.b.getManager(44)).a(this.a.a.a.a, true);
  }
  
  protected void a(TroopGagMgr.SelfGagInfo paramSelfGagInfo)
  {
    ChatActivity.a(this.a.a, paramSelfGagInfo, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     ceb
 * JD-Core Version:    0.7.0.1
 */