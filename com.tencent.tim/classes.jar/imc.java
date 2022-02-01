import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import mqq.app.BaseActivity;

public class imc
{
  private Runnable bk;
  
  public void a(VideoAppInterface paramVideoAppInterface, VideoController paramVideoController)
  {
    if ((paramVideoAppInterface == null) || (paramVideoController == null)) {}
    do
    {
      return;
      paramVideoController = paramVideoController.a();
    } while ((this.bk == null) || (paramVideoController == null));
    paramVideoController.a(this.bk, paramVideoAppInterface);
    this.bk = null;
  }
  
  public void a(BaseActivity paramBaseActivity, VideoAppInterface paramVideoAppInterface, VideoController paramVideoController)
  {
    if ((paramBaseActivity == null) || (paramVideoAppInterface == null) || (paramVideoController == null)) {}
    do
    {
      return;
      paramVideoController = paramVideoController.a();
    } while (paramVideoController == null);
    this.bk = paramVideoController.a(paramBaseActivity, paramVideoAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     imc
 * JD-Core Version:    0.7.0.1
 */