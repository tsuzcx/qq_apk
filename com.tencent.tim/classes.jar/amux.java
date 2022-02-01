import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.search.searchengine.ApproximateSearchEngine.2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class amux
  implements amwd<ampt>
{
  private static Queue<amux.b> I = new ConcurrentLinkedQueue();
  private static final Comparator<ampt> X = new amuy();
  private static Object mLock = new Object();
  private List<ampt> Gg = new ArrayList();
  private List<WeakReference<amux.a>> Gh = new ArrayList();
  private amwe<ampt> jdField_a_of_type_Amwe;
  private amux.c[] jdField_a_of_type_ArrayOfAmux$c = { new amux.c(1, "friend"), new amux.c(768, "phone_contact"), new amux.c(8, "discussion"), new amux.c(16, "troop") };
  protected QQAppInterface app;
  private Set<String> cV;
  private String caU;
  private String ccj;
  private int dCH;
  private Object eE = new Object();
  private int fromType;
  private String type;
  
  public amux(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, Set<String> paramSet)
  {
    this.app = paramQQAppInterface;
    this.dCH = paramInt2;
    this.fromType = paramInt1;
    this.cV = paramSet;
    this.caU = paramString;
    this.type = "people";
  }
  
  public amux(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, Set<String> paramSet)
  {
    this(paramQQAppInterface, paramInt1, paramInt2, null, paramSet);
  }
  
  private static int a(ampt paramampt1, ampt paramampt2)
  {
    int j = 0;
    int i = j;
    if (paramampt2.za() != null)
    {
      i = j;
      if (paramampt1.za() != null) {
        i = paramampt1.za().toString().compareTo(paramampt2.za().toString());
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (paramampt2.zb() != null)
      {
        j = i;
        if (paramampt1.zb() != null) {
          j = paramampt1.zb().toString().compareTo(paramampt2.zb().toString());
        }
      }
    }
    return j;
  }
  
  private List<ampt> a(amux.a parama)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_ArrayOfAmux$c.length)
    {
      if ("global_troop_member".equals(Integer.valueOf(this.jdField_a_of_type_ArrayOfAmux$c[i].type))) {}
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_ArrayOfAmux$c[i].akd = -1L;
      }
    }
    String str = this.ccj;
    ??? = h(str, false);
    ArrayList localArrayList1 = new ArrayList();
    if (??? != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ApproximateSearchEngine", 2, "searchContactWithoutTroopMember use cache, keyword = " + str);
      }
      localArrayList1.addAll((Collection)???);
      return localArrayList1;
    }
    ArrayList localArrayList2 = new ArrayList();
    for (;;)
    {
      try
      {
        if (this.Gg.size() == 0) {
          return null;
        }
        localArrayList2.addAll(this.Gg);
        i = 0;
        if (i >= localArrayList2.size()) {
          break;
        }
        if (parama.getValue())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApproximateSearchEngine", 2, "searchContactWithoutTroopMember canceled, keyword = " + str);
          }
          return null;
        }
      }
      finally {}
      synchronized ((ampt)localArrayList2.get(i))
      {
        amxi localamxi = ((ampt)???).a(str);
        if ((localamxi != null) && (localamxi.isMatched)) {
          localArrayList1.add(???);
        }
        i += 1;
      }
    }
    e(str, localArrayList1, false);
    return localArrayList1;
  }
  
  private void e(String paramString, List<ampt> paramList, boolean paramBoolean)
  {
    Queue localQueue;
    synchronized (mLock)
    {
      if ((TextUtils.isEmpty(paramString)) || (paramString.trim().contains(" ")) || (paramList == null)) {
        return;
      }
      localQueue = I;
      if (localQueue.size() > 2) {
        localQueue.poll();
      }
    }
    if (localQueue.size() == 2)
    {
      if (paramList.isEmpty()) {
        break label118;
      }
      localQueue.poll();
    }
    for (;;)
    {
      localQueue.add(new amux.b(paramString, paramList));
      return;
      label118:
      Iterator localIterator = localQueue.iterator();
      while (localIterator.hasNext())
      {
        amux.b localb = (amux.b)localIterator.next();
        if (localb.Gi.isEmpty()) {
          localQueue.remove(localb);
        }
      }
      if (localQueue.size() == 2) {
        localQueue.poll();
      }
    }
  }
  
  private List<ampt> f(amwt paramamwt)
  {
    amux.a locala = new amux.a(false);
    boolean bool;
    do
    {
      ArrayList localArrayList;
      do
      {
        synchronized (this.eE)
        {
          this.Gh.add(new WeakReference(locala));
          this.ccj = paramamwt.keyword;
          paramamwt = this.ccj;
          if (locala.getValue())
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApproximateSearchEngine", 2, "searchContact canceled, keyword = " + paramamwt);
            }
            return null;
          }
        }
        localArrayList = new ArrayList();
        ??? = a(locala);
        if (!locala.getValue()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ApproximateSearchEngine", 2, "searchContact canceled, keyword = " + paramamwt);
      return null;
      if (??? != null) {
        localArrayList.addAll((Collection)???);
      }
      ??? = new ArrayList();
      bool = a(localArrayList, (List)???, locala, paramamwt);
      paramamwt = (amwt)???;
      if (((List)???).size() > 40) {
        paramamwt = ((List)???).subList(0, 40);
      }
    } while (bool);
    return paramamwt;
  }
  
  private List<ampt> h(String paramString, boolean paramBoolean)
  {
    label243:
    label246:
    for (;;)
    {
      synchronized (mLock)
      {
        if ((TextUtils.isEmpty(paramString)) || (paramString.trim().contains(" "))) {
          return null;
        }
        int i = -2147483648;
        Iterator localIterator = I.iterator();
        Object localObject1 = null;
        if (localIterator.hasNext())
        {
          amux.b localb = (amux.b)localIterator.next();
          if ((!paramString.contains(localb.keyword)) || (localb.keyword.length() <= i)) {
            break label243;
          }
          i = localb.keyword.length();
          localObject1 = localb;
          break label246;
        }
        if ((localObject1 != null) && (localObject1.Gi != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApproximateSearchEngine", 2, "getBestCache hit cache, cur keyword = " + paramString + " , cache keyword = " + localObject1.keyword + " , cache size = " + localObject1.Gi.size());
          }
          paramString = localObject1.Gi;
          return paramString;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApproximateSearchEngine", 2, "getBestCache miss cache, cur keyword = " + paramString);
      }
      return null;
    }
  }
  
  public static int ji(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1: 
      return 0;
    case 768: 
      return 1;
    case 8: 
      return 2;
    }
    return 3;
  }
  
  public List<ampt> a(amwt paramamwt)
  {
    return f(paramamwt);
  }
  
  public void a(amwt paramamwt, amwe<ampt> paramamwe)
  {
    this.jdField_a_of_type_Amwe = paramamwe;
    ThreadManager.postImmediately(new ApproximateSearchEngine.2(this, paramamwt), null, true);
  }
  
  public boolean a(List<ampt> paramList1, List<ampt> paramList2, amux.a arg3, String paramString)
  {
    amux.a locala = ???;
    if (??? == null) {
      locala = new amux.a(false);
    }
    ampt localampt1;
    for (;;)
    {
      ampt localampt2;
      synchronized (this.eE)
      {
        this.Gh.add(new WeakReference(locala));
        ??? = new HashMap();
        paramList1 = paramList1.iterator();
        if (!paramList1.hasNext()) {
          break;
        }
        localampt1 = (ampt)paramList1.next();
        localampt2 = (ampt)???.get(localampt1.S());
        if (locala.getValue())
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApproximateSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
          }
          return true;
        }
      }
      if ((localampt2 == null) || (localampt2.gN() < localampt1.gN())) {
        ???.put(localampt1.S(), localampt1);
      }
    }
    paramList1 = new ArrayList();
    ??? = ???.values().iterator();
    while (???.hasNext())
    {
      localampt1 = (ampt)???.next();
      if (locala.getValue())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApproximateSearchEngine", 2, "searchContact canceled, keyword = " + paramString);
        }
        return true;
      }
      localampt1 = (ampt)localampt1.clone();
      if (localampt1 != null) {
        paramList1.add(localampt1);
      }
    }
    Collections.sort(paramList1, X);
    paramList2.addAll(paramList1);
    return false;
  }
  
  protected List<ampt> ak(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAmux$c.length)
    {
      this.jdField_a_of_type_ArrayOfAmux$c[i].dDH = 0;
      this.jdField_a_of_type_ArrayOfAmux$c[i].initTime = 0L;
      i += 1;
    }
    Object localObject2 = new ArrayList();
    long l1;
    Object localObject3;
    Object localObject4;
    Object localObject1;
    label168:
    label253:
    long l2;
    if ((paramInt & 0x1) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject3 = new ArrayList();
      localObject4 = (acff)this.app.getManager(51);
      if (localObject4 != null)
      {
        this.app.getCurrentAccountUin();
        localObject1 = ((acff)localObject4).cp();
        if (localObject1 != null)
        {
          Iterator localIterator1 = ((List)localObject1).iterator();
          while (localIterator1.hasNext())
          {
            Groups localGroups = (Groups)localIterator1.next();
            localObject1 = ((acff)localObject4).B(String.valueOf(localGroups.group_id));
            if (localObject1 != null)
            {
              Iterator localIterator2 = ((List)localObject1).iterator();
              Friends localFriends;
              QQAppInterface localQQAppInterface;
              if (localIterator2.hasNext())
              {
                localFriends = (Friends)localIterator2.next();
                localQQAppInterface = this.app;
                i = this.fromType;
                if (localFriends.gathtertype != 1) {
                  break label253;
                }
              }
              for (localObject1 = BaseApplicationImpl.sApplication.getResources().getString(2131721547);; localObject1 = localGroups.group_name)
              {
                ((List)localObject3).add(new amok(localQQAppInterface, i, localFriends, (String)localObject1, 0L));
                break label168;
                break;
              }
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject3);
      l2 = System.currentTimeMillis();
      i = ji(1);
      this.jdField_a_of_type_ArrayOfAmux$c[i].initTime = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAmux$c[i].dDH = ((List)localObject3).size();
    }
    if ((paramInt & 0x100) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (ajdo)this.app.getManager(11);
      if (localObject3 != null)
      {
        localObject3 = ((ajdo)localObject3).cZ();
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          localObject3 = (List)((List)localObject3).get(0);
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject3).next();
              ((List)localObject1).add(new amop(this.app, this.fromType, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = ji(768);
      this.jdField_a_of_type_ArrayOfAmux$c[i].initTime = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAmux$c[i].dDH = ((List)localObject1).size();
    }
    if ((paramInt & 0x200) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = (ajdo)this.app.getManager(11);
      if (localObject3 != null)
      {
        localObject3 = ((ajdo)localObject3).cZ();
        if ((localObject3 != null) && (((List)localObject3).size() > 1))
        {
          localObject3 = (List)((List)localObject3).get(1);
          if (localObject3 != null)
          {
            localObject3 = ((List)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (PhoneContact)((Iterator)localObject3).next();
              ((List)localObject1).add(new amop(this.app, this.fromType, (PhoneContact)localObject4));
            }
          }
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = ji(768);
      this.jdField_a_of_type_ArrayOfAmux$c[i].initTime = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAmux$c[i].dDH = ((List)localObject1).size();
    }
    if ((paramInt & 0x8) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject1 = new ArrayList();
      localObject3 = ((acdu)this.app.getManager(53)).getDiscussList();
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (DiscussionInfo)((Iterator)localObject3).next();
          ((List)localObject1).add(new amoi(this.app, this.fromType, (DiscussionInfo)localObject4, null, 0));
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      i = ji(8);
      this.jdField_a_of_type_ArrayOfAmux$c[i].initTime = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAmux$c[i].dDH = ((List)localObject1).size();
    }
    if ((paramInt & 0x10) != 0)
    {
      l1 = System.currentTimeMillis();
      localObject3 = (TroopManager)this.app.getManager(52);
      localObject1 = new ArrayList();
      localObject3 = ((TroopManager)localObject3).cE();
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (TroopInfo)((Iterator)localObject3).next();
          ((List)localObject1).add(new amos(this.app, this.fromType, (TroopInfo)localObject4, 0L));
        }
      }
      ((List)localObject2).addAll((Collection)localObject1);
      l2 = System.currentTimeMillis();
      paramInt = ji(16);
      this.jdField_a_of_type_ArrayOfAmux$c[paramInt].initTime = (l2 - l1);
      this.jdField_a_of_type_ArrayOfAmux$c[paramInt].dDH = ((List)localObject1).size();
    }
    if ((this.cV != null) && (!this.cV.isEmpty()))
    {
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ampt)((Iterator)localObject2).next();
        if (!this.cV.contains(((ampt)localObject3).getUin())) {
          ((List)localObject1).add(localObject3);
        }
      }
      return localObject1;
    }
    return localObject2;
  }
  
  public void cancel()
  {
    synchronized (this.eE)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.Gh.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        amux.a locala = (amux.a)localWeakReference.get();
        if (locala != null)
        {
          locala.setValue(true);
          localArrayList.add(localWeakReference);
        }
      }
    }
    this.Gh = localObject2;
    this.jdField_a_of_type_Amwe = null;
  }
  
  public void destroy()
  {
    I.clear();
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 89	amux:dCH	I
    //   5: invokevirtual 495	amux:ak	(I)Ljava/util/List;
    //   8: astore_1
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_1
    //   12: ifnull +35 -> 47
    //   15: aload_1
    //   16: invokeinterface 186 1 0
    //   21: ifle +26 -> 47
    //   24: aload_0
    //   25: getfield 68	amux:Gg	Ljava/util/List;
    //   28: invokeinterface 496 1 0
    //   33: aload_0
    //   34: getfield 68	amux:Gg	Ljava/util/List;
    //   37: aload_1
    //   38: invokeinterface 182 2 0
    //   43: pop
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: getfield 68	amux:Gg	Ljava/util/List;
    //   51: invokeinterface 496 1 0
    //   56: goto -12 -> 44
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	amux
    //   8	30	1	localList	List
    //   59	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	44	59	finally
    //   44	46	59	finally
    //   47	56	59	finally
    //   60	62	59	finally
  }
  
  public void pause() {}
  
  public void resume() {}
  
  class a
  {
    boolean value;
    
    public a(boolean paramBoolean)
    {
      this.value = paramBoolean;
    }
    
    public boolean getValue()
    {
      try
      {
        boolean bool = this.value;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void setValue(boolean paramBoolean)
    {
      try
      {
        this.value = paramBoolean;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
  
  class b
  {
    List<ampt> Gi;
    String keyword;
    
    public b(List<ampt> paramList)
    {
      this.keyword = paramList;
      Object localObject;
      this.Gi = localObject;
    }
  }
  
  public static class c
  {
    long akd;
    String cck;
    int dDH;
    long initTime;
    int type;
    
    public c(int paramInt, String paramString)
    {
      this.type = paramInt;
      this.cck = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amux
 * JD-Core Version:    0.7.0.1
 */