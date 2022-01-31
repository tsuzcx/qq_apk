import com.tencent.mobileqq.activity.aio.item.MedalNewsItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.medalwall.MedalWallMng;

public class uyu
  implements Runnable
{
  public uyu(MedalNewsItemBuilder paramMedalNewsItemBuilder) {}
  
  public void run()
  {
    ((MedalWallMng)this.a.a.getManager(249)).a(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uyu
 * JD-Core Version:    0.7.0.1
 */