import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class afkd
{
  private static afkd a;
  CopyOnWriteArrayList<WeakReference<afkm>> ab = new CopyOnWriteArrayList();
  CopyOnWriteArrayList<WeakReference<afkn>> ac = new CopyOnWriteArrayList();
  CopyOnWriteArrayList<WeakReference<afko>> ad = new CopyOnWriteArrayList();
  
  public static afkd a()
  {
    try
    {
      if (a == null) {
        a = new afkd();
      }
      afkd localafkd = a;
      return localafkd;
    }
    finally {}
  }
  
  public void a(afkm paramafkm)
  {
    if (paramafkm == null) {
      return;
    }
    synchronized (this.ab)
    {
      Iterator localIterator = this.ab.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramafkm) {
          return;
        }
      }
    }
    paramafkm = new WeakReference(paramafkm);
    this.ab.add(paramafkm);
  }
  
  public void a(afkn paramafkn)
  {
    if (paramafkn == null) {
      return;
    }
    synchronized (this.ac)
    {
      Iterator localIterator = this.ac.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramafkn) {
          return;
        }
      }
    }
    paramafkn = new WeakReference(paramafkn);
    this.ac.add(paramafkn);
  }
  
  public void a(afko paramafko)
  {
    if (paramafko == null) {
      return;
    }
    synchronized (this.ad)
    {
      Iterator localIterator = this.ad.iterator();
      while (localIterator.hasNext()) {
        if (((WeakReference)localIterator.next()).get() == paramafko) {
          return;
        }
      }
    }
    paramafko = new WeakReference(paramafko);
    this.ad.add(paramafko);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.ac != null)
    {
      if (paramInt2 != 0) {}
      for (;;)
      {
        synchronized (this.ac)
        {
          Iterator localIterator = this.ac.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          afkn localafkn = (afkn)((WeakReference)localIterator.next()).get();
          if (localafkn == null) {
            continue;
          }
          localafkn.b(paramEmoticonPackage, paramInt1, paramInt3);
        }
        paramInt3 = 0;
      }
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface)
  {
    if ((paramEmoticonPackage == null) || (paramQQAppInterface == null)) {
      return;
    }
    if ((paramEmoticonPackage.status == 2) && (afnu.jx(paramEmoticonPackage.updateFlag))) {
      anot.a(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_fail", 0, 0, paramEmoticonPackage.epId, "" + paramEmoticonPackage.localVersion, "" + paramEmoticonPackage.latestVersion, "");
    }
    for (;;)
    {
      if ((paramInt1 != 19) && (paramInt1 != 20))
      {
        ram.e("EmojiListenerManager", "notifyPackageFail ep.id=" + paramEmoticonPackage.epId + " error: " + paramInt1);
        ((ajdg)paramQQAppInterface.getManager(14)).m(paramEmoticonPackage);
      }
      paramQQAppInterface = this.ac.iterator();
      while (paramQQAppInterface.hasNext())
      {
        afkn localafkn = (afkn)((WeakReference)paramQQAppInterface.next()).get();
        if (localafkn != null) {
          localafkn.a(paramEmoticonPackage, paramInt2);
        }
      }
      paramEmoticonPackage.status = 0;
    }
    if (paramEmoticonPackage.type == 1) {}
    for (paramInt1 = 5;; paramInt1 = 4)
    {
      ajdg.fe(String.valueOf(paramInt2), paramInt1);
      return;
    }
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, int paramInt, QQAppInterface paramQQAppInterface)
  {
    a(paramEmoticonPackage, -1, paramInt, paramQQAppInterface);
  }
  
  protected void a(EmoticonPackage paramEmoticonPackage, QQAppInterface paramQQAppInterface)
  {
    if (paramEmoticonPackage == null) {}
    do
    {
      return;
      g(paramEmoticonPackage);
      paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
      String str = paramQQAppInterface.getString("LAST_ADD_EMO_PACKAGE", "");
      str = str + "|" + paramEmoticonPackage.epId;
      paramQQAppInterface.edit().putString("LAST_ADD_EMO_PACKAGE", str).commit();
    } while (3 != paramEmoticonPackage.jobType);
    paramQQAppInterface.edit().putBoolean("LAST_ADD_EMO_PACKAGE_MAGIC", true).commit();
  }
  
  public void b(afkm paramafkm)
  {
    if (paramafkm == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.ab.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramafkm) {
          this.ab.remove(localWeakReference);
        }
      }
    }
  }
  
  public void b(afkn paramafkn)
  {
    if (paramafkn == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.ac.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramafkn) {
          this.ac.remove(localWeakReference);
        }
      }
    }
  }
  
  public void b(afko paramafko)
  {
    if (paramafko == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.ad.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() == paramafko) {
          this.ad.remove(localWeakReference);
        }
      }
    }
  }
  
  public void b(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      if (this.ac != null)
      {
        Iterator localIterator = this.ac.iterator();
        while (localIterator.hasNext())
        {
          afkn localafkn = (afkn)((WeakReference)localIterator.next()).get();
          if (localafkn != null) {
            localafkn.c(paramEmoticonPackage, paramInt);
          }
        }
      }
    }
  }
  
  public void b(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      if (this.ad != null)
      {
        Iterator localIterator = this.ad.iterator();
        while (localIterator.hasNext())
        {
          afko localafko = (afko)((WeakReference)localIterator.next()).get();
          if (localafko != null) {
            localafko.a(paramEmoticonPackage, paramInt, paramBundle);
          }
        }
      }
    }
  }
  
  public void d(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.ab.iterator();
      while (localIterator.hasNext())
      {
        afkm localafkm = (afkm)((WeakReference)localIterator.next()).get();
        if (localafkm != null) {
          localafkm.a(paramEmoticonPackage, paramInt1, paramInt2);
        }
      }
    }
  }
  
  public void e(EmoticonPackage paramEmoticonPackage)
  {
    Iterator localIterator = this.ac.iterator();
    while (localIterator.hasNext())
    {
      afkn localafkn = (afkn)((WeakReference)localIterator.next()).get();
      if (localafkn != null) {
        localafkn.j(paramEmoticonPackage);
      }
    }
  }
  
  protected void e(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    synchronized (this.ac)
    {
      Iterator localIterator = this.ac.iterator();
      while (localIterator.hasNext())
      {
        afkn localafkn = (afkn)((WeakReference)localIterator.next()).get();
        if (localafkn != null) {
          localafkn.c(paramEmoticonPackage, paramInt1, paramInt2);
        }
      }
    }
  }
  
  public void f(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {}
    for (;;)
    {
      return;
      afnt.Ie(paramEmoticonPackage.epId);
      Iterator localIterator = this.ab.iterator();
      while (localIterator.hasNext())
      {
        afkm localafkm = (afkm)((WeakReference)localIterator.next()).get();
        if (localafkm != null) {
          localafkm.a(paramEmoticonPackage);
        }
      }
    }
  }
  
  protected void g(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Iterator localIterator = this.ab.iterator();
    while (localIterator.hasNext())
    {
      afkm localafkm = (afkm)((WeakReference)localIterator.next()).get();
      if (localafkm != null) {
        localafkm.b(paramEmoticonPackage);
      }
    }
    if (paramEmoticonPackage.type == 1) {}
    for (int i = 5;; i = 4)
    {
      ajdg.ew("0", i);
      return;
    }
  }
  
  protected void h(EmoticonPackage paramEmoticonPackage)
  {
    afnt.Ie(paramEmoticonPackage.epId);
    synchronized (this.ac)
    {
      Iterator localIterator = this.ac.iterator();
      while (localIterator.hasNext())
      {
        afkn localafkn = (afkn)((WeakReference)localIterator.next()).get();
        if (localafkn != null) {
          localafkn.a(paramEmoticonPackage, 0);
        }
      }
    }
    if (paramEmoticonPackage.type == 1) {}
    for (int i = 5;; i = 4)
    {
      ajdg.fe("0", i);
      return;
    }
  }
  
  public void onDestory()
  {
    synchronized (this.ab)
    {
      this.ab.clear();
    }
    synchronized (this.ac)
    {
      this.ac.clear();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afkd
 * JD-Core Version:    0.7.0.1
 */