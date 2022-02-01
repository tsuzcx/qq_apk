import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.fileviewer.model.C2CFileModel.1.1;

public class atzg
  extends atsn
{
  atzg(atzf paramatzf) {}
  
  protected void Q(long paramLong1, long paramLong2)
  {
    super.Q(paramLong1, paramLong2);
    if ((paramLong1 == this.a.c.fR()) && (this.a.e != null)) {
      this.a.e.ir();
    }
  }
  
  protected void a(atwh paramatwh)
  {
    if ((TextUtils.isEmpty(paramatwh.fileId)) || (TextUtils.isEmpty(paramatwh.filePath))) {
      if (QLog.isColorLevel()) {
        QLog.i("FMObserver<FileAssistant>", 2, "OnThumbDownLoad error : [fileId] = " + paramatwh.fileId + " [path] = " + paramatwh.filePath);
      }
    }
    while (this.a.jdField_a_of_type_Atzy$c == null) {
      return;
    }
    this.a.jdField_a_of_type_Atzy$c.fP(paramatwh.fileId, paramatwh.filePath);
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
          paramInt = this.a.getFileType();
          if (paramInt != 4) {
            break;
          }
        } while (this.a.jdField_a_of_type_Atzy$c == null);
        this.a.jdField_a_of_type_Atzy$c.fP(String.valueOf(paramLong), paramString2);
        return;
        if (paramInt != 0) {
          break;
        }
      } while ((this.a.V() != paramLong) || (this.a.jdField_a_of_type_Atzy$c == null));
      this.a.jdField_a_of_type_Atzy$c.fP(String.valueOf(paramLong), paramString2);
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
    if (paramLong2 != this.a.c.fR()) {}
    do
    {
      return;
      paramString = this.a.c.b();
    } while ((paramString == null) || ((paramString.getCloudType() == 0) && (paramString.nOpType == 10)) || (this.a.jdField_a_of_type_Atzy$d == null));
    this.a.jdField_a_of_type_Atzy$d.aO(paramString.getfProgress());
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FMObserver<FileAssistant>", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    if (paramLong2 != this.a.c.fR()) {}
    while (this.a.jdField_a_of_type_Atzy$d == null) {
      return;
    }
    if (!paramBoolean)
    {
      atzf.a(this.a, paramLong2, paramInt2, paramString2);
      this.a.jdField_a_of_type_Atzy$d.djH();
      return;
    }
    if (this.a.getFileType() == 2) {
      new Handler().postDelayed(new C2CFileModel.1.1(this), 1000L);
    }
    for (;;)
    {
      this.a.a(this.a.c, 4);
      return;
      this.a.jdField_a_of_type_Atzy$d.djG();
    }
  }
  
  protected void b(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (paramLong != this.a.c.b().nSessionId) {}
    while ((paramString2 == null) || (paramString2.length() <= 0) || (paramInt == 0)) {
      return;
    }
    audx.JI(paramString2);
  }
  
  protected void bJl() {}
  
  protected void c(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.c.fR()) {}
    while (this.a.jdField_a_of_type_Atzy$d == null) {
      return;
    }
    this.a.jdField_a_of_type_Atzy$d.djE();
  }
  
  protected void cq(int paramInt, String paramString)
  {
    audx.JI(paramString);
  }
  
  protected void e(int paramInt, long paramLong, String paramString)
  {
    if (paramLong != this.a.c.b().nSessionId) {
      return;
    }
    audx.n(paramLong, paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atzg
 * JD-Core Version:    0.7.0.1
 */