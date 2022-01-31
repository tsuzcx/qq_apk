package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopBarIconFlagEntity;
import com.tencent.mobileqq.data.TroopBarPageEntity.TypeListEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import hbs;
import hbt;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.request.Ticket;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarUtils
{
  public static final String A = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrkUA+dDEQT52svdheRw04+xrExuTvNj3g7pjcyUkH3+86FiYNhHtyWJc11BywUZ2Ey3RomCyTb/szl5qQEJqR7UC5z4mhLrhgXlbRI0BgmI/LhaMRsfskGM7ziyQ2ZpS0qbHX2xoum6ou/541/VePIwmcnIk6eWUx6GYnA4euZQIDAQAB";
  public static final String B = " ";
  public static final String C = "  ";
  public static final String D = "";
  protected static final String E = "刚刚";
  protected static final String F = "分钟前";
  protected static final String G = "MM-dd";
  protected static final String H = "HH:mm";
  protected static final String I = "昨天";
  protected static final String J = "前天";
  protected static final String K = "全部";
  protected static final String L = "精华";
  private static final String M = "&_wv=1031&_bid=128&platform=android&from=native&version=6.0.1";
  public static final int a = 20;
  public static final TroopBarPageEntity.TypeListEntity a;
  public static final String a = "TroopBar";
  protected static SimpleDateFormat a;
  public static final HashMap a;
  public static Hashtable a;
  public static final int b = 50;
  public static final TroopBarPageEntity.TypeListEntity b;
  public static final String b = "http://xiaoqu.qq.com/cgi-bin/bar/";
  public static final HashMap b;
  public static final int c = -1;
  public static final String c = "http://xiaoqu.qq.com/cgi-bin/bar/page";
  public static final HashMap c = new HashMap();
  protected static final int d = 60000;
  public static final String d = "http://xiaoqu.qq.com/cgi-bin/bar/user/fbar";
  protected static final int e = 86400000;
  public static final String e = "http://xiaoqu.qq.com/cgi-bin/bar/sign";
  protected static final int f = 1440;
  public static final String f = "http://xiaoqu.qq.com/cgi-bin/bar/get_category_post_by_page";
  protected static final int g = 2880;
  public static final String g = "http://xiaoqu.qq.com/cgi-bin/bar/get_best_post_by_page";
  public static final int h = 100000;
  public static final String h = "http://xiaoqu.qq.com/cgi-bin/bar/get_post_by_page";
  public static final int i = 100001;
  public static final String i = "http://xiaoqu.qq.com/cgi-bin/bar/jump?";
  public static final int j = 100003;
  public static final String j = "http://xiaoqu.qq.com/cgi-bin/bar/user/poilist";
  public static final int k = 100004;
  public static final String k = "http://xiaoqu.qq.com/cgi-bin/bar/mybarlist";
  public static final int l = 100012;
  public static final String l = "http://xiaoqu.qq.com/cgi-bin/bar/post/publish_v2";
  public static final int m = -1001;
  public static final String m = "http://xiaoqu.qq.com/cgi-bin/bar/post/recomment";
  public static final int n = -1002;
  public static final String n = "http://xiaoqu.qq.com/cgi-bin/bar/post/comment_v2";
  public static final int o = 0;
  public static final String o = "http://xiaoqu.qq.com/cgi-bin/bar/bar_publish_info";
  public static final int p = 1;
  public static final String p = "http://upload.buluo.qq.com/cgi-bin/bar/upload/image";
  public static final int q = 2;
  public static final String q = "action";
  public static final int r = 3;
  public static final String r = "info";
  public static final int s = 4;
  public static final String s = "all_bar";
  public static final int t = 5;
  public static final String t = "publish";
  public static final int u = 6;
  public static final String u = "qqweb_index";
  public static final int v = 7;
  public static final String v = "&_wv=1031";
  public static final int w = 8;
  public static final String w = "target=hot&_wv=1031";
  public static final String x = "http://xiaoqu.qq.com/cgi-bin/bar/jump?bid=%s";
  public static final String y = "QQ2013";
  public static final String z = "LWPAH-5CHEJ-Y6CR2-AQPLX-IV2JQ";
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity = new TroopBarPageEntity.TypeListEntity(-1001, "全部");
    jdField_b_of_type_ComTencentMobileqqDataTroopBarPageEntity$TypeListEntity = new TroopBarPageEntity.TypeListEntity(-1002, "精华");
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat();
    jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static final double a(JSONObject paramJSONObject, String paramString)
  {
    double d1 = -1.0D;
    if (paramJSONObject != null) {}
    try
    {
      d1 = paramJSONObject.getDouble(paramString);
      return d1;
    }
    catch (JSONException paramJSONObject) {}
    return -1.0D;
  }
  
  public static final int a(Resources paramResources)
  {
    try
    {
      int i1 = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      return i1;
    }
    catch (Exception localException) {}
    return (int)(paramResources.getDisplayMetrics().density * 25.0F + 0.5D);
  }
  
  public static final int a(JSONObject paramJSONObject, String paramString)
  {
    int i1 = -1;
    if (paramJSONObject != null) {}
    try
    {
      i1 = paramJSONObject.getInt(paramString);
      return i1;
    }
    catch (JSONException paramJSONObject) {}
    return -1;
  }
  
  public static final long a(JSONObject paramJSONObject, String paramString)
  {
    long l1 = -1L;
    if (paramJSONObject != null) {}
    try
    {
      l1 = paramJSONObject.getLong(paramString);
      return l1;
    }
    catch (JSONException paramJSONObject) {}
    return -1L;
  }
  
  public static final Rect a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    return new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }
  
  public static final Uri a(BaseActivity paramBaseActivity, String paramString, int paramInt)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {}
    for (boolean bool = true; (bool) && (paramString.canWrite()); bool = paramString.mkdirs())
    {
      paramString = Uri.fromFile(new File(AppConstants.ap + System.currentTimeMillis() + ".jpg"));
      Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
      localIntent.putExtra("output", paramString);
      localIntent.putExtra("android.intent.extra.videoQuality", 100);
      paramBaseActivity.startActivityForResult(localIntent, paramInt);
      return paramString;
    }
    if ((paramBaseActivity != null) && (!paramBaseActivity.isFinishing())) {
      QQToast.a(paramBaseActivity, 2131560748, 1).b(paramBaseActivity.d());
    }
    return null;
  }
  
  public static Entity a(Class paramClass, QQAppInterface paramQQAppInterface, String... paramVarArgs)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramClass = paramQQAppInterface.a(paramClass, paramVarArgs);
    if ((paramClass == null) && (QLog.isColorLevel())) {
      QLog.e("TroopBar", 2, "can't find troop  bar info!");
    }
    paramQQAppInterface.a();
    return paramClass;
  }
  
  public static final String a(long paramLong)
  {
    if (paramLong < 10000L) {
      return String.valueOf(paramLong);
    }
    if (paramLong < 100000000L) {
      return String.format("%.2f万", new Object[] { Float.valueOf((float)paramLong / 10000.0F) });
    }
    return String.format("%.2f亿", new Object[] { Float.valueOf((float)paramLong / 1.0E+008F) });
  }
  
  public static final String a(EditText paramEditText)
  {
    if (paramEditText == null) {
      return null;
    }
    if ((paramEditText.getEditableText() instanceof QQTextBuilder))
    {
      QQTextBuilder localQQTextBuilder = (QQTextBuilder)paramEditText.getEditableText();
      if (localQQTextBuilder != null) {
        return localQQTextBuilder.a();
      }
    }
    return paramEditText.getEditableText().toString();
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    WtloginManager localWtloginManager = (WtloginManager)paramAppInterface.getManager(1);
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramAppInterface.getAccount())) || (localWtloginManager == null)) {
      return null;
    }
    paramAppInterface = localWtloginManager.GetLocalTicket(paramAppInterface.getAccount(), 16L, 4096);
    if (paramAppInterface != null)
    {
      long l1 = System.currentTimeMillis() / 1000L;
      if ((l1 > paramAppInterface._create_time) && (l1 < paramAppInterface._expire_time - 600L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, "local skey available");
        }
        return new String(paramAppInterface._sig);
      }
    }
    return null;
  }
  
  public static final String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    long l2;
    long l1;
    do
    {
      long l5;
      do
      {
        long l4;
        try
        {
          l5 = 1000L * Long.valueOf(paramString).longValue();
          l2 = NetConnInfoCenter.getServerTime();
          l1 = l2;
          if (l2 <= 0L) {
            l1 = (int)MessageCache.a();
          }
          long l6 = l1 * 1000L;
          paramString = Calendar.getInstance();
          Calendar localCalendar = Calendar.getInstance();
          paramString.setTimeInMillis(l5);
          localCalendar.setTimeInMillis(l6);
          l4 = l5 / 86400000L;
          l3 = l5 / 60000L;
          l1 = l5 / 1000L;
          l5 = l6 / 60000L;
          l2 = l6 / 1000L;
          l6 /= 86400000L;
          if (paramString.before(localCalendar))
          {
            l4 = l6 - l4;
            if (l4 > 2L)
            {
              jdField_a_of_type_JavaTextSimpleDateFormat.applyPattern("MM-dd");
              return jdField_a_of_type_JavaTextSimpleDateFormat.format(paramString.getTime());
            }
            if (l4 == 2L)
            {
              jdField_a_of_type_JavaTextSimpleDateFormat.applyPattern("HH:mm");
              return "前天" + jdField_a_of_type_JavaTextSimpleDateFormat.format(paramString.getTime());
              if (l3 < 60L) {
                return l3 + "分钟前";
              }
              jdField_a_of_type_JavaTextSimpleDateFormat.applyPattern("HH:mm");
              return "昨天" + jdField_a_of_type_JavaTextSimpleDateFormat.format(paramString.getTime());
              if (l3 < 60L) {
                return l3 + "分钟前";
              }
              jdField_a_of_type_JavaTextSimpleDateFormat.applyPattern("HH:mm");
              return jdField_a_of_type_JavaTextSimpleDateFormat.format(paramString.getTime());
            }
          }
          else
          {
            jdField_a_of_type_JavaTextSimpleDateFormat.applyPattern("MM-dd");
            paramString = jdField_a_of_type_JavaTextSimpleDateFormat.format(paramString.getTime());
            return paramString;
          }
        }
        catch (Exception paramString)
        {
          return "";
        }
        if (l4 != 1L) {
          break;
        }
        l3 = l5 - l3;
      } while (l2 - l1 >= 60L);
      return "刚刚";
      long l3 = l5 - l3;
    } while (l2 - l1 >= 60L);
    return "刚刚";
  }
  
  public static final String a(JSONObject paramJSONObject, String paramString)
  {
    String str = "";
    if (paramJSONObject != null) {}
    try
    {
      str = paramJSONObject.getString(paramString);
      return str;
    }
    catch (JSONException paramJSONObject) {}
    return "";
  }
  
  public static List a(Class paramClass, QQAppInterface paramQQAppInterface, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramClass = paramQQAppInterface.a(paramClass, false, paramString1, paramArrayOfString, null, null, null, paramString2);
    if ((paramClass == null) && (QLog.isColorLevel())) {
      QLog.e("TroopBar", 2, "can't find troop  bar info!");
    }
    paramQQAppInterface.a();
    return paramClass;
  }
  
  public static final JSONObject a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (FileUtil.a(paramString1))
    {
      paramContext = new HashMap();
      paramContext.put("Connection", "keep-alive");
      paramContext.put("Referer", "http://www.qq.com");
      HashMap localHashMap1 = new HashMap();
      localHashMap1.put("file", paramString1);
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("file", paramString1);
      localHashMap2.put("type", "2");
      paramContext = HttpUtil.a("http://upload.buluo.qq.com/cgi-bin/bar/upload/image", paramString2, paramString3, localHashMap2, localHashMap1, paramContext);
      if (TextUtils.isEmpty(paramContext)) {
        return null;
      }
      try
      {
        paramContext = new JSONObject(paramContext);
        if (paramContext.getInt("retcode") == 0)
        {
          paramContext = paramContext.getJSONObject("result");
          return paramContext;
        }
      }
      catch (JSONException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, paramContext.getMessage());
        }
      }
    }
    return null;
  }
  
  protected static void a(Context paramContext, Bundle paramBundle1, HttpWebCgiAsyncTask.Callback paramCallback, String paramString1, String paramString2, String paramString3, int paramInt, Bundle paramBundle2, String paramString4)
  {
    if ((paramBundle1 == null) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    paramBundle1.putString("version", "6.0.1");
    paramBundle1.putString("platform", "android");
    paramBundle1.putString("Cookie", "uin=" + paramString2 + ";skey=" + paramString3);
    paramBundle1.putString("Referer", "http://xiaoqu.qq.com");
    paramString2 = new HashMap();
    paramString2.put("BUNDLE", paramBundle1);
    paramString2.put("CONTEXT", paramContext.getApplicationContext());
    new HttpWebCgiAsyncTask(paramString1, paramString4, paramCallback, paramInt, paramBundle2).execute(new HashMap[] { paramString2 });
  }
  
  public static void a(Context paramContext, String paramString, String... paramVarArgs)
  {
    if ((paramContext == null) || (paramString == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("http://xiaoqu.qq.com/cgi-bin/bar/jump?").append("action=").append(paramString).append("&_wv=1031&_bid=128&platform=android&from=native&version=6.0.1");
    if (paramVarArgs != null)
    {
      int i2 = paramVarArgs.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localStringBuilder.append(paramVarArgs[i1]);
        i1 += 1;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopBar", 4, "jumpPublicAccountBorswer--->url:" + localStringBuilder.toString());
    }
    paramString = new Intent(paramContext, PublicAccountBrowser.class).putExtra("url", localStringBuilder.toString());
    paramString.putExtra("hide_operation_bar", true);
    paramString.putExtra("hideRightButton", true);
    paramContext.startActivity(paramString);
  }
  
  public static final void a(Resources paramResources, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramViewGroup != null) && (paramLayoutInflater != null))
    {
      paramViewGroup.removeAllViews();
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        TroopBarIconFlagEntity localTroopBarIconFlagEntity = (TroopBarIconFlagEntity)paramArrayList.get(i1);
        TextView localTextView = (TextView)paramLayoutInflater.inflate(2130903406, null);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.leftMargin = ((int)paramResources.getDisplayMetrics().density * 3);
        TroopBarIconFlagEntity.setViewBackgroundColor(paramResources, localTextView, localTroopBarIconFlagEntity.icon_bg);
        TroopBarIconFlagEntity.setTextViewForegroundColor(localTextView, localTroopBarIconFlagEntity.icon_color);
        localTextView.setText(localTroopBarIconFlagEntity.icon_text);
        paramViewGroup.addView(localTextView, localLayoutParams);
        i1 += 1;
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, Bundle paramBundle1, String paramString, int paramInt, Bundle paramBundle2, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    a(paramBaseActivity, paramBundle1, paramString, paramInt, paramBundle2, paramCallback, "GET");
  }
  
  protected static void a(BaseActivity paramBaseActivity, Bundle paramBundle1, String paramString1, int paramInt, Bundle paramBundle2, HttpWebCgiAsyncTask.Callback paramCallback, String paramString2)
  {
    String str1 = paramBaseActivity.b.getAccount();
    String str2 = ((TicketManager)paramBaseActivity.b.getManager(2)).getSkey(str1);
    if (str2 != null) {
      a(paramBaseActivity, paramBundle1, paramCallback, paramString1, str1, str2, paramInt, paramBundle2, paramString2);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("TroopBar", 2, "httpGet skey is null!!!!!!!!!!!!!!!");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Entity paramEntity)
  {
    if ((paramQQAppInterface == null) || (paramEntity == null)) {
      return;
    }
    new Thread(new hbs(paramQQAppInterface, paramEntity)).start();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List paramList)
  {
    if ((paramQQAppInterface == null) || (paramList == null)) {}
    while (paramList.size() == 0) {
      return;
    }
    new Thread(new hbt(paramQQAppInterface, paramList)).start();
  }
  
  public static final void a(String paramString1, String paramString2, String paramString3)
  {
    a("tribe_hp", paramString1, paramString2, paramString3, "", "");
  }
  
  public static final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(null, "P_CliOper", "Grp_tribe", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Class paramClass, String paramString, String[] paramArrayOfString)
  {
    for (;;)
    {
      try
      {
        Object localObject = ((Entity)paramClass.newInstance()).getTableName();
        paramClass = paramQQAppInterface.a().createEntityManager();
        localObject = new StringBuilder().append("DELETE FROM ").append((String)localObject);
        if (!TextUtils.isEmpty(paramString))
        {
          paramQQAppInterface = " WHERE " + paramString;
          boolean bool = paramClass.a(paramQQAppInterface, paramArrayOfString);
          paramClass.a();
          return bool;
        }
      }
      catch (InstantiationException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return false;
      }
      catch (IllegalAccessException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return false;
      }
      paramQQAppInterface = "";
    }
  }
  
  public static byte[] a(Object paramObject)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramObject);
      paramObject = localByteArrayOutputStream.toByteArray();
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      return paramObject;
    }
    catch (IOException paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  public static final String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBar", 2, "scalePublishImage imagePath is null!!!");
      }
    }
    for (;;)
    {
      return null;
      File localFile = new File(paramString);
      if (!localFile.exists())
      {
        if (QLog.isColorLevel())
        {
          QLog.d("TroopBar", 2, "scalePublishImage file not exists!!!");
          return null;
        }
      }
      else
      {
        if (localFile.length() < 2097152L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopBar", 2, "scalePublishImage file.length() is " + localFile.length() + ", no need to scale.");
          }
          return paramString;
        }
        paramString = ImageUtil.b(paramString, 1280);
        if (paramString != null) {}
        for (paramString = ImageUtil.a(paramString); !TextUtils.isEmpty(paramString); paramString = null) {
          return paramString;
        }
      }
    }
  }
  
  public static void b(BaseActivity paramBaseActivity, Bundle paramBundle1, String paramString, int paramInt, Bundle paramBundle2, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    a(paramBaseActivity, paramBundle1, paramString, paramInt, paramBundle2, paramCallback, "POST");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBarUtils
 * JD-Core Version:    0.7.0.1
 */