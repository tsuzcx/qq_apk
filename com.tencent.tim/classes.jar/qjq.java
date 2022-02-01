import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class qjq
{
  private String axz;
  private ErrorMessage e;
  public final String feedId;
  public puh h;
  @NonNull
  public final String vid;
  
  public qjq(@NonNull String paramString1, @NonNull String paramString2)
  {
    this.vid = paramString1;
    this.feedId = paramString2;
  }
  
  public static qjq a(String paramString1, String paramString2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramString1 != null) {
      if (paramString2 == null) {
        break label31;
      }
    }
    for (;;)
    {
      paramString1 = new qjq(paramString1, paramString2);
      paramString1.e = paramErrorMessage;
      return paramString1;
      paramString1 = "ERROR_NO_VID";
      break;
      label31:
      paramString2 = "ERROR_NO_FEED";
    }
  }
  
  public static qjq a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 != null) {
      if (paramString2 == null) {
        break label31;
      }
    }
    for (;;)
    {
      paramString1 = new qjq(paramString1, paramString2);
      paramString1.axz = paramString3;
      return paramString1;
      paramString1 = "LOADING_NO_VID";
      break;
      label31:
      paramString2 = "LOADING_NO_FEED";
    }
  }
  
  public boolean JK()
  {
    return this.axz != null;
  }
  
  public boolean JL()
  {
    return this.e != null;
  }
  
  public boolean JM()
  {
    return (!JK()) && (!JL());
  }
  
  public VideoListFeedItem a()
  {
    if (TextUtils.isEmpty(this.feedId)) {
      return null;
    }
    FeedItem localFeedItem = ((qvf)psx.a(11)).a(this.feedId, true);
    if (localFeedItem == null) {
      return null;
    }
    if ((localFeedItem instanceof VideoListFeedItem)) {
      return (VideoListFeedItem)localFeedItem;
    }
    return null;
  }
  
  public StoryVideoItem b()
  {
    return ((psu)psx.a(5)).b(this.vid);
  }
  
  public ErrorMessage c()
  {
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("VideoData{").append("msgTabNodeType=");
    int i;
    if (this.h == null)
    {
      i = 0;
      localStringBuilder2.append(i).append(",");
      if (!JK()) {
        break label89;
      }
      localStringBuilder1.append("loadingMessage='").append(this.axz).append('\'');
    }
    for (;;)
    {
      localStringBuilder1.append("}");
      return localStringBuilder1.toString();
      i = this.h.nodeType;
      break;
      label89:
      if (JL()) {
        localStringBuilder1.append("errorMessage=").append(this.e);
      } else {
        localStringBuilder1.append("vid='").append(this.vid).append('\'').append(", feedId='").append(this.feedId).append('\'');
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qjq
 * JD-Core Version:    0.7.0.1
 */