import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.app.TroopObserver;

public class dpf
  extends TroopObserver
{
  public dpf(TroopGagActivity paramTroopGagActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dpf
 * JD-Core Version:    0.7.0.1
 */