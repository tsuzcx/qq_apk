import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ras
{
  public static long BB;
  public static long BC;
  public static String azm = "";
  public static String azn = "";
  public static int bpo;
  public static int bpq;
  
  public static void F(long paramLong, String paramString)
  {
    if ((paramLong > 0L) && (BB > 0L) && (BC > 0L) && (!TextUtils.isEmpty(paramString)) && (KP()))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("create_duration", String.valueOf((BC - BB) / 1000.0D));
      localHashMap.put("frame_duration", String.valueOf((paramLong - BB) / 1000.0D));
      paramLong -= BB;
      anpc.a(BaseApplicationImpl.getContext()).collectPerformance(paramString, "actShortVideoEdit", true, paramLong, 0L, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.i("VideoEditReport", 2, "create_duration:" + (String)localHashMap.get("create_duration") + ", frame_duration:" + (String)localHashMap.get("frame_duration") + ", frameDuration:" + paramLong);
      }
      BB = 0L;
      BC = 0L;
    }
  }
  
  public static boolean KP()
  {
    return ((!TextUtils.isEmpty(azm)) && (azm.equals("grp_qq"))) || (azm.equals("grp_qzone")) || (azm.equals("grp_tribe")) || (azm.equals("grp_readinjoy"));
  }
  
  private static boolean KQ()
  {
    return (!TextUtils.isEmpty(azm)) && ((azm.equals("grp_qq_pic_base")) || (azm.equals("grp_qq_pic_qzone")) || (azm.equals("grp_qq_pic_kandian")));
  }
  
  public static void aP(int paramInt, String paramString)
  {
    if ((paramInt == 101) || (paramInt == 102))
    {
      if (KQ()) {
        sp(paramString);
      }
    }
    else {
      return;
    }
    so(paramString);
  }
  
  public static String bZ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "grp_qq_pic_base";
    case 2: 
      return "grp_qq_pic_base";
    case 3: 
      return "grp_qq_pic_qzone";
    }
    return "grp_qq_pic_kandian";
  }
  
  public static void bv(String paramString, int paramInt)
  {
    if (!KP()) {
      return;
    }
    anot.a(null, "dc00898", "", "", paramString, paramString, sZ(), 0, String.valueOf(paramInt), "", "", "");
  }
  
  public static void bw(String paramString, int paramInt)
  {
    int i;
    if (KQ())
    {
      i = 1;
      if (!azm.equalsIgnoreCase("grp_qq_pic_qzone")) {
        break label46;
      }
      i = 2;
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", paramString, paramString, i, 0, String.valueOf(paramInt), "", "", "");
      return;
      label46:
      if (azm.equalsIgnoreCase("grp_qq_pic_kandian")) {
        i = 3;
      }
    }
  }
  
  public static void cz(String paramString1, String paramString2)
  {
    int i;
    if (KQ())
    {
      i = 1;
      if (!azm.equalsIgnoreCase("grp_qq_pic_qzone")) {
        break label43;
      }
      i = 2;
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", paramString1, paramString1, i, 0, "", "", paramString2, "");
      return;
      label43:
      if (azm.equalsIgnoreCase("grp_qq_pic_kandian")) {
        i = 3;
      }
    }
  }
  
  public static void g(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!KP()) {
      return;
    }
    anot.a(null, "dc00898", "", "", paramString1, paramString1, sZ(), 0, paramString2, paramString3, paramString4, paramString5);
  }
  
  private static int sZ()
  {
    if (azm.equals("grp_tribe")) {
      return 4;
    }
    if (azm.equals("grp_qq")) {
      return 1;
    }
    if (azm.equals("grp_readinjoy")) {
      return 5;
    }
    return 2;
  }
  
  public static void so(String paramString)
  {
    if (!KP()) {
      return;
    }
    anot.a(null, "dc00898", "", "", paramString, paramString, sZ(), 0, "", "", "", "");
  }
  
  public static void sp(String paramString)
  {
    cz(paramString, "");
  }
  
  public static void wM(int paramInt)
  {
    bpo = paramInt;
  }
  
  public static void wN(int paramInt)
  {
    bpq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ras
 * JD-Core Version:    0.7.0.1
 */