package com.tencent.biz.troop;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import bnl;
import bnm;
import bnn;
import bno;
import bnp;
import bnr;
import bns;
import bnt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"InlinedApi"})
public class TroopMemberApiPlugin
  extends WebViewPlugin
{
  public static final byte a = 1;
  public static final int a = 1;
  public static final String a = "http://web.p.qq.com/qqmpmobile/group/groupmembers";
  public static final int b = 2;
  public static final String b = "last_update_time";
  public static final int c = 3;
  public static final String c = "key_last_update_member_list_time";
  public static final int d = 4;
  public static final String d = "key_last_update_troop_info_time";
  public static final int e = 5;
  public static int h = 0;
  static int i = 0;
  static int j = 0;
  static int k = 0;
  static int l = 0;
  public static int m = 0;
  public static int n = 0;
  public static int o = 0;
  public static String q;
  static final String r = "com.tencent.qqhead.getheadreq";
  static final String s = "com.tencent.qqhead.getheadresp";
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bnl(this);
  public Handler a;
  public TroopMemberApiClient a;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqAppTroopObserver = new bno(this);
  public QQProgressNotifier a;
  public ArrayList a;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(jdField_j_of_type_Int);
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public JSONArray a;
  boolean jdField_a_of_type_Boolean;
  public ArrayList b;
  public HashMap b;
  public boolean b;
  public boolean c = false;
  boolean d = false;
  public String e;
  private boolean e;
  public int f;
  public String f;
  private boolean f;
  public int g;
  public String g;
  String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  String p;
  
  static
  {
    jdField_h_of_type_Int = -1;
    q = "";
    jdField_i_of_type_Int = 40;
    jdField_j_of_type_Int = 7;
    jdField_k_of_type_Int = 500;
    jdField_l_of_type_Int = 200;
    jdField_m_of_type_Int = 500;
    jdField_n_of_type_Int = 300000;
    jdField_o_of_type_Int = 86400000;
  }
  
  public TroopMemberApiPlugin()
  {
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
    this.jdField_a_of_type_AndroidOsHandler = new bnp(this);
  }
  
  private TroopMemberInfo a(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        Object localObject = this.mRuntime.a();
        if (localObject == null) {
          break label107;
        }
        localObject = ((AppInterface)localObject).a(((AppInterface)localObject).getAccount()).createEntityManager();
        if (localObject == null) {
          break label107;
        }
        try
        {
          paramString1 = ((EntityManager)localObject).a(TroopMemberInfo.class, false, "troopuin=? AND memberuin=?", new String[] { paramString1, paramString2 }, null, null, null, null);
          if ((paramString1 != null) && (paramString1.size() > 0))
          {
            paramString1 = (TroopMemberInfo)paramString1.get(0);
            ((EntityManager)localObject).a();
            return paramString1;
          }
        }
        finally {}
        paramString1 = null;
      }
      finally {}
      continue;
      label107:
      paramString1 = null;
    }
  }
  
  private String a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return "";
    }
    Object localObject1 = new Matrix();
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    float f1 = jdField_i_of_type_Int / (Math.max(i1, i2) * 1.0F);
    if ((f1 != 1.0F) && (f1 > 0.0F)) {}
    for (;;)
    {
      try
      {
        ((Matrix)localObject1).postScale(f1, f1);
        localObject1 = Bitmap.createBitmap(paramBitmap, 0, 0, i1, i2, (Matrix)localObject1, true);
        if (localObject1 != null) {
          break label192;
        }
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
        if (localObject1 != null) {
          ((Bitmap)localObject1).recycle();
        }
        return Base64Util.a(localByteArrayOutputStream.toByteArray(), 2);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, "compress :" + localException.getMessage());
        }
        Object localObject2 = null;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.TAG, 2, "compress :  scaleBitmap OOM");
        }
      }
      Object localObject3 = null;
      continue;
      label192:
      paramBitmap = localObject3;
    }
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = paramString.length();
    int i1 = 0;
    while (i1 < i2)
    {
      if ((paramString.charAt(i1) != ' ') && (paramString.charAt(i1) != ' ')) {
        localStringBuilder.append(paramString.charAt(i1));
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private String a(HashMap paramHashMap)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject = (Map.Entry)paramHashMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (Bitmap)((Map.Entry)localObject).getValue();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("uin", str);
        localJSONObject.put("imgStr", a((Bitmap)localObject));
        localJSONArray.put(localJSONObject);
      }
      paramHashMap = localJSONArray.toString();
      return paramHashMap;
    }
    catch (JSONException paramHashMap) {}
    return null;
  }
  
  public static JSONObject a(TroopMemberInfo paramTroopMemberInfo, Bundle paramBundle)
  {
    if (paramTroopMemberInfo != null) {
      try
      {
        if ((paramTroopMemberInfo.memberuin != null) && (paramTroopMemberInfo.memberuin.trim().length() > 0) && (!paramTroopMemberInfo.memberuin.trim().equalsIgnoreCase("0")) && (!paramTroopMemberInfo.memberuin.trim().equalsIgnoreCase("1000000")) && (!paramTroopMemberInfo.memberuin.trim().equalsIgnoreCase("10000")))
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("uin", paramTroopMemberInfo.memberuin);
          localJSONObject.put("displayName", paramBundle.getString("displayName"));
          String str = paramBundle.getString("displayNamePinyinAll");
          if (!TextUtils.isEmpty(str)) {
            localJSONObject.put("displayNamePinyinAll", str);
          }
          str = paramBundle.getString("displayNamePinyinFirst");
          if (!TextUtils.isEmpty(str)) {
            localJSONObject.put("displayNamePinyinFirst", str);
          }
          if (!TextUtils.isEmpty(paramTroopMemberInfo.friendnick))
          {
            localJSONObject.put("nickName", a(paramTroopMemberInfo.friendnick));
            if (paramTroopMemberInfo.pyAll_friendnick != null) {
              localJSONObject.put("nickNamePinyinAll", a(paramTroopMemberInfo.pyAll_friendnick));
            }
            if (paramTroopMemberInfo.pyFirst_friendnick != null) {
              localJSONObject.put("nickNamePinyinFirst", a(paramTroopMemberInfo.pyFirst_friendnick));
            }
          }
          str = paramBundle.getString("remark");
          if (!TextUtils.isEmpty(str))
          {
            localJSONObject.put("remark", str);
            str = paramBundle.getString("remarkPinyinAll");
            if (str != null) {
              localJSONObject.put("remarkPinyinAll", str);
            }
            str = paramBundle.getString("remarkPinyinFirst");
            if (str != null) {
              localJSONObject.put("remarkPinyinFirst", str);
            }
            if (TextUtils.isEmpty(paramTroopMemberInfo.troopnick)) {
              break label573;
            }
            localJSONObject.put("troopNick", a(paramTroopMemberInfo.troopnick));
            if (paramTroopMemberInfo.pyAll_friendnick != null) {
              localJSONObject.put("troopNickPinyinAll", a(paramTroopMemberInfo.pyAll_troopnick));
            }
            if (paramTroopMemberInfo.pyFirst_friendnick != null) {
              localJSONObject.put("troopNickPinyinFirst", a(paramTroopMemberInfo.pyFirst_troopnick));
            }
            label374:
            localJSONObject.put("lastActiveTime", paramTroopMemberInfo.last_active_time);
            localJSONObject.put("score", paramTroopMemberInfo.active_point);
            localJSONObject.put("joinTime", paramTroopMemberInfo.join_time);
            localJSONObject.put("creditLevel", paramTroopMemberInfo.credit_level);
            i1 = paramBundle.getInt("status", -1);
            if (i1 != -1) {
              localJSONObject.put("status", i1);
            }
            localJSONObject.put("level", paramTroopMemberInfo.level);
            paramBundle = paramBundle.getString("levelName");
            if (paramBundle != null) {
              localJSONObject.put("levelName", a(paramBundle));
            }
            if (!paramTroopMemberInfo.isTroopFollowed) {
              break label586;
            }
          }
          label573:
          label586:
          for (int i1 = 1;; i1 = 0)
          {
            localJSONObject.put("isFocus", i1);
            return localJSONObject;
            if (TextUtils.isEmpty(paramTroopMemberInfo.autoremark)) {
              break;
            }
            localJSONObject.put("remark", a(paramTroopMemberInfo.autoremark));
            if (paramTroopMemberInfo.pyAll_friendnick != null) {
              localJSONObject.put("remarkPinyinAll", a(paramTroopMemberInfo.pyAll_autoremark));
            }
            if (paramTroopMemberInfo.pyFirst_friendnick == null) {
              break;
            }
            localJSONObject.put("remarkPinyinFirst", a(paramTroopMemberInfo.pyFirst_autoremark));
            break;
            localJSONObject.put("troopNick", "");
            break label374;
          }
        }
        return null;
      }
      catch (JSONException paramTroopMemberInfo) {}
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = "";
    AppInterface localAppInterface = this.mRuntime.a();
    if (localAppInterface != null) {}
    for (;;)
    {
      int i2;
      try
      {
        localObject2 = localAppInterface.a(localAppInterface.getAccount()).createEntityManager();
        localObject1 = localObject3;
        if (localObject2 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("troopMember", 2, "start to query database, troopuin = " + paramString2);
          }
          localObject1 = ((EntityManager)localObject2).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString2 }, null, null, null, null);
          ((EntityManager)localObject2).a();
        }
        localObject2 = "6.0.2";
        if (localObject1 == null) {
          break;
        }
        i2 = ((List)localObject1).size();
        if (QLog.isColorLevel()) {
          QLog.d("troopMember", 2, "get member list from database and size is " + i2);
        }
        if ((this.jdField_e_of_type_Boolean) && (this.jdField_b_of_type_JavaUtilArrayList == null) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (((((String)localObject2).compareTo("4") < 0) && (i2 > jdField_l_of_type_Int)) || ((((String)localObject2).compareTo("4") >= 0) && (i2 > jdField_k_of_type_Int)))) {
          this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(i2);
        }
        if (QLog.isColorLevel()) {
          QLog.d("troopMember", 2, "start process member list data");
        }
        if (i2 > 1000)
        {
          bool = true;
          if (!bool) {
            break label365;
          }
          i1 = 1000;
          if (!bool) {
            break label371;
          }
          paramString2 = ((List)localObject1).subList(0, 1000);
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(paramString2, new bnr(this, i1, (List)localObject1, bool, paramString1));
          if (bool) {
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(((List)localObject1).subList(1000, i2), new bns(this, i2, (List)localObject1, paramString1));
          }
          return;
        }
      }
      finally {}
      boolean bool = false;
      continue;
      label365:
      int i1 = i2;
      continue;
      label371:
      paramString2 = (String)localObject1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("troopMember", 2, "send null data to web because get null from database");
    }
    callJs(paramString1, new String[] { "[]" });
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    TroopMemberInfo localTroopMemberInfo = a(paramString2, paramString3);
    if ((localTroopMemberInfo != null) && (localTroopMemberInfo.memberuin != null) && (localTroopMemberInfo.memberuin.trim().length() > 0) && (!localTroopMemberInfo.memberuin.trim().equalsIgnoreCase("0")))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localTroopMemberInfo);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(localArrayList, new bnt(this, localTroopMemberInfo, paramString1, paramString2, paramString3));
      return;
    }
    callJs(paramString1, new String[] { paramString2, paramString3, "null" });
  }
  
  Bitmap a(String paramString)
  {
    return BitmapFactory.decodeFile(QQAppInterface.a(paramString));
  }
  
  void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.qqhead.getheadresp");
      this.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier((BaseActivity)this.mRuntime.a());
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("troopMember".equals(paramString2))
    {
      paramString2 = this.mRuntime.a();
      paramJsBridgeListener = this.mRuntime.a();
      paramString1 = this.mRuntime.a();
      if ((paramJsBridgeListener == null) || (paramString1 == null) || (paramString2 == null) || (!paramString2.getUrl().startsWith("http://web.p.qq.com/qqmpmobile/group/groupmembers"))) {
        return true;
      }
      if (!"getMemberList".equals(paramString3)) {}
    }
    for (;;)
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        this.jdField_e_of_type_JavaLangString = paramJsBridgeListener.optString("troopUin");
        this.jdField_f_of_type_JavaLangString = paramJsBridgeListener.optString("troopCode");
        this.jdField_i_of_type_JavaLangString = paramJsBridgeListener.optString("callback");
        this.jdField_j_of_type_JavaLangString = paramJsBridgeListener.optString("faceCallback");
        this.jdField_k_of_type_JavaLangString = paramJsBridgeListener.optString("progressCallback");
        if ((!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))) {
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_e_of_type_JavaLangString, new bnm(this));
        }
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        return true;
      }
      if ("getMemberFace".equals(paramString3)) {}
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = paramString1.optJSONArray("uinList");
        this.jdField_l_of_type_JavaLangString = paramString1.optString("callback");
        if (paramJsBridgeListener == null) {
          return true;
        }
        this.d = false;
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        int i1 = 0;
        label245:
        if (i1 < paramJsBridgeListener.length()) {
          if (i1 != paramJsBridgeListener.length() - 1) {
            break label1291;
          }
        }
        label1282:
        label1291:
        for (boolean bool = true;; bool = false)
        {
          for (;;)
          {
            for (;;)
            {
              for (;;)
              {
                for (;;)
                {
                  for (;;)
                  {
                    this.d = bool;
                    paramString1 = paramJsBridgeListener.getString(i1);
                    if (paramString1 != null)
                    {
                      paramString2 = a(paramString1);
                      if (paramString2 != null)
                      {
                        this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
                        if ((this.jdField_a_of_type_JavaUtilHashMap.size() != jdField_j_of_type_Int) && (!this.d)) {
                          break label1282;
                        }
                        callJs(this.jdField_l_of_type_JavaLangString, new String[] { a(this.jdField_a_of_type_JavaUtilHashMap) });
                        this.jdField_a_of_type_JavaUtilHashMap.clear();
                        break label1282;
                      }
                      this.jdField_a_of_type_JavaUtilArrayList.add(paramString1);
                      break label1282;
                    }
                    if (!this.d) {
                      break label1282;
                    }
                    callJs(this.jdField_l_of_type_JavaLangString, new String[] { a(this.jdField_a_of_type_JavaUtilHashMap) });
                    this.jdField_a_of_type_JavaUtilHashMap.clear();
                    break label1282;
                    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
                    {
                      paramJsBridgeListener = new Intent("com.tencent.qqhead.getheadreq");
                      paramJsBridgeListener.putStringArrayListExtra("uinList", this.jdField_a_of_type_JavaUtilArrayList);
                      this.mRuntime.a().sendBroadcast(paramJsBridgeListener);
                    }
                    this.d = true;
                    break;
                    if ("addGroupMemberConcernedList".equals(paramString3)) {
                      try
                      {
                        paramString1 = new JSONObject(paramVarArgs[0]);
                        this.jdField_e_of_type_JavaLangString = paramString1.optString("troopUin");
                        paramJsBridgeListener = paramString1.optJSONArray("uinList");
                        this.jdField_m_of_type_JavaLangString = paramString1.optString("callback");
                        paramString1 = new long[paramJsBridgeListener.length()];
                        i1 = 0;
                        while (i1 < paramJsBridgeListener.length())
                        {
                          paramString1[i1] = Long.parseLong(paramJsBridgeListener.getString(i1));
                          i1 += 1;
                        }
                        if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null) {
                          break;
                        }
                        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(true, Long.parseLong(this.jdField_e_of_type_JavaLangString), paramString1);
                        ReportController.b(null, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_sf_by_sf", 0, 0, this.jdField_e_of_type_JavaLangString, "" + paramString1.length, "", "");
                        return true;
                      }
                      catch (JSONException paramJsBridgeListener)
                      {
                        return true;
                      }
                      catch (NumberFormatException paramJsBridgeListener)
                      {
                        return true;
                      }
                    }
                  }
                  if ("deleteGroupMemberConcernedList".equals(paramString3)) {
                    try
                    {
                      paramString1 = new JSONObject(paramVarArgs[0]);
                      this.jdField_e_of_type_JavaLangString = paramString1.optString("troopUin");
                      paramJsBridgeListener = paramString1.optJSONArray("uinList");
                      this.jdField_n_of_type_JavaLangString = paramString1.optString("callback");
                      paramString1 = new long[paramJsBridgeListener.length()];
                      i1 = 0;
                      while (i1 < paramJsBridgeListener.length())
                      {
                        paramString1[i1] = Long.parseLong(paramJsBridgeListener.getString(i1));
                        i1 += 1;
                      }
                      if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null) {
                        break;
                      }
                      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(false, Long.parseLong(this.jdField_e_of_type_JavaLangString), paramString1);
                      ReportController.b(null, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_unsf_by_sf", 0, 0, this.jdField_e_of_type_JavaLangString, "" + paramString1.length, "", "");
                      return true;
                    }
                    catch (JSONException paramJsBridgeListener)
                    {
                      return true;
                    }
                    catch (NumberFormatException paramJsBridgeListener)
                    {
                      return true;
                    }
                  }
                }
                if ("showTroopMemberCard".equals(paramString3)) {
                  try
                  {
                    paramString1 = new JSONObject(paramVarArgs[0]);
                    this.jdField_e_of_type_JavaLangString = paramString1.optString("troopUin");
                    this.g = paramString1.optString("uin");
                    this.p = paramString1.optString("callback");
                    jdField_h_of_type_Int = -1;
                    paramJsBridgeListener = new Intent(paramJsBridgeListener, TroopMemberCardActivity.class);
                    paramJsBridgeListener.putExtra("troopUin", this.jdField_e_of_type_JavaLangString);
                    paramJsBridgeListener.putExtra("memberUin", this.g);
                    paramJsBridgeListener.putExtra("fromFlag", 1);
                    startActivityForResult(paramJsBridgeListener, (byte)1);
                    ReportController.b(null, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_head", 1, 0, this.jdField_e_of_type_JavaLangString, this.g, "", "");
                  }
                  catch (JSONException paramJsBridgeListener)
                  {
                    return true;
                  }
                }
              }
              if ("kickGroupMember".equals(paramString3)) {
                for (;;)
                {
                  try
                  {
                    paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
                    this.jdField_e_of_type_JavaLangString = paramJsBridgeListener.optString("troopUin");
                    this.g = paramJsBridgeListener.optString("uin");
                    bool = paramJsBridgeListener.optString("shield").equals("1");
                    this.jdField_o_of_type_JavaLangString = paramJsBridgeListener.optString("callback");
                    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null) {
                      break;
                    }
                    long l1 = Long.parseLong(this.g);
                    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(Long.parseLong(this.jdField_e_of_type_JavaLangString), new long[] { l1 }, bool);
                    paramJsBridgeListener = this.jdField_e_of_type_JavaLangString;
                    paramString1 = new StringBuilder().append("");
                    if (bool)
                    {
                      i1 = 0;
                      ReportController.b(null, "P_CliOper", "Grp_mber", "", "manage_grp", "Clk_delmber_never", 0, 0, paramJsBridgeListener, i1, "", "");
                    }
                  }
                  catch (JSONException paramJsBridgeListener)
                  {
                    return true;
                  }
                  i1 = 1;
                }
              }
              if ("getTroopMemberInfo".equals(paramString3)) {
                try
                {
                  paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
                  this.jdField_e_of_type_JavaLangString = paramJsBridgeListener.optString("troopUin");
                  this.g = paramJsBridgeListener.optString("uin");
                  this.jdField_h_of_type_JavaLangString = paramJsBridgeListener.optString("callback");
                  a(this.jdField_h_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.g);
                }
                catch (JSONException paramJsBridgeListener)
                {
                  return true;
                }
              }
            }
            if (!"inviteMember".equals(paramString3)) {
              break;
            }
            try
            {
              paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
              this.jdField_e_of_type_JavaLangString = paramJsBridgeListener.optString("troopUin");
              bool = paramJsBridgeListener.optBoolean("isOwnerOrAdmin");
              ThreadManager.a(new bnn(this, paramString1, bool));
            }
            catch (JSONException paramJsBridgeListener)
            {
              return true;
            }
          }
          return false;
          i1 += 1;
          break label245;
        }
        return true;
      }
      catch (JSONException paramJsBridgeListener) {}
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    byte b1 = -1;
    Object localObject = this.mRuntime.a();
    AppInterface localAppInterface = this.mRuntime.a();
    if ((localObject == null) || (localAppInterface == null)) {}
    do
    {
      do
      {
        return;
      } while (paramInt != -1);
      switch (paramByte)
      {
      default: 
        return;
      }
      localObject = "";
      paramByte = b1;
      if (paramIntent != null)
      {
        paramByte = paramIntent.getIntExtra("memberOperationFlag", -1);
        localObject = paramIntent.getStringExtra("memberOperateUin");
      }
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = "";
      }
    } while (paramByte < 0);
    callJs(this.p, new String[] { this.jdField_e_of_type_JavaLangString, paramIntent, Integer.toString(paramByte) });
  }
  
  protected void onCreate()
  {
    AppInterface localAppInterface = this.mRuntime.a();
    Activity localActivity = this.mRuntime.a();
    if ((localAppInterface == null) || (localActivity == null)) {
      return;
    }
    this.jdField_e_of_type_JavaLangString = localActivity.getIntent().getStringExtra("troop_uin");
    a();
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_ComTencentMobileqqAppTroopObserver);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
      this.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiPlugin
 * JD-Core Version:    0.7.0.1
 */