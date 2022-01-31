import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;

class ytf
  implements View.OnClickListener
{
  ytf(yte paramyte) {}
  
  public void onClick(View paramView)
  {
    ApolloGameActivity.c(this.a.jdField_a_of_type_Ytc.a).setVisibility(4);
    ApolloGameActivity.a(this.a.jdField_a_of_type_Ytc.a).setVisibility(4);
    ApolloGameActivity.a(this.a.jdField_a_of_type_Ytc.a).setVisibility(0);
    if (this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$ICmGameConfirmListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$ICmGameConfirmListener.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ytf
 * JD-Core Version:    0.7.0.1
 */