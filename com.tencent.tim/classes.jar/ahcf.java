import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.UniformDownloadBPTransEntity;
import com.tencent.qphone.base.util.QLog;

public class ahcf
{
  private static ahcf a;
  
  public static ahcf a()
  {
    try
    {
      if (a == null) {
        a = new ahcf();
      }
      ahcf localahcf = a;
      return localahcf;
    }
    finally {}
  }
  
  public void JN(String paramString)
  {
    QLog.i("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] delBPTransItem. url[" + paramString + "]");
    QQAppInterface localQQAppInterface = aglz.a().getApp();
    if (localQQAppInterface == null) {
      QLog.e("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] delBPTransItem failed APP=null. url[" + paramString + "]");
    }
    while (localQQAppInterface.a() == null) {
      return;
    }
    localQQAppInterface.a().JO(paramString);
  }
  
  public ahcf.a a(String paramString)
  {
    Object localObject = aglz.a().getApp();
    if (localObject == null) {
      QLog.e("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] getBPTransItem failed APP=null. url[" + paramString + "]");
    }
    for (;;)
    {
      return null;
      if (((QQAppInterface)localObject).a() != null) {}
      for (paramString = ((QQAppInterface)localObject).a().a(paramString); paramString != null; paramString = null)
      {
        localObject = new ahcf.a();
        ((ahcf.a)localObject).fileName = paramString.mFileName;
        ((ahcf.a)localObject).fileSize = paramString.mFileSize;
        ((ahcf.a)localObject).aTN = paramString.mFilePath;
        ((ahcf.a)localObject).bJT = paramString.mTempPath;
        return localObject;
        QLog.e("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] getUDLBPTransProxy=null.");
      }
    }
  }
  
  public void b(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = new UniformDownloadBPTransEntity();
    localUniformDownloadBPTransEntity.mUrl = paramString1;
    localUniformDownloadBPTransEntity.mFileName = paramString2;
    localUniformDownloadBPTransEntity.mFileSize = paramLong;
    localUniformDownloadBPTransEntity.mFilePath = paramString4;
    localUniformDownloadBPTransEntity.mTempPath = paramString3;
    QQAppInterface localQQAppInterface = aglz.a().getApp();
    if (localQQAppInterface == null)
    {
      QLog.e("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] addBPTransItem.failed APP=null, filename[" + paramString2 + "] fillesize[" + paramLong + "] tempPath[" + paramString3 + "] strPath[" + paramString4 + "] url[" + paramString1 + "]");
      return;
    }
    if (localQQAppInterface.a() != null) {
      localQQAppInterface.a().a(localUniformDownloadBPTransEntity);
    }
    QLog.i("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] addBPTransItem.filename[" + paramString2 + "] fillesize[" + paramLong + "] tempPath[" + paramString3 + "] strPath[" + paramString4 + "] url[" + paramString1 + "]");
  }
  
  public static class a
  {
    String aTN;
    String bJT;
    String fileName;
    long fileSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahcf
 * JD-Core Version:    0.7.0.1
 */