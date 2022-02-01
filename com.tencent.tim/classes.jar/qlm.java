import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.qphone.base.util.QLog;

public class qlm
  implements qmc.c
{
  public qlm(TrimTextureVideoView paramTrimTextureVideoView) {}
  
  public boolean b(qmc paramqmc, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e(this.this$0.TAG, 2, "TrimTextureVideoView MediaPlayer onError==>what:" + paramInt1 + "|extra:" + paramInt2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qlm
 * JD-Core Version:    0.7.0.1
 */