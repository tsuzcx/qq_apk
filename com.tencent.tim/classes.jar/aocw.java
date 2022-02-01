import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.teamwork.spread.ConfigSetting.1;
import com.tencent.mobileqq.teamwork.spread.ConfigSetting.2;
import com.tencent.mobileqq.teamwork.spread.ConfigSetting.3;
import com.tencent.mobileqq.teamwork.spread.ConfigSetting.LocalWtTicketPromise.1;
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

public class aocw
{
  private aeur a;
  private long aoV;
  private int dNY;
  public QQAppInterface mApp;
  
  public aocw(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    cIU();
  }
  
  private aeur b()
  {
    if (this.a == null) {
      this.a = aeus.a();
    }
    return this.a;
  }
  
  private void cIU()
  {
    ThreadManager.executeOnSubThread(new ConfigSetting.1(this));
  }
  
  private void d(aeur paramaeur)
  {
    if (paramaeur == null) {
      return;
    }
    try
    {
      paramaeur.bc(((aobh)this.mApp.getBusinessHandler(122)).ae());
      return;
    }
    catch (Exception paramaeur)
    {
      QLog.e("ConfigSetting", 2, " getTemplateListFromCgi failed :" + paramaeur.toString());
      paramaeur.printStackTrace();
    }
  }
  
  public aeur.b a(String paramString)
  {
    Iterator localIterator = b().et().iterator();
    while (localIterator.hasNext())
    {
      aeur.b localb = (aeur.b)localIterator.next();
      if (localb.keyword.contains(paramString)) {
        return localb;
      }
    }
    return null;
  }
  
  public String a(aocs paramaocs)
  {
    Object localObject1;
    Object localObject2;
    if (((paramaocs instanceof aocu)) || ((paramaocs instanceof aoda)))
    {
      localObject1 = b().ah();
      paramaocs = ahbj.getExtension(paramaocs.AB());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (aeur.a)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((aeur.a)localObject3).eJ;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramaocs)) {
          return ((aeur.a)localObject3).strTips;
        }
        i += 1;
      }
      continue;
      if ((paramaocs instanceof aocz))
      {
        localObject2 = b().et();
        localObject1 = b().h();
        paramaocs = paramaocs.AB();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (aeur.b)((Iterator)localObject2).next();
          if ((paramaocs.contains(((aeur.b)localObject3).keyword)) && (((SparseArray)localObject1).valueAt(((aeur.b)localObject3).templateType) != null)) {
            return ((aeur.a)((SparseArray)localObject1).valueAt(((aeur.b)localObject3).templateType)).strTips;
          }
        }
      }
    }
    return "";
  }
  
  public String[] a(aocs paramaocs)
  {
    int i = 0;
    Map localMap = b().ah();
    Object localObject = b().et();
    if (((paramaocs instanceof aocu)) || ((paramaocs instanceof aoda)))
    {
      paramaocs = ahbj.getExtension(paramaocs.AB());
      localObject = localMap.keySet().iterator();
    }
    while (((Iterator)localObject).hasNext())
    {
      aeur.a locala = (aeur.a)localMap.get((String)((Iterator)localObject).next());
      String[] arrayOfString = locala.eJ;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramaocs)) {
          return locala.eH;
        }
        i += 1;
      }
      continue;
      paramaocs = new String[((List)localObject).size()];
      while (i < ((List)localObject).size())
      {
        paramaocs[i] = ((aeur.b)((List)localObject).get(i)).keyword;
        i += 1;
      }
      return paramaocs;
    }
    return new String[0];
  }
  
  public void aa(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForText)) {
      this.aoV = System.currentTimeMillis();
    }
    this.dNY += 1;
    ThreadManager.executeOnSubThread(new ConfigSetting.3(this));
  }
  
  public boolean azv()
  {
    return System.currentTimeMillis() - this.aoV > b().Cx() * 1000;
  }
  
  public String b(aocs paramaocs)
  {
    Object localObject1;
    Object localObject2;
    if (((paramaocs instanceof aocu)) || ((paramaocs instanceof aoda)))
    {
      localObject1 = b().ah();
      paramaocs = ahbj.getExtension(paramaocs.AB());
      localObject2 = ((Map)localObject1).keySet().iterator();
    }
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (aeur.a)((Map)localObject1).get((String)((Iterator)localObject2).next());
      String[] arrayOfString = ((aeur.a)localObject3).eJ;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfString[i].equalsIgnoreCase(paramaocs)) {
          return ((aeur.a)localObject3).bBr;
        }
        i += 1;
      }
      continue;
      if ((paramaocs instanceof aocz))
      {
        localObject2 = b().et();
        localObject1 = b().h();
        paramaocs = paramaocs.AB();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (aeur.b)((Iterator)localObject2).next();
          if ((paramaocs.contains(((aeur.b)localObject3).keyword)) && (((SparseArray)localObject1).valueAt(((aeur.b)localObject3).templateType) != null)) {
            return ((aeur.a)((SparseArray)localObject1).valueAt(((aeur.b)localObject3).templateType)).bBr;
          }
        }
      }
    }
    return "";
  }
  
  public void c(aeur paramaeur)
  {
    if (paramaeur == null) {
      return;
    }
    this.a = paramaeur;
    TicketManager localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
    if (TextUtils.isEmpty(localTicketManager.getPskey(this.mApp.getCurrentAccountUin(), "docs.qq.com")))
    {
      String str = this.mApp.getCurrentAccountUin();
      paramaeur = new aocw.a(this, paramaeur);
      localTicketManager.GetPskey(str, 16L, new String[] { "docs.qq.com" }, paramaeur);
      return;
    }
    ThreadManager.excute(new ConfigSetting.2(this, paramaeur), 128, null, false);
  }
  
  public int getLocalCount()
  {
    return this.dNY;
  }
  
  public static class a
    implements WtTicketPromise
  {
    private aeur a;
    private WeakReference<aocw> bs;
    
    public a(aocw paramaocw, aeur paramaeur)
    {
      this.bs = new WeakReference(paramaocw);
      this.a = paramaeur;
    }
    
    public void Done(Ticket paramTicket)
    {
      if ((paramTicket != null) && (paramTicket._pskey_map != null))
      {
        ThreadManager.excute(new ConfigSetting.LocalWtTicketPromise.1(this), 128, null, false);
        return;
      }
      if (this.a != null) {
        this.a.Hv(false);
      }
      QLog.e("ConfigSetting", 2, "get pskey failed ticket is null");
    }
    
    public void Failed(ErrMsg paramErrMsg)
    {
      QLog.e("ConfigSetting", 2, "get pskey failed ticket failed");
      if (this.a != null) {
        this.a.Hv(false);
      }
    }
    
    public void Timeout(ErrMsg paramErrMsg)
    {
      if (this.a != null) {
        this.a.Hv(false);
      }
      QLog.e("ConfigSetting", 2, "get pskey failed ticket time oiut");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aocw
 * JD-Core Version:    0.7.0.1
 */