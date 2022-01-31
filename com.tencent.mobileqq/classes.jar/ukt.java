import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.11;
import com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.3;
import com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.4;
import com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.8;
import com.tencent.biz.qqstory.album.view.RoundCornerLayout;
import com.tencent.biz.qqstory.album.view.StoryFormSwitchItem;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideProgressNotifier;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import java.util.List;
import mqq.os.MqqHandler;

public class ukt
  implements Handler.Callback, View.OnClickListener, ulf
{
  public static float a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  private RecyclerView.OnChildAttachStateChangeListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnChildAttachStateChangeListener = new ulb(this);
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new ukv(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bmaa jdField_a_of_type_Bmaa;
  private StoryFormSwitchItem jdField_a_of_type_ComTencentBizQqstoryAlbumViewStoryFormSwitchItem;
  private SlideProgressNotifier jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier;
  private SpeedFlexibleRecyclerView jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private uio jdField_a_of_type_Uio = (uio)uwa.a(30);
  private ukl jdField_a_of_type_Ukl;
  private ulc jdField_a_of_type_Ulc;
  private uld jdField_a_of_type_Uld;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int = -1;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int = -1;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int = -1;
  private boolean jdField_l_of_type_Boolean;
  private int m = -1;
  
  static
  {
    jdField_a_of_type_Float = 0.85F;
  }
  
  public ukt(Activity paramActivity, View paramView, @NonNull ulc paramulc)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Ulc = paramulc;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidViewView.getResources().getDisplayMetrics().widthPixels;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidViewView.getResources().getDisplayMetrics().heightPixels;
    if (bnsm.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int))
    {
      this.jdField_h_of_type_Int = ((int)(this.jdField_a_of_type_Int * 0.38D / 2.0D * 3.0D));
      this.jdField_i_of_type_Int = ((int)(this.jdField_a_of_type_Int * 0.47D / 2.0D * 3.0D));
      this.jdField_g_of_type_Int = ((int)(this.jdField_a_of_type_Int * 0.47D));
    }
    for (this.jdField_f_of_type_Int = ((int)(this.jdField_a_of_type_Int * 0.38D));; this.jdField_f_of_type_Int = ((int)(this.jdField_a_of_type_Int * 0.53D)))
    {
      this.jdField_e_of_type_Int = ((this.jdField_g_of_type_Int - this.jdField_f_of_type_Int) / 2);
      this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_Int * 0.1D - this.jdField_e_of_type_Int) / 2);
      this.jdField_d_of_type_Int = ((this.jdField_a_of_type_Int - this.jdField_g_of_type_Int) / 2);
      uik.a().a();
      return;
      this.jdField_h_of_type_Int = ((int)(this.jdField_a_of_type_Int * 0.53D / 2.0D * 3.0D));
      this.jdField_i_of_type_Int = ((int)(this.jdField_a_of_type_Int * 0.62D / 2.0D * 3.0D));
      this.jdField_g_of_type_Int = ((int)(this.jdField_a_of_type_Int * 0.62D));
    }
  }
  
  private static float a(int paramInt1, int paramInt2, float paramFloat)
  {
    return 1.0F - (paramInt1 - paramInt2) * paramFloat / paramInt1;
  }
  
  public static float a(ukl paramukl, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramukl.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.width = ((int)(paramukl.jdField_a_of_type_AndroidViewView.getWidth() * 0.95F));
    paramukl.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    paramukl.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramukl.jdField_a_of_type_AndroidWidgetTextView.getTextColors().withAlpha((int)(255.0F * paramFloat)));
    paramukl.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramukl.jdField_c_of_type_AndroidWidgetTextView.getTextColors().withAlpha((int)(178.5F * paramFloat)));
    paramukl.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramukl.jdField_b_of_type_AndroidWidgetTextView.getTextColors().withAlpha((int)(153.0F * paramFloat)));
    float f1 = 0.2F * paramFloat + 0.8F;
    paramukl.jdField_a_of_type_AndroidWidgetLinearLayout.setScaleX(f1);
    paramukl.jdField_a_of_type_AndroidWidgetLinearLayout.setScaleY(f1);
    paramukl.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setAlpha(jdField_a_of_type_Float);
    f1 = a(paramInt2, paramInt1, 1.0F - paramFloat);
    float f2 = a(paramInt4, paramInt3, 1.0F - paramFloat);
    paramukl.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setScaleX(f1);
    paramukl.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setScaleY(f2);
    f1 = jdField_a_of_type_Float;
    f2 = jdField_a_of_type_Float;
    paramukl.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setAlpha(f1 * paramFloat + f2);
    QLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", 4, " setVideoItemScale i=" + paramInt5 + " percent=" + paramFloat);
    return paramFloat;
  }
  
  private void a(long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new AlbumGalleryCapturePart.8(this), paramLong);
  }
  
  private void b(uiz paramuiz)
  {
    wxe.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "preload album :%s", paramuiz);
    if ((this.jdField_b_of_type_Long == -1L) || (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 30000L))
    {
      xna.a().a(paramuiz);
      xna.a().h();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131700540));
      return;
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setText(alud.a(2131700562));
  }
  
  private void c(uiz paramuiz)
  {
    if (paramuiz.jdField_d_of_type_Int == 1)
    {
      this.jdField_a_of_type_Ulc.b();
      wxj.a("video_shoot_slides", "clk_selectbutton", 0, 0, new String[0]);
    }
    do
    {
      return;
      if (paramuiz.jdField_d_of_type_Int == 4)
      {
        this.jdField_a_of_type_Ulc.b();
        wxj.a("video_shoot_slides", "clk_noalbum", 0, 0, new String[0]);
        return;
      }
      if (paramuiz.jdField_d_of_type_Int == 5)
      {
        wxj.a("video_shoot_slides", "clk_research", 0, 0, new String[0]);
        if (!xrn.a(this.jdField_a_of_type_AndroidAppActivity))
        {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, alud.a(2131700571), 0).a();
          return;
        }
        g();
        return;
      }
    } while (paramuiz.jdField_d_of_type_Int != 3);
    h();
    wxj.a("video_shoot_slides", "clk_onalbum", 0, 0, new String[0]);
  }
  
  private void d(uiz paramuiz)
  {
    if (this.jdField_l_of_type_Boolean)
    {
      wxe.e("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "you have clicked album when handling");
      return;
    }
    this.jdField_l_of_type_Boolean = true;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    wxj.a("video_shoot_slides", "clk_makebutton", 0, 0, new String[] { String.valueOf(paramuiz.d()) });
    Bosses.get().postJob(new ukw(this, paramuiz));
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362531);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362449);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376342));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365032));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362515));
    this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131362517);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362518));
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewStoryFormSwitchItem = ((StoryFormSwitchItem)this.jdField_a_of_type_AndroidViewView.findViewById(2131362519));
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewStoryFormSwitchItem.setOnCheckedChangeListener(new uku(this));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131362516).setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView = ((SpeedFlexibleRecyclerView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363937));
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setMaxFlingVelocityX();
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setNestedScrollingEnabled(true);
    this.jdField_a_of_type_Uld = new uld(this.jdField_a_of_type_AndroidAppActivity, this, this.jdField_g_of_type_Int, this.jdField_i_of_type_Int);
    this.jdField_a_of_type_Uld.a(this.jdField_f_of_type_Int, this.jdField_h_of_type_Int);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setAdapter(this.jdField_a_of_type_Uld);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidViewView.getContext(), 0, false);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager);
    blrh localblrh = new blrh(this.jdField_c_of_type_Int, this.jdField_c_of_type_Int, 0, 0);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.addItemDecoration(localblrh);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setOverScrollMode(2);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setPadding(this.jdField_d_of_type_Int - this.jdField_c_of_type_Int, 0, this.jdField_d_of_type_Int + this.jdField_c_of_type_Int, 0);
    this.jdField_a_of_type_Bmaa = new bmaa();
    this.jdField_a_of_type_Bmaa.a(this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView);
    this.jdField_a_of_type_JavaLangRunnable = new AlbumGalleryCapturePart.3(this);
    this.jdField_b_of_type_JavaLangRunnable = new AlbumGalleryCapturePart.4(this);
    this.jdField_b_of_type_Boolean = uvt.i();
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.addOnChildAttachStateChangeListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnChildAttachStateChangeListener);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier = new SlideProgressNotifier(this.jdField_a_of_type_AndroidAppActivity, 2131561236);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier.a(new uky(this));
    this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new ukz(this));
    this.jdField_a_of_type_AndroidViewView.requestLayout();
    j();
  }
  
  private void g()
  {
    if (!this.jdField_a_of_type_Uio.a())
    {
      wxe.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data error ,detect user close scan!");
      return;
    }
    Bosses.get().postJob(new ula(this));
  }
  
  private void h()
  {
    wxe.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "open album");
    this.jdField_a_of_type_Uio.a(true);
    g();
    d();
  }
  
  private void i()
  {
    wxe.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "close album");
    this.jdField_a_of_type_Uio.a(false);
    this.jdField_a_of_type_Uld.c();
    d();
  }
  
  private void j()
  {
    boolean bool = this.jdField_a_of_type_Uio.a();
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewStoryFormSwitchItem.setChecked(bool);
    b(bool);
  }
  
  private void k()
  {
    uiz localuiz = this.jdField_a_of_type_Uld.a();
    if (localuiz != null)
    {
      if (!localuiz.a()) {
        break label173;
      }
      if ((localuiz.jdField_d_of_type_Int == 1) || (localuiz.jdField_d_of_type_Int == 4))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131700572));
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      }
    }
    else
    {
      return;
    }
    if (localuiz.jdField_d_of_type_Int == 3)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131700547));
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      return;
    }
    if (localuiz.jdField_d_of_type_Int == 5)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131700552));
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      return;
    }
    if (localuiz.jdField_d_of_type_Int == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131700541));
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.5F);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131700543));
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.5F);
    return;
    label173:
    this.jdField_a_of_type_AndroidWidgetTextView.setText(alud.a(2131700548));
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
  }
  
  private void l() {}
  
  public float a(View paramView)
  {
    int n = Math.min(paramView.getLeft(), this.jdField_a_of_type_Int - paramView.getRight());
    float f1 = this.jdField_f_of_type_Int / 2.0F;
    f1 = (n + f1) / (this.jdField_a_of_type_Int / 2.0F);
    if (f1 < 0.0F) {
      return 0.0F;
    }
    if (f1 > 1.0F) {
      return 1.0F;
    }
    return f1;
  }
  
  public void a()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    wxe.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "on destroy");
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier.b();
    }
    if (this.jdField_a_of_type_Ukl != null)
    {
      this.jdField_a_of_type_Ukl.c();
      this.jdField_a_of_type_Ukl = null;
    }
    if (this.jdField_a_of_type_Uld != null) {
      this.jdField_a_of_type_Uld.a();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_f_of_type_Boolean) {
      wxj.a("video_shoot_slides", "exp_selectbutton", 0, 0, new String[0]);
    }
    if (this.jdField_g_of_type_Boolean) {
      wxj.a("video_shoot_slides", "exp_noalbum", 0, 0, new String[0]);
    }
    if (this.jdField_h_of_type_Boolean) {
      wxj.a("video_shoot_slides", "exp_research", 0, 0, new String[0]);
    }
    if (this.jdField_i_of_type_Boolean) {
      wxj.a("video_shoot_slides", "exp_onalbum", 0, 0, new String[0]);
    }
    if (this.jdField_l_of_type_Int >= 0) {
      wxj.a("video_shoot_slides", "swap_smartalbum", 0, 0, new String[] { String.valueOf(this.jdField_l_of_type_Int) });
    }
    try
    {
      QQLiveImage.onBackground(this.jdField_a_of_type_AndroidAppActivity);
      return;
    }
    catch (Exception localException)
    {
      wxe.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "QQLiveImage background , error :%s", localException);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    wxe.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "on create");
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Long = paramBundle.getLong("BUNDLE_KEY_LOCATE_ALBUM_ID", -1L);
      this.jdField_k_of_type_Int = paramBundle.getInt("BUNDLE_KEY_LOCATE_INDEX", -1);
      wxe.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "onCreate albumId = %s , index = %d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_k_of_type_Int) });
    }
    f();
    g();
  }
  
  public void a(uiz paramuiz)
  {
    if (this.jdField_k_of_type_Boolean) {
      wxe.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "album scrolling , select ignore :%s", new Object[] { paramuiz });
    }
    while (paramuiz == null) {
      return;
    }
    wxe.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "on album select :%s", paramuiz);
    if (paramuiz.a())
    {
      c(paramuiz);
      return;
    }
    d(paramuiz);
  }
  
  public void a(uiz paramuiz, int paramInt)
  {
    a(300L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1005);
    if ((paramBoolean) && (!this.jdField_e_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1006, 6000L);
      this.jdField_e_of_type_Boolean = true;
    }
    wxe.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "onReceiveScanResult :%s", Boolean.valueOf(paramBoolean));
  }
  
  public void b()
  {
    wxe.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "on resume");
    if (this.jdField_a_of_type_Ukl != null)
    {
      wxe.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "onResume, startPlay");
      this.jdField_a_of_type_Ukl.b();
    }
  }
  
  public void c()
  {
    wxe.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "on stop");
    if (this.jdField_a_of_type_Ukl != null) {
      this.jdField_a_of_type_Ukl.c();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_l_of_type_Boolean = false;
  }
  
  public void d()
  {
    int i1 = this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildCount();
    int n = 0;
    for (;;)
    {
      if (n < i1)
      {
        Object localObject = this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildAt(n);
        float f1 = a((View)localObject);
        localObject = (ukl)this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildViewHolder((View)localObject);
        if (localObject != null) {
          a((ukl)localObject, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, f1, n);
        }
        if (f1 <= 0.8F) {
          break label134;
        }
        if (this.m == n) {
          break label107;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1003);
      }
      for (;;)
      {
        this.m = n;
        return;
        label107:
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1003, 300L);
      }
      label134:
      n += 1;
    }
  }
  
  public void e()
  {
    k();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int n = 0;
    boolean bool2 = false;
    switch (paramMessage.what)
    {
    }
    label215:
    label353:
    do
    {
      do
      {
        return true;
        paramMessage = this.jdField_a_of_type_Bmaa.a(this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getLayoutManager());
        if (paramMessage == null)
        {
          wxe.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "on handle find snap msg , not found snap view !");
          return true;
        }
        ukl localukl = (ukl)this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildViewHolder(paramMessage);
        if ((this.jdField_a_of_type_Ukl != null) && (this.jdField_a_of_type_Ukl != localukl)) {
          this.jdField_a_of_type_Ukl.c();
        }
        if ((localukl != null) && (this.jdField_a_of_type_Ukl != localukl))
        {
          localukl.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setAlpha(1.0F);
          wxe.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "SNAP, startPlay");
          localukl.b();
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager.getPosition(paramMessage) == 0) && (!this.jdField_a_of_type_Boolean)) {
            this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.postDelayed(new AlbumGalleryCapturePart.11(this), 3500L);
          }
        }
        this.jdField_a_of_type_Ukl = localukl;
        int i1 = this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildAdapterPosition(paramMessage);
        if (i1 != this.jdField_a_of_type_Uld.a())
        {
          n = 1;
          this.jdField_a_of_type_Uld.a(this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView, i1);
          boolean bool1 = bool2;
          if (this.jdField_e_of_type_Boolean)
          {
            bool1 = bool2;
            if (n != 0) {
              bool1 = true;
            }
          }
          this.jdField_e_of_type_Boolean = bool1;
          k();
          this.jdField_l_of_type_Int = Math.max(this.jdField_a_of_type_Uld.a(), this.jdField_l_of_type_Int);
          paramMessage = this.jdField_a_of_type_Uld.a();
          if ((paramMessage != null) && (!paramMessage.a()) && (n != 0)) {
            b(this.jdField_a_of_type_Uld.a());
          }
          if ((paramMessage != null) && (paramMessage.a()))
          {
            if (paramMessage.jdField_d_of_type_Int != 1) {
              break label353;
            }
            this.jdField_f_of_type_Boolean = true;
          }
        }
        while (this.jdField_d_of_type_Boolean)
        {
          l();
          return true;
          n = 0;
          break label215;
          if (paramMessage.jdField_d_of_type_Int == 4) {
            this.jdField_g_of_type_Boolean = true;
          } else if (paramMessage.jdField_d_of_type_Int == 3) {
            this.jdField_i_of_type_Boolean = true;
          } else if (paramMessage.jdField_d_of_type_Int == 5) {
            this.jdField_h_of_type_Boolean = true;
          } else if (paramMessage.jdField_d_of_type_Int != 2) {}
        }
        paramMessage = this.jdField_a_of_type_Uld.a();
        if (this.jdField_a_of_type_Long != -1L) {
          while (n < paramMessage.size())
          {
            if (((uiz)paramMessage.get(n)).a() == this.jdField_a_of_type_Long)
            {
              this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager.scrollToPosition(n);
              a(200L);
              this.jdField_a_of_type_Long = -1L;
              wxe.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "start ,scroll to position %d automatically", Integer.valueOf(n));
              return true;
            }
            n += 1;
          }
        }
      } while ((this.jdField_k_of_type_Int < 0) || (this.jdField_k_of_type_Int >= paramMessage.size()));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager.scrollToPosition(this.jdField_k_of_type_Int);
      a(200L);
      this.jdField_k_of_type_Int = -1;
      wxe.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "start ,scroll to position %d automatically", Integer.valueOf(this.jdField_k_of_type_Int));
      return true;
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, alud.a(2131700558), 0).a();
      this.jdField_a_of_type_Uld.d();
      return true;
      wxe.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "handle msg ,showAfterLoadingTip : %s", Boolean.valueOf(this.jdField_e_of_type_Boolean));
    } while (!this.jdField_e_of_type_Boolean);
    n = this.jdField_a_of_type_Uld.a();
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.smoothScrollToPosition(n + 1);
    a(200L);
    this.jdField_e_of_type_Boolean = false;
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131376342: 
    case 2131362449: 
      do
      {
        do
        {
          return;
          paramView = this.jdField_a_of_type_Uld.a();
        } while (paramView == null);
        long l1 = SystemClock.uptimeMillis();
        if (l1 - this.jdField_c_of_type_Long > 500L) {
          a(paramView);
        }
        for (;;)
        {
          this.jdField_c_of_type_Long = l1;
          return;
          wxe.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "you click too fast, wait...");
        }
      } while (this.jdField_a_of_type_Ulc == null);
      this.jdField_a_of_type_Ulc.a();
      return;
    case 2131362515: 
      if (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0)
      {
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845978);
      }
      for (;;)
      {
        wxj.a("video_shoot_slides", "clk_setting", 0, 0, new String[0]);
        return;
        this.jdField_j_of_type_Boolean = true;
        j();
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845979);
      }
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ukt
 * JD-Core Version:    0.7.0.1
 */