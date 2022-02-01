import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayList<Lapyg;>;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.ZipException;

public class apyh
{
  protected static apyh a;
  protected static Object locker = new Object();
  protected ArrayList<apyg> CC = new ArrayList(0);
  protected File aX = new File(aT(paramContext) + "group_catalog_new.xml");
  protected File aY;
  protected apyg d;
  
  private apyh(Context paramContext) {}
  
  private apyg a(apyg paramapyg, String paramString)
  {
    Object localObject2 = null;
    Iterator localIterator = null;
    if (paramapyg.id.equals(paramString)) {}
    do
    {
      for (Object localObject1 = paramapyg; !localIterator.hasNext(); localObject1 = localObject2)
      {
        do
        {
          do
          {
            return localObject1;
            localObject1 = localIterator;
          } while (paramapyg.list == null);
          localObject1 = localIterator;
        } while (paramapyg.list.isEmpty());
        localIterator = paramapyg.list.iterator();
      }
      paramapyg = a((apyg)localIterator.next(), paramString);
      localObject1 = paramapyg;
    } while (paramapyg == null);
    return paramapyg;
  }
  
  private apyg a(String paramString)
  {
    Object localObject1 = null;
    if ((this.CC == null) || (this.CC.isEmpty())) {
      return null;
    }
    synchronized (locker)
    {
      Iterator localIterator = this.CC.iterator();
      while (localIterator.hasNext())
      {
        apyg localapyg = a((apyg)localIterator.next(), paramString);
        localObject1 = localapyg;
        if (localapyg != null) {
          localObject1 = localapyg;
        }
      }
      return localObject1;
    }
  }
  
  public static apyh a(Context paramContext)
  {
    synchronized (locker)
    {
      if (a == null) {
        a = new apyh(paramContext);
      }
      return a;
    }
  }
  
