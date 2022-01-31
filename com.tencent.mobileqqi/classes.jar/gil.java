import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.compress.PicQualityCommon;
import com.tencent.mobileqq.pic.compress.PicType;
import com.tencent.mobileqq.pic.compress.PicTypeLong;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.utils.FileUtils;

public class gil
  extends PicQualityCommon
{
  public gil(PicTypeLong paramPicTypeLong, PicType paramPicType)
  {
    super(paramPicType);
  }
  
  protected boolean b()
  {
    boolean bool1 = false;
    this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeLong.a.e = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeLong.a.c, this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeLong.a.g);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeLong.a.e)) {
      Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeLong.a.jdField_a_of_type_JavaLangString + " destPath is empty");
    }
    boolean bool2;
    do
    {
      return bool1;
      if (FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeLong.a.e))
      {
        Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeLong.a.jdField_a_of_type_JavaLangString + " destPath exist. return true");
        return true;
      }
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeLong.a.c);
        if (localBitmap == null)
        {
          Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeLong.a.jdField_a_of_type_JavaLangString + " bm == null, maybe is broken");
          return false;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeLong.a.a(true);
        Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeLong.a.jdField_a_of_type_JavaLangString + " decodeFile oom, execute commonCompress()");
        this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeLong.a.e = "";
        return this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeLong.c();
      }
      bool2 = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeLong.a.e, localOutOfMemoryError, this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeLong.a(), this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeLong.a.jdField_a_of_type_JavaLangString);
      bool1 = bool2;
    } while (localOutOfMemoryError == null);
    localOutOfMemoryError.recycle();
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gil
 * JD-Core Version:    0.7.0.1
 */