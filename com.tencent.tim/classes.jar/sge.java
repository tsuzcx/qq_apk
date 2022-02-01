import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class sge
{
  private static ActivityOptions jdField_a_of_type_AndroidAppActivityOptions;
  private static final Property<ImageView, Matrix> jdField_a_of_type_AndroidUtilProperty = new sgi(Matrix.class, "animatedTransform");
  private static final AccelerateDecelerateInterpolator b = new AccelerateDecelerateInterpolator();
  private static Map<String, String> gp;
  private File G;
  private AnimatorSet M;
  private View T;
  private sgd jdField_a_of_type_Sgd;
  private sge.b jdField_a_of_type_Sge$b;
  private sgk jdField_a_of_type_Sgk;
  private FrameLayout aA;
  private int bhu;
  private int bhv;
  private int mImageHeight;
  private String mImageUrl;
  private int mImageWidth;
  private Rect mRect;
  private ImageView.ScaleType mScaleType;
  private ImageView nZ;
  private ImageView oa;
  
  public sge(Bundle paramBundle, sgk paramsgk)
  {
    if ((paramBundle == null) || (paramsgk == null)) {
      return;
    }
    this.jdField_a_of_type_Sgk = paramsgk;
    aT(paramBundle);
    bjK();
    bjL();
    bjM();
    bjO();
  }
  
  public static boolean HP()
  {
    return QzoneConfig.getInstance().getConfig("qqsubscribe", "secondaryEnableJumpDetailTransanimate", 1) > 0;
  }
  
  private boolean HQ()
  {
    if (this.mRect == null) {}
    while ((TextUtils.isEmpty(this.mImageUrl)) || (!this.G.isFile()) || (!this.G.exists()) || (this.mImageWidth == 0) || (this.mImageHeight == 0) || (this.mScaleType == null) || (this.bhu == 0) || (this.bhv == 0)) {
      return false;
    }
    return true;
  }
  
  public static Intent a(URLImageView paramURLImageView, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    if (HP())
    {
      Bundle localBundle = new Bundle();
      Object localObject = new int[2];
      paramURLImageView.getLocationInWindow((int[])localObject);
      paramURLImageView.getLocationOnScreen((int[])localObject);
      localBundle.putParcelable("bundle_key_trans_anim_rect", new Rect(localObject[0], localObject[1], localObject[0] + paramURLImageView.getWidth(), localObject[1] + paramURLImageView.getHeight()));
      for (;;)
      {
        try
        {
          localObject = ((URLDrawable)paramURLImageView.getDrawable()).getFileInLocal().getPath();
          String str = ((URLDrawable)paramURLImageView.getDrawable()).getURL().toString();
          if (gp == null) {
            gp = new HashMap();
          }
          gp.clear();
          gp.put(str, localObject);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          if (Build.VERSION.SDK_INT >= 16)
          {
            jdField_a_of_type_AndroidAppActivityOptions = ActivityOptions.makeScaleUpAnimation(paramURLImageView, 0, 0, paramURLImageView.getWidth(), paramURLImageView.getHeight());
            localBundle.putString("bundle_key_source_image_param", new sge.b((String)localObject, paramInt1, paramInt2).mb());
            localBundle.putSerializable("bundle_key_image_scale_type", paramURLImageView.getScaleType());
            localIntent.putExtra("bundle_key_parms_extra", localBundle);
            return localIntent;
          }
        }
        catch (Exception paramURLImageView)
        {
          paramURLImageView.printStackTrace();
          QLog.e("TransitionAnimHelper", 1, "generatePrams getImagePath error!" + paramURLImageView.toString());
          return localIntent;
        }
        jdField_a_of_type_AndroidAppActivityOptions = null;
      }
    }
    jdField_a_of_type_AndroidAppActivityOptions = null;
    return localIntent;
  }
  
  public static Matrix a(ImageView paramImageView)
  {
    QLog.d("TransitionAnimHelper", 4, "getImageMatrix, imageView " + paramImageView);
    int i = paramImageView.getLeft();
    int j = paramImageView.getTop();
    int k = paramImageView.getRight();
    int m = paramImageView.getBottom();
    Rect localRect = new Rect(i, j, k, m);
    QLog.d("TransitionAnimHelper", 4, "getImageMatrix, left" + i + ",top:" + j + ",right:" + k + ",bottom:" + m);
    Drawable localDrawable = paramImageView.getDrawable();
    ImageView.ScaleType localScaleType = paramImageView.getScaleType();
    QLog.d("TransitionAnimHelper", 4, "getImageMatrix, scaleType " + localScaleType);
    if (localScaleType == ImageView.ScaleType.FIT_XY)
    {
      paramImageView = paramImageView.getImageMatrix();
      if (!paramImageView.isIdentity()) {
        return new Matrix(paramImageView);
      }
      i = localDrawable.getIntrinsicWidth();
      j = localDrawable.getIntrinsicHeight();
      if ((i > 0) && (j > 0))
      {
        float f1 = localRect.width() / i;
        float f2 = localRect.height() / j;
        paramImageView = new Matrix();
        paramImageView.setScale(f1, f2);
        return paramImageView;
      }
      return null;
    }
    return new Matrix(paramImageView.getImageMatrix());
  }
  
  private void aT(Bundle paramBundle)
  {
    this.jdField_a_of_type_Sgd = new sgd();
    this.mRect = ((Rect)paramBundle.getParcelable("bundle_key_trans_anim_rect"));
    String str = paramBundle.getString("bundle_key_source_image_param");
    this.jdField_a_of_type_Sge$b = new sge.b();
    this.jdField_a_of_type_Sge$b.qB(str);
    this.mImageUrl = this.jdField_a_of_type_Sge$b.image_url;
    this.G = new File(this.mImageUrl);
    this.mImageWidth = this.jdField_a_of_type_Sge$b.bhw;
    this.mImageHeight = this.jdField_a_of_type_Sge$b.bhx;
    this.mScaleType = ((ImageView.ScaleType)paramBundle.getSerializable("bundle_key_image_scale_type"));
    bjN();
    if (!HQ()) {
      this.jdField_a_of_type_Sgd.bys();
    }
  }
  
  private void bjK()
  {
    if ((this.jdField_a_of_type_Sgd != null) && (this.jdField_a_of_type_Sgd.isErrorState())) {
      return;
    }
    this.aA = new FrameLayout(BaseApplicationImpl.getContext());
    this.T = new View(BaseApplicationImpl.getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.aA.addView(this.T, localLayoutParams);
    this.T.setBackgroundColor(-1);
  }
  
  private void bjL()
  {
    if ((this.jdField_a_of_type_Sgd != null) && (this.jdField_a_of_type_Sgd.isErrorState())) {}
    while (this.aA == null) {
      return;
    }
    this.nZ = new ImageView(this.aA.getContext());
    this.aA.addView(this.nZ);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.nZ.getLayoutParams();
    localLayoutParams.width = this.mRect.width();
    localLayoutParams.height = this.mRect.height();
    localLayoutParams.setMargins(this.mRect.left, this.mRect.top, 0, 0);
    this.nZ.setScaleType(this.mScaleType);
    this.nZ.setImageURI(Uri.fromFile(this.G));
  }
  
  private void bjM()
  {
    if ((this.jdField_a_of_type_Sgd != null) && (this.jdField_a_of_type_Sgd.isErrorState())) {
      return;
    }
    if (this.aA != null)
    {
      this.oa = new ImageView(this.aA.getContext());
      this.aA.addView(this.oa);
      this.oa.setVisibility(4);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.bhu, this.bhv);
      localLayoutParams.gravity = 1;
      localLayoutParams.topMargin = this.jdField_a_of_type_Sgk.uj();
      this.oa.setLayoutParams(localLayoutParams);
    }
    this.oa.setScaleType(this.mScaleType);
    this.oa.setImageURI(Uri.fromFile(this.G));
    this.jdField_a_of_type_Sgd.setState(1);
  }
  
  private void bjN()
  {
    int[] arrayOfInt = this.jdField_a_of_type_Sgk.a(this.mImageWidth, this.mImageHeight);
    if ((arrayOfInt != null) && (arrayOfInt.length == 2))
    {
      this.bhu = arrayOfInt[0];
      this.bhv = arrayOfInt[1];
    }
  }
  
  private void bjO()
  {
    if ((this.jdField_a_of_type_Sgd == null) || (!this.jdField_a_of_type_Sgd.Mg())) {
      QLog.d("TransitionAnimHelper", 1, "initImageEnterAnimation error!");
    }
    while (this.oa == null) {
      return;
    }
    this.oa.getViewTreeObserver().addOnPreDrawListener(new sgf(this));
  }
  
  public static String gz(String paramString)
  {
    if ((gp != null) && (gp.containsKey(paramString))) {
      return (String)gp.get(paramString);
    }
    return "";
  }
  
  @RequiresApi(api=16)
  public static Bundle i()
  {
    Bundle localBundle = new Bundle();
    if (jdField_a_of_type_AndroidAppActivityOptions != null)
    {
      localBundle = jdField_a_of_type_AndroidAppActivityOptions.toBundle();
      jdField_a_of_type_AndroidAppActivityOptions = null;
    }
    return localBundle;
  }
  
  public static boolean s(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.containsKey("bundle_key_trans_anim_rect");
    }
    return false;
  }
  
  private void w(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Sgd != null) {
      this.jdField_a_of_type_Sgd.setState(2);
    }
    Object localObject1 = PropertyValuesHolder.ofInt("left", new int[] { this.nZ.getLeft(), paramInt1 });
    Object localObject2 = PropertyValuesHolder.ofInt("top", new int[] { this.nZ.getTop(), paramInt2 });
    Object localObject3 = PropertyValuesHolder.ofInt("right", new int[] { this.nZ.getRight(), paramInt1 + paramInt3 });
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofInt("bottom", new int[] { this.nZ.getBottom(), paramInt2 + paramInt4 });
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.nZ, new PropertyValuesHolder[] { localObject1, localObject2, localObject3, localPropertyValuesHolder });
    ((ObjectAnimator)localObject1).addListener(new sgg(this, paramInt4, paramInt3, paramInt1, paramInt2));
    localObject2 = a(this.nZ);
    localObject3 = a(this.oa);
    this.nZ.setScaleType(ImageView.ScaleType.MATRIX);
    localObject2 = ObjectAnimator.ofObject(this.nZ, jdField_a_of_type_AndroidUtilProperty, new sge.a(), new Matrix[] { localObject2, localObject3 });
    localObject3 = ObjectAnimator.ofInt(this.T, "backgroundColor", new int[] { -1, 16777215 });
    ((ValueAnimator)localObject3).setEvaluator(new ArgbEvaluator());
    this.M = new AnimatorSet();
    this.M.setDuration(200L);
    this.M.setInterpolator(b);
    this.M.addListener(new sgh(this));
    this.M.playTogether(new Animator[] { localObject1, localObject2, localObject3 });
    this.M.start();
  }
  
  public void a(sgl paramsgl)
  {
    if (this.jdField_a_of_type_Sgd != null) {
      this.jdField_a_of_type_Sgd.b(paramsgl);
    }
  }
  
  public FrameLayout e()
  {
    return this.aA;
  }
  
  static class a
    implements TypeEvaluator<Matrix>
  {
    public static TypeEvaluator<Matrix> a = new sgj();
    float[] aG = new float[9];
    float[] aH = new float[9];
    Matrix mTempMatrix = new Matrix();
    
    public Matrix a(float paramFloat, Matrix paramMatrix1, Matrix paramMatrix2)
    {
      paramMatrix1.getValues(this.aG);
      paramMatrix2.getValues(this.aH);
      int i = 0;
      while (i < 9)
      {
        float f1 = this.aH[i];
        float f2 = this.aG[i];
        this.aH[i] = ((f1 - f2) * paramFloat + this.aG[i]);
        i += 1;
      }
      this.mTempMatrix.setValues(this.aH);
      return this.mTempMatrix;
    }
  }
  
  public static class b
  {
    private final String asB = "image_url";
    private final String asC = "image_width";
    private final String asD = "image_height";
    int bhw;
    int bhx;
    public String image_url;
    
    public b() {}
    
    public b(String paramString, int paramInt1, int paramInt2)
    {
      this.image_url = paramString;
      this.bhw = paramInt1;
      this.bhx = paramInt2;
    }
    
    public String mb()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("image_url", this.image_url);
        localJSONObject.put("image_width", this.bhw);
        localJSONObject.put("image_height", this.bhx);
        return localJSONObject.toString();
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    
    public void qB(String paramString)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.image_url = paramString.getString("image_url");
        this.bhw = paramString.getInt("image_width");
        this.bhx = paramString.getInt("image_height");
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sge
 * JD-Core Version:    0.7.0.1
 */