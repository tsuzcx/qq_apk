import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageChangedListener;
import java.util.ArrayList;

public class all
  implements EmoticonPackageChangedListener
{
  public all(EmosmActivity paramEmosmActivity) {}
  
  public void a(EmoticonPackage paramEmoticonPackage) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2) {}
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    int i = 0;
    while (i < this.a.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((EmoticonPackage)this.a.jdField_a_of_type_JavaUtilArrayList.get(i)).epId.equals(paramEmoticonPackage.epId)) {
        return;
      }
      i += 1;
    }
    this.a.runOnUiThread(this.a.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     all
 * JD-Core Version:    0.7.0.1
 */