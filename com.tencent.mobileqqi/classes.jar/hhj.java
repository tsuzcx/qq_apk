import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;

public class hhj
  extends Handler
{
  public hhj(QQToastNotifier paramQQToastNotifier, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (hhk)paramMessage.obj;
    if (this.a.jdField_a_of_type_AndroidWidgetToast == null)
    {
      if ((paramMessage.jdField_a_of_type_JavaLangString != null) && (paramMessage.jdField_a_of_type_JavaLangString.length() > 0)) {}
      for (this.a.jdField_a_of_type_AndroidWidgetToast = QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, paramMessage.jdField_a_of_type_Int, LocaleString.p(this.a.jdField_a_of_type_AndroidContentContext, paramMessage.jdField_a_of_type_JavaLangString), paramMessage.c).a(paramMessage.d);; this.a.jdField_a_of_type_AndroidWidgetToast = QQToast.a(this.a.jdField_a_of_type_AndroidContentContext, paramMessage.jdField_a_of_type_Int, paramMessage.b, paramMessage.c).a(paramMessage.d))
      {
        this.a.jdField_a_of_type_AndroidWidgetToast.show();
        return;
      }
    }
    View localView = this.a.jdField_a_of_type_AndroidWidgetToast.getView();
    TextView localTextView = (TextView)localView.findViewById(2131232011);
    if ((paramMessage.jdField_a_of_type_JavaLangString != null) && (paramMessage.jdField_a_of_type_JavaLangString.length() > 0)) {
      localTextView.setText(LocaleString.p(this.a.jdField_a_of_type_AndroidContentContext, paramMessage.jdField_a_of_type_JavaLangString));
    }
    for (;;)
    {
      ((ImageView)localView.findViewById(2131232010)).setImageResource(QQToast.a(paramMessage.jdField_a_of_type_Int));
      this.a.jdField_a_of_type_AndroidWidgetToast.setDuration(paramMessage.c);
      break;
      localTextView.setText(this.a.jdField_a_of_type_AndroidContentContext.getString(paramMessage.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hhj
 * JD-Core Version:    0.7.0.1
 */