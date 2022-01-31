import android.text.Editable;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

class yir
  implements Runnable
{
  yir(yiq paramyiq, Editable paramEditable) {}
  
  public void run()
  {
    ApolloRender localApolloRender = this.jdField_a_of_type_Yiq.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender();
    if ((localApolloRender != null) && (this.jdField_a_of_type_Yiq.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorAddr != 0L)) {
      localApolloRender.getSavaWrapper().a(this.jdField_a_of_type_Yiq.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.mEditorAddr, this.jdField_a_of_type_AndroidTextEditable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yir
 * JD-Core Version:    0.7.0.1
 */