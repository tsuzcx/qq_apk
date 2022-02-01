import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qidian.QidianManager.1;
import com.tencent.qidian.QidianManager.10;
import com.tencent.qidian.QidianManager.2;
import com.tencent.qidian.QidianManager.3;
import com.tencent.qidian.QidianManager.4;
import com.tencent.qidian.QidianManager.6;
import com.tencent.qidian.QidianManager.7;
import com.tencent.qidian.QidianManager.8;
import com.tencent.qidian.QidianManager.9;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianInternalInfo;
import com.tencent.qidian.data.QidianPAForWpa;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class asgx
  implements Manager
{
  public static final AtomicBoolean eA = new AtomicBoolean(false);
  private List<asgx.a> JP;
  public AppInterface app;
  public Map<String, Integer> oU;
  public Map<String, QidianExternalInfo> oV;
  public Map<String, QidianInternalInfo> oW;
  public Map<String, QidianCorpInfo> oX;
  public Map<String, QidianProfileUiInfo> oY;
  public Map<String, BmqqUserSimpleInfo> oZ;
  public Map<String, QidianPAForWpa> pa;
  public Map<String, String> pb;
  public Map<String, List<MessageRecord>> pc;
  
  public asgx(AppInterface paramAppInterface)
  {
    this.app = paramAppInterface;
    this.oU = new HashMap();
    this.oV = new HashMap();
    this.oW = new HashMap();
    this.oZ = new HashMap();
    this.oX = new HashMap();
    this.oY = new HashMap();
    this.pa = new HashMap();
    this.pc = new HashMap();
    this.pb = new HashMap();
    if (aurs.aJC()) {
      ThreadManager.getSubThreadHandler().post(new QidianManager.1(this));
    }
    for (;;)
    {
      this.JP = new CopyOnWriteArrayList();
      return;
      initial();
    }
  }
  
  public static boolean E(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (!TextUtils.isEmpty(paramString2)) {
        break label48;
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramString3)) && (paramString3.contains("isNeedReply=")) && (paramString3.contains("QidianKfUin=")))
      {
        return true;
        paramString2 = paramString1;
        break;
      }
      return false;
      label48:
      paramString3 = paramString2;
    }
  }
  
  public static String H(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = aqgv.D(paramQQAppInterface, paramString);
    if ((TextUtils.isEmpty(str)) || (str.equals(paramString)))
    {
      paramQQAppInterface = ((asgx)paramQQAppInterface.getManager(165)).a(String.valueOf(paramString));
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.nickname;
      }
    }
    return str;
  }
  
  public static String I(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (asgx)paramQQAppInterface.getManager(165);
    if (paramQQAppInterface.sM(paramString)) {
      if (paramQQAppInterface.oV.containsKey(paramString))
      {
        paramQQAppInterface = (QidianExternalInfo)paramQQAppInterface.oV.get(paramString);
        if (paramQQAppInterface != null) {
          return paramQQAppInterface.masterUin;
        }
      }
      else if (paramQQAppInterface.pb.containsKey(paramString))
      {
        return (String)paramQQAppInterface.pb.get(paramString);
      }
    }
    return "";
  }
  
  /* Error */
  public static void a(android.app.Activity paramActivity, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aload 5
    //   5: ifnonnull +195 -> 200
    //   8: aconst_null
    //   9: astore 5
    //   11: aload_2
    //   12: ifnonnull +204 -> 216
    //   15: ldc 169
    //   17: astore 9
    //   19: aload_3
    //   20: ifnonnull +211 -> 231
    //   23: ldc 169
    //   25: astore_2
    //   26: aload 4
    //   28: ifnonnull +217 -> 245
    //   31: ldc 169
    //   33: astore_3
    //   34: new 174	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   41: astore 10
    //   43: iload_1
    //   44: bipush 6
    //   46: if_icmpne +233 -> 279
    //   49: ldc 177
    //   51: astore 4
    //   53: aload 10
    //   55: aload 4
    //   57: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 10
    //   63: ldc 183
    //   65: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 10
    //   71: ldc 185
    //   73: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload 5
    //   78: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 10
    //   84: ldc 187
    //   86: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 9
    //   91: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 10
    //   97: ldc 189
    //   99: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_2
    //   103: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 10
    //   109: ldc 191
    //   111: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_3
    //   115: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 10
    //   121: ldc 193
    //   123: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: astore_3
    //   127: iload 8
    //   129: ifeq +157 -> 286
    //   132: ldc 195
    //   134: astore_2
    //   135: aload_3
    //   136: aload_2
    //   137: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 10
    //   143: ldc 197
    //   145: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: iload 7
    //   150: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 10
    //   156: ldc 202
    //   158: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload 6
    //   163: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: new 204	android/content/Intent
    //   170: dup
    //   171: ldc 206
    //   173: aload 10
    //   175: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 216	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   181: invokespecial 219	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   184: astore_2
    //   185: aload_2
    //   186: ldc 221
    //   188: ldc 223
    //   190: invokevirtual 227	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   193: pop
    //   194: aload_0
    //   195: aload_2
    //   196: invokevirtual 233	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   199: return
    //   200: aload 5
    //   202: ldc 235
    //   204: invokevirtual 239	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   207: iconst_2
    //   208: invokestatic 245	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   211: astore 5
    //   213: goto -202 -> 11
    //   216: aload_2
    //   217: ldc 235
    //   219: invokevirtual 239	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   222: iconst_2
    //   223: invokestatic 245	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   226: astore 9
    //   228: goto -209 -> 19
    //   231: aload_3
    //   232: ldc 235
    //   234: invokevirtual 239	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   237: iconst_2
    //   238: invokestatic 245	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   241: astore_2
    //   242: goto -216 -> 26
    //   245: aload 4
    //   247: ldc 235
    //   249: invokevirtual 239	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   252: iconst_2
    //   253: invokestatic 245	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   256: astore_3
    //   257: goto -223 -> 34
    //   260: astore_3
    //   261: aconst_null
    //   262: astore 9
    //   264: aconst_null
    //   265: astore 5
    //   267: aconst_null
    //   268: astore_2
    //   269: aload_3
    //   270: invokevirtual 248	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   273: aload 10
    //   275: astore_3
    //   276: goto -242 -> 34
    //   279: ldc 250
    //   281: astore 4
    //   283: goto -230 -> 53
    //   286: ldc 252
    //   288: astore_2
    //   289: goto -154 -> 135
    //   292: astore_3
    //   293: aconst_null
    //   294: astore 9
    //   296: aconst_null
    //   297: astore_2
    //   298: goto -29 -> 269
    //   301: astore_3
    //   302: aconst_null
    //   303: astore_2
    //   304: goto -35 -> 269
    //   307: astore_3
    //   308: goto -39 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	paramActivity	android.app.Activity
    //   0	311	1	paramInt1	int
    //   0	311	2	paramString1	String
    //   0	311	3	paramString2	String
    //   0	311	4	paramString3	String
    //   0	311	5	paramString4	String
    //   0	311	6	paramString5	String
    //   0	311	7	paramInt2	int
    //   0	311	8	paramBoolean	boolean
    //   17	278	9	str	String
    //   1	273	10	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   200	213	260	java/io/UnsupportedEncodingException
    //   216	228	292	java/io/UnsupportedEncodingException
    //   231	242	301	java/io/UnsupportedEncodingException
    //   245	257	307	java/io/UnsupportedEncodingException
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends)
  {
    if (paramFriends == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QidianManager", 2, "updateQidianAccountType friend is null");
      }
      return;
    }
    f(paramQQAppInterface, paramFriends.cSpecialFlag, paramFriends.uin);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends[] paramArrayOfFriends)
  {
    asgx localasgx;
    if (paramArrayOfFriends != null)
    {
      localasgx = (asgx)paramQQAppInterface.getManager(165);
      if (aurs.aJC()) {
        ThreadManager.postImmediately(new QidianManager.9(localasgx, paramQQAppInterface, paramArrayOfFriends), null, false);
      }
    }
    else
    {
      return;
    }
    localasgx.b(paramQQAppInterface, paramArrayOfFriends);
  }
  
  private void a(QidianPAForWpa paramQidianPAForWpa, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "updateQidianPAForWpa");
    }
    paramString1 = this.app.getEntityManagerFactory().createEntityManager();
    if (paramString1 != null) {
      if (paramQidianPAForWpa == null) {}
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          paramString1.persistOrReplace(paramQidianPAForWpa);
          if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "updateQidianPAForWpa success");
          }
          return;
        }
        catch (Exception paramQidianPAForWpa)
        {
          paramQidianPAForWpa.printStackTrace();
          return;
        }
        finally
        {
          paramString1.close();
        }
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "updateQidianPAForWpa uiInfo is null");
        }
      }
    }
    QLog.d("QidianManager", 2, "updateQidianPAForWpa em is null");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Friends paramFriends, int paramInt)
  {
    boolean bool2 = true;
    paramQQAppInterface = (asgx)paramQQAppInterface.getManager(165);
    boolean bool1 = bool2;
    if (paramFriends != null)
    {
      bool1 = bool2;
      if (mS(paramFriends.cSpecialFlag)) {
        if ((paramInt != 1) && (paramInt != 2) && (paramInt != 13) && (paramInt != 10001) && (paramInt != 7)) {
          break label67;
        }
      }
    }
    label67:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public static boolean af(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((asgx)paramQQAppInterface.getManager(165)).sL(paramString);
  }
  
  public static boolean ag(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((asgx)paramQQAppInterface.getManager(165)).sM(paramString);
  }
  
  private boolean au(String paramString, int paramInt)
  {
    Object localObject = (acff)this.app.getManager(51);
    if (localObject != null)
    {
      localObject = ((acff)localObject).b(paramString);
      if ((localObject != null) && (((Friends)localObject).cSpecialFlag < 0))
      {
        QLog.i("QidianManager", 1, "isSpecialAccountInFriend meet error!!");
        return false;
      }
      if ((localObject != null) && ((((Friends)localObject).cSpecialFlag & paramInt) != 0)) {
        QLog.i("QidianManager", 1, MsfSdkUtils.getShortUin(paramString) + " isSpecialAccountInFriend isSpecialAccount is true, friendInfo.cSpecialFlag: " + ((Friends)localObject).cSpecialFlag + " | flag: " + paramInt);
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  /* Error */
  private void b(QQAppInterface paramQQAppInterface, Friends[] paramArrayOfFriends)
  {
    // Byte code:
    //   0: aload_2
    //   1: arraylength
    //   2: istore 4
    //   4: iconst_0
    //   5: istore_3
    //   6: iload_3
    //   7: iload 4
    //   9: if_icmpge +276 -> 285
    //   12: aload_2
    //   13: iload_3
    //   14: aaload
    //   15: astore 9
    //   17: aload 9
    //   19: getfield 296	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   22: astore 10
    //   24: aload 9
    //   26: getfield 293	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   29: istore 5
    //   31: aload 10
    //   33: invokestatic 380	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   36: pop2
    //   37: aload 10
    //   39: invokestatic 385	jou:de	(Ljava/lang/String;)Z
    //   42: ifne +4 -> 46
    //   45: return
    //   46: iload 5
    //   48: invokestatic 345	asgx:mS	(I)Z
    //   51: istore 6
    //   53: iload 5
    //   55: invokestatic 388	asgx:mR	(I)Z
    //   58: istore 7
    //   60: iload 5
    //   62: invokestatic 391	asgx:cU	(I)Z
    //   65: istore 8
    //   67: iload 6
    //   69: ifne +61 -> 130
    //   72: iload 7
    //   74: ifne +56 -> 130
    //   77: iload 8
    //   79: ifne +51 -> 130
    //   82: invokestatic 279	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +201 -> 286
    //   88: ldc_w 281
    //   91: iconst_2
    //   92: new 174	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 175	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 393
    //   102: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 10
    //   107: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc_w 395
    //   113: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: iload 5
    //   118: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: goto +159 -> 286
    //   130: aconst_null
    //   131: astore 9
    //   133: iload 6
    //   135: ifeq +109 -> 244
    //   138: new 397	com/tencent/qidian/data/BmqqAccountType
    //   141: dup
    //   142: aload 10
    //   144: bipush 6
    //   146: invokespecial 400	com/tencent/qidian/data/BmqqAccountType:<init>	(Ljava/lang/String;I)V
    //   149: astore 9
    //   151: aload 9
    //   153: ifnull +133 -> 286
    //   156: aload_0
    //   157: aload 10
    //   159: invokevirtual 404	asgx:fH	(Ljava/lang/String;)I
    //   162: aload 9
    //   164: invokevirtual 408	com/tencent/qidian/data/BmqqAccountType:getAccountType	()I
    //   167: if_icmpeq +119 -> 286
    //   170: aload_0
    //   171: getfield 56	asgx:oU	Ljava/util/Map;
    //   174: aload 10
    //   176: aload 9
    //   178: invokevirtual 408	com/tencent/qidian/data/BmqqAccountType:getAccountType	()I
    //   181: invokestatic 413	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: invokeinterface 417 3 0
    //   189: pop
    //   190: iload 6
    //   192: ifeq +94 -> 286
    //   195: aload_0
    //   196: aload 10
    //   198: invokevirtual 144	asgx:a	(Ljava/lang/String;)Lcom/tencent/qidian/data/QidianExternalInfo;
    //   201: astore 11
    //   203: aload_0
    //   204: aload 10
    //   206: invokevirtual 420	asgx:a	(Ljava/lang/String;)Lcom/tencent/qidian/data/QidianProfileUiInfo;
    //   209: astore 10
    //   211: aload 11
    //   213: ifnull +8 -> 221
    //   216: aload 10
    //   218: ifnonnull +68 -> 286
    //   221: aload_0
    //   222: aload_1
    //   223: invokevirtual 424	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   226: invokevirtual 430	com/tencent/qphone/base/util/BaseApplication:getBaseContext	()Landroid/content/Context;
    //   229: aload 9
    //   231: invokevirtual 433	asgx:b	(Landroid/content/Context;Lcom/tencent/qidian/data/BmqqAccountType;)Z
    //   234: pop
    //   235: goto +51 -> 286
    //   238: astore_1
    //   239: aload_1
    //   240: invokevirtual 338	java/lang/Exception:printStackTrace	()V
    //   243: return
    //   244: iload 7
    //   246: ifeq +18 -> 264
    //   249: new 397	com/tencent/qidian/data/BmqqAccountType
    //   252: dup
    //   253: aload 10
    //   255: iconst_1
    //   256: invokespecial 400	com/tencent/qidian/data/BmqqAccountType:<init>	(Ljava/lang/String;I)V
    //   259: astore 9
    //   261: goto -110 -> 151
    //   264: iload 8
    //   266: ifeq -115 -> 151
    //   269: new 397	com/tencent/qidian/data/BmqqAccountType
    //   272: dup
    //   273: aload 10
    //   275: iconst_3
    //   276: invokespecial 400	com/tencent/qidian/data/BmqqAccountType:<init>	(Ljava/lang/String;I)V
    //   279: astore 9
    //   281: goto -130 -> 151
    //   284: astore_1
    //   285: return
    //   286: iload_3
    //   287: iconst_1
    //   288: iadd
    //   289: istore_3
    //   290: goto -284 -> 6
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	asgx
    //   0	293	1	paramQQAppInterface	QQAppInterface
    //   0	293	2	paramArrayOfFriends	Friends[]
    //   5	285	3	i	int
    //   2	8	4	j	int
    //   29	88	5	k	int
    //   51	140	6	bool1	boolean
    //   58	187	7	bool2	boolean
    //   65	200	8	bool3	boolean
    //   15	265	9	localObject1	Object
    //   22	252	10	localObject2	Object
    //   201	11	11	localQidianExternalInfo	QidianExternalInfo
    // Exception table:
    //   from	to	target	type
    //   0	4	238	java/lang/Exception
    //   17	31	238	java/lang/Exception
    //   37	45	238	java/lang/Exception
    //   46	67	238	java/lang/Exception
    //   82	127	238	java/lang/Exception
    //   138	151	238	java/lang/Exception
    //   156	190	238	java/lang/Exception
    //   195	211	238	java/lang/Exception
    //   221	235	238	java/lang/Exception
    //   249	261	238	java/lang/Exception
    //   269	281	238	java/lang/Exception
    //   31	37	284	java/lang/Exception
  }
  
  private void b(BmqqUserSimpleInfo paramBmqqUserSimpleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "updateBmqqExtInfo");
    }
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    if (localEntityManager != null) {
      if (paramBmqqUserSimpleInfo == null) {}
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          localEntityManager.persistOrReplace(paramBmqqUserSimpleInfo);
          if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "updateBmqqExtInfo success");
          }
          return;
        }
        catch (Exception paramBmqqUserSimpleInfo)
        {
          paramBmqqUserSimpleInfo.printStackTrace();
          return;
        }
        finally
        {
          localEntityManager.close();
        }
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "updateBmqqExtInfo uiInfo is null");
        }
      }
    }
    QLog.d("QidianManager", 2, "updateBmqqExtInfo em is null");
  }
  
  private void b(QidianExternalInfo paramQidianExternalInfo, QidianInternalInfo paramQidianInternalInfo, QidianCorpInfo paramQidianCorpInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread");
    }
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    if (localEntityManager != null) {
      if (paramQidianExternalInfo == null) {}
    }
    label63:
    label127:
    while (!QLog.isColorLevel())
    {
      try
      {
        localEntityManager.persistOrReplace(paramQidianExternalInfo);
        if (paramQidianInternalInfo == null) {
          break label127;
        }
        localEntityManager.persistOrReplace(paramQidianInternalInfo);
      }
      catch (Exception paramQidianExternalInfo)
      {
        for (;;)
        {
          paramQidianExternalInfo.printStackTrace();
          return;
          if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "saveQidianIntInfoInSubThread internalInfo is null");
          }
        }
      }
      finally
      {
        localEntityManager.close();
      }
      if (paramQidianCorpInfo != null)
      {
        localEntityManager.persistOrReplace(paramQidianCorpInfo);
        if (paramQidianProfileUiInfo == null) {
          break label173;
        }
        localEntityManager.persistOrReplace(paramQidianProfileUiInfo);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread success");
        }
        localEntityManager.close();
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread externalInfo is null");
        break;
        if (!QLog.isColorLevel()) {
          break label63;
        }
        QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread corpInfo is null");
        break label63;
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread uiInfo is null");
        }
      }
    }
    label173:
    QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread em is null");
  }
  
  private void b(QidianExternalInfo paramQidianExternalInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread");
    }
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    if (localEntityManager != null) {
      if (paramQidianExternalInfo == null) {}
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          localEntityManager.persistOrReplace(paramQidianExternalInfo);
          if (paramQidianProfileUiInfo == null) {
            continue;
          }
          localEntityManager.persistOrReplace(paramQidianProfileUiInfo);
        }
        catch (Exception paramQidianExternalInfo)
        {
          paramQidianExternalInfo.printStackTrace();
          return;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread uiInfo is null");
          continue;
        }
        finally
        {
          localEntityManager.close();
        }
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread success");
        }
        localEntityManager.close();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread externalInfo is null");
        }
      }
    }
    QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread em is null");
  }
  
  public static boolean cU(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  private void e(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.query(QidianExternalInfo.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        QidianExternalInfo localQidianExternalInfo = (QidianExternalInfo)paramEntityManager.next();
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 4, "loadExternalInfo query from db: " + localQidianExternalInfo);
        }
        String str = localQidianExternalInfo.uin;
        this.oV.put(str, localQidianExternalInfo);
      }
    }
  }
  
  public static void f(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        Long.parseLong(paramString);
        if (!jou.de(paramString)) {
          return;
        }
        asgx localasgx = (asgx)paramQQAppInterface.getManager(165);
        boolean bool1 = mS(paramInt);
        boolean bool2 = mR(paramInt);
        boolean bool3 = cU(paramInt);
        if ((!bool1) && (!bool2) && (!bool3))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QidianManager", 2, "updateQidianAccountType ignore uin: " + paramString + " | cSpecialFlag: " + paramInt);
          return;
        }
        if (localasgx.sN(paramString))
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QidianManager", 2, "updateQidianAccountType requested uin: " + paramString + " | cSpecialFlag: " + paramInt);
          return;
        }
        if (bool1)
        {
          localBmqqAccountType = new BmqqAccountType(paramString, 6);
          localasgx.a(localBmqqAccountType);
          if (!bool1) {
            continue;
          }
          QidianExternalInfo localQidianExternalInfo = localasgx.a(paramString);
          paramString = localasgx.a(paramString);
          if ((localQidianExternalInfo != null) && (paramString != null)) {
            continue;
          }
          if (aurs.aJC()) {
            ThreadManager.post(new QidianManager.10(localasgx, paramQQAppInterface, localBmqqAccountType), 5, null, true);
          }
        }
        else
        {
          if (bool2)
          {
            localBmqqAccountType = new BmqqAccountType(paramString, 1);
            continue;
          }
          if (!bool3) {
            break label285;
          }
          localBmqqAccountType = new BmqqAccountType(paramString, 3);
          continue;
        }
        localasgx.b(paramQQAppInterface.getApp().getBaseContext(), localBmqqAccountType);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
      label285:
      BmqqAccountType localBmqqAccountType = null;
    }
  }
  
  private void f(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.query(QidianInternalInfo.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        QidianInternalInfo localQidianInternalInfo = (QidianInternalInfo)paramEntityManager.next();
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 4, "loadInternalInfo query from db: " + localQidianInternalInfo);
        }
        String str = localQidianInternalInfo.uin;
        this.oW.put(str, localQidianInternalInfo);
      }
    }
  }
  
  public static void g(Context paramContext, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    paramContext = paramContext.getPackageManager();
    if (new Intent().setPackage("com.tencent.qidian").setData(Uri.parse("qdapi://")).resolveActivity(paramContext) != null) {
      paramArrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(19));
    }
  }
  
  private void g(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.query(BmqqUserSimpleInfo.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        BmqqUserSimpleInfo localBmqqUserSimpleInfo = (BmqqUserSimpleInfo)paramEntityManager.next();
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 4, "loadBmqqExtInfo query from db: " + localBmqqUserSimpleInfo);
        }
        String str = localBmqqUserSimpleInfo.mBmqqUin;
        this.oZ.put(str, localBmqqUserSimpleInfo);
      }
    }
  }
  
  private void h(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.query(QidianCorpInfo.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        QidianCorpInfo localQidianCorpInfo = (QidianCorpInfo)paramEntityManager.next();
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 4, "loadCorpInfo query from db: " + localQidianCorpInfo);
        }
        String str = localQidianCorpInfo.corpUin;
        this.oX.put(str, localQidianCorpInfo);
      }
    }
  }
  
  private void i(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.query(QidianProfileUiInfo.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        QidianProfileUiInfo localQidianProfileUiInfo = (QidianProfileUiInfo)paramEntityManager.next();
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 4, "loadQidianProfileUiInfo query from db: " + localQidianProfileUiInfo);
        }
        this.oY.put(localQidianProfileUiInfo.uin, localQidianProfileUiInfo);
      }
    }
  }
  
  private void initial()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 4, "initial ...");
    }
    localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
    try
    {
      e(localEntityManager);
      f(localEntityManager);
      h(localEntityManager);
      i(localEntityManager);
      g(localEntityManager);
      j(localEntityManager);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QidianManager", 2, "QidianManager get data from db error: " + localException.getMessage());
        }
        localEntityManager.close();
      }
    }
    finally
    {
      localEntityManager.close();
    }
    eA.set(true);
  }
  
  private void j(EntityManager paramEntityManager)
  {
    paramEntityManager = paramEntityManager.query(QidianPAForWpa.class);
    if (paramEntityManager != null)
    {
      paramEntityManager = paramEntityManager.iterator();
      while (paramEntityManager.hasNext())
      {
        QidianPAForWpa localQidianPAForWpa = (QidianPAForWpa)paramEntityManager.next();
        this.pa.put(localQidianPAForWpa.puin, localQidianPAForWpa);
      }
    }
  }
  
  public static boolean j(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    return ((((asgx)paramQQAppInterface.getManager(165)).sH(paramMessageRecord.frienduin)) || (paramMessageRecord.istroop == 1024)) && (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("is_eman_sc_message")));
  }
  
  private boolean m(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(paramQQAppInterface.getAccount())) {
      if (QLog.isColorLevel()) {
        QLog.i("QidianManager", 2, "app.getAccount() is null");
      }
    }
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.i("QidianManager", 2, "initParm uin = " + paramString);
      }
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("QidianManager", 2, "mAllinone is null");
    return false;
    return true;
  }
  
  public static boolean mR(int paramInt)
  {
    return (paramInt & 0x4) != 0;
  }
  
  public static boolean mS(int paramInt)
  {
    return (paramInt & 0x10) != 0;
  }
  
  private void o(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("isNeedReply=")) && (paramString1.contains("QidianKfUin=")))
    {
      bool1 = false;
      bool2 = false;
      str3 = "";
      str2 = "";
      str1 = "";
      localMatcher = Pattern.compile("((?:isNeedReply|isNeedLbs|QidianKfUin|isExt|FromStaff|cqq))=([^\\?&=]+)").matcher(paramString1);
      while (localMatcher.find()) {
        if ("isNeedReply".equals(localMatcher.group(1))) {
          bool2 = "true".equals(localMatcher.group(2));
        } else if ("isNeedLbs".equals(localMatcher.group(1))) {
          bool1 = "true".equals(localMatcher.group(2));
        } else if ("QidianKfUin".equals(localMatcher.group(1))) {
          str3 = localMatcher.group(2);
        } else if ("isExt".equals(localMatcher.group(1)))
        {
          if (paramInt2 == 2) {
            try
            {
              bool3 = Boolean.parseBoolean(localMatcher.group(2));
              if (bool3)
              {
                paramInt2 = 0;
                continue;
              }
              paramInt2 = 1;
            }
            catch (Exception localException)
            {
              paramInt2 = 0;
            }
          }
        }
        else if ("FromStaff".equals(localMatcher.group(1))) {
          str2 = localMatcher.group(2);
        } else if ("cqq".equals(localMatcher.group(1))) {
          str1 = localMatcher.group(2);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QidianManager", 2, "isNeedLbs: " + bool1 + " | isNeedReply: " + bool2 + " | masterUin: " + str3 + " | srcType: " + paramInt2);
      }
      if (bool2)
      {
        if (!bool1) {
          break label364;
        }
        SosoInterface.a(new asgy(this, 1, true, true, 0L, true, false, "QidianManager", paramString1, paramInt1, str3, paramInt2, str2, str1, paramString2));
      }
    }
    label364:
    while (!QLog.isColorLevel())
    {
      boolean bool1;
      boolean bool2;
      String str3;
      String str2;
      String str1;
      Matcher localMatcher;
      boolean bool3;
      return;
      a(paramString1, paramInt1, bool1, 0.0D, 0.0D, str3, paramInt2, str2, str1, paramString2);
      return;
    }
    QLog.d("QidianManager", 2, "key is null or don't contain isNeedReply : " + paramString1);
  }
  
  private String qV(String paramString)
  {
    String str = "";
    if (sH(paramString))
    {
      QidianExternalInfo localQidianExternalInfo = (QidianExternalInfo)this.oV.get(paramString);
      if ((localQidianExternalInfo != null) && (!TextUtils.isEmpty(localQidianExternalInfo.masterUin)))
      {
        paramString = (QidianCorpInfo)this.oX.get(localQidianExternalInfo.masterUin);
        if (paramString == null) {
          break label124;
        }
      }
    }
    label124:
    for (paramString = paramString.corpName;; paramString = "")
    {
      str = paramString;
      do
      {
        do
        {
          return str;
        } while (!QLog.isColorLevel());
        QLog.d("QidianManager", 4, "QidianExternalInfo is null or masterUin is empty for uin: " + paramString);
        return "";
      } while (!QLog.isColorLevel());
      QLog.d("QidianManager", 4, "uin is no qidian account");
      return "";
    }
  }
  
  public static void x(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    try
    {
      Long.parseLong(paramString1);
      if (!jou.de(paramString1)) {
        return;
      }
      ((asgx)paramQQAppInterface.getManager(165)).pb.put(paramString1, paramString2);
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  public boolean P(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    try
    {
      Long.parseLong(paramString);
      if (!jou.de(paramString)) {}
      while ((jou.al.get()) && (!jou.z(null, paramString))) {
        return false;
      }
      if (this.oZ.containsKey(paramString)) {}
      for (;;)
      {
        return bool;
        if (!au(paramString, 1))
        {
          if (!paramBoolean) {
            dI(paramString, false);
          }
          bool = false;
        }
      }
      return false;
    }
    catch (Exception paramString) {}
  }
  
  public boolean Q(String paramString, boolean paramBoolean)
  {
    boolean bool2;
    try
    {
      Long.parseLong(paramString);
      if (!jou.de(paramString))
      {
        bool2 = false;
        return bool2;
      }
    }
    catch (Exception paramString)
    {
      return false;
    }
    if ((jou.al.get()) && (!jou.z(null, paramString))) {
      return false;
    }
    boolean bool1;
    if (this.oU.containsKey(paramString))
    {
      if (((Integer)this.oU.get(paramString)).intValue() != 1) {
        break label152;
      }
      bool1 = true;
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      bool2 = bool1;
      if (this.oV.get(paramString) != null) {
        break;
      }
      bool2 = bool1;
      if (paramBoolean) {
        break;
      }
      if (!aurs.aJC()) {
        break label157;
      }
      ThreadManager.post(new QidianManager.4(this, paramString), 5, null, true);
      return bool1;
      if (au(paramString, 4))
      {
        bool1 = true;
      }
      else
      {
        if (!paramBoolean) {
          dI(paramString, false);
        }
        label152:
        bool1 = false;
      }
    }
    label157:
    b(this.app.getApp().getBaseContext(), new BmqqAccountType(paramString, 1));
    return bool1;
  }
  
  public boolean R(String paramString, boolean paramBoolean)
  {
    boolean bool1 = false;
    label401:
    for (;;)
    {
      try
      {
        Long.parseLong(paramString);
        if (!jou.de(paramString))
        {
          paramBoolean = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("QidianManager", 2, "isQidianMaster uin is not in bmqqsegment");
            paramBoolean = bool1;
          }
          return paramBoolean;
        }
        if ((jou.al.get()) && (jou.z(null, paramString)))
        {
          paramBoolean = bool1;
          if (QLog.isColorLevel())
          {
            QLog.d("QidianManager", 2, "isQidianMaster is bmqquin");
            return false;
          }
        }
        else
        {
          bool1 = au(paramString, 16);
          boolean bool2;
          if (!bool1)
          {
            if (this.oU.containsKey(paramString))
            {
              if (((Integer)this.oU.get(paramString)).intValue() != 6) {
                break label401;
              }
              QLog.i("QidianManager", 1, MsfSdkUtils.getShortUin(paramString) + " isQidianMaster is qidianmain");
              bool2 = true;
              bool1 = bool2;
              if (!paramBoolean)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("QidianManager", 2, "isQidianMaster not only in cache 0");
                }
                XL(paramString);
                bool1 = bool2;
              }
              if ((bool1) && (!paramBoolean))
              {
                QidianExternalInfo localQidianExternalInfo = a(String.valueOf(paramString));
                QidianProfileUiInfo localQidianProfileUiInfo = a(String.valueOf(paramString));
                if ((localQidianExternalInfo == null) || (localQidianProfileUiInfo == null))
                {
                  if (!aurs.aJC()) {
                    continue;
                  }
                  ThreadManager.post(new QidianManager.7(this, paramString), 5, null, true);
                }
              }
              paramBoolean = bool1;
              if (!bool1) {
                continue;
              }
              QLog.i("QidianManager", 1, MsfSdkUtils.getShortUin(paramString) + " isQidianMaster is true finally");
              return bool1;
            }
            if (!paramBoolean)
            {
              if (QLog.isColorLevel()) {
                QLog.d("QidianManager", 2, "isQidianMaster not only in cache 1");
              }
              XL(paramString);
              continue;
            }
          }
          else if (!this.oU.containsKey(paramString))
          {
            a(new BmqqAccountType(paramString, 6));
            if (QLog.isColorLevel()) {
              QLog.d("QidianManager", 2, "isQidianMaster update account type");
            }
          }
          continue;
          b(this.app.getApp().getBaseContext(), new BmqqAccountType(paramString, 6));
          if (QLog.isColorLevel())
          {
            QLog.d("QidianManager", 2, "isQidianMaster get user detail");
            continue;
            bool2 = bool1;
          }
        }
      }
      catch (Exception paramString)
      {
        return false;
      }
    }
  }
  
  public void UC(boolean paramBoolean)
  {
    Iterator localIterator = this.JP.iterator();
    while (localIterator.hasNext()) {
      ((asgx.a)localIterator.next()).UD(paramBoolean);
    }
  }
  
  public void XK(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return;
        localObject1 = paramString.split("\\?");
      } while (localObject1.length != 2);
      localObject2 = localObject1[1].split("&");
      localObject1 = new HashMap();
      int j = localObject2.length;
      int i = 0;
      if (i < j)
      {
        String[] arrayOfString = localObject2[i].split("=");
        if (arrayOfString.length != 2) {}
        for (;;)
        {
          i += 1;
          break;
          ((HashMap)localObject1).put(arrayOfString[0], arrayOfString[1]);
        }
      }
      localObject2 = (String)((HashMap)localObject1).get("aioType");
      localObject1 = (String)((HashMap)localObject1).get("uin");
    } while ((TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty((CharSequence)localObject1)));
    bs(paramString, (String)localObject2, (String)localObject1);
  }
  
  public void XL(String paramString)
  {
    ((CardHandler)this.app.getBusinessHandler(2)).Dx(paramString);
  }
  
  public QidianCorpInfo a(String paramString)
  {
    QidianCorpInfo localQidianCorpInfo = null;
    if (this.oX.containsKey(paramString)) {
      localQidianCorpInfo = (QidianCorpInfo)this.oX.get(paramString);
    }
    return localQidianCorpInfo;
  }
  
  public QidianExternalInfo a(String paramString)
  {
    QidianExternalInfo localQidianExternalInfo = null;
    if (this.oV.containsKey(paramString)) {
      localQidianExternalInfo = (QidianExternalInfo)this.oV.get(paramString);
    }
    return localQidianExternalInfo;
  }
  
  public QidianInternalInfo a(String paramString)
  {
    QidianInternalInfo localQidianInternalInfo = null;
    if (this.oW.containsKey(paramString)) {
      localQidianInternalInfo = (QidianInternalInfo)this.oW.get(paramString);
    }
    return localQidianInternalInfo;
  }
  
  public QidianProfileUiInfo a(String paramString)
  {
    QidianProfileUiInfo localQidianProfileUiInfo = null;
    if (this.oY.containsKey(paramString)) {
      localQidianProfileUiInfo = (QidianProfileUiInfo)this.oY.get(paramString);
    }
    return localQidianProfileUiInfo;
  }
  
  public void a(BmqqUserSimpleInfo paramBmqqUserSimpleInfo)
  {
    if (paramBmqqUserSimpleInfo != null) {
      this.oZ.put(paramBmqqUserSimpleInfo.mBmqqUin, paramBmqqUserSimpleInfo);
    }
    if (aurs.aJC())
    {
      ThreadManager.post(new QidianManager.2(this, paramBmqqUserSimpleInfo), 5, null, true);
      return;
    }
    b(paramBmqqUserSimpleInfo);
  }
  
  public void a(BmqqAccountType paramBmqqAccountType)
  {
    if (paramBmqqAccountType != null) {
      this.oU.put(paramBmqqAccountType.getUin(), Integer.valueOf(paramBmqqAccountType.getAccountType()));
    }
  }
  
  public void a(QidianExternalInfo paramQidianExternalInfo, QidianInternalInfo paramQidianInternalInfo, QidianCorpInfo paramQidianCorpInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    if (paramQidianExternalInfo != null) {
      this.oV.put(paramQidianExternalInfo.uin, paramQidianExternalInfo);
    }
    if (paramQidianCorpInfo != null) {
      this.oX.put(paramQidianCorpInfo.corpUin, paramQidianCorpInfo);
    }
    if (paramQidianProfileUiInfo != null) {
      this.oY.put(paramQidianProfileUiInfo.uin, paramQidianProfileUiInfo);
    }
    if (paramQidianInternalInfo != null) {
      this.oW.put(paramQidianInternalInfo.uin, paramQidianInternalInfo);
    }
    if (aurs.aJC())
    {
      ThreadManager.post(new QidianManager.3(this, paramQidianExternalInfo, paramQidianInternalInfo, paramQidianCorpInfo, paramQidianProfileUiInfo), 5, null, true);
      return;
    }
    b(paramQidianExternalInfo, paramQidianInternalInfo, paramQidianCorpInfo, paramQidianProfileUiInfo);
  }
  
  public void a(QidianExternalInfo paramQidianExternalInfo, QidianProfileUiInfo paramQidianProfileUiInfo)
  {
    if (paramQidianExternalInfo != null) {
      this.oV.put(paramQidianExternalInfo.uin, paramQidianExternalInfo);
    }
    if (paramQidianProfileUiInfo != null) {
      this.oY.put(paramQidianProfileUiInfo.uin, paramQidianProfileUiInfo);
    }
    if (aurs.aJC())
    {
      ThreadManager.post(new QidianManager.8(this, paramQidianExternalInfo, paramQidianProfileUiInfo), 5, null, true);
      return;
    }
    b(paramQidianExternalInfo, paramQidianProfileUiInfo);
  }
  
  public void a(String paramString1, int paramInt1, boolean paramBoolean, double paramDouble1, double paramDouble2, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    ((ashy)this.app.getBusinessHandler(85)).b(paramString1, paramInt1, paramBoolean, 0.0D, 0.0D, paramString2, paramInt2, paramString3, paramString4, paramString5);
  }
  
  public boolean a(Context paramContext, BmqqAccountType paramBmqqAccountType)
  {
    if (paramBmqqAccountType == null) {}
    for (;;)
    {
      return false;
      paramContext = paramBmqqAccountType.getUin();
      try
      {
        long l = Long.parseLong(paramContext);
        if (jou.de(paramContext))
        {
          switch (paramBmqqAccountType.getAccountType())
          {
          default: 
            return false;
          case 1: 
            ((ashy)this.app.getBusinessHandler(85)).mv(l);
            return true;
          }
          ((ashy)this.app.getBusinessHandler(85)).mx(l);
          return true;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public String as(Context paramContext, String paramString)
  {
    paramString = qV(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return String.format(paramContext.getString(2131700713), new Object[] { paramString });
    }
    return paramContext.getString(2131700712);
  }
  
  public boolean b(Context paramContext, BmqqAccountType paramBmqqAccountType)
  {
    if (paramBmqqAccountType == null) {}
    for (;;)
    {
      return false;
      paramContext = paramBmqqAccountType.getUin();
      try
      {
        long l = Long.parseLong(paramContext);
        if (jou.de(paramContext))
        {
          switch (paramBmqqAccountType.getAccountType())
          {
          case 3: 
          case 4: 
          case 5: 
          default: 
            return false;
          case 0: 
          case 2: 
            ((jor)this.app.getBusinessHandler(37)).kV(paramContext);
            return true;
          case 1: 
            ((ashy)this.app.getBusinessHandler(85)).mu(l);
            return true;
          }
          ((ashy)this.app.getBusinessHandler(85)).mw(l);
          return true;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  public void bs(String paramString1, String paramString2, String paramString3)
  {
    String str = "";
    if (paramString2.equals("1")) {
      paramString2 = str;
    }
    for (;;)
    {
      ((ashy)this.app.getBusinessHandler(85)).bs(paramString1, paramString2, paramString3);
      return;
      if (paramString2.equals("2"))
      {
        paramString2 = paramString3;
        paramString3 = "";
      }
      else
      {
        paramString3 = "";
        paramString2 = str;
      }
    }
  }
  
  public void c(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    Object localObject2;
    FragmentActivity localFragmentActivity;
    do
    {
      do
      {
        return;
        localObject1 = String.valueOf(paramLong);
        localObject2 = anre.a(paramString.getBytes(), 0);
      } while ((localObject2 == null) || ((!(BaseActivity.sTopActivity instanceof SplashActivity)) && (!(BaseActivity.sTopActivity instanceof ChatActivity))));
      localFragmentActivity = (FragmentActivity)BaseActivity.sTopActivity;
    } while ((localFragmentActivity.getChatFragment() == null) || (!localFragmentActivity.getChatFragment().b.sessionInfo.aTl.equals(localObject1)));
    paramString = (MessageForStructing)anbi.d(-2011);
    paramString.msgtype = -2011;
    paramString.istroop = localFragmentActivity.getChatFragment().b.sessionInfo.cZ;
    paramString.issend = 0;
    paramString.isread = true;
    paramString.selfuin = paramQQAppInterface.getCurrentAccountUin();
    paramString.mIsParsed = true;
    paramString.frienduin = ((String)localObject1);
    paramString.senderuin = ((String)localObject1);
    paramString.structingMsg = ((AbsStructMsg)localObject2);
    paramString.msgData = ((AbsStructMsg)localObject2).getBytes();
    paramString.saveExtInfoToExtStr("is_eman_sc_message", "1");
    if (this.pc.get(localObject1) == null)
    {
      localObject2 = new ArrayList();
      ((List)localObject2).add(paramString);
      this.pc.put(localObject1, localObject2);
    }
    for (;;)
    {
      localObject1 = new ArrayList();
      if (achp.a(paramQQAppInterface, paramString, false)) {
        break;
      }
      ((ArrayList)localObject1).add(paramString);
      paramQQAppInterface.b().t((List)localObject1, String.valueOf(paramQQAppInterface.getCurrentAccountUin()));
      return;
      ((List)this.pc.get(localObject1)).add(paramString);
    }
  }
  
  public void c(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5)
  {
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(paramString3)) {
        break label31;
      }
    }
    for (;;)
    {
      o(paramString4, 1, paramInt, paramString5);
      return;
      paramString3 = paramString2;
      break;
      label31:
      paramString4 = paramString3;
    }
  }
  
  public void dI(String paramString, boolean paramBoolean)
  {
    if ((!jou.al.get()) || (jou.z(null, paramString))) {
      ((CardHandler)this.app.getBusinessHandler(2)).bz(paramString, paramBoolean);
    }
  }
  
  public int fH(String paramString)
  {
    return ((Integer)this.oU.get(paramString)).intValue();
  }
  
  public int g(String paramString, QQAppInterface paramQQAppInterface)
  {
    int i = 1;
    if (!m(paramString, paramQQAppInterface)) {
      i = 5;
    }
    do
    {
      return i;
      if (sM(paramString)) {
        return 6;
      }
      if (jqs.d(paramQQAppInterface, paramString, 0)) {
        return 3;
      }
    } while (sH(paramString));
    if (P(paramString, true)) {
      return 0;
    }
    return 4;
  }
  
  public void gC(String paramString, int paramInt)
  {
    Object localObject = (List)this.pc.get(paramString);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord != null) && (paramInt == localMessageRecord.istroop)) {
          ((QQAppInterface)this.app).b().t(paramString, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
    }
  }
  
  public void iM(String paramString1, String paramString2)
  {
    if (this.pa.containsKey(paramString1)) {}
    for (QidianPAForWpa localQidianPAForWpa = (QidianPAForWpa)this.pa.get(paramString1);; localQidianPAForWpa = new QidianPAForWpa())
    {
      localQidianPAForWpa.puin = paramString1;
      localQidianPAForWpa.kfuin = paramString2;
      this.pa.put(paramString1, localQidianPAForWpa);
      if (!aurs.aJC()) {
        break;
      }
      ThreadManager.post(new QidianManager.6(this, localQidianPAForWpa, paramString1, paramString2), 5, null, true);
      return;
    }
    a(localQidianPAForWpa, paramString1, paramString2);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 4, "onDestroyd ...");
    }
    if (this.oU != null) {
      this.oU.clear();
    }
    if (this.oV != null) {
      this.oV.clear();
    }
    if (this.oW != null) {
      this.oW.clear();
    }
    if (this.oX != null) {
      this.oX.clear();
    }
    if (this.oY != null) {
      this.oY.clear();
    }
    if (this.oZ != null) {
      this.oZ.clear();
    }
    if (this.pa != null) {
      this.pa.clear();
    }
    if (this.pb != null) {
      this.pb.clear();
    }
    if (this.pc != null) {
      this.pc.clear();
    }
    if (this.JP != null) {
      this.JP.clear();
    }
    eA.set(false);
  }
  
  public String qW(String paramString)
  {
    if (this.oV.containsKey(paramString))
    {
      paramString = (QidianExternalInfo)this.oV.get(paramString);
      if (paramString != null) {
        return paramString.masterUin;
      }
    }
    return "";
  }
  
  public String qX(String paramString)
  {
    paramString = (QidianPAForWpa)this.pa.get(paramString);
    if (paramString != null) {
      return paramString.kfuin;
    }
    return null;
  }
  
  public boolean sH(String paramString)
  {
    return Q(paramString, true);
  }
  
  public boolean sI(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.oV.containsKey(paramString))
    {
      paramString = (QidianExternalInfo)this.oV.get(paramString);
      bool1 = bool2;
      if (paramString != null) {
        if (paramString.isShowCall != 1) {
          break label49;
        }
      }
    }
    label49:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean sJ(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.oV.containsKey(paramString))
    {
      paramString = (QidianExternalInfo)this.oV.get(paramString);
      bool1 = bool2;
      if (paramString != null) {
        if (paramString.isShowVideoCall != 1) {
          break label49;
        }
      }
    }
    label49:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public boolean sK(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(qW(paramString)))
    {
      bool1 = bool2;
      if (sI(paramString)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean sL(String paramString)
  {
    try
    {
      Long.parseLong(paramString);
      if ((this.oU.containsKey(paramString)) && (((Integer)this.oU.get(paramString)).intValue() == 3)) {
        return true;
      }
    }
    catch (Exception paramString)
    {
      return false;
    }
    return false;
  }
  
  public boolean sM(String paramString)
  {
    return R(paramString, true);
  }
  
  public boolean sN(String paramString)
  {
    return this.oU.containsKey(paramString);
  }
  
  public static abstract interface a
  {
    public abstract void UD(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asgx
 * JD-Core Version:    0.7.0.1
 */