package com.tencent.mm.sdk.plugin;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import com.tencent.mm.algorithm.Base64;
import com.tencent.mm.sdk.channel.MMessage.CallBack;
import com.tencent.mm.sdk.channel.MMessage.Receiver;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class MMPluginAPIImpl
  implements IMMPluginAPI
{
  private static final String[] columns = { "key", "type", "value" };
  private String am;
  private MMessage.Receiver bF;
  private final Context q;
  
  public MMPluginAPIImpl(Context paramContext)
  {
    this.q = paramContext;
    this.am = paramContext.getPackageName();
  }
  
  private void a(String paramString1, String paramString2, Intent paramIntent)
  {
    paramString2 = new Intent(paramString2);
    paramString2.setClassName("com.tencent.mm", "com.tencent.mm.plugin.PluginProxyUI");
    if (paramIntent != null) {
      paramString2.putExtras(paramIntent);
    }
    paramString2.putExtra("com.tencent.mm.sdk.plugin.Intent.ACCESS_TOKEN", paramString1);
    this.q.startActivity(paramString2);
  }
  
  private Object e(String paramString)
  {
    Cursor localCursor = this.q.getContentResolver().query(MMPluginProviderConstants.PluginDB.CONTENT_URI, columns, null, new String[] { paramString }, null);
    paramString = null;
    if (localCursor == null) {
      return null;
    }
    int i = localCursor.getColumnIndex("type");
    int j = localCursor.getColumnIndex("value");
    if (localCursor.moveToFirst()) {
      paramString = MMPluginProviderConstants.Resolver.resolveObj(localCursor.getInt(i), localCursor.getString(j));
    }
    localCursor.close();
    return paramString;
  }
  
  public boolean appendNetStat(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder("plugindb://");
    localStringBuilder.append(this.am);
    localStringBuilder.append("/action.appnetstat?recv=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("&send=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("&type=");
    localStringBuilder.append(paramInt3);
    return Util.nullAsFalse((Boolean)e(localStringBuilder.toString()));
  }
  
  public void createMsgController(String paramString) {}
  
  public void createQRCodeController(String paramString)
  {
    a(paramString, "qrcode", null);
  }
  
  public void createQRCodeController(String paramString, MMessage.CallBack paramCallBack)
  {
    createQRCodeController(paramString, paramCallBack, "*");
  }
  
  public void createQRCodeController(String paramString1, MMessage.CallBack paramCallBack, String paramString2)
  {
    a(paramString1, "qrcode", new Intent().putExtra("qrcode_pattern", paramString2));
  }
  
  public Profile getCurrentProfile(String paramString)
  {
    Cursor localCursor = this.q.getContentResolver().query(Profile.CONTENT_URI, Profile.columns, null, new String[] { paramString }, null);
    paramString = null;
    if (localCursor == null)
    {
      Log.e("MicroMsg.SDK.MMPluginMgrImpl", "get current profile failed");
      return null;
    }
    if (localCursor.moveToFirst())
    {
      paramString = new Profile();
      paramString.convertFrom(localCursor);
    }
    localCursor.close();
    return paramString;
  }
  
  public String getPluginKey(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("plugindb://");
    localStringBuilder.append(paramString);
    localStringBuilder.append("/comm.pluginkey");
    return (String)e(localStringBuilder.toString());
  }
  
  public boolean installPlugin(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("plugindb://");
    localStringBuilder.append(paramString);
    localStringBuilder.append("/action.install");
    return Util.nullAsFalse((Boolean)e(localStringBuilder.toString()));
  }
  
  public boolean isPluginInstalled(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("plugindb://");
    localStringBuilder.append(paramString);
    localStringBuilder.append("/comm.installed");
    return Util.nullAsFalse((Boolean)e(localStringBuilder.toString()));
  }
  
  public void jumpToBindEmail(String paramString)
  {
    a(paramString, "bindemail", new Intent());
  }
  
  public void jumpToBindMobile(String paramString)
  {
    a(paramString, "bindmobile", new Intent());
  }
  
  public void jumpToBindQQ(String paramString)
  {
    a(paramString, "bindqq", new Intent());
  }
  
  public void jumpToChattingUI(String paramString1, String paramString2)
  {
    a(paramString1, "chatting", new Intent().putExtra("Contact_User", paramString2).setFlags(67108864));
  }
  
  public void jumpToSettingView(String paramString1, String paramString2)
  {
    a(paramString1, "profile", new Intent().putExtra("Contact_User", paramString2).setFlags(67108864));
  }
  
  public boolean registerAutoMsg(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("plugindb://");
    localStringBuilder.append(this.am);
    localStringBuilder.append("/action.automsg?pluginMsgUsername=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&pluginUsername=");
    localStringBuilder.append(paramString2);
    return Util.nullAsFalse((Boolean)e(localStringBuilder.toString()));
  }
  
  public boolean registerPattern(String paramString1, MMessage.CallBack paramCallBack, String paramString2)
  {
    return false;
  }
  
  public boolean registerQRCodePattern(String paramString1, MMessage.CallBack paramCallBack, String paramString2)
  {
    MMessage.Receiver localReceiver = this.bF;
    if (localReceiver != null) {
      this.q.unregisterReceiver(localReceiver);
    }
    this.bF = new MMessage.Receiver(paramCallBack);
    this.q.registerReceiver(this.bF, new IntentFilter("com.tencent.mm.sdk.plugin.Intent.ACTION_QRCODE_SCANNED"));
    paramCallBack = new StringBuilder("plugindb://");
    paramCallBack.append(paramString1);
    paramCallBack.append("/action.register_qrcode_result?pattern=");
    paramCallBack.append(paramString2);
    return Util.nullAsFalse((Boolean)e(paramCallBack.toString()));
  }
  
  public void release()
  {
    Log.d("MicroMsg.SDK.MMPluginMgrImpl", "release plugin mgr implemetation");
    MMessage.Receiver localReceiver = this.bF;
    if (localReceiver != null)
    {
      this.q.unregisterReceiver(localReceiver);
      Log.d("MicroMsg.SDK.MMPluginMgrImpl", "unregister qrcode scan result receiver");
    }
  }
  
  public boolean sendMsgNotify(String paramString1, String paramString2, int paramInt, String paramString3, Class<?> paramClass)
  {
    if (paramClass == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder("plugindb://");
    localStringBuilder.append(this.am);
    localStringBuilder.append("/action.msgnotify?username=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&msgContent=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("&msgType=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("&customNotify=");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("&intentUri=");
    localStringBuilder.append(Base64.encodeToString(new Intent(this.q, paramClass).toUri(0).getBytes(), false));
    return Util.nullAsFalse((Boolean)e(localStringBuilder.toString()));
  }
  
  public boolean unregisterAutoMsg(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("plugindb://");
    localStringBuilder.append(this.am);
    localStringBuilder.append("/action.unautomsg?pluginMsgUsername=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("&pluginUsername=");
    localStringBuilder.append(paramString2);
    return Util.nullAsFalse((Boolean)e(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.MMPluginAPIImpl
 * JD-Core Version:    0.7.0.1
 */