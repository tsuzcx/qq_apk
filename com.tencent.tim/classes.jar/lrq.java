import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.s;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class lrq
  extends ImageBase
{
  private Drawable GRAY_PLACEHOLDER = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private mas b = new mas();
  private TextView pU;
  private FrameLayout root;
  private KandianUrlImageView t;
  
  public lrq(VafContext paramVafContext)
  {
    super(paramVafContext);
    initViews(paramVafContext.getContext());
  }
  
  private void initViews(Context paramContext)
  {
    this.root = new FrameLayout(paramContext);
    this.t = new KandianUrlImageView(paramContext);
    this.pU = new TextView(paramContext);
    paramContext = new FrameLayout.LayoutParams(-2, -2);
    this.root.addView(this.t, paramContext);
    paramContext = new FrameLayout.LayoutParams(Utils.dp2px(30.0D), Utils.dp2px(18.0D));
    paramContext.gravity = 85;
    this.pU.setGravity(17);
    this.pU.setBackgroundColor(Color.parseColor("#80000000"));
    this.pU.setTextColor(-1);
    this.root.addView(this.pU, paramContext);
  }
  
  public void aNf()
  {
    Resources localResources = this.mContext.getContext().getResources();
    if ((this.b.a.a() == null) || (this.b.a.a().mSocialFeedInfo == null) || (this.b.a.a().mSocialFeedInfo.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CornerTextImageView", 2, "info is null");
      }
      return;
    }
    int j = localResources.getDisplayMetrics().widthPixels - wja.dp2px(24.0F, localResources);
    int k = (int)(j * 0.598F);
    float f1 = localResources.getDisplayMetrics().density;
    int i;
    float f2;
    ViewGroup.LayoutParams localLayoutParams;
    if (this.b.a.a().mSocialFeedInfo.a.la.size() > 0)
    {
      i = ((SocializeFeedsInfo.s)this.b.a.a().mSocialFeedInfo.a.la.get(0)).pic_width;
      int m = ((SocializeFeedsInfo.s)this.b.a.a().mSocialFeedInfo.a.la.get(0)).pic_height;
      f2 = wja.dp2px(i / 2, localResources);
      f1 = wja.dp2px(m / 2, localResources);
      i = ((SocializeFeedsInfo.s)this.b.a.a().mSocialFeedInfo.a.la.get(0)).aSX;
      localLayoutParams = this.t.getLayoutParams();
      if ((f2 >= j) || (f1 >= k)) {
        break label399;
      }
      this.pU.setVisibility(8);
    }
    for (;;)
    {
      if (i == 1)
      {
        this.pU.setVisibility(0);
        this.pU.setText(2131718542);
      }
      localLayoutParams.width = ((int)f2);
      localLayoutParams.height = ((int)f1);
      this.t.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.t.setLayoutParams(localLayoutParams);
      this.t.setPadding(0, 0, 0, 0);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CornerTextImageView", 2, "ugc pic info is null");
      }
      f2 = 115.0F * f1;
      f1 *= 1037.0F;
      i = 0;
      break;
      label399:
      if ((f2 < j) && (f1 > k))
      {
        if (f1 / f2 > 4.0F)
        {
          f1 = k;
          f2 = wja.dp2px(150.0F, localResources);
          this.pU.setVisibility(0);
          this.pU.setText(2131718543);
        }
        else
        {
          f2 *= k / f1;
          f1 = k;
          this.pU.setVisibility(8);
        }
      }
      else if ((f2 > j) && (f1 < k))
      {
        if (f2 / f1 > 4.0F)
        {
          f2 = j;
          f1 = wja.dp2px(150.0F, localResources);
          this.pU.setText(2131718544);
          this.pU.setVisibility(0);
        }
        else
        {
          f1 *= j / f2;
          f2 = j;
          this.pU.setVisibility(8);
        }
      }
      else if (f1 / f2 > 4.0F)
      {
        f1 = k;
        f2 = wja.dp2px(150.0F, localResources);
        this.pU.setVisibility(0);
        this.pU.setText(2131718543);
      }
      else if (f2 / f1 > 4.0F)
      {
        f2 = j;
        f1 = wja.dp2px(150.0F, localResources);
        this.pU.setText(2131718544);
        this.pU.setVisibility(0);
      }
      else
      {
        float f3 = j;
        if ((f1 - k) / (f2 - f3) < 0.598F)
        {
          f1 *= j / f2;
          f2 = j;
          this.pU.setVisibility(8);
        }
        else
        {
          f2 *= k / f1;
          f1 = k;
          this.pU.setVisibility(8);
        }
      }
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.root.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.root.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.root;
  }
  
  public void loadImage(String paramString)
  {
    super.loadImage(paramString);
    this.t.setImagePlaceHolder(this.GRAY_PLACEHOLDER);
    try
    {
      this.t.setImage(new URL(paramString));
      return;
    }
    catch (MalformedURLException paramString) {}
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.root.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.root.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.root.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    loadImage(this.mSrc);
    refresh();
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    super.setAttribute(paramInt, paramObject);
    switch (paramInt)
    {
    default: 
      return false;
    }
    if ((paramObject instanceof lie)) {
      setModel((lie)paramObject);
    }
    return true;
  }
  
  public void setBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.t.setImageBitmap(paramBitmap);
    }
  }
  
  public void setModel(lie paramlie)
  {
    this.b.setModel(paramlie);
    aNf();
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new lrq(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lrq
 * JD-Core Version:    0.7.0.1
 */