import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

final class abtr
  extends aquy
{
  abtr(File paramFile, abhh paramabhh, int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, abto.b paramb, String paramString, int paramInt3, int[] paramArrayOfInt, int paramInt4) {}
  
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
          break label421;
        }
        if (this.c != null)
        {
          paramaquz = this.c;
          if (this.val$errorCount.get() > 0) {
            bool = false;
          }
          paramaquz.onDownLoadFinish(bool, this.val$uin, this.cpx, this.jQ, this.val$actionId);
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
      label421:
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes download uin:" + this.val$uin + ", cb cnt: " + this.aT.get() + ", all cnt: " + this.aU.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abtr
 * JD-Core Version:    0.7.0.1
 */