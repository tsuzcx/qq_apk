import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class abts
  extends aquy
{
  abts(File paramFile) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    if ((3 == paramaquz.getStatus()) && (this.val$file.exists())) {}
    try
    {
      jqp.b(this.val$file, this.val$file.getParent() + File.separator);
      label166:
      return;
    }
    catch (Exception paramaquz)
    {
      paramaquz = paramaquz;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error  error->" + paramaquz.getMessage());
      }
      try
      {
        this.val$file.delete();
        return;
      }
      catch (Exception paramaquz)
      {
        return;
      }
    }
    catch (OutOfMemoryError paramaquz)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + paramaquz.getMessage());
      }
      try
      {
        this.val$file.delete();
        return;
      }
      catch (Exception paramaquz)
      {
        return;
      }
    }
    finally
    {
      try
      {
        this.val$file.delete();
        throw paramaquz;
      }
      catch (Exception localException)
      {
        break label166;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abts
 * JD-Core Version:    0.7.0.1
 */