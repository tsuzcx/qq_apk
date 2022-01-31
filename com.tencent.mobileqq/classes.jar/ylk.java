import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;

class ylk
  implements View.OnSystemUiVisibilityChangeListener
{
  ylk(yli paramyli, ViewGroup paramViewGroup) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0) {
      this.jdField_a_of_type_AndroidViewViewGroup.setSystemUiVisibility(3846);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ylk
 * JD-Core Version:    0.7.0.1
 */