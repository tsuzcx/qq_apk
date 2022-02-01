import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import com.tencent.biz.qqcircle.viewmodels.QCircleMessageNoticeViewModel.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class pea
  extends rxi
{
  private MutableLiveData<ovy> q = new MutableLiveData();
  
  private void y(List<String> paramList, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("setNoticeTipValue ");
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      QLog.e("QCircleMessageNoticeViewModel", 1, i + ", " + paramInt);
      paramList = new ovy(paramList, paramInt);
      this.q.postValue(paramList);
      return;
    }
  }
  
  public void cw(Context paramContext)
  {
    QLog.i("QCircleMessageNoticeViewModel", 1, "pullLastestInfo");
    ThreadManager.getSubThreadHandler().post(new QCircleMessageNoticeViewModel.1(this));
  }
  
  public String getLogTag()
  {
    return "QCircleMessageNoticeViewModel";
  }
  
  public MutableLiveData<ovy> n()
  {
    return this.q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pea
 * JD-Core Version:    0.7.0.1
 */