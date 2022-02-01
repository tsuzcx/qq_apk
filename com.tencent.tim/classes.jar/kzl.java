import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.aladdin.config.handlers.AladdinConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinConfigServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class kzl
  implements AladdinConfigHandler
{
  public static JSONObject A()
  {
    return b(299);
  }
  
  public static JSONObject B()
  {
    return b(291);
  }
  
  public static JSONObject b(int paramInt)
  {
    localJSONObject = new JSONObject();
    try
    {
      Object localObject = Aladdin.getConfig(paramInt);
      if (localObject == null) {
        return localJSONObject;
      }
      localObject = ((AladdinConfig)localObject).getAll().entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DyHandler", 1, "getMultiVideoConfig error: " + localThrowable.getMessage());
    }
  }
  
  /* Error */
  public static int[] u()
  {
    // Byte code:
    //   0: ldc 99
    //   2: ldc 101
    //   4: invokestatic 107	awit:f	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   7: checkcast 64	java/lang/String
    //   10: astore_1
    //   11: aload_1
    //   12: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: aload_1
    //   21: ldc 115
    //   23: invokevirtual 119	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   26: astore_3
    //   27: aload_3
    //   28: arraylength
    //   29: ifne +5 -> 34
    //   32: aconst_null
    //   33: areturn
    //   34: aload_3
    //   35: arraylength
    //   36: newarray int
    //   38: astore_2
    //   39: iconst_0
    //   40: istore_0
    //   41: aload_2
    //   42: astore_1
    //   43: iload_0
    //   44: aload_3
    //   45: arraylength
    //   46: if_icmpge +50 -> 96
    //   49: aload_2
    //   50: iload_0
    //   51: aload_3
    //   52: iload_0
    //   53: aaload
    //   54: invokestatic 125	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   57: iastore
    //   58: iload_0
    //   59: iconst_1
    //   60: iadd
    //   61: istore_0
    //   62: goto -21 -> 41
    //   65: astore_1
    //   66: ldc 73
    //   68: iconst_1
    //   69: new 75	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   76: ldc 127
    //   78: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_1
    //   82: invokevirtual 86	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   85: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 95	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aconst_null
    //   95: astore_1
    //   96: aload_1
    //   97: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   40	22	0	i	int
    //   10	33	1	localObject	Object
    //   65	17	1	localThrowable	Throwable
    //   95	2	1	arrayOfInt1	int[]
    //   38	12	2	arrayOfInt2	int[]
    //   26	26	3	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   0	18	65	java/lang/Throwable
    //   20	32	65	java/lang/Throwable
    //   34	39	65	java/lang/Throwable
    //   43	58	65	java/lang/Throwable
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      paramString = kye.i(paramString).entrySet().iterator();
      while (paramString.hasNext())
      {
        Object localObject2 = (Map.Entry)paramString.next();
        Object localObject1 = (String)awit.f("key_viola_dynamic", "");
        localObject2 = (String)((Map.Entry)localObject2).getValue();
        awit.H("key_viola_dynamic", localObject2);
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals(localObject1)))
        {
          localObject1 = kxm.a();
          if (localObject1 != null) {
            AladdinConfigServlet.i((QQAppInterface)localObject1, ((QQAppInterface)localObject1).getCurrentUin());
          }
        }
      }
      return true;
    }
    catch (Throwable paramString)
    {
      QLog.e("DyHandler", 0, "parse dynamic error: " + paramString.getMessage());
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    awit.H("key_viola_dynamic", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     kzl
 * JD-Core Version:    0.7.0.1
 */