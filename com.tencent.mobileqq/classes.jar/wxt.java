import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.NeoVideoFilterPlayView;
import com.tencent.qphone.base.util.QLog;

public class wxt
  extends axqo
{
  public wxt(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void a()
  {
    super.a();
    this.a.a.n();
    this.a.l();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "onPlayFrame");
    }
    super.a(paramLong);
    try
    {
      this.a.a(1000L * paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wxt
 * JD-Core Version:    0.7.0.1
 */