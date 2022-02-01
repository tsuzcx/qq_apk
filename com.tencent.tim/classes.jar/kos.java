import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyCutImageView;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyCutImageView.a;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyDoubleImageView.1;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyDoubleImageView.5;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.net.URL;
import java.util.ArrayList;

public class kos
  extends ViewBase
{
  private Boolean C = Boolean.valueOf(false);
  private Boolean E = Boolean.valueOf(true);
  private Drawable GRAY_PLACEHOLDER = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private int Sf = -1;
  private ReadInjoyCutImageView.a jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView$a;
  private kor jdField_a_of_type_Kor;
  private lie jdField_a_of_type_Lie;
  private int aKH = -1;
  private int aKI = -1;
  private int aKJ;
  private int aKK;
  private String abx;
  private int azH;
  private ReadInjoyCutImageView.a jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView$a;
  private ReadInjoyCutImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView;
  private knm jdField_b_of_type_Knm = new knm();
  private Runnable cA;
  private Drawable cu = new ColorDrawable(Color.parseColor("#00000000"));
  private AdvertisementInfo e;
  private NativeReadInjoyImageView g;
  private NativeReadInjoyImageView h;
  private ArrayList<String> kj;
  private int lastTop;
  private Context mContext;
  private View mRootView;
  private Rect rect;
  
  public kos(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mContext = paramVafContext.getContext();
    initView(this.mContext);
  }
  
  private ReadInjoyCutImageView.a a(String paramString)
  {
    paramString = paramString.split(",");
    if (paramString.length == 2)
    {
      float f1 = Float.parseFloat(paramString[0]);
      float f2 = Float.parseFloat(paramString[1]);
      float f3 = f1 / this.e.mAdMaterialWidth;
      float f4 = -f2 / this.e.mAdMaterialHeight;
      if ((f3 >= 0.0F) && (f3 <= 1.0F) && (f4 >= -1.0F) && (f4 <= 0.0F)) {
        return new ReadInjoyCutImageView.a(f3, f4, f1, f2);
      }
    }
    return null;
  }
  
  private Boolean a(float paramFloat1, float paramFloat2)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    float f1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView$a.jf;
    float f2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView$a.je;
    float f3 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView$a.jf;
    float f4 = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView$a.je;
    if (f1 == f3)
    {
      if (paramFloat2 <= f1) {}
      for (;;)
      {
        return Boolean.valueOf(bool1);
        bool1 = false;
      }
    }
    if (f2 == f4)
    {
      if (paramFloat1 < f2) {}
      for (bool1 = bool2;; bool1 = false) {
        return Boolean.valueOf(bool1);
      }
    }
    float f5 = (f1 - f3) / (f2 - f4);
    if ((paramFloat2 - (f3 * f2 - f1 * f4) / (f2 - f4)) / f5 > paramFloat1) {}
    for (bool1 = bool3;; bool1 = false) {
      return Boolean.valueOf(bool1);
    }
  }
  
  private Boolean a(View paramView, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramView == null) {
      return Boolean.valueOf(false);
    }
    int j = paramView.getHeight();
    if (this.rect == null) {
      this.rect = new Rect();
    }
    paramView.getGlobalVisibleRect(this.rect);
    if (!paramBoolean) {}
    for (int i = this.rect.height();; i = this.rect.height() - this.aKK)
    {
      paramBoolean = bool;
      if (i > j >> 1) {
        paramBoolean = true;
      }
      return Boolean.valueOf(paramBoolean);
    }
  }
  
  private void a(String paramString, Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.g.setImageDrawable(null);
      this.g.setImagePlaceHolder(paramDrawable);
    }
    paramDrawable = URLDrawable.URLDrawableOptions.obtain();
    paramDrawable.mLoadingDrawable = this.GRAY_PLACEHOLDER;
    paramDrawable = URLDrawable.getDrawable(paramString, paramDrawable);
    if ((paramDrawable != null) && (paramDrawable.getStatus() == 2)) {
      paramDrawable.restartDownload();
    }
    do
    {
      return;
      if ((paramDrawable != null) && (paramDrawable.getStatus() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInjoyDoubleImageView", 2, "status=URLDrawable.SUCCESSED:" + paramString);
        }
        this.jdField_a_of_type_Kor = new kor(paramDrawable.getCurrDrawable(), this.azH, this.aKH - (this.Sf + this.aKI));
        this.g.setImageDrawable(this.jdField_a_of_type_Kor);
        this.abx = paramString;
        return;
      }
    } while (paramDrawable == null);
    paramDrawable.setURLDrawableListener(new kot(this, paramString));
  }
  
  private void aFx()
  {
    if ((this.aKH == -1) || (this.Sf == -1)) {
      cd(this.g);
    }
    if ((!TextUtils.isEmpty(this.e.mImaxImg)) && (!this.e.mImaxImg.equals(this.abx))) {
      a(this.e.mImaxImg, this.GRAY_PLACEHOLDER);
    }
  }
  
  private void aFz()
  {
    if ((this.e == null) || (TextUtils.isEmpty(this.e.mAdvertisementExtInfo.aap)) || (this.kj == null) || (this.e.mAdMaterialWidth == 0) || (this.e.mAdMaterialHeight == 0) || (this.cA != null) || (this.jdField_b_of_type_Knm.a() != null) || (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView == null)) {
      return;
    }
    mn(this.e.mAdvertisementExtInfo.aap);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setOnTouchListener(new kou(this));
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView$a != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView$a != null)) {
      this.jdField_b_of_type_Knm.a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView$a, this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView$a, this.e.mAdvertisementExtInfo.aJB, this.e.mAdvertisementExtInfo.aJC, this.e.mAdvertisementExtInfo.aJF);
    }
    this.jdField_b_of_type_Knm.a(new kov(this));
    this.cA = new ReadInjoyDoubleImageView.5(this);
    this.E = Boolean.valueOf(false);
  }
  
  private void bP(ArrayList<String> paramArrayList)
  {
    if ((knd.q(this.e)) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView, (String)paramArrayList.get(this.aKJ), this.GRAY_PLACEHOLDER);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setIsShowSrc(true);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setVisibility(0);
      this.aKJ = ((this.aKJ + 1) % paramArrayList.size());
      a(this.g, (String)paramArrayList.get(this.aKJ), this.GRAY_PLACEHOLDER);
    }
  }
  
  private void bindData()
  {
    if (this.e != null) {
      if (!knd.n(this.e))
      {
        localObject = this.e.getVideoCoverUrlWithSmartCut(false);
        if (localObject == null) {
          break label158;
        }
      }
    }
    label158:
    for (Object localObject = ((URL)localObject).getFile();; localObject = null)
    {
      a(this.g, (String)localObject, this.GRAY_PLACEHOLDER);
      if ((this.e.mInteractType == 2) && (!TextUtils.isEmpty(this.e.mInteractImageList))) {
        a(this.h, this.e.mInteractImageList, this.cu);
      }
      if ((this.e.mAdvertisementExtInfo.aJz == 1009) && (this.e.mAdImgList != null))
      {
        this.kj = this.e.mAdImgList;
        this.aKJ = 0;
        bP(this.kj);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.post(new ReadInjoyDoubleImageView.1(this));
      }
      return;
    }
  }
  
  private void cd(View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramView != null)
    {
      localObject2 = paramView.getContext();
      paramView = (View)localObject1;
      for (localObject1 = localObject2;; localObject1 = ((ContextWrapper)localObject1).getBaseContext())
      {
        localObject2 = paramView;
        if (!(localObject1 instanceof ContextWrapper)) {
          break;
        }
        if ((localObject1 instanceof Activity)) {
          paramView = (Activity)localObject1;
        }
      }
    }
    if ((localObject2 != null) && (((Activity)localObject2).getWindow() != null))
    {
      paramView = ((Activity)localObject2).getWindow().getDecorView().findViewById(16908307);
      if (paramView != null)
      {
        this.aKH = paramView.getTop();
        this.aKK = paramView.getMeasuredHeight();
      }
    }
    if ((this.jdField_a_of_type_Lie != null) && (this.jdField_a_of_type_Lie.b() != null) && (this.jdField_a_of_type_Lie.b().b() != null))
    {
      this.Sf = this.jdField_a_of_type_Lie.b().b().getPaddingTop();
      this.aKI = this.jdField_a_of_type_Lie.b().b().getTop();
      if (this.aKH <= 0) {
        this.aKH = this.jdField_a_of_type_Lie.b().b().getBottom();
      }
    }
    for (;;)
    {
      this.azH = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInjoyDoubleImageView", 2, "initQQUIHeight cannot get listview's too and padding.");
      }
    }
  }
  
  private void cs(int paramInt1, int paramInt2)
  {
    this.e.mAdvertisementExtInfo.aJD = paramInt1;
    this.e.materialGroup = paramInt2;
    this.e.clickType = 2;
  }
  
  private void initView(Context paramContext)
  {
    this.mRootView = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131560234, null);
    this.g = ((NativeReadInjoyImageView)this.mRootView.findViewById(2131369657));
    this.h = ((NativeReadInjoyImageView)this.mRootView.findViewById(2131369659));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView = ((ReadInjoyCutImageView)this.mRootView.findViewById(2131369658));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setVisibility(8);
    this.h.setVisibility(8);
  }
  
  private int m(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.getPath())))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.getPath().equals(paramArrayList.get(i))) {
          return i;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  private void mn(String paramString)
  {
    Object localObject = paramString.split("\\|");
    if (localObject.length == 2)
    {
      paramString = localObject[0];
      localObject = localObject[1];
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView$a = a(paramString);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView$a = a((String)localObject);
    }
  }
  
  private int nw()
  {
    return this.aKH - getComMeasuredHeight();
  }
  
  public void M(float paramFloat)
  {
    this.h.setAlpha(paramFloat);
    if (paramFloat > 0.0F)
    {
      this.h.setVisibility(0);
      return;
    }
    this.h.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    if (nw() < 0) {}
    int i;
    do
    {
      return;
      i = paramInt2;
      if (paramInt2 < nw())
      {
        i = paramInt2;
        if (paramInt3 == 2)
        {
          i = paramInt2;
          if (this.lastTop + 1 != paramInt2)
          {
            i = paramInt2;
            if (this.lastTop != 0)
            {
              i = paramInt2;
              if (Math.abs(paramInt2 - this.lastTop) > 3)
              {
                i = paramInt2;
                if (paramDouble <= 0.0D)
                {
                  i = paramInt2;
                  if (paramInt2 <= this.lastTop) {
                    i = this.lastTop + 1;
                  }
                }
              }
            }
          }
        }
      }
      if (this.lastTop != i) {
        this.lastTop = i;
      }
    } while (this.jdField_a_of_type_Kor == null);
    if (this.jdField_a_of_type_Kor.getCallback() == null) {
      this.g.setImageDrawable(this.jdField_a_of_type_Kor);
    }
    paramInt2 = -(Math.abs(i) - Math.abs(this.Sf));
    if (i <= 0) {
      paramInt2 = this.Sf + Math.abs(i);
    }
    this.jdField_a_of_type_Kor.cr(paramInt1, paramInt2);
  }
  
  public void a(NativeReadInjoyImageView paramNativeReadInjoyImageView, String paramString, Drawable paramDrawable)
  {
    QLog.d("ReadInjoyDoubleImageView", 2, "loadImage: path is " + paramString);
    if ((paramString != null) && (!paramString.equals("-1")))
    {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount"))) {
        break label79;
      }
      if (paramDrawable != null) {
        paramNativeReadInjoyImageView.setImagePlaceHolder(this.GRAY_PLACEHOLDER);
      }
      paramNativeReadInjoyImageView.setImageSrc(paramString);
    }
    label79:
    do
    {
      return;
      paramString = ImageCommon.getDrawableResourceId(paramString);
    } while (paramString == null);
    QLog.d("ReadInjoyDoubleImageView", 2, "loadImage: cant find in offline dir, try to load from resources");
    try
    {
      paramNativeReadInjoyImageView.setImageDrawable(paramNativeReadInjoyImageView.getResources().getDrawable(paramString.intValue()));
      return;
    }
    catch (Resources.NotFoundException paramNativeReadInjoyImageView)
    {
      QLog.d("ReadInjoyDoubleImageView", 2, "loadImage: cant find in resources dir, do nothing");
    }
  }
  
  public void aFy()
  {
    if (this.h.getVisibility() == 0) {
      this.h.setVisibility(8);
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.getVisibility() == 0)
    {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setVisibility(8);
      stopAnim();
    }
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    float f3 = 0.0F;
    float f2 = 1.0F;
    if (this.e == null) {}
    do
    {
      return;
      switch (this.e.mInteractEffectType)
      {
      default: 
        return;
      }
    } while ((paramInt1 <= 0) || (paramInt2 <= 0));
    float f1 = paramInt3 / paramInt1;
    if (paramBoolean) {
      f1 = 1.0F - paramInt4 * 1.0F / paramInt1;
    }
    if (f1 < 0.0F) {
      f1 = f3;
    }
    for (;;)
    {
      if (f1 > 1.0F) {
        f1 = f2;
      }
      for (;;)
      {
        M(f1);
        return;
      }
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.mRootView.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.mRootView.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.mRootView;
  }
  
  public void mA(boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView != null) && (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.getHeight() != 0) && (this.cA != null))
    {
      this.C = a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView, paramBoolean);
      if (!this.C.booleanValue()) {
        break label90;
      }
      if (!this.E.booleanValue())
      {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.removeCallbacks(this.cA);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.post(this.cA);
        this.E = Boolean.valueOf(true);
      }
    }
    return;
    label90:
    stopAnim();
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mRootView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.mRootView.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.g.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.g.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(2, ImageView.ScaleType.CENTER_CROP));
    this.g.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    this.h.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.h.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(2, ImageView.ScaleType.CENTER_CROP));
    this.h.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(2, ImageView.ScaleType.CENTER_CROP));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    bindData();
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.g.setImageSrc(null);
    this.h.setImageSrc(null);
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView != null)
    {
      this.jdField_b_of_type_Knm.stopAnim();
      this.jdField_b_of_type_Knm.a(null);
      this.jdField_b_of_type_Knm = null;
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.setImageSrc(null);
    }
    if (this.jdField_a_of_type_Kor != null)
    {
      this.g.setImageDrawable(null);
      this.jdField_a_of_type_Kor.reset();
      this.jdField_a_of_type_Kor = null;
    }
  }
  
  public boolean setAttribute(int paramInt, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    switch (paramInt)
    {
    default: 
      bool1 = super.setAttribute(paramInt, paramObject);
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        try
        {
          if ((paramObject instanceof AdvertisementInfo))
          {
            this.e = ((AdvertisementInfo)paramObject);
            return true;
          }
        }
        catch (Exception paramObject)
        {
          this.e = null;
          QLog.d("ReadInjoyDoubleImageView", 1, "setAttribute STR_ID_SET_AD_BANNER exception " + paramObject.toString());
        }
      }
    }
    return true;
  }
  
  public void setModel(lie paramlie)
  {
    this.jdField_a_of_type_Lie = paramlie;
    if ((this.e != null) && (knd.n(this.e))) {
      aFx();
    }
    if ((this.e != null) && (knd.q(this.e))) {
      cd(this.g);
    }
  }
  
  public void stopAnim()
  {
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView != null)
    {
      this.jdField_b_of_type_Knm.stopAnim();
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInjoyCutImageView.removeCallbacks(this.cA);
      this.E = Boolean.valueOf(false);
    }
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new kos(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kos
 * JD-Core Version:    0.7.0.1
 */