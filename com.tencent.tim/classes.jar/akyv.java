import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class akyv
  extends aehv<akyv.d>
{
  protected abstract int Hn();
  
  @NonNull
  public akyv.d a(int paramInt)
  {
    return new akyv.d();
  }
  
  @Nullable
  public akyv.d a(aeic[] paramArrayOfaeic)
  {
    akyv.d locald = new akyv.d();
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null)) {
      akyv.d.a(locald, paramArrayOfaeic[0].content);
    }
    return locald;
  }
  
  public void a(akyv.d paramd) {}
  
  public Class<akyv.d> clazz()
  {
    return akyv.d.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return Hn();
  }
  
  public static final class a
    extends akyv
  {
    protected int Hn()
    {
      return 502;
    }
  }
  
  public static final class b
    extends akyv
  {
    protected int Hn()
    {
      return 519;
    }
  }
  
  public static final class c
    extends akyv
  {
    protected int Hn()
    {
      return 514;
    }
  }
  
  public static final class d
  {
    final TroopAIOAppInfo b = new TroopAIOAppInfo();
    
    private void parse(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        if (QLog.isColorLevel()) {
          QLog.d("AIOPlusPanelAppInfoConfigProcessor", 2, "Config parse configText -> " + paramString);
        }
      }
      try
      {
        paramString = new JSONObject(paramString);
        this.b.appid = paramString.optInt("appid");
        this.b.name = paramString.optString("title");
        this.b.enName = paramString.optString("eng_title");
        this.b.iconUrl = paramString.optString("iconNormal");
        this.b.iconPress = paramString.optString("iconPress");
        this.b.simpleDayUrl = paramString.optString("iconConciseNormal");
        this.b.simpleDayPressUrl = paramString.optString("iconConcisePress");
        this.b.simpleNightUrl = paramString.optString("iconConciseNightNormal");
        this.b.simpleNightPressUrl = paramString.optString("iconConciseNightPress");
        this.b.redDotID = akza.eI(this.b.appid);
        this.b.actionType = paramString.optString("actionType");
        this.b.action = paramString.optString("action");
        this.b.enableC2C = paramString.optInt("enableC2C");
        this.b.enableGroup = paramString.optInt("enableGroup");
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("AIOPlusPanelAppInfoConfigProcessor", 1, paramString, new Object[0]);
      }
    }
  }
  
  public static final class e
    extends akyv
  {
    protected int Hn()
    {
      return 516;
    }
  }
  
  public static final class f
    extends akyv
  {
    protected int Hn()
    {
      return 509;
    }
  }
  
  public static final class g
    extends akyv
  {
    protected int Hn()
    {
      return 507;
    }
  }
  
  public static final class h
    extends akyv
  {
    protected int Hn()
    {
      return 518;
    }
  }
  
  public static final class i
    extends akyv
  {
    protected int Hn()
    {
      return 505;
    }
  }
  
  public static final class j
    extends akyv
  {
    protected int Hn()
    {
      return 508;
    }
  }
  
  public static final class k
    extends akyv
  {
    protected int Hn()
    {
      return 506;
    }
  }
  
  public static final class l
    extends akyv
  {
    protected int Hn()
    {
      return 520;
    }
  }
  
  public static final class m
    extends akyv
  {
    protected int Hn()
    {
      return 511;
    }
  }
  
  public static final class n
    extends akyv
  {
    protected int Hn()
    {
      return 504;
    }
  }
  
  public static final class o
    extends akyv
  {
    protected int Hn()
    {
      return 512;
    }
  }
  
  public static final class p
    extends akyv
  {
    protected int Hn()
    {
      return 510;
    }
  }
  
  public static final class q
    extends akyv
  {
    protected int Hn()
    {
      return 2049;
    }
  }
  
  public static final class r
    extends akyv
  {
    protected int Hn()
    {
      return 600;
    }
  }
  
  public static final class s
    extends akyv
  {
    protected int Hn()
    {
      return 513;
    }
  }
  
  public static final class t
    extends akyv
  {
    protected int Hn()
    {
      return 560;
    }
  }
  
  public static final class u
    extends akyv
  {
    protected int Hn()
    {
      return 517;
    }
  }
  
  public static final class v
    extends akyv
  {
    protected int Hn()
    {
      return 515;
    }
  }
  
  public static final class w
    extends akyv
  {
    protected int Hn()
    {
      return 503;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akyv
 * JD-Core Version:    0.7.0.1
 */