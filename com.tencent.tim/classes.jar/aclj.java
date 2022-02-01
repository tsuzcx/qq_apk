import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.manager.Manager;

public class aclj
  implements Manager
{
  public static boolean bJm;
  private final int TYPE_GROUP = 10000;
  private final int TYPE_OTHER = 10001;
  private QQAppInterface app;
  private EntityManager em;
  
  public aclj(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.em = paramQQAppInterface.a().createEntityManager();
  }
  
  public static void Q(QQAppInterface paramQQAppInterface, String paramString)
  {
    bJm = true;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putString("search_keyword" + paramQQAppInterface.getCurrentAccountUin(), paramString);
    localEditor.commit();
  }
  
  private boolean b(SearchHistory paramSearchHistory)
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.app.getManager(11);
    if (localPhoneContactManagerImp.Uv()) {
      return true;
    }
    paramSearchHistory = localPhoneContactManagerImp.c(paramSearchHistory.uin);
    if (paramSearchHistory == null) {
      return true;
    }
    return TextUtils.isEmpty(paramSearchHistory.uin);
  }
  
  private boolean c(SearchHistory paramSearchHistory)
  {
    Object localObject = (acff)this.app.getManager(51);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((acff)localObject).isFriend(paramSearchHistory.uin)) {
        bool1 = true;
      }
    }
    if (paramSearchHistory.type == 1000)
    {
      localObject = (TroopManager)this.app.getManager(52);
      if (((TroopManager)localObject).b(((TroopManager)localObject).jq(paramSearchHistory.troopUin), paramSearchHistory.uin) != null) {}
    }
    else
    {
      do
      {
        return true;
        if (paramSearchHistory.type != 1004) {
          break;
        }
        paramSearchHistory = ((acdu)this.app.getManager(53)).a(paramSearchHistory.troopUin);
      } while ((paramSearchHistory == null) || (paramSearchHistory.isDiscussHrMeeting()) || (paramSearchHistory.isHidden()));
    }
    return bool1;
  }
  
  private String hd(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    acff localacff = (acff)this.app.getManager(51);
    paramString = localacff.e(paramString);
    if (paramString != null)
    {
      paramString = localacff.a(paramString.groupid + "");
      if (paramString == null) {}
    }
    for (paramString = paramString.group_name;; paramString = null) {
      return paramString;
    }
  }
  
  public static String q(QQAppInterface paramQQAppInterface)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getString("search_keyword" + paramQQAppInterface.getCurrentAccountUin(), "");
  }
  
  /* Error */
  public void a(SearchHistory paramSearchHistory)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: putfield 188	com/tencent/mobileqq/data/SearchHistory:count	I
    //   5: aload_1
    //   6: invokestatic 194	java/lang/System:currentTimeMillis	()J
    //   9: putfield 198	com/tencent/mobileqq/data/SearchHistory:time	J
    //   12: aload_1
    //   13: getfield 128	com/tencent/mobileqq/data/SearchHistory:type	I
    //   16: lookupswitch	default:+124->140, 0:+125->141, 1:+272->288, 1000:+389->405, 1004:+428->444, 1006:+350->366, 1008:+506->522, 1021:+467->483, 3000:+311->327, 7220:+558->574, 56938:+350->366, 56939:+350->366, 56940:+350->366, 56941:+350->366, 56942:+350->366
    //   141: aload_1
    //   142: aload_0
    //   143: aload_1
    //   144: getfield 106	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   147: invokespecial 200	aclj:hd	(Ljava/lang/String;)Ljava/lang/String;
    //   150: putfield 203	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   153: aload_1
    //   154: getfield 203	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   157: ifnonnull +12 -> 169
    //   160: aload_1
    //   161: ldc 204
    //   163: invokestatic 210	acfp:m	(I)Ljava/lang/String;
    //   166: putfield 203	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   169: aload_1
    //   170: new 65	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   177: aload_1
    //   178: getfield 106	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   181: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: sipush 10001
    //   187: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: putfield 213	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   196: aload_0
    //   197: getfield 40	aclj:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   200: ldc 102
    //   202: aload_1
    //   203: getfield 213	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   206: invokevirtual 219	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   209: checkcast 102	com/tencent/mobileqq/data/SearchHistory
    //   212: astore_2
    //   213: aload_2
    //   214: ifnull +399 -> 613
    //   217: aload_2
    //   218: aload_1
    //   219: getfield 198	com/tencent/mobileqq/data/SearchHistory:time	J
    //   222: putfield 198	com/tencent/mobileqq/data/SearchHistory:time	J
    //   225: aload_2
    //   226: aload_2
    //   227: getfield 188	com/tencent/mobileqq/data/SearchHistory:count	I
    //   230: iconst_1
    //   231: iadd
    //   232: putfield 188	com/tencent/mobileqq/data/SearchHistory:count	I
    //   235: aload_2
    //   236: getfield 128	com/tencent/mobileqq/data/SearchHistory:type	I
    //   239: aload_1
    //   240: getfield 128	com/tencent/mobileqq/data/SearchHistory:type	I
    //   243: if_icmpeq +35 -> 278
    //   246: aload_2
    //   247: aload_1
    //   248: getfield 203	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   251: putfield 203	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   254: aload_2
    //   255: aload_1
    //   256: getfield 128	com/tencent/mobileqq/data/SearchHistory:type	I
    //   259: putfield 128	com/tencent/mobileqq/data/SearchHistory:type	I
    //   262: aload_2
    //   263: aload_1
    //   264: getfield 133	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   267: putfield 133	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   270: aload_2
    //   271: aload_1
    //   272: getfield 222	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   275: putfield 222	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   278: aload_0
    //   279: getfield 40	aclj:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   282: aload_2
    //   283: invokevirtual 226	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   286: pop
    //   287: return
    //   288: aload_1
    //   289: ldc 227
    //   291: invokestatic 210	acfp:m	(I)Ljava/lang/String;
    //   294: putfield 203	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   297: aload_1
    //   298: new 65	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   305: aload_1
    //   306: getfield 106	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   309: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: sipush 10000
    //   315: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: putfield 213	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   324: goto -128 -> 196
    //   327: aload_1
    //   328: ldc 228
    //   330: invokestatic 210	acfp:m	(I)Ljava/lang/String;
    //   333: putfield 203	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   336: aload_1
    //   337: new 65	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   344: aload_1
    //   345: getfield 106	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   348: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: sipush 10000
    //   354: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: putfield 213	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   363: goto -167 -> 196
    //   366: aload_1
    //   367: ldc 229
    //   369: invokestatic 210	acfp:m	(I)Ljava/lang/String;
    //   372: putfield 203	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   375: aload_1
    //   376: new 65	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   383: aload_1
    //   384: getfield 106	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   387: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: sipush 10001
    //   393: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   396: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: putfield 213	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   402: goto -206 -> 196
    //   405: aload_1
    //   406: ldc 230
    //   408: invokestatic 210	acfp:m	(I)Ljava/lang/String;
    //   411: putfield 203	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   414: aload_1
    //   415: new 65	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   422: aload_1
    //   423: getfield 106	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   426: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: sipush 10001
    //   432: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   435: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: putfield 213	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   441: goto -245 -> 196
    //   444: aload_1
    //   445: ldc 231
    //   447: invokestatic 210	acfp:m	(I)Ljava/lang/String;
    //   450: putfield 203	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   453: aload_1
    //   454: new 65	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   461: aload_1
    //   462: getfield 106	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   465: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: sipush 10001
    //   471: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   474: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: putfield 213	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   480: goto -284 -> 196
    //   483: aload_1
    //   484: ldc 232
    //   486: invokestatic 210	acfp:m	(I)Ljava/lang/String;
    //   489: putfield 203	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   492: aload_1
    //   493: new 65	java/lang/StringBuilder
    //   496: dup
    //   497: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   500: aload_1
    //   501: getfield 106	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   504: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: sipush 10001
    //   510: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   513: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: putfield 213	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   519: goto -323 -> 196
    //   522: aload_1
    //   523: getfield 106	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   526: getstatic 237	acbn:blw	Ljava/lang/String;
    //   529: invokestatic 241	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   532: ifeq -336 -> 196
    //   535: aload_1
    //   536: ldc 242
    //   538: invokestatic 210	acfp:m	(I)Ljava/lang/String;
    //   541: putfield 203	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   544: aload_1
    //   545: new 65	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   552: aload_1
    //   553: getfield 106	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   556: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: sipush 10001
    //   562: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   565: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: putfield 213	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   571: goto -375 -> 196
    //   574: aload_1
    //   575: ldc 243
    //   577: invokestatic 210	acfp:m	(I)Ljava/lang/String;
    //   580: putfield 203	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   583: aload_1
    //   584: new 65	java/lang/StringBuilder
    //   587: dup
    //   588: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   591: aload_1
    //   592: getfield 106	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   595: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: sipush 10001
    //   601: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   604: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: putfield 213	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   610: goto -414 -> 196
    //   613: aload_0
    //   614: getfield 40	aclj:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   617: iconst_0
    //   618: ldc 102
    //   620: invokevirtual 248	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   623: aconst_null
    //   624: aconst_null
    //   625: aconst_null
    //   626: aconst_null
    //   627: aconst_null
    //   628: ldc 250
    //   630: aconst_null
    //   631: invokevirtual 254	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   634: astore_3
    //   635: aload_3
    //   636: ifnull +174 -> 810
    //   639: aload_3
    //   640: astore_2
    //   641: iconst_5
    //   642: aload_3
    //   643: invokeinterface 260 1 0
    //   648: if_icmpgt +162 -> 810
    //   651: aload_3
    //   652: astore_2
    //   653: aload_3
    //   654: invokeinterface 263 1 0
    //   659: ifeq +140 -> 799
    //   662: aload_3
    //   663: astore_2
    //   664: aload_3
    //   665: aload_3
    //   666: ldc_w 264
    //   669: invokeinterface 268 2 0
    //   674: invokeinterface 270 2 0
    //   679: astore 4
    //   681: aload_3
    //   682: astore_2
    //   683: aload_0
    //   684: getfield 40	aclj:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   687: ldc 102
    //   689: aload 4
    //   691: invokevirtual 219	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   694: checkcast 102	com/tencent/mobileqq/data/SearchHistory
    //   697: astore 4
    //   699: aload_3
    //   700: astore_2
    //   701: aload 4
    //   703: aload_1
    //   704: getfield 213	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   707: putfield 213	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   710: aload_3
    //   711: astore_2
    //   712: aload 4
    //   714: aload_1
    //   715: getfield 106	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   718: putfield 106	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   721: aload_3
    //   722: astore_2
    //   723: aload 4
    //   725: aload_1
    //   726: getfield 133	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   729: putfield 133	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   732: aload_3
    //   733: astore_2
    //   734: aload 4
    //   736: aload_1
    //   737: getfield 198	com/tencent/mobileqq/data/SearchHistory:time	J
    //   740: putfield 198	com/tencent/mobileqq/data/SearchHistory:time	J
    //   743: aload_3
    //   744: astore_2
    //   745: aload 4
    //   747: aload_1
    //   748: getfield 222	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   751: putfield 222	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   754: aload_3
    //   755: astore_2
    //   756: aload 4
    //   758: aload_1
    //   759: getfield 128	com/tencent/mobileqq/data/SearchHistory:type	I
    //   762: putfield 128	com/tencent/mobileqq/data/SearchHistory:type	I
    //   765: aload_3
    //   766: astore_2
    //   767: aload 4
    //   769: aload_1
    //   770: getfield 188	com/tencent/mobileqq/data/SearchHistory:count	I
    //   773: putfield 188	com/tencent/mobileqq/data/SearchHistory:count	I
    //   776: aload_3
    //   777: astore_2
    //   778: aload 4
    //   780: aload_1
    //   781: getfield 203	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   784: putfield 203	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   787: aload_3
    //   788: astore_2
    //   789: aload_0
    //   790: getfield 40	aclj:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   793: aload 4
    //   795: invokevirtual 226	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   798: pop
    //   799: aload_3
    //   800: ifnull -660 -> 140
    //   803: aload_3
    //   804: invokeinterface 273 1 0
    //   809: return
    //   810: aload_3
    //   811: astore_2
    //   812: aload_0
    //   813: getfield 40	aclj:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   816: aload_1
    //   817: invokevirtual 277	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   820: goto -21 -> 799
    //   823: astore_1
    //   824: aload_3
    //   825: astore_2
    //   826: aload_1
    //   827: invokevirtual 280	java/lang/Exception:printStackTrace	()V
    //   830: aload_3
    //   831: ifnull -691 -> 140
    //   834: aload_3
    //   835: invokeinterface 273 1 0
    //   840: return
    //   841: astore_1
    //   842: aconst_null
    //   843: astore_2
    //   844: aload_2
    //   845: ifnull +9 -> 854
    //   848: aload_2
    //   849: invokeinterface 273 1 0
    //   854: aload_1
    //   855: athrow
    //   856: astore_1
    //   857: goto -13 -> 844
    //   860: astore_1
    //   861: aconst_null
    //   862: astore_3
    //   863: goto -39 -> 824
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	866	0	this	aclj
    //   0	866	1	paramSearchHistory	SearchHistory
    //   212	637	2	localObject1	Object
    //   634	229	3	localCursor	android.database.Cursor
    //   679	115	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   641	651	823	java/lang/Exception
    //   653	662	823	java/lang/Exception
    //   664	681	823	java/lang/Exception
    //   683	699	823	java/lang/Exception
    //   701	710	823	java/lang/Exception
    //   712	721	823	java/lang/Exception
    //   723	732	823	java/lang/Exception
    //   734	743	823	java/lang/Exception
    //   745	754	823	java/lang/Exception
    //   756	765	823	java/lang/Exception
    //   767	776	823	java/lang/Exception
    //   778	787	823	java/lang/Exception
    //   789	799	823	java/lang/Exception
    //   812	820	823	java/lang/Exception
    //   613	635	841	finally
    //   641	651	856	finally
    //   653	662	856	finally
    //   664	681	856	finally
    //   683	699	856	finally
    //   701	710	856	finally
    //   712	721	856	finally
    //   723	732	856	finally
    //   734	743	856	finally
    //   745	754	856	finally
    //   756	765	856	finally
    //   767	776	856	finally
    //   778	787	856	finally
    //   789	799	856	finally
    //   812	820	856	finally
    //   826	830	856	finally
    //   613	635	860	java/lang/Exception
  }
  
  boolean a(SearchHistory paramSearchHistory)
  {
    boolean bool2 = true;
    TroopManager localTroopManager = (TroopManager)this.app.getManager(52);
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.app.getManager(11);
    boolean bool1 = bool2;
    switch (paramSearchHistory.type)
    {
    default: 
      bool1 = false;
    case 1021: 
    case 0: 
    case 1000: 
    case 1004: 
    case 1: 
    case 3000: 
    case 1008: 
    case 7220: 
    case 56940: 
    case 56941: 
      label146:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return bool1;
                  if (((acff)this.app.getManager(51)).isFriend(paramSearchHistory.uin)) {
                    break;
                  }
                  return true;
                  return c(paramSearchHistory);
                  if (localTroopManager.b(paramSearchHistory.uin) != null) {
                    break;
                  }
                  return true;
                  paramSearchHistory = ((acdu)this.app.getManager(53)).a(paramSearchHistory.uin);
                  bool1 = bool2;
                } while (paramSearchHistory == null);
                if (!paramSearchHistory.isHidden()) {
                  break;
                }
                return true;
                bool1 = bool2;
              } while (!TextUtils.equals(paramSearchHistory.uin, acbn.blw));
              bool1 = bool2;
            } while (awit.cA(this.app));
            paramSearchHistory.displayName = obt.b(this.app, BaseApplicationImpl.getContext());
            return false;
            bool1 = bool2;
          } while (!awit.cA(this.app));
          bool1 = bool2;
        } while (awit.Vs());
        paramSearchHistory.displayName = obt.c(this.app, BaseApplicationImpl.getContext());
        return false;
        return b(paramSearchHistory);
        bool1 = bool2;
      } while (!localPhoneContactManagerImp.Uv());
      paramSearchHistory = localPhoneContactManagerImp.c(paramSearchHistory.uin);
      if ((paramSearchHistory != null) && ("0".equals(paramSearchHistory.uin))) {
        break;
      }
    }
    for (bool1 = true;; bool1 = false)
    {
      return bool1;
      paramSearchHistory = localPhoneContactManagerImp.c(paramSearchHistory.uin);
      bool1 = bool2;
      if (paramSearchHistory == null) {
        break label146;
      }
      bool1 = bool2;
      if (TextUtils.isEmpty(paramSearchHistory.uin)) {
        break label146;
      }
      if (!"0".equals(paramSearchHistory.uin)) {
        break;
      }
      return true;
      paramSearchHistory = localPhoneContactManagerImp.c(paramSearchHistory.uin);
      if (paramSearchHistory == null) {
        break;
      }
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramSearchHistory.uin)) {
        break label146;
      }
      return false;
    }
  }
  
  /* Error */
  public java.util.ArrayList<SearchHistory> cC()
  {
    // Byte code:
    //   0: new 317	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 318	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: getfield 40	aclj:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   13: iconst_0
    //   14: ldc 102
    //   16: invokevirtual 248	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: ldc_w 320
    //   27: aconst_null
    //   28: invokevirtual 254	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull +267 -> 300
    //   36: aload_3
    //   37: invokeinterface 263 1 0
    //   42: ifeq +258 -> 300
    //   45: iconst_0
    //   46: istore_1
    //   47: new 102	com/tencent/mobileqq/data/SearchHistory
    //   50: dup
    //   51: invokespecial 321	com/tencent/mobileqq/data/SearchHistory:<init>	()V
    //   54: astore 5
    //   56: aload 5
    //   58: aload_3
    //   59: aload_3
    //   60: ldc_w 264
    //   63: invokeinterface 268 2 0
    //   68: invokeinterface 270 2 0
    //   73: putfield 213	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   76: aload 5
    //   78: aload_3
    //   79: aload_3
    //   80: ldc_w 322
    //   83: invokeinterface 268 2 0
    //   88: invokeinterface 270 2 0
    //   93: putfield 222	com/tencent/mobileqq/data/SearchHistory:displayName	Ljava/lang/String;
    //   96: aload 5
    //   98: aload_3
    //   99: aload_3
    //   100: ldc_w 323
    //   103: invokeinterface 268 2 0
    //   108: invokeinterface 270 2 0
    //   113: putfield 106	com/tencent/mobileqq/data/SearchHistory:uin	Ljava/lang/String;
    //   116: aload 5
    //   118: aload_3
    //   119: aload_3
    //   120: ldc_w 324
    //   123: invokeinterface 268 2 0
    //   128: invokeinterface 270 2 0
    //   133: putfield 133	com/tencent/mobileqq/data/SearchHistory:troopUin	Ljava/lang/String;
    //   136: aload 5
    //   138: aload_3
    //   139: aload_3
    //   140: ldc_w 325
    //   143: invokeinterface 268 2 0
    //   148: invokeinterface 329 2 0
    //   153: putfield 128	com/tencent/mobileqq/data/SearchHistory:type	I
    //   156: aload 5
    //   158: aload_3
    //   159: aload_3
    //   160: ldc_w 330
    //   163: invokeinterface 268 2 0
    //   168: invokeinterface 270 2 0
    //   173: putfield 203	com/tencent/mobileqq/data/SearchHistory:extralInfo	Ljava/lang/String;
    //   176: aload 5
    //   178: aload_3
    //   179: aload_3
    //   180: ldc_w 331
    //   183: invokeinterface 268 2 0
    //   188: invokeinterface 329 2 0
    //   193: putfield 188	com/tencent/mobileqq/data/SearchHistory:count	I
    //   196: aload 5
    //   198: aload_3
    //   199: aload_3
    //   200: ldc_w 332
    //   203: invokeinterface 268 2 0
    //   208: invokeinterface 336 2 0
    //   213: putfield 198	com/tencent/mobileqq/data/SearchHistory:time	J
    //   216: aload 5
    //   218: aload_3
    //   219: aload_3
    //   220: ldc_w 338
    //   223: invokeinterface 268 2 0
    //   228: invokeinterface 329 2 0
    //   233: i2l
    //   234: invokevirtual 342	com/tencent/mobileqq/data/SearchHistory:setId	(J)V
    //   237: aload_0
    //   238: aload 5
    //   240: invokevirtual 344	aclj:a	(Lcom/tencent/mobileqq/data/SearchHistory;)Z
    //   243: istore_2
    //   244: iload_1
    //   245: iconst_5
    //   246: if_icmplt +5 -> 251
    //   249: iconst_1
    //   250: istore_2
    //   251: iload_2
    //   252: ifeq +61 -> 313
    //   255: aload_0
    //   256: getfield 40	aclj:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   259: ldc 102
    //   261: aload 5
    //   263: getfield 213	com/tencent/mobileqq/data/SearchHistory:key	Ljava/lang/String;
    //   266: invokevirtual 219	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   269: checkcast 102	com/tencent/mobileqq/data/SearchHistory
    //   272: astore 5
    //   274: aload 5
    //   276: ifnull +13 -> 289
    //   279: aload_0
    //   280: getfield 40	aclj:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   283: aload 5
    //   285: invokevirtual 347	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   288: pop
    //   289: aload_3
    //   290: invokeinterface 350 1 0
    //   295: istore_2
    //   296: iload_2
    //   297: ifne +75 -> 372
    //   300: aload_3
    //   301: ifnull +9 -> 310
    //   304: aload_3
    //   305: invokeinterface 273 1 0
    //   310: aload 4
    //   312: areturn
    //   313: iload_1
    //   314: iconst_5
    //   315: if_icmpge -26 -> 289
    //   318: aload 4
    //   320: aload 5
    //   322: invokevirtual 353	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   325: pop
    //   326: goto -37 -> 289
    //   329: astore 5
    //   331: aload_3
    //   332: ifnull -22 -> 310
    //   335: aload_3
    //   336: invokeinterface 273 1 0
    //   341: aload 4
    //   343: areturn
    //   344: astore 4
    //   346: aconst_null
    //   347: astore_3
    //   348: aload_3
    //   349: ifnull +9 -> 358
    //   352: aload_3
    //   353: invokeinterface 273 1 0
    //   358: aload 4
    //   360: athrow
    //   361: astore 4
    //   363: goto -15 -> 348
    //   366: astore_3
    //   367: aconst_null
    //   368: astore_3
    //   369: goto -38 -> 331
    //   372: iload_1
    //   373: iconst_1
    //   374: iadd
    //   375: istore_1
    //   376: goto -329 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	aclj
    //   46	330	1	i	int
    //   243	54	2	bool	boolean
    //   31	322	3	localCursor	android.database.Cursor
    //   366	1	3	localException1	java.lang.Exception
    //   368	1	3	localObject1	Object
    //   7	335	4	localArrayList	java.util.ArrayList
    //   344	15	4	localObject2	Object
    //   361	1	4	localObject3	Object
    //   54	267	5	localSearchHistory	SearchHistory
    //   329	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   36	45	329	java/lang/Exception
    //   47	244	329	java/lang/Exception
    //   255	274	329	java/lang/Exception
    //   279	289	329	java/lang/Exception
    //   289	296	329	java/lang/Exception
    //   318	326	329	java/lang/Exception
    //   9	32	344	finally
    //   36	45	361	finally
    //   47	244	361	finally
    //   255	274	361	finally
    //   279	289	361	finally
    //   289	296	361	finally
    //   318	326	361	finally
    //   9	32	366	java/lang/Exception
  }
  
  public boolean d(SearchHistory paramSearchHistory)
  {
    boolean bool = false;
    if (paramSearchHistory != null)
    {
      paramSearchHistory.setStatus(1001);
      bool = this.em.remove(paramSearchHistory);
    }
    return bool;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aclj
 * JD-Core Version:    0.7.0.1
 */