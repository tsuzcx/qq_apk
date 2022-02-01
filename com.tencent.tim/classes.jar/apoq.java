import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class apoq
  extends aehv<apoq.a>
{
  public static apoq.a a()
  {
    apoq.a locala = (apoq.a)aeif.a().o(547);
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, "getConfigBean configBean = " + locala);
    }
    return locala;
  }
  
  @NonNull
  public apoq.a a(int paramInt)
  {
    return new apoq.a();
  }
  
  @Nullable
  public apoq.a a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length == 0)) {
      return null;
    }
    paramArrayOfaeic = paramArrayOfaeic[0].content;
    if (QLog.isColorLevel()) {
      QLog.d("TDCRecomTroopConfigProcessor", 2, " onParsed,configID:547, content:" + paramArrayOfaeic);
    }
    return apoq.a.a(paramArrayOfaeic);
  }
  
  public void a(apoq.a parama) {}
  
  public Class<apoq.a> clazz()
  {
    return apoq.a.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 547;
  }
  
  public static class a
  {
    public boolean cRR;
    public String title = "";
    
    /* Error */
    public static a a(String paramString)
    {
      // Byte code:
      //   0: aload_0
      //   1: ifnull +113 -> 114
      //   4: new 2	apoq$a
      //   7: dup
      //   8: invokespecial 24	apoq$a:<init>	()V
      //   11: astore_2
      //   12: new 26	org/json/JSONObject
      //   15: dup
      //   16: aload_0
      //   17: invokespecial 29	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   20: astore_3
      //   21: aload_3
      //   22: ldc 31
      //   24: invokevirtual 35	org/json/JSONObject:optInt	(Ljava/lang/String;)I
      //   27: iconst_1
      //   28: if_icmpne +62 -> 90
      //   31: iconst_1
      //   32: istore_1
      //   33: aload_2
      //   34: iload_1
      //   35: putfield 37	apoq$a:cRR	Z
      //   38: aload_2
      //   39: aload_3
      //   40: ldc 39
      //   42: invokevirtual 43	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   45: putfield 19	apoq$a:title	Ljava/lang/String;
      //   48: invokestatic 49	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   51: ifeq +37 -> 88
      //   54: ldc 51
      //   56: iconst_2
      //   57: new 53	java/lang/StringBuilder
      //   60: dup
      //   61: invokespecial 54	java/lang/StringBuilder:<init>	()V
      //   64: ldc 56
      //   66: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   69: aload_0
      //   70: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   73: ldc 62
      //   75: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   78: aload_2
      //   79: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   82: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   85: invokestatic 73	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   88: aload_2
      //   89: areturn
      //   90: iconst_0
      //   91: istore_1
      //   92: goto -59 -> 33
      //   95: astore_3
      //   96: aconst_null
      //   97: astore_2
      //   98: ldc 51
      //   100: iconst_1
      //   101: ldc 75
      //   103: aload_3
      //   104: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
      //   107: goto -59 -> 48
      //   110: astore_3
      //   111: goto -13 -> 98
      //   114: aconst_null
      //   115: astore_2
      //   116: goto -68 -> 48
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	119	0	paramString	String
      //   32	60	1	bool	boolean
      //   11	105	2	locala	a
      //   20	20	3	localJSONObject	org.json.JSONObject
      //   95	9	3	localException1	java.lang.Exception
      //   110	1	3	localException2	java.lang.Exception
      // Exception table:
      //   from	to	target	type
      //   4	12	95	java/lang/Exception
      //   12	31	110	java/lang/Exception
      //   33	48	110	java/lang/Exception
    }
    
    public String toString()
    {
      return "[displayOrNot:" + this.cRR + ",title:" + this.title + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apoq
 * JD-Core Version:    0.7.0.1
 */