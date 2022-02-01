import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class uzw
  implements urk
{
  private vbt jdField_a_of_type_Vbt;
  private vcj jdField_a_of_type_Vcj;
  private vcl jdField_a_of_type_Vcl;
  private vct jdField_a_of_type_Vct;
  
  private WSPlayerManager a()
  {
    if ((this.jdField_a_of_type_Vct != null) && (this.jdField_a_of_type_Vct.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null)) {
      return this.jdField_a_of_type_Vct.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
    }
    return null;
  }
  
  public void a(urt paramurt) {}
  
  public void a(urt paramurt, int paramInt1, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_Vcj != null)
    {
      this.jdField_a_of_type_Vcj.h();
      this.jdField_a_of_type_Vcj.a(paramString);
    }
  }
  
  public void a(urt paramurt, int paramInt, boolean paramBoolean) {}
  
  public void a(urt paramurt, long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Vcl != null) && (!this.jdField_a_of_type_Vcl.a()))
    {
      if (paramLong2 != 0L) {
        break label65;
      }
      this.jdField_a_of_type_Vcl.a(0.0F);
    }
    for (;;)
    {
      if ((paramLong1 > 2000L) && (this.jdField_a_of_type_Vbt != null) && (!this.jdField_a_of_type_Vbt.a())) {
        this.jdField_a_of_type_Vbt.f();
      }
      return;
      label65:
      float f = (float)paramLong1 / (float)paramLong2;
      this.jdField_a_of_type_Vcl.a(f);
    }
  }
  
  public void a(urt paramurt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vcl != null)
    {
      uya.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoInitiate() show");
      this.jdField_a_of_type_Vcl.f();
      this.jdField_a_of_type_Vcl.a(0.0F);
    }
  }
  
  public void a(urt paramurt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_Vcj != null) && (paramBoolean1) && (paramBoolean2)) {
      this.jdField_a_of_type_Vcj.a(8, 400);
    }
  }
  
  public void a(vct paramvct)
  {
    this.jdField_a_of_type_Vct = paramvct;
    if (paramvct == null) {}
    do
    {
      do
      {
        return;
        if ((paramvct.jdField_a_of_type_Ula instanceof vbl))
        {
          Object localObject = (vbl)paramvct.jdField_a_of_type_Ula;
          ukz localukz = ((vbl)localObject).a();
          if ((localukz instanceof vcj)) {
            this.jdField_a_of_type_Vcj = ((vcj)localukz);
          }
          localObject = ((vbl)localObject).b();
          if ((localObject instanceof vcl)) {
            this.jdField_a_of_type_Vcl = ((vcl)localObject);
          }
        }
      } while (!(paramvct.jdField_a_of_type_Ula instanceof vcz));
      paramvct = ((vcz)paramvct.jdField_a_of_type_Ula).c();
    } while (!(paramvct instanceof vbt));
    this.jdField_a_of_type_Vbt = ((vbt)paramvct);
  }
  
  public boolean a(urt paramurt)
  {
    return false;
  }
  
  public void b(urt paramurt) {}
  
  public void c(urt paramurt)
  {
    uya.b("WS_VIDEO_VerticalUIDelegate", "WSVerticalPlayerUIDelegate onVideoViewLayoutSwitched()");
    if (this.jdField_a_of_type_Vcj != null) {
      this.jdField_a_of_type_Vcj.a(8, 200);
    }
  }
  
  public void d(urt paramurt)
  {
    if (this.jdField_a_of_type_Vcj != null)
    {
      this.jdField_a_of_type_Vcj.a(8, 400);
      this.jdField_a_of_type_Vcj.c(8);
      this.jdField_a_of_type_Vcj.h();
      this.jdField_a_of_type_Vcj.i();
    }
    if (this.jdField_a_of_type_Vcl != null)
    {
      uya.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoStart() hide");
      this.jdField_a_of_type_Vcl.g();
    }
  }
  
  public void e(urt paramurt)
  {
    if (this.jdField_a_of_type_Vcj != null) {
      this.jdField_a_of_type_Vcj.c(0);
    }
  }
  
  public void f(urt paramurt)
  {
    if (this.jdField_a_of_type_Vcj != null)
    {
      this.jdField_a_of_type_Vcj.c(8);
      this.jdField_a_of_type_Vcj.i();
    }
  }
  
  public void g(urt paramurt)
  {
    if (this.jdField_a_of_type_Vcj != null)
    {
      this.jdField_a_of_type_Vcj.h();
      this.jdField_a_of_type_Vcj.a(0, 100);
      this.jdField_a_of_type_Vcj.c(8);
    }
    if (this.jdField_a_of_type_Vcl != null)
    {
      this.jdField_a_of_type_Vcl.g();
      this.jdField_a_of_type_Vcl.a(0.0F);
    }
  }
  
  public void h(urt paramurt)
  {
    if (this.jdField_a_of_type_Vcj != null)
    {
      this.jdField_a_of_type_Vcj.g();
      paramurt = a();
      if ((paramurt != null) && (paramurt.b())) {
        this.jdField_a_of_type_Vcj.c(8);
      }
    }
  }
  
  public void i(urt paramurt)
  {
    if (this.jdField_a_of_type_Vcl != null)
    {
      uya.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoBufferEnd() hide");
      this.jdField_a_of_type_Vcl.g();
    }
    if (this.jdField_a_of_type_Vcj != null)
    {
      this.jdField_a_of_type_Vcj.h();
      paramurt = a();
      if ((paramurt != null) && (paramurt.b())) {
        this.jdField_a_of_type_Vcj.c(0);
      }
    }
  }
  
  public void j(urt paramurt)
  {
    if (this.jdField_a_of_type_Vcj != null) {
      this.jdField_a_of_type_Vcj.a(0, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzw
 * JD-Core Version:    0.7.0.1
 */