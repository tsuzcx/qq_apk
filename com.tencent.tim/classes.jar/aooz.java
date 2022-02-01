import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class aooz
{
  public static int dRe = -1;
  
  public static void Sv(int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_EXIF_Info_Switch", 4).edit();
    localEditor.putInt("SP_KEY_EXIF_Info_Switch_VALUE", paramInt);
    localEditor.commit();
    dRe = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("PicUploadExifInfoSwitch", 2, "setSwitch:" + paramInt);
    }
  }
  
  public static boolean aAu()
  {
    if (ahwy.a().aok()) {}
    do
    {
      return true;
      if (dRe < 0) {
        dRe = BaseApplicationImpl.sApplication.getSharedPreferences("SP_KEY_EXIF_Info_Switch", 4).getInt("SP_KEY_EXIF_Info_Switch_VALUE", 0);
      }
    } while (dRe == 1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aooz
 * JD-Core Version:    0.7.0.1
 */