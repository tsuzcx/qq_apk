import android.util.SparseArray;
import android.view.View;

public class zho
{
  private SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray;
  private View jdField_a_of_type_AndroidViewView;
  
  private zho(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public <T extends View> T a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    if ((this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null) && (this.jdField_a_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, this.jdField_a_of_type_AndroidViewView.findViewById(paramInt));
    }
    return (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     zho
 * JD-Core Version:    0.7.0.1
 */