import android.os.Build.VERSION;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import java.io.File;

public class uph
  implements azlv
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
  
  public uph(PublishVideoEntry paramPublishVideoEntry, String paramString, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
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
  
  public azlw a(int paramInt1, int paramInt2)
  {
    azlw localazlw = new azlw();
    if (paramInt1 <= paramInt2)
    {
      Object localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localazlw.jdField_a_of_type_JavaIoFile = ((File)localObject);
      localazlw.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localazlw.jdField_a_of_type_Float = (960.0F / paramInt2);
      localazlw.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      localazlw.jdField_b_of_type_Boolean = a();
      localazlw.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localazlw.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      localazlw.jdField_c_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localazlw.jdField_d_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localazlw.g = this.jdField_d_of_type_Int;
      localazlw.h = this.e;
      localazlw.i = this.f;
      localazlw.j = this.g;
      localazlw.f = this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hwBitrateMode;
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isNeedHighProfile)
      {
        localazlw.jdField_a_of_type_Boolean = true;
        localazlw.jdField_d_of_type_Int = 8;
        localazlw.e = 512;
      }
      if (uvt.e())
      {
        wxe.d(upd.jdField_a_of_type_JavaLangString, "story debug mode is enable");
        localObject = (uvt)uwa.a(10);
        paramInt1 = ((Integer)((uvt)localObject).b("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
        paramInt2 = ((Integer)((uvt)localObject).b("int_story_debug_bitrate_mode", Integer.valueOf(localazlw.f))).intValue();
        boolean bool = ((Boolean)((uvt)localObject).b("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
        localazlw.f = paramInt2;
        localazlw.jdField_a_of_type_Int = (paramInt1 * 1000);
        if (!bool) {
          break label571;
        }
        localazlw.jdField_a_of_type_Boolean = true;
        localazlw.jdField_d_of_type_Int = 8;
      }
    }
    for (localazlw.e = 512;; localazlw.e = 512)
    {
      wxe.a(upd.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: getEncodeConfig() config.setRotation = " + localazlw.jdField_b_of_type_Boolean + ", scaleRate=" + localazlw.jdField_a_of_type_Float + ", videoBitRate=" + localazlw.jdField_a_of_type_Int + ", videoFrameRate=" + localazlw.jdField_b_of_type_Int + ", beginTime=" + localazlw.jdField_a_of_type_Long + ", endTime=" + localazlw.jdField_b_of_type_Long, ", isMute=" + this.jdField_b_of_type_Boolean, ", accurateSeek=" + this.jdField_c_of_type_Boolean + ", cropX=" + this.jdField_d_of_type_Int + ", cropY=" + this.e + ", cropWidth=" + this.f + ", cropHeight=" + this.g + ",bitrateMode=" + localazlw.f + ",setProfileLevel=" + localazlw.jdField_a_of_type_Boolean + ",profile=" + localazlw.jdField_d_of_type_Int + ", level=" + localazlw.e);
      return localazlw;
      paramInt2 = paramInt1;
      break;
      label571:
      localazlw.jdField_a_of_type_Boolean = false;
      localazlw.jdField_d_of_type_Int = 1;
    }
  }
  
  public void a()
  {
    wxe.e(upd.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onSuccessed");
  }
  
  public void a(int paramInt)
  {
    wxe.b(upd.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onProgress:" + paramInt);
  }
  
  public void a(Throwable paramThrowable)
  {
    wxe.e(upd.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onFailed");
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
    wxe.c(upd.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onCanceled");
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uph
 * JD-Core Version:    0.7.0.1
 */