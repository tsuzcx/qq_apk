import android.os.AsyncTask;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.io.IOException;

public class ekl
  extends AsyncTask
{
  public ekl(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, URLDrawable paramURLDrawable, String paramString) {}
  
  protected String a(Void... paramVarArgs)
  {
    try
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.saveTo(this.jdField_a_of_type_JavaLangString);
      if (paramVarArgs != null)
      {
        ImageUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, paramVarArgs);
        return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131363440) + " " + paramVarArgs;
      }
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131363441);
      return paramVarArgs;
    }
    catch (IOException paramVarArgs)
    {
      return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131363441);
    }
    catch (OutOfMemoryError paramVarArgs) {}
    return this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getString(2131363441);
  }
  
  protected void a(String paramString)
  {
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ekl
 * JD-Core Version:    0.7.0.1
 */