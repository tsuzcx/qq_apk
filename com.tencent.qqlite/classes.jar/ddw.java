import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.EmosmHandler.EmosmHandlerListener;
import com.tencent.mobileqq.data.EmosmResp;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.SogouEmoji;
import com.tencent.mobileqq.emoticon.SogouEmoji.OnEmojiKeyBackSogou;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ddw
  implements EmosmHandler.EmosmHandlerListener
{
  public ddw(SogouEmoji paramSogouEmoji, ArrayList paramArrayList, SogouEmoji.OnEmojiKeyBackSogou paramOnEmojiKeyBackSogou) {}
  
  public void a(boolean paramBoolean, int paramInt, EmosmResp paramEmosmResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func onEmosmBack begins, isSuccess:" + paramBoolean + ",type:" + paramInt + ",er:" + paramEmosmResp);
    }
    if (!paramBoolean) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqAppEmosmHandler.b(this);
      paramEmosmResp = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramEmosmResp.hasNext())
      {
        Emoticon localEmoticon = (Emoticon)paramEmosmResp.next();
        if (localEmoticon != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func onEmosmBack, emo.encryptKey=" + localEmoticon.encryptKey + ",emo.id:" + localEmoticon.eId);
          }
          this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(localEmoticon);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji$OnEmojiKeyBackSogou != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji$OnEmojiKeyBackSogou.a(this.jdField_a_of_type_JavaUtilArrayList);
      }
    } while (!QLog.isColorLevel());
    QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func onEmosmBack ends ,callback:" + this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji$OnEmojiKeyBackSogou);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ddw
 * JD-Core Version:    0.7.0.1
 */