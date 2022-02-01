import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
public class png
{
  public long Af;
  public long Ag;
  public pnb.a a;
  public pnb.d a;
  public boolean aAK;
  public boolean aAL;
  public boolean aAM;
  public String atT;
  public int bjt;
  public int bju = -1;
  public aoll c;
  public int compressLevel;
  public MessageForShortVideo d;
  public String downloadKey;
  public String downloadUrl;
  public Map<String, Object> fD = new HashMap();
  public int fileType;
  public String localPath;
  public String originalUrl;
  public int priority = 1;
  public int retryTime;
  public int status;
  public String vid;
  
  public static png a(String paramString, int paramInt)
  {
    return a(paramString, null, paramInt, false);
  }
  
  public static png a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, null, paramInt, paramBoolean);
  }
  
  private static png a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    png localpng = new png();
    StoryVideoItem localStoryVideoItem = ((psu)psx.a(5)).a(paramString1);
    if ((localStoryVideoItem != null) && (localStoryVideoItem.isMine()))
    {
      localpng.localPath = pnh.a(paramString1, localStoryVideoItem.mCreateTime, paramInt, false, false);
      localpng.atT = pnh.a(paramString1, localStoryVideoItem.mCreateTime, paramInt, true, false);
      localpng.status = 0;
      localpng.vid = paramString1;
      localpng.fileType = paramInt;
      localpng.downloadKey = makeKey(paramString1, paramInt);
      if (!paramBoolean) {
        break label159;
      }
    }
    label159:
    for (paramString1 = "";; paramString1 = paramString2)
    {
      localpng.originalUrl = paramString1;
      if (paramBoolean) {
        paramString2 = "";
      }
      localpng.downloadUrl = paramString2;
      localpng.aAM = paramBoolean;
      return localpng;
      localpng.localPath = pnh.b(paramString1, paramInt, false, false);
      localpng.atT = pnh.b(paramString1, paramInt, true, false);
      break;
    }
  }
  
  public static String makeKey(String paramString, int paramInt)
  {
    return paramInt + "_" + paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof png))
    {
      paramObject = (png)paramObject;
      if (TextUtils.equals(this.downloadKey, paramObject.downloadKey)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return "DownloadTask{vid='" + this.vid + '\'' + ", fileType=" + plr.bR(this.fileType) + ", status=" + this.status + ", downloadUrl='" + this.downloadUrl + '\'' + ", localPath='" + this.localPath + '\'' + ", localTmpPath='" + this.atT + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     png
 * JD-Core Version:    0.7.0.1
 */