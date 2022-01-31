import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class xiv
  implements xhg
{
  xiv(xiq paramxiq) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((!paramBoolean) || (paramArrayList == null))
    {
      this.a.a(ajya.a(2131703880));
      QLog.w("EditVideoSmartMusicPart", 1, "extractFrame failed  data is null");
    }
    xiq localxiq;
    StringBuilder localStringBuilder;
    if (xiq.a(this.a) != null)
    {
      localxiq = this.a;
      localStringBuilder = new StringBuilder().append(ajya.a(2131703766)).append(xiq.a(this.a).a()).append("ms\n抽取图片数：");
      if (paramArrayList != null) {
        break label133;
      }
    }
    label133:
    for (int i = 0;; i = paramArrayList.size())
    {
      localxiq.a(i + "\n抽帧字节数：" + xiq.a(this.a).b() + "KB");
      xiq.a(this.a, paramArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xiv
 * JD-Core Version:    0.7.0.1
 */