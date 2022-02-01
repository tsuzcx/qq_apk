import android.view.View;

final class uow
  implements bkhw
{
  uow(bkhw parambkhw, bkho parambkho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    upe.b("WSFeedUtils", "clickedView :" + paramView + ", which: " + paramInt);
    if (this.jdField_a_of_type_Bkhw != null) {
      this.jdField_a_of_type_Bkhw.OnClick(paramView, paramInt);
    }
    this.jdField_a_of_type_Bkho.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uow
 * JD-Core Version:    0.7.0.1
 */