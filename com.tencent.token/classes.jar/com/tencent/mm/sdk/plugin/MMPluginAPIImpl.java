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
    Object localObject = null;
    Cursor localCursor = this.q.getContentResolver().query(MMPluginProviderConstants.PluginDB.CONTENT_URI, columns, null, new String[] { paramString }, null);
    if (localCursor == null) {
      return null;
    }
    int i = localCursor.getColumnIndex("type");
    int j = localCursor.getColumnIndex("value");
    paramString = localObject;
    if (localCursor.moveToFirst()) {
      paramString = MMPluginProviderConstants.Resolver.resolveObj(localCursor.getInt(i), localCursor.getString(j));
    }
    localCursor.close();
    return paramString;
  }
  
  public boolean appendNetStat(int paramInt1, int paramInt2, int paramInt3)
  {
    return Util.nullAsFalse((Boolean)e("plugindb://" + this.am + "/action.appnetstat?recv=" + paramInt1 + "&send=" + paramInt2 + "&type=" + paramInt3));
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
    Object localObject = null;
    Cursor localCursor = this.q.getContentResolver().query(Profile.CONTENT_URI, Profile.columns, null, new String[] { paramString }, null);
    if (localCursor == null)
    {
      Log.e("MicroMsg.SDK.MMPluginMgrImpl", "get current profile failed");
      return null;
    }
    paramString = localObject;
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
    return (String)e("plugindb://" + paramString + "/comm.pluginkey");
  }
  
  public boolean installPlugin(String paramString)
  {
    return Util.nullAsFalse((Boolean)e("plugindb://" + paramString + "/action.install"));
  }
  
  public boolean isPluginInstalled(String paramString)
  {
    return Util.nullAsFalse((Boolean)e("plugindb://" + paramString + "/comm.installed"));
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
    return Util.nullAsFalse((Boolean)e("plugindb://" + this.am + "/action.automsg?pluginMsgUsername=" + paramString1 + "&pluginUsername=" + paramString2));
  }
  
  public boolean registerPattern(String paramString1, MMessage.CallBack paramCallBack, String paramString2)
  {
    return false;
  }
  
  public boolean registerQRCodePattern(String paramString1, MMessage.CallBack paramCallBack, String paramString2)
  {
    if (this.bF != null) {
      this.q.unregisterReceiver(this.bF);
    }
    this.bF = new MMessage.Receiver(paramCallBack);
    this.q.registerReceiver(this.bF, new IntentFilter("com.tencent.mm.sdk.plugin.Intent.ACTION_QRCODE_SCANNED"));
    return Util.nullAsFalse((Boolean)e("plugindb://" + paramString1 + "/action.register_qrcode_result?pattern=" + paramString2));
  }
  
  public void release()
  {
    Log.d("MicroMsg.SDK.MMPluginMgrImpl", "release plugin mgr implemetation");
    if (this.bF != null)
    {
      this.q.unregisterReceiver(this.bF);
      Log.d("MicroMsg.SDK.MMPluginMgrImpl", "unregister qrcode scan result receiver");
    }
  }
  
  public boolean sendMsgNotify(String paramString1, String paramString2, int paramInt, String paramString3, Class<?> paramClass)
  {
    if (paramClass == null) {
      return false;
    }
    return Util.nullAsFalse((Boolean)e("plugindb://" + this.am + "/action.msgnotify?username=" + paramString1 + "&msgContent=" + paramString2 + "&msgType=" + paramInt + "&customNotify=" + paramString3 + "&intentUri=" + Base64.encodeToString(new Intent(this.q, paramClass).toUri(0).getBytes(), false)));
  }
  
  public boolean unregisterAutoMsg(String paramString1, String paramString2)
  {
    return Util.nullAsFalse((Boolean)e("plugindb://" + this.am + "/action.unautomsg?pluginMsgUsername=" + paramString1 + "&pluginUsername=" + paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.MMPluginAPIImpl
 * JD-Core Version:    0.7.0.1
 */