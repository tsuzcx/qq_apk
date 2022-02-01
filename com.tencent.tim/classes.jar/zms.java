import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.activity.history.tendoc.TenDocMessageResultAdapter;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

class zms
  implements AdapterView.c
{
  zms(zmq paramzmq) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TenDocMessageSearchDialog", 2, "onItemClick, position = " + paramInt);
    }
    if ((zmq.a(this.a).getCount() <= 0) || (paramInt <= 0)) {
      return;
    }
    paramAdapterView = (zmc)zmq.a(this.a).getItem(paramInt - 1);
    if ((paramAdapterView != null) && (paramAdapterView.messageRecord != null))
    {
      paramAdapterView = paramAdapterView.messageRecord;
      QLog.d("TenDocMessageSearchDialog", 4, "jump to mr: " + paramAdapterView.msgseq + " " + paramAdapterView.shmsgseq);
      if (top.fs(this.a.sessionInfo.cZ)) {
        ChatHistoryBubbleListForTroopFragment.a((Activity)this.a.mContext, this.a.sessionInfo.aTl, paramAdapterView.shmsgseq, 0, 2);
      }
      for (;;)
      {
        anot.a(this.a.app, "dc00898", "", "", "0X800A175", "0X800A175", zmq.a(this.a), 0, "", "", "s_qq_history_tab", "");
        this.a.BM(true);
        return;
        ChatHistoryActivity.a((Activity)this.a.mContext, this.a.sessionInfo.aTl, this.a.sessionInfo.cZ, this.a.sessionInfo.Vx, paramAdapterView.time, paramAdapterView.shmsgseq, 0);
      }
    }
    QLog.e("TenDocMessageSearchDialog", 2, "null item: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zms
 * JD-Core Version:    0.7.0.1
 */