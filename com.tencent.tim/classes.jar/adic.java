import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.armap.ARMapTracer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class adic
{
  static adic a;
  public long Td;
  public long Te;
  public long Tf;
  public long Tg;
  public long Th;
  public int cGk;
  public long starTime;
  
  public static adic a()
  {
    try
    {
      if (a == null) {
        a = new adic();
      }
      return a;
    }
    finally {}
  }
  
  public static void a(adhv paramadhv, adht paramadht)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("errorcode_mq", String.valueOf(paramadht.cGd));
    localHashMap.put("errorcode_yt", String.valueOf(paramadht.cGe));
    if ((paramadht.cGd == 0) && (paramadht.cGe == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      int i = 0;
      int m = 0;
      int j = 0;
      int k = 0;
      if (bool)
      {
        i = m;
        if (paramadhv.a.b != null) {
          i = paramadhv.a.b.length;
        }
        j = k;
        if (paramadht.ur != null) {
          j = paramadht.ur.size();
        }
        localHashMap.put("send_person_count", String.valueOf(i));
        localHashMap.put("receive_star_count", String.valueOf(j));
      }
      long l = System.currentTimeMillis() - paramadhv.Tb;
      localHashMap.put("upload_cost", String.valueOf(l));
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actARFaceCloudResult", bool, 0L, 0L, localHashMap, "", true);
      if (QLog.isColorLevel()) {
        QLog.d("ARFaceDataCollector", 2, "reportARFaceCloudResult,sendPersonCount  = " + i + ",starCount = " + j + ",uploadCost = " + l);
      }
      return;
    }
  }
  
  public static void aE(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARFaceDataCollector", 2, "reportARTrackStablity,duration  = " + paramLong + ",count = " + paramInt);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_type", String.valueOf(ARMapTracer.BU()));
    localHashMap.put("recoverCount", String.valueOf(paramInt));
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actARFaceTrackStability", true, paramLong, 0L, localHashMap, "", true);
  }
  
  public static void cRR()
  {
    adic localadic = a();
    localadic.cRQ();
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_type", String.valueOf(ARMapTracer.BU()));
    localHashMap.put("ppTotalCost", String.valueOf(localadic.Td));
    localHashMap.put("ppFaceDectectCost", String.valueOf(localadic.Te));
    localHashMap.put("upload_cost", String.valueOf(localadic.Tf));
    localHashMap.put("ppExtractCost", String.valueOf(localadic.Tg));
    localHashMap.put("ppExtractFaceCount", String.valueOf(localadic.cGk));
    localHashMap.put("firstDrawUICost", String.valueOf(localadic.Th));
    long l2 = localadic.Td;
    if (localadic.Tg > localadic.Tf) {}
    for (long l1 = localadic.Tg;; l1 = localadic.Tf)
    {
      localHashMap.put("totalCost", String.valueOf(l1 + l2 + localadic.Th));
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actFaceStepDuration", true, 0L, 0L, localHashMap, "", true);
      localadic.reset();
      return;
    }
  }
  
  public static void ef(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARFaceDataCollector", 2, "reportARSoLoadResult,libName  = " + paramString + ",result = " + paramInt);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("libName", paramString);
    localHashMap.put("loadResult", String.valueOf(paramInt));
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actARFaceSoLoadResult", true, 0L, 0L, localHashMap, "", true);
  }
  
  public static void iD(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARFaceDataCollector", 2, "reportARFaceInit,initCost  = " + paramLong + ",devType = " + ARMapTracer.BU());
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_type", String.valueOf(ARMapTracer.BU()));
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actARFaceInit", true, paramLong, 0L, localHashMap, "", true);
  }
  
  public static void iE(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARFaceDataCollector", 2, "reportARFaceDetect,cost  = " + paramLong);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_type", String.valueOf(ARMapTracer.BU()));
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actARFaceDetect", true, paramLong, 0L, localHashMap, "", true);
  }
  
  public static void iF(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARFaceDataCollector", 2, "reportARExtracFaceFeatrue,cost  = " + paramLong);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("device_type", String.valueOf(ARMapTracer.BU()));
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actARExtractFaceFeatrue", true, paramLong, 0L, localHashMap, "", true);
  }
  
  public void cRQ()
  {
    long l2 = this.Td;
    if (this.Tg > this.Tf) {}
    for (long l1 = this.Tg;; l1 = this.Tf)
    {
      long l3 = this.Th;
      long l4 = System.currentTimeMillis();
      long l5 = this.starTime;
      if (QLog.isColorLevel()) {
        QLog.d("ARFaceDataCollector", 2, "printStepDuration preprocessTotalCost  = " + this.Td + ",preprocessFaceDetectCost = " + this.Te + ",picUploadCost = " + this.Tf + ",preprocessFeatureExtrctCost = " + this.Tg + ",preprocessFaceCount = " + this.cGk + ",firstDrawUICost = " + this.Th + ",totalCost = " + (l1 + l2 + l3) + ",starTime = " + this.starTime + ",realCost = " + (l4 - l5));
      }
      return;
    }
  }
  
  public void reset()
  {
    this.starTime = 0L;
    this.Td = 0L;
    this.Te = 0L;
    this.Tf = 0L;
    this.Tg = 0L;
    this.Th = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adic
 * JD-Core Version:    0.7.0.1
 */