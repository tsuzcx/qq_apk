import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader;
import com.tencent.biz.qqcircle.QCircleFeedPicLoader.b;
import com.tencent.biz.qqcircle.transition.QCircleTransitionImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class pdk
{
  private File G;
  private QCircleTransitionImageView jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView;
  private pdk.a jdField_a_of_type_Pdk$a;
  private sgd jdField_a_of_type_Sgd;
  private FrameLayout aA;
  private QCircleTransitionImageView b;
  private int bhu;
  private int bhv;
  private int mImageHeight;
  private String mImageUrl;
  private int mImageWidth;
  private Rect mRect;
  private ImageView.ScaleType mScaleType;
  
  public pdk(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
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
      localObject = "";
      try
      {
        if ((paramURLImageView.getTag(2131374559) instanceof String))
        {
          localObject = (String)paramURLImageView.getTag(2131374559);
          localObject = QCircleFeedPicLoader.a().b(new QCircleFeedPicLoader.b().a((String)localObject));
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localBundle.putString("bundle_key_source_image_param", new pdk.a((String)localObject, paramInt1, paramInt2).mb());
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
  
  private int[] a(int paramInt1, int paramInt2)
  {
    paramInt1 = (int)(paramInt2 / paramInt1 * ImmersiveUtils.getScreenWidth());
    return new int[] { ImmersiveUtils.getScreenWidth(), paramInt1 };
  }
  
  private void aT(Bundle paramBundle)
  {
    this.jdField_a_of_type_Sgd = new sgd();
    this.mRect = ((Rect)paramBundle.getParcelable("bundle_key_trans_anim_rect"));
    String str = paramBundle.getString("bundle_key_source_image_param");
    this.jdField_a_of_type_Pdk$a = new pdk.a();
    this.jdField_a_of_type_Pdk$a.qB(str);
    this.mImageUrl = this.jdField_a_of_type_Pdk$a.image_url;
    this.G = new File(this.mImageUrl);
    this.mImageWidth = this.jdField_a_of_type_Pdk$a.bhw;
    this.mImageHeight = this.jdField_a_of_type_Pdk$a.bhx;
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
    this.aA.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.aA.setBackgroundColor(-16777216);
  }
  
  private void bjL()
  {
    if ((this.jdField_a_of_type_Sgd != null) && (this.jdField_a_of_type_Sgd.isErrorState())) {}
    while (this.aA == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView = new QCircleTransitionImageView(this.aA.getContext());
    this.aA.addView(this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.getLayoutParams();
    localLayoutParams.width = this.mRect.width();
    localLayoutParams.height = this.mRect.height();
    localLayoutParams.setMargins(this.mRect.left, this.mRect.top, 0, 0);
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setScaleType(this.mScaleType);
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setImageURI(Uri.fromFile(this.G));
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.setVisibility(4);
  }
  
  private void bjM()
  {
    if ((this.jdField_a_of_type_Sgd != null) && (this.jdField_a_of_type_Sgd.isErrorState())) {
      return;
    }
    if (this.aA != null)
    {
      this.b = new QCircleTransitionImageView(this.aA.getContext());
      this.aA.addView(this.b);
      this.b.setVisibility(4);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 17;
      this.b.setLayoutParams(localLayoutParams);
      this.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.b.setImageURI(Uri.fromFile(this.G));
    }
    this.jdField_a_of_type_Sgd.setState(1);
  }
  
  private void bjN()
  {
    int[] arrayOfInt = a(this.mImageWidth, this.mImageHeight);
    if ((arrayOfInt != null) && (arrayOfInt.length == 2))
    {
      this.bhu = arrayOfInt[0];
      this.bhv = arrayOfInt[1];
    }
  }
  
  private void bjO()
  {
    if ((this.jdField_a_of_type_Sgd == null) || (!this.jdField_a_of_type_Sgd.Mg())) {
      QLog.d("QCircleTransitionAnimHelper", 1, "initImageEnterAnimation error!");
    }
    while (this.b == null) {
      return;
    }
    this.b.getViewTreeObserver().addOnPreDrawListener(new pdl(this));
  }
  
  private void bjP()
  {
    if (this.jdField_a_of_type_Sgd != null) {
      this.jdField_a_of_type_Sgd.setState(2);
    }
    this.b.setVisibility(0);
    this.b.a(this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionImageView.a(), new pdm(this));
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
  
  public static class a
  {
    private final String asB = "image_url";
    private final String asC = "image_width";
    private final String asD = "image_height";
    int bhw;
    int bhx;
    public String image_url;
    
    public a() {}
    
    public a(String paramString, int paramInt1, int paramInt2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdk
 * JD-Core Version:    0.7.0.1
 */