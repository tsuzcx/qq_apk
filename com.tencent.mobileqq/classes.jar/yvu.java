import NS_COMM.COMM.Entry;
import android.content.Context;
import android.os.Handler;
import android.provider.Settings.Secure;
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

public class yvu
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  
  public static long a()
  {
    return jdField_a_of_type_Long;
  }
  
  @NonNull
  public static String a(int paramInt, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= paramInt)) {
      return "";
    }
    return paramVarArgs[paramInt];
  }
  
  public static List<COMM.Entry> a()
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { MiniProgramReportHelper.newEntry("uin", String.valueOf(bexd.a().a())), MiniProgramReportHelper.newEntry("timestamp", String.valueOf(System.currentTimeMillis())), MiniProgramReportHelper.newEntry("qua", bizf.a()), MiniProgramReportHelper.newEntry("version", "8.3.3.4515"), MiniProgramReportHelper.newEntry("imei", bfin.c()), MiniProgramReportHelper.newEntry("idfa", ""), MiniProgramReportHelper.newEntry("idfv", ""), MiniProgramReportHelper.newEntry("android_id", Settings.Secure.getString(bexd.a().a().getContentResolver(), "android_id")) }));
  }
  
  public static List<COMM.Entry> a(int paramInt, long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { MiniProgramReportHelper.newEntry("ret_code", String.valueOf(paramInt)), MiniProgramReportHelper.newEntry("time_cost", String.valueOf(paramLong1)), MiniProgramReportHelper.newEntry("url", paramString1), MiniProgramReportHelper.newEntry("file_size", String.valueOf(paramLong2)), MiniProgramReportHelper.newEntry("element_id", paramString2) }));
  }
  
  public static List<COMM.Entry> a(long paramLong1, long paramLong2)
  {
    return new ArrayList(Arrays.asList(new COMM.Entry[] { MiniProgramReportHelper.newEntry("ret_code", String.valueOf(paramLong1)), MiniProgramReportHelper.newEntry("time_cost", String.valueOf(paramLong2)) }));
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
  
  public static List<COMM.Entry> a(HashMap<String, Object> paramHashMap)
  {
    return a(null, paramHashMap);
  }
  
  public static List<COMM.Entry> a(List<COMM.Entry> paramList)
  {
    if (paramList != null) {
      paramList.add(MiniProgramReportHelper.newEntry("unique_id", String.valueOf(a())));
    }
    return paramList;
  }
  
  public static void a()
  {
    jdField_a_of_type_Long = System.currentTimeMillis() / 1000L << 32 | jdField_a_of_type_Int;
    jdField_a_of_type_Int += 1;
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    a("", paramString1, paramString2, paramInt1, paramInt2, paramVarArgs);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    azmj.b(null, "dc00898", "", paramString1, paramString2, paramString3, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
  }
  
  public static void a(String paramString, List<COMM.Entry> paramList)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new VSReporter.1(paramString, paramList));
  }
  
  public static List<COMM.Entry> b(HashMap<String, Object> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.keySet().size() > 0)) {
      return a(a(paramHashMap));
    }
    return null;
  }
  
  public static void b(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    b("", paramString1, paramString2, paramInt1, paramInt2, paramVarArgs);
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    aznj.a(null, paramString1, paramString2, paramString3, paramInt1, paramInt2, a(0, paramVarArgs), a(1, paramVarArgs), a(2, paramVarArgs), a(3, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yvu
 * JD-Core Version:    0.7.0.1
 */