package com.tencent.qqmail.utilities.template;

import android.content.Context;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.HashMap;

public class Template
{
  public static String CONTENT_HTML_CARD;
  public static String CONTENT_HTML_SYNC_ERROR_NETWORK_UNAVAILABLE;
  public static String CONTENT_HTML_SYNC_ERROR_SERVER_ERROR;
  public static String CONTENT_HTML_SYNC_ERROR_WITHOUT_NETWORK;
  public static String CONTENT_HTML_TEMPLATE;
  public static String TAG = "Template";
  private static HashMap<String, String> mMapSection = new HashMap();
  private static HashMap<String, String> mMapTemplates;
  
  static
  {
    CONTENT_HTML_TEMPLATE = "mail/template/content.html";
    CONTENT_HTML_CARD = "mail/template/card.html";
    CONTENT_HTML_SYNC_ERROR_WITHOUT_NETWORK = "mail/template/sync_error_without_network.html";
    CONTENT_HTML_SYNC_ERROR_SERVER_ERROR = "mail/template/sync_error_server_error.html";
    CONTENT_HTML_SYNC_ERROR_NETWORK_UNAVAILABLE = "mail/template/sync_error_network_unavailable.html";
    mMapTemplates = new HashMap();
  }
  
  /* Error */
  public static String getTemplate(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 48	com/tencent/qqmail/utilities/template/Template:mMapTemplates	Ljava/util/HashMap;
    //   3: aload_1
    //   4: invokevirtual 60	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   7: ifeq +14 -> 21
    //   10: getstatic 48	com/tencent/qqmail/utilities/template/Template:mMapTemplates	Ljava/util/HashMap;
    //   13: aload_1
    //   14: invokevirtual 64	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: checkcast 66	java/lang/String
    //   20: areturn
    //   21: aload_0
    //   22: invokevirtual 72	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   25: invokevirtual 78	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   28: aload_1
    //   29: invokevirtual 84	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   32: astore_0
    //   33: sipush 4096
    //   36: newarray byte
    //   38: astore_3
    //   39: new 86	java/io/ByteArrayOutputStream
    //   42: dup
    //   43: invokespecial 87	java/io/ByteArrayOutputStream:<init>	()V
    //   46: astore 4
    //   48: aload_0
    //   49: aload_3
    //   50: invokevirtual 93	java/io/InputStream:read	([B)I
    //   53: istore_2
    //   54: iload_2
    //   55: ifle +21 -> 76
    //   58: aload 4
    //   60: aload_3
    //   61: iconst_0
    //   62: iload_2
    //   63: invokevirtual 97	java/io/ByteArrayOutputStream:write	([BII)V
    //   66: goto -18 -> 48
    //   69: astore_1
    //   70: aload_0
    //   71: invokevirtual 100	java/io/InputStream:close	()V
    //   74: aconst_null
    //   75: areturn
    //   76: aload 4
    //   78: ldc 102
    //   80: invokevirtual 106	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore_3
    //   84: getstatic 48	com/tencent/qqmail/utilities/template/Template:mMapTemplates	Ljava/util/HashMap;
    //   87: aload_1
    //   88: aload_3
    //   89: invokevirtual 110	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   92: pop
    //   93: aload_0
    //   94: invokevirtual 100	java/io/InputStream:close	()V
    //   97: aload_3
    //   98: areturn
    //   99: astore_0
    //   100: aload_3
    //   101: areturn
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 100	java/io/InputStream:close	()V
    //   109: aload_1
    //   110: athrow
    //   111: astore_0
    //   112: goto -38 -> 74
    //   115: astore_0
    //   116: goto -7 -> 109
    //   119: astore_1
    //   120: goto -15 -> 105
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_0
    //   126: goto -56 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramContext	Context
    //   0	129	1	paramString	String
    //   53	10	2	i	int
    //   38	63	3	localObject	Object
    //   46	31	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   33	48	69	java/lang/Exception
    //   48	54	69	java/lang/Exception
    //   58	66	69	java/lang/Exception
    //   76	93	69	java/lang/Exception
    //   93	97	99	java/lang/Exception
    //   21	33	102	finally
    //   70	74	111	java/lang/Exception
    //   105	109	115	java/lang/Exception
    //   33	48	119	finally
    //   48	54	119	finally
    //   58	66	119	finally
    //   76	93	119	finally
    //   21	33	123	java/lang/Exception
  }
  
  public static String getTemplateSectionWithName(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    String str = paramString1 + "," + paramString2;
    if (mMapSection.containsKey(str)) {
      return (String)mMapSection.get(str);
    }
    paramContext = getTemplate(paramContext, paramString1);
    if (paramContext != null)
    {
      ((StringBuilder)localObject).setLength(0);
      paramString1 = "<!" + paramString2 + "!>";
      ((StringBuilder)localObject).setLength(0);
      localObject = "<!/" + paramString2 + "!>";
      int i = paramContext.indexOf(paramString1);
      int j = paramContext.indexOf((String)localObject);
      if ((i == -1) || (j == -1) || (j <= i))
      {
        QMLog.log(6, TAG, "can not find tempalte " + paramString2);
        throw new RuntimeException("can not find template section for " + paramString2);
      }
      paramContext = paramContext.substring(paramString1.length() + i, j);
      mMapSection.put(str, paramContext);
      return paramContext;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.template.Template
 * JD-Core Version:    0.7.0.1
 */