import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class fnu
  extends Thread
{
  public fnu(EmoticonController paramEmoticonController, String paramString) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_JavaLangString + ".err";
    if (FileUtils.b(this.jdField_a_of_type_JavaLangString, str)) {}
    for (;;)
    {
      FileUtils.a(str);
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.EmoDown", 2, "EMaterialTask| zip folder is lossy, Do delete ok.:" + str);
      }
      return;
      str = this.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     fnu
 * JD-Core Version:    0.7.0.1
 */