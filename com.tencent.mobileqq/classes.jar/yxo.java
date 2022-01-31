import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class yxo
  implements yvz
{
  yxo(yxj paramyxj) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((!paramBoolean) || (paramArrayList == null))
    {
      this.a.a(alpo.a(2131704252));
      QLog.w("EditVideoSmartMusicPart", 1, "extractFrame failed  data is null");
    }
    yxj localyxj;
    StringBuilder localStringBuilder;
    if (yxj.a(this.a) != null)
    {
      localyxj = this.a;
      localStringBuilder = new StringBuilder().append(alpo.a(2131704138)).append(yxj.a(this.a).a()).append("ms\n抽取图片数：");
      if (paramArrayList != null) {
        break label133;
      }
    }
    label133:
    for (int i = 0;; i = paramArrayList.size())
    {
      localyxj.a(i + "\n抽帧字节数：" + yxj.a(this.a).b() + "KB");
      yxj.a(this.a, paramArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yxo
 * JD-Core Version:    0.7.0.1
 */