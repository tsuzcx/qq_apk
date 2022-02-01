import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class apqr
  extends aquy
{
  apqr(apqk paramapqk) {}
  
  public void onDone(aquz paramaquz)
  {
    apqk.a locala = new apqk.a();
    Bundle localBundle = paramaquz.getParams();
    String str1 = localBundle.getString("GiftAnimationId");
    String str2 = localBundle.getString("TroopUin");
    int i = localBundle.getInt("GiftAnimationType");
    boolean bool = localBundle.getBoolean("GiftIsInteract");
    locala.isFinish = true;
    locala.cqv = str1;
    apqk.b.a().setChanged();
    apqk.b.a().notifyObservers(locala);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAnimationControlManager", 2, "onDone Id=" + str1 + " task:" + paramaquz);
    }
    anot.a(null, "P_CliOper", "P_CliOper", "", "troop_gift_animation", "download", 0, paramaquz.errCode, str1, "", "", "");
    if (paramaquz.errCode == 0)
    {
      paramaquz = new File(aptj.g(str1, i, bool));
      if (paramaquz.exists()) {}
      try
      {
        aqhq.W(paramaquz.getAbsolutePath(), acbn.bno, false);
        paramaquz.delete();
        this.this$0.oo.put(str1, Integer.valueOf(3));
        anot.a(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_suc", 1, 0, str2, "", "", "");
        if (((this.this$0.mBaseChatPie != null) || (this.this$0.mActivity != null)) && (!apqk.cqs.equals(this.this$0.cqt))) {}
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        paramaquz.delete();
      }
    }
    this.this$0.oo.put(localObject, Integer.valueOf(4));
    i = aqiw.getSystemNetwork(this.this$0.mApp.getApplication());
    if (i == 1) {
      i = 0;
    }
    for (;;)
    {
      if ((!(this.this$0.mBaseChatPie instanceof ybt)) && (!(this.this$0.mBaseChatPie instanceof yam))) {
        break label428;
      }
      acie.i("gift_aio", "fail_cartoon", str2, "", "", "");
      break;
      if (i == 2) {
        i = 3;
      } else if (i == 3) {
        i = 2;
      } else if (i == 4) {
        i = 1;
      } else {
        i = 4;
      }
    }
    label428:
    if (this.this$0.mBaseChatPie != null)
    {
      paramaquz = "0";
      label441:
      if (!jof.a().dd(str2)) {
        break label522;
      }
    }
    label522:
    for (int j = 2;; j = 1)
    {
      anot.a(null, "P_CliOper", "Grp_flower", "", "grp_aio", "anime_fail", j, 0, str2, localObject + "", paramaquz, i + "");
      break;
      paramaquz = "1";
      break label441;
    }
  }
  
  public boolean onStart(aquz paramaquz)
  {
    String str = paramaquz.getParams().getString("GiftAnimationId");
    apqk.a locala = new apqk.a();
    locala.isFinish = false;
    locala.cqv = str;
    apqk.b.a().setChanged();
    apqk.b.a().notifyObservers(locala);
    return super.onStart(paramaquz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqr
 * JD-Core Version:    0.7.0.1
 */