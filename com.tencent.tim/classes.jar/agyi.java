import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public abstract interface agyi
{
  public abstract void N(Bitmap paramBitmap);
  
  public abstract agyi.a a();
  
  public abstract FileManagerEntity a();
  
  public abstract boolean a(Bitmap paramBitmap, int paramInt, String paramString);
  
  public abstract void dkF();
  
  public abstract void dkG();
  
  public abstract BaseActivity e();
  
  public abstract String getFileName();
  
  public abstract String getFilePath();
  
  public abstract long getFileSize();
  
  public abstract int getFileType();
  
  public abstract String vS();
  
  public static final class a
  {
    String aRN;
    int cYT = 1;
    boolean cfR;
    boolean cfS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agyi
 * JD-Core Version:    0.7.0.1
 */