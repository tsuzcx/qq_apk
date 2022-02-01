import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.NeoVideoFilterPlayView;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.NeoVideoFilterPlayView.a;
import com.tencent.qphone.base.util.QLog;

public class rep
  extends NeoVideoFilterPlayView.a
{
  public rep(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void btC()
  {
    super.btC();
    this.this$0.a.dMd();
    this.this$0.onDecodeRepeat();
  }
  
  public void ed(int paramInt1, int paramInt2)
  {
    super.ed(paramInt1, paramInt2);
  }
  
  public void fq(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "onPlayFrame");
    }
    super.fq(paramLong);
    try
    {
      this.this$0.fp(1000L * paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rep
 * JD-Core Version:    0.7.0.1
 */