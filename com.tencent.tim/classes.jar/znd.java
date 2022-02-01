import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

class znd
  implements AdapterView.c
{
  znd(zmw paramzmw) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onItemClick, position = " + paramInt);
    }
    if ((this.c.a.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return;
      paramAdapterView = (zmc)this.c.a.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.c.o = paramAdapterView.messageRecord;
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "onItemClick, mRecordCount = " + this.c.cdF + ",needSearchInCloud:" + this.c.brB);
    }
    paramView = this.c.sessionInfo.aTl;
    ChatHistoryBubbleListForTroopFragment.a((Activity)this.c.mContext, paramView, paramAdapterView.messageRecord.shmsgseq, -1, 2);
    this.c.BM(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     znd
 * JD-Core Version:    0.7.0.1
 */