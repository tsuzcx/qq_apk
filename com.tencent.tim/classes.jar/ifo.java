import android.content.Context;
import android.os.Environment;
import com.jakewharton.disklrucache.DiskLruCache;
import com.jakewharton.disklrucache.DiskLruCache.Editor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class ifo
{
  private final DiskLruCache a;
  
  public ifo(Context paramContext, int paramInt, long paramLong)
    throws IOException
  {
    paramContext = e(paramContext);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    this.a = DiskLruCache.open(paramContext, paramInt, 1, paramLong);
    initialize();
  }
  
  private void aG(String paramString1, String paramString2)
  {
    DiskLruCache.Editor localEditor = null;
    String str = ift.MD5(paramString1);
    paramString1 = localEditor;
    try
    {
      localEditor = this.a.edit(str);
      if (localEditor == null) {
        return;
      }
      paramString1 = localEditor;
      localEditor.set(0, paramString2);
      paramString1 = localEditor;
      localEditor.commit();
      return;
    }
    catch (IOException paramString2)
    {
      if (paramString1 != null) {
        try
        {
          paramString1.abort();
          return;
        }
        catch (IOException paramString1) {}
      }
    }
  }
  
  /* Error */
  private String dc(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokestatic 48	ift:MD5	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 35	ifo:a	Lcom/jakewharton/disklrucache/DiskLruCache;
    //   12: aload_1
    //   13: invokevirtual 71	com/jakewharton/disklrucache/DiskLruCache:get	(Ljava/lang/String;)Lcom/jakewharton/disklrucache/DiskLruCache$Snapshot;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +25 -> 43
    //   21: aload_1
    //   22: astore_2
    //   23: aload_1
    //   24: iconst_0
    //   25: invokevirtual 77	com/jakewharton/disklrucache/DiskLruCache$Snapshot:getString	(I)Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: astore_2
    //   31: aload_1
    //   32: ifnull +9 -> 41
    //   35: aload_1
    //   36: invokevirtual 80	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   39: aload_3
    //   40: astore_2
    //   41: aload_2
    //   42: areturn
    //   43: aload 4
    //   45: astore_2
    //   46: aload_1
    //   47: ifnull -6 -> 41
    //   50: aload_1
    //   51: invokevirtual 80	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   54: aconst_null
    //   55: areturn
    //   56: astore_3
    //   57: aconst_null
    //   58: astore_1
    //   59: aload_1
    //   60: astore_2
    //   61: aload_3
    //   62: invokevirtual 83	java/lang/Exception:printStackTrace	()V
    //   65: aload 4
    //   67: astore_2
    //   68: aload_1
    //   69: ifnull -28 -> 41
    //   72: aload_1
    //   73: invokevirtual 80	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_2
    //   81: aload_2
    //   82: ifnull +7 -> 89
    //   85: aload_2
    //   86: invokevirtual 80	com/jakewharton/disklrucache/DiskLruCache$Snapshot:close	()V
    //   89: aload_1
    //   90: athrow
    //   91: astore_1
    //   92: goto -11 -> 81
    //   95: astore_3
    //   96: goto -37 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	ifo
    //   0	99	1	paramString	String
    //   22	64	2	localObject1	Object
    //   28	12	3	str	String
    //   56	6	3	localException1	java.lang.Exception
    //   95	1	3	localException2	java.lang.Exception
    //   1	65	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   8	17	56	java/lang/Exception
    //   8	17	78	finally
    //   23	29	91	finally
    //   61	65	91	finally
    //   23	29	95	java/lang/Exception
  }
  
  private File e(Context paramContext)
  {
    String str = Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + paramContext.getPackageName() + "/cache/";
    Object localObject = ift.getExternalCacheDir(paramContext);
    if ((("mounted".equals(Environment.getExternalStorageState())) || (!ift.isExternalStorageRemovable())) && (localObject != null)) {
      paramContext = ((File)localObject).getPath();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Translator", 2, "[TransDiskCache] getDiskCacheDir:" + paramContext);
      }
      return new File(paramContext + File.separator + "TransDiskCache_simsun_qqi");
      localObject = paramContext.getCacheDir().getPath();
      if (localObject != null)
      {
        paramContext = (Context)localObject;
        if (((String)localObject).length() > 0) {}
      }
      else
      {
        paramContext = str;
      }
    }
  }
  
  public ifr a(String paramString1, long paramLong, String paramString2)
  {
    String str = get(ift.F(paramString2, paramString1));
    if (str == null) {
      return null;
    }
    paramString2 = get(ift.d(paramString2, paramString1, paramLong));
    paramString1 = Boolean.valueOf(false);
    if (paramString2 != null) {
      paramString1 = Boolean.valueOf(paramString2);
    }
    return new ifr(str, paramString1.booleanValue());
  }
  
  public void a(String paramString1, String paramString2, long paramLong, Boolean paramBoolean)
  {
    put(ift.d(paramString1, paramString2, paramLong), paramBoolean.toString());
  }
  
  public void a(String paramString1, String paramString2, long paramLong, Boolean paramBoolean, String paramString3)
  {
    put(ift.d(paramString3, paramString1, paramLong), paramBoolean.toString());
    put(ift.F(paramString3, paramString1), paramString2);
  }
  
  public String get(String paramString)
  {
    return dc(paramString);
  }
  
  public void initialize() {}
  
  public void put(String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      aG(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ifo
 * JD-Core Version:    0.7.0.1
 */