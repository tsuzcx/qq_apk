import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import mqq.manager.Manager;

public class mzg
  implements Manager
{
  public static int aWx;
  public static int aWy = 1;
  TroopMemberApiService a;
  private boolean aqD = true;
  HashMap<Long, Bundle> er = new HashMap();
  HashMap<Long, Bundle> es = new HashMap();
  private QQAppInterface mApp;
  
  public mzg(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private void sV(int paramInt) {}
  
  public void a(TroopMemberApiService paramTroopMemberApiService)
  {
    if (this.a == null) {
      this.a = paramTroopMemberApiService;
    }
  }
  
  public void e(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if ((TextUtils.isEmpty(paramString)) || (!rox.checkFileExist(paramString))) {}
    for (;;)
    {
      mzh localmzh = new mzh(this);
      aool localaool = new aool();
      localaool.b = new mzi(this);
      aooi localaooi = this.mApp.a();
      localmzh.addFilter(new Class[] { aojg.class });
      localaooi.a(localmzh);
      localaool.dQ = paramString;
      localaool.cNy = true;
      localaool.mFileType = 24;
      localaool.dOM = 54;
      localaool.mSelfUin = this.mApp.getCurrentUin();
      localaool.mPeerUin = "0";
      localaool.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      localaooi.a(localaool);
      this.er.put(Long.valueOf(localaool.mUniseq), paramBundle);
      this.es.put(Long.valueOf(localaool.mUniseq), paramBundle);
      return;
      sV(aWx);
    }
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mzg
 * JD-Core Version:    0.7.0.1
 */