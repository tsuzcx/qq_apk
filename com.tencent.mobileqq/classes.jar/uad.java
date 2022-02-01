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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;
import java.util.List;

public class uad
  extends ViewBase
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(Color.parseColor("#E9E9E9"));
  private View jdField_a_of_type_AndroidViewView;
  private NativeReadInjoyImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private HashMap<Integer, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private pvc jdField_a_of_type_Pvc;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = -1;
  private NativeReadInjoyImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private int jdField_c_of_type_Int = -1;
  private NativeReadInjoyImageView jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView;
  private int d;
  private int e;
  private int f = -1;
  private int g;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  
  public uad(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.jdField_a_of_type_AndroidContentContext = paramVafContext.getContext();
    a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_Int == -1) || (this.jdField_b_of_type_Int == -1)) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView);
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131560057, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369291));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369366));
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView = ((NativeReadInjoyImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369298));
  }
  
  private void a(View paramView)
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
        this.jdField_a_of_type_Int = paramView.getTop();
      }
      this.d = AIOUtils.dp2px(40.0F, ((Activity)localObject1).getResources());
    }
    if ((this.jdField_a_of_type_Pvc != null) && (this.jdField_a_of_type_Pvc.a() != null) && (this.jdField_a_of_type_Pvc.a().a() != null))
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Pvc.a().a().getPaddingTop();
      this.jdField_c_of_type_Int = this.jdField_a_of_type_Pvc.a().a().getTop();
      if (this.jdField_a_of_type_Int <= 0) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_Pvc.a().a().getBottom();
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInjoyTripleImageInteractView", 2, "initQQUIHeight cannot get listview's too and padding.");
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.b != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.b.size() > 0))
    {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView, (String)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.b.get(0), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.b.size() > 1)
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.q != 1) {
          break label170;
        }
        a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView, (String)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.b.get(1), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setVisibility(0);
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setVisibility(8);
      }
    }
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = true)
    {
      a();
      return;
      label170:
      a(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView, (String)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.b.get(1), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setVisibility(0);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setVisibility(8);
    }
  }
  
  private void c()
  {
    a();
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo != null))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.q == 1)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(this.e, -1);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setLayoutParams(localLayoutParams);
      }
    }
    else {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.e + this.d, -1);
    localLayoutParams.setMargins(-this.d, 0, 0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setLayoutParams(localLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo == null)) {}
    label396:
    label594:
    label1145:
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
                          if (this.e == 0)
                          {
                            this.e = paramInt1;
                            c();
                          }
                          if (1 != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.q) {
                            break label659;
                          }
                          if (paramBoolean) {
                            break label396;
                          }
                          paramInt1 = this.jdField_a_of_type_Int;
                          paramInt4 = this.jdField_b_of_type_Int;
                          paramInt5 = this.jdField_c_of_type_Int;
                          paramInt1 = this.jdField_a_of_type_Int - (paramInt1 - (paramInt4 + paramInt5)) / 3;
                          if (paramInt1 <= 0)
                          {
                            a();
                            return;
                          }
                          if ((this.jdField_a_of_type_Int - paramInt3 <= paramInt2) || (paramInt3 - paramInt1 <= 0)) {
                            break;
                          }
                          if (this.h == -1)
                          {
                            this.h = (paramInt3 - paramInt1);
                            this.jdField_a_of_type_Float = (paramInt2 / (paramInt2 - this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getHeight()));
                            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(1.0F);
                            this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(1.0F);
                            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(1.0F);
                            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(1.0F);
                          }
                        } while (this.h == 0);
                        f1 = (this.h - (paramInt3 - paramInt1)) / this.h;
                      } while ((f1 < 0.0F) || (f1 > 1.0F));
                      f1 *= this.jdField_a_of_type_Float;
                      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(1.0F + f1);
                      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(1.0F + f1);
                      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(0.1F * f1 + 1.0F);
                      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(f1 * 0.1F + 1.0F);
                      return;
                      if ((this.jdField_a_of_type_Int - paramInt3 > paramInt2) && (paramInt3 - paramInt1 <= 0))
                      {
                        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(this.jdField_a_of_type_Float + 1.0F);
                        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(this.jdField_a_of_type_Float + 1.0F);
                        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(this.jdField_a_of_type_Float * 0.1F + 1.0F);
                        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(this.jdField_a_of_type_Float * 0.1F + 1.0F);
                        return;
                      }
                    } while ((this.jdField_a_of_type_Int - paramInt3 >= paramInt2) || (paramInt3 - paramInt1 <= 0));
                    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(1.0F);
                    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(1.0F);
                    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(1.0F);
                    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(1.0F);
                    return;
                    paramInt1 = this.jdField_b_of_type_Int + this.jdField_c_of_type_Int;
                    if (paramInt3 - paramInt1 <= 0) {
                      break label594;
                    }
                    if (this.jdField_a_of_type_Boolean)
                    {
                      this.jdField_a_of_type_Float = (paramInt2 / (paramInt2 - this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getHeight()));
                      this.jdField_a_of_type_Boolean = false;
                    }
                    if ((this.i == 0) || (this.i == -1)) {
                      break;
                    }
                    f1 = (this.i - (paramInt3 - paramInt1)) / this.i;
                  } while ((f1 < 0.0F) || (f1 > 1.0F));
                  f1 *= this.jdField_a_of_type_Float;
                  this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(1.0F + f1);
                  this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(1.0F + f1);
                  this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(0.1F * f1 + 1.0F);
                  this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(f1 * 0.1F + 1.0F);
                  return;
                } while (this.i != -1);
                this.i = paramInt5;
                this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(1.0F);
                this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(1.0F);
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(1.0F);
                this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(1.0F);
                return;
              } while (paramInt3 - paramInt1 > 0);
              this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(this.jdField_a_of_type_Float + 1.0F);
              this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(this.jdField_a_of_type_Float + 1.0F);
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleX(this.jdField_a_of_type_Float * 0.1F + 1.0F);
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleY(this.jdField_a_of_type_Float * 0.1F + 1.0F);
              return;
            } while (2 != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.q);
            paramInt4 = this.jdField_b_of_type_Int + this.jdField_c_of_type_Int;
            if ((this.jdField_a_of_type_Int - paramInt3 <= paramInt2) || (paramInt3 - paramInt4 <= 0)) {
              break label1145;
            }
            if (paramBoolean) {
              break;
            }
            if (this.jdField_a_of_type_Boolean)
            {
              this.f = (this.jdField_a_of_type_Int - this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getHeight() - paramInt4);
              this.g = (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getWidth() + paramInt1);
              this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setTranslationX(paramInt1);
              this.jdField_a_of_type_Boolean = false;
            }
          } while (this.f == 0);
          f1 = (this.f - (paramInt3 - paramInt4)) / this.f;
          float f2 = this.g;
          this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setTranslationX(paramInt1 - f2 * f1);
          f2 = this.d;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setTranslationX(f1 * f2);
          return;
          if (this.jdField_a_of_type_Boolean)
          {
            this.g = (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getWidth() + paramInt1);
            this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setTranslationX(paramInt1);
            localLayoutParams = new RelativeLayout.LayoutParams(this.e + this.d, -1);
            localLayoutParams.setMargins(-this.d, 0, 0, 0);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setLayoutParams(localLayoutParams);
            this.jdField_a_of_type_Boolean = false;
          }
          if ((this.j == 0) || (this.j == -1)) {
            break;
          }
          f2 = (this.j - (paramInt3 - paramInt4)) / this.j;
          f1 = f2;
          if (f2 >= 0.0F)
          {
            f1 = f2;
            if (f2 <= 1.0F)
            {
              if (f2 > 0.02D) {
                break label1035;
              }
              f1 = 0.0F;
            }
          }
          for (;;)
          {
            f2 = this.g;
            this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setTranslationX(paramInt1 - f2 * f1);
            f2 = this.d;
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setTranslationX(f2 * f1);
            if (f1 >= 0.0F) {
              break;
            }
            this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setTranslationX(paramInt1);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setTranslationX(0.0F);
            return;
            f1 = f2;
            if (f2 > 0.98D) {
              f1 = 1.0F;
            }
          }
        } while (f1 <= 1.0F);
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setTranslationX(paramInt1 - this.g);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setTranslationX(this.d);
        return;
      } while (this.j != -1);
      this.j = paramInt5;
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.e + this.d, -1);
      localLayoutParams.setMargins(-this.d, 0, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setLayoutParams(localLayoutParams);
      return;
    } while (paramInt3 - paramInt4 > 0);
    label659:
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setTranslationX(-this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.getWidth());
    label1035:
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setTranslationX(this.d);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.e = paramInt1;
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_Boolean = true;
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setTranslationX(paramInt1);
      c();
      this.j = -1;
      this.i = -1;
    }
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
        paramNativeReadInjoyImageView.setImagePlaceHolder(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
  
  public void a(pvc parampvc)
  {
    this.jdField_a_of_type_Pvc = parampvc;
    a();
  }
  
  public boolean a()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo == null)) {
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        if (1 != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.q) {
          break;
        }
      } while (this.i == -1);
      return false;
    } while (this.j == -1);
    return false;
  }
  
  public int getComMeasuredHeight()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_AndroidViewView.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewView.measure(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setScaleType((ImageView.ScaleType)ImageBase.IMAGE_SCALE_TYPE.get(2, ImageView.ScaleType.CENTER_CROP));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
    c();
    b();
    refresh();
  }
  
  public void reset()
  {
    super.reset();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(null);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(null);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeReadInjoyImageView.setImageSrc(null);
    this.f = -1;
    this.h = -1;
    this.i = -1;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
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
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)paramObject);
            return true;
          }
        }
        catch (Exception paramObject)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = null;
          QLog.d("ReadInjoyTripleImageInteractView", 1, "setAttribute STR_ID_SET_AD_BANNER exception " + paramObject.toString());
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uad
 * JD-Core Version:    0.7.0.1
 */