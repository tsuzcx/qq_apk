import android.os.CountDownTimer;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout;
import com.tencent.qphone.base.util.QLog;

public class apjo
  extends CountDownTimer
{
  public apjo(ReciteRecordLayout paramReciteRecordLayout, long paramLong1, long paramLong2)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    this.this$0.cQW = false;
    if (this.this$0.isRecording())
    {
      this.this$0.eah();
      if (this.this$0.mActivity != null)
      {
        aqju localaqju = aqha.a(this.this$0.mActivity, 230).setMessage(2131699662).setNegativeButton(2131699698, new apjq(this)).setPositiveButton(2131699690, new apjp(this));
        localaqju.setCancelable(false);
        localaqju.show();
      }
    }
  }
  
  public void onTick(long paramLong)
  {
    int i = (int)(paramLong / 1000L);
    if (QLog.isColorLevel()) {
      QLog.d("ReciteRecordLayout", 2, "onTick remainSecond = " + i);
    }
    if (i == 5) {
      this.this$0.aaP.setText(2131699654);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apjo
 * JD-Core Version:    0.7.0.1
 */