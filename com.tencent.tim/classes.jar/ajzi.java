import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qphone.base.util.QLog;

class ajzi
  extends Handler
{
  ajzi(ajzh paramajzh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (this.a.jdField_a_of_type_Ajzp != null)
      {
        int i = this.a.jdField_a_of_type_Ajzp.getProgress();
        this.a.jdField_a_of_type_Ajzh$a.RF(i);
        if (QLog.isColorLevel()) {
          QLog.d("VideoPlayerView", 2, "PROGRESS_MSG :" + i);
        }
      }
      this.a.mHandler.sendEmptyMessageDelayed(2025, 100L);
      return;
      if ((this.a.Bt != null) && (this.a.Bt.getParent() != null) && (((ViewGroup)this.a.Bt.getParent()).getChildAt(0) != this.a.Bt))
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoPlayerView", 2, "UPDATE_COVER  mPlayer.getCurrentPosition()=" + this.a.jdField_a_of_type_Ajzp.getCurrentPosition());
        }
        ((ViewGroup)this.a.Bt.getParent()).removeView(this.a.Bt);
        ajzh.a(this.a).addView(this.a.Bt, 0, new RelativeLayout.LayoutParams(-1, -1));
        ajzh.a(this.a).requestLayout();
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i("VideoPlayerView", 2, "UPDATE_COVER  2do nothing()=");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajzi
 * JD-Core Version:    0.7.0.1
 */