import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class anld
{
  static final Object LOCK_mInstance = new Object();
  static anld jdField_a_of_type_Anld;
  public static long ama = 57671680L;
  public static long amb = 209715200L;
  public String JE = "";
  final BroadcastReceiver MsdCardMountReceiver = new anle(this);
  anld.a jdField_a_of_type_Anld$a;
  boolean mIsRegisterSdcardReceiver;
  HashMap<String, String> mSDCardName2PathMap = new HashMap();
  long maxAvailableSize = 0L;
  public String maxAvailableSizePath = "";
  
  anld()
  {
    getAllSDCardInfo();
    ahJ();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
    localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
    localIntentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
    localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
    localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
    localIntentFilter.addDataScheme("file");
    VideoEnvironment.getContext().registerReceiver(this.MsdCardMountReceiver, localIntentFilter);
    this.mIsRegisterSdcardReceiver = true;
  }
  
  public static anld a()
  {
    if (jdField_a_of_type_Anld == null) {}
    synchronized (LOCK_mInstance)
    {
      if (jdField_a_of_type_Anld == null) {
        jdField_a_of_type_Anld = new anld();
      }
      return jdField_a_of_type_Anld;
    }
  }
  
  /* Error */
  static boolean isStorageReallyCanwrite(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: invokestatic 117	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5: invokevirtual 121	java/lang/Thread:getId	()J
    //   8: lstore_2
    //   9: new 123	java/io/File
    //   12: dup
    //   13: new 125	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   20: aload_0
    //   21: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 132
    //   26: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: lload_2
    //   30: invokevirtual 135	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 141	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 145	java/io/File:exists	()Z
    //   44: ifeq +22 -> 66
    //   47: aload_0
    //   48: invokevirtual 148	java/io/File:delete	()Z
    //   51: ifeq +8 -> 59
    //   54: aload_0
    //   55: invokevirtual 151	java/io/File:createNewFile	()Z
    //   58: istore_1
    //   59: aload_0
    //   60: invokevirtual 148	java/io/File:delete	()Z
    //   63: pop
    //   64: iload_1
    //   65: ireturn
    //   66: aload_0
    //   67: invokevirtual 151	java/io/File:createNewFile	()Z
    //   70: istore_1
    //   71: goto -12 -> 59
    //   74: astore 4
    //   76: aload 4
    //   78: invokevirtual 154	java/lang/Throwable:printStackTrace	()V
    //   81: aload_0
    //   82: invokevirtual 148	java/io/File:delete	()Z
    //   85: pop
    //   86: iconst_0
    //   87: ireturn
    //   88: astore 4
    //   90: aload_0
    //   91: invokevirtual 148	java/io/File:delete	()Z
    //   94: pop
    //   95: aload 4
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramString	String
    //   1	70	1	bool	boolean
    //   8	22	2	l	long
    //   74	3	4	localThrowable	Throwable
    //   88	8	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	47	74	java/lang/Throwable
    //   47	59	74	java/lang/Throwable
    //   66	71	74	java/lang/Throwable
    //   40	47	88	finally
    //   47	59	88	finally
    //   66	71	88	finally
    //   76	81	88	finally
  }
  
  public static long s(String paramString)
  {
    try
    {
      paramString = new StatFs(paramString);
      long l = paramString.getAvailableBlocks();
      int i = paramString.getBlockSize();
      return i * l;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StorageManager", 2, "getFreeSpace throw an Exception!", paramString);
      }
    }
    return 0L;
  }
  
  public void a(anld.a parama)
  {
    this.jdField_a_of_type_Anld$a = parama;
  }
  
  void ahJ()
  {
    if (TextUtils.isEmpty(this.maxAvailableSizePath)) {}
    for (;;)
    {
      return;
      this.JE = (this.maxAvailableSizePath + "/Android/data/com.tencent.mobileqq/qq/video");
      if (QLog.isColorLevel())
      {
        QLog.e("TAG", 2, "updateStorePath:storeVideoPath=" + this.JE);
        QLog.e("TAG", 2, "updateStorePath:maxAvailableSizePath=" + this.maxAvailableSizePath);
      }
      try
      {
        File localFile = new File(this.JE);
        if (!localFile.exists())
        {
          localFile.mkdirs();
          return;
        }
      }
      catch (Exception localException)
      {
        this.maxAvailableSizePath = null;
      }
    }
  }
  
  void getAllSDCardInfo()
  {
    synchronized (this.mSDCardName2PathMap)
    {
      this.mSDCardName2PathMap.clear();
      this.maxAvailableSizePath = "";
      this.maxAvailableSize = 0L;
      Object localObject1 = Environment.getExternalStorageDirectory().getAbsolutePath();
      if (!this.mSDCardName2PathMap.containsValue(localObject1)) {
        this.mSDCardName2PathMap.put("external_card", localObject1);
      }
      localObject1 = this.mSDCardName2PathMap.values().iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          String str = (String)((Iterator)localObject1).next();
          try
          {
            Object localObject3 = new File(str);
            if ((((File)localObject3).exists()) && (((File)localObject3).canWrite()) && (isStorageReallyCanwrite(str)))
            {
              localObject3 = new StatFs(str);
              long l = ((StatFs)localObject3).getAvailableBlocks() * ((StatFs)localObject3).getBlockSize();
              if ((l > 0L) && (this.maxAvailableSize < l))
              {
                this.maxAvailableSize = l;
                this.maxAvailableSizePath = str;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
      }
    }
  }
  
  public void release()
  {
    if (this.mIsRegisterSdcardReceiver)
    {
      VideoEnvironment.getContext().unregisterReceiver(this.MsdCardMountReceiver);
      this.mIsRegisterSdcardReceiver = false;
    }
  }
  
  public static abstract interface a
  {
    public abstract void H(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anld
 * JD-Core Version:    0.7.0.1
 */