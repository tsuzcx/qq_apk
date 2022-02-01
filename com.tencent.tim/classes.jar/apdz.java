import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferMgr.5;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class apdz
  extends TroopFileTransferManager
{
  private static Handler dC;
  protected apew.a a;
  protected apfx.a a;
  protected int dTO;
  protected int dTP;
  
  static
  {
    if (!apdz.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public apdz(QQAppInterface paramQQAppInterface, long paramLong)
  {
    this.mApp = paramQQAppInterface;
    this.mTroopUin = paramLong;
  }
  
  public static void b(Runnable paramRunnable, boolean paramBoolean)
  {
    if (dC == null) {}
    try
    {
      dC = new Handler(Looper.getMainLooper());
      if ((paramBoolean) || (Thread.currentThread() != dC.getLooper().getThread()))
      {
        dC.post(paramRunnable);
        return;
      }
    }
    finally {}
    paramRunnable.run();
  }
  
  public apcy a(String paramString1, long paramLong1, String paramString2, String paramString3, long paramLong2, int paramInt1, int paramInt2, long paramLong3)
  {
    synchronized (a()) {}
    try
    {
      paramString2 = ???.a(paramString2, paramLong2, 102);
      if (paramString2 == null) {
        return null;
      }
      dYP();
      paramString2 = new TroopFileTransferManager.Item(paramString2);
      paramString2.RandomNum = paramInt2;
      paramString2.ForwardPath = paramString1;
      paramString2.ForwardTroopuin = paramLong1;
      paramString2.ForwardBusId = paramInt1;
      paramString2.Status = 4;
      paramString2.LocalFile = paramString3;
      paramString2.entrySessionID = paramLong3;
      paramString1 = (MessageForTroopFile)this.mApp.b().a(String.valueOf(paramLong1), 1, paramString1);
      if (paramString1 != null)
      {
        paramString2.width = paramString1.width;
        paramString2.height = paramString1.height;
        paramString2.yybApkPackageName = paramString1.yybApkPackageName;
        paramString2.yybApkName = paramString1.yybApkName;
        paramString2.yybApkIconUrl = paramString1.yybApkIconUrl;
      }
      paramString3 = TroopFileTransferManager.a(this.mApp, paramLong1);
      if ((paramString3 != null) && (paramString1 != null) && (!TextUtils.isEmpty(paramString1.uuid)))
      {
        paramString1 = paramString3.a(UUID.fromString(paramString1.uuid));
        if (paramString1 != null)
        {
          paramString2.largeThumbnailFile = paramString1.largeThumbnailFile;
          paramString2.middleThumbnailFile = paramString1.middleThumbnailFile;
        }
      }
      a(paramString2);
      paramString1 = apfj.a(this.mTroopUin, paramString2);
      if (paramString1 == null)
      {
        return null;
        paramString1 = finally;
        throw paramString1;
      }
      paramString1.Li();
      paramString1 = paramString2.getInfo(this.mTroopUin);
      return paramString1;
    }
    finally {}
  }
  
  /* Error */
  public apcy a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 86	apdz:a	()Lapsf;
    //   4: astore 8
    //   6: aload 8
    //   8: monitorenter
    //   9: aload_0
    //   10: monitorenter
    //   11: aload 8
    //   13: aload_1
    //   14: aload_2
    //   15: lload_3
    //   16: iload 5
    //   18: invokevirtual 206	apsf:a	(Ljava/lang/String;Ljava/lang/String;JI)Lapbr;
    //   21: astore 9
    //   23: aload 9
    //   25: ifnonnull +10 -> 35
    //   28: aload_0
    //   29: monitorexit
    //   30: aload 8
    //   32: monitorexit
    //   33: aconst_null
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 94	apdz:dYP	()V
    //   39: iconst_0
    //   40: istore 6
    //   42: aload_0
    //   43: getfield 210	apdz:nC	Ljava/util/Map;
    //   46: aload 9
    //   48: getfield 216	apbr:Id	Ljava/util/UUID;
    //   51: invokeinterface 222 2 0
    //   56: checkcast 96	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   59: astore 7
    //   61: aload 7
    //   63: ifnonnull +175 -> 238
    //   66: new 96	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   69: dup
    //   70: aload 9
    //   72: invokespecial 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lapbr;)V
    //   75: astore_1
    //   76: iconst_1
    //   77: istore 5
    //   79: aload_1
    //   80: aload_2
    //   81: putfield 225	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   84: aload_1
    //   85: lload_3
    //   86: putfield 228	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressTotal	J
    //   89: aload_1
    //   90: lconst_0
    //   91: putfield 231	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ProgressValue	J
    //   94: iload 5
    //   96: ifeq +8 -> 104
    //   99: aload_0
    //   100: aload_1
    //   101: invokevirtual 189	apdz:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   104: aload_1
    //   105: getfield 225	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   108: invokestatic 237	ahav:getFileType	(Ljava/lang/String;)I
    //   111: iconst_2
    //   112: if_icmpne +206 -> 318
    //   115: aload_0
    //   116: getfield 33	apdz:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   119: invokestatic 243	ahbr:aM	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   122: ifeq +196 -> 318
    //   125: aload_1
    //   126: aload_0
    //   127: getfield 37	apdz:mTroopUin	J
    //   130: invokevirtual 202	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lapcy;
    //   133: astore 7
    //   135: new 245	agtf
    //   138: dup
    //   139: aload_0
    //   140: getfield 33	apdz:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   143: aload 7
    //   145: invokespecial 248	agtf:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Lapcy;)V
    //   148: invokestatic 253	agkw:a	(Lagsw;)Laglf;
    //   151: invokeinterface 258 1 0
    //   156: pop
    //   157: aload_2
    //   158: invokestatic 264	ahbj:getExtension	(Ljava/lang/String;)Ljava/lang/String;
    //   161: astore_2
    //   162: aload_0
    //   163: getfield 33	apdz:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   166: ldc_w 266
    //   169: ldc_w 268
    //   172: ldc_w 268
    //   175: ldc_w 270
    //   178: ldc_w 272
    //   181: iconst_0
    //   182: iconst_0
    //   183: ldc_w 268
    //   186: new 274	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   193: aload_0
    //   194: getfield 37	apdz:mTroopUin	J
    //   197: invokevirtual 279	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   200: ldc_w 268
    //   203: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: aload_2
    //   210: ldc_w 268
    //   213: invokestatic 291	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload_1
    //   217: aload_0
    //   218: getfield 37	apdz:mTroopUin	J
    //   221: invokevirtual 202	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lapcy;
    //   224: astore_1
    //   225: aload_0
    //   226: monitorexit
    //   227: aload 8
    //   229: monitorexit
    //   230: aload_1
    //   231: areturn
    //   232: astore_1
    //   233: aload 8
    //   235: monitorexit
    //   236: aload_1
    //   237: athrow
    //   238: aload 7
    //   240: astore_1
    //   241: iload 6
    //   243: istore 5
    //   245: aload 7
    //   247: getfield 115	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   250: bipush 7
    //   252: if_icmpeq -173 -> 79
    //   255: aload 7
    //   257: getfield 115	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   260: bipush 11
    //   262: if_icmpne +21 -> 283
    //   265: aload 7
    //   267: astore_1
    //   268: iload 6
    //   270: istore 5
    //   272: aload 9
    //   274: getfield 292	apbr:LocalFile	Ljava/lang/String;
    //   277: invokestatic 298	aqhq:fileExists	(Ljava/lang/String;)Z
    //   280: ifeq -201 -> 79
    //   283: aload 7
    //   285: getfield 115	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   288: bipush 6
    //   290: if_icmpne +21 -> 311
    //   293: aload 7
    //   295: astore_1
    //   296: iload 6
    //   298: istore 5
    //   300: aload 9
    //   302: getfield 292	apbr:LocalFile	Ljava/lang/String;
    //   305: invokestatic 298	aqhq:fileExists	(Ljava/lang/String;)Z
    //   308: ifeq -229 -> 79
    //   311: aload_0
    //   312: monitorexit
    //   313: aload 8
    //   315: monitorexit
    //   316: aconst_null
    //   317: areturn
    //   318: invokestatic 303	apew:a	()Lapew;
    //   321: aload_0
    //   322: getfield 37	apdz:mTroopUin	J
    //   325: aload_1
    //   326: aconst_null
    //   327: invokevirtual 306	apew:a	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Landroid/os/Bundle;)I
    //   330: pop
    //   331: goto -174 -> 157
    //   334: astore_1
    //   335: aload_0
    //   336: monitorexit
    //   337: aload_1
    //   338: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	apdz
    //   0	339	1	paramString1	String
    //   0	339	2	paramString2	String
    //   0	339	3	paramLong	long
    //   0	339	5	paramInt	int
    //   40	257	6	i	int
    //   59	235	7	localObject	Object
    //   4	310	8	localapsf	apsf
    //   21	280	9	localapbr	apbr
    // Exception table:
    //   from	to	target	type
    //   9	11	232	finally
    //   30	33	232	finally
    //   227	230	232	finally
    //   233	236	232	finally
    //   313	316	232	finally
    //   337	339	232	finally
    //   11	23	334	finally
    //   28	30	334	finally
    //   35	39	334	finally
    //   42	61	334	finally
    //   66	76	334	finally
    //   79	94	334	finally
    //   99	104	334	finally
    //   104	157	334	finally
    //   157	227	334	finally
    //   245	265	334	finally
    //   272	283	334	finally
    //   283	293	334	finally
    //   300	311	334	finally
    //   311	313	334	finally
    //   318	331	334	finally
    //   335	337	334	finally
  }
  
  /* Error */
  public apcy a(String paramString, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 86	apdz:a	()Lapsf;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: aload_0
    //   10: monitorenter
    //   11: aload 4
    //   13: aload_1
    //   14: invokevirtual 310	apsf:b	(Ljava/lang/String;)Lapbr;
    //   17: astore 5
    //   19: aload 5
    //   21: ifnonnull +10 -> 31
    //   24: aload_0
    //   25: monitorexit
    //   26: aload 4
    //   28: monitorexit
    //   29: aconst_null
    //   30: areturn
    //   31: aload_0
    //   32: invokevirtual 94	apdz:dYP	()V
    //   35: new 96	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   38: dup
    //   39: aload 5
    //   41: invokespecial 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lapbr;)V
    //   44: astore 5
    //   46: aload 5
    //   48: bipush 102
    //   50: putfield 313	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   53: aload 5
    //   55: iload_2
    //   56: putfield 316	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isFromAIO	Z
    //   59: aload 5
    //   61: iload_3
    //   62: putfield 102	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:RandomNum	I
    //   65: new 318	com/tencent/mm/vfs/VFSFile
    //   68: dup
    //   69: aload_1
    //   70: invokespecial 321	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   73: astore 6
    //   75: aload 6
    //   77: invokevirtual 324	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   80: ifeq +13 -> 93
    //   83: aload 5
    //   85: aload 6
    //   87: invokevirtual 328	com/tencent/mm/vfs/VFSFile:lastModified	()J
    //   90: putfield 331	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:origLastModifyTime	J
    //   93: aload_0
    //   94: aload 5
    //   96: invokevirtual 189	apdz:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   99: aload_1
    //   100: invokestatic 237	ahav:getFileType	(Ljava/lang/String;)I
    //   103: iconst_5
    //   104: if_icmpne +41 -> 145
    //   107: aload_1
    //   108: new 333	apec
    //   111: dup
    //   112: aload_0
    //   113: aload 5
    //   115: invokespecial 336	apec:<init>	(Lapdz;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   118: invokestatic 341	ahap:a	(Ljava/lang/String;Lahap$a;)Z
    //   121: pop
    //   122: aload 5
    //   124: aload_0
    //   125: getfield 37	apdz:mTroopUin	J
    //   128: invokevirtual 202	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:getInfo	(J)Lapcy;
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload 4
    //   136: monitorexit
    //   137: aload_1
    //   138: areturn
    //   139: astore_1
    //   140: aload 4
    //   142: monitorexit
    //   143: aload_1
    //   144: athrow
    //   145: invokestatic 347	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   148: invokestatic 353	aqiw:getSystemNetwork	(Landroid/content/Context;)I
    //   151: ifne +12 -> 163
    //   154: aload_0
    //   155: aload 5
    //   157: iconst_3
    //   158: bipush 106
    //   160: invokevirtual 356	apdz:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;II)V
    //   163: invokestatic 361	apfx:a	()Lapfx;
    //   166: aload_0
    //   167: getfield 37	apdz:mTroopUin	J
    //   170: aload 5
    //   172: aconst_null
    //   173: invokevirtual 363	apfx:e	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Landroid/os/Bundle;)I
    //   176: pop
    //   177: goto -55 -> 122
    //   180: astore_1
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	apdz
    //   0	185	1	paramString	String
    //   0	185	2	paramBoolean	boolean
    //   0	185	3	paramInt	int
    //   4	137	4	localapsf	apsf
    //   17	154	5	localObject	Object
    //   73	13	6	localVFSFile	VFSFile
    // Exception table:
    //   from	to	target	type
    //   9	11	139	finally
    //   26	29	139	finally
    //   134	137	139	finally
    //   140	143	139	finally
    //   183	185	139	finally
    //   11	19	180	finally
    //   24	26	180	finally
    //   31	93	180	finally
    //   93	122	180	finally
    //   122	134	180	finally
    //   145	163	180	finally
    //   163	177	180	finally
    //   181	183	180	finally
  }
  
  public TroopFileTransferManager.Item a(UUID paramUUID, boolean paramBoolean)
  {
    try
    {
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.nC.remove(paramUUID);
      if ((paramBoolean) && (localItem != null)) {
        this.mApp.a().a().a(this.mTroopUin, paramUUID);
      }
      return localItem;
    }
    finally {}
  }
  
  public void a(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      this.nC.put(paramItem.Id, paramItem);
      if (paramItem.troopuin == 0L) {
        paramItem.troopuin = this.mTroopUin;
      }
      if (paramItem.troopuin != this.mTroopUin)
      {
        apef.b.w("TroopFileTransferMgr", apef.b.USR, "newItem troop confit. item.troopuin:" + paramItem.troopuin + " mTroopUin" + this.mTroopUin);
        paramItem.troopuin = this.mTroopUin;
      }
      this.mApp.a().a().a(paramItem, null);
      return;
    }
    finally {}
  }
  
  public void a(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2)
  {
    try
    {
      apdw.a(this.mTroopUin, paramItem, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  public void a(TroopFileTransferManager.Item paramItem, int paramInt, apsd.a parama)
  {
    try
    {
      apdw.a(this.mTroopUin, paramItem, paramInt, parama);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  @Deprecated
  public void a(TroopFileTransferManager.Item paramItem, int paramInt, boolean paramBoolean)
  {
    try
    {
      apef.b.w("TroopFileTransferMgr", apef.b.USR, "!!!warning: oldver fun: doReqDownload be called");
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  public void a(Collection<String> paramCollection, boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject2;
      synchronized (a())
      {
        try
        {
          if (aqiw.getSystemNetwork(BaseApplication.getContext()) == 0)
          {
            i = 1;
            paramCollection = paramCollection.iterator();
            if (!paramCollection.hasNext()) {
              break;
            }
            Object localObject1 = (String)paramCollection.next();
            localObject2 = ???.b((String)localObject1);
            if (localObject2 == null) {
              continue;
            }
            dYP();
            localObject2 = new TroopFileTransferManager.Item((apbr)localObject2);
            ((TroopFileTransferManager.Item)localObject2).BusId = 102;
            ((TroopFileTransferManager.Item)localObject2).isFromAIO = paramBoolean;
            localObject1 = new VFSFile((String)localObject1);
            if (((VFSFile)localObject1).exists()) {
              ((TroopFileTransferManager.Item)localObject2).origLastModifyTime = ((VFSFile)localObject1).lastModified();
            }
            a((TroopFileTransferManager.Item)localObject2);
            if (i == 0) {
              break label158;
            }
            a((TroopFileTransferManager.Item)localObject2, 3, 106);
            continue;
            paramCollection = finally;
          }
        }
        finally {}
      }
      int i = 0;
      continue;
      label158:
      apfx.a().e(this.mTroopUin, (TroopFileTransferManager.Item)localObject2, null);
    }
  }
  
  public boolean a(TroopFileTransferManager.Item paramItem, int paramInt)
  {
    return apfq.a(this.mTroopUin, paramItem, paramInt);
  }
  
  /* Error */
  public boolean a(UUID paramUUID)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 94	apdz:dYP	()V
    //   8: aload_0
    //   9: getfield 210	apdz:nC	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 222 2 0
    //   18: checkcast 96	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore 4
    //   23: aload 4
    //   25: ifnonnull +7 -> 32
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: invokestatic 361	apfx:a	()Lapfx;
    //   35: aload_1
    //   36: aconst_null
    //   37: invokevirtual 448	apfx:c	(Ljava/util/UUID;Landroid/os/Bundle;)I
    //   40: istore_2
    //   41: iload_2
    //   42: ifne +8 -> 50
    //   45: iconst_1
    //   46: istore_3
    //   47: goto -19 -> 28
    //   50: iconst_0
    //   51: istore_3
    //   52: goto -5 -> 47
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	apdz
    //   0	60	1	paramUUID	UUID
    //   40	2	2	i	int
    //   1	51	3	bool	boolean
    //   21	3	4	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   4	23	55	finally
    //   32	41	55	finally
  }
  
  public boolean a(UUID paramUUID, int paramInt)
  {
    synchronized (a()) {}
    try
    {
      apbr localapbr = ???.b(paramUUID);
      if (localapbr == null) {
        return false;
      }
      int i = ahav.getFileType(ahbj.getExtension(localapbr.str_file_name));
      if ((i != 0) && (i != 2))
      {
        return false;
        paramUUID = finally;
        throw paramUUID;
      }
      dYP();
      TroopFileTransferManager.Item localItem = (TroopFileTransferManager.Item)this.nC.get(paramUUID);
      paramUUID = localItem;
      if (localItem == null)
      {
        paramUUID = new TroopFileTransferManager.Item(localapbr);
        a(paramUUID);
      }
      apfq.a().c(this.mTroopUin, paramUUID, paramInt);
      return true;
    }
    finally {}
  }
  
  @Deprecated
  public boolean aAU()
  {
    try
    {
      apef.b.w("TroopFileTransferMgr", apef.b.USR, "!!!warning: oldver fun: saveStatus be called");
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(TroopFileTransferManager.Item paramItem)
  {
    apdw.a(this.mTroopUin, paramItem);
  }
  
  /* Error */
  public boolean b(UUID paramUUID)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 94	apdz:dYP	()V
    //   8: aload_0
    //   9: getfield 210	apdz:nC	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 222 2 0
    //   18: checkcast 96	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore_1
    //   22: aload_1
    //   23: ifnonnull +7 -> 30
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_3
    //   29: ireturn
    //   30: invokestatic 361	apfx:a	()Lapfx;
    //   33: aload_0
    //   34: getfield 37	apdz:mTroopUin	J
    //   37: aload_1
    //   38: aconst_null
    //   39: invokevirtual 363	apfx:e	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Landroid/os/Bundle;)I
    //   42: istore_2
    //   43: iload_2
    //   44: ifne +8 -> 52
    //   47: iconst_1
    //   48: istore_3
    //   49: goto -23 -> 26
    //   52: iconst_0
    //   53: istore_3
    //   54: goto -5 -> 49
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	apdz
    //   0	62	1	paramUUID	UUID
    //   42	2	2	i	int
    //   1	53	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	22	57	finally
    //   30	43	57	finally
  }
  
  public void c(TroopFileTransferManager.Item paramItem)
  {
    paramItem = apfu.a(this.mTroopUin, paramItem);
    if (paramItem != null) {
      paramItem.dZm();
    }
  }
  
  /* Error */
  public void c(UUID paramUUID)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 94	apdz:dYP	()V
    //   6: aload_0
    //   7: getfield 210	apdz:nC	Ljava/util/Map;
    //   10: aload_1
    //   11: invokeinterface 222 2 0
    //   16: checkcast 96	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   19: astore_2
    //   20: aload_2
    //   21: ifnonnull +6 -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: ldc_w 390
    //   30: getstatic 395	apef$b:USR	I
    //   33: new 274	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 478
    //   43: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_1
    //   47: invokevirtual 479	java/util/UUID:toString	()Ljava/lang/String;
    //   50: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 481
    //   56: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 484	apef$b:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: new 486	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr$3
    //   68: dup
    //   69: aload_0
    //   70: aload_2
    //   71: aload_1
    //   72: invokespecial 489	com/tencent/mobileqq/troop/filemanager/TroopFileTransferMgr$3:<init>	(Lapdz;Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Ljava/util/UUID;)V
    //   75: iconst_5
    //   76: aconst_null
    //   77: iconst_0
    //   78: invokestatic 494	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   81: goto -57 -> 24
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	apdz
    //   0	89	1	paramUUID	UUID
    //   19	52	2	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   2	20	84	finally
    //   27	81	84	finally
  }
  
  /* Error */
  public boolean c(UUID paramUUID)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 94	apdz:dYP	()V
    //   8: aload_0
    //   9: getfield 210	apdz:nC	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 222 2 0
    //   18: checkcast 96	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore_1
    //   22: aload_1
    //   23: ifnonnull +7 -> 30
    //   26: aload_0
    //   27: monitorexit
    //   28: iload_3
    //   29: ireturn
    //   30: aload_1
    //   31: getfield 497	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:isZipInnerFile	Z
    //   34: ifeq +21 -> 55
    //   37: invokestatic 303	apew:a	()Lapew;
    //   40: aload_0
    //   41: getfield 37	apdz:mTroopUin	J
    //   44: aload_1
    //   45: aconst_null
    //   46: invokevirtual 499	apew:c	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Landroid/os/Bundle;)I
    //   49: pop
    //   50: iconst_1
    //   51: istore_3
    //   52: goto -26 -> 26
    //   55: invokestatic 303	apew:a	()Lapew;
    //   58: aload_0
    //   59: getfield 37	apdz:mTroopUin	J
    //   62: aload_1
    //   63: aconst_null
    //   64: invokevirtual 306	apew:a	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;Landroid/os/Bundle;)I
    //   67: istore_2
    //   68: iload_2
    //   69: ifne +8 -> 77
    //   72: iconst_1
    //   73: istore_3
    //   74: goto -48 -> 26
    //   77: iconst_0
    //   78: istore_3
    //   79: goto -5 -> 74
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	apdz
    //   0	87	1	paramUUID	UUID
    //   67	2	2	i	int
    //   1	78	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	22	82	finally
    //   30	50	82	finally
    //   55	68	82	finally
  }
  
  public void d(TroopFileTransferManager.Item paramItem)
  {
    try
    {
      apdw.b(this.mTroopUin, paramItem);
      return;
    }
    finally
    {
      paramItem = finally;
      throw paramItem;
    }
  }
  
  /* Error */
  public boolean d(UUID paramUUID)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 94	apdz:dYP	()V
    //   8: aload_0
    //   9: getfield 210	apdz:nC	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 222 2 0
    //   18: checkcast 96	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   21: astore 4
    //   23: aload 4
    //   25: ifnonnull +7 -> 32
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: invokestatic 303	apew:a	()Lapew;
    //   35: aload_1
    //   36: aconst_null
    //   37: invokevirtual 503	apew:a	(Ljava/util/UUID;Landroid/os/Bundle;)I
    //   40: istore_2
    //   41: aload 4
    //   43: getfield 225	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   46: invokestatic 237	ahav:getFileType	(Ljava/lang/String;)I
    //   49: iconst_2
    //   50: if_icmpne +29 -> 79
    //   53: aload_0
    //   54: getfield 33	apdz:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   57: invokestatic 243	ahbr:aM	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   60: ifeq +19 -> 79
    //   63: aload 4
    //   65: getfield 506	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FilePath	Ljava/lang/String;
    //   68: invokestatic 509	agkw:IM	(Ljava/lang/String;)V
    //   71: aload_0
    //   72: aload 4
    //   74: bipush 9
    //   76: invokevirtual 512	apdz:c	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;I)V
    //   79: iload_2
    //   80: ifne +8 -> 88
    //   83: iconst_1
    //   84: istore_3
    //   85: goto -57 -> 28
    //   88: iconst_0
    //   89: istore_3
    //   90: goto -5 -> 85
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	apdz
    //   0	98	1	paramUUID	UUID
    //   40	40	2	i	int
    //   1	89	3	bool	boolean
    //   21	52	4	localItem	TroopFileTransferManager.Item
    // Exception table:
    //   from	to	target	type
    //   4	23	93	finally
    //   32	79	93	finally
  }
  
  public void dYP()
  {
    try
    {
      boolean bool = this.cvp;
      if (bool) {
        label11:
        return;
      }
      this.cvp = true;
      List localList = this.mApp.a().a().j(this.mTroopUin);
      this.nC = new ConcurrentHashMap();
      if ((!$assertionsDisabled) && (localList == null)) {
        throw new AssertionError();
      }
    }
    finally {}
    Object localObject2;
    if (localObject1 != null)
    {
      localIterator = localObject1.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (TroopFileTansferItemEntity)localIterator.next();
        if (((TroopFileTansferItemEntity)localObject2).Id != null)
        {
          if (!((TroopFileTansferItemEntity)localObject2).isCheckPrivateDir)
          {
            ((TroopFileTansferItemEntity)localObject2).isCheckPrivateDir = true;
            if (!TextUtils.isEmpty(((TroopFileTansferItemEntity)localObject2).smallThumbFile)) {
              ((TroopFileTansferItemEntity)localObject2).smallThumbFile = aqul.getSDKPrivatePath(((TroopFileTansferItemEntity)localObject2).smallThumbFile);
            }
            if (!TextUtils.isEmpty(((TroopFileTansferItemEntity)localObject2).largeThumbnailFile)) {
              ((TroopFileTansferItemEntity)localObject2).largeThumbnailFile = aqul.getSDKPrivatePath(((TroopFileTansferItemEntity)localObject2).largeThumbnailFile);
            }
            if (!TextUtils.isEmpty(((TroopFileTansferItemEntity)localObject2).middleThumbnailFile)) {
              ((TroopFileTansferItemEntity)localObject2).middleThumbnailFile = aqul.getSDKPrivatePath(((TroopFileTansferItemEntity)localObject2).middleThumbnailFile);
            }
          }
          this.nC.put(((TroopFileTansferItemEntity)localObject2).Id, new TroopFileTransferManager.Item((TroopFileTansferItemEntity)localObject2));
        }
        else
        {
          apef.b.e("TroopFileTransferMgr", apef.b.USR, "entity.Id is null");
        }
      }
    }
    Iterator localIterator = this.nC.values().iterator();
    for (;;)
    {
      if (localIterator.hasNext()) {
        localObject2 = (TroopFileTransferManager.Item)localIterator.next();
      }
      switch (((TroopFileTransferManager.Item)localObject2).Status)
      {
      case 0: 
      case 1: 
        ((TroopFileTransferManager.Item)localObject2).Status = 3;
        break;
      case 8: 
        ((TroopFileTransferManager.Item)localObject2).Status = 10;
        continue;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
          ThreadManager.post(new TroopFileTransferMgr.5(this), 8, null, true);
          break label11;
        }
        aBv();
        break label11;
      }
    }
  }
  
  public void dYQ()
  {
    for (;;)
    {
      TroopFileTransferManager.Item localItem;
      Bundle localBundle;
      try
      {
        dYP();
        Iterator localIterator = this.nC.values().iterator();
        if (!localIterator.hasNext()) {
          break label204;
        }
        localItem = (TroopFileTransferManager.Item)localIterator.next();
        if (localItem.W2MPause != 2) {
          continue;
        }
        localItem.W2MPause = 0;
        localBundle = new Bundle();
        switch (localItem.Status)
        {
        case 0: 
        case 1: 
        case 8: 
          localItem.Pausing = 0;
          break;
        case 2: 
          localBundle.putBoolean("_wifi2mobile_resume_", true);
        }
      }
      finally {}
      apfx.a().e(this.mTroopUin, localItem, localBundle);
      continue;
      localBundle.putBoolean("_wifi2mobile_resume_", true);
      if (localItem.isZipInnerFile)
      {
        apew.a().c(this.mTroopUin, localItem, localBundle);
      }
      else
      {
        apew.a().a(this.mTroopUin, localItem, localBundle);
        continue;
        label204:
        return;
      }
    }
  }
  
  @Deprecated
  public void dYR()
  {
    try
    {
      apef.b.w("TroopFileTransferMgr", apef.b.USR, "!!!warning: oldver fun: Interrupt be called");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @Deprecated
  public void e(TroopFileTransferManager.Item paramItem)
  {
    apef.b.w("TroopFileTransferMgr", apef.b.USR, "!!!warning: oldver fun: doReqUpload be called");
  }
  
  public boolean e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    synchronized (a()) {}
    try
    {
      int i = ahav.getFileType(ahbj.getExtension(paramString2));
      if ((i != 0) && (i != 2)) {
        return false;
      }
      apbr localapbr = ???.a(paramString1, paramString2, 0L, paramInt1);
      if (localapbr == null)
      {
        return false;
        paramString1 = finally;
        throw paramString1;
      }
      dYP();
      paramString2 = (TroopFileTransferManager.Item)this.nC.get(localapbr.Id);
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        paramString1 = new TroopFileTransferManager.Item(localapbr);
        a(paramString1);
      }
      apfq.a().c(this.mTroopUin, paramString1, paramInt2);
      return true;
    }
    finally {}
  }
  
  public boolean e(UUID paramUUID)
  {
    apbr localapbr;
    TroopFileTransferManager.Item localItem;
    synchronized (a()) {}
  }
  
  public int f(FileManagerEntity paramFileManagerEntity)
  {
    for (;;)
    {
      apbr localapbr;
      TroopFileTransferManager.Item localItem;
      synchronized (a()) {}
      int i = 0;
    }
  }
  
  @Deprecated
  public void f(TroopFileTransferManager.Item paramItem)
  {
    apef.b.w("TroopFileTransferMgr", apef.b.USR, "!!!warning: oldver fun: doReqResend be called");
  }
  
  public boolean i(String paramString1, String paramString2, int paramInt)
  {
    apbr localapbr;
    synchronized (a()) {}
  }
  
  public void init()
  {
    super.init();
    if (this.jdField_a_of_type_Apfx$a == null)
    {
      this.jdField_a_of_type_Apfx$a = new apea(this);
      apfx.a().addObserver(this.jdField_a_of_type_Apfx$a);
    }
    if (this.jdField_a_of_type_Apew$a == null)
    {
      this.jdField_a_of_type_Apew$a = new apeb(this);
      apew.a().addObserver(this.jdField_a_of_type_Apew$a);
    }
    apef.b.i("TroopFileTransferMgr", apef.b.USR, "init");
  }
  
  /* Error */
  public void j(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 86	apdz:a	()Lapsf;
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_1
    //   12: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifeq +9 -> 24
    //   18: aload_0
    //   19: monitorexit
    //   20: aload 6
    //   22: monitorexit
    //   23: return
    //   24: aload 6
    //   26: aload_2
    //   27: lload_3
    //   28: bipush 25
    //   30: invokevirtual 91	apsf:a	(Ljava/lang/String;JI)Lapbr;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnonnull +15 -> 50
    //   38: aload_0
    //   39: monitorexit
    //   40: aload 6
    //   42: monitorexit
    //   43: return
    //   44: astore_1
    //   45: aload 6
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    //   50: aload_0
    //   51: invokevirtual 94	apdz:dYP	()V
    //   54: new 96	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lapbr;)V
    //   62: astore_2
    //   63: aload_2
    //   64: aload_1
    //   65: putfield 106	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardPath	Ljava/lang/String;
    //   68: aload_2
    //   69: aload_0
    //   70: getfield 33	apdz:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   73: invokevirtual 669	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   76: invokestatic 674	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   79: invokevirtual 677	java/lang/Long:longValue	()J
    //   82: putfield 109	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   85: aload_2
    //   86: iload 5
    //   88: putfield 112	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardBusId	I
    //   91: aload_2
    //   92: iconst_4
    //   93: putfield 115	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Status	I
    //   96: aload_2
    //   97: bipush 25
    //   99: putfield 313	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:BusId	I
    //   102: aload_0
    //   103: aload_2
    //   104: invokevirtual 189	apdz:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   107: aload_0
    //   108: getfield 37	apdz:mTroopUin	J
    //   111: aload_2
    //   112: invokestatic 682	apff:a	(JLcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)Lapff;
    //   115: astore_1
    //   116: aload_1
    //   117: ifnull +14 -> 131
    //   120: aload_1
    //   121: invokevirtual 683	apff:Li	()I
    //   124: pop
    //   125: aload_0
    //   126: monitorexit
    //   127: aload 6
    //   129: monitorexit
    //   130: return
    //   131: ldc_w 390
    //   134: getstatic 395	apef$b:USR	I
    //   137: ldc_w 685
    //   140: invokestatic 551	apef$b:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: goto -18 -> 125
    //   146: astore_1
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_1
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	apdz
    //   0	151	1	paramString1	String
    //   0	151	2	paramString2	String
    //   0	151	3	paramLong	long
    //   0	151	5	paramInt	int
    //   4	124	6	localapsf	apsf
    // Exception table:
    //   from	to	target	type
    //   9	11	44	finally
    //   20	23	44	finally
    //   40	43	44	finally
    //   45	48	44	finally
    //   127	130	44	finally
    //   149	151	44	finally
    //   11	20	146	finally
    //   24	34	146	finally
    //   38	40	146	finally
    //   50	116	146	finally
    //   120	125	146	finally
    //   125	127	146	finally
    //   131	143	146	finally
    //   147	149	146	finally
  }
  
  public void mN(List<apcy> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ArrayList localArrayList;
    synchronized (a())
    {
      try
      {
        dYP();
        localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          apcy localapcy = (apcy)paramList.next();
          if (!TextUtils.isEmpty(localapcy.FilePath))
          {
            Object localObject = ???.a(localapcy.FileName, localapcy.ProgressTotal, 25);
            if (localObject != null)
            {
              localObject = new TroopFileTransferManager.Item((apbr)localObject);
              a((TroopFileTransferManager.Item)localObject);
              ((TroopFileTransferManager.Item)localObject).ForwardPath = localapcy.FilePath;
              ((TroopFileTransferManager.Item)localObject).ForwardTroopuin = Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
              ((TroopFileTransferManager.Item)localObject).ForwardBusId = localapcy.BusId;
              ((TroopFileTransferManager.Item)localObject).Status = 4;
              ((TroopFileTransferManager.Item)localObject).BusId = 25;
              localArrayList.add(localObject);
              continue;
              paramList = finally;
            }
          }
        }
      }
      finally {}
    }
    if (localArrayList.size() == 0) {
      return;
    }
    paramList = apfh.a(this.mTroopUin, localArrayList);
    if (paramList != null) {
      paramList.Li();
    }
    for (;;)
    {
      return;
      apef.b.e("TroopFileTransferMgr", apef.b.USR, "startMultiCopyToWeiyun forwarder=null");
    }
  }
  
  /* Error */
  public void o(apbr paramapbr)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 86	apdz:a	()Lapsf;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_1
    //   12: ifnonnull +9 -> 21
    //   15: aload_0
    //   16: monitorexit
    //   17: aload 4
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: invokevirtual 94	apdz:dYP	()V
    //   25: aload_0
    //   26: getfield 210	apdz:nC	Ljava/util/Map;
    //   29: aload_1
    //   30: getfield 216	apbr:Id	Ljava/util/UUID;
    //   33: invokeinterface 222 2 0
    //   38: checkcast 96	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   41: astore_3
    //   42: aload_3
    //   43: astore_2
    //   44: aload_3
    //   45: ifnonnull +17 -> 62
    //   48: new 96	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 99	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:<init>	(Lapbr;)V
    //   56: astore_2
    //   57: aload_0
    //   58: aload_2
    //   59: invokevirtual 189	apdz:a	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   62: aload_2
    //   63: aload_1
    //   64: getfield 716	apbr:ThumbnailFile_Large	Ljava/lang/String;
    //   67: putfield 183	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:largeThumbnailFile	Ljava/lang/String;
    //   70: aload_2
    //   71: aload_1
    //   72: getfield 719	apbr:coc	Ljava/lang/String;
    //   75: putfield 186	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:middleThumbnailFile	Ljava/lang/String;
    //   78: aload_2
    //   79: aload_1
    //   80: getfield 722	apbr:ThumbnailFile_Small	Ljava/lang/String;
    //   83: putfield 723	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:smallThumbFile	Ljava/lang/String;
    //   86: aload_0
    //   87: aload_2
    //   88: invokevirtual 725	apdz:b	(Lcom/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item;)V
    //   91: aload_0
    //   92: monitorexit
    //   93: aload 4
    //   95: monitorexit
    //   96: return
    //   97: astore_1
    //   98: aload 4
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	apdz
    //   0	108	1	paramapbr	apbr
    //   43	45	2	localItem1	TroopFileTransferManager.Item
    //   41	4	3	localItem2	TroopFileTransferManager.Item
    //   4	95	4	localapsf	apsf
    // Exception table:
    //   from	to	target	type
    //   9	11	97	finally
    //   17	20	97	finally
    //   93	96	97	finally
    //   98	101	97	finally
    //   106	108	97	finally
    //   15	17	103	finally
    //   21	42	103	finally
    //   48	62	103	finally
    //   62	93	103	finally
    //   104	106	103	finally
  }
  
  public void release()
  {
    apef.b.i("TroopFileTransferMgr", apef.b.USR, "release");
    if (this.jdField_a_of_type_Apfx$a != null)
    {
      apfx.a().deleteObserver(this.jdField_a_of_type_Apfx$a);
      this.jdField_a_of_type_Apfx$a = null;
    }
    if (this.jdField_a_of_type_Apew$a != null)
    {
      apew.a().deleteObserver(this.jdField_a_of_type_Apew$a);
      this.jdField_a_of_type_Apew$a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apdz
 * JD-Core Version:    0.7.0.1
 */