import android.app.Activity;
import com.tencent.biz.addContactTroopView.AddContactTroopHandler.IGetPopClassAndSearchCB;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.IAddContactContext;
import com.tencent.mobileqq.activity.contact.addcontact.TroopView;

public class wgc
  implements AddContactTroopHandler.IGetPopClassAndSearchCB
{
  public wgc(TroopView paramTroopView) {}
  
  public void a()
  {
    if ((this.a.a == null) || (this.a.a.a() == null) || (this.a.a.a().isFinishing())) {
      return;
    }
    TroopView.b(this.a, true);
    TroopView.c(this.a, true);
    TroopView.a(this.a).sendEmptyMessage(4);
  }
  
  public void b()
  {
    if ((this.a.a == null) || (this.a.a.a() == null) || (this.a.a.a().isFinishing())) {
      return;
    }
    TroopView.b(this.a, true);
    TroopView.c(this.a, false);
    TroopView.a(this.a).sendEmptyMessage(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wgc
 * JD-Core Version:    0.7.0.1
 */