import com.tencent.mobileqq.activity.richmedia.QzDynamicVideoPreviewActivity;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IOnStopCompleteListener;

public class xzl
  implements IOnStopCompleteListener
{
  public xzl(QzDynamicVideoPreviewActivity paramQzDynamicVideoPreviewActivity) {}
  
  public void onStopComplete()
  {
    this.a.runOnUiThread(new xzm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xzl
 * JD-Core Version:    0.7.0.1
 */