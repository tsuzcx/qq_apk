import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.app.TroopObserver;

public class dpe
  extends TroopObserver
{
  public dpe(TroopGagActivity paramTroopGagActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dpe
 * JD-Core Version:    0.7.0.1
 */