import com.tencent.mobileqq.customviews.MessageProgressTextView;

public class fnf
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  int b = 0;
  
  public fnf(MessageProgressTextView paramMessageProgressTextView, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView.jdField_a_of_type_Fnf = null;
    if (!MessageProgressTextView.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Int += this.b;
      MessageProgressTextView.a(this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView, this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fnf
 * JD-Core Version:    0.7.0.1
 */