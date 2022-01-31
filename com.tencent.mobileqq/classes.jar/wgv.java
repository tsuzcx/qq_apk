import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.subscribe.widget.SubscribeBannerView.BannerAdapter;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeMultiPicHeadItemView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;

public class wgv
  extends SubscribeBannerView.BannerAdapter
{
  public wgv(RelativeMultiPicHeadItemView paramRelativeMultiPicHeadItemView) {}
  
  private String a(Object paramObject)
  {
    if ((paramObject instanceof CertifiedAccountMeta.StImage)) {
      return ((CertifiedAccountMeta.StImage)paramObject).url.get();
    }
    return "";
  }
  
  public View a(View paramView, Object paramObject)
  {
    paramObject = a(paramObject);
    if (paramObject != null) {
      vvr.a(paramObject, (URLImageView)paramView);
    }
    return paramView;
  }
  
  protected URLImageView a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new URLImageView(paramViewGroup.getContext());
    if (RelativeMultiPicHeadItemView.a(this.a) == 0) {}
    for (int i = -1;; i = RelativeMultiPicHeadItemView.a(this.a))
    {
      paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
      return paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wgv
 * JD-Core Version:    0.7.0.1
 */