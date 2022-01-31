import android.view.View;

final class tlg
  implements bhuk
{
  tlg(bhuk parambhuk, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    tlo.b("WSFeedUtils", "clickedView :" + paramView + ", which: " + paramInt);
    if (this.jdField_a_of_type_Bhuk != null) {
      this.jdField_a_of_type_Bhuk.OnClick(paramView, paramInt);
    }
    this.jdField_a_of_type_Bhuf.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tlg
 * JD-Core Version:    0.7.0.1
 */