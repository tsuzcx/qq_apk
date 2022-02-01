import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import com.tencent.biz.qqcircle.viewmodels.QCircleMessageNoticeViewModel.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class vxc
  extends aabb
{
  private MutableLiveData<vbb> a = new MutableLiveData();
  
  private void a(List<String> paramList1, int paramInt1, List<String> paramList2, int paramInt2)
  {
    Object localObject = new StringBuilder().append("setNoticeTipValue ");
    int i;
    StringBuilder localStringBuilder;
    if (paramList1 == null)
    {
      i = 0;
      localStringBuilder = ((StringBuilder)localObject).append(i).append(", messageUnRead:").append(paramInt1).append(" chatUinList");
      if (paramList2 != null) {
        break label103;
      }
    }
    label103:
    for (localObject = Integer.valueOf(0);; localObject = paramList2.size() + ", chatUnReadNum:" + paramInt2)
    {
      QLog.d("QCircleMessageNoticeViewModel", 1, localObject);
      paramList1 = new vbb(paramList1, paramInt1, paramList2, paramInt2);
      this.a.postValue(paramList1);
      return;
      i = paramList1.size();
      break;
    }
  }
  
  public MutableLiveData<vbb> a()
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
    ThreadManager.getSubThreadHandler().post(new QCircleMessageNoticeViewModel.1(this, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxc
 * JD-Core Version:    0.7.0.1
 */