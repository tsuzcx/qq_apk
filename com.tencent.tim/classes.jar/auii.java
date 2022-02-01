import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.teamwork.PadInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class auii
  extends aulm
{
  auii(auif paramauif) {}
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, int paramInt3, int paramInt4, List<PadInfo> paramList)
  {
    if ((QLog.isColorLevel()) || (!paramBoolean1))
    {
      QLog.i("FileRecentListPresenter", 1, "isSuccess = " + paramBoolean1 + ",typePadList: " + paramInt1 + ",retCode: " + paramInt2 + ",isTimeStampChanged: " + paramBoolean2 + ",isEnd: " + paramBoolean3 + ",totalCount: " + paramInt3 + ",typeOperation: " + paramInt4);
      if ((paramList != null) && (paramList.size() != 0) && (auif.a(this.this$0).size() != 0)) {
        break label122;
      }
    }
    label122:
    PadInfo localPadInfo;
    do
    {
      return;
      while (!((Iterator)localObject).hasNext()) {
        localObject = paramList.iterator();
      }
      paramList = (PadInfo)((Iterator)localObject).next();
      localPadInfo = (PadInfo)auif.a(this.this$0).get(paramList.pad_url);
    } while ((localPadInfo == null) || (paramList.title.equals(localPadInfo.title)));
    if (QLog.isColorLevel()) {
      QLog.i("FileRecentListPresenter", 1, "onGetPadList. find a teamwork file name has change. oldFileName[" + localPadInfo.title + "] newFileName[" + paramList.title + "] fileUrl[" + localPadInfo.pad_url + "] fileId[" + localPadInfo.padId + "]");
    }
    Object localObject = this.this$0.q.obtainMessage(9);
    ((Message)localObject).obj = paramList;
    this.this$0.q.sendMessage((Message)localObject);
  }
  
  public void t(boolean paramBoolean, int paramInt, String paramString)
  {
    super.t(paramBoolean, paramInt, paramString);
    Message localMessage = this.this$0.q.obtainMessage(10);
    localMessage.obj = paramString;
    localMessage.arg1 = 0;
    this.this$0.q.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auii
 * JD-Core Version:    0.7.0.1
 */