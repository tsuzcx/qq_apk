import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.fragment.WebpageFragment;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView.a;
import com.tencent.biz.pubaccount.CustomWebView;

public class jwy
  implements VerticalPagerView.a
{
  public jwy(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public boolean cX(int paramInt)
  {
    return (PublicAccountAdvertisementActivity.e(this.this$0)) && (PublicAccountAdvertisementActivity.c(this.this$0));
  }
  
  public boolean cY(int paramInt)
  {
    return (PublicAccountAdvertisementActivity.e(this.this$0)) && (!PublicAccountAdvertisementActivity.c(this.this$0)) && (PublicAccountAdvertisementActivity.a(this.this$0) != null) && (PublicAccountAdvertisementActivity.a(this.this$0).getWebView() != null) && (PublicAccountAdvertisementActivity.a(this.this$0).getWebView().getWebScrollY() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwy
 * JD-Core Version:    0.7.0.1
 */