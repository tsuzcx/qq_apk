import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IOnStopCompleteListener;

public class xpx
  implements IOnStopCompleteListener
{
  public xpx(QzDynamicVideoPreviewActivity paramQzDynamicVideoPreviewActivity) {}
  
  public void onStopComplete()
  {
    this.a.runOnUiThread(new xpy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xpx
 * JD-Core Version:    0.7.0.1
 */