import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class obg
{
  static obg a;
  static ByteBuffer buffer = ByteBuffer.allocate(8);
  int ahi;
  String aoV;
  String aoW;
  int bdQ;
  int bdR;
  int bdS;
  int bdT;
  int bdU;
  String itemID;
  int itemPos;
  String search;
  int uo = 1;
  
  public static obg a()
  {
    if (a == null) {
      a = new obg();
    }
    return a;
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("sVer", "1.0");
    localHashMap.put("sSearch", this.aoV);
    localHashMap.put("sKey", this.search);
    localHashMap.put("sCurTime", String.valueOf(l));
    localHashMap.put("sItem", paramString);
    localHashMap.put("sPScene", String.valueOf(this.bdS));
    localHashMap.put("sScene", String.valueOf(this.bdQ + paramInt1));
    localHashMap.put("sItemPos", String.valueOf(paramInt2));
    if (paramInt3 == 12) {
      localHashMap.put("sFolder", "1");
    }
    for (;;)
    {
      f("actSearchNetClick", localHashMap);
      this.bdR = this.bdS;
      this.bdS = (this.bdQ + paramInt1);
      this.itemPos = paramInt2;
      this.itemID = paramString;
      if (QLog.isDevelopLevel()) {
        QLog.d("PADetailReportUtil", 4, "start report click event searchID:" + this.aoV + ", superview:" + this.bdR + ", thisview:" + this.bdS + ", itemPos:" + this.itemPos + ", time:" + l + ", itemID:" + this.itemID + ", from:" + paramInt3);
      }
      return;
      localHashMap.put("sFolder", "0");
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("sVer", "1.0");
    localHashMap.put("sSearch", this.aoV);
    localHashMap.put("sKey", this.search);
    localHashMap.put("sCurTime", String.valueOf(l));
    localHashMap.put("sPScene", String.valueOf(this.bdS));
    localHashMap.put("sScene", String.valueOf(this.bdQ + paramInt1));
    localHashMap.put("sDirect", String.valueOf(paramInt2));
    localHashMap.put("sItem", paramString);
    if (paramInt3 == 12)
    {
      localHashMap.put("sFolder", "1");
      if (!paramBoolean) {
        break label308;
      }
      localHashMap.put("sFrom", "1");
    }
    for (;;)
    {
      f("actSearchSubscribe", localHashMap);
      this.bdR = this.bdS;
      this.bdS = (this.bdQ + paramInt1);
      this.itemID = paramString;
      this.bdU = paramInt2;
      if (QLog.isDevelopLevel()) {
        QLog.d("PADetailReportUtil", 4, "start report attention event searchID:" + this.aoV + ", superview:" + this.bdR + ", thisview:" + this.bdS + ", itemID:" + this.itemID + ", isDirectClick:" + this.bdU + ", time" + l + ", from:" + paramInt3 + ", isoffline:" + paramBoolean);
      }
      return;
      localHashMap.put("sFolder", "0");
      break;
      label308:
      localHashMap.put("sFrom", "0");
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, String paramString3)
  {
    long l;
    HashMap localHashMap;
    if (paramInt1 == 3)
    {
      this.uo += 1;
      this.ahi = ((this.uo - 1) * paramInt2);
      l = System.currentTimeMillis();
      localHashMap = new HashMap();
      localHashMap.put("sVer", "1.0");
      if (paramString1 == null) {
        break label366;
      }
      localHashMap.put("sSearch", paramString1);
      label65:
      localHashMap.put("sCurTime", String.valueOf(l));
      localHashMap.put("sKey", paramString2);
      localHashMap.put("sPScene", String.valueOf(this.bdS));
      localHashMap.put("sScene", String.valueOf(this.bdQ + paramInt1));
      if (this.uo == 0) {
        break label381;
      }
      localHashMap.put("sItemListPage", String.valueOf(this.uo));
      localHashMap.put("sItemListStart", String.valueOf((this.uo - 1) * paramInt2));
    }
    for (;;)
    {
      localHashMap.put("sItemlist", paramString3);
      f("actSearchNet", localHashMap);
      this.bdR = this.bdS;
      this.bdS = (this.bdQ + paramInt1);
      if (paramString1 != null) {
        this.aoV = paramString1;
      }
      this.search = paramString2;
      this.bdT = this.uo;
      this.aoW = paramString3;
      if (QLog.isDevelopLevel())
      {
        QLog.d("PADetailReportUtil", 4, "start report searchpage searchID:" + this.aoV + " superview:" + this.bdR + ", thisview:" + this.bdS + ", search:" + this.search);
        QLog.d("PADetailReportUtil", 4, "pagenum:" + this.bdT + ", startPos:" + this.ahi + ", itemList:" + this.aoW + ", time:" + l);
      }
      return;
      this.uo = 0;
      break;
      label366:
      localHashMap.put("sSearch", this.aoV);
      break label65;
      label381:
      localHashMap.put("sItemListPage", "1");
      localHashMap.put("sItemListStart", "0");
    }
  }
  
  public String aa(String paramString1, String paramString2)
  {
    try
    {
      if ((!this.search.equals(paramString2)) || (this.aoV == null))
      {
        paramString1 = MD5.toMD5Byte(paramString1 + String.valueOf(System.currentTimeMillis()) + Math.random());
        buffer.put(paramString1, 0, 8);
        buffer.flip();
        this.uo = 0;
        long l = buffer.getLong();
        return String.valueOf(l);
      }
    }
    catch (Exception paramString1) {}
    return null;
  }
  
  public void bdc()
  {
    this.aoV = null;
    this.search = null;
    this.bdR = 0;
    this.bdS = 0;
    this.bdT = 0;
    this.ahi = 0;
  }
  
  public void bdd()
  {
    this.uo = 0;
  }
  
  public void f(String paramString, HashMap<String, String> paramHashMap)
  {
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, paramString, true, 0L, 0L, paramHashMap, null);
  }
  
  public void uv(int paramInt)
  {
    bdc();
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("sVer", "1.0");
    localHashMap.put("sScene", String.valueOf(paramInt));
    localHashMap.put("sCurTime", String.valueOf(l));
    f("actSearchExposure", localHashMap);
    this.bdS = paramInt;
    this.bdQ = paramInt;
    this.uo = 0;
    if (QLog.isDevelopLevel()) {
      QLog.d("PADetailReportUtil", 4, "start report entrance event cur view:" + paramInt + ", time:" + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     obg
 * JD-Core Version:    0.7.0.1
 */