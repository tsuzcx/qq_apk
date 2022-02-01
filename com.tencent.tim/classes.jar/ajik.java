import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;

public class ajik
  implements Manager
{
  private ajii a;
  private boolean bUX;
  private AtomicInteger bz = new AtomicInteger(0);
  private boolean cor;
  private Map<Integer, ajil> lT = new HashMap();
  private QQAppInterface mApp;
  
  public ajik(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public int a(ajil paramajil)
  {
    int i = this.bz.getAndIncrement();
    try
    {
      this.lT.put(Integer.valueOf(i), paramajil);
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOManager", 2, "addAioContext() called with: multiAioContext = [" + paramajil + "], id = [" + i + "]");
      }
      return i;
    }
    finally {}
  }
  
  public ajil a(int paramInt)
  {
    try
    {
      ajil localajil = (ajil)this.lT.remove(Integer.valueOf(paramInt));
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOManager", 2, "removeAioContext() called with: id = [" + paramInt + "], multiAioContext = " + localajil);
      }
      return localajil;
    }
    finally {}
  }
  
  public boolean aqC()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOManager", 2, "MultiAIOEntranceConfigData isConfigInited = " + this.cor);
    }
    if (this.cor) {
      return this.bUX;
    }
    this.cor = true;
    dxJ();
    if (!this.a.aqN())
    {
      this.bUX = false;
      return false;
    }
    Object localObject = this.a.fG();
    String str = (Build.MANUFACTURER + Build.MODEL).trim();
    if ((localObject != null) && (((List)localObject).contains(str)))
    {
      this.bUX = false;
      return false;
    }
    localObject = this.a.xp();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (anjn.ej((String)localObject) <= 0))
    {
      this.bUX = false;
      return false;
    }
    this.bUX = true;
    return true;
  }
  
  public ajil b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOManager", 2, "getAioContext() called with: id = [" + paramInt + "]");
    }
    try
    {
      ajil localajil = (ajil)this.lT.get(Integer.valueOf(paramInt));
      return localajil;
    }
    finally {}
  }
  
  public void b(ajii paramajii)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOManager", 2, "onConfUpdate : " + paramajii);
    }
    this.a = paramajii;
  }
  
  public void clear()
  {
    try
    {
      Iterator localIterator = this.lT.values().iterator();
      while (localIterator.hasNext())
      {
        ajil localajil = (ajil)localIterator.next();
        if (localajil != null) {
          localajil.destroy();
        }
      }
      this.lT.clear();
    }
    finally {}
  }
  
  public void dxJ()
  {
    this.a = ((ajii)aeif.a().o(478));
    if (this.a == null)
    {
      this.a = new ajii();
      if (QLog.isColorLevel()) {
        QLog.d("MultiAIOManager", 2, "MultiAIOEntranceConfigData =null, general new bean");
      }
    }
  }
  
  public void onDestroy()
  {
    clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajik
 * JD-Core Version:    0.7.0.1
 */