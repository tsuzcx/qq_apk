import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.video.FrameVideoHelper.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class srx
  implements FrameVideoHelper.a
{
  srx(srs paramsrs) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    if ((!paramBoolean) || (paramArrayList == null))
    {
      this.this$0.tz(acfp.m(2131705646));
      QLog.w("EditVideoSmartMusicPart", 1, "extractFrame failed  data is null");
    }
    srs localsrs;
    StringBuilder localStringBuilder;
    if (srs.a(this.this$0) != null)
    {
      localsrs = this.this$0;
      localStringBuilder = new StringBuilder().append(acfp.m(2131705532)).append(srs.a(this.this$0).getExecuteTime()).append("ms\n抽取图片数：");
      if (paramArrayList != null) {
        break label133;
      }
    }
    label133:
    for (int i = 0;; i = paramArrayList.size())
    {
      localsrs.tz(i + "\n抽帧字节数：" + srs.a(this.this$0).eb() + "KB");
      srs.a(this.this$0, paramArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     srx
 * JD-Core Version:    0.7.0.1
 */