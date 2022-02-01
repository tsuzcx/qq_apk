import android.util.SparseIntArray;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil.1;
import com.tencent.mobileqq.shortvideo.dancemachine.BoyDataReport;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.text.SimpleDateFormat;
import java.util.Date;

public class alwx
{
  public static String aae;
  public static final SparseIntArray af;
  public static String bZd;
  public static String bZe;
  public static boolean cAa;
  public static boolean cAb;
  public static boolean cAc;
  public static boolean cAd;
  public static boolean czZ;
  public static int dyy = -1;
  public static String filterId;
  public static String lensId;
  public static long videoDuration;
  
  static
  {
    aae = "";
    bZd = "";
    lensId = "";
    bZe = "";
    filterId = "";
    videoDuration = -1L;
    af = new SparseIntArray();
    af.put(10000, 1);
    af.put(10004, 2);
    af.put(10001, 3);
    af.put(10002, 4);
    af.put(10007, 5);
    af.put(10003, 6);
    af.put(10012, 7);
    af.put(10013, 8);
  }
  
  public static void Po(String paramString)
  {
    if (!cAd) {
      return;
    }
    anqf localanqf = a();
    localanqf.Uq = "0X8008425";
    localanqf.Ur = "0X8008425";
    localanqf.bZd = paramString;
    anns.a(null, localanqf);
  }
  
  public static void Pp(String paramString)
  {
    if (!cAd) {
      return;
    }
    anqf localanqf = a();
    localanqf.Uq = "0X8008427";
    localanqf.Ur = "0X8008427";
    localanqf.bZe = paramString;
    anns.a(null, localanqf);
  }
  
  public static void Pq(String paramString)
  {
    anqf localanqf = a();
    localanqf.Uq = "0X8008938";
    localanqf.Ur = "0X8008938";
    localanqf.bZd = bZd;
    localanqf.cgv = lensId;
    if (localanqf.dLH == 5) {
      localanqf.aae = aae;
    }
    localanqf.bZe = paramString;
    anns.a(null, localanqf);
  }
  
  public static void TA(int paramInt)
  {
    if (!cAd) {
      return;
    }
    anqf localanqf = a();
    localanqf.Uq = "0X8008429";
    localanqf.Ur = "0X8008429";
    localanqf.cgu = (paramInt + "");
    anns.a(null, localanqf);
  }
  
  public static void TB(int paramInt)
  {
    if (!cAd) {
      return;
    }
    anqf localanqf = a();
    localanqf.cgu = (paramInt + "");
    localanqf.Uq = "0X800842B";
    localanqf.Ur = "0X800842B";
    anns.a(null, localanqf);
  }
  
  public static void TC(int paramInt)
  {
    if (!cAd) {
      return;
    }
    anqf localanqf = a();
    localanqf.cgu = (paramInt + "");
    localanqf.Uq = "0X800842C";
    localanqf.Ur = "0X800842C";
    anns.a(null, localanqf);
  }
  
  public static void TD(int paramInt)
  {
    if (!cAd) {}
    anqf localanqf;
    do
    {
      return;
      localanqf = a();
      localanqf.Uq = "0X800842D";
      localanqf.Ur = "0X800842D";
      if (localanqf.dLH == 5) {
        localanqf.aae = aae;
      }
      localanqf.bZd = bZd;
      localanqf.cgv = lensId;
      localanqf.bZe = bZe;
      localanqf.filterId = filterId;
      localanqf.aae = aae;
      localanqf.cgw = (paramInt + "");
      anns.a(null, localanqf);
    } while (!czZ);
    localanqf.Uq = "0X80083AE";
    localanqf.Ur = "0X80083AE";
    anns.a(null, localanqf);
  }
  
  public static void TE(int paramInt)
  {
    if (!cAd) {}
    anqf localanqf;
    do
    {
      return;
      localanqf = a();
      localanqf.Uq = "0X800842D";
      localanqf.Ur = "0X800842D";
      if (localanqf.dLH == 5) {
        localanqf.aae = aae;
      }
      localanqf.bZd = bZd;
      localanqf.cgv = lensId;
      localanqf.bZe = bZe;
      localanqf.filterId = filterId;
      localanqf.cgw = (paramInt + "");
      anns.a(null, localanqf);
    } while (!czZ);
    localanqf.Uq = "0X80083AE";
    localanqf.Ur = "0X80083AE";
    anns.a(null, localanqf);
  }
  
