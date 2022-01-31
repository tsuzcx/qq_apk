import android.graphics.Bitmap;
import com.tencent.mobileqq.transfile.FileAssistantDownloader;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.net.URL;

public class ehb
  implements BitmapDecoder
{
  public ehb(FileAssistantDownloader paramFileAssistantDownloader) {}
  
  public Bitmap a(URL paramURL)
  {
    paramURL = this.a.a(paramURL);
    return FileAssistantDownloader.a(this.a, paramURL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ehb
 * JD-Core Version:    0.7.0.1
 */