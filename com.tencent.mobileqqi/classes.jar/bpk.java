import android.text.TextUtils;
import com.tencent.biz.common.util.LoadedBack;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.qphone.base.util.QLog;

public class bpk
  implements LoadedBack
{
  public bpk(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void a(int paramInt)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("forceUpdate", 2, "loaded code:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.b = this.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.notifyCacheReady(paramInt);
  }
  
  public void b(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bpk
 * JD-Core Version:    0.7.0.1
 */