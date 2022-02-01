import com.tencent.cloudfile.CloudUserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tim.cloudfile.CloudFileSendRecvSyncer;
import com.tencent.tim.cloudfile.data.CloudFileUserInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class atgc
  implements Manager
{
  private List<FileManagerEntity> Kr = new ArrayList();
  private CloudFileUserInfo a;
  private QQAppInterface app;
  private boolean dhA;
  private boolean dhz;
  EntityManager em;
  private volatile boolean isInited;
  private List<atiu> lb = new ArrayList();
  private HashMap<Long, FileManagerEntity> qc = new HashMap();
  
  public atgc(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.em = paramQQAppInterface.a().createEntityManager();
    qh();
  }
  
  /* Error */
  private void e(com.tencent.mobileqq.persistence.Entity paramEntity)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield 56	atgc:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   9: invokevirtual 70	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   12: invokevirtual 75	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   15: aload_1
    //   16: invokevirtual 81	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   19: sipush 1000
    //   22: if_icmpne +32 -> 54
    //   25: aload_0
    //   26: getfield 56	atgc:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   29: aload_1
    //   30: invokevirtual 84	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   33: aload_0
    //   34: getfield 56	atgc:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   37: invokevirtual 70	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   40: invokevirtual 87	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   43: aload_0
    //   44: getfield 56	atgc:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   47: invokevirtual 70	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   50: invokevirtual 90	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   53: return
    //   54: aload_0
    //   55: getfield 56	atgc:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   58: aload_1
    //   59: invokevirtual 94	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   62: pop
    //   63: goto -30 -> 33
    //   66: astore_1
    //   67: ldc 96
    //   69: iconst_1
    //   70: new 98	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   77: ldc 101
    //   79: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: invokevirtual 109	java/lang/Exception:toString	()Ljava/lang/String;
    //   86: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload_0
    //   96: getfield 56	atgc:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   99: invokevirtual 70	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   102: invokevirtual 90	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   105: return
    //   106: astore_1
    //   107: aload_0
    //   108: getfield 56	atgc:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   111: invokevirtual 70	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   114: invokevirtual 90	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   117: aload_1
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	atgc
    //   0	119	1	paramEntity	com.tencent.mobileqq.persistence.Entity
    // Exception table:
    //   from	to	target	type
    //   5	33	66	java/lang/Exception
    //   33	43	66	java/lang/Exception
    //   54	63	66	java/lang/Exception
    //   5	33	106	finally
    //   33	43	106	finally
    //   54	63	106	finally
    //   67	95	106	finally
  }
  
  public String EN()
  {
    String str1 = null;
    if (this.a != null) {
      str1 = this.a.aioRecentFolderName;
    }
    String str2 = str1;
    if (str1 == null) {
      str2 = BaseApplicationImpl.getContext().getString(2131719500);
    }
    return str2;
  }
  
  public String EO()
  {
    String str1 = null;
    if (this.a != null) {
      str1 = this.a.defaultAddFolderName;
    }
    String str2 = str1;
    if (str1 == null) {
      str2 = BaseApplicationImpl.getContext().getString(2131691589);
    }
    return str2;
  }
  
  public int On()
  {
    if (this.a != null) {
      return this.a.allItemCount;
    }
    return 0;
  }
  
  public void R(FileManagerEntity paramFileManagerEntity)
  {
    if (!this.qc.containsKey(Long.valueOf(paramFileManagerEntity.nSessionId))) {
      this.qc.put(Long.valueOf(paramFileManagerEntity.nSessionId), paramFileManagerEntity);
    }
  }
  
  public void S(FileManagerEntity paramFileManagerEntity)
  {
    if (this.qc.containsKey(Long.valueOf(paramFileManagerEntity.nSessionId))) {
      this.qc.remove(Long.valueOf(paramFileManagerEntity.nSessionId));
    }
  }
  
  public void T(FileManagerEntity paramFileManagerEntity)
  {
    this.Kr.remove(paramFileManagerEntity);
  }
  
  public void Vx(boolean paramBoolean)
  {
    if ((this.dhz) && (!this.dhA)) {
      CloudFileSendRecvSyncer.a().etE();
    }
    this.dhA = paramBoolean;
  }
  
  public void YJ(String paramString)
  {
    if (this.a == null) {
      this.a = new CloudFileUserInfo();
    }
    this.a.aioRecentFolderName = paramString;
  }
  
  public void YK(String paramString)
  {
    if (this.a == null) {
      this.a = new CloudFileUserInfo();
    }
    this.a.defaultAddFolderName = paramString;
  }
  
  public FileManagerEntity a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    while (i < this.Kr.size())
    {
      if ((paramArrayOfByte2 != null) && (((FileManagerEntity)this.Kr.get(i)).cloudId != null) && (Arrays.equals(paramArrayOfByte2, ((FileManagerEntity)this.Kr.get(i)).cloudId))) {
        return (FileManagerEntity)this.Kr.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(CloudUserInfo paramCloudUserInfo)
  {
    if ((paramCloudUserInfo != null) && (paramCloudUserInfo.rootDirKey != null))
    {
      if (this.a == null) {
        this.a = new CloudFileUserInfo();
      }
      this.a.rootDirKey = paramCloudUserInfo.rootDirKey;
      this.a.aioRecentFolderId = paramCloudUserInfo.aioRecentFolderId;
      this.a.usedSpace = paramCloudUserInfo.usedSpace;
      this.a.totalSpace = paramCloudUserInfo.totalSpace;
      this.a.defaultAddFolderId = paramCloudUserInfo.defaultAddFolderId;
      this.a.uploadFileLimit = paramCloudUserInfo.uploadFileLimit;
      e(this.a);
      if ((!this.dhz) && (this.dhA)) {
        CloudFileSendRecvSyncer.a().etE();
      }
      this.dhz = true;
    }
  }
  
  public byte[] aE()
  {
    if (this.a != null) {
      return this.a.rootDirKey;
    }
    return null;
  }
  
  public byte[] aF()
  {
    if (this.a != null) {
      return this.a.aioRecentFolderId;
    }
    return null;
  }
  
  public byte[] aG()
  {
    if (this.a != null) {
      return this.a.defaultAddFolderId;
    }
    return null;
  }
  
  public boolean aJe()
  {
    return this.dhz;
  }
  
  public void aan(int paramInt)
  {
    if (this.a != null)
    {
      this.a.allItemCount = paramInt;
      e(this.a);
    }
  }
  
  public FileManagerEntity b(FileManagerEntity paramFileManagerEntity)
  {
    Iterator localIterator = this.Kr.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (athu.c(localFileManagerEntity, paramFileManagerEntity)) {
        return localFileManagerEntity;
      }
    }
    return null;
  }
  
  public FileManagerEntity f(long paramLong)
  {
    Iterator localIterator = this.Kr.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (localFileManagerEntity.nSessionId == paramLong) {
        return localFileManagerEntity;
      }
    }
    return null;
  }
  
  public long getTotalSpace()
  {
    if (this.a != null) {
      return this.a.totalSpace;
    }
    return 10737418240L;
  }
  
  public List<FileManagerEntity> hg()
  {
    return new ArrayList(this.qc.values());
  }
  
  public List<FileManagerEntity> hh()
  {
    return this.Kr;
  }
  
  public List<atiu> hi()
  {
    return this.lb;
  }
  
  public long it()
  {
    if (this.a != null) {
      return this.a.usedSpace;
    }
    return 0L;
  }
  
  public long iu()
  {
    if (this.a != null) {
      return this.a.uploadFileLimit;
    }
    return 104857600L;
  }
  
  public void nC(List<FileManagerEntity> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    label139:
    for (;;)
    {
      return;
      Iterator localIterator1 = this.Kr.iterator();
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label139;
        }
        FileManagerEntity localFileManagerEntity1 = (FileManagerEntity)localIterator1.next();
        Iterator localIterator2 = paramList.iterator();
        if (localIterator2.hasNext())
        {
          FileManagerEntity localFileManagerEntity2 = (FileManagerEntity)localIterator2.next();
          if ((localFileManagerEntity2.cloudId == null) || (localFileManagerEntity1.cloudId == null) || (!Arrays.equals(localFileManagerEntity2.cloudId, localFileManagerEntity1.cloudId))) {
            break;
          }
          localFileManagerEntity2.setfProgress(localFileManagerEntity1.getfProgress());
          if (localFileManagerEntity1.status == 3) {
            localFileManagerEntity2.status = -1;
          } else {
            localFileManagerEntity2.status = localFileManagerEntity1.status;
          }
        }
      }
    }
  }
  
  public void nD(List<Object> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    label151:
    for (;;)
    {
      return;
      Iterator localIterator1 = this.Kr.iterator();
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label151;
        }
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator1.next();
        Iterator localIterator2 = paramList.iterator();
        if (localIterator2.hasNext())
        {
          Object localObject = localIterator2.next();
          if (!(localObject instanceof FileManagerEntity)) {
            break;
          }
          localObject = (FileManagerEntity)localObject;
          if ((((FileManagerEntity)localObject).cloudId == null) || (localFileManagerEntity.cloudId == null) || (!Arrays.equals(((FileManagerEntity)localObject).cloudId, localFileManagerEntity.cloudId))) {
            break;
          }
          ((FileManagerEntity)localObject).setfProgress(localFileManagerEntity.getfProgress());
          if (localFileManagerEntity.status == 3) {
            ((FileManagerEntity)localObject).status = -1;
          } else {
            ((FileManagerEntity)localObject).status = localFileManagerEntity.status;
          }
        }
      }
    }
  }
  
  public void nE(List<atiu> paramList)
  {
    this.lb.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.lb.addAll(paramList);
    }
  }
  
  public void onDestroy()
  {
    this.Kr.clear();
    this.lb.clear();
  }
  
  public void qh()
  {
    if (!this.isInited) {
      try
      {
        if (!this.isInited)
        {
          List localList = this.em.query(CloudFileUserInfo.class);
          if ((localList != null) && (!localList.isEmpty())) {
            this.a = ((CloudFileUserInfo)localList.get(0));
          }
          this.isInited = true;
        }
        return;
      }
      finally {}
    }
  }
  
  public boolean w(byte[] paramArrayOfByte)
  {
    return Arrays.equals(aF(), paramArrayOfByte);
  }
  
  public boolean y(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    Iterator localIterator = this.Kr.iterator();
    while (localIterator.hasNext()) {
      if (athu.c((FileManagerEntity)localIterator.next(), paramFileManagerEntity)) {
        return false;
      }
    }
    return this.Kr.add(paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atgc
 * JD-Core Version:    0.7.0.1
 */