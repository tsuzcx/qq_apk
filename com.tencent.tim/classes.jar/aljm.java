import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class aljm
  implements Manager
{
  List<alji> EW = null;
  List<String> EX = null;
  QQAppInterface mApp = null;
  
  public aljm(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    cis();
  }
  
  public alji b(String paramString)
  {
    if (aqmr.isEmpty(paramString)) {}
    while ((this.EW == null) || (this.EW.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.EW.iterator();
    alji localalji;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localalji = (alji)localIterator.next();
    } while ((localalji.bWH == null) || (!localalji.bWH.equalsIgnoreCase(paramString)));
    for (paramString = localalji;; paramString = null) {
      return paramString;
    }
  }
  
  public void cis()
  {
    String str = aljk.n(this.mApp);
    QLog.i("QAssistantManager", 2, "loadConfigFromLoacl config is " + str);
    yH(str);
  }
  
  public boolean oa(String paramString)
  {
    if ((aqmr.isEmpty(paramString)) || (this.EX == null)) {
      return false;
    }
    Iterator localIterator = this.EX.iterator();
    while (localIterator.hasNext()) {
      if (((String)localIterator.next()).equalsIgnoreCase(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public void onDestroy() {}
  
  public void yH(String paramString)
  {
    if (aqmr.isEmpty(paramString)) {
      return;
    }
    if (this.EW == null)
    {
      this.EW = new ArrayList();
      label26:
      if (this.EX != null) {
        break label81;
      }
      this.EX = new ArrayList();
    }
    for (;;)
    {
      paramString = aljk.f(paramString, this.EX);
      if (paramString == null) {
        break;
      }
      this.EW.addAll(paramString);
      return;
      this.EW.clear();
      break label26;
      label81:
      this.EX.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aljm
 * JD-Core Version:    0.7.0.1
 */