  private String aT(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + "group_catalog" + File.separator;
    if ((this.aY != null) && (this.aY.exists()) && (paramContext.equals(this.aY.getPath() + File.separator))) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupCatalogTool", 2, "mCatalogXmlDirFile != null && path.equals(mCatalogXmlDirFile.getPath()");
      }
    }
    do
    {
      return paramContext;
      this.aY = new File(paramContext);
    } while (this.aY.exists());
    this.aY.mkdirs();
    return paramContext;
  }
  
  private String aU(Context paramContext)
  {
    paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + "group_catalog_temp" + File.separator;
    File localFile = new File(paramContext);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return paramContext;
  }
  
  /* Error */
  private apyg b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 150	apyh:isReady	()Z
    //   7: ifne +14 -> 21
    //   10: aload_1
    //   11: ldc 152
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 43	apyh:aT	(Landroid/content/Context;)Ljava/lang/String;
    //   18: invokestatic 158	aurv:ap	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   21: new 160	apyj
    //   24: dup
    //   25: aload_2
    //   26: invokespecial 161	apyj:<init>	(Ljava/lang/String;)V
    //   29: astore_3
    //   30: invokestatic 167	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   33: invokevirtual 171	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   36: astore 5
    //   38: new 173	java/io/BufferedInputStream
    //   41: dup
    //   42: new 175	java/io/FileInputStream
    //   45: dup
    //   46: aload_0
    //   47: getfield 58	apyh:aX	Ljava/io/File;
    //   50: invokespecial 178	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 181	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: astore_2
    //   57: aload_2
    //   58: astore_1
    //   59: aload 5
    //   61: new 183	org/xml/sax/InputSource
    //   64: dup
    //   65: new 185	java/io/InputStreamReader
    //   68: dup
    //   69: aload_2
    //   70: ldc 187
    //   72: invokespecial 190	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   75: invokespecial 193	org/xml/sax/InputSource:<init>	(Ljava/io/Reader;)V
    //   78: aload_3
    //   79: invokevirtual 199	javax/xml/parsers/SAXParser:parse	(Lorg/xml/sax/InputSource;Lorg/xml/sax/helpers/DefaultHandler;)V
    //   82: aload_2
    //   83: astore_1
    //   84: aload_0
    //   85: aload_3
    //   86: invokevirtual 203	apyj:dY	()Ljava/util/ArrayList;
    //   89: putfield 34	apyh:CC	Ljava/util/ArrayList;
    //   92: aload_2
    //   93: astore_1
    //   94: aload_3
    //   95: invokevirtual 206	apyj:b	()Lapyg;
    //   98: astore_3
    //   99: aload_3
    //   100: astore_1
    //   101: aload_2
    //   102: ifnull +9 -> 111
    //   105: aload_2
    //   106: invokevirtual 211	java/io/InputStream:close	()V
    //   109: aload_3
    //   110: astore_1
    //   111: aload_1
    //   112: areturn
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   118: aload_3
    //   119: areturn
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: astore_1
    //   125: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +14 -> 142
    //   131: aload_2
    //   132: astore_1
    //   133: ldc 128
    //   135: iconst_2
    //   136: ldc 216
    //   138: aload_3
    //   139: invokestatic 220	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   142: aload 4
    //   144: astore_1
    //   145: aload_2
    //   146: ifnull -35 -> 111
    //   149: aload_2
    //   150: invokevirtual 211	java/io/InputStream:close	()V
    //   153: aconst_null
    //   154: areturn
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   160: aconst_null
    //   161: areturn
    //   162: astore_3
    //   163: aconst_null
    //   164: astore_2
    //   165: aload_2
    //   166: astore_1
    //   167: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +14 -> 184
    //   173: aload_2
    //   174: astore_1
    //   175: ldc 128
    //   177: iconst_2
    //   178: ldc 222
    //   180: aload_3
    //   181: invokestatic 220	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   184: aload 4
    //   186: astore_1
    //   187: aload_2
    //   188: ifnull -77 -> 111
    //   191: aload_2
    //   192: invokevirtual 211	java/io/InputStream:close	()V
    //   195: aconst_null
    //   196: areturn
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   202: aconst_null
    //   203: areturn
    //   204: astore_2
    //   205: aconst_null
    //   206: astore_1
    //   207: aload_1
    //   208: ifnull +7 -> 215
    //   211: aload_1
    //   212: invokevirtual 211	java/io/InputStream:close	()V
    //   215: aload_2
    //   216: athrow
    //   217: astore_1
    //   218: aload_1
    //   219: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   222: goto -7 -> 215
    //   225: astore_2
    //   226: goto -19 -> 207
    //   229: astore_3
    //   230: goto -65 -> 165
    //   233: astore_3
    //   234: goto -111 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	apyh
    //   0	237	1	paramContext	Context
    //   0	237	2	paramString	String
    //   29	90	3	localObject1	Object
    //   120	19	3	localException1	java.lang.Exception
    //   162	19	3	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   229	1	3	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   233	1	3	localException2	java.lang.Exception
    //   1	184	4	localObject2	Object
    //   36	24	5	localSAXParser	javax.xml.parsers.SAXParser
    // Exception table:
    //   from	to	target	type
    //   105	109	113	java/io/IOException
    //   30	57	120	java/lang/Exception
    //   149	153	155	java/io/IOException
    //   30	57	162	java/lang/OutOfMemoryError
    //   191	195	197	java/io/IOException
    //   30	57	204	finally
    //   211	215	217	java/io/IOException
    //   59	82	225	finally
    //   84	92	225	finally
    //   94	99	225	finally
    //   125	131	225	finally
    //   133	142	225	finally
    //   167	173	225	finally
    //   175	184	225	finally
    //   59	82	229	java/lang/OutOfMemoryError
    //   84	92	229	java/lang/OutOfMemoryError
    //   94	99	229	java/lang/OutOfMemoryError
    //   59	82	233	java/lang/Exception
    //   84	92	233	java/lang/Exception
    //   94	99	233	java/lang/Exception
  }
  
  private ArrayList<apyg> b(ArrayList<apyg> paramArrayList, String paramString)
  {
    Object localObject = null;
    apyg localapyg = null;
    Iterator localIterator;
    if (paramArrayList != null)
    {
      localIterator = paramArrayList.iterator();
      paramArrayList = localapyg;
    }
    for (;;)
    {
      localObject = paramArrayList;
      if (localIterator.hasNext())
      {
        localapyg = (apyg)localIterator.next();
        if ((localapyg.list == null) || (localapyg.list.size() <= 0)) {
          break label100;
        }
        if (!localapyg.id.equals(paramString)) {
          break label81;
        }
        localObject = localapyg.list;
      }
      label81:
      label100:
      do
      {
        return localObject;
        localObject = b(localapyg.list, paramString);
        paramArrayList = (ArrayList<apyg>)localObject;
        if (localObject == null) {
          break;
        }
        return localObject;
        localObject = paramArrayList;
      } while (localapyg.level == 4);
    }
  }
  
  public apyg a()
  {
    return this.d;
  }
  
  public apyg a(Context paramContext, String paramString)
  {
    if ((this.CC != null) && (!this.CC.isEmpty()))
    {
      paramContext = a(paramString);
      this.d = paramContext;
      return paramContext;
    }
    paramContext = b(paramContext, paramString);
    this.d = paramContext;
    return paramContext;
  }
  
  public void a(String paramString, apyh.a parama)
  {
    long l = r(BaseApplicationImpl.getContext());
    boolean bool = this.aX.exists();
    if ((System.currentTimeMillis() - l > 86400000L) || (!bool))
    {
      paramString = new aqva(BaseApplicationImpl.getApplication().getRuntime()).a(1);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("https://pub.idqqimg.com/pc/group/layer_new.zip");
      HashMap localHashMap = new HashMap();
      File localFile = new File(aU(BaseApplicationImpl.getContext()) + "layer_new.zip");
      localHashMap.put("https://pub.idqqimg.com/pc/group/layer_new.zip", localFile);
      paramString.a(new aquz(localArrayList, localHashMap, "https://pub.idqqimg.com/pc/group/layer_new.zip"), new apyi(this, localFile, parama), new Bundle());
    }
  }
  
  public ArrayList<apyg> af(String paramString)
  {
    synchronized (locker)
    {
      paramString = b(this.CC, paramString);
      return paramString;
    }
  }
  
  public void b(apyg paramapyg)
  {
    this.d = paramapyg;
  }
  
  public boolean bG(Context paramContext)
  {
    boolean bool = false;
    try
    {
      jqp.b(new File(aU(paramContext) + "layer_new.zip"), aU(paramContext));
      bool = true;
    }
    catch (ZipException paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GroupCatalogTool", 2, paramContext.getMessage());
      return false;
    }
    catch (IOException paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("GroupCatalogTool", 2, paramContext.getMessage());
    }
    return bool;
    return false;
  }
  
  public boolean bH(Context paramContext)
  {
    return aqhq.moveFile(aU(paramContext) + "group_catalog_new.xml", aT(paramContext) + "group_catalog_new.xml");
  }
  
  public void clear()
  {
    if (this.CC != null) {}
    synchronized (locker)
    {
      this.CC.clear();
      this.d = null;
      return;
    }
  }
  
  public ArrayList<apyg> dX()
  {
    synchronized (locker)
    {
      ArrayList localArrayList = new ArrayList(Arrays.asList(new apyg[this.CC.size()]));
      Collections.copy(localArrayList, this.CC);
      return localArrayList;
    }
  }
  
  public boolean isReady()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.aX.exists())
    {
      bool1 = bool2;
      if (this.aX.length() > 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected long r(Context paramContext)
  {
    return paramContext.getSharedPreferences("LAST_GET_CLASS_CHOICE_URL_TIME", 0).getLong("GroupCatalogTool", 0L);
  }
  
  public void s(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getSharedPreferences("LAST_GET_CLASS_CHOICE_URL_TIME", 0).edit();
    paramContext.putLong("GroupCatalogTool", paramLong);
    paramContext.commit();
  }
  
  public static abstract interface a
  {
    public abstract void onResult(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apyh
 * JD-Core Version:    0.7.0.1
 */