import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqcircle.launchbean.QCircleLayerBean;
import com.tencent.biz.qqcircle.launchbean.QCircleLayerBean.SourceRect;
import com.tencent.biz.qqcircle.picload.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.transition.QCircleTransitionImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.io.File;

public class vvh
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_a_of_type_Int;
  private aamd jdField_a_of_type_Aamd;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  private QCircleTransitionImageView jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView;
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private QCircleTransitionImageView jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView;
  private int c;
  private int d;
  
  public vvh(QCircleLayerBean paramQCircleLayerBean)
  {
    if (paramQCircleLayerBean == null) {
      return;
    }
    a(paramQCircleLayerBean);
    a();
    b();
    c();
    e();
  }
  
  public static Drawable a()
  {
    return jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_Aamd != null) && (this.jdField_a_of_type_Aamd.a())) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundColor(this.jdField_a_of_type_AndroidWidgetFrameLayout.getResources().getColor(2131166253));
  }
  
  /* Error */
  public static void a(ImageView paramImageView, int paramInt1, int paramInt2, QCircleLayerBean paramQCircleLayerBean)
  {
    // Byte code:
    //   0: aload_3
    //   1: astore 4
    //   3: aload_3
    //   4: ifnonnull +12 -> 16
    //   7: new 92	com/tencent/biz/qqcircle/launchbean/QCircleLayerBean
    //   10: dup
    //   11: invokespecial 93	com/tencent/biz/qqcircle/launchbean/QCircleLayerBean:<init>	()V
    //   14: astore 4
    //   16: invokestatic 94	vvh:a	()Z
    //   19: ifeq +139 -> 158
    //   22: aload_0
    //   23: ldc 95
    //   25: invokevirtual 101	android/widget/ImageView:getTag	(I)Ljava/lang/Object;
    //   28: instanceof 103
    //   31: ifeq +175 -> 206
    //   34: aload_0
    //   35: ldc 95
    //   37: invokevirtual 101	android/widget/ImageView:getTag	(I)Ljava/lang/Object;
    //   40: checkcast 103	java/lang/String
    //   43: astore_3
    //   44: invokestatic 108	com/tencent/biz/qqcircle/picload/QCircleFeedPicLoader:a	()Lcom/tencent/biz/qqcircle/picload/QCircleFeedPicLoader;
    //   47: new 110	vrd
    //   50: dup
    //   51: invokespecial 111	vrd:<init>	()V
    //   54: aload_3
    //   55: invokevirtual 114	vrd:a	(Ljava/lang/String;)Lvrd;
    //   58: invokevirtual 117	com/tencent/biz/qqcircle/picload/QCircleFeedPicLoader:b	(Lvrd;)Ljava/lang/String;
    //   61: astore_3
    //   62: aload_0
    //   63: invokevirtual 120	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   66: putstatic 40	vvh:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   69: aload_3
    //   70: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   73: ifne +85 -> 158
    //   76: iconst_2
    //   77: newarray int
    //   79: astore 5
    //   81: aload_0
    //   82: aload 5
    //   84: invokevirtual 130	android/widget/ImageView:getLocationInWindow	([I)V
    //   87: aload_0
    //   88: aload 5
    //   90: invokevirtual 133	android/widget/ImageView:getLocationOnScreen	([I)V
    //   93: aload 4
    //   95: new 135	com/tencent/biz/qqcircle/launchbean/QCircleLayerBean$SourceRect
    //   98: dup
    //   99: aload 5
    //   101: iconst_0
    //   102: iaload
    //   103: aload 5
    //   105: iconst_1
    //   106: iaload
    //   107: aload 5
    //   109: iconst_0
    //   110: iaload
    //   111: aload_0
    //   112: invokevirtual 139	android/widget/ImageView:getWidth	()I
    //   115: iadd
    //   116: aload 5
    //   118: iconst_1
    //   119: iaload
    //   120: aload_0
    //   121: invokevirtual 142	android/widget/ImageView:getHeight	()I
    //   124: iadd
    //   125: invokespecial 145	com/tencent/biz/qqcircle/launchbean/QCircleLayerBean$SourceRect:<init>	(IIII)V
    //   128: invokevirtual 149	com/tencent/biz/qqcircle/launchbean/QCircleLayerBean:setSourceRect	(Lcom/tencent/biz/qqcircle/launchbean/QCircleLayerBean$SourceRect;)V
    //   131: aload 4
    //   133: aload_3
    //   134: invokevirtual 153	com/tencent/biz/qqcircle/launchbean/QCircleLayerBean:setImageUrl	(Ljava/lang/String;)V
    //   137: aload 4
    //   139: iload_1
    //   140: invokevirtual 156	com/tencent/biz/qqcircle/launchbean/QCircleLayerBean:setImageWidth	(I)V
    //   143: aload 4
    //   145: iload_2
    //   146: invokevirtual 159	com/tencent/biz/qqcircle/launchbean/QCircleLayerBean:setImageHeight	(I)V
    //   149: aload 4
    //   151: aload_0
    //   152: invokevirtual 163	android/widget/ImageView:getScaleType	()Landroid/widget/ImageView$ScaleType;
    //   155: invokevirtual 167	com/tencent/biz/qqcircle/launchbean/QCircleLayerBean:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   158: return
    //   159: astore 5
    //   161: ldc 169
    //   163: astore_3
    //   164: aload 5
    //   166: invokevirtual 172	java/lang/Exception:printStackTrace	()V
    //   169: ldc 174
    //   171: iconst_1
    //   172: new 176	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   179: ldc 179
    //   181: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload 5
    //   186: invokevirtual 187	java/lang/Exception:toString	()Ljava/lang/String;
    //   189: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   198: goto -129 -> 69
    //   201: astore 5
    //   203: goto -39 -> 164
    //   206: ldc 169
    //   208: astore_3
    //   209: goto -140 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	paramImageView	ImageView
    //   0	212	1	paramInt1	int
    //   0	212	2	paramInt2	int
    //   0	212	3	paramQCircleLayerBean	QCircleLayerBean
    //   1	149	4	localQCircleLayerBean	QCircleLayerBean
    //   79	38	5	arrayOfInt	int[]
    //   159	26	5	localException1	java.lang.Exception
    //   201	1	5	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   22	62	159	java/lang/Exception
    //   62	69	201	java/lang/Exception
  }
  
  private void a(QCircleLayerBean paramQCircleLayerBean)
  {
    this.jdField_a_of_type_Aamd = new aamd();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(paramQCircleLayerBean.getSourceRect().getLeft(), paramQCircleLayerBean.getSourceRect().getTop(), paramQCircleLayerBean.getSourceRect().getRight(), paramQCircleLayerBean.getSourceRect().getBottom());
    this.jdField_a_of_type_JavaLangString = paramQCircleLayerBean.getImageUrl();
    this.jdField_a_of_type_JavaIoFile = new File(QCircleFeedPicLoader.a().b(new vrd().a(this.jdField_a_of_type_JavaLangString)));
    this.jdField_a_of_type_Int = paramQCircleLayerBean.getImageWidth();
    this.jdField_b_of_type_Int = paramQCircleLayerBean.getImageHeight();
    this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = paramQCircleLayerBean.getScaleType();
    d();
    if (!b()) {
      this.jdField_a_of_type_Aamd.a();
    }
  }
  
  public static boolean a()
  {
    return QzoneConfig.getInstance().getConfig("qqsubscribe", "secondaryEnableJumpDetailTransanimate", 1) > 0;
  }
  
  public static boolean a(QCircleLayerBean paramQCircleLayerBean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQCircleLayerBean != null)
    {
      bool1 = bool2;
      if (paramQCircleLayerBean.getSourceRect() != null) {
        bool1 = true;
      }
    }
    return bool1;
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
    if ((this.jdField_a_of_type_Aamd != null) && (this.jdField_a_of_type_Aamd.a())) {}
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
    if ((this.jdField_a_of_type_Aamd != null) && (this.jdField_a_of_type_Aamd.a())) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView = new QCircleTransitionImageView(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setPadding(0, 0, 0, uym.c);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView);
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setVisibility(4);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 17;
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setLayoutParams(localLayoutParams);
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setImageDrawable(jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    this.jdField_a_of_type_Aamd.a(1);
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
    if ((this.jdField_a_of_type_Aamd == null) || (!this.jdField_a_of_type_Aamd.b())) {
      QLog.d("QCircleTransitionAnimHelper", 1, "initImageEnterAnimation error!");
    }
    while (this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.getViewTreeObserver().addOnPreDrawListener(new vvi(this));
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setAlpha(1.0F);
    if (this.jdField_a_of_type_Aamd != null) {
      this.jdField_a_of_type_Aamd.a(2);
    }
    this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setVisibility(0);
    this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.a(this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.a(), new vvj(this));
  }
  
  public FrameLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public void a(aamn paramaamn)
  {
    if (this.jdField_a_of_type_Aamd != null) {
      this.jdField_a_of_type_Aamd.a(paramaamn);
    }
  }
  
  public void a(Matrix paramMatrix, ImageView paramImageView, vvs paramvvs)
  {
    if (this.jdField_a_of_type_Aamd != null) {
      this.jdField_a_of_type_Aamd.a(2);
    }
    if ((this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView == null) || (this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView == null))
    {
      if (paramvvs != null) {
        paramvvs.a();
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
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.b(paramMatrix, new vvk(this, paramvvs));
      return;
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setImageDrawable(paramImageView.getDrawable());
      this.jdField_b_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setImageDrawable(paramImageView.getDrawable());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvh
 * JD-Core Version:    0.7.0.1
 */