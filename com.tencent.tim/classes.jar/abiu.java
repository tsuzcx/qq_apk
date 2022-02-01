import com.tencent.qphone.base.util.QLog;
import java.io.File;

class abiu
  extends aquy
{
  abiu(abis paramabis, File paramFile, abis.a parama) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip task.getStatus:" + paramaquz.getStatus());
    }
    if (3 == paramaquz.getStatus())
    {
      if (this.val$file.exists()) {
        try
        {
          paramaquz = arwv.encodeFileHexStr(this.val$file.getAbsolutePath());
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, " downloadAllZip onDone dstMd5:" + paramaquz + " result.mMd5:" + this.a.mMd5);
          }
          if (abis.b(this.a, paramaquz))
          {
            if (abis.b(this.a))
            {
              jqp.b(this.val$file, this.val$file.getParent() + File.separator);
              if (QLog.isColorLevel()) {
                QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile ok file path->" + this.val$file.getAbsolutePath());
              }
            }
            for (;;)
            {
              abis.a(this.this$0, this.a.cpj, this.a);
              return;
              boolean bool = aqhq.copyFile(this.val$file.getAbsolutePath(), this.a.qX() + this.a.bgw);
              QLog.i("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip no need unzip copy:" + bool);
            }
          }
          QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path- no exist:" + this.val$file.getAbsolutePath());
        }
        catch (Exception paramaquz)
        {
          abis.a(this.this$0, this.a.cpj);
          this.val$file.delete();
          QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.val$file.getAbsolutePath() + paramaquz.getMessage());
          return;
          QLog.e("rscContent_CmShowRscUpdateHandler", 1, "dstMd5 != result.mMd5");
          abis.a(this.this$0, this.a.cpj);
          return;
        }
        catch (OutOfMemoryError paramaquz)
        {
          if (QLog.isColorLevel()) {
            QLog.d("rscContent_CmShowRscUpdateHandler", 2, "downloadAllZip unZipFile file error path->" + this.val$file.getAbsolutePath() + paramaquz.getMessage());
          }
          this.val$file.delete();
          return;
        }
      }
      abis.a(this.this$0, this.a.cpj);
      return;
    }
    QLog.d("rscContent_CmShowRscUpdateHandler", 1, "downloadAllZip  file error path->" + this.val$file.getAbsolutePath() + " task.getStatus()->" + paramaquz.getStatus());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abiu
 * JD-Core Version:    0.7.0.1
 */