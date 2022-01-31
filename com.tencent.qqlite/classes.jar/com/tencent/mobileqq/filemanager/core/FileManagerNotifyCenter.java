package com.tencent.mobileqq.filemanager.core;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import dnp;
import dnq;
import java.util.HashMap;
import java.util.Observable;

public class FileManagerNotifyCenter
  extends Observable
{
  public static final int a = 10001;
  protected static final String a = "FileManagerNotifyCenter<FileAssistant>";
  Handler a;
  public QQAppInterface a;
  
  public FileManagerNotifyCenter(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler = new dnp(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
  }
  
  /* Error */
  private tencent.im.msg.im_msg_body.RichText a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    // Byte code:
    //   0: new 49	tencent/im/msg/im_msg_body$NotOnlineFile
    //   3: dup
    //   4: invokespecial 50	tencent/im/msg/im_msg_body$NotOnlineFile:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: getfield 54	tencent/im/msg/im_msg_body$NotOnlineFile:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   14: iconst_0
    //   15: invokevirtual 60	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   18: aload 6
    //   20: getfield 64	tencent/im/msg/im_msg_body$NotOnlineFile:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   23: aload_2
    //   24: invokevirtual 70	java/lang/String:getBytes	()[B
    //   27: invokestatic 76	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   30: invokevirtual 81	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   33: aload 6
    //   35: getfield 85	tencent/im/msg/im_msg_body$NotOnlineFile:uint64_file_size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   38: lload 4
    //   40: invokevirtual 90	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   43: aload 6
    //   45: getfield 93	tencent/im/msg/im_msg_body$NotOnlineFile:bytes_file_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   48: aload_3
    //   49: invokevirtual 70	java/lang/String:getBytes	()[B
    //   52: invokestatic 76	com/tencent/mobileqq/pb/ByteStringMicro:copyFrom	([B)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   55: invokevirtual 81	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   58: new 95	tencent/im/msg/im_msg_body$RichText
    //   61: dup
    //   62: invokespecial 96	tencent/im/msg/im_msg_body$RichText:<init>	()V
    //   65: astore_1
    //   66: aload_1
    //   67: getfield 100	tencent/im/msg/im_msg_body$RichText:not_online_file	Ltencent/im/msg/im_msg_body$NotOnlineFile;
    //   70: aload 6
    //   72: invokevirtual 103	tencent/im/msg/im_msg_body$NotOnlineFile:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   75: aload_1
    //   76: areturn
    //   77: astore_2
    //   78: aconst_null
    //   79: astore_1
    //   80: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +11 -> 94
    //   86: ldc 10
    //   88: iconst_2
    //   89: ldc 111
    //   91: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload_2
    //   95: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   98: aload_1
    //   99: areturn
    //   100: astore_2
    //   101: goto -21 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	FileManagerNotifyCenter
    //   0	104	1	paramString1	String
    //   0	104	2	paramString2	String
    //   0	104	3	paramString3	String
    //   0	104	4	paramLong	long
    //   7	64	6	localNotOnlineFile	tencent.im.msg.im_msg_body.NotOnlineFile
    // Exception table:
    //   from	to	target	type
    //   0	66	77	java/lang/Exception
    //   66	75	100	java/lang/Exception
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, int paramInt, String paramString)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("averageSpeed", String.valueOf(0.0F));
    ((HashMap)localObject).put("peerUin", String.valueOf(paramFileManagerEntity.peerUin));
    ((HashMap)localObject).put("fileType", FileUtil.a(paramFileManagerEntity.fileName));
    switch (paramInt)
    {
    default: 
      QLog.e("FileManagerNotifyCenter<FileAssistant>", 1, "what type is report?!nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "],may be not report!");
      return;
    case 5: 
      return;
    case 6: 
      localObject = "actFileOf2Of";
    }
    for (;;)
    {
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, (String)localObject, 1L, paramString, paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 0L, 0L, paramFileManagerEntity.fileSize, 0, null);
      return;
      localObject = "actFileOf2Wy";
      continue;
      localObject = "actFileWy2Of";
      continue;
      localObject = "actFileDisc2Of";
      continue;
      localObject = "actFileDisc2Disc";
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, Object paramObject, int paramInt3, String paramString2)
  {
    setChanged();
    if (paramObject == null)
    {
      notifyObservers(new Object[] { Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), paramString2 });
      return;
    }
    notifyObservers(new Object[] { Integer.valueOf(paramInt2), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, Integer.valueOf(paramInt1), paramObject });
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, int paramInt, String paramString)
  {
    b(paramFileManagerEntity, paramInt, paramString);
    new Thread(new dnq(this, paramFileManagerEntity, paramInt)).run();
  }
  
  public void a(boolean paramBoolean, int paramInt, Object paramObject)
  {
    try
    {
      setChanged();
      notifyObservers(new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), paramObject });
      return;
    }
    finally
    {
      paramObject = finally;
      throw paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter
 * JD-Core Version:    0.7.0.1
 */