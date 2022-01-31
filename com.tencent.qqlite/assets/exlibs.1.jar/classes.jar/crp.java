import android.content.Context;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class crp
  implements Runnable
{
  public crp(DataLineHandler paramDataLineHandler, String paramString, int paramInt) {}
  
  public void run()
  {
    String str = "'" + this.jdField_a_of_type_JavaLangString + "'" + BaseApplication.getContext().getResources().getString(2131361873);
    QQToast.a(BaseApplicationImpl.getContext(), 1, str, 0).b(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     crp
 * JD-Core Version:    0.7.0.1
 */