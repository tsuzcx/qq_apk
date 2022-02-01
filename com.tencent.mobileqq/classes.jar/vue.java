import com.tencent.biz.qqcircle.list.bizblocks.QCircleChatBoxHelper;
import com.tencent.biz.qqcircle.viewmodels.QCircleMessageNoticeViewModel.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.List;

public class vue
  implements vqv
{
  public vue(QCircleMessageNoticeViewModel.1 param1) {}
  
  public void a(List<String> paramList, int paramInt)
  {
    if (this.a.a != null) {
      QLog.d("QCircleMessageNoticeViewModel", 1, "getChatUnReadInfo currentTime:" + System.currentTimeMillis());
    }
    for (Pair localPair = QCircleChatBoxHelper.getInstance().getUnReadInfo();; localPair = null)
    {
      if (localPair != null)
      {
        QLog.d("QCircleMessageNoticeViewModel", 1, "chatUnReadInfo not null currentTime:" + System.currentTimeMillis());
        vud.a(this.a.this$0, paramList, paramInt, (List)localPair.second, ((Integer)localPair.first).intValue());
        return;
      }
      QLog.d("QCircleMessageNoticeViewModel", 1, "chatUnReadInfo is null currentTime:" + System.currentTimeMillis());
      vud.a(this.a.this$0, paramList, paramInt, new ArrayList(), 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vue
 * JD-Core Version:    0.7.0.1
 */