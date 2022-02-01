import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class abir
  extends aquy
{
  abir(String paramString1, File paramFile, AtomicInteger paramAtomicInteger1, int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, abiq.a parama, abip.a parama1, String paramString2, List paramList) {}
  
  public void onDone(aquz paramaquz)
  {
    boolean bool = true;
    super.onDone(paramaquz);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscDownloader", 1, "download url:" + this.val$url + " task.getStatus()->" + paramaquz.getStatus());
    }
    if (3 == paramaquz.getStatus()) {
      if (!this.val$file.exists()) {}
    }
    do
    {
      for (;;)
      {
        try
        {
          jqp.b(this.val$file, this.val$file.getParent() + File.separator);
          this.aT.getAndIncrement();
          if (this.aT.get() != this.aU.get()) {
            break;
          }
          if (this.jdField_a_of_type_Abiq$a != null)
          {
            paramaquz = "";
            if (this.jdField_a_of_type_Abip$a != null) {
              paramaquz = this.jdField_a_of_type_Abip$a.qV();
            }
            abiq.a locala = this.jdField_a_of_type_Abiq$a;
            if (this.val$errorCount.get() > 0) {
              bool = false;
            }
            locala.a(bool, this.val$uin, this.val$tasks, paramaquz);
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes download all done uin: " + this.val$uin + "all cnt: " + this.aU.get() + ", err cnt: " + this.val$errorCount.get());
            }
          }
          return;
        }
        catch (Exception paramaquz)
        {
          this.val$file.delete();
          this.val$errorCount.getAndIncrement();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("rscContent_CmShowRscDownloader", 2, "unZipFile file error resType->" + this.val$resType + " id->" + this.val$id + " error->" + paramaquz.getMessage());
          continue;
        }
        catch (OutOfMemoryError paramaquz)
        {
          this.val$file.delete();
          this.val$errorCount.getAndIncrement();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("rscContent_CmShowRscDownloader", 2, "unZipFile file error resType->" + this.val$resType + " id->" + this.val$id + " error->" + paramaquz.getMessage());
          continue;
        }
        this.val$errorCount.getAndIncrement();
        QLog.d("rscContent_CmShowRscDownloader", 1, "download file error resType->" + this.val$resType + " id->" + this.val$id + " task.getStatus()->" + paramaquz.getStatus());
      }
    } while (!QLog.isColorLevel());
    QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes download uin:" + this.val$uin + ", cb cnt: " + this.aT.get() + ", all cnt: " + this.aU.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abir
 * JD-Core Version:    0.7.0.1
 */