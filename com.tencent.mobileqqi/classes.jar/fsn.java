import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.BigEmoticonViewBinder;
import com.tencent.mobileqq.model.EmoticonManager;

public class fsn
  implements Runnable
{
  public fsn(BigEmoticonViewBinder paramBigEmoticonViewBinder) {}
  
  public void run()
  {
    ((EmoticonManager)BigEmoticonViewBinder.a(this.a).getManager(12)).a(this.a.a.epId, Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fsn
 * JD-Core Version:    0.7.0.1
 */