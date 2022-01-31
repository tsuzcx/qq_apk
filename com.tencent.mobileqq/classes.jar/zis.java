import android.app.Activity;
import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public abstract class zis
  extends zjj
  implements zja
{
  int jdField_a_of_type_Int;
  protected Activity a;
  protected Dialog a;
  protected View a;
  protected ImageView a;
  protected RelativeLayout a;
  protected TextView a;
  protected bdjz a;
  public AbstractImageAdapter a;
  protected GestureSelectGridView a;
  protected zil a;
  protected zir a;
  zja jdField_a_of_type_Zja = new ziy(this);
  protected boolean a;
  private int b;
  protected ImageView b;
  protected TextView b;
  protected boolean b;
  private int c;
  protected ImageView c;
  protected TextView c;
  private int d;
  protected TextView d;
  
  public zis(Activity paramActivity, zir paramzir)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Zir = paramzir;
  }
  
  private void c(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560821, null));
    if (paramViewGroup == null) {
      this.jdField_a_of_type_AndroidAppActivity.addContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
    }
    for (;;)
    {
      b(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131377938));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131364337));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131376342));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131366762));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131376108));
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131380202));
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131362434);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131364147));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView = ((GestureSelectGridView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131362345));
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setScrollBarStyle(0);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setNumColumns(4);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setColumnWidth(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setHorizontalSpacing(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setVerticalSpacing(this.jdField_c_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setPadding(this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingTop(), this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getPaddingBottom());
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnItemClickListener(a());
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setOnIndexChangedListener(a());
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.setAdapter(this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720329);
      o();
      q();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      return;
      paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0);
    }
  }
  
  private void n()
  {
    ((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window")).getDefaultDisplay();
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297300);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297301);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131297302);
    this.jdField_a_of_type_Int = ((bdoo.a() - this.jdField_d_of_type_Int * 2 - this.jdField_b_of_type_Int * 3) / 4);
  }
  
  private void o()
  {
    if (this.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      if ((this.jdField_a_of_type_Zje == null) || (!this.jdField_a_of_type_Zje.jdField_b_of_type_Boolean)) {
        break label129;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setText("");
      ((ViewGroup.MarginLayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams()).setMargins(aepi.a(16.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()), 0, 0, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new zit(this));
    }
    for (;;)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView != null)
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(2131690047);
        this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(a());
      }
      return;
      label129:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131689930);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(new ziu(this));
    }
  }
  
  private void q()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ziv(this));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new ziw(this));
      if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
        this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(new zix(this));
      }
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public Rect a()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
    int j = this.jdField_a_of_type_Zir.b();
    View localView = this.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(j - i);
    if (localView != null) {
      return zjc.a(localView);
    }
    return null;
  }
  
  protected abstract View.OnClickListener a();
  
  protected abstract bhuw a();
  
  protected abstract bhxl a();
  
  protected abstract AbstractImageAdapter a(Activity paramActivity, int paramInt);
  
  public void a()
  {
    this.jdField_a_of_type_Zje.a().a(this.jdField_a_of_type_Zja);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Zil = this.jdField_a_of_type_Zje.a();
    n();
    c(paramViewGroup);
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public boolean e()
  {
    g();
    this.jdField_a_of_type_AndroidAppActivity.finish();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772049, 2130772046);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130771977, 2130771978);
    }
  }
  
  public void f()
  {
    super.f();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageAdapter = null;
    this.jdField_a_of_type_Zir = null;
  }
  
  public void g() {}
  
  protected abstract void i();
  
  protected abstract void j();
  
  public void k()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AIOGalleryActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImmerseTest", 2, "imagelist setColor blue");
      }
      int i;
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        i = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidAppActivity);
        if (localLayoutParams != null) {
          localLayoutParams.setMargins(0, i, 0, 0);
        }
        if ((this.jdField_a_of_type_Zje != null) && (this.jdField_a_of_type_Zje.jdField_a_of_type_AndroidViewViewGroup != null) && (Build.VERSION.SDK_INT >= 16)) {
          this.jdField_a_of_type_Zje.jdField_a_of_type_AndroidViewViewGroup.setSystemUiVisibility(0);
        }
      }
      if (((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp != null)
      {
        i = this.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166959);
        ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusColor(i);
        ((AIOGalleryActivity)this.jdField_a_of_type_AndroidAppActivity).mSystemBarComp.setStatusBarColor(i);
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131720329);
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "imagelist onstart");
    }
  }
  
  public void l()
  {
    super.l();
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "imagelist onStop");
    }
  }
  
  protected abstract void m();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zis
 * JD-Core Version:    0.7.0.1
 */