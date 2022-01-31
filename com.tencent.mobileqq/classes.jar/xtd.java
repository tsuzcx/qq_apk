import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IOnStopCompleteListener;

public class xtd
  implements IOnStopCompleteListener
{
  public xtd(QzDynamicVideoPreviewActivity paramQzDynamicVideoPreviewActivity) {}
  
  public void onStopComplete()
  {
    this.a.runOnUiThread(new xte(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xtd
 * JD-Core Version:    0.7.0.1
 */