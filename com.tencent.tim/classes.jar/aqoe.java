import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class aqoe
{
  private static boolean cUT;
  public static boolean cUU;
  private static int eas = -1;
  private static int eat = -1;
  private static int eau = -1;
  private static int eav = -1;
  private static int eaw = -1;
  private static int eax = -1;
  
  public static String[] A(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    localObject = new StringBuilder(32);
    paramString = new ahqk(new StringReader(paramString));
    try
    {
      for (;;)
      {
        ahqg localahqg = paramString.a();
        if (localahqg == null) {
          break;
        }
        if (!TextUtils.isEmpty(localahqg.wu()))
        {
          ((StringBuilder)localObject).append(localahqg.wu());
          ((StringBuilder)localObject).append(' ');
        }
      }
      int i;
      return localObject;
    }
    catch (IOException paramString)
    {
      ((StringBuilder)localObject).setLength(0);
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "keywordSegment: failure", paramString);
      }
      paramString = new ArrayList();
      if (((StringBuilder)localObject).length() > 0) {
        paramString.add(((StringBuilder)localObject).toString().trim());
      }
      if (paramString.size() == 0) {
        return null;
      }
      localObject = new String[paramString.size()];
      i = 0;
      while (i < paramString.size())
      {
        localObject[i] = ((String)paramString.get(i));
        i += 1;
      }
    }
  }
  
  public static ArrayList<String> K(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.replaceAll("[^A-Za-z0-9\\u4e00-\\u9fa5]", " ").split("\\s");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length)
    {
      String str = paramString[i].trim();
      if ((str != null) && (!TextUtils.isEmpty(str))) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void S(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putInt("support_fts4_flag" + paramQQAppInterface.getCurrentAccountUin(), paramInt);
    localEditor.commit();
  }
  
  public static void T(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSystemSharedPreferences("fts_sp_file", 0).edit();
    paramQQAppInterface.putInt("fts_crash_count_by_hook", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static int a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (eav == -1) {
      eav = paramBaseApplicationImpl.getSharedPreferences("fts_sp_file", 0).getInt("fts_notify_flag" + paramBaseApplicationImpl.getRuntime().getAccount(), 0);
    }
    return eav;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putLong("fts_upgrade_cost" + paramQQAppInterface.getCurrentAccountUin(), paramLong1 + paramLong2);
    long l = paramLong1;
    if (localEditor.commit()) {
      l = paramLong1 + paramLong2;
    }
    return l;
  }
  
  public static Pair<CharSequence, CharSequence> a(ampt paramampt)
  {
    if ((paramampt instanceof amok)) {
      return ((amok)paramampt).s();
    }
    if ((paramampt instanceof amoj)) {
      return ((amoj)paramampt).s();
    }
    return null;
  }
  
  public static FTSMessage a(ContentValues paramContentValues, MessageRecord paramMessageRecord)
  {
    for (;;)
    {
      try
      {
        if (paramContentValues.containsKey("msgData"))
        {
          arrayOfByte = paramContentValues.getAsByteArray("msgData");
          if (arrayOfByte != null) {
            continue;
          }
          paramMessageRecord.msg = null;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        byte[] arrayOfByte;
        localUnsupportedEncodingException.printStackTrace();
        paramMessageRecord.msg = null;
        continue;
      }
      if (paramContentValues.containsKey("time")) {
        paramMessageRecord.time = paramContentValues.getAsLong("time").longValue();
      }
      if (paramContentValues.containsKey("shmsgseq")) {
        paramMessageRecord.shmsgseq = paramContentValues.getAsLong("shmsgseq").longValue();
      }
      return FTSMessageCodec.b(paramMessageRecord);
      paramMessageRecord.msg = new String(arrayOfByte, "UTF-8");
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    do
    {
      return paramString1;
      switch (paramInt)
      {
      default: 
        return aqgv.d(paramQQAppInterface, paramString1, paramInt);
      }
      if (acbn.bkD.equals(paramString1)) {
        return paramContext.getString(2131720683);
      }
      if (acbn.bkG.equals(paramString1)) {
        return paramContext.getString(2131720682);
      }
      if (acbn.bkB.equals(paramString1)) {
        return paramContext.getString(2131720758);
      }
      if (paramInt != 1000) {
        break;
      }
      paramContext = (TroopManager)paramQQAppInterface.getManager(52);
    } while (paramContext == null);
    return aqgv.a(paramQQAppInterface, paramString1, paramContext.jp(paramString2), paramString2, true, null);
    if (paramInt == 1004)
    {
      paramContext = aqgv.m(paramQQAppInterface, paramString2, paramString1);
      if ((paramContext != null) && (paramContext.equals(paramString1))) {
        return aqgv.b(paramQQAppInterface, paramString1, true);
      }
    }
    else
    {
      return aqgv.d(paramQQAppInterface, paramString1, paramInt);
    }
    return paramContext;
  }
  
  public static boolean a(ContentValues paramContentValues)
  {
    if ((paramContentValues.containsKey("msgtype")) && (paramContentValues.getAsInteger("msgtype").intValue() == -2006)) {}
    while ((paramContentValues.containsKey("isValid")) && (!paramContentValues.getAsBoolean("isValid").booleanValue())) {
      return true;
    }
    return false;
  }
  
  public static boolean aFl()
  {
    boolean bool = false;
    PackageManager localPackageManager = BaseApplicationImpl.getApplication().getPackageManager();
    try
    {
      int i = localPackageManager.getApplicationInfo(BaseApplicationImpl.getApplication().getPackageName(), 0).flags;
      if ((i & 0x40000) != 0) {
        bool = true;
      }
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("Q.fts.utils", 2, "isInstallOnSDCard: failure", localException);
    }
    return bool;
    return false;
  }
  
  public static boolean aFm()
  {
    if (cUU) {
      return cUT;
    }
    cUU = true;
    if (aFl())
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.fts.utils", 2, "QQ install on SDCard");
      }
      if (!ck((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_ROM", aqgz.getRomInfo());
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "actQQInstallExternal", true, -1L, 0L, (HashMap)localObject1, null, false);
        ak((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true);
      }
    }
    Object localObject1 = aqgz.getRomMemroy();
    if (QLog.isColorLevel()) {
      QLog.i("Q.fts.utils", 2, "Rom total size: " + localObject1[0] + " MB, Rom available size: " + localObject1[1] + " MB");
    }
    if (localObject1[0] == -1L)
    {
      cUT = true;
      return true;
    }
    try
    {
      Object localObject2 = BaseApplicationImpl.getApplication().getFilesDir().getPath();
      long l = Math.ceil(new File(((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("/")) + "/databases", BaseApplicationImpl.getApplication().getRuntime().getAccount() + ".db").length() / 1048576.0D);
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.utils", 2, "uin.db size: " + l + " MB");
      }
      if (localObject1[1] > 5L * l)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.fts.utils", 2, "NOT Low Rom For FTS");
        }
        cUT = false;
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.utils", 2, "IS Low Rom For FTS");
      }
      if (!cl((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("param_ROM", aqgz.getRomInfo());
        ((HashMap)localObject2).put("param_totalrom", String.valueOf(localObject1[0]));
        ((HashMap)localObject2).put("param_availrom", String.valueOf(localObject1[1]));
        ((HashMap)localObject2).put("param_dbsize", String.valueOf(l));
        anpc.a(BaseApplication.getContext()).collectPerformance(null, "actLowRomForFTS", true, -1L, 0L, (HashMap)localObject2, null, false);
        al((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true);
      }
      cUT = true;
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "isLowRomForFTS: failure", localException);
      }
      cUT = true;
    }
    return true;
  }
  
  public static void ai(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putBoolean("fts_upgrade_log_flag" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static int aj(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getInt("support_fts4_flag" + paramQQAppInterface.getCurrentAccountUin(), -1);
  }
  
  public static void aj(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putBoolean("fts_upgrade_table_flag" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static int ak(QQAppInterface paramQQAppInterface)
  {
    int i = aj(paramQQAppInterface);
    if (i == -1)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        S(paramQQAppInterface, 1);
        return 1;
      }
      S(paramQQAppInterface, 0);
      return 0;
    }
    return i;
  }
  
  public static void ak(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putBoolean("install_external_report_flag" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static int al(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getInt("fts_upgrade_tables" + paramQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  public static void al(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putBoolean("low_rom_for_fts_report_flag" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static int am(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getInt("fts_upgrade_msgs" + paramQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  public static void am(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putBoolean("hardware_support_fts_flag" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static int an(QQAppInterface paramQQAppInterface)
  {
    if (eas == -1) {
      eas = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getInt("fts_compare_flag" + paramQQAppInterface.getCurrentAccountUin(), 0);
    }
    return eas;
  }
  
  public static void an(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putBoolean("fts_first_flag" + paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
    localEditor.commit();
  }
  
  public static int ao(QQAppInterface paramQQAppInterface)
  {
    return BaseApplicationImpl.sApplication.getSystemSharedPreferences("fts_sp_file", 0).getInt("fts_crash_count_by_hook", 0);
  }
  
  public static int ap(QQAppInterface paramQQAppInterface)
  {
    if (eat == -1) {
      eat = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getInt("fts_extension_flag" + paramQQAppInterface.getCurrentAccountUin(), 1);
    }
    return eat;
  }
  
  public static int aq(QQAppInterface paramQQAppInterface)
  {
    if (eau == -1) {
      eau = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getInt("fts_extension_conversation_flag" + paramQQAppInterface.getCurrentAccountUin(), 0);
    }
    return eau;
  }
  
  public static int b(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putInt("fts_upgrade_tables" + paramQQAppInterface.getCurrentAccountUin(), paramInt1 + paramInt2);
    int i = paramInt1;
    if (localEditor.commit()) {
      i = paramInt1 + paramInt2;
    }
    return i;
  }
  
  public static boolean b(ContentValues paramContentValues)
  {
    if (paramContentValues.containsKey("msgData")) {}
    while ((paramContentValues.containsKey("time")) || (paramContentValues.containsKey("shmsgseq"))) {
      return true;
    }
    return false;
  }
  
  public static void bk(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0);
    paramQQAppInterface = ((SharedPreferences)localObject).edit();
    localObject = ((SharedPreferences)localObject).getAll().keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (str.endsWith(paramString)) {
        paramQQAppInterface.remove(str);
      }
    }
    paramQQAppInterface.commit();
  }
  
  private static int bu(Context paramContext)
  {
    int i = 0;
    paramContext = (Activity)paramContext;
    if ((paramContext instanceof FTSEntitySearchActivity)) {
      i = 2;
    }
    while (!(paramContext instanceof FTSEntitySearchDetailActivity)) {
      return i;
    }
    return 3;
  }
  
  public static int c(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    localEditor.putInt("fts_upgrade_msgs" + paramQQAppInterface.getCurrentAccountUin(), paramInt1 + paramInt2);
    int i = paramInt1;
    if (localEditor.commit()) {
      i = paramInt1 + paramInt2;
    }
    return i;
  }
  
  public static boolean cg(QQAppInterface paramQQAppInterface)
  {
    return (ak(paramQQAppInterface) == 1) && (!aFm());
  }
  
  public static boolean ch(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getBoolean("fts_upgrade_log_flag" + paramQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public static boolean ci(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getBoolean("fts_upgrade_table_flag" + paramQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public static boolean cj(QQAppInterface paramQQAppInterface)
  {
    return (ch(paramQQAppInterface)) && (ci(paramQQAppInterface));
  }
  
  public static boolean ck(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getBoolean("install_external_report_flag" + paramQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public static boolean cl(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getBoolean("low_rom_for_fts_report_flag" + paramQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public static boolean cm(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getBoolean("hardware_support_fts_flag" + paramQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public static boolean cn(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getBoolean("fts_first_flag" + paramQQAppInterface.getCurrentAccountUin(), true);
  }
  
  public static ArrayList<aqoe.b> d(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l1 = System.nanoTime();
    int m = paramString.length();
    int j = 0;
    int k = 0;
    int i;
    if (k < m)
    {
      if (paramString.charAt(k) < '') {}
      for (i = j + 1;; i = j + 2)
      {
        k += 1;
        j = i;
        break;
      }
    }
    m = j / 2 + 2;
    ArrayList localArrayList;
    Object localObject1;
    Object localObject2;
    if (j >= 3)
    {
      k = j * 2;
      localArrayList = new ArrayList();
      i = m;
      if (j >= 3)
      {
        localObject1 = paramQQAppInterface.getCurrentAccountUin();
        localObject2 = aqgv.b(paramQQAppInterface, (String)localObject1, true);
        if (!((String)localObject2).toLowerCase().startsWith(paramString.toLowerCase())) {
          break label428;
        }
        localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
        ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131167442)), 0, paramString.length(), 17);
        localArrayList.add(new aqoe.b((String)localObject1, 0, new Pair(localObject2, null)));
        i = m + 1;
      }
      label193:
      paramQQAppInterface = new amvg(paramQQAppInterface, 10001, 29, null);
      paramQQAppInterface.init();
      paramQQAppInterface = paramQQAppInterface.a(new amwt(paramString));
      if ((paramQQAppInterface == null) || (paramQQAppInterface.isEmpty())) {
        break label921;
      }
      j = 0;
      localObject1 = paramQQAppInterface.iterator();
    }
    label349:
    label369:
    for (;;)
    {
      label248:
      if (((Iterator)localObject1).hasNext())
      {
        paramString = (ampt)((Iterator)localObject1).next();
        if ((paramString.gN() & 0xFFFFFFFF & 0xFF000000) >> 24 != 2L) {
          if (localArrayList.size() < i)
          {
            if ((paramString.lk() == 0) || (paramString.lk() == 1004))
            {
              m = j + 1;
              paramQQAppInterface = a(paramString);
              localArrayList.add(new aqoe.b(paramString.getUin(), paramString.lk(), paramQQAppInterface));
              j = m;
              if (!QLog.isColorLevel()) {
                continue;
              }
              if (paramString.getUin() != null) {
                break label766;
              }
              paramQQAppInterface = "null";
              j = paramString.lk();
              if (paramString.getTitle() != null) {
                break label774;
              }
            }
            for (paramString = "null";; paramString = paramString.getTitle())
            {
              QLog.d("Q.fts.utils", 2, String.format("contactSearchForTopN, contact uin: %s, uinType: %d, matchTitle: %s", new Object[] { paramQQAppInterface, Integer.valueOf(j), paramString }));
              j = m;
              break label248;
              k = -1;
              break;
              if (((String)localObject1).toLowerCase().startsWith(paramString.toLowerCase()))
              {
                localObject3 = new SpannableStringBuilder("(" + (String)localObject1 + ")");
                ((SpannableStringBuilder)localObject3).setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131167442)), 1, paramString.length() + 1, 17);
                localArrayList.add(new aqoe.b((String)localObject1, 0, new Pair(localObject2, localObject3)));
                i = m + 1;
                break label193;
              }
              Object localObject3 = amxk.a((String)localObject2, paramString, 1);
              if (localObject3[0] == 0)
              {
                i = localObject3[1];
                localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
                ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131167442)), 0, i, 17);
                localArrayList.add(new aqoe.b((String)localObject1, 0, new Pair(localObject2, null)));
                i = m + 1;
                break label193;
              }
              localObject3 = amxk.a((String)localObject2, paramString, 2);
              i = m;
              if (localObject3[0] != 0) {
                break label193;
              }
              i = localObject3[1];
              localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
              ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131167442)), 0, i, 17);
              localArrayList.add(new aqoe.b((String)localObject1, 0, new Pair(localObject2, null)));
              i = m + 1;
              break label193;
              localArrayList.add(new aqoe.b(paramString.getUin(), paramString.lk(), null));
              m = j;
              break label349;
              label766:
              paramQQAppInterface = paramString.getUin();
              break label369;
            }
          }
          else if (j < k)
          {
            if ((paramString.lk() == 0) || (paramString.lk() == 1004))
            {
              paramQQAppInterface = a(paramString);
              localArrayList.add(new aqoe.b(paramString.getUin(), paramString.lk(), paramQQAppInterface));
              if (QLog.isColorLevel())
              {
                if (paramString.getUin() != null) {
                  break label905;
                }
                paramQQAppInterface = "null";
                m = paramString.lk();
                if (paramString.getTitle() != null) {
                  break label913;
                }
              }
              for (paramString = "null";; paramString = paramString.getTitle())
              {
                QLog.d("Q.fts.utils", 2, String.format("contactSearchForTopN, contact uin: %s, uinType: %d, matchTitle: %s", new Object[] { paramQQAppInterface, Integer.valueOf(m), paramString }));
                j += 1;
                break;
                paramQQAppInterface = paramString.getUin();
                break label849;
              }
            }
          }
        }
      }
    }
    label428:
    label849:
    long l2 = System.nanoTime();
    label774:
    label905:
    label913:
    label921:
    if (QLog.isColorLevel())
    {
      QLog.d("Q.fts.utils", 2, "contactSearchForTopN, cost: " + (l2 - l1) / 1000000L + "ms size: " + localArrayList.size() + " contactNum: " + i + " friendNum: " + k);
      i = 0;
      while (i < localArrayList.size())
      {
        QLog.i("Q.fts.utils", 2, "index = " + i + ", contactInfo = " + localArrayList.get(i));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static int fp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return 0;
      paramString = paramString.split(" ");
    } while (paramString == null);
    return paramString.length;
  }
  
  public static void iv(View paramView)
  {
    HashMap localHashMap = new HashMap();
    aqoe.a.eaA = bu(paramView.getContext());
    paramView = (Integer)paramView.getTag(2131381961);
    if (paramView != null) {}
    for (int i = paramView.intValue();; i = -1)
    {
      aqoe.a.itemPosition = i + 1;
      if (aqoe.a.itemType == 1)
      {
        aqoe.a.totalCost = aqoe.a.atr + (System.nanoTime() - aqoe.a.atq) / 1000000L;
        aqoe.a.atp = aqoe.a.ats + (System.nanoTime() - aqoe.a.dS) / 1000000L;
      }
      if (aqoe.a.eaB == 1)
      {
        aqoe.a.senderNum = -1;
        aqoe.a.friendNum = -1;
        aqoe.a.friendIndex = -1;
      }
      localHashMap.put("keyNum", String.valueOf(aqoe.a.eay));
      localHashMap.put("firstKeyLen", String.valueOf(aqoe.a.eaz));
      localHashMap.put("itemPage", String.valueOf(aqoe.a.eaA));
      localHashMap.put("itemSearchStrategy", String.valueOf(aqoe.a.eaB));
      localHashMap.put("itemPosition", String.valueOf(aqoe.a.itemPosition));
      localHashMap.put("itemType", String.valueOf(aqoe.a.itemType));
      localHashMap.put("itemUinType", String.valueOf(aqoe.a.eaC));
      if (aqoe.a.itemType == 1)
      {
        localHashMap.put("totalCost", String.valueOf(aqoe.a.totalCost));
        localHashMap.put("searchCost", String.valueOf(aqoe.a.atp));
      }
      localHashMap.put("senderNum", String.valueOf(aqoe.a.senderNum));
      localHashMap.put("friendNum", String.valueOf(aqoe.a.friendNum));
      localHashMap.put("friendIndex", String.valueOf(aqoe.a.friendIndex));
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actFtsItemClickEvent", true, aqoe.a.totalCost, aqoe.a.atp, localHashMap, "", false);
      if ((aqoe.a.itemType == 1) && (QLog.isColorLevel())) {
        QLog.d("Q.fts.utils", 2, "actFtsItemClickEvent: totalCost = " + aqoe.a.totalCost + ", searchCost = " + aqoe.a.atp);
      }
      return;
    }
  }
  
  public static String pJ(String paramString)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder(64);
        localahqj = new ahqj(new StringReader(paramString), paramString.length());
        paramString = null;
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder;
        ahqj localahqj;
        ahqg localahqg;
        localThrowable.printStackTrace();
        paramString = localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.fts.utils", 2, "tokenSegment: failure", localThrowable);
      }
      try
      {
        localahqg = localahqj.a();
        if (localahqg != null) {
          continue;
        }
        if ((paramString != null) && (TextUtils.equals(paramString.type(), "double")) && (!TextUtils.isEmpty(paramString.wu())))
        {
          localStringBuilder.append(paramString.wu().charAt(paramString.wu().length() - 1));
          localStringBuilder.append("*");
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.fts.utils", 2, "tokenSegment: failure", paramString);
        continue;
      }
      paramString = localStringBuilder.toString();
      return paramString;
      if ((paramString != null) && (TextUtils.equals(paramString.type(), "double")) && ((!TextUtils.equals(localahqg.type(), "double")) || (paramString.Fg() < localahqg.Ff())) && (!TextUtils.isEmpty(paramString.wu())))
      {
        localStringBuilder.append(paramString.wu().charAt(paramString.wu().length() - 1));
        localStringBuilder.append("*");
        localStringBuilder.append(' ');
      }
      if ((!TextUtils.isEmpty(localahqg.wu())) && ((!TextUtils.equals(localahqg.type(), "double")) || (localahqg.wu().length() != 1)))
      {
        localStringBuilder.append(localahqg.wu());
        localStringBuilder.append(' ');
      }
      paramString = localahqg;
    }
    return null;
  }
  
  public static long q(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getLong("fts_upgrade_cost" + paramQQAppInterface.getCurrentAccountUin(), 0L);
  }
  
  public static String[] z(String paramString)
  {
    int j = 0;
    Object localObject = K(paramString);
    if (localObject == null) {
      return null;
    }
    paramString = new ArrayList();
    int i = 0;
    while (i < ((ArrayList)localObject).size())
    {
      String str = pJ((String)((ArrayList)localObject).get(i));
      if (!TextUtils.isEmpty(str)) {
        paramString.add(str.trim());
      }
      i += 1;
    }
    if (paramString.size() == 0) {
      return null;
    }
    localObject = new String[paramString.size()];
    i = j;
    while (i < paramString.size())
    {
      localObject[i] = ((String)paramString.get(i));
      i += 1;
    }
    return localObject;
  }
  
  public static class a
  {
    public static long atp;
    public static long atq;
    public static long atr;
    public static long ats;
    public static boolean cUV;
    public static long dS;
    public static int eaA;
    public static int eaB;
    public static int eaC;
    public static int eay;
    public static int eaz;
    public static int friendIndex;
    public static int friendNum;
    public static int itemPosition;
    public static int itemType;
    public static int senderNum;
    public static long totalCost;
    
    public static void clear()
    {
      eay = 0;
      eaz = 0;
      eaA = 0;
      eaB = 0;
      itemPosition = 0;
      itemType = 0;
      eaC = 0;
      totalCost = 0L;
      atp = 0L;
      senderNum = 0;
      friendNum = 0;
      friendIndex = 0;
      atq = 0L;
      atr = 0L;
      dS = 0L;
      ats = 0L;
      cUV = false;
    }
  }
  
  public static class b
  {
    public Pair<CharSequence, CharSequence> r;
    public String uin;
    public int uinType;
    
    public b(String paramString, int paramInt, Pair<CharSequence, CharSequence> paramPair)
    {
      this.uin = paramString;
      this.uinType = paramInt;
      this.r = paramPair;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append("MsgSearchContactInfo{uin='").append(this.uin).append('\'').append(", uinType=").append(this.uinType).append(", matchTitle=[");
      if (this.r == null)
      {
        localObject = "null";
        return (String)localObject + "]" + '}';
      }
      StringBuilder localStringBuilder2 = new StringBuilder();
      if (this.r.first == null)
      {
        localObject = "null";
        label92:
        localStringBuilder2 = localStringBuilder2.append(localObject).append(", ");
        if (this.r.second != null) {
          break label142;
        }
      }
      label142:
      for (Object localObject = "null";; localObject = (CharSequence)this.r.second)
      {
        localObject = localObject;
        break;
        localObject = (CharSequence)this.r.first;
        break label92;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqoe
 * JD-Core Version:    0.7.0.1
 */