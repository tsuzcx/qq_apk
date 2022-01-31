import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.app.TroopObserver;

public class bms
  extends TroopObserver
{
  public bms(TroopGagActivity paramTroopGagActivity) {}
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bms
 * JD-Core Version:    0.7.0.1
 */