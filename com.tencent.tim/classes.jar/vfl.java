import com.tencent.mobileqq.activity.Leba;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class vfl
  extends accn
{
  public vfl(Leba paramLeba) {}
  
  protected void onGetWholePeopleVoteLebaSwitch(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.leba", 2, String.format(Locale.getDefault(), "onGetWholePeopleVoteLebaSwitch isSuc: %b cur: %b pre: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) }));
    }
    if ((paramBoolean1) && (paramBoolean2 != paramBoolean3)) {
      this.this$0.e.sendEmptyMessage(11340002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfl
 * JD-Core Version:    0.7.0.1
 */