import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class gsi
  implements Runnable
{
  public gsi(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void run()
  {
    if (this.a.a == null) {
      this.a.a = new QQProgressDialog(this.a, this.a.d());
    }
    this.a.a.b(2131560736);
    this.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gsi
 * JD-Core Version:    0.7.0.1
 */