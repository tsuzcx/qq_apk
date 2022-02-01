import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class wsk
{
  private ErrorMessage a;
  @NonNull
  public final String a;
  public vxd a;
  public final String b;
  private String c;
  
  public wsk(@NonNull String paramString1, @NonNull String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public static wsk a(String paramString1, String paramString2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramString1 != null) {
      if (paramString2 == null) {
        break label31;
      }
    }
    for (;;)
    {
      paramString1 = new wsk(paramString1, paramString2);
      paramString1.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
      return paramString1;
      paramString1 = "ERROR_NO_VID";
      break;
      label31:
      paramString2 = "ERROR_NO_FEED";
    }
  }
  
  public static wsk a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 != null) {
      if (paramString2 == null) {
        break label31;
      }
    }
    for (;;)
    {
      paramString1 = new wsk(paramString1, paramString2);
      paramString1.c = paramString3;
      return paramString1;
      paramString1 = "LOADING_NO_VID";
      break;
      label31:
      paramString2 = "LOADING_NO_FEED";
    }
  }
  
  public ErrorMessage a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
  }
  
  public StoryVideoItem a()
  {
    return ((vuu)vux.a(5)).b(this.jdField_a_of_type_JavaLangString);
  }
  
  public VideoListFeedItem a()
  {
    if (TextUtils.isEmpty(this.b)) {
      return null;
    }
    FeedItem localFeedItem = ((xnp)vux.a(11)).a(this.b, true);
    if (localFeedItem == null) {
      return null;
    }
    if ((localFeedItem instanceof VideoListFeedItem)) {
      return (VideoListFeedItem)localFeedItem;
    }
    return null;
  }
  
  public boolean a()
  {
    return this.c != null;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null;
  }
  
  public boolean c()
  {
    return (!a()) && (!b());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append("VideoData{").append("msgTabNodeType=");
    int i;
    if (this.jdField_a_of_type_Vxd == null)
    {
      i = 0;
      localStringBuilder2.append(i).append(",");
      if (!a()) {
        break label89;
      }
      localStringBuilder1.append("loadingMessage='").append(this.c).append('\'');
    }
    for (;;)
    {
      localStringBuilder1.append("}");
      return localStringBuilder1.toString();
      i = this.jdField_a_of_type_Vxd.a;
      break;
      label89:
      if (b()) {
        localStringBuilder1.append("errorMessage=").append(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
      } else {
        localStringBuilder1.append("vid='").append(this.jdField_a_of_type_JavaLangString).append('\'').append(", feedId='").append(this.b).append('\'');
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsk
 * JD-Core Version:    0.7.0.1
 */