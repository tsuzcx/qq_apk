import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class aeid
{
  private static volatile aeid jdField_a_of_type_Aeid;
  private final ReadWriteLock jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock = new ReentrantReadWriteLock();
  private String alm;
  public volatile boolean bUa;
  public volatile boolean bUb;
  private Set<aeid.a> cl = new HashSet(20);
  private final Object dp = new Object();
  private Map<String, SharedPreferences> jQ = new HashMap(20);
  private Map<String, SharedPreferences.Editor> jR = new HashMap(20);
  private SharedPreferences mPrefs;
  
  private aeid.a a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      paramString = paramString.split("-");
      if (paramString.length != 3) {
        continue;
      }
      try
      {
        int i = Integer.valueOf(paramString[0]).intValue();
        if ((i < 0) || (i > 2) || (TextUtils.isEmpty(paramString[1]))) {
          continue;
        }
        String str = paramString[1];
        try
        {
          long l = Long.valueOf(paramString[2]).longValue();
          return new aeid.a(i, str, l, null);
        }
        catch (NumberFormatException paramString)
        {
          return null;
        }
        return null;
      }
      catch (NumberFormatException paramString) {}
    }
  }
  
  public static aeid a()
  {
    if (jdField_a_of_type_Aeid == null) {}
    try
    {
      if (jdField_a_of_type_Aeid == null) {
        jdField_a_of_type_Aeid = new aeid();
      }
      return jdField_a_of_type_Aeid;
    }
    finally {}
  }
  
  private void a(aeid.a parama)
  {
    if (parama.type != 0) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = Integer.valueOf(parama.key).intValue();
        Object localObject1 = "conf_" + parama.uin + "_sharepref";
        Object localObject2 = "conf_" + parama.uin + "_content_sharepref";
        Object localObject3 = c((String)localObject1);
        Object localObject4 = c((String)localObject2);
        if ((localObject3 == null) || (localObject4 == null)) {
          break label430;
        }
        localObject4 = ((SharedPreferences)localObject3).getStringSet(i + "_ids", null);
        int j = ((SharedPreferences)localObject3).getInt(parama.key, -1);
        if ((localObject4 == null) || (((Set)localObject4).isEmpty())) {
          break label430;
        }
        localObject2 = b((String)localObject2);
        if (localObject2 != null)
        {
          localObject3 = ((Set)localObject4).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            ((SharedPreferences.Editor)localObject2).remove(i + "_" + (String)localObject4);
            continue;
          }
        }
        localObject1 = b((String)localObject1);
        if (localObject1 != null)
        {
          ((SharedPreferences.Editor)localObject1).remove(parama.key);
          ((SharedPreferences.Editor)localObject1).remove(i + "_ids");
          bool1 = true;
          bool2 = bool1;
          if (bool1)
          {
            bool2 = bool1;
            if (j != -1)
            {
              localObject1 = b("q_journey_safe_mode_deleted_confs_pref");
              bool2 = bool1;
              if (localObject1 != null)
              {
                long l = System.currentTimeMillis();
                ((SharedPreferences.Editor)localObject1).putLong(parama.key, l);
                ((SharedPreferences.Editor)localObject1).putInt(i + "_version", j);
                bool2 = bool1;
              }
            }
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("QConfigJourney", 2, "deleteSpConf, entry=" + parama + ", success=" + bool2);
          return;
        }
      }
      catch (NumberFormatException parama)
      {
        return;
      }
      boolean bool1 = false;
      continue;
      label430:
      boolean bool2 = false;
    }
  }
  
  private void a(aeid.a parama, SharedPreferences.Editor paramEditor)
  {
    Object localObject1 = null;
    if (parama.type != 2) {}
    boolean bool2;
    label125:
    do
    {
      return;
      Object localObject2 = v();
      boolean bool3 = false;
      boolean bool1 = false;
      bool2 = bool3;
      String str;
      if (localObject2 != null)
      {
        str = parama.type + "-" + parama.key + "-" + parama.uin;
        localObject2 = ((SharedPreferences)localObject2).getString(str, null);
        bool2 = bool3;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = new File((String)localObject2);
        }
      }
      try
      {
        bool2 = y((File)localObject1);
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        break label125;
      }
      bool2 = bool1;
      localObject1 = localObject2;
      if (bool1)
      {
        localObject1 = b("q_journey_safe_mode_deleted_files_pref");
        if (localObject1 != null) {
          ((SharedPreferences.Editor)localObject1).putString(str, (String)localObject2);
        }
        paramEditor.remove(str);
        localObject1 = localObject2;
        bool2 = bool1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QConfigJourney", 2, "deleteStorage, entry=" + parama + ", path=" + (String)localObject1 + ", success=" + bool2);
  }
  
  private SharedPreferences.Editor b(String paramString)
  {
    SharedPreferences.Editor localEditor = (SharedPreferences.Editor)this.jR.get(paramString);
    Object localObject = localEditor;
    if (localEditor == null)
    {
      localObject = c(paramString);
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).edit();
        this.jR.put(paramString, localObject);
      }
    }
    else
    {
      return localObject;
    }
    return null;
  }
  
  private void b(aeid.a parama)
  {
    if (parama.type != 1) {}
    for (;;)
    {
      return;
      try
      {
        int i = Integer.valueOf(parama.key).intValue();
        if (this.alm == null) {
          a(null);
        }
        String str = this.alm + File.separator + "qstore" + File.separator + parama.uin + File.separator + "conf" + File.separator + i;
        Object localObject1 = new File(str);
        boolean bool1 = false;
        try
        {
          boolean bool2 = y((File)localObject1);
          bool1 = bool2;
        }
        catch (Exception localException)
        {
          label124:
          Object localObject2;
          int j;
          long l;
          break label124;
        }
        if (bool1)
        {
          localObject2 = "conf_" + parama.uin + "_sharepref";
          localObject1 = c((String)localObject2);
          localObject2 = b((String)localObject2);
          j = ((SharedPreferences)localObject1).getInt(parama.key, -1);
          if ((j != -1) && (localObject2 != null)) {
            ((SharedPreferences.Editor)localObject2).remove(parama.key + "_" + j + "_defualt");
          }
          if (localObject2 != null) {
            ((SharedPreferences.Editor)localObject2).remove(parama.key);
          }
          localObject1 = b("q_journey_safe_mode_deleted_confs_pref");
          if (localObject1 != null)
          {
            l = System.currentTimeMillis();
            ((SharedPreferences.Editor)localObject1).putLong(parama.key, l);
            ((SharedPreferences.Editor)localObject1).putInt(i + "_version", j);
          }
        }
        if (QLog.isColorLevel())
        {
          QLog.d("QConfigJourney", 2, "deleteFileConf, entry=" + parama + ", path=" + str + ", success=" + bool1);
          return;
        }
      }
      catch (NumberFormatException parama) {}
    }
  }
  
  private SharedPreferences c(String paramString)
  {
    SharedPreferences localSharedPreferences2 = (SharedPreferences)this.jQ.get(paramString);
    SharedPreferences localSharedPreferences1 = localSharedPreferences2;
    if (localSharedPreferences2 == null)
    {
      localSharedPreferences2 = BaseApplicationImpl.getApplication().getSharedPreferences(paramString, 0);
      localSharedPreferences1 = localSharedPreferences2;
      if (localSharedPreferences2 != null)
      {
        this.jQ.put(paramString, localSharedPreferences2);
        localSharedPreferences1 = localSharedPreferences2;
      }
    }
    return localSharedPreferences1;
  }
  
  private SharedPreferences v()
  {
    if (this.mPrefs == null) {
      this.mPrefs = BaseApplicationImpl.getApplication().getSharedPreferences("q_journey_safe_mode_pref", 0);
    }
    return this.mPrefs;
  }
  
  private boolean y(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory())
      {
        String[] arrayOfString = paramFile.list();
        if (arrayOfString != null)
        {
          int i = 0;
          while (i < arrayOfString.length)
          {
            if (!y(new File(paramFile, arrayOfString[i]))) {
              return false;
            }
            i += 1;
          }
        }
      }
      return paramFile.delete();
    }
    return true;
  }
  
  public void Hs(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.bUa = false;
    }
    Set localSet;
    HashSet localHashSet;
    for (;;)
    {
      synchronized (this.dp)
      {
        int i = this.cl.size();
        Object localObject3 = new HashSet(this.cl);
        this.cl.clear();
        if (QLog.isColorLevel()) {
          QLog.d("QConfigJourney", 2, "makeAJourney, size=" + i + ", fate=" + paramBoolean);
        }
        if (((Set)localObject3).isEmpty()) {
          return;
        }
        Object localObject4 = v();
        if (localObject4 == null) {
          return;
        }
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject4).edit();
        localSet = ((SharedPreferences)localObject4).getStringSet("safe_scoop", new HashSet());
        if (paramBoolean)
        {
          ??? = "fate_log_tag";
          localHashSet = new HashSet(i);
          if (paramBoolean)
          {
            localObject4 = ((SharedPreferences)localObject4).getStringSet((String)???, null);
            if ((localObject4 != null) && (!((Set)localObject4).isEmpty())) {
              localHashSet.addAll((Collection)localObject4);
            }
          }
          localObject3 = ((Set)localObject3).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject4 = (aeid.a)((Iterator)localObject3).next();
          String str = ((aeid.a)localObject4).type + "-" + ((aeid.a)localObject4).key + "-" + ((aeid.a)localObject4).uin;
          if (((aeid.a)localObject4).type == 2) {
            localEditor.putString(str, ((aeid.a)localObject4).path);
          }
          localHashSet.add(str);
        }
      }
      ??? = String.valueOf(System.currentTimeMillis() / 1000L);
    }
    localSet.add(???);
    localObject2.putStringSet((String)???, localHashSet);
    localObject2.putStringSet("safe_scoop", localSet);
    localObject2.commit();
  }
  
  public void a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    Object localObject3 = null;
    Object localObject1 = paramBaseApplicationImpl;
    if (paramBaseApplicationImpl == null) {
      localObject1 = BaseApplicationImpl.getApplication();
    }
    paramBaseApplicationImpl = localObject3;
    if (localObject1 != null)
    {
      paramBaseApplicationImpl = ((BaseApplicationImpl)localObject1).getFilesDir();
      Object localObject2 = paramBaseApplicationImpl;
      if (paramBaseApplicationImpl == null) {
        localObject2 = ((BaseApplicationImpl)localObject1).getCacheDir();
      }
      paramBaseApplicationImpl = localObject3;
      if (localObject2 != null) {
        paramBaseApplicationImpl = ((File)localObject2).getParent();
      }
    }
    localObject1 = paramBaseApplicationImpl;
    if (paramBaseApplicationImpl == null) {
      localObject1 = File.separator + "data" + File.separator + "data" + File.separator + BaseApplicationImpl.getContext().getPackageName();
    }
    this.alm = ((String)localObject1);
  }
  
  void aB(String arg1, String paramString2, String paramString3)
  {
    if ((this.bUa) && (!TextUtils.isEmpty(???)) && (!TextUtils.isEmpty(paramString3))) {}
    for (;;)
    {
      try
      {
        paramString2 = new aeid.a(2, ???, Long.valueOf(paramString2).longValue(), paramString3);
      }
      catch (NumberFormatException ???)
      {
        continue;
      }
      synchronized (this.dp)
      {
        this.cl.add(paramString2);
        if (this.bUb) {
          Hs(true);
        }
        return;
      }
    }
  }
  
  /* Error */
  void aC(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +156 -> 160
    //   7: aload_3
    //   8: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +149 -> 160
    //   14: aload_2
    //   15: invokestatic 84	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   18: invokevirtual 88	java/lang/Long:longValue	()J
    //   21: lstore 4
    //   23: aload_0
    //   24: ldc 235
    //   26: invokespecial 131	aeid:c	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   29: astore_2
    //   30: new 105	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 378
    //   40: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_1
    //   44: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 63
    //   49: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: lload 4
    //   54: invokevirtual 119	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   57: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore_1
    //   61: aload_3
    //   62: aload_2
    //   63: aload_1
    //   64: aconst_null
    //   65: invokeinterface 224 3 0
    //   70: invokestatic 382	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   73: ifeq +87 -> 160
    //   76: aload_2
    //   77: invokeinterface 253 1 0
    //   82: astore_2
    //   83: aload_0
    //   84: getfield 49	aeid:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   87: invokeinterface 388 1 0
    //   92: invokeinterface 393 1 0
    //   97: aload_2
    //   98: aload_1
    //   99: invokeinterface 175 2 0
    //   104: pop
    //   105: aload_2
    //   106: invokeinterface 348 1 0
    //   111: pop
    //   112: aload_0
    //   113: getfield 49	aeid:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   116: invokeinterface 388 1 0
    //   121: invokeinterface 396 1 0
    //   126: return
    //   127: astore_1
    //   128: aload_0
    //   129: getfield 49	aeid:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   132: invokeinterface 388 1 0
    //   137: invokeinterface 396 1 0
    //   142: return
    //   143: astore_1
    //   144: aload_0
    //   145: getfield 49	aeid:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   148: invokeinterface 388 1 0
    //   153: invokeinterface 396 1 0
    //   158: aload_1
    //   159: athrow
    //   160: return
    //   161: astore_1
    //   162: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	aeid
    //   0	163	1	paramString1	String
    //   0	163	2	paramString2	String
    //   0	163	3	paramString3	String
    //   21	32	4	l	long
    // Exception table:
    //   from	to	target	type
    //   97	112	127	java/lang/Exception
    //   97	112	143	finally
    //   14	97	161	java/lang/NumberFormatException
    //   112	126	161	java/lang/NumberFormatException
    //   128	142	161	java/lang/NumberFormatException
    //   144	160	161	java/lang/NumberFormatException
  }
  
  boolean aP(int paramInt1, int paramInt2)
  {
    SharedPreferences localSharedPreferences = c("q_journey_safe_mode_deleted_confs_pref");
    int i = localSharedPreferences.getInt(paramInt1 + "_version", -1);
    if (i == -1) {}
    long l;
    do
    {
      do
      {
        return false;
      } while (i != paramInt2);
      l = localSharedPreferences.getLong(String.valueOf(paramInt1), -1L);
    } while ((l == -1L) || (l + 10800000L <= System.currentTimeMillis()));
    return true;
  }
  
  public void cXf()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QConfigJourney", 2, "clearFakeJourney");
    }
    this.bUb = false;
    Object localObject = v();
    if (localObject != null)
    {
      Set localSet = ((SharedPreferences)localObject).getStringSet("safe_scoop", new HashSet());
      if (localSet.contains("fate_log_tag"))
      {
        localSet.remove("fate_log_tag");
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).remove("fate_log_tag");
        ((SharedPreferences.Editor)localObject).putStringSet("safe_scoop", localSet);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public void clear()
  {
    Object localObject1 = v();
    StringBuilder localStringBuilder;
    Object localObject2;
    SharedPreferences.Editor localEditor;
    Iterator localIterator;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("clear operation");
      if (localObject1 != null)
      {
        localObject2 = ((SharedPreferences)localObject1).getStringSet("safe_scoop", new HashSet());
        localEditor = ((SharedPreferences)localObject1).edit();
        if (localStringBuilder != null) {
          localStringBuilder.append(", scoops size=").append(((Set)localObject2).size());
        }
        localIterator = ((Set)localObject2).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label279;
        }
        Object localObject3 = (String)localIterator.next();
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          Object localObject4 = ((SharedPreferences)localObject1).getStringSet((String)localObject3, new HashSet());
          localObject3 = new HashSet(((Set)localObject4).size());
          localObject4 = ((Set)localObject4).iterator();
          for (;;)
          {
            if (((Iterator)localObject4).hasNext())
            {
              aeid.a locala = a((String)((Iterator)localObject4).next());
              if (locala != null)
              {
                ((Set)localObject3).add(locala);
                continue;
                localStringBuilder = null;
                break;
              }
            }
          }
          localObject3 = ((Set)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (aeid.a)((Iterator)localObject3).next();
            if (((aeid.a)localObject4).type == 0) {
              a((aeid.a)localObject4);
            } else if (((aeid.a)localObject4).type == 1) {
              b((aeid.a)localObject4);
            } else {
              a((aeid.a)localObject4, localEditor);
            }
          }
        }
      }
      label279:
      localObject1 = this.jR.values().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((SharedPreferences.Editor)((Iterator)localObject1).next()).commit();
      }
      this.jQ.clear();
      this.jR.clear();
      localObject1 = ((Set)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localEditor.remove((String)localObject2);
        }
      }
      localEditor.remove("safe_scoop");
      localEditor.commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QConfigJourney", 2, localStringBuilder.toString());
    }
  }
  
  void k(int paramInt, long paramLong, boolean paramBoolean)
  {
    int i;
    if (this.bUa)
    {
      if (!paramBoolean) {
        break label69;
      }
      i = 1;
    }
    for (;;)
    {
      aeid.a locala = new aeid.a(i, String.valueOf(paramInt), paramLong, null);
      synchronized (this.dp)
      {
        this.cl.add(locala);
        if (this.bUb) {
          Hs(true);
        }
        return;
        label69:
        i = 0;
      }
    }
  }
  
  /* Error */
  boolean q(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +138 -> 145
    //   10: aload_3
    //   11: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifne +131 -> 145
    //   17: aload_2
    //   18: invokestatic 84	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   21: invokevirtual 88	java/lang/Long:longValue	()J
    //   24: lstore 4
    //   26: aload_0
    //   27: ldc 235
    //   29: invokespecial 131	aeid:c	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   32: astore_2
    //   33: new 105	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 378
    //   43: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_1
    //   47: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc 63
    //   52: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: lload 4
    //   57: invokevirtual 119	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   60: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_1
    //   64: aload_0
    //   65: getfield 49	aeid:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   68: invokeinterface 445 1 0
    //   73: invokeinterface 393 1 0
    //   78: aload_2
    //   79: aload_1
    //   80: aconst_null
    //   81: invokeinterface 224 3 0
    //   86: astore_1
    //   87: aload_0
    //   88: getfield 49	aeid:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   91: invokeinterface 445 1 0
    //   96: invokeinterface 396 1 0
    //   101: aload_3
    //   102: aload_1
    //   103: invokestatic 382	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   106: ireturn
    //   107: astore_1
    //   108: aload_0
    //   109: getfield 49	aeid:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   112: invokeinterface 445 1 0
    //   117: invokeinterface 396 1 0
    //   122: aload 6
    //   124: astore_1
    //   125: goto -24 -> 101
    //   128: astore_1
    //   129: aload_0
    //   130: getfield 49	aeid:jdField_a_of_type_JavaUtilConcurrentLocksReadWriteLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   133: invokeinterface 445 1 0
    //   138: invokeinterface 396 1 0
    //   143: aload_1
    //   144: athrow
    //   145: iconst_0
    //   146: ireturn
    //   147: astore_1
    //   148: iconst_0
    //   149: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	aeid
    //   0	150	1	paramString1	String
    //   0	150	2	paramString2	String
    //   0	150	3	paramString3	String
    //   24	32	4	l	long
    //   1	122	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   78	87	107	java/lang/Exception
    //   78	87	128	finally
    //   17	78	147	java/lang/NumberFormatException
    //   87	101	147	java/lang/NumberFormatException
    //   101	107	147	java/lang/NumberFormatException
    //   108	122	147	java/lang/NumberFormatException
    //   129	145	147	java/lang/NumberFormatException
  }
  
  static final class a
  {
    private final String bxz;
    public String key;
    public String path;
    public int type;
    public long uin;
    
    public a(int paramInt, String paramString1, long paramLong, String paramString2)
    {
      this.type = paramInt;
      this.key = paramString1;
      this.uin = paramLong;
      this.path = paramString2;
      this.bxz = (this.type + "-" + this.key + "-" + this.uin);
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {}
      do
      {
        return false;
        paramObject = (a)paramObject;
      } while ((this.type != paramObject.type) || (!this.key.equals(paramObject.key)) || (this.uin != paramObject.uin));
      return true;
    }
    
    public int hashCode()
    {
      return this.bxz.hashCode();
    }
    
    public String toString()
    {
      return "Entry{type=" + this.type + ", key='" + this.key + '\'' + ", uin=" + this.uin + ", path='" + this.path + '\'' + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeid
 * JD-Core Version:    0.7.0.1
 */