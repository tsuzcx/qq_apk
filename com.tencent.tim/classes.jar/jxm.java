import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class jxm
{
  private static jxm jdField_a_of_type_Jxm = new jxm();
  private jxm.a jdField_a_of_type_Jxm$a = new jxm.a(null);
  private boolean acL;
  private boolean acM;
  private long mStartTime;
  
  public static jxm a()
  {
    try
    {
      if (jdField_a_of_type_Jxm == null) {
        jdField_a_of_type_Jxm = new jxm();
      }
      jxm localjxm = jdField_a_of_type_Jxm;
      return localjxm;
    }
    finally {}
  }
  
  public void aAW()
  {
    if (this.jdField_a_of_type_Jxm$a.qY == -1L) {
      this.jdField_a_of_type_Jxm$a.qY = (SystemClock.uptimeMillis() - this.mStartTime);
    }
  }
  
  public void f(String paramString, long paramLong, boolean paramBoolean)
  {
    this.acL = false;
    this.acM = false;
    this.jdField_a_of_type_Jxm$a.reset();
    this.mStartTime = paramLong;
    if (QLog.isColorLevel()) {
      QLog.i("AdvertisementStatistics", 2, "mClickTime:" + this.mStartTime + " sToolShowTime:" + BaseApplicationImpl.sToolShowTime);
    }
    if ((BaseApplicationImpl.sToolShowTime == 0L) || (BaseApplicationImpl.sToolShowTime > paramLong)) {
      this.jdField_a_of_type_Jxm$a.aEk = 0;
    }
    for (this.jdField_a_of_type_Jxm$a.qX = (BaseApplicationImpl.sToolShowTime - paramLong);; this.jdField_a_of_type_Jxm$a.qX = 0L)
    {
      long l = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Jxm$a.qW = (l - paramLong);
      this.jdField_a_of_type_Jxm$a.adid = paramString;
      this.jdField_a_of_type_Jxm$a.isFirst = paramBoolean;
      return;
      this.jdField_a_of_type_Jxm$a.aEk = 1;
    }
  }
  
  public void n(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.acM) {
      return;
    }
    this.acM = true;
    this.jdField_a_of_type_Jxm$a.name = "IMAX_Ad_Remind_Dialog_Click";
    this.jdField_a_of_type_Jxm$a.adid = paramString1;
    this.jdField_a_of_type_Jxm$a.vid = paramString2;
    paramString1 = this.jdField_a_of_type_Jxm$a.s();
    if (QLog.isColorLevel()) {
      QLog.i("AdvertisementStatistics", 2, this.jdField_a_of_type_Jxm$a.toString() + " ok " + paramBoolean);
    }
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", this.jdField_a_of_type_Jxm$a.name, paramBoolean, this.jdField_a_of_type_Jxm$a.qY, 0L, paramString1, "", false);
  }
  
  static class a
  {
    public int aEk = -1;
    public int aEl = -1;
    public String adid = "";
    public boolean isFirst = true;
    public String name = "IMAX_Ad_StartCost";
    public long qW = -1L;
    public long qX = -1L;
    public long qY = -1L;
    public long qZ = -1L;
    public String vid = "";
    
    public void reset()
    {
      this.adid = "";
      this.vid = "";
      this.aEk = -1;
      this.aEl = -1;
      this.qW = -1L;
      this.qX = -1L;
      this.qY = -1L;
      this.qZ = -1L;
      this.isFirst = true;
    }
    
    public HashMap<String, String> s()
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("adid", this.adid);
      localHashMap.put("vid", this.vid);
      localHashMap.put("webPreloaded", "" + this.aEk);
      localHashMap.put("videoPreloaded", "" + this.aEl);
      localHashMap.put("webProStartCost", "" + this.qX);
      localHashMap.put("webActStartCost", "" + this.qW);
      localHashMap.put("actDisplayCost", "" + this.qY);
      localHashMap.put("videoDisplayCost", "" + this.qZ);
      localHashMap.put("isFirst", "" + this.isFirst);
      return localHashMap;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[name:" + this.name).append(" adid:" + this.adid).append(" vid:" + this.vid).append(" webPreloaded:" + this.aEk).append(" videoPreloaded:" + this.aEl).append(" webProStartCost:" + this.qX).append(" webActStartCost:" + this.qW).append(" actDisplayCost:" + this.qY).append(" videoDisplayCost:" + this.qZ).append(" isFirst:" + this.isFirst + "]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jxm
 * JD-Core Version:    0.7.0.1
 */