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
      return null;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static final ft eJ()
  {
    return ft.a.rE;
  }
  
  private void eN()
  {
    synchronized (this.hx)
    {
      if ((this.rA != null) && (this.rA.rF != null) && (!this.rA.rF.isEmpty()))
      {
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
        if (localfv.rF.isEmpty()) {
          return;
        }
        gk.a(df.a(localfv), eM());
        return;
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
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
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramJceStruct == null) {
        return;
      }
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
      if (this.rA == null)
      {
        this.rA = paramfv;
      }
      else
      {
        paramfv = paramfv.rF.iterator();
        while (paramfv.hasNext())
        {
          fu localfu1 = (fu)paramfv.next();
          if (localfu1 != null)
          {
            fu localfu2 = au(localfu1.id);
            if (((localfu2 == null) || (localfu2.networkId == localfu1.networkId) || (localfu2.networkId != cb.gI)) && (localfu2 == null)) {
              a(localfu1);
            }
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw paramfv;
    }
  }
  
  public List<Pair<String, Integer>> eI()
  {
    synchronized (this.hx)
    {
      if ((this.rA != null) && (this.rA.rF != null))
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.rA.rF.iterator();
        while (localIterator.hasNext())
        {
          fu localfu = (fu)localIterator.next();
          if (localfu.networkId != cb.gI) {
            localArrayList.add(new Pair(localfu.ssid, Integer.valueOf(localfu.security)));
          }
        }
        return localArrayList;
      }
      return null;
    }
    for (;;)
    {
      throw localObject2;
    }
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
    boolean bool;
    if ((localfv.rF != null) && (!localfv.rF.isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      a(localfv);
    }
    return bool;
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
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    fu localfu = au(cb.d(paramString, paramInt));
    boolean bool = true;
    if (localfu == null) {
      l(paramString, paramInt);
    } else if (localfu.networkId == cb.gI) {
      localfu.networkId = 0;
    } else {
      bool = false;
    }
    this.rC |= bool;
    if (this.rC) {
      eO();
    }
    return bool;
  }
  
  public void k(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = au(cb.d(paramString, paramInt));
    if (paramString != null)
    {
      paramString.networkId = cb.gI;
      this.rC |= true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.ft
 * JD-Core Version:    0.7.0.1
 */