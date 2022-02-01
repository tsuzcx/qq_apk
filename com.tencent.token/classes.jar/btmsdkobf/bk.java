package btmsdkobf;

import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.taf.jce.JceStruct;
import com.tmsdk.base.conch.ConchService.ConchPushInfo;
import com.tmsdk.base.conch.ConchService.IConchPushListener;
import com.tmsdk.base.conch.ConchService.RevokeTaskInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bk
{
  private static bk fT;
  private byte[] fU = new byte[0];
  private SparseArray<ConchService.IConchPushListener> fV = new SparseArray();
  private List<ab> fW = new ArrayList();
  private long fX = -1L;
  private bx fY = bx.ar();
  private cm fZ = new cm()
  {
    public final dj<Long, Integer, JceStruct> a(int paramAnonymousInt1, long paramAnonymousLong, int paramAnonymousInt2, JceStruct paramAnonymousJceStruct)
    {
      if (paramAnonymousInt2 == 10010)
      {
        if (paramAnonymousJceStruct == null) {
          return null;
        }
        Object localObject1 = ((ah)paramAnonymousJceStruct).bo;
        if (localObject1 != null)
        {
          if (((List)localObject1).size() == 0) {
            return null;
          }
          paramAnonymousJceStruct = new w();
          paramAnonymousJceStruct.aW = new ArrayList();
          StringBuilder localStringBuilder = new StringBuilder();
          bk.a(bk.this, ((ac)((List)localObject1).get(0)).bg);
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ac localac = (ac)((Iterator)localObject1).next();
            if ((localac.bk != null) && (localac.bk.size() != 0))
            {
              Iterator localIterator = localac.bk.iterator();
              while (localIterator.hasNext())
              {
                z localz = (z)localIterator.next();
                ConchService.ConchPushInfo localConchPushInfo = new ConchService.ConchPushInfo(localac.bg, localac.bh, localz);
                Object localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(localz.cmdId);
                ((StringBuilder)localObject2).append(";");
                localStringBuilder.append(((StringBuilder)localObject2).toString());
                localObject2 = bk.b(bk.this);
                if (localConchPushInfo.mRevokeInfo == null) {
                  paramAnonymousInt1 = localz.cmdId;
                } else {
                  paramAnonymousInt1 = localConchPushInfo.mRevokeInfo.mRevokeCmdId;
                }
                if ((ConchService.IConchPushListener)((SparseArray)localObject2).get(paramAnonymousInt1) != null)
                {
                  bk.a(bk.this, localConchPushInfo);
                  paramAnonymousJceStruct.aW.add(bk.a(bk.this, localac.bg, localac.bh, localz, 1));
                }
              }
            }
            else
            {
              paramAnonymousJceStruct.aW.add(bk.a(bk.this, localac.bg, localac.bh, null, 3));
            }
          }
          if (!TextUtils.isEmpty(localStringBuilder.toString())) {
            be.SaveStringData(1320064, localStringBuilder.toString());
          }
          return new dj(Long.valueOf(paramAnonymousLong), Integer.valueOf(paramAnonymousInt2), paramAnonymousJceStruct);
        }
      }
      return null;
    }
  };
  
  public static bk G()
  {
    if (fT == null) {
      try
      {
        if (fT == null) {
          fT = new bk();
        }
      }
      finally {}
    }
    return fT;
  }
  
  private void H()
  {
    try
    {
      ee.cT().addTask(new Runnable()
      {
        public final void run()
        {
          for (;;)
          {
            synchronized (bk.d(bk.this))
            {
              if (bk.e(bk.this).size() > 0)
              {
                x localx = new x();
                localx.aW = new ArrayList(bk.e(bk.this));
                bk.e(bk.this).clear();
                if ((localx != null) && (localx.aW != null)) {
                  bk.c(bk.this).a(21, localx, new af(), 2, new cj()
                  {
                    public final void onFinish(int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3, int paramAnonymous2Int4, JceStruct paramAnonymous2JceStruct) {}
                  }, 0L);
                }
                return;
              }
            }
            Object localObject2 = null;
          }
        }
      }, "conchRet");
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
  
  private void a(final ConchService.ConchPushInfo paramConchPushInfo)
  {
    try
    {
      ee.cT().addTask(new Runnable()
      {
        public final void run()
        {
          ConchService.ConchPushInfo localConchPushInfo = paramConchPushInfo;
          int j = localConchPushInfo.mConch.cmdId;
          Object localObject = bk.b(bk.this);
          int i = j;
          if (localConchPushInfo != null) {
            if (localConchPushInfo.mRevokeInfo == null) {
              i = j;
            } else {
              i = localConchPushInfo.mRevokeInfo.mRevokeCmdId;
            }
          }
          localObject = (ConchService.IConchPushListener)((SparseArray)localObject).get(i);
          if (localObject != null) {}
          try
          {
            ((ConchService.IConchPushListener)localObject).onRecvPush(localConchPushInfo);
            return;
          }
          catch (Throwable localThrowable) {}
        }
      }, "conchP");
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
    case 3: 
    default: 
      localab.bi = paramInt4;
      break;
    case 2: 
      localab.bj = paramInt4;
      break;
    case 1: 
      localab.action = paramInt4;
    }
    synchronized (this.fU)
    {
      this.fW.add(localab);
      H();
      return;
    }
  }
  
  public void a(long paramLong, List<Integer> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
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
        return;
      }
    }
  }
  
  public void a(long paramLong, List<Integer> paramList, ConchService.IConchPushListener paramIConchPushListener)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (paramIConchPushListener == null) {
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
        return;
      }
    }
  }
  
  public void b(long paramLong, final int paramInt)
  {
    final ConchService.IConchPushListener localIConchPushListener = (ConchService.IConchPushListener)this.fV.get(paramInt);
    if (localIConchPushListener == null) {
      return;
    }
    y localy = new y();
    localy.cmdId = paramInt;
    this.fY.a(11, localy, new ag(), 2, new cj()
    {
      public final void onFinish(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, JceStruct paramAnonymousJceStruct)
      {
        if (paramAnonymousInt3 != 0) {
          localIConchPushListener.mErrorCode = (paramAnonymousInt3 - 65);
        } else if (paramAnonymousInt4 != 0) {
          localIConchPushListener.mErrorCode = (paramAnonymousInt4 - 65);
        } else if (paramAnonymousInt2 != 10011) {
          localIConchPushListener.mErrorCode = -4000;
        }
        if (localIConchPushListener.mErrorCode != 0) {
          return;
        }
        if (paramAnonymousJceStruct != null)
        {
          Object localObject = (ag)paramAnonymousJceStruct;
          if (((ag)localObject).bo != null)
          {
            if (((ag)localObject).bo.size() == 0) {
              return;
            }
            paramAnonymousJceStruct = new w();
            paramAnonymousJceStruct.aW = new ArrayList();
            StringBuilder localStringBuilder1 = new StringBuilder();
            if (bk.a(bk.this) == ((ac)((ag)localObject).bo.get(0)).bg) {
              return;
            }
            localObject = ((ag)localObject).bo.iterator();
            while (((Iterator)localObject).hasNext())
            {
              ac localac = (ac)((Iterator)localObject).next();
              if ((localac.bk != null) && (localac.bk.size() != 0))
              {
                Iterator localIterator = localac.bk.iterator();
                while (localIterator.hasNext())
                {
                  z localz = (z)localIterator.next();
                  StringBuilder localStringBuilder2;
                  if ((localz.cmdId != paramInt) && (bk.b(bk.this).get(localz.cmdId) == null))
                  {
                    localStringBuilder2 = new StringBuilder("2-");
                    localStringBuilder2.append(localz.cmdId);
                    localStringBuilder2.append(";");
                    localStringBuilder1.append(localStringBuilder2.toString());
                    paramAnonymousJceStruct.aW.add(bk.a(bk.this, localac.bg, localac.bh, localz, 5));
                  }
                  else
                  {
                    bk.a(bk.this, new ConchService.ConchPushInfo(localac.bg, localac.bh, localz));
                    paramAnonymousJceStruct.aW.add(bk.a(bk.this, localac.bg, localac.bh, localz, 1));
                    localStringBuilder2 = new StringBuilder("1-");
                    localStringBuilder2.append(localz.cmdId);
                    localStringBuilder2.append(";");
                    localStringBuilder1.append(localStringBuilder2.toString());
                  }
                }
              }
              else
              {
                localStringBuilder1.append("0-;");
                paramAnonymousJceStruct.aW.add(bk.a(bk.this, localac.bg, localac.bh, null, 3));
              }
            }
            if (paramAnonymousJceStruct.aW.size() > 0)
            {
              be.SaveStringData(1320061, localStringBuilder1.toString());
              bk.c(bk.this).a(13, paramAnonymousJceStruct, new ae(), 2, null, 0L);
            }
          }
        }
      }
    }, 0L);
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