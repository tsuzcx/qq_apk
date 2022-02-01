import android.content.ContentValues;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy.1;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy.2;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy.3;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy.4;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class agne
  extends acxq
{
  private static Handler E;
  private List<FileManagerEntity> Bl;
  List<FileManagerEntity> Bm = null;
  List<FileManagerEntity> Bn = null;
  List<agne.a> Bo = new ArrayList();
  private List<Integer> Bp = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12) });
  private long Zg;
  private final int cYc = 2000;
  private Set<String> cq;
  private Map<String, FileManagerEntity> kE = new Hashtable();
  private Map<Long, FileManagerEntity> kx;
  
  public agne(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
  }
  
  private ContentValues a(Entity paramEntity)
  {
    ContentValues localContentValues = new ContentValues();
    List localList = TableBuilder.getValidField(paramEntity.getClass());
    int j = localList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject1 = (Field)localList.get(i);
        String str = ((Field)localObject1).getName();
        if (!((Field)localObject1).isAccessible()) {
          ((Field)localObject1).setAccessible(true);
        }
        try
        {
          localObject1 = ((Field)localObject1).get(paramEntity);
          if ((localObject1 instanceof Integer))
          {
            localContentValues.put(str, (Integer)localObject1);
            i += 1;
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            localIllegalArgumentException.printStackTrace();
            Object localObject2 = null;
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            localIllegalAccessException.printStackTrace();
            Object localObject3 = null;
            continue;
            if ((localObject3 instanceof Long)) {
              localContentValues.put(str, (Long)localObject3);
            } else if ((localObject3 instanceof String)) {
              localContentValues.put(str, (String)localObject3);
            } else if ((localObject3 instanceof byte[])) {
              localContentValues.put(str, (byte[])localObject3);
            } else if ((localObject3 instanceof Short)) {
              localContentValues.put(str, (Short)localObject3);
            } else if ((localObject3 instanceof Boolean)) {
              localContentValues.put(str, (Boolean)localObject3);
            } else if ((localObject3 instanceof Double)) {
              localContentValues.put(str, (Double)localObject3);
            } else if ((localObject3 instanceof Float)) {
              localContentValues.put(str, (Float)localObject3);
            } else if ((localObject3 instanceof Byte)) {
              localContentValues.put(str, (Byte)localObject3);
            }
          }
        }
      }
    }
    return localContentValues;
  }
  
  private boolean aX(String paramString1, String paramString2)
  {
    String str2 = ahav.getFileName(paramString1);
    if ((str2 != null) && (str2.equals(paramString2))) {
      return true;
    }
    int i = paramString2.lastIndexOf(".");
    paramString1 = "";
    if (i > 0)
    {
      paramString1 = paramString2.substring(0, i);
      String str1 = paramString2.substring(i);
      paramString2 = paramString1;
      paramString1 = str1;
    }
    try
    {
      for (;;)
      {
        i = Integer.parseInt(str2.replace(paramString2, "").replace(paramString1, "").replace("(", "").replace(")", ""));
        if (i == -1) {
          break;
        }
        bool = true;
        return bool;
        paramString2 = paramString2.substring(0);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        i = -1;
        continue;
        boolean bool = false;
      }
    }
  }
  
  /* Error */
  private void dir()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokestatic 220	java/lang/System:currentTimeMillis	()J
    //   6: putfield 222	agne:Zg	J
    //   9: aload_0
    //   10: getfield 224	agne:kx	Ljava/util/Map;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 224	agne:kx	Ljava/util/Map;
    //   27: invokeinterface 227 1 0
    //   32: istore_1
    //   33: iload_1
    //   34: ifeq -14 -> 20
    //   37: aload_0
    //   38: getfield 224	agne:kx	Ljava/util/Map;
    //   41: invokeinterface 231 1 0
    //   46: invokeinterface 237 1 0
    //   51: astore 4
    //   53: aload 4
    //   55: invokeinterface 242 1 0
    //   60: ifeq -40 -> 20
    //   63: aload 4
    //   65: invokeinterface 246 1 0
    //   70: checkcast 248	java/util/Map$Entry
    //   73: astore 5
    //   75: aload 5
    //   77: invokeinterface 251 1 0
    //   82: checkcast 253	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   85: astore 6
    //   87: aload 6
    //   89: getfield 256	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   92: iconst_2
    //   93: if_icmpeq -40 -> 53
    //   96: aload 6
    //   98: getfield 256	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   101: bipush 14
    //   103: if_icmpeq -50 -> 53
    //   106: aload 6
    //   108: getfield 256	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   111: bipush 15
    //   113: if_icmpeq -60 -> 53
    //   116: aload 6
    //   118: getfield 256	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   121: iconst_4
    //   122: if_icmpeq -69 -> 53
    //   125: aload 5
    //   127: invokeinterface 259 1 0
    //   132: checkcast 124	java/lang/Long
    //   135: invokevirtual 262	java/lang/Long:longValue	()J
    //   138: lstore_2
    //   139: aload 4
    //   141: invokeinterface 265 1 0
    //   146: invokestatic 270	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq -96 -> 53
    //   152: ldc_w 272
    //   155: iconst_2
    //   156: new 274	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   163: ldc_w 277
    //   166: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: lload_2
    //   170: invokevirtual 284	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   173: ldc_w 286
    //   176: invokevirtual 281	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 289	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 293	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: goto -132 -> 53
    //   188: astore 4
    //   190: goto -170 -> 20
    //   193: astore 4
    //   195: aload_0
    //   196: monitorexit
    //   197: aload 4
    //   199: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	agne
    //   32	2	1	i	int
    //   138	32	2	l	long
    //   13	127	4	localObject1	Object
    //   188	1	4	localException	Exception
    //   193	5	4	localObject2	Object
    //   73	53	5	localEntry	Map.Entry
    //   85	32	6	localFileManagerEntity	FileManagerEntity
    // Exception table:
    //   from	to	target	type
    //   37	53	188	java/lang/Exception
    //   53	185	188	java/lang/Exception
    //   2	15	193	finally
    //   23	33	193	finally
    //   37	53	193	finally
    //   53	185	193	finally
  }
  
  private boolean jK(int paramInt)
  {
    for (;;)
    {
      boolean bool;
      FileManagerEntity localFileManagerEntity;
      try
      {
        if (this.Bl == null) {
          init();
        }
        int i = this.Bl.size();
        if (i == 0)
        {
          bool = false;
          return bool;
        }
        Object localObject1 = "select * from ( select * from " + FileManagerEntity.tableName() + " where srvTime <= " + String.valueOf(((FileManagerEntity)this.Bl.get(this.Bl.size() - 1)).srvTime) + " and  nSessionId != " + String.valueOf(((FileManagerEntity)this.Bl.get(this.Bl.size() - 1)).nSessionId) + "  order by srvTime desc limit " + paramInt + ") order by srvTime desc";
        localObject1 = this.app.a().createEntityManager().rawQuery(FileManagerEntity.class, (String)localObject1, null);
        if (localObject1 == null)
        {
          bool = false;
          continue;
        }
        if (((List)localObject1).size() == 0)
        {
          bool = false;
          continue;
        }
        List localList = ahap.o(BaseApplicationImpl.getContext());
        Iterator localIterator1 = ((List)localObject1).iterator();
        if (!localIterator1.hasNext()) {
          break label421;
        }
        localFileManagerEntity = (FileManagerEntity)localIterator1.next();
        if ((localFileManagerEntity.nFileType == 5) && (localFileManagerEntity.getCloudType() == 3) && (!ahbj.isFileExists(localFileManagerEntity.getFilePath())) && (localFileManagerEntity.strApkPackageName != null) && (localFileManagerEntity.strApkPackageName.length() > 0))
        {
          Iterator localIterator2 = localList.iterator();
          if (localIterator2.hasNext())
          {
            PackageInfo localPackageInfo = (PackageInfo)localIterator2.next();
            if (!localFileManagerEntity.strApkPackageName.equalsIgnoreCase(localPackageInfo.packageName)) {
              continue;
            }
            localFileManagerEntity.setFilePath(localPackageInfo.applicationInfo.publicSourceDir);
            continue;
          }
        }
        if (this.kx.get(Long.valueOf(localFileManagerEntity.nSessionId)) != null) {
          break label391;
        }
      }
      finally {}
      this.kx.put(Long.valueOf(localFileManagerEntity.nSessionId), localFileManagerEntity);
      label391:
      this.Bl.add(this.kx.get(Long.valueOf(localFileManagerEntity.nSessionId)));
      continue;
      label421:
      paramInt = localObject2.size();
      if (paramInt < 30) {
        bool = false;
      } else {
        bool = true;
      }
    }
  }
  
  public void A(FileManagerEntity paramFileManagerEntity)
  {
    int i;
    try
    {
      if (this.Bl == null) {
        init();
      }
      if ((!this.Bl.contains(paramFileManagerEntity)) || (!QLog.isColorLevel())) {
        break label335;
      }
      QLog.e("FileManagerProxy<FileAssistant>", 2, "!!!!!!!!!!!fmList has one!!!!!!!!!!!!");
    }
    catch (Exception paramFileManagerEntity)
    {
      for (;;)
      {
        FileManagerEntity localFileManagerEntity;
        label272:
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerProxy<FileAssistant>", 1, paramFileManagerEntity.toString());
        }
      }
    }
    finally {}
    if (i < this.Bl.size())
    {
      localFileManagerEntity = (FileManagerEntity)this.Bl.get(i);
      if (paramFileManagerEntity.srvTime >= localFileManagerEntity.srvTime)
      {
        this.Bl.add(i, paramFileManagerEntity);
        if (this.Bm == null) {
          break label340;
        }
        this.Bm.add(i, paramFileManagerEntity);
        break label340;
      }
    }
    for (;;)
    {
      if (!bool)
      {
        if (this.Bl.size() != 0) {
          break label272;
        }
        this.Bl.add(0, paramFileManagerEntity);
        if (this.Bm != null) {
          this.Bm.add(0, paramFileManagerEntity);
        }
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("FileManagerProxy<FileAssistant>", 4, "insertToList, is add" + bool + " entityInfo:" + ahav.d(paramFileManagerEntity));
        }
        this.kx.put(Long.valueOf(paramFileManagerEntity.nSessionId), paramFileManagerEntity);
        if (this.Bl.size() > 30) {
          this.Bl.remove(this.Bl.size() - 1);
        }
        return;
        i += 1;
        break;
        this.Bl.add(paramFileManagerEntity);
        if (this.Bm != null) {
          this.Bm.add(paramFileManagerEntity);
        }
      }
      boolean bool = false;
      continue;
      label335:
      i = 0;
      break;
      label340:
      bool = true;
    }
  }
  
  public void B(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return;
    }
    for (;;)
    {
      ContentValues localContentValues;
      try
      {
        localContentValues = new ContentValues();
        if (paramFileManagerEntity.bDelInFM)
        {
          localContentValues.put("bDelInFM", Boolean.valueOf(true));
          a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
          break;
        }
      }
      finally {}
      localContentValues.put("bDelInFM", Boolean.valueOf(false));
    }
  }
  
  public void C(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    for (;;)
    {
      return;
      try
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("msgSeq", Long.valueOf(paramFileManagerEntity.msgSeq));
        localContentValues.put("msgUid", Long.valueOf(paramFileManagerEntity.msgUid));
        localContentValues.put("msgTime", Long.valueOf(paramFileManagerEntity.msgTime));
        a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
      }
      finally {}
    }
  }
  
  public void D(FileManagerEntity paramFileManagerEntity)
  {
    synchronized (this.kE)
    {
      this.kE.put(paramFileManagerEntity.zipInnerPath, paramFileManagerEntity);
      QLog.e("FileManagerProxy<FileAssistant>", 1, "insertToZipListFile : [fileName] = " + paramFileManagerEntity.fileName + "[sessionId] = " + paramFileManagerEntity.nSessionId);
      return;
    }
  }
  
  public void IZ(String paramString)
  {
    if (this.cq == null) {
      this.cq = new HashSet();
    }
    this.cq.add(paramString);
  }
  
  public long a(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (this.Bl == null) {
      init();
    }
    Object localObject1 = this.app.b().k(String.valueOf(paramLong3), paramInt);
    Object localObject2;
    int i;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("------->FileManager findUinSeqForCache :msgIsTroop:").append(paramInt).append(",peerUin:").append(ahav.kZ(String.valueOf(paramLong3))).append(",list size:");
      if (localObject1 == null)
      {
        i = 0;
        QLog.i("FileManagerProxy<FileAssistant>", 2, i);
      }
    }
    else
    {
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label253;
      }
      localObject1 = ((List)localObject1).iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((((MessageRecord)localObject2).msgUid != 0L) && (((MessageRecord)localObject2).msgUid == paramLong4))
        {
          return ((MessageRecord)localObject2).uniseq;
          i = ((List)localObject1).size();
          break;
        }
        if ((Math.abs(((MessageRecord)localObject2).time - paramLong2) < 30L) && (((MessageRecord)localObject2).shmsgseq == paramLong1) && (((MessageRecord)localObject2).senderuin.equals(Long.valueOf(paramLong3))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("FileManagerProxy<FileAssistant>", 2, "------->msgFilter-duplicated msg.");
          }
          return ((MessageRecord)localObject2).uniseq;
        }
      }
    }
    label253:
    localObject1 = this.Bl.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
      if ((((FileManagerEntity)localObject2).peerType == paramInt) && (((FileManagerEntity)localObject2).msgSeq == paramLong1) && (((FileManagerEntity)localObject2).msgUid == paramLong4) && (((FileManagerEntity)localObject2).peerUin != null) && (((FileManagerEntity)localObject2).peerUin.equals(Long.valueOf(paramLong3)))) {
        return ((FileManagerEntity)localObject2).uniseq;
      }
    }
    return -1L;
  }
  
  /* Error */
  public FileManagerEntity a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 297	agne:Bl	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 300	agne:init	()V
    //   13: aload_0
    //   14: getfield 297	agne:Bl	Ljava/util/List;
    //   17: invokeinterface 355 1 0
    //   22: astore 4
    //   24: aload 4
    //   26: invokeinterface 242 1 0
    //   31: ifeq +40 -> 71
    //   34: aload 4
    //   36: invokeinterface 246 1 0
    //   41: checkcast 253	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   44: astore_3
    //   45: aload_3
    //   46: invokevirtual 364	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   49: ifnull -25 -> 24
    //   52: aload_3
    //   53: invokevirtual 364	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   56: aload_1
    //   57: invokevirtual 385	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: istore_2
    //   61: iload_2
    //   62: ifeq -38 -> 24
    //   65: aload_3
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: areturn
    //   71: aload_0
    //   72: getfield 224	agne:kx	Ljava/util/Map;
    //   75: invokeinterface 543 1 0
    //   80: invokeinterface 237 1 0
    //   85: astore 4
    //   87: aload 4
    //   89: invokeinterface 242 1 0
    //   94: ifeq +53 -> 147
    //   97: aload 4
    //   99: invokeinterface 246 1 0
    //   104: checkcast 124	java/lang/Long
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 224	agne:kx	Ljava/util/Map;
    //   112: aload_3
    //   113: invokeinterface 402 2 0
    //   118: checkcast 253	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   121: astore_3
    //   122: aload_3
    //   123: invokevirtual 364	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   126: ifnull -39 -> 87
    //   129: aload_3
    //   130: invokevirtual 364	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getFilePath	()Ljava/lang/String;
    //   133: aload_1
    //   134: invokevirtual 385	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   137: istore_2
    //   138: iload_2
    //   139: ifeq -52 -> 87
    //   142: aload_3
    //   143: astore_1
    //   144: goto -77 -> 67
    //   147: aconst_null
    //   148: astore_1
    //   149: goto -82 -> 67
    //   152: astore_1
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_1
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	agne
    //   0	157	1	paramString	String
    //   60	79	2	bool	boolean
    //   44	99	3	localObject	Object
    //   22	76	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	152	finally
    //   13	24	152	finally
    //   24	61	152	finally
    //   71	87	152	finally
    //   87	138	152	finally
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, ProxyListener paramProxyListener)
  {
    for (;;)
    {
      try
      {
        paramProxyListener = this.app.a().createEntityManager();
        if (paramProxyListener == null) {
          return;
        }
        paramProxyListener = new FileManagerEntity();
        if (paramFileManagerEntity.nFileType != 13) {
          paramFileManagerEntity.nFileType = ahav.getFileType(paramFileManagerEntity.fileName);
        }
        paramProxyListener.copyFrom(paramFileManagerEntity);
        paramProxyListener.nSessionId = paramFileManagerEntity.nSessionId;
        paramProxyListener.bSend = paramFileManagerEntity.bSend;
        paramProxyListener.bDelInAio = paramFileManagerEntity.bDelInAio;
        paramProxyListener.bDelInFM = paramFileManagerEntity.bDelInFM;
        if ((paramProxyListener.status != 1) && (paramProxyListener.status != -1) && (!paramProxyListener.bSend) && (paramProxyListener.status != 4)) {
          paramProxyListener.status = 0;
        }
        if ((paramProxyListener.status == 2) || (paramProxyListener.status == 18)) {
          paramProxyListener.status = 0;
        }
        if (paramFileManagerEntity.status == 16) {
          paramProxyListener.status = 16;
        }
        if (paramProxyListener.getStatus() == 1000)
        {
          this.a.addMsgQueue(String.valueOf(0), 0, paramProxyListener.getTableName(), paramProxyListener, 0, null);
          paramFileManagerEntity.setId(paramProxyListener.getId());
          paramFileManagerEntity.setStatus(paramProxyListener.getStatus());
          continue;
        }
        if (paramProxyListener.getStatus() != 1001) {
          break label243;
        }
      }
      finally {}
      this.a.addMsgQueue(String.valueOf(0), 0, paramProxyListener.getTableName(), paramProxyListener, 1, null);
      continue;
      label243:
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "FileManagerEntity status[" + String.valueOf(paramProxyListener.getStatus()) + "] is wrong");
      }
    }
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "why FileManagerEntity is null!!!");
      }
      return;
    }
    paramFileManagerEntity.setFilePath(paramString);
    paramFileManagerEntity = paramFileManagerEntity.clone();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("strFilePath", paramString);
    a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
  }
  
  public void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.a.addMsgQueue(String.valueOf(0), 0, paramString1, paramContentValues, paramString2, paramArrayOfString, 1, paramProxyListener);
  }
  
  protected void a(String paramString1, String paramString2, String[] paramArrayOfString, ProxyListener paramProxyListener)
  {
    this.a.addMsgQueue(String.valueOf(0), 0, paramString1, paramString2, paramArrayOfString, 2, paramProxyListener);
  }
  
  public void aIH()
  {
    if (this.Bl == null) {
      init();
    }
    Object localObject2 = this.Bl.iterator();
    for (Object localObject1 = null; ((Iterator)localObject2).hasNext(); localObject1 = ((FileManagerEntity)localObject1).getTableName())
    {
      localObject1 = (FileManagerEntity)((Iterator)localObject2).next();
      ((FileManagerEntity)localObject1).isReaded = true;
    }
    if (localObject1 != null)
    {
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("isReaded", Boolean.valueOf(true));
      a((String)localObject1, (ContentValues)localObject2, "isReaded=?", new String[] { "0" }, null);
    }
  }
  
  public List<FileManagerEntity> ad(int paramInt)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    for (;;)
    {
      long l1;
      try
      {
        if ((this.Bl == null) || (this.Bl.isEmpty())) {
          init();
        }
        Object localObject1 = "select * from ( select * from " + FileManagerEntity.tableName() + " order by srvTime desc limit " + paramInt + ") order by srvTime desc";
        localObject3 = this.app.a().createEntityManager();
        l1 = System.currentTimeMillis();
        try
        {
          localObject1 = ((EntityManager)localObject3).rawQuery(FileManagerEntity.class, (String)localObject1, null);
          if (QLog.isDevelopLevel())
          {
            if (localObject1 != null) {
              continue;
            }
            QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[null]");
          }
          localObject3 = localFileManagerEntity1;
          if (localObject1 != null)
          {
            paramInt = ((List)localObject1).size();
            if (paramInt != 0) {
              break label240;
            }
            localObject3 = localFileManagerEntity1;
          }
          return localObject3;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (!QLog.isColorLevel()) {
            break label504;
          }
        }
        QLog.e("FileManagerProxy<FileAssistant>", 2, "load " + paramInt + " data,is oom!");
      }
      finally {}
      QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[" + localOutOfMemoryError.size() + "]");
      continue;
      label240:
      Object localObject3 = new ArrayList();
      Iterator localIterator1 = localObject2.iterator();
      label258:
      label502:
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          localFileManagerEntity1 = (FileManagerEntity)localIterator1.next();
          if ((this.kx != null) && (this.kx.containsKey(Long.valueOf(localFileManagerEntity1.nSessionId))))
          {
            localFileManagerEntity1 = (FileManagerEntity)this.kx.get(Long.valueOf(localFileManagerEntity1.nSessionId));
            ahav.H(localFileManagerEntity1);
            ((List)localObject3).add(localFileManagerEntity1);
          }
          else
          {
            Iterator localIterator2 = this.Bl.iterator();
            while (localIterator2.hasNext())
            {
              FileManagerEntity localFileManagerEntity2 = (FileManagerEntity)localIterator2.next();
              if (localFileManagerEntity2.nSessionId == localFileManagerEntity1.nSessionId)
              {
                ahav.H(localFileManagerEntity2);
                ((List)localObject3).add(localFileManagerEntity2);
              }
            }
          }
        }
        else
        {
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt != 0) {
              break label502;
            }
            ahav.H(localFileManagerEntity1);
            ((List)localObject3).add(localFileManagerEntity1);
            break label258;
            long l2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("FileManagerProxy<FileAssistant>", 2, "QueryMoreEntity cost[" + (l2 - l1) + "], size[" + ((List)localObject3).size() + "]");
            }
            break;
          }
        }
      }
      label504:
      localIterator1 = null;
    }
  }
  
  public void aq(long paramLong, String paramString)
  {
    if (E == null)
    {
      HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("FileManagerDBThread", 0);
      localHandlerThread.start();
      E = new Handler(localHandlerThread.getLooper());
    }
    E.post(new FileManagerProxy.4(this, paramLong, paramString));
  }
  
  /* Error */
  public List<FileManagerEntity> av(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	agne:Bn	Ljava/util/List;
    //   6: ifnull +33 -> 39
    //   9: aload_0
    //   10: getfield 38	agne:Bn	Ljava/util/List;
    //   13: invokeinterface 685 1 0
    //   18: aload_0
    //   19: aload_0
    //   20: sipush 200
    //   23: aload_1
    //   24: invokevirtual 688	agne:e	(ILjava/lang/String;)Ljava/util/List;
    //   27: putfield 38	agne:Bn	Ljava/util/List;
    //   30: aload_0
    //   31: getfield 38	agne:Bn	Ljava/util/List;
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: areturn
    //   39: aload_0
    //   40: new 40	java/util/ArrayList
    //   43: dup
    //   44: invokespecial 43	java/util/ArrayList:<init>	()V
    //   47: putfield 38	agne:Bn	Ljava/util/List;
    //   50: goto -32 -> 18
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	agne
    //   0	58	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	18	53	finally
    //   18	35	53	finally
    //   39	50	53	finally
  }
  
  public List<FileManagerEntity> aw(String paramString)
  {
    try
    {
      if (this.Bn == null) {
        this.Bn = new ArrayList();
      }
      paramString = this.Bn;
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public FileManagerEntity b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 297	agne:Bl	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 300	agne:init	()V
    //   13: aload_0
    //   14: getfield 297	agne:Bl	Ljava/util/List;
    //   17: invokeinterface 355 1 0
    //   22: astore 4
    //   24: aload 4
    //   26: invokeinterface 242 1 0
    //   31: ifeq +40 -> 71
    //   34: aload 4
    //   36: invokeinterface 246 1 0
    //   41: checkcast 253	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   44: astore_3
    //   45: aload_3
    //   46: getfield 693	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strServerPath	Ljava/lang/String;
    //   49: ifnull -25 -> 24
    //   52: aload_3
    //   53: getfield 693	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strServerPath	Ljava/lang/String;
    //   56: aload_1
    //   57: invokevirtual 385	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: istore_2
    //   61: iload_2
    //   62: ifeq -38 -> 24
    //   65: aload_3
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: areturn
    //   71: aload_0
    //   72: getfield 224	agne:kx	Ljava/util/Map;
    //   75: invokeinterface 543 1 0
    //   80: invokeinterface 237 1 0
    //   85: astore 4
    //   87: aload 4
    //   89: invokeinterface 242 1 0
    //   94: ifeq +61 -> 155
    //   97: aload 4
    //   99: invokeinterface 246 1 0
    //   104: checkcast 124	java/lang/Long
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 224	agne:kx	Ljava/util/Map;
    //   112: aload_3
    //   113: invokeinterface 402 2 0
    //   118: checkcast 253	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   121: astore_3
    //   122: aload_3
    //   123: getfield 693	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strServerPath	Ljava/lang/String;
    //   126: ifnull -39 -> 87
    //   129: aload_3
    //   130: getfield 442	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bDelInFM	Z
    //   133: iconst_1
    //   134: if_icmpeq -47 -> 87
    //   137: aload_3
    //   138: getfield 693	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strServerPath	Ljava/lang/String;
    //   141: aload_1
    //   142: invokevirtual 385	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   145: istore_2
    //   146: iload_2
    //   147: ifeq -60 -> 87
    //   150: aload_3
    //   151: astore_1
    //   152: goto -85 -> 67
    //   155: aconst_null
    //   156: astore_1
    //   157: goto -90 -> 67
    //   160: astore_1
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_1
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	agne
    //   0	165	1	paramString	String
    //   60	87	2	bool	boolean
    //   44	107	3	localObject	Object
    //   22	76	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	160	finally
    //   13	24	160	finally
    //   24	61	160	finally
    //   71	87	160	finally
    //   87	146	160	finally
  }
  
  public FileManagerEntity b(String paramString, long paramLong)
  {
    for (;;)
    {
      Iterator localIterator;
      FileManagerEntity localFileManagerEntity;
      try
      {
        if (this.Bl == null) {
          init();
        }
        if ((paramString == null) || (paramLong <= 0L))
        {
          localObject = null;
          return localObject;
        }
        localIterator = this.Bl.iterator();
        if (localIterator.hasNext())
        {
          localFileManagerEntity = (FileManagerEntity)localIterator.next();
          if (localFileManagerEntity.nOLfileSessionId == paramLong)
          {
            localObject = localFileManagerEntity;
            if (paramString.equalsIgnoreCase(localFileManagerEntity.peerUin)) {
              continue;
            }
          }
          if ((0L != localFileManagerEntity.nOLfileSessionId) || (paramLong != localFileManagerEntity.nSessionId) || (!paramString.equalsIgnoreCase(localFileManagerEntity.peerUin))) {
            continue;
          }
          localFileManagerEntity.nOLfileSessionId = paramLong;
          u(localFileManagerEntity);
          localObject = localFileManagerEntity;
          continue;
        }
        localIterator = this.kx.values().iterator();
      }
      finally {}
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localFileManagerEntity = (FileManagerEntity)localIterator.next();
          if (localFileManagerEntity.nOLfileSessionId == paramLong)
          {
            localObject = localFileManagerEntity;
            if (paramString.equalsIgnoreCase(localFileManagerEntity.peerUin)) {
              break;
            }
          }
          if ((0L == localFileManagerEntity.nOLfileSessionId) && (paramLong == localFileManagerEntity.nSessionId) && (paramString.equalsIgnoreCase(localFileManagerEntity.peerUin)))
          {
            localFileManagerEntity.nOLfileSessionId = paramLong;
            u(localFileManagerEntity);
            localObject = localFileManagerEntity;
            break;
          }
        }
      }
      Object localObject = null;
    }
  }
  
  public FileManagerEntity b(String paramString1, String paramString2)
  {
    if (this.Bl == null) {
      init();
    }
    Iterator localIterator = this.Bl.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (FileManagerEntity)localIterator.next();
      if ((((FileManagerEntity)localObject).cloudType == 3) && (((FileManagerEntity)localObject).strFileSHA != null) && (((FileManagerEntity)localObject).status == 1) && (((FileManagerEntity)localObject).strFileSHA.equalsIgnoreCase(paramString1)) && (aX(((FileManagerEntity)localObject).getFilePath(), paramString2)) && (ahbj.fileExistsAndNotEmpty(((FileManagerEntity)localObject).getFilePath())) && (new File(((FileManagerEntity)localObject).getFilePath()).lastModified() == ((FileManagerEntity)localObject).lastTime)) {
        return localObject;
      }
    }
    localIterator = this.kx.keySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Long)localIterator.next();
      localObject = (FileManagerEntity)this.kx.get(localObject);
      if ((((FileManagerEntity)localObject).cloudType == 3) && (((FileManagerEntity)localObject).strFileSHA != null) && (((FileManagerEntity)localObject).status == 1) && (((FileManagerEntity)localObject).strFileSHA.equalsIgnoreCase(paramString1)) && (aX(((FileManagerEntity)localObject).getFilePath(), paramString2)) && (ahbj.fileExistsAndNotEmpty(((FileManagerEntity)localObject).getFilePath())) && (new File(((FileManagerEntity)localObject).getFilePath()).lastModified() == ((FileManagerEntity)localObject).lastTime)) {
        return localObject;
      }
    }
    return null;
  }
  
  public List<FileManagerEntity> b(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.Bm == null) {
      eU();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Bm.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!TextUtils.isEmpty(localFileManagerEntity.fileName)) && (!TextUtils.isEmpty(localFileManagerEntity.peerUin)))
      {
        String str = localFileManagerEntity.fileName;
        if (localFileManagerEntity.peerUin.equals(paramString2)) {
          if (str.indexOf(paramString1) >= 0) {
            localArrayList.add(localFileManagerEntity);
          } else if (amxk.b(paramString1, str, amjz.aiT) > -9223372036854775808L) {
            localArrayList.add(localFileManagerEntity);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public boolean b(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramFileManagerEntity == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.e("FileManagerProxy<FileAssistant>", 2, "if item is null, why can choose???!!!");
          bool1 = bool2;
        }
        return bool1;
      }
      finally {}
      bool1 = bool2;
      if (this.app.a().createEntityManager() != null)
      {
        Object localObject = this.app.b().b(paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, paramFileManagerEntity.uniseq);
        if ((paramFileManagerEntity.bDelInAio) && (paramFileManagerEntity.bDelInFM) && (localObject == null))
        {
          a(FileManagerEntity.tableName(), "nSessionId = ?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
          this.Bl.remove(paramFileManagerEntity);
          if (this.Bm != null)
          {
            localObject = this.Bm.iterator();
            if (((Iterator)localObject).hasNext())
            {
              if (((Iterator)localObject).next() != paramFileManagerEntity) {
                continue;
              }
              ((Iterator)localObject).remove();
              continue;
            }
          }
          localObject = this.kx.entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            if (paramFileManagerEntity.nSessionId == ((FileManagerEntity)localEntry.getValue()).nSessionId) {
              ((Iterator)localObject).remove();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerProxy<FileAssistant>", 2, "Delete FileManagerEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] for memory and db:" + ahav.d(paramFileManagerEntity));
          }
          i(paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.nOLfileSessionId);
          bool1 = jK(1);
        }
        else
        {
          localObject = new ContentValues();
          ((ContentValues)localObject).put("bDelInAio", Boolean.valueOf(paramFileManagerEntity.bDelInAio));
          ((ContentValues)localObject).put("bDelInFM", Boolean.valueOf(paramFileManagerEntity.bDelInFM));
          ((ContentValues)localObject).put("uniseq", Long.valueOf(paramFileManagerEntity.uniseq));
          a(FileManagerEntity.tableName(), (ContentValues)localObject, "nSessionId = ?", new String[] { String.valueOf(paramFileManagerEntity.nSessionId) }, null);
          if (paramBoolean) {
            this.a.transSaveToDatabase();
          }
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerProxy<FileAssistant>", 2, "Update FileManagerEntity[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] for db:" + ahav.d(paramFileManagerEntity));
          }
          bool1 = true;
        }
      }
    }
  }
  
  public FileManagerEntity c(long paramLong, String paramString, int paramInt)
  {
    if ((paramLong != -1L) && (paramString != null)) {}
    for (;;)
    {
      Iterator localIterator;
      FileManagerEntity localFileManagerEntity;
      try
      {
        int i = paramString.length();
        if (i == 0)
        {
          paramString = null;
          return paramString;
        }
        if (this.Bl == null) {
          init();
        }
        localIterator = this.Bl.iterator();
        if (!localIterator.hasNext()) {
          break label175;
        }
        localFileManagerEntity = (FileManagerEntity)localIterator.next();
        if ((localFileManagerEntity.peerUin == null) || (localFileManagerEntity.uniseq != paramLong) || (!localFileManagerEntity.peerUin.equals(paramString))) {
          continue;
        }
        if (((localFileManagerEntity.cloudType == 9) || (localFileManagerEntity.cloudType == 1)) && (ahav.o(localFileManagerEntity)))
        {
          localFileManagerEntity.status = 16;
          paramString = localFileManagerEntity;
          continue;
        }
        paramString = localFileManagerEntity;
      }
      finally {}
      if (localFileManagerEntity.cloudType == 9)
      {
        localFileManagerEntity.status = 1;
        paramString = localFileManagerEntity;
        continue;
        label175:
        if (this.kx != null)
        {
          localIterator = this.kx.entrySet().iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localFileManagerEntity = (FileManagerEntity)((Map.Entry)localIterator.next()).getValue();
              if ((localFileManagerEntity.uniseq == paramLong) && (localFileManagerEntity.peerUin != null) && (localFileManagerEntity.peerUin.equals(paramString)) && (paramInt == localFileManagerEntity.peerType))
              {
                paramString = localFileManagerEntity;
                if (localFileManagerEntity.cloudType != 1) {
                  break;
                }
                paramString = localFileManagerEntity;
                if (!ahav.o(localFileManagerEntity)) {
                  break;
                }
                localFileManagerEntity.status = 16;
                paramString = localFileManagerEntity;
                break;
              }
            }
          }
        }
        paramString = null;
      }
    }
  }
  
  public FileManagerEntity c(String paramString)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        if (this.Bl == null) {
          init();
        }
        localArrayList = new ArrayList();
        localObject2 = this.Bl.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (FileManagerEntity)((Iterator)localObject2).next();
          if ((((FileManagerEntity)localObject1).WeiYunFileId == null) || (!((FileManagerEntity)localObject1).WeiYunFileId.equalsIgnoreCase(paramString))) {
            continue;
          }
          if (((FileManagerEntity)localObject1).status == 1)
          {
            boolean bool = ahbj.fileExistsAndNotEmpty(((FileManagerEntity)localObject1).getFilePath());
            if (bool) {
              return localObject1;
            }
          }
          localArrayList.add(localObject1);
          continue;
        }
        localIterator = localArrayList.iterator();
      }
      finally {}
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject2 = (FileManagerEntity)localIterator.next();
          localObject1 = localObject2;
          if (((FileManagerEntity)localObject2).nOpType == 5) {
            break;
          }
          localObject1 = localObject2;
          if (((FileManagerEntity)localObject2).nOpType == 50) {
            break;
          }
          if (((FileManagerEntity)localObject2).cloudType == 2)
          {
            localObject1 = localObject2;
            break;
          }
        }
      }
      localArrayList.clear();
      Iterator localIterator = this.kx.keySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label304;
        }
        localObject1 = (Long)localIterator.next();
        localObject2 = (FileManagerEntity)this.kx.get(localObject1);
        if ((((FileManagerEntity)localObject2).WeiYunFileId != null) && (((FileManagerEntity)localObject2).WeiYunFileId.equalsIgnoreCase(paramString)))
        {
          if (((FileManagerEntity)localObject2).status == 1)
          {
            localObject1 = localObject2;
            if (ahbj.fileExistsAndNotEmpty(((FileManagerEntity)localObject2).getFilePath())) {
              break;
            }
          }
          localArrayList.add(localObject2);
        }
      }
      label304:
      Object localObject2 = localArrayList.iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          paramString = (FileManagerEntity)((Iterator)localObject2).next();
          localObject1 = paramString;
          if (paramString.nOpType == 5) {
            break;
          }
          localObject1 = paramString;
          if (paramString.nOpType == 50) {
            break;
          }
          int i = paramString.cloudType;
          if (i == 2)
          {
            localObject1 = paramString;
            break;
          }
        }
      }
      Object localObject1 = null;
    }
  }
  
  public boolean cb(long paramLong)
  {
    Iterator localIterator = this.Bo.iterator();
    while (localIterator.hasNext()) {
      if (((agne.a)localIterator.next()).nSessionId == paramLong) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public FileManagerEntity d(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 297	agne:Bl	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 300	agne:init	()V
    //   13: aload_0
    //   14: getfield 297	agne:Bl	Ljava/util/List;
    //   17: invokeinterface 355 1 0
    //   22: astore 6
    //   24: aload 6
    //   26: invokeinterface 242 1 0
    //   31: ifeq +32 -> 63
    //   34: aload 6
    //   36: invokeinterface 246 1 0
    //   41: checkcast 253	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   44: astore 5
    //   46: aload 5
    //   48: getfield 318	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   51: lstore_3
    //   52: lload_3
    //   53: lload_1
    //   54: lcmp
    //   55: ifne -31 -> 24
    //   58: aload_0
    //   59: monitorexit
    //   60: aload 5
    //   62: areturn
    //   63: aload_0
    //   64: getfield 36	agne:Bm	Ljava/util/List;
    //   67: ifnull +49 -> 116
    //   70: aload_0
    //   71: getfield 36	agne:Bm	Ljava/util/List;
    //   74: invokeinterface 355 1 0
    //   79: astore 6
    //   81: aload 6
    //   83: invokeinterface 242 1 0
    //   88: ifeq +28 -> 116
    //   91: aload 6
    //   93: invokeinterface 246 1 0
    //   98: checkcast 253	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   101: astore 5
    //   103: aload 5
    //   105: getfield 318	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   108: lload_1
    //   109: lcmp
    //   110: ifne -29 -> 81
    //   113: goto -55 -> 58
    //   116: aload_0
    //   117: getfield 224	agne:kx	Ljava/util/Map;
    //   120: lload_1
    //   121: invokestatic 401	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   124: invokeinterface 402 2 0
    //   129: checkcast 253	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   132: astore 5
    //   134: goto -76 -> 58
    //   137: astore 5
    //   139: aload_0
    //   140: monitorexit
    //   141: aload 5
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	agne
    //   0	144	1	paramLong	long
    //   51	2	3	l	long
    //   44	89	5	localFileManagerEntity	FileManagerEntity
    //   137	5	5	localObject	Object
    //   22	70	6	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	137	finally
    //   13	24	137	finally
    //   24	52	137	finally
    //   63	81	137	finally
    //   81	113	137	finally
    //   116	134	137	finally
  }
  
  public FileManagerEntity d(long paramLong, String paramString, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = null;
    for (;;)
    {
      long l;
      try
      {
        if (this.Bl == null) {
          init();
        }
        paramString = "select * from " + FileManagerEntity.tableName() + " where uniseq = ?";
        EntityManager localEntityManager = this.app.a().createEntityManager();
        if (localEntityManager == null)
        {
          paramString = localFileManagerEntity;
          if (QLog.isColorLevel())
          {
            QLog.e("FileManagerProxy<FileAssistant>", 2, "get EntityManager null!");
            paramString = localFileManagerEntity;
          }
          return paramString;
        }
        l = System.currentTimeMillis();
        paramString = localEntityManager.rawQuery(FileManagerEntity.class, paramString, new String[] { String.valueOf(paramLong) });
        paramLong = System.currentTimeMillis();
        if (paramString == null)
        {
          paramString = localFileManagerEntity;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("FileManagerProxy<FileAssistant>", 2, "queryOver, but no data!");
          paramString = localFileManagerEntity;
          continue;
        }
        if (!QLog.isColorLevel()) {
          break label207;
        }
      }
      finally {}
      QLog.d("FileManagerProxy<FileAssistant>", 2, "query over,startTime[" + String.valueOf(l) + "], overTime[" + String.valueOf(paramLong) + "]");
      label207:
      if ((paramString.size() > 1) && (QLog.isColorLevel())) {
        QLog.w("FileManagerProxy", 2, "why size[" + String.valueOf(paramString.size()) + "] over 1?");
      }
      localFileManagerEntity = (FileManagerEntity)paramString.get(0);
      this.kx.put(Long.valueOf(localFileManagerEntity.nSessionId), localFileManagerEntity);
      ahap.G(localFileManagerEntity);
      paramString = localFileManagerEntity;
      if (localFileManagerEntity.cloudType == 1)
      {
        paramString = localFileManagerEntity;
        if (ahav.o(localFileManagerEntity))
        {
          localFileManagerEntity.status = 16;
          paramString = localFileManagerEntity;
        }
      }
    }
  }
  
  /* Error */
  public FileManagerEntity d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 297	agne:Bl	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 300	agne:init	()V
    //   13: aload_0
    //   14: getfield 297	agne:Bl	Ljava/util/List;
    //   17: invokeinterface 355 1 0
    //   22: astore 4
    //   24: aload 4
    //   26: invokeinterface 242 1 0
    //   31: ifeq +62 -> 93
    //   34: aload 4
    //   36: invokeinterface 246 1 0
    //   41: checkcast 253	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   44: astore_3
    //   45: aload_3
    //   46: getfield 793	com/tencent/mobileqq/filemanager/data/FileManagerEntity:WeiYunFileId	Ljava/lang/String;
    //   49: ifnull -25 -> 24
    //   52: aload_3
    //   53: getfield 793	com/tencent/mobileqq/filemanager/data/FileManagerEntity:WeiYunFileId	Ljava/lang/String;
    //   56: aload_1
    //   57: invokevirtual 385	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: ifeq -36 -> 24
    //   63: aload_3
    //   64: getfield 256	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   67: iconst_1
    //   68: if_icmpne -44 -> 24
    //   71: aload_3
    //   72: getfield 830	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   75: ifle -51 -> 24
    //   78: aload_3
    //   79: getfield 833	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   82: istore_2
    //   83: iload_2
    //   84: ifle -60 -> 24
    //   87: aload_3
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: areturn
    //   93: aload_0
    //   94: getfield 224	agne:kx	Ljava/util/Map;
    //   97: invokeinterface 543 1 0
    //   102: invokeinterface 237 1 0
    //   107: astore 4
    //   109: aload 4
    //   111: invokeinterface 242 1 0
    //   116: ifeq +75 -> 191
    //   119: aload 4
    //   121: invokeinterface 246 1 0
    //   126: checkcast 124	java/lang/Long
    //   129: astore_3
    //   130: aload_0
    //   131: getfield 224	agne:kx	Ljava/util/Map;
    //   134: aload_3
    //   135: invokeinterface 402 2 0
    //   140: checkcast 253	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   143: astore_3
    //   144: aload_3
    //   145: getfield 793	com/tencent/mobileqq/filemanager/data/FileManagerEntity:WeiYunFileId	Ljava/lang/String;
    //   148: ifnull -39 -> 109
    //   151: aload_3
    //   152: getfield 793	com/tencent/mobileqq/filemanager/data/FileManagerEntity:WeiYunFileId	Ljava/lang/String;
    //   155: aload_1
    //   156: invokevirtual 385	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   159: ifeq -50 -> 109
    //   162: aload_3
    //   163: getfield 256	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   166: iconst_1
    //   167: if_icmpne -58 -> 109
    //   170: aload_3
    //   171: getfield 830	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgHeight	I
    //   174: ifle -65 -> 109
    //   177: aload_3
    //   178: getfield 833	com/tencent/mobileqq/filemanager/data/FileManagerEntity:imgWidth	I
    //   181: istore_2
    //   182: iload_2
    //   183: ifle -74 -> 109
    //   186: aload_3
    //   187: astore_1
    //   188: goto -99 -> 89
    //   191: aconst_null
    //   192: astore_1
    //   193: goto -104 -> 89
    //   196: astore_1
    //   197: aload_0
    //   198: monitorexit
    //   199: aload_1
    //   200: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	agne
    //   0	201	1	paramString	String
    //   82	101	2	i	int
    //   44	143	3	localObject	Object
    //   22	98	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	196	finally
    //   13	24	196	finally
    //   24	83	196	finally
    //   93	109	196	finally
    //   109	182	196	finally
  }
  
  public List<FileManagerEntity> d(String paramString, long paramLong)
  {
    ArrayList localArrayList;
    Iterator localIterator;
    Object localObject;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerProxy<FileAssistant>", 1, "call thread:" + Thread.currentThread().getName());
      }
      if (this.Bl == null) {
        init();
      }
      localArrayList = new ArrayList();
      localIterator = this.Bl.iterator();
      while (localIterator.hasNext())
      {
        localObject = (FileManagerEntity)localIterator.next();
        if ((((FileManagerEntity)localObject).fileSize == paramLong) && (((FileManagerEntity)localObject).fileName.equals(paramString)) && (((FileManagerEntity)localObject).status == 1) && (ahbj.fileExistsAndNotEmpty(((FileManagerEntity)localObject).getFilePath()))) {
          localArrayList.add(localObject);
        }
      }
      localIterator = this.kx.keySet().iterator();
    }
    finally {}
    while (localIterator.hasNext())
    {
      localObject = (Long)localIterator.next();
      localObject = (FileManagerEntity)this.kx.get(localObject);
      if ((!localArrayList.contains(localObject)) && (((FileManagerEntity)localObject).fileSize == paramLong) && (((FileManagerEntity)localObject).fileName.equals(paramString)) && (((FileManagerEntity)localObject).status == 1) && (ahbj.fileExistsAndNotEmpty(((FileManagerEntity)localObject).getFilePath()))) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  protected void destory() {}
  
  /* Error */
  public void dgm()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 297	agne:Bl	Ljava/util/List;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 297	agne:Bl	Ljava/util/List;
    //   18: invokeinterface 93 1 0
    //   23: iconst_1
    //   24: isub
    //   25: istore_1
    //   26: iload_1
    //   27: bipush 30
    //   29: if_icmplt -18 -> 11
    //   32: aload_0
    //   33: getfield 297	agne:Bl	Ljava/util/List;
    //   36: iload_1
    //   37: invokeinterface 436 2 0
    //   42: pop
    //   43: iload_1
    //   44: iconst_1
    //   45: isub
    //   46: istore_1
    //   47: goto -21 -> 26
    //   50: astore_2
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	agne
    //   25	22	1	i	int
    //   6	2	2	localList	List
    //   50	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	50	finally
    //   14	26	50	finally
    //   32	43	50	finally
  }
  
  public void diq()
  {
    long l = System.currentTimeMillis();
    if ((this.kx != null) && (this.kx.size() > 0) && (l - this.Zg > 5000L)) {
      ThreadManager.getSubThreadHandler().post(new FileManagerProxy.2(this));
    }
    if (this.cq != null) {
      this.cq.clear();
    }
  }
  
  public void dis()
  {
    String str = "delete from " + FileManagerEntity.tableName();
    this.app.a().createEntityManager().execSQL(str);
  }
  
  public void dit()
  {
    synchronized (this.kE)
    {
      this.kE.clear();
      return;
    }
  }
  
  public FileManagerEntity e(long paramLong)
  {
    FileManagerEntity localFileManagerEntity = null;
    try
    {
      if (this.kx.containsKey(Long.valueOf(paramLong))) {
        localFileManagerEntity = (FileManagerEntity)this.kx.get(Long.valueOf(paramLong));
      }
      return localFileManagerEntity;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public List<FileManagerEntity> e(int paramInt1, int paramInt2)
  {
    Object localObject5;
    long l1;
    for (;;)
    {
      try
      {
        if ((this.Bl == null) || (this.Bl.isEmpty())) {
          init();
        }
        Object localObject1 = "select * from ( select * from " + FileManagerEntity.tableName() + " order by srvTime desc limit " + paramInt1 * paramInt2 + "," + (paramInt2 + 1) * paramInt1 + ") order by srvTime desc";
        localObject5 = this.app.a().createEntityManager();
        localArrayList = null;
        l1 = System.currentTimeMillis();
        try
        {
          localObject1 = ((EntityManager)localObject5).rawQuery(FileManagerEntity.class, (String)localObject1, null);
          if (QLog.isDevelopLevel())
          {
            if (localObject1 == null) {
              QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[null]");
            }
          }
          else
          {
            if (localObject1 != null)
            {
              paramInt1 = ((List)localObject1).size();
              if (paramInt1 != 0) {
                break;
              }
            }
            localObject1 = null;
            return localObject1;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Object localObject2 = localArrayList;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("FileManagerProxy<FileAssistant>", 2, "load " + paramInt1 + " data,is oom!");
          localObject2 = localArrayList;
          continue;
        }
        QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity[" + localObject3.size() + "]");
      }
      finally {}
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = localObject3.iterator();
    label277:
    label536:
    for (;;)
    {
      if (((Iterator)localObject4).hasNext())
      {
        localObject5 = (FileManagerEntity)((Iterator)localObject4).next();
        if (this.kx.containsKey(Long.valueOf(((FileManagerEntity)localObject5).nSessionId)) == true)
        {
          localObject5 = (FileManagerEntity)this.kx.get(Long.valueOf(((FileManagerEntity)localObject5).nSessionId));
          ahav.H((FileManagerEntity)localObject5);
          localArrayList.add(localObject5);
        }
        else
        {
          Iterator localIterator = this.Bl.iterator();
          while (localIterator.hasNext())
          {
            FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
            if (localFileManagerEntity.nSessionId == ((FileManagerEntity)localObject5).nSessionId)
            {
              ahav.H(localFileManagerEntity);
              localArrayList.add(localFileManagerEntity);
            }
          }
        }
      }
      else
      {
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            break label536;
          }
          ahav.H((FileManagerEntity)localObject5);
          localArrayList.add(localObject5);
          break label277;
          long l2 = System.currentTimeMillis();
          if (QLog.isDevelopLevel()) {
            QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity cost[" + (l2 - l1) + "]");
          }
          QLog.d("FileManagerProxy<FileAssistant>", 4, "QueryMoreEntity retList size" + localArrayList.size());
          localObject4 = localArrayList;
          break;
        }
      }
    }
  }
  
  /* Error */
  public List<FileManagerEntity> e(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 40	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 43	java/util/ArrayList:<init>	()V
    //   9: astore 5
    //   11: aload 5
    //   13: invokeinterface 685 1 0
    //   18: aload_0
    //   19: getfield 36	agne:Bm	Ljava/util/List;
    //   22: ifnonnull +14 -> 36
    //   25: aload_0
    //   26: new 40	java/util/ArrayList
    //   29: dup
    //   30: invokespecial 43	java/util/ArrayList:<init>	()V
    //   33: putfield 36	agne:Bm	Ljava/util/List;
    //   36: aload_0
    //   37: getfield 36	agne:Bm	Ljava/util/List;
    //   40: invokeinterface 355 1 0
    //   45: astore 6
    //   47: aload 6
    //   49: invokeinterface 242 1 0
    //   54: ifeq +86 -> 140
    //   57: aload 6
    //   59: invokeinterface 246 1 0
    //   64: checkcast 253	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   67: astore 7
    //   69: aload 7
    //   71: ifnull +51 -> 122
    //   74: aload 7
    //   76: getfield 536	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   79: ifnull +43 -> 122
    //   82: aload 7
    //   84: getfield 536	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   87: aload_2
    //   88: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   91: ifeq +31 -> 122
    //   94: aload 7
    //   96: invokevirtual 361	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getCloudType	()I
    //   99: iconst_2
    //   100: if_icmpne +12 -> 112
    //   103: aload 7
    //   105: getfield 798	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nOpType	I
    //   108: iconst_3
    //   109: if_icmpne +13 -> 122
    //   112: aload 5
    //   114: aload 7
    //   116: invokeinterface 408 2 0
    //   121: pop
    //   122: aload 5
    //   124: invokeinterface 93 1 0
    //   129: istore_3
    //   130: iload_3
    //   131: iload_1
    //   132: if_icmplt -85 -> 47
    //   135: aload_0
    //   136: monitorexit
    //   137: aload 5
    //   139: areturn
    //   140: iconst_0
    //   141: istore_3
    //   142: aload 5
    //   144: invokeinterface 93 1 0
    //   149: ifle +6 -> 155
    //   152: goto -17 -> 135
    //   155: aload_0
    //   156: sipush 200
    //   159: iload_3
    //   160: invokevirtual 881	agne:e	(II)Ljava/util/List;
    //   163: astore 6
    //   165: aload 6
    //   167: ifnonnull +6 -> 173
    //   170: goto -35 -> 135
    //   173: aload 6
    //   175: invokeinterface 355 1 0
    //   180: astore 6
    //   182: aload 6
    //   184: invokeinterface 242 1 0
    //   189: ifeq +110 -> 299
    //   192: aload 6
    //   194: invokeinterface 246 1 0
    //   199: checkcast 253	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   202: astore 7
    //   204: aload 7
    //   206: ifnull +75 -> 281
    //   209: aload 7
    //   211: getfield 536	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   214: ifnull +67 -> 281
    //   217: aload 5
    //   219: aload 7
    //   221: invokeinterface 413 2 0
    //   226: ifne +55 -> 281
    //   229: aload 7
    //   231: getfield 536	com/tencent/mobileqq/filemanager/data/FileManagerEntity:peerUin	Ljava/lang/String;
    //   234: aload_2
    //   235: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   238: ifeq +43 -> 281
    //   241: aload 7
    //   243: invokevirtual 361	com/tencent/mobileqq/filemanager/data/FileManagerEntity:getCloudType	()I
    //   246: iconst_2
    //   247: if_icmpne +12 -> 259
    //   250: aload 7
    //   252: getfield 798	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nOpType	I
    //   255: iconst_3
    //   256: if_icmpne +25 -> 281
    //   259: aload 5
    //   261: aload 7
    //   263: invokeinterface 408 2 0
    //   268: pop
    //   269: aload_0
    //   270: getfield 36	agne:Bm	Ljava/util/List;
    //   273: aload 7
    //   275: invokeinterface 408 2 0
    //   280: pop
    //   281: aload 5
    //   283: invokeinterface 93 1 0
    //   288: istore 4
    //   290: iload 4
    //   292: iload_1
    //   293: if_icmplt -111 -> 182
    //   296: goto -161 -> 135
    //   299: iload_3
    //   300: iconst_1
    //   301: iadd
    //   302: istore_3
    //   303: goto -161 -> 142
    //   306: astore_2
    //   307: aload_0
    //   308: monitorexit
    //   309: aload_2
    //   310: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	agne
    //   0	311	1	paramInt	int
    //   0	311	2	paramString	String
    //   129	174	3	i	int
    //   288	6	4	j	int
    //   9	273	5	localArrayList	ArrayList
    //   45	148	6	localObject	Object
    //   67	207	7	localFileManagerEntity	FileManagerEntity
    // Exception table:
    //   from	to	target	type
    //   2	36	306	finally
    //   36	47	306	finally
    //   47	69	306	finally
    //   74	112	306	finally
    //   112	122	306	finally
    //   122	130	306	finally
    //   142	152	306	finally
    //   155	165	306	finally
    //   173	182	306	finally
    //   182	204	306	finally
    //   209	259	306	finally
    //   259	281	306	finally
    //   281	290	306	finally
  }
  
  public void eG(String paramString, int paramInt)
  {
    Object localObject2;
    try
    {
      if (this.Bl == null) {
        init();
      }
      localObject1 = this.Bl.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
        if ((((FileManagerEntity)localObject2).peerUin != null) && (((FileManagerEntity)localObject2).peerUin.equals(paramString)) && (((FileManagerEntity)localObject2).peerType == paramInt))
        {
          ((FileManagerEntity)localObject2).uniseq = -1L;
          ((FileManagerEntity)localObject2).bDelInAio = true;
        }
      }
      localObject1 = this.kx.keySet().iterator();
    }
    finally {}
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Long)((Iterator)localObject1).next();
      localObject2 = (FileManagerEntity)this.kx.get(localObject2);
      if ((((FileManagerEntity)localObject2).peerUin != null) && (((FileManagerEntity)localObject2).peerUin.equals(paramString)) && (((FileManagerEntity)localObject2).peerType == paramInt))
      {
        ((FileManagerEntity)localObject2).uniseq = -1L;
        ((FileManagerEntity)localObject2).bDelInAio = true;
      }
    }
    Object localObject1 = new ContentValues();
    ((ContentValues)localObject1).put("bDelInAio", Boolean.valueOf(true));
    ((ContentValues)localObject1).put("uniseq", Integer.valueOf(-1));
    a(FileManagerEntity.tableName(), (ContentValues)localObject1, " peerUin = ? and peerType = ? ", new String[] { paramString, String.valueOf(paramInt) }, null);
    a(FileManagerEntity.tableName(), " bDelInAio = ? and bDelInFM = ? ", new String[] { String.valueOf(1), String.valueOf(1) }, null);
  }
  
  public List<FileManagerEntity> eU()
  {
    try
    {
      this.Bm = ad(200);
      if (this.Bm == null) {
        this.Bm = new ArrayList();
      }
      List localList = this.Bm;
      return localList;
    }
    finally {}
  }
  
  public List<FileManagerEntity> eV()
  {
    try
    {
      if (this.Bm == null) {
        eU();
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerProxy<FileAssistant>", 2, "queryMaxRecentRecords size[" + this.Bm.size() + "]");
      }
      List localList = this.Bm;
      return localList;
    }
    finally {}
  }
  
  public List<FileManagerEntity> eW()
  {
    if ((this.Bl == null) || (this.Bl.isEmpty())) {
      init();
    }
    return this.Bl;
  }
  
  public List<FileManagerEntity> f(List<Integer> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    if (this.Bm == null) {
      eU();
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Bm.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!TextUtils.isEmpty(localFileManagerEntity.fileName)) && (!TextUtils.isEmpty(localFileManagerEntity.peerUin)))
      {
        int i = ahav.getFileType(localFileManagerEntity.fileName);
        if ((localFileManagerEntity.peerUin.equals(paramString)) && (paramList.contains(Integer.valueOf(i)))) {
          localArrayList.add(localFileManagerEntity);
        }
      }
    }
    return localArrayList;
  }
  
  /* Error */
  public FileManagerEntity g(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 297	agne:Bl	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 300	agne:init	()V
    //   13: aload_0
    //   14: getfield 297	agne:Bl	Ljava/util/List;
    //   17: invokeinterface 355 1 0
    //   22: astore 4
    //   24: aload 4
    //   26: invokeinterface 242 1 0
    //   31: ifeq +33 -> 64
    //   34: aload 4
    //   36: invokeinterface 246 1 0
    //   41: checkcast 253	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   44: astore_3
    //   45: aload_1
    //   46: aload_3
    //   47: getfield 902	com/tencent/mobileqq/filemanager/data/FileManagerEntity:cloudIdHex	Ljava/lang/String;
    //   50: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: istore_2
    //   54: iload_2
    //   55: ifeq -31 -> 24
    //   58: aload_3
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: areturn
    //   64: aload_0
    //   65: getfield 36	agne:Bm	Ljava/util/List;
    //   68: ifnull +53 -> 121
    //   71: aload_0
    //   72: getfield 36	agne:Bm	Ljava/util/List;
    //   75: invokeinterface 355 1 0
    //   80: astore 4
    //   82: aload 4
    //   84: invokeinterface 242 1 0
    //   89: ifeq +32 -> 121
    //   92: aload 4
    //   94: invokeinterface 246 1 0
    //   99: checkcast 253	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   102: astore_3
    //   103: aload_1
    //   104: aload_3
    //   105: getfield 902	com/tencent/mobileqq/filemanager/data/FileManagerEntity:cloudIdHex	Ljava/lang/String;
    //   108: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   111: istore_2
    //   112: iload_2
    //   113: ifeq -31 -> 82
    //   116: aload_3
    //   117: astore_1
    //   118: goto -58 -> 60
    //   121: aconst_null
    //   122: astore_1
    //   123: goto -63 -> 60
    //   126: astore_1
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	agne
    //   0	131	1	paramString	String
    //   53	60	2	bool	boolean
    //   44	73	3	localFileManagerEntity	FileManagerEntity
    //   22	71	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	126	finally
    //   13	24	126	finally
    //   24	54	126	finally
    //   64	82	126	finally
    //   82	112	126	finally
  }
  
  public List<FileManagerEntity> g(List<Integer> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList(paramList);
    paramList = new ArrayList(this.Bp);
    paramList.removeAll(localArrayList);
    localArrayList = new ArrayList();
    Iterator localIterator = this.Bm.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if ((!TextUtils.isEmpty(localFileManagerEntity.fileName)) && (!TextUtils.isEmpty(localFileManagerEntity.peerUin)))
      {
        int i = ahav.getFileType(localFileManagerEntity.fileName);
        if ((localFileManagerEntity.peerUin.equals(paramString)) && (paramList.contains(Integer.valueOf(i)))) {
          localArrayList.add(localFileManagerEntity);
        }
      }
    }
    return localArrayList;
  }
  
  public FileManagerEntity h(String paramString)
  {
    for (;;)
    {
      try
      {
        if (this.Bl == null) {
          init();
        }
        Object localObject = "select * from " + FileManagerEntity.tableName() + " where Uuid = ?";
        EntityManager localEntityManager = this.app.a().createEntityManager();
        if (localEntityManager == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("FileManagerProxy<FileAssistant>", 2, "get EntityManager null!");
          }
          paramString = null;
          return paramString;
        }
        long l1 = System.currentTimeMillis();
        paramString = localEntityManager.rawQuery(FileManagerEntity.class, (String)localObject, new String[] { SecurityUtile.encode(paramString) });
        long l2 = System.currentTimeMillis();
        if (paramString == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FileManagerProxy<FileAssistant>", 2, "queryOver, but no data!");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("FileManagerProxy<FileAssistant>", 2, "query over,startTime[" + String.valueOf(l1) + "], overTime[" + String.valueOf(l2) + "]");
          }
          if ((paramString.size() > 1) && (QLog.isColorLevel())) {
            QLog.w("FileManagerProxy", 2, "why size[" + String.valueOf(paramString.size()) + "] over 1?");
          }
          localObject = (FileManagerEntity)paramString.get(0);
          if (localObject == null)
          {
            paramString = null;
            continue;
          }
          this.kx.put(Long.valueOf(((FileManagerEntity)localObject).nSessionId), localObject);
          ahap.G((FileManagerEntity)localObject);
          paramString = (String)localObject;
          if (((FileManagerEntity)localObject).cloudType != 1) {
            continue;
          }
          paramString = (String)localObject;
          if (!ahav.o((FileManagerEntity)localObject)) {
            continue;
          }
          ((FileManagerEntity)localObject).status = 16;
          paramString = (String)localObject;
          continue;
        }
        paramString = null;
      }
      finally {}
    }
  }
  
  public FileManagerEntity i(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.Bl == null) {
      init();
    }
    Iterator localIterator = this.kx.keySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Long)localIterator.next();
      localObject = (FileManagerEntity)this.kx.get(localObject);
      if ((!TextUtils.isEmpty(((FileManagerEntity)localObject).strTroopFilePath)) && (paramString.equalsIgnoreCase(((FileManagerEntity)localObject).strTroopFilePath))) {
        return localObject;
      }
    }
    localIterator = this.Bl.iterator();
    while (localIterator.hasNext())
    {
      localObject = (FileManagerEntity)localIterator.next();
      if ((!TextUtils.isEmpty(((FileManagerEntity)localObject).strTroopFilePath)) && (paramString.equalsIgnoreCase(((FileManagerEntity)localObject).strTroopFilePath))) {
        return localObject;
      }
    }
    return null;
  }
  
  public void i(long paramLong1, String paramString, long paramLong2)
  {
    if ((paramString == null) || (paramLong1 < 0L) || (paramLong2 <= 0L)) {}
    do
    {
      return;
      if (this.Bo.size() > 30) {
        this.Bo.remove(0);
      }
      agne.a locala = new agne.a();
      locala.nSessionId = paramLong1;
      locala.peerUin = paramString;
      locala.Zj = paramLong2;
      this.Bo.add(locala);
    } while (!QLog.isColorLevel());
    QLog.i("FileManagerProxy<FileAssistant>", 2, "saveDeletedEntity nSessionId=" + paramLong1 + " nOlSessionId=" + paramLong2);
  }
  
  public void init()
  {
    if (this.Bl != null) {
      return;
    }
    Object localObject2 = "select * from ( select * from " + FileManagerEntity.tableName() + " order by srvTime desc limit " + 30 + ") order by srvTime desc";
    Object localObject3 = "update  " + FileManagerEntity.tableName() + " set bDelInFM = ?  where ( srvTime + ?  ) < ? and cloudType = ? ";
    EntityManager localEntityManager = this.app.a().createEntityManager();
    localEntityManager.update((String)localObject3, new Object[] { Integer.valueOf(1), Long.valueOf(604800000L), Long.valueOf(anaz.gQ() * 1000L), Integer.valueOf(1) });
    this.Bl = localEntityManager.rawQuery(FileManagerEntity.class, (String)localObject2, null);
    if (this.Bl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerProxy<FileAssistant>", 2, "init , buf fmList is null,maybe is not data!,sql[" + (String)localObject2 + "]");
      }
      this.Bl = new ArrayList();
    }
    try
    {
      if (this.kx == null)
      {
        this.kx = new HashMap();
        localObject2 = this.Bl.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FileManagerEntity)((Iterator)localObject2).next();
          ahav.H((FileManagerEntity)localObject3);
          this.kx.put(Long.valueOf(((FileManagerEntity)localObject3).nSessionId), localObject3);
        }
      }
    }
    finally {}
    localObject1.close();
  }
  
  /* Error */
  public FileManagerEntity j(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 297	agne:Bl	Ljava/util/List;
    //   6: ifnonnull +7 -> 13
    //   9: aload_0
    //   10: invokevirtual 300	agne:init	()V
    //   13: aload_0
    //   14: getfield 297	agne:Bl	Ljava/util/List;
    //   17: invokeinterface 355 1 0
    //   22: astore 4
    //   24: aload 4
    //   26: invokeinterface 242 1 0
    //   31: ifeq +40 -> 71
    //   34: aload 4
    //   36: invokeinterface 246 1 0
    //   41: checkcast 253	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   44: astore_3
    //   45: aload_3
    //   46: getfield 958	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   49: ifnull -25 -> 24
    //   52: aload_3
    //   53: getfield 958	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   56: aload_1
    //   57: invokevirtual 385	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: istore_2
    //   61: iload_2
    //   62: ifeq -38 -> 24
    //   65: aload_3
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: areturn
    //   71: aload_0
    //   72: getfield 224	agne:kx	Ljava/util/Map;
    //   75: invokeinterface 543 1 0
    //   80: invokeinterface 237 1 0
    //   85: astore 4
    //   87: aload 4
    //   89: invokeinterface 242 1 0
    //   94: ifeq +60 -> 154
    //   97: aload 4
    //   99: invokeinterface 246 1 0
    //   104: checkcast 124	java/lang/Long
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 224	agne:kx	Ljava/util/Map;
    //   112: aload_3
    //   113: invokeinterface 402 2 0
    //   118: checkcast 253	com/tencent/mobileqq/filemanager/data/FileManagerEntity
    //   121: astore_3
    //   122: aload_3
    //   123: ifnull -36 -> 87
    //   126: aload_3
    //   127: getfield 958	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   130: invokestatic 739	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   133: ifne -46 -> 87
    //   136: aload_3
    //   137: getfield 958	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   140: aload_1
    //   141: invokevirtual 385	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   144: istore_2
    //   145: iload_2
    //   146: ifeq -59 -> 87
    //   149: aload_3
    //   150: astore_1
    //   151: goto -84 -> 67
    //   154: aconst_null
    //   155: astore_1
    //   156: goto -89 -> 67
    //   159: astore_1
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	agne
    //   0	164	1	paramString	String
    //   60	86	2	bool	boolean
    //   44	106	3	localObject	Object
    //   22	76	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	13	159	finally
    //   13	24	159	finally
    //   24	61	159	finally
    //   71	87	159	finally
    //   87	122	159	finally
    //   126	145	159	finally
  }
  
  public void jo(long paramLong)
  {
    try
    {
      if (this.kx != null)
      {
        Iterator localIterator = this.kx.entrySet().iterator();
        while (localIterator.hasNext()) {
          if (paramLong == ((FileManagerEntity)((Map.Entry)localIterator.next()).getValue()).nSessionId) {
            localIterator.remove();
          }
        }
      }
    }
    finally {}
  }
  
  public FileManagerEntity k(String arg1)
  {
    FileManagerEntity localFileManagerEntity;
    synchronized (this.kE)
    {
      if (this.kE.size() == 0) {
        return null;
      }
      localFileManagerEntity = (FileManagerEntity)this.kE.get(???);
      if (localFileManagerEntity == null) {
        return null;
      }
    }
    ??? = e(localFileManagerEntity.nSessionId);
    if (??? != null)
    {
      if (??? == localFileManagerEntity)
      {
        if (!ahbj.fileExistsAndNotEmpty(localFileManagerEntity.getFilePath())) {
          synchronized (this.kE)
          {
            this.kE.remove(localFileManagerEntity.zipInnerPath);
            QLog.e("FileManagerProxy<FileAssistant>", 1, "getZipFileListEntity : can find the Entity in cache, but raw file is not exist! [fileName] = " + localFileManagerEntity.fileName + "[sessionId] = " + localFileManagerEntity.nSessionId);
            return null;
          }
        }
      }
      else {
        synchronized (this.kE)
        {
          this.kE.put(???, ???);
          return ???;
        }
      }
    }
    else {
      try
      {
        this.kx.put(Long.valueOf(???.nSessionId), ???);
        return ???;
      }
      finally {}
    }
    return ???;
  }
  
  public boolean mA(String paramString)
  {
    if (this.cq == null)
    {
      this.cq = new HashSet();
      return false;
    }
    return this.cq.contains(paramString);
  }
  
  public Map<String, List<FileManagerEntity>> q(String paramString)
  {
    if (this.Bm == null) {
      eU();
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).addAll(this.Bm);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject2 = ((List)localObject1).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (FileManagerEntity)((Iterator)localObject2).next();
      if ((!TextUtils.isEmpty(((FileManagerEntity)localObject3).fileName)) && (((FileManagerEntity)localObject3).fileName.indexOf(paramString) >= 0))
      {
        if (!localLinkedHashMap.containsKey(((FileManagerEntity)localObject3).fileName)) {
          localLinkedHashMap.put(((FileManagerEntity)localObject3).fileName, new ArrayList());
        }
        ((List)localLinkedHashMap.get(((FileManagerEntity)localObject3).fileName)).add(localObject3);
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
      if (!TextUtils.isEmpty(((FileManagerEntity)localObject2).fileName))
      {
        localObject3 = ((FileManagerEntity)localObject2).fileName;
        if (localLinkedHashMap.containsKey(((FileManagerEntity)localObject2).fileName) != true) {
          if (amxk.b(paramString, (String)localObject3, amjz.aiT) > -9223372036854775808L)
          {
            if (!localLinkedHashMap.containsKey(((FileManagerEntity)localObject2).fileName)) {
              localLinkedHashMap.put(((FileManagerEntity)localObject2).fileName, new ArrayList());
            }
            ((List)localLinkedHashMap.get(((FileManagerEntity)localObject2).fileName)).add(localObject2);
          }
          else
          {
            localObject3 = ahav.e((FileManagerEntity)localObject2);
            if (TextUtils.isEmpty((CharSequence)localObject3))
            {
              if (QLog.isDevelopLevel()) {
                throw new NullPointerException("get Full String error!!!");
              }
            }
            else if (amxk.b(paramString, ((String)localObject3).replace(acfp.m(2131706245), "").replace(acfp.m(2131706269), "").replace(acfp.m(2131706263), "").replace(acfp.m(2131706256), "").replace(acfp.m(2131706246), "").replace(acfp.m(2131706276), "").replace(acfp.m(2131706261), "").replace(acfp.m(2131706257), "").replace(acfp.m(2131706254), "").trim(), amjz.aiT) > -9223372036854775808L)
            {
              if (!localLinkedHashMap.containsKey(((FileManagerEntity)localObject2).fileName)) {
                localLinkedHashMap.put(((FileManagerEntity)localObject2).fileName, new ArrayList());
              }
              ((List)localLinkedHashMap.get(((FileManagerEntity)localObject2).fileName)).add(localObject2);
            }
          }
        }
      }
    }
    return localLinkedHashMap;
  }
  
  public boolean r(String paramString, long paramLong)
  {
    Iterator localIterator = this.Bo.iterator();
    while (localIterator.hasNext())
    {
      agne.a locala = (agne.a)localIterator.next();
      if ((locala.Zj == paramLong) && (locala.peerUin != null) && (locala.peerUin.equalsIgnoreCase(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public void u(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerProxy<FileAssistant>", 2, "updateFileEntity, Error : entity is null!!!");
      }
      return;
    }
    ahav.H(paramFileManagerEntity);
    int i = paramFileManagerEntity.status;
    if (i == 2) {
      paramFileManagerEntity.status = 0;
    }
    ContentValues localContentValues = a(paramFileManagerEntity);
    paramFileManagerEntity.status = i;
    long l = paramFileManagerEntity.nSessionId;
    paramFileManagerEntity = Looper.getMainLooper();
    if (Thread.currentThread() == paramFileManagerEntity.getThread()) {
      try
      {
        a(FileManagerEntity.tableName(), localContentValues, "nSessionId=?", new String[] { String.valueOf(l) }, null);
        return;
      }
      catch (Exception paramFileManagerEntity)
      {
        paramFileManagerEntity.printStackTrace();
        return;
      }
    }
    new Handler(paramFileManagerEntity).post(new FileManagerProxy.3(this, localContentValues, l));
  }
  
  public void v(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      init();
      ahav.H(paramFileManagerEntity);
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.kx.get(Long.valueOf(paramFileManagerEntity.nSessionId));
      this.kx.put(Long.valueOf(paramFileManagerEntity.nSessionId), paramFileManagerEntity);
      return;
    }
    finally
    {
      paramFileManagerEntity = finally;
      throw paramFileManagerEntity;
    }
  }
  
  public void z(FileManagerEntity paramFileManagerEntity)
  {
    for (;;)
    {
      try
      {
        v(paramFileManagerEntity);
        Looper localLooper = Looper.getMainLooper();
        Thread localThread1 = Thread.currentThread();
        Thread localThread2 = localLooper.getThread();
        if (localThread1 == localThread2) {
          try
          {
            a(paramFileManagerEntity, null);
            if (!paramFileManagerEntity.bDelInFM) {
              A(paramFileManagerEntity);
            }
            return;
          }
          catch (Exception paramFileManagerEntity)
          {
            paramFileManagerEntity.printStackTrace();
            continue;
          }
        }
        new Handler(localLooper).post(new FileManagerProxy.1(this, paramFileManagerEntity));
      }
      finally {}
    }
  }
  
  class a
  {
    long Zj;
    long nSessionId;
    String peerUin;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agne
 * JD-Core Version:    0.7.0.1
 */