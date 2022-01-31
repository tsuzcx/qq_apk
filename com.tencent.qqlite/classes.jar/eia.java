import android.graphics.Bitmap;
import com.tencent.mobileqq.transfile.DataLineDownloader;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.net.URL;

public class eia
  implements BitmapDecoder
{
  public ehz a;
  
  public eia(DataLineDownloader paramDataLineDownloader) {}
  
  public Bitmap a(URL paramURL)
  {
    this.jdField_a_of_type_Ehz = this.jdField_a_of_type_ComTencentMobileqqTransfileDataLineDownloader.a(paramURL);
    return DataLineDownloader.a(this.jdField_a_of_type_ComTencentMobileqqTransfileDataLineDownloader, this.jdField_a_of_type_Ehz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eia
 * JD-Core Version:    0.7.0.1
 */