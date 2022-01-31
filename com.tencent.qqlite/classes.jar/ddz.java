import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.SogouEmoji;
import com.tencent.mobileqq.emoticon.SogouEmojiTaskController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ddz
  implements Runnable
{
  public ddz(SogouEmoji paramSogouEmoji, String paramString1, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullSingleEmojiKey begins, packId=" + this.jdField_a_of_type_JavaLangString + ",exprId:" + this.b + ",isNewTask:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(this.jdField_a_of_type_JavaLangString) == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.b = this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.a(this.jdField_a_of_type_JavaLangString, this.b);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(this.jdField_a_of_type_JavaLangString, EmojiManager.c, this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji$OnEmojiJsonBackSogou, this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.b, this.b);
      if (QLog.isColorLevel()) {
        QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullSingleEmojiKey ends, fail to search 【the pack】 from db, try get json from srv, mCurTaskId:" + this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.b);
      }
    }
    do
    {
      Emoticon localEmoticon;
      do
      {
        return;
        localEmoticon = this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(this.jdField_a_of_type_JavaLangString, this.b);
        if (localEmoticon != null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.b = this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.a(this.jdField_a_of_type_JavaLangString, this.b);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(this.jdField_a_of_type_JavaLangString, EmojiManager.c, this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji$OnEmojiJsonBackSogou, this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.b, this.b);
      } while (!QLog.isColorLevel());
      QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullSingleEmojiKey ends, fail to search 【the emotion】 from db, try get json from srv, mCurTaskId:" + this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.b);
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localEmoticon);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.b = this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.a(this.jdField_a_of_type_JavaLangString, this.b);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.a(this.jdField_a_of_type_JavaLangString, localArrayList, new dea(this));
    } while (!QLog.isColorLevel());
    QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullSingleEmojiKey ends, everything is ok, try get keys from svr");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ddz
 * JD-Core Version:    0.7.0.1
 */