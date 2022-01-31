import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class zcd
  implements zao
{
  zcd(zby paramzby) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((!paramBoolean) || (paramArrayList == null))
    {
      this.a.a(alud.a(2131704264));
      QLog.w("EditVideoSmartMusicPart", 1, "extractFrame failed  data is null");
    }
    zby localzby;
    StringBuilder localStringBuilder;
    if (zby.a(this.a) != null)
    {
      localzby = this.a;
      localStringBuilder = new StringBuilder().append(alud.a(2131704150)).append(zby.a(this.a).a()).append("ms\n抽取图片数：");
      if (paramArrayList != null) {
        break label133;
      }
    }
    label133:
    for (int i = 0;; i = paramArrayList.size())
    {
      localzby.a(i + "\n抽帧字节数：" + zby.a(this.a).b() + "KB");
      zby.a(this.a, paramArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zcd
 * JD-Core Version:    0.7.0.1
 */