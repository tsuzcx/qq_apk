import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment;
import com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahor
  implements View.OnClickListener
{
  public ahor(SDKSetEmotionPreviewFragment.a parama, String paramString, View paramView) {}
  
  public void onClick(View paramView)
  {
    SDKSetEmotionPreviewFragment.a(this.val$filePath, this.b.a.getActivity(), this.Dx);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahor
 * JD-Core Version:    0.7.0.1
 */