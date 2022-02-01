import android.app.Activity;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class abob
  implements ApolloCmdChannel.a
{
  public static int cqn = -2147483648;
  private JSONObject bg;
  private SparseArray<abob.a> cb = new SparseArray();
  public WeakReference<abos> fH;
  public int mGameId;
  
  public abob()
  {
    a(new abnp());
  }
  
  public abob(abos paramabos)
  {
    a(new abnp());
    if (paramabos != null)
    {
      this.fH = new WeakReference(paramabos);
      this.mGameId = paramabos.getGameId();
    }
  }
  
  private void Cl(String paramString)
  {
    n(0L, "cs.native_method_state.local", q(paramString).toString());
  }
  
  private void n(long paramLong, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) && (paramString2 != null)) {
      abmt.a().callbackFromRequest(paramLong, 0, paramString1, paramString2);
    }
  }
  
  private JSONObject q(String paramString)
  {
    try
    {
      if (this.bg == null) {
        this.bg = new JSONObject();
      }
      this.bg.put("message", paramString);
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.e("CmGameNetiveMethodHandler", 1, paramString, new Object[0]);
      }
    }
    return this.bg;
  }
  
  public abjp a(long paramLong, String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      try
      {
        if (this.fH == null) {
          break label325;
        }
        Object localObject = (abos)this.fH.get();
        if (localObject != null)
        {
          localObject = ((abos)localObject).b();
          if ((localObject != null) && (((ApolloSurfaceView)localObject).getLuaState() == paramLong))
          {
            paramString2 = new JSONObject(paramString2);
            i = paramString2.optInt("N_R_OBJ");
            if (this.cb != null)
            {
              localObject = (abob.a)this.cb.get(i);
              paramString2.put("N_R_CMD", paramString1);
              paramString2.put("N_R_STATE", paramLong);
              if (localObject != null)
              {
                paramString1 = ((abob.a)localObject).a(this, paramString2);
                if (paramString2.optBoolean("N_R_SYNC"))
                {
                  if (paramString1 != null) {
                    paramString1.put("code", 0);
                  }
                  localObject = new abjp();
                  ((abjp)localObject).bDs = true;
                  if (paramString1 == null)
                  {
                    paramString1 = paramString2.toString();
                    ((abjp)localObject).bgF = paramString1;
                    return localObject;
                  }
                  paramString1 = paramString1.toString();
                  continue;
                }
                aJ(paramString1);
              }
              else
              {
                int j = this.cb.size();
                i = 0;
                if (i < j)
                {
                  int k = this.cb.keyAt(i);
                  paramString1 = (abob.a)this.cb.get(k);
                  if (paramString1 == null) {
                    break label327;
                  }
                  paramString1 = paramString1.a(this, paramString2);
                  if (paramString1 == null) {
                    break label327;
                  }
                  aJ(paramString1);
                  break label327;
                }
              }
            }
          }
          else
          {
            QLog.e("CmGameNetiveMethodHandler", 1, "view is null");
          }
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("CmGameNetiveMethodHandler", 1, paramString1, new Object[0]);
        Cl("handleCmd " + paramString1.getMessage());
      }
      QLog.e("CmGameNetiveMethodHandler", 1, "launcher is null");
      label325:
      return null;
      label327:
      i += 1;
    }
  }
  
  public void a(abob.a parama)
  {
    if (parama != null)
    {
      int i = parama.zJ();
      if (this.cb == null) {
        this.cb = new SparseArray();
      }
      if (this.cb.get(i) == null) {
        this.cb.put(i, parama);
      }
    }
  }
  
  public void aJ(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      try
      {
        int i = paramJSONObject.optInt("N_R_SE", -1);
        int j = paramJSONObject.optInt("N_R_OBJ", -1);
        long l = paramJSONObject.optLong("N_R_STATE");
        String str = paramJSONObject.optString("N_R_CMD", null);
        if ((i != -1) && (j != -1) && (!TextUtils.isEmpty(str)))
        {
          abmt.a().callbackFromRequest(l, 0, str, paramJSONObject.toString());
          return;
        }
        QLog.e("CmGameNetiveMethodHandler", 1, "response invalid " + str);
        Cl("invalid response " + i + " # " + j + " # " + str);
        return;
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("CmGameNetiveMethodHandler", 1, paramJSONObject, new Object[0]);
      }
    }
  }
  
  public void b(abob.a parama)
  {
    if (parama != null)
    {
      int i = parama.zJ();
      parama.rf();
      if (this.cb != null) {
        this.cb.remove(i);
      }
    }
  }
  
  public void destroyHandler()
  {
    if (this.cb != null)
    {
      int j = this.cb.size();
      int i = 0;
      while (i < j)
      {
        int k = this.cb.keyAt(i);
        abob.a locala = (abob.a)this.cb.get(k);
        if (locala != null) {
          locala.rf();
        }
        i += 1;
      }
      this.cb.clear();
      this.cb = null;
    }
    if (this.fH != null)
    {
      this.fH.clear();
      this.fH = null;
    }
    this.bg = null;
  }
  
  public boolean q(Activity paramActivity)
  {
    return false;
  }
  
  public int zz()
  {
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract JSONObject a(abob paramabob, JSONObject paramJSONObject);
    
    public abstract String rf();
    
    public abstract int zJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abob
 * JD-Core Version:    0.7.0.1
 */