import android.graphics.Rect;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.util.AnimateUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;

public class fhe
  implements Runnable
{
  private static final int jdField_a_of_type_Int = 400;
  private static final int g = 0;
  private static final int h = 1;
  private static final int i = 2;
  private static final int j = 3;
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private int d;
  private int e;
  private int f;
  
  public fhe(AbsListView paramAbsListView) {}
  
  public void a()
  {
    boolean bool = true;
    int k = this.jdField_a_of_type_ComTencentWidgetAbsListView.ao;
    int m = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount();
    k = this.jdField_a_of_type_ComTencentWidgetAbsListView.aA - (k + m - 1) - 1;
    if (k == 0)
    {
      k = AbsListView.j(this.jdField_a_of_type_ComTencentWidgetAbsListView);
      m = AbsListView.k(this.jdField_a_of_type_ComTencentWidgetAbsListView);
      int n = this.jdField_a_of_type_ComTencentWidgetAbsListView.c.bottom;
      this.f = (this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() - 1).getBottom() - (k - m - n));
      if (this.f == 0)
      {
        b();
        return;
      }
      this.e = 400;
      this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
      this.jdField_b_of_type_Int = 0;
      this.jdField_c_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
    }
    this.jdField_c_of_type_Float = (this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() * k / this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() / 300.0F);
    this.jdField_a_of_type_Float = (this.jdField_c_of_type_Float / 100.0F);
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.d = (this.jdField_a_of_type_ComTencentWidgetAbsListView.aA - 1);
    if (k == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
      bool = false;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView.removeCallbacks(this);
    this.jdField_a_of_type_ComTencentWidgetAbsListView.l = false;
  }
  
  public void run()
  {
    int k = 0;
    AdapterView.a("AbsListView.MoveToBottomScroller.run");
    for (;;)
    {
      int m;
      try
      {
        m = (int)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long);
        switch (this.jdField_c_of_type_Int)
        {
        case 0: 
          k -= this.jdField_b_of_type_Int;
          if (this.jdField_a_of_type_ComTencentWidgetAbsListView.a(-k, -k)) {
            break label545;
          }
          k = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount();
          int n = this.jdField_a_of_type_ComTencentWidgetAbsListView.ao;
          if ((this.jdField_c_of_type_Int == 3) || (this.jdField_c_of_type_Int == 1) || (n + k - 1 < this.d)) {
            break label524;
          }
          n = AbsListView.l(this.jdField_a_of_type_ComTencentWidgetAbsListView);
          int i1 = AbsListView.m(this.jdField_a_of_type_ComTencentWidgetAbsListView);
          int i2 = this.jdField_a_of_type_ComTencentWidgetAbsListView.c.bottom;
          this.f = (this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(k - 1).getBottom() - (n - i1 - i2));
          if (this.f != 0) {
            break label426;
          }
          b();
          return;
        }
      }
      finally
      {
        AdapterView.A();
      }
      if (m > 100)
      {
        this.jdField_b_of_type_Float = this.jdField_c_of_type_Float;
        k = (int)(this.jdField_c_of_type_Float * m - this.jdField_c_of_type_Float * 400.0F / 8.0F);
        this.jdField_a_of_type_Float = 0.0F;
        this.jdField_c_of_type_Int = 2;
      }
      else
      {
        this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float * m);
        k = (int)(this.jdField_b_of_type_Float * m / 2.0F);
        continue;
        k = (int)(this.jdField_c_of_type_Float * m - this.jdField_c_of_type_Float * 400.0F / 8.0F);
        continue;
        if (m > this.e)
        {
          k = this.f - this.jdField_b_of_type_Int;
          this.jdField_a_of_type_ComTencentWidgetAbsListView.a(-k, -k);
          AdapterView.A();
          return;
        }
        this.jdField_b_of_type_Float -= this.jdField_a_of_type_Float * m;
        k = (int)(this.f - this.jdField_b_of_type_Float * (this.e - m) / 2.0F);
        continue;
        if (m > this.e)
        {
          k = this.f - this.jdField_b_of_type_Int;
          this.jdField_a_of_type_ComTencentWidgetAbsListView.a(-k, -k);
          AdapterView.A();
          return;
        }
        float f1 = m;
        k = (int)(AnimateUtils.a(f1 / this.e) * this.f);
        continue;
        label426:
        this.e = (400 - m);
        if (this.e < 100) {
          this.e = 100;
        }
        this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
        this.jdField_b_of_type_Int = 0;
        if ((this.jdField_b_of_type_Float * 1000.0F > AbsListView.e(this.jdField_a_of_type_ComTencentWidgetAbsListView)) && (!this.jdField_a_of_type_Boolean))
        {
          this.jdField_c_of_type_Int = 1;
          this.jdField_b_of_type_Float = (this.f * 2.0F / this.e);
          this.jdField_a_of_type_Float = (this.jdField_b_of_type_Float / this.e);
          label524:
          this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
        }
        for (;;)
        {
          AdapterView.A();
          return;
          this.jdField_c_of_type_Int = 3;
          break;
          label545:
          b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fhe
 * JD-Core Version:    0.7.0.1
 */