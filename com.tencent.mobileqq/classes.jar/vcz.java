import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;

public final class vcz
  implements Runnable
{
  public vcz(int paramInt) {}
  
  public void run()
  {
    HapticManager.a().a(String.valueOf(this.a), PokeItemHelper.e + this.a + "/" + this.a + ".hapt");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vcz
 * JD-Core Version:    0.7.0.1
 */