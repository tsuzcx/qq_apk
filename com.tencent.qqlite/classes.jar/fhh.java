import android.util.SparseArray;
import android.view.View;
import com.tencent.widget.AbsSpinner;

public class fhh
{
  private final SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  public fhh(AbsSpinner paramAbsSpinner) {}
  
  public View a(int paramInt)
  {
    View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localView != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.delete(paramInt);
    }
    return localView;
  }
  
  public void a()
  {
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)localSparseArray.valueAt(i);
      if (localView != null) {
        AbsSpinner.a(this.jdField_a_of_type_ComTencentWidgetAbsSpinner, localView, true);
      }
      i += 1;
    }
    localSparseArray.clear();
  }
  
  public void a(int paramInt, View paramView)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     fhh
 * JD-Core Version:    0.7.0.1
 */