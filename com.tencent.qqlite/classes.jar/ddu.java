import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.SogouEmoji;
import com.tencent.mobileqq.emoticon.SogouEmoji.OnEmojiKeyBackSogou;
import com.tencent.mobileqq.emoticon.SogouEmojiTaskController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ddu
  implements SogouEmoji.OnEmojiKeyBackSogou
{
  ddu(ddt paramddt) {}
  
  public void a(ArrayList paramArrayList)
  {
    boolean bool = this.a.a.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.a(this.a.a.b);
    if (QLog.isColorLevel()) {
      QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func onEmojiKeyBack begins, isTaskExist:" + bool);
    }
    if (!bool) {
      if (QLog.isColorLevel()) {
        QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func onEmojiKeyBack ends, task CANCELLED by user.");
      }
    }
    do
    {
      do
      {
        return;
      } while ((paramArrayList == null) || (paramArrayList.size() == 0));
      this.a.a.a((Emoticon)paramArrayList.get(0));
    } while (!QLog.isColorLevel());
    QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func onEmojiKeyBack ends, Ready to send.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ddu
 * JD-Core Version:    0.7.0.1
 */