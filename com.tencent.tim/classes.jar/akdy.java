import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class akdy
  implements ahcj.b
{
  akdy(akcx paramakcx, String paramString) {}
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    QLog.i("NearbyProfileDisplayPanel", 1, "onDownloadSucess() called with: filePath = [" + paramString + "], fileSize = [" + paramLong + "], extData = [" + paramBundle + "]");
    paramBundle = BaseApplicationImpl.getContext().getSharedPreferences(this.bgb, 4);
    paramBundle.edit().putInt("state", 1);
    paramBundle.edit().putString("filePath", paramString);
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle) {}
  
  public void p(int paramInt, Bundle paramBundle) {}
  
  public void q(int paramInt, Bundle paramBundle) {}
  
  public void r(int paramInt, Bundle paramBundle) {}
  
  public void s(int paramInt, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akdy
 * JD-Core Version:    0.7.0.1
 */