import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.Text;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.WarnMsg;

public class ajqh
  implements Manager
{
  protected ajqh.c a = new ajqh.c();
  protected QQAppInterface app;
  protected HashSet<String> bm = new HashSet();
  protected boolean cpO = true;
  protected boolean cpP = true;
  protected HashMap<Long, ajqh.a> lU = new HashMap();
  
  public ajqh(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    String str = DateFormat.format("yyyy-MM-dd", System.currentTimeMillis()).toString();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0);
    if (!localSharedPreferences.getString("over_people_limit_tip_show_date" + paramQQAppInterface.getCurrentAccountUin(), "").equals(str))
    {
      bool1 = true;
      this.cpO = bool1;
      if (localSharedPreferences.getString("over_one_limit_tip_show_date" + paramQQAppInterface.getCurrentAccountUin(), "").equals(str)) {
        break label178;
      }
    }
    label178:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.cpP = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  private SpannableString a(List<oidb_0x8e7.Text> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return null;
    }
    Object localObject1 = new StringBuilder();
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((StringBuilder)localObject1).append(((oidb_0x8e7.Text)((Iterator)localObject2).next()).bytes_context.get().toStringUtf8());
    }
    if (((StringBuilder)localObject1).length() == 0) {
      return null;
    }
    localObject1 = new SpannableString(((StringBuilder)localObject1).toString());
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      localObject2 = (oidb_0x8e7.Text)paramList.next();
      int j = ((oidb_0x8e7.Text)localObject2).bytes_context.get().toStringUtf8().length();
      if (((oidb_0x8e7.Text)localObject2).uint32_color.has()) {
        ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(Color.parseColor(String.format("#%x", new Object[] { Integer.valueOf(((oidb_0x8e7.Text)localObject2).uint32_color.get()) }))), i, i + j, 33);
      }
      i += j;
    }
    return localObject1;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    anot.a(paramQQAppInterface, "dc00899", "grp_lbs", paramString2, "pay_like", paramString1, 0, 0, paramString3, paramString4, paramString5, paramString6);
    if (QLog.isColorLevel()) {
      QLog.d("nearbyLike.report", 2, "report, opName=" + paramString1 + ", toUin=" + paramString2 + ", extra1=" + paramString3 + ", extra2=" + paramString4 + ", extra3=" + paramString5 + ", extra4=" + paramString6);
    }
  }
  
  public static boolean cu(long paramLong)
  {
    if ((paramLong == 6L) || (paramLong == 8L) || (paramLong == 37L) || (paramLong == 41L) || (paramLong == 42L) || (paramLong == 43L) || (paramLong == 45L) || (paramLong == 46L) || (paramLong == 47L) || (paramLong == 51L) || (paramLong == 10002L)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyLikeLimitManager", 2, "isNeedNewLimitCheck, source=" + paramLong + ", ret=" + bool);
      }
      return bool;
    }
  }
  
  public static void j(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    b(paramQQAppInterface, paramString1, "", paramString2, "", "", "");
  }
  
  protected void G(Activity paramActivity, String paramString)
  {
    aqha.a(paramActivity, 230).setTitle(acfp.m(2131708756)).setMessage(acfp.m(2131708752)).setNegativeButton(acfp.m(2131708754), new ajql(this)).setPositiveButton(acfp.m(2131708753), new ajqk(this, paramActivity)).show();
  }
  
  public void K(long paramLong, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        if (this.a == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "updateItem, mLimitInfo == null, return");
          }
          return;
        }
        ajqh.a locala = (ajqh.a)this.lU.get(Long.valueOf(paramLong));
        if (locala == null)
        {
          if ((paramInt1 > 0) || (paramInt2 > 0))
          {
            locala = new ajqh.a();
            locala.uin = paramLong;
            locala.dkt += paramInt1;
            locala.dku += paramInt2;
            locala.dkv += this.a.dkA * paramInt2;
            this.lU.put(Long.valueOf(paramLong), locala);
            localObject2 = this.a;
            ((ajqh.c)localObject2).dkE += 1;
            localObject2 = this.a;
            ((ajqh.c)localObject2).dkD -= this.a.dkA * paramInt2;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("updateItem, key=").append(paramLong).append(", freeLikeCount=").append(paramInt1).append(", payLikeCount=").append(paramInt2).append(", hasLikeBefore=");
            if (locala == null) {
              break label379;
            }
            bool = true;
            QLog.d("NearbyLikeLimitManager", 2, bool);
          }
          cz(paramLong + "", true);
          continue;
        }
        localObject1.dkt += paramInt1;
      }
      finally {}
      localObject1.dku += paramInt2;
      localObject1.dkv += this.a.dkA * paramInt2;
      this.lU.put(Long.valueOf(paramLong), localObject1);
      Object localObject2 = this.a;
      ((ajqh.c)localObject2).dkD -= this.a.dkA * paramInt2;
      continue;
      label379:
      boolean bool = false;
    }
  }
  
  public void a(ajqh.c paramc, List<ajqh.a> paramList, int paramInt)
  {
    try
    {
      this.a = paramc;
      if (paramInt == 511) {
        this.lU.clear();
      }
      paramc = new StringBuilder();
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          ajqh.a locala = (ajqh.a)paramList.next();
          this.lU.put(Long.valueOf(locala.uin), locala);
          if (QLog.isColorLevel()) {
            paramc.append(locala).append(" | ");
          }
        }
      }
      if (!QLog.isColorLevel()) {
        break label166;
      }
    }
    finally {}
    QLog.d("NearbyLikeLimitManager", 2, "updateFromServer, mLimitInfo=" + this.a + ", mLikeItemMap=[" + paramc + "]");
    label166:
  }
  
  public void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString1, ajqh.d paramd, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyLikeLimitManager", 2, "checkCanDoVote, uin=" + paramString1 + ", from=" + paramString2 + ", mLimitInfo=" + this.a);
        }
        boolean bool1 = cr(Long.valueOf(paramString1).longValue());
        boolean bool2 = cs(Long.valueOf(paramString1).longValue());
        if ((!bool1) && (!bool2)) {
          break label307;
        }
        if ((bool1) && (aru()))
        {
          localSpannableString = i();
          j(paramQQAppInterface, "exp_uv_limit", paramString2);
          i = 1;
          if (i != 0)
          {
            paramActivity = aqha.a(paramActivity, 0, null, localSpannableString, acfp.m(2131708755), acfp.m(2131708751), acfp.m(2131708750), new ajqi(this, bool1, paramString1, paramd, paramQQAppInterface, paramString2, paramActivity), new ajqj(this, paramActivity, paramQQAppInterface, paramString2));
            paramActivity.getBtnLeft().setTextColor(-14698765);
            paramActivity.show();
          }
        }
        else
        {
          if ((!bool2) || (!arv())) {
            break label332;
          }
          localSpannableString = j();
          j(paramQQAppInterface, "exp_pv_limit", paramString2);
          i = 1;
          continue;
        }
        if (ars())
        {
          K(Long.valueOf(paramString1).longValue(), 0, 1);
          paramd.cA(paramString1, false);
          b(paramQQAppInterface, "pay_like", paramString1, paramString2, "", "", "");
          continue;
        }
        G(paramActivity, paramString2);
      }
      finally {}
      j(paramQQAppInterface, "exp_pay_like", paramString2);
      continue;
      label307:
      K(Long.valueOf(paramString1).longValue(), 1, 0);
      paramd.cA(paramString1, true);
      continue;
      label332:
      SpannableString localSpannableString = null;
      int i = 0;
    }
  }
  
  public void aS(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (this.a != null)
      {
        this.a.level = paramInt1;
        this.a.dkB = paramInt2;
        this.a.dkC = paramInt3;
        if (QLog.isColorLevel()) {
          QLog.d("NearbyLikeLimitManager", 2, "updateFromServer, level=" + paramInt1 + ", freeLikePeopleLimit=" + paramInt2 + ", freeLikeOneLimit=" + paramInt3);
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean ars()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    for (;;)
    {
      try
      {
        if (this.a == null)
        {
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("NearbyLikeLimitManager", 2, "isStockEnough, mLimitInfo == null, return true");
            bool2 = bool1;
          }
          return bool2;
        }
        if (this.a.dkD >= this.a.dkA)
        {
          bool1 = bool2;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("NearbyLikeLimitManager", 2, "isStockEnough, ret=" + bool1);
            bool2 = bool1;
          }
        }
        else
        {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  public boolean art()
  {
    boolean bool1 = true;
    try
    {
      String str = "need_show_first_tip_" + this.app.getCurrentAccountUin();
      boolean bool2 = BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0).getBoolean(str, true);
      bool1 = bool2;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyLikeLimitManager", 2, "isNeedShowFirstTip" + localException.toString());
    }
    return bool1;
    return true;
  }
  
  public boolean aru()
  {
    if ((this.cpO) && (this.a != null) && (this.a.a != null)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyLikeLimitManager", 2, "isNeedShowOverPeopleLimitTip, ret=" + bool);
      }
      return bool;
    }
  }
  
  public boolean arv()
  {
    if ((this.cpP) && (this.a != null) && (this.a.a != null)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyLikeLimitManager", 2, "isNeedShowOverOneLimitTip, ret=" + bool);
      }
      return bool;
    }
  }
  
  public boolean cr(long paramLong)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    label167:
    label173:
    label221:
    for (;;)
    {
      try
      {
        if (this.a == null)
        {
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("NearbyLikeLimitManager", 2, "isOverFreeLikePeopleLimit, mLimitInfo==null, return false, uin=" + paramLong);
            bool2 = bool1;
          }
          return bool2;
        }
        ajqh.a locala = (ajqh.a)this.lU.get(Long.valueOf(paramLong));
        if (locala != null) {
          break label173;
        }
        if (this.a.dkE < this.a.dkB) {
          break label167;
        }
        bool1 = true;
      }
      finally {}
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("NearbyLikeLimitManager", 2, "isOverFreeLikePeopleLimit, ret=" + bool1 + ", uin=" + paramLong);
        bool2 = bool1;
        continue;
        bool1 = false;
        break label221;
        if ((this.a.dkE >= this.a.dkB) && (localObject.dku > 0))
        {
          int i = localObject.dkt;
          if (i != 0) {}
        }
        for (bool1 = bool2;; bool1 = false) {
          break;
        }
      }
    }
  }
  
  public boolean cs(long paramLong)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        ajqh.a locala = (ajqh.a)this.lU.get(Long.valueOf(paramLong));
        boolean bool1;
        if ((this.a == null) || (locala == null))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("isOVerFreeLikeOneLimit, mLimitInfo isNull=");
            if (this.a == null)
            {
              bool1 = true;
              localStringBuilder = localStringBuilder.append(bool1).append(", item isNull=");
              if (locala != null) {
                continue;
              }
              bool1 = bool2;
              QLog.d("NearbyLikeLimitManager", 2, bool1 + ", uin=" + paramLong + ", return false");
            }
          }
          else
          {
            bool2 = false;
            return bool2;
          }
          bool1 = false;
          continue;
          bool1 = false;
          continue;
        }
        if (locala.dkt >= this.a.dkC)
        {
          bool1 = true;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("NearbyLikeLimitManager", 2, "isOVerFreeLikeOneLimit, uin=" + paramLong + ", ret=" + bool1);
            bool2 = bool1;
          }
        }
        else
        {
          bool1 = false;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public boolean ct(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	ajqh:lU	Ljava/util/HashMap;
    //   6: lload_1
    //   7: invokestatic 334	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokevirtual 337	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 8	ajqh$a
    //   16: astore 5
    //   18: aload_0
    //   19: getfield 38	ajqh:a	Lajqh$c;
    //   22: astore 6
    //   24: aload 6
    //   26: ifnull +8 -> 34
    //   29: aload 5
    //   31: ifnonnull +11 -> 42
    //   34: iconst_0
    //   35: istore 4
    //   37: aload_0
    //   38: monitorexit
    //   39: iload 4
    //   41: ireturn
    //   42: aload 5
    //   44: getfield 349	ajqh$a:dku	I
    //   47: istore_3
    //   48: iload_3
    //   49: ifle +9 -> 58
    //   52: iconst_1
    //   53: istore 4
    //   55: goto -18 -> 37
    //   58: iconst_0
    //   59: istore 4
    //   61: goto -24 -> 37
    //   64: astore 5
    //   66: aload_0
    //   67: monitorexit
    //   68: aload 5
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	ajqh
    //   0	71	1	paramLong	long
    //   47	2	3	i	int
    //   35	25	4	bool	boolean
    //   16	27	5	locala	ajqh.a
    //   64	5	5	localObject	Object
    //   22	3	6	localc	ajqh.c
    // Exception table:
    //   from	to	target	type
    //   2	24	64	finally
    //   42	48	64	finally
  }
  
  public void cz(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        if (!paramBoolean)
        {
          this.bm.remove(paramString);
          if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "setNeedUpdateProfileCardFlag, uin=" + paramString + ", isNeedUpdate=" + paramBoolean);
          }
        }
        else
        {
          this.bm.add(paramString);
        }
      }
      finally {}
    }
  }
  
  public void dyH()
  {
    try
    {
      String str = "need_show_first_tip_" + this.app.getCurrentAccountUin();
      BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0).edit().putBoolean(str, false).commit();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyLikeLimitManager", 2, "disableShowFirstTip" + localException.toString());
    }
  }
  
  public void dyI()
  {
    String str1 = DateFormat.format("yyyy-MM-dd", System.currentTimeMillis()).toString();
    String str2 = "over_people_limit_tip_show_date" + this.app.getCurrentAccountUin();
    BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0).edit().putString(str2, str1).commit();
    this.cpO = false;
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "disableShowOverPeopleLimitTip, key=" + str2);
    }
  }
  
  public void dyJ()
  {
    String str1 = DateFormat.format("yyyy-MM-dd", System.currentTimeMillis()).toString();
    String str2 = "over_one_limit_tip_show_date" + this.app.getCurrentAccountUin();
    BaseApplicationImpl.getApplication().getSharedPreferences("nearby_like_cfg", 0).edit().putString(str2, str1).commit();
    this.cpP = false;
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "disableShowOverOneLimitTip, key=" + str2);
    }
  }
  
  public SpannableString h()
  {
    if ((this.a == null) || (this.a.a == null)) {
      return null;
    }
    return a(this.a.a.rpt_msg_first_info.get());
  }
  
  public SpannableString i()
  {
    if ((this.a == null) || (this.a.a == null)) {
      return null;
    }
    return a(this.a.a.rpt_msg_user_num_limit_info.get());
  }
  
  public SpannableString j()
  {
    if ((this.a == null) || (this.a.a == null)) {
      return null;
    }
    return a(this.a.a.rpt_msg_zan_limit_info.get());
  }
  
  /* Error */
  public boolean nz(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 535	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +52 -> 58
    //   9: iconst_0
    //   10: istore_2
    //   11: invokestatic 221	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +40 -> 54
    //   17: ldc_w 264
    //   20: iconst_2
    //   21: new 88	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 595
    //   31: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_2
    //   35: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   38: ldc_w 520
    //   41: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aload_0
    //   55: monitorexit
    //   56: iload_2
    //   57: ireturn
    //   58: aload_0
    //   59: getfield 48	ajqh:bm	Ljava/util/HashSet;
    //   62: aload_1
    //   63: invokevirtual 598	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   66: istore_2
    //   67: goto -56 -> 11
    //   70: astore_1
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_1
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	ajqh
    //   0	75	1	paramString	String
    //   10	57	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	9	70	finally
    //   11	54	70	finally
    //   58	67	70	finally
  }
  
  public void onDestroy()
  {
    try
    {
      this.a = null;
      this.lU.clear();
      if (QLog.isColorLevel()) {
        QLog.d("NearbyLikeLimitManager", 2, "onDestroy");
      }
      return;
    }
    finally {}
  }
  
  public static class a
  {
    public int dkt;
    public int dku;
    public int dkv;
    public int source;
    public long uin;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=").append(this.uin).append(",freeLikeCount=").append(this.dkt).append(",payLikeCount=").append(this.dku).append(",totalPerCount=").append(this.dkv).append(",source=").append(this.source);
      return localStringBuilder.toString();
    }
  }
  
  public static class b
  {
    public int dkw;
    public int dkx;
    public int dky;
    public int dkz;
    public String errMsg;
    public int ret;
    public long uin;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ret=").append(this.ret).append(",uin=").append(this.uin).append(",succFreeLikeCnt=").append(this.dkw).append(",succPayLikeCnt=").append(this.dkx).append(",todayLikeCnt=").append(this.dky).append(",totalPayStockCnt=").append(this.dkz).append(",errMsg=").append(this.errMsg);
      return localStringBuilder.toString();
    }
  }
  
  public static class c
  {
    public oidb_0x8e7.WarnMsg a;
    public String bSi;
    public String bSj;
    public int dkA;
    public int dkB;
    public int dkC;
    public int dkD;
    public int dkE;
    public int level;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[level=").append(this.level).append(",stockPerLike=").append(this.dkA).append(",freeLikePeopleLimit=").append(this.dkB).append(",freeLikeOneLimit=").append(this.dkC).append(",stockCount=").append(this.dkD).append(",freeLikePeopleCount=").append(this.dkE).append(",buyStockUrl=").append(this.bSi).append(",updateLevelUrl=").append(this.bSj).append("]");
      return localStringBuilder.toString();
    }
  }
  
  public static abstract interface d
  {
    public abstract void cA(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajqh
 * JD-Core Version:    0.7.0.1
 */