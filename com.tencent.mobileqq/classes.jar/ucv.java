import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.NativeVueLoaderManager;
import com.tencent.nativevue.NativeVueLogAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.utils.ViolaUtils;

public class ucv
  implements NativeVueLogAdapter
{
  public void logD(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeVueLoaderManager", 2, "[NativeVue Debug]: " + paramString);
    }
  }
  
  public void logE(String paramString)
  {
    QLog.e("NativeVueLoaderManager", 1, "[NativeVue Error]: " + paramString);
  }
  
  public void onNativeVueError(String paramString)
  {
    ViolaUtils.reportNVError(paramString, NativeVueLoaderManager.a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ucv
 * JD-Core Version:    0.7.0.1
 */