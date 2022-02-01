import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class aafy
{
  private String bcL;
  private String bcM;
  private boolean isInited;
  
  public static aafy a()
  {
    return aafy.a.a;
  }
  
  public String jdMethod_if(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    do
    {
      do
      {
        do
        {
          return localObject;
          localObject = paramString;
        } while (!this.isInited);
        localObject = paramString;
      } while (TextUtils.isEmpty(this.bcL));
      localObject = paramString;
    } while (TextUtils.isEmpty(this.bcM));
    Object localObject = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      int j = this.bcL.indexOf(c);
      if (j != -1) {
        ((StringBuilder)localObject).append(this.bcM.charAt(j));
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuilder)localObject).append(c);
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.d("FontConvert", 2, "traditionalToSimplified params is " + paramString + ",result is " + (String)localObject);
    }
    return localObject;
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	aafy:isInited	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new 90	android/os/Handler
    //   17: dup
    //   18: invokestatic 96	com/tencent/mobileqq/app/ThreadManager:getSubThreadLooper	()Landroid/os/Looper;
    //   21: invokespecial 99	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   24: new 101	com/tencent/mobileqq/activity/qwallet/utils/FontConvert$1
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 104	com/tencent/mobileqq/activity/qwallet/utils/FontConvert$1:<init>	(Laafy;)V
    //   32: invokevirtual 108	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   35: pop
    //   36: goto -25 -> 11
    //   39: astore_2
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_2
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	aafy
    //   6	2	1	bool	boolean
    //   39	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	39	finally
    //   14	36	39	finally
  }
  
  public String qt()
  {
    ResourceInfo localResourceInfo = ((PreloadManager)BaseApplicationImpl.getApplication().getRuntime().getManager(151)).getResInfoByResId("text_translate");
    if (localResourceInfo == null) {
      return null;
    }
    return localResourceInfo.folderPath;
  }
  
  static class a
  {
    public static final aafy a = new aafy(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aafy
 * JD-Core Version:    0.7.0.1
 */