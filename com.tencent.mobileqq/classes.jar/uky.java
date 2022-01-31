import android.os.Build.VERSION;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import java.io.File;

public class uky
  implements azhm
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
  
  public uky(PublishVideoEntry paramPublishVideoEntry, String paramString, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
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
  
  public azhn a(int paramInt1, int paramInt2)
  {
    azhn localazhn = new azhn();
    if (paramInt1 <= paramInt2)
    {
      Object localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localazhn.jdField_a_of_type_JavaIoFile = ((File)localObject);
      localazhn.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localazhn.jdField_a_of_type_Float = (960.0F / paramInt2);
      localazhn.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      localazhn.jdField_b_of_type_Boolean = a();
      localazhn.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localazhn.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      localazhn.jdField_c_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localazhn.jdField_d_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localazhn.g = this.jdField_d_of_type_Int;
      localazhn.h = this.e;
      localazhn.i = this.f;
      localazhn.j = this.g;
      localazhn.f = this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hwBitrateMode;
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isNeedHighProfile)
      {
        localazhn.jdField_a_of_type_Boolean = true;
        localazhn.jdField_d_of_type_Int = 8;
        localazhn.e = 512;
      }
      if (urk.e())
      {
        wsv.d(uku.jdField_a_of_type_JavaLangString, "story debug mode is enable");
        localObject = (urk)urr.a(10);
        paramInt1 = ((Integer)((urk)localObject).b("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
        paramInt2 = ((Integer)((urk)localObject).b("int_story_debug_bitrate_mode", Integer.valueOf(localazhn.f))).intValue();
        boolean bool = ((Boolean)((urk)localObject).b("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
        localazhn.f = paramInt2;
        localazhn.jdField_a_of_type_Int = (paramInt1 * 1000);
        if (!bool) {
          break label571;
        }
        localazhn.jdField_a_of_type_Boolean = true;
        localazhn.jdField_d_of_type_Int = 8;
      }
    }
    for (localazhn.e = 512;; localazhn.e = 512)
    {
      wsv.a(uku.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: getEncodeConfig() config.setRotation = " + localazhn.jdField_b_of_type_Boolean + ", scaleRate=" + localazhn.jdField_a_of_type_Float + ", videoBitRate=" + localazhn.jdField_a_of_type_Int + ", videoFrameRate=" + localazhn.jdField_b_of_type_Int + ", beginTime=" + localazhn.jdField_a_of_type_Long + ", endTime=" + localazhn.jdField_b_of_type_Long, ", isMute=" + this.jdField_b_of_type_Boolean, ", accurateSeek=" + this.jdField_c_of_type_Boolean + ", cropX=" + this.jdField_d_of_type_Int + ", cropY=" + this.e + ", cropWidth=" + this.f + ", cropHeight=" + this.g + ",bitrateMode=" + localazhn.f + ",setProfileLevel=" + localazhn.jdField_a_of_type_Boolean + ",profile=" + localazhn.jdField_d_of_type_Int + ", level=" + localazhn.e);
      return localazhn;
      paramInt2 = paramInt1;
      break;
      label571:
      localazhn.jdField_a_of_type_Boolean = false;
      localazhn.jdField_d_of_type_Int = 1;
    }
  }
  
  public void a()
  {
    wsv.e(uku.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onSuccessed");
  }
  
  public void a(int paramInt)
  {
    wsv.b(uku.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onProgress:" + paramInt);
  }
  
  public void a(Throwable paramThrowable)
  {
    wsv.e(uku.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onFailed");
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
    wsv.c(uku.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onCanceled");
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uky
 * JD-Core Version:    0.7.0.1
 */