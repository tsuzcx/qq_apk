import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.video.FrameVideoHelper.a;
import java.util.ArrayList;

public final class axnc
  implements FrameVideoHelper.a
{
  public axnc(FrameVideoHelper paramFrameVideoHelper, FrameVideoHelper.a parama) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    axiy.i("AEEditorMusicHelper", "[extractFrameForSmartMusic], onResult(), isSuccess=" + paramBoolean + ", dataArray=" + paramArrayList + ", frameSize=" + paramLong);
    int i;
    if (this.b != null)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[extractFrameForSmartMusic], executeTime=").append(this.b.getExecuteTime()).append(", frameCount=");
      if (paramArrayList == null)
      {
        i = 0;
        axiy.d("AEEditorMusicHelper", i + ", size=" + this.b.eb() + "KB");
      }
    }
    else if (this.a != null)
    {
      if (paramArrayList != null) {
        break label169;
      }
    }
    label169:
    for (paramArrayList = null;; paramArrayList = new ArrayList(paramArrayList))
    {
      this.a.a(paramBoolean, paramArrayList, paramLong);
      if (this.b != null) {
        this.b.stop();
      }
      return;
      i = paramArrayList.size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axnc
 * JD-Core Version:    0.7.0.1
 */