package com.tencent.mobileqq.pic.compress;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.utils.FileUtils;

public abstract class PicType
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 2;
  public CompressInfo a;
  protected PicQuality a;
  protected String a;
  
  PicType(CompressInfo paramCompressInfo)
  {
    this.jdField_a_of_type_JavaLangString = getClass().getSimpleName();
    if ((paramCompressInfo == null) || (TextUtils.isEmpty(paramCompressInfo.jdField_c_of_type_JavaLangString))) {
      throw new IllegalArgumentException("info == null || TextUtils.isEmpty(info.srcPath)");
    }
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo = paramCompressInfo;
    this.jdField_a_of_type_ComTencentMobileqqPicCompressPicQuality = a();
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressPicQuality == null) {
      throw new IllegalArgumentException("create PicQuality is Fail");
    }
  }
  
  private int a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!FileUtils.b(paramString1))) {
      Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " sampleCompress()", " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
    }
    BitmapFactory.Options localOptions;
    do
    {
      return 0;
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = false;
      localOptions.inSampleSize = 2;
      try
      {
        Bitmap localBitmap3 = BitmapFactory.decodeFile(paramString1, localOptions);
        Bitmap localBitmap1 = localBitmap3;
        if (localBitmap3 != null) {
          break;
        }
        Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " sampleCompress()", " bm == null, maybe is broken");
        return 0;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(true);
        Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " sampleCompress()", " decodeFile OutOfMemoryError, sampleCnt:" + 1 + " oomKeepCompress:" + paramBoolean);
      }
    } while (!paramBoolean);
    localOptions.inSampleSize = 4;
    for (;;)
    {
      try
      {
        Bitmap localBitmap2 = BitmapFactory.decodeFile(paramString1, localOptions);
        i = 2;
        paramBoolean = Utils.a(paramString2, localBitmap2, a(), this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
        if (localBitmap2 != null) {
          localBitmap2.recycle();
        }
        if (paramBoolean) {
          return i;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(false);
        paramString1.printStackTrace();
        Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " sampleCompress()", " oomKeepCompress decodeFile OutOfMemoryError, sampleCnt:" + 2);
        return 0;
      }
      i = 0;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2);
  }
  
  public final int a()
  {
    int i = 80;
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.d;
    switch (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g)
    {
    default: 
      i = 100;
    }
    do
    {
      do
      {
        return i;
      } while (bool);
      return 70;
    } while (!bool);
    return 90;
  }
  
  protected abstract PicQuality a();
  
  boolean a()
  {
    if (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_c_of_type_JavaLangString))
    {
      Logger.b(this.jdField_a_of_type_JavaLangString, "start()", this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " src file does not exist");
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPicCompressPicQuality.a();
  }
  
  final int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.d) {
      return 20971520;
    }
    return 4194304;
  }
  
  boolean b()
  {
    boolean bool1 = false;
    if (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_c_of_type_JavaLangString)) {
      Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", " src file does not exist");
    }
    boolean bool2;
    do
    {
      return bool1;
      this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_c_of_type_JavaLangString);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString))
      {
        Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", " destPath is empty");
        return false;
      }
      if (FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString))
      {
        Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", " destPath exist. return true");
        return true;
      }
      bool2 = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_c_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString);
      bool1 = bool2;
    } while (bool2);
    this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
    Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", " compressAIOThumbnail is failed");
    return bool2;
  }
  
  final int c()
  {
    return 20971520;
  }
  
  public final boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g == 2) {
      if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_c_of_type_JavaLangString) <= c())
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_c_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress() 直接传原图，UI上选择了原图");
        Logger.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", "直接传原图，UI上选择了原图");
        if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_Int != 2) {
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_Boolean = true;
        }
      }
    }
    for (;;)
    {
      return true;
      Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", "直接传原图，UI上选择了原图，该图片 > 最大文件限制");
      continue;
      if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_c_of_type_JavaLangString) > b())
      {
        Logger.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " src file size > max, file size:" + Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_c_of_type_JavaLangString) + " max:" + b());
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.g);
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString))
        {
          Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " destPath is empty");
          return false;
        }
        if (FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString))
        {
          Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " destPath exist. return true");
          return true;
        }
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.h = 0;
        int i = a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString, true);
        if (i != 0)
        {
          Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
          ((CompressInfo)localObject1).h = (i + ((CompressInfo)localObject1).h);
          if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString) > b())
          {
            if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.h >= 2)
            {
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(false);
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()" + " 面积是原来的1/16，不能再小了fileSize:" + Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString) + " max:" + b());
              Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " 面积是原来的1/16，不能再小了fileSize:" + Utils.a(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString) + " max:" + b());
              FileUtils.d(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString);
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
              return false;
            }
            Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString;
            localObject1 = (String)localObject2 + "_second";
            this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
            i = a((String)localObject2, (String)localObject1, false);
            FileUtils.d((String)localObject2);
            if (i != 0)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo;
              ((CompressInfo)localObject2).h = (i + ((CompressInfo)localObject2).h);
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = ((String)localObject1);
              if (Utils.a((String)localObject1) > b())
              {
                this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.a(false);
                this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()" + " 已经2次sample压缩，长、宽各是原来的1/4；面积是原来的1/16。fileSize:" + Utils.a((String)localObject1) + " max:" + b());
                Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " 已经2次sample压缩，长、宽各是原来的1/4；面积是原来的1/16。fileSize:" + Utils.a((String)localObject1) + " max:" + b());
                FileUtils.d(this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString);
                this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
                return false;
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
              this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()" + " 第二次压缩失败");
              Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " 第二次压缩失败");
              return false;
            }
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = "";
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()" + " sampleCompress failed");
          Logger.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", " sampleCompress failed");
          return false;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_c_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress() 直接传原图");
        Logger.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_a_of_type_JavaLangString + " commonCompress()", "直接传原图");
        if (this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_f_of_type_Int != 2) {
          this.jdField_a_of_type_ComTencentMobileqqPicCompressInfo.jdField_e_of_type_Boolean = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.PicType
 * JD-Core Version:    0.7.0.1
 */