import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class xiy
  implements xhj
{
  xiy(xit paramxit) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((!paramBoolean) || (paramArrayList == null))
    {
      this.a.a(ajyc.a(2131703869));
      QLog.w("EditVideoSmartMusicPart", 1, "extractFrame failed  data is null");
    }
    xit localxit;
    StringBuilder localStringBuilder;
    if (xit.a(this.a) != null)
    {
      localxit = this.a;
      localStringBuilder = new StringBuilder().append(ajyc.a(2131703755)).append(xit.a(this.a).a()).append("ms\n抽取图片数：");
      if (paramArrayList != null) {
        break label133;
      }
    }
    label133:
    for (int i = 0;; i = paramArrayList.size())
    {
      localxit.a(i + "\n抽帧字节数：" + xit.a(this.a).b() + "KB");
      xit.a(this.a, paramArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xiy
 * JD-Core Version:    0.7.0.1
 */