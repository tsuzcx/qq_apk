import android.text.TextUtils;
import com.tencent.mobileqq.apollo.process.data.CmGameShareDataHandler.1;
import com.tencent.mobileqq.apollo.process.data.CmGameShareDataHandler.3;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class abpg
{
  private static abpg a;
  private Comparator<abpg.a> I = new abph(this);
  private ConcurrentHashMap<String, Boolean> dw = new ConcurrentHashMap();
  private List<abpg.a> wu = new ArrayList();
  
  private abpg()
  {
    ThreadManagerV2.executeOnFileThread(new CmGameShareDataHandler.1(this));
  }
  
  public static abpg a()
  {
    try
    {
      if (a == null) {
        a = new abpg();
      }
      abpg localabpg = a;
      return localabpg;
    }
    finally {}
  }
  
  private void qh()
  {
    Object localObject = new File(abxi.biF + "gameShareResult.txt");
    if (((File)localObject).exists()) {}
    for (;;)
    {
      int i;
      try
      {
        localObject = abuj.m((File)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          QLog.e("cmgame_process.CmGameShareDataHandler", 1, "initCache, ApolloClientUtil.readFileSafety null");
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameShareDataHandler", 2, new Object[] { "initCache content:", localObject });
        }
        localObject = new JSONArray((String)localObject);
        int j = ((JSONArray)localObject).length();
        i = 0;
        if (i < j)
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          if (localJSONObject == null) {
            break label320;
          }
          abpg.a locala = new abpg.a();
          locala.bZN = localJSONObject.optInt("shareTo");
          locala.cpN = localJSONObject.optInt("activity");
          locala.byr = localJSONObject.optInt("aioType");
          locala.mGameId = localJSONObject.optInt("gameId");
          locala.mUin = localJSONObject.optString("uin");
          locala.Oj = localJSONObject.optLong("shareTS");
          locala.cqC = localJSONObject.optInt("shareRet");
          this.wu.add(locala);
          this.dw.put(locala.getCacheKey(), Boolean.TRUE);
          break label320;
        }
        Collections.sort(this.wu, this.I);
        QLog.d("cmgame_process.CmGameShareDataHandler", 1, new Object[] { "initCache finish mShareResultCache.size():", Integer.valueOf(this.wu.size()) });
        return;
      }
      catch (Exception localException)
      {
        QLog.e("cmgame_process.CmGameShareDataHandler", 1, "initCache e:", localException);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (!QLog.isColorLevel()) {
          break label319;
        }
      }
      QLog.e("cmgame_process.CmGameShareDataHandler", 1, localOutOfMemoryError, new Object[0]);
      return;
      QLog.e("cmgame_process.CmGameShareDataHandler", 1, "file gameShareResult.txt no exsit");
      label319:
      return;
      label320:
      i += 1;
    }
  }
  
  public void a(abpg.a parama)
  {
    if (parama == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameShareDataHandler", 2, new Object[] { "saveShareResult, result:", parama });
    }
    this.wu.add(0, parama);
    if (this.wu.size() > 100) {
      this.wu = new CopyOnWriteArrayList(this.wu.subList(0, 100));
    }
    ThreadManagerV2.executeOnFileThread(new CmGameShareDataHandler.3(this));
  }
  
  public boolean a(abpg.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameShareDataHandler", 1, new Object[] { "isDuplicateShare result:", parama });
    }
    boolean bool1;
    if (parama == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      parama = (Boolean)this.dw.get(parama.getCacheKey());
      if (parama == null) {
        break;
      }
      bool2 = parama.booleanValue();
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.CmGameShareDataHandler", 1, new Object[] { "isDuplicateShare sameValue:", Boolean.valueOf(bool2) });
    return bool2;
    return false;
  }
  
  public static class a
  {
    public long Oj;
    public int bZN;
    public int byr;
    public int cpN;
    public int cqC;
    public int mGameId;
    public String mUin;
    
    public String getCacheKey()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.bZN == 0) {
        localStringBuilder.append(this.mGameId).append("_").append(this.cpN).append("_").append(this.byr).append("_").append(this.mUin);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameShareDataHandler", 2, new Object[] { "getCacheKey:", localStringBuilder.toString() });
        }
        return localStringBuilder.toString();
        localStringBuilder.append(this.mGameId).append("_").append(this.cpN).append("_").append(this.bZN);
      }
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer("GameShareResult{");
      localStringBuffer.append("mGameId=").append(this.mGameId);
      localStringBuffer.append(", mActivityId=").append(this.cpN);
      localStringBuffer.append(", mUin='").append(this.mUin).append('\'');
      localStringBuffer.append(", mAIOType=").append(this.byr);
      localStringBuffer.append(", mShareTo=").append(this.bZN);
      localStringBuffer.append(", mShareTS=").append(this.Oj);
      localStringBuffer.append(", mShareRet=").append(this.cqC);
      localStringBuffer.append('}');
      return localStringBuffer.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abpg
 * JD-Core Version:    0.7.0.1
 */