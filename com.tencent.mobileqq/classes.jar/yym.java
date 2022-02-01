import android.os.Handler;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.1.1;
import com.tencent.biz.richframework.download.RFWDownloader.GetFileListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class yym
  implements RFWDownloader.GetFileListener
{
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    QLog.d("AnimationDrawableFactory", 1, "cost time" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    if ((paramBoolean) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < this.jdField_a_of_type_Yyk.a()))
    {
      QLog.d("AnimationDrawableFactory", 1, "get drawable file list success:" + this.jdField_a_of_type_JavaLangString);
      paramString = yyl.a(paramString, this.jdField_a_of_type_Yyk.b());
      if ((paramString == null) || (paramString.length == 0))
      {
        this.jdField_a_of_type_Yyr.a(false, null);
        return;
      }
      ThreadManagerV2.getUIHandlerV2().post(new AnimationDrawableFactory.1.1(this, paramString));
    }
    for (;;)
    {
      QLog.d("AnimationDrawableFactory", 1, "removeKey" + this.jdField_a_of_type_JavaLangString);
      yyl.a(this.jdField_a_of_type_Yyl).remove(this.jdField_a_of_type_JavaLangString);
      return;
      QLog.d("AnimationDrawableFactory", 1, "create animationDrawable failed");
      this.jdField_a_of_type_Yyr.a(false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yym
 * JD-Core Version:    0.7.0.1
 */