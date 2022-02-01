import android.database.Observable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.app.MobileQQ;

public class apsf
  extends Observable<apcp>
{
  public static Map<Long, apsf> nN;
  public apsf.b a;
  private smq.b jdField_a_of_type_Smq$b = new apsi(this);
  private smq.p jdField_a_of_type_Smq$p = new apsj(this);
  public String aEG = "";
  public apsf.b b;
  private smq.e b;
  public accd d;
  public TroopFileTransferManager d;
  public int dVF;
  public ArrayMap<Integer, List<apcs>> m = new ArrayMap();
  public QQAppInterface mApp;
  public Handler mHandler;
  public int mRunningCount;
  public long mTroopUin;
  public Map<String, apbr> nO = new HashMap();
  public Map<UUID, apbr> nP = new HashMap();
  public Map<String, apsf.a> nQ = new HashMap();
  
  static
  {
    if (!apsf.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      nN = new HashMap();
      return;
    }
  }
  
  public apsf(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.jdField_a_of_type_Apsf$b = new apsf.c();
    this.jdField_b_of_type_Apsf$b = new apsf.d();
    this.jdField_d_of_type_Accd = new apsh(this);
    this.jdField_b_of_type_Smq$e = new apsk(this);
    this.mTroopUin = paramLong;
    this.mApp = paramQQAppInterface;
    this.jdField_d_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(paramQQAppInterface, paramLong);
    Iterator localIterator = this.jdField_d_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.f().iterator();
    while (localIterator.hasNext())
    {
      apcy localapcy = (apcy)localIterator.next();
      apbr localapbr = new apbr();
      localapbr.Id = localapcy.Id;
      localapbr.a(localapcy, this.mApp);
      this.nP.put(localapbr.Id, localapbr);
      if ((localapbr.mFileId != null) && (!"/".equals(localapbr.mFileId))) {
        this.nO.put(localapbr.mFileId, localapbr);
      }
    }
    this.mHandler = new apsg(this, paramQQAppInterface.getApplication().getMainLooper());
    paramQQAppInterface.addObserver(this.jdField_d_of_type_Accd);
  }
  
  private void Release()
  {
    try
    {
      this.mApp.removeObserver(this.jdField_d_of_type_Accd);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static apsf a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      apsf localapsf2 = (apsf)nN.get(Long.valueOf(paramLong));
      apsf localapsf1;
      if (localapsf2 != null)
      {
        localapsf1 = localapsf2;
        if (localapsf2.mApp == paramQQAppInterface) {}
      }
      else
      {
        localapsf1 = new apsf(paramQQAppInterface, paramLong);
        nN.put(Long.valueOf(paramLong), localapsf1);
      }
      return localapsf1;
    }
    finally {}
  }
  
  public static List<apbr> a(Collection<apbr> paramCollection, apsf.b paramb)
  {
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      apbr localapbr = (apbr)paramCollection.next();
      if (paramb.d(localapbr)) {
        localArrayList.add(localapbr);
      }
    }
    return localArrayList;
  }
  
  public static void ebE()
  {
    
    try
    {
      Iterator localIterator = nN.values().iterator();
      while (localIterator.hasNext()) {
        ((apsf)localIterator.next()).Release();
      }
      nN.clear();
    }
    finally {}
  }
  
  public final boolean F(String paramString, long paramLong)
  {
    try
    {
      apsf.a locala = (apsf.a)this.nQ.get(paramString + paramLong);
      paramString = locala;
      if (locala == null) {
        paramString = new apsf.a(paramLong);
      }
      boolean bool = paramString.mIsEnd;
      return bool;
    }
    finally {}
  }
  
  public final boolean G(String paramString, long paramLong)
  {
    try
    {
      apsf.a locala = (apsf.a)this.nQ.get(paramString + paramLong);
      if (locala == null)
      {
        locala = new apsf.a(paramLong);
        this.nQ.put(paramString + paramLong, locala);
      }
      for (;;)
      {
        if (!locala.mIsEnd)
        {
          bool = locala.cSg;
          if (!bool) {
            break label108;
          }
        }
        for (boolean bool = false;; bool = true)
        {
          return bool;
          label108:
          smq.a(this.mApp, this.mTroopUin, locala.bxJ, 3, 20, 3, 1, paramString, locala.dVG, paramLong, locala.mStartIndex, locala.a, this.jdField_b_of_type_Smq$e);
          locala.cSg = true;
        }
      }
    }
    finally {}
  }
  
  public int LF()
  {
    return this.dVF;
  }
  
  public final void TQ(String paramString)
  {
    try
    {
      apef.b.i("TroopFileManager", apef.b.USR, "doUploadDelete: filePath:" + paramString);
      paramString = (apbr)this.nO.remove(paramString);
      if ((!$assertionsDisabled) && (paramString == null)) {
        throw new AssertionError();
      }
    }
    finally {}
    if (paramString != null)
    {
      this.nP.remove(paramString.Id);
      j(paramString);
    }
  }
  
  public final void TR(String paramString)
  {
    try
    {
      apef.b.i("TroopFileManager", apef.b.USR, "doTroopFileDelete: filePath:" + paramString);
      paramString = (apbr)this.nO.remove(paramString);
      if ((!$assertionsDisabled) && (paramString == null)) {
        throw new AssertionError();
      }
    }
    finally {}
    if (paramString != null)
    {
      this.nP.remove(paramString.Id);
      j(paramString);
    }
  }
  
  public void WZ(int paramInt)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((apcp)localIterator.next()).WC(paramInt);
    }
  }
  
  /* Error */
  public apbr a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 72	apsf:nO	Ljava/util/Map;
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: getfield 72	apsf:nO	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 209 2 0
    //   19: checkcast 145	apbr
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: aconst_null
    //   28: astore_1
    //   29: goto -6 -> 23
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	apsf
    //   0	37	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	23	32	finally
  }
  
  public apbr a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      apbr localapbr = new apbr();
      localapbr.Id = UUID.randomUUID();
      localapbr.str_file_name = paramString;
      localapbr.uint64_file_size = paramLong;
      localapbr.dTg = paramInt;
      localapbr.WB((int)NetConnInfoCenter.getServerTime());
      this.nP.put(localapbr.Id, localapbr);
      return localapbr;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public apbr a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (paramString1 == null) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      Object localObject1;
      label34:
      try
      {
        localObject1 = apef.oD(paramString1);
        if (localObject1 == null) {
          break label271;
        }
        if (((String)localObject1).length() != 0) {
          break label268;
        }
      }
      finally {}
      Object localObject2 = (apbr)this.nO.get(paramString1);
      if (localObject2 != null)
      {
        this.nP.put(((apbr)localObject2).Id, localObject2);
        paramString1 = (String)localObject2;
      }
      else
      {
        localObject1 = (apbr)this.nO.get(localObject1);
        if (localObject1 != null)
        {
          this.nP.put(((apbr)localObject1).Id, localObject1);
          paramString1 = (String)localObject1;
        }
        else
        {
          label268:
          label271:
          while (paramInt != 0)
          {
            localObject1 = new apbr();
            localObject2 = this.jdField_d_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.a(paramString1);
            if (localObject2 != null) {
              ((apbr)localObject1).Id = ((apcy)localObject2).Id;
            }
            if (((apbr)localObject1).Id == null) {
              ((apbr)localObject1).Id = UUID.nameUUIDFromBytes(paramString1.getBytes());
            }
            ((apbr)localObject1).mFileId = paramString1;
            ((apbr)localObject1).str_file_name = paramString2;
            ((apbr)localObject1).uint64_file_size = paramLong;
            ((apbr)localObject1).dTg = paramInt;
            if (TextUtils.isEmpty(this.aEG)) {}
            for (paramString2 = "/";; paramString2 = this.aEG)
            {
              ((apbr)localObject1).mParentId = paramString2;
              this.nP.put(((apbr)localObject1).Id, localObject1);
              this.nO.put(paramString1, localObject1);
              paramString1 = (String)localObject1;
              break;
            }
            break label34;
            localObject1 = "0";
            break label34;
          }
          paramString1 = null;
        }
      }
    }
  }
  
  public void a(apbr paramapbr, int paramInt)
  {
    apsd.a(this.mApp, this.mTroopUin, paramapbr.str_file_name, paramapbr.Status, paramInt);
  }
  
  public final void a(apbr paramapbr, int paramInt1, int paramInt2)
  {
    if (paramapbr != null) {}
    for (;;)
    {
      try
      {
        UUID localUUID = paramapbr.Id;
        if (localUUID == null) {
          return;
        }
        apef.b.i("TroopFileManager", apef.b.USR, "[" + paramapbr.Id.toString() + "] delete. mFileId:" + paramapbr.mFileId + " mParentId:" + paramapbr.mParentId + " uint32_bus_id:" + paramapbr.dTg);
        if ((paramapbr.mFileId == null) || (paramapbr.mParentId == null) || ("".equals(paramapbr.mFileId)) || ("".equals(paramapbr.mParentId)))
        {
          e(paramapbr.Id);
          continue;
        }
        if (paramapbr.dTg == 0) {
          continue;
        }
      }
      finally {}
      smq.a(this.mApp, this.mTroopUin, paramapbr.dTg, paramapbr.mFileId, paramapbr.mParentId, paramInt1, paramInt2, this.jdField_a_of_type_Smq$b);
    }
  }
  
  public void a(String paramString, apbr paramapbr)
  {
    try
    {
      this.nO.put(paramString, paramapbr);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(Collection<apbr> paramCollection, boolean paramBoolean, String paramString, long paramLong)
  {
    this.mHandler.obtainMessage(1, new Object[] { paramCollection, Boolean.valueOf(paramBoolean), paramString, Long.valueOf(paramLong) }).sendToTarget();
  }
  
  public boolean a(apcp paramapcp)
  {
    return this.mObservers.contains(paramapcp);
  }
  
  public apbr b(String paramString)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    for (;;)
    {
      try
      {
        apbr localapbr = new apbr();
        localapbr.Id = UUID.randomUUID();
        localapbr.LocalFile = paramString;
        paramString = new File(paramString);
        localapbr.uint64_file_size = paramString.length();
        localapbr.str_file_name = paramString.getName();
        if (TextUtils.isEmpty(this.aEG))
        {
          paramString = "/";
          localapbr.mParentId = paramString;
          this.nP.put(localapbr.Id, localapbr);
          paramString = localapbr;
          break;
        }
      }
      finally {}
      paramString = this.aEG;
    }
  }
  
  public apbr b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      apbr localapbr = new apbr();
      localapbr.Id = UUID.nameUUIDFromBytes(paramString1.getBytes());
      localapbr.mFileId = paramString1;
      localapbr.str_file_name = paramString2;
      localapbr.uint64_file_size = paramLong;
      localapbr.dTg = paramInt;
      localapbr.mParentId = "/";
      this.nP.put(localapbr.Id, localapbr);
      this.nO.put(paramString1, localapbr);
      return localapbr;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public apbr b(UUID paramUUID)
  {
    try
    {
      paramUUID = (apbr)this.nP.get(paramUUID);
      return paramUUID;
    }
    finally
    {
      paramUUID = finally;
      throw paramUUID;
    }
  }
  
  public void b(apbr paramapbr, String paramString)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((apcp)localIterator.next()).a(paramapbr, paramString);
    }
  }
  
  public void b(List<apbr> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((apcp)localIterator.next()).a(paramList, paramBoolean, paramString, paramLong);
    }
  }
  
  public apbr c(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      paramString1 = a(paramString1, paramString2, paramLong, paramInt);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public final boolean c(apbr paramapbr)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 338	apbr:dTg	I
    //   6: ifeq +14 -> 20
    //   9: aload_1
    //   10: getfield 163	apbr:mFileId	Ljava/lang/String;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +9 -> 26
    //   20: iconst_0
    //   21: istore_3
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_3
    //   25: ireturn
    //   26: getstatic 290	apef$b:USR	I
    //   29: istore_2
    //   30: new 238	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 391
    //   40: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: astore 5
    //   45: aload_1
    //   46: getfield 151	apbr:Id	Ljava/util/UUID;
    //   49: ifnull +73 -> 122
    //   52: aload_1
    //   53: getfield 151	apbr:Id	Ljava/util/UUID;
    //   56: invokevirtual 392	java/util/UUID:toString	()Ljava/lang/String;
    //   59: astore 4
    //   61: ldc_w 285
    //   64: iload_2
    //   65: aload 5
    //   67: aload 4
    //   69: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 457
    //   75: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: getfield 163	apbr:mFileId	Ljava/lang/String;
    //   82: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 296	apef$b:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_0
    //   92: getfield 115	apsf:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: aload_0
    //   96: getfield 113	apsf:mTroopUin	J
    //   99: aload_1
    //   100: aload_0
    //   101: getfield 106	apsf:jdField_a_of_type_Smq$p	Lsmq$p;
    //   104: invokestatic 460	smq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLapbr;Lsmq$p;)V
    //   107: aload_0
    //   108: aload_0
    //   109: getfield 462	apsf:mRunningCount	I
    //   112: iconst_1
    //   113: iadd
    //   114: putfield 462	apsf:mRunningCount	I
    //   117: iconst_1
    //   118: istore_3
    //   119: goto -97 -> 22
    //   122: ldc_w 464
    //   125: astore 4
    //   127: goto -66 -> 61
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	apsf
    //   0	135	1	paramapbr	apbr
    //   29	36	2	i	int
    //   21	98	3	bool	boolean
    //   13	113	4	str	String
    //   43	23	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	15	130	finally
    //   26	61	130	finally
    //   61	117	130	finally
  }
  
  public final void d(UUID paramUUID)
  {
    if (paramUUID == null) {}
    for (;;)
    {
      return;
      try
      {
        paramUUID = (apbr)this.nP.get(paramUUID);
        if ((paramUUID == null) || (!paramUUID.cPL)) {
          continue;
        }
        paramUUID.cPL = false;
        k(paramUUID);
      }
      finally {}
    }
  }
  
  public final boolean d(int paramInt, String paramString, long paramLong)
  {
    try
    {
      apsf.a locala = (apsf.a)this.nQ.get(paramString + paramLong);
      if (locala == null)
      {
        locala = new apsf.a(paramLong);
        this.nQ.put(paramString + paramLong, locala);
      }
      for (;;)
      {
        long l1 = System.currentTimeMillis();
        long l2 = locala.arU;
        l1 -= l2;
        if ((0L < l1) && (l1 < paramInt * 1000L)) {}
        for (boolean bool = false;; bool = true)
        {
          return bool;
          locala.arU = System.currentTimeMillis();
          smq.a(this.mApp, this.mTroopUin, locala.bxJ, 1, 20, 3, 1, paramString, locala.dVG, paramLong, 0, locala.a, this.jdField_b_of_type_Smq$e);
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public final void e(UUID paramUUID)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 290	apef$b:USR	I
    //   5: istore_2
    //   6: new 238	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 391
    //   16: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: astore 4
    //   21: aload_1
    //   22: ifnull +51 -> 73
    //   25: aload_1
    //   26: invokevirtual 392	java/util/UUID:toString	()Ljava/lang/String;
    //   29: astore_3
    //   30: ldc_w 285
    //   33: iload_2
    //   34: aload 4
    //   36: aload_3
    //   37: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 483
    //   43: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 296	apef$b:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 70	apsf:nP	Ljava/util/Map;
    //   56: aload_1
    //   57: invokeinterface 299 2 0
    //   62: checkcast 145	apbr
    //   65: astore_1
    //   66: aload_1
    //   67: ifnonnull +13 -> 80
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: ldc_w 464
    //   76: astore_3
    //   77: goto -47 -> 30
    //   80: aload_0
    //   81: aload_1
    //   82: invokevirtual 306	apsf:j	(Lapbr;)V
    //   85: aload_0
    //   86: getfield 72	apsf:nO	Ljava/util/Map;
    //   89: aload_1
    //   90: getfield 163	apbr:mFileId	Ljava/lang/String;
    //   93: invokeinterface 299 2 0
    //   98: pop
    //   99: goto -29 -> 70
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	apsf
    //   0	107	1	paramUUID	UUID
    //   5	29	2	i	int
    //   29	48	3	str	String
    //   19	16	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	21	102	finally
    //   25	30	102	finally
    //   30	66	102	finally
    //   80	99	102	finally
  }
  
  public final void ebF()
  {
    try
    {
      Iterator localIterator = this.nP.values().iterator();
      while (localIterator.hasNext()) {
        ((apbr)localIterator.next()).cPL = false;
      }
    }
    finally {}
  }
  
  public final void g(apbr paramapbr)
  {
    try
    {
      a(paramapbr, 0, 0);
      return;
    }
    finally
    {
      paramapbr = finally;
      throw paramapbr;
    }
  }
  
  public final List<apbr> gD()
  {
    try
    {
      List localList = a(this.nP.values(), this.jdField_b_of_type_Apsf$b);
      return localList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void j(apbr paramapbr)
  {
    this.jdField_d_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager.g(paramapbr.Id);
    this.mHandler.obtainMessage(2, new Object[] { paramapbr }).sendToTarget();
  }
  
  public void k(apbr paramapbr)
  {
    this.mHandler.obtainMessage(3, new Object[] { paramapbr }).sendToTarget();
  }
  
  public void m(apbr paramapbr)
  {
    this.mHandler.obtainMessage(6, new Object[] { paramapbr }).sendToTarget();
  }
  
  /* Error */
  public final void p(apbr paramapbr)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +92 -> 95
    //   6: getstatic 290	apef$b:USR	I
    //   9: istore_2
    //   10: new 238	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 391
    //   20: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: astore 4
    //   25: aload_1
    //   26: getfield 151	apbr:Id	Ljava/util/UUID;
    //   29: ifnull +69 -> 98
    //   32: aload_1
    //   33: getfield 151	apbr:Id	Ljava/util/UUID;
    //   36: invokevirtual 392	java/util/UUID:toString	()Ljava/lang/String;
    //   39: astore_3
    //   40: ldc_w 285
    //   43: iload_2
    //   44: aload 4
    //   46: aload_3
    //   47: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 498
    //   53: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 296	apef$b:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: getfield 72	apsf:nO	Ljava/util/Map;
    //   66: aload_1
    //   67: getfield 163	apbr:mFileId	Ljava/lang/String;
    //   70: invokeinterface 299 2 0
    //   75: pop
    //   76: aload_0
    //   77: getfield 70	apsf:nP	Ljava/util/Map;
    //   80: aload_1
    //   81: getfield 151	apbr:Id	Ljava/util/UUID;
    //   84: invokeinterface 299 2 0
    //   89: pop
    //   90: aload_0
    //   91: aload_1
    //   92: invokevirtual 306	apsf:j	(Lapbr;)V
    //   95: aload_0
    //   96: monitorexit
    //   97: return
    //   98: ldc_w 464
    //   101: astore_3
    //   102: goto -62 -> 40
    //   105: astore_1
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	apsf
    //   0	110	1	paramapbr	apbr
    //   9	35	2	i	int
    //   39	63	3	str	String
    //   23	22	4	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	40	105	finally
    //   40	95	105	finally
  }
  
  public void q(apbr paramapbr)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((apcp)localIterator.next()).j(paramapbr);
    }
  }
  
  public void r(apbr paramapbr)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((apcp)localIterator.next()).k(paramapbr);
    }
  }
  
  public void s(apbr paramapbr)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((apcp)localIterator.next()).l(paramapbr);
    }
  }
  
  public void t(apbr paramapbr)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((apcp)localIterator.next()).n(paramapbr);
    }
  }
  
  public void u(apbr paramapbr)
  {
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext()) {
      ((apcp)localIterator.next()).m(paramapbr);
    }
  }
  
  public class a
  {
    public List<apbr> BE = new ArrayList();
    public ByteStringMicro a = ByteStringMicro.copyFromUtf8("");
    public long arU = 0L;
    public int bxJ = 0;
    public boolean cSg = false;
    public int dVG;
    public boolean mIsEnd = false;
    public int mRequestCount = 0;
    public int mStartIndex = 0;
    public Map<String, apbr> nR = new HashMap();
    
    public a(long paramLong)
    {
      if (paramLong == 0L) {
        this.dVG = 0;
      }
      for (;;)
      {
        this.dVG = i;
        return;
        i = 3;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean d(apbr paramapbr);
  }
  
  public static class c
    implements apsf.b
  {
    public boolean d(apbr paramapbr)
    {
      if (paramapbr.cPM) {
        return false;
      }
      switch (paramapbr.Status)
      {
      }
      return true;
    }
  }
  
  public static class d
    implements apsf.b
  {
    public boolean d(apbr paramapbr)
    {
      switch (paramapbr.Status)
      {
      default: 
        return false;
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apsf
 * JD-Core Version:    0.7.0.1
 */