import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.musicgene.BitmapBlur;
import com.tencent.mobileqq.musicgene.MusicGeneWebViewPlugin;
import java.io.File;

public class dyt
  implements Runnable
{
  public dyt(MusicGeneWebViewPlugin paramMusicGeneWebViewPlugin, String paramString, File paramFile) {}
  
  public void run()
  {
    Object localObject1 = MusicGeneWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicGeneWebViewPlugin, this.jdField_a_of_type_JavaLangString);
    if (localObject1 != null)
    {
      Object localObject2 = BitmapBlur.a((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), true);
      MusicGeneWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicGeneWebViewPlugin, (Bitmap)localObject2);
      localObject1 = Message.obtain(MusicGeneWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicGeneWebViewPlugin));
      ((Message)localObject1).obj = localObject2;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("BUNDLE_KEY_FILE_PATH", this.jdField_a_of_type_JavaIoFile.getPath());
      ((Message)localObject1).setData((Bundle)localObject2);
      ((Message)localObject1).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dyt
 * JD-Core Version:    0.7.0.1
 */