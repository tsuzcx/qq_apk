package cooperation.plugin;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import iey;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class PluginInfoUtil
{
  private static final String a = ".cfg";
  
  /* Error */
  static PluginInfo a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 24	java/io/File:length	()J
    //   6: l2i
    //   7: newarray byte
    //   9: astore_1
    //   10: new 26	java/io/FileInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 29	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   18: astore_0
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual 33	java/io/FileInputStream:read	([B)I
    //   24: pop
    //   25: new 35	java/lang/String
    //   28: dup
    //   29: aload_1
    //   30: iconst_0
    //   31: invokestatic 40	com/tencent/mobileqq/utils/Base64Util:a	([BI)[B
    //   34: invokespecial 43	java/lang/String:<init>	([B)V
    //   37: new 45	cooperation/plugin/PluginInfoParser
    //   40: dup
    //   41: invokespecial 46	cooperation/plugin/PluginInfoParser:<init>	()V
    //   44: invokestatic 51	cooperation/plugin/PluginInstaller:a	(Ljava/lang/String;Lcooperation/plugin/PluginInfoParser;)Lcooperation/plugin/PluginInfo;
    //   47: astore_1
    //   48: aload_1
    //   49: astore_2
    //   50: aload_0
    //   51: ifnull +9 -> 60
    //   54: aload_0
    //   55: invokevirtual 54	java/io/FileInputStream:close	()V
    //   58: aload_1
    //   59: astore_2
    //   60: aload_2
    //   61: areturn
    //   62: astore_0
    //   63: aconst_null
    //   64: astore_0
    //   65: aload_0
    //   66: ifnull -6 -> 60
    //   69: aload_0
    //   70: invokevirtual 54	java/io/FileInputStream:close	()V
    //   73: aconst_null
    //   74: areturn
    //   75: astore_0
    //   76: aconst_null
    //   77: areturn
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_0
    //   81: aload_0
    //   82: ifnull +7 -> 89
    //   85: aload_0
    //   86: invokevirtual 54	java/io/FileInputStream:close	()V
    //   89: aload_1
    //   90: athrow
    //   91: astore_0
    //   92: aload_1
    //   93: areturn
    //   94: astore_0
    //   95: goto -6 -> 89
    //   98: astore_1
    //   99: goto -18 -> 81
    //   102: astore_1
    //   103: goto -38 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramFile	File
    //   9	50	1	localObject1	Object
    //   78	15	1	localPluginInfo	PluginInfo
    //   98	1	1	localObject2	Object
    //   102	1	1	localException	Exception
    //   1	60	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   10	19	62	java/lang/Exception
    //   69	73	75	java/io/IOException
    //   10	19	78	finally
    //   54	58	91	java/io/IOException
    //   85	89	94	java/io/IOException
    //   19	48	98	finally
    //   19	48	102	java/lang/Exception
  }
  
  public static PluginInfo a(String paramString, File paramFile)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!new File(paramFile, paramString + ".cfg").exists()) {
      return null;
    }
    return a(paramFile);
  }
  
  public static void a(PluginInfo paramPluginInfo, File paramFile)
  {
    try
    {
      paramFile = new File(paramFile, paramPluginInfo.mID + ".cfg");
      if ((paramFile.isFile()) && (paramFile.exists()))
      {
        paramFile.delete();
        paramFile.createNewFile();
      }
      a(paramFile, paramPluginInfo);
      return;
    }
    catch (Exception paramPluginInfo) {}
  }
  
  public static void a(String paramString, File paramFile)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = new File(paramFile, paramString + ".cfg");
    } while ((!paramString.isFile()) || (!paramString.exists()));
    paramString.delete();
  }
  
  static boolean a(PluginBaseInfo paramPluginBaseInfo, File paramFile)
  {
    if ((!paramFile.exists()) || (!paramFile.isFile())) {}
    do
    {
      do
      {
        return false;
      } while ((paramPluginBaseInfo.mLength > 0L) && (paramFile.length() != paramPluginBaseInfo.mLength));
      paramFile = PluginStatic.encodeFile(paramFile.getPath());
    } while ((paramPluginBaseInfo.mMD5 != null) && (!paramPluginBaseInfo.mMD5.equals(paramFile)));
    return true;
  }
  
  static boolean a(PluginInfo paramPluginInfo, Context paramContext)
  {
    if ((paramPluginInfo.mProcesses == null) || (paramPluginInfo.mProcesses.length == 0)) {}
    do
    {
      return false;
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    } while (paramContext == null);
    paramContext = paramContext.iterator();
    boolean bool = false;
    if (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      String[] arrayOfString = paramPluginInfo.mProcesses;
      int j = arrayOfString.length;
      int i = 0;
      label76:
      if (i < j) {
        if (arrayOfString[i].equalsIgnoreCase(localRunningAppProcessInfo.processName)) {
          bool = true;
        }
      }
      for (;;)
      {
        break;
        i += 1;
        break label76;
      }
    }
    return bool;
  }
  
  /* Error */
  static boolean a(File paramFile, PluginInfo paramPluginInfo)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_1
    //   6: invokestatic 169	cooperation/plugin/PluginInfoParser:a	(Lcooperation/plugin/PluginInfo;)Ljava/lang/String;
    //   9: invokevirtual 173	java/lang/String:getBytes	()[B
    //   12: iconst_0
    //   13: invokestatic 176	com/tencent/mobileqq/utils/Base64Util:b	([BI)[B
    //   16: astore_1
    //   17: new 178	java/io/FileOutputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 179	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   25: astore_0
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 182	java/io/FileOutputStream:write	([B)V
    //   31: iconst_1
    //   32: istore_3
    //   33: iload_3
    //   34: istore_2
    //   35: aload_0
    //   36: ifnull +9 -> 45
    //   39: aload_0
    //   40: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   43: iload_3
    //   44: istore_2
    //   45: iload_2
    //   46: ireturn
    //   47: astore_0
    //   48: aconst_null
    //   49: astore_0
    //   50: aload_0
    //   51: ifnull -6 -> 45
    //   54: aload_0
    //   55: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   58: iconst_0
    //   59: ireturn
    //   60: astore_0
    //   61: iconst_0
    //   62: ireturn
    //   63: astore_0
    //   64: aload 4
    //   66: astore_1
    //   67: aload_1
    //   68: ifnull +7 -> 75
    //   71: aload_1
    //   72: invokevirtual 183	java/io/FileOutputStream:close	()V
    //   75: aload_0
    //   76: athrow
    //   77: astore_0
    //   78: iconst_1
    //   79: ireturn
    //   80: astore_1
    //   81: goto -6 -> 75
    //   84: astore 4
    //   86: aload_0
    //   87: astore_1
    //   88: aload 4
    //   90: astore_0
    //   91: goto -24 -> 67
    //   94: astore_1
    //   95: goto -45 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramFile	File
    //   0	98	1	paramPluginInfo	PluginInfo
    //   1	45	2	bool1	boolean
    //   32	12	3	bool2	boolean
    //   3	62	4	localObject1	Object
    //   84	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	26	47	java/lang/Exception
    //   54	58	60	java/io/IOException
    //   5	26	63	finally
    //   39	43	77	java/io/IOException
    //   71	75	80	java/io/IOException
    //   26	31	84	finally
    //   26	31	94	java/lang/Exception
  }
  
  public static File[] a(File paramFile)
  {
    return paramFile.listFiles(new iey());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.plugin.PluginInfoUtil
 * JD-Core Version:    0.7.0.1
 */