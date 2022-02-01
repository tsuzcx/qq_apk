package wf7;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.taf.jce.JceStruct;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ft
{
  private final Object hx = new Object();
  private fv rA = null;
  private final AtomicBoolean rB = new AtomicBoolean(false);
  private boolean rC = false;
  
  private ft()
  {
    init();
  }
  
  private void a(fu paramfu)
  {
    synchronized (this.hx)
    {
      if (this.rA == null) {
        this.rA = new fv();
      }
      if (this.rA.rF == null) {
        this.rA.rF = new ArrayList();
      }
      this.rA.rF.add(paramfu);
      return;
    }
  }
  
  private fu au(int paramInt)
  {
    synchronized (this.hx)
    {
      if (this.rA == null) {
        return null;
      }
      Iterator localIterator = this.rA.rF.iterator();
      while (localIterator.hasNext())
      {
        fu localfu = (fu)localIterator.next();
        if ((localfu != null) && (localfu.id == paramInt)) {
          return localfu;
        }
      }
    }
    return null;
  }
  
  public static final ft eJ()
  {
    return a.rE;
  }
  
  private void eN()
  {
    synchronized (this.hx)
    {
      if ((this.rA == null) || (this.rA.rF == null) || (this.rA.rF.isEmpty())) {
        return;
      }
      fv localfv = new fv();
      localfv.rF = new ArrayList();
      Iterator localIterator = this.rA.rF.iterator();
      while (localIterator.hasNext())
      {
        fu localfu = (fu)localIterator.next();
        if (localfu.networkId != cb.gI) {
          localfv.rF.add(localfu);
        }
      }
    }
    if (localJceStruct.rF.isEmpty()) {
      return;
    }
    gk.a(df.a(localJceStruct), eM());
  }
  
  private void eO()
  {
    bz.av().u().v().a(new ft.2(this), "saveData");
  }
  
  private void init()
  {
    eK();
  }
  
  private void l(String paramString, int paramInt)
  {
    fu localfu = new fu();
    localfu.ssid = paramString;
    localfu.security = paramInt;
    localfu.id = cb.d(paramString, paramInt);
    a(new fu());
  }
  
  protected void a(String paramString, JceStruct paramJceStruct)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramJceStruct == null)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = gk.a(new File(paramString));
        if ((paramString != null) && (paramString.length > 0))
        {
          df.a(paramString, paramJceStruct, false);
          return;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  protected void a(fv paramfv)
  {
    synchronized (this.hx)
    {
      if (this.rA == null) {
        this.rA = paramfv;
      }
      fu localfu1;
      fu localfu2;
      do
      {
        do
        {
          while (!paramfv.hasNext())
          {
            return;
            paramfv = paramfv.rF.iterator();
          }
          localfu1 = (fu)paramfv.next();
        } while (localfu1 == null);
        localfu2 = au(localfu1.id);
      } while (((localfu2 != null) && (localfu2.networkId != localfu1.networkId) && (localfu2.networkId == cb.gI)) || (localfu2 != null));
      a(localfu1);
    }
  }
  
  public List<Pair<String, Integer>> eI()
  {
    synchronized (this.hx)
    {
      if ((this.rA == null) || (this.rA.rF == null)) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.rA.rF.iterator();
      while (localIterator.hasNext())
      {
        fu localfu = (fu)localIterator.next();
        if (localfu.networkId != cb.gI) {
          localArrayList.add(new Pair(localfu.ssid, Integer.valueOf(localfu.security)));
        }
      }
    }
    return localList;
  }
  
  protected void eK()
  {
    if (this.rB.get()) {
      return;
    }
    bz.av().u().v().a(new ft.1(this), "loadConfigRecords");
  }
  
  protected boolean eL()
  {
    String str = eM();
    fv localfv = new fv();
    a(str, localfv);
    if ((localfv.rF != null) && (!localfv.rF.isEmpty())) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        a(localfv);
      }
      return bool;
    }
  }
  
  protected String eM()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(bz.av().t().getFilesDir());
    localStringBuffer.append(File.separator);
    localStringBuffer.append("files");
    localStringBuffer.append(File.separator);
    File localFile = new File(localStringBuffer.toString());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localStringBuffer.append("wifi_cofigs_record_data_file.dat");
    return localStringBuffer.toString();
  }
  
  public void eP()
  {
    eO();
  }
  
  public boolean j(String paramString, int paramInt)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    fu localfu = au(cb.d(paramString, paramInt));
    if (localfu == null) {
      l(paramString, paramInt);
    }
    for (;;)
    {
      this.rC |= bool;
      if (this.rC) {
        eO();
      }
      return bool;
      if (localfu.networkId == cb.gI) {
        localfu.networkId = 0;
      } else {
        bool = false;
      }
    }
  }
  
  public void k(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = au(cb.d(paramString, paramInt));
    } while (paramString == null);
    paramString.networkId = cb.gI;
    this.rC |= true;
  }
  
  static abstract interface a
  {
    public static final ft rE = new ft(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.ft
 * JD-Core Version:    0.7.0.1
 */