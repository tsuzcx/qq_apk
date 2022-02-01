import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class ura
  implements ujv
{
  private usx jdField_a_of_type_Usx;
  private utm jdField_a_of_type_Utm;
  private uto jdField_a_of_type_Uto;
  private utw jdField_a_of_type_Utw;
  
  private WSPlayerManager a()
  {
    if ((this.jdField_a_of_type_Utw != null) && (this.jdField_a_of_type_Utw.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null)) {
      return this.jdField_a_of_type_Utw.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
    }
    return null;
  }
  
  public void a(ukb paramukb) {}
  
  public void a(ukb paramukb, int paramInt1, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_Utm != null)
    {
      this.jdField_a_of_type_Utm.h();
      this.jdField_a_of_type_Utm.a(paramString);
    }
  }
  
  public void a(ukb paramukb, int paramInt, boolean paramBoolean) {}
  
  public void a(ukb paramukb, long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Uto != null) && (!this.jdField_a_of_type_Uto.a()))
    {
      if (paramLong2 != 0L) {
        break label65;
      }
      this.jdField_a_of_type_Uto.a(0.0F);
    }
    for (;;)
    {
      if ((paramLong1 > 2000L) && (this.jdField_a_of_type_Usx != null) && (!this.jdField_a_of_type_Usx.a())) {
        this.jdField_a_of_type_Usx.f();
      }
      return;
      label65:
      float f = (float)paramLong1 / (float)paramLong2;
      this.jdField_a_of_type_Uto.a(f);
    }
  }
  
  public void a(ukb paramukb, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Uto != null)
    {
      upe.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoInitiate() show");
      this.jdField_a_of_type_Uto.f();
      this.jdField_a_of_type_Uto.a(0.0F);
    }
  }
  
  public void a(ukb paramukb, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_Utm != null) && (paramBoolean1) && (paramBoolean2)) {
      this.jdField_a_of_type_Utm.a(8, 400);
    }
  }
  
  public void a(utw paramutw)
  {
    this.jdField_a_of_type_Utw = paramutw;
    if (paramutw == null) {}
    do
    {
      do
      {
        return;
        if ((paramutw.jdField_a_of_type_Uei instanceof usp))
        {
          Object localObject = (usp)paramutw.jdField_a_of_type_Uei;
          ueh localueh = ((usp)localObject).a();
          if ((localueh instanceof utm)) {
            this.jdField_a_of_type_Utm = ((utm)localueh);
          }
          localObject = ((usp)localObject).b();
          if ((localObject instanceof uto)) {
            this.jdField_a_of_type_Uto = ((uto)localObject);
          }
        }
      } while (!(paramutw.jdField_a_of_type_Uei instanceof uuc));
      paramutw = ((uuc)paramutw.jdField_a_of_type_Uei).c();
    } while (!(paramutw instanceof usx));
    this.jdField_a_of_type_Usx = ((usx)paramutw);
  }
  
  public boolean a(ukb paramukb)
  {
    return false;
  }
  
  public void b(ukb paramukb) {}
  
  public void c(ukb paramukb)
  {
    upe.b("WS_VIDEO_VerticalUIDelegate", "WSVerticalPlayerUIDelegate onVideoViewLayoutSwitched()");
    if (this.jdField_a_of_type_Utm != null) {
      this.jdField_a_of_type_Utm.a(8, 200);
    }
  }
  
  public void d(ukb paramukb)
  {
    if (this.jdField_a_of_type_Utm != null)
    {
      this.jdField_a_of_type_Utm.a(8, 400);
      this.jdField_a_of_type_Utm.b(8);
      this.jdField_a_of_type_Utm.h();
      this.jdField_a_of_type_Utm.i();
    }
    if (this.jdField_a_of_type_Uto != null)
    {
      upe.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoStart() hide");
      this.jdField_a_of_type_Uto.g();
    }
  }
  
  public void e(ukb paramukb)
  {
    if (this.jdField_a_of_type_Utm != null) {
      this.jdField_a_of_type_Utm.b(0);
    }
  }
  
  public void f(ukb paramukb)
  {
    if (this.jdField_a_of_type_Utm != null)
    {
      this.jdField_a_of_type_Utm.b(8);
      this.jdField_a_of_type_Utm.i();
    }
  }
  
  public void g(ukb paramukb)
  {
    if (this.jdField_a_of_type_Utm != null)
    {
      this.jdField_a_of_type_Utm.h();
      this.jdField_a_of_type_Utm.a(0, 100);
      this.jdField_a_of_type_Utm.b(8);
    }
    if (this.jdField_a_of_type_Uto != null)
    {
      this.jdField_a_of_type_Uto.g();
      this.jdField_a_of_type_Uto.a(0.0F);
    }
  }
  
  public void h(ukb paramukb)
  {
    if (this.jdField_a_of_type_Utm != null)
    {
      this.jdField_a_of_type_Utm.g();
      paramukb = a();
      if ((paramukb != null) && (paramukb.b())) {
        this.jdField_a_of_type_Utm.b(8);
      }
    }
  }
  
  public void i(ukb paramukb)
  {
    if (this.jdField_a_of_type_Uto != null)
    {
      upe.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoBufferEnd() hide");
      this.jdField_a_of_type_Uto.g();
    }
    if (this.jdField_a_of_type_Utm != null)
    {
      this.jdField_a_of_type_Utm.h();
      paramukb = a();
      if ((paramukb != null) && (paramukb.b())) {
        this.jdField_a_of_type_Utm.b(0);
      }
    }
  }
  
  public void j(ukb paramukb)
  {
    if (this.jdField_a_of_type_Utm != null) {
      this.jdField_a_of_type_Utm.a(0, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ura
 * JD-Core Version:    0.7.0.1
 */