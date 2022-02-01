import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleDitto.StItemInfo;

public class vaf
  extends RecyclerView.ViewHolder
  implements aabg<QCircleReportBean>
{
  protected int a;
  protected QCircleReportBean a;
  protected FeedCloudMeta.StFeed a;
  protected Object a;
  protected vae a;
  protected int b;
  protected int c;
  
  public vaf(View paramView)
  {
    super(paramView);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public QCircleReportBean a()
  {
    return this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean;
  }
  
  public QQCircleDitto.StItemInfo a()
  {
    return (QQCircleDitto.StItemInfo)this.jdField_a_of_type_JavaLangObject;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleReportQCircleReportBean = paramQCircleReportBean;
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.jdField_a_of_type_FeedcloudFeedCloudMeta$StFeed = paramStFeed;
  }
  
  public void a(String paramString, int paramInt, URLImageView paramURLImageView)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramURLImageView != null))
    {
      Drawable localDrawable = paramURLImageView.getContext().getResources().getDrawable(paramInt);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = uys.b(paramURLImageView);
      localURLDrawableOptions.mFailedDrawable = localDrawable;
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      uys.a(paramString, paramURLImageView, localURLDrawableOptions, false);
    }
  }
  
  public void a(vae paramvae)
  {
    this.jdField_a_of_type_Vae = paramvae;
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vaf
 * JD-Core Version:    0.7.0.1
 */