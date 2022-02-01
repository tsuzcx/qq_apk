import android.content.Context;
import android.os.Environment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class amut
{
  private static volatile amut a;
  public static final String cch = Environment.getExternalStorageDirectory() + File.separator + "ArkApp";
  private boolean cEl = true;
  private Map<Integer, amue> mY = new HashMap();
  private Map<Integer, amun> mZ = new HashMap();
  
  private void O(List<amun> arg1, List<amue> paramList1)
  {
    if (??? != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "updateConfig， nativesize :" + ???.size());
      }
      synchronized (this.mZ)
      {
        this.mZ.clear();
        ??? = ???.iterator();
        if (???.hasNext())
        {
          amun localamun = (amun)???.next();
          this.mZ.put(Integer.valueOf(localamun.getID()), localamun);
        }
      }
    }
    for (;;)
    {
      if (paramList1 == null) {
        break label264;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "updateConfig， arksize:" + paramList1.size());
      }
      synchronized (this.mY)
      {
        this.mY.clear();
        paramList1 = paramList1.iterator();
        if (!paramList1.hasNext()) {
          break;
        }
        ??? = (amue)paramList1.next();
        this.mY.put(Integer.valueOf(((amue)???).getID()), ???);
      }
      synchronized (this.mZ)
      {
        this.mZ.clear();
        if (QLog.isColorLevel()) {
          QLog.d("RichNodeFactory", 2, "updateConfig， nativesize = 0");
        }
      }
    }
    for (;;)
    {
      return;
      label264:
      synchronized (this.mY)
      {
        this.mY.clear();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("RichNodeFactory", 2, "updateConfig， arksize = 0");
        return;
      }
    }
  }
  
  public static amut a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        a = new amut();
        a.init();
      }
      return a;
    }
    finally {}
  }
  
  private amuk b(int paramInt)
  {
    amuk localamuk2 = d(paramInt);
    amuk localamuk1 = localamuk2;
    if (localamuk2 == null) {
      localamuk1 = c(paramInt);
    }
    return localamuk1;
  }
  
  private amuk c(int paramInt)
  {
    synchronized (this.mY)
    {
      amue localamue = (amue)this.mY.get(Integer.valueOf(paramInt));
      if (localamue != null) {
        return new amui(localamue);
      }
    }
    return null;
  }
  
  private amuk d(int paramInt)
  {
    if (paramInt == 101) {
      return new amup();
    }
    return null;
  }
  
  private void init()
  {
    initConfig();
  }
  
  private void initConfig()
  {
    ArrayList localArrayList = null;
    Object localObject1 = aesw.a();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "initConfig , config is null");
      }
      return;
    }
    this.cEl = ((aesw)localObject1).ahG();
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeFactory", 2, "mRichSwitchOn :" + this.cEl);
    }
    if (!this.cEl)
    {
      O(null, null);
      return;
    }
    Object localObject2 = ((aesw)localObject1).I("ark");
    Object localObject3 = ((aesw)localObject1).I("native");
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        aesw.a locala = (aesw.a)((Iterator)localObject2).next();
        ((List)localObject1).add(new amue(locala.cOX, locala.bAW, locala.bAX, locala.bAY, "", null));
      }
    }
    for (;;)
    {
      localObject2 = localArrayList;
      if (localObject3 != null)
      {
        localObject2 = localArrayList;
        if (((ArrayList)localObject3).size() > 0)
        {
          localArrayList = new ArrayList();
          localObject3 = ((ArrayList)localObject3).iterator();
          for (;;)
          {
            localObject2 = localArrayList;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localArrayList.add(new amun(((aesw.a)((Iterator)localObject3).next()).cOX));
          }
        }
      }
      O((List)localObject2, (List)localObject1);
      return;
      localObject1 = null;
    }
  }
  
  public amuk a(QQAppInterface paramQQAppInterface, Context paramContext, ampv paramampv)
  {
    Object localObject1 = null;
    if (paramampv == null) {}
    Object localObject2;
    String str1;
    String str2;
    do
    {
      int i;
      do
      {
        do
        {
          return localObject1;
        } while (!(paramampv instanceof amra));
        localObject2 = (amra)paramampv;
        i = ((amra)localObject2).vY();
        paramampv = b(i);
        localObject1 = paramampv;
      } while (paramampv == null);
      str1 = ((amra)localObject2).zk();
      str2 = ((amra)localObject2).getConfig();
      localObject2 = ((amra)localObject2).zl();
      paramampv.a(paramQQAppInterface, paramContext, i, str1, (String)localObject2, str2);
      localObject1 = paramampv;
    } while (!QLog.isColorLevel());
    QLog.d("RichNodeFactory", 2, "create, data:" + str1 + " config:" + str2 + " extradata:" + (String)localObject2);
    return paramampv;
  }
  
  public boolean ll(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeFactory", 2, "nodeExist， id:" + paramInt);
    }
    if (!this.cEl)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RichNodeFactory", 2, "nodeExist， switch off");
      }
      return false;
    }
    synchronized (this.mZ)
    {
      if (this.mZ.get(Integer.valueOf(paramInt)) != null) {
        return true;
      }
    }
    synchronized (this.mY)
    {
      amue localamue = (amue)this.mY.get(Integer.valueOf(paramInt));
      if (localamue != null)
      {
        return true;
        localObject1 = finally;
        throw localObject1;
      }
    }
    return false;
  }
  
  public void updateConfig()
  {
    initConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amut
 * JD-Core Version:    0.7.0.1
 */