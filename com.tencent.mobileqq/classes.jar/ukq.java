import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ukq
  implements uko
{
  private long jdField_a_of_type_Long;
  private ukp jdField_a_of_type_Ukp = new ukp();
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    upe.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_CHANGE_HW_BACKUP_URL");
    this.jdField_a_of_type_Ukp.jdField_c_of_type_Boolean = true;
  }
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramObject = ((String)paramObject).split(":", 2);
      if (paramObject.length == 2)
      {
        String str = paramObject[1];
        this.jdField_a_of_type_Ukp.jdField_e_of_type_JavaLangString = str;
        upe.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] PERFORMANCE_REPORT method:" + paramObject[0] + ", timeJson:" + str);
      }
    }
  }
  
  private void a(ukp paramukp)
  {
    upe.d("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onStop] mReportData:" + paramukp.toString());
    this.jdField_a_of_type_Boolean = true;
    ukr.a(paramukp);
  }
  
  private void b()
  {
    upe.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_DECODER_BLOCK");
  }
  
  private void b(Object paramObject)
  {
    upe.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_HW_DECODE_FAILED");
    if ((paramObject instanceof String)) {
      this.jdField_a_of_type_Ukp.h = ((String)paramObject);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Ukp.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Ukp.jdField_f_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
    this.jdField_a_of_type_Ukp.jdField_g_of_type_JavaLangString = paramString;
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
    upe.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onOpenVideo] ==== start ====");
    this.jdField_a_of_type_Boolean = false;
    if (!paramBoolean) {}
    for (long l = SystemClock.uptimeMillis();; l = 0L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Ukp.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_Ukp.jdField_a_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_Ukp.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Ukp.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Ukp.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Ukp.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Ukp.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Ukp.jdField_e_of_type_Int = 0;
      this.jdField_a_of_type_Ukp.jdField_e_of_type_Long = 0L;
      this.jdField_a_of_type_Ukp.jdField_d_of_type_Long = 0L;
      this.jdField_a_of_type_Ukp.jdField_d_of_type_JavaLangString = "";
      this.jdField_a_of_type_Ukp.jdField_f_of_type_JavaLangString = "";
      this.jdField_a_of_type_Ukp.jdField_g_of_type_JavaLangString = "";
      this.jdField_a_of_type_Ukp.jdField_c_of_type_JavaLangString = "";
      this.jdField_a_of_type_Ukp.jdField_e_of_type_JavaLangString = "";
      this.jdField_a_of_type_Ukp.h = "";
      this.jdField_a_of_type_Ukp.jdField_c_of_type_Boolean = false;
      return;
    }
  }
  
  public void a(uke paramuke)
  {
    this.jdField_a_of_type_Ukp.n = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
    ThreadManager.getSubThreadHandler().post(new WSPlayerReportImpl.1(this, paramuke));
  }
  
  public void a(uke paramuke, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ukp.jdField_b_of_type_Boolean = paramuke.f();
    this.jdField_a_of_type_Ukp.jdField_c_of_type_JavaLangString = paramuke.a();
    this.jdField_a_of_type_Ukp.jdField_a_of_type_Long = paramuke.c();
    this.jdField_a_of_type_Ukp.jdField_b_of_type_Long = paramuke.d();
    this.jdField_a_of_type_Ukp.jdField_e_of_type_Int = paramuke.c();
    this.jdField_a_of_type_Ukp.jdField_d_of_type_Int = paramuke.d();
    this.jdField_a_of_type_Ukp.jdField_c_of_type_Long = paramuke.e();
    this.jdField_a_of_type_Ukp.jdField_d_of_type_JavaLangString = paramuke.c();
    this.jdField_a_of_type_Ukp.jdField_f_of_type_Long = paramuke.f();
    this.jdField_a_of_type_Ukp.jdField_d_of_type_Long = paramuke.h();
    this.jdField_a_of_type_Ukp.jdField_e_of_type_Long = paramuke.g();
    this.jdField_a_of_type_Ukp.jdField_g_of_type_Long = paramuke.i();
    this.jdField_a_of_type_Ukp.i = paramuke.b();
    a(this.jdField_a_of_type_Ukp);
  }
  
  public void a(boolean paramBoolean)
  {
    upe.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onHitPreload] loaded:" + paramBoolean);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Ukp.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(uke paramuke)
  {
    this.jdField_a_of_type_Ukp.jdField_a_of_type_Int = paramuke.a();
    this.jdField_a_of_type_Ukp.jdField_b_of_type_Int = paramuke.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukq
 * JD-Core Version:    0.7.0.1
 */