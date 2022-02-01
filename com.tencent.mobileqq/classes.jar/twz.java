import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public abstract class twz
{
  private final String jdField_a_of_type_JavaLangString = "FeedExposureHelper";
  private txa jdField_a_of_type_Txa;
  
  public int a(int paramInt1, int paramInt2)
  {
    return paramInt1 + paramInt2;
  }
  
  public txa a(AbsListView paramAbsListView)
  {
    int j = 0;
    txa localtxa = new txa();
    localtxa.jdField_a_of_type_Long = System.currentTimeMillis();
    int k = paramAbsListView.getHeight();
    int m = paramAbsListView.getFirstVisiblePosition();
    int n = paramAbsListView.getChildCount();
    int i = j;
    if (n == 0)
    {
      localtxa.jdField_a_of_type_Int = 0;
      localtxa.b = 10;
      i = j;
    }
    if (i < n)
    {
      if (a(paramAbsListView.getChildAt(i), k)) {
        localtxa.jdField_a_of_type_Int = a(m, i);
      }
    }
    else {
      i = paramAbsListView.getLastVisiblePosition() - m;
    }
    for (;;)
    {
      if (i >= 0)
      {
        if (a(paramAbsListView.getChildAt(i), k)) {
          localtxa.b = a(m, i);
        }
      }
      else
      {
        return localtxa;
        i += 1;
        break;
      }
      i -= 1;
    }
  }
  
  public txa a(txa paramtxa1, txa paramtxa2)
  {
    if ((paramtxa1 == null) || (paramtxa2 == null)) {}
    while ((paramtxa1.b < paramtxa2.jdField_a_of_type_Int) || (paramtxa1.jdField_a_of_type_Int > paramtxa2.b)) {
      return null;
    }
    txa localtxa = new txa();
    if (paramtxa1.jdField_a_of_type_Int > paramtxa2.jdField_a_of_type_Int)
    {
      i = paramtxa1.jdField_a_of_type_Int;
      localtxa.jdField_a_of_type_Int = i;
      if (paramtxa1.b >= paramtxa2.b) {
        break label113;
      }
    }
    label113:
    for (int i = paramtxa1.b;; i = paramtxa2.b)
    {
      localtxa.b = i;
      localtxa.jdField_a_of_type_Long = Math.abs(paramtxa1.jdField_a_of_type_Long - paramtxa2.jdField_a_of_type_Long);
      return localtxa;
      i = paramtxa2.jdField_a_of_type_Int;
      break;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      paramAbsListView = a(paramAbsListView);
      QLog.d("FeedExposureHelper", 2, "thisRange: " + paramAbsListView);
      if (this.jdField_a_of_type_Txa != null)
      {
        txa localtxa = a(this.jdField_a_of_type_Txa, paramAbsListView);
        if ((localtxa != null) && (localtxa.jdField_a_of_type_Long > 1000L))
        {
          QLog.d("FeedExposureHelper", 2, "sameRange: " + localtxa);
          a(localtxa);
        }
      }
      this.jdField_a_of_type_Txa = paramAbsListView;
    } while (paramInt != 5);
    this.jdField_a_of_type_Txa = null;
  }
  
  public abstract void a(txa paramtxa);
  
  public boolean a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return false;
    }
    if (paramView.getBottom() > paramInt) {}
    for (;;)
    {
      int i = paramInt;
      if (paramView.getTop() > 0) {
        i = paramInt - paramView.getTop();
      }
      if (i <= paramView.getHeight() * 0.5F) {
        break;
      }
      return true;
      paramInt = paramView.getBottom();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     twz
 * JD-Core Version:    0.7.0.1
 */