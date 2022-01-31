import com.tencent.mobileqq.apollo.IApolloRenderView;

class ysk
  implements Runnable
{
  ysk(ysj paramysj, IApolloRenderView paramIApolloRenderView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloIApolloRenderView != null)
    {
      if (ysj.a(this.jdField_a_of_type_Ysj)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloIApolloRenderView.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloIApolloRenderView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ysk
 * JD-Core Version:    0.7.0.1
 */