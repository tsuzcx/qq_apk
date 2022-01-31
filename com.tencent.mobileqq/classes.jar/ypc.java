import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.widget.QQToast;

public class ypc
  implements Runnable
{
  public ypc(SpriteUIHandler paramSpriteUIHandler, String paramString) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      QQToast.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString, 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ypc
 * JD-Core Version:    0.7.0.1
 */