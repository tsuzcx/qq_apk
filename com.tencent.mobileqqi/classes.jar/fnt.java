import com.tencent.mobileqq.emoticon.EPJsonTask;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.emoticon.EmoticonController.ProgressHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class fnt
  implements Runnable
{
  public fnt(EmoticonController paramEmoticonController, int paramInt) {}
  
  public void run()
  {
    EmoticonController.ProgressHandler localProgressHandler;
    synchronized (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController.e)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController.e.size() == 0) {
        return;
      }
      localProgressHandler = (EmoticonController.ProgressHandler)this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController.e.remove(0);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController.f.add(localProgressHandler);
      ??? = new EPJsonTask(localProgressHandler.a, EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController));
      ((EPJsonTask)???).a(localProgressHandler);
      ((EPJsonTask)???).a(this.jdField_a_of_type_Int);
    }
    try
    {
      ((EPJsonTask)???).a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmosmDetailActivity", 2, "startDownloadEmosmJson|json is loading");
      }
      EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonController.f, localProgressHandler);
      return;
      localObject1 = finally;
      throw localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.emoji.EmoDown", 2, "downloadEmosmJson Exception|" + localException.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     fnt
 * JD-Core Version:    0.7.0.1
 */