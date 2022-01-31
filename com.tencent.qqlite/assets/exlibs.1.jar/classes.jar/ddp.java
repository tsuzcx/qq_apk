import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;

public class ddp
  implements Runnable
{
  public ddp(EmojiManager paramEmojiManager, EmoticonPackage paramEmoticonPackage, boolean paramBoolean) {}
  
  public void run()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType)
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.d, this.jdField_a_of_type_Boolean);
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.c);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.e, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ddp
 * JD-Core Version:    0.7.0.1
 */