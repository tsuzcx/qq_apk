import Wallet.RedInfoSyncReq;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig.a;
import com.tencent.mobileqq.activity.qwallet.red.QWRedConfig;
import com.tencent.mobileqq.activity.qwallet.red.QWRedConfig.RedInfo;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.1;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.manager.Manager;

public class aadk
  implements aaai.b, Manager
{
  private QWRedConfig a;
  private QQAppInterface mApp;
  
  public aadk(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "QWalletRedManager init");
    }
    this.mApp = paramQQAppInterface;
    this.a = QWRedConfig.readConfig(paramQQAppInterface);
    syncData();
  }
  
  private void syncData()
  {
    ThreadManager.executeOnSubThread(new QWalletRedManager.1(this));
  }
  
  public void Af(String paramString)
  {
    List localList = this.a.getCurShowRedInfosByPath(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "doClick" + paramString + "|" + localList);
    }
    paramString = new LinkedList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      QWRedConfig.RedInfo localRedInfo = (QWRedConfig.RedInfo)localIterator.next();
      if (localRedInfo.doClick()) {
        paramString.add(localRedInfo);
      }
    }
    if (paramString.size() > 0)
    {
      this.a.saveConfig();
      zyb.a(RedInfoSyncReq.createReq(paramString), new aadl(this));
    }
    if (localList.size() > 0) {
      VACDReportUtil.a(null, "QWalletStat", "QWalletRedClick", "QWalletRedClick", QWRedConfig.RedInfo.transToReportStr(localList), 0, null);
    }
  }
  
  public void Ag(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    hy(localLinkedList);
  }
  
  public aadk.a a(String paramString)
  {
    aadk.a locala = this.a.getShowInfoByPath(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("QWalletRedManager", 2, "getShowInfo path=" + paramString + ",res=" + locala);
    }
    return locala;
  }
  
  public void a(String paramString1, String paramString2, QWalletConfig.a parama)
  {
    this.a.parseConfig(parama);
  }
  
  public String getNotShowListStr()
  {
    return this.a.getNotShowListStr();
  }
  
  public void hy(List<String> paramList)
  {
    if (paramList == null) {}
    LinkedList localLinkedList;
    do
    {
      return;
      localLinkedList = new LinkedList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        localLinkedList.addAll(this.a.getCurShowRedInfosByPath(str));
      }
    } while (localLinkedList.size() <= 0);
    VACDReportUtil.a(null, "QWalletStat", "QWalletRedShow", "QWalletRedShow", QWRedConfig.RedInfo.transToReportStr(localLinkedList), 0, null);
  }
  
  public void onDestroy()
  {
    aaai localaaai = (aaai)this.mApp.getManager(245);
    if (localaaai != null) {
      localaaai.b("redPoint", this);
    }
  }
  
  public static class a
  {
    public String buffer;
    public boolean bvg;
    public boolean bvh;
    public String content;
    
    public a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
    {
      this.bvg = paramBoolean1;
      this.bvh = paramBoolean2;
      this.content = paramString1;
      this.buffer = paramString2;
    }
    
    public String toString()
    {
      return "ShowInfo{Red=" + this.bvg + ",Corner=" + this.bvh + ",con='" + this.content + '\'' + ",buf='" + this.buffer + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aadk
 * JD-Core Version:    0.7.0.1
 */