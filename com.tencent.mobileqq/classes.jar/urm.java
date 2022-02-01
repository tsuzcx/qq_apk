import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public abstract class urm
{
  private final String jdField_a_of_type_JavaLangString = "FeedExposureHelper";
  private urn jdField_a_of_type_Urn;
  
  public int a(int paramInt1, int paramInt2)
  {
    return paramInt1 + paramInt2;
  }
  
  public urn a(AbsListView paramAbsListView)
  {
    int j = 0;
    urn localurn = new urn();
    localurn.jdField_a_of_type_Long = System.currentTimeMillis();
    int k = paramAbsListView.getHeight();
    int m = paramAbsListView.getFirstVisiblePosition();
    int n = paramAbsListView.getChildCount();
    int i = j;
    if (n == 0)
    {
      localurn.jdField_a_of_type_Int = 0;
      localurn.b = 10;
      i = j;
    }
    if (i < n)
    {
      if (a(paramAbsListView.getChildAt(i), k)) {
        localurn.jdField_a_of_type_Int = a(m, i);
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
          localurn.b = a(m, i);
        }
      }
      else
      {
        return localurn;
        i += 1;
        break;
      }
      i -= 1;
    }
  }
  
  public urn a(urn paramurn1, urn paramurn2)
  {
    if ((paramurn1 == null) || (paramurn2 == null)) {}
    while ((paramurn1.b < paramurn2.jdField_a_of_type_Int) || (paramurn1.jdField_a_of_type_Int > paramurn2.b)) {
      return null;
    }
    urn localurn = new urn();
    if (paramurn1.jdField_a_of_type_Int > paramurn2.jdField_a_of_type_Int)
    {
      i = paramurn1.jdField_a_of_type_Int;
      localurn.jdField_a_of_type_Int = i;
      if (paramurn1.b >= paramurn2.b) {
        break label113;
      }
    }
    label113:
    for (int i = paramurn1.b;; i = paramurn2.b)
    {
      localurn.b = i;
      localurn.jdField_a_of_type_Long = Math.abs(paramurn1.jdField_a_of_type_Long - paramurn2.jdField_a_of_type_Long);
      return localurn;
      i = paramurn2.jdField_a_of_type_Int;
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
      if (this.jdField_a_of_type_Urn != null)
      {
        urn localurn = a(this.jdField_a_of_type_Urn, paramAbsListView);
        if ((localurn != null) && (localurn.jdField_a_of_type_Long > 1000L))
        {
          QLog.d("FeedExposureHelper", 2, "sameRange: " + localurn);
          a(localurn);
        }
      }
      this.jdField_a_of_type_Urn = paramAbsListView;
    } while (paramInt != 5);
    this.jdField_a_of_type_Urn = null;
  }
  
  public abstract void a(urn paramurn);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urm
 * JD-Core Version:    0.7.0.1
 */