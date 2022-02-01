import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.richmedia.dc.DataReport;
import com.tencent.mobileqq.richmedia.dc.DataReport.ReportTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class alyp
  extends alyt
{
  private alyp.a a;
  private boolean mReported;
  
  public alyp(Context paramContext)
  {
    super(paramContext);
  }
  
  public void dLD()
  {
    if ((this.a != null) && (!this.mReported)) {
      alyp.a.b(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void dLE()
  {
    if ((this.a != null) && (!this.mReported)) {
      alyp.a.c(this.a, SystemClock.uptimeMillis());
    }
  }
  
  public void exit()
  {
    if ((this.a != null) && (!this.mReported))
    {
      DataReport.ReportTask localReportTask = new DataReport.ReportTask("Pic.AioPreview.Progressive", this.a.v("Pic.AioPreview.Progressive"));
      DataReport.a().a(localReportTask);
      this.mReported = true;
    }
  }
  
  public void pG()
  {
    if ((this.a != null) && (!this.mReported)) {
      alyp.a.b(this.a, true);
    }
  }
  
  public void vk(boolean paramBoolean)
  {
    if ((this.a == null) && (!this.mReported))
    {
      alyp.a locala = new alyp.a(null);
      alyp.a.a(locala, paramBoolean);
      alyp.a.a(locala, SystemClock.uptimeMillis());
      this.a = locala;
    }
  }
  
  static class a
    extends alys
  {
    private long aib;
    private long aic;
    private boolean bje;
    private boolean cBr;
    private long ie;
    
    public HashMap<String, String> v(String paramString)
    {
      paramString = null;
      if ((this.ie == 0L) || (this.aic == 0L)) {
        return null;
      }
      if (QLog.isColorLevel()) {
        paramString = new StringBuilder();
      }
      HashMap localHashMap = new HashMap();
      if (this.bje)
      {
        localHashMap.put("is_progressive", "progressive");
        localHashMap.put("view_count", "1");
        if (this.cBr)
        {
          localHashMap.put("failure", "1");
          if (QLog.isColorLevel())
          {
            paramString.append("progressive:\n");
            paramString.append("refresh_dp:" + String.valueOf(this.aib - this.ie) + "\n");
            paramString.append("refresh_large:" + String.valueOf(this.aic - this.ie));
            QLog.i(alyt.aeM, 2, paramString.toString());
          }
        }
      }
      label391:
      for (;;)
      {
        return localHashMap;
        if (this.aib > this.ie) {
          localHashMap.put("to_dp", String.valueOf(this.aib - this.ie));
        }
        if ((this.aic <= this.ie) || (this.aic <= this.aib)) {
          break;
        }
        localHashMap.put("to_large", String.valueOf(this.aic - this.ie));
        break;
        localHashMap.put("is_progressive", "baseline");
        localHashMap.put("view_count", "1");
        if (this.cBr) {
          localHashMap.put("failure", "1");
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label391;
          }
          paramString.append("baseline:\n");
          paramString.append("refresh_large:" + String.valueOf(this.aic - this.ie));
          QLog.i(alyt.aeM, 2, paramString.toString());
          break;
          if (this.aic > this.ie) {
            localHashMap.put("to_large", String.valueOf(this.aic - this.ie));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyp
 * JD-Core Version:    0.7.0.1
 */