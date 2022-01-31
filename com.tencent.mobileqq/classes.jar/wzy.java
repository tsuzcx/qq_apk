import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class wzy
  implements wyj
{
  wzy(wzt paramwzt) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((!paramBoolean) || (paramArrayList == null))
    {
      this.a.a(ajjy.a(2131638084));
      QLog.w("EditVideoSmartMusicPart", 1, "extractFrame failed  data is null");
    }
    wzt localwzt;
    StringBuilder localStringBuilder;
    if (wzt.a(this.a) != null)
    {
      localwzt = this.a;
      localStringBuilder = new StringBuilder().append(ajjy.a(2131637970)).append(wzt.a(this.a).a()).append("ms\n抽取图片数：");
      if (paramArrayList != null) {
        break label133;
      }
    }
    label133:
    for (int i = 0;; i = paramArrayList.size())
    {
      localwzt.a(i + "\n抽帧字节数：" + wzt.a(this.a).b() + "KB");
      wzt.a(this.a, paramArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzy
 * JD-Core Version:    0.7.0.1
 */