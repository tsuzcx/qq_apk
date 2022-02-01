import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeReadInjoyImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ImageCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.List;

public class kow
  extends ViewBase
{
  private Drawable GRAY_PLACEHOLDER = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private int Sf = -1;
  private lie a;
  private int aKH = -1;
  private int aKI = -1;
  private int aKP;
  private int aKQ;
  private int aKR = -1;
  private int aKS;
  private int aKT = -1;
  private int aKU = -1;
  private int aKV = -1;
  private boolean agS = true;
  private HashMap<Integer, Integer> dw = new HashMap();
  private AdvertisementInfo e;
  private NativeReadInjoyImageView i;
  private NativeReadInjoyImageView j;
  private NativeReadInjoyImageView k;
  private Context mContext;
  private View mRootView;
  private float mScaleY;
  
  public kow(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.mContext = paramVafContext.getContext();
    initView(this.mContext);
  }
  
  private void aFA()
  {
    if ((this.aKH == -1) || (this.Sf == -1)) {
      cd(this.i);
    }
  }
  
  private void aFB()
  {
    aFA();
    if ((this.e != null) && (this.e.mAdvertisementExtInfo != null))
    {
      if (this.e.mAdvertisementExtInfo.aJH == 1)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(this.aKQ, -1);
        this.i.setLayoutParams(localLayoutParams);
      }
    }
    else {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.aKQ + this.aKP, -1);
    localLayoutParams.setMargins(-this.aKP, 0, 0, 0);
    this.i.setLayoutParams(localLayoutParams);
  }
  
  private void bindData()
  {
    if ((this.e != null) && (this.e.mAdvertisementExtInfo != null) && (this.e.mAdvertisementExtInfo.gj != null) && (this.e.mAdvertisementExtInfo.gj.size() > 0))
    {
      a(this.i, (String)this.e.mAdvertisementExtInfo.gj.get(0), this.GRAY_PLACEHOLDER);
      if (this.e.mAdvertisementExtInfo.gj.size() > 1)
      {
        if (this.e.mAdvertisementExtInfo.aJH != 1) {
          break label170;
        }
        a(this.j, (String)this.e.mAdvertisementExtInfo.gj.get(1), this.GRAY_PLACEHOLDER);
        this.j.setVisibility(0);
        this.k.setVisibility(8);
      }
    }
    for (this.agS = true;; this.agS = true)
    {
      aFA();
      return;
      label170:
      a(this.k, (String)this.e.mAdvertisementExtInfo.gj.get(1), this.GRAY_PLACEHOLDER);
      this.k.setVisibility(0);
      this.j.setVisibility(8);
    }
  }
  
  private void cd(View paramView)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramView != null)
    {
      localObject1 = paramView.getContext();
      paramView = (View)localObject2;
      for (localObject2 = localObject1;; localObject2 = ((ContextWrapper)localObject2).getBaseContext())
      {
        localObject1 = paramView;
        if (!(localObject2 instanceof ContextWrapper)) {
          break;
        }
        if ((localObject2 instanceof Activity)) {
          paramView = (Activity)localObject2;
        }
      }
    }
    if ((localObject1 != null) && (((Activity)localObject1).getWindow() != null))
    {
      paramView = ((Activity)localObject1).getWindow().getDecorView().findViewById(16908307);
      if (paramView != null) {
        this.aKH = paramView.getTop();
      }
      this.aKP = wja.dp2px(40.0F, ((Activity)localObject1).getResources());
    }
    if ((this.a != null) && (this.a.b() != null) && (this.a.b().b() != null))
    {
      this.Sf = this.a.b().b().getPaddingTop();
      this.aKI = this.a.b().b().getTop();
      if (this.aKH <= 0) {
        this.aKH = this.a.b().b().getBottom();
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInjoyTripleImageInteractView", 2, "initQQUIHeight cannot get listview's too and padding.");
  }
  
  private void initView(Context paramContext)
  {
    this.mRootView = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131560243, null);
    this.i = ((NativeReadInjoyImageView)this.mRootView.findViewById(2131369806));
    this.j = ((NativeReadInjoyImageView)this.mRootView.findViewById(2131369886));
    this.k = ((NativeReadInjoyImageView)this.mRootView.findViewById(2131369812));
  }
  
  public boolean Ah()
  {
    boolean bool = true;
    if ((this.e == null) || (this.e.mAdvertisementExtInfo == null)) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (1 != this.e.mAdvertisementExtInfo.aJH) {
          break;
        }
      } while (this.aKU == -1);
      return false;
    } while (this.aKV == -1);
    return false;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5)
  {
    if ((this.e == null) || (this.e.mAdvertisementExtInfo == null)) {}
    label400:
    label600:
    do
    {
      do
      {
        float f1;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                          if (this.aKQ == 0)
                          {
                            this.aKQ = paramInt1;
                            aFB();
                          }
                          if (1 != this.e.mAdvertisementExtInfo.aJH) {
                            break label667;
                          }
                          if (paramBoolean) {
                            break label400;
                          }
                          paramInt1 = this.aKH;
                          paramInt4 = this.Sf;
                          paramInt5 = this.aKI;
                          paramInt1 = this.aKH - (paramInt1 - (paramInt4 + paramInt5)) / 3;
                          if (paramInt1 <= 0)
                          {
                            aFA();
                            return;
                          }
                          if ((this.aKH - paramInt3 <= paramInt2) || (paramInt3 - paramInt1 <= 0)) {
                            break;
                          }
                          if (this.aKT == -1)
                          {
                            this.aKT = (paramInt3 - paramInt1);
                            this.mScaleY = (paramInt2 / (paramInt2 - this.j.getHeight()));
                            this.j.setScaleX(1.0F);
                            this.j.setScaleY(1.0F);
                            this.i.setScaleX(1.0F);
                            this.i.setScaleY(1.0F);
                          }
                        } while (this.aKT == 0);
                        f1 = (this.aKT - (paramInt3 - paramInt1)) / this.aKT;
                      } while ((f1 < 0.0F) || (f1 > 1.0F));
                      f1 *= this.mScaleY;
                      this.j.setScaleX(1.0F + f1);
                      this.j.setScaleY(1.0F + f1);
                      this.i.setScaleX(0.1F * f1 + 1.0F);
                      this.i.setScaleY(f1 * 0.1F + 1.0F);
                      return;
                      if ((this.aKH - paramInt3 > paramInt2) && (paramInt3 - paramInt1 <= 0))
                      {
                        this.j.setScaleX(this.mScaleY + 1.0F);
                        this.j.setScaleY(this.mScaleY + 1.0F);
                        this.i.setScaleX(this.mScaleY * 0.1F + 1.0F);
                        this.i.setScaleY(this.mScaleY * 0.1F + 1.0F);
                        return;
                      }
                    } while ((this.aKH - paramInt3 >= paramInt2) || (paramInt3 - paramInt1 <= 0));
                    this.j.setScaleX(1.0F);
                    this.j.setScaleY(1.0F);
                    this.i.setScaleX(1.0F);
                    this.i.setScaleY(1.0F);
                    return;
                    paramInt1 = this.Sf + this.aKI;
                    if (paramInt3 - paramInt1 <= 0) {
                      break label600;
                    }
                    if (this.agS)
                    {
                      this.mScaleY = (paramInt2 / (paramInt2 - this.j.getHeight()));
                      this.agS = false;
                    }
                    if ((this.aKU == 0) || (this.aKU == -1)) {
                      break;
                    }
                    f1 = (this.aKU - (paramInt3 - paramInt1)) / this.aKU;
                  } while ((f1 < 0.0F) || (f1 > 1.0F));
                  f1 *= this.mScaleY;
                  this.j.setScaleX(1.0F + f1);
                  this.j.setScaleY(1.0F + f1);
                  this.i.setScaleX(0.1F * f1 + 1.0F);
                  this.i.setScaleY(f1 * 0.1F + 1.0F);
                  return;
                } while (this.aKU != -1);
                this.aKU = paramInt5;
                this.j.setScaleX(1.0F);
                this.j.setScaleY(1.0F);
                this.i.setScaleX(1.0F);
                this.i.setScaleY(1.0F);
                return;
              } while (paramInt3 - paramInt1 > 0);
              this.j.setScaleX(this.mScaleY + 1.0F);
              this.j.setScaleY(this.mScaleY + 1.0F);
              this.i.setScaleX(this.mScaleY * 0.1F + 1.0F);
              this.i.setScaleY(this.mScaleY * 0.1F + 1.0F);
              return;
            } while (2 != this.e.mAdvertisementExtInfo.aJH);
            paramInt4 = this.Sf + this.aKI;
            if ((this.aKH - paramInt3 <= paramInt2) || (paramInt3 - paramInt4 <= 0)) {
              break label1153;
            }
            if (paramBoolean) {
              break;
            }
            if (this.agS)
            {
              this.aKR = (this.aKH - this.k.getHeight() - paramInt4);
              this.aKS = (this.k.getWidth() + paramInt1);
              this.k.setTranslationX(paramInt1);
              this.agS = false;
            }
          } while (this.aKR == 0);
          f1 = (this.aKR - (paramInt3 - paramInt4)) / this.aKR;
          float f2 = this.aKS;
          this.k.setTranslationX(paramInt1 - f2 * f1);
          f2 = this.aKP;
          this.i.setTranslationX(f1 * f2);
          return;
          if (this.agS)
          {
            this.aKS = (this.k.getWidth() + paramInt1);
            this.k.setTranslationX(paramInt1);
            localLayoutParams = new RelativeLayout.LayoutParams(this.aKQ + this.aKP, -1);
            localLayoutParams.setMargins(-this.aKP, 0, 0, 0);
            this.i.setLayoutParams(localLayoutParams);
            this.agS = false;
          }
          if ((this.aKV == 0) || (this.aKV == -1)) {
            break;
          }
          f2 = (this.aKV - (paramInt3 - paramInt4)) / this.aKV;
          f1 = f2;
          if (f2 >= 0.0F)
          {
            f1 = f2;
            if (f2 <= 1.0F)
            {
              if (f2 > 0.02D) {
                break label1043;
              }
              f1 = 0.0F;
            }
          }
          for (;;)
          {
            f2 = this.aKS;
            this.k.setTranslationX(paramInt1 - f2 * f1);
            f2 = this.aKP;
            this.i.setTranslationX(f2 * f1);
            if (f1 >= 0.0F) {
              break;
            }
            this.k.setTranslationX(paramInt1);
            this.i.setTranslationX(0.0F);
            return;
            f1 = f2;
            if (f2 > 0.98D) {
              f1 = 1.0F;
            }
          }
        } while (f1 <= 1.0F);
        this.k.setTranslationX(paramInt1 - this.aKS);
        this.i.setTranslationX(this.aKP);
        return;
      } while (this.aKV != -1);
      this.aKV = paramInt5;
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.aKQ + this.aKP, -1);
      localLayoutParams.setMargins(-this.aKP, 0, 0, 0);
      this.i.setLayoutParams(localLayoutParams);
      return;
    } while (paramInt3 - paramInt4 > 0);
    label667:
    this.k.setTranslationX(-this.k.getWidth());
    label1043:
    this.i.setTranslationX(this.aKP);
    label1153:
  }
  
  public void a(NativeReadInjoyImageView paramNativeReadInjoyImageView, String paramString, Drawable paramDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyTripleImageInteractView", 2, "loadImage: path is " + paramString);
    }
    if ((paramString != null) && (!paramString.equals("-1")))
    {
      if ((!paramString.startsWith("http")) && (!paramString.startsWith("pubaccount"))) {
        break label85;
      }
      if (paramDrawable != null) {
        paramNativeReadInjoyImageView.setImagePlaceHolder(this.GRAY_PLACEHOLDER);
      }
      paramNativeReadInjoyImageView.setImageSrc(paramString);
    }
    label85:
    do
    {
      return;
      paramString = ImageCommon.getDrawableResourceId(paramString);
    } while (paramString == null);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyTripleImageInteractView", 2, "loadImage: cant find in offline dir, try to load from resources");
    }
    try
    {
      paramNativeReadInjoyImageView.setImageDrawable(paramNativeReadInjoyImageView.getResources().getDrawable(paramString.intValue()));
      return;
    }
    catch (Resources.NotFoundException paramNativeReadInjoyImageView)
    {
      QLog.d("ReadInjoyTripleImageInteractView", 2, "loadImage: cant find in resources dir, do nothing");
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
  
  public void h(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.aKQ = paramInt1;
    if (paramBoolean)
    {
      this.dw.clear();
      this.agS = true;
      this.k.setTranslationX(paramInt1);
      aFB();
      this.aKV = -1;
      this.aKU = -1;
    }
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
    this.i.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.i.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(2, ImageView.ScaleType.CENTER_CROP));
    this.i.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    aFB();
    bindData();
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.i.setImageSrc(null);
    this.j.setImageSrc(null);
    this.k.setImageSrc(null);
    this.aKR = -1;
    this.aKT = -1;
    this.aKU = -1;
    this.dw.clear();
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
          QLog.d("ReadInjoyTripleImageInteractView", 1, "setAttribute STR_ID_SET_AD_BANNER exception " + paramObject.toString());
        }
      }
    }
    return true;
  }
  
  public void setModel(lie paramlie)
  {
    this.a = paramlie;
    aFA();
  }
  
  public static class a
    implements ViewBase.IBuilder
  {
    public ViewBase build(VafContext paramVafContext)
    {
      return new kow(paramVafContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kow
 * JD-Core Version:    0.7.0.1
 */