import com.tencent.mobileqq.activity.Leba;
import com.tencent.qphone.base.util.QLog;

public class vfm
  extends afsr
{
  public vfm(Leba paramLeba) {}
  
  protected void Be(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.lebatab.leba", 2, "onUpdateRedPoint " + paramInt);
    }
    if (Leba.a(this.this$0) != null) {
      Leba.a(this.this$0).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfm
 * JD-Core Version:    0.7.0.1
 */