import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import com.tencent.biz.qqcircle.viewmodels.QCircleMessageNoticeViewModel.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class tzd
  extends tyz
{
  private static final String jdField_a_of_type_JavaLangString = tzd.class.getSimpleName();
  private MutableLiveData<trt> jdField_a_of_type_AndroidArchLifecycleMutableLiveData = new MutableLiveData();
  
  private void a(List<String> paramList, int paramInt)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder().append("setNoticeTipValue ");
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      QLog.e(str, 1, i + ", " + paramInt);
      paramList = new trt(paramList, paramInt);
      this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData.postValue(paramList);
      return;
    }
  }
  
  public MutableLiveData<trt> a()
  {
    return this.jdField_a_of_type_AndroidArchLifecycleMutableLiveData;
  }
  
  public void a(Context paramContext)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "pullLastestInfo");
    ThreadManager.getSubThreadHandler().post(new QCircleMessageNoticeViewModel.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzd
 * JD-Core Version:    0.7.0.1
 */