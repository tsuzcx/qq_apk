package cooperation.pluginbridge;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Xml;
import anot;
import aqhq;
import aqmj;
import avfw;
import avfw.d;
import avgt;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class BridgeHelper
  implements Runnable
{
  private static avgt jdField_a_of_type_Avgt;
  private static BridgeHelper jdField_a_of_type_CooperationPluginbridgeBridgeHelper;
  private static final byte[] cv = new byte[0];
  private static BroadcastReceiver mReceiver;
  private boolean dna;
  private AtomicBoolean eE = new AtomicBoolean(false);
  private int ewX;
  private Context mContext;
  private String mUin;
  private final HashMap<String, String> qz;
  
  private BridgeHelper(Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mUin = paramString;
    this.qz = new HashMap();
    this.eE.set(false);
  }
  
  public static BridgeHelper a(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("BridgeHelper", 2, "get GeneralEntryConfigManager instancegInstance:" + jdField_a_of_type_CooperationPluginbridgeBridgeHelper + "uin:" + paramString);
        }
        if (jdField_a_of_type_CooperationPluginbridgeBridgeHelper == null) {
          try
          {
            if (jdField_a_of_type_CooperationPluginbridgeBridgeHelper == null) {
              jdField_a_of_type_CooperationPluginbridgeBridgeHelper = new BridgeHelper(paramContext, paramString);
            }
            paramContext = jdField_a_of_type_CooperationPluginbridgeBridgeHelper;
            return paramContext;
          }
          finally {}
        }
        if (TextUtils.isEmpty(paramString)) {
          break label123;
        }
      }
      finally {}
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(jdField_a_of_type_CooperationPluginbridgeBridgeHelper.mUin)))
      {
        label123:
        jdField_a_of_type_CooperationPluginbridgeBridgeHelper.eE.set(false);
        jdField_a_of_type_CooperationPluginbridgeBridgeHelper.dna = false;
        jdField_a_of_type_CooperationPluginbridgeBridgeHelper.mUin = paramString;
        jdField_a_of_type_CooperationPluginbridgeBridgeHelper.qz.clear();
      }
    }
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    if ((paramActivity != null) && (paramQQAppInterface != null))
    {
      if (((avfw)paramQQAppInterface.getManager(27)).isPlugininstalled("BridgePlugin.apk")) {
        b(paramActivity, paramQQAppInterface, paramIntent, paramString1, paramString2, paramString3);
      }
    }
    else {
      return;
    }
    if (paramIntent == null) {
      paramIntent = new Intent(paramActivity, BridgePluginInstallActivity.class);
    }
    for (;;)
    {
      paramIntent.putExtra("distParamsString", paramString1);
      paramIntent.putExtra("distPluginId", paramString2);
      paramIntent.putExtra("distPluginName", paramString3);
      paramActivity.startActivity(paramIntent);
      return;
      paramIntent.setClass(paramActivity, BridgePluginInstallActivity.class);
    }
  }
  
  static void b(Activity paramActivity, QQAppInterface paramQQAppInterface, Intent paramIntent, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("param_plugin_gesturelock", true);
    localIntent.putExtra("userQqResources", -1);
    localIntent.putExtra("useSkinEngine", true);
    paramIntent = new avfw.d(1);
    paramIntent.mPluginID = "BridgePlugin.apk";
    paramIntent.mPluginName = "BridgePlugin";
    if (jdField_a_of_type_Avgt == null) {
      jdField_a_of_type_Avgt = new avgt(paramActivity, paramString3);
    }
    paramIntent.mDialog = jdField_a_of_type_Avgt;
    paramIntent.mUin = paramQQAppInterface.getCurrentAccountUin();
    localIntent.putExtra("distParamsString", paramString1);
    localIntent.putExtra("distPluginId", paramString2);
    localIntent.putExtra("distPluginName", paramString3);
    paramIntent.mIntent = localIntent;
    paramIntent.cKu = "com.tencent.bridge.activity.BridgeMainActivity";
    paramIntent.K = MainBridgeProxyActivity.class;
    paramIntent.mRequestCode = 19;
    paramIntent.mTimeOut = 15000;
    paramIntent.dmV = false;
    paramIntent.cKv = null;
    gm(paramActivity);
    avfw.a(paramActivity, paramIntent);
    anot.a(paramQQAppInterface, "P_CliOper", "BridgePlatform", "", "start_bridge_plugin", "BridgePlugin.apk", 0, 1, "", "", "", "");
  }
  
  public static boolean b(String paramString1, String paramString2, Context paramContext)
  {
    paramString1 = "pluginLaunchMode_" + paramString1;
    paramString1 = a(paramContext, paramString2).getConfig(paramString1);
    if (paramString1 != null) {
      return paramString1.equals("1");
    }
    return false;
  }
  
  public static AppRuntime d(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.tencent.bridge.BridgeInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "BridgePlugin.apk");
        paramBaseApplicationImpl = paramString.loadClass("com.tencent.bridge.BridgeInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      if (!QLog.isColorLevel()) {
        break label101;
      }
      QLog.e("BridgeHelper", 2, "*createBridgeAppInterface exception:" + paramBaseApplicationImpl.toString());
      label101:
      return null;
    }
    if (paramBaseApplicationImpl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BridgeHelper", 2, "*createBridgeAppInterface load class fail");
      }
    }
    else
    {
      do
      {
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    return null;
  }
  
  static void gm(Context paramContext)
  {
    if (mReceiver == null) {
      mReceiver = new a(null);
    }
    IntentFilter localIntentFilter = new IntentFilter("bridge.onresume.broadcast");
    localIntentFilter.addAction("bridge.plugin.onresume.broadcast");
    paramContext.registerReceiver(mReceiver, localIntentFilter);
  }
  
  public void J(ConfigurationService.Config paramConfig)
  {
    if (paramConfig.version != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 13,version: " + paramConfig.version.get());
      }
      aqmj.m(this.mContext, paramConfig.version.get(), this.mUin);
    }
    if (paramConfig.content_list != null) {
      break label219;
    }
    synchronized (cv)
    {
      this.qz.clear();
      this.eE.set(true);
      paramConfig = paramConfig.content_list.get();
      if ((paramConfig == null) || (paramConfig.size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 13,content_list is empty ");
        }
        paramConfig = new File(this.mContext.getFilesDir(), "entry_config_file_" + this.mUin);
        if (paramConfig.exists()) {
          paramConfig.delete();
        }
        label181:
        ThreadManager.getFileThreadHandler().removeCallbacks(jdField_a_of_type_CooperationPluginbridgeBridgeHelper);
        this.ewX = 1;
        ThreadManager.getFileThreadHandler().post(jdField_a_of_type_CooperationPluginbridgeBridgeHelper);
        return;
      }
    }
    Iterator localIterator = paramConfig.iterator();
    label219:
    XmlPullParser localXmlPullParser;
    while (localIterator.hasNext())
    {
      paramConfig = (String)localIterator.next();
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 13,content: " + paramConfig);
      }
      if (!TextUtils.isEmpty(paramConfig)) {
        localXmlPullParser = Xml.newPullParser();
      }
    }
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramConfig.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
        paramConfig = "";
      }
      catch (XmlPullParserException paramConfig)
      {
        synchronized (cv)
        {
          String str1;
          String str2;
          this.qz.put(str1, str2);
          ??? = paramConfig;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("BridgeHelper", 2, "config put. " + str1 + " : " + str2);
          ??? = paramConfig;
          continue;
          paramConfig = paramConfig;
          paramConfig.printStackTrace();
        }
      }
      catch (IOException paramConfig)
      {
        paramConfig.printStackTrace();
      }
      int i = localXmlPullParser.next();
      paramConfig = (ConfigurationService.Config)???;
      if (localXmlPullParser.getDepth() == 2)
      {
        ??? = localXmlPullParser.getName();
      }
      else
      {
        ??? = paramConfig;
        if (localXmlPullParser.getDepth() == 3)
        {
          ??? = localXmlPullParser.getName();
          localXmlPullParser.next();
          str1 = paramConfig + "_" + (String)???;
          str2 = localXmlPullParser.getText();
          break label219;
          break label181;
          if (i == 1) {
            break;
          }
          switch (i)
          {
          }
          ??? = paramConfig;
        }
      }
    }
  }
  
  public void ezV()
  {
    if ((!this.eE.get()) && (!this.dna))
    {
      this.dna = true;
      this.ewX = 2;
      ThreadManager.getFileThreadHandler().post(jdField_a_of_type_CooperationPluginbridgeBridgeHelper);
    }
  }
  
  public String getConfig(String paramString)
  {
    ezV();
    return (String)this.qz.get(paramString);
  }
  
  public void run()
  {
    if (this.ewX == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("BridgeHelper", 2, "Write configContent to file: " + this.qz);
      }
      ??? = new ByteArrayOutputStream();
    }
    for (;;)
    {
      try
      {
        ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)???);
        localObjectOutputStream.writeObject(this.qz);
        localObjectOutputStream.close();
        ((ByteArrayOutputStream)???).close();
        aqhq.a(new File(this.mContext.getFilesDir(), "entry_config_file_" + this.mUin).getAbsolutePath(), ((ByteArrayOutputStream)???).toByteArray(), false);
        return;
      }
      catch (IOException localIOException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("BridgeHelper", 2, "Exception happened while construct ObjectOutputStream. ", localIOException);
        continue;
      }
      if (this.ewX != 2) {
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.w("BridgeHelper", 2, "Read configContent from file.");
      }
      ??? = new File(this.mContext.getFilesDir(), "entry_config_file_" + this.mUin);
      if ((??? != null) && (((File)???).exists()))
      {
        ??? = aqhq.fileToBytes((File)???);
        if (??? != null) {
          ??? = new ByteArrayInputStream((byte[])???);
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = new ObjectInputStream((InputStream)???).readObject();
          if ((this.eE.get()) || (!(localObject2 instanceof HashMap))) {}
        }
        catch (Exception localException)
        {
          Object localObject2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("BridgeHelper", 2, "Exception happened while construct ObjectInputStream. ", localException);
          continue;
        }
        synchronized (cv)
        {
          this.qz.clear();
          this.qz.putAll((HashMap)localObject2);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("BridgeHelper", 2, "configContent: " + this.qz.toString());
          return;
        }
      }
    }
  }
  
  static class a
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramIntent = paramIntent.getAction();
      if (QLog.isColorLevel()) {
        QLog.i("BridgeHelper", 2, "action:" + paramIntent);
      }
      if (("bridge.plugin.onresume.broadcast".equals(paramIntent)) || ("bridge.onresume.broadcast".equals(paramIntent))) {}
      try
      {
        paramContext.unregisterReceiver(BridgeHelper.mReceiver);
        BridgeHelper.access$102(null);
        if (BridgeHelper.a() != null)
        {
          BridgeHelper.a().dismiss();
          BridgeHelper.a(null);
        }
        if ((paramContext instanceof BridgePluginInstallActivity))
        {
          if (QLog.isColorLevel()) {
            QLog.w("BridgeHelper", 2, "Activity finish!");
          }
          ((BridgePluginInstallActivity)paramContext).finish();
        }
        return;
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          paramIntent.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.pluginbridge.BridgeHelper
 * JD-Core Version:    0.7.0.1
 */