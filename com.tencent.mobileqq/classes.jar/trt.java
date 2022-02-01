import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vpng.view.VPNGImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"ViewConstructor"})
class trt
  extends RelativeLayout
  implements View.OnClickListener
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  @Nullable
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  @Nullable
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(new trv(this));
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ApngDrawable.OnPlayRepeatListener jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener;
  @Nullable
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private VPNGImageView jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView;
  @Nullable
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private String jdField_a_of_type_JavaLangString;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private rlt jdField_a_of_type_Rlt = new tru(this);
  private rwf jdField_a_of_type_Rwf;
  private boolean jdField_a_of_type_Boolean;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_b_of_type_Boolean;
  private Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean = true;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private boolean jdField_d_of_type_Boolean = true;
  
  public trt(Activity paramActivity, @Nullable ListView paramListView, String paramString)
  {
    super(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramActivity.getWindow().getDecorView());
    this.jdField_a_of_type_JavaLangString = paramString;
    e();
  }
  
  @Nullable
  private Bitmap a(@Nullable View paramView, boolean paramBoolean)
  {
    Canvas localCanvas = null;
    Object localObject4 = null;
    Bitmap localBitmap1 = null;
    Object localObject2;
    Object localObject3;
    if (paramView != null)
    {
      paramView.setDrawingCacheEnabled(true);
      paramView.buildDrawingCache();
      localObject2 = localCanvas;
      localObject3 = localObject4;
    }
    try
    {
      Bitmap localBitmap2 = paramView.getDrawingCache();
      localObject2 = localCanvas;
      localObject3 = localObject4;
      localBitmap1 = Bitmap.createBitmap(localBitmap2.getWidth(), localBitmap2.getHeight(), localBitmap2.getConfig());
      localObject2 = localBitmap1;
      localObject3 = localBitmap1;
      localCanvas = new Canvas(localBitmap1);
      if (!paramBoolean)
      {
        localObject2 = localBitmap1;
        localObject3 = localBitmap1;
        localCanvas.drawColor(Color.parseColor("#f8f8f8"));
      }
      localObject2 = localBitmap1;
      localObject3 = localBitmap1;
      localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, null);
      return localBitmap1;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("KandianAdPandent", 2, "buildBitmapFromView, error" + localException.getMessage());
        localException.printStackTrace();
      }
      return localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("KandianAdPandent", 2, "buildBitmapFromView, error" + localOutOfMemoryError.getMessage());
        localOutOfMemoryError.printStackTrace();
      }
      return localObject3;
    }
    finally
    {
      paramView.setDrawingCacheEnabled(false);
      paramView.destroyDrawingCache();
    }
  }
  
  @Nullable
  private View a()
  {
    localObject2 = null;
    View localView = null;
    int j;
    int k;
    int i;
    if (this.jdField_a_of_type_ComTencentWidgetListView != null)
    {
      j = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
      k = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
      i = j;
    }
    for (;;)
    {
      localObject2 = localView;
      if (i <= k) {
        localObject2 = localView;
      }
      try
      {
        Object localObject3 = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter().getItem(i);
        localObject2 = localView;
        if ((localObject3 instanceof AdvertisementInfo))
        {
          localObject2 = localView;
          localObject3 = (AdvertisementInfo)localObject3;
          localObject2 = localView;
          if (tqi.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
          {
            localObject2 = localView;
            if (((AdvertisementInfo)localObject3).mAdAid == tqi.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid)
            {
              localObject2 = localView;
              localView = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i - j);
              localObject2 = localView;
              QLog.d("KandianAdPandent", 2, "hideAdsWithAnim, find AdvertisementInfo, targetPos=" + i + ", targetItemView=" + localView);
              localObject2 = localView;
              return localObject2;
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1 = localObject2;
        }
      }
      i += 1;
    }
  }
  
  private void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView == null) || (this.jdField_b_of_type_AndroidViewViewGroup == null)) {
      return;
    }
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setVisibility(0);
    g();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.jdField_b_of_type_AndroidViewViewGroup.getWidth() * 1.778F));
    localLayoutParams.addRule(13, -1);
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.setVideo(paramString, false, 1, new trw(this));
    c();
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("audio"));
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      b();
      return;
    case 3: 
      a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    b(this.jdField_a_of_type_JavaLangString);
  }
  
  private void b(String paramString)
  {
    a(false);
    g();
    if (QLog.isColorLevel()) {
      QLog.d("KandianAdPandent", 2, new Object[] { "initTVKVideoController with path:", paramString });
    }
    if (!new rwh().a()) {
      QLog.e("KandianAdPandent", 2, "sdk NOT installed");
    }
    this.jdField_a_of_type_Rwf = new rwf(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_Rwf.b();
    this.jdField_c_of_type_AndroidViewView.setId(2131369445);
    if (this.jdField_c_of_type_AndroidViewView != null) {
      a(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    this.jdField_a_of_type_Rwf.b(2);
    this.jdField_a_of_type_Rwf.a(this.jdField_a_of_type_Rwf.a());
    this.jdField_a_of_type_Rwf.a(this.jdField_a_of_type_Rlt);
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Rwf.a(null, paramString, 3, 1L, 0L, 0);
    this.jdField_a_of_type_Rwf.c(false);
    c();
  }
  
  private void e()
  {
    LayoutInflater.from(getContext()).inflate(2131560210, this, true);
    setId(2131369494);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131372369));
    this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView = ((VPNGImageView)findViewById(2131369442));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372364));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369255));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369252));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369253));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372370);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131372377);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369479));
    ((ImmersiveTitleBar2)findViewById(2131379186)).a(0);
    setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void f()
  {
    boolean bool2 = true;
    label43:
    label104:
    rwf localrwf;
    if (!this.jdField_c_of_type_Boolean)
    {
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      if (!this.jdField_c_of_type_Boolean) {
        break label136;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130849521));
      if ((this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer() != null) && (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a != null) && (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a.isPlaying()))
      {
        if (!this.jdField_c_of_type_Boolean) {
          break label159;
        }
        this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a.setVolume(1.0F, 1.0F);
      }
      if (this.jdField_a_of_type_Rwf != null)
      {
        localrwf = this.jdField_a_of_type_Rwf;
        if (this.jdField_c_of_type_Boolean) {
          break label177;
        }
      }
    }
    label136:
    label159:
    label177:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localrwf.c(bool1);
      return;
      bool1 = false;
      break;
      this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130849520));
      break label43;
      this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a.setVolume(0.0F, 0.0F);
      break label104;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
    }
    QLog.d("KandianAdPandent", 2, "current volume =  " + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Float = (this.jdField_a_of_type_Int / 5.0F);
    QLog.d("KandianAdPandent", 2, "current volume =  " + this.jdField_a_of_type_Int + "intervalVolume = " + this.jdField_a_of_type_Float);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject3 = a();
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity.findViewById(16908307);
    Object localObject2 = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131380604);
    int i;
    int j;
    if (localObject3 != null)
    {
      i = ((View)localObject3).getHeight();
      j = a((View)localObject3, this.jdField_b_of_type_AndroidViewViewGroup);
    }
    for (;;)
    {
      QLog.d("KandianAdPandent", 2, "hideAdsWithAnim, targetFeedsItemTop=" + j + ", targetFeedsItemHeight=" + i);
      if ((j >= 0) && (i > 0)) {}
      for (int k = 1; k != 0; k = 0)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = a((View)localObject3, false);
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          localObject3 = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).width = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
          ((ViewGroup.LayoutParams)localObject3).height = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
          this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
        }
        this.jdField_c_of_type_AndroidGraphicsBitmap = a((View)localObject2, true);
        if (this.jdField_c_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap);
          localObject3 = this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject3).height = this.jdField_c_of_type_AndroidGraphicsBitmap.getHeight();
          ((ViewGroup.LayoutParams)localObject3).width = this.jdField_c_of_type_AndroidGraphicsBitmap.getWidth();
          this.jdField_c_of_type_AndroidWidgetImageView.setY(((View)localObject2).getY());
          this.jdField_c_of_type_AndroidWidgetImageView.requestLayout();
        }
        this.jdField_b_of_type_AndroidGraphicsBitmap = a((View)localObject1, true);
        if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap);
          localObject2 = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).height = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
          ((ViewGroup.LayoutParams)localObject2).width = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
          this.jdField_b_of_type_AndroidWidgetImageView.setY(((View)localObject1).getY());
          this.jdField_b_of_type_AndroidWidgetImageView.requestLayout();
        }
        i = i / 2 + j - getHeight() / 2;
        QLog.d("KandianAdPandent", 2, "hideAdsWithAnim, centerDiff=" + i);
        localObject2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.2F, 1.0F });
        localObject3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleY", new float[] { 1.2F, 1.0F });
        Object localObject4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "alpha", new float[] { 0.0F, 1.0F });
        Object localObject5 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "translationY", new float[] { 0.0F, i });
        localObject1 = new AnimatorSet();
        ((AnimatorSet)localObject1).play((Animator)localObject2).with((Animator)localObject3).with((Animator)localObject4).with((Animator)localObject5);
        ((AnimatorSet)localObject1).setDuration(600L);
        localObject3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "alpha", new float[] { 1.0F, 0.0F });
        localObject4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "scaleY", new float[] { 1.0F, 0.8F });
        localObject5 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "scaleY", new float[] { 1.0F, 0.8F });
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "translationY", new float[] { 0.0F, i });
        localObject2 = new AnimatorSet();
        ((AnimatorSet)localObject2).play((Animator)localObject3).with(localObjectAnimator).with((Animator)localObject4).with((Animator)localObject5);
        ((AnimatorSet)localObject2).setDuration(600L);
        localObject3 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidViewView, "alpha", new float[] { 0.5F, 0.0F });
        ((ObjectAnimator)localObject3).setDuration(600L);
        localObject5 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "alpha", new float[] { 1.0F, 0.0F });
        localObject4 = new AnimatorSet();
        ((AnimatorSet)localObject4).play((Animator)localObject5).after(150L);
        ((AnimatorSet)localObject4).setDuration(150L);
        localObject5 = new AnimatorSet();
        ((AnimatorSet)localObject5).setInterpolator(new AccelerateDecelerateInterpolator());
        ((AnimatorSet)localObject5).playTogether(new Animator[] { localObject1, localObject2, localObject3, localObject4 });
        ((AnimatorSet)localObject5).start();
        this.jdField_a_of_type_Boolean = true;
        ((AnimatorSet)localObject5).addListener(new trx(this));
        return;
      }
      i();
      return;
      j = -1;
      i = 0;
    }
  }
  
  private void i()
  {
    a();
  }
  
  public int a(View paramView1, View paramView2)
  {
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (i > 30) {
        return j;
      }
      j = paramView1.getTop() + j;
      paramView1 = (View)paramView1.getParent();
      if ((paramView1 == null) || (paramView1 == paramView2)) {
        return j;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    if (getParent() != null)
    {
      ((ViewGroup)getParent()).removeView(this);
      this.jdField_b_of_type_Boolean = false;
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
    {
      localObject = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
      if ((localObject instanceof ApngDrawable))
      {
        localObject = (ApngDrawable)localObject;
        ((ApngDrawable)localObject).removeOnPlayRepeatListener(this.jdField_a_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener);
        ((ApngDrawable)localObject).setOnPlayRepeatListener(null);
      }
    }
    if (NetConnInfoCenter.getServerTimeMillis() - tqi.a().a() >= 1000L) {
      if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
        tqi.a().d(2);
      }
    }
    for (;;)
    {
      tqi.a().b(2);
      if (this.jdField_a_of_type_ComTencentWidgetListView != null)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
        if ((localObject instanceof blmb))
        {
          localObject = ((blmb)localObject).getWrappedAdapter();
          if ((localObject instanceof sel)) {
            ((sel)localObject).a(this.jdField_a_of_type_ComTencentWidgetListView, 0);
          }
        }
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView != null) {
        this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.onRelease();
      }
      if (this.jdField_a_of_type_Rwf != null)
      {
        this.jdField_a_of_type_Rwf.g();
        this.jdField_a_of_type_Rwf.h();
      }
      if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {}
      try
      {
        this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, this.jdField_a_of_type_Int, 4);
        tqi.a().c();
        return;
        QLog.d("ReadInJoySuperMaskAd", 1, "exposure time is less than one second, do not report strict");
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("KandianAdPandentMask", 2, "audioManager setStreamVolume error :" + localException.toString());
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (tqi.a(paramInt)) {}
    do
    {
      return;
      if (this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369494) == null)
      {
        b(paramInt);
        this.jdField_b_of_type_AndroidViewViewGroup.addView(this);
        this.jdField_b_of_type_Boolean = true;
      }
    } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true));
    tqi.a().d(1);
  }
  
  public void a(View paramView)
  {
    if ((paramView.getParent() != null) && ((paramView.getParent() instanceof ViewGroup))) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    a(this.jdField_c_of_type_AndroidViewView);
    a(this.jdField_d_of_type_AndroidWidgetImageView);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
    localLayoutParams.height = -1;
    localLayoutParams.width = -1;
    localLayoutParams.addRule(13, -1);
    paramViewGroup.addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
    localLayoutParams.height = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 27.0F);
    localLayoutParams.width = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 72.0F);
    localLayoutParams.rightMargin = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 20.0F);
    localLayoutParams.topMargin = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 60.0F);
    localLayoutParams.addRule(11, -1);
    paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(1, 1);
    localLayoutParams.height = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 26.0F);
    localLayoutParams.width = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 26.0F);
    localLayoutParams.rightMargin = bhgr.a(this.jdField_a_of_type_AndroidAppActivity, 2.0F);
    localLayoutParams.addRule(6, 2131369479);
    localLayoutParams.addRule(8, 2131369479);
    localLayoutParams.addRule(0, 2131369479);
    paramViewGroup.addView(this.jdField_d_of_type_AndroidWidgetImageView, localLayoutParams);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  void b() {}
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView != null) && (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer() != null) && (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a != null))
    {
      if (!paramBoolean) {
        break label70;
      }
      this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.onResume();
    }
    label70:
    do
    {
      for (;;)
      {
        if (this.jdField_a_of_type_Rwf != null)
        {
          if (!paramBoolean) {
            break;
          }
          if (this.jdField_a_of_type_Rwf.e()) {
            this.jdField_a_of_type_Rwf.d();
          }
        }
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.getVPNGRenderer().a.isPlaying()) {
          this.jdField_a_of_type_ComTencentMobileqqVpngViewVPNGImageView.onPause();
        }
      }
    } while (!this.jdField_a_of_type_Rwf.f());
    this.jdField_a_of_type_Rwf.f();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_AndroidMediaAudioManager == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, 0, 4);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null)
    {
      int i = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
      if (i >= this.jdField_a_of_type_Int) {
        this.jdField_d_of_type_Boolean = false;
      }
      i = (int)Math.ceil(i + this.jdField_a_of_type_Float);
      QLog.d("KandianAdPandent", 2, "updateVolume setVolume =  " + i);
      this.jdField_a_of_type_AndroidMediaAudioManager.setStreamVolume(3, i, 4);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    label78:
    long l;
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131369494: 
      tqi.a().c(1);
      tly localtly = tqi.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo;
      if (this.jdField_c_of_type_Boolean)
      {
        localObject = "1";
        localtly.f = ((String)localObject);
        if ((this.jdField_a_of_type_ComTencentWidgetListView == null) || (this.jdField_a_of_type_ComTencentWidgetListView.getAdapter() == null) || (!(this.jdField_a_of_type_ComTencentWidgetListView.getAdapter() instanceof blmb))) {
          break label376;
        }
        localObject = (blmb)this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
        if ((((blmb)localObject).getWrappedAdapter() == null) || (!(((blmb)localObject).getWrappedAdapter() instanceof sek))) {
          break label376;
        }
        localObject = (sek)((blmb)localObject).getWrappedAdapter();
        if (localObject != null)
        {
          ((sek)localObject).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = ubd.a(getContext(), tqi.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (sel)localObject, 0, false, null);
          if (((sek)localObject).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params == null) {
            break label265;
          }
          l = SystemClock.elapsedRealtime();
          label196:
          ((sek)localObject).jdField_a_of_type_Long = l;
        }
      }
      break;
    }
    for (;;)
    {
      tqi.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickPos = 11;
      ubd.a(this.jdField_a_of_type_AndroidAppActivity, tqi.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, (sel)localObject, 0, false, false, null);
      tqi.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.pauseVideo();
      }
      i();
      break;
      localObject = "0";
      break label78;
      label265:
      l = -2147483648L;
      break label196;
      tqi.a().c(nzq.C);
      if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.pauseVideo();
      }
      this.jdField_c_of_type_Boolean = false;
      f();
      h();
      break;
      if (this.jdField_c_of_type_Boolean)
      {
        tqi.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.f = "0";
        tqi.a().c(nzq.D);
      }
      for (;;)
      {
        f();
        break;
        tqi.a().jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.f = "1";
        tqi.a().c(nzq.E);
      }
      label376:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trt
 * JD-Core Version:    0.7.0.1
 */