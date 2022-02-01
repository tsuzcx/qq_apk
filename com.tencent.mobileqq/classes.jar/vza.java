import android.app.Activity;
import android.content.res.ColorStateList;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.11;
import com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.8;
import com.tencent.biz.qqstory.album.view.RoundCornerLayout;
import com.tencent.biz.qqstory.album.view.StoryFormSwitchItem;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideProgressNotifier;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import java.util.List;
import mqq.os.MqqHandler;

public class vza
  implements Handler.Callback, View.OnClickListener, vzg
{
  public static float a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RecyclerView.LayoutManager jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bonx jdField_a_of_type_Bonx;
  private StoryFormSwitchItem jdField_a_of_type_ComTencentBizQqstoryAlbumViewStoryFormSwitchItem;
  private SlideProgressNotifier jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideProgressNotifier;
  private SpeedFlexibleRecyclerView jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private vwv jdField_a_of_type_Vwv;
  private vys jdField_a_of_type_Vys;
  private vze jdField_a_of_type_Vze;
  private vzf jdField_a_of_type_Vzf;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
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
  private boolean j;
  private boolean k;
  
  static
  {
    jdField_a_of_type_Float = 0.85F;
  }
  
  private static float a(int paramInt1, int paramInt2, float paramFloat)
  {
    return 1.0F - (paramInt1 - paramInt2) * paramFloat / paramInt1;
  }
  
  public static float a(vys paramvys, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramvys.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.width = ((int)(paramvys.jdField_a_of_type_AndroidViewView.getWidth() * 0.95F));
    paramvys.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    paramvys.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramvys.jdField_a_of_type_AndroidWidgetTextView.getTextColors().withAlpha((int)(255.0F * paramFloat)));
    paramvys.c.setTextColor(paramvys.c.getTextColors().withAlpha((int)(178.5F * paramFloat)));
    paramvys.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramvys.jdField_b_of_type_AndroidWidgetTextView.getTextColors().withAlpha((int)(153.0F * paramFloat)));
    float f1 = 0.2F * paramFloat + 0.8F;
    paramvys.jdField_a_of_type_AndroidWidgetLinearLayout.setScaleX(f1);
    paramvys.jdField_a_of_type_AndroidWidgetLinearLayout.setScaleY(f1);
    paramvys.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setAlpha(jdField_a_of_type_Float);
    f1 = a(paramInt2, paramInt1, 1.0F - paramFloat);
    float f2 = a(paramInt4, paramInt3, 1.0F - paramFloat);
    paramvys.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setScaleX(f1);
    paramvys.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setScaleY(f2);
    f1 = jdField_a_of_type_Float;
    f2 = jdField_a_of_type_Float;
    paramvys.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setAlpha(f1 * paramFloat + f2);
    QLog.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", 4, " setVideoItemScale i=" + paramInt5 + " percent=" + paramFloat);
    return paramFloat;
  }
  
  private void a(long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new AlbumGalleryCapturePart.8(this), paramLong);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131699659));
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(anvx.a(2131699681));
  }
  
  private void b(vxg paramvxg)
  {
    ykq.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "preload album :%s", paramvxg);
    if ((this.jdField_b_of_type_Long == -1L) || (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 30000L))
    {
      yzz.a().a(paramvxg);
      yzz.a().h();
    }
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Vwv.a())
    {
      ykq.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "load data error ,detect user close scan!");
      return;
    }
    Bosses.get().postJob(new vzd(this));
  }
  
  private void c(vxg paramvxg)
  {
    if (paramvxg.jdField_d_of_type_Int == 1)
    {
      this.jdField_a_of_type_Vze.b();
      ykv.a("video_shoot_slides", "clk_selectbutton", 0, 0, new String[0]);
    }
    do
    {
      return;
      if (paramvxg.jdField_d_of_type_Int == 4)
      {
        this.jdField_a_of_type_Vze.b();
        ykv.a("video_shoot_slides", "clk_noalbum", 0, 0, new String[0]);
        return;
      }
      if (paramvxg.jdField_d_of_type_Int == 5)
      {
        ykv.a("video_shoot_slides", "clk_research", 0, 0, new String[0]);
        if (!zei.a(this.jdField_a_of_type_AndroidAppActivity))
        {
          QQToast.a(this.jdField_a_of_type_AndroidAppActivity, anvx.a(2131699690), 0).a();
          return;
        }
        c();
        return;
      }
    } while (paramvxg.jdField_d_of_type_Int != 3);
    d();
    ykv.a("video_shoot_slides", "clk_onalbum", 0, 0, new String[0]);
  }
  
  private void d()
  {
    ykq.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "open album");
    this.jdField_a_of_type_Vwv.a(true);
    c();
    a();
  }
  
  private void d(vxg paramvxg)
  {
    if (this.k)
    {
      ykq.e("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "you have clicked album when handling");
      return;
    }
    this.k = true;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    ykv.a("video_shoot_slides", "clk_makebutton", 0, 0, new String[] { String.valueOf(paramvxg.d()) });
    Bosses.get().postJob(new vzb(this, paramvxg));
  }
  
  private void e()
  {
    boolean bool = this.jdField_a_of_type_Vwv.a();
    this.jdField_a_of_type_ComTencentBizQqstoryAlbumViewStoryFormSwitchItem.setChecked(bool);
    a(bool);
  }
  
  private void f()
  {
    vxg localvxg = this.jdField_a_of_type_Vzf.a();
    if (localvxg != null)
    {
      if (!localvxg.a()) {
        break label173;
      }
      if ((localvxg.jdField_d_of_type_Int == 1) || (localvxg.jdField_d_of_type_Int == 4))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131699691));
        this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      }
    }
    else
    {
      return;
    }
    if (localvxg.jdField_d_of_type_Int == 3)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131699666));
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      return;
    }
    if (localvxg.jdField_d_of_type_Int == 5)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131699671));
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
      return;
    }
    if (localvxg.jdField_d_of_type_Int == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131699660));
      this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.5F);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131699662));
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(0.5F);
    return;
    label173:
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131699667));
    this.jdField_a_of_type_AndroidWidgetTextView.setAlpha(1.0F);
  }
  
  private void g() {}
  
  public float a(View paramView)
  {
    int m = Math.min(paramView.getLeft(), this.jdField_a_of_type_Int - paramView.getRight());
    float f1 = this.jdField_c_of_type_Int / 2.0F;
    f1 = (m + f1) / (this.jdField_a_of_type_Int / 2.0F);
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
    int n = this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildCount();
    int m = 0;
    for (;;)
    {
      if (m < n)
      {
        Object localObject = this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildAt(m);
        float f1 = a((View)localObject);
        localObject = (vys)this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildViewHolder((View)localObject);
        if (localObject != null) {
          a((vys)localObject, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int, f1, m);
        }
        if (f1 <= 0.8F) {
          break label134;
        }
        if (this.jdField_i_of_type_Int == m) {
          break label107;
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1003);
      }
      for (;;)
      {
        this.jdField_i_of_type_Int = m;
        return;
        label107:
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1003);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1003, 300L);
      }
      label134:
      m += 1;
    }
  }
  
  public void a(vxg paramvxg)
  {
    if (this.j) {
      ykq.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "album scrolling , select ignore :%s", new Object[] { paramvxg });
    }
    while (paramvxg == null) {
      return;
    }
    ykq.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "on album select :%s", paramvxg);
    if (paramvxg.a())
    {
      c(paramvxg);
      return;
    }
    d(paramvxg);
  }
  
  public void a(vxg paramvxg, int paramInt)
  {
    a(300L);
  }
  
  public void b()
  {
    f();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = 0;
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
        paramMessage = this.jdField_a_of_type_Bonx.a(this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getLayoutManager());
        if (paramMessage == null)
        {
          ykq.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "on handle find snap msg , not found snap view !");
          return true;
        }
        vys localvys = (vys)this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildViewHolder(paramMessage);
        if ((this.jdField_a_of_type_Vys != null) && (this.jdField_a_of_type_Vys != localvys)) {
          this.jdField_a_of_type_Vys.c();
        }
        if ((localvys != null) && (this.jdField_a_of_type_Vys != localvys))
        {
          localvys.jdField_a_of_type_ComTencentBizQqstoryAlbumViewRoundCornerLayout.setAlpha(1.0F);
          ykq.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "SNAP, startPlay");
          localvys.b();
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager.getPosition(paramMessage) == 0) && (!this.jdField_a_of_type_Boolean)) {
            this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.postDelayed(new AlbumGalleryCapturePart.11(this), 3500L);
          }
        }
        this.jdField_a_of_type_Vys = localvys;
        int n = this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.getChildAdapterPosition(paramMessage);
        if (n != this.jdField_a_of_type_Vzf.a())
        {
          m = 1;
          this.jdField_a_of_type_Vzf.a(this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView, n);
          boolean bool1 = bool2;
          if (this.jdField_d_of_type_Boolean)
          {
            bool1 = bool2;
            if (m != 0) {
              bool1 = true;
            }
          }
          this.jdField_d_of_type_Boolean = bool1;
          f();
          this.jdField_h_of_type_Int = Math.max(this.jdField_a_of_type_Vzf.a(), this.jdField_h_of_type_Int);
          paramMessage = this.jdField_a_of_type_Vzf.a();
          if ((paramMessage != null) && (!paramMessage.a()) && (m != 0)) {
            b(this.jdField_a_of_type_Vzf.a());
          }
          if ((paramMessage != null) && (paramMessage.a()))
          {
            if (paramMessage.jdField_d_of_type_Int != 1) {
              break label353;
            }
            this.jdField_e_of_type_Boolean = true;
          }
        }
        while (this.jdField_c_of_type_Boolean)
        {
          g();
          return true;
          m = 0;
          break label215;
          if (paramMessage.jdField_d_of_type_Int == 4) {
            this.jdField_f_of_type_Boolean = true;
          } else if (paramMessage.jdField_d_of_type_Int == 3) {
            this.jdField_h_of_type_Boolean = true;
          } else if (paramMessage.jdField_d_of_type_Int == 5) {
            this.jdField_g_of_type_Boolean = true;
          } else if (paramMessage.jdField_d_of_type_Int != 2) {}
        }
        paramMessage = this.jdField_a_of_type_Vzf.a();
        if (this.jdField_a_of_type_Long != -1L) {
          while (m < paramMessage.size())
          {
            if (((vxg)paramMessage.get(m)).a() == this.jdField_a_of_type_Long)
            {
              this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager.scrollToPosition(m);
              a(200L);
              this.jdField_a_of_type_Long = -1L;
              ykq.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "start ,scroll to position %d automatically", Integer.valueOf(m));
              return true;
            }
            m += 1;
          }
        }
      } while ((this.jdField_g_of_type_Int < 0) || (this.jdField_g_of_type_Int >= paramMessage.size()));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$LayoutManager.scrollToPosition(this.jdField_g_of_type_Int);
      a(200L);
      this.jdField_g_of_type_Int = -1;
      ykq.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "start ,scroll to position %d automatically", Integer.valueOf(this.jdField_g_of_type_Int));
      return true;
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, anvx.a(2131699677), 0).a();
      this.jdField_a_of_type_Vzf.b();
      return true;
      ykq.a("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "handle msg ,showAfterLoadingTip : %s", Boolean.valueOf(this.jdField_d_of_type_Boolean));
    } while (!this.jdField_d_of_type_Boolean);
    m = this.jdField_a_of_type_Vzf.a();
    this.jdField_a_of_type_DovComQqImCaptureViewSpeedFlexibleRecyclerView.smoothScrollToPosition(m + 1);
    a(200L);
    this.jdField_d_of_type_Boolean = false;
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      vxg localvxg = this.jdField_a_of_type_Vzf.a();
      if (localvxg != null)
      {
        long l = SystemClock.uptimeMillis();
        if (l - this.jdField_c_of_type_Long > 500L) {
          a(localvxg);
        }
        for (;;)
        {
          this.jdField_c_of_type_Long = l;
          break;
          ykq.d("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "you click too fast, wait...");
        }
        if (this.jdField_a_of_type_Vze != null)
        {
          this.jdField_a_of_type_Vze.a();
          continue;
          if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
          {
            this.jdField_a_of_type_AndroidViewView.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846438);
          }
          for (;;)
          {
            ykv.a("video_shoot_slides", "clk_setting", 0, 0, new String[0]);
            break;
            this.jdField_i_of_type_Boolean = true;
            e();
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846439);
          }
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846438);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vza
 * JD-Core Version:    0.7.0.1
 */