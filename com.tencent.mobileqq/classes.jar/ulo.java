import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ulo
  implements ulm
{
  private long jdField_a_of_type_Long;
  private uln jdField_a_of_type_Uln = new uln();
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    uqf.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_CHANGE_HW_BACKUP_URL");
    this.jdField_a_of_type_Uln.jdField_c_of_type_Boolean = true;
  }
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramObject = ((String)paramObject).split(":", 2);
      if (paramObject.length == 2)
      {
        String str = paramObject[1];
        this.jdField_a_of_type_Uln.jdField_e_of_type_JavaLangString = str;
        uqf.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] PERFORMANCE_REPORT method:" + paramObject[0] + ", timeJson:" + str);
      }
    }
  }
  
  private void a(uln paramuln)
  {
    uqf.d("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onStop] mReportData:" + paramuln.toString());
    this.jdField_a_of_type_Boolean = true;
    ulp.a(paramuln);
  }
  
  private void b()
  {
    uqf.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_DECODER_BLOCK");
  }
  
  private void b(Object paramObject)
  {
    uqf.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_HW_DECODE_FAILED");
    if ((paramObject instanceof String)) {
      this.jdField_a_of_type_Uln.h = ((String)paramObject);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Uln.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Uln.jdField_f_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
    this.jdField_a_of_type_Uln.jdField_g_of_type_JavaLangString = paramString;
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
    uqf.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onOpenVideo] ==== start ====");
    this.jdField_a_of_type_Boolean = false;
    if (!paramBoolean) {}
    for (long l = SystemClock.uptimeMillis();; l = 0L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Uln.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_Uln.jdField_a_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_Uln.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Uln.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Uln.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Uln.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Uln.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Uln.jdField_e_of_type_Int = 0;
      this.jdField_a_of_type_Uln.jdField_e_of_type_Long = 0L;
      this.jdField_a_of_type_Uln.jdField_d_of_type_Long = 0L;
      this.jdField_a_of_type_Uln.jdField_d_of_type_JavaLangString = "";
      this.jdField_a_of_type_Uln.jdField_f_of_type_JavaLangString = "";
      this.jdField_a_of_type_Uln.jdField_g_of_type_JavaLangString = "";
      this.jdField_a_of_type_Uln.jdField_c_of_type_JavaLangString = "";
      this.jdField_a_of_type_Uln.jdField_e_of_type_JavaLangString = "";
      this.jdField_a_of_type_Uln.h = "";
      this.jdField_a_of_type_Uln.jdField_c_of_type_Boolean = false;
      return;
    }
  }
  
  public void a(ulc paramulc)
  {
    this.jdField_a_of_type_Uln.n = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
    ThreadManager.getSubThreadHandler().post(new WSPlayerReportImpl.1(this, paramulc));
  }
  
  public void a(ulc paramulc, boolean paramBoolean)
  {
    this.jdField_a_of_type_Uln.jdField_b_of_type_Boolean = paramulc.f();
    this.jdField_a_of_type_Uln.jdField_c_of_type_JavaLangString = paramulc.a();
    this.jdField_a_of_type_Uln.jdField_a_of_type_Long = paramulc.c();
    this.jdField_a_of_type_Uln.jdField_b_of_type_Long = paramulc.d();
    this.jdField_a_of_type_Uln.jdField_e_of_type_Int = paramulc.c();
    this.jdField_a_of_type_Uln.jdField_d_of_type_Int = paramulc.d();
    this.jdField_a_of_type_Uln.jdField_c_of_type_Long = paramulc.e();
    this.jdField_a_of_type_Uln.jdField_d_of_type_JavaLangString = paramulc.c();
    this.jdField_a_of_type_Uln.jdField_f_of_type_Long = paramulc.f();
    this.jdField_a_of_type_Uln.jdField_d_of_type_Long = paramulc.h();
    this.jdField_a_of_type_Uln.jdField_e_of_type_Long = paramulc.g();
    this.jdField_a_of_type_Uln.jdField_g_of_type_Long = paramulc.i();
    this.jdField_a_of_type_Uln.i = paramulc.b();
    a(this.jdField_a_of_type_Uln);
  }
  
  public void a(boolean paramBoolean)
  {
    uqf.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onHitPreload] loaded:" + paramBoolean);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Uln.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(ulc paramulc)
  {
    int j = 0;
    uln localuln = this.jdField_a_of_type_Uln;
    if (paramulc != null) {}
    for (int i = paramulc.a();; i = 0)
    {
      localuln.jdField_a_of_type_Int = i;
      localuln = this.jdField_a_of_type_Uln;
      i = j;
      if (paramulc != null) {
        i = paramulc.b();
      }
      localuln.jdField_b_of_type_Int = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulo
 * JD-Core Version:    0.7.0.1
 */