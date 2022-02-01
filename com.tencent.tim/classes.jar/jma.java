import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.qphone.base.util.QLog;

public class jma
  extends CountDownTimer
{
  Bitmap bL = null;
  int i = 1;
  Resources res = this.val$context.getResources();
  
  public jma(ChildLockCircle paramChildLockCircle, long paramLong1, long paramLong2, Context paramContext)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    ChildLockCircle.a(this.this$0, ChildLockCircle.b(this.this$0));
    ChildLockCircle.a(this.this$0, 0);
    this.this$0.postInvalidate();
    ChildLockCircle.a(this.this$0);
    if ((this.bL != null) && (!this.bL.isRecycled()))
    {
      this.bL.recycle();
      this.bL = null;
    }
    if (ChildLockCircle.a(this.this$0) != null)
    {
      ChildLockCircle.a(this.this$0).cancel();
      ChildLockCircle.a(this.this$0, null);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChildLockCircle", 2, "LockAnimation,CountDownTimer finish");
    }
  }
  
  public void onTick(long paramLong)
  {
    if (this.val$context != null)
    {
      this.bL = this.this$0.b(this.res, this.i);
      if (this.bL != null)
      {
        ChildLockCircle.a(this.this$0, this.bL);
        this.this$0.postInvalidate();
      }
      this.i += 1;
      if (QLog.isColorLevel()) {
        QLog.d("ChildLockCircle", 2, "LockAnimation, i[" + this.i + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jma
 * JD-Core Version:    0.7.0.1
 */