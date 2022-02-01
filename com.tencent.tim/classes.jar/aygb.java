import dov.com.qq.im.capture.view.ProviderViewEditContainer;
import dov.com.qq.im.capture.view.VideoSegmentPickerProviderView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView.a;

class aygb
  implements DoodleEditView.a
{
  aygb(ayfw paramayfw) {}
  
  public void a(ayoo.a parama)
  {
    if ((this.this$0.b.RP() != 0) && (aygz.r(ayfw.a(this.this$0), 134217728)))
    {
      VideoSegmentPickerProviderView localVideoSegmentPickerProviderView = (VideoSegmentPickerProviderView)this.this$0.a.a(111);
      if (localVideoSegmentPickerProviderView != null)
      {
        aydt localaydt = (aydt)this.this$0.a(aydt.class);
        if (localaydt != null)
        {
          localVideoSegmentPickerProviderView.setPlayMode(localaydt.getPlayMode());
          localaydt.aQt();
          localaydt.pausePlay();
        }
      }
      this.this$0.a.s(111, new Object[] { parama });
      if (this.this$0.b.bqq == 0) {
        this.this$0.b.changeState(36);
      }
    }
    do
    {
      return;
      this.this$0.a.s(103, new Object[] { parama });
    } while (this.this$0.b.bqq != 0);
    this.this$0.b.changeState(27);
  }
  
  public void eNB()
  {
    this.this$0.a.dLp();
    if (this.this$0.b.bqq == 27) {
      this.this$0.b.changeState(0);
    }
    if (this.this$0.b.bqq == 36)
    {
      aydt localaydt = (aydt)this.this$0.a(aydt.class);
      if (localaydt != null) {
        localaydt.resumePlay();
      }
      this.this$0.b.changeState(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aygb
 * JD-Core Version:    0.7.0.1
 */