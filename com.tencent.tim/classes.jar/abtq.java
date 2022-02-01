import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class abtq
  extends aquy
{
  abtq(File paramFile, abhh paramabhh, int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, abto.c paramc, String paramString, List paramList) {}
  
  public void onDone(aquz paramaquz)
  {
    boolean bool = true;
    super.onDone(paramaquz);
    if (3 == paramaquz.getStatus()) {
      if (!this.val$file.exists()) {}
    }
    for (;;)
    {
      try
      {
        jqp.b(this.val$file, this.val$file.getParent() + File.separator);
        abto.a(this.b, this.val$resType, this.val$id);
        this.aT.getAndIncrement();
        if (this.aT.get() != this.aU.get()) {
          break label413;
        }
        if (this.a != null)
        {
          paramaquz = this.a;
          if (this.val$errorCount.get() > 0) {
            bool = false;
          }
          paramaquz.e(bool, this.val$uin, this.val$tasks);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloResDownloader", 2, "downloadApolloRes download all done uin: " + this.val$uin + "all cnt: " + this.aU.get() + ", err cnt: " + this.val$errorCount.get());
          }
        }
        this.val$file.delete();
        return;
      }
      catch (Exception paramaquz)
      {
        this.val$errorCount.getAndIncrement();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + this.val$resType + " id->" + this.val$id + " error->" + paramaquz.getMessage());
        continue;
      }
      catch (OutOfMemoryError paramaquz)
      {
        this.val$errorCount.getAndIncrement();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + this.val$resType + " id->" + this.val$id + " error->" + paramaquz.getMessage());
        continue;
      }
      this.val$errorCount.getAndIncrement();
      QLog.d("ApolloResDownloader", 1, "download file error resType->" + this.val$resType + " id->" + this.val$id + " task.getStatus()->" + paramaquz.getStatus());
      continue;
      label413:
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes download uin:" + this.val$uin + ", cb cnt: " + this.aT.get() + ", all cnt: " + this.aU.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abtq
 * JD-Core Version:    0.7.0.1
 */