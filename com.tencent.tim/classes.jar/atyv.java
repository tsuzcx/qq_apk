import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.tim.filemanager.data.TroopForwardFileInfo;

public class atyv
{
  public static ForwardFileInfo a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.setType(10004);
    if (paramFileManagerEntity.bSend) {}
    for (String str = paramQQAppInterface.getAccount();; str = paramFileManagerEntity.peerUin)
    {
      localForwardFileInfo.Oj(paramFileManagerEntity.getCloudType());
      localForwardFileInfo.jA(Long.valueOf(str.replace("+", "")).longValue());
      localForwardFileInfo.jB(paramFileManagerEntity.uniseq);
      localForwardFileInfo.p(paramFileManagerEntity.nSessionId);
      localForwardFileInfo.setFileName(paramFileManagerEntity.fileName);
      localForwardFileInfo.setFileSize(paramFileManagerEntity.fileSize);
      localForwardFileInfo.setUuid(paramFileManagerEntity.Uuid);
      localForwardFileInfo.setLocalPath(paramFileManagerEntity.getFilePath());
      if (paramFileManagerEntity.getCloudType() == 9)
      {
        paramFileManagerEntity.cloudFile = athu.a(paramFileManagerEntity);
        paramQQAppInterface.a().v(paramFileManagerEntity);
      }
      return localForwardFileInfo;
    }
  }
  
  public static ForwardFileInfo b(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.nSessionId == 0L) {
      paramFileManagerEntity.nSessionId = audx.d().longValue();
    }
    paramQQAppInterface.a().v(paramFileManagerEntity);
    paramQQAppInterface = new ForwardFileInfo();
    paramQQAppInterface.Oj(9);
    paramQQAppInterface.setType(10001);
    paramQQAppInterface.setFileName(paramFileManagerEntity.fileName);
    paramQQAppInterface.setFileSize(paramFileManagerEntity.fileSize);
    paramQQAppInterface.bg(paramFileManagerEntity.pDirKey);
    paramQQAppInterface.bf(paramFileManagerEntity.cloudId);
    paramQQAppInterface.p(paramFileManagerEntity.nSessionId);
    return paramQQAppInterface;
  }
  
  public static ForwardFileInfo b(FileManagerEntity paramFileManagerEntity)
  {
    TroopForwardFileInfo localTroopForwardFileInfo = new TroopForwardFileInfo();
    localTroopForwardFileInfo.p(paramFileManagerEntity.nSessionId);
    localTroopForwardFileInfo.Oj(4);
    localTroopForwardFileInfo.setType(10006);
    localTroopForwardFileInfo.setLocalPath(paramFileManagerEntity.getFilePath());
    localTroopForwardFileInfo.setFileName(paramFileManagerEntity.fileName);
    localTroopForwardFileInfo.setFileSize(paramFileManagerEntity.fileSize);
    return localTroopForwardFileInfo;
  }
  
  /* Error */
  public static ForwardFileInfo b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 160	aueh:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   4: ifeq +84 -> 88
    //   7: new 162	com/tencent/mobileqq/filemanager/data/FileInfo
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 164	com/tencent/mobileqq/filemanager/data/FileInfo:<init>	(Ljava/lang/String;)V
    //   15: astore_1
    //   16: aload_1
    //   17: invokestatic 167	audx:a	(Lcom/tencent/mobileqq/filemanager/data/FileInfo;)Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   20: astore_2
    //   21: new 8	com/tencent/mobileqq/filemanager/data/ForwardFileInfo
    //   24: dup
    //   25: invokespecial 12	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:<init>	()V
    //   28: astore_0
    //   29: aload_0
    //   30: aload_2
    //   31: getfield 69	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   34: invokevirtual 72	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:p	(J)V
    //   37: aload_0
    //   38: iconst_3
    //   39: invokevirtual 35	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:Oj	(I)V
    //   42: aload_0
    //   43: sipush 10000
    //   46: invokevirtual 16	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:setType	(I)V
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual 170	com/tencent/mobileqq/filemanager/data/FileInfo:getPath	()Ljava/lang/String;
    //   54: invokevirtual 98	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:setLocalPath	(Ljava/lang/String;)V
    //   57: aload_0
    //   58: aload_1
    //   59: invokevirtual 173	com/tencent/mobileqq/filemanager/data/FileInfo:getName	()Ljava/lang/String;
    //   62: invokevirtual 80	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:setFileName	(Ljava/lang/String;)V
    //   65: aload_0
    //   66: aload_1
    //   67: invokevirtual 176	com/tencent/mobileqq/filemanager/data/FileInfo:getSize	()J
    //   70: invokevirtual 86	com/tencent/mobileqq/filemanager/data/ForwardFileInfo:setFileSize	(J)V
    //   73: aload_0
    //   74: areturn
    //   75: astore_1
    //   76: aconst_null
    //   77: astore_0
    //   78: aload_1
    //   79: invokevirtual 179	java/io/FileNotFoundException:printStackTrace	()V
    //   82: aload_0
    //   83: areturn
    //   84: astore_1
    //   85: goto -7 -> 78
    //   88: aconst_null
    //   89: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramString	String
    //   15	52	1	localFileInfo	com.tencent.mobileqq.filemanager.data.FileInfo
    //   75	4	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   84	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   20	11	2	localFileManagerEntity	FileManagerEntity
    // Exception table:
    //   from	to	target	type
    //   0	29	75	java/io/FileNotFoundException
    //   29	73	84	java/io/FileNotFoundException
  }
  
  public static ForwardFileInfo c(FileManagerEntity paramFileManagerEntity)
  {
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.Oj(2);
    localForwardFileInfo.setType(10003);
    localForwardFileInfo.p(paramFileManagerEntity.nSessionId);
    localForwardFileInfo.setFileName(paramFileManagerEntity.fileName);
    localForwardFileInfo.setFileId(paramFileManagerEntity.WeiYunFileId);
    localForwardFileInfo.Oi(paramFileManagerEntity.nWeiYunSrcType);
    localForwardFileInfo.setFileSize(paramFileManagerEntity.fileSize);
    return localForwardFileInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atyv
 * JD-Core Version:    0.7.0.1
 */