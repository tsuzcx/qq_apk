import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class avcn
{
  public String cJf;
  public int cdu;
  protected boolean dmf;
  public boolean dmg;
  public int ewp;
  public int ewr = 256;
  protected String mPluginID;
  public String mProcessName;
  public int mStrategyId;
  
  private void a(avco.a parama, String paramString)
  {
    if (parama != null)
    {
      parama.ewq = 2;
      parama.cJg = paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloadStrategy", 2, "pluginType:" + this.cdu + "  " + paramString);
    }
  }
  
  public void a(avco.a parama) {}
  
  public boolean a(avcn.b paramb, String paramString1, QQAppInterface paramQQAppInterface, String paramString2, int paramInt, long paramLong, int[] paramArrayOfInt, avco.a parama)
  {
    if (paramb == null) {
      return false;
    }
    if ((paramb.dmo) && (!tg(paramString2)))
    {
      a(parama, "preload:fail:notinleba");
      return false;
    }
    if (paramb.dmi)
    {
      int i = t(paramQQAppInterface, paramString1);
      if ((paramb.dmj) && (i == 4))
      {
        a(parama, "preload:ok:reddotonly");
        return true;
      }
      if ((paramb.dmk) && ((i == 1) || (i == 4)))
      {
        a(parama, "preload:ok:reddot");
        return true;
      }
      if ((paramb.dml) && (i == 2))
      {
        a(parama, "preload:fail:lebareddot");
        return false;
      }
    }
    if ((paramb.dmh) && (!bA(paramb.ewu, paramb.ewv)))
    {
      a(parama, "preload:fail:timecontrol");
      return false;
    }
    if ((paramb.dmq) && (paramInt < paramb.ewy))
    {
      a(parama, "preload:fail:usedtimeslimit");
      return false;
    }
    if (paramb.dmp)
    {
      long l = paramb.ewx * 60 * 60 * 1000;
      if (System.currentTimeMillis() - paramLong > l)
      {
        a(parama, "preload:fail:notactive");
        return false;
      }
    }
    if (paramb.dmm)
    {
      if ((System.currentTimeMillis() - paramLong) / 1000L <= paramb.eww) {
        paramInt = 1;
      }
      while (paramInt != 0) {
        if (paramb.dmn)
        {
          a(parama, "preload:ok:cdperiod");
          return true;
          paramInt = 0;
        }
        else
        {
          a(parama, "preload:fail:cdperiod");
          return false;
        }
      }
    }
    if ((paramb.dmr) && (paramb.ewz > 0) && (!a(paramString1, paramQQAppInterface.getCurrentAccountUin(), paramb.ewz, paramArrayOfInt, paramb.ewA, paramb.ewB)))
    {
      a(parama, "preload:fail:notinuserlearn");
      return false;
    }
    a(parama, "preload:ok:normal");
    return true;
  }
  
  public abstract boolean a(avco.a parama);
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramInt1 <= 0) || (paramArrayOfInt == null)) {
      return false;
    }
    String str1 = paramString1 + "_userlearn_lasttime:" + paramString2;
    String str2 = paramString1 + "_userlearn_timearea:" + paramString2;
    String str3 = paramString1 + "_userlearn_timearea_inhour:" + paramString2 + ":";
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("ppp_profile", aqmc.dw());
    long l = localSharedPreferences.getLong(str1, 0L);
    int i = localSharedPreferences.getInt(str2, 3);
    if ((System.currentTimeMillis() - l > 86400000L) || (paramInt1 != i))
    {
      paramString2 = a(paramArrayOfInt, paramInt1, paramInt2, paramInt3);
      paramString1 = paramString2;
      if (paramString2 == null) {
        break label377;
      }
      paramInt2 = 0;
      while (paramInt2 < paramInt1)
      {
        localSharedPreferences.edit().putInt(str3 + paramInt2, paramString2[paramInt2]).commit();
        paramInt2 += 1;
      }
      localSharedPreferences.edit().putInt(str2, paramInt1).commit();
      localSharedPreferences.edit().putLong(str1, System.currentTimeMillis()).commit();
    }
    for (;;)
    {
      if (paramString2 != null)
      {
        paramInt2 = Calendar.getInstance().get(11);
        paramInt3 = paramString2.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt3)
        {
          if (paramInt2 == paramString2[paramInt1])
          {
            return true;
            paramString2 = new int[i];
            paramInt1 = 0;
            for (;;)
            {
              paramString1 = paramString2;
              if (paramInt1 >= i) {
                break;
              }
              paramString2[paramInt1] = localSharedPreferences.getInt(str3 + paramInt1, paramInt1 + 20);
              paramInt1 += 1;
            }
          }
          paramInt1 += 1;
        }
      }
      return false;
      label377:
      paramString2 = paramString1;
    }
  }
  
  public int[] a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramArrayOfInt == null) || (paramInt1 <= 0) || (paramInt1 > paramArrayOfInt.length)) {}
    do
    {
      return null;
      localObject = new avcn.a(paramInt3);
      switch (paramInt2)
      {
      default: 
        return null;
      case 1: 
        paramInt2 = ((avcn.a)localObject).e(paramArrayOfInt, paramInt1);
      }
    } while (paramInt2 == -1);
    paramInt3 = paramInt2 - paramInt1 / 2;
    paramInt2 = paramInt3;
    if (paramInt3 < 0) {
      paramInt2 = paramInt3 + paramArrayOfInt.length;
    }
    Object localObject = new int[paramInt1];
    paramInt3 = 0;
    if (paramInt3 < paramInt1)
    {
      localObject[paramInt3] = paramInt2;
      int i = paramInt2 + 1;
      if (i >= paramArrayOfInt.length) {}
      for (paramInt2 = -paramArrayOfInt.length;; paramInt2 = 0)
      {
        paramInt3 += 1;
        paramInt2 = i + paramInt2;
        break;
      }
    }
    return localObject;
    return ((avcn.a)localObject).b(paramArrayOfInt, paramInt1);
  }
  
  protected abstract void aBp();
  
  public boolean b(avco.a parama)
  {
    return true;
  }
  
  public boolean bA(int paramInt1, int paramInt2)
  {
    if ((1 << Calendar.getInstance().get(7) - 1 & paramInt1) == 0) {}
    while ((1 << Calendar.getInstance().get(11) & paramInt2) == 0) {
      return false;
    }
    return true;
  }
  
  public int t(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {
      return 3;
    }
    Object localObject1 = (jnv)paramQQAppInterface.getManager(70);
    int m;
    if (localObject1 != null) {
      m = ((jnv)localObject1).a(paramQQAppInterface);
    }
    for (int k = ((jnv)localObject1).mN();; k = 0)
    {
      Object localObject2 = (altq)paramQQAppInterface.getManager(36);
      int i = 0;
      int j = 0;
      boolean bool1 = false;
      boolean bool2 = bool1;
      int n = j;
      int i1;
      if (localObject2 != null)
      {
        n = ((altq)localObject2).iL(0);
        localObject1 = ((altq)localObject2).aj(0);
        localObject2 = ((altq)localObject2).fV();
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
          break label675;
        }
        bool1 = false;
        i = 0;
        i1 = 0;
        if (i1 < ((List)localObject1).size())
        {
          BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i1);
          j = i;
          if (localAppInfo.mission_level.get() != 0) {
            break label669;
          }
          j = i;
          if (localAppInfo.path.get().contains(".")) {
            break label669;
          }
          if (localAppInfo.iNewFlag.get() != 1) {}
          for (;;)
          {
            i1 += 1;
            break;
            j = 0;
            for (;;)
            {
              if ((j >= ((List)localObject2).size()) || (localAppInfo.uiAppId.get() == ((BusinessInfoCheckUpdate.AppSetting)((List)localObject2).get(j)).appid.get()))
              {
                if ((j >= ((List)localObject2).size()) || (((BusinessInfoCheckUpdate.AppSetting)((List)localObject2).get(j)).setting.get())) {
                  break label289;
                }
                break;
              }
              j += 1;
            }
            label289:
            i += 1;
            j = i;
            if (!paramString.equals(localAppInfo.path.get())) {
              break label669;
            }
            bool1 = true;
          }
        }
        j = i;
        i = n;
        n = j;
        bool2 = bool1;
      }
      for (;;)
      {
        paramString = (aneo)paramQQAppInterface.getManager(10);
        int i2 = 0;
        i1 = 0;
        if (paramString != null)
        {
          i2 = paramString.jn(1);
          i1 = paramString.jn(2);
        }
        j = 0;
        bool1 = false;
        paramQQAppInterface = (ReadInJoyManager)paramQQAppInterface.getManager(96);
        label414:
        int i6;
        int i3;
        label434:
        int i4;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.c();
          if (paramQQAppInterface != null)
          {
            j = paramQQAppInterface.Qm();
            if ((paramQQAppInterface == null) || (!paramQQAppInterface.aNb())) {
              break label629;
            }
            bool1 = true;
          }
        }
        else
        {
          i6 = i2 + k + i + j;
          if (m <= 0) {
            break label635;
          }
          i3 = 1;
          if (i1 <= 0) {
            break label641;
          }
          i4 = 1;
          label442:
          if (!bool1) {
            break label647;
          }
        }
        label641:
        label647:
        for (int i5 = 1;; i5 = 0)
        {
          i3 = i5 + (n + i3 + i4);
          if (QLog.isColorLevel()) {
            QLog.d("PluginPreloadStrategy", 2, "Troop redTouch: " + m + "; Troop num: " + k + "; Message num: " + i + "; Leba redTouch: " + n + "; Business has redTouch: " + bool2 + "; QZone msg count: " + i2 + "; QZone new count: " + i1 + "; ReadInJoy notify count: " + j + "; ReadInJoy need show notify: " + bool1 + "; Total redTouch: " + i3 + "; Total num: " + i6);
          }
          if (!bool2) {
            break label655;
          }
          if ((i6 != 0) || (i3 != 1)) {
            break label653;
          }
          return 4;
          j = 0;
          break;
          label629:
          bool1 = false;
          break label414;
          label635:
          i3 = 0;
          break label434;
          i4 = 0;
          break label442;
        }
        label653:
        return 1;
        label655:
        if ((i6 > 0) || (i3 > 0)) {
          return 2;
        }
        return 3;
        label669:
        i = j;
        break;
        label675:
        i = n;
        bool2 = bool1;
        n = j;
      }
      m = 0;
    }
  }
  
  public boolean tg(String paramString)
  {
    Object localObject = zjq.a().dq();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      aevs localaevs = (aevs)((Iterator)localObject).next();
      if ((localaevs != null) && (localaevs.a != null) && (localaevs.a.strPkgName != null) && (localaevs.a.strPkgName.contains(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public class a
  {
    private float[][] d;
    private int ews = 3;
    private int[] tD;
    
    public a(int paramInt)
    {
      int i = paramInt;
      if (paramInt <= 0) {
        i = this.ews;
      }
      this.ews = i;
      paramInt = this.ews;
      this.d = ((float[][])Array.newInstance(Float.TYPE, new int[] { paramInt, 2 }));
      paramInt = 0;
      while (paramInt < this.ews)
      {
        this.d[paramInt][0] = 0;
        this.d[paramInt][1] = 0;
        paramInt += 1;
      }
    }
    
    public int[] b(int[] paramArrayOfInt, int paramInt)
    {
      if ((paramArrayOfInt == null) || (paramInt <= 0) || (paramArrayOfInt.length < paramInt)) {
        return null;
      }
      int j = 0;
      for (int i = 0; j < paramInt; i = k + i)
      {
        k = paramArrayOfInt[j];
        j += 1;
      }
      j = 1;
      int n = i;
      int k = 0;
      int m = i;
      if (j < paramArrayOfInt.length)
      {
        i = n - paramArrayOfInt[(j - 1)];
        if (j + paramInt - 1 < paramArrayOfInt.length) {
          i += paramArrayOfInt[(j + paramInt - 1)];
        }
        for (;;)
        {
          n = m;
          if (m < i)
          {
            n = i;
            k = j;
          }
          j += 1;
          m = n;
          n = i;
          break;
          i += paramArrayOfInt[((j + paramInt - 1) % paramArrayOfInt.length)];
        }
      }
      int[] arrayOfInt = new int[paramInt];
      i = 0;
      if (i < paramInt)
      {
        arrayOfInt[i] = k;
        k += 1;
        if (k >= paramArrayOfInt.length) {}
        for (j = -paramArrayOfInt.length;; j = 0)
        {
          i += 1;
          k += j;
          break;
        }
      }
      return arrayOfInt;
    }
    
    public int e(int[] paramArrayOfInt, int paramInt)
    {
      if ((paramArrayOfInt == null) || (paramArrayOfInt.length < this.ews) || (this.ews <= 0) || (paramInt < 1) || (paramInt > paramArrayOfInt.length)) {
        return -1;
      }
      int i2 = paramArrayOfInt.length;
      this.tD = paramArrayOfInt;
      int k = i2 / this.ews;
      int i = 0;
      while (i < this.ews)
      {
        j = i * k;
        this.d[i][0] = j;
        this.d[i][1] = this.tD[j];
        while ((j < (i + 1) * k) && (j < i2))
        {
          if (this.tD[j] > this.d[i][1])
          {
            this.d[i][0] = j;
            this.d[i][1] = this.tD[j];
          }
          j += 1;
        }
        i += 1;
      }
      paramArrayOfInt = new int[i2];
      i = 0;
      while (i < i2)
      {
        paramArrayOfInt[i] = -1;
        i += 1;
      }
      i = this.ews;
      int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 });
      int[] arrayOfInt1 = new int[this.ews];
      i = 0;
      while (i < this.ews)
      {
        arrayOfInt[i][0] = 0;
        arrayOfInt[i][1] = 0;
        arrayOfInt1[i] = ((int)this.d[i][0]);
        i += 1;
      }
      i = 0;
      int j = 0;
      while ((j < 10) && (i == 0))
      {
        k = 0;
        int n;
        int m;
        if (k < i2)
        {
          if (this.tD[k] == 0) {}
          for (;;)
          {
            k += 1;
            break;
            n = 0;
            m = Math.abs(k - (int)this.d[0][0]);
            i = 0;
            while (i < this.ews)
            {
              int i1 = m;
              if (m > Math.abs(k - (int)this.d[i][0]))
              {
                i1 = Math.abs(k - (int)this.d[i][0]);
                n = i;
              }
              i += 1;
              m = i1;
            }
            paramArrayOfInt[k] = n;
          }
        }
        i = 0;
        while (i < this.ews)
        {
          arrayOfInt[i][0] = 0;
          arrayOfInt[i][1] = 0;
          i += 1;
        }
        i = 0;
        int[] arrayOfInt2;
        if (i < i2)
        {
          if (this.tD[i] == 0) {}
          for (;;)
          {
            i += 1;
            break;
            arrayOfInt2 = arrayOfInt[paramArrayOfInt[i]];
            arrayOfInt2[0] += this.tD[i] * i;
            arrayOfInt2 = arrayOfInt[paramArrayOfInt[i]];
            arrayOfInt2[1] += this.tD[i];
          }
        }
        i = 0;
        while (i < this.ews)
        {
          if (arrayOfInt[i][1] != 0)
          {
            this.d[i][0] = ((int)Math.round(arrayOfInt[i][0] * 1.0D / arrayOfInt[i][1]));
            m = (int)this.d[i][0] - paramInt / 2;
            if (m < 0)
            {
              k = i2;
              arrayOfInt[i][1] = 0;
              m += k;
              k = 0;
              label613:
              if (k >= paramInt) {
                break label695;
              }
              if (paramArrayOfInt[m] == i)
              {
                arrayOfInt2 = arrayOfInt[i];
                arrayOfInt2[1] += this.tD[m];
              }
              n = m + 1;
              if (n < i2) {
                break label689;
              }
            }
            label689:
            for (m = -i2;; m = 0)
            {
              k += 1;
              m = n + m;
              break label613;
              k = 0;
              break;
            }
            label695:
            this.d[i][1] = arrayOfInt[i][1];
          }
          i += 1;
        }
        i = 1;
        k = 0;
        while (k < this.ews)
        {
          if (arrayOfInt1[k] != (int)this.d[k][0])
          {
            arrayOfInt1[k] = ((int)this.d[k][0]);
            i = 0;
          }
          k += 1;
        }
        j += 1;
      }
      paramInt = 0;
      while (paramInt < this.d.length)
      {
        i = 0;
        while (i < this.d.length - paramInt - 1)
        {
          if (this.d[(i + 1)][1] > this.d[i][1])
          {
            j = this.d[i][0];
            k = this.d[i][1];
            this.d[i][0] = this.d[(i + 1)][0];
            this.d[i][1] = this.d[(i + 1)][1];
            this.d[(i + 1)][0] = j;
            this.d[(i + 1)][1] = k;
          }
          i += 1;
        }
        paramInt += 1;
      }
      return (int)this.d[0][0];
    }
  }
  
  public static class b
  {
    public boolean dmh;
    public boolean dmi;
    public boolean dmj;
    public boolean dmk;
    public boolean dml;
    public boolean dmm;
    public boolean dmn;
    public boolean dmo;
    public boolean dmp;
    public boolean dmq;
    public boolean dmr;
    public int ewA;
    public int ewB;
    public int ewt;
    public int ewu;
    public int ewv;
    public int eww;
    public int ewx;
    public int ewy;
    public int ewz;
    
    public static b a(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      try
      {
        paramString = new JSONObject(paramString);
        return a(paramString);
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PreloadPublicParam", 2, "PreloadPublicParam parseJson Exception");
          }
          paramString = null;
        }
      }
    }
    
    public static b a(JSONObject paramJSONObject)
    {
      if (paramJSONObject == null) {
        return null;
      }
      b localb = new b();
      try
      {
        if (paramJSONObject.has("pppid")) {
          localb.ewt = paramJSONObject.getInt("pppid");
        }
        if (paramJSONObject.has("timecontrol"))
        {
          localObject = paramJSONObject.getJSONObject("timecontrol");
          localb.dmh = ((JSONObject)localObject).getBoolean("switch");
          localb.ewu = ((JSONObject)localObject).getInt("dayofweek");
          localb.ewv = ((JSONObject)localObject).getInt("hourofday");
        }
        if (paramJSONObject.has("reddot"))
        {
          localObject = paramJSONObject.getJSONObject("reddot");
          localb.dmi = ((JSONObject)localObject).getBoolean("switch");
          localb.dmj = ((JSONObject)localObject).optBoolean("apponly");
          localb.dmk = ((JSONObject)localObject).getBoolean("app");
          localb.dml = ((JSONObject)localObject).getBoolean("leba");
        }
        if (paramJSONObject.has("lebalist")) {
          localb.dmo = paramJSONObject.getJSONObject("lebalist").getBoolean("switch");
        }
        if (paramJSONObject.has("activetime"))
        {
          localObject = paramJSONObject.getJSONObject("activetime");
          localb.dmp = ((JSONObject)localObject).getBoolean("switch");
          localb.ewx = ((JSONObject)localObject).getInt("hour");
        }
        if (paramJSONObject.has("usedtimes"))
        {
          localObject = paramJSONObject.getJSONObject("usedtimes");
          localb.dmq = ((JSONObject)localObject).getBoolean("switch");
          localb.ewy = ((JSONObject)localObject).getInt("times");
        }
        if (paramJSONObject.has("userlearn"))
        {
          localObject = paramJSONObject.getJSONObject("userlearn");
          localb.dmr = ((JSONObject)localObject).getBoolean("switch");
          localb.ewz = ((JSONObject)localObject).getInt("timearea");
          localb.ewA = ((JSONObject)localObject).getInt("methodid");
          localb.ewB = ((JSONObject)localObject).getInt("clusternum");
        }
        localObject = localb;
        if (paramJSONObject.has("cdperiod"))
        {
          paramJSONObject = paramJSONObject.getJSONObject("cdperiod");
          localb.dmm = paramJSONObject.optBoolean("switch");
          localb.eww = paramJSONObject.optInt("time");
          localb.dmn = paramJSONObject.optBoolean("reverse");
          localObject = localb;
        }
      }
      catch (JSONException paramJSONObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PreloadPublicParam", 2, "PreloadPublicParam parseJson Exception");
          }
          Object localObject = null;
        }
      }
      return localObject;
    }
  }
  
  public static class c
  {
    public boolean aqY;
    public int cNR;
    public boolean dms;
    public int ewC;
    public String mExt1;
    
    public c(int paramInt, String paramString)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("ppp_profile", 4);
      this.cNR = localSharedPreferences.getInt(paramInt + "preload_switch" + paramString, -1);
      this.aqY = localSharedPreferences.getBoolean(paramInt + "preload" + paramString, false);
      this.dms = localSharedPreferences.getBoolean(paramInt + "preload_data" + paramString, false);
      this.ewC = localSharedPreferences.getInt(paramInt + "mem_limit" + paramString, 256);
      this.mExt1 = localSharedPreferences.getString(paramInt + "ext1" + paramString, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avcn
 * JD-Core Version:    0.7.0.1
 */