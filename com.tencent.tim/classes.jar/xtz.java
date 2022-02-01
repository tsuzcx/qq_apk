import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.ArrayList;

public class xtz
  implements agld
{
  public xtz(AIOImageProviderService paramAIOImageProviderService, agsw paramagsw, long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (this.this$0.c != null)
    {
      ArrayList localArrayList = paramSuperPlayerVideoInfo.getCookie();
      Bundle localBundle = new Bundle();
      localBundle.putString("savepath", paramSuperPlayerVideoInfo.getLocalSavePath());
      localBundle.putStringArrayList("cookies", localArrayList);
      localBundle.putString("contextid", this.a.ve());
      localBundle.putString("fileid", paramSuperPlayerVideoInfo.getFileId());
      this.this$0.c.a(this.val$id, this.bXb, this.val$type, this.a.vL(), paramSuperPlayerVideoInfo.getPlayUrls(), null, null, -1, localBundle);
    }
  }
  
  public void bp(int paramInt, String paramString)
  {
    if (this.this$0.c != null) {
      this.this$0.c.a(this.val$id, this.bXb, this.val$type, "I:E", new String[] { String.valueOf(paramInt), paramString }, null, null, -1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xtz
 * JD-Core Version:    0.7.0.1
 */