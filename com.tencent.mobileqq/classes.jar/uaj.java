import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqcircle.transition.QCircleTransitionImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class uaj
{
  private static Map<String, String> jdField_a_of_type_JavaUtilMap;
  private int jdField_a_of_type_Int;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  private QCircleTransitionImageView jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView;
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  private uam jdField_a_of_type_Uam;
  private yks jdField_a_of_type_Yks;
  private int jdField_b_of_type_Int;
  private QCircleTransitionImageView jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView;
  private int c;
  private int d;
  
  public uaj(Bundle paramBundle)
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
  
  public static Intent a(URLImageView paramURLImageView, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    if (a())
    {
      Bundle localBundle = new Bundle();
      Object localObject = new int[2];
      paramURLImageView.getLocationInWindow((int[])localObject);
      paramURLImageView.getLocationOnScreen((int[])localObject);
      localBundle.putParcelable("bundle_key_trans_anim_rect", new Rect(localObject[0], localObject[1], localObject[0] + paramURLImageView.getWidth(), localObject[1] + paramURLImageView.getHeight()));
      try
      {
        localObject = ((URLDrawable)paramURLImageView.getDrawable()).getFileInLocal().getPath();
        String str = b(((URLDrawable)paramURLImageView.getDrawable()).getURL().toString());
        QLog.d("QCircleTransitionAnimHelper", 4, "generatePrams trimUrl:" + str);
        if (jdField_a_of_type_JavaUtilMap == null) {
          jdField_a_of_type_JavaUtilMap = new HashMap();
        }
        jdField_a_of_type_JavaUtilMap.clear();
        jdField_a_of_type_JavaUtilMap.put(str, localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localBundle.putString("bundle_key_source_image_param", new uam((String)localObject, paramInt1, paramInt2).a());
          localBundle.putSerializable("bundle_key_image_scale_type", paramURLImageView.getScaleType());
          localIntent.putExtra("bundle_key_parms_extra", localBundle);
          return localIntent;
        }
      }
      catch (Exception paramURLImageView)
      {
        paramURLImageView.printStackTrace();
        QLog.e("QCircleTransitionAnimHelper", 1, "generatePrams getImagePath error!" + paramURLImageView.toString());
        return localIntent;
      }
    }
    return localIntent;
  }
  
  public static String a(String paramString)
  {
    if ((jdField_a_of_type_JavaUtilMap != null) && (jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      return (String)jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return "";
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_Yks != null) && (this.jdField_a_of_type_Yks.a())) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(-16777216);
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Yks = new yks();
    this.jdField_a_of_type_AndroidGraphicsRect = ((Rect)paramBundle.getParcelable("bundle_key_trans_anim_rect"));
    String str = paramBundle.getString("bundle_key_source_image_param");
    this.jdField_a_of_type_Uam = new uam();
    this.jdField_a_of_type_Uam.a(str);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Uam.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_JavaIoFile = new File(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Uam.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Uam.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = ((ImageView.ScaleType)paramBundle.getSerializable("bundle_key_image_scale_type"));
    d();
    if (!b()) {
      this.jdField_a_of_type_Yks.a();
    }
  }
  
  public static boolean a()
  {
    return QzoneConfig.getInstance().getConfig("qqsubscribe", "secondaryEnableJumpDetailTransanimate", 1) > 0;
  }
  
  private int[] a(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)(paramInt2 / paramInt1 * ImmersiveUtils.a());
    return new int[] { ImmersiveUtils.a(), paramInt1 };
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (paramString.contains("#sce=")) {
      str = paramString.substring(0, paramString.indexOf("#sce="));
    }
    return str;
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Yks != null) && (this.jdField_a_of_type_Yks.a())) {}
    while (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView = new QCircleTransitionImageView(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.getLayoutParams();
    localLayoutParams.width = this.jdField_a_of_type_AndroidGraphicsRect.width();
    localLayoutParams.height = this.jdField_a_of_type_AndroidGraphicsRect.height();
    localLayoutParams.setMargins(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, 0, 0);
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setScaleType(this.jdField_a_of_type_AndroidWidgetImageView$ScaleType);
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setImageURI(Uri.fromFile(this.jdField_a_of_type_JavaIoFile));
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setVisibility(4);
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {}
    while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaIoFile.isFile()) || (!this.jdField_a_of_type_JavaIoFile.exists()) || (this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0) || (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == null) || (this.c == 0) || (this.d == 0)) {
      return false;
    }
    return true;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Yks != null) && (this.jdField_a_of_type_Yks.a())) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView = new QCircleTransitionImageView(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView);
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setVisibility(4);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 17;
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setImageURI(Uri.fromFile(this.jdField_a_of_type_JavaIoFile));
    }
    this.jdField_a_of_type_Yks.a(1);
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
    if ((this.jdField_a_of_type_Yks == null) || (!this.jdField_a_of_type_Yks.b())) {
      QLog.d("QCircleTransitionAnimHelper", 1, "initImageEnterAnimation error!");
    }
    while (this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.getViewTreeObserver().addOnPreDrawListener(new uak(this));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Yks != null) {
      this.jdField_a_of_type_Yks.a(2);
    }
    this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setVisibility(0);
    this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.a(this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.a(), new ual(this));
  }
  
  public FrameLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public void a(ylc paramylc)
  {
    if (this.jdField_a_of_type_Yks != null) {
      this.jdField_a_of_type_Yks.a(paramylc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uaj
 * JD-Core Version:    0.7.0.1
 */