import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class vfo
  implements anwa.a
{
  public vfo(Leba paramLeba) {}
  
  public void onChange(boolean paramBoolean)
  {
    QLog.i("Q.lebatab.leba", 1, "StudyModeChange onChange " + paramBoolean);
    if (this.this$0.app.a() != null) {
      this.this$0.app.a().cJu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vfo
 * JD-Core Version:    0.7.0.1
 */