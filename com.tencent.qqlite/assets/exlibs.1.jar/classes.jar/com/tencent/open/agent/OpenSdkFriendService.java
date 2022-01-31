package com.tencent.open.agent;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.datamodel.FriendGroup;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.open.component.cache.CacheManager;
import com.tencent.open.component.cache.database.DbCacheManager;
import com.tencent.open.component.cache.database.DbCacheService;
import com.tencent.open.settings.OpensdkPreference;
import com.tencent.open.settings.ServerSetting;
import fbq;
import java.util.ArrayList;
import java.util.List;

public class OpenSdkFriendService
{
  protected static final int a = 888800;
  protected static OpenSdkFriendService a;
  protected static final String a = "OpenSdkFriendService";
  public static final int b = 888801;
  protected static final String b = "invite_friend_list";
  public static final int c = 888802;
  protected static final String c = "invite_friend_list_md5";
  protected static final String d = "time";
  protected static final String e = "prefer_last_avatar_update_time";
  protected long a;
  protected Bundle a;
  protected OpenSdkFriendService.CheckAvatarUpdateListener a;
  protected HttpCgiAsyncTask a;
  protected DbCacheManager a;
  public String f;
  protected String g;
  protected String h;
  public String i;
  
  static
  {
    jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService = null;
  }
  
  public static OpenSdkFriendService a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService == null) {
        jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService = new OpenSdkFriendService();
      }
      OpenSdkFriendService localOpenSdkFriendService = jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService;
      return localOpenSdkFriendService;
    }
    finally {}
  }
  
  public ArrayList a()
  {
    int j = 0;
    if (this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager == null) {
      return new ArrayList(0);
    }
    int k = this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager.a();
    ArrayList localArrayList = new ArrayList(k);
    while (j < k)
    {
      localArrayList.add((FriendGroup)this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager.a(j));
      j += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$CheckAvatarUpdateListener = null;
    this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask.a();
  }
  
  public void a(Bundle paramBundle, OpenSdkFriendService.GetFriendInfoListener paramGetFriendInfoListener, String paramString)
  {
    if ((paramBundle == null) || (paramGetFriendInfoListener == null))
    {
      LogUtility.e("OpenSdkFriendService", "getFriendListAsync params error. params=" + paramBundle + "; listener=" + paramGetFriendInfoListener);
      return;
    }
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.i = paramString;
    if ("action_invite".equals(paramString))
    {
      paramString = ServerSetting.a().a("http://fusion.qq.com/cgi-bin/qzapps/mappinvite_getqqlist.cgi");
      paramBundle.putString("md5str", OpensdkPreference.a(CommonDataAdapter.a().a(), "invite_friend_list_md5").getString(this.g, ""));
    }
    for (;;)
    {
      this.h = paramString;
      this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask = new HttpCgiAsyncTask(paramString, "GET", new OpenSdkFriendService.GetFriendListCallback(this, paramGetFriendInfoListener));
      this.jdField_a_of_type_ComTencentOpenBaseHttpHttpCgiAsyncTask.a(paramBundle);
      return;
      if ("action_story".equals(paramString))
      {
        paramString = ServerSetting.a().a("http://fusion.qq.com/cgi-bin/appstage/mapp_getqqlist.cgi");
        paramBundle.putString("needhttpcache", "nothing");
      }
      else if ("action_voice".equals(paramString))
      {
        paramString = ServerSetting.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else if ("action_reactive".equals(paramString))
      {
        paramString = ServerSetting.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
      else
      {
        paramString = ServerSetting.a().a("http://appic.qq.com/cgi-bin/appstage/mapp_friendslist.cgi");
      }
    }
  }
  
  public void a(Handler paramHandler)
  {
    new Handler(Looper.getMainLooper()).post(new fbq(this, paramHandler));
  }
  
  public void a(String paramString)
  {
    if ("action_invite".equals(this.i))
    {
      SharedPreferences.Editor localEditor = OpensdkPreference.a(CommonDataAdapter.a().a(), "invite_friend_list_md5").edit();
      localEditor.putString(this.g, paramString);
      localEditor.commit();
    }
  }
  
  public void a(String paramString, Bundle paramBundle, OpenSdkFriendService.CheckAvatarUpdateListener paramCheckAvatarUpdateListener)
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenSdkFriendService$CheckAvatarUpdateListener = paramCheckAvatarUpdateListener;
    paramBundle.putString("time", OpensdkPreference.a(CommonDataAdapter.a().a(), "prefer_last_avatar_update_time").getString(this.g, "0"));
    new HttpCgiAsyncTask(paramString, "GET", new OpenSdkFriendService.CheckAvatarUpdateCallback(this)).a(paramBundle);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    for (;;)
    {
      try
      {
        LogUtility.e("OpenSdkFriendService", "initData error. appid=" + paramString1 + "; openid=" + paramString2);
        return;
      }
      finally {}
      this.jdField_a_of_type_Long = Long.parseLong(OpensdkPreference.a(CommonDataAdapter.a().a(), "uin_openid_store").getString(paramString2, ""));
      this.f = paramString1;
      this.g = paramString2;
      try
      {
        this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager = CacheManager.a().a(FriendGroup.class, this.jdField_a_of_type_Long, "invite_friend_list_" + this.g);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public void a(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager == null) {
      return;
    }
    FriendGroup[] arrayOfFriendGroup = new FriendGroup[paramList.size()];
    paramList.toArray(arrayOfFriendGroup);
    this.jdField_a_of_type_ComTencentOpenComponentCacheDatabaseDbCacheManager.a(arrayOfFriendGroup, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkFriendService
 * JD-Core Version:    0.7.0.1
 */