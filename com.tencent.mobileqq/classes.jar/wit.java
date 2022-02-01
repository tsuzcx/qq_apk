import android.os.Build.VERSION;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import java.io.File;

public class wit
  implements bcmt
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
  
  public wit(PublishVideoEntry paramPublishVideoEntry, String paramString, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
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
  
  public bcmu a(int paramInt1, int paramInt2)
  {
    bcmu localbcmu = new bcmu();
    if (paramInt1 <= paramInt2)
    {
      Object localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localbcmu.jdField_a_of_type_JavaIoFile = ((File)localObject);
      localbcmu.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localbcmu.jdField_a_of_type_Float = (960.0F / paramInt2);
      localbcmu.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      localbcmu.jdField_b_of_type_Boolean = a();
      localbcmu.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localbcmu.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      localbcmu.jdField_c_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localbcmu.jdField_d_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localbcmu.g = this.jdField_d_of_type_Int;
      localbcmu.h = this.e;
      localbcmu.i = this.f;
      localbcmu.j = this.g;
      localbcmu.f = this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hwBitrateMode;
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isNeedHighProfile)
      {
        localbcmu.jdField_a_of_type_Boolean = true;
        localbcmu.jdField_d_of_type_Int = 8;
        localbcmu.e = 512;
      }
      if (wpf.e())
      {
        yqp.d(wip.jdField_a_of_type_JavaLangString, "story debug mode is enable");
        localObject = (wpf)wpm.a(10);
        paramInt1 = ((Integer)((wpf)localObject).b("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
        paramInt2 = ((Integer)((wpf)localObject).b("int_story_debug_bitrate_mode", Integer.valueOf(localbcmu.f))).intValue();
        boolean bool = ((Boolean)((wpf)localObject).b("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
        localbcmu.f = paramInt2;
        localbcmu.jdField_a_of_type_Int = (paramInt1 * 1000);
        if (!bool) {
          break label571;
        }
        localbcmu.jdField_a_of_type_Boolean = true;
        localbcmu.jdField_d_of_type_Int = 8;
      }
    }
    for (localbcmu.e = 512;; localbcmu.e = 512)
    {
      yqp.a(wip.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: getEncodeConfig() config.setRotation = " + localbcmu.jdField_b_of_type_Boolean + ", scaleRate=" + localbcmu.jdField_a_of_type_Float + ", videoBitRate=" + localbcmu.jdField_a_of_type_Int + ", videoFrameRate=" + localbcmu.jdField_b_of_type_Int + ", beginTime=" + localbcmu.jdField_a_of_type_Long + ", endTime=" + localbcmu.jdField_b_of_type_Long, ", isMute=" + this.jdField_b_of_type_Boolean, ", accurateSeek=" + this.jdField_c_of_type_Boolean + ", cropX=" + this.jdField_d_of_type_Int + ", cropY=" + this.e + ", cropWidth=" + this.f + ", cropHeight=" + this.g + ",bitrateMode=" + localbcmu.f + ",setProfileLevel=" + localbcmu.jdField_a_of_type_Boolean + ",profile=" + localbcmu.jdField_d_of_type_Int + ", level=" + localbcmu.e);
      return localbcmu;
      paramInt2 = paramInt1;
      break;
      label571:
      localbcmu.jdField_a_of_type_Boolean = false;
      localbcmu.jdField_d_of_type_Int = 1;
    }
  }
  
  public void a()
  {
    yqp.e(wip.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onSuccessed");
  }
  
  public void a(int paramInt)
  {
    yqp.b(wip.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onProgress:" + paramInt);
  }
  
  public void a(Throwable paramThrowable)
  {
    yqp.e(wip.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onFailed");
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
    yqp.c(wip.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onCanceled");
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wit
 * JD-Core Version:    0.7.0.1
 */