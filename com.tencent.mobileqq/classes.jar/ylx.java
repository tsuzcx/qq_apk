import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

public final class ylx
  implements TextWatcher
{
  public ylx(ApolloSurfaceView paramApolloSurfaceView, ApolloRender paramApolloRender) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.queueEvent(new yly(this, paramEditable));
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ylx
 * JD-Core Version:    0.7.0.1
 */