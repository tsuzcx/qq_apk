import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.tim.filemanager.util.FileCategoryUtil.2;
import com.tencent.tim.filemanager.util.FileCategoryUtil.3;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public class audt
{
  private static Comparator<FileInfo> am = new audu();
  
  public static void G(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    while ((paramFileManagerEntity.nFileType != 5) || (paramFileManagerEntity.getCloudType() != 3)) {
      return;
    }
    ThreadManager.post(new FileCategoryUtil.2(paramFileManagerEntity), 8, null, false);
  }
  
  private static Cursor a(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return alld.query(paramContext.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "bucket_display_name", "_data", "bucket_id", "bucket_display_name" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  @TargetApi(9)
  public static List<FileInfo> a(Context paramContext, QfileBaseTabView paramQfileBaseTabView)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = o(paramContext);
    paramContext = paramContext.getPackageManager();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject).next();
      try
      {
        FileInfo localFileInfo = new FileInfo(localPackageInfo.applicationInfo.publicSourceDir);
        localFileInfo.setType(5);
        localFileInfo.setName(localPackageInfo.applicationInfo.loadLabel(paramContext).toString());
        localFileInfo.setApkPackeageName(localPackageInfo.applicationInfo.packageName + ".apk");
        if (Build.VERSION.SDK_INT >= 9) {
          localFileInfo.setDate(localPackageInfo.lastUpdateTime);
        }
        localFileInfo.setGroupName("已安装");
        localArrayList.add(localFileInfo);
        if (paramQfileBaseTabView != null) {
          paramQfileBaseTabView.a(localFileInfo);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    Collections.sort(localArrayList, am);
    return localArrayList;
  }
  
  /* Error */
  public static Map<String, List<FileInfo>> a(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_1
    //   5: aconst_null
    //   6: iload_2
    //   7: invokestatic 199	audt:queryImages	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   10: astore_0
    //   11: aload_0
    //   12: astore_1
    //   13: aload_0
    //   14: iconst_0
    //   15: invokestatic 202	audt:a	(Landroid/database/Cursor;I)Ljava/util/Map;
    //   18: astore_3
    //   19: aload_3
    //   20: astore_1
    //   21: aload_0
    //   22: ifnull +11 -> 33
    //   25: aload_0
    //   26: invokeinterface 207 1 0
    //   31: aload_3
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: astore_3
    //   36: aconst_null
    //   37: astore_0
    //   38: aload_0
    //   39: astore_1
    //   40: aload_3
    //   41: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   44: aload 4
    //   46: astore_1
    //   47: aload_0
    //   48: ifnull -15 -> 33
    //   51: aload_0
    //   52: invokeinterface 207 1 0
    //   57: aconst_null
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +9 -> 72
    //   66: aload_1
    //   67: invokeinterface 207 1 0
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: goto -13 -> 62
    //   78: astore_3
    //   79: goto -41 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramContext	Context
    //   0	82	1	paramString	String
    //   0	82	2	paramInt	int
    //   18	14	3	localMap	Map
    //   35	6	3	localException1	Exception
    //   78	1	3	localException2	Exception
    //   1	44	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	11	35	java/lang/Exception
    //   3	11	59	finally
    //   13	19	74	finally
    //   40	44	74	finally
    //   13	19	78	java/lang/Exception
  }
  
  private static Map<String, List<FileInfo>> a(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.getCount() <= 0) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    int i;
    int j;
    int k;
    int m;
    String str2;
    switch (paramInt)
    {
    default: 
      i = 0;
      j = 0;
      k = 0;
      m = 0;
      if (aqfo.isExistSDCard()) {
        str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath() + File.separator + "Camera";
      }
      break;
    }
    for (;;)
    {
      label99:
      if (paramCursor.moveToNext())
      {
        Object localObject = paramCursor.getString(m);
        int n = paramCursor.getInt(k);
        paramCursor.getInt(j);
        String str1;
        if (paramInt != 1) {
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && ((((String)localObject).contains(str2)) || (((String)localObject).contains("/storage/sdcard1/DCIM/Camera")))) {
            str1 = "camera";
          }
        }
        for (;;)
        {
          if (localObject == null) {
            break label99;
          }
          localObject = FileInfo.a((String)localObject);
          if (localObject == null) {
            break label99;
          }
          ((FileInfo)localObject).setMediaId(n);
          ((FileInfo)localObject).setType(paramInt);
          ((FileInfo)localObject).setGroupName(str1);
          if (!localHashMap.containsKey(str1)) {
            localHashMap.put(str1, new ArrayList());
          }
          ((List)localHashMap.get(str1)).add(localObject);
          break label99;
          m = paramCursor.getColumnIndexOrThrow("_data");
          k = paramCursor.getColumnIndexOrThrow("_id");
          i = 0;
          j = 0;
          break;
          m = paramCursor.getColumnIndexOrThrow("_data");
          k = paramCursor.getColumnIndexOrThrow("_id");
          j = paramCursor.getColumnIndexOrThrow("bucket_id");
          i = paramCursor.getColumnIndexOrThrow("bucket_display_name");
          break;
          m = paramCursor.getColumnIndexOrThrow("_data");
          k = paramCursor.getColumnIndexOrThrow("_id");
          j = paramCursor.getColumnIndexOrThrow("bucket_id");
          i = paramCursor.getColumnIndexOrThrow("bucket_display_name");
          break;
          str1 = paramCursor.getString(i);
          continue;
          str1 = "音乐";
        }
      }
      return localHashMap;
      str2 = "/storage/emulated/0/DCIM/Camera";
    }
  }
  
  public static void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, HashMap<String, List<FileInfo>> paramHashMap, QfileBaseTabView paramQfileBaseTabView)
  {
    if (paramString1 == null) {}
    do
    {
      for (;;)
      {
        return;
        if ((paramQfileBaseTabView == null) || (!paramQfileBaseTabView.akZ())) {
          try
          {
            Thread.sleep(0L);
            File localFile = new File(paramString1);
            if (localFile.isDirectory())
            {
              if (localFile.getName().indexOf(".") == 0) {
                continue;
              }
              paramString1 = localFile.listFiles();
              if (paramString1 == null) {
                continue;
              }
              int i = 0;
              while (i < paramString1.length)
              {
                if ((!new File(paramString1[i].getAbsolutePath()).isDirectory()) || (paramBoolean)) {
                  a(paramBoolean, paramString1[i].getAbsolutePath(), paramString2, paramString3, paramHashMap, paramQfileBaseTabView);
                }
                i += 1;
              }
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
            if (QLog.isColorLevel()) {
              QLog.i("scanFileList", 2, "inFilter[" + paramString2 + "],outOfFilter[" + paramString3 + "],path[" + paramString1 + "]");
            }
            String str = ahbj.getExtension(paramString1);
            Object localObject = str;
            if (paramString2 != null)
            {
              localObject = str;
              if (paramString2.length() > 0)
              {
                if ((str == null) || (str.length() <= 1)) {
                  continue;
                }
                localObject = str.toLowerCase();
                if (paramString2.indexOf((String)localObject) < 0) {
                  continue;
                }
              }
            }
            paramString2 = (String)localObject;
            if (localObject != null)
            {
              paramString2 = (String)localObject;
              if (((String)localObject).length() > 1)
              {
                paramString2 = (String)localObject;
                if (paramString3 != null)
                {
                  paramString2 = (String)localObject;
                  if (paramString3.length() > 0)
                  {
                    paramString2 = ((String)localObject).toLowerCase();
                    if (paramString3.indexOf(paramString2) >= 0) {
                      continue;
                    }
                  }
                }
              }
            }
            paramString1 = FileInfo.a(paramString1);
          }
        }
      }
    } while (paramString1 == null);
    if (!paramHashMap.containsKey(paramString2)) {
      paramHashMap.put(paramString2, new ArrayList());
    }
    if (paramQfileBaseTabView != null) {
      paramQfileBaseTabView.a(paramString1);
    }
    ((List)paramHashMap.get(paramString2)).add(paramString1);
  }
  
  public static boolean a(String paramString, audt.a parama)
  {
    if (paramString == null) {
      return false;
    }
    ahav.a.getExecutor().execute(new FileCategoryUtil.3(paramString, parama));
    return true;
  }
  
  public static void ai(Map<String, List<FileInfo>> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext()) {
        Collections.sort((List)paramMap.get((String)localIterator.next()), am);
      }
    }
  }
  
  public static int at(Context paramContext)
  {
    int j = 0;
    localObject = null;
    localContext = null;
    try
    {
      paramContext = queryImages(paramContext, null, null, 0);
      localContext = paramContext;
      localObject = paramContext;
      int i = paramContext.getCount();
      j = i;
      if (paramContext != null)
      {
        paramContext.close();
        j = i;
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        localObject = localContext;
        paramContext.printStackTrace();
      } while (localContext == null);
      localContext.close();
      return 0;
    }
    finally
    {
      if (localObject == null) {
        break label76;
      }
      ((Cursor)localObject).close();
    }
    return j;
  }
  
  public static int au(Context paramContext)
  {
    return o(paramContext).size();
  }
  
  private static Cursor b(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return alld.query(paramContext.getContentResolver(), MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_display_name", "_data" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  /* Error */
  public static Map<String, List<FileInfo>> b(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_1
    //   5: aconst_null
    //   6: iload_2
    //   7: invokestatic 400	audt:a	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   10: astore_0
    //   11: aload_0
    //   12: astore_1
    //   13: aload_0
    //   14: iconst_2
    //   15: invokestatic 202	audt:a	(Landroid/database/Cursor;I)Ljava/util/Map;
    //   18: astore_3
    //   19: aload_3
    //   20: astore_1
    //   21: aload_0
    //   22: ifnull +11 -> 33
    //   25: aload_0
    //   26: invokeinterface 207 1 0
    //   31: aload_3
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: astore_3
    //   36: aconst_null
    //   37: astore_0
    //   38: aload_0
    //   39: astore_1
    //   40: aload_3
    //   41: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   44: aload 4
    //   46: astore_1
    //   47: aload_0
    //   48: ifnull -15 -> 33
    //   51: aload_0
    //   52: invokeinterface 207 1 0
    //   57: aconst_null
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +9 -> 72
    //   66: aload_1
    //   67: invokeinterface 207 1 0
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: goto -13 -> 62
    //   78: astore_3
    //   79: goto -41 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramContext	Context
    //   0	82	1	paramString	String
    //   0	82	2	paramInt	int
    //   18	14	3	localMap	Map
    //   35	6	3	localException1	Exception
    //   78	1	3	localException2	Exception
    //   1	44	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	11	35	java/lang/Exception
    //   3	11	59	finally
    //   13	19	74	finally
    //   40	44	74	finally
    //   13	19	78	java/lang/Exception
  }
  
  public static int bA(Context paramContext)
  {
    int j = 0;
    localObject = null;
    localContext = null;
    try
    {
      paramContext = a(paramContext, null, null, 0);
      localContext = paramContext;
      localObject = paramContext;
      int i = paramContext.getCount();
      j = i;
      if (paramContext != null)
      {
        paramContext.close();
        j = i;
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        localObject = localContext;
        paramContext.printStackTrace();
      } while (localContext == null);
      localContext.close();
      return 0;
    }
    finally
    {
      if (localObject == null) {
        break label76;
      }
      ((Cursor)localObject).close();
    }
    return j;
  }
  
  public static int bz(Context paramContext)
  {
    int j = 0;
    localObject = null;
    localContext = null;
    try
    {
      paramContext = b(paramContext, null, null, 0);
      localContext = paramContext;
      localObject = paramContext;
      int i = paramContext.getCount();
      j = i;
      if (paramContext != null)
      {
        paramContext.close();
        j = i;
      }
    }
    catch (Exception paramContext)
    {
      do
      {
        localObject = localContext;
        paramContext.printStackTrace();
      } while (localContext == null);
      localContext.close();
      return 0;
    }
    finally
    {
      if (localObject == null) {
        break label76;
      }
      ((Cursor)localObject).close();
    }
    return j;
  }
  
  /* Error */
  public static Map<String, List<FileInfo>> c(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: aload_1
    //   5: aconst_null
    //   6: iload_2
    //   7: invokestatic 404	audt:b	(Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   10: astore_0
    //   11: aload_0
    //   12: astore_1
    //   13: aload_0
    //   14: iconst_1
    //   15: invokestatic 202	audt:a	(Landroid/database/Cursor;I)Ljava/util/Map;
    //   18: astore_3
    //   19: aload_3
    //   20: astore_1
    //   21: aload_0
    //   22: ifnull +11 -> 33
    //   25: aload_0
    //   26: invokeinterface 207 1 0
    //   31: aload_3
    //   32: astore_1
    //   33: aload_1
    //   34: areturn
    //   35: astore_3
    //   36: aconst_null
    //   37: astore_0
    //   38: aload_0
    //   39: astore_1
    //   40: aload_3
    //   41: invokevirtual 186	java/lang/Exception:printStackTrace	()V
    //   44: aload 4
    //   46: astore_1
    //   47: aload_0
    //   48: ifnull -15 -> 33
    //   51: aload_0
    //   52: invokeinterface 207 1 0
    //   57: aconst_null
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +9 -> 72
    //   66: aload_1
    //   67: invokeinterface 207 1 0
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: goto -13 -> 62
    //   78: astore_3
    //   79: goto -41 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramContext	Context
    //   0	82	1	paramString	String
    //   0	82	2	paramInt	int
    //   18	14	3	localMap	Map
    //   35	6	3	localException1	Exception
    //   78	1	3	localException2	Exception
    //   1	44	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	11	35	java/lang/Exception
    //   3	11	59	finally
    //   13	19	74	finally
    //   40	44	74	finally
    //   13	19	78	java/lang/Exception
  }
  
  public static String getAppName(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    PackageManager localPackageManager = BaseApplicationImpl.getContext().getPackageManager();
    PackageInfo localPackageInfo = localPackageManager.getPackageArchiveInfo(paramString, 1);
    if (localPackageInfo != null) {
      return localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString();
    }
    return ahav.getFileName(paramString);
  }
  
  public static Map<String, List<FileInfo>> h(Context paramContext)
  {
    paramContext = a(paramContext, null, 0);
    if (paramContext != null) {
      ai(paramContext);
    }
    return paramContext;
  }
  
  public static Map<String, List<FileInfo>> i(Context paramContext)
  {
    paramContext = b(paramContext, null, 0);
    if (paramContext != null) {
      ai(paramContext);
    }
    return paramContext;
  }
  
  public static Map<String, List<FileInfo>> j(Context paramContext)
  {
    paramContext = c(paramContext, null, 0);
    if (paramContext != null) {
      ai(paramContext);
    }
    return paramContext;
  }
  
  public static List<PackageInfo> o(Context paramContext)
  {
    localArrayList = new ArrayList();
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = alkx.a(paramContext, 1024);
      int i = 0;
      while (i < paramContext.size())
      {
        PackageInfo localPackageInfo = (PackageInfo)paramContext.get(i);
        int j = localPackageInfo.applicationInfo.flags;
        ApplicationInfo localApplicationInfo = localPackageInfo.applicationInfo;
        if (((j & 0x1) <= 0) && (ahbj.isFileExists(localPackageInfo.applicationInfo.publicSourceDir))) {
          localArrayList.add(localPackageInfo);
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramContext) {}
  }
  
  private static Cursor queryImages(Context paramContext, String paramString, String[] paramArrayOfString, int paramInt)
  {
    return alld.query(paramContext.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_data", "bucket_id", "bucket_display_name" }, paramString, paramArrayOfString, "date_added desc");
  }
  
  public static abstract interface a
  {
    public abstract void Za(String paramString);
    
    public abstract void Zb(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     audt
 * JD-Core Version:    0.7.0.1
 */