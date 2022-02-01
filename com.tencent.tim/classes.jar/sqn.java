import NS_COMM.COMM.Entry;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.biz.videostory.support.VSReporter.1;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class sqn
{
  private static int bhl;
  private static long zE;
  
  @NonNull
  public static String a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= paramInt)) {
      return "";
    }
    return paramVarArgs[paramInt];
  }
  
  public static List<COMM.Entry> a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { MiniProgramReportHelper.newEntry("ret_code", String.valueOf(paramInt)), MiniProgramReportHelper.newEntry("time_cost", String.valueOf(paramLong1)), MiniProgramReportHelper.newEntry("url", paramString1), MiniProgramReportHelper.newEntry("file_size", String.valueOf(paramLong2)), MiniProgramReportHelper.newEntry("element_id", paramString2) }));
  }
  
  public static List<COMM.Entry> a(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { MiniProgramReportHelper.newEntry("ret_code", String.valueOf(paramLong1)), MiniProgramReportHelper.newEntry("time_cost", String.valueOf(paramLong2)), MiniProgramReportHelper.newEntry("url", paramString), MiniProgramReportHelper.newEntry("file_size", String.valueOf(paramLong3)) }));
  }
  
  public static List<COMM.Entry> a(ArrayList<COMM.Entry> paramArrayList, HashMap<String, Object> paramHashMap)
  {
    Object localObject = paramArrayList;
    if (paramArrayList == null) {
      localObject = new ArrayList();
    }
    if ((paramHashMap != null) && (paramHashMap.keySet().size() > 0))
    {
      paramArrayList = paramHashMap.keySet().iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        ((ArrayList)localObject).add(MiniProgramReportHelper.newEntry(str, String.valueOf(paramHashMap.get(str))));
      }
    }
    return localObject;
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    b("", paramString1, paramString2, paramInt1, paramInt2, paramVarArgs);
  }
  
  public static List<COMM.Entry> ay(List<COMM.Entry> paramList)
  {
    if (paramList != null) {
      paramList.add(MiniProgramReportHelper.newEntry("unique_id", String.valueOf(dv())));
    }
    return paramList;
  }
  
  public static List<COMM.Entry> b(HashMap<String, Object> paramHashMap)
  {
    return a(null, paramHashMap);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    anot.a(null, "dc00898", "", paramString1, paramString2, paramString3, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
  }
  
  public static void bjt()
  {
    zE = System.currentTimeMillis() / 1000L << 32 | bhl;
    bhl += 1;
  }
  
  public static List<COMM.Entry> c(HashMap<String, Object> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.keySet().size() > 0)) {
      return ay(b(paramHashMap));
    }
    return null;
  }
  
  public static void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    anph.b(null, paramString1, paramString2, paramString3, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
  }
  
  public static void d(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    c("", paramString1, paramString2, paramInt1, paramInt2, paramVarArgs);
  }
  
  public static long dv()
  {
    return zE;
  }
  
  public static List<COMM.Entry> i(long paramLong1, long paramLong2)
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { MiniProgramReportHelper.newEntry("ret_code", String.valueOf(paramLong1)), MiniProgramReportHelper.newEntry("time_cost", String.valueOf(paramLong2)) }));
  }
  
  public static void n(String paramString, List<COMM.Entry> paramList)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new VSReporter.1(paramString, paramList));
  }
  
  public static List<COMM.Entry> newUserInfoEntries()
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { MiniProgramReportHelper.newEntry("uin", String.valueOf(aroi.a().getUin())), MiniProgramReportHelper.newEntry("timestamp", String.valueOf(System.currentTimeMillis())), MiniProgramReportHelper.newEntry("qua", avpq.getQUA3()), MiniProgramReportHelper.newEntry("version", "3.4.4.3058"), MiniProgramReportHelper.newEntry("imei", arxr.getImei()), MiniProgramReportHelper.newEntry("idfa", ""), MiniProgramReportHelper.newEntry("idfv", ""), MiniProgramReportHelper.newEntry("android_id", alla.getString(aroi.a().getContext().getContentResolver(), "android_id")) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sqn
 * JD-Core Version:    0.7.0.1
 */