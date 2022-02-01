import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.transition.QCircleTransitionImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.io.File;

public class vsn
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_a_of_type_Int;
  private aaic jdField_a_of_type_Aaic;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  private QCircleTransitionImageView jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView;
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  private vsr jdField_a_of_type_Vsr;
  private int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private QCircleTransitionImageView jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView;
  private int c;
  private int d;
  
  public vsn(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    a(paramBundle);
    a();
    b();
    c();
    e();
  }
  
  public static Intent a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    if (a())
    {
      Bundle localBundle = new Bundle();
      Object localObject = new int[2];
      paramImageView.getLocationInWindow((int[])localObject);
      paramImageView.getLocationOnScreen((int[])localObject);
      localBundle.putParcelable("bundle_key_trans_anim_rect", new Rect(localObject[0], localObject[1], localObject[0] + paramImageView.getWidth(), localObject[1] + paramImageView.getHeight()));
      localObject = "";
      try
      {
        if ((paramImageView.getTag(2131373863) instanceof String))
        {
          localObject = (String)paramImageView.getTag(2131373863);
          localObject = QCircleFeedPicLoader.a().b(new vou().a((String)localObject));
          jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramImageView.getDrawable();
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localBundle.putString("bundle_key_source_image_param", new vsr((String)localObject, paramInt1, paramInt2).a());
          localBundle.putSerializable("bundle_key_image_scale_type", paramImageView.getScaleType());
          localIntent.putExtra("bundle_key_parms_extra", localBundle);
          return localIntent;
        }
      }
      catch (Exception paramImageView)
      {
        paramImageView.printStackTrace();
        QLog.e("QCircleTransitionAnimHelper", 1, "generatePrams getImagePath error!" + paramImageView.toString());
        return localIntent;
      }
    }
    return localIntent;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_Aaic != null) && (this.jdField_a_of_type_Aaic.a())) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(this.jdField_a_of_type_AndroidWidgetFrameLayout.getResources().getColor(2131166250));
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Aaic = new aaic();
    this.jdField_a_of_type_AndroidGraphicsRect = ((Rect)paramBundle.getParcelable("bundle_key_trans_anim_rect"));
    String str = paramBundle.getString("bundle_key_source_image_param");
    this.jdField_a_of_type_Vsr = new vsr();
    this.jdField_a_of_type_Vsr.a(str);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Vsr.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_JavaIoFile = new File(QCircleFeedPicLoader.a().b(new vou().a(this.jdField_a_of_type_JavaLangString)));
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Vsr.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Vsr.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = ((ImageView.ScaleType)paramBundle.getSerializable("bundle_key_image_scale_type"));
    d();
    if (!b()) {
      this.jdField_a_of_type_Aaic.a();
    }
  }
  
  public static boolean a()
  {
    return QzoneConfig.getInstance().getConfig("qqsubscribe", "secondaryEnableJumpDetailTransanimate", 1) > 0;
  }
  
  private int[] a(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)(paramInt2 / paramInt1 * ImmersiveUtils.a());
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = ImmersiveUtils.a();
    arrayOfInt[1] = paramInt1;
    paramInt1 = (int)((ImmersiveUtils.b() - paramInt1) / 2.0F);
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect(0, paramInt1, arrayOfInt[0], arrayOfInt[1] + paramInt1);
    return arrayOfInt;
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Aaic != null) && (this.jdField_a_of_type_Aaic.a())) {}
    while (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView = new QCircleTransitionImageView(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.getLayoutParams();
    localLayoutParams.width = this.jdField_a_of_type_AndroidGraphicsRect.width();
    localLayoutParams.height = this.jdField_a_of_type_AndroidGraphicsRect.height();
    localLayoutParams.setMargins(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, 0, 0);
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setScaleType(this.jdField_a_of_type_AndroidWidgetImageView$ScaleType);
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setVisibility(4);
  }
  
  private boolean b()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsRect == null) || (this.jdField_b_of_type_AndroidGraphicsRect == null)) {}
    while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaIoFile.isFile()) || (!this.jdField_a_of_type_JavaIoFile.exists()) || (this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0) || (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == null) || (this.c == 0) || (this.d == 0) || (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)) {
      return false;
    }
    return true;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Aaic != null) && (this.jdField_a_of_type_Aaic.a())) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView = new QCircleTransitionImageView(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setPadding(0, 0, 0, uxb.c);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView);
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setVisibility(4);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 17;
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    this.jdField_a_of_type_Aaic.a(1);
  }
  
  private void d()
  {
    int[] arrayOfInt = a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    if ((arrayOfInt != null) && (arrayOfInt.length == 2))
    {
      this.c = arrayOfInt[0];
      this.d = arrayOfInt[1];
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Aaic == null) || (!this.jdField_a_of_type_Aaic.b())) {
      QLog.d("QCircleTransitionAnimHelper", 1, "initImageEnterAnimation error!");
    }
    while (this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.getViewTreeObserver().addOnPreDrawListener(new vso(this));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Aaic != null) {
      this.jdField_a_of_type_Aaic.a(2);
    }
    this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setVisibility(0);
    this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.a(this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.a(), new vsp(this));
  }
  
  public FrameLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public void a(aaim paramaaim)
  {
    if (this.jdField_a_of_type_Aaic != null) {
      this.jdField_a_of_type_Aaic.a(paramaaim);
    }
  }
  
  public void a(Matrix paramMatrix, ImageView paramImageView, vsz paramvsz)
  {
    if (this.jdField_a_of_type_Aaic != null) {
      this.jdField_a_of_type_Aaic.a(2);
    }
    if ((this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView == null) || (this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView == null))
    {
      if (paramvsz != null) {
        paramvsz.a();
      }
      return;
    }
    if (paramImageView == null) {
      paramImageView = this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView;
    }
    for (;;)
    {
      paramMatrix = QCircleTransitionImageView.a(paramMatrix, paramImageView);
      if (paramMatrix != null) {
        this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.a(paramMatrix);
      }
      paramMatrix = this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.a();
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setVisibility(8);
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setAlpha(1.0F);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(0);
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.b(paramMatrix, new vsq(this, paramvsz));
      return;
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setImageDrawable(paramImageView.getDrawable());
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setImageDrawable(paramImageView.getDrawable());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsn
 * JD-Core Version:    0.7.0.1
 */