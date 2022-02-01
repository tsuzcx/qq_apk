import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class voo
  implements vfs
{
  private vqn jdField_a_of_type_Vqn;
  private vrd jdField_a_of_type_Vrd;
  private vrf jdField_a_of_type_Vrf;
  private vrn jdField_a_of_type_Vrn;
  
  private WSPlayerManager a()
  {
    if ((this.jdField_a_of_type_Vrn != null) && (this.jdField_a_of_type_Vrn.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null)) {
      return this.jdField_a_of_type_Vrn.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
    }
    return null;
  }
  
  public void a(vgb paramvgb) {}
  
  public void a(vgb paramvgb, int paramInt1, int paramInt2, String paramString)
  {
    if (this.jdField_a_of_type_Vrd != null)
    {
      this.jdField_a_of_type_Vrd.h();
      this.jdField_a_of_type_Vrd.a(paramString);
    }
  }
  
  public void a(vgb paramvgb, int paramInt, boolean paramBoolean) {}
  
  public void a(vgb paramvgb, long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Vrf != null) && (!this.jdField_a_of_type_Vrf.a()))
    {
      if (paramLong2 != 0L) {
        break label65;
      }
      this.jdField_a_of_type_Vrf.a(0.0F);
    }
    for (;;)
    {
      if ((paramLong1 > 2000L) && (this.jdField_a_of_type_Vqn != null) && (!this.jdField_a_of_type_Vqn.a())) {
        this.jdField_a_of_type_Vqn.f();
      }
      return;
      label65:
      float f = (float)paramLong1 / (float)paramLong2;
      this.jdField_a_of_type_Vrf.a(f);
    }
  }
  
  public void a(vgb paramvgb, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Vrf != null)
    {
      vmp.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoInitiate() show");
      this.jdField_a_of_type_Vrf.f();
      this.jdField_a_of_type_Vrf.a(0.0F);
    }
  }
  
  public void a(vgb paramvgb, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_Vrd != null) && (paramBoolean1) && (paramBoolean2)) {
      this.jdField_a_of_type_Vrd.a(8, 400);
    }
  }
  
  public void a(vrn paramvrn)
  {
    this.jdField_a_of_type_Vrn = paramvrn;
    if (paramvrn == null) {}
    do
    {
      do
      {
        return;
        if ((paramvrn.jdField_a_of_type_Uyx instanceof vqe))
        {
          Object localObject = (vqe)paramvrn.jdField_a_of_type_Uyx;
          uyw localuyw = ((vqe)localObject).a();
          if ((localuyw instanceof vrd)) {
            this.jdField_a_of_type_Vrd = ((vrd)localuyw);
          }
          localObject = ((vqe)localObject).b();
          if ((localObject instanceof vrf)) {
            this.jdField_a_of_type_Vrf = ((vrf)localObject);
          }
        }
      } while (!(paramvrn.jdField_a_of_type_Uyx instanceof vru));
      paramvrn = ((vru)paramvrn.jdField_a_of_type_Uyx).c();
    } while (!(paramvrn instanceof vqn));
    this.jdField_a_of_type_Vqn = ((vqn)paramvrn);
  }
  
  public boolean a(vgb paramvgb)
  {
    return false;
  }
  
  public void b(vgb paramvgb) {}
  
  public void c(vgb paramvgb)
  {
    vmp.b("WS_VIDEO_VerticalUIDelegate", "WSVerticalPlayerUIDelegate onVideoViewLayoutSwitched()");
    if (this.jdField_a_of_type_Vrd != null) {
      this.jdField_a_of_type_Vrd.a(8, 200);
    }
  }
  
  public void d(vgb paramvgb)
  {
    if (this.jdField_a_of_type_Vrd != null)
    {
      this.jdField_a_of_type_Vrd.a(8, 400);
      this.jdField_a_of_type_Vrd.c(8);
      this.jdField_a_of_type_Vrd.h();
      this.jdField_a_of_type_Vrd.i();
    }
    if (this.jdField_a_of_type_Vrf != null)
    {
      vmp.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoStart() hide");
      this.jdField_a_of_type_Vrf.g();
    }
  }
  
  public void e(vgb paramvgb)
  {
    if (this.jdField_a_of_type_Vrd != null) {
      this.jdField_a_of_type_Vrd.c(0);
    }
  }
  
  public void f(vgb paramvgb)
  {
    if (this.jdField_a_of_type_Vrd != null)
    {
      this.jdField_a_of_type_Vrd.c(8);
      this.jdField_a_of_type_Vrd.i();
    }
  }
  
  public void g(vgb paramvgb)
  {
    if (this.jdField_a_of_type_Vrd != null)
    {
      this.jdField_a_of_type_Vrd.h();
      this.jdField_a_of_type_Vrd.a(0, 100);
      this.jdField_a_of_type_Vrd.c(8);
    }
    if (this.jdField_a_of_type_Vrf != null)
    {
      this.jdField_a_of_type_Vrf.g();
      this.jdField_a_of_type_Vrf.a(0.0F);
    }
  }
  
  public void h(vgb paramvgb)
  {
    if (this.jdField_a_of_type_Vrd != null)
    {
      this.jdField_a_of_type_Vrd.g();
      paramvgb = a();
      if ((paramvgb != null) && (paramvgb.b())) {
        this.jdField_a_of_type_Vrd.c(8);
      }
    }
  }
  
  public void i(vgb paramvgb)
  {
    if (this.jdField_a_of_type_Vrf != null)
    {
      vmp.b("WS_VIDEO_ProgressBar", "WSVerticalPlayerUIDelegate onVideoBufferEnd() hide");
      this.jdField_a_of_type_Vrf.g();
    }
    if (this.jdField_a_of_type_Vrd != null)
    {
      this.jdField_a_of_type_Vrd.h();
      paramvgb = a();
      if ((paramvgb != null) && (paramvgb.b())) {
        this.jdField_a_of_type_Vrd.c(0);
      }
    }
  }
  
  public void j(vgb paramvgb)
  {
    if (this.jdField_a_of_type_Vrd != null) {
      this.jdField_a_of_type_Vrd.a(0, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     voo
 * JD-Core Version:    0.7.0.1
 */