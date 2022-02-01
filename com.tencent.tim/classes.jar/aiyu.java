import android.os.Handler;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.7.1;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController.7.2;
import com.tencent.qphone.base.util.QLog;

public class aiyu
  implements aiyh.a
{
  aiyu(aiyr paramaiyr, long paramLong, int paramInt) {}
  
  public void e(aixt paramaixt)
  {
    long l1 = System.currentTimeMillis();
    long l2 = this.sb;
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewController", 2, "【magicface】 cost =" + (l1 - l2) + "ms");
    }
    boolean bool;
    if (this.val$type == 0)
    {
      bool = this.this$0.a.apR();
      this.this$0.a.LG(bool);
    }
    for (;;)
    {
      this.this$0.uiHandler.post(new MagicfaceViewController.7.1(this, paramaixt));
      return;
      bool = this.this$0.a.apS();
      this.this$0.a.LG(bool);
    }
  }
  
  public void f(aixt paramaixt)
  {
    this.this$0.uiHandler.post(new MagicfaceViewController.7.2(this, paramaixt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiyu
 * JD-Core Version:    0.7.0.1
 */