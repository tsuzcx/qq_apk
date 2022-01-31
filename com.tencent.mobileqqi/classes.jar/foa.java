import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.BigEmoticonViewBinder;
import com.tencent.mobileqq.model.EmoticonManager;

public class foa
  implements Runnable
{
  public foa(BigEmoticonViewBinder paramBigEmoticonViewBinder) {}
  
  public void run()
  {
    ((EmoticonManager)BigEmoticonViewBinder.a(this.a).getManager(12)).a(this.a.a.epId, Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     foa
 * JD-Core Version:    0.7.0.1
 */