package btmsdkobf;

import android.util.SparseArray;
import com.tmsdk.base.conch.ConchService.ConchPushInfo;
import com.tmsdk.base.conch.ConchService.IConchPushListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bk
{
  private static bk fT;
  private byte[] fU = new byte[0];
  private SparseArray fV = new SparseArray();
  private List fW = new ArrayList();
  private long fX = -1L;
  private bx fY = bx.ar();
  private cm fZ = new fa(this);
  
  public static bk G()
  {
    if (fT == null) {}
    try
    {
      if (fT == null) {
        fT = new bk();
      }
      return fT;
    }
    finally {}
  }
  
  private void H()
  {
    try
    {
      ee.cT().addTask(new fc(this), "conchRet");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private aa a(long paramLong1, long paramLong2, z paramz, int paramInt)
  {
    aa localaa = new aa();
    localaa.bg = paramLong1;
    localaa.bh = paramLong2;
    if (paramz != null)
    {
      localaa.cmdId = paramz.cmdId;
      localaa.ba = paramz.ba;
    }
    localaa.bi = paramInt;
    return localaa;
  }
  
  private void a(ConchService.ConchPushInfo paramConchPushInfo)
  {
    try
    {
      ee.cT().addTask(new fb(this, paramConchPushInfo), "conchP");
      return;
    }
    finally
    {
      paramConchPushInfo = finally;
      throw paramConchPushInfo;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    synchronized (this.fU)
    {
      if (this.fV.get(paramInt) != null) {
        this.fV.remove(paramInt);
      }
      return;
    }
  }
  
  public void a(long paramLong, int paramInt, ConchService.IConchPushListener paramIConchPushListener)
  {
    if (paramIConchPushListener == null) {
      return;
    }
    synchronized (this.fU)
    {
      if (this.fV.get(paramInt) == null) {
        this.fV.put(paramInt, paramIConchPushListener);
      }
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ab localab = new ab();
    localab.bg = paramLong2;
    localab.bh = paramLong3;
    localab.cmdId = paramInt1;
    localab.ba = paramInt2;
    localab.phase = paramInt3;
    switch (paramInt3)
    {
    default: 
      localab.bi = paramInt4;
    }
    synchronized (this.fU)
    {
      for (;;)
      {
        this.fW.add(localab);
        H();
        return;
        localab.bi = paramInt4;
        continue;
        localab.action = paramInt4;
      }
      localab.bj = paramInt4;
    }
  }
  
  public void a(long paramLong, List paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    synchronized (this.fU)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Integer localInteger = (Integer)paramList.next();
        if (this.fV.get(localInteger.intValue()) != null) {
          this.fV.remove(localInteger.intValue());
        }
      }
    }
  }
  
  public void a(long paramLong, List paramList, ConchService.IConchPushListener paramIConchPushListener)
  {
    if ((paramList == null) || (paramList.size() <= 0) || (paramIConchPushListener == null)) {
      return;
    }
    synchronized (this.fU)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Integer localInteger = (Integer)paramList.next();
        if (this.fV.get(localInteger.intValue()) == null) {
          this.fV.put(localInteger.intValue(), paramIConchPushListener);
        }
      }
    }
  }
  
  public void b(long paramLong, int paramInt)
  {
    ConchService.IConchPushListener localIConchPushListener = (ConchService.IConchPushListener)this.fV.get(paramInt);
    if (localIConchPushListener == null) {
      return;
    }
    y localy = new y();
    localy.cmdId = paramInt;
    this.fY.a(11, localy, new ag(), 2, new ez(this, localIConchPushListener, paramInt), 0L);
  }
  
  public void registerSharkPush()
  {
    this.fY.a(10010, new ah(), 2, this.fZ);
  }
  
  public void unRegisterSharkPush()
  {
    this.fY.e(10010, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bk
 * JD-Core Version:    0.7.0.1
 */