import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.leba.LebaMgrDataLogic.1;
import com.tencent.mobileqq.activity.leba.LebaMgrDataLogic.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class zjp
{
  private boolean brr;
  public int cdu;
  public HashMap<Long, Integer> hp;
  public long lastClickTime;
  public final List<aimt> uo = new ArrayList();
  public final List<aimt> up;
  public final List<aimt> uq;
  public final List<aimt> ur;
  public final List<aimt> us;
  public final List<aimt> ut;
  public final List<aimt> uu;
  public final List<List<aimt>> uv;
  
  public zjp()
  {
    this.uo.add(a());
    this.up = new ArrayList();
    this.uq = new ArrayList();
    this.ur = new ArrayList();
    this.us = new ArrayList();
    this.ut = new ArrayList();
    this.uu = new ArrayList();
    this.uv = new ArrayList();
    this.uv.add(this.uo);
    this.uv.add(this.up);
    this.uv.add(this.uq);
    this.uv.add(this.ur);
    this.uv.add(this.us);
    this.uv.add(this.ut);
    this.uv.add(this.uu);
  }
  
  public void BJ(boolean paramBoolean)
  {
    this.brr = paramBoolean;
  }
  
  public int a(aimt paramaimt)
  {
    int i;
    if (this.brr) {
      i = this.uq.size();
    }
    int j;
    do
    {
      return i;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.uq.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((aimt)localIterator.next()).g);
      }
      localArrayList.add(paramaimt.g);
      acgw.G(localArrayList, jdMethod_do());
      j = localArrayList.indexOf(paramaimt.g);
      i = j;
    } while (j != -1);
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "findOpenInsertPosition index == -1");
    return this.uq.size();
  }
  
  public aimt a()
  {
    aimt localaimt = new aimt();
    localaimt.viewType = 1;
    return localaimt;
  }
  
  public aimt a(int paramInt)
  {
    if (paramInt < 0)
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "getItem" + paramInt);
      return null;
    }
    Iterator localIterator = this.uv.iterator();
    List localList;
    for (int i = 0; localIterator.hasNext(); i = localList.size() + i)
    {
      localList = (List)localIterator.next();
      if (paramInt < localList.size() + i) {
        return (aimt)localList.get(paramInt - i);
      }
    }
    return null;
  }
  
  public aimt a(aevs paramaevs)
  {
    aimt localaimt = new aimt();
    localaimt.viewType = 2;
    localaimt.g = paramaevs;
    return localaimt;
  }
  
  public aimt a(Context paramContext, boolean paramBoolean)
  {
    aimt localaimt = new aimt();
    localaimt.viewType = 1;
    if (paramBoolean)
    {
      if (this.brr) {}
      for (paramContext = paramContext.getString(2131695244);; paramContext = paramContext.getString(2131695243))
      {
        localaimt.title = paramContext;
        return localaimt;
      }
    }
    localaimt.title = paramContext.getString(2131695242);
    return localaimt;
  }
  
  public void a(aevs paramaevs, boolean paramBoolean)
  {
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "handlePluginSwitch");
    ThreadManager.excute(new LebaMgrDataLogic.1(this, paramaevs, paramBoolean), 128, null, true);
  }
  
  public void a(aimt paramaimt, long paramLong, boolean paramBoolean, StringBuilder paramStringBuilder)
  {
    if (this.hp == null) {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "reportItemSequence mInitPosMap == null");
    }
    while ((paramaimt == null) || (paramaimt.g == null)) {
      return;
    }
    long l2 = paramaimt.g.WP;
    paramaimt = (Integer)this.hp.get(Long.valueOf(l2));
    long l1;
    if (paramaimt != null)
    {
      l1 = paramaimt.intValue() + 1;
      if (!paramBoolean) {
        break label113;
      }
    }
    label113:
    for (paramLong = 1L + paramLong;; paramLong = 0L)
    {
      paramStringBuilder.append(l2).append("_").append(l1).append("_").append(paramLong).append(";");
      return;
      l1 = 0L;
      break;
    }
  }
  
  public void a(aimu paramaimu)
  {
    if (paramaimu != null) {}
    try
    {
      paramaimu.notifyDataSetChanged();
      cpB();
      return;
    }
    catch (Exception paramaimu)
    {
      for (;;)
      {
        QLog.i("leba_sort_LebaMgrDataLogic", 1, "onDargEnd", paramaimu);
      }
    }
  }
  
  public void a(aimu paramaimu, List<aimt> paramList1, List<aimt> paramList2)
  {
    int i = 0;
    int k = paramList2.size();
    int m = fC(paramList1.size());
    int j = n(paramList2);
    if (k > m)
    {
      k -= m;
      i = 0;
      while (i < k)
      {
        paramList2.remove(0);
        i += 1;
      }
      paramaimu.notifyItemRangeRemoved(j, k);
    }
    while (k >= m) {
      return;
    }
    k = m - k;
    while (i < k)
    {
      paramList2.add(a(null));
      i += 1;
    }
    paramaimu.notifyItemRangeInserted(paramList2.size() + j - k, k);
  }
  
  public void a(Context paramContext, aimu paramaimu, aimt paramaimt, aimu.a parama)
  {
    try
    {
      if (qH())
      {
        QLog.i("leba_sort_LebaMgrDataLogic", 1, "openPlugin isFastClick");
        return;
      }
      if ((paramaimt == null) || (paramaimt.g == null) || (paramaimt.viewType != 2) || (!this.ut.contains(paramaimt)))
      {
        QLog.i("leba_sort_LebaMgrDataLogic", 1, "openPlugin error ");
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "closePlugin", paramContext);
      return;
    }
    long l = System.currentTimeMillis();
    int i = n(this.ut) + this.ut.indexOf(paramaimt);
    paramaimt.g.cXq();
    paramaimu.a(parama, paramaimt);
    int j = a(paramaimt);
    this.uq.add(j, paramaimt);
    this.ut.remove(paramaimt);
    paramaimu.notifyItemMoved(i, j + n(this.uq));
    if (this.up.isEmpty())
    {
      this.up.add(a(paramContext, true));
      paramaimu.notifyItemInserted(n(this.up));
    }
    if (this.ut.isEmpty())
    {
      this.us.clear();
      paramaimu.notifyItemRemoved(n(this.us));
    }
    a(paramaimu, this.uq, this.ur);
    a(paramaimu, this.ut, this.uu);
    a(paramaimt.g, true);
    if (this.brr) {
      cpB();
    }
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "openPlugin position=" + i + ", time= " + (System.currentTimeMillis() - l));
  }
  
  public void a(Context paramContext, List<aevs> paramList, List<Integer> paramList1, int paramInt, aimu paramaimu)
  {
    if (paramaimu == null)
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "initShowMgrData adpter == null ");
      return;
    }
    this.cdu = paramInt;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "initShowMgrData srcList isEmpty " + this.cdu);
      this.up.clear();
      this.uq.clear();
      this.ur.clear();
      this.us.clear();
      this.ut.clear();
      this.uu.clear();
      paramaimu.notifyDataSetChanged();
      cpA();
      return;
    }
    this.up.clear();
    this.uq.clear();
    this.ur.clear();
    this.us.clear();
    this.ut.clear();
    this.uu.clear();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    b(localArrayList1, localArrayList2, paramList, paramList1);
    a(paramContext, localArrayList1, true);
    a(paramContext, localArrayList2, false);
    paramaimu.notifyDataSetChanged();
    cpA();
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "initShowMgrData " + this.cdu);
  }
  
  public void a(Context paramContext, List<aevs> paramList, boolean paramBoolean)
  {
    List localList1;
    List localList2;
    label20:
    List localList3;
    if (paramBoolean)
    {
      localList1 = this.up;
      if (!paramBoolean) {
        break label102;
      }
      localList2 = this.uq;
      if (!paramBoolean) {
        break label111;
      }
      localList3 = this.ur;
    }
    for (;;)
    {
      label30:
      if (!paramList.isEmpty())
      {
        localList1.add(a(paramContext, paramBoolean));
        paramContext = paramList.iterator();
        for (;;)
        {
          if (paramContext.hasNext())
          {
            localList2.add(a((aevs)paramContext.next()));
            continue;
            localList1 = this.us;
            break;
            label102:
            localList2 = this.ut;
            break label20;
            label111:
            localList3 = this.uu;
            break label30;
          }
        }
        int j = fC(localList2.size());
        if (j > 0)
        {
          int i = 0;
          while (i < j)
          {
            localList3.add(a(null));
            i += 1;
          }
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, anpv paramanpv)
  {
    anny.b(paramQQAppInterface, paramanpv);
  }
  
  public boolean a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    aimt localaimt1 = a(paramInt1);
    if ((localaimt1 == null) || (!this.uq.contains(localaimt1))) {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "onDargMove start error " + paramInt1);
    }
    int i;
    do
    {
      aimt localaimt2;
      do
      {
        return false;
        localaimt2 = a(paramInt2);
      } while ((localaimt2 == null) || ((!this.uq.contains(localaimt2)) && (!this.ur.contains(localaimt2))));
      paramInt2 = this.uq.indexOf(localaimt1);
      if (this.ur.contains(localaimt2)) {}
      for (i = this.uq.size() - 1; paramInt2 < i; i = this.uq.indexOf(localaimt2))
      {
        j = paramInt2;
        while (j < i)
        {
          Collections.swap(this.uq, j, j + 1);
          j += 1;
        }
      }
    } while (paramInt2 <= i);
    int j = paramInt2;
    while (j > i)
    {
      Collections.swap(this.uq, j, j - 1);
      j -= 1;
    }
    if (paramRecyclerView.getAdapter() != null) {
      paramRecyclerView.getAdapter().notifyItemMoved(paramInt1, i + paramInt1 - paramInt2);
    }
    return true;
  }
  
  public int b(aimt paramaimt)
  {
    int i = 0;
    int j = 0;
    while (i < this.ut.size())
    {
      aimt localaimt = (aimt)this.ut.get(i);
      int k = j;
      if (localaimt != null)
      {
        k = j;
        if (localaimt.g != null)
        {
          if (localaimt.g.a != null) {
            break label75;
          }
          k = j;
        }
      }
      i += 1;
      j = k;
      continue;
      label75:
      if (paramaimt.g.a.sPriority > localaimt.g.a.sPriority) {}
      for (k = 1;; k = 0)
      {
        if (k == 0) {
          return j;
        }
        k = i + 1;
        break;
      }
    }
    return j;
  }
  
  public void b(Context paramContext, aimu paramaimu, aimt paramaimt, aimu.a parama)
  {
    try
    {
      if (qH())
      {
        QLog.i("leba_sort_LebaMgrDataLogic", 1, "closePlugin isFastClick");
        return;
      }
      if ((paramaimt == null) || (paramaimt.viewType != 2) || (paramaimt.g == null) || (!this.uq.contains(paramaimt)))
      {
        QLog.i("leba_sort_LebaMgrDataLogic", 1, "closePlugin error");
        return;
      }
    }
    catch (Exception paramContext)
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "closePlugin", paramContext);
      return;
    }
    long l = System.currentTimeMillis();
    int i = n(this.uq) + this.uq.indexOf(paramaimt);
    paramaimt.g.cXr();
    paramaimu.a(parama, paramaimt);
    int j = b(paramaimt);
    this.ut.add(j, paramaimt);
    this.uq.remove(paramaimt);
    paramaimu.notifyItemMoved(i, j + n(this.ut));
    if (this.us.isEmpty())
    {
      this.us.add(a(paramContext, false));
      paramaimu.notifyItemInserted(n(this.us));
    }
    if (this.uq.isEmpty())
    {
      this.up.clear();
      paramaimu.notifyItemRemoved(n(this.up));
    }
    a(paramaimu, this.uq, this.ur);
    a(paramaimu, this.ut, this.uu);
    a(paramaimt.g, false);
    if (this.brr) {
      cpB();
    }
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "closePlugin position=" + i + ", time=" + (System.currentTimeMillis() - l));
  }
  
  public void b(List<aevs> paramList1, List<aevs> paramList2, List<aevs> paramList3, List<Integer> paramList)
  {
    paramList3 = paramList3.iterator();
    while (paramList3.hasNext())
    {
      aevs localaevs = (aevs)paramList3.next();
      if ((localaevs != null) && (localaevs.a != null) && (TextUtils.isEmpty(localaevs.bCo)) && (localaevs.aif())) {
        if (localaevs.isOpen()) {
          paramList1.add(localaevs);
        } else {
          paramList2.add(localaevs);
        }
      }
    }
    acgw.G(paramList1, paramList);
    Collections.sort(paramList2, new acgw.a());
  }
  
  public void br(QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < this.uq.size())
    {
      a((aimt)this.uq.get(i), i, true, localStringBuilder);
      i += 1;
    }
    i = 0;
    while (i < this.ut.size())
    {
      a((aimt)this.ut.get(i), i, false, localStringBuilder);
      i += 1;
    }
    anpv localanpv = aims.a("plugin_sequence");
    localanpv.cgp = localStringBuilder.toString();
    a(paramQQAppInterface, localanpv);
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "reportSequence " + localStringBuilder);
  }
  
  public void cpA()
  {
    if (this.hp == null)
    {
      this.hp = new HashMap();
      int i = 0;
      while (i < this.uq.size())
      {
        aimt localaimt = (aimt)this.uq.get(i);
        if ((localaimt != null) && (localaimt.g != null)) {
          this.hp.put(Long.valueOf(localaimt.g.WP), Integer.valueOf(i));
        }
        i += 1;
      }
    }
  }
  
  public void cpB()
  {
    ArrayList localArrayList = new ArrayList(this.ur.size());
    int i = 0;
    while (i < this.uq.size())
    {
      aimt localaimt = (aimt)this.uq.get(i);
      if (localaimt.g != null)
      {
        localArrayList.add(Integer.valueOf((int)localaimt.g.WP));
        localaimt.g.cPv = i;
      }
      i += 1;
    }
    QLog.i("leba_sort_LebaMgrDataLogic", 1, "handlePluginSort list = " + localArrayList);
    ThreadManager.excute(new LebaMgrDataLogic.2(this, localArrayList), 128, null, true);
  }
  
  public List<Integer> jdMethod_do()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface)))
    {
      QLog.i("leba_sort_LebaMgrDataLogic", 1, "getSortList AppRuntime error ");
      return null;
    }
    return acgw.a((QQAppInterface)localAppRuntime, this.cdu);
  }
  
  public int fC(int paramInt)
  {
    paramInt %= 3;
    if (paramInt == 0) {
      return 0;
    }
    return 3 - paramInt;
  }
  
  public int getItemCount()
  {
    Iterator localIterator = this.uv.iterator();
    for (int i = 0; localIterator.hasNext(); i = ((List)localIterator.next()).size() + i) {}
    return i;
  }
  
  public int getItemViewType(int paramInt)
  {
    aimt localaimt = a(paramInt);
    if (localaimt == null) {
      return 1;
    }
    return localaimt.viewType;
  }
  
  public int n(List<aimt> paramList)
  {
    Iterator localIterator = this.uv.iterator();
    List localList;
    for (int i = 0;; i = localList.size() + i) {
      if (localIterator.hasNext())
      {
        localList = (List)localIterator.next();
        if (localList != paramList) {}
      }
      else
      {
        return i;
      }
    }
  }
  
  public boolean qH()
  {
    if (Math.abs(this.lastClickTime - System.currentTimeMillis()) < 500L) {
      return true;
    }
    this.lastClickTime = System.currentTimeMillis();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zjp
 * JD-Core Version:    0.7.0.1
 */