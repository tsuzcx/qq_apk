import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.activity.Leba.30.1;
import com.tencent.qphone.base.util.QLog;

public class vfh
  extends acyz
{
  public vfh(Leba paramLeba) {}
  
  public void g(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, "onReadInJoyNotifyRedTouchUpdate, isSuccess=" + paramBoolean1 + ",isUpdate=" + paramBoolean2 + ", type=" + paramInt);
    }
    if ((paramBoolean1) && (paramBoolean2) && ((paramInt & 0x1) != 0)) {
      this.this$0.runOnUiThread(new Leba.30.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfh
 * JD-Core Version:    0.7.0.1
 */