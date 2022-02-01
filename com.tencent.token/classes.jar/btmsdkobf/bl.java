package btmsdkobf;

import android.os.Bundle;

public class bl
{
  public static final String KEY_COMPLETED = "key_completed";
  public static final String KEY_DOWNSIZE = "key_downSize";
  public static final String KEY_DOWNTYPE = "key_downType";
  public static final String KEY_ERRCODE = "key_errcode";
  public static final String KEY_ERRORMSG = "key_errorMsg";
  public static final String KEY_PROGRESS = "key_progress";
  public static final String KEY_SDCARDSTATUS = "key_sdcardstatus";
  public static final String KEY_SUCCESS = "key_success";
  public static final String KEY_TOTAL = "key_total";
  protected a gf = null;
  
  /* Error */
  public static String getRelocationUrl(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 50	java/net/URL
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 53	java/net/URL:<init>	(Ljava/lang/String;)V
    //   12: invokevirtual 57	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   15: checkcast 59	java/net/HttpURLConnection
    //   18: astore_0
    //   19: aload_0
    //   20: sipush 30000
    //   23: invokevirtual 63	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   26: aload_0
    //   27: sipush 30000
    //   30: invokevirtual 66	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   33: aload_0
    //   34: iconst_1
    //   35: invokevirtual 70	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   38: aload_0
    //   39: invokevirtual 74	java/net/HttpURLConnection:getResponseCode	()I
    //   42: pop
    //   43: aload_0
    //   44: invokevirtual 78	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   47: invokevirtual 82	java/net/URL:toString	()Ljava/lang/String;
    //   50: astore_1
    //   51: aload_1
    //   52: astore_2
    //   53: aload_0
    //   54: ifnull +44 -> 98
    //   57: aload_0
    //   58: invokevirtual 85	java/net/HttpURLConnection:disconnect	()V
    //   61: aload_1
    //   62: areturn
    //   63: astore_1
    //   64: aload_0
    //   65: astore_2
    //   66: goto +11 -> 77
    //   69: goto +20 -> 89
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_2
    //   75: aload_0
    //   76: astore_1
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 85	java/net/HttpURLConnection:disconnect	()V
    //   85: aload_1
    //   86: athrow
    //   87: aconst_null
    //   88: astore_0
    //   89: aload_0
    //   90: ifnull +8 -> 98
    //   93: aload_3
    //   94: astore_1
    //   95: goto -38 -> 57
    //   98: aload_2
    //   99: areturn
    //   100: astore_0
    //   101: goto -14 -> 87
    //   104: astore_1
    //   105: goto -36 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramString	String
    //   50	12	1	str	String
    //   63	1	1	localObject1	Object
    //   76	19	1	localObject2	Object
    //   104	1	1	localException	java.lang.Exception
    //   1	98	2	localObject3	Object
    //   3	91	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   19	51	63	finally
    //   4	19	72	finally
    //   4	19	100	java/lang/Exception
    //   19	51	104	java/lang/Exception
  }
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    a locala = this.gf;
    if (locala != null)
    {
      if (paramInt == 1)
      {
        locala.a(paramBundle);
        return;
      }
      if (paramInt == 2) {
        locala.b(paramBundle);
      }
    }
  }
  
  public void setNetworkListener(a parama)
  {
    this.gf = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(Bundle paramBundle);
    
    public abstract void b(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bl
 * JD-Core Version:    0.7.0.1
 */