import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

class zlp
  implements AdapterView.c
{
  zlp(zli paramzli) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "onItemClick, position = " + paramInt);
    }
    if ((this.c.a.getCount() <= 0) || (paramInt <= 0)) {}
    do
    {
      return;
      paramAdapterView = (zmc)this.c.a.getItem(paramInt - 1);
    } while (paramAdapterView == null);
    this.c.o = paramAdapterView.messageRecord;
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "onItemClick, mRecordCount = " + this.c.cdF + ",needSearchInCloud:" + this.c.brB);
    }
    ChatHistoryActivity.a((Activity)this.c.mContext, this.c.sessionInfo.aTl, this.c.sessionInfo.cZ, this.c.sessionInfo.Vx, this.c.o.time, this.c.o.shmsgseq, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zlp
 * JD-Core Version:    0.7.0.1
 */