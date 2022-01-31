import android.annotation.TargetApi;
import android.view.View;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.EdgeEffect;
import com.tencent.widget.OverScroller;

public class hzt
  implements Runnable
{
  private static final int b = 40;
  private int jdField_a_of_type_Int;
  private final OverScroller jdField_a_of_type_ComTencentWidgetOverScroller;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new hzu(this);
  
  public hzt(AbsListView paramAbsListView)
  {
    this.jdField_a_of_type_ComTencentWidgetOverScroller = new OverScroller(paramAbsListView.getContext());
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView.ab = -1;
    this.jdField_a_of_type_ComTencentWidgetAbsListView.removeCallbacks(this);
    this.jdField_a_of_type_ComTencentWidgetAbsListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentWidgetAbsListView.a(0);
    AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView);
    this.jdField_a_of_type_ComTencentWidgetOverScroller.a();
    if (AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView) != null) {
      AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView, AbsListView.b(this.jdField_a_of_type_ComTencentWidgetAbsListView, AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView)));
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0) {}
    for (int i = 2147483647;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_ComTencentWidgetOverScroller.a(0, i, 0, paramInt, 0, 2147483647, 0, 2147483647);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.ab = 4;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      if (AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView) == null) {
        AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView, AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView, "AbsListView-fling"));
      }
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {}
    for (int i = 2147483647;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_ComTencentWidgetOverScroller.a(0, i, 0, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.ab = 4;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 40L);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetOverScroller.a(0, this.jdField_a_of_type_ComTencentWidgetAbsListView.getScrollY(), paramInt, paramInt, paramInt, paramInt))
    {
      this.jdField_a_of_type_ComTencentWidgetAbsListView.ab = 6;
      this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetAbsListView.ab = -1;
    this.jdField_a_of_type_ComTencentWidgetAbsListView.a(0);
  }
  
  void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetOverScroller.a(0, this.jdField_a_of_type_ComTencentWidgetAbsListView.getScrollY(), 0, paramInt, 0, 0, -2147483648, 2147483647, 0, this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight());
    this.jdField_a_of_type_ComTencentWidgetAbsListView.ab = 6;
    this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
    this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
  }
  
  @TargetApi(9)
  void d(int paramInt)
  {
    OverScroller localOverScroller = this.jdField_a_of_type_ComTencentWidgetOverScroller;
    int i;
    if (paramInt > 0)
    {
      i = this.jdField_a_of_type_ComTencentWidgetAbsListView.al;
      localOverScroller.b(paramInt, 0, i);
      i = this.jdField_a_of_type_ComTencentWidgetAbsListView.getOverScrollMode();
      if ((i != 0) && ((i != 1) || (AbsListView.b(this.jdField_a_of_type_ComTencentWidgetAbsListView)))) {
        break label136;
      }
      this.jdField_a_of_type_ComTencentWidgetAbsListView.ab = 6;
      i = (int)this.jdField_a_of_type_ComTencentWidgetOverScroller.a();
      if (AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView) != null)
      {
        if (paramInt <= 0) {
          break label122;
        }
        AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView).a(i);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
      this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
      return;
      i = this.jdField_a_of_type_ComTencentWidgetAbsListView.am;
      break;
      label122:
      AbsListView.b(this.jdField_a_of_type_ComTencentWidgetAbsListView).a(i);
      continue;
      label136:
      this.jdField_a_of_type_ComTencentWidgetAbsListView.ab = -1;
      if (this.jdField_a_of_type_ComTencentWidgetAbsListView.a != null) {
        this.jdField_a_of_type_ComTencentWidgetAbsListView.a.a();
      }
      if (AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView) != null) {
        AbsListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView).b();
      }
    }
  }
  
  @TargetApi(9)
  public void run()
  {
    int k = 1;
    int i;
    int j;
    switch (this.jdField_a_of_type_ComTencentWidgetAbsListView.ab)
    {
    case 5: 
    default: 
      a();
    case 3: 
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentWidgetOverScroller.a());
    case 4: 
      AdapterView.a("AbsListView.FlingRunable.onfling");
      try
      {
        if (this.jdField_a_of_type_ComTencentWidgetAbsListView.p) {
          this.jdField_a_of_type_ComTencentWidgetAbsListView.i();
        }
        if ((this.jdField_a_of_type_ComTencentWidgetAbsListView.aB == 0) || (this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() == 0))
        {
          a();
          return;
        }
        Object localObject1 = this.jdField_a_of_type_ComTencentWidgetOverScroller;
        boolean bool = ((OverScroller)localObject1).b();
        int m = ((OverScroller)localObject1).b();
        i = this.jdField_a_of_type_Int - m;
        if (i > 0)
        {
          this.jdField_a_of_type_ComTencentWidgetAbsListView.W = this.jdField_a_of_type_ComTencentWidgetAbsListView.ap;
          localObject1 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(0);
          this.jdField_a_of_type_ComTencentWidgetAbsListView.X = ((View)localObject1).getTop();
        }
        for (i = Math.min(this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() - AbsListView.f(this.jdField_a_of_type_ComTencentWidgetAbsListView) - AbsListView.g(this.jdField_a_of_type_ComTencentWidgetAbsListView) - 1, i);; i = Math.max(-(this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() - AbsListView.h(this.jdField_a_of_type_ComTencentWidgetAbsListView) - AbsListView.i(this.jdField_a_of_type_ComTencentWidgetAbsListView) - 1), i))
        {
          localObject1 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(this.jdField_a_of_type_ComTencentWidgetAbsListView.W - this.jdField_a_of_type_ComTencentWidgetAbsListView.ap);
          if (localObject1 == null) {
            break label597;
          }
          j = ((View)localObject1).getTop();
          if ((!this.jdField_a_of_type_ComTencentWidgetAbsListView.a(i, i)) || (i == 0)) {
            break label602;
          }
          label254:
          if (k == 0) {
            break;
          }
          if (localObject1 != null)
          {
            j = -(i - (((View)localObject1).getTop() - j));
            i = j;
            if (bool)
            {
              d(j);
              i = this.jdField_a_of_type_ComTencentWidgetOverScroller.b();
            }
            this.jdField_a_of_type_ComTencentWidgetAbsListView.overScrollBy(0, i, 0, this.jdField_a_of_type_ComTencentWidgetAbsListView.getScrollY(), 0, 0, 0, this.jdField_a_of_type_ComTencentWidgetAbsListView.aj, false);
          }
          return;
          j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildCount() - 1;
          this.jdField_a_of_type_ComTencentWidgetAbsListView.W = (this.jdField_a_of_type_ComTencentWidgetAbsListView.ap + j);
          localObject1 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(j);
          this.jdField_a_of_type_ComTencentWidgetAbsListView.X = ((View)localObject1).getTop();
        }
        if ((bool) && (k == 0))
        {
          this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
          this.jdField_a_of_type_Int = m;
          this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
        }
        for (;;)
        {
          return;
          a();
        }
        try
        {
          localOverScroller = this.jdField_a_of_type_ComTencentWidgetOverScroller;
          if (localOverScroller.b())
          {
            j = this.jdField_a_of_type_ComTencentWidgetAbsListView.getScrollY();
            k = localOverScroller.b();
            if (this.jdField_a_of_type_ComTencentWidgetAbsListView.overScrollBy(0, k - j, 0, j, 0, 0, 0, this.jdField_a_of_type_ComTencentWidgetAbsListView.aj, false)) {
              if ((j <= 0) && (k > 0))
              {
                i = 1;
                break label607;
              }
            }
          }
        }
        finally {}
      }
      finally
      {
        AdapterView.A();
      }
    }
    for (;;)
    {
      OverScroller localOverScroller;
      label527:
      k = (int)localOverScroller.a();
      i = k;
      if (j != 0) {
        i = -k;
      }
      localOverScroller.a();
      a(i);
      return;
      i = 0;
      break label607;
      label564:
      j = 0;
      label597:
      label602:
      label607:
      do
      {
        b(0);
        return;
        this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
        this.jdField_a_of_type_ComTencentWidgetAbsListView.post(this);
        return;
        a();
        return;
        j = 0;
        break;
        k = 0;
        break label254;
        if ((j < 0) || (k >= 0)) {
          break label564;
        }
        j = 1;
        if (i != 0) {
          break label527;
        }
      } while (j == 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hzt
 * JD-Core Version:    0.7.0.1
 */