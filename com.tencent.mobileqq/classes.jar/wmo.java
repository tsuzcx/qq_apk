import android.os.Build.VERSION;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import java.io.File;

public class wmo
  implements bdfl
{
  int jdField_a_of_type_Int = 1024000;
  final long jdField_a_of_type_Long;
  PublishVideoEntry jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
  final String jdField_a_of_type_JavaLangString;
  public Throwable a;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 25;
  final long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  int d;
  int e;
  int f;
  int g;
  
  public wmo(PublishVideoEntry paramPublishVideoEntry, String paramString, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = paramPublishVideoEntry;
  }
  
  public bdfm a(int paramInt1, int paramInt2)
  {
    bdfm localbdfm = new bdfm();
    if (paramInt1 <= paramInt2)
    {
      Object localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localbdfm.jdField_a_of_type_JavaIoFile = ((File)localObject);
      localbdfm.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localbdfm.jdField_a_of_type_Float = (960.0F / paramInt2);
      localbdfm.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      localbdfm.jdField_b_of_type_Boolean = a();
      localbdfm.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localbdfm.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      localbdfm.jdField_c_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localbdfm.jdField_d_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localbdfm.g = this.jdField_d_of_type_Int;
      localbdfm.h = this.e;
      localbdfm.i = this.f;
      localbdfm.j = this.g;
      localbdfm.f = this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hwBitrateMode;
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isNeedHighProfile)
      {
        localbdfm.jdField_a_of_type_Boolean = true;
        localbdfm.jdField_d_of_type_Int = 8;
        localbdfm.e = 512;
      }
      if (wta.e())
      {
        yuk.d(wmk.jdField_a_of_type_JavaLangString, "story debug mode is enable");
        localObject = (wta)wth.a(10);
        paramInt1 = ((Integer)((wta)localObject).b("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
        paramInt2 = ((Integer)((wta)localObject).b("int_story_debug_bitrate_mode", Integer.valueOf(localbdfm.f))).intValue();
        boolean bool = ((Boolean)((wta)localObject).b("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
        localbdfm.f = paramInt2;
        localbdfm.jdField_a_of_type_Int = (paramInt1 * 1000);
        if (!bool) {
          break label571;
        }
        localbdfm.jdField_a_of_type_Boolean = true;
        localbdfm.jdField_d_of_type_Int = 8;
      }
    }
    for (localbdfm.e = 512;; localbdfm.e = 512)
    {
      yuk.a(wmk.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: getEncodeConfig() config.setRotation = " + localbdfm.jdField_b_of_type_Boolean + ", scaleRate=" + localbdfm.jdField_a_of_type_Float + ", videoBitRate=" + localbdfm.jdField_a_of_type_Int + ", videoFrameRate=" + localbdfm.jdField_b_of_type_Int + ", beginTime=" + localbdfm.jdField_a_of_type_Long + ", endTime=" + localbdfm.jdField_b_of_type_Long, ", isMute=" + this.jdField_b_of_type_Boolean, ", accurateSeek=" + this.jdField_c_of_type_Boolean + ", cropX=" + this.jdField_d_of_type_Int + ", cropY=" + this.e + ", cropWidth=" + this.f + ", cropHeight=" + this.g + ",bitrateMode=" + localbdfm.f + ",setProfileLevel=" + localbdfm.jdField_a_of_type_Boolean + ",profile=" + localbdfm.jdField_d_of_type_Int + ", level=" + localbdfm.e);
      return localbdfm;
      paramInt2 = paramInt1;
      break;
      label571:
      localbdfm.jdField_a_of_type_Boolean = false;
      localbdfm.jdField_d_of_type_Int = 1;
    }
  }
  
  public void a()
  {
    yuk.e(wmk.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onSuccessed");
  }
  
  public void a(int paramInt)
  {
    yuk.b(wmk.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onProgress:" + paramInt);
  }
  
  public void a(Throwable paramThrowable)
  {
    yuk.e(wmk.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onFailed");
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
  
  public void b()
  {
    yuk.c(wmk.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onCanceled");
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wmo
 * JD-Core Version:    0.7.0.1
 */