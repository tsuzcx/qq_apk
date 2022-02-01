import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class usb
  implements ukp
{
  private uty jdField_a_of_type_Uty;
  private uuo jdField_a_of_type_Uuo;
  private uuq jdField_a_of_type_Uuq;
  private uuy jdField_a_of_type_Uuy;
  
  private WSPlayerManager a()
  {
    if ((this.jdField_a_of_type_Uuy != null) && (this.jdField_a_of_type_Uuy.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null)) {
      return this.jdField_a_of_type_Uuy.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
    }
    return null;
  }
  
  public void a(ukz paramukz) {}
  
  public void a(ukz paramukz, int paramInt1, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_Uuo != null)
    {
      this.jdField_a_of_type_Uuo.h();
      this.jdField_a_of_type_Uuo.a(paramString);
    }
  }
  
  public void a(ukz paramukz, int paramInt, boolean paramBoolean) {}
  
  public void a(ukz paramukz, long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Uuq != null) && (!this.jdField_a_of_type_Uuq.a()))
    {
      if (paramLong2 != 0L) {
        break label65;
      }
      this.jdField_a_of_type_Uuq.a(0.0F);
    }
    for (;;)
    {
      if ((paramLong1 > 2000L) && (this.jdField_a_of_type_Uty != null) && (!this.jdField_a_of_type_Uty.a())) {
        this.jdField_a_of_type_Uty.f();
      }
      return;
      label65:
      float f = (float)paramLong1 / (float)paramLong2;
      this.jdField_a_of_type_Uuq.a(f);
    }
  }
  
  public void a(ukz paramukz, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Uuq != null)
    {
      uqf.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoInitiate() show");
      this.jdField_a_of_type_Uuq.f();
      this.jdField_a_of_type_Uuq.a(0.0F);
    }
  }
  
  public void a(ukz paramukz, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_Uuo != null) && (paramBoolean1) && (paramBoolean2)) {
      this.jdField_a_of_type_Uuo.a(8, 400);
    }
  }
  
  public void a(uuy paramuuy)
  {
    this.jdField_a_of_type_Uuy = paramuuy;
    if (paramuuy == null) {}
    do
    {
      do
      {
        return;
        if ((paramuuy.jdField_a_of_type_Uek instanceof utq))
        {
          Object localObject = (utq)paramuuy.jdField_a_of_type_Uek;
          uej localuej = ((utq)localObject).a();
          if ((localuej instanceof uuo)) {
            this.jdField_a_of_type_Uuo = ((uuo)localuej);
          }
          localObject = ((utq)localObject).b();
          if ((localObject instanceof uuq)) {
            this.jdField_a_of_type_Uuq = ((uuq)localObject);
          }
        }
      } while (!(paramuuy.jdField_a_of_type_Uek instanceof uve));
      paramuuy = ((uve)paramuuy.jdField_a_of_type_Uek).c();
    } while (!(paramuuy instanceof uty));
    this.jdField_a_of_type_Uty = ((uty)paramuuy);
  }
  
  public boolean a(ukz paramukz)
  {
    return false;
  }
  
  public void b(ukz paramukz) {}
  
  public void c(ukz paramukz)
  {
    uqf.b("WS_VIDEO_VerticalUIDelegate", "WSVerticalPlayerUIDelegate onVideoViewLayoutSwitched()");
    if (this.jdField_a_of_type_Uuo != null) {
      this.jdField_a_of_type_Uuo.a(8, 200);
    }
  }
  
  public void d(ukz paramukz)
  {
    if (this.jdField_a_of_type_Uuo != null)
    {
      this.jdField_a_of_type_Uuo.a(8, 400);
      this.jdField_a_of_type_Uuo.c(8);
      this.jdField_a_of_type_Uuo.h();
      this.jdField_a_of_type_Uuo.i();
    }
    if (this.jdField_a_of_type_Uuq != null)
    {
      uqf.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoStart() hide");
      this.jdField_a_of_type_Uuq.g();
    }
  }
  
  public void e(ukz paramukz)
  {
    if (this.jdField_a_of_type_Uuo != null) {
      this.jdField_a_of_type_Uuo.c(0);
    }
  }
  
  public void f(ukz paramukz)
  {
    if (this.jdField_a_of_type_Uuo != null)
    {
      this.jdField_a_of_type_Uuo.c(8);
      this.jdField_a_of_type_Uuo.i();
    }
  }
  
  public void g(ukz paramukz)
  {
    if (this.jdField_a_of_type_Uuo != null)
    {
      this.jdField_a_of_type_Uuo.h();
      this.jdField_a_of_type_Uuo.a(0, 100);
      this.jdField_a_of_type_Uuo.c(8);
    }
    if (this.jdField_a_of_type_Uuq != null)
    {
      this.jdField_a_of_type_Uuq.g();
      this.jdField_a_of_type_Uuq.a(0.0F);
    }
  }
  
  public void h(ukz paramukz)
  {
    if (this.jdField_a_of_type_Uuo != null)
    {
      this.jdField_a_of_type_Uuo.g();
      paramukz = a();
      if ((paramukz != null) && (paramukz.b())) {
        this.jdField_a_of_type_Uuo.c(8);
      }
    }
  }
  
  public void i(ukz paramukz)
  {
    if (this.jdField_a_of_type_Uuq != null)
    {
      uqf.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoBufferEnd() hide");
      this.jdField_a_of_type_Uuq.g();
    }
    if (this.jdField_a_of_type_Uuo != null)
    {
      this.jdField_a_of_type_Uuo.h();
      paramukz = a();
      if ((paramukz != null) && (paramukz.b())) {
        this.jdField_a_of_type_Uuo.c(0);
      }
    }
  }
  
  public void j(ukz paramukz)
  {
    if (this.jdField_a_of_type_Uuo != null) {
      this.jdField_a_of_type_Uuo.a(0, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usb
 * JD-Core Version:    0.7.0.1
 */