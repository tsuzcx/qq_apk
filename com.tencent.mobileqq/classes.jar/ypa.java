import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.subscribe.widget.SubscribeBannerView.BannerAdapter;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeMultiPicHeadItemView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ypa
  extends SubscribeBannerView.BannerAdapter
{
  public ypa(RelativeMultiPicHeadItemView paramRelativeMultiPicHeadItemView) {}
  
  private String a(Object paramObject)
  {
    if ((paramObject instanceof CertifiedAccountMeta.StImage)) {
      return ((CertifiedAccountMeta.StImage)paramObject).url.get();
    }
    return "";
  }
  
  public View a(View paramView, Object paramObject)
  {
    String str = a(paramObject);
    if (((paramObject instanceof CertifiedAccountMeta.StImage)) && (RelativeMultiPicHeadItemView.a(this.a) != 0))
    {
      paramObject = (CertifiedAccountMeta.StImage)paramObject;
      if ((paramObject.width.get() != 0) && (paramObject.height.get() != 0))
      {
        float f = paramObject.height.get() / paramObject.width.get();
        paramObject = paramView.getLayoutParams();
        int j = (int)(RelativeMultiPicHeadItemView.a(this.a) / f);
        int i = j;
        if (j > RelativeMultiPicHeadItemView.b(this.a)) {
          i = RelativeMultiPicHeadItemView.b(this.a);
        }
        paramObject.width = i;
        paramObject.height = RelativeMultiPicHeadItemView.a(this.a);
      }
    }
    if (str != null) {}
    try
    {
      paramObject = ykt.a(str);
      if (!TextUtils.isEmpty(paramObject))
      {
        paramObject = new File(paramObject);
        if (paramObject.exists())
        {
          ((URLImageView)paramView).setImageURI(Uri.fromFile(paramObject));
          return paramView;
        }
      }
    }
    catch (Exception paramObject)
    {
      QLog.d("RelativeMultiPicHeadItemView", 1, "bindItemView set local image path error!exception:" + paramObject);
      ybm.a(str, (URLImageView)paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ypa
 * JD-Core Version:    0.7.0.1
 */