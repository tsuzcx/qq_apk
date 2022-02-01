import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.QIMProviderContainerView;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView.a;

class axop
  implements DoodleEditView.a
{
  axop(axoo paramaxoo) {}
  
  public void a(ayoo.a parama)
  {
    this.b.b.setVisibility(8);
    axoo.a(this.b).setVisibility(8);
    axoo.a(this.b).setVisibility(8);
    if (this.b.aPn()) {
      axoo.a(this.b).setVisibility(8);
    }
    axoo.a(this.b).s(103, new Object[] { parama });
  }
  
  public void eNB()
  {
    if (this.b.busType != 14)
    {
      this.b.b.setVisibility(0);
      axoo.a(this.b).setVisibility(0);
      axoo.a(this.b).setVisibility(0);
      axoo.a(this.b).dLp();
      if ((!this.b.isRecording()) && (!axoo.a(this.b)))
      {
        axoo.a(this.b).setVisibility(0);
        if (this.b.aPn()) {
          axoo.a(this.b).setVisibility(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axop
 * JD-Core Version:    0.7.0.1
 */