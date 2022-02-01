import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager.5;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class afhp
  implements URLDrawable.URLDrawableListener
{
  public afhp(EmoticonFromGroupManager.5 param5, URLDrawable paramURLDrawable, CustomEmotionData paramCustomEmotionData, afhv paramafhv, afhu paramafhu) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    afhl.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0).zG.remove(this.y);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    afhl.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0).zG.remove(this.y);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    afhl.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0).zG.remove(this.y);
    paramURLDrawable = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0.kB(this.y.getURL().toString());
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0.lQ(paramURLDrawable)) {}
    String str;
    do
    {
      do
      {
        return;
        str = afhl.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoticonFromGroupManager$5.this$0, paramURLDrawable);
      } while ("".equals(str));
      this.d.emoPath = str;
      this.d.md5 = paramURLDrawable;
    } while ("".equals(str));
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonFromGroup_Manager", 4, "onLoadSuccessed upload emo " + paramURLDrawable);
      }
      this.y.saveTo(str);
      this.jdField_a_of_type_Afhv.d(this.d);
      this.val$fdb.c(this.d);
      return;
    }
    catch (IOException paramURLDrawable)
    {
      paramURLDrawable.printStackTrace();
      QLog.d("EmoticonFromGroup_Manager", 1, paramURLDrawable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhp
 * JD-Core Version:    0.7.0.1
 */