import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.b;
import com.tencent.mobileqq.apollo.process.download.CmGameSubRscHandler.1;
import com.tencent.mobileqq.apollo.process.download.CmGameSubRscHandler.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class abpm
  implements abpq
{
  private long NG;
  private Map<String, abpm.a> iY = Collections.synchronizedMap(new LinkedHashMap());
  private Context mCtx;
  private int mGameId;
  
  public abpm(int paramInt)
  {
    this.mGameId = paramInt;
    this.iY.clear();
    ThreadManager.excute(new CmGameSubRscHandler.1(this), 64, null, true);
  }
  
  private int y(String paramString1, String paramString2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append(abxi.biF).append(this.mGameId).append(File.separator).append(paramString2).append(File.separator).append("config.json");
      paramString2 = new File(localStringBuilder.toString());
      if (!paramString2.exists()) {
        return -1;
      }
      int i = (int)new JSONObject(aqhq.readFileToString(paramString2)).optDouble("version");
      paramString1 = (abpm.a)this.iY.get(paramString1);
      if (paramString1 != null) {
        paramString1.version = i;
      }
      return i;
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, paramString1, new Object[0]);
    }
    return -1;
  }
  
  public void C(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("packName", paramString);
      localJSONObject.put("percentage", paramInt1);
      paramString = abmt.a();
      if (paramString != null) {
        paramString.callbackFromRequest(this.NG, 0, "sc.load_percentage_nofity.local", localJSONObject.toString());
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void a(abpl paramabpl)
  {
    if (paramabpl == null) {}
    abpi localabpi = new abpi(paramabpl, this);
    abpm.a locala = (abpm.a)this.iY.get(paramabpl.packName);
    if (locala != null) {
      locala.b = localabpi;
    }
    QLog.i("cmgame_process.CmGameSubRscHandler", 1, "[cmgame_pack_sub], response, isUpdate:" + paramabpl.isUpdate + ",svrVer:" + paramabpl.cqD + ",isPatch:" + paramabpl.isPatch);
    if (!localabpi.YT()) {
      bJ(paramabpl.gameId, paramabpl.packName);
    }
  }
  
  public void a(CmGameStartChecker.b paramb, long paramLong)
  {
    if ((this.mCtx == null) && (paramb != null))
    {
      QLog.w("cmgame_process.CmGameSubRscHandler", 1, "[onDownloadConfirm], ctx:" + this.mCtx);
      paramb.b(null);
      return;
    }
    ThreadManager.getUIHandler().post(new CmGameSubRscHandler.2(this, paramLong, paramb));
  }
  
  public void aa(long paramLong, String paramString)
  {
    abpu localabpu;
    String str;
    try
    {
      this.NG = paramLong;
      localabpu = abmt.a();
      if (localabpu == null)
      {
        QLog.w("cmgame_process.CmGameSubRscHandler", 1, "jsState:" + paramLong);
        return;
      }
      str = new JSONObject(paramString).optString("packName");
      if (TextUtils.isEmpty(str))
      {
        bK(-10003, "");
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, paramString, new Object[0]);
      return;
    }
    abpe localabpe = new abpe();
    localabpe.busId = 10001;
    localabpe.itemId = (this.mGameId + "_" + str);
    paramString = (abpm.a)this.iY.get(str);
    if (paramString != null)
    {
      if ((paramString.b != null) && (paramString.b.getStatus() == 1))
      {
        bK(-1004, str);
        return;
      }
      localabpe.cqB = paramString.version;
      paramString.packName = str;
    }
    while ((paramString.bEB) && (!BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4).getBoolean("apollo_sp_game_rsc_verify_" + localabpe.itemId, false)))
    {
      QLog.i("cmgame_process.CmGameSubRscHandler", 1, "each pack requst only once in game.");
      bJ(this.mGameId, str);
      return;
      paramString = new abpm.a();
      paramString.packName = str;
      localabpe.cqB = 0;
      this.iY.put(str, paramString);
    }
    QLog.i("cmgame_process.CmGameSubRscHandler", 1, "[cmgame_pack_sub], request, packname:" + str + ",ver:" + localabpe.cqB);
    paramString = new ArrayList();
    paramString.add(localabpe);
    localabpu.a(this.mGameId, str, paramString);
  }
  
  public void ab(long paramLong, String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameSubRscHandler", 2, "[verifyRsc]");
      }
      paramString = new JSONObject(paramString).optString("packName");
      Object localObject = (abpm.a)this.iY.get(paramString);
      if (localObject == null) {
        return;
      }
      if (TextUtils.isEmpty(((abpm.a)localObject).bhn)) {
        anq();
      }
      localObject = new abya(this.mGameId, 1, paramString, ((abpm.a)localObject).bhn);
      ((abya)localObject).a(new abpp(this, paramString));
      ((abya)localObject).cGh();
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, paramString, new Object[0]);
    }
  }
  
  public void anq()
  {
    try
    {
      QLog.i("cmgame_process.CmGameSubRscHandler", 1, "[parseConfig]");
      Object localObject1 = new StringBuilder(100);
      ((StringBuilder)localObject1).append(abxi.biF).append(this.mGameId).append(File.separator).append("gameConfig.json");
      localObject1 = new File(((StringBuilder)localObject1).toString());
      if (!((File)localObject1).exists()) {
        QLog.w("cmgame_process.CmGameSubRscHandler", 1, "[parsePackRoot], gameConfig.json NOT exist.");
      }
      for (;;)
      {
        return;
        JSONArray localJSONArray = new JSONObject(aqhq.readFileToString((File)localObject1)).optJSONArray("subpackages");
        if (localJSONArray != null)
        {
          int i = 0;
          while (i < localJSONArray.length())
          {
            localObject1 = localJSONArray.optJSONObject(i);
            String str1 = ((JSONObject)localObject1).optString("name");
            String str2 = ((JSONObject)localObject1).optString("root");
            abpm.a locala = (abpm.a)this.iY.get(str1);
            localObject1 = locala;
            if (locala == null) {
              localObject1 = new abpm.a();
            }
            ((abpm.a)localObject1).packName = str1;
            ((abpm.a)localObject1).bhn = str2;
            this.iY.put(str1, localObject1);
            y(str1, str2);
            i += 1;
          }
          QLog.i("cmgame_process.CmGameSubRscHandler", 1, "[parseConfig], done.");
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("cmgame_process.CmGameSubRscHandler", 1, localThrowable, new Object[0]);
      }
    }
    finally {}
  }
  
  public void bI(int paramInt, String paramString)
  {
    QLog.i("cmgame_process.CmGameSubRscHandler", 1, "[onStartDownload], gameId:" + paramInt + ",packN:" + paramString);
  }
  
  public void bJ(int paramInt, String paramString)
  {
    bK(0, paramString);
    abpm.a locala = (abpm.a)this.iY.get(paramString);
    if (locala != null)
    {
      locala.bEB = true;
      paramInt = y(paramString, locala.bhn);
      QLog.i("cmgame_process.CmGameSubRscHandler", 1, "[onDownloadSuccess], newV:" + paramInt + ",packName:" + paramString);
    }
  }
  
  public void bK(int paramInt, String paramString)
  {
    try
    {
      QLog.i("cmgame_process.CmGameSubRscHandler", 1, "[onDownloadFailure], ret:" + paramInt + ",packName:" + paramString);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("packName", paramString);
      localJSONObject.put("result", paramInt);
      paramString = abmt.a();
      if (paramString != null) {
        paramString.callbackFromRequest(this.NG, 0, "cs.load_subpackage.local", localJSONObject.toString());
      }
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("cmgame_process.CmGameSubRscHandler", 1, paramString, new Object[0]);
    }
  }
  
  public String iE(String paramString)
  {
    if (this.iY.size() == 0) {
      anq();
    }
    Object localObject = (abpm.a)this.iY.get(paramString);
    if (localObject == null)
    {
      localObject = "";
      return localObject;
    }
    String str = ((abpm.a)localObject).bhn;
    if (TextUtils.isEmpty(str))
    {
      anq();
      str = ((abpm.a)localObject).bhn;
    }
    for (;;)
    {
      localObject = str;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("cmgame_process.CmGameSubRscHandler", 2, new Object[] { "name:", paramString, ",root:", str });
      return str;
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.mCtx = paramContext;
  }
  
  public String t(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(abxi.biF).append(this.mGameId).append("/").append(iE(paramString));
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    abpi b;
    boolean bEB;
    String bhn;
    String packName;
    int version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abpm
 * JD-Core Version:    0.7.0.1
 */