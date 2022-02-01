import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.compress.PicQualityCommon;
import com.tencent.mobileqq.pic.compress.PicType;
import com.tencent.mobileqq.pic.compress.PicTypeNormal;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;

public class gec
  extends PicQualityCommon
{
  public gec(PicTypeNormal paramPicTypeNormal, PicType paramPicType)
  {
    super(paramPicType);
  }
  
  protected final int[] a()
  {
    int[] arrayOfInt = new int[2];
    switch (this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.g)
    {
    default: 
      return null;
    case 0: 
      arrayOfInt[0] = 960;
      arrayOfInt[1] = 1920;
      return arrayOfInt;
    }
    arrayOfInt[0] = 1600;
    arrayOfInt[1] = 3200;
    return arrayOfInt;
  }
  
  protected boolean b()
  {
    float f = 1.0F;
    int n = 0;
    Object localObject1 = a();
    int i1 = localObject1[0];
    int i = localObject1[1];
    if (localObject1 == null)
    {
      Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.jdField_a_of_type_JavaLangString + " largerSide is null");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.e = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.g);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.e))
    {
      Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.jdField_a_of_type_JavaLangString + " destPath is empty");
      return false;
    }
    if (FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.e))
    {
      Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.jdField_a_of_type_JavaLangString + " destPath exist. return true");
      return true;
    }
    localObject1 = new BitmapFactory.Options();
    if (!Utils.a((BitmapFactory.Options)localObject1, this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.jdField_c_of_type_JavaLangString, i, i1))
    {
      Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.jdField_a_of_type_JavaLangString + " calculateInSampleSize fail");
      return false;
    }
    Bitmap localBitmap;
    try
    {
      localBitmap = BitmapFactory.decodeFile(this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.jdField_c_of_type_JavaLangString, (BitmapFactory.Options)localObject1);
      if (localBitmap == null)
      {
        Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.jdField_a_of_type_JavaLangString + " bm == null, maybe is broken");
        return false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.a(true);
      localOutOfMemoryError1.printStackTrace();
      Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.jdField_a_of_type_JavaLangString + " decodeFile oom, execute commonCompress()");
      this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.e = "";
      return this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.c();
    }
    i = localBitmap.getWidth();
    int j = localBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    int m;
    if (i > j)
    {
      k = i;
      m = j;
      if (k <= i1) {
        break label703;
      }
      f = i1 / (1.0F * k);
      m = (int)(m * f);
      k = (int)(k * f);
    }
    label703:
    for (int k = 1;; k = 0) {
      for (;;)
      {
        if (i > j) {}
        i1 = ImageUtil.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.jdField_c_of_type_JavaLangString);
        m = n;
        if (this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.jdField_c_of_type_Boolean)
        {
          m = n;
          if (i1 != 0)
          {
            m = n;
            if (i1 % 90 == 0)
            {
              localMatrix.postRotate(i1, i >> 1, j >> 1);
              m = 1;
            }
          }
        }
        if (k != 0) {
          localMatrix.postScale(f, f);
        }
        Object localObject2;
        if (m == 0)
        {
          localObject2 = localBitmap;
          if (k == 0) {
            break label601;
          }
        }
        try
        {
          localObject2 = Bitmap.createBitmap(localBitmap, 0, 0, i, j, localMatrix, true);
          label601:
          boolean bool = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.e, (Bitmap)localObject2, this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a(), this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.jdField_a_of_type_JavaLangString);
          if (localObject2 != null) {
            ((Bitmap)localObject2).recycle();
          }
          return bool;
          k = j;
          m = i;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          for (;;)
          {
            Logger.b(this.jdField_a_of_type_JavaLangString, "compress()", this.jdField_a_of_type_ComTencentMobileqqPicCompressPicTypeNormal.a.jdField_a_of_type_JavaLangString + " scale or rotate createBitmap OutOfMemoryError");
            Object localObject3 = localBitmap;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gec
 * JD-Core Version:    0.7.0.1
 */