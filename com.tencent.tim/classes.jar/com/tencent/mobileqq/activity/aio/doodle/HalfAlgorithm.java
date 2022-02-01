package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Path;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lwrx.a;>;
import java.util.Map;
import java.util.TreeMap;
import wrw;
import wrx.a;
import wsa.a;
import wse;
import wsf;
import wsg;
import wsi;
import wsj;

public class HalfAlgorithm
  extends wrw
  implements wsj
{
  private wsf a = new wsf();
  private int bRj;
  private Map<Integer, wsg> hy;
  private List<wsa.a> rL;
  private Path y;
  
  private boolean a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong1, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, long paramLong2, Path paramPath, List<wsa.a> paramList)
  {
    paramPath.moveTo(paramFloat1, paramFloat2);
    paramPath.quadTo(paramFloat4, paramFloat5, paramFloat6, paramFloat7);
    return a(paramList, paramPath, paramFloat3, paramFloat8, paramLong1, paramLong2);
  }
  
  private void cbo()
  {
    if (this.rL == null) {
      this.rL = new ArrayList();
    }
    this.rL.clear();
    if (this.y == null) {
      this.y = new Path();
    }
    this.y.reset();
  }
  
  private void x(List<wsa.a> paramList1, List<wsa.a> paramList2)
  {
    if ((paramList2 == null) || (paramList1 == null) || (paramList2.size() == 0)) {
      return;
    }
    long l;
    if (paramList1.size() > 0) {
      l = ((wsa.a)paramList1.get(paramList1.size() - 1)).getTime();
    }
    for (int i = ((wsa.a)paramList1.get(paramList1.size() - 1)).getSeq();; i = 0)
    {
      if (((wsa.a)paramList2.get(0)).getTime() == l)
      {
        QLog.d("DoodleAlgorithm", 2, "addjust time and seg :" + l);
        Iterator localIterator = paramList2.iterator();
        while (localIterator.hasNext())
        {
          wsa.a locala = (wsa.a)localIterator.next();
          if (locala.getTime() != l) {
            break;
          }
          locala.setSeq(locala.getSeq() + i + 1);
        }
      }
      paramList1.addAll(paramList2);
      return;
      l = -1L;
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, Path paramPath, List<wsa.a> paramList)
  {
    if (paramPath == null) {}
    do
    {
      return;
      paramPath.reset();
      paramPath.moveTo(paramFloat1, paramFloat2);
      this.a.e(paramFloat1, paramFloat2, paramFloat3, paramLong);
    } while (paramList == null);
    paramList.clear();
    cbo();
  }
  
  public void a(int paramInt, boolean paramBoolean, Path paramPath, List<wsa.a> paramList)
  {
    if (this.hy == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoodleAlgorithm", 2, "onResult :" + paramInt + " : " + this.bRj);
    }
    if (((!paramBoolean) || (paramList == null) || (paramPath == null)) && (QLog.isColorLevel())) {
      QLog.d("DoodleAlgorithm", 2, "onResult error!!");
    }
    synchronized (this.hy)
    {
      wsg localwsg = new wsg();
      localwsg.mID = paramInt;
      localwsg.mResult = paramBoolean;
      localwsg.mPath = paramPath;
      localwsg.rR = paramList;
      this.hy.put(Integer.valueOf(paramInt), localwsg);
      if (this.hy.size() == this.bRj)
      {
        this.hy.notifyAll();
        QLog.d("DoodleAlgorithm", 2, "onResult the last one, notify all");
      }
      return;
    }
  }
  
  public void a(Path paramPath, List<wsa.a> paramList)
  {
    if (paramList == null)
    {
      this.a.end();
      paramPath.quadTo(this.a.c.mX, this.a.c.mY, this.a.b.mX, this.a.b.mY);
      return;
    }
    cbo();
    this.a.end();
    if (a(this.a.a.mX, this.a.a.mY, this.a.a.mWidth, this.a.a.mTime, this.a.c.mX, this.a.c.mY, this.a.b.mX, this.a.b.mY, this.a.b.mWidth, this.a.b.mTime, this.y, this.rL))
    {
      if (this.rL.size() > 0)
      {
        paramPath.addPath(this.y);
        x(paramList, this.rL);
        this.y = null;
        this.rL = null;
        return;
      }
      QLog.d("DoodleAlgorithm", 2, "finish segment == 0:" + System.currentTimeMillis());
      return;
    }
    QLog.d("DoodleAlgorithm", 2, "finish failed:" + System.currentTimeMillis());
  }
  
  public void a(List<wrx.a> paramList, Path paramPath, List<wsa.a> paramList1)
  {
    if ((paramList == null) || (paramList.size() == 0) || (paramPath == null) || (paramList1 == null)) {
      return;
    }
    QLog.d("DoodleAlgorithm", 2, "patchPath begin:");
    paramList = paramList.iterator();
    int i = 1;
    if (paramList.hasNext())
    {
      wrx.a locala = (wrx.a)paramList.next();
      if (i != 0)
      {
        a(locala.getX(), locala.getY(), locala.getWidth(), locala.getTime(), paramPath, null);
        i = 0;
      }
      for (;;)
      {
        break;
        b(locala.getX(), locala.getY(), locala.getWidth(), locala.getTime(), paramPath, null);
      }
    }
    a(paramPath, null);
    a(paramList1, paramPath);
    QLog.d("DoodleAlgorithm", 2, "patchpath end:" + paramList1.size());
  }
  
  public void a(List<wrx.a> arg1, Path paramPath, List<wsa.a> paramList1, int paramInt)
  {
    if ((??? == null) || (???.size() == 0) || (paramPath == null) || (paramList1 == null)) {}
    int i;
    label88:
    do
    {
      return;
      QLog.d("DoodleAlgorithm", 2, "transPath begin:" + System.currentTimeMillis());
      if (???.size() > paramInt)
      {
        i = 1;
        if (i != 0) {
          break;
        }
        QLog.d("DoodleAlgorithm", 2, "transPath begin singlethread begin");
        ??? = ???.iterator();
        paramInt = 1;
        if (!???.hasNext()) {
          break label180;
        }
        localObject1 = (wrx.a)???.next();
        if (paramInt == 0) {
          break label151;
        }
        a(((wrx.a)localObject1).getX(), ((wrx.a)localObject1).getY(), ((wrx.a)localObject1).getWidth(), ((wrx.a)localObject1).getTime(), paramPath, paramList1);
        paramInt = 0;
      }
      for (;;)
      {
        break label88;
        i = 0;
        break;
        b(((wrx.a)localObject1).getX(), ((wrx.a)localObject1).getY(), ((wrx.a)localObject1).getWidth(), ((wrx.a)localObject1).getTime(), paramPath, paramList1);
      }
      a(paramPath, paramList1);
      QLog.d("DoodleAlgorithm", 2, "before merge:" + paramList1.size());
      H(paramList1, 0);
    } while (!QLog.isColorLevel());
    label151:
    label180:
    QLog.d("DoodleAlgorithm", 2, "after merge:" + paramList1.size());
    return;
    Object localObject1 = null;
    paramPath.reset();
    if (paramList1 != null) {
      paramList1.clear();
    }
    this.bRj = 0;
    if (this.hy == null) {
      this.hy = new TreeMap();
    }
    this.hy.clear();
    QLog.d("DoodleAlgorithm", 2, "transPath begin multithread begin");
    Object localObject2 = ???.iterator();
    ??? = (List<wrx.a>)localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (wrx.a)((Iterator)localObject2).next();
      if (??? == null)
      {
        ??? = new wsi();
        ???.setMaxSize(paramInt);
        ???.e(((wrx.a)localObject1).getX(), ((wrx.a)localObject1).getY(), ((wrx.a)localObject1).getWidth(), ((wrx.a)localObject1).getTime());
        paramPath.moveTo(((wrx.a)localObject1).getX(), ((wrx.a)localObject1).getY());
      }
      else if (???.a(((wrx.a)localObject1).getX(), ((wrx.a)localObject1).getY(), ((wrx.a)localObject1).getWidth(), ((wrx.a)localObject1).getTime()))
      {
        localObject1 = ???.bE();
        i = this.bRj + 1;
        this.bRj = i;
        ThreadManager.post(new TransPathJob(i, (List)localObject1, this), 8, null, true);
      }
    }
    ???.end();
    paramInt = this.bRj + 1;
    this.bRj = paramInt;
    ThreadManager.post(new TransPathJob(paramInt, ???.rS, this), 8, null, true);
    synchronized (this.hy)
    {
      QLog.d("DoodleAlgorithm", 2, "tranpath wait:" + this.bRj + " - " + this.hy.size());
      paramInt = this.hy.size();
      i = this.bRj;
      if (paramInt >= i) {}
    }
    try
    {
      this.hy.wait(60000L);
      if (this.hy.size() == this.bRj)
      {
        localObject1 = this.hy.values().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (wsg)((Iterator)localObject1).next();
          if (((wsg)localObject2).mPath != null) {
            paramPath.addPath(((wsg)localObject2).mPath);
          }
          if (((wsg)localObject2).rR != null)
          {
            x(paramList1, ((wsg)localObject2).rR);
            continue;
            paramPath = finally;
            throw paramPath;
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoodleAlgorithm", 2, "transPath exception:" + localException);
        }
      }
      QLog.d("DoodleAlgorithm", 2, "transPath end :" + this.bRj);
    }
    for (;;)
    {
      this.hy = null;
      this.bRj = 0;
      QLog.d("DoodleAlgorithm", 2, "before merge:" + paramList1.size());
      H(paramList1, 0);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("DoodleAlgorithm", 2, "transPath end:" + paramList1.size());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DoodleAlgorithm", 2, "transPath end with error:" + this.hy.size() + " ---" + this.bRj);
      }
    }
  }
  
  public void b(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong, Path paramPath, List<wsa.a> paramList)
  {
    if (paramPath == null) {
      return;
    }
    if (paramList == null)
    {
      this.a.b(paramFloat1, paramFloat2, paramFloat3, paramLong, true);
      paramPath.quadTo(this.a.c.mX, this.a.c.mY, this.a.b.mX, this.a.b.mY);
      return;
    }
    cbo();
    boolean bool = a(this.a.b.mX, this.a.b.mY, this.a.b.mWidth, this.a.b.mTime, this.a.d.mX, this.a.d.mY, (this.a.d.mX + paramFloat1) / 2.0F, (this.a.d.mY + paramFloat2) / 2.0F, (this.a.d.mWidth + paramFloat3) / 2.0F, (this.a.d.mTime + paramLong) / 2L, this.y, this.rL);
    this.a.b(paramFloat1, paramFloat2, paramFloat3, paramLong, bool);
    if (bool)
    {
      if (this.rL.size() > 0)
      {
        paramPath.addPath(this.y);
        x(paramList, this.rL);
        return;
      }
      QLog.d("DoodleAlgorithm", 2, "addpoint segment == 0:" + System.currentTimeMillis());
      return;
    }
    QLog.d("DoodleAlgorithm", 2, "addpoint failed:" + System.currentTimeMillis());
  }
  
  class TransPathJob
    implements Runnable
  {
    private int mID;
    private WeakReference<wsj> mListenerRef;
    private List<wsf> rM;
    
    public TransPathJob(List<wsf> paramList, wsj paramwsj)
    {
      this.mID = paramList;
      this.rM = paramwsj;
      Object localObject;
      this.mListenerRef = new WeakReference(localObject);
    }
    
    public void run()
    {
      if ((this.rM == null) || (this.rM.size() == 0) || (this.mListenerRef == null) || (this.mListenerRef.get() == null))
      {
        if (this.mListenerRef != null)
        {
          localObject = (wsj)this.mListenerRef.get();
          if (localObject != null) {
            ((wsj)localObject).a(this.mID, false, null, null);
          }
        }
        return;
      }
      QLog.d("TransPathJob", 2, "TransPathJob begin:" + this.mID + " - " + System.currentTimeMillis());
      Path localPath1 = new Path();
      localPath1.reset();
      ArrayList localArrayList1 = new ArrayList();
      Path localPath2 = new Path();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = this.rM.iterator();
      Object localObject = null;
      wsf localwsf;
      if (localIterator.hasNext())
      {
        localwsf = (wsf)localIterator.next();
        if (localObject == null) {
          break label488;
        }
        localwsf.b((wsf)localObject);
        localObject = null;
      }
      label321:
      label483:
      label488:
      for (;;)
      {
        if (HalfAlgorithm.a(HalfAlgorithm.this, localwsf.a.mX, localwsf.a.mY, localwsf.a.mWidth, localwsf.a.mTime, localwsf.c.mX, localwsf.c.mY, localwsf.b.mX, localwsf.b.mY, localwsf.b.mWidth, localwsf.b.mTime, localPath2, localArrayList2)) {
          if (localArrayList2.size() > 0)
          {
            localPath1.addPath(localPath2);
            HalfAlgorithm.a(HalfAlgorithm.this, localArrayList1, localArrayList2);
            localPath2.reset();
            localArrayList2.clear();
          }
        }
        for (;;)
        {
          break;
          QLog.d("TransPathJob", 2, "TransPathJob segment == 0:" + System.currentTimeMillis());
          break label321;
          QLog.d("TransPathJob", 2, "TransPathJob no segment:" + System.currentTimeMillis());
          localObject = localwsf;
        }
        localObject = (wsj)this.mListenerRef.get();
        int i;
        if (localObject != null)
        {
          i = this.mID;
          if (localArrayList1.size() <= 0) {
            break label483;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          ((wsj)localObject).a(i, bool, localPath1, localArrayList1);
          QLog.d("TransPathJob", 2, "TransPathJob end:" + this.mID + "-" + System.currentTimeMillis());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.HalfAlgorithm
 * JD-Core Version:    0.7.0.1
 */