package cooperation.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import avfw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.IStatisticsUploader;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class PluginCrashReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject = paramIntent.getAction();
            if ((!"com.tencent.mobileqq.ACTION_PLUGIN_CRASH".equals(localObject)) || ("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED".equals(localObject))) {
              try
              {
                new b(paramIntent).execute(new String[] { "" });
                return;
              }
              catch (Throwable paramContext)
              {
                return;
              }
            }
            if ("com.tencent.mobileqq.ACTION_PLUGIN_DIR_INFO_LOG".equals(localObject)) {
              try
              {
                new a(paramContext).execute(new String[] { "" });
                return;
              }
              catch (Throwable paramContext)
              {
                return;
              }
            }
            if (!"com.tencent.mobileqq.ACTION_PLUGIN_INSTALL_FAILED".equals(localObject)) {
              break;
            }
            localObject = BaseApplicationImpl.getApplication().getRuntime();
          } while (!(localObject instanceof QQAppInterface));
          paramContext = paramIntent.getStringExtra("plugin");
          paramIntent = paramIntent.getStringExtra("process");
          QLog.d("plugin_tag", 1, "receive installFailed " + paramContext + ", " + paramIntent);
        } while ("com.tencent.tim".equals(paramIntent));
        paramIntent = (QQAppInterface)localObject;
      } while (!paramIntent.iz(27));
      ((avfw)paramIntent.getManager(27)).cancelInstall(paramContext);
      return;
    } while (!"com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_SPEED_INFO".equals(localObject));
  }
  
  static class a
    extends AsyncTask<String, String, String>
  {
    private static boolean dmW;
    private Context mContext;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    /* Error */
    protected String doInBackground(String... paramVarArgs)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: getstatic 33	cooperation/plugin/PluginCrashReceiver$a:dmW	Z
      //   5: ifeq +8 -> 13
      //   8: ldc 35
      //   10: astore_2
      //   11: aload_2
      //   12: areturn
      //   13: iconst_1
      //   14: putstatic 33	cooperation/plugin/PluginCrashReceiver$a:dmW	Z
      //   17: new 37	java/lang/StringBuilder
      //   20: dup
      //   21: invokespecial 38	java/lang/StringBuilder:<init>	()V
      //   24: astore_3
      //   25: new 40	java/lang/ProcessBuilder
      //   28: dup
      //   29: iconst_3
      //   30: anewarray 42	java/lang/String
      //   33: dup
      //   34: iconst_0
      //   35: ldc 44
      //   37: aastore
      //   38: dup
      //   39: iconst_1
      //   40: ldc 46
      //   42: aastore
      //   43: dup
      //   44: iconst_2
      //   45: aload_0
      //   46: getfield 19	cooperation/plugin/PluginCrashReceiver$a:mContext	Landroid/content/Context;
      //   49: ldc 48
      //   51: iconst_0
      //   52: invokevirtual 54	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
      //   55: invokevirtual 60	java/io/File:getPath	()Ljava/lang/String;
      //   58: aastore
      //   59: invokespecial 63	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
      //   62: astore_1
      //   63: aload_1
      //   64: iconst_1
      //   65: invokevirtual 67	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
      //   68: pop
      //   69: new 69	java/io/BufferedReader
      //   72: dup
      //   73: new 71	java/io/InputStreamReader
      //   76: dup
      //   77: aload_1
      //   78: invokevirtual 75	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
      //   81: invokevirtual 81	java/lang/Process:getInputStream	()Ljava/io/InputStream;
      //   84: invokespecial 84	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   87: invokespecial 87	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   90: astore_1
      //   91: aload_1
      //   92: invokevirtual 90	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   95: astore 4
      //   97: aload 4
      //   99: ifnull +42 -> 141
      //   102: aload 4
      //   104: ldc 48
      //   106: invokevirtual 94	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   109: ifeq -18 -> 91
      //   112: aload_3
      //   113: aload 4
      //   115: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   118: ldc 100
      //   120: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   123: pop
      //   124: goto -33 -> 91
      //   127: astore_3
      //   128: aload_1
      //   129: ifnull -118 -> 11
      //   132: aload_1
      //   133: invokevirtual 103	java/io/BufferedReader:close	()V
      //   136: aconst_null
      //   137: areturn
      //   138: astore_1
      //   139: aconst_null
      //   140: areturn
      //   141: ldc 105
      //   143: iconst_1
      //   144: new 37	java/lang/StringBuilder
      //   147: dup
      //   148: invokespecial 38	java/lang/StringBuilder:<init>	()V
      //   151: ldc 107
      //   153: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   156: aload_3
      //   157: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   160: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   163: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   166: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   169: aload_1
      //   170: ifnull -159 -> 11
      //   173: aload_1
      //   174: invokevirtual 103	java/io/BufferedReader:close	()V
      //   177: aconst_null
      //   178: areturn
      //   179: astore_1
      //   180: aconst_null
      //   181: areturn
      //   182: astore_2
      //   183: aconst_null
      //   184: astore_1
      //   185: aload_1
      //   186: ifnull +7 -> 193
      //   189: aload_1
      //   190: invokevirtual 103	java/io/BufferedReader:close	()V
      //   193: aload_2
      //   194: athrow
      //   195: astore_1
      //   196: goto -3 -> 193
      //   199: astore_2
      //   200: goto -15 -> 185
      //   203: astore_1
      //   204: aconst_null
      //   205: astore_1
      //   206: goto -78 -> 128
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	209	0	this	a
      //   0	209	1	paramVarArgs	String[]
      //   1	11	2	str1	String
      //   182	12	2	localObject1	Object
      //   199	1	2	localObject2	Object
      //   24	89	3	localStringBuilder	java.lang.StringBuilder
      //   127	30	3	localThrowable	Throwable
      //   95	19	4	str2	String
      // Exception table:
      //   from	to	target	type
      //   91	97	127	java/lang/Throwable
      //   102	124	127	java/lang/Throwable
      //   141	169	127	java/lang/Throwable
      //   132	136	138	java/lang/Exception
      //   173	177	179	java/lang/Exception
      //   17	91	182	finally
      //   189	193	195	java/lang/Exception
      //   91	97	199	finally
      //   102	124	199	finally
      //   141	169	199	finally
      //   17	91	203	java/lang/Throwable
    }
  }
  
  static class b
    extends AsyncTask<String, String, String>
  {
    private IStatisticsUploader a;
    private String cJL;
    private String cKw;
    private String cKx;
    private String mPluginID;
    private String mPluginName;
    private String mUin;
    
    public b(Intent paramIntent)
    {
      this.mUin = paramIntent.getStringExtra("pluginsdk_selfuin");
      this.mPluginName = paramIntent.getStringExtra("pluginsdk_pluginName");
      this.mPluginID = paramIntent.getStringExtra("pluginsdk_pluginLocation");
      this.cKw = paramIntent.getStringExtra("pluginsdk_pluginpath");
      this.cKx = paramIntent.getStringExtra("pluginsdk_launchActivity");
      this.cJL = paramIntent.getStringExtra("pluginsdk_extraInfo");
      paramIntent = paramIntent.getStringExtra("clsUploader");
      if (paramIntent != null) {}
      try
      {
        this.a = ((IStatisticsUploader)Class.forName(paramIntent).newInstance());
        return;
      }
      catch (Exception paramIntent)
      {
        this.a = null;
      }
    }
    
    protected String doInBackground(String... paramVarArgs)
    {
      if ((this.a == null) || (this.cJL == null)) {
        return "";
      }
      for (;;)
      {
        try
        {
          if ((this.cJL.contains("Resources$NotFoundException")) || (this.cJL.contains("ResourcesNotFoundException")) || (this.cJL.contains("ClassNotFoundException")) || (this.cJL.contains("GetPackageInfoFailException")))
          {
            paramVarArgs = PluginStatic.encodeFile(this.cKw);
            if (this.cKw == null) {
              continue;
            }
            l = new File(this.cKw).length();
            this.cJL = ("ApkMd5:" + paramVarArgs + "__FileSize:" + l + "__" + this.cJL);
          }
          this.a.uploadStartupFailure(MobileQQ.getContext(), this.mUin, this.mPluginName, this.mPluginID, this.cKx, this.cJL);
        }
        catch (Throwable paramVarArgs)
        {
          long l;
          continue;
        }
        return null;
        l = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.plugin.PluginCrashReceiver
 * JD-Core Version:    0.7.0.1
 */