package com.tencent.biz.lebasearch;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.common.app.AppInterface;
import com.tencent.map.lbsapi.api.SOSOMapLBSApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.ExtensionRequestInfo;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.PluginState;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.RequestBody;
import com.tencent.mobileqq.dynamic_search.mobileqq_dynamic_search.RootSearcherRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import nr;
import ns;
import nt;
import nu;
import nv;
import nw;
import nx;
import ny;
import nz;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchProtocol
{
  private static float a = -1.0F;
  public static final int a = 1;
  public static long a = 0L;
  public static final String a = "DynSearchSvc.Search";
  private static float b = -1.0F;
  public static final int b = 2;
  public static final long b = 7200000L;
  public static final String b = "data";
  public static final int c = 3;
  public static final long c = 600000L;
  public static final String c = "cmd";
  public static final int d = 4;
  public static final String d = "result_type";
  public static final int e = 0;
  public static final String e = "result_name";
  public static final int f = -1;
  public static final String f = "total_count";
  public static final String g = "result_extension";
  public static final String h = "jump_url";
  public static final String i = "pic_url";
  public static final String j = "name";
  public static final String k = "keyword";
  public static final String l = "more_url";
  public static final String m = "more_name";
  public static final String n = "active_search_home_hot_word";
  public static final String o = "active_search_home_hot_word_id";
  public static final String p = "active_search_home_hot_word_time";
  public static final String q = "active_search_hot_words";
  public static final String r = "active_search_hot_words_time";
  public static final String s = "search_lbs_timestamp";
  public static final String t = "search_lbs_latitude";
  public static final String u = "search_lbs_logitude";
  private static final String v = "SearchProtocol";
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
    if (System.currentTimeMillis() - paramQQAppInterface.getLong("search_lbs_timestamp", 0L) > 7200000L)
    {
      SOSOMapLBSApi.getInstance().requestLocationUpdate(paramContext, new nr(1, 1, 1, 8, paramQQAppInterface));
      return;
    }
    a = paramQQAppInterface.getFloat("search_lbs_latitude", 0.0F);
    b = paramQQAppInterface.getFloat("search_lbs_logitude", 0.0F);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, SearchProtocol.SearchObserver paramSearchObserver)
  {
    if ((paramAppInterface == null) || (paramSearchObserver == null)) {
      return;
    }
    paramContext = new nu(Looper.getMainLooper(), paramSearchObserver);
    paramSearchObserver = paramAppInterface.a().getSharedPreferences(paramAppInterface.getAccount(), 0);
    if (System.currentTimeMillis() - paramSearchObserver.getLong("active_search_home_hot_word_time", 0L) < 600000L)
    {
      paramAppInterface = paramContext.obtainMessage();
      paramAppInterface.arg1 = 0;
      paramAppInterface.obj = b(paramSearchObserver);
      paramContext.sendMessage(paramAppInterface);
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramAppInterface.a(), ProtoServlet.class);
    localNewIntent.putExtra("cmd", "DynSearchSvc.Search");
    mobileqq_dynamic_search.RequestBody localRequestBody = new mobileqq_dynamic_search.RequestBody();
    localRequestBody.cmd.set(3);
    if (paramSearchObserver.contains("active_search_home_hot_word_id"))
    {
      localObject = paramSearchObserver.getString("active_search_home_hot_word_id", "");
      if (!((String)localObject).equals("")) {
        localRequestBody.result_id.set(ByteStringMicro.copyFromUtf8((String)localObject));
      }
    }
    Object localObject = new mobileqq_dynamic_search.RootSearcherRequest();
    ((mobileqq_dynamic_search.RootSearcherRequest)localObject).business.set(128);
    localRequestBody.search_request.set((MessageMicro)localObject);
    localNewIntent.putExtra("data", localRequestBody.toByteArray());
    localNewIntent.setObserver(new nv(paramContext, paramSearchObserver));
    paramAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, SearchProtocol.SearchObserver paramSearchObserver, String paramString)
  {
    if ((paramAppInterface == null) || (paramSearchObserver == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramContext = new ny(Looper.getMainLooper(), paramSearchObserver);
    paramSearchObserver = new NewIntent(paramAppInterface.a(), ProtoServlet.class);
    paramSearchObserver.putExtra("cmd", "DynSearchSvc.Search");
    mobileqq_dynamic_search.RequestBody localRequestBody = new mobileqq_dynamic_search.RequestBody();
    localRequestBody.cmd.set(2);
    localRequestBody.key_word.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new mobileqq_dynamic_search.RootSearcherRequest();
    paramString.business.set(128);
    localRequestBody.search_request.set(paramString);
    paramSearchObserver.putExtra("data", localRequestBody.toByteArray());
    paramSearchObserver.setObserver(new nz(paramContext));
    paramAppInterface.startServlet(paramSearchObserver);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, SearchProtocol.SearchObserver paramSearchObserver, String paramString, List paramList)
  {
    if ((paramAppInterface == null) || (paramSearchObserver == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramContext = new ns(Looper.getMainLooper(), paramSearchObserver);
    paramSearchObserver = new NewIntent(paramAppInterface.a(), ProtoServlet.class);
    paramSearchObserver.putExtra("cmd", "DynSearchSvc.Search");
    mobileqq_dynamic_search.RequestBody localRequestBody = new mobileqq_dynamic_search.RequestBody();
    localRequestBody.cmd.set(4);
    localRequestBody.key_word.set(ByteStringMicro.copyFromUtf8(paramString));
    mobileqq_dynamic_search.RootSearcherRequest localRootSearcherRequest = new mobileqq_dynamic_search.RootSearcherRequest();
    localRootSearcherRequest.business.set(128);
    localRootSearcherRequest.busi_mask.set(-1L);
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      LebaViewItem localLebaViewItem = (LebaViewItem)paramList.next();
      mobileqq_dynamic_search.PluginState localPluginState = new mobileqq_dynamic_search.PluginState();
      localPluginState.plugin_id.set((int)localLebaViewItem.jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.uiResId);
      if (localLebaViewItem.jdField_a_of_type_Byte == 0) {
        localPluginState.plugin_switch.set(1);
      }
      for (;;)
      {
        localArrayList.add(localPluginState);
        break;
        if (localLebaViewItem.jdField_a_of_type_Byte == 1) {
          localPluginState.plugin_switch.set(0);
        }
      }
    }
    localRootSearcherRequest.plugin_state.set(localArrayList);
    localRequestBody.search_request.set(localRootSearcherRequest);
    if (a != -1.0F)
    {
      paramList = new mobileqq_dynamic_search.ExtensionRequestInfo();
      paramList.latitude.set(a);
      paramList.longitude.set(b);
      localRequestBody.extension_request_info.set(paramList);
    }
    paramSearchObserver.putExtra("data", localRequestBody.toByteArray());
    paramSearchObserver.setObserver(new nt(paramString, paramContext));
    paramAppInterface.startServlet(paramSearchObserver);
  }
  
  private static SearchProtocol.WordItem b(SharedPreferences paramSharedPreferences)
  {
    SearchProtocol.WordItem localWordItem = new SearchProtocol.WordItem();
    localWordItem.a = paramSharedPreferences.getString("active_search_home_hot_word", "");
    localWordItem.b = paramSharedPreferences.getString("active_search_home_hot_word_id", "");
    return localWordItem;
  }
  
  private static List b(SharedPreferences paramSharedPreferences)
  {
    localArrayList = new ArrayList();
    paramSharedPreferences = paramSharedPreferences.getString("active_search_hot_words", "");
    if (!TextUtils.isEmpty(paramSharedPreferences)) {
      try
      {
        JSONArray localJSONArray = new JSONArray(paramSharedPreferences);
        int i1 = 0;
        while (i1 < localJSONArray.length())
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i1);
          SearchProtocol.WordItem localWordItem = new SearchProtocol.WordItem();
          localWordItem.b = localJSONObject.getString("id");
          localWordItem.a = localJSONObject.getString("word");
          localArrayList.add(localWordItem);
          i1 += 1;
        }
        return localArrayList;
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SearchProtocol", 2, "JSONException tips = " + paramSharedPreferences);
        }
      }
    }
  }
  
  private static void b(SharedPreferences paramSharedPreferences, List paramList)
  {
    JSONArray localJSONArray;
    if (paramList.size() != 0)
    {
      localJSONArray = new JSONArray();
      paramList = paramList.iterator();
    }
    for (;;)
    {
      SearchProtocol.WordItem localWordItem;
      JSONObject localJSONObject;
      if (paramList.hasNext())
      {
        localWordItem = (SearchProtocol.WordItem)paramList.next();
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("word", localWordItem.a);
        localJSONObject.put("id", localWordItem.b);
        label78:
        localJSONArray.put(localJSONObject);
        continue;
        paramSharedPreferences.edit().putString("active_search_hot_words", localJSONArray.toString()).commit();
        paramSharedPreferences.edit().putLong("active_search_hot_words_time", System.currentTimeMillis()).commit();
        return;
      }
      catch (JSONException localJSONException)
      {
        break label78;
      }
    }
  }
  
  public static void b(AppInterface paramAppInterface, Context paramContext, SearchProtocol.SearchObserver paramSearchObserver)
  {
    if ((paramAppInterface == null) || (paramSearchObserver == null)) {
      return;
    }
    paramContext = new nw(Looper.getMainLooper(), paramSearchObserver);
    paramSearchObserver = paramAppInterface.a().getSharedPreferences(paramAppInterface.getAccount(), 0);
    long l1 = System.currentTimeMillis();
    long l2 = paramSearchObserver.getLong("active_search_hot_words_time", 0L);
    if (Long.valueOf(l1).longValue() - Long.valueOf(l2).longValue() < 600000L)
    {
      paramAppInterface = b(paramSearchObserver);
      paramSearchObserver = paramContext.obtainMessage();
      paramSearchObserver.arg1 = 0;
      paramSearchObserver.obj = paramAppInterface;
      paramContext.sendMessage(paramSearchObserver);
      return;
    }
    NewIntent localNewIntent = new NewIntent(paramAppInterface.a(), ProtoServlet.class);
    localNewIntent.putExtra("cmd", "DynSearchSvc.Search");
    mobileqq_dynamic_search.RequestBody localRequestBody = new mobileqq_dynamic_search.RequestBody();
    localRequestBody.cmd.set(1);
    mobileqq_dynamic_search.RootSearcherRequest localRootSearcherRequest = new mobileqq_dynamic_search.RootSearcherRequest();
    localRootSearcherRequest.business.set(128);
    localRootSearcherRequest.busi_mask.set(-1L);
    localRequestBody.search_request.set(localRootSearcherRequest);
    localNewIntent.putExtra("data", localRequestBody.toByteArray());
    localNewIntent.setObserver(new nx(paramSearchObserver, paramContext));
    paramAppInterface.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.lebasearch.SearchProtocol
 * JD-Core Version:    0.7.0.1
 */