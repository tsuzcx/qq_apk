import android.os.Handler;
import android.os.Looper;
import com.tencent.cloudfile.CloudFileCallbackCenter;
import com.tencent.cloudfile.CloudUploadFile;
import com.tencent.tim.filemanager.core.WpsFileEditUploader.1.1;
import com.tencent.tim.filemanager.core.WpsFileEditUploader.1.2;
import com.tencent.tim.filemanager.core.WpsFileEditUploader.1.3;
import com.tencent.tim.filemanager.core.WpsFileEditUploader.1.4;

public class atvv
  extends CloudFileCallbackCenter
{
  atvv(atvu paramatvu) {}
  
  public void onDeleteUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new WpsFileEditUploader.1.4(this, paramArrayOfByte, paramLong, paramInt2, paramString));
      return;
    }
    atvu.c(this.b, paramArrayOfByte, paramLong, paramInt2, paramString);
  }
  
  public void onStartUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString, CloudUploadFile paramCloudUploadFile)
  {
    paramCloudUploadFile = Looper.getMainLooper();
    if (Thread.currentThread() != paramCloudUploadFile.getThread())
    {
      new Handler(paramCloudUploadFile).post(new WpsFileEditUploader.1.1(this, paramArrayOfByte, paramLong, paramInt2, paramString));
      return;
    }
    atvu.a(this.b, paramArrayOfByte, paramLong, paramInt2, paramString);
  }
  
  public void onStopUpload(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new WpsFileEditUploader.1.2(this, paramArrayOfByte, paramLong, paramInt2, paramString));
      return;
    }
    atvu.b(this.b, paramArrayOfByte, paramLong, paramInt2, paramString);
  }
  
  public void onUploadComplete(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, String paramString, CloudUploadFile paramCloudUploadFile)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new WpsFileEditUploader.1.3(this, paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString, paramCloudUploadFile));
      return;
    }
    atvu.a(this.b, paramArrayOfByte, paramLong, paramInt1, paramInt2, paramString, paramCloudUploadFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvv
 * JD-Core Version:    0.7.0.1
 */