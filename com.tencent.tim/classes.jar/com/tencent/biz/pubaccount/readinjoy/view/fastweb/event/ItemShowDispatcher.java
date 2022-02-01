package com.tencent.biz.pubaccount.readinjoy.view.fastweb.event;

import android.util.SparseArray;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.AbsListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import knc;
import mqq.os.MqqHandler;
import nlk;
import wja;

public class ItemShowDispatcher
{
  private static String TAG = ItemShowDispatcher.class.getSimpleName();
  public HashSet<Integer> Y = new HashSet();
  public HashSet<String> Z = new HashSet();
  private OneSecondCallbackLoop a;
  private SparseArray<b> ay;
  private SparseArray<b> az;
  private final int baj = 1000;
  private final int bak = 500;
  private nlk c;
  private Runnable cX = new ItemShowDispatcher.1(this);
  private Pair<Integer, Integer> d;
  private Pair<Integer, Integer> e;
  private ArrayList<a> lK = new ArrayList();
  private ArrayList<a> lL = new ArrayList();
  
  private boolean FL()
  {
    if ((this.d == null) && (this.e == null)) {}
    while ((this.c == null) || (this.c.size() == 0) || (((this.ay == null) || (this.ay.size() == 0)) && ((this.az == null) || (this.az.size() == 0)))) {
      return false;
    }
    return true;
  }
  
