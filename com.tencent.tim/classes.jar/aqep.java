import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.nearby.picbrowser.NearbyProfilePicBrowserActivity;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.util.ProfileCardUtil.1;
import com.tencent.mobileqq.util.ProfileCardUtil.2;
import com.tencent.mobileqq.util.ProfileCardUtil.3;
import com.tencent.mobileqq.util.ProfileCardUtil.4;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class aqep
{
  public static ArrayList<alcs> CH = new ArrayList();
  public static StringBuilder X;
  private static long asA;
  protected static long asB;
  public static String bec = "";
  private static boolean cTL;
  private static String csu;
  public static int dYP;
  public static int dYQ = 1;
  public static int dYR = 2;
  public static int dYS = 3;
  public static int dYT = 4;
  private static final String[] hL = { "AT", "BE", "BG", "HR", "CY", "CZ", "DK", "EE", "FI", "FR", "DE", "GR", "HU", "IE", "IT", "LV", "LT", "LU", "MT", "NL", "PL", "PT", "RO", "SK", "SI", "ES", "SE", "GB", "US" };
  protected static HashMap<String, String> oM;
  
  public static String BR()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CardHandler.bnU).append("temp").append("/").append(System.currentTimeMillis()).append("_portrait.tmp");
    return aqul.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String BS()
  {
    return csu;
  }
  
  public static String BT()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CardHandler.bnU).append("temp").append("/").append(System.currentTimeMillis()).append("_cardbg.tmp");
    return aqul.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String H(QQAppInterface paramQQAppInterface)
  {
    Calendar localCalendar = Calendar.getInstance();
    StringBuilder localStringBuilder = new StringBuilder(acbn.bnh);
    localStringBuilder.append("IMG");
    localStringBuilder.append(localCalendar.get(1));
    int i = localCalendar.get(2) + 1;
    if (i < 10)
    {
      paramQQAppInterface = "0" + i;
      localStringBuilder.append(paramQQAppInterface);
      i = localCalendar.get(5);
      if (i >= 10) {
        break label300;
      }
      paramQQAppInterface = "0" + i;
      label108:
      localStringBuilder.append(paramQQAppInterface);
      i = localCalendar.get(11);
      if (i >= 10) {
        break label308;
      }
      paramQQAppInterface = "0" + i;
      label148:
      localStringBuilder.append(paramQQAppInterface);
      i = localCalendar.get(12);
      if (i >= 10) {
        break label316;
      }
      paramQQAppInterface = "0" + i;
      label188:
      localStringBuilder.append(paramQQAppInterface);
      i = localCalendar.get(13);
      if (i >= 10) {
        break label324;
      }
    }
    label300:
    label308:
    label316:
    label324:
    for (paramQQAppInterface = "0" + i;; paramQQAppInterface = Integer.valueOf(i))
    {
      localStringBuilder.append(paramQQAppInterface);
      if (new File(localStringBuilder.toString() + ".jpg").exists()) {
        break label332;
      }
      return localStringBuilder.toString() + ".jpg";
      paramQQAppInterface = Integer.valueOf(i);
      break;
      paramQQAppInterface = Integer.valueOf(i);
      break label108;
      paramQQAppInterface = Integer.valueOf(i);
      break label148;
      paramQQAppInterface = Integer.valueOf(i);
      break label188;
    }
    label332:
    paramQQAppInterface = new StringBuilder(localStringBuilder);
    int j = localStringBuilder.length();
    i = 1;
    for (;;)
    {
      if (i < 2147483647)
      {
        paramQQAppInterface.append('(');
        paramQQAppInterface.append(i);
        paramQQAppInterface.append(')');
        paramQQAppInterface.append(".jpg");
        if (new File(paramQQAppInterface.toString()).exists()) {}
      }
      else
      {
        return paramQQAppInterface.toString();
      }
      paramQQAppInterface.delete(j, paramQQAppInterface.length());
      i += 1;
    }
  }
  
  public static String I(Context paramContext, String paramString)
  {
    return aY(paramContext) + pi(paramString);
  }
  
  public static void I(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("uin", paramString2);
    paramContext.startActivity(localIntent);
  }
  
  public static boolean P(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    return paramArrayList.contains(Integer.valueOf(2));
  }
  
  public static boolean Q(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    return paramArrayList.contains(Integer.valueOf(1));
  }
  
  public static boolean R(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    return paramArrayList.contains(Integer.valueOf(3));
  }
  
  public static boolean S(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    while ((!Q(paramArrayList)) && (!R(paramArrayList)) && (!P(paramArrayList))) {
      return false;
    }
    return true;
  }
  
  public static String T(int paramInt1, int paramInt2)
  {
    aqss localaqss = aqss.a;
    switch (paramInt2)
    {
    default: 
      return "_";
    case 0: 
      return localaqss.getDir(BaseApplicationImpl.getApplication(), localaqss.getScid(paramInt1)) + "/half.png";
    case 1: 
      return localaqss.getDir(BaseApplicationImpl.getApplication(), localaqss.getScid(paramInt1)) + "/star.png";
    case 2: 
      return localaqss.getDir(BaseApplicationImpl.getApplication(), localaqss.getScid(paramInt1)) + "/moon.png";
    case 3: 
      return localaqss.getDir(BaseApplicationImpl.getApplication(), localaqss.getScid(paramInt1)) + "/sun.png";
    case 4: 
      return localaqss.getDir(BaseApplicationImpl.getApplication(), localaqss.getScid(paramInt1)) + "/crown.png";
    }
    return localaqss.getDir(BaseApplicationImpl.getApplication(), localaqss.getScid(paramInt1)) + "/more.png";
  }
  
  public static boolean T(ArrayList<Integer> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    while ((!Q(paramArrayList)) && (!R(paramArrayList))) {
      return false;
    }
    return true;
  }
  
  public static void Us(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.Avatar", 2, "setTempAvatarFilePath|false");
      }
      cTL = false;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "setTempAvatarFilePath|true");
    }
    csu = paramString;
    cTL = true;
  }
  
  public static void Ut(String paramString)
  {
    if (oM != null) {
      oM.remove(paramString);
    }
  }
  
  public static void Uu(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new ProfileCardUtil.2(paramString));
  }
  
  public static boolean Z(@NonNull QQAppInterface paramQQAppInterface, String paramString)
  {
    if (aqvl.e(paramQQAppInterface, "show_diy_template_guide_for_guest_time", 0) >= 3) {}
    long l;
    do
    {
      return false;
      l = paramQQAppInterface.getApp().getSharedPreferences("diy_guest_tip_show_list", 0).getLong(paramQQAppInterface.getCurrentAccountUin() + "_" + paramString, 0L);
    } while (System.currentTimeMillis() - l < 86400000L);
    return true;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, ProfileActivity.AllInOne paramAllInOne)
  {
    if ((paramQQAppInterface == null) || (paramAllInOne == null)) {
      return 0L;
    }
    if ((paramAllInOne.troopcode != null) && (paramAllInOne.troopcode.length() > 0)) {
      paramQQAppInterface = paramAllInOne.troopcode;
    }
    for (;;)
    {
      paramAllInOne = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        paramAllInOne = "0";
      }
      try
      {
        long l = Long.valueOf(paramAllInOne).longValue();
        return l;
      }
      catch (Exception paramQQAppInterface)
      {
        return 0L;
      }
      if ((paramAllInOne.troopUin != null) && (paramAllInOne.troopUin.length() > 0))
      {
        paramQQAppInterface = (TroopInfo)paramQQAppInterface.a().createEntityManager().find(TroopInfo.class, "troopcode=?", new String[] { paramAllInOne.troopUin });
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.troopuin;
          continue;
        }
      }
      paramQQAppInterface = "0";
    }
  }
  
  public static alcs a(alcs paramalcs)
  {
    if (paramalcs == null) {
      return null;
    }
    alcs localalcs = new alcs();
    localalcs.agr = paramalcs.agr;
    localalcs.name = paramalcs.name;
    localalcs.version = paramalcs.version;
    localalcs.bVr = paramalcs.bVr;
    localalcs.tag = paramalcs.tag;
    localalcs.drQ = paramalcs.drQ;
    localalcs.drR = paramalcs.drR;
    localalcs.bVs = paramalcs.bVs;
    localalcs.bVt = paramalcs.bVt;
    localalcs.bVu = paramalcs.bVu;
    localalcs.bVv = paramalcs.bVv;
    localalcs.bVw = paramalcs.bVw;
    localalcs.bVx = paramalcs.bVx;
    localalcs.bVy = paramalcs.bVy;
    localalcs.bVz = paramalcs.bVz;
    localalcs.animation = paramalcs.animation;
    localalcs.bVE = paramalcs.bVE;
    localalcs.bVF = paramalcs.bVF;
    localalcs.bVG = paramalcs.bVG;
    localalcs.bVH = paramalcs.bVH;
    localalcs.bVA = paramalcs.bVA;
    localalcs.bVC = paramalcs.bVC;
    localalcs.bVB = paramalcs.bVB;
    localalcs.bVD = paramalcs.bVD;
    localalcs.imageSize = paramalcs.imageSize;
    localalcs.downloadUrl = paramalcs.downloadUrl;
    localalcs.size = paramalcs.size;
    localalcs.drS = paramalcs.drS;
    localalcs.drT = paramalcs.drT;
    localalcs.drG = paramalcs.drG;
    localalcs.drH = paramalcs.drH;
    localalcs.drI = paramalcs.drI;
    localalcs.drU = paramalcs.drU;
    localalcs.isHide = paramalcs.isHide;
    return localalcs;
  }
  
  public static alcs a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean)
  {
    int k = 0;
    if (paramLong == alcs.agc) {
      return null;
    }
    ArrayList localArrayList = a(paramQQAppInterface, true, paramBoolean);
    int m = localArrayList.size();
    int i = 0;
    paramQQAppInterface = null;
    int j = k;
    if (i < m)
    {
      paramQQAppInterface = (alcs)localArrayList.get(i);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.agr == paramLong)) {
        j = 1;
      }
    }
    else
    {
      if ((j != 1) || (paramQQAppInterface == null)) {
        break label92;
      }
    }
    for (;;)
    {
      return paramQQAppInterface;
      i += 1;
      break;
      label92:
      paramQQAppInterface = null;
    }
  }
  
  public static Intent a(Intent paramIntent, String paramString, QQAppInterface paramQQAppInterface, ProfileActivity.AllInOne paramAllInOne, BusinessCard paramBusinessCard)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null)) {
      return paramIntent;
    }
    String str = String.format("https://ti.qq.com/qcard/index.html?qq=%s&appid=%s&version=%s&_wv=1027", new Object[] { paramString, String.valueOf(paramQQAppInterface.getAppid()), "android-3.4.4" });
    paramString = str;
    if (aBZ()) {
      paramString = str + "&intl=1";
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "openDetails() url = " + paramString);
    }
    paramIntent = new Intent(paramIntent);
    paramIntent.putExtra("url", paramString);
    paramIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    paramIntent.putExtra("AllInOne", paramAllInOne);
    paramIntent.putExtra("BusinessCard", paramBusinessCard);
    return paramIntent;
  }
  
  /* Error */
  public static Bitmap a(String paramString, int paramInt, float paramFloat)
  {
    // Byte code:
    //   0: new 191	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: ifnull +26 -> 36
    //   13: aload_0
    //   14: invokevirtual 198	java/io/File:exists	()Z
    //   17: ifeq +19 -> 36
    //   20: aload_0
    //   21: invokevirtual 587	java/io/File:length	()J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifle +10 -> 36
    //   29: aload_0
    //   30: invokevirtual 590	java/io/File:isDirectory	()Z
    //   33: ifeq +9 -> 42
    //   36: aconst_null
    //   37: astore 7
    //   39: aload 7
    //   41: areturn
    //   42: new 592	java/io/BufferedInputStream
    //   45: dup
    //   46: new 594	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 597	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: invokespecial 600	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore_0
    //   58: aload_0
    //   59: invokestatic 606	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   62: astore 6
    //   64: aload 6
    //   66: ifnonnull +13 -> 79
    //   69: aload_0
    //   70: ifnull +7 -> 77
    //   73: aload_0
    //   74: invokevirtual 609	java/io/BufferedInputStream:close	()V
    //   77: aconst_null
    //   78: areturn
    //   79: aload 6
    //   81: invokevirtual 614	android/graphics/Bitmap:getWidth	()I
    //   84: istore_3
    //   85: aload 6
    //   87: invokevirtual 617	android/graphics/Bitmap:getHeight	()I
    //   90: istore 4
    //   92: iload_3
    //   93: iload_1
    //   94: if_icmple +68 -> 162
    //   97: iload_1
    //   98: i2f
    //   99: fload_2
    //   100: fdiv
    //   101: f2i
    //   102: istore 5
    //   104: new 619	android/graphics/Matrix
    //   107: dup
    //   108: invokespecial 620	android/graphics/Matrix:<init>	()V
    //   111: astore 7
    //   113: aload 7
    //   115: iload_1
    //   116: i2f
    //   117: iload_3
    //   118: i2f
    //   119: fdiv
    //   120: iload 5
    //   122: i2f
    //   123: iload 4
    //   125: i2f
    //   126: fdiv
    //   127: invokevirtual 624	android/graphics/Matrix:postScale	(FF)Z
    //   130: pop
    //   131: aload 6
    //   133: iconst_0
    //   134: iconst_0
    //   135: iload_3
    //   136: iload 4
    //   138: aload 7
    //   140: iconst_1
    //   141: invokestatic 628	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   144: astore 7
    //   146: aload 6
    //   148: invokevirtual 631	android/graphics/Bitmap:recycle	()V
    //   151: aload_0
    //   152: ifnull +7 -> 159
    //   155: aload_0
    //   156: invokevirtual 609	java/io/BufferedInputStream:close	()V
    //   159: aload 7
    //   161: areturn
    //   162: aload 6
    //   164: astore 7
    //   166: aload_0
    //   167: ifnull -128 -> 39
    //   170: aload_0
    //   171: invokevirtual 609	java/io/BufferedInputStream:close	()V
    //   174: aload 6
    //   176: areturn
    //   177: astore_0
    //   178: aload 6
    //   180: areturn
    //   181: astore_0
    //   182: aconst_null
    //   183: astore_0
    //   184: aload_0
    //   185: ifnull +7 -> 192
    //   188: aload_0
    //   189: invokevirtual 609	java/io/BufferedInputStream:close	()V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_0
    //   195: aconst_null
    //   196: astore_0
    //   197: aload_0
    //   198: ifnull +7 -> 205
    //   201: aload_0
    //   202: invokevirtual 609	java/io/BufferedInputStream:close	()V
    //   205: aconst_null
    //   206: areturn
    //   207: astore 6
    //   209: aconst_null
    //   210: astore_0
    //   211: aload_0
    //   212: ifnull +7 -> 219
    //   215: aload_0
    //   216: invokevirtual 609	java/io/BufferedInputStream:close	()V
    //   219: aload 6
    //   221: athrow
    //   222: astore_0
    //   223: goto -146 -> 77
    //   226: astore_0
    //   227: goto -68 -> 159
    //   230: astore_0
    //   231: goto -39 -> 192
    //   234: astore_0
    //   235: goto -30 -> 205
    //   238: astore_0
    //   239: goto -20 -> 219
    //   242: astore 6
    //   244: goto -33 -> 211
    //   247: astore 6
    //   249: goto -52 -> 197
    //   252: astore 6
    //   254: goto -70 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramString	String
    //   0	257	1	paramInt	int
    //   0	257	2	paramFloat	float
    //   84	52	3	i	int
    //   90	47	4	j	int
    //   102	19	5	k	int
    //   62	117	6	localBitmap	Bitmap
    //   207	13	6	localObject1	Object
    //   242	1	6	localObject2	Object
    //   247	1	6	localException	Exception
    //   252	1	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   37	128	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   170	174	177	java/lang/Exception
    //   42	58	181	java/lang/OutOfMemoryError
    //   42	58	194	java/lang/Exception
    //   42	58	207	finally
    //   73	77	222	java/lang/Exception
    //   155	159	226	java/lang/Exception
    //   188	192	230	java/lang/Exception
    //   201	205	234	java/lang/Exception
    //   215	219	238	java/lang/Exception
    //   58	64	242	finally
    //   79	92	242	finally
    //   97	151	242	finally
    //   58	64	247	java/lang/Exception
    //   79	92	247	java/lang/Exception
    //   97	151	247	java/lang/Exception
    //   58	64	252	java/lang/OutOfMemoryError
    //   79	92	252	java/lang/OutOfMemoryError
    //   97	151	252	java/lang/OutOfMemoryError
  }
  
  public static SpannableString a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!aqss.k(paramContext, paramInt2)) {
      aqss.a((QQAppInterface)localAppInterface, paramInt2, null, false);
    }
    Object localObject1;
    if (paramInt3 == 0)
    {
      localObject1 = new SpannableString("*");
      paramInt1 = (int)paramContext.getResources().getDimension(2131297499);
      paramContext = paramContext.getResources().getDrawable(2130846755);
      paramContext = aqqx.a(localAppInterface, T(paramInt2, dYP), "", paramContext, aqqx.pe, "halfstar", false, null);
      paramContext.setBounds(0, 0, paramInt1, paramInt1);
      ProfileActivity.a(localAppInterface, paramContext);
      ((SpannableString)localObject1).setSpan(new ImageSpan(paramContext), 0, 1, 33);
      return localObject1;
    }
    int k = paramInt3 / 64;
    paramInt3 %= 64;
    int m = paramInt3 / 16;
    int i1 = paramInt3 % 16;
    int n = i1 / 4;
    Object localObject4 = "";
    int i = 0;
    while (i < 4)
    {
      paramInt3 = 0;
      localObject1 = "";
      switch (i)
      {
      }
      for (;;)
      {
        int j = 0;
        while (j < paramInt3)
        {
          localObject4 = (String)localObject4 + (String)localObject1;
          j += 1;
        }
        localObject1 = "!";
        paramInt3 = k;
        continue;
        localObject1 = "@";
        paramInt3 = m;
        continue;
        localObject1 = "#";
        paramInt3 = n;
        continue;
        localObject1 = "%";
        paramInt3 = i1 % 4;
      }
      i += 1;
    }
    if (paramBoolean) {}
    for (;;)
    {
      Object localObject5;
      try
      {
        if (((String)localObject4).length() <= paramInt1) {
          break label941;
        }
        localObject1 = ((String)localObject4).substring(0, paramInt1);
        localObject7 = localObject1;
      }
      catch (Exception localException1)
      {
        try
        {
          localObject5 = paramContext.getResources().getDrawable(2130851860);
          if (localObject5 != null)
          {
            localObject1 = localObject5;
            localObject4 = localObject5;
            ((Drawable)localObject5).setBounds(0, 0, i, i);
            localObject1 = localObject5;
            localObject4 = localObject5;
            localSpannableString.setSpan(new ImageSpan((Drawable)localObject5), paramInt3, paramInt3 + 1, 33);
          }
          return localSpannableString;
        }
        catch (Error localError)
        {
          for (;;)
          {
            Object localObject7;
            Object localObject6;
            Object localObject8;
            Object localObject2;
            localObject5 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.profilecard.FrdProfileCard", 2, localError.toString());
              localObject5 = localObject2;
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            localObject5 = localError;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.profilecard.FrdProfileCard", 2, localException2.toString());
              localObject5 = localError;
            }
          }
        }
        localException1 = localException1;
        localException1.printStackTrace();
        localObject7 = localObject4;
        continue;
        localObject2 = localObject6;
        localObject4 = localObject8;
        if (!"!".equalsIgnoreCase(localObject7.substring(paramInt3, paramInt3 + 1))) {
          continue;
        }
        localObject2 = localObject6;
        localObject4 = localObject8;
        localObject5 = paramContext.getResources().getDrawable(2130846753);
        localObject2 = localObject6;
        localObject4 = localObject8;
        localObject5 = aqqx.a(localAppInterface, T(paramInt2, dYT), "", (Drawable)localObject5, aqqx.pe, "crown", false, null);
        localObject6 = localObject5;
        localObject2 = localObject5;
        localObject4 = localObject5;
        if (!"@".equalsIgnoreCase(localObject7.substring(paramInt3, paramInt3 + 1))) {
          continue;
        }
        localObject2 = localObject5;
        localObject4 = localObject5;
        localObject6 = paramContext.getResources().getDrawable(2130846757);
        localObject2 = localObject5;
        localObject4 = localObject5;
        localObject6 = aqqx.a(localAppInterface, T(paramInt2, dYS), "", (Drawable)localObject6, aqqx.pe, "sun", false, null);
        localObject5 = localObject6;
        localObject2 = localObject6;
        localObject4 = localObject6;
        if (!"#".equalsIgnoreCase(localObject7.substring(paramInt3, paramInt3 + 1))) {
          continue;
        }
        localObject2 = localObject6;
        localObject4 = localObject6;
        localObject5 = paramContext.getResources().getDrawable(2130846754);
        localObject2 = localObject6;
        localObject4 = localObject6;
        localObject5 = aqqx.a(localAppInterface, T(paramInt2, dYR), "", (Drawable)localObject5, aqqx.pe, "moon", false, null);
        localObject2 = localObject5;
        localObject4 = localObject5;
        if (!"%".equalsIgnoreCase(localObject7.substring(paramInt3, paramInt3 + 1))) {
          break label934;
        }
      }
      SpannableString localSpannableString = new SpannableString(localObject7);
      i = (int)paramContext.getResources().getDimension(2131297499);
      paramInt3 = 0;
      if (paramInt3 < localObject7.length())
      {
        localObject6 = null;
        localObject8 = null;
        localObject5 = null;
        if ((paramInt3 == paramInt1 - 1) && (paramBoolean == true))
        {
          localObject1 = localObject6;
          localObject4 = localObject8;
        }
        localObject2 = localObject5;
        localObject4 = localObject5;
        localObject6 = paramContext.getResources().getDrawable(2130846756);
        localObject2 = localObject5;
        localObject4 = localObject5;
        localObject5 = aqqx.a(localAppInterface, T(paramInt2, dYQ), "", (Drawable)localObject6, aqqx.pe, "star", false, null);
      }
      label934:
      for (localObject2 = localObject5;; localObject3 = localObject5)
      {
        localObject5 = localObject2;
        if (localObject5 != null)
        {
          ((Drawable)localObject5).setBounds(0, 0, i, i);
          ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), (Drawable)localObject5);
          localSpannableString.setSpan(new ImageSpan((Drawable)localObject5), paramInt3, paramInt3 + 1, 33);
        }
        paramInt3 += 1;
        break;
        return localSpannableString;
      }
      label941:
      Object localObject3 = localError;
    }
  }
  
  public static SpannableString a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i;
      int j;
      if (paramBoolean)
      {
        paramString = " " + paramString;
        i = 1;
        j = 0;
      }
      for (;;)
      {
        paramString = new SpannableString(paramString);
        paramInt2 = (int)paramContext.getResources().getDimension(paramInt2);
        paramInt3 = (int)paramContext.getResources().getDimension(paramInt3);
        paramContext = paramContext.getResources().getDrawable(paramInt1);
        paramContext.setBounds(0, 0, paramInt2, paramInt3);
        ProfileActivity.a(paramQQAppInterface, paramContext);
        paramString.setSpan(new ImageSpan(paramContext), j, i, 33);
        return paramString;
        paramString = paramString + " ";
        j = paramString.length() - 1;
        i = paramString.length();
      }
    }
    return null;
  }
  
  public static SpannableString a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, Context paramContext, QQAppInterface paramQQAppInterface, ClickableSpan paramClickableSpan)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i;
      int j;
      if (paramBoolean)
      {
        paramString = "  " + paramString;
        i = 1;
        j = 0;
      }
      for (;;)
      {
        paramString = new SpannableString(paramString);
        paramInt2 = (int)paramContext.getResources().getDimension(paramInt2);
        paramInt3 = (int)paramContext.getResources().getDimension(paramInt3);
        paramContext = paramContext.getResources().getDrawable(paramInt1);
        paramContext.setBounds(0, 0, paramInt2, paramInt3);
        ProfileActivity.a(paramQQAppInterface, paramContext);
        paramString.setSpan(new VerticalCenterImageSpan(paramContext, 0), j, i, 33);
        if (paramClickableSpan != null) {
          paramString.setSpan(paramClickableSpan, j, i, 33);
        }
        return paramString;
        paramString = paramString + "  ";
        j = paramString.length() - 1;
        i = paramString.length();
      }
    }
    return null;
  }
  
  public static SpannableStringBuilder a(List<SpannableString> paramList, int paramInt1, int paramInt2, String paramString, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (paramSpannableStringBuilder == null)
    {
      paramSpannableStringBuilder = new SpannableStringBuilder();
      if (paramList != null) {
        break label89;
      }
    }
    label89:
    for (int i = 0;; i = paramList.size())
    {
      int j = paramInt1;
      while ((j >= 0) && (j < paramInt2) && (j < i))
      {
        if (j > paramInt1) {
          paramSpannableStringBuilder.append(paramString);
        }
        paramSpannableStringBuilder.append((CharSequence)paramList.get(j));
        j += 1;
      }
      paramSpannableStringBuilder.clear();
      break;
    }
    return paramSpannableStringBuilder;
  }
  
  public static aooi.a a(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    String str = BR();
    aqhu.compressImageJpg(paramString, str, 1080, 1080, 100);
    return a(paramQQAppInterface, str, paramIntent, true);
  }
  
  private static aooi.a a(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent, boolean paramBoolean)
  {
    Object localObject = new File(paramString);
    long l = ((File)localObject).length();
    aooi.a locala = new aooi.a();
    if (!((File)localObject).exists())
    {
      locala.errCode = -10000;
      locala.errDesc = "file not exist";
      ad("onAvatarChanged", locala.errCode, locala.errDesc);
      return locala;
    }
    if (!aqiw.isNetSupport(paramQQAppInterface.getApp()))
    {
      locala.errCode = -10001;
      locala.errDesc = "network error";
      ad("onAvatarChanged", locala.errCode, locala.errDesc);
      return locala;
    }
    if ((l <= 0L) || (l >= 1749600L))
    {
      ad("onAvatarChanged", 0, String.valueOf(l));
      locala.errCode = -10000;
      locala.errDesc = "image illegal, size must be square.";
      ad("onAvatarChanged", locala.errCode, locala.errDesc);
      return locala;
    }
    if (paramBoolean)
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      int i = ((BitmapFactory.Options)localObject).outWidth;
      if ((i != ((BitmapFactory.Options)localObject).outHeight) || (i <= 0) || (i > 1080))
      {
        locala.errCode = -10000;
        locala.errDesc = "image illegal, size must be square.";
        ad("onAvatarChanged", locala.errCode, locala.errDesc);
        return locala;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Avatar", 2, "onAvatarChanged|start upload : size = " + l);
    }
    locala.errCode = 0;
    locala.errDesc = "ok";
    Us(paramString);
    paramQQAppInterface.a().b(paramQQAppInterface, paramString, paramIntent);
    return locala;
  }
  
  public static aqqe a(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ProfileCardUtil", 2, "do parse ProfileCardBgInfo");
      }
      aqqe localaqqe = new aqqe();
      try
      {
        paramString = new JSONObject(paramString);
        localaqqe.mInterval = paramString.getInt("frameInterval");
        localaqqe.mFrameNumber = paramString.getInt("frameNumber");
        localaqqe.x = ((float)paramString.getDouble("positionX"));
        localaqqe.y = ((float)paramString.getDouble("positionY"));
        localaqqe.mWidth = ((float)paramString.getDouble("width"));
        localaqqe.mHeight = ((float)paramString.getDouble("height"));
        return localaqqe;
      }
      catch (JSONException paramString)
      {
        QLog.e("ProfileCardUtil", 2, "parse, exception=" + MsfSdkUtils.getStackTraceString(paramString));
      }
    }
    return null;
  }
  
  public static FriendProfileCardBgDrawable a(Resources paramResources, String paramString1, String paramString2)
  {
    aqqe localaqqe = null;
    if (!paramString1.equals(""))
    {
      localaqqe = a(aqhq.b(new File(paramString1, "config.json"), -1));
      if (localaqqe != null)
      {
        String[] arrayOfString = new String[localaqqe.mFrameNumber];
        int i = 0;
        while (i < localaqqe.mFrameNumber)
        {
          arrayOfString[i] = (paramString1 + "/" + (i + 1) + ".png");
          i += 1;
        }
        localaqqe.hY = arrayOfString;
      }
    }
    paramString1 = localaqqe;
    if (localaqqe == null) {
      paramString1 = new aqqe();
    }
    if (paramString1 != null) {
      paramString1.cuW = paramString2;
    }
    return new FriendProfileCardBgDrawable(paramResources, paramString1);
  }
  
  public static Card a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject1 = null;
    byte b2 = 1;
    acff localacff;
    OlympicManager localOlympicManager;
    byte b1;
    try
    {
      localacff = (acff)paramQQAppInterface.getManager(51);
      localOlympicManager = (OlympicManager)paramQQAppInterface.getManager(167);
      if (localacff == null) {
        break label570;
      }
      localObject1 = localacff.e(paramString);
      paramQQAppInterface = localacff.b(paramString);
      if (paramQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileCardUtil", 2, "initCard card = null, uin = " + paramString);
        }
        paramQQAppInterface = new Card();
        paramQQAppInterface.uin = paramString;
        paramQQAppInterface.shGender = -1;
        if (localOlympicManager.nM(paramString))
        {
          b1 = 1;
          paramQQAppInterface.olympicTorch = b1;
          if (localObject1 == null) {
            break label417;
          }
          paramQQAppInterface.strNick = ((Friends)localObject1).name;
          paramQQAppInterface.strReMark = ((Friends)localObject1).remark;
          paramQQAppInterface.strShowName = ((Friends)localObject1).alias;
          if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
            break label402;
          }
          b1 = 1;
          label167:
          paramQQAppInterface.bQQVipOpen = b1;
          if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
            break label407;
          }
          b1 = 1;
          label185:
          paramQQAppInterface.bSuperVipOpen = b1;
          if (!((Friends)localObject1).isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
            break label412;
          }
          b1 = b2;
          label203:
          paramQQAppInterface.bSuperQQOpen = b1;
          if ((QLog.isColorLevel()) && (paramQQAppInterface != null)) {
            QLog.d("ProfileCardUtil", 2, "initCard bSuperVipOpen=" + paramQQAppInterface.bSuperVipOpen + ",bQQVipOpen=" + paramQQAppInterface.bQQVipOpen + ",uin = " + paramString);
          }
          paramQQAppInterface.iQQVipType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_QQVIP);
          paramQQAppInterface.iSuperVipType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_SUPERVIP);
          paramQQAppInterface.iSuperQQType = ((Friends)localObject1).getServiceType(EVIPSPEC.E_SP_SUPERQQ);
          paramQQAppInterface.iQQVipLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_QQVIP);
          paramQQAppInterface.iSuperVipLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
          paramQQAppInterface.iSuperQQLevel = ((Friends)localObject1).getServiceLevel(EVIPSPEC.E_SP_SUPERQQ);
          paramQQAppInterface.lUserFlag = ((Friends)localObject1).cSpecialFlag;
          paramQQAppInterface.namePlateOfKingGameId = ((Friends)localObject1).namePlateOfKingGameId;
          paramQQAppInterface.namePlateOfKingLoginTime = ((Friends)localObject1).namePlateOfKingLoginTime;
        }
        for (;;)
        {
          if (localacff == null) {
            break label567;
          }
          localacff.a(paramQQAppInterface);
          label383:
          if (paramQQAppInterface != null) {
            paramQQAppInterface.getPersonalityLabel();
          }
          return paramQQAppInterface;
          b1 = 0;
          break;
          label402:
          b1 = 0;
          break label167;
          label407:
          b1 = 0;
          break label185;
          label412:
          b1 = 0;
          break label203;
          label417:
          paramQQAppInterface.strSign = "";
          paramQQAppInterface.strNick = "";
          paramQQAppInterface.strReMark = "";
        }
      }
      if (localObject1 == null) {
        break label544;
      }
    }
    finally {}
    int i;
    label476:
    boolean bool2;
    boolean bool1;
    if (!aqft.equalsWithNullCheck(((Friends)localObject1).alias, paramQQAppInterface.strShowName))
    {
      paramQQAppInterface.strShowName = ((Friends)localObject1).alias;
      i = 1;
      if ((((Friends)localObject1).cSpecialFlag & 0x1) == 1) {
        paramQQAppInterface.lUserFlag |= 1L;
      }
      bool2 = localOlympicManager.nM(paramString);
      if (paramQQAppInterface.olympicTorch == 1)
      {
        bool1 = true;
        break label583;
      }
    }
    for (;;)
    {
      label519:
      paramQQAppInterface.olympicTorch = b1;
      i = 1;
      label527:
      if ((localacff != null) && (i != 0)) {
        localacff.a(paramQQAppInterface);
      }
      label544:
      break label383;
      bool1 = false;
      label567:
      label570:
      label583:
      do
      {
        b1 = 0;
        break label519;
        do
        {
          break label527;
          i = 0;
          break label476;
          break label383;
          Object localObject2 = null;
          paramQQAppInterface = (QQAppInterface)localObject1;
          localObject1 = localObject2;
          break;
        } while (bool1 == bool2);
      } while (!bool2);
      b1 = 1;
    }
  }
  
  public static String a(alcn paramalcn, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if ((paramalcn == null) || (paramalcn.e == null) || (TextUtils.isEmpty(paramalcn.e.uin)) || (paramQQAppInterface == null) || (paramActivity == null)) {
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      String str2 = paramalcn.e.uin;
      String str1 = paramalcn.troopUin;
      paramalcn = (asgx)paramQQAppInterface.getManager(165);
      if (paramalcn.sH(str2)) {
        return String.format("https://datacard.qidian.qq.com/static/1_%s_more.htm?appid=%s&version=%s&_wv=1027", new Object[] { str2, String.valueOf(paramQQAppInterface.getAppid()), "android-3.4.4" });
      }
      if (paramalcn.sM(str2)) {
        return paramActivity.getIntent().getStringExtra("key_qidian_detail_url");
      }
      paramQQAppInterface = String.format("https://ti.qq.com/qcard/index.html?qq=%s&appid=%s&version=%s&_wv=1027", new Object[] { str2, String.valueOf(paramQQAppInterface.getAppid()), "android-3.4.4" });
      paramalcn = paramQQAppInterface;
      if (!TextUtils.isEmpty(str1)) {
        paramalcn = paramQQAppInterface + "&troopUin=" + str1;
      }
      paramQQAppInterface = paramalcn;
    } while (!aBZ());
    return paramalcn + "&intl=1";
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt1 == 0)
    {
      localStringBuilder.append(paramContext.getString(2131695654));
      localStringBuilder.append("  ");
    }
    for (;;)
    {
      if (paramInt2 != 0)
      {
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(paramContext.getString(2131720665));
        localStringBuilder.append("  ");
      }
      paramContext = aqek.fY(paramInt3);
      if (!TextUtils.isEmpty(paramContext))
      {
        localStringBuilder.append(paramContext);
        localStringBuilder.append("  ");
      }
      String str = "";
      paramContext = str;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramContext = str;
        if (!acfp.m(2131709941).equals(paramString1)) {
          paramContext = "" + paramString1;
        }
      }
      paramString1 = paramContext;
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramContext;
        if (!TextUtils.isEmpty(paramContext)) {
          paramString1 = paramContext + "-";
        }
        paramString1 = paramString1 + paramString2;
      }
      paramContext = paramString1;
      if (!TextUtils.isEmpty(paramString3))
      {
        paramContext = paramString1;
        if (!TextUtils.isEmpty(paramString1)) {
          paramContext = paramString1 + "-";
        }
        paramContext = paramContext + paramString3;
      }
      localStringBuilder.append(paramContext);
      return localStringBuilder.toString();
      if (paramInt1 == 1)
      {
        localStringBuilder.append(paramContext.getString(2131693477));
        localStringBuilder.append("  ");
      }
    }
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt1 == 0)
    {
      localStringBuilder.append(paramContext.getString(2131695654));
      localStringBuilder.append("  ");
    }
    for (;;)
    {
      if (paramInt2 != 0)
      {
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(paramContext.getString(2131720665));
        localStringBuilder.append("  ");
      }
      String str = "";
      paramContext = str;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramContext = str;
        if (!acfp.m(2131709914).equals(paramString1)) {
          paramContext = "" + paramString1;
        }
      }
      paramString1 = paramContext;
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramContext;
        if (!TextUtils.isEmpty(paramContext)) {
          paramString1 = paramContext + " ";
        }
        paramString1 = paramString1 + paramString2;
      }
      paramContext = paramString1;
      if (!TextUtils.isEmpty(paramString3))
      {
        paramContext = paramString1;
        if (!TextUtils.isEmpty(paramString1)) {
          paramContext = paramString1 + " ";
        }
        paramContext = paramContext + paramString3;
      }
      localStringBuilder.append(paramContext);
      return localStringBuilder.toString();
      if (paramInt1 == 1)
      {
        localStringBuilder.append(paramContext.getString(2131693477));
        localStringBuilder.append("  ");
      }
    }
  }
  
  public static String a(Context paramContext, alcn paramalcn)
  {
    Card localCard = paramalcn.d;
    ContactCard localContactCard = paramalcn.a;
    int i = -1;
    paramalcn = "";
    Object localObject;
    if (localCard != null)
    {
      i = localCard.age;
      localObject = paramalcn;
      if (i > 0)
      {
        localObject = paramalcn;
        if (!aBZ()) {
          localObject = i + paramContext.getString(2131720665);
        }
      }
      paramalcn = "";
      if (localCard == null) {
        break label356;
      }
      paramContext = paramalcn;
      if (!TextUtils.isEmpty(localCard.strCountry))
      {
        paramContext = paramalcn;
        if (!acfp.m(2131709912).equals(localCard.strCountry)) {
          paramContext = "" + localCard.strCountry;
        }
      }
      paramalcn = paramContext;
      if (!TextUtils.isEmpty(localCard.strProvince))
      {
        paramalcn = paramContext;
        if (!TextUtils.isEmpty(paramContext)) {
          paramalcn = paramContext + " ";
        }
        paramalcn = paramalcn + localCard.strProvince;
      }
      paramContext = paramalcn;
      if (!TextUtils.isEmpty(localCard.strCity))
      {
        paramContext = paramalcn;
        if (!TextUtils.isEmpty(paramalcn)) {
          paramContext = paramalcn + " ";
        }
        paramContext = paramContext + localCard.strCity;
      }
      label263:
      if ((localObject == null) || (((String)localObject).length() <= 0)) {
        break label554;
      }
    }
    label554:
    for (paramalcn = "" + " " + (String)localObject;; paramalcn = "")
    {
      localObject = paramalcn;
      if (paramContext != null)
      {
        localObject = paramalcn;
        if (paramContext.length() > 0) {
          localObject = paramalcn + " " + paramContext;
        }
      }
      return localObject;
      if (localContactCard == null) {
        break;
      }
      i = localContactCard.bAge;
      break;
      label356:
      paramContext = paramalcn;
      if (localContactCard == null) {
        break label263;
      }
      paramContext = paramalcn;
      if (!TextUtils.isEmpty(localContactCard.strCountry))
      {
        paramContext = paramalcn;
        if (!acfp.m(2131709925).equals(localContactCard.strCountry)) {
          paramContext = "" + localContactCard.strCountry;
        }
      }
      paramalcn = paramContext;
      if (!TextUtils.isEmpty(localContactCard.strProvince))
      {
        paramalcn = paramContext;
        if (!TextUtils.isEmpty(paramContext)) {
          paramalcn = paramContext + " ";
        }
        paramalcn = paramalcn + localContactCard.strProvince;
      }
      paramContext = paramalcn;
      if (TextUtils.isEmpty(localContactCard.strCity)) {
        break label263;
      }
      paramContext = paramalcn;
      if (!TextUtils.isEmpty(paramalcn)) {
        paramContext = paramalcn + " ";
      }
      paramContext = paramContext + localContactCard.strCity;
      break label263;
    }
  }
  
  public static String a(ProfileActivity.AllInOne paramAllInOne)
  {
    String str = "";
    Object localObject = str;
    if (paramAllInOne != null)
    {
      localObject = str;
      if (paramAllInOne.pr != null)
      {
        localObject = str;
        if (paramAllInOne.pr.size() > 0)
        {
          localObject = (ProfileActivity.CardContactInfo)paramAllInOne.pr.get(0);
          if (localObject == null) {
            break label99;
          }
        }
      }
    }
    label99:
    for (str = ((ProfileActivity.CardContactInfo)localObject).aOM + ((ProfileActivity.CardContactInfo)localObject).phoneNumber;; str = "")
    {
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        localObject = str;
        if (!TextUtils.isEmpty(paramAllInOne.uin)) {
          localObject = paramAllInOne.uin;
        }
      }
      return localObject;
    }
  }
  
  public static String a(boolean paramBoolean, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://club.vip.qq.com/profile/custom?_wv=131072&_fv=0");
    if (paramBoolean) {
      localStringBuilder.append("&from=guest");
    }
    localStringBuilder.append("&templateId=").append(paramLong);
    return localStringBuilder.toString();
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        if (paramInt1 == 4)
        {
          if ((paramInt2 == 0) || (paramInt2 == 1)) {
            return "mvip.gongneng.android.mingpian_open427";
          }
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open429";
          }
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open4210";
          }
        }
        else if (paramInt1 == 2)
        {
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open428";
          }
        }
        else if (((paramInt1 == 0) || (paramInt1 == 1)) && (paramInt2 == 4))
        {
          return "mvip.gongneng.android.mingpian_open426";
        }
      }
    }
    else if (!paramBoolean2) {
      if (paramInt3 == 2)
      {
        if (paramInt1 == 4)
        {
          if ((paramInt2 == 0) || (paramInt2 == 1)) {
            return "mvip.gongneng.android.mingpian_open422";
          }
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open424";
          }
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open425";
          }
        }
        else if (paramInt1 == 2)
        {
          if (paramInt2 == 4) {
            return "mvip.gongneng.android.mingpian_open423";
          }
        }
        else if (((paramInt1 == 0) || (paramInt1 == 1)) && (paramInt2 == 4))
        {
          return "mvip.gongneng.android.mingpian_open421";
        }
      }
      else
      {
        if (paramInt1 == 2)
        {
          if (paramInt2 == 2) {
            return "mvip.gongneng.android.mingpian_open413";
          }
          return "mvip.gongneng.android.mingpian_open412";
        }
        if (paramInt2 == 2) {
          return "mvip.gongneng.android.mingpian_open411";
        }
      }
    }
    return "";
  }
  
  /* Error */
  public static ArrayList<alcs> a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +13 -> 19
    //   9: ldc_w 571
    //   12: iconst_2
    //   13: ldc_w 1203
    //   16: invokestatic 738	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 373	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   23: astore_0
    //   24: aload_0
    //   25: invokestatic 1206	aqep:aX	(Landroid/content/Context;)Ljava/lang/String;
    //   28: astore 8
    //   30: new 191	java/io/File
    //   33: dup
    //   34: aload 8
    //   36: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore 7
    //   41: aload 7
    //   43: invokevirtual 198	java/io/File:exists	()Z
    //   46: istore 5
    //   48: iload 5
    //   50: ifne +8 -> 58
    //   53: ldc_w 1208
    //   56: astore 8
    //   58: getstatic 44	aqep:bec	Ljava/lang/String;
    //   61: aload 8
    //   63: invokestatic 1211	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   66: ifeq +20 -> 86
    //   69: getstatic 40	aqep:CH	Ljava/util/ArrayList;
    //   72: invokevirtual 1213	java/util/ArrayList:isEmpty	()Z
    //   75: ifne +11 -> 86
    //   78: iload_1
    //   79: ifne +7 -> 86
    //   82: getstatic 40	aqep:CH	Ljava/util/ArrayList;
    //   85: areturn
    //   86: invokestatic 320	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +13 -> 102
    //   92: ldc_w 571
    //   95: iconst_2
    //   96: ldc_w 1215
    //   99: invokestatic 738	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: new 35	java/util/ArrayList
    //   105: dup
    //   106: invokespecial 38	java/util/ArrayList:<init>	()V
    //   109: astore 10
    //   111: iload 5
    //   113: ifeq +103 -> 216
    //   116: new 594	java/io/FileInputStream
    //   119: dup
    //   120: aload 7
    //   122: invokespecial 597	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   125: astore_0
    //   126: new 1217	java/io/ByteArrayOutputStream
    //   129: dup
    //   130: invokespecial 1218	java/io/ByteArrayOutputStream:<init>	()V
    //   133: astore 7
    //   135: sipush 4096
    //   138: newarray byte
    //   140: astore 6
    //   142: aload_0
    //   143: aload 6
    //   145: iconst_0
    //   146: sipush 4096
    //   149: invokevirtual 1224	java/io/InputStream:read	([BII)I
    //   152: istore_2
    //   153: iload_2
    //   154: iconst_m1
    //   155: if_icmpeq +75 -> 230
    //   158: aload 7
    //   160: aload 6
    //   162: iconst_0
    //   163: iload_2
    //   164: invokevirtual 1228	java/io/ByteArrayOutputStream:write	([BII)V
    //   167: goto -25 -> 142
    //   170: astore 9
    //   172: aload 7
    //   174: astore 6
    //   176: aload 9
    //   178: astore 7
    //   180: aload 7
    //   182: invokevirtual 1229	java/lang/Throwable:printStackTrace	()V
    //   185: aload_0
    //   186: ifnull +7 -> 193
    //   189: aload_0
    //   190: invokevirtual 1230	java/io/InputStream:close	()V
    //   193: aload 6
    //   195: ifnull +8 -> 203
    //   198: aload 6
    //   200: invokevirtual 1231	java/io/ByteArrayOutputStream:close	()V
    //   203: aload 8
    //   205: putstatic 44	aqep:bec	Ljava/lang/String;
    //   208: aload 10
    //   210: putstatic 40	aqep:CH	Ljava/util/ArrayList;
    //   213: aload 10
    //   215: areturn
    //   216: aload_0
    //   217: invokevirtual 1235	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   220: ldc_w 1237
    //   223: invokevirtual 1243	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   226: astore_0
    //   227: goto -101 -> 126
    //   230: new 54	java/lang/String
    //   233: dup
    //   234: aload 7
    //   236: invokevirtual 1247	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   239: ldc_w 1249
    //   242: invokespecial 1252	java/lang/String:<init>	([BLjava/lang/String;)V
    //   245: astore 6
    //   247: aload 6
    //   249: invokevirtual 402	java/lang/String:length	()I
    //   252: ifle +627 -> 879
    //   255: new 858	org/json/JSONObject
    //   258: dup
    //   259: aload 6
    //   261: invokespecial 859	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   264: astore 6
    //   266: aload 6
    //   268: ldc_w 1254
    //   271: invokevirtual 1257	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   274: ifeq +605 -> 879
    //   277: aload 6
    //   279: ldc_w 1254
    //   282: invokevirtual 1261	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   285: astore 6
    //   287: aload 6
    //   289: invokevirtual 1264	org/json/JSONArray:length	()I
    //   292: istore_3
    //   293: iconst_0
    //   294: istore_2
    //   295: iload_2
    //   296: iload_3
    //   297: if_icmpge +489 -> 786
    //   300: aload 6
    //   302: iload_2
    //   303: invokevirtual 1268	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   306: astore 9
    //   308: new 438	alcs
    //   311: dup
    //   312: invokespecial 439	alcs:<init>	()V
    //   315: astore 11
    //   317: aload 11
    //   319: aload 9
    //   321: ldc_w 1270
    //   324: invokevirtual 1273	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   327: i2l
    //   328: putfield 442	alcs:agr	J
    //   331: aload 11
    //   333: aload 9
    //   335: ldc_w 1274
    //   338: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   341: putfield 445	alcs:name	Ljava/lang/String;
    //   344: aload 11
    //   346: aload 9
    //   348: ldc_w 1278
    //   351: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   354: putfield 448	alcs:version	Ljava/lang/String;
    //   357: aload 11
    //   359: aload 9
    //   361: ldc_w 1280
    //   364: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   367: putfield 451	alcs:bVr	Ljava/lang/String;
    //   370: aload 11
    //   372: aload 9
    //   374: ldc_w 1281
    //   377: invokevirtual 1273	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   380: putfield 454	alcs:tag	I
    //   383: aload 11
    //   385: aload 9
    //   387: ldc_w 1283
    //   390: invokevirtual 1273	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   393: putfield 457	alcs:drQ	I
    //   396: aload 11
    //   398: aload 9
    //   400: ldc_w 1285
    //   403: invokevirtual 1273	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   406: putfield 460	alcs:drR	I
    //   409: aload 11
    //   411: aload 9
    //   413: ldc_w 1287
    //   416: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   419: putfield 463	alcs:bVs	Ljava/lang/String;
    //   422: aload 11
    //   424: aload 9
    //   426: ldc_w 1289
    //   429: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   432: putfield 466	alcs:bVt	Ljava/lang/String;
    //   435: aload 11
    //   437: aload 9
    //   439: ldc_w 1291
    //   442: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   445: putfield 469	alcs:bVu	Ljava/lang/String;
    //   448: aload 11
    //   450: aload 9
    //   452: ldc_w 1293
    //   455: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   458: putfield 472	alcs:bVv	Ljava/lang/String;
    //   461: aload 11
    //   463: aload 9
    //   465: ldc_w 1295
    //   468: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   471: putfield 475	alcs:bVw	Ljava/lang/String;
    //   474: aload 11
    //   476: aload 9
    //   478: ldc_w 1297
    //   481: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   484: putfield 478	alcs:bVx	Ljava/lang/String;
    //   487: aload 11
    //   489: aload 9
    //   491: ldc_w 1299
    //   494: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   497: putfield 481	alcs:bVy	Ljava/lang/String;
    //   500: aload 11
    //   502: aload 9
    //   504: ldc_w 1301
    //   507: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   510: putfield 484	alcs:bVz	Ljava/lang/String;
    //   513: aload 11
    //   515: aload 9
    //   517: ldc_w 1302
    //   520: invokevirtual 1273	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   523: putfield 487	alcs:animation	I
    //   526: aload 11
    //   528: aload 9
    //   530: ldc_w 1304
    //   533: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   536: putfield 490	alcs:bVE	Ljava/lang/String;
    //   539: aload 11
    //   541: aload 9
    //   543: ldc_w 1306
    //   546: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   549: putfield 493	alcs:bVF	Ljava/lang/String;
    //   552: aload 11
    //   554: aload 9
    //   556: ldc_w 1308
    //   559: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   562: putfield 496	alcs:bVG	Ljava/lang/String;
    //   565: aload 11
    //   567: aload 9
    //   569: ldc_w 1310
    //   572: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   575: putfield 499	alcs:bVH	Ljava/lang/String;
    //   578: aload 11
    //   580: aload 9
    //   582: ldc_w 1312
    //   585: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   588: putfield 502	alcs:bVA	Ljava/lang/String;
    //   591: aload 11
    //   593: aload 9
    //   595: ldc_w 1314
    //   598: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   601: putfield 505	alcs:bVC	Ljava/lang/String;
    //   604: aload 11
    //   606: aload 9
    //   608: ldc_w 1316
    //   611: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   614: putfield 508	alcs:bVB	Ljava/lang/String;
    //   617: aload 11
    //   619: aload 9
    //   621: ldc_w 1318
    //   624: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   627: putfield 511	alcs:bVD	Ljava/lang/String;
    //   630: aload 11
    //   632: aload 9
    //   634: ldc_w 1319
    //   637: invokevirtual 1273	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   640: putfield 514	alcs:imageSize	I
    //   643: aload 11
    //   645: aload 9
    //   647: ldc_w 1321
    //   650: invokevirtual 1277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   653: putfield 517	alcs:downloadUrl	Ljava/lang/String;
    //   656: aload 11
    //   658: aload 9
    //   660: ldc_w 1323
    //   663: invokevirtual 1273	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   666: putfield 519	alcs:size	I
    //   669: aload 11
    //   671: aload 9
    //   673: ldc_w 1325
    //   676: invokevirtual 1273	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   679: putfield 522	alcs:drS	I
    //   682: aload 11
    //   684: aload 9
    //   686: ldc_w 1327
    //   689: invokevirtual 1273	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   692: putfield 525	alcs:drT	I
    //   695: aload 11
    //   697: aload 9
    //   699: ldc_w 1329
    //   702: invokevirtual 1273	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   705: putfield 528	alcs:drG	I
    //   708: aload 11
    //   710: aload 9
    //   712: ldc_w 1331
    //   715: invokevirtual 1273	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   718: putfield 531	alcs:drH	I
    //   721: aload 11
    //   723: aload 9
    //   725: ldc_w 1333
    //   728: invokevirtual 1273	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   731: putfield 534	alcs:drI	I
    //   734: aload 9
    //   736: ldc_w 1335
    //   739: invokevirtual 1273	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   742: istore 4
    //   744: aload 11
    //   746: aload 9
    //   748: ldc_w 1337
    //   751: invokevirtual 1273	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   754: putfield 537	alcs:drU	I
    //   757: iload 4
    //   759: iconst_1
    //   760: if_icmpne +230 -> 990
    //   763: iconst_1
    //   764: istore_1
    //   765: aload 11
    //   767: iload_1
    //   768: putfield 540	alcs:isHide	Z
    //   771: aload 10
    //   773: aload 11
    //   775: invokevirtual 1340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   778: pop
    //   779: iload_2
    //   780: iconst_1
    //   781: iadd
    //   782: istore_2
    //   783: goto -488 -> 295
    //   786: new 438	alcs
    //   789: dup
    //   790: invokespecial 439	alcs:<init>	()V
    //   793: astore 6
    //   795: aload 6
    //   797: ldc2_w 1341
    //   800: putfield 442	alcs:agr	J
    //   803: aload 6
    //   805: iconst_1
    //   806: putfield 540	alcs:isHide	Z
    //   809: aload 10
    //   811: aload 6
    //   813: invokevirtual 1340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   816: pop
    //   817: new 438	alcs
    //   820: dup
    //   821: invokespecial 439	alcs:<init>	()V
    //   824: astore 6
    //   826: aload 6
    //   828: ldc2_w 1343
    //   831: putfield 442	alcs:agr	J
    //   834: aload 6
    //   836: iconst_1
    //   837: putfield 540	alcs:isHide	Z
    //   840: aload 10
    //   842: aload 6
    //   844: invokevirtual 1340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   847: pop
    //   848: new 438	alcs
    //   851: dup
    //   852: invokespecial 439	alcs:<init>	()V
    //   855: astore 6
    //   857: aload 6
    //   859: ldc2_w 1345
    //   862: putfield 442	alcs:agr	J
    //   865: aload 6
    //   867: iconst_1
    //   868: putfield 540	alcs:isHide	Z
    //   871: aload 10
    //   873: aload 6
    //   875: invokevirtual 1340	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   878: pop
    //   879: aload_0
    //   880: ifnull +7 -> 887
    //   883: aload_0
    //   884: invokevirtual 1230	java/io/InputStream:close	()V
    //   887: aload 7
    //   889: ifnull -686 -> 203
    //   892: aload 7
    //   894: invokevirtual 1231	java/io/ByteArrayOutputStream:close	()V
    //   897: goto -694 -> 203
    //   900: astore_0
    //   901: aload_0
    //   902: invokevirtual 1347	java/io/IOException:printStackTrace	()V
    //   905: goto -702 -> 203
    //   908: astore_0
    //   909: aload_0
    //   910: invokevirtual 1347	java/io/IOException:printStackTrace	()V
    //   913: goto -710 -> 203
    //   916: astore 6
    //   918: aconst_null
    //   919: astore 7
    //   921: aconst_null
    //   922: astore_0
    //   923: aload_0
    //   924: ifnull +7 -> 931
    //   927: aload_0
    //   928: invokevirtual 1230	java/io/InputStream:close	()V
    //   931: aload 7
    //   933: ifnull +8 -> 941
    //   936: aload 7
    //   938: invokevirtual 1231	java/io/ByteArrayOutputStream:close	()V
    //   941: aload 6
    //   943: athrow
    //   944: astore_0
    //   945: aload_0
    //   946: invokevirtual 1347	java/io/IOException:printStackTrace	()V
    //   949: goto -8 -> 941
    //   952: astore 6
    //   954: aconst_null
    //   955: astore 7
    //   957: goto -34 -> 923
    //   960: astore 6
    //   962: goto -39 -> 923
    //   965: astore 8
    //   967: aload 6
    //   969: astore 7
    //   971: aload 8
    //   973: astore 6
    //   975: goto -52 -> 923
    //   978: astore 7
    //   980: aconst_null
    //   981: astore_0
    //   982: goto -802 -> 180
    //   985: astore 7
    //   987: goto -807 -> 180
    //   990: iconst_0
    //   991: istore_1
    //   992: goto -227 -> 765
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	995	0	paramQQAppInterface	QQAppInterface
    //   0	995	1	paramBoolean	boolean
    //   152	631	2	i	int
    //   292	6	3	j	int
    //   742	19	4	k	int
    //   46	66	5	bool	boolean
    //   1	873	6	localObject1	Object
    //   916	26	6	localObject2	Object
    //   952	1	6	localObject3	Object
    //   960	8	6	localObject4	Object
    //   973	1	6	localObject5	Object
    //   39	931	7	localObject6	Object
    //   978	1	7	localThrowable1	java.lang.Throwable
    //   985	1	7	localThrowable2	java.lang.Throwable
    //   28	176	8	str	String
    //   965	7	8	localObject7	Object
    //   170	7	9	localThrowable3	java.lang.Throwable
    //   306	441	9	localJSONObject	JSONObject
    //   109	763	10	localArrayList	ArrayList
    //   315	459	11	localalcs	alcs
    // Exception table:
    //   from	to	target	type
    //   135	142	170	java/lang/Throwable
    //   142	153	170	java/lang/Throwable
    //   158	167	170	java/lang/Throwable
    //   230	293	170	java/lang/Throwable
    //   300	757	170	java/lang/Throwable
    //   765	779	170	java/lang/Throwable
    //   786	879	170	java/lang/Throwable
    //   883	887	900	java/io/IOException
    //   892	897	900	java/io/IOException
    //   189	193	908	java/io/IOException
    //   198	203	908	java/io/IOException
    //   116	126	916	finally
    //   216	227	916	finally
    //   927	931	944	java/io/IOException
    //   936	941	944	java/io/IOException
    //   126	135	952	finally
    //   135	142	960	finally
    //   142	153	960	finally
    //   158	167	960	finally
    //   230	293	960	finally
    //   300	757	960	finally
    //   765	779	960	finally
    //   786	879	960	finally
    //   180	185	965	finally
    //   116	126	978	java/lang/Throwable
    //   216	227	978	java/lang/Throwable
    //   126	135	985	java/lang/Throwable
  }
  
  public static ArrayList<alcs> a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "getProfileTemplateList isReturnHidden=" + paramBoolean1 + ",returnExpire=" + paramBoolean2);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = a(paramQQAppInterface, false);
    if (!((ArrayList)localObject).isEmpty())
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        alcs localalcs = (alcs)((Iterator)localObject).next();
        if ((paramBoolean1) || (!localalcs.isHide)) {
          if (paramBoolean2) {
            localArrayList.add(localalcs);
          } else if (a(paramQQAppInterface, localalcs)) {
            localArrayList.add(localalcs);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static List<Pair<String, String>> a(Context paramContext, Card paramCard)
  {
    ArrayList localArrayList = new ArrayList(3);
    if ((paramContext == null) || (paramCard == null)) {
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardUtil", 2, "makeAccountInfoForSelfProfile new rule");
    }
    int i = paramCard.shGender;
    if (i == 0) {
      localArrayList.add(Pair.create(paramContext.getString(2131695654), ""));
    }
    for (;;)
    {
      paramContext = ph(paramCard.strSchool);
      if (!TextUtils.isEmpty(paramContext)) {
        localArrayList.add(Pair.create(paramContext, "school"));
      }
      paramContext = ph(paramCard.strCompany);
      if (!TextUtils.isEmpty(paramContext)) {
        localArrayList.add(Pair.create(paramContext, "company"));
      }
      if (localArrayList.size() >= 4) {
        break;
      }
      paramContext = ph(paramCard.strCountry);
      String str1 = ph(paramCard.strProvince);
      String str2 = ph(paramCard.strCity);
      StringBuilder localStringBuilder = new StringBuilder(50);
      if ((!TextUtils.isEmpty(paramContext)) && (!acfp.m(2131709921).equals(paramContext))) {
        localStringBuilder.append(paramContext);
      }
      if (!TextUtils.isEmpty(str1))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("-");
        }
        localStringBuilder.append(str1);
      }
      if (!TextUtils.isEmpty(str2))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("-");
        }
        localStringBuilder.append(str2);
      }
      if (localStringBuilder.length() > 0) {
        localArrayList.add(Pair.create(localStringBuilder.toString(), "location"));
      }
      if (localArrayList.size() >= 4) {
        break;
      }
      paramContext = ph(aqek.fY(paramCard.constellation));
      if (TextUtils.isEmpty(paramContext)) {
        break;
      }
      localArrayList.add(Pair.create(paramContext, ""));
      return localArrayList;
      if (i == 1) {
        localArrayList.add(Pair.create(paramContext.getString(2131693477), ""));
      }
    }
  }
  
  public static List<SpannableString> a(QQAppInterface paramQQAppInterface, Context paramContext, Card paramCard)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramContext == null) || (paramCard == null)) {
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCardUtil", 2, "makeAccountInfoForSelfProfile new rule");
    }
    int i = paramCard.shGender;
    if (i == 0)
    {
      localArrayList.add(new SpannableString(paramContext.getString(2131695654)));
      str = ph(paramCard.strSchool);
      if (!TextUtils.isEmpty(str))
      {
        if (!paramCard.schoolVerifiedFlag) {
          break label191;
        }
        localArrayList.add(a(str, true, 2130846073, 2131298630, 2131298629, paramContext, paramQQAppInterface));
      }
    }
    for (;;)
    {
      paramQQAppInterface = ph(paramCard.strCompany);
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        localArrayList.add(new SpannableString(paramQQAppInterface));
      }
      if (localArrayList.size() < 4) {
        break label213;
      }
      return localArrayList;
      if (i != 1) {
        break;
      }
      localArrayList.add(new SpannableString(paramContext.getString(2131693477)));
      break;
      label191:
      localArrayList.add(new SpannableString(paramCard.strSchool));
    }
    label213:
    paramQQAppInterface = ph(paramCard.strCountry);
    paramContext = ph(paramCard.strProvince);
    String str = ph(paramCard.strCity);
    StringBuilder localStringBuilder = new StringBuilder(50);
    if ((!TextUtils.isEmpty(paramQQAppInterface)) && (!acfp.m(2131709921).equals(paramQQAppInterface))) {
      localStringBuilder.append(paramQQAppInterface);
    }
    if (!TextUtils.isEmpty(paramContext))
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("-");
      }
      localStringBuilder.append(paramContext);
    }
    if (!TextUtils.isEmpty(str))
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("-");
      }
      localStringBuilder.append(str);
    }
    if (localStringBuilder.length() > 0) {
      localArrayList.add(new SpannableString(localStringBuilder.toString()));
    }
    if (localArrayList.size() >= 4) {
      return localArrayList;
    }
    paramQQAppInterface = ph(aqek.fY(paramCard.constellation));
    if (!TextUtils.isEmpty(paramQQAppInterface)) {
      localArrayList.add(new SpannableString(paramQQAppInterface));
    }
    return localArrayList;
  }
  
  public static void a(alcn paramalcn, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if ((paramalcn == null) || (paramQQAppInterface == null) || (paramActivity == null)) {}
    do
    {
      return;
      paramalcn = a(paramalcn, paramQQAppInterface, paramActivity);
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, String.format(Locale.getDefault(), "openDetails url: %s", new Object[] { paramalcn }));
      }
    } while (TextUtils.isEmpty(paramalcn));
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", paramalcn);
    localIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("broadcastAction", "com.tencent.mobileqq.card.modify");
    localIntent.putExtra("reqType", 1);
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_gxl");
    paramActivity.startActivity(localIntent);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString)
  {
    a(paramActivity, paramView, paramString, false, false);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    localIntent.putExtra("curType", paramInt);
    paramView = sxx.getViewRect(paramView);
    localIntent.putExtra("is_from_face2face_add_friend", true);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramView);
    localIntent.putExtra("requestType", 881);
    paramActivity.startActivityForResult(localIntent, 881);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, long paramLong, int paramInt)
  {
    a(paramActivity, paramView, paramString, paramLong, paramInt, null);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, long paramLong, int paramInt, ProfileActivity.AllInOne paramAllInOne)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    paramView = sxx.getViewRect(paramView);
    localIntent.putExtra("extra_pendant_id", paramLong);
    localIntent.putExtra("extra_action_source", paramInt);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", paramView);
    localIntent.putExtra("requestType", 881);
    if (paramAllInOne != null) {
      localIntent.putExtra("AllInOne", paramAllInOne);
    }
    paramActivity.startActivityForResult(localIntent, 881);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramActivity, paramView, paramString, paramBoolean1, paramBoolean2, null);
  }
  
  public static void a(Activity paramActivity, View paramView, String paramString, boolean paramBoolean1, boolean paramBoolean2, ProfileActivity.AllInOne paramAllInOne)
  {
    Intent localIntent = new Intent(paramActivity, FriendProfileImageActivity.class);
    localIntent.putExtra("friendUin", paramString);
    localIntent.putExtra("KEY_THUMBNAL_BOUND", sxx.getViewRect(paramView));
    localIntent.putExtra("requestType", 881);
    localIntent.putExtra("is_hide_actionsheet", paramBoolean1);
    localIntent.putExtra("is_hide_footbar", paramBoolean2);
    if (paramAllInOne != null) {
      localIntent.putExtra("AllInOne", paramAllInOne);
    }
    paramActivity.startActivityForResult(localIntent, 881);
  }
  
  public static void a(Activity paramActivity, BusinessCard paramBusinessCard, ProfileActivity.AllInOne paramAllInOne)
  {
    a(paramActivity, paramBusinessCard, paramAllInOne, false);
  }
  
  public static void a(Activity paramActivity, BusinessCard paramBusinessCard, ProfileActivity.AllInOne paramAllInOne, boolean paramBoolean)
  {
    a(paramActivity, paramBusinessCard, paramAllInOne, paramBoolean, null);
  }
  
  public static void a(Activity paramActivity, BusinessCard paramBusinessCard, ProfileActivity.AllInOne paramAllInOne, boolean paramBoolean, Bundle paramBundle)
  {
    Intent localIntent;
    if (!paramBoolean)
    {
      localIntent = new Intent(paramActivity, BusinessCardEditActivity.class);
      if (paramAllInOne.pa != 0) {
        break label166;
      }
      localIntent.putExtra("mode_type", 3);
      localIntent.putExtra("source_activity", 3);
    }
    for (;;)
    {
      localIntent.putExtra("cur_card_body", paramBusinessCard);
      localIntent.putExtra("is_edit_mode", true);
      localIntent.putExtra("finish_immedia", true);
      Object localObject = paramAllInOne.pr;
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
        break label207;
      }
      paramBusinessCard = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramBusinessCard.add(((ProfileActivity.CardContactInfo)((Iterator)localObject).next()).phoneNumber);
      }
      localIntent = new Intent();
      localIntent.setClassName("com.tencent.tim", BusinessCardEditActivity.class.getName());
      break;
      label166:
      localIntent.putExtra("mode_type", 2);
      localIntent.putExtra("source_activity", 1);
      paramBusinessCard.bindUin = paramAllInOne.uin;
    }
    localIntent.putExtra("bind_phone_num", paramBusinessCard);
    label207:
    if (paramBoolean)
    {
      localIntent.putExtra("notify_plugin", true);
      localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    }
    if (paramBundle != null) {
      localIntent.putExtras(paramBundle);
    }
    paramActivity.startActivity(localIntent);
    if (paramAllInOne.pa == 0)
    {
      anot.a(null, "CliOper", "", "", "0X8006A7F", "0X8006A7F", 0, 0, "", "", "", "");
      return;
    }
    anot.a(null, "CliOper", "", "", "0X8006A93", "0X8006A93", 0, 0, "", "", "", "");
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, boolean paramBoolean)
  {
    a(paramActivity, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramBoolean, false, "");
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    paramString4 = new Intent(paramActivity, QQBrowserActivity.class);
    paramString4.putExtra("uin", paramString1);
    paramString4.putExtra("isShowAd", false);
    paramString4.putExtra("hide_more_button", true);
    paramString4.putExtra("has_red_dot", paramBoolean2);
    paramString4.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramString2 = aqqj.o(paramActivity, "card", paramString2);
    paramString1 = paramString2;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1 = paramString2 + "&" + paramString3;
    }
    paramString1 = paramString1 + "&entryId=" + paramInt2 + "&isCache=" + paramInt1 + "&tabId=" + paramInt3;
    if ((paramActivity instanceof FriendProfileCardActivity))
    {
      if (paramInt2 != 0) {
        break label204;
      }
      paramString4.putExtra("individuation_url_type", 40202);
    }
    for (;;)
    {
      paramString4.putExtra("url", paramString1);
      VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, paramString1, -1L, paramString4, paramBoolean1, 1025);
      return;
      label204:
      if (paramInt2 == 1) {
        paramString4.putExtra("individuation_url_type", 40203);
      } else if (paramInt2 == 3) {
        paramString4.putExtra("individuation_url_type", 40204);
      }
    }
  }
  
  public static void a(TextView paramTextView, String paramString1, String paramString2, View.OnLongClickListener paramOnLongClickListener)
  {
    if (paramTextView == null) {
      return;
    }
    String str = paramTextView.getText().toString();
    alas localalas = new alas(str);
    if ((paramString1 != null) && (str.contains(paramString1)))
    {
      localalas.gU("复制QQ号", paramString1);
      if ((paramString2 != null) && (paramString2.length() > 0) && (str.length() > paramString1.length() + 2)) {
        localalas.gU(acfp.m(2131709952), paramString2);
      }
    }
    for (;;)
    {
      paramTextView.setTag(new albb(89, localalas));
      paramTextView.setText(paramTextView.getText(), TextView.BufferType.SPANNABLE);
      paramTextView.setOnLongClickListener(paramOnLongClickListener);
      return;
      if ((paramString2 != null) && (str.contains(paramString2))) {
        localalas.gU(acfp.m(2131709918), paramString2);
      } else {
        localalas.gU(acfp.m(2131709903), str);
      }
    }
  }
  
  @Deprecated
  public static void a(BaseActivity paramBaseActivity, long paramLong, String paramString1, String paramString2, int paramInt)
  {
    stj.a(paramBaseActivity, paramLong, paramString1, paramString2, paramInt, "", new Bundle());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2)
  {
    a(paramQQAppInterface, paramLong1, paramLong2, paramString1, paramLong3, paramString2, 0, null, null, 0.0F, 0.0F, 0.0F, "", 0L);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, int paramInt, String paramString3, String paramString4, float paramFloat1, float paramFloat2, float paramFloat3, String paramString5, long paramLong4)
  {
    paramQQAppInterface.execute(new ProfileCardUtil.3(paramInt, paramString3, paramString4, paramFloat1, paramFloat2, paramFloat3, paramQQAppInterface, paramLong4, paramLong1, paramLong2, paramString1, paramLong3, paramString2, paramString5));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2, String paramString3, long paramLong4)
  {
    a(paramQQAppInterface, paramLong1, paramLong2, paramString1, paramLong3, paramString2, 0, null, null, 0.0F, 0.0F, 0.0F, paramString3, paramLong4);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, View paramView, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramView instanceof DynamicAvatarView))
    {
      aqcy localaqcy = ((DynamicAvatarView)paramView).b;
      if ((localaqcy != null) && (localaqcy.cTy) && (!TextUtils.isEmpty(localaqcy.mBigUrl)))
      {
        b(paramActivity, paramView, localaqcy.mBigUrl);
        paramInt1 = 1;
        if (paramInt2 == 0) {
          if (paramInt1 == 0) {
            break label159;
          }
        }
      }
    }
    label159:
    for (paramActivity = "1";; paramActivity = "0")
    {
      anot.a(paramQQAppInterface, "dc00898", "", "", "0X8007103", "0X8007103", 0, 0, paramActivity, "", "", "");
      return;
      if (paramInt2 == 1)
      {
        a(paramActivity, paramView, paramString, paramInt1);
        paramInt1 = 0;
        break;
      }
      a(paramActivity, paramView, paramString, true, true);
      for (;;)
      {
        paramInt1 = 0;
        break;
        if (paramInt2 == 1)
        {
          a(paramActivity, paramView, paramString, paramInt1);
          paramInt1 = 0;
          break;
        }
        a(paramActivity, paramView, paramString, true, true);
      }
    }
  }
  
  public static void a(Card paramCard, QQAppInterface paramQQAppInterface)
  {
    if ((paramCard != null) && (paramQQAppInterface != null)) {
      paramQQAppInterface.getApp().getSharedPreferences("profile_card_new_school_guide", 0).edit().putBoolean("new_school_guide_init_" + paramCard.uin, false).commit();
    }
  }
  
  public static void a(String paramString1, int paramInt1, boolean paramBoolean, String paramString2, String paramString3, long paramLong1, int paramInt2, int paramInt3, long paramLong2, String paramString4, String paramString5)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("doStaticForVoiceTransfer()").append(", uin = ").append(paramString1).append(", nOpType = ").append(paramInt1).append(", isSuccess = ").append(paramBoolean).append(", filekey = ").append(paramString2).append(", ip = ").append(paramString3).append(", duration = ").append(paramLong1).append(", retry_count = ").append(paramInt2).append(", failCode = ").append(paramInt3).append(", fileSize = ").append(paramLong2).append(", errorMsg = ").append(paramString4).append(", rspHeader = ").append(paramString5);
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.VoiceIntro", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 0) {}
    HashMap localHashMap;
    for (localObject = "actIntroPttUpload";; localObject = "actIntroPttDownload")
    {
      localHashMap = new HashMap();
      localHashMap.put("serverip", paramString3);
      localHashMap.put("param_uuid", paramString2);
      if (!paramBoolean) {
        break;
      }
      localHashMap.put("param_retry", String.valueOf(paramInt2));
      anpc.a(BaseApplication.getContext()).collectPerformance(paramString1, (String)localObject, paramBoolean, paramLong1, paramLong2, localHashMap, "", false);
      return;
    }
    if (!aojn.a(paramInt3, localHashMap))
    {
      localHashMap.put("param_FailCode", Integer.toString(paramInt3));
      if ((paramInt3 == -9527) || (paramInt3 == 9311) || (paramInt3 == 9044) || (paramInt3 == 9350) || (paramInt3 == 9351))
      {
        localHashMap.put(aojn.cle, paramString4);
        label316:
        if (paramInt1 == 1) {
          localHashMap.put("param_url", paramString3);
        }
        if (paramString5 == null) {
          break label379;
        }
      }
    }
    for (;;)
    {
      localHashMap.put("param_rspHeader", paramString5);
      break;
      localHashMap.put("param_errorDesc", paramString4);
      break label316;
      localHashMap.put("param_errorDesc", paramString4);
      break label316;
      label379:
      paramString5 = "";
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    boolean bool2 = true;
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null) || (paramActivity == null))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("param:app:");
        if (paramQQAppInterface != null) {
          break label79;
        }
        bool1 = true;
        paramString = paramString.append(bool1).append(",activity:");
        if (paramActivity != null) {
          break label84;
        }
      }
      label79:
      label84:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        QLog.i("forwardQzone", 2, bool1);
        return;
        bool1 = false;
        break;
      }
    }
    avpw.d locald = avpw.d.a();
    locald.cMP = paramQQAppInterface.getCurrentAccountUin();
    locald.nickname = aqgv.n(paramQQAppInterface, locald.cMP);
    avpw.a(paramActivity, locald, paramString, paramActivity.getString(2131693309), "", -1);
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "openAddPersonalityLabel");
    }
    paramString = new Intent(paramActivity, QQBrowserActivity.class);
    paramString.putExtra("url", albf.bVi);
    paramString.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    paramString.putExtra("broadcastAction", "com.tencent.mobileqq.card.modify_personality_label");
    paramString.putExtra("fromProfile", paramBoolean);
    paramActivity.startActivity(paramString);
  }
  
  public static boolean a(alcl paramalcl)
  {
    return paramalcl.id == 160;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, alcs paramalcs)
  {
    long l = NetConnInfoCenter.getServerTime();
    if (((paramalcs.drS > 100) && (l < paramalcs.drS)) || ((paramalcs.drT > 100) && (l > paramalcs.drT)))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ProfileCardUtil", 2, "filterTemplate->sytle:" + paramalcs.agr + ",beginTime:" + paramalcs.drS + ",endTime:" + paramalcs.drT);
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    boolean bool = false;
    if (a(paramQQAppInterface, paramString, paramIntent, false).errCode == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(Card paramCard, QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramCard != null)
    {
      bool1 = bool2;
      if (paramQQAppInterface != null)
      {
        bool1 = bool2;
        if (!paramCard.isNewSchoolStatusWriteForGuide())
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramCard.strSchool)) {
            bool1 = paramQQAppInterface.getApp().getSharedPreferences("profile_card_new_school_guide", 0).getBoolean("new_school_guide_init_" + paramCard.uin, true);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "isNeedGuideForNewSchoolData " + bool1);
    }
    return bool1;
  }
  
  public static boolean aBY()
  {
    return cTL;
  }
  
  public static boolean aBZ()
  {
    Locale localLocale = Locale.getDefault();
    String str = localLocale.getCountry();
    String[] arrayOfString = hL;
    int j = arrayOfString.length;
    int i = 0;
    if (i < j) {
      if (!TextUtils.equals(str, arrayOfString[i])) {}
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("TRUETe", 4, String.format(localLocale, "isEuropeAndAmerica country:%s, local: %s", new Object[] { str, localLocale }));
      }
      return bool;
      i += 1;
      break;
    }
  }
  
  public static int aI(Context paramContext)
  {
    int i = e(paramContext.getResources());
    return (int)((paramContext.getResources().getDisplayMetrics().heightPixels - i) * 0.75F);
  }
  
  public static int aJ(Context paramContext)
  {
    return (int)(0.56338F * aI(paramContext));
  }
  
  public static int aS(int paramInt1, int paramInt2)
  {
    return Math.min(1080, Math.min(paramInt1, paramInt2) - 10);
  }
  
  public static String aW(Context paramContext)
  {
    paramContext = paramContext.getDir(".profilecard", 0);
    return paramContext.getAbsolutePath() + File.separator + "qvip_profile_label_config.json" + "3.4.4";
  }
  
  public static String aX(Context paramContext)
  {
    paramContext = paramContext.getDir(".profilecard", 0);
    return paramContext.getAbsolutePath() + File.separator + "qvip_profile_template.json" + "3.4.4";
  }
  
  public static String aY(Context paramContext)
  {
    try
    {
      if (aqft.cC()) {
        return acbn.bnh;
      }
      String str = paramContext.getDir(".profilecard", 0).getAbsoluteFile() + File.separator;
      return str;
    }
    catch (Exception localException)
    {
      QLog.e("Q.profilecard.FrdProfileCard", 1, "getBGDir error, e = " + localException);
    }
    return paramContext.getDir(".profilecard", 0).getAbsoluteFile() + File.separator;
  }
  
  public static final void ad(String paramString1, int paramInt, String paramString2)
  {
    if (X == null) {
      X = new StringBuilder(120);
    }
    for (;;)
    {
      X.append(paramString1).append(", reason = [").append(paramString2).append("], code = [").append(paramInt).append("]");
      QLog.i("UPLOAD_AVATAR_FAIL", 1, X.toString());
      return;
      X.setLength(0);
    }
  }
  
  public static byte[] ae(String paramString)
  {
    byte[] arrayOfByte = null;
    if (!TextUtils.isEmpty(paramString)) {
      arrayOfByte = aqhs.hexStr2Bytes(paramString);
    }
    return arrayOfByte;
  }
  
  public static boolean aj(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    paramContext = I(paramContext, paramString);
    boolean bool1;
    try
    {
      paramContext = new File(paramContext);
      if ((paramContext.exists()) && (paramContext.isFile()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource is exists");
        }
      }
      else
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          return bool1;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource is not exists");
        return false;
      }
    }
    catch (Exception paramContext)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistBgResource exception msg=" + paramContext.getMessage());
        return false;
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int b(ProfileActivity.AllInOne paramAllInOne)
  {
    int i = 0;
    if (paramAllInOne == null) {
      return 1001;
    }
    if (ProfileActivity.AllInOne.b(paramAllInOne)) {}
    for (;;)
    {
      return i;
      if ((paramAllInOne.pa == 22) || (paramAllInOne.pa == 21)) {
        i = 1000;
      } else if ((paramAllInOne.pa == 41) || (paramAllInOne.pa == 42)) {
        i = 1001;
      } else if (paramAllInOne.pa == 86) {
        i = 10002;
      } else if (paramAllInOne.pa == 94) {
        i = 10004;
      } else if (paramAllInOne.pa == 3) {
        i = 1005;
      } else if (paramAllInOne.pa == 2) {
        i = 1005;
      } else if (paramAllInOne.pa == 74) {
        i = 1023;
      } else if ((paramAllInOne.pa == 32) || (paramAllInOne.pa == 31) || (paramAllInOne.pa == 51) || (paramAllInOne.pa == 50) || (paramAllInOne.pa == 34) || (paramAllInOne.pa == 53)) {
        i = 1006;
      } else if ((paramAllInOne.pa == 46) || (paramAllInOne.pa == 47)) {
        i = 1004;
      } else if ((paramAllInOne.pa == 56) || (paramAllInOne.pa == 57)) {
        i = 1009;
      } else if (paramAllInOne.pa == 58) {
        i = 1020;
      } else if ((paramAllInOne.pa == 71) || (paramAllInOne.pa == 72)) {
        i = 1021;
      } else if (paramAllInOne.pa != 70) {
        if ((paramAllInOne.pa == 27) || (paramAllInOne.pa == 25)) {
          i = 1022;
        } else if ((paramAllInOne.pa == 75) || (paramAllInOne.pa == 76)) {
          i = 1010;
        } else if (paramAllInOne.pa == 80) {
          i = 25;
        } else if (paramAllInOne.pa == 115) {
          i = 10008;
        } else {
          i = 1001;
        }
      }
    }
  }
  
  public static String b(Context paramContext, alcn paramalcn)
  {
    int j = -1;
    String str = "";
    Card localCard = paramalcn.d;
    ContactCard localContactCard = paramalcn.a;
    int i;
    if ((paramalcn.e.gender == 0) || (paramalcn.e.gender == 1))
    {
      i = paramalcn.e.gender;
      if (i != 0) {
        break label150;
      }
      str = paramContext.getString(2131695654);
    }
    for (;;)
    {
      return str + a(paramContext, paramalcn);
      if ((localCard != null) && ((localCard.shGender == 0) || (localCard.shGender == 1)))
      {
        i = localCard.shGender;
        break;
      }
      i = j;
      if (localContactCard == null) {
        break;
      }
      if (localContactCard.bSex != 0)
      {
        i = j;
        if (localContactCard.bSex != 1) {
          break;
        }
      }
      i = localContactCard.bSex;
      break;
      label150:
      if (i == 1) {
        str = paramContext.getString(2131693477);
      }
    }
  }
  
  public static String b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getDir(".profilecard", 0).getAbsolutePath();
    if (paramLong == -1L) {
      return paramQQAppInterface + File.separator + "common_" + "583";
    }
    if ((paramLong != alcs.agc) && (paramLong > 0L)) {
      return paramQQAppInterface + File.separator + paramLong;
    }
    return null;
  }
  
  public static void b(Activity paramActivity, View paramView, String paramString)
  {
    Object localObject = new PicInfo();
    ((PicInfo)localObject).videoUrl = paramString;
    paramString = new ArrayList(1);
    paramString.add(localObject);
    localObject = new Intent(paramActivity, NearbyProfilePicBrowserActivity.class);
    ((Intent)localObject).putExtra("intent_param_index", 0);
    ((Intent)localObject).putExtra("intent_param_pic_infos", paramString);
    ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", sxx.getViewRect(paramView));
    ((Intent)localObject).addFlags(536870912);
    paramActivity.startActivity((Intent)localObject);
  }
  
  @Deprecated
  public static void b(BaseActivity paramBaseActivity, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, Bundle paramBundle)
  {
    stj.a(paramBaseActivity, paramLong, paramString1, paramString2, paramInt, paramString3, paramBundle);
  }
  
  public static void b(String paramString, Activity paramActivity)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString)) || (paramActivity == null))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("param:activity:");
        if (paramActivity != null) {
          break label53;
        }
      }
      for (;;)
      {
        QLog.i("forwardtofriend", 2, bool);
        return;
        label53:
        bool = false;
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_filepath", paramString);
    localBundle.putString("forward_thumb", paramString);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    ahgq.f(paramActivity, paramString, 21);
  }
  
  public static void b(String paramString, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    boolean bool2 = true;
    if ((TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null) || (paramActivity == null))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder().append("param:app:");
        if (paramQQAppInterface != null) {
          break label79;
        }
        bool1 = true;
        paramString = paramString.append(bool1).append(",activity:");
        if (paramActivity != null) {
          break label84;
        }
      }
      label79:
      label84:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        QLog.i("forwardFavorite", 2, bool1);
        return;
        bool1 = false;
        break;
      }
    }
    try
    {
      aviz.b(paramString).b(paramActivity, paramQQAppInterface.getCurrentAccountUin());
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("forwardFavorite", 2, "", paramString);
      }
      QQToast.a(paramActivity, paramActivity.getResources().getString(2131694176), 0).show();
    }
  }
  
  public static void bC(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = aqhs.bytes2HexStr(paramArrayOfByte);
      String str = aqhs.hexString2String(paramArrayOfByte);
      ThreadManager.post(new ProfileCardUtil.1(str, pg(paramArrayOfByte)), 8, null, false);
      Ut(str);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.Avatar", 2, paramArrayOfByte.toString());
    }
  }
  
  public static boolean bY(QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject = b(paramQQAppInterface, -1L);
    if (localObject != null)
    {
      paramQQAppInterface = new File((String)localObject);
      localObject = new File((String)localObject + File.separator + "config_black.json");
      bool1 = bool2;
      if (paramQQAppInterface.isDirectory())
      {
        bool1 = bool2;
        if (((File)localObject).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistsTemplateDir common dir exists=" + paramQQAppInterface.isDirectory() + " templateConfig exists= " + ((File)localObject).exists());
        bool2 = bool1;
      }
    }
    do
    {
      return bool2;
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("Q.profilecard.FrdProfileCard", 2, "isExistsTemplateDir common path is null");
    return false;
  }
  
  public static void bd(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      paramQQAppInterface = new URL("profile_img_thumb", null, paramQQAppInterface.a(false, paramString));
      if (BaseApplicationImpl.sImageCache != null) {
        BaseApplicationImpl.sImageCache.remove(paramQQAppInterface.toString());
      }
      paramQQAppInterface = new URL("profile_img_big", null, pe(paramString));
      if (BaseApplicationImpl.sImageCache != null) {
        BaseApplicationImpl.sImageCache.remove(paramQQAppInterface.toString());
      }
      paramQQAppInterface = new URL("profile_img_big_fhd", null, pf(paramString));
      if (BaseApplicationImpl.sImageCache != null) {
        BaseApplicationImpl.sImageCache.remove(paramQQAppInterface.toString());
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.profilecard.Avatar", 2, "", paramQQAppInterface);
    }
  }
  
  public static void be(@NonNull QQAppInterface paramQQAppInterface, String paramString)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("diy_guest_tip_show_list", 0);
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin() + "_" + paramString;
    localSharedPreferences.edit().putLong(paramQQAppInterface, System.currentTimeMillis()).apply();
  }
  
  public static String c(byte paramByte)
  {
    switch (paramByte)
    {
    case 0: 
    default: 
      return null;
    case 1: 
      return acfp.m(2131709910);
    case 2: 
      return acfp.m(2131709902);
    case 3: 
      return acfp.m(2131709928);
    case 4: 
      return acfp.m(2131709900);
    case 5: 
      return acfp.m(2131709907);
    case 6: 
      return acfp.m(2131709906);
    case 7: 
      return acfp.m(2131709920);
    case 8: 
      return acfp.m(2131709933);
    case 9: 
      return acfp.m(2131709942);
    case 10: 
      return acfp.m(2131709950);
    case 11: 
      return acfp.m(2131709930);
    }
    return acfp.m(2131709922);
  }
  
  public static void c(Activity paramActivity, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    try
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString1);
      Card localCard = a((QQAppInterface)localObject, paramString2);
      paramString1 = new ProfileActivity.AllInOne(paramString2, 9);
      paramString1.nickname = aqgv.s((QQAppInterface)localObject, paramString2);
      paramString1.aOF = paramString2;
      paramString1.bIX = paramInt;
      paramString1.bIZ = 2;
      paramString1.bJa = 123;
      paramString2 = new alcn();
      paramString2.d = localCard;
      paramString2.e = paramString1;
      paramString2 = adzx.a((QQAppInterface)localObject, paramString2);
      if (paramString2.mobilesNum.size() >= 3)
      {
        QQToast.a(paramActivity, 0, 2131696850, 0).show();
        return;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("add_phone_num", paramString3);
      a(paramActivity, paramString2, paramString1, false, (Bundle)localObject);
      return;
    }
    catch (AccountNotMatchException paramActivity)
    {
      QLog.e("openBusinessCardToAddingPhone", 1, paramActivity, new Object[0]);
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    a(paramQQAppInterface, paramLong1, paramLong2, null, 0L, null);
  }
  
  public static final int dpToPx(Context paramContext, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics());
  }
  
  public static final int e(Resources paramResources)
  {
    try
    {
      int i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      return i;
    }
    catch (Exception localException) {}
    return (int)(paramResources.getDisplayMetrics().density * 25.0F + 0.5D);
  }
  
  public static void edA()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ProfileCardUtil", 2, "clear drawables from doOnDestroy.");
    }
    if ((CH != null) && (!CH.isEmpty()))
    {
      Iterator localIterator = CH.iterator();
      while (localIterator.hasNext()) {
        ((alcs)localIterator.next()).dEZ();
      }
    }
  }
  
  public static void edz()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "initAvatarUploadState");
    }
    cTL = false;
    csu = null;
  }
  
  public static void et(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new ProfileCardUtil.4(paramQQAppInterface), 5, null, false);
  }
  
  public static void eu(@NonNull QQAppInterface paramQQAppInterface)
  {
    aqvl.x(paramQQAppInterface, "show_diy_template_guide_for_guest_time", aqvl.e(paramQQAppInterface, "show_diy_template_guide_for_guest_time", 0) + 1);
  }
  
  @NotNull
  public static void ev(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (akjp)paramQQAppInterface.getManager(160);
    paramQQAppInterface.n(10019, false);
    paramQQAppInterface.n(10020, false);
    paramQQAppInterface.n(10022, false);
    paramQQAppInterface.n(10021, false);
    paramQQAppInterface.n(10023, false);
    paramQQAppInterface.n(10024, false);
    paramQQAppInterface.n(10025, false);
    paramQQAppInterface.n(10026, false);
    paramQQAppInterface.n(10027, false);
  }
  
  public static final int f(Context paramContext, float paramFloat)
  {
    return (int)TypedValue.applyDimension(1, paramFloat, paramContext.getApplicationContext().getResources().getDisplayMetrics());
  }
  
  public static int fb(String paramString)
  {
    int i1 = 0;
    int j = 0;
    long l = System.currentTimeMillis();
    paramString = a(paramString, 100, 0.56338F);
    if (paramString == null) {}
    int i;
    do
    {
      return j;
      int k = 0;
      int n = 0;
      j = 0;
      while (k < paramString.getHeight())
      {
        int m = 0;
        i = n;
        if (m < paramString.getWidth())
        {
          n = paramString.getPixel(m, k);
          int i2 = Color.red(n);
          int i3 = Color.green(n);
          if ((Color.blue(n) + (i2 + i3)) / 3 > 127)
          {
            n = j + 1;
            j = i;
          }
          for (i = n;; i = n)
          {
            n = m + 1;
            m = i;
            i = j;
            j = m;
            m = n;
            break;
            n = j;
            j = i + 1;
          }
        }
        k += 1;
        n = i;
      }
      i = i1;
      if (j >= n) {
        i = 1;
      }
      paramString.recycle();
      j = i;
    } while (!QLog.isColorLevel());
    QLog.d("ProfileCardUtil", 2, "-->calculate background color cost:" + (System.currentTimeMillis() - l) + "(ms)");
    return i;
  }
  
  public static void fw(Context paramContext)
  {
    long l = System.currentTimeMillis();
    if (l - asA < 1500L) {
      return;
    }
    asA = l;
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://ti.qq.com/signature/msglist?_wv=3&_wwv=128");
    paramContext.startActivity(localIntent);
    paramContext = (akjp)BaseApplicationImpl.getApplication().getRuntime().getManager(160);
    paramContext.bG(10019, false);
    paramContext.bG(10020, false);
    paramContext.bG(10022, false);
    paramContext.bG(10021, false);
    paramContext.bG(10023, false);
    paramContext.bG(10024, false);
    paramContext.bG(10025, false);
    paramContext.bG(10026, false);
    paramContext.bG(10027, false);
    QLog.d("ProfileCardUtil", 1, "jumpProfileBubbleMsgList");
  }
  
  public static String gb(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return "mvip.gongneng.mobileqq.mingpian.open.android";
    case 2: 
      return "mvip.gongneng.mobileqq.mingpian.huiliu.android";
    case 3: 
      return "mvip.gongneng.mobileqq.mingpian.kerentai.android";
    case 4: 
      return "mvip.gongneng.mobileqq.mingpian.open.android";
    case 5: 
      return "mvip.gongneng.mobileqq.mingpian.huiliu.android";
    }
    return "mvip.gongneng.mobileqq.mingpian.kerentai.android";
  }
  
  public static long hC()
  {
    return System.currentTimeMillis() - asB;
  }
  
  public static long hD()
  {
    try
    {
      if (aqft.cC()) {
        return aqft.getUsableSpace(new File(acbn.SDCARD_ROOT));
      }
      long l = aqft.getUsableSpace(new File(Environment.getRootDirectory().getPath()));
      return l;
    }
    catch (Exception localException) {}
    return -1L;
  }
  
  public static void i(Context paramContext, long paramLong, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("isShowAd", false);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = String.format(aqqj.getUrl("rareCard"), new Object[] { Long.valueOf(paramLong) });
    }
    localIntent.putExtra("url", str);
    paramContext.startActivity(localIntent);
  }
  
  @NotNull
  public static BusinessInfoCheckUpdate.RedTypeInfo o()
  {
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    localRedTypeInfo.red_type.set(-1);
    akjp localakjp = (akjp)BaseApplicationImpl.getApplication().getRuntime().getManager(160);
    RedTouchItem localRedTouchItem = localakjp.a(-4);
    if ((localakjp.a(localRedTouchItem, true)) && (localRedTouchItem.count > 0))
    {
      QLog.d("ProfileCardUtil", 1, "getProfileMsgListRedTouch");
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
    }
    return localRedTypeInfo;
  }
  
  public static String pe(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = MD5.toMD5(MD5.toMD5(MD5.toMD5(paramString)));
    localStringBuilder.append(CardHandler.bnU).append("HDAvatar").append("/").append(paramString).append(".jpg");
    return aqul.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String pf(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = MD5.toMD5(MD5.toMD5(MD5.toMD5(paramString)));
    localStringBuilder.append(CardHandler.bnU).append("FHDAvatar").append("/").append(paramString).append(".jpg");
    return aqul.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String pg(String paramString)
  {
    if (oM != null) {
      return (String)oM.get(paramString);
    }
    return null;
  }
  
  public static String ph(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.trim();
  }
  
  public static String pi(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return MD5.toMD5(paramString);
  }
  
  public static boolean rg(String paramString)
  {
    boolean bool2 = false;
    paramString = pe(paramString);
    try
    {
      paramString = new File(paramString);
      bool1 = bool2;
      if (paramString.exists()) {
        bool1 = paramString.delete();
      }
    }
    catch (Exception paramString)
    {
      do
      {
        boolean bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.Avatar", 2, paramString.toString());
    }
    return bool1;
    return false;
  }
  
  public static boolean rh(String paramString)
  {
    boolean bool2 = false;
    paramString = pf(paramString);
    try
    {
      paramString = new File(paramString);
      bool1 = bool2;
      if (paramString.exists()) {
        bool1 = paramString.delete();
      }
    }
    catch (Exception paramString)
    {
      do
      {
        boolean bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Q.profilecard.Avatar", 2, "clearFHDAvatar " + paramString.toString());
    }
    return bool1;
    return false;
  }
  
  public static final int u(Context paramContext, int paramInt)
  {
    return (int)Math.ceil(TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics()));
  }
  
  public static int v(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return aS(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
  }
  
  public static final int v(Context paramContext, int paramInt)
  {
    return (int)Math.floor(TypedValue.applyDimension(1, paramInt, paramContext.getApplicationContext().getResources().getDisplayMetrics()));
  }
  
  public static void v(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "deleteOldCardTemplateDir clear old version template dir");
    }
    paramQQAppInterface = paramQQAppInterface.getApp().getDir(".profilecard", 0).getAbsolutePath();
    try
    {
      File[] arrayOfFile = new File(paramQQAppInterface).listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0)) {
        while (i < arrayOfFile.length)
        {
          String str = arrayOfFile[i].getName();
          if ((str.startsWith(String.valueOf(paramString1))) && (!str.endsWith(paramString2)))
          {
            str = paramQQAppInterface + File.separator + String.valueOf(paramString1) + "_" + str;
            aqhq.cn(str);
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.FrdProfileCard", 2, "deleteOldCardTemplateDir old dir=" + str);
            }
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static int w(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return (int)((Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) - 10) * 0.8F + 0.5F);
  }
  
  public static int x(Activity paramActivity)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.widthPixels;
  }
  
  public static int y(Activity paramActivity)
  {
    return x(paramActivity) * 3 / 4;
  }
  
  public static class a
  {
    Bundle bundle = new Bundle();
    
    public a a(String paramString)
    {
      this.bundle.putString("text_evidence", paramString);
      return this;
    }
    
    public a b(String paramString)
    {
      this.bundle.putString("img_evidence", paramString);
      return this;
    }
    
    public a c(String paramString)
    {
      this.bundle.putString("url_evidence", paramString);
      return this;
    }
    
    public a d(String paramString)
    {
      this.bundle.putString("video_evidence", paramString);
      return this;
    }
    
    public a e(String paramString)
    {
      this.bundle.putString("file_evidence", paramString);
      return this;
    }
    
    public a f(String paramString)
    {
      this.bundle.putString("audio_evidence", paramString);
      return this;
    }
    
    public a g(String paramString)
    {
      this.bundle.putString("user_input_param", paramString);
      return this;
    }
    
    public Bundle s()
    {
      return this.bundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqep
 * JD-Core Version:    0.7.0.1
 */