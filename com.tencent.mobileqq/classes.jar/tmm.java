import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class tmm
  implements thf
{
  private tnc jdField_a_of_type_Tnc;
  private tne jdField_a_of_type_Tne;
  private tnk jdField_a_of_type_Tnk;
  
  private WSPlayerManager a()
  {
    if ((this.jdField_a_of_type_Tnk != null) && (this.jdField_a_of_type_Tnk.a() != null)) {
      return this.jdField_a_of_type_Tnk.a().a();
    }
    return null;
  }
  
  public void a(thl paramthl) {}
  
  public void a(thl paramthl, int paramInt1, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_Tnc != null)
    {
      this.jdField_a_of_type_Tnc.h();
      this.jdField_a_of_type_Tnc.a(paramString);
    }
  }
  
  public void a(thl paramthl, int paramInt, boolean paramBoolean) {}
  
  public void a(thl paramthl, long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Tne != null) && (!this.jdField_a_of_type_Tne.a()))
    {
      if (paramLong2 == 0L) {
        this.jdField_a_of_type_Tne.a(0.0F);
      }
    }
    else {
      return;
    }
    float f = (float)paramLong1 / (float)paramLong2;
    this.jdField_a_of_type_Tne.a(f);
  }
  
  public void a(thl paramthl, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Tne != null)
    {
      tlo.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoInitiate() show");
      this.jdField_a_of_type_Tne.f();
    }
  }
  
  public void a(thl paramthl, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_Tnc != null) && (paramBoolean1) && (paramBoolean2)) {
      this.jdField_a_of_type_Tnc.a(8, 400);
    }
  }
  
  public void a(tnk paramtnk)
  {
    this.jdField_a_of_type_Tnk = paramtnk;
    if (paramtnk != null)
    {
      this.jdField_a_of_type_Tnc = paramtnk.a();
      this.jdField_a_of_type_Tne = paramtnk.a();
    }
  }
  
  public boolean a(thl paramthl)
  {
    return false;
  }
  
  public void b(thl paramthl) {}
  
  public void c(thl paramthl)
  {
    tlo.b("WS_VIDEO_VerticalUIDelegate", "WSVerticalPlayerUIDelegate onVideoViewLayoutSwitched()");
    if (this.jdField_a_of_type_Tnc != null) {
      this.jdField_a_of_type_Tnc.a(8, 200);
    }
  }
  
  public void d(thl paramthl)
  {
    if (this.jdField_a_of_type_Tnc != null)
    {
      this.jdField_a_of_type_Tnc.a(8, 400);
      this.jdField_a_of_type_Tnc.b(8);
      this.jdField_a_of_type_Tnc.h();
      this.jdField_a_of_type_Tnc.i();
    }
    if (this.jdField_a_of_type_Tne != null)
    {
      tlo.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoStart() hide");
      this.jdField_a_of_type_Tne.g();
    }
  }
  
  public void e(thl paramthl)
  {
    if (this.jdField_a_of_type_Tnc != null) {
      this.jdField_a_of_type_Tnc.b(0);
    }
  }
  
  public void f(thl paramthl)
  {
    if (this.jdField_a_of_type_Tnc != null)
    {
      this.jdField_a_of_type_Tnc.b(8);
      this.jdField_a_of_type_Tnc.i();
    }
  }
  
  public void g(thl paramthl)
  {
    if (this.jdField_a_of_type_Tnc != null)
    {
      this.jdField_a_of_type_Tnc.h();
      this.jdField_a_of_type_Tnc.a(0, 100);
      this.jdField_a_of_type_Tnc.b(8);
    }
    if (this.jdField_a_of_type_Tne != null) {
      this.jdField_a_of_type_Tne.g();
    }
  }
  
  public void h(thl paramthl)
  {
    if (this.jdField_a_of_type_Tnc != null)
    {
      this.jdField_a_of_type_Tnc.g();
      paramthl = a();
      if ((paramthl != null) && (paramthl.b())) {
        this.jdField_a_of_type_Tnc.b(8);
      }
    }
  }
  
  public void i(thl paramthl)
  {
    if (this.jdField_a_of_type_Tne != null)
    {
      tlo.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoBufferEnd() hide");
      this.jdField_a_of_type_Tne.g();
    }
    if (this.jdField_a_of_type_Tnc != null)
    {
      this.jdField_a_of_type_Tnc.h();
      paramthl = a();
      if ((paramthl != null) && (paramthl.b())) {
        this.jdField_a_of_type_Tnc.b(0);
      }
    }
  }
  
  public void j(thl paramthl)
  {
    if (this.jdField_a_of_type_Tnc != null) {
      this.jdField_a_of_type_Tnc.a(0, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tmm
 * JD-Core Version:    0.7.0.1
 */