  public static void TF(int paramInt)
  {
    if (!cAd) {}
    anqf localanqf;
    do
    {
      return;
      localanqf = a();
      localanqf.Uq = "0X800842E";
      localanqf.Ur = "0X800842E";
      if (localanqf.dLH == 5) {
        localanqf.aae = aae;
      }
      localanqf.bZd = bZd;
      localanqf.cgv = lensId;
      localanqf.bZe = bZe;
      localanqf.filterId = filterId;
      localanqf.cgw = (paramInt + "");
      anns.a(null, localanqf);
    } while (!czZ);
    localanqf.Uq = "0X80083B0";
    localanqf.Ur = "0X80083B0";
    anns.a(null, localanqf);
  }
  
  public static void TG(int paramInt)
  {
    if (!cAd) {
      return;
    }
    anqf localanqf = a();
    localanqf.Uq = "0X800842F";
    localanqf.Ur = "0X800842F";
    if (localanqf.dLH == 5) {
      localanqf.aae = aae;
    }
    localanqf.bZd = bZd;
    localanqf.cgv = lensId;
    localanqf.bZe = bZe;
    localanqf.filterId = filterId;
    localanqf.cgw = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (cAc) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localanqf.cgx = (paramInt + "");
      anns.a(null, localanqf);
      return;
    }
  }
  
  public static void TH(int paramInt)
  {
    if (!cAd) {}
    anqf localanqf;
    do
    {
      return;
      localanqf = a();
      localanqf.Uq = "0X8008431";
      localanqf.Ur = "0X8008431";
      if (localanqf.dLH == 5) {
        localanqf.aae = aae;
      }
      localanqf.bZd = bZd;
      localanqf.cgv = lensId;
      localanqf.bZe = bZe;
      localanqf.filterId = filterId;
      localanqf.cgw = (paramInt + "");
      localanqf.cgy = String.valueOf(aauj.a().aYL);
      localanqf.cgz = (videoDuration + "");
      anns.a(null, localanqf);
    } while (!czZ);
    localanqf.Uq = "0X80083AF";
    localanqf.Ur = "0X80083AF";
    anns.a(null, localanqf);
  }
  
  public static void TI(int paramInt)
  {
    if (!cAd) {
      return;
    }
    anqf localanqf = a();
    localanqf.Uq = "0X8008432";
    localanqf.Ur = "0X8008432";
    localanqf.bZd = bZd;
    localanqf.cgv = lensId;
    localanqf.bZe = bZe;
    localanqf.filterId = filterId;
    if (localanqf.dLH == 5) {
      localanqf.aae = aae;
    }
    localanqf.cgw = (paramInt + "");
    StringBuilder localStringBuilder = new StringBuilder();
    if (cAb) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localanqf.cgx = (paramInt + "");
      localanqf.cgy = String.valueOf(aauj.a().aYL);
      localanqf.cgz = (videoDuration + "");
      anns.a(null, localanqf);
      return;
    }
  }
  
  public static void Tz(int paramInt)
  {
    if (!cAd) {
      return;
    }
    anqf localanqf = a();
    localanqf.Uq = "0X8008754";
    localanqf.Ur = "0X8008754";
    localanqf.cgy = String.valueOf(paramInt);
    anns.a(null, localanqf);
  }
  
  public static anqf a()
  {
    anqf localanqf = new anqf();
    localanqf.aIR = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    localanqf.toUin = "";
    localanqf.Uq = "";
    localanqf.Ur = "";
    localanqf.dLH = af.get(dyy, -1);
    localanqf.cgt = "${count_unknown}";
    localanqf.cgu = "";
    localanqf.aae = "";
    localanqf.bZd = "";
    localanqf.cgv = "";
    localanqf.bZe = "";
    localanqf.filterId = "";
    localanqf.cgw = "";
    localanqf.cgx = "";
    localanqf.cgy = "";
    localanqf.cgz = "";
    localanqf.cgA = "";
    localanqf.cgB = "";
    localanqf.cgC = "";
    localanqf.cgD = "";
    localanqf.cgE = "";
    localanqf.cgF = "";
    return localanqf;
  }
  
  public static void a(aygz paramaygz)
  {
    if ((paramaygz != null) && (paramaygz.a != null) && (paramaygz.a.asi == 14)) {
      if (paramaygz.La()) {
        break label57;
      }
    }
    label57:
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00898", "", "", "0X800A55F", "0X800A55F", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(aygz paramaygz, ayrk paramayrk)
  {
    if (paramayrk == null) {}
    while ((paramaygz == null) || (paramaygz.a == null) || (paramaygz.a.asi != 14)) {
      return;
    }
    if (paramayrk.isVideo) {}
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00898", "", "", "0X800A55C", "0X800A55C", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(ayrk paramayrk)
  {
    c(null, paramayrk);
  }
  
  public static void a(BoyDataReport paramBoyDataReport)
  {
    if (paramBoyDataReport != null) {
      ThreadManager.post(new CaptureReportUtil.1(paramBoyDataReport), 5, null, false);
    }
  }
  
  public static void aCD()
  {
    dyy = -1;
    aae = "";
    bZd = "";
    lensId = "";
    bZe = "";
    filterId = "";
    czZ = false;
    cAa = false;
    videoDuration = -1L;
    cAc = false;
    cAb = false;
    cAd = false;
  }
  
  private static void aF(long paramLong1, long paramLong2)
  {
    anqf localanqf = a();
    localanqf.Uq = "0X8008937";
    localanqf.Ur = "0X8008937";
    localanqf.bZd = bZd;
    localanqf.cgv = lensId;
    localanqf.bZe = ("" + paramLong1);
    if (localanqf.dLH == 5) {
      localanqf.aae = aae;
    }
    localanqf.cgz = (paramLong2 / 1000L + "");
    anns.a(null, localanqf);
  }
  
  public static void aF(String paramString, long paramLong)
  {
    anqf localanqf = a();
    localanqf.Uq = "0X8008939";
    localanqf.Ur = "0X8008939";
    localanqf.bZd = bZd;
    localanqf.cgv = lensId;
    if (localanqf.dLH == 5) {
      localanqf.aae = aae;
    }
    localanqf.bZe = paramString;
    localanqf.cgz = ((float)paramLong / 1000.0F + "");
    anns.a(null, localanqf);
  }
  
  private static void aP(String paramString1, String paramString2, String paramString3)
  {
    anqf localanqf = a();
    localanqf.Uq = "0X8008936";
    localanqf.Ur = "0X8008936";
    localanqf.bZd = bZd;
    localanqf.cgv = lensId;
    localanqf.bZe = paramString2;
    localanqf.filterId = paramString1;
    if (localanqf.dLH == 5) {
      localanqf.aae = aae;
    }
    localanqf.cgw = paramString3;
    anns.a(null, localanqf);
  }
  
  public static void aR(long paramLong, int paramInt)
  {
    if (cAa)
    {
      anqf localanqf = a();
      localanqf.Uq = "0X800893A";
      localanqf.Ur = "0X800893A";
      localanqf.bZd = bZd;
      localanqf.cgv = lensId;
      localanqf.cgu = (paramInt + "");
      if (localanqf.dLH == 5) {
        localanqf.aae = aae;
      }
      localanqf.cgz = ((float)paramLong / 1000.0F + "");
      anns.a(null, localanqf);
    }
  }
  
  public static void b(aygz paramaygz)
  {
    if ((paramaygz != null) && (paramaygz.a != null) && (paramaygz.a.asi == 14)) {
      if (paramaygz.La()) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00898", "", "", "0X800A55E", "0X800A55E", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void b(aygz paramaygz, ayrk paramayrk)
  {
    if (paramayrk == null) {}
    while ((paramaygz == null) || (paramaygz.a == null) || (paramaygz.a.asi != 14)) {
      return;
    }
    if (paramayrk.isVideo) {}
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00898", "", "", "0X800A55B", "0X800A55B", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void c(aygz paramaygz)
  {
    if ((paramaygz != null) && (paramaygz.a != null) && (paramaygz.a.asi == 14)) {
      anot.a(null, "dc00898", "", "", "0X800A55D", "0X800A55D", 0, 0, "", "", "", "");
    }
  }
  
  public static void c(aygz paramaygz, ayrk paramayrk)
  {
    int i = 1;
    if (paramayrk == null) {}
    while ((paramaygz != null) && (paramaygz.a != null) && (paramaygz.a.asi != 14)) {
      return;
    }
    if (paramayrk.messageType == 1)
    {
      paramaygz = "2";
      if (!paramayrk.isVideo) {
        break label96;
      }
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X800A55A", "0X800A55A", i, 0, paramaygz, "", "", "");
      return;
      if (paramayrk.messageType == 0)
      {
        paramaygz = "1";
        break;
      }
      paramaygz = "3";
      break;
      label96:
      i = 2;
    }
  }
  
  public static void d(aygz paramaygz)
  {
    if ((paramaygz != null) && (paramaygz.a != null) && (paramaygz.a.asi == 14)) {
      if (paramaygz.La()) {
        break label59;
      }
    }
    label59:
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00898", "", "", "0X800A559", "0X800A559", i, 0, "", "", "", "");
      return;
    }
  }
  
  public static void dA(int paramInt, String paramString)
  {
    if (!cAd) {
      return;
    }
    anqf localanqf = a();
    localanqf.Uq = "0X8008430";
    localanqf.Ur = "0X8008430";
    localanqf.toUin = paramString;
    if (localanqf.dLH == 5) {
      localanqf.aae = aae;
    }
    localanqf.bZd = bZd;
    localanqf.cgv = lensId;
    localanqf.bZe = bZe;
    localanqf.filterId = filterId;
    localanqf.cgw = (paramInt + "");
    localanqf.cgy = "";
    paramString = new StringBuilder();
    if (cAc) {}
    for (int i = 2;; i = 1)
    {
      localanqf.cgx = (i + "");
      anns.a(null, localanqf);
      if (czZ)
      {
        localanqf.Uq = "0X80083B2";
        localanqf.Ur = "0X80083B2";
        anns.a(null, localanqf);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, dyy, filterId);
      return;
    }
  }
  
  public static void dB(int paramInt, String paramString)
  {
    if (!cAd) {
      return;
    }
    anqf localanqf = a();
    localanqf.Uq = "0X8008433";
    localanqf.Ur = "0X8008433";
    localanqf.toUin = paramString;
    localanqf.bZd = bZd;
    localanqf.cgv = lensId;
    localanqf.bZe = bZe;
    localanqf.filterId = filterId;
    if (localanqf.dLH == 5) {
      localanqf.aae = aae;
    }
    localanqf.cgw = (paramInt + "");
    paramString = new StringBuilder();
    if (cAb) {}
    for (int i = 2;; i = 1)
    {
      localanqf.cgx = (i + "");
      localanqf.cgy = String.valueOf(aauj.a().aYL);
      localanqf.cgz = (videoDuration + "");
      anns.a(null, localanqf);
      if (czZ)
      {
        localanqf.Uq = "0X80083B1";
        localanqf.Ur = "0X80083B1";
        anns.a(null, localanqf);
      }
      QmcfManager.getInstance().reportQmcfFrameConsume(paramInt, dyy, filterId);
      return;
    }
  }
  
  public static void dKr()
  {
    anqf localanqf = a();
    localanqf.Uq = "0X8008423";
    localanqf.Ur = "0X8008423";
    anns.a(null, localanqf);
  }
  
  public static void dKs()
  {
    if (!cAd) {
      return;
    }
    anqf localanqf = a();
    localanqf.Uq = "0X8008424";
    localanqf.Ur = "0X8008424";
    anns.a(null, localanqf);
  }
  
  public static void dKt()
  {
    if (!cAd) {
      return;
    }
    anqf localanqf = a();
    localanqf.Uq = "0X8008753";
    localanqf.Ur = "0X8008753";
    anns.a(null, localanqf);
  }
  
  public static void dKu()
  {
    if (!cAd) {
      return;
    }
    anqf localanqf = a();
    localanqf.Uq = "0X8008426";
    localanqf.Ur = "0X8008426";
    anns.a(null, localanqf);
  }
  
  public static void dKv()
  {
    if (!cAd) {
      return;
    }
    anqf localanqf = a();
    localanqf.Uq = "0X8008428";
    localanqf.Ur = "0X8008428";
    anns.a(null, localanqf);
  }
  
  public static void dKw()
  {
    if (!cAd) {
      return;
    }
    anqf localanqf = a();
    localanqf.Uq = "0X800842A";
    localanqf.Ur = "0X800842A";
    anns.a(null, localanqf);
  }
  
  public static void dKx()
  {
    if (dyy == 10002) {
      rar.a("video_edit", "camera_clkdouble", 0, 0, new String[0]);
    }
  }
  
  public static void dKy()
  {
    anqf localanqf = a();
    localanqf.Uq = "0X8008F10";
    localanqf.Ur = "0X8008F10";
    anns.a(null, localanqf);
  }
  
  public static void e(aygz paramaygz)
  {
    if ((paramaygz != null) && (paramaygz.a != null) && (paramaygz.a.asi == 14)) {
      anot.a(null, "dc00898", "", "", "0X800A558", "0X800A558", 0, 0, "", "", "", "");
    }
  }
  
  private static String eR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 0: 
      return "miss";
    case 1: 
      return "good";
    case 2: 
      return "great";
    }
    return "perfect";
  }
  
  public static void f(aygz paramaygz)
  {
    if ((paramaygz != null) && (paramaygz.a != null) && (paramaygz.a.asi == 14)) {
      anot.a(null, "dc00898", "", "", "0X800A557", "0X800A557", 0, 0, "", "", "", "");
    }
  }
  
  public static void g(aygz paramaygz)
  {
    if ((paramaygz != null) && (paramaygz.a != null) && (paramaygz.a.asi == 14)) {
      anot.a(null, "dc00898", "", "", "0X800A556", "0X800A556", 0, 0, "", "", "", "");
    }
  }
  
  public static void h(aygz paramaygz)
  {
    if ((paramaygz != null) && (paramaygz.a != null) && (paramaygz.a.asi == 14)) {
      anot.a(null, "dc00898", "", "", "0X800A555", "0X800A555", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwx
 * JD-Core Version:    0.7.0.1
 */