import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

public class ahie
  extends ahgq
{
  private boolean che;
  private ImageView wp;
  
  public ahie(Intent paramIntent)
  {
    super(paramIntent);
    this.che = paramIntent.getBooleanExtra("direct_send_emoji", false);
    this.cZS = 4;
  }
  
  public void H(int paramInt, Bundle paramBundle)
  {
    if (this.che)
    {
      if (paramInt >= 0) {
        this.bf.putInt("key_forward_ability_type", paramInt);
      }
      if (paramBundle != null) {
        this.bf.putAll(paramBundle);
      }
      dnv();
      return;
    }
    super.H(paramInt, paramBundle);
  }
  
  protected boolean anl()
  {
    Intent localIntent = new Intent(this.mActivity, SplashActivity.class);
    localIntent.putExtras(this.bf);
    ForwardUtils.a(this.app, this.mActivity, this.mAppContext, localIntent, null);
    this.mActivity.setResult(-1, localIntent);
    this.mActivity.finish();
    return false;
  }
  
  protected boolean ans()
  {
    return true;
  }
  
  protected View cc()
  {
    FrameLayout localFrameLayout = new FrameLayout(this.mActivity);
    localFrameLayout.setMinimumHeight(aqnm.dip2px(85.0F));
    int i = aqnm.dip2px(15.0F);
    localFrameLayout.setPadding(0, i, 0, i);
    ImageView localImageView = new ImageView(this.mActivity);
    localImageView.setAdjustViewBounds(true);
    localImageView.setMaxWidth(aqnm.dip2px(120.0F));
    localImageView.setMaxHeight(aqnm.dip2px(120.0F));
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    localFrameLayout.addView(localImageView, new FrameLayout.LayoutParams(-2, -2, 17));
    this.wp = localImageView;
    doh();
    return localFrameLayout;
  }
  
  protected void dnr()
  {
    if (anv()) {
      this.cs.add(U);
    }
    if (anw()) {
      this.cs.add(T);
    }
    if (anx()) {
      this.cs.add(S);
    }
  }
  
  protected void doh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardMarketFaceOption", 2, "setPreviewImage");
    }
    if (this.bf.getBoolean("forward_emotion_from_preview", false)) {}
    for (Object localObject = AIOEmotionFragment.f; localObject == null; localObject = MarketFaceItemBuilder.b) {
      return;
    }
    localObject = ((afpu)localObject).a("fromAIO", false);
    ((URLDrawable)localObject).setBounds(aqhu.a((Drawable)localObject, 36, 100, this.mDensity));
    this.wp.setImageDrawable((Drawable)localObject);
    ((URLDrawable)localObject).setURLDrawableListener(new ahif(this));
  }
  
  public void onPause()
  {
    super.onPause();
    AbstractGifImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    AbstractGifImage.resumeAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahie
 * JD-Core Version:    0.7.0.1
 */