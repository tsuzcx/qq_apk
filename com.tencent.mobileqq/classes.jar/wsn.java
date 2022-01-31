final class wsn
  implements bfos
{
  wsn(wsq paramwsq, bfol parambfol) {}
  
  public void onDismiss()
  {
    if (this.jdField_a_of_type_Wsq != null) {
      this.jdField_a_of_type_Wsq.a(false);
    }
    this.jdField_a_of_type_Bfol.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wsn
 * JD-Core Version:    0.7.0.1
 */