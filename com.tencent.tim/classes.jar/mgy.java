import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import java.net.URL;

public class mgy
  implements mhk
{
  protected URL e;
  protected BaseArticleInfo j;
  
  public mgy(BaseArticleInfo paramBaseArticleInfo)
  {
    this.j = paramBaseArticleInfo;
  }
  
  protected Pair<Integer, Integer> a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return kwz.k();
    }
    return kwz.j();
  }
  
  public int getCommentCount()
  {
    return this.j.mVideoCommentCount;
  }
  
  public String getInnerUniqueID()
  {
    return this.j.innerUniqueID;
  }
  
  public String getShareUrl()
  {
    return this.j.mArticleContentUrl;
  }
  
  public String getSubscribeName()
  {
    return this.j.mSubscribeName;
  }
  
  public String getSubscribeUin()
  {
    return this.j.mSubscribeID;
  }
  
  public URL getVideoCoverURL()
  {
    if (this.j.mVideoCoverUrl != null) {
      return this.j.mVideoCoverUrl;
    }
    if (this.j.mSinglePicture != null) {
      return this.j.mSinglePicture;
    }
    return kxm.b(this.j.mFirstPagePicUrl);
  }
  
  public URL getVideoCoverUrlWithSmartCut(boolean paramBoolean)
  {
    if (this.e == null)
    {
      Pair localPair = a(paramBoolean);
      this.e = getVideoCoverWithSmartCut(((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
    }
    return this.e;
  }
  
  public URL getVideoCoverWithSmartCut(int paramInt1, int paramInt2)
  {
    if (getVideoCoverURL() != null)
    {
      String str2 = getVideoCoverURL().toString();
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (str2.startsWith("pubaccountimage:")) {
          str1 = str2.replaceFirst("pubaccountimage:", "");
        }
      }
      return kxm.b(kxm.c(str1, paramInt1, paramInt2));
    }
    return this.j.mVideoCoverUrl;
  }
  
  public int getVideoDuration()
  {
    if (this.j != null) {
      return this.j.mVideoDuration;
    }
    return 0;
  }
  
  public int getVideoHeight()
  {
    return this.j.mVideoJsonHeight;
  }
  
  public String getVideoVid()
  {
    return this.j.mVideoVid;
  }
  
  public int getVideoWidth()
  {
    return this.j.mVideoJsonWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mgy
 * JD-Core Version:    0.7.0.1
 */