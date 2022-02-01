import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.1;
import com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.2;
import com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.3;
import com.tencent.mobileqq.teamwork.spread.ConfigSettingForDataLine.LocalWtTicketPromise.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

public class aocx
{
  private aetr a;
  private long aoV;
  private int dNY;
  public QQAppInterface mApp;
  
  public aocx(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    cIU();
  }
  
  private aetr b()
  {
    if (this.a == null) {
      this.a = aets.a();
    }
    return this.a;
  }
  
  private void c(aetr paramaetr)
  {
    if (paramaetr == null) {
      return;
    }
    try
    {
      paramaetr.bc(((aobh)this.mApp.getBusinessHandler(122)).ae());
      return;
    }
    catch (Exception paramaetr)
    {
      QLog.e("ConfigSettingForDataLine", 2, " getTemplateListFromCgi failed :" + paramaetr.toString());
      paramaetr.printStackTrace();
    }
  }
  
  private void cIU()
  {
    ThreadManager.executeOnSubThread(new ConfigSettingForDataLine.2(this));
  }
  
  public String a(aoct paramaoct)
  {
    if ((paramaoct instanceof aocv))
    {
      Map localMap = b().ah();
      paramaoct = ahbj.getExtension(paramaoct.AB());
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        aetr.a locala = (aetr.a)localMap.get((String)localIterator.next());
        String[] arrayOfString = locala.eJ;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(paramaoct)) {
            return locala.strTips;
          }
          i += 1;
        }
      }
    }
    return "";
  }
  
  public String[] a(aoct paramaoct)
  {
    int i = 0;
    Map localMap = b().ah();
    Object localObject = b().et();
    if ((paramaoct instanceof aocv))
    {
      paramaoct = ahbj.getExtension(paramaoct.AB());
      localObject = localMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        aetr.a locala = (aetr.a)localMap.get((String)((Iterator)localObject).next());
        String[] arrayOfString = locala.eJ;
        int j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(paramaoct)) {
            return locala.eH;
          }
          i += 1;
        }
      }
    }
    paramaoct = new String[((List)localObject).size()];
    while (i < ((List)localObject).size())
    {
      paramaoct[i] = ((aetr.b)((List)localObject).get(i)).keyword;
      i += 1;
    }
    return paramaoct;
    return new String[0];
  }
  
  public boolean azv()
  {
    boolean bool = false;
    long l = System.currentTimeMillis();
    this.aoV = this.mApp.getApp().getSharedPreferences(this.mApp.getCurrentAccountUin() + "_m_str_teamwork_dataline_tips_sp", 0).getLong("file_str_lstat_show_time_local", 0L);
    if (l - this.aoV > b().Cx() * 1000) {
      bool = true;
    }
    return bool;
  }
  
  public String b(aoct paramaoct)
  {
    if ((paramaoct instanceof aocv))
    {
      Map localMap = b().ah();
      paramaoct = ahbj.getExtension(paramaoct.AB());
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        aetr.a locala = (aetr.a)localMap.get((String)localIterator.next());
        String[] arrayOfString = locala.eJ;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfString[i].equalsIgnoreCase(paramaoct)) {
            return locala.bBr;
          }
          i += 1;
        }
      }
    }
    return "";
  }
  
  public void b(aetr paramaetr)
  {
    if (paramaetr == null) {
      return;
    }
    this.a = paramaetr;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.mApp.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.mApp.getCurrentAccountUin();
      paramaetr = new aocx.a(this, paramaetr);
      localTicketManager.GetPskey(str, 16L, new String[] { "docs.qq.com" }, paramaetr);
      return;
    }
    ThreadManager.excute(new ConfigSettingForDataLine.1(this, paramaetr), 128, null, false);
  }
  
  public int getLocalCount()
  {
    return this.dNY;
  }
  
  public void i(DataLineMsgRecord paramDataLineMsgRecord)
  {
    this.aoV = System.currentTimeMillis();
    this.dNY += 1;
    ThreadManager.executeOnSubThread(new ConfigSettingForDataLine.3(this));
  }
  
  public static class a
    implements WtTicketPromise
  {
    private aetr a;
    private WeakReference<aocx> bs;
    
    public a(aocx paramaocx, aetr paramaetr)
    {
      this.bs = new WeakReference(paramaocx);
      this.a = paramaetr;
    }
    
    public void Done(Ticket paramTicket)
    {
      if ((paramTicket != null) && (paramTicket._pskey_map != null))
      {
        ThreadManager.excute(new ConfigSettingForDataLine.LocalWtTicketPromise.1(this), 128, null, false);
        return;
      }
      if (this.a != null) {
        this.a.Hv(false);
      }
      QLog.e("ConfigSettingForDataLine", 2, "get pskey failed ticket is null");
    }
    
    public void Failed(ErrMsg paramErrMsg)
    {
      QLog.e("ConfigSettingForDataLine", 2, "get pskey failed ticket failed");
      if (this.a != null) {
        this.a.Hv(false);
      }
    }
    
    public void Timeout(ErrMsg paramErrMsg)
    {
      if (this.a != null) {
        this.a.Hv(false);
      }
      QLog.e("ConfigSettingForDataLine", 2, "get pskey failed ticket time oiut");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aocx
 * JD-Core Version:    0.7.0.1
 */