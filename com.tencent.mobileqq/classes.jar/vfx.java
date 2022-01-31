import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConvertConfig;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class vfx
  implements VideoConverter.Processor
{
  final int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  final String jdField_a_of_type_JavaLangString;
  Throwable jdField_a_of_type_JavaLangThrowable;
  final int b;
  
  vfx(vft paramvft, String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    if (paramInt2 > 0) {}
    for (this.jdField_b_of_type_Int = paramInt2;; this.jdField_b_of_type_Int = 30)
    {
      this.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_JavaLangThrowable = null;
      if (paramString != null) {
        break;
      }
      throw new IllegalArgumentException("null == outputFilePath");
    }
  }
  
  public VideoConverter.VideoConvertConfig a(int paramInt1, int paramInt2)
  {
    double d1 = 0.27D;
    double d2 = 0.067D;
    long l2 = 209715200L;
    VideoConverter.VideoConvertConfig localVideoConvertConfig = new VideoConverter.VideoConvertConfig();
    Object localObject;
    int i;
    double d4;
    long l1;
    int m;
    if ((this.jdField_a_of_type_Vft.b != null) && (this.jdField_a_of_type_Vft.b.get() != null))
    {
      localObject = SharedPreUtils.q(((QQAppInterface)this.jdField_a_of_type_Vft.b.get()).getApp(), ((QQAppInterface)this.jdField_a_of_type_Vft.b.get()).getCurrentAccountUin());
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: getEncodeConfig, compressConfig = " + (String)localObject);
        }
        localObject = ((String)localObject).split("\\|");
        if ((localObject != null) && (localObject.length >= 5))
        {
          for (;;)
          {
            try
            {
              i = Integer.valueOf(localObject[0]).intValue();
              if (i <= 0) {
                continue;
              }
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              double d5;
              double d3 = 0.27D;
              int j = 30;
              int k = 960;
              d2 = 0.067D;
              d1 = d2;
              l1 = l2;
              d4 = d3;
              i = j;
              m = k;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.e("ShortVideoItemBuilder", 2, "getEncodeConfig -> get VideoCompressConfig Erro", localNumberFormatException1);
              d1 = d2;
              l1 = l2;
              d4 = d3;
              i = j;
              m = k;
              continue;
              j = paramInt1;
              continue;
              localVideoConvertConfig.jdField_a_of_type_Int = ((int)d2);
              continue;
              i = 960;
              continue;
            }
            try
            {
              j = Integer.valueOf(localObject[1]).intValue();
              if (j <= 0) {
                continue;
              }
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              d3 = 0.27D;
              j = 30;
              d2 = 0.067D;
              k = i;
              continue;
              j = 30;
            }
          }
          d4 = d2;
          d3 = d1;
          try
          {
            d5 = Double.valueOf(localObject[2]).doubleValue();
            if (d5 > 0.0D) {
              d1 = d5;
            }
            d4 = d2;
            d3 = d1;
            d5 = Double.valueOf(localObject[3]).doubleValue();
            if (d5 > 0.0D) {
              d2 = d5;
            }
            d4 = d2;
            d3 = d1;
            k = Integer.valueOf(localObject[4]).intValue();
            if (k <= 0) {
              break label999;
            }
            l1 = k * 1024 * 1024 * 8;
          }
          catch (NumberFormatException localNumberFormatException3)
          {
            for (;;)
            {
              d2 = d4;
              k = i;
              continue;
              d1 = d2;
              continue;
              l1 = 209715200L;
            }
          }
          m = i;
          i = j;
          d4 = d1;
          d1 = d2;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: getEncodeConfig, maxLength = " + m + ", maxFPS = " + i + ", density = " + d4 + ", minDensity = " + d1 + ", maxSize = " + l1);
      }
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localVideoConvertConfig.jdField_a_of_type_JavaIoFile = ((File)localObject);
      if (paramInt1 <= paramInt2)
      {
        j = paramInt2;
        localVideoConvertConfig.jdField_a_of_type_Float = (m / j);
        if (localVideoConvertConfig.jdField_a_of_type_Float > 1.0F) {
          localVideoConvertConfig.jdField_a_of_type_Float = 1.0F;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: getEncodeConfig, config.scaleRate = " + localVideoConvertConfig.jdField_a_of_type_Float + ", width = " + paramInt1 + ", height = " + paramInt2);
        }
        j = i;
        if (this.jdField_b_of_type_Int <= i) {
          j = this.jdField_b_of_type_Int;
        }
        localVideoConvertConfig.jdField_b_of_type_Int = j;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: getEncodeConfig, config.videoFrameRate = " + localVideoConvertConfig.jdField_b_of_type_Int + ", mSrcVideoFrameRate = " + this.jdField_b_of_type_Int);
        }
        d3 = d4 * (paramInt1 * paramInt2 * localVideoConvertConfig.jdField_a_of_type_Float * localVideoConvertConfig.jdField_a_of_type_Float * localVideoConvertConfig.jdField_b_of_type_Int);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: getEncodeConfig, dpsExp = " + d3 + ", mSrcVideoBitrate = " + this.jdField_a_of_type_Int);
        }
        d2 = d3;
        if (d3 > this.jdField_a_of_type_Int) {
          d2 = this.jdField_a_of_type_Int;
        }
        if (this.jdField_a_of_type_Long * d2 <= l1) {
          break label946;
        }
        d2 = (float)l1 / (paramInt1 * paramInt2 * localVideoConvertConfig.jdField_a_of_type_Float * localVideoConvertConfig.jdField_a_of_type_Float * localVideoConvertConfig.jdField_b_of_type_Int * (float)this.jdField_a_of_type_Long);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: getEncodeConfig, densityExp = " + d2);
        }
        if (d2 >= d1) {
          break label993;
        }
        localVideoConvertConfig.jdField_a_of_type_Int = ((int)(d1 * (paramInt1 * paramInt2 * localVideoConvertConfig.jdField_a_of_type_Float * localVideoConvertConfig.jdField_a_of_type_Float * localVideoConvertConfig.jdField_b_of_type_Int)));
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: getEncodeConfig, config.videoBitRate " + localVideoConvertConfig.jdField_a_of_type_Int);
        }
        localVideoConvertConfig.jdField_b_of_type_Boolean = a();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: getEncodeConfig() config.setRotation = " + localVideoConvertConfig.jdField_b_of_type_Boolean);
        }
        return localVideoConvertConfig;
      }
      label946:
      label993:
      label999:
      d4 = 0.27D;
      i = 30;
      m = 960;
      d1 = 0.067D;
      l1 = l2;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: HWCompressProcessor onSuccessed");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "CompressTask, step: HWCompressProcessor onProgress:" + paramInt);
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoItemBuilder", 2, "CompressTask, step: HWCompressProcessor onFailed");
    }
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT <= 19)) {
      bool = true;
    }
    while (Build.VERSION.SDK_INT <= 19) {
      return bool;
    }
    return false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vfx
 * JD-Core Version:    0.7.0.1
 */