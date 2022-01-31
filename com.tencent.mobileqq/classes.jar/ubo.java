import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import com.tencent.biz.qqcircle.viewmodels.QCircleMessageNoticeViewModel.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class ubo
  extends ubk
{
  private MutableLiveData<try> a = new MutableLiveData();
  
  private void a(List<String> paramList, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setNoticeTipValue ");
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      QLog.e("QCircleMessageNoticeViewModel", 1, i + ", " + paramInt);
      paramList = new try(paramList, paramInt);
      this.a.postValue(paramList);
      return;
    }
  }
  
  public MutableLiveData<try> a()
  {
    return this.a;
  }
  
  public String a()
  {
    return "QCircleMessageNoticeViewModel";
  }
  
  public void a(Context paramContext)
  {
    QLog.i("QCircleMessageNoticeViewModel", 1, "pullLastestInfo");
    ThreadManager.getSubThreadHandler().post(new QCircleMessageNoticeViewModel.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubo
 * JD-Core Version:    0.7.0.1
 */