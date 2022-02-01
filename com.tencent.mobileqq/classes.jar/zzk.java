import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class zzk
  implements zxu
{
  zzk(zzf paramzzf) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((!paramBoolean) || (paramArrayList == null))
    {
      this.a.a(amtj.a(2131703000));
      QLog.w("EditVideoSmartMusicPart", 1, "extractFrame failed  data is null");
    }
    zzf localzzf;
    StringBuilder localStringBuilder;
    if (zzf.a(this.a) != null)
    {
      localzzf = this.a;
      localStringBuilder = new StringBuilder().append(amtj.a(2131702889)).append(zzf.a(this.a).a()).append("ms\n抽取图片数：");
      if (paramArrayList != null) {
        break label133;
      }
    }
    label133:
    for (int i = 0;; i = paramArrayList.size())
    {
      localzzf.a(i + "\n抽帧字节数：" + zzf.a(this.a).b() + "KB");
      zzf.a(this.a, paramArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzk
 * JD-Core Version:    0.7.0.1
 */