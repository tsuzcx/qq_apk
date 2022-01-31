import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ujr
  extends VasQuickUpdateManager.CallBacker
{
  public ujr(PokePanel paramPokePanel) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramLong == 21L)
    {
      if ((!paramString1.equals("poke.effectList")) || (paramInt1 != 0)) {
        break label107;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.PokePanel", 2, "download vas poke list, refresh now.");
      }
      paramString1 = paramVasQuickUpdateManager.a;
      ThreadManager.getUIHandler().post(new ujs(this, paramString1));
      paramString1 = "";
      paramString2 = "";
      bool1 = bool2;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        ThreadManager.getUIHandler().post(new ujt(this, paramString2, paramString1, bool1));
      }
      return;
      label107:
      if (paramString1.startsWith("poke.item.effect."))
      {
        paramString1 = paramString1.substring("poke.item.effect.".length(), paramString1.length());
        if (paramInt1 != 0) {}
        for (;;)
        {
          paramString2 = "poke.item.effect.";
          break;
          bool1 = false;
        }
      }
      if (paramString1.startsWith("poke.item.res."))
      {
        paramString1 = paramString1.substring("poke.item.res.".length(), paramString1.length());
        if (paramInt1 != 0) {}
        for (bool1 = bool3;; bool1 = false)
        {
          paramString2 = "poke.item.res.";
          break;
        }
      }
      paramString1 = "";
      paramString2 = "";
      bool1 = bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ujr
 * JD-Core Version:    0.7.0.1
 */