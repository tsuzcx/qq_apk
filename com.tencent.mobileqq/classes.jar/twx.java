import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;

public abstract class twx
{
  private final String jdField_a_of_type_JavaLangString = "FeedExposureHelper";
  private twy jdField_a_of_type_Twy;
  
  public int a(int paramInt1, int paramInt2)
  {
    return paramInt1 + paramInt2;
  }
  
  public twy a(AbsListView paramAbsListView)
  {
    int j = 0;
    twy localtwy = new twy();
    localtwy.jdField_a_of_type_Long = System.currentTimeMillis();
    int k = paramAbsListView.getHeight();
    int m = paramAbsListView.getFirstVisiblePosition();
    int n = paramAbsListView.getChildCount();
    int i = j;
    if (n == 0)
    {
      localtwy.jdField_a_of_type_Int = 0;
      localtwy.b = 10;
      i = j;
    }
    if (i < n)
    {
      if (a(paramAbsListView.getChildAt(i), k)) {
        localtwy.jdField_a_of_type_Int = a(m, i);
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
          localtwy.b = a(m, i);
        }
      }
      else
      {
        return localtwy;
        i += 1;
        break;
      }
      i -= 1;
    }
  }
  
  public twy a(twy paramtwy1, twy paramtwy2)
  {
    if ((paramtwy1 == null) || (paramtwy2 == null)) {}
    while ((paramtwy1.b < paramtwy2.jdField_a_of_type_Int) || (paramtwy1.jdField_a_of_type_Int > paramtwy2.b)) {
      return null;
    }
    twy localtwy = new twy();
    if (paramtwy1.jdField_a_of_type_Int > paramtwy2.jdField_a_of_type_Int)
    {
      i = paramtwy1.jdField_a_of_type_Int;
      localtwy.jdField_a_of_type_Int = i;
      if (paramtwy1.b >= paramtwy2.b) {
        break label113;
      }
    }
    label113:
    for (int i = paramtwy1.b;; i = paramtwy2.b)
    {
      localtwy.b = i;
      localtwy.jdField_a_of_type_Long = Math.abs(paramtwy1.jdField_a_of_type_Long - paramtwy2.jdField_a_of_type_Long);
      return localtwy;
      i = paramtwy2.jdField_a_of_type_Int;
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
      if (this.jdField_a_of_type_Twy != null)
      {
        twy localtwy = a(this.jdField_a_of_type_Twy, paramAbsListView);
        if ((localtwy != null) && (localtwy.jdField_a_of_type_Long > 1000L))
        {
          QLog.d("FeedExposureHelper", 2, "sameRange: " + localtwy);
          a(localtwy);
        }
      }
      this.jdField_a_of_type_Twy = paramAbsListView;
    } while (paramInt != 5);
    this.jdField_a_of_type_Twy = null;
  }
  
  public abstract void a(twy paramtwy);
  
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
 * Qualified Name:     twx
 * JD-Core Version:    0.7.0.1
 */