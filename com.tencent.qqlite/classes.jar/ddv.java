import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.SogouEmoji;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ddv
  implements Runnable
{
  public ddv(SogouEmoji paramSogouEmoji, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullMultipleEmojiKey begins, allPackId:" + this.jdField_a_of_type_JavaUtilList);
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullMultipleEmojiKey ends, param packid is null.");
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullMultipleEmojiKey,size:" + this.jdField_a_of_type_JavaUtilList.size());
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(str);
        if (localObject == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(str, EmojiManager.c);
          if (QLog.isColorLevel()) {
            QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullMultipleEmojiKey, packId=" + str + ",fail to search 【the pack】 from db, try get json from svr.");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullMultipleEmojiKey, packId=" + str + ",type:" + ((EmoticonPackage)localObject).type + ",json exists in local db.");
          }
          localObject = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(str);
          localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.a((ArrayList)localObject);
          if ((localObject != null) && (((ArrayList)localObject).size() != 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.a(str, (ArrayList)localObject, null);
            if (QLog.isColorLevel()) {
              QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullMultipleEmojiKey ends, packId=" + str + ", try get keys from svr.");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ddv
 * JD-Core Version:    0.7.0.1
 */