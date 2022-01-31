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
  protected bl.a gf = null;
  
  /* Error */
  public static String getRelocationUrl(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 47	java/net/URL
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 50	java/net/URL:<init>	(Ljava/lang/String;)V
    //   10: invokevirtual 54	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   13: checkcast 56	java/net/HttpURLConnection
    //   16: astore_0
    //   17: aload_0
    //   18: sipush 30000
    //   21: invokevirtual 60	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   24: aload_0
    //   25: sipush 30000
    //   28: invokevirtual 63	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   31: aload_0
    //   32: iconst_1
    //   33: invokevirtual 67	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   36: aload_0
    //   37: invokevirtual 71	java/net/HttpURLConnection:getResponseCode	()I
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual 75	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   45: invokevirtual 79	java/net/URL:toString	()Ljava/lang/String;
    //   48: astore_1
    //   49: aload_0
    //   50: ifnull +47 -> 97
    //   53: aload_0
    //   54: invokevirtual 82	java/net/HttpURLConnection:disconnect	()V
    //   57: aload_1
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_0
    //   62: aload_0
    //   63: ifnull +32 -> 95
    //   66: aload_0
    //   67: invokevirtual 82	java/net/HttpURLConnection:disconnect	()V
    //   70: aconst_null
    //   71: areturn
    //   72: astore_2
    //   73: aload_1
    //   74: astore_0
    //   75: aload_2
    //   76: astore_1
    //   77: aload_0
    //   78: ifnull +7 -> 85
    //   81: aload_0
    //   82: invokevirtual 82	java/net/HttpURLConnection:disconnect	()V
    //   85: aload_1
    //   86: athrow
    //   87: astore_1
    //   88: goto -11 -> 77
    //   91: astore_1
    //   92: goto -30 -> 62
    //   95: aconst_null
    //   96: areturn
    //   97: aload_1
    //   98: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramString	String
    //   1	85	1	localObject1	Object
    //   87	1	1	localObject2	Object
    //   91	7	1	localException	java.lang.Exception
    //   72	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	59	java/lang/Exception
    //   2	17	72	finally
    //   17	49	87	finally
    //   17	49	91	java/lang/Exception
  }
  
  protected void a(int paramInt, Bundle paramBundle)
  {
    if (this.gf != null)
    {
      if (paramInt != 1) {
        break label23;
      }
      this.gf.a(paramBundle);
    }
    label23:
    while (paramInt != 2) {
      return;
    }
    this.gf.b(paramBundle);
  }
  
  public void setNetworkListener(bl.a parama)
  {
    this.gf = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bl
 * JD-Core Version:    0.7.0.1
 */