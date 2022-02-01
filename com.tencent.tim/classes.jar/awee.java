import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.a;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class awee
  extends WebViewPlugin
{
  private long Ey;
  private long Ez;
  private int bCu;
  private Map<Integer, String> qn;
  private int state = 0;
  
  public awee()
  {
    this.mPluginNameSpace = "gdtReportPlugin";
  }
  
  private void b(int paramInt, Map<String, Object> paramMap)
  {
    Log.i("gdtReportPlugin", "173\t" + eh());
    if ((paramMap != null) && (paramMap.containsKey("errorCode")) && ((paramMap.get("errorCode") instanceof Integer))) {}
    for (paramInt = Math.abs(((Integer)paramMap.get("errorCode")).intValue());; paramInt = 0)
    {
      avzf.a().a().a(this.qn, 2014, 1, eh(), paramInt);
      return;
    }
  }
  
  private void c(int paramInt, Map<String, Object> paramMap)
  {
    this.Ez = SystemClock.elapsedRealtime();
    if ((paramMap != null) && (paramMap.containsKey("errorCode")) && ((paramMap.get("errorCode") instanceof Integer))) {}
    for (int i = Math.abs(((Integer)paramMap.get("errorCode")).intValue());; i = 0)
    {
      avzf.a().a().a(this.qn, 2000, paramInt, eh(), i);
      Log.i("gdtReportPlugin", paramInt + 120 + "\t" + eh());
      return;
    }
  }
  
  private void eDm()
  {
    Log.i("gdtReportPlugin", "172\t" + eh());
    avzf.a().a().a(this.qn, 2014, 0, eh(), 0L);
  }
  
  private void eDn()
  {
    Log.i("gdtReportPlugin", "129\t" + eh());
    avzf.a().a().a(this.qn, 2005, 0, getStayTime(), 0L);
  }
  
  private void eDo()
  {
    this.Ez = SystemClock.elapsedRealtime();
    avzf.a().a().a(this.qn, 2000, 0, eh(), 0L);
    Log.i("gdtReportPlugin", "120\t" + eh());
  }
  
  private long eh()
  {
    return SystemClock.elapsedRealtime() - this.Ey;
  }
  
  public static boolean gJ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new URL(paramString).getHost();
        String[] arrayOfString = "ttc.gdt.qq.com#c.gdt.qq.com#xc.gdt.qq.com".split("#");
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = paramString.equals(arrayOfString[i]);
          if (bool) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (Exception paramString) {}
    }
  }
  
  private long getStayTime()
  {
    return SystemClock.elapsedRealtime() - this.Ez;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (this.mRuntime.getActivity().getIntent().getBooleanExtra("needGdtLandingPageReport", false)) {
      switch (this.state)
      {
      default: 
        if (this.bCu == 1)
        {
          if ((paramLong != 8589934593L) || (this.state != 1) || (gJ(paramString))) {
            break label402;
          }
          eDm();
          this.bCu = 2;
        }
        break;
      }
    }
    for (;;)
    {
      paramString = new QZoneClickReport.a();
      paramString.actionType = String.valueOf(478);
      if (paramLong == 8589934599L)
      {
        paramString.cMI = String.valueOf(2);
        QZoneClickReport.report(this.mRuntime.a().getAccount(), paramString, true);
      }
      return false;
      if (paramLong != 8589934593L) {
        break;
      }
      if ((gJ(paramString)) && (this.bCu == 0)) {
        this.bCu = 1;
      }
      List localList = (List)this.mRuntime.getActivity().getIntent().getSerializableExtra("FeedDataCookie");
      if ((localList != null) && (localList.size() == 1)) {
        this.qn = ((Map)localList.get(0));
      }
      this.Ey = SystemClock.elapsedRealtime();
      this.state = 1;
      break;
      if (paramLong == 8589934594L)
      {
        this.state = 2;
        eDo();
        break;
      }
      if (paramLong == 8589934595L)
      {
        this.state = 3;
        c(1, paramMap);
        break;
      }
      if (paramLong == 8589934601L)
      {
        this.state = 4;
        c(94, paramMap);
        eDn();
        break;
      }
      if (paramLong != 8589934597L) {
        break;
      }
      this.state = 4;
      c(95, paramMap);
      eDn();
      break;
      if (paramLong != 8589934597L) {
        break;
      }
      eDn();
      this.state = 4;
      break;
      if (paramLong == 8589934593L)
      {
        this.state = 4;
        eDn();
        this.Ey = SystemClock.elapsedRealtime();
        break;
      }
      if (paramLong != 8589934597L) {
        break;
      }
      this.state = 4;
      eDn();
      break;
      label402:
      if ((gJ(paramString)) && ((paramLong == 8589934598L) || (paramLong == 8589934595L)))
      {
        this.bCu = 2;
        b(1, paramMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awee
 * JD-Core Version:    0.7.0.1
 */