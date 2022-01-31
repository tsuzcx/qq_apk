import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class tia
  implements thy
{
  private long jdField_a_of_type_Long;
  private thz jdField_a_of_type_Thz = new thz();
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    tlo.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_CHANGE_HW_BACKUP_URL");
    this.jdField_a_of_type_Thz.jdField_b_of_type_Boolean = true;
  }
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramObject = ((String)paramObject).split(":", 2);
      if (paramObject.length == 2)
      {
        String str = paramObject[1];
        this.jdField_a_of_type_Thz.jdField_e_of_type_JavaLangString = str;
        tlo.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] PERFORMANCE_REPORT method:" + paramObject[0] + ", timeJson:" + str);
      }
    }
  }
  
  private void a(thz paramthz)
  {
    tlo.d("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onStop] mReportData:" + paramthz.toString());
    this.jdField_a_of_type_Boolean = true;
    tib.a(paramthz);
  }
  
  private void b()
  {
    tlo.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_DECODER_BLOCK");
  }
  
  private void b(Object paramObject)
  {
    tlo.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_HW_DECODE_FAILED");
    if ((paramObject instanceof String)) {
      this.jdField_a_of_type_Thz.h = ((String)paramObject);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Thz.jdField_f_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
    this.jdField_a_of_type_Thz.jdField_g_of_type_JavaLangString = paramString;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 28: 
      b();
      return;
    case 39: 
      b(paramObject);
      return;
    case 41: 
      a();
      return;
    }
    a(paramObject);
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    tlo.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onOpenVideo] ==== start ====");
    this.jdField_a_of_type_Boolean = false;
    if (!paramBoolean) {}
    for (long l = SystemClock.uptimeMillis();; l = 0L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Thz.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_Thz.jdField_a_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_Thz.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Thz.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Thz.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Thz.jdField_d_of_type_Int = 0;
      this.jdField_a_of_type_Thz.jdField_e_of_type_Long = 0L;
      this.jdField_a_of_type_Thz.jdField_d_of_type_Long = 0L;
      this.jdField_a_of_type_Thz.jdField_d_of_type_JavaLangString = "";
      this.jdField_a_of_type_Thz.jdField_f_of_type_JavaLangString = "";
      this.jdField_a_of_type_Thz.jdField_g_of_type_JavaLangString = "";
      this.jdField_a_of_type_Thz.jdField_c_of_type_JavaLangString = "";
      this.jdField_a_of_type_Thz.jdField_e_of_type_JavaLangString = "";
      this.jdField_a_of_type_Thz.h = "";
      this.jdField_a_of_type_Thz.jdField_b_of_type_Boolean = false;
      return;
    }
  }
  
  public void a(tho paramtho)
  {
    this.jdField_a_of_type_Thz.n = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
    ThreadManager.getSubThreadHandler().post(new WSPlayerReportImpl.1(this, paramtho));
  }
  
  public void a(tho paramtho, boolean paramBoolean)
  {
    this.jdField_a_of_type_Thz.jdField_c_of_type_JavaLangString = paramtho.a();
    this.jdField_a_of_type_Thz.jdField_a_of_type_Long = paramtho.c();
    this.jdField_a_of_type_Thz.jdField_b_of_type_Long = paramtho.d();
    this.jdField_a_of_type_Thz.jdField_d_of_type_Int = paramtho.c();
    this.jdField_a_of_type_Thz.jdField_c_of_type_Int = paramtho.d();
    this.jdField_a_of_type_Thz.jdField_c_of_type_Long = paramtho.e();
    this.jdField_a_of_type_Thz.jdField_d_of_type_JavaLangString = paramtho.c();
    this.jdField_a_of_type_Thz.jdField_f_of_type_Long = paramtho.f();
    this.jdField_a_of_type_Thz.jdField_d_of_type_Long = paramtho.h();
    this.jdField_a_of_type_Thz.jdField_e_of_type_Long = paramtho.g();
    this.jdField_a_of_type_Thz.jdField_g_of_type_Long = paramtho.i();
    this.jdField_a_of_type_Thz.i = paramtho.b();
    a(this.jdField_a_of_type_Thz);
  }
  
  public void a(boolean paramBoolean)
  {
    tlo.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onHitPreload] loaded:" + paramBoolean);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Thz.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(tho paramtho)
  {
    this.jdField_a_of_type_Thz.jdField_a_of_type_Int = paramtho.a();
    this.jdField_a_of_type_Thz.jdField_b_of_type_Int = paramtho.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tia
 * JD-Core Version:    0.7.0.1
 */