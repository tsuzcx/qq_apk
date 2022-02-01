import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi_new.player.report.WSPlayerReportImpl.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class vgs
  implements vgq
{
  private long jdField_a_of_type_Long;
  private vgr jdField_a_of_type_Vgr = new vgr();
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    vmp.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_CHANGE_HW_BACKUP_URL");
    this.jdField_a_of_type_Vgr.jdField_c_of_type_Boolean = true;
  }
  
  private void a(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      paramObject = ((String)paramObject).split(":", 2);
      if (paramObject.length == 2)
      {
        String str = paramObject[1];
        this.jdField_a_of_type_Vgr.jdField_e_of_type_JavaLangString = str;
        vmp.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] PERFORMANCE_REPORT method:" + paramObject[0] + ", timeJson:" + str);
      }
    }
  }
  
  private void a(vgr paramvgr)
  {
    vmp.d("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onStop] mReportData:" + paramvgr.toString());
    this.jdField_a_of_type_Boolean = true;
    vgt.a(paramvgr);
  }
  
  private void b()
  {
    vmp.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_DECODER_BLOCK");
  }
  
  private void b(Object paramObject)
  {
    vmp.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] 播放状态回调 PLAYER_INFO_HW_DECODE_FAILED");
    if ((paramObject instanceof String)) {
      this.jdField_a_of_type_Vgr.jdField_h_of_type_JavaLangString = ((String)paramObject);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Vgr.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_Vgr.jdField_f_of_type_JavaLangString = (paramInt1 + ":" + paramInt2);
    this.jdField_a_of_type_Vgr.jdField_g_of_type_JavaLangString = paramString;
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
    vmp.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onOpenVideo] ==== start ====");
    this.jdField_a_of_type_Boolean = false;
    if (!paramBoolean) {}
    for (long l = SystemClock.uptimeMillis();; l = 0L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Vgr.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_Vgr.jdField_a_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_Vgr.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Vgr.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Vgr.jdField_d_of_type_Int = 0;
      this.jdField_a_of_type_Vgr.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Vgr.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Vgr.jdField_f_of_type_Int = 0;
      this.jdField_a_of_type_Vgr.jdField_e_of_type_Long = 0L;
      this.jdField_a_of_type_Vgr.jdField_d_of_type_Long = 0L;
      this.jdField_a_of_type_Vgr.jdField_d_of_type_JavaLangString = "";
      this.jdField_a_of_type_Vgr.jdField_f_of_type_JavaLangString = "";
      this.jdField_a_of_type_Vgr.jdField_g_of_type_JavaLangString = "";
      this.jdField_a_of_type_Vgr.jdField_c_of_type_JavaLangString = "";
      this.jdField_a_of_type_Vgr.jdField_e_of_type_JavaLangString = "";
      this.jdField_a_of_type_Vgr.jdField_h_of_type_JavaLangString = "";
      this.jdField_a_of_type_Vgr.jdField_c_of_type_Boolean = false;
      return;
    }
  }
  
  public void a(vgh paramvgh)
  {
    this.jdField_a_of_type_Vgr.o = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
    ThreadManager.getSubThreadHandler().post(new WSPlayerReportImpl.1(this, paramvgh));
  }
  
  public void a(vgh paramvgh, boolean paramBoolean)
  {
    vgr localvgr = this.jdField_a_of_type_Vgr;
    if ((paramvgh.a() instanceof vhi)) {}
    for (int i = 1;; i = 0)
    {
      localvgr.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Vgr.jdField_b_of_type_Boolean = paramvgh.g();
      this.jdField_a_of_type_Vgr.jdField_c_of_type_JavaLangString = paramvgh.a();
      this.jdField_a_of_type_Vgr.jdField_a_of_type_Long = paramvgh.c();
      this.jdField_a_of_type_Vgr.jdField_b_of_type_Long = paramvgh.d();
      this.jdField_a_of_type_Vgr.jdField_f_of_type_Int = paramvgh.c();
      this.jdField_a_of_type_Vgr.jdField_e_of_type_Int = paramvgh.d();
      this.jdField_a_of_type_Vgr.jdField_c_of_type_Long = paramvgh.e();
      this.jdField_a_of_type_Vgr.jdField_d_of_type_JavaLangString = paramvgh.c();
      this.jdField_a_of_type_Vgr.jdField_f_of_type_Long = paramvgh.g();
      this.jdField_a_of_type_Vgr.jdField_d_of_type_Long = paramvgh.i();
      this.jdField_a_of_type_Vgr.jdField_e_of_type_Long = paramvgh.h();
      this.jdField_a_of_type_Vgr.jdField_g_of_type_Long = paramvgh.j();
      this.jdField_a_of_type_Vgr.i = paramvgh.b();
      this.jdField_a_of_type_Vgr.jdField_h_of_type_Long = paramvgh.f();
      a(this.jdField_a_of_type_Vgr);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    vmp.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onHitPreload] loaded:" + paramBoolean);
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Vgr.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(vgh paramvgh)
  {
    int j = 0;
    vgr localvgr = this.jdField_a_of_type_Vgr;
    if (paramvgh != null) {}
    for (int i = paramvgh.a();; i = 0)
    {
      localvgr.jdField_b_of_type_Int = i;
      localvgr = this.jdField_a_of_type_Vgr;
      i = j;
      if (paramvgh != null) {
        i = paramvgh.b();
      }
      localvgr.jdField_c_of_type_Int = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vgs
 * JD-Core Version:    0.7.0.1
 */