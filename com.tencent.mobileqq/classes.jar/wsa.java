import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.view.PagerAdapter;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.videostory.capture.widgets.AECaptureModeSelectPager;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class wsa
  extends wug
{
  private int jdField_a_of_type_Int;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bhcw jdField_a_of_type_Bhcw;
  private AECaptureModeSelectPager jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAECaptureModeSelectPager;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private wsi jdField_a_of_type_Wsi;
  private wsz jdField_a_of_type_Wsz;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public wsa(Activity paramActivity, AppInterface paramAppInterface, View paramView, wus paramwus)
  {
    super(paramActivity, paramView, paramwus);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bhcw = ((bhcw)paramwus.a(65537, new Object[0]));
  }
  
  private bgxx a()
  {
    return (bgxx)bhfm.a().c(18);
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Int == paramInt) || (this.jdField_a_of_type_Wsi.e())) {
      return;
    }
    this.jdField_a_of_type_Wsi.a().a(wsh.a()[paramInt]);
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAECaptureModeSelectPager.setCurrentItem(paramInt, true);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {}
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_Boolean = paramBoolean;
        if (!paramBoolean) {
          break;
        }
      } while (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      return;
    } while (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
  }
  
  private void e()
  {
    int i = 200;
    Object localObject = this.jdField_a_of_type_Bhcw.a().getIntent();
    if (localObject != null) {
      i = ((Intent)localObject).getIntExtra("AECAMERA_MODE", 200);
    }
    switch (i)
    {
    default: 
      this.jdField_a_of_type_Wsi.a(true);
      bhcm.a().c();
      this.jdField_a_of_type_Wsi.a(wsh.jdField_a_of_type_Wsh);
      a(wsh.jdField_a_of_type_Wsh.jdField_a_of_type_Int);
      b(false);
      return;
    case 201: 
      localObject = this.jdField_a_of_type_Wsi.a();
      if (localObject == wsh.b) {
        bhcm.a().e("3");
      }
      this.jdField_a_of_type_Wsi.a((wsh)localObject);
      a(((wsh)localObject).jdField_a_of_type_Int);
      b(true);
      return;
    }
    this.jdField_a_of_type_Wsi.a(true);
    bhcm.a().i();
    this.jdField_a_of_type_Wsi.a(wsh.c);
    a(wsh.c.jdField_a_of_type_Int);
    b(false);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Wsi = ((wsi)bhur.a(this.jdField_a_of_type_Bhcw).a(wsi.class));
    this.jdField_a_of_type_Wsi.a().a(this.jdField_a_of_type_Bhcw, new wsc(this));
    this.jdField_a_of_type_Wsz = ((wsz)bhur.a(this.jdField_a_of_type_Bhcw).a(wsz.class));
    this.jdField_a_of_type_Wsz.a().a(this.jdField_a_of_type_Bhcw, new wsd(this));
  }
  
  protected void a()
  {
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131309608);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131302895));
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAECaptureModeSelectPager = ((AECaptureModeSelectPager)this.jdField_b_of_type_AndroidViewView.findViewById(2131313503));
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    int k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    int i = j;
    if (bjlo.a(j, k)) {
      i = k * 9 / 16;
    }
    i = (i - bajq.a(53.0F)) / 2;
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAECaptureModeSelectPager.setPadding(i, 0, i, 0);
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAECaptureModeSelectPager.setOffscreenPageLimit(wsh.a().length);
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAECaptureModeSelectPager.setDisableScroll(true);
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAECaptureModeSelectPager.setOnPageChangeListener(new wsb(this));
    this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = new wse(this, this.jdField_a_of_type_AndroidViewView.getContext());
    this.jdField_a_of_type_ComTencentBizVideostoryCaptureWidgetsAECaptureModeSelectPager.setAdapter(this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter);
    f();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (paramInt1 == 101) && (paramInt2 == 201)) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      e();
      return;
      if ((paramVarArgs == null) || (paramVarArgs.length != 1) || (!(paramVarArgs[0] instanceof bgya))) {
        break;
      }
    } while (this.jdField_a_of_type_Int != wsh.b.jdField_a_of_type_Int);
    a().a((bgya)paramVarArgs[0], true);
    if (this.jdField_a_of_type_Bhcw != null) {
      this.jdField_a_of_type_Bhcw.a().getIntent().putExtra("widgetinfo", "camera^" + ((bgya)paramVarArgs[0]).a);
    }
    a(wsh.jdField_a_of_type_Wsh.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wsa
 * JD-Core Version:    0.7.0.1
 */