import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.11.1;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.TaskScan;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.c;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.UUID;

public class apsn
  extends smq.l
{
  public apsn(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  /* Error */
  private final void a(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 22	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5: ifeq +37 -> 42
    //   8: ldc 24
    //   10: iconst_4
    //   11: ldc 26
    //   13: iconst_3
    //   14: anewarray 28	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: getfield 34	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:FileName	Ljava/lang/String;
    //   23: aastore
    //   24: dup
    //   25: iconst_1
    //   26: iload_2
    //   27: invokestatic 40	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aastore
    //   31: dup
    //   32: iconst_2
    //   33: aload 5
    //   35: aastore
    //   36: invokestatic 46	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   39: invokestatic 50	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: iload_2
    //   43: ifeq +44 -> 87
    //   46: aload_1
    //   47: getfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:mForwardCallback	Lahbm;
    //   50: ifnull +34 -> 84
    //   53: aload_1
    //   54: getfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:mForwardCallback	Lahbm;
    //   57: iconst_0
    //   58: lload 7
    //   60: iload_2
    //   61: aload 6
    //   63: aload_1
    //   64: getfield 58	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
    //   67: invokevirtual 64	java/util/UUID:toString	()Ljava/lang/String;
    //   70: aload_1
    //   71: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   74: invokestatic 71	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   77: ldc 73
    //   79: invokeinterface 79 9 0
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    //   87: aload_1
    //   88: getfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:mForwardCallback	Lahbm;
    //   91: ifnull -7 -> 84
    //   94: aload_1
    //   95: getfield 54	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:mForwardCallback	Lahbm;
    //   98: iconst_1
    //   99: lload 7
    //   101: iload_2
    //   102: ldc 73
    //   104: aload_1
    //   105: getfield 58	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:Id	Ljava/util/UUID;
    //   108: invokevirtual 64	java/util/UUID:toString	()Ljava/lang/String;
    //   111: aload_1
    //   112: getfield 68	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$Item:ForwardTroopuin	J
    //   115: invokestatic 71	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   118: aload 4
    //   120: invokeinterface 79 9 0
    //   125: goto -41 -> 84
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	apsn
    //   0	133	1	paramItem	TroopFileTransferManager.Item
    //   0	133	2	paramInt1	int
    //   0	133	3	paramInt2	int
    //   0	133	4	paramString1	String
    //   0	133	5	paramString2	String
    //   0	133	6	paramString3	String
    //   0	133	7	paramLong	long
    // Exception table:
    //   from	to	target	type
    //   2	42	128	finally
    //   46	84	128	finally
    //   87	125	128	finally
  }
  
  public final void a(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        if (!QLog.isDevelopLevel()) {
          break label444;
        }
        QLog.e("TroopFileTransferManager", 4, String.format("onRspCopyToGroup - retCode: %d", new Object[] { Integer.valueOf(paramInt1) }));
      }
      finally {}
      paramString1 = new apsd.a(paramItem.FileName, paramItem.ForwardTroopuin, 5, paramInt1, paramString1);
      this.this$0.a(paramItem, 5, paramString1);
      paramItem = ((QQAppInterface)this.n.get()).a().b(paramItem.entrySessionID);
      if (paramItem != null)
      {
        long l = paramItem.structMsgSeq;
        ((QQAppInterface)this.n.get()).b().t("" + this.this$0.mTroopUin, 1, l);
      }
      return;
      paramInt1 = 202;
      paramString1 = paramString3;
      continue;
      paramInt1 = 600;
      paramString1 = paramString3;
      continue;
      paramInt1 = 701;
      paramString1 = paramString3;
      continue;
      paramInt1 = 706;
      paramString1 = acfp.m(2131715681);
      continue;
      if (paramItem.BusId == 102)
      {
        paramItem.BusId = 104;
        smq.a(this.this$0.mApp, false, this.this$0.mTroopUin, paramItem, this.this$0.mTroopUin, 0L, TroopFileTransferManager.a(this.this$0));
      }
      else
      {
        paramInt1 = 204;
        paramString1 = paramString3;
        continue;
        paramInt1 = -139;
        paramString1 = paramString3;
        continue;
        if ((!TextUtils.isEmpty(paramItem.LocalFile)) && (new File(paramItem.LocalFile).exists()))
        {
          this.this$0.c(paramItem, 0);
          paramItem.BusId = 102;
          this.this$0.a[0].a(new TroopFileTransferManager.TaskScan(this.this$0, paramItem));
          continue;
          label444:
          while (paramInt1 >= 0)
          {
            new Handler(Looper.getMainLooper()).post(new TroopFileTransferManager.11.1(this));
            paramItem.FilePath = paramString1;
            paramString2 = paramItem.getInfo(this.this$0.mTroopUin);
            if (paramString2 != null) {
              paramString2.FilePath = paramString1;
            }
            paramString2 = this.this$0.mApp.a().b(paramItem.entrySessionID);
            if (paramString2 != null) {
              paramString2.strTroopFilePath = paramString1;
            }
            this.this$0.a(paramItem, 7, 0);
            this.this$0.c(paramItem);
            break;
          }
          paramInt2 = 207;
        }
        else
        {
          switch (paramInt1)
          {
          case -3: 
          case -4: 
          case -25: 
          case -22: 
          case -36: 
          case -20001: 
          case -20000: 
          case -403: 
          case -139: 
          case -138: 
          case -6101: 
          default: 
            paramString1 = paramString3;
            paramInt1 = paramInt2;
            continue;
            paramInt1 = 603;
            paramString1 = paramString3;
            break;
          case -30: 
            paramInt1 = 705;
            paramString1 = paramString3;
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    long l = paramBundle.getLong("troopUin");
    TroopFileTransferManager localTroopFileTransferManager;
    Object localObject;
    try
    {
      localTroopFileTransferManager = (TroopFileTransferManager)TroopFileTransferManager.access$000().get(Long.valueOf(l));
      if (localTroopFileTransferManager == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("TroopFileTransferManager", 4, "bad troopUin" + l);
        }
        return;
      }
      String str = paramBundle.getString("itemKey");
      if (str == null) {
        return;
      }
      localObject = UUID.fromString(str);
      try
      {
        localObject = (TroopFileTransferManager.Item)localTroopFileTransferManager.nC.get(localObject);
        if (localObject == null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("TroopFileTransferManager", 4, "bad item key" + str);
          }
          return;
        }
      }
      finally {}
    }
    finally {}
    if (QLog.isDevelopLevel()) {
      QLog.e("TroopFileTransferManager", 4, String.format("onCopyToResult - retCode: %d", new Object[] { Integer.valueOf(paramInt1) }));
    }
    if (((TroopFileTransferManager.Item)localObject).BusId == 25)
    {
      b((TroopFileTransferManager.Item)localObject, paramInt1, paramInt2, paramString1, paramString2, paramString3);
      return;
    }
    if ((((TroopFileTransferManager.Item)localObject).BusId == 102) || (((TroopFileTransferManager.Item)localObject).BusId == 104))
    {
      a((TroopFileTransferManager.Item)localObject, paramInt1, paramInt2, paramString1, paramString2, paramString3);
      return;
    }
    if ((((TroopFileTransferManager.Item)localObject).BusId == 3) || (((TroopFileTransferManager.Item)localObject).BusId == 106) || (((TroopFileTransferManager.Item)localObject).BusId == 38)) {
      a((TroopFileTransferManager.Item)localObject, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramBundle.getLong("sessionId"));
    }
  }
  
  public final void b(TroopFileTransferManager.Item paramItem, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    for (;;)
    {
      try
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("TroopFileTransferManager", 4, String.format("onRspCopyToWeiyun - retCode: %d", new Object[] { Integer.valueOf(paramInt1) }));
        }
        awou.nP(paramInt1);
        if (paramInt1 == 0) {
          break label290;
        }
        paramInt2 = 601;
        switch (paramInt1)
        {
        case -3: 
          paramString1 = new apsd.a(paramItem.FileName, this.this$0.mTroopUin, 5, paramInt1, paramString3);
          this.this$0.a(paramItem, 5, paramString1);
          return;
        }
      }
      finally {}
      paramInt1 = 202;
      continue;
      if (paramItem.BusId == 102)
      {
        paramItem.BusId = 104;
        smq.a(this.this$0.mApp, false, this.this$0.mTroopUin, paramItem, this.this$0.mTroopUin, 0L, TroopFileTransferManager.a(this.this$0));
      }
      else
      {
        paramInt1 = 702;
        continue;
        paramInt1 = 703;
        continue;
        paramInt1 = 702;
        continue;
        paramInt1 = 701;
        continue;
        paramInt1 = 705;
        continue;
        paramInt1 = paramInt2;
        if (!TextUtils.isEmpty(paramString3))
        {
          paramInt1 = 704;
          continue;
          label290:
          paramString1 = new apsd.a(paramItem.FileName, this.this$0.mTroopUin, 5, 602);
          this.this$0.a(paramItem, 5, paramString1);
          continue;
          paramInt1 = paramInt2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apsn
 * JD-Core Version:    0.7.0.1
 */