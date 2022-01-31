import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FastScroller;
import com.tencent.widget.ListView;
import java.util.HashSet;
import java.util.Iterator;

public class fij
  extends fgt
  implements fix
{
  public fij(ListView paramListView)
  {
    super(paramListView);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 2147483647;
    int j = 0;
    if (paramInt3 >= paramInt2) {
      if (i >= paramInt1) {}
    }
    for (;;)
    {
      if (paramInt3 >= 0)
      {
        paramInt1 = 0;
        for (;;)
        {
          if (paramInt1 <= paramInt3)
          {
            this.a.jdField_a_of_type_Fhd.a(this.a.getChildAt(paramInt1), this.a.ao + paramInt1);
            paramInt1 += 1;
            continue;
            localObject = this.a.getChildAt(paramInt3);
            int k = i;
            if (i == 2147483647) {
              k = ((View)localObject).getBottom();
            }
            i = ((View)localObject).getHeight();
            int m = ListView.a(this.a, (View)localObject, this.a.ao + paramInt3, k, false, this.a.c.left, paramInt3);
            j += m;
            i = k - (m + i + this.a.aF);
            paramInt3 -= 1;
            break;
          }
        }
        ListView.e(this.a, 0, paramInt3 + 1);
        Object localObject = this.a;
        ((ListView)localObject).ao += paramInt3 + 1;
        return 0;
      }
      return j;
      paramInt3 = -1;
    }
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 0;
    int i = -2147483648;
    if (paramInt3 <= paramInt4) {
      if (i <= paramInt2) {}
    }
    for (paramInt2 = paramInt3;; paramInt2 = -1)
    {
      if (paramInt2 >= 0)
      {
        paramInt3 = paramInt2;
        for (;;)
        {
          if (paramInt3 < paramInt1)
          {
            this.a.jdField_a_of_type_Fhd.a(this.a.getChildAt(paramInt3), this.a.ao + paramInt3);
            paramInt3 += 1;
            continue;
            View localView = this.a.getChildAt(paramInt3);
            int k = i;
            if (i == -2147483648) {
              k = localView.getTop();
            }
            i = localView.getHeight();
            int m = ListView.a(this.a, localView, this.a.ao + paramInt3, k, true, this.a.c.left, paramInt3);
            j += m;
            i = k + (m + i + this.a.aF);
            paramInt3 += 1;
            break;
          }
        }
        ListView.g(this.a, paramInt2, paramInt1 - paramInt2);
        return 0;
      }
      return j;
    }
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 > paramInt5) || (paramInt1 < paramInt4)) {
      paramInt4 = -1;
    }
    do
    {
      return paramInt4;
      paramInt4 = paramInt1;
    } while (paramInt1 < paramInt2);
    return paramInt1 + (paramInt3 - paramInt2 + 1);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 < 0) {}
    do
    {
      int i;
      do
      {
        return;
        if (paramInt3 <= 0) {
          break;
        }
        i = -1;
        if (paramInt2 >= 0)
        {
          localObject = this.a.getChildAt(paramInt2);
          if (((View)localObject).getBottom() - paramInt3 < paramInt1)
          {
            this.a.jdField_a_of_type_Fhd.a((View)localObject, this.a.ao + paramInt2);
            j = i;
            if (i >= 0) {}
          }
          for (int j = paramInt2;; j = i)
          {
            paramInt2 -= 1;
            i = j;
            break;
            ((View)localObject).offsetTopAndBottom(-paramInt3);
          }
        }
      } while (i < 0);
      ListView.f(this.a, 0, i + 1);
      Object localObject = this.a;
      ((ListView)localObject).ao = (i + 1 + ((ListView)localObject).ao);
      return;
    } while (paramInt3 >= 0);
    this.a.b(false);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 > 0)
    {
      i = -1;
      if (paramInt3 < paramInt1)
      {
        localView = this.a.getChildAt(paramInt3);
        if (localView.getTop() + paramInt4 > paramInt2)
        {
          this.a.jdField_a_of_type_Fhd.a(localView, this.a.ao + paramInt3);
          j = i;
          if (i >= 0) {}
        }
        for (j = paramInt3;; j = i)
        {
          paramInt3 += 1;
          i = j;
          break;
          localView.offsetTopAndBottom(paramInt4);
        }
      }
      if (i >= 0) {
        ListView.h(this.a, i, paramInt1 - i);
      }
    }
    while (paramInt4 >= 0)
    {
      int i;
      View localView;
      int j;
      return;
    }
    while (paramInt3 < paramInt1)
    {
      this.a.getChildAt(paramInt3).offsetTopAndBottom(paramInt4);
      paramInt3 += 1;
    }
    this.a.b(true);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i = 0;
    int j = 0;
    View localView;
    Object localObject;
    if (paramBoolean)
    {
      paramInt2 = j;
      while (paramInt2 < paramInt1)
      {
        localView = this.a.getChildAt(paramInt2);
        localObject = new AlphaAnimation(0.0F, 1.0F);
        ((AlphaAnimation)localObject).setDuration(this.a.d());
        localView.setAnimation((Animation)localObject);
        paramInt2 += 1;
      }
    }
    while (i <= paramInt2)
    {
      localView = this.a.getChildAt(i);
      localObject = new TranslateAnimation(0.0F, 0.0F, paramInt3, 0.0F);
      ((TranslateAnimation)localObject).setDuration(this.a.d());
      localView.setAnimation((Animation)localObject);
      i += 1;
    }
    paramInt2 += 1;
    while (paramInt2 < paramInt1)
    {
      localView = this.a.getChildAt(paramInt2);
      localObject = new TranslateAnimation(0.0F, 0.0F, paramInt4, 0.0F);
      ((TranslateAnimation)localObject).setDuration(this.a.d());
      localView.setAnimation((Animation)localObject);
      paramInt2 += 1;
    }
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if ((paramInt1 > paramInt5) || (paramInt1 < paramInt4)) {
      paramInt4 = -1;
    }
    do
    {
      return paramInt4;
      paramInt4 = paramInt1;
    } while (paramInt1 < paramInt2);
    if (paramInt1 <= paramInt3) {
      return -1;
    }
    return paramInt1 - (paramInt3 - paramInt2 + 1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int k;
    int n;
    int i3;
    int i;
    label283:
    int j;
    int m;
    label425:
    label463:
    label477:
    Object localObject;
    if ((paramInt1 == 0) && (this.a.aA > 0))
    {
      System.nanoTime();
      if (paramInt2 < paramInt1) {
        throw new IllegalArgumentException("lastRow must more than firstRow!");
      }
      if ((paramInt1 < 0) || (paramInt1 > this.a.aA - this.a.k() - this.a.l())) {
        throw new IllegalArgumentException("row index out of bound");
      }
      if ((this.a.o) || (this.a.q)) {
        onChanged();
      }
      int i1;
      int i2;
      do
      {
        do
        {
          return;
        } while (this.a.aA == 0);
        k = paramInt1 + this.a.k();
        paramInt2 += this.a.k();
        n = paramInt2 - k + 1;
        i3 = this.a.getChildCount();
        i1 = this.a.ao;
        i2 = this.a.ao + i3 - 1;
        if (k == this.a.aA)
        {
          paramInt1 = 1;
          if (this.a.jdField_a_of_type_ComTencentWidgetFastScroller != null) {
            this.a.jdField_a_of_type_ComTencentWidgetFastScroller.a(this.a.aA, this.a.aA - n);
          }
          this.a.aA += n;
          if (this.a.az < 0) {
            break label425;
          }
          i = a(this.a.az, k, paramInt2, i1, i2);
          this.a.e(i);
          this.a.f(i);
          if (this.a.W >= 0) {
            this.a.W = a(this.a.W, k, paramInt2, i1, i2);
          }
          if (this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) {
            break label463;
          }
        }
        for (i = 0;; i = this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.size())
        {
          if (i <= 0) {
            break label477;
          }
          j = 0;
          while (j < i)
          {
            m = this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.keyAt(j);
            boolean bool = this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.valueAt(j);
            if (m >= k)
            {
              this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.delete(m);
              this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(m + (paramInt2 - k + 1), bool);
            }
            j += 1;
          }
          paramInt1 = 0;
          break;
          if (this.a.Q < 0) {
            break label283;
          }
          this.a.az = a(this.a.Q, k, paramInt2, i1, i2);
          break label283;
        }
        if (ListView.a(this.a) != null)
        {
          i = 0;
          while (i < ListView.a(this.a).length)
          {
            j = ListView.a(this.a)[i];
            if (j >= k) {
              ListView.a(this.a)[i] = (j + (paramInt2 - k + 1));
            }
            i += 1;
          }
        }
        m = ListView.a(this.a) - ListView.b(this.a) - this.a.c.bottom;
        i3 = this.a.getChildAt(i3 - 1).getBottom();
        if ((this.a.n() == 1) && (paramInt1 != 0) && (i3 <= m)) {}
        for (i = 1; (k <= i1) && (i == 0) && (i3 >= m); i = 0)
        {
          localObject = this.a;
          ((ListView)localObject).ao += n;
          return;
        }
      } while ((k > i2) && (i == 0) && (i3 >= m));
      n = this.a.c.top;
      if (this.a.az >= 0)
      {
        paramInt1 = this.a.az;
        j = k - i1;
        if (i == 0) {
          break label932;
        }
        paramInt1 = 0;
        i = m;
        label719:
        if (paramInt2 < k) {
          break label1644;
        }
        if (i >= n) {
          break label809;
        }
        paramInt2 += 1;
      }
    }
    for (;;)
    {
      if (paramInt2 >= 0)
      {
        paramInt1 = 0;
        for (;;)
        {
          if (paramInt1 <= j - 1)
          {
            this.a.jdField_a_of_type_Fhd.a(this.a.getChildAt(paramInt1), this.a.ao + paramInt1);
            paramInt1 += 1;
            continue;
            if (this.a.j())
            {
              paramInt1 = this.a.Q;
              break;
            }
            paramInt1 = -1;
            break;
            label809:
            localObject = this.a.a(paramInt2, this.a.jdField_a_of_type_ArrayOfBoolean);
            ListView.a(this.a, (View)localObject, paramInt2, i, false, this.a.c.left, false, this.a.jdField_a_of_type_ArrayOfBoolean[0], j);
            m = ((View)localObject).getHeight() + this.a.aF;
            i -= m;
            paramInt2 -= 1;
            paramInt1 = m + paramInt1;
            break label719;
          }
        }
        ListView.a(this.a, 0, j);
        this.a.ao = paramInt2;
      }
      for (;;)
      {
        ListView.a(this.a);
        return;
        a(n, j - 1, paramInt1);
        continue;
        label932:
        if (((paramInt1 < 0) || (paramInt1 >= k)) && ((paramInt1 >= 0) || (this.a.i))) {
          break label1216;
        }
        i = 0;
        n = -1;
        if (j <= 0) {
          break;
        }
        paramInt1 = this.a.getChildAt(j - 1).getBottom() + this.a.aF;
        j = k;
        k = paramInt1;
        for (;;)
        {
          paramInt1 = n;
          if (j <= paramInt2)
          {
            if (k > m) {
              paramInt1 = j - this.a.ao;
            }
          }
          else
          {
            j = this.a.getChildCount();
            if (paramInt1 < 0) {
              break label1188;
            }
            paramInt2 = paramInt1;
            while (paramInt2 < j)
            {
              this.a.jdField_a_of_type_Fhd.a(this.a.getChildAt(paramInt2), this.a.ao + paramInt2);
              paramInt2 += 1;
            }
          }
          localObject = this.a.a(j, this.a.jdField_a_of_type_ArrayOfBoolean);
          ListView.a(this.a, (View)localObject, j, k, true, this.a.c.left, false, this.a.jdField_a_of_type_ArrayOfBoolean[0], j - this.a.ao);
          paramInt1 = ((View)localObject).getHeight() + this.a.aF;
          k += paramInt1;
          i += paramInt1;
          j += 1;
        }
        ListView.b(this.a, paramInt1, j - paramInt1);
        continue;
        label1188:
        a(this.a.getChildCount(), m, paramInt2 - this.a.ao + 1, i);
      }
      label1216:
      if (m > i3) {
        this.a.offsetChildrenTopAndBottom(m - i3);
      }
      i = this.a.getChildAt(j).getTop() - this.a.aF;
      paramInt1 = 0;
      if (paramInt2 >= k) {
        if (i < n) {
          paramInt2 += 1;
        }
      }
      for (;;)
      {
        if (paramInt2 >= 0)
        {
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 <= j - 1)
            {
              this.a.jdField_a_of_type_Fhd.a(this.a.getChildAt(paramInt1), this.a.ao + paramInt1);
              paramInt1 += 1;
              continue;
              localObject = this.a.a(paramInt2, this.a.jdField_a_of_type_ArrayOfBoolean);
              ListView.a(this.a, (View)localObject, paramInt2, i, false, this.a.c.left, false, this.a.jdField_a_of_type_ArrayOfBoolean[0], j);
              m = ((View)localObject).getHeight() + this.a.aF;
              i -= m;
              paramInt2 -= 1;
              paramInt1 = m + paramInt1;
              break;
            }
          }
          ListView.c(this.a, 0, j);
          this.a.ao = paramInt2;
          break;
        }
        a(n, j - 1, paramInt1);
        break;
        if (ListView.a(this.a) == null)
        {
          localObject = new int[paramInt2 - paramInt1 + 1];
          j = 0;
          i = paramInt1;
          paramInt1 = j;
          while (i <= paramInt2)
          {
            localObject[paramInt1] = i;
            i += 1;
            paramInt1 += 1;
          }
          ListView.a(this.a, (int[])localObject);
        }
        for (;;)
        {
          onChanged();
          return;
          localObject = new HashSet();
          while (paramInt1 <= paramInt2)
          {
            ((HashSet)localObject).add(Integer.valueOf(paramInt1));
            paramInt1 += 1;
          }
          int[] arrayOfInt = ListView.a(this.a);
          paramInt2 = arrayOfInt.length;
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            ((HashSet)localObject).add(Integer.valueOf(arrayOfInt[paramInt1]));
            paramInt1 += 1;
          }
          arrayOfInt = new int[((HashSet)localObject).size()];
          localObject = ((HashSet)localObject).iterator();
          paramInt1 = 0;
          while (((Iterator)localObject).hasNext())
          {
            arrayOfInt[paramInt1] = ((Integer)((Iterator)localObject).next()).intValue();
            paramInt1 += 1;
          }
          ListView.a(this.a, arrayOfInt);
        }
        paramInt2 = -1;
      }
      label1644:
      paramInt2 = -1;
    }
  }
  
  public void a(int... paramVarArgs)
  {
    onChanged();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    System.nanoTime();
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("lastRow must more than firstRow!");
    }
    if ((paramInt1 < 0) || (paramInt2 >= this.a.aA - this.a.k() - this.a.l())) {
      throw new IllegalArgumentException("row index out of bound");
    }
    if ((this.a.o) || (this.a.q)) {
      onChanged();
    }
    int n;
    int i2;
    int i1;
    int i3;
    boolean bool1;
    int m;
    int k;
    int j;
    int i;
    label469:
    label483:
    label636:
    label638:
    Object localObject;
    label548:
    label702:
    label711:
    label749:
    do
    {
      int i4;
      do
      {
        return;
        n = paramInt1 + this.a.k();
        i2 = paramInt2 + this.a.k();
        paramInt1 = i2 - n + 1;
        i4 = this.a.getChildCount();
        i1 = this.a.ao;
        i3 = this.a.ao + i4 - 1;
        if (this.a.jdField_a_of_type_ComTencentWidgetFastScroller != null) {
          this.a.jdField_a_of_type_ComTencentWidgetFastScroller.a(this.a.aA, this.a.aA - paramInt1);
        }
        this.a.aA -= paramInt1;
        if (this.a.az >= 0)
        {
          paramInt1 = b(this.a.az, n, i2, i1, i3);
          this.a.e(paramInt1);
          this.a.f(paramInt1);
          if (this.a.W >= 0) {
            this.a.W = b(this.a.W, n, i2, i1, i3);
          }
          if (this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray != null) {
            break label469;
          }
        }
        for (paramInt2 = 0;; paramInt2 = this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.size())
        {
          if (paramInt2 <= 0) {
            break label483;
          }
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            int i5 = this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.keyAt(paramInt1);
            bool1 = this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.valueAt(paramInt1);
            m = paramInt1;
            k = paramInt2;
            if (i5 >= n)
            {
              this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.delete(i5);
              j = paramInt1;
              i = paramInt2;
              if (i5 <= i2)
              {
                j = paramInt1 - 1;
                i = paramInt2 - 1;
              }
              m = j;
              k = i;
              if (i5 > i2)
              {
                this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(i5 - (i2 - n + 1), bool1);
                k = i;
                m = j;
              }
            }
            paramInt1 = m + 1;
            paramInt2 = k;
          }
          if (this.a.Q < 0) {
            break;
          }
          this.a.az = b(this.a.Q, n, i2, i1, i3);
          break;
        }
        if (ListView.a(this.a) != null)
        {
          paramInt1 = 0;
          if (paramInt1 < ListView.a(this.a).length)
          {
            paramInt2 = ListView.a(this.a)[paramInt1];
            if (paramInt2 >= n)
            {
              if (paramInt2 > i2) {
                break label548;
              }
              paramInt2 = -1;
            }
            for (;;)
            {
              ListView.a(this.a)[paramInt1] = paramInt2;
              paramInt1 += 1;
              break;
              paramInt2 -= i2 - n + 1;
            }
          }
        }
      } while ((i2 < i1) || (n > i3));
      m = this.a.c.top;
      k = ListView.c(this.a) - ListView.d(this.a) - this.a.c.bottom;
      if (n < i1)
      {
        paramInt1 = 0;
        if (i2 <= i3) {
          break label702;
        }
        paramInt2 = i4 - 1;
        i = 0;
        if (i >= i4) {
          break label749;
        }
        localObject = this.a.getChildAt(i);
        if ((i < paramInt1) || (i > paramInt2)) {
          break label711;
        }
        this.a.jdField_a_of_type_Fhd.a((View)localObject, i);
        ((View)localObject).setTag(2131230829, null);
      }
      for (;;)
      {
        i += 1;
        break label638;
        paramInt1 = n - i1;
        break;
        paramInt2 = i2 - i1;
        break label636;
        if (ListView.a(this.a)) {
          ((View)localObject).setTag(2131230829, new Point(((View)localObject).getTop(), ((View)localObject).getBottom()));
        }
      }
      ListView.d(this.a, paramInt1, paramInt2 - paramInt1 + 1);
    } while (this.a.aA == 0);
    paramInt2 = this.a.getChildCount();
    boolean bool2 = this.a.j();
    if (this.a.az >= 0)
    {
      j = this.a.az;
      if (QLog.isColorLevel()) {
        QLog.d("XListView", 2, "first is:" + n + ",last is:" + i2 + ",firstPosition is:" + i1 + ",lastPosition is:" + i3 + ",newSelectionPosition is:" + j + ",mStackFromBottom is:" + this.a.i);
      }
      if ((n > i1) || (i2 < i3)) {
        break label1165;
      }
      if (this.a.i) {
        break label1130;
      }
      paramInt1 = n;
      if (n > this.a.aA - 1) {
        paramInt1 = this.a.aA - 1;
      }
      ListView.a(this.a, paramInt1, m);
      bool1 = true;
      paramInt1 = -1;
      i = 0;
      paramInt2 = 0;
    }
    for (;;)
    {
      k = this.a.getChildCount();
      if ((j >= 0) && (j < k) && (bool2)) {
        this.a.a(j, this.a.getChildAt(j - this.a.ao));
      }
      if (QLog.isColorLevel()) {
        QLog.d("XListView", 2, "upItemsMaxIndex is:" + paramInt1 + ",upItemsMoveDistance is:" + paramInt2 + ",downItemsMoveDistance is:" + i);
      }
      if (ListView.a(this.a)) {
        a(k, paramInt1, paramInt2, i, bool1);
      }
      this.a.invalidate();
      return;
      if (bool2)
      {
        j = this.a.Q;
        break;
      }
      j = -1;
      break;
      label1130:
      localObject = this.a;
      if (n - 1 < 0) {}
      for (paramInt1 = 0;; paramInt1 = n - 1)
      {
        ListView.b((ListView)localObject, paramInt1, k);
        break;
      }
      label1165:
      if (n <= i1)
      {
        if ((this.a.i) || (j >= 0))
        {
          this.a.ao = n;
          localObject = this.a.getChildAt(paramInt1);
          paramInt2 = ((View)localObject).getTop();
          this.a.b(false);
          ListView.a(this.a);
          paramInt1 = ((View)localObject).getTop();
          i = paramInt2 - paramInt1;
          if (paramInt1 - this.a.aF > 0) {}
          for (paramInt1 = -paramInt1 + this.a.aF;; paramInt1 = 0)
          {
            k = this.a.indexOfChild((View)localObject) - 1;
            paramInt2 = paramInt1;
            bool1 = false;
            paramInt1 = k;
            break;
          }
        }
        localObject = this.a.getChildAt(0);
        paramInt2 = ((View)localObject).getTop();
        this.a.offsetChildrenTopAndBottom(m - ((View)localObject).getTop());
        this.a.ao = n;
        this.a.b(true);
        ListView.a(this.a);
        if (((View)localObject).getTop() - this.a.aF > 0) {}
        for (paramInt1 = -((View)localObject).getTop() + this.a.aF;; paramInt1 = 0)
        {
          i = paramInt2 - ((View)localObject).getTop();
          k = this.a.indexOfChild((View)localObject);
          paramInt2 = paramInt1;
          bool1 = false;
          paramInt1 = k;
          break;
        }
      }
      if (i2 >= i3)
      {
        if ((!this.a.i) || (j >= 0))
        {
          localObject = this.a.getChildAt(paramInt2 - 1);
          paramInt2 = ((View)localObject).getBottom();
          this.a.b(true);
          ListView.a(this.a);
          paramInt1 = ((View)localObject).getBottom();
          paramInt2 -= paramInt1;
          if (k - paramInt1 - this.a.aF > 0) {}
          for (paramInt1 = k - paramInt1 - this.a.aF;; paramInt1 = 0)
          {
            k = this.a.indexOfChild((View)localObject);
            i = paramInt1;
            bool1 = false;
            paramInt1 = k;
            break;
          }
        }
        localObject = this.a.getChildAt(paramInt2 - 1);
        paramInt2 = ((View)localObject).getTop();
        this.a.offsetChildrenTopAndBottom(k - ((View)localObject).getBottom());
        this.a.b(false);
        ListView.a(this.a);
        if (k - ((View)localObject).getBottom() - this.a.aF > 0) {}
        for (paramInt1 = k - ((View)localObject).getBottom() - this.a.aF;; paramInt1 = 0)
        {
          paramInt2 -= ((View)localObject).getTop();
          k = this.a.indexOfChild((View)localObject);
          i = paramInt1;
          bool1 = false;
          paramInt1 = k;
          break;
        }
      }
      View localView;
      if (((j >= 0) && (j < n)) || ((j < 0) && (!this.a.i)))
      {
        localObject = this.a.getChildAt(paramInt1 - 1);
        k = ((View)localObject).getTop();
        localView = this.a.getChildAt(paramInt1);
        i = localView.getTop();
        m = localView.getTop();
        i2 = ((View)localObject).getBottom();
        paramInt1 = n - i1;
        while (paramInt1 < paramInt2)
        {
          this.a.getChildAt(paramInt1).offsetTopAndBottom(-(m - i2) + this.a.aF);
          paramInt1 += 1;
        }
        this.a.b(true);
        ListView.a(this.a);
        m = localView.getTop();
        paramInt2 = k - ((View)localObject).getTop();
        paramInt1 = this.a.indexOfChild((View)localObject);
        i -= m;
        bool1 = false;
      }
      else if ((j >= n) || ((j < 0) && (this.a.i)))
      {
        localObject = this.a.getChildAt(paramInt1 - 1);
        paramInt2 = ((View)localObject).getTop();
        localView = this.a.getChildAt(paramInt1);
        i = localView.getTop();
        k = localView.getTop();
        m = this.a.getChildAt(paramInt1 - 1).getBottom();
        paramInt1 = 0;
        while (paramInt1 < n - i1)
        {
          this.a.getChildAt(paramInt1).offsetTopAndBottom(k - m - this.a.aF);
          paramInt1 += 1;
        }
        this.a.b(false);
        ListView.a(this.a);
        k = localView.getTop();
        paramInt2 -= ((View)localObject).getTop();
        paramInt1 = this.a.indexOfChild((View)localObject);
        i -= k;
        bool1 = false;
      }
      else
      {
        paramInt1 = -1;
        i = 0;
        paramInt2 = 0;
        bool1 = false;
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("lastRow must more than firstRow!");
    }
    if ((paramInt1 < this.a.k()) || (paramInt2 >= this.a.aA - this.a.k() - this.a.l())) {
      throw new IllegalArgumentException("row index out of bound. insert range: " + paramInt1 + "~" + paramInt2 + ". valid range: " + this.a.k() + "~" + (this.a.aA - this.a.k() - this.a.l()));
    }
    if ((this.a.o) || (this.a.q)) {
      onChanged();
    }
    int n;
    int i1;
    int j;
    int i;
    do
    {
      do
      {
        return;
      } while (this.a.aA == 0);
      n = paramInt1 + this.a.k();
      i1 = paramInt2 + this.a.k();
      j = this.a.getChildCount();
      paramInt1 = this.a.ao;
      i = this.a.ao + j - 1;
    } while ((i1 < paramInt1) || (n > i));
    int k = this.a.c.top;
    int m = ListView.e(this.a) - ListView.f(this.a) - this.a.c.bottom;
    if (n < paramInt1)
    {
      paramInt2 = 0;
      if (i1 <= i) {
        break label392;
      }
      i = j - 1;
      label297:
      if (this.a.az < 0) {
        break label400;
      }
      paramInt1 = this.a.az;
      label315:
      if (((paramInt1 < 0) || (paramInt1 > n)) && ((paramInt1 >= 0) || (this.a.i))) {
        break label426;
      }
      paramInt1 = a(j, m, paramInt2, i);
      ListView.a(this.a, this.a.getChildCount());
      a(j, m, i + 1, paramInt1);
    }
    for (;;)
    {
      ListView.a(this.a);
      return;
      paramInt2 = n - paramInt1;
      break;
      label392:
      i = i1 - paramInt1;
      break label297;
      label400:
      if (this.a.j())
      {
        paramInt1 = this.a.Q;
        break label315;
      }
      paramInt1 = -1;
      break label315;
      label426:
      if ((paramInt1 >= i1) || ((paramInt1 < 0) && (this.a.i)))
      {
        paramInt1 = a(k, paramInt2, i);
        ListView.b(this.a, this.a.getChildCount());
        a(k, paramInt2 - 1, paramInt1);
      }
      else
      {
        paramInt1 -= this.a.ao;
        a(j, m, i + 1, a(j, m, paramInt1, i));
        a(k, paramInt2 - 1, a(k, paramInt2, paramInt1 - 1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fij
 * JD-Core Version:    0.7.0.1
 */