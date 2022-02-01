import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.TroopInfo;
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

public class amol
  extends ampt
{
  protected List<amol.b> FW;
  protected List<String> FX;
  protected List<String> FY;
  private long ajL;
  private long ajW = amjz.ajG;
  protected Set<amol.b> cT;
  protected CharSequence mDescription;
  public String mTroopUin;
  protected TroopInfo troopInfo;
  protected String wB;
  
  public amol(QQAppInterface paramQQAppInterface, int paramInt, String paramString, List<amol.b> paramList)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.mTroopUin = paramString;
    this.FW = paramList;
    this.troopInfo = ((TroopManager)paramQQAppInterface.getManager(52)).c(this.mTroopUin);
    if (paramQQAppInterface.a().a().kG(paramString))
    {
      if (this.troopInfo.isNewTroop()) {
        this.ajW = amjz.ajx;
      }
    }
    else {
      return;
    }
    this.ajW = amjz.ajH;
  }
  
  private long a(acxw paramacxw, String paramString1, long paramLong, String paramString2)
  {
    boolean bool = true;
    switch (SearchConfigManager.sReduceDiscussionWeight)
    {
    default: 
      return amxk.a(paramString2, paramString1, paramLong, false, false, true);
    case 0: 
    case 1: 
      if (this.troopInfo.isNewTroop()) {
        bool = false;
      }
      return amxk.a(paramString2, paramString1, paramLong, false, false, bool);
    }
    if (paramacxw.kG(this.mTroopUin)) {
      return amxk.a(paramString2, paramString1, paramLong, false, false, false);
    }
    return amxk.a(paramString2, paramString1, paramLong, false, false, true);
  }
  
  static boolean a(int paramInt, List<List<amol.a>> paramList, long[] paramArrayOfLong, Map<amol.b, Long> paramMap1, int[] paramArrayOfInt, Map<amol.b, Integer> paramMap, boolean[] paramArrayOfBoolean, Set<amol.b> paramSet, Map<amol.b, Long> paramMap2)
  {
    paramArrayOfBoolean[paramInt] = true;
    int i = 0;
    if (i < ((List)paramList.get(paramInt)).size())
    {
      amol.b localb = ((amol.a)((List)paramList.get(paramInt)).get(i)).a;
      if (paramSet.contains(localb)) {}
      for (;;)
      {
        i += 1;
        break;
        long l = paramArrayOfLong[paramInt] + ((Long)paramMap1.get(localb)).longValue() - ((amol.a)((List)paramList.get(paramInt)).get(i)).ajX;
        if (l == 0L)
        {
          paramSet.add(localb);
          int j = ((Integer)paramMap.get(localb)).intValue();
          if ((j == -1) || (a(j, paramList, paramArrayOfLong, paramMap1, paramArrayOfInt, paramMap, paramArrayOfBoolean, paramSet, paramMap2)))
          {
            paramMap.put(localb, Integer.valueOf(paramInt));
            paramArrayOfInt[paramInt] = i;
            return true;
          }
        }
        else if (l < ((Long)paramMap2.get(localb)).longValue())
        {
          paramMap2.put(localb, Long.valueOf(l));
        }
      }
    }
    return false;
  }
  
  private Object[] a(amol.b paramb, String paramString)
  {
    acxw localacxw = this.app.a().a();
    long l2 = -9223372036854775808L;
    long l1;
    String str;
    if (this.troopInfo.isNewTroop())
    {
      l1 = amjz.aiV;
      l1 = a(localacxw, paramb.mMemberCard, l1, paramString);
      if (l1 <= -9223372036854775808L) {
        break label193;
      }
      str = paramb.mMemberCard;
      paramb.dDf = 66;
    }
    for (;;)
    {
      if (this.troopInfo.isNewTroop()) {}
      for (long l3 = amjz.aiU;; l3 = amjz.aiY)
      {
        long l4 = a(localacxw, paramb.mMemberName, l3, paramString);
        l2 = l1;
        if (l4 > l1)
        {
          str = paramb.mMemberName;
          paramb.dDf = 88;
          l2 = l4;
        }
        l3 = a(localacxw, paramb.mMemberNick, l3, paramString);
        l1 = l2;
        if (l3 > l2)
        {
          str = paramb.mMemberNick;
          paramb.dDf = 99;
          l1 = l3;
        }
        return new Object[] { Long.valueOf(l1), str };
        l1 = amjz.ajd;
        break;
      }
      label193:
      str = null;
      l1 = l2;
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
        this.FY.add(paramString[i]);
        ArrayList localArrayList2 = new ArrayList();
        localArrayList1.add(localArrayList2);
        int j = 0;
        while (j < this.FW.size())
        {
          Object localObject = (amol.b)this.FW.get(j);
          Object[] arrayOfObject = a((amol.b)localObject, paramString[i]);
          long l = ((Long)arrayOfObject[0]).longValue();
          if ((((amol.b)localObject).ajY == -9223372036854775808L) || (l > ((amol.b)localObject).ajY))
          {
            ((amol.b)localObject).ajY = l;
            ((amol.b)localObject).dDg = ((amol.b)localObject).dDf;
          }
          if (l != -9223372036854775808L)
          {
            localObject = new amol.a();
            ((amol.a)localObject).ajX = l;
            ((amol.a)localObject).mName = ((String)arrayOfObject[1]);
            ((amol.a)localObject).a = ((amol.b)this.FW.get(j));
            localArrayList2.add(localObject);
          }
          j += 1;
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
  
  private long f(List<List<amol.a>> paramList)
  {
    long[] arrayOfLong = new long[paramList.size()];
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    int[] arrayOfInt = new int[paramList.size()];
    HashMap localHashMap3 = new HashMap();
    int i = 0;
    int j;
    Object localObject;
    long l2;
    while (i < paramList.size())
    {
      l1 = -9223372036854775808L;
      j = 0;
      while (j < ((List)paramList.get(i)).size())
      {
        localObject = ((amol.a)((List)paramList.get(i)).get(j)).a;
        if (!localHashMap3.containsKey(localObject))
        {
          localHashMap3.put(localObject, Integer.valueOf(-1));
          localHashMap1.put(localObject, Long.valueOf(0L));
        }
        l2 = l1;
        if (((amol.a)((List)paramList.get(i)).get(j)).ajX > l1) {
          l2 = ((amol.a)((List)paramList.get(i)).get(j)).ajX;
        }
        j += 1;
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
        localHashMap2.put((amol.b)localIterator.next(), Long.valueOf(9223372036854775807L));
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
        amol.b localb;
        while (localIterator.hasNext())
        {
          localb = (amol.b)localIterator.next();
          if (!localHashSet.contains(localb))
          {
            l2 = ((Long)localHashMap2.get(localb)).longValue();
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
        j = 0;
        if (j <= i)
        {
          if (localObject[j] == 0) {}
          for (;;)
          {
            j += 1;
            break;
            arrayOfLong[j] -= l1;
          }
        }
        localIterator = localHashMap1.keySet().iterator();
        while (localIterator.hasNext())
        {
          localb = (amol.b)localIterator.next();
          if (!localHashSet.contains(localb)) {
            localHashMap2.put(localb, Long.valueOf(((Long)localHashMap2.get(localb)).longValue() - l1));
          } else {
            localHashMap1.put(localb, Long.valueOf(((Long)localHashMap1.get(localb)).longValue() + l1));
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
      long l3 = ((amol.a)((List)paramList.get(i)).get(arrayOfInt[i])).ajX;
      l2 = l1;
      if (l3 > l1) {
        l2 = l3;
      }
      this.cT.add(((amol.a)((List)paramList.get(i)).get(arrayOfInt[i])).a);
      this.FX.add(((amol.a)((List)paramList.get(i)).get(arrayOfInt[i])).mName);
      i += 1;
    }
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public int IU()
  {
    return 2;
  }
  
  public Object S()
  {
    return this.mTroopUin;
  }
  
  protected long au(String paramString)
  {
    Object localObject2 = null;
    this.FX = new ArrayList();
    this.FY = new ArrayList();
    this.cT = new HashSet();
    this.wB = paramString;
    this.ajL = -9223372036854775808L;
    int i = 0;
    long l1 = -9223372036854775808L;
    Object localObject1 = null;
    Object localObject3;
    if (i < this.FW.size())
    {
      localObject3 = a((amol.b)this.FW.get(i), paramString);
      long l2 = ((Long)localObject3[0]).longValue();
      if (l2 <= l1) {
        break label273;
      }
      localObject1 = (amol.b)this.FW.get(i);
      localObject2 = (String)localObject3[1];
      l1 = l2;
    }
    for (;;)
    {
      i += 1;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      if (localObject2 != null)
      {
        this.cT.add(localObject2);
        this.FX.add(localObject1);
        this.FY.add(paramString);
      }
      if (l1 > this.ajL) {
        this.ajL = l1;
      }
      if (this.ajL == -9223372036854775808L)
      {
        l1 = av(paramString);
        if (l1 > this.ajL) {
          this.ajL = l1;
        }
      }
      if (this.ajL != -9223372036854775808L)
      {
        this.ajL += this.ajW;
        dOp();
      }
      return this.ajL;
      label273:
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  public void cR(View paramView)
  {
    super.cR(paramView);
    if (amxk.lo(this.fromType))
    {
      String str = aqgv.a(this.app, this.mTroopUin, true);
      aalb.bwg = true;
      aalb.a(paramView.getContext(), this.app, this.mTroopUin, 1, str, false);
      aclj.Q(this.app, this.wB);
      amxk.d(this.app, getTitle().toString(), this.mTroopUin, "", 1);
      amxk.a(this.wB, 20, 2, paramView);
      amxk.a(this.wB, 20, paramView, false);
      amxk.a(this, paramView);
      if (((S() instanceof String)) && (!this.cDS)) {
        amxk.e(this.app, this.wB, this.cbp, (String)S(), IU());
      }
      if ((paramView.getContext() instanceof UniteSearchActivity))
      {
        if ((this.cbp == null) || (TextUtils.isEmpty(this.cbp))) {
          break label234;
        }
        amub.a(null, 0, this.fromType, "0X8009D31", 2, 0, null, null);
      }
    }
    for (;;)
    {
      if (SearchConfigManager.needSeparate) {
        amxk.d("search", "group", "groups", 0, 0, new String[] { amxk.fc(this.fromType) });
      }
      return;
      label234:
      amub.a(null, 0, this.fromType, "0X8009D3B", 0, 0, null, null);
    }
  }
  
  protected void dOp()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (this.FW != null)
    {
      localSpannableStringBuilder.append("包含: ");
      int j = this.FX.size() - 1;
      int i = 0;
      if (j >= 0)
      {
        k = 1;
        label45:
        if (i >= 10) {
          break label124;
        }
      }
      label124:
      for (int m = 1;; m = 0)
      {
        if ((m & k) == 0) {
          break label130;
        }
        localSpannableStringBuilder.append(amxk.a((String)this.FX.get(j), (String)this.FY.get(j), 6, false));
        i += 1;
        localSpannableStringBuilder.append("、");
        j -= 1;
        break;
        k = 0;
        break label45;
      }
      label130:
      int k = 0;
      j = i;
      i = k;
      label151:
      label160:
      Object localObject;
      if (i < this.FW.size())
      {
        k = 1;
        if (j >= 10) {
          break label277;
        }
        m = 1;
        if ((m & k) == 0) {
          break label329;
        }
        localObject = (amol.b)this.FW.get(i);
        k = j;
        if (!this.cT.contains(localObject))
        {
          if (this.FY.size() != 1) {
            break label283;
          }
          m = ((amol.b)localObject).dDf;
          label218:
          if (m != 66) {
            break label293;
          }
          localObject = ((amol.b)localObject).mMemberCard;
        }
      }
      for (;;)
      {
        label232:
        k = j;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          k = j + 1;
          localSpannableStringBuilder.append((CharSequence)localObject);
          localSpannableStringBuilder.append("、");
        }
        label277:
        label283:
        label293:
        do
        {
          i += 1;
          j = k;
          break;
          k = 0;
          break label151;
          m = 0;
          break label160;
          m = ((amol.b)localObject).dDg;
          break label218;
          if (m == 88)
          {
            localObject = ((amol.b)localObject).mMemberName;
            break label232;
          }
          k = j;
        } while (m != 99);
        localObject = ((amol.b)localObject).mMemberNick;
      }
    }
    label329:
    if ((localSpannableStringBuilder.length() > 0) && (localSpannableStringBuilder.charAt(localSpannableStringBuilder.length() - 1) == '、'))
    {
      this.mDescription = localSpannableStringBuilder.subSequence(0, localSpannableStringBuilder.length() - 1);
      return;
    }
    this.mDescription = localSpannableStringBuilder;
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public long gM()
  {
    return super.gM();
  }
  
  public CharSequence getDescription()
  {
    return this.mDescription;
  }
  
  public String getKeyword()
  {
    return this.wB;
  }
  
  public CharSequence getTitle()
  {
    if ((this.troopInfo.isNewTroop()) && (!this.troopInfo.hasSetTroopName())) {
      return za();
    }
    return super.getTitle();
  }
  
  public String getUin()
  {
    return this.mTroopUin;
  }
  
  public int lk()
  {
    return 1;
  }
  
  public int pG()
  {
    return 4;
  }
  
  public String za()
  {
    return aqgv.a(this.app, this.mTroopUin, true);
  }
  
  public String zb()
  {
    return this.mTroopUin;
  }
  
  static class a
  {
    amol.b a;
    long ajX;
    String mName;
  }
  
  public static class b
  {
    public long ajY = -9223372036854775808L;
    public int dDf;
    public int dDg;
    public String mMemberCard;
    public String mMemberName;
    public String mMemberNick;
    public String mMemberUin;
    
    public b(String paramString1, String paramString2, String paramString3, String paramString4)
    {
      this.mMemberCard = paramString1;
      this.mMemberName = paramString2;
      this.mMemberUin = paramString3;
      this.mMemberNick = paramString4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amol
 * JD-Core Version:    0.7.0.1
 */