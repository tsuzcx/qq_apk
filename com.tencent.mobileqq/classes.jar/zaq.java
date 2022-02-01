import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.io.File;

public class zaq
  extends zan
{
  private yxt a;
  
  public void a()
  {
    super.a();
    if (jdField_b_of_type_Int != 2)
    {
      String str = new File(this.jdField_b_of_type_JavaLangString).getParent();
      if (str != null) {
        bhmi.a(str);
      }
    }
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, AppInterface paramAppInterface, yxt paramyxt)
  {
    super.a(paramActivity, paramString1, paramString2, paramAppInterface);
    this.a = paramyxt;
  }
  
  protected boolean a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem.action == 2)
    {
      if (this.a != null) {
        this.a.a();
      }
      return true;
    }
    return super.a(paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zaq
 * JD-Core Version:    0.7.0.1
 */