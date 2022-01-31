import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.widget.XListView.DrawFinishedListener;

public class vys
  implements XListView.DrawFinishedListener
{
  public vys(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void a()
  {
    if ((!this.a.ag) && (this.a.ah))
    {
      this.a.ag = true;
      PublicTracker.a("SUBSCRIPT_AIO_COST", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vys
 * JD-Core Version:    0.7.0.1
 */