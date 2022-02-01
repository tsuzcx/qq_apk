import com.tencent.biz.pubaccount.readinjoy.logic.ReadinjoyFixPosArticleManager.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class lgy
{
  private static volatile lgy jdField_a_of_type_Lgy;
  private lgy.a jdField_a_of_type_Lgy$a = new lgy.a(1);
  private HashMap<Integer, WeakReference<ndi>> dK = new HashMap();
  
  private static int B(long paramLong)
  {
    return (int)(-paramLong & 0xFFFFFFFF);
  }
  
  private int a(int paramInt1, List<BaseArticleInfo> paramList, int paramInt2)
  {
    paramInt1 = 0;
    while (paramInt1 < paramList.size())
    {
      if (paramInt2 == 0)
      {
        paramList = (BaseArticleInfo)paramList.get(paramInt1);
        paramInt2 = paramInt1;
        if (paramList != null)
        {
          paramInt2 = paramInt1;
          if (paramList.mGroupId != -1L)
          {
            paramInt2 = paramInt1;
            if (paramList.mGroupCount != 1L)
            {
              QLog.d("ReadinjoyFixPosArticleManager", 2, "position " + paramInt1 + " is group article , groupCount : " + paramList.mGroupCount + ", nowGroupIndex : " + paramList.mFeedIndexInGroup + ", groupID : " + paramList.mGroupId);
              paramInt2 = paramInt1 + (int)(paramList.mGroupCount - paramList.mFeedIndexInGroup);
            }
          }
        }
        return paramInt2;
      }
      paramInt2 -= 1;
      paramInt1 += 1;
    }
    return -1;
  }
  
  public static lgy a()
  {
    if (jdField_a_of_type_Lgy == null) {}
    try
    {
      if (jdField_a_of_type_Lgy == null) {
        jdField_a_of_type_Lgy = new lgy();
      }
      return jdField_a_of_type_Lgy;
    }
    finally {}
  }
  
  public static boolean aP(long paramLong)
  {
    return paramLong <= 0L;
  }
  
  private static long c(int paramInt1, int paramInt2)
  {
    return -(paramInt1 << 32 | paramInt2);
  }
  
  private void qY(int paramInt)
  {
    QLog.d("ReadinjoyFixPosArticleManager", 1, "on async data refresh , channelID  : " + paramInt);
    Object localObject1 = (WeakReference)this.dK.get(Integer.valueOf(paramInt));
    if (localObject1 == null) {}
    ArrayList localArrayList;
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = (ndi)((WeakReference)localObject1).get();
      } while ((localObject1 == null) || (((ndi)localObject1).isEmpty()));
      localArrayList = new ArrayList();
      localObject2 = ((ndi)localObject1).getData().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)((Iterator)localObject2).next();
        if (!aP(localBaseArticleInfo.mRecommendSeq)) {
          localArrayList.add(localBaseArticleInfo);
        }
      }
      localObject2 = a(paramInt, localArrayList, localArrayList, 3);
    } while (localObject2 == localArrayList);
    ThreadManager.getUIHandler().post(new ReadinjoyFixPosArticleManager.1(this, (ndi)localObject1, (List)localObject2));
  }
  
  public void F(int paramInt, long paramLong)
  {
    if (!aP(paramLong)) {
      return;
    }
    int i = B(paramLong);
    this.jdField_a_of_type_Lgy$a.cJ(paramInt, i);
  }
  
  public List<BaseArticleInfo> a(int paramInt1, List<BaseArticleInfo> paramList1, List<BaseArticleInfo> paramList2, int paramInt2)
  {
    if (paramList1 == null) {
      return null;
    }
    this.jdField_a_of_type_Lgy$a.qZ(paramInt1);
    if (!this.jdField_a_of_type_Lgy$a.dI(paramInt1))
    {
      QLog.d("ReadinjoyFixPosArticleManager", 1, "has no fix article , give up insert !");
      return paramList1;
    }
    QLog.d("ReadinjoyFixPosArticleManager", 1, "insertFixPosArticles type : " + paramInt2 + ", channelID : " + paramInt1);
    long l;
    int j;
    if (paramInt2 == 2)
    {
      paramInt2 = 0;
      if (paramInt2 < paramList2.size())
      {
        l = ((BaseArticleInfo)paramList2.get(paramInt2)).mRecommendSeq;
        if (!aP(l)) {}
        for (;;)
        {
          paramInt2 += 1;
          break;
          i = B(l);
          j = paramInt2 - i;
          localArrayList1 = (ArrayList)this.jdField_a_of_type_Lgy$a.dL.get(Integer.valueOf(paramInt1));
          localArrayList2 = (ArrayList)this.jdField_a_of_type_Lgy$a.dM.get(Integer.valueOf(paramInt1));
          if ((localArrayList1 != null) && (localArrayList2 != null))
          {
            int k = localArrayList1.indexOf(Integer.valueOf(i));
            if (k >= 0)
            {
              localArrayList2.set(k, Integer.valueOf(j));
              QLog.d("ReadinjoyFixPosArticleManager", 1, "fix offset when loadMore, expect : " + i + ", now : " + paramInt2 + ", offset : " + j);
            }
          }
        }
      }
    }
    paramList2 = (ArrayList)this.jdField_a_of_type_Lgy$a.dL.get(Integer.valueOf(paramInt1));
    ArrayList localArrayList1 = (ArrayList)this.jdField_a_of_type_Lgy$a.dM.get(Integer.valueOf(paramInt1));
    Object localObject = (ArrayList)this.jdField_a_of_type_Lgy$a.dN.get(Integer.valueOf(paramInt1));
    if ((paramList2 == null) || (localArrayList1 == null) || (localObject == null))
    {
      QLog.d("ReadinjoyFixPosArticleManager", 1, "ad article or positions is empty ! return ori data ");
      return paramList1;
    }
    ArrayList localArrayList2 = new ArrayList(paramList1);
    int i = Math.min(paramList2.size(), ((ArrayList)localObject).size());
    paramInt2 = 0;
    if (paramInt2 < i)
    {
      j = ((Integer)paramList2.get(paramInt2)).intValue();
      j = ((Integer)localArrayList1.get(paramInt2)).intValue() + j;
      if (paramList1.size() + paramList2.size() < j + 1) {
        QLog.d("ReadinjoyFixPosArticleManager", 1, "expect insert into " + j + ", but article size is not enougharticle size:" + paramList1.size() + " sp size: " + paramList2.size());
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        j = a(paramInt1, localArrayList2, j);
        if (j == -1)
        {
          QLog.d("ReadinjoyFixPosArticleManager", 1, "find real position is error ! ");
        }
        else
        {
          l = c(1, ((Integer)paramList2.get(paramInt2)).intValue());
          QLog.d("ReadinjoyFixPosArticleManager", 1, "insert article , position : " + j + ", expectIndex : " + paramList2.get(paramInt2) + ", fakeSeq : " + l);
          localObject = lbz.a().a(paramInt1, l);
          if (localObject != null) {
            localArrayList2.add(j, localObject);
          }
        }
      }
    }
    return localArrayList2;
  }
  
  public void a(int paramInt, ndi paramndi)
  {
    if (paramndi == null) {
      return;
    }
    this.dK.put(Integer.valueOf(paramInt), new WeakReference(paramndi));
    this.jdField_a_of_type_Lgy$a.ra(paramInt);
  }
  
  public ArticleInfo c(int paramInt, long paramLong)
  {
    return (ArticleInfo)this.jdField_a_of_type_Lgy$a.a(paramInt, B(paramLong));
  }
  
  public void qW(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyFixPosArticleManager", 2, " registerReommendADListener " + paramInt);
    }
    this.jdField_a_of_type_Lgy$a.ra(paramInt);
  }
  
  public void qX(int paramInt)
  {
    this.dK.remove(Integer.valueOf(paramInt));
    this.jdField_a_of_type_Lgy$a.rb(paramInt);
  }
  
  class a
  {
    private lhw.a a = new lgz(this);
    public int busiType;
    HashMap<Integer, ArrayList<Integer>> dL = new HashMap();
    HashMap<Integer, ArrayList<Integer>> dM = new HashMap();
    HashMap<Integer, ArrayList<BaseArticleInfo>> dN = new HashMap();
    
    a(int paramInt)
    {
      this.busiType = paramInt;
    }
    
    private lhw a()
    {
      AppRuntime localAppRuntime = kxm.getAppRuntime();
      if (localAppRuntime != null) {
        return ((lcd)localAppRuntime.getManager(163)).b().a();
      }
      return null;
    }
    
    public BaseArticleInfo a(int paramInt1, int paramInt2)
    {
      Object localObject = (ArrayList)this.dL.get(Integer.valueOf(paramInt1));
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        int i = ((ArrayList)localObject).indexOf(Integer.valueOf(paramInt2));
        if (i != -1)
        {
          if ((this.dN.containsKey(Integer.valueOf(paramInt1))) && (i < ((ArrayList)this.dN.get(Integer.valueOf(paramInt1))).size()))
          {
            localObject = (BaseArticleInfo)((ArrayList)this.dN.get(Integer.valueOf(paramInt1))).get(i);
            if (localObject != null) {
              ((BaseArticleInfo)localObject).mRecommendSeq = lgy.d(1, paramInt2);
            }
            return localObject;
          }
          QLog.d("ReadinjoyFixPosArticleManager", 1, "article isn't exist ! positon : " + paramInt2);
        }
      }
      for (;;)
      {
        return null;
        QLog.d("ReadinjoyFixPosArticleManager", 1, "positons is null !");
      }
    }
    
    void cJ(int paramInt1, int paramInt2)
    {
      ArrayList localArrayList = (ArrayList)this.dL.get(Integer.valueOf(paramInt1));
      if (localArrayList != null)
      {
        int i = localArrayList.indexOf(Integer.valueOf(paramInt2));
        if (i != -1)
        {
          ((ArrayList)this.dL.get(Integer.valueOf(paramInt1))).remove(i);
          ((ArrayList)this.dM.get(Integer.valueOf(paramInt1))).remove(i);
          ((ArrayList)this.dN.get(Integer.valueOf(paramInt1))).remove(i);
          QLog.d("ReadinjoyFixPosArticleManager", 1, "delete ad article , position : " + paramInt2);
        }
      }
    }
    
    boolean dI(int paramInt)
    {
      for (;;)
      {
        try
        {
          if ((this.dL.get(Integer.valueOf(paramInt)) != null) && (((ArrayList)this.dL.get(Integer.valueOf(paramInt))).size() > 0) && (this.dN.get(Integer.valueOf(paramInt)) != null) && (((ArrayList)this.dN.get(Integer.valueOf(paramInt))).size() > 0))
          {
            bool = true;
            return bool;
          }
        }
        finally {}
        boolean bool = false;
      }
    }
    
    void qZ(int paramInt)
    {
      int j = 0;
      reset(paramInt);
      Object localObject2 = a();
      if (localObject2 == null)
      {
        QLog.d("ReadinjoyFixPosArticleManager", 1, "adinterface is null !");
        return;
      }
      Object localObject3 = ((lhw)localObject2).c(paramInt);
      if ((localObject3 == null) || (localObject3.length <= 0))
      {
        QLog.d("ReadinjoyFixPosArticleManager", 1, "get ad position fail ~ return data is null !");
        return;
      }
      Object localObject1 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localObject3.length)
      {
        ((ArrayList)localObject1).add(Integer.valueOf(localObject3[i]));
        localArrayList.add(Integer.valueOf(0));
        i += 1;
      }
      Collections.sort((List)localObject1, new lha(this));
      this.dL.put(Integer.valueOf(paramInt), localObject1);
      this.dM.put(Integer.valueOf(paramInt), localArrayList);
      localObject2 = ((lhw)localObject2).k(paramInt);
      if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
      {
        localObject3 = new ArrayList((Collection)localObject2);
        this.dN.put(Integer.valueOf(paramInt), localObject3);
      }
      localObject1 = new StringBuilder().append("ad pos : ").append(localObject1).append(", channelID : ").append(paramInt).append(", articleSize : ");
      paramInt = j;
      if (localObject2 != null) {
        paramInt = ((ArrayList)localObject2).size();
      }
      QLog.d("ReadinjoyFixPosArticleManager", 1, paramInt);
    }
    
    void ra(int paramInt)
    {
      lhw locallhw = a();
      if (locallhw != null) {
        locallhw.a(paramInt, this.a);
      }
    }
    
    void rb(int paramInt)
    {
      lhw locallhw = a();
      if (locallhw != null) {
        locallhw.rd(paramInt);
      }
    }
    
    public void reset(int paramInt)
    {
      try
      {
        this.dL.remove(Integer.valueOf(paramInt));
        this.dN.remove(Integer.valueOf(paramInt));
        this.dM.remove(Integer.valueOf(paramInt));
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgy
 * JD-Core Version:    0.7.0.1
 */