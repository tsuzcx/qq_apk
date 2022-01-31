import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.SharedPreUtils;
import java.util.HashMap;

public class zxd
  implements Runnable
{
  public zxd(ARDeviceController paramARDeviceController, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", String.valueOf(this.jdField_a_of_type_Int));
    StatisticCollector.a(BaseApplication.getContext()).a(null, "AREnable", this.jdField_a_of_type_Boolean, 0L, 0L, (HashMap)localObject, null);
    localObject = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("ar_incompatible_reason", this.jdField_a_of_type_Int);
    SharedPreUtils.a((SharedPreferences.Editor)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zxd
 * JD-Core Version:    0.7.0.1
 */