import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ush
  implements usf
{
  private long jdField_a_of_type_Long;
  private usg jdField_a_of_type_Usg = new usg();
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    uya.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_CHANGE_HW_BACKUP_URL");
    this.jdField_a_of_type_Usg.jdField_c_of_type_Boolean = true;
  }
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramObject = ((String)paramObject).split(":", 2);
      if (paramObject.length == 2)
      {
        String str = paramObject[1];
        this.jdField_a_of_type_Usg.jdField_e_of_type_JavaLangString = str;
        uya.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] PERFORMANCE_REPORT method:" + paramObject[0] + ", timeJson:" + str);
      }
    }
  }
  
  private void a(usg paramusg)
  {
    uya.d("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onStop] mReportData:" + paramusg.toString());
    this.jdField_a_of_type_Boolean = true;
    usi.a(paramusg);
  }
  
  private void b()
  {
    uya.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_DECODER_BLOCK");
  }
  
  private void b(Object paramObject)
  {
    uya.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_HW_DECODE_FAILED");
    if ((paramObject instanceof String)) {
      this.jdField_a_of_type_Usg.jdField_h_of_type_JavaLangString = ((String)paramObject);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Usg.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Usg.jdField_f_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
    this.jdField_a_of_type_Usg.jdField_g_of_type_JavaLangString = paramString;
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
    uya.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onOpenVideo] ==== start ====");
    this.jdField_a_of_type_Boolean = false;
    if (!paramBoolean) {}
    for (long l = SystemClock.uptimeMillis();; l = 0L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Usg.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_Usg.jdField_a_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_Usg.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Usg.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Usg.jdField_d_of_type_Int = 0;
      this.jdField_a_of_type_Usg.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Usg.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Usg.jdField_f_of_type_Int = 0;
      this.jdField_a_of_type_Usg.jdField_e_of_type_Long = 0L;
      this.jdField_a_of_type_Usg.jdField_d_of_type_Long = 0L;
      this.jdField_a_of_type_Usg.jdField_d_of_type_JavaLangString = "";
      this.jdField_a_of_type_Usg.jdField_f_of_type_JavaLangString = "";
      this.jdField_a_of_type_Usg.jdField_g_of_type_JavaLangString = "";
      this.jdField_a_of_type_Usg.jdField_c_of_type_JavaLangString = "";
      this.jdField_a_of_type_Usg.jdField_e_of_type_JavaLangString = "";
      this.jdField_a_of_type_Usg.jdField_h_of_type_JavaLangString = "";
      this.jdField_a_of_type_Usg.jdField_c_of_type_Boolean = false;
      return;
    }
  }
  
  public void a(urw paramurw)
  {
    this.jdField_a_of_type_Usg.o = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
    ThreadManager.getSubThreadHandler().post(new WSPlayerReportImpl.1(this, paramurw));
  }
  
  public void a(urw paramurw, boolean paramBoolean)
  {
    usg localusg = this.jdField_a_of_type_Usg;
    if ((paramurw.a() instanceof usx)) {}
    for (int i = 1;; i = 0)
    {
      localusg.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Usg.jdField_b_of_type_Boolean = paramurw.g();
      this.jdField_a_of_type_Usg.jdField_c_of_type_JavaLangString = paramurw.a();
      this.jdField_a_of_type_Usg.jdField_a_of_type_Long = paramurw.c();
      this.jdField_a_of_type_Usg.jdField_b_of_type_Long = paramurw.d();
      this.jdField_a_of_type_Usg.jdField_f_of_type_Int = paramurw.c();
      this.jdField_a_of_type_Usg.jdField_e_of_type_Int = paramurw.d();
      this.jdField_a_of_type_Usg.jdField_c_of_type_Long = paramurw.e();
      this.jdField_a_of_type_Usg.jdField_d_of_type_JavaLangString = paramurw.c();
      this.jdField_a_of_type_Usg.jdField_f_of_type_Long = paramurw.g();
      this.jdField_a_of_type_Usg.jdField_d_of_type_Long = paramurw.i();
      this.jdField_a_of_type_Usg.jdField_e_of_type_Long = paramurw.h();
      this.jdField_a_of_type_Usg.jdField_g_of_type_Long = paramurw.j();
      this.jdField_a_of_type_Usg.i = paramurw.b();
      this.jdField_a_of_type_Usg.jdField_h_of_type_Long = paramurw.f();
      a(this.jdField_a_of_type_Usg);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    uya.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onHitPreload] loaded:" + paramBoolean);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Usg.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(urw paramurw)
  {
    int j = 0;
    usg localusg = this.jdField_a_of_type_Usg;
    if (paramurw != null) {}
    for (int i = paramurw.a();; i = 0)
    {
      localusg.jdField_b_of_type_Int = i;
      localusg = this.jdField_a_of_type_Usg;
      i = j;
      if (paramurw != null) {
        i = paramurw.b();
      }
      localusg.jdField_c_of_type_Int = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ush
 * JD-Core Version:    0.7.0.1
 */