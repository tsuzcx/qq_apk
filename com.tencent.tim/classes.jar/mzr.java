import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.WeishiRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLazyLoadDelegate;
import com.tencent.biz.pubaccount.readinjoy.video.WeishiVideoFeedsLazyLoadDelegate.1;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

public class mzr
  extends VideoFeedsLazyLoadDelegate
{
  private lcr a;
  private boolean aqT;
  private WeishiRedDotInfo b;
  private boolean dw;
  
  public mzr(mry.a parama, Bundle paramBundle, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    super(parama, paramBundle, paramQQAppInterface, paramFragmentActivity, paramString1, paramString2, paramBoolean, paramInt);
    this.jdField_a_of_type_Lcr = ((lcr)this.mApp.getManager(274));
  }
  
  private void a(WeishiRedDotInfo paramWeishiRedDotInfo)
  {
    if (paramWeishiRedDotInfo == null)
    {
      super.ie();
      return;
    }
    this.dw = true;
    int i = this.mActivity.getIntent().getIntExtra("VIDEO_FROM_TYPE", -1);
    String str1 = this.mActivity.getIntent().getStringExtra("VIDEO_SECOND_INDEX_INNER_ID");
    long l3 = this.mActivity.getIntent().getLongExtra("VIDEO_FROM_POLYMERIC_TOPIC_ID", -1L);
    String str2 = this.mActivity.getIntent().getStringExtra("VIDEO_COMMON_DATA");
    String str3 = this.mActivity.getIntent().getStringExtra("VALUE_COOKIE");
    long l2 = this.mActivity.getIntent().getLongExtra("VIDEO_FROM_POLYMERIC_PUIN", 0L);
    long l1 = l2;
    if (l2 == 0L) {
      l1 = Long.parseLong(this.mApp.getCurrentAccountUin());
    }
    this.jdField_a_of_type_Kcr.a(this.jdField_b_of_type_Kcs, l1, c(), i, null, str1, l3, true, 0, str2, str3, paramWeishiRedDotInfo, 0, null, null, 0, null);
  }
  
  public void N(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (this.jdField_a_of_type_Lcr != null))
    {
      if (paramVideoInfo.articleInfo == null) {
        muj.x(paramVideoInfo);
      }
      long l = NetConnInfoCenter.getServerTime();
      this.jdField_a_of_type_Lcr.B(ocp.a(this.mApp, paramVideoInfo.articleInfo), l);
    }
  }
  
  public void aSz()
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ((int)aqgz.getWidth());
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ((int)aqgz.getHeight());
    ColorDrawable localColorDrawable = new ColorDrawable(this.mActivity.getResources().getColor(2131165381));
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable("https://sqimg.qq.com/qq_product_operations/kan/images/rij_wehishi_bg.png", (URLDrawable.URLDrawableOptions)localObject);
    this.al.setBackgroundDrawable((Drawable)localObject);
  }
  
  public void g(VideoInfo paramVideoInfo)
  {
    N(paramVideoInfo);
    super.g(paramVideoInfo);
  }
  
  public void ie()
  {
    if (!this.aqT)
    {
      this.aqT = true;
      ThreadManager.excute(new WeishiVideoFeedsLazyLoadDelegate.1(this), 32, null, true);
      return;
    }
    a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructWeishiRedDotInfo);
  }
  
  public boolean p(Bundle paramBundle)
  {
    if (this.dw)
    {
      this.e = ((VideoInfo)paramBundle.getParcelable("VALUE_REQUEST_VIDEO_DETAIL_INFO"));
      if (this.e != null)
      {
        muj.x(this.e);
        this.mActivity.getIntent().putExtra("VIDEO_ARTICLE_ID", this.e.Wz);
        this.jdField_a_of_type_Lcr.aI(this.mActivity);
        return true;
      }
    }
    return super.p(paramBundle);
  }
  
  public void sB(int paramInt)
  {
    if (paramInt == 0)
    {
      this.sl.setText("");
      this.kc.setImageResource(2130844003);
      return;
    }
    super.sB(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mzr
 * JD-Core Version:    0.7.0.1
 */