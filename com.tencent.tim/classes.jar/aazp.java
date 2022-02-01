import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class aazp
  extends MqqHandler
{
  public aazp(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          QQToast.a(this.this$0, 2131720241, 0).show();
          return;
          String str = this.this$0.getString(2131720242);
          paramMessage = (String)paramMessage.obj;
          QQToast.a(this.this$0.mContext, 2, str + paramMessage, 0).show();
          aqhu.cn(this.this$0, paramMessage);
          return;
          paramMessage = aqha.a(this.this$0.mContext, 232, this.this$0.mContext.getResources().getString(2131720274), this.this$0.mContext.getResources().getString(2131720273), 2131720256, 2131718798, new aazq(this), new aazr(this));
          ShortVideoPlayActivity.a(this.this$0, paramMessage);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoPlayActivity", 2, "...mobile/none => wifi...");
          }
        } while ((this.this$0.fa == null) || (this.this$0.fa.get() == null));
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "...wifi/none => mobile...");
        }
        if (((this.this$0.fa != null) && (this.this$0.fa.get() != null)) && ((this.this$0.cmQ != 1) && (this.this$0.cmQ != 2))) {
          break;
        }
      } while (!this.this$0.isPlaying());
      this.this$0.pause();
      this.this$0.cAE();
      return;
    } while ((this.this$0.cmQ != 0) && (this.this$0.cmQ != 5));
    ShortVideoPlayActivity.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aazp
 * JD-Core Version:    0.7.0.1
 */