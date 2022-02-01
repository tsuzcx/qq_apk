import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;

public class jxw
  implements ahal.a
{
  public jxw(VideoCoverView paramVideoCoverView) {}
  
  public void aD()
  {
    com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.acG = true;
    com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.isSelected = true;
    if (this.this$0.aEt == 5) {
      this.this$0.resumeVideo();
    }
    for (;;)
    {
      jxm.a().n(VideoCoverView.a(this.this$0).a.hT, this.this$0.UC, true);
      return;
      this.this$0.bJ(VideoCoverView.a(this.this$0));
    }
  }
  
  public void aE()
  {
    this.this$0.aEt = 6;
    com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.acG = false;
    com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.isSelected = true;
    this.this$0.updateView();
    jxm.a().n(VideoCoverView.a(this.this$0).a.hT, this.this$0.UC, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jxw
 * JD-Core Version:    0.7.0.1
 */