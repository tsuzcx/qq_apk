import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.fileviewer.model.TIMCloudFileModel.3.1;
import com.tencent.tim.filemanager.fileviewer.model.TIMCloudFileModel.3.2;
import com.tencent.tim.filemanager.fileviewer.model.TIMCloudFileModel.3.3;
import java.util.Arrays;

public class auam
  extends atsn
{
  auam(auaj paramauaj, QQAppInterface paramQQAppInterface) {}
  
  protected void Q(long paramLong1, long paramLong2)
  {
    super.Q(paramLong1, paramLong2);
    if ((paramLong1 == this.this$0.c.fR()) && (this.this$0.e != null)) {
      this.this$0.e.ir();
    }
  }
  
  protected void a(atwh paramatwh)
  {
    if ((TextUtils.isEmpty(paramatwh.fileId)) || (TextUtils.isEmpty(paramatwh.filePath))) {
      if (QLog.isColorLevel()) {
        QLog.i("FMObserver<FileAssistant>", 2, "OnThumbDownLoad error : [fileId] = " + paramatwh.fileId + " [path] = " + paramatwh.filePath);
      }
    }
    while (this.this$0.jdField_a_of_type_Atzy$c == null) {
      return;
    }
    this.this$0.jdField_a_of_type_Atzy$c.fP(paramatwh.fileId, paramatwh.filePath);
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    audx.n(paramLong, paramInteger.intValue(), paramString);
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (!paramBoolean) {}
    do
    {
      do
      {
        do
        {
          return;
          paramInt = this.this$0.getFileType();
          if (paramInt != 4) {
            break;
          }
        } while (this.this$0.jdField_a_of_type_Atzy$c == null);
        this.this$0.jdField_a_of_type_Atzy$c.fP(String.valueOf(paramLong), paramString2);
        return;
        if (paramInt != 0) {
          break;
        }
      } while ((this.this$0.V() != paramLong) || (this.this$0.jdField_a_of_type_Atzy$c == null));
      this.this$0.jdField_a_of_type_Atzy$c.fP(String.valueOf(paramLong), paramString2);
      return;
    } while (!QLog.isColorLevel());
    QLog.i("FMObserver<FileAssistant>", 2, "OnZipImageThumbDownloadCompleted : sessionId[" + paramLong + "]  thumbPath[" + paramString2 + "] but current file browser can not handle");
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3)
  {
    if (!paramBoolean) {
      audx.n(paramLong3, paramInt, paramString1);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    paramString = ((atgc)this.val$app.getManager(373)).b(this.this$0.c.b());
    if ((paramString != null) && (paramString.nFileType != 2))
    {
      FileManagerEntity localFileManagerEntity = this.this$0.c.b();
      atgc localatgc = (atgc)this.val$app.getManager(373);
      if (Arrays.equals(localFileManagerEntity.pDirKey, localatgc.aF()))
      {
        auaj.a(this.this$0, this.this$0.mAppInterface.a().a(localFileManagerEntity.cloudId));
        if ((auaj.a(this.this$0) != null) && (paramLong2 == auaj.a(this.this$0).nSessionId)) {
          break label142;
        }
      }
    }
    label142:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (auaj.a(this.this$0).getfProgress() == 0.0F)
            {
              auaj.a(this.this$0).setfProgress(paramString.getfProgress());
              auaj.a(this.this$0).status = paramString.status;
            }
          } while (this.this$0.jdField_a_of_type_Atzy$d == null);
          paramString.setfProgress(auaj.a(this.this$0).getfProgress());
          float f = auaj.a(this.this$0).getfProgress();
          this.this$0.mContext.runOnUiThread(new TIMCloudFileModel.3.1(this, f));
          return;
          this.this$0.c.b();
          if (auaj.a(this.this$0) == null) {
            auaj.a(this.this$0, this.this$0.c.b());
          }
        } while ((auaj.a(this.this$0) == null) || (paramLong2 != auaj.a(this.this$0).nSessionId));
        if (auaj.a(this.this$0).status != 3) {
          auaj.a(this.this$0).status = 2;
        }
      } while ((auaj.a(this.this$0).getCloudType() == 0) && (auaj.a(this.this$0).nOpType == 10));
      paramString = auaj.a(this.this$0);
    } while (this.this$0.jdField_a_of_type_Atzy$d == null);
    this.this$0.mContext.runOnUiThread(new TIMCloudFileModel.3.2(this, paramString));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMObserver<FileAssistant>", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    if (auaj.a(this.this$0) == null) {
      auaj.a(this.this$0, this.this$0.c.b());
    }
    if ((auaj.a(this.this$0) == null) || (paramLong2 != auaj.a(this.this$0).nSessionId)) {}
    do
    {
      return;
      if (paramBoolean) {
        break label235;
      }
      paramString1 = this.this$0.c.b();
      if ((paramString1.nFileType != 2) && (paramString1.status != 16)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FMObserver<FileAssistant>", 2, "offline download fail,but file is video don't retry!");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("FMObserver<FileAssistant>", 2, "offline download fail, retry cloud sdk download.");
    }
    atgi.a().startDownloadFile(paramString1.pDirKey, paramString1.cloudId, acbn.bmg + paramString1.fileName);
    return;
    label235:
    paramString1 = auaj.a(this.this$0).getFilePath();
    paramString2 = this.this$0.c.b();
    paramString2.setFilePath(paramString1);
    paramString2.status = 1;
    if (paramString2.cloudFile != null)
    {
      paramString2.cloudFile.downloadStatus = 5;
      paramString2.cloudFile.finalPath = paramString1;
    }
    atgi.a().a(paramString2, paramString1, true);
    if (this.this$0.getFileType() == 2) {
      new Handler().postDelayed(new TIMCloudFileModel.3.3(this), 1000L);
    }
    for (;;)
    {
      this.this$0.a(this.this$0.c, 4);
      return;
      if (this.this$0.jdField_a_of_type_Atzy$d != null) {
        this.this$0.jdField_a_of_type_Atzy$d.djG();
      }
    }
  }
  
  protected void b(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (paramLong != this.this$0.c.b().nSessionId) {}
    while ((paramString2 == null) || (paramString2.length() <= 0) || (paramInt == 0)) {
      return;
    }
    audx.JI(paramString2);
  }
  
  protected void bJl() {}
  
  protected void c(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.this$0.c.fR()) {}
    while (this.this$0.jdField_a_of_type_Atzy$d == null) {
      return;
    }
    this.this$0.jdField_a_of_type_Atzy$d.djE();
  }
  
  protected void cq(int paramInt, String paramString)
  {
    audx.JI(paramString);
  }
  
  protected void e(int paramInt, long paramLong, String paramString)
  {
    if (paramLong != this.this$0.c.b().nSessionId) {
      return;
    }
    audx.n(paramLong, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auam
 * JD-Core Version:    0.7.0.1
 */