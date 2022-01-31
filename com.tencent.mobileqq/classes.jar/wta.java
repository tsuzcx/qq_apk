import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class wta
  extends wug
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private bhcw jdField_a_of_type_Bhcw;
  private wsi jdField_a_of_type_Wsi;
  private wsz jdField_a_of_type_Wsz;
  private wth jdField_a_of_type_Wth;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private View g;
  private View h;
  
  public wta(Activity paramActivity, View paramView, wus paramwus)
  {
    super(paramActivity, paramView, paramwus);
    this.jdField_a_of_type_Bhcw = ((bhcw)paramwus.a(65537, new Object[0]));
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_Wth == null) || (this.jdField_a_of_type_Wth.b() == null)) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_Wth.b().a();
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Wsi.a())
      {
        this.h.setVisibility(0);
        this.g.setVisibility(0);
      }
      this.f.setVisibility(0);
      return;
    }
    if (this.jdField_a_of_type_Wsi.a())
    {
      this.h.setVisibility(8);
      this.g.setVisibility(8);
    }
    this.d.setVisibility(8);
    this.e.setVisibility(8);
    this.f.setVisibility(8);
  }
  
  private void e()
  {
    if (!"VIVO;V1836T".equalsIgnoreCase(Build.MANUFACTURER + ";" + Build.MODEL)) {}
    ViewGroup.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = this.b.getLayoutParams();
    } while (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams));
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
    localMarginLayoutParams.topMargin += vct.a(this.jdField_a_of_type_AndroidAppActivity, 20.0F);
    this.b.setLayoutParams(localLayoutParams);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Wsi = ((wsi)bhur.a(this.jdField_a_of_type_Bhcw).a(wsi.class));
    this.jdField_a_of_type_Wsi.a().a(this.jdField_a_of_type_Bhcw, new wtb(this));
    this.jdField_a_of_type_Wth = ((wth)bhur.a(this.jdField_a_of_type_Bhcw).a(wth.class));
    this.jdField_a_of_type_Wth.a().a(this.jdField_a_of_type_Bhcw, new wtc(this));
    this.jdField_a_of_type_Wth.b().a(this.jdField_a_of_type_Bhcw, new wtd(this));
    this.jdField_a_of_type_Wsz = ((wsz)bhur.a(this.jdField_a_of_type_Bhcw).a(wsz.class));
    this.jdField_a_of_type_Wsz.a().a(this.jdField_a_of_type_Bhcw, new wte(this));
    this.jdField_a_of_type_Wsz.b().a(this.jdField_a_of_type_Bhcw, new wtf(this));
    this.jdField_a_of_type_Wsz.c().a(this.jdField_a_of_type_Bhcw, new wtg(this));
  }
  
  protected void a()
  {
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131300854);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131298236));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.b.findViewById(2131298302));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.c = this.b.findViewById(2131298472);
    this.d = this.b.findViewById(2131299334);
    this.f = this.b.findViewById(2131297562);
    this.f.setOnClickListener(this);
    this.e = this.b.findViewById(2131300750);
    this.e.setVisibility(8);
    this.g = this.b.findViewById(2131299229);
    this.g.setOnClickListener(this);
    this.h = this.b.findViewById(2131310948);
    this.h.setOnClickListener(this);
    this.h.setSelected(false);
    f();
    e();
  }
  
  public void b()
  {
    super.b();
    if (a()) {
      this.jdField_a_of_type_Wth.b().a(Boolean.valueOf(true));
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    this.jdField_a_of_type_Bhcw.onClick(paramView);
    switch (paramView.getId())
    {
    }
    label125:
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_Wsi.a()) {}
          for (;;)
          {
            bhpm.a(paramView, 200L, null);
            wye.a("mystatus_shoot", "beauty_clk", 0, 0, new String[0]);
            if (this.jdField_a_of_type_Wus == null) {
              break;
            }
            if (!this.jdField_a_of_type_Wsz.a()) {
              break label125;
            }
            this.jdField_a_of_type_Wus.a(327686, new Object[0]);
            return;
            bhci.a().q();
          }
        } while (this.jdField_a_of_type_Wsz.b());
        this.jdField_a_of_type_Wus.a(131077, new Object[0]);
        return;
        bhpm.a(paramView, 200L, null);
        paramView = (Boolean)this.jdField_a_of_type_Wth.a().a();
        if (paramView != null) {
          break;
        }
        bool1 = false;
        paramView = this.jdField_a_of_type_Wth.a();
        if (bool1) {
          break label235;
        }
        bool2 = true;
        paramView.a(Boolean.valueOf(bool2));
      } while (!this.jdField_a_of_type_Wsi.a());
      paramView = bhcm.a();
      if (!bool1) {}
      for (bool1 = bool3;; bool1 = false)
      {
        paramView.d(bool1);
        return;
        bool1 = paramView.booleanValue();
        break;
        bool2 = false;
        break label192;
      }
      bhpm.a(paramView, 200L, null);
      bool3 = a();
      paramView = this.jdField_a_of_type_Wth.b();
      if (bool3) {
        break;
      }
      bool1 = true;
      paramView.a(Boolean.valueOf(bool1));
    } while (!this.jdField_a_of_type_Wsi.a());
    label192:
    label235:
    paramView = bhcm.a();
    if (!bool3) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramView.c(bool1);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wta
 * JD-Core Version:    0.7.0.1
 */