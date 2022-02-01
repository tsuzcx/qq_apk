import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class amoi
  extends ampt
{
  private List<String> FU;
  private List<String> FV;
  private CharSequence ai;
  private long ajT;
  private long ajU = amjz.ajy;
  private boolean cDD;
  boolean cDE = false;
  private Set<DiscussionMemberInfo> cS;
  private DiscussionInfo d;
  private CharSequence description;
  private acff j;
  private String keyword;
  private String myUin;
  private List<DiscussionMemberInfo> qA;
  
  public amoi(QQAppInterface paramQQAppInterface, int paramInt1, DiscussionInfo paramDiscussionInfo, List<DiscussionMemberInfo> paramList, int paramInt2)
  {
    super(paramQQAppInterface, paramInt1, paramInt2);
    this.d = paramDiscussionInfo;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.qA = ((List)localObject);
    this.j = ((acff)paramQQAppInterface.getManager(51));
    if (!paramDiscussionInfo.hasRenamed()) {}
    for (boolean bool = true;; bool = false)
    {
      this.cDD = bool;
      this.myUin = paramQQAppInterface.getCurrentAccountUin();
      return;
    }
  }
  
  private long a(acxw paramacxw, String paramString1, long paramLong, String paramString2)
  {
    switch (SearchConfigManager.sReduceDiscussionWeight)
    {
    default: 
      return amxk.a(paramString2, paramString1, paramLong);
    case 0: 
      return amxk.a(paramString2, paramString1, paramLong);
    }
    if (paramacxw.kG(this.d.uin)) {
      return amxk.a(paramString2, paramString1, paramLong, true, false, false);
    }
    return amxk.a(paramString2, paramString1, paramLong);
  }
  
  static boolean a(int paramInt, List<List<amoi.a>> paramList, long[] paramArrayOfLong, Map<DiscussionMemberInfo, Long> paramMap1, int[] paramArrayOfInt, Map<DiscussionMemberInfo, Integer> paramMap, boolean[] paramArrayOfBoolean, Set<DiscussionMemberInfo> paramSet, Map<DiscussionMemberInfo, Long> paramMap2)
  {
    paramArrayOfBoolean[paramInt] = true;
    int i = 0;
    if (i < ((List)paramList.get(paramInt)).size())
    {
      DiscussionMemberInfo localDiscussionMemberInfo = ((amoi.a)((List)paramList.get(paramInt)).get(i)).a;
      if (paramSet.contains(localDiscussionMemberInfo)) {}
      for (;;)
      {
        i += 1;
        break;
        long l = paramArrayOfLong[paramInt] + ((Long)paramMap1.get(localDiscussionMemberInfo)).longValue() - ((amoi.a)((List)paramList.get(paramInt)).get(i)).ajV;
        if (l == 0L)
        {
          paramSet.add(localDiscussionMemberInfo);
          int k = ((Integer)paramMap.get(localDiscussionMemberInfo)).intValue();
          if ((k == -1) || (a(k, paramList, paramArrayOfLong, paramMap1, paramArrayOfInt, paramMap, paramArrayOfBoolean, paramSet, paramMap2)))
          {
            paramMap.put(localDiscussionMemberInfo, Integer.valueOf(paramInt));
            paramArrayOfInt[paramInt] = i;
            return true;
          }
        }
        else if (l < ((Long)paramMap2.get(localDiscussionMemberInfo)).longValue())
        {
          paramMap2.put(localDiscussionMemberInfo, Long.valueOf(l));
        }
      }
    }
    return false;
  }
  
  private Object[] a(DiscussionMemberInfo paramDiscussionMemberInfo, String paramString)
  {
    acxw localacxw = this.app.a().a();
    long l2 = -9223372036854775808L;
    long l1 = a(localacxw, paramDiscussionMemberInfo.inteRemark, amjz.aiX, paramString);
    String str;
    if (l1 > -9223372036854775808L)
    {
      str = paramDiscussionMemberInfo.inteRemark;
      l2 = l1;
    }
    for (;;)
    {
      long l3 = a(localacxw, paramDiscussionMemberInfo.memberName, amjz.aiY, paramString);
      l1 = l2;
      if (l3 > l2)
      {
        str = paramDiscussionMemberInfo.memberName;
        l1 = l3;
      }
      Friends localFriends = this.j.b(paramDiscussionMemberInfo.memberUin);
      paramDiscussionMemberInfo = str;
      l3 = l1;
      if (localFriends != null)
      {
        paramDiscussionMemberInfo = str;
        l3 = l1;
        if (localFriends.isFriend())
        {
          l3 = a(localacxw, localFriends.remark, amjz.aiW, paramString);
          paramDiscussionMemberInfo = str;
          l2 = l1;
          if (l3 > l1)
          {
            paramDiscussionMemberInfo = localFriends.remark;
            l2 = l3;
          }
          l1 = a(localacxw, localFriends.name, amjz.aiY, paramString);
          l3 = l2;
          if (l1 > l2)
          {
            paramDiscussionMemberInfo = localFriends.name;
            l3 = l1;
          }
        }
      }
      return new Object[] { Long.valueOf(l3), paramDiscussionMemberInfo };
      str = null;
    }
  }
  
  private long av(String paramString)
  {
    paramString = paramString.split("\\s+");
    if ((paramString != null) && (paramString.length >= 2))
    {
      ArrayList localArrayList1 = new ArrayList();
      int i = 0;
      while (i < paramString.length)
      {
        this.FV.add(paramString[i]);
        ArrayList localArrayList2 = new ArrayList();
        localArrayList1.add(localArrayList2);
        int k = 0;
        if (k < this.qA.size())
        {
          if (((DiscussionMemberInfo)this.qA.get(k)).memberUin.equals(this.myUin)) {}
          for (;;)
          {
            k += 1;
            break;
            Object[] arrayOfObject = a((DiscussionMemberInfo)this.qA.get(k), paramString[i]);
            long l = ((Long)arrayOfObject[0]).longValue();
            if (l != -9223372036854775808L)
            {
              amoi.a locala = new amoi.a();
              locala.ajV = l;
              locala.name = ((String)arrayOfObject[1]);
              locala.a = ((DiscussionMemberInfo)this.qA.get(k));
              localArrayList2.add(locala);
            }
          }
        }
        if (localArrayList2.isEmpty()) {
          return -9223372036854775808L;
        }
        i += 1;
      }
      return f(localArrayList1);
    }
    return -9223372036854775808L;
  }
  
  private void dOp()
  {
    int i = 0;
    int i1 = 0;
    if ((amxk.lo(this.fromType)) || (this.fromType == 5))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if (this.qA != null)
      {
        localSpannableStringBuilder.append("包含: ");
        int k = this.FU.size() - 1;
        i = 0;
        if (k >= 0)
        {
          m = 1;
          label68:
          if (i >= 10) {
            break label159;
          }
        }
        label159:
        for (int n = 1;; n = 0)
        {
          if ((n & m) == 0) {
            break label165;
          }
          localSpannableStringBuilder.append(amxk.a((String)this.FU.get(k), (String)this.FV.get(k), 6));
          i += 1;
          if (i < this.qA.size()) {
            localSpannableStringBuilder.append("、");
          }
          k -= 1;
          break;
          m = 0;
          break label68;
        }
        label165:
        int m = 0;
        k = i;
        i = m;
        if (i < this.qA.size())
        {
          m = 1;
          label186:
          if (k >= 10) {
            break label310;
          }
          n = 1;
          label195:
          if ((n & m) == 0) {
            break label326;
          }
          localObject = (DiscussionMemberInfo)this.qA.get(i);
          m = k;
          if (!this.cS.contains(localObject)) {
            if (((DiscussionMemberInfo)localObject).inteRemark == null) {
              break label316;
            }
          }
        }
        label310:
        label316:
        for (localObject = ((DiscussionMemberInfo)localObject).inteRemark;; localObject = ((DiscussionMemberInfo)localObject).memberName)
        {
          m = k;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            k += 1;
            localSpannableStringBuilder.append((CharSequence)localObject);
            m = k;
            if (k < this.qA.size())
            {
              localSpannableStringBuilder.append("、");
              m = k;
            }
          }
          i += 1;
          k = m;
          break;
          m = 0;
          break label186;
          n = 0;
          break label195;
        }
      }
      label326:
      this.description = localSpannableStringBuilder;
      localObject = new StringBuilder().append("(");
      i = i1;
      if (this.qA != null) {
        i = this.qA.size();
      }
      this.ai = (i + acfp.m(2131704426));
      return;
    }
    this.description = acfp.m(2131704483);
    Object localObject = new SpannableStringBuilder();
    if (!this.d.hasRenamed())
    {
      ((SpannableStringBuilder)localObject).append("(");
      if (this.qA != null) {
        i = this.qA.size();
      }
      ((SpannableStringBuilder)localObject).append(String.valueOf(i));
      ((SpannableStringBuilder)localObject).append(")");
    }
    for (;;)
    {
      this.ai = ((CharSequence)localObject);
      return;
      if (!this.FU.isEmpty())
      {
        ((SpannableStringBuilder)localObject).append("(");
        i = this.FU.size() - 1;
        while (i >= 0)
        {
          ((SpannableStringBuilder)localObject).append(amxk.a((String)this.FU.get(i), (String)this.FV.get(i), 6));
          if (i > 0) {
            ((SpannableStringBuilder)localObject).append("、");
          }
          i -= 1;
        }
        ((SpannableStringBuilder)localObject).append(")");
      }
    }
  }
  
  private long f(List<List<amoi.a>> paramList)
  {
    long[] arrayOfLong = new long[paramList.size()];
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    int[] arrayOfInt = new int[paramList.size()];
    HashMap localHashMap3 = new HashMap();
    int i = 0;
    int k;
    Object localObject;
    long l2;
    while (i < paramList.size())
    {
      l1 = -9223372036854775808L;
      k = 0;
      while (k < ((List)paramList.get(i)).size())
      {
        localObject = ((amoi.a)((List)paramList.get(i)).get(k)).a;
        if (!localHashMap3.containsKey(localObject))
        {
          localHashMap3.put(localObject, Integer.valueOf(-1));
          localHashMap1.put(localObject, Long.valueOf(0L));
        }
        l2 = l1;
        if (((amoi.a)((List)paramList.get(i)).get(k)).ajV > l1) {
          l2 = ((amoi.a)((List)paramList.get(i)).get(k)).ajV;
        }
        k += 1;
        l1 = l2;
      }
      arrayOfLong[i] = l1;
      i += 1;
    }
    i = 0;
    while (i < paramList.size())
    {
      localObject = new boolean[paramList.size()];
      Arrays.fill((boolean[])localObject, false);
      HashSet localHashSet = new HashSet();
      Iterator localIterator = localHashMap1.keySet().iterator();
      while (localIterator.hasNext()) {
        localHashMap2.put((DiscussionMemberInfo)localIterator.next(), Long.valueOf(9223372036854775807L));
      }
      for (;;)
      {
        localHashSet.clear();
        Arrays.fill((boolean[])localObject, false);
        if (a(i, paramList, arrayOfLong, localHashMap1, arrayOfInt, localHashMap3, (boolean[])localObject, localHashSet, localHashMap2)) {
          break;
        }
        l1 = 9223372036854775807L;
        localIterator = localHashMap2.keySet().iterator();
        DiscussionMemberInfo localDiscussionMemberInfo;
        while (localIterator.hasNext())
        {
          localDiscussionMemberInfo = (DiscussionMemberInfo)localIterator.next();
          if (!localHashSet.contains(localDiscussionMemberInfo))
          {
            l2 = ((Long)localHashMap2.get(localDiscussionMemberInfo)).longValue();
            if (l2 < l1) {
              l1 = l2;
            }
          }
        }
        if ((l1 == 9223372036854775807L) || (l1 == 0L))
        {
          l2 = -9223372036854775808L;
          return l2;
        }
        k = 0;
        if (k <= i)
        {
          if (localObject[k] == 0) {}
          for (;;)
          {
            k += 1;
            break;
            arrayOfLong[k] -= l1;
          }
        }
        localIterator = localHashMap1.keySet().iterator();
        while (localIterator.hasNext())
        {
          localDiscussionMemberInfo = (DiscussionMemberInfo)localIterator.next();
          if (!localHashSet.contains(localDiscussionMemberInfo)) {
            localHashMap2.put(localDiscussionMemberInfo, Long.valueOf(((Long)localHashMap2.get(localDiscussionMemberInfo)).longValue() - l1));
          } else {
            localHashMap1.put(localDiscussionMemberInfo, Long.valueOf(((Long)localHashMap1.get(localDiscussionMemberInfo)).longValue() + l1));
          }
        }
      }
      i += 1;
    }
    i = 0;
    for (long l1 = -9223372036854775808L;; l1 = l2)
    {
      l2 = l1;
      if (i >= paramList.size()) {
        break;
      }
      long l3 = ((amoi.a)((List)paramList.get(i)).get(arrayOfInt[i])).ajV;
      l2 = l1;
      if (l3 > l1) {
        l2 = l3;
      }
      this.cS.add(((amoi.a)((List)paramList.get(i)).get(arrayOfInt[i])).a);
      this.FU.add(((amoi.a)((List)paramList.get(i)).get(arrayOfInt[i])).name);
      i += 1;
    }
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public int IU()
  {
    return 3;
  }
  
  public Object S()
  {
    return this.d.uin;
  }
  
  protected long au(String paramString)
  {
    this.cDE = false;
    this.FU = new ArrayList();
    this.FV = new ArrayList();
    this.cS = new HashSet();
    this.keyword = paramString;
    this.ajT = -9223372036854775808L;
    if (!this.cDD)
    {
      l1 = amxk.b(paramString, this.d.discussionName, amjz.aiR);
      if (l1 > this.ajT)
      {
        this.ajT = l1;
        this.cDE = true;
      }
    }
    Object localObject1 = null;
    Object localObject2 = null;
    long l1 = -9223372036854775808L;
    int i = 0;
    Object localObject3;
    if (i < this.qA.size()) {
      if (((DiscussionMemberInfo)this.qA.get(i)).memberUin.equals(this.myUin))
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
    for (;;)
    {
      i += 1;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      localObject3 = a((DiscussionMemberInfo)this.qA.get(i), paramString);
      long l2 = ((Long)localObject3[0]).longValue();
      if (l2 > l1)
      {
        localObject2 = (DiscussionMemberInfo)this.qA.get(i);
        localObject1 = (String)localObject3[1];
        l1 = l2;
        continue;
        if (localObject1 != null)
        {
          this.cS.add(localObject1);
          this.FU.add(localObject2);
          this.FV.add(paramString);
        }
        if (l1 > this.ajT)
        {
          this.ajT = l1;
          this.cDE = false;
        }
        if (this.ajT == -9223372036854775808L)
        {
          l1 = av(paramString);
          if (l1 > this.ajT)
          {
            this.ajT = l1;
            this.cDE = false;
          }
        }
        if (this.cS.size() == this.qA.size())
        {
          i = 1;
          this.ajU = amjz.ajn;
          paramString = this.app.a().a();
          if (i != 0)
          {
            this.ajU = amjz.ajl;
            label389:
            if (this.ajT != -9223372036854775808L)
            {
              this.ajT += this.ajU;
              dOp();
            }
            return this.ajT;
          }
        }
        else
        {
          if (this.cS.size() != this.qA.size() - 1) {
            break label564;
          }
          paramString = this.app.getCurrentAccountUin();
          localObject1 = this.cS.iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (DiscussionMemberInfo)((Iterator)localObject1).next();
          } while ((paramString == null) || (!paramString.equals(((DiscussionMemberInfo)localObject2).memberUin)));
        }
        for (i = 1;; i = 0)
        {
          if (i == 0)
          {
            i = 1;
            break;
            if (paramString.kG(this.d.uin))
            {
              if (this.cDE)
              {
                this.ajU = amjz.ajn;
                break label389;
              }
              this.ajU = amjz.ajw;
              break label389;
            }
            this.ajU = amjz.ajy;
            break label389;
          }
          label564:
          i = 0;
          break;
        }
      }
      else
      {
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
  }
  
  protected boolean awc()
  {
    return this.cDE;
  }
  
  public void cR(View paramView)
  {
    super.cR(paramView);
    if (amxk.lo(this.fromType))
    {
      aalb.bwg = true;
      aalb.a(paramView.getContext(), this.app, this.d.uin, 3000, this.d.discussionName, false);
      aclj.Q(this.app, this.keyword);
      amxk.d(this.app, getTitle().toString(), this.d.uin, "", 3000);
      amxk.a(this.keyword, 20, 3, paramView);
      amxk.a(this.keyword, 30, paramView, false);
      amxk.PY(this.keyword);
      amxk.a(this, paramView);
      if (SearchConfigManager.needSeparate) {
        amxk.d("search", "group", "groups", 0, 0, new String[] { amxk.fc(this.fromType) });
      }
      if (((S() instanceof String)) && (!this.cDS)) {
        amxk.e(this.app, this.keyword, this.cbp, (String)S(), IU());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.cbp == null) || (TextUtils.isEmpty(this.cbp))) {
          break label299;
        }
        amub.a(null, 0, this.fromType, "0X8009D31", 2, 0, null, null);
      }
    }
    for (;;)
    {
      new anov(this.app).a("dc00899").b("Grp_listNew").c("search_result").d("clk_grp").a(new String[] { this.d.uin }).report();
      return;
      label299:
      amub.a(null, 0, this.fromType, "0X8009D3B", 0, 0, null, null);
      continue;
      amxk.a(paramView, this);
    }
  }
  
  public CharSequence f()
  {
    return this.ai;
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    return this.description;
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public CharSequence getTitle()
  {
    if (this.cDD) {
      return za();
    }
    return super.getTitle();
  }
  
  public String getUin()
  {
    return this.d.uin;
  }
  
  public int lk()
  {
    return 3000;
  }
  
  public int pG()
  {
    return 101;
  }
  
  public String za()
  {
    return aqgv.a(BaseApplicationImpl.sApplication, this.d);
  }
  
  public String zb()
  {
    return this.ai.toString();
  }
  
  static class a
  {
    DiscussionMemberInfo a;
    long ajV;
    String name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amoi
 * JD-Core Version:    0.7.0.1
 */