import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.QStorageSafeDeleteException;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class aeij
{
  private static final String[] eG = { "flashchat" };
  public static ConcurrentHashMap<String, aeij> eY = new ConcurrentHashMap();
  File am;
  String bxJ;
  String bxK;
  Context mContext;
  
  private aeij(Context paramContext, String paramString1, String paramString2)
  {
    this.bxJ = paramString1;
    this.mContext = paramContext;
    this.bxK = paramString2;
    paramContext = new File(this.mContext.getFilesDir().getAbsolutePath() + File.separator + this.bxK + File.separator + "qstorage" + File.separator + "objs");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    this.am = paramContext;
  }
  
  public static <T extends aehx<Y>, Y> T a(Y paramY, Class<T> paramClass)
    throws QStorageInstantiateException
  {
    aehx localaehx = (aehx)aeif.newInstance(paramClass);
    try
    {
      localaehx.L(paramY);
      return localaehx;
    }
    catch (Exception paramY)
    {
      aeig.a().a(paramClass, paramY);
      throw new QStorageInstantiateException("readJsonOrXml exception too much", paramY);
    }
  }
  
  public static aeij a(String paramString)
  {
    if (!lF(paramString)) {
      QLog.d("QStorage", 1, "buildQStorage notRegister " + paramString);
    }
    Object localObject = (aeij)eY.get(paramString);
    if (localObject == null) {
      synchronized (eY)
      {
        aeij localaeij = (aeij)eY.get(paramString);
        localObject = localaeij;
        if (localaeij == null)
        {
          localObject = new aeij(BaseApplicationImpl.getContext(), paramString, MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
          eY.put(paramString, localObject);
        }
        return localObject;
      }
    }
    return localObject;
  }
  
  private static boolean lF(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = eG;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (TextUtils.equals(arrayOfString[i], paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public <T extends Serializable> T a(String paramString, Class<T> paramClass, int paramInt)
    throws QStorageInstantiateException, QStorageSafeDeleteException
  {
    File localFile = i(paramString, ".serial");
    return (Serializable)a(localFile, "", paramClass, paramInt, new aeil(this, localFile, paramString));
  }
  
  public <JavaBean, Param> JavaBean a(File paramFile, Param paramParam, Class<JavaBean> paramClass, int paramInt, aehw<JavaBean, Param> paramaehw)
    throws QStorageInstantiateException, QStorageSafeDeleteException
  {
    Object localObject = null;
    if (paramFile != null) {}
    String str2;
    for (;;)
    {
      try
      {
        String str1 = paramFile.getCanonicalPath();
        if ((paramInt == 1) || (str1 == null) || (!aeid.a().q(this.bxJ, this.bxK, str1)) || (paramFile.exists())) {
          break;
        }
        throw new QStorageSafeDeleteException();
      }
      catch (IOException localIOException)
      {
        str2 = null;
        continue;
      }
      str2 = null;
    }
    try
    {
      paramParam = paramaehw.a(paramFile, paramParam);
      paramFile = paramParam;
    }
    catch (Exception paramParam)
    {
      for (;;)
      {
        aeig.a().a(paramaehw, paramFile, paramParam);
        QLog.d("QStorage", 1, "readFile " + paramFile.getAbsolutePath(), paramParam);
        paramFile = localObject;
        continue;
        paramParam = paramFile;
        if (str2 != null)
        {
          aeid.a().aB(this.bxJ, this.bxK, str2);
          paramParam = paramFile;
        }
      }
    }
    if (paramFile == null)
    {
      paramParam = aeif.newInstance(paramClass);
      if (paramParam != null) {
        return paramParam;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QStorage", 2, "readFile ");
      }
      throw new QStorageInstantiateException("readSerializable exception too much", new NullPointerException());
    }
    return paramParam;
  }
  
  /* Error */
  public <DATA> void a(File paramFile, DATA paramDATA, aehw<String, DATA> paramaehw)
  {
    // Byte code:
    //   0: aload_3
    //   1: aload_1
    //   2: aload_2
    //   3: invokeinterface 209 3 0
    //   8: pop
    //   9: aload_1
    //   10: ifnull +49 -> 59
    //   13: aload_1
    //   14: invokevirtual 76	java/io/File:exists	()Z
    //   17: istore 4
    //   19: iload 4
    //   21: ifeq +38 -> 59
    //   24: aload_1
    //   25: invokevirtual 194	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   28: astore_2
    //   29: invokestatic 199	aeid:a	()Laeid;
    //   32: aload_0
    //   33: getfield 36	aeij:bxJ	Ljava/lang/String;
    //   36: aload_0
    //   37: getfield 40	aeij:bxK	Ljava/lang/String;
    //   40: aload_2
    //   41: invokevirtual 234	aeid:aC	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   44: invokestatic 199	aeid:a	()Laeid;
    //   47: aload_0
    //   48: getfield 36	aeij:bxJ	Ljava/lang/String;
    //   51: aload_0
    //   52: getfield 40	aeij:bxK	Ljava/lang/String;
    //   55: aload_2
    //   56: invokevirtual 229	aeid:aB	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   59: return
    //   60: astore_2
    //   61: ldc 122
    //   63: iconst_1
    //   64: new 44	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   71: ldc 236
    //   73: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: invokevirtual 55	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: aload_2
    //   87: invokestatic 225	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   90: invokestatic 104	aeig:a	()Laeig;
    //   93: aload_3
    //   94: aload_1
    //   95: aload_2
    //   96: invokevirtual 222	aeig:a	(Laehw;Ljava/io/File;Ljava/lang/Exception;)V
    //   99: return
    //   100: astore_1
    //   101: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	aeij
    //   0	102	1	paramFile	File
    //   0	102	2	paramDATA	DATA
    //   0	102	3	paramaehw	aehw<String, DATA>
    //   17	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	9	60	java/lang/Exception
    //   13	19	60	java/lang/Exception
    //   24	59	60	java/lang/Exception
    //   24	59	100	java/io/IOException
  }
  
  public <T extends Serializable> void b(String paramString, T paramT)
  {
    a(i(paramString, ".serial"), paramT, new aeik(this, paramString, paramT));
  }
  
  public File i(String paramString1, String paramString2)
  {
    return new File(this.am, paramString1 + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeij
 * JD-Core Version:    0.7.0.1
 */