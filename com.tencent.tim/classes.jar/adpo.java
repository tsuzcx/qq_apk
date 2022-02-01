import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.ArkAiDictMgr.1;
import com.tencent.mobileqq.ark.ArkAiDictMgr.3;
import com.tencent.mobileqq.ark.ArkAiDictMgr.4;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkRecommendLogic;
import com.tencent.mobileqq.ark.ArkRecommendLogic.ArkWordSegmentThread;
import com.tencent.mobileqq.startup.step.UpdateArkSo;
import com.tencent.wordsegment.WordSegment;
import java.io.File;

public class adpo
{
  private static volatile boolean aNM;
  private static String buV;
  private java.lang.ref.WeakReference<AppInterface> n;
  
  public adpo(AppInterface paramAppInterface)
  {
    this.n = new mqq.util.WeakReference(paramAppInterface);
  }
  
  public static adpo.a a(AppInterface paramAppInterface, String paramString)
  {
    adpo.a locala = new adpo.a();
    locala.text = paramString;
    ArkRecommendLogic.a().ae(new ArkAiDictMgr.3(paramAppInterface, locala, paramString));
    return locala;
  }
  
  public static boolean afq()
  {
    return (aNM) && (!TextUtils.isEmpty(buV));
  }
  
  private static void cTF()
  {
    try
    {
      if ((adph.sARMv7Compatible) && (!aNM))
      {
        aNM = UpdateArkSo.af(BaseApplicationImpl.getContext(), "WordSegment");
        ArkAppCenter.r("ArkApp.Dict", String.format("loadWordSegmentSo, result=%s", new Object[] { Boolean.toString(aNM) }));
        if (aNM) {
          WordSegment.setLogCallback(new adpp());
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void cTG()
  {
    Object localObject = new File(sJ());
    if (((File)localObject).isFile()) {
      ((File)localObject).delete();
    }
    for (;;)
    {
      return;
      localObject = ((File)localObject).listFiles();
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          localObject[i].delete();
          i += 1;
        }
      }
    }
  }
  
  private static boolean g(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null) {}
    do
    {
      return true;
      paramAppInterface = aeiy.b(170).a();
      if ((paramAppInterface == null) || (paramAppInterface.e() == null))
      {
        ArkAppCenter.r("ArkApp.Dict", "getWordInitState, confBean is empty");
        return true;
      }
      paramAppInterface = paramAppInterface.e().bxY;
      if (paramAppInterface == null) {
        break;
      }
      ArkAppCenter.r("ArkApp.Dict", String.format("getWordInitState, wordInitState=%s", new Object[] { paramAppInterface }));
    } while (!paramAppInterface.equals("false"));
    return false;
    ArkAppCenter.r("ArkApp.Dict", "getWordInitState, ark_dict_init is empty");
    return true;
  }
  
  public static String jU(String paramString)
  {
    return sJ() + paramString;
  }
  
  public static void n(AppInterface paramAppInterface)
  {
    if (afq())
    {
      ArkAppCenter.r("ArkApp.Dict", "initWordData, already inited.");
      return;
    }
    new File(sJ()).mkdirs();
    if (!aNM) {
      ArkRecommendLogic.a().ae(new ArkAiDictMgr.1());
    }
    o(paramAppInterface);
  }
  
  public static void o(AppInterface paramAppInterface)
  {
    if (!aNM)
    {
      ArkAppCenter.r("ArkApp.Dict", "reloadWordData, sIsSoLoaded is false");
      return;
    }
    ArkRecommendLogic.u().post(new ArkAiDictMgr.4(paramAppInterface));
  }
  
  static String sJ()
  {
    return ArkAppCenter.sN() + "/WordData/";
  }
  
  public void cTB()
  {
    ArkAppCenter.r("ArkApp.Dict", "clearDict");
    AppInterface localAppInterface = (AppInterface)this.n.get();
    aqmj.cw(localAppInterface.getApp(), localAppInterface.getCurrentAccountUin());
    cTG();
  }
  
  public static class a
  {
    public String[] es;
    public boolean success;
    public String text;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adpo
 * JD-Core Version:    0.7.0.1
 */