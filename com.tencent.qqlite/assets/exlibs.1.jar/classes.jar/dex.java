import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.data.EmoticonKeyword;
import com.tencent.mobileqq.data.EmoticonKeywordForCloud;
import com.tencent.mobileqq.emoticonview.EmotionPreviewLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class dex
  implements URLDrawable.URLDrawableListener
{
  public dex(EmotionPreviewLayout paramEmotionPreviewLayout) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e(EmotionPreviewLayout.jdField_a_of_type_JavaLangString, 2, "bigImage load faild");
    if ((this.a.jdField_a_of_type_AndroidWidgetEditText != null) && (this.a.b.equals(this.a.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString())))
    {
      paramThrowable = (EmoticonKeywordForCloud)paramURLDrawable.getTag();
      if (paramThrowable != null)
      {
        paramURLDrawable.setTag(paramThrowable);
        paramThrowable.loadedType = 3;
      }
      paramURLDrawable = this.a;
      paramURLDrawable.f -= 1;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 10002));
      if (this.a.f == 0) {
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 10000), 3000L);
      }
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.e(EmotionPreviewLayout.jdField_a_of_type_JavaLangString, 2, "bigImage load successed");
    if ((this.a.jdField_a_of_type_AndroidWidgetEditText != null) && (this.a.b.equals(this.a.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString())))
    {
      paramURLDrawable = (EmoticonKeywordForCloud)paramURLDrawable.getTag();
      if (paramURLDrawable != null)
      {
        paramURLDrawable.loadedType = 2;
        if (this.a.jdField_a_of_type_JavaUtilList != null)
        {
          Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
          EmoticonKeyword localEmoticonKeyword;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localEmoticonKeyword = (EmoticonKeyword)localIterator.next();
          } while ((!localEmoticonKeyword.eId.equals(paramURLDrawable.eId)) || (!localEmoticonKeyword.epId.equals(paramURLDrawable.epId)));
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.a.jdField_a_of_type_JavaUtilList.add(paramURLDrawable);
      }
      paramURLDrawable = this.a;
      paramURLDrawable.f -= 1;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 10002));
      if (this.a.f == 0) {
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.a.jdField_a_of_type_AndroidOsHandler, 10000), 3000L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dex
 * JD-Core Version:    0.7.0.1
 */