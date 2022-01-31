import com.tencent.mobileqq.activity.aio.PokePanel.PokeData;
import com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class vdc
  implements Runnable
{
  public vdc(GivingHeartItemBuilder paramGivingHeartItemBuilder) {}
  
  public void run()
  {
    Object localObject = PokeItemHelper.a(this.a.b, GivingHeartItemBuilder.a(this.a));
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PokePanel.PokeData localPokeData = (PokePanel.PokeData)((Iterator)localObject).next();
        GivingHeartItemBuilder.a(this.a).put(Integer.valueOf(localPokeData.b), Integer.valueOf(localPokeData.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vdc
 * JD-Core Version:    0.7.0.1
 */