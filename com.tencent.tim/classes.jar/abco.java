import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.weather.SessionClearFragment;
import com.tencent.mobileqq.activity.weather.SessionClearFragment.b;
import com.tencent.qphone.base.util.QLog;

public class abco
  implements aduk.a
{
  public abco(SessionClearFragment paramSessionClearFragment) {}
  
  public void b(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SessionClearFragment", 4, "mHeaderLoaderForTroop onFaceUpdate uin: " + paramString1 + " -- " + paramString2 + " head:" + paramBitmap);
    }
    SessionClearFragment.a(this.a).b(paramString1, paramBitmap, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abco
 * JD-Core Version:    0.7.0.1
 */