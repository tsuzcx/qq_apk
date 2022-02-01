package com.tencent.android.tpush;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.e;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.Arrays;

public class XGPushProvider
  extends ContentProvider
{
  public static String AUTH_PRIX = ".XGVIP_PUSH_AUTH";
  public static final String TAG = "XGPushProvider";
  private Context a = null;
  private String b = null;
  private UriMatcher c = new UriMatcher(-1);
  
  private void a()
  {
    this.a = getContext().getApplicationContext();
    i.a(this.a);
    this.b = this.a.getPackageName();
    String str = this.b + AUTH_PRIX;
    this.c.addURI(str, TypeStr.config.getStr(), TypeStr.config.getType());
    this.c.addURI(str, TypeStr.config_all.getStr(), TypeStr.config_all.getType());
    this.c.addURI(str, TypeStr.msg.getStr(), TypeStr.msg.getType());
    this.c.addURI(str, TypeStr.msg_all.getStr(), TypeStr.msg_all.getType());
    this.c.addURI(str, TypeStr.hearbeat.getStr(), TypeStr.hearbeat.getType());
    this.c.addURI(str, TypeStr.hearbeat_all.getStr(), TypeStr.hearbeat_all.getType());
    this.c.addURI(str, TypeStr.feedback.getStr(), TypeStr.feedback.getType());
    this.c.addURI(str, TypeStr.feedback_all.getStr(), TypeStr.feedback_all.getType());
    this.c.addURI(str, TypeStr.token.getStr(), TypeStr.token.getType());
    this.c.addURI(str, TypeStr.register.getStr(), TypeStr.register.getType());
    this.c.addURI(str, TypeStr.insert_mid_new.getStr(), TypeStr.insert_mid_new.getType());
    this.c.addURI(str, TypeStr.insert_mid_old.getStr(), TypeStr.insert_mid_old.getType());
    this.c.addURI(str, TypeStr.pullupxg.getStr(), TypeStr.pullupxg.getType());
  }
  
  public static void fetchProviderAuthorities(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      ComponentName localComponentName = new ComponentName(str, XGPushProvider.class.getName());
      paramContext = paramContext.getPackageManager().getProviderInfo(localComponentName, 0);
      AUTH_PRIX = paramContext.authority.replace(str, "");
      TLogger.i("XGPushProvider", "name:" + paramContext.name + ", authority:" + paramContext.authority + ", AUTH_PRIX:" + AUTH_PRIX);
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.w("XGPushProvider", "unexpected for fetchProviderAuthorities", paramContext);
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    TLogger.w("XGPushProvider", "delete uri:" + paramUri + ",selection:" + paramString + ",selectionArgs:" + Arrays.toString(paramArrayOfString));
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    int i = this.c.match(paramUri);
    TLogger.i("XGPushProvider", "getType uri:" + paramUri + ",match:" + i);
    paramUri = TypeStr.getTypeStr(i);
    if (paramUri == null) {
      return null;
    }
    switch (XGPushProvider.1.a[paramUri.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return "CONFIG";
    case 2: 
      return "CONFIG_ALL";
    case 3: 
      e.a(this.a).a(false);
      return null;
    case 4: 
      TLogger.i("XGPushProvider", "Start XGService by provider");
      b.a(this.a);
      return null;
    case 5: 
      return "HEARTBEAT_ALL";
    case 6: 
      return GuidInfoManager.getToken(this.a);
    }
    paramUri = CacheManager.getCurrentAppRegisterEntity(this.a);
    TLogger.i("XGPushProvider", "get RegisterEntity:" + paramUri);
    return Rijndael.encrypt(RegisterEntity.encode(paramUri));
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    int i = this.c.match(paramUri);
    TypeStr localTypeStr = TypeStr.getTypeStr(i);
    if (localTypeStr == null) {
      return null;
    }
    TLogger.i("XGPushProvider", "insert uri:" + paramUri + ",match:" + i + ",values:" + paramContentValues);
    switch (XGPushProvider.1.a[localTypeStr.ordinal()])
    {
    case 9: 
    default: 
      return null;
    }
    try
    {
      paramUri = paramContentValues.getAsString("key");
      if (paramUri == null)
      {
        TLogger.e("XGPushProvider", "key is null");
        return null;
      }
    }
    catch (URISyntaxException paramUri)
    {
      paramUri.printStackTrace();
      return null;
    }
    paramUri = Intent.parseUri(paramUri, 0);
    paramUri.addCategory("android.intent.category.BROWSABLE");
    paramUri.setComponent(null);
    i = Build.VERSION.SDK_INT;
    if (i >= 15) {}
    try
    {
      paramUri.getClass().getMethod("setSelector", new Class[] { Intent.class }).invoke(paramUri, new Object[] { null });
      e.a(this.a).b(paramUri);
      return null;
    }
    catch (Throwable paramContentValues)
    {
      for (;;)
      {
        TLogger.w("XGPushProvider", "invoke intent.setComponent error.", paramContentValues);
      }
    }
  }
  
  public boolean onCreate()
  {
    TLogger.i("XGPushProvider", "XGPushProvider onCreate");
    a();
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    TLogger.i("XGPushProvider", "query uri:" + paramUri + ",projection:" + Arrays.toString(paramArrayOfString1) + ",selection:" + paramString1 + ",selectionArgs:" + Arrays.toString(paramArrayOfString2) + ",sortOrder:" + paramString2);
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    int i = this.c.match(paramUri);
    TypeStr localTypeStr = TypeStr.getTypeStr(i);
    if (localTypeStr == null) {
      return 0;
    }
    TLogger.i("XGPushProvider", "update uri:" + paramUri + ",values:" + paramContentValues + ",selection:" + paramString + ",selectionArgs:" + Arrays.toString(paramArrayOfString) + ",match:" + i);
    switch (XGPushProvider.1.a[localTypeStr.ordinal()])
    {
    case 11: 
    default: 
      return 0;
    }
    paramUri = Rijndael.decrypt(paramContentValues.getAsString("feedback"));
    TLogger.i("XGPushProvider", "feeback: " + paramUri);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushProvider
 * JD-Core Version:    0.7.0.1
 */