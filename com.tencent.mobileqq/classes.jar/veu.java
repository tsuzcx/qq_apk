import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.EditGifImage;
import com.tencent.image.AbstractGifImage.DoAccumulativeRunnable;
import com.tencent.image.NativeGifImage;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.widget.FastAnimationDrawable;

public class veu
  extends vhk
  implements View.OnClickListener
{
  protected double a;
  protected final int a;
  protected LinearLayout a;
  protected SeekBar a;
  protected TextView a;
  protected boolean a;
  protected int b;
  protected TextView b;
  protected int c;
  protected int d = 50;
  protected int e = -1;
  protected int f;
  protected int g;
  
  public veu(@NonNull vhm paramvhm)
  {
    super(paramvhm);
    this.jdField_a_of_type_Int = AbstractGifImage.DoAccumulativeRunnable.DELAY;
  }
  
  private void f()
  {
    this.f = bhqe.f;
    this.g = (this.c * bhqe.g);
    this.jdField_a_of_type_Double = ((this.f - this.g) / 100.0D);
    if (QLog.isColorLevel()) {
      QLog.d("EditGifSpeedControl", 2, "calculateSpeedChangeByLimit | defaultY:" + this.c + " maxSpeed:" + this.f + " minSpeed:" + this.g + " k1:" + this.jdField_a_of_type_Double);
    }
  }
  
  public void a()
  {
    super.a();
    AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    NativeGifImage.QZONE_DELAY = -1;
    this.jdField_b_of_type_Int = 50;
    if (QLog.isColorLevel()) {
      QLog.d("EditGifSpeedControl", 2, "onCreate | defaultX:" + this.jdField_b_of_type_Int + " defaultY:" + this.c + " delayTime:" + this.e);
    }
    f();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131375788));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131375783));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131375784));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)a(2131367064));
    this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(100);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(new vev(this));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    if (this.e == -1)
    {
      if (!this.jdField_a_of_type_Vhm.a.jdField_a_of_type_Boolean) {
        break label193;
      }
      paramInt = (int)this.jdField_a_of_type_Vhm.a.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.a();
      this.e = paramInt;
      this.c = paramInt;
    }
    for (NativeGifImage.QZONE_DELAY = paramInt;; NativeGifImage.QZONE_DELAY = paramInt)
    {
      f();
      paramInt = (int)((this.c - this.g) / this.jdField_a_of_type_Double);
      this.d = paramInt;
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("EditGifSpeedControl", 2, "editVideoStateChanged | delayTime:" + this.e + " barPosition:" + this.d);
      }
      this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(this.d);
      this.c = this.e;
      this.jdField_b_of_type_Int = this.d;
      return;
      label193:
      paramInt = NativeGifImage.GIF_DEFAULT_DELAY;
      this.e = paramInt;
      this.c = paramInt;
    }
  }
  
  public void a(@NonNull vsa paramvsa)
  {
    if (this.e == -1) {
      if (this.jdField_a_of_type_Vhm.a.jdField_a_of_type_Boolean)
      {
        paramvsa.a.jdField_b_of_type_Int = ((int)this.jdField_a_of_type_Vhm.a.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.a());
        paramvsa.a.c = this.jdField_a_of_type_Boolean;
        if (QLog.isColorLevel()) {
          QLog.d("EditGifSpeedControl", 2, "editVideoPrePublish | get defaultY:" + this.c + " isDelayTimeChange:" + this.jdField_a_of_type_Boolean);
        }
      }
    }
    do
    {
      return;
      vse localvse = paramvsa.a;
      if (NativeGifImage.GIF_DEFAULT_DELAY != -1) {}
      for (int i = NativeGifImage.GIF_DEFAULT_DELAY;; i = bhqe.d)
      {
        localvse.jdField_b_of_type_Int = i;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditGifSpeedControl", 2, "editVideoPrePublish | get delayTime:" + this.e + " isDelayTimeChange:" + this.jdField_a_of_type_Boolean);
      }
      paramvsa.a.jdField_b_of_type_Int = this.e;
      paramvsa.a.c = this.jdField_a_of_type_Boolean;
      if (this.e < this.c)
      {
        LpReportInfo_pf00064.allReport(628, 5, 3);
        return;
      }
    } while (this.e <= this.c);
    LpReportInfo_pf00064.allReport(628, 5, 2);
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_Vhm.jdField_b_of_type_Int == 21)
    {
      NativeGifImage.QZONE_DELAY = this.c;
      if (this.jdField_a_of_type_Vhm.a.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable != null) {
        this.jdField_a_of_type_Vhm.a.jdField_a_of_type_CooperationQzoneWidgetFastAnimationDrawable.a(NativeGifImage.QZONE_DELAY);
      }
      this.e = this.c;
      this.d = this.jdField_b_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("EditGifSpeedControl", 2, "onBackPressed | delayTime:" + this.e + " barPosition:" + this.d);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_Vhm.a(0);
      bool = true;
      LpReportInfo_pf00064.allReport(628, 5, 4);
    }
    return bool;
  }
  
  public void d()
  {
    super.d();
    if (QLog.isColorLevel()) {
      QLog.d("EditGifSpeedControl", 2, "onDestroy | DEFAULT_DELAY:" + this.jdField_a_of_type_Int);
    }
    AbstractGifImage.DoAccumulativeRunnable.DELAY = this.jdField_a_of_type_Int;
    NativeGifImage.QZONE_DELAY = -1;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131375784: 
      do
      {
        return;
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      } while (this.jdField_a_of_type_Vhm.jdField_b_of_type_Int != 21);
      this.jdField_a_of_type_Vhm.a(0);
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     veu
 * JD-Core Version:    0.7.0.1
 */