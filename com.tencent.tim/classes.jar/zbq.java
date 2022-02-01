import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.1;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.2;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.3;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zbq
  implements aehn.b, Manager
{
  private boolean Yp;
  private zbx.a jdField_a_of_type_Zbx$a = new zbr(this);
  private final zbx jdField_a_of_type_Zbx;
  private final QQAppInterface app;
  private ajdo.a b = new zbu(this);
  private final SparseArray<zbm> bJ;
  private final SparseArray<zbq.a> bK;
  private Object bV = new Object();
  private boolean bqA;
  private boolean bqB;
  private boolean bqC;
  private boolean bqD;
  private boolean bqz;
  private int ccR;
  protected int ccS;
  private int ccT;
  private accn jdField_e_of_type_Accn = new zbs(this);
  acfd jdField_e_of_type_Acfd = new zbv(this);
  private afsr jdField_e_of_type_Afsr = new zbt(this);
  private final List<zbp> mListeners;
  private final List<Integer> tF;
  private final List<zbq.b> tG;
  
  public zbq(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "CTEntryMng create");
    }
    this.app = paramQQAppInterface;
    this.bJ = new SparseArray(5);
    this.bK = new SparseArray(5);
    this.tF = Collections.synchronizedList(new ArrayList(5));
    this.mListeners = Collections.synchronizedList(new ArrayList(5));
    this.tG = Collections.synchronizedList(new ArrayList(5));
    this.app.addObserver(this.jdField_e_of_type_Accn);
    this.app.addObserver(this.jdField_e_of_type_Afsr);
    this.app.addObserver(this.jdField_e_of_type_Acfd);
    this.jdField_a_of_type_Zbx = new zbx(this.app, this.jdField_a_of_type_Zbx$a);
    paramQQAppInterface = this.app.a();
    paramQQAppInterface.a("confess_config", this);
    paramQQAppInterface.a("extend_friend_config_785", this);
    paramQQAppInterface.a("contact_top_entry_config", this);
    paramQQAppInterface.a("register_invitation_config", this);
    ThreadManager.excute(new CTEntryMng.1(this), 64, null, false);
    if (this.b != null) {
      ((PhoneContactManagerImp)this.app.getManager(11)).a(this.b);
    }
  }
  
  private void Bp(boolean paramBoolean)
  {
    if (this.Yp) {}
    zbm localzbm;
    boolean bool;
    do
    {
      return;
      localzbm = a(1);
      bool = localzbm.bqw;
      aegp localaegp = ((aegs)this.app.getManager(269)).a();
      if (TextUtils.isEmpty(localzbm.title)) {
        localzbm.title = acfp.m(2131704529);
      }
      localzbm.bqw = localaegp.agD();
      a(localzbm);
      if ((bool != localzbm.bqw) && (localzbm.bqw) && (paramBoolean)) {
        b(localzbm);
      }
    } while (!QLog.isColorLevel());
    QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateConfessEntry show: %s, title: %s, sub: %s preValue: %s", new Object[] { Boolean.valueOf(localzbm.bqw), localzbm.title, localzbm.subTitle, Boolean.valueOf(bool) }));
  }
  
  private void Bq(boolean paramBoolean)
  {
    if (this.Yp) {
      return;
    }
    zbm localzbm = a(2);
    boolean bool = localzbm.bqw;
    afsi localafsi = (afsi)this.app.getManager(264);
    afsi.a locala = localafsi.b();
    if (locala != null) {
      localzbm.bqw = localafsi.a(locala);
    }
    for (localzbm.extraInfo = Boolean.valueOf(localafsi.isResourceReady());; localzbm.extraInfo = null)
    {
      a(localzbm);
      if ((bool != localzbm.bqw) && (localzbm.bqw) && (paramBoolean)) {
        b(localzbm);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateExtendFrdEntry show: %s, title: %s, sub: %s, preValue: %s", new Object[] { Boolean.valueOf(localzbm.bqw), localzbm.title, localzbm.subTitle, Boolean.valueOf(bool) }));
      return;
      localzbm.bqw = false;
    }
  }
  
  private void Br(boolean paramBoolean)
  {
    if (this.Yp) {
      return;
    }
    zbm localzbm = a(3);
    boolean bool3 = localzbm.bqw;
    achg localachg = (achg)this.app.getManager(159);
    boolean bool2;
    boolean bool1;
    if (localachg != null)
    {
      bool2 = localachg.kl("sp_mayknow_entry_list_recommend");
      bool1 = localachg.kl("sp_mayknow_entry_list_head");
    }
    for (;;)
    {
      localzbm.title = this.app.getApp().getResources().getString(2131701327);
      if ((bool1) && (!bool2)) {}
      for (localzbm.bqw = true;; localzbm.bqw = false)
      {
        if (localzbm.extraInfo == null) {
          localzbm.subTitle = "";
        }
        if ((paramBoolean) || ((localzbm.bqw) && (localzbm.extraInfo == null))) {
          this.jdField_a_of_type_Zbx.checkUpdate();
        }
        a(localzbm);
        if ((bool3 != localzbm.bqw) && (localzbm.bqw) && (paramBoolean)) {
          b(localzbm);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateMayKnowEntry show: %s, title: %s, sub: %s, extra: %s", new Object[] { Boolean.valueOf(localzbm.bqw), localzbm.title, localzbm.subTitle, localzbm.extraInfo }));
        return;
      }
      bool1 = true;
      bool2 = false;
    }
  }
  
  private void Bs(boolean paramBoolean)
  {
    if (this.Yp) {
      return;
    }
    zbm localzbm = a(4);
    boolean bool2 = localzbm.bqw;
    if (BaseApplicationImpl.getContext().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getInt("contacts_invite_friend_entry", 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      localzbm.bqw = bool1;
      if ((bool2 != localzbm.bqw) && (localzbm.bqw) && (paramBoolean)) {
        b(localzbm);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateInviteFrd show: %s, title: %s, sub: %s, url: %s", new Object[] { Boolean.valueOf(localzbm.bqw), localzbm.title, localzbm.subTitle, localzbm.jumpUrl }));
      return;
    }
  }
  
  private String a(SparseArray<zbq.a> paramSparseArray)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (paramSparseArray != null)
    {
      localObject1 = localObject2;
      if (paramSparseArray.size() > 0)
      {
        localObject1 = new JSONArray();
        i = 0;
        if (i < paramSparseArray.size())
        {
          localObject2 = (zbq.a)paramSparseArray.valueAt(i);
          if ((((zbq.a)localObject2).ccU > 4) && (!this.tF.contains(Integer.valueOf(((zbq.a)localObject2).ccU)))) {
            if (QLog.isColorLevel()) {
              QLog.i("CTEntryMng", 2, "getEntryRedDotStr not save id: " + ((zbq.a)localObject2).ccU);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            localObject2 = ((zbq.a)localObject2).toJson();
            if (localObject2 != null) {
              ((JSONArray)localObject1).put(localObject2);
            }
          }
        }
        localObject1 = ((JSONArray)localObject1).toString();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = Locale.getDefault();
      if (paramSparseArray != null) {
        break label197;
      }
    }
    label197:
    for (int i = 0;; i = paramSparseArray.size())
    {
      QLog.i("CTEntryMng", 2, String.format((Locale)localObject2, "getEntryRedDotStr size: %s, str: %s", new Object[] { Integer.valueOf(i), localObject1 }));
      return localObject1;
    }
  }
  
  private zbq.b a(short paramShort)
  {
    int i = 0;
    while (i < this.tG.size())
    {
      if (((zbq.b)this.tG.get(i)).L == paramShort) {
        return (zbq.b)this.tG.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  private void a(zbm paramzbm)
  {
    if (paramzbm == null) {
      return;
    }
    synchronized (this.bJ)
    {
      this.bJ.put(paramzbm.id, paramzbm);
      return;
    }
  }
  
  private void a(zbq.b paramb)
  {
    if (!this.tG.contains(paramb)) {
      this.tG.add(paramb);
    }
  }
  
  /* Error */
  private void an(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifne +15 -> 18
    //   6: aload_0
    //   7: getfield 409	zbq:bqz	Z
    //   10: istore_3
    //   11: iload_3
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: invokespecial 412	zbq:cnU	()V
    //   22: aload_0
    //   23: invokespecial 415	zbq:cnW	()V
    //   26: aload_0
    //   27: aload_2
    //   28: invokespecial 419	zbq:bj	(Ljava/lang/String;)V
    //   31: aload_0
    //   32: iconst_1
    //   33: invokevirtual 422	zbq:Bu	(Z)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 409	zbq:bqz	Z
    //   41: aload_0
    //   42: invokespecial 399	zbq:cnR	()V
    //   45: aload_0
    //   46: invokespecial 425	zbq:cnT	()V
    //   49: aload_0
    //   50: invokevirtual 428	zbq:cnS	()V
    //   53: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq -41 -> 15
    //   59: ldc 90
    //   61: iconst_2
    //   62: invokestatic 220	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   65: ldc_w 430
    //   68: iconst_3
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: iload_1
    //   75: invokestatic 228	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: aload_2
    //   82: aastore
    //   83: dup
    //   84: iconst_2
    //   85: aload_0
    //   86: getfield 98	zbq:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   89: invokevirtual 433	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   92: aastore
    //   93: invokestatic 237	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   96: invokestatic 96	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: goto -84 -> 15
    //   102: astore_2
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_2
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	zbq
    //   0	107	1	paramBoolean	boolean
    //   0	107	2	paramString	String
    //   10	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	11	102	finally
    //   18	99	102	finally
  }
  
  private void b(SparseArray<zbq.a> paramSparseArray)
  {
    ThreadManager.excute(new CTEntryMng.2(this, paramSparseArray), 64, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "saveEntryRedDot");
    }
  }
  
  /* Error */
  private void bj(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 118	zbq:tF	Ljava/util/List;
    //   4: invokeinterface 450 1 0
    //   9: aload_1
    //   10: invokestatic 197	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +327 -> 340
    //   16: new 452	org/json/JSONObject
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 454	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: ldc_w 456
    //   29: invokevirtual 459	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   32: ifeq +303 -> 335
    //   35: aload_1
    //   36: ldc_w 456
    //   39: invokevirtual 463	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   42: astore 6
    //   44: iconst_0
    //   45: istore_3
    //   46: iconst_0
    //   47: istore_2
    //   48: aload 6
    //   50: ifnull +47 -> 97
    //   53: iload_3
    //   54: aload 6
    //   56: invokevirtual 466	org/json/JSONArray:length	()I
    //   59: if_icmpge +38 -> 97
    //   62: aload_0
    //   63: aload 6
    //   65: iload_3
    //   66: invokevirtual 470	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   69: invokespecial 474	zbq:q	(Lorg/json/JSONObject;)Z
    //   72: istore 5
    //   74: iload 5
    //   76: ifne +7 -> 83
    //   79: iload_2
    //   80: ifeq +12 -> 92
    //   83: iconst_1
    //   84: istore_2
    //   85: iload_3
    //   86: iconst_1
    //   87: iadd
    //   88: istore_3
    //   89: goto -41 -> 48
    //   92: iconst_0
    //   93: istore_2
    //   94: goto -9 -> 85
    //   97: iload_2
    //   98: istore_3
    //   99: aload_1
    //   100: ldc_w 476
    //   103: invokevirtual 459	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   106: ifeq +70 -> 176
    //   109: aload_1
    //   110: ldc_w 476
    //   113: invokevirtual 463	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   116: astore_1
    //   117: iconst_0
    //   118: istore 4
    //   120: iload_2
    //   121: istore_3
    //   122: aload_1
    //   123: ifnull +53 -> 176
    //   126: iload_2
    //   127: istore_3
    //   128: iload 4
    //   130: aload_1
    //   131: invokevirtual 466	org/json/JSONArray:length	()I
    //   134: if_icmpge +42 -> 176
    //   137: aload_1
    //   138: iload 4
    //   140: invokevirtual 479	org/json/JSONArray:getInt	(I)I
    //   143: istore_3
    //   144: aload_0
    //   145: getfield 118	zbq:tF	Ljava/util/List;
    //   148: iload_3
    //   149: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: invokeinterface 396 2 0
    //   157: pop
    //   158: iload 4
    //   160: iconst_1
    //   161: iadd
    //   162: istore 4
    //   164: goto -44 -> 120
    //   167: astore_1
    //   168: iconst_0
    //   169: istore_2
    //   170: aload_1
    //   171: invokevirtual 482	org/json/JSONException:printStackTrace	()V
    //   174: iload_2
    //   175: istore_3
    //   176: aload_0
    //   177: getfield 118	zbq:tF	Ljava/util/List;
    //   180: iconst_3
    //   181: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: invokeinterface 342 2 0
    //   189: ifne +17 -> 206
    //   192: aload_0
    //   193: getfield 118	zbq:tF	Ljava/util/List;
    //   196: iconst_3
    //   197: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   200: invokeinterface 396 2 0
    //   205: pop
    //   206: aload_0
    //   207: getfield 118	zbq:tF	Ljava/util/List;
    //   210: iconst_1
    //   211: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: invokeinterface 342 2 0
    //   219: ifeq +8 -> 227
    //   222: aload_0
    //   223: iconst_0
    //   224: invokespecial 484	zbq:Bp	(Z)V
    //   227: aload_0
    //   228: getfield 118	zbq:tF	Ljava/util/List;
    //   231: iconst_2
    //   232: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: invokeinterface 342 2 0
    //   240: ifeq +8 -> 248
    //   243: aload_0
    //   244: iconst_0
    //   245: invokespecial 486	zbq:Bq	(Z)V
    //   248: aload_0
    //   249: getfield 118	zbq:tF	Ljava/util/List;
    //   252: iconst_3
    //   253: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: invokeinterface 342 2 0
    //   261: ifeq +8 -> 269
    //   264: aload_0
    //   265: iconst_0
    //   266: invokespecial 402	zbq:Br	(Z)V
    //   269: aload_0
    //   270: getfield 118	zbq:tF	Ljava/util/List;
    //   273: iconst_4
    //   274: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: invokeinterface 342 2 0
    //   282: ifeq +8 -> 290
    //   285: aload_0
    //   286: iconst_0
    //   287: invokespecial 488	zbq:Bs	(Z)V
    //   290: aload_0
    //   291: getfield 118	zbq:tF	Ljava/util/List;
    //   294: iconst_5
    //   295: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   298: invokeinterface 342 2 0
    //   303: ifeq +8 -> 311
    //   306: aload_0
    //   307: iconst_0
    //   308: invokevirtual 491	zbq:Bt	(Z)V
    //   311: iload_3
    //   312: ifeq +14 -> 326
    //   315: aload_0
    //   316: aload_0
    //   317: getfield 107	zbq:bK	Landroid/util/SparseArray;
    //   320: invokevirtual 495	android/util/SparseArray:clone	()Landroid/util/SparseArray;
    //   323: invokespecial 497	zbq:b	(Landroid/util/SparseArray;)V
    //   326: return
    //   327: astore_1
    //   328: goto -158 -> 170
    //   331: astore_1
    //   332: goto -162 -> 170
    //   335: iconst_0
    //   336: istore_2
    //   337: goto -240 -> 97
    //   340: iconst_0
    //   341: istore_3
    //   342: goto -166 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	zbq
    //   0	345	1	paramString	String
    //   47	290	2	i	int
    //   45	297	3	j	int
    //   118	45	4	k	int
    //   72	3	5	bool	boolean
    //   42	22	6	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   16	44	167	org/json/JSONException
    //   53	74	327	org/json/JSONException
    //   99	117	331	org/json/JSONException
    //   128	158	331	org/json/JSONException
  }
  
  private void cnR()
  {
    int i = 0;
    try
    {
      while (i < this.mListeners.size())
      {
        zbp localzbp = (zbp)this.mListeners.get(i);
        if (localzbp != null) {
          localzbp.bFV();
        }
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "notifyEntryUpdated [isEntryUIInit: %s, redDotFlag: %s]", new Object[] { Boolean.valueOf(this.bqC), Integer.valueOf(this.ccS) }));
      }
      if (!this.bqC) {
        wd(l(dj()));
      }
    }
  }
  
  private void cnT()
  {
    synchronized (this.bV)
    {
      if (!this.bqD)
      {
        this.bqD = true;
        this.ccT = this.app.getApp().getSharedPreferences("mayknow_connections_switch", 0).getInt("key_mayknow_connections_switch", 0);
        if (QLog.isColorLevel()) {
          QLog.i("CTEntryMng", 2, "initConnectionsSwitchLocal " + this.ccT);
        }
      }
      return;
    }
  }
  
  private void cnU()
  {
    if (this.bqA) {
      return;
    }
    synchronized (this.bK)
    {
      this.bK.clear();
      zs(aqgt.k(this.app.getApp(), this.app.getCurrentUin(), "ct_entry_reddot_info"));
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "initEntryRedDot");
      }
      this.bqA = true;
      return;
    }
  }
  
  private void cnV()
  {
    ThreadManager.excute(new CTEntryMng.3(this), 64, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "saveUserSetting");
    }
  }
  
  private void cnW()
  {
    if (this.bqB) {
      return;
    }
    Object localObject = aqgt.k(this.app.getApp(), this.app.getCurrentUin(), "ct_entry_user_setting");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = new JSONArray((String)localObject);
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
          zbq.b localb = new zbq.b();
          localb.parseFromJson(localJSONObject);
          if ((localb.ccU != 0) && (localb.L != 0)) {
            a(localb);
          }
          i += 1;
        }
        this.bqB = true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static int l(List<zbm> paramList)
  {
    int i = 0;
    if ((paramList != null) && (i < paramList.size()))
    {
      zbm localzbm = (zbm)paramList.get(i);
      if (localzbm == null) {}
      while (!localzbm.bqx)
      {
        i += 1;
        break;
      }
      return 1;
    }
    return -1;
  }
  
  private boolean q(JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramJSONObject == null) {}
    int i;
    do
    {
      return false;
      i = paramJSONObject.optInt("id", 0);
    } while (i == 0);
    ??? = a(i);
    ((zbm)???).id = i;
    ((zbm)???).title = paramJSONObject.optString("title", ((zbm)???).title);
    ((zbm)???).smallIconUrl = paramJSONObject.optString("AndroidMultiCardsIcon", ((zbm)???).smallIconUrl);
    ((zbm)???).Xy = paramJSONObject.optString("AndroidSingleCardIcon", ((zbm)???).Xy);
    ((zbm)???).jumpUrl = paramJSONObject.optString("url", ((zbm)???).jumpUrl);
    ((zbm)???).showRedDot = paramJSONObject.optBoolean("showRedDot", ((zbm)???).showRedDot);
    ((zbm)???).redDotVersion = paramJSONObject.optInt("redDotVersion", ((zbm)???).redDotVersion);
    ((zbm)???).K = ((short)paramJSONObject.optInt("switchFlag", ((zbm)???).K));
    switch (((zbm)???).id)
    {
    default: 
      ((zbm)???).subTitle = paramJSONObject.optString("subTitle", ((zbm)???).subTitle);
      ((zbm)???).bqv = false;
      ((zbm)???).bqw = true;
      a((zbm)???);
      paramJSONObject = a(((zbm)???).id);
      if (paramJSONObject.redDotVersion != ((zbm)???).redDotVersion)
      {
        paramJSONObject.redDotVersion = ((zbm)???).redDotVersion;
        paramJSONObject.showRedDot = ((zbm)???).showRedDot;
        paramJSONObject.bqE = false;
        paramJSONObject.KS = 0L;
      }
      break;
    }
    for (;;)
    {
      synchronized (this.bK)
      {
        this.bK.put(paramJSONObject.ccU, paramJSONObject);
        return bool;
        ((zbm)???).subTitle = paramJSONObject.optString("subTitle", ((zbm)???).subTitle);
        ((zbm)???).bqv = false;
        ((zbm)???).K = -25161;
        break;
        ((zbm)???).subTitle = paramJSONObject.optString("subTitle", ((zbm)???).subTitle);
        ((zbm)???).bqv = false;
        ((zbm)???).jumpUrl = "native";
        ((zbm)???).K = -23324;
        break;
        ((zbm)???).subTitle = paramJSONObject.optString("subTitle", ((zbm)???).subTitle);
        ((zbm)???).bqv = false;
        ((zbm)???).K = -23323;
        break;
        ((zbm)???).bqv = true;
        ((zbm)???).jumpUrl = "native";
        ((zbm)???).K = -23447;
        break;
        ((zbm)???).subTitle = paramJSONObject.optString("subTitle", ((zbm)???).subTitle);
        ((zbm)???).bqv = false;
        ((zbm)???).jumpUrl = "native";
        ((zbm)???).K = -23316;
      }
      bool = false;
    }
  }
  
  public void Bn(boolean paramBoolean)
  {
    this.bqC = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "setEntryUIInit  " + paramBoolean);
    }
  }
  
  public void Bo(boolean paramBoolean)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "setConnectionsSwitch " + paramBoolean);
    }
    if (!Vf()) {}
    for (boolean bool = true; bool == paramBoolean; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "setConnectionsSwitch no need to set");
      }
      return;
    }
    CardHandler localCardHandler = (CardHandler)this.app.getBusinessHandler(2);
    if (paramBoolean) {}
    for (;;)
    {
      localCardHandler.b((short)-23204, (short)i);
      return;
      i = 0;
    }
  }
  
  public void Bt(boolean paramBoolean)
  {
    if (this.Yp) {
      return;
    }
    zbm localzbm = a(5);
    boolean bool1 = localzbm.bqw;
    int i = ((PhoneContactManagerImp)this.app.getManager(11)).xy();
    if (QLog.isDevelopLevel()) {
      QLog.i("CTEntryMng", 4, "updateFindFriendEntry selfBindState:" + i + " uin:" + this.app.getCurrentUin());
    }
    if ((i == 1) || (i == 2))
    {
      SharedPreferences localSharedPreferences = aqmj.j(this.app.getCurrentUin());
      boolean bool2 = localSharedPreferences.getBoolean("contacts_bind_phone_canshow", false);
      localzbm.bqw = bool2;
      if (bool2) {
        localzbm.extraInfo = Boolean.valueOf(localSharedPreferences.getBoolean("contacts_bind_phone_is_new_user", false));
      }
      if (!localzbm.bqy)
      {
        i = localSharedPreferences.getInt("contacts_bind_phone_next_gap", 300);
        long l1 = localSharedPreferences.getLong("contacts_bind_phone_last_time", -1L);
        long l2 = NetConnInfoCenter.getServerTime();
        if (QLog.isDevelopLevel()) {
          QLog.i("CTEntryMng", 4, "updateFindFriendEntry nextGap:" + i + " gap:" + (l2 - l1) + " uin:" + this.app.getCurrentUin());
        }
        if ((l1 < 0L) || (l2 - l1 >= i))
        {
          ((CardHandler)this.app.getBusinessHandler(2)).cHN();
          localSharedPreferences.edit().putLong("contacts_bind_phone_last_time", l2).commit();
        }
      }
    }
    for (;;)
    {
      a(localzbm);
      if ((bool1 != localzbm.bqw) && (localzbm.bqw) && (paramBoolean)) {
        b(localzbm);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateFindFriendEntry show: %s, title: %s, sub: %s, preValue: %s uin: %s", new Object[] { Boolean.valueOf(localzbm.bqw), localzbm.title, localzbm.subTitle, Boolean.valueOf(bool1), this.app.getCurrentUin() }));
      return;
      localzbm.bqw = false;
    }
  }
  
  public void Bu(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.ccR > 20))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "getEntryUserSettingFromServer fromConfig to many times!");
      }
      return;
    }
    if (paramBoolean) {
      this.ccR += 1;
    }
    String str = "";
    for (;;)
    {
      short[] arrayOfShort;
      int i;
      try
      {
        List localList = dk();
        if (localList.size() <= 0) {
          break;
        }
        arrayOfShort = new short[localList.size()];
        i = 0;
        if (i >= localList.size()) {
          break label257;
        }
        zbm localzbm = (zbm)localList.get(i);
        switch (localzbm.id)
        {
        case 1: 
          arrayOfShort[i] = localzbm.K;
          zbq.b localb = a(localzbm.id);
          localb.L = arrayOfShort[i];
          a(localb);
          if (!QLog.isColorLevel()) {
            break label303;
          }
          str = String.format(Locale.getDefault(), "%s, [id: %s, title: %s, flag: %s]", new Object[] { str, Integer.valueOf(localzbm.id), localzbm.title, Short.valueOf(arrayOfShort[i]) });
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      arrayOfShort[i] = -25161;
      continue;
      arrayOfShort[i] = -23324;
      continue;
      label257:
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "getEntryUserSettingFromServer log: %s", new Object[] { localThrowable }));
      }
      ((CardHandler)this.app.getBusinessHandler(2)).a(arrayOfShort);
      return;
      label303:
      break label309;
      continue;
      label309:
      i += 1;
      continue;
      arrayOfShort[i] = -23447;
      continue;
      arrayOfShort[i] = -23323;
      continue;
      arrayOfShort[i] = -23316;
    }
  }
  
  public void EY(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, "saveConnectionsSwitchToLocal " + paramInt);
    }
    synchronized (this.bV)
    {
      this.app.getApp().getSharedPreferences("mayknow_connections_switch", 0).edit().putInt("key_mayknow_connections_switch", paramInt).commit();
      this.ccT = paramInt;
      this.bqD = true;
      return;
    }
  }
  
  public boolean Vd()
  {
    return false;
  }
  
  public boolean Ve()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.tG.size())
      {
        if ((this.tG.get(i) != null) && (((zbq.b)this.tG.get(i)).ccU == 3)) {
          bool1 = ((zbq.b)this.tG.get(i)).Vh();
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean Vf()
  {
    cnT();
    for (;;)
    {
      synchronized (this.bV)
      {
        if (this.ccT == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public zbm a(int paramInt)
  {
    synchronized (this.bJ)
    {
      zbm localzbm = (zbm)this.bJ.get(paramInt);
      ??? = localzbm;
      if (localzbm == null)
      {
        ??? = new zbm();
        ((zbm)???).id = paramInt;
        ((zbm)???).bqw = false;
        ((zbm)???).bqy = false;
        ((zbm)???).extraInfo = null;
      }
      return ???;
    }
  }
  
  public zbq.a a(int paramInt)
  {
    synchronized (this.bK)
    {
      zbq.a locala = (zbq.a)this.bK.get(paramInt);
      ??? = locala;
      if (locala == null)
      {
        ??? = new zbq.a();
        ((zbq.a)???).ccU = paramInt;
      }
      return ???;
    }
  }
  
  public zbq.b a(int paramInt)
  {
    int i = 0;
    if (i < this.tG.size()) {
      if (((zbq.b)this.tG.get(i)).ccU != paramInt) {}
    }
    for (zbq.b localb1 = (zbq.b)this.tG.get(i);; localb1 = null)
    {
      zbq.b localb2 = localb1;
      if (localb1 == null)
      {
        localb2 = new zbq.b();
        localb2.ccU = paramInt;
        switch (paramInt)
        {
        default: 
          localb2.L = 0;
        }
      }
      for (;;)
      {
        localb2.M = -32768;
        return localb2;
        i += 1;
        break;
        localb2.L = -25161;
        continue;
        localb2.L = -23324;
        continue;
        localb2.L = -23447;
        continue;
        localb2.L = -23323;
        continue;
        localb2.L = -23316;
      }
    }
  }
  
  public zbx a()
  {
    return this.jdField_a_of_type_Zbx;
  }
  
  public short a(zbm paramzbm, boolean paramBoolean)
  {
    if (paramzbm == null) {
      return 0;
    }
    paramzbm = a(paramzbm.id);
    short s2 = paramzbm.L;
    if ((paramBoolean) && (paramzbm.M != 1)) {}
    for (short s1 = 1;; s1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "closeEntry switch_id: %s, switch_value: %s", new Object[] { Short.valueOf(s2), Short.valueOf(s1) }));
      }
      if (s2 != 0) {
        ((CardHandler)this.app.getBusinessHandler(2)).b(s2, s1);
      }
      return s2;
      if ((paramBoolean) || (paramzbm.M == 0)) {
        break;
      }
    }
    if (paramBoolean) {}
    for (s1 = 1;; s1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "closeEntry, caution something wrong!");
      }
      break;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, aehn.a parama)
  {
    if (parama != null) {
      i(paramString, parama.strContent, parama.localVersion, parama.version);
    }
  }
  
  public void a(zbm paramzbm, short paramShort)
  {
    if (paramzbm == null) {
      return;
    }
    zbq.b localb = a(paramzbm.K);
    if ((localb != null) && (localb.M != paramShort)) {
      localb.M = paramShort;
    }
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        cnV();
        cnR();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "updateEntrySetting [id:%s, switch_value: %s, needUpdate: %s]", new Object[] { Integer.valueOf(paramzbm.id), Short.valueOf(paramShort), Boolean.valueOf(bool) }));
      return;
    }
  }
  
  public void a(zbp paramzbp)
  {
    if ((paramzbp != null) && (!this.mListeners.contains(paramzbp))) {
      this.mListeners.add(paramzbp);
    }
  }
  
  public void b(zbm paramzbm)
  {
    if (paramzbm == null) {
      return;
    }
    short[] arrayOfShort = new short[1];
    switch (paramzbm.id)
    {
    default: 
      arrayOfShort[0] = paramzbm.K;
    }
    for (;;)
    {
      zbq.b localb = a(paramzbm.id);
      localb.L = arrayOfShort[0];
      a(localb);
      ((CardHandler)this.app.getBusinessHandler(2)).a(arrayOfShort);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "getEntryUserSettingFromServer [id: %s, switch_id: %s, title: %s]", new Object[] { Integer.valueOf(paramzbm.id), Short.valueOf(arrayOfShort[0]), paramzbm.title }));
      return;
      arrayOfShort[0] = -25161;
      continue;
      arrayOfShort[0] = -23324;
      continue;
      arrayOfShort[0] = -23447;
      continue;
      arrayOfShort[0] = -23323;
      continue;
      arrayOfShort[0] = -23316;
    }
  }
  
  public void b(zbp paramzbp)
  {
    if (paramzbp != null) {
      this.mListeners.remove(paramzbp);
    }
  }
  
  public void cnS()
  {
    ((CardHandler)this.app.getBusinessHandler(2)).cHD();
  }
  
  public List<zbm> di()
  {
    if (!this.bqz) {
      an(false, aqmj.k(this.app.getApp(), this.app.getCurrentUin(), "contact_top_entry_config"));
    }
    return dk();
  }
  
  public List<zbm> dj()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      zbm localzbm = a(3);
      if (localzbm.Vb())
      {
        localzbm.bqy = a(3).Vh();
        localzbm.bqx = false;
        localArrayList.add(localzbm);
      }
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "getEntryListToShow size:" + localArrayList.size() + "  canBeShown:" + localzbm.bqw + "  isUserClose:" + localzbm.bqy);
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("CTEntryMng", 1, "getEntryListToShow error:" + localException.getMessage());
    }
    return localArrayList;
  }
  
  public List<zbm> dk()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      zbm localzbm = a(3);
      localzbm.bqy = a(3).Vh();
      localArrayList.add(localzbm);
      if (QLog.isColorLevel()) {
        QLog.i("CTEntryMng", 2, "getEntryListForSetting size:" + localArrayList.size() + "  canBeShown:" + localzbm.bqw + "  isUserClose:" + localzbm.bqy);
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localArrayList;
  }
  
  public void i(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "onConfigUpdatedFromServer tag: %s, localVersion: %s, version: %s, value: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 }));
    }
    if ("confess_config".equals(paramString1)) {
      Bp(true);
    }
    do
    {
      return;
      if ("extend_friend_config_785".equals(paramString1))
      {
        Bq(true);
        return;
      }
      if ("register_invitation_config".equals(paramString1))
      {
        Bs(true);
        return;
      }
    } while (!"contact_top_entry_config".equals(paramString1));
    an(true, paramString2);
  }
  
  public void j(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CTEntryMng", 4, "updateBindPhoneSwitchInfo needShow:" + paramBoolean1 + " net_gap:" + paramInt + " isNewUser:" + paramBoolean2 + " uin:" + this.app.getCurrentUin());
    }
    aqmj.j(this.app.getCurrentUin()).edit().putBoolean("contacts_bind_phone_canshow", paramBoolean1).putInt("contacts_bind_phone_next_gap", paramInt).putBoolean("contacts_bind_phone_is_new_user", paramBoolean2).commit();
    Bt(false);
    cnR();
  }
  
  public void onDestroy()
  {
    this.Yp = true;
    this.app.a().a(this);
    this.mListeners.clear();
    this.app.removeObserver(this.jdField_e_of_type_Accn);
    this.app.removeObserver(this.jdField_e_of_type_Afsr);
    this.app.removeObserver(this.jdField_e_of_type_Acfd);
    this.jdField_a_of_type_Zbx.onDestroy();
    if ((this.app.iz(11)) && (this.b != null)) {
      ((PhoneContactManagerImp)this.app.getManager(11)).b(this.b);
    }
    this.b = null;
  }
  
  public void wd(int paramInt)
  {
    int i = 1;
    if (this.ccS == paramInt) {
      return;
    }
    this.ccS = paramInt;
    if (this.ccS == 1) {}
    for (paramInt = i;; paramInt = 0)
    {
      zbw.k(this.app, paramInt);
      acks.cw(this.app);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CTEntryMng", 2, "updateRedPoint mRedDotFlag: " + this.ccS);
      return;
    }
  }
  
  protected void zs(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        i = 0;
        if (i < localJSONArray.length())
        {
          ??? = localJSONArray.getJSONObject(i);
          zbq.a locala = new zbq.a();
          locala.parseFromJson((JSONObject)???);
          if (locala.ccU == 0) {
            break label141;
          }
          synchronized (this.bK)
          {
            this.bK.put(locala.ccU, locala);
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      QLog.i("CTEntryMng", 2, String.format(Locale.getDefault(), "parseEntryRedDot size: %s, str: %s", new Object[] { Integer.valueOf(this.bK.size()), paramString }));
      return;
      label141:
      i += 1;
    }
  }
  
  public static class a
  {
    public long KS;
    public boolean bqE;
    public int ccU;
    public int redDotVersion;
    public boolean showRedDot;
    
    public void parseFromJson(JSONObject paramJSONObject)
    {
      if (paramJSONObject != null)
      {
        this.ccU = paramJSONObject.optInt("entryID");
        this.redDotVersion = paramJSONObject.optInt("redDotVersion");
        this.showRedDot = paramJSONObject.optBoolean("showRedDot");
        this.bqE = paramJSONObject.optBoolean("userCanceled");
        this.KS = paramJSONObject.optLong("lastCancelTime");
      }
    }
    
    public JSONObject toJson()
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONException1.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          localJSONObject.put("entryID", this.ccU);
          localJSONObject.put("redDotVersion", this.redDotVersion);
          localJSONObject.put("showRedDot", this.showRedDot);
          localJSONObject.put("userCanceled", this.bqE);
          localJSONObject.put("lastCancelTime", this.KS);
          return localJSONObject;
        }
        catch (JSONException localJSONException2)
        {
          JSONObject localJSONObject;
          break label68;
        }
        localJSONException1 = localJSONException1;
        localJSONObject = null;
      }
      label68:
      return localJSONObject;
    }
  }
  
  public static class b
  {
    public short L;
    public short M;
    public int ccU;
    
    boolean Vh()
    {
      return (this.L != 0) && (this.M == 1);
    }
    
    public void parseFromJson(JSONObject paramJSONObject)
    {
      if (paramJSONObject != null)
      {
        this.ccU = paramJSONObject.optInt("entryId");
        this.L = ((short)paramJSONObject.optInt("flagId"));
        this.M = ((short)paramJSONObject.optInt("flagValue"));
      }
    }
    
    public JSONObject toJson()
    {
      try
      {
        localJSONObject = new JSONObject();
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          localJSONObject.put("entryId", this.ccU);
          localJSONObject.put("flagId", this.L);
          localJSONObject.put("flagValue", this.M);
          return localJSONObject;
        }
        catch (Exception localException2)
        {
          JSONObject localJSONObject;
          break label46;
        }
        localException1 = localException1;
        localJSONObject = null;
      }
      label46:
      return localJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zbq
 * JD-Core Version:    0.7.0.1
 */