  private void Z(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new CheckAndStartWebProcessRunnable(paramQQAppInterface));
  }
  
  private float a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt4 < paramInt1) || (paramInt4 > paramInt1 + paramInt2)) {}
    for (;;)
    {
      return 0.0F;
      View localView = paramAbsListView.getChildAt(paramInt4 - paramInt1);
      if (localView != null) {
        try
        {
          paramInt1 = Math.abs(paramAbsListView.getBottom() - localView.getTop() - paramAbsListView.getTop());
          paramInt2 = this.c.get(paramInt4);
          if ((paramInt1 > 0) && (paramInt2 > 0)) {
            return paramInt1 / paramInt2;
          }
        }
        catch (RuntimeException paramAbsListView)
        {
          wja.a("FastWebActivityCheckAdOutOfBounds", "adPos:" + paramInt4, paramAbsListView);
        }
      }
    }
    return 0.0F;
  }
  
  private int a(SparseArray<b> paramSparseArray, BaseData paramBaseData)
  {
    int j;
    if (paramSparseArray == null)
    {
      j = -1;
      return j;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramSparseArray.size()) {
        break label47;
      }
      j = i;
      if (((b)paramSparseArray.valueAt(i)).a() == paramBaseData) {
        break;
      }
      i += 1;
    }
    label47:
    return -1;
  }
  
  private Pair<Integer, Integer> a(Pair<Integer, Integer> paramPair1, Pair<Integer, Integer> paramPair2)
  {
    if ((paramPair1 == null) || (paramPair2 == null)) {
      return null;
    }
    if ((((Integer)paramPair1.second).intValue() < ((Integer)paramPair2.first).intValue()) || (((Integer)paramPair1.first).intValue() > ((Integer)paramPair2.second).intValue())) {
      return null;
    }
    Integer localInteger;
    int i;
    if (((Integer)paramPair1.first).intValue() > ((Integer)paramPair2.first).intValue())
    {
      localInteger = (Integer)paramPair1.first;
      i = localInteger.intValue();
      if (((Integer)paramPair1.second).intValue() >= ((Integer)paramPair2.second).intValue()) {
        break label158;
      }
    }
    label158:
    for (paramPair1 = (Integer)paramPair1.second;; paramPair1 = (Integer)paramPair2.second)
    {
      return new Pair(Integer.valueOf(i), Integer.valueOf(paramPair1.intValue()));
      localInteger = (Integer)paramPair2.first;
      break;
    }
  }
  
  private Pair<Integer, Integer> a(AbsListView paramAbsListView)
  {
    int i = paramAbsListView.getFirstVisiblePosition();
    int n = paramAbsListView.getLastVisiblePosition();
    int m = n - i;
    for (;;)
    {
      int k;
      try
      {
        localView1 = paramAbsListView.getChildAt(0);
        View localView2 = paramAbsListView.getChildAt(m);
        i1 = paramAbsListView.getHeight();
        j = localView1.getBottom();
        k = 0;
        if (!af(j, this.c.get(i)))
        {
          k += 1;
          i += 1;
          j = paramAbsListView.getChildAt(k).getBottom();
          continue;
        }
        k = this.c.get(n) - (localView2.getBottom() - i1);
      }
      catch (Exception paramAbsListView)
      {
        View localView1;
        int i1;
        int j;
        return null;
      }
      if (!af(k, this.c.get(n)))
      {
        n -= 1;
        m -= 1;
        localView1 = paramAbsListView.getChildAt(m);
        k = this.c.get(n) - (localView1.getBottom() - i1);
      }
      else
      {
        QLog.d(TAG, 2, "  " + i + " - " + n + "         " + j + "  " + this.c.get(i) + "   " + k + "   " + this.c.get(n));
        return new Pair(Integer.valueOf(i), Integer.valueOf(n));
      }
      if (k <= 0) {
        if (n >= 0) {}
      }
    }
  }
  
  private void a(Pair<Integer, Integer> paramPair)
  {
    if ((paramPair == null) || (this.az == null) || (this.az.size() == 0)) {
      return;
    }
    QLog.d(TAG, 2, "show : " + paramPair.first + " ---  " + paramPair.second);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.az.size())
    {
      int j = this.az.keyAt(i);
      if ((j >= ((Integer)paramPair.first).intValue()) && (j <= ((Integer)paramPair.second).intValue()))
      {
        ((b)this.az.valueAt(i)).aED();
        localArrayList.add(Integer.valueOf(j));
      }
      i += 1;
    }
    paramPair = localArrayList.iterator();
    while (paramPair.hasNext())
    {
      i = ((Integer)paramPair.next()).intValue();
      this.az.remove(i);
    }
    aZu();
  }
  
  private void aZr()
  {
    if ((this.ay == null) || (this.ay.size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "doAdCallback(all) ");
      }
      localArrayList = new ArrayList();
      Iterator localIterator = this.lK.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if ((locala.G.longValue() != 0L) && (System.currentTimeMillis() - locala.G.longValue() >= 1000L))
        {
          locala.exposureTime = (System.currentTimeMillis() - locala.G.longValue());
          localArrayList.add(Integer.valueOf(locala.postion));
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "time is out , need report ,ad pos is =" + locala.postion + "  show time=" + locala.G);
          }
        }
      }
    } while (localArrayList.size() <= 0);
    bV(localArrayList);
  }
  
  private void aZt()
  {
    int j = 2147483647;
    int i = -1;
    int m = i;
    int n = j;
    if (this.ay != null)
    {
      int k = 0;
      for (;;)
      {
        m = i;
        n = j;
        if (k >= this.ay.size()) {
          break;
        }
        n = this.ay.keyAt(k);
        m = j;
        if (n < j) {
          m = n;
        }
        j = i;
        if (n > i) {
          j = n;
        }
        k += 1;
        i = j;
        j = m;
      }
    }
    this.d = new Pair(Integer.valueOf(n), Integer.valueOf(m));
  }
  
  private void aZu()
  {
    int j = 2147483647;
    int i = -1;
    int m = i;
    int n = j;
    if (this.az != null)
    {
      int k = 0;
      for (;;)
      {
        m = i;
        n = j;
        if (k >= this.az.size()) {
          break;
        }
        n = this.az.keyAt(k);
        m = j;
        if (n < j) {
          m = n;
        }
        j = i;
        if (n > i) {
          j = n;
        }
        k += 1;
        i = j;
        j = m;
      }
    }
    this.e = new Pair(Integer.valueOf(n), Integer.valueOf(m));
  }
  
  private boolean af(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {}
    while (paramInt1 / paramInt2 < 0.5D) {
      return false;
    }
    return true;
  }
  
  private void bV(ArrayList<Integer> paramArrayList)
  {
    if ((this.ay == null) || (this.ay.size() == 0)) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, " (ArrayList<Integer> adPositionlist) ");
      }
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Integer localInteger = (Integer)paramArrayList.next();
        Object localObject = (b)this.ay.get(localInteger.intValue());
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doAdCallback(ArrayList<Integer> adPositionlist) pos=" + localInteger);
          }
          ((b)localObject).aED();
          localArrayList.add(localInteger);
          this.ay.remove(localInteger.intValue());
          localObject = this.lK.iterator();
          while (((Iterator)localObject).hasNext())
          {
            a locala = (a)((Iterator)localObject).next();
            if ((locala != null) && (locala.postion == localInteger.intValue())) {
              this.lK.remove(locala);
            }
          }
          if (this.Y.contains(localInteger))
          {
            this.Y.remove(localInteger);
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "invalidADExposurePos remove " + localInteger);
            }
          }
        }
      }
    }
  }
  
  private boolean d(BaseData paramBaseData)
  {
    if (paramBaseData == null) {}
    while (!AdData.b(paramBaseData)) {
      return false;
    }
    return knc.k((AdData)paramBaseData);
  }
  
  private void m(AbsListView paramAbsListView, int paramInt)
  {
    a(a(a(paramAbsListView), this.e));
  }
  
  public a a(int paramInt)
  {
    if (this.lK == null) {
      return null;
    }
    Iterator localIterator = this.lK.iterator();
    a locala;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (a)localIterator.next();
    } while (locala.postion != paramInt);
    for (;;)
    {
      return locala;
      locala = null;
    }
  }
  
  public void a(int paramInt, b paramb)
  {
    if (this.ay == null) {
      this.ay = new SparseArray();
    }
    int i = a(this.ay, paramb.a());
    if (i >= 0) {
      this.ay.remove(i);
    }
    this.ay.put(paramInt, paramb);
    aZt();
  }
  
  public void a(QQAppInterface paramQQAppInterface, AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.lL.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      AdData localAdData = (AdData)locala.f;
      if ((localAdData != null) && (d(locala.f)) && (!this.Z.contains(localAdData.alJ)) && (a(paramAbsListView, paramInt1, paramInt2, locala.postion))) {
        if (locala.xJ == 0L)
        {
          locala.xJ = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkWebProcess set start time=, traceId=" + localAdData.alJ);
          }
        }
        else if (System.currentTimeMillis() - locala.xJ >= 500L)
        {
          this.Z.add(localAdData.alJ);
          Z(paramQQAppInterface);
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkWebProcess CHECK WebViwe! traceId=" + localAdData.alJ);
          }
        }
      }
    }
  }
  
  public void a(nlk paramnlk)
  {
    this.c = paramnlk;
  }
  
  public boolean a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 < paramInt1) || (paramInt3 > paramInt1 + paramInt2)) {}
    for (;;)
    {
      return false;
      View localView = paramAbsListView.getChildAt(paramInt3 - paramInt1);
      if (localView != null) {
        try
        {
          paramInt1 = Math.abs(paramAbsListView.getBottom() - localView.getTop() - paramAbsListView.getTop());
          if (paramInt1 > 0) {
            return true;
          }
        }
        catch (RuntimeException paramAbsListView)
        {
          wja.a("FastWebActivityCheckAdOutOfBounds", "adPos:" + paramInt3, paramAbsListView);
        }
      }
    }
    return false;
  }
  
  public boolean a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt4 < paramInt1) || (paramInt4 > paramInt1 + paramInt2)) {}
    View localView;
    do
    {
      return false;
      localView = paramAbsListView.getChildAt(paramInt4 - paramInt1);
    } while (localView == null);
    try
    {
      paramInt1 = Math.abs(paramAbsListView.getBottom() - localView.getTop() - paramAbsListView.getTop());
      if ((paramInt1 > 0) && (!this.Y.contains(Integer.valueOf(paramInt4))))
      {
        this.Y.add(Integer.valueOf(paramInt4));
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "invalidADExposurePos add " + paramInt4 + " showHeight = " + paramInt1 + " viewHeight = " + this.c.get(paramInt4));
        }
      }
      boolean bool = af(Math.abs(paramAbsListView.getBottom() - localView.getTop() - paramAbsListView.getTop()), this.c.get(paramInt4));
      return bool;
    }
    catch (RuntimeException paramAbsListView)
    {
      wja.a("FastWebActivityCheckAdOutOfBounds", "adPos:" + paramInt4, paramAbsListView);
    }
    return false;
  }
  
  public void aZs()
  {
    if (this.ay != null) {
      this.ay.clear();
    }
    if (this.az != null) {
      this.az.clear();
    }
    if (this.cX != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.cX);
    }
    if (this.a != null) {
      ThreadManager.getUIHandler().removeCallbacks(this.a);
    }
  }
  
  public void b(int paramInt, b paramb)
  {
    if (this.az == null) {
      this.az = new SparseArray();
    }
    int i = a(this.az, paramb.a());
    if (i >= 0) {
      this.az.remove(i);
    }
    this.az.put(paramInt, paramb);
    aZu();
  }
  
  public void bW(ArrayList<a> paramArrayList)
  {
    Iterator localIterator1 = paramArrayList.iterator();
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label125;
      }
      a locala1 = (a)localIterator1.next();
      Iterator localIterator2 = this.lK.iterator();
      a locala2;
      while (localIterator2.hasNext())
      {
        locala2 = (a)localIterator2.next();
        if (locala1.f == locala2.f) {
          locala1.a(locala2);
        }
      }
      localIterator2 = this.lL.iterator();
      if (localIterator2.hasNext())
      {
        locala2 = (a)localIterator2.next();
        if (locala1.f != locala2.f) {
          break;
        }
        locala1.a(locala2);
      }
    }
    label125:
    this.lK.clear();
    this.lK.addAll(paramArrayList);
    this.lL.clear();
    this.lL.addAll(paramArrayList);
  }
  
  public void dl(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      int i;
      Object localObject;
      if (this.az != null)
      {
        this.az.remove(paramInt1);
        i = paramInt1 + 1;
        while (i < paramInt2)
        {
          localObject = (b)this.az.get(i);
          if (localObject != null)
          {
            this.az.delete(i);
            this.az.put(i - 1, localObject);
          }
          i += 1;
        }
      }
      if (this.ay != null)
      {
        this.ay.remove(paramInt1);
        i = paramInt1 + 1;
        while (i < paramInt2)
        {
          localObject = (b)this.ay.get(i);
          if (localObject != null)
          {
            this.ay.delete(i);
            this.ay.put(i - 1, localObject);
          }
          i += 1;
        }
      }
      if (this.lK != null)
      {
        localObject = this.lK.iterator();
        while (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Iterator)localObject).next();
          if (locala.postion == paramInt1) {
            ((Iterator)localObject).remove();
          } else if (locala.postion > paramInt1) {
            locala.postion -= 1;
          }
        }
      }
    }
  }
  
  public void l(AbsListView paramAbsListView, int paramInt)
  {
    QLog.d(TAG, 2, "" + paramInt);
    if (!FL()) {
      return;
    }
    if (this.a == null) {
      this.a = new OneSecondCallbackLoop(paramAbsListView, paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      m(paramAbsListView, paramInt);
      ThreadManager.getUIHandler().postDelayed(this.cX, 1000L);
      return;
    }
    m(paramAbsListView, paramInt);
    ThreadManager.getUIHandler().removeCallbacks(this.cX);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!FL()) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      Iterator localIterator = this.lK.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (a(paramAbsListView, paramInt1, paramInt2, paramInt3, locala.postion))
        {
          if ((locala.G.longValue() != 0L) && (System.currentTimeMillis() - locala.G.longValue() >= 1000L))
          {
            localArrayList.add(Integer.valueOf(locala.postion));
            locala.exposureTime = (System.currentTimeMillis() - locala.G.longValue());
            locala.kD = a(paramAbsListView, paramInt1, paramInt2, paramInt3, locala.postion);
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "need report ,ad pos is =" + locala.postion + "  show time=" + locala.G + " exposureTime = " + locala.exposureTime + " exposureArea = " + locala.kD);
            }
          }
          else if (locala.G.longValue() == 0L)
          {
            locala.kD = a(paramAbsListView, paramInt1, paramInt2, paramInt3, locala.postion);
            locala.G = Long.valueOf(System.currentTimeMillis());
          }
        }
        else {
          locala.G = Long.valueOf(0L);
        }
      }
    } while (localArrayList.size() <= 0);
    bV(localArrayList);
  }
  
  public static class CheckAndStartWebProcessRunnable
    implements Runnable
  {
    private WeakReference<QQAppInterface> mWeakReference;
    
    public CheckAndStartWebProcessRunnable(QQAppInterface paramQQAppInterface)
    {
      this.mWeakReference = new WeakReference(paramQQAppInterface);
    }
    
    public void run()
    {
      if (WebProcessManager.aFS()) {
        if (QLog.isColorLevel()) {
          QLog.d(ItemShowDispatcher.TAG, 2, "checkWebProcess WebProcess Already Exist.");
        }
      }
      do
      {
        do
        {
          return;
        } while ((this.mWeakReference == null) || (this.mWeakReference.get() == null));
        WebProcessManager localWebProcessManager = (WebProcessManager)((QQAppInterface)this.mWeakReference.get()).getManager(13);
        if (localWebProcessManager != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(ItemShowDispatcher.TAG, 2, "checkWebProcess start preload web process");
          }
          localWebProcessManager.egu();
        }
      } while (!QLog.isColorLevel());
      QLog.d(ItemShowDispatcher.TAG, 2, "checkWebProcess enter preload web process");
    }
  }
  
  public class OneSecondCallbackLoop
    implements Runnable
  {
    private AbsListView d;
    private int state;
    
    public OneSecondCallbackLoop(AbsListView paramAbsListView, int paramInt)
    {
      this.d = paramAbsListView;
      this.state = paramInt;
    }
    
    public void run()
    {
      QLog.d(ItemShowDispatcher.TAG, 2, "  1秒到了 ");
      ItemShowDispatcher.a(ItemShowDispatcher.this, this.d, this.state);
      if (ItemShowDispatcher.a(ItemShowDispatcher.this)) {
        ThreadManager.getUIHandler().postDelayed(this, 1000L);
      }
    }
  }
  
  public static class a
  {
    public Long G;
    public long exposureTime;
    public BaseData f;
    public float kD;
    public int postion;
    public long xJ;
    
    public a(int paramInt, Long paramLong, BaseData paramBaseData)
    {
      this.postion = paramInt;
      this.G = paramLong;
      this.exposureTime = 0L;
      this.kD = 0.0F;
      this.f = paramBaseData;
      this.xJ = 0L;
    }
    
    public void a(a parama)
    {
      if (parama != null)
      {
        this.G = parama.G;
        this.exposureTime = parama.exposureTime;
        this.kD = parama.kD;
        this.f = parama.f;
        this.xJ = parama.xJ;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract BaseData a();
    
    public abstract void aED();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher
 * JD-Core Version:    0.7.0.1
 */