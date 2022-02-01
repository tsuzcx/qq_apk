import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class qkd
  extends SimpleJob<Object>
{
  public qkd(VideoViewVideoHolder paramVideoViewVideoHolder, String paramString1, boolean paramBoolean1, int paramInt1, Long paramLong, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, int paramInt5, int paramInt6, int paramInt7, qle.a parama, long paramLong1, String paramString4, String paramString5)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    int i = 0;
    paramJobContext = "0";
    int j;
    if (this.val$isLoading)
    {
      j = 200;
      i = this.bmL;
      paramVarArgs = String.valueOf(i) + "*";
      paramJobContext = paramVarArgs;
      i = j;
      if (this.L != null)
      {
        paramJobContext = paramVarArgs + String.valueOf(SystemClock.uptimeMillis() - this.L.longValue());
        i = j;
      }
      if ((i != 0) && (i != 7) && ((i != 200) || (this.bmL < 6) || (this.bmL > 10))) {
        break label509;
      }
      if (this.bmO != 1) {
        break label503;
      }
      paramVarArgs = "1";
      label138:
      if ((!TextUtils.equals(this.axE, this.axF)) || (i == 0)) {
        break label532;
      }
      ram.w(this.this$0.TAG, "reportDevPlayerDone, errorCode=%d, suError=%s => treat as success => 300", new Object[] { Integer.valueOf(i), paramJobContext });
      j = 300;
      String str = String.valueOf(i) + "*";
      paramJobContext = str + paramJobContext;
    }
    for (;;)
    {
      rar.b("play_video", "play_result", this.bmP, j, new String[] { paramJobContext, paramVarArgs, rar.getNetworkType(this.this$0.n()), this.axF });
      rar.b("play_video", "play_buffering", this.bmP, j, new String[] { String.valueOf(this.bmQ), String.valueOf(this.bmR), rar.getNetworkType(this.this$0.n()), this.axF });
      if (this.b.fileSize > 0L) {
        rar.b("play_video", "play_bitRate", this.bmP, j, new String[] { paramJobContext, this.b.toString(), rar.getNetworkType(this.this$0.n()), this.axF });
      }
      if (this.val$isLoading) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          long l = 0L;
          if (this.AT != 0L) {
            l = SystemClock.uptimeMillis() - this.AT;
          }
          rar.b("sdk_download_video", "video_download_error", this.bmP, j, new String[] { this.axG, this.axH, String.valueOf(i), String.valueOf(l) });
        }
        return null;
        if (!this.val$isError) {
          break;
        }
        i = this.bmM;
        paramJobContext = String.valueOf(this.bmN);
        break;
        label503:
        paramVarArgs = "2";
        break label138;
        label509:
        paramVarArgs = "0";
        break label138;
        if (this.val$isError) {
          i = 2;
        } else {
          i = 0;
        }
      }
      label532:
      j = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qkd
 * JD-Core Version:    0.7.0.1
 */