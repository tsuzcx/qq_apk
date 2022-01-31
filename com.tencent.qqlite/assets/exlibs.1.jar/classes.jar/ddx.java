import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class ddx
  extends Thread
{
  public ddx(EmojiManager paramEmojiManager, String paramString) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString + ".err";
    if (FileUtils.b(this.jdField_a_of_type_JavaLangString, str)) {}
    for (;;)
    {
      FileUtils.a(str);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.jdField_a_of_type_JavaLangString, 2, "EMaterialTask| zip folder is lossy, Do delete ok.:" + str);
      }
      return;
      str = this.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ddx
 * JD-Core Version:    0.7.0.1
 */