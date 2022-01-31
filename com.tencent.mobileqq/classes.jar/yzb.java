import com.tencent.mobileqq.apollo.IApolloRenderView;

class yzb
  implements Runnable
{
  yzb(yza paramyza, IApolloRenderView paramIApolloRenderView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloIApolloRenderView != null)
    {
      if (yza.a(this.jdField_a_of_type_Yza)) {
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
 * Qualified Name:     yzb
 * JD-Core Version:    0.7.0.1
 */