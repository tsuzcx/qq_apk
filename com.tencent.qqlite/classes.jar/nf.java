import android.text.TextUtils;
import com.tencent.biz.common.util.LoadedBack;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.qphone.base.util.QLog;

public class nf
  implements LoadedBack
{
  public nf(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     nf
 * JD-Core Version:    0.7.0.1
 */