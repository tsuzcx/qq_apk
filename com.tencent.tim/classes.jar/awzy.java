import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import dov.com.qq.im.ae.view.AEDownLoadingView;

public class awzy
  extends RecyclerView.ViewHolder
{
  public ImageView De;
  public ImageView Df;
  public ImageView HX;
  public AEDownLoadingView a;
  public URLImageView aD;
  private Context mContext;
  private int mCurrentState = 0;
  public RelativeLayout nR;
  
  public awzy(View paramView)
  {
    super(paramView);
    this.aD = ((URLImageView)paramView.findViewById(2131379629));
    this.De = ((ImageView)paramView.findViewById(2131377939));
    this.Df = ((ImageView)paramView.findViewById(2131366098));
    this.HX = ((ImageView)paramView.findViewById(2131380102));
    this.a = ((AEDownLoadingView)paramView.findViewById(2131373699));
    this.nR = ((RelativeLayout)paramView.findViewById(2131382127));
  }
  
  private static int Q(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0;
    }
    return 8;
  }
  
  private void m(axbu paramaxbu)
  {
    this.De.setVisibility(8);
    this.Df.setVisibility(8);
    this.HX.setVisibility(8);
    this.nR.setVisibility(8);
  }
  
  private void n(axbu paramaxbu)
  {
    this.De.setVisibility(8);
    o(paramaxbu);
    q(paramaxbu);
    this.nR.setVisibility(Q(paramaxbu.editablewatermark));
  }
  
  private void o(axbu paramaxbu)
  {
    if (paramaxbu.isWsBanner())
    {
      this.Df.setVisibility(8);
      this.a.setVisibility(8);
      return;
    }
    if (paramaxbu.usable)
    {
      this.Df.setVisibility(8);
      this.a.setVisibility(8);
      return;
    }
    if (paramaxbu.downloading)
    {
      this.Df.setVisibility(8);
      this.a.setVisibility(0);
      this.a.setProgress(paramaxbu.eEx);
      return;
    }
    this.Df.setVisibility(0);
    this.Df.setImageResource(2130845453);
    this.a.setVisibility(8);
  }
  
  private void p(axbu paramaxbu)
  {
    this.De.setVisibility(0);
    this.De.setImageResource(2130845519);
    o(paramaxbu);
    q(paramaxbu);
    this.nR.setVisibility(Q(paramaxbu.editablewatermark));
  }
  
  private void q(axbu paramaxbu)
  {
    if (paramaxbu.isWsBanner())
    {
      this.HX.setVisibility(0);
      this.HX.setImageResource(2130846856);
      return;
    }
    if (paramaxbu.needDisplayType())
    {
      this.HX.setVisibility(0);
      this.HX.setImageResource(paramaxbu.getDisplayIconByType());
      return;
    }
    this.HX.setVisibility(8);
  }
  
  private void r(axbu paramaxbu)
  {
    switch (this.mCurrentState)
    {
    default: 
      m(paramaxbu);
      return;
    case 0: 
      m(paramaxbu);
      return;
    case 1: 
      n(paramaxbu);
      s(paramaxbu);
      return;
    }
    p(paramaxbu);
    s(paramaxbu);
  }
  
  private void s(axbu paramaxbu)
  {
    if (TextUtils.isEmpty(paramaxbu.iconurl)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = wja.dp2px(60.0F, this.mContext.getResources());
    Drawable localDrawable = this.mContext.getResources().getDrawable(2130845452);
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mRetryCount = 3;
    paramaxbu = URLDrawable.getDrawable(paramaxbu.iconurl, localURLDrawableOptions);
    if (paramaxbu.getStatus() == 2) {
      paramaxbu.restartDownload();
    }
    this.aD.setImageDrawable(paramaxbu);
  }
  
  public void b(int paramInt, axbu paramaxbu)
  {
    this.mCurrentState = paramInt;
    r(paramaxbu);
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext;
    int i = wja.dp2px(6.0F, paramContext.getResources());
    int j = wja.dp2px(2.0F, paramContext.getResources());
    int k = wja.dp2px(16.0F, paramContext.getResources());
    this.a.setBgCorner(k / 2);
    this.a.setMinimumHeight(k);
    this.a.setMinimumWidth(k);
    this.a.setProgressSizeAndMode(i, j, false);
    this.a.setBgColor(-1);
    this.a.setProgressColor(-16725252);
    this.a.Yq(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awzy
 * JD-Core Version:    0.7.0.1
 */