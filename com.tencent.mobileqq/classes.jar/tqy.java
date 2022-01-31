import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.app.QQAppInterface;

public class tqy
  implements Runnable
{
  public tqy(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    QQSettingMe.a(this.a).setVisibility(8);
    QQSettingMe.b(this.a).setVisibility(8);
    this.a.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "drawer", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
    if (QQSettingMe.a(this.a) == null)
    {
      PropertyValuesHolder localPropertyValuesHolder1 = PropertyValuesHolder.ofFloat("alpha", new float[] { 1.0F, 0.0F });
      PropertyValuesHolder localPropertyValuesHolder2 = PropertyValuesHolder.ofFloat("scaleX", new float[] { 1.0F, 0.0F });
      PropertyValuesHolder localPropertyValuesHolder3 = PropertyValuesHolder.ofFloat("scaleY", new float[] { 1.0F, 0.0F });
      QQSettingMe.a(this.a, ObjectAnimator.ofPropertyValuesHolder(QQSettingMe.a(this.a), new PropertyValuesHolder[] { localPropertyValuesHolder1, localPropertyValuesHolder2, localPropertyValuesHolder3 }));
      QQSettingMe.a(this.a).setDuration(200L);
      QQSettingMe.a(this.a).addListener(new tqz(this));
    }
    QQSettingMe.b(this.a, true);
    QQSettingMe.a(this.a).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tqy
 * JD-Core Version:    0.7.0.1
 */