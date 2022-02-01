import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;

public class vhz
  implements vgc
{
  private uxe a;
  
  public vhz(uxe paramuxe)
  {
    this.a = paramuxe;
  }
  
  public void a(vgb paramvgb) {}
  
  public void a(vgb paramvgb, int paramInt) {}
  
  public void a(vgb paramvgb, int paramInt1, int paramInt2, String paramString)
  {
    paramString = new StringBuilder().append("[onVideoError] video: ");
    if ((paramvgb != null) && (paramvgb.jdField_a_of_type_Vhc != null)) {}
    for (paramvgb = paramvgb.jdField_a_of_type_Vgi.d;; paramvgb = "")
    {
      vmp.b("WSFollowPlayerStatusListenerImpl", paramvgb);
      return;
    }
  }
  
  public void a(vgb paramvgb, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onVideoStop] video: ");
    if ((paramvgb != null) && (paramvgb.jdField_a_of_type_Vhc != null)) {}
    for (String str = paramvgb.jdField_a_of_type_Vgi.d;; str = "")
    {
      vmp.b("WSFollowPlayerStatusListenerImpl", str);
      vka.a(paramvgb, paramBoolean);
      vkf.a(paramvgb, paramBoolean);
      return;
    }
  }
  
  public void b(vgb paramvgb)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onVideoStart] video: ");
    if ((paramvgb != null) && (paramvgb.jdField_a_of_type_Vgi != null)) {}
    for (String str = paramvgb.jdField_a_of_type_Vgi.d;; str = "")
    {
      vmp.b("WSFollowPlayerStatusListenerImpl", str);
      vka.a(paramvgb);
      if (this.a != null) {
        this.a.a();
      }
      return;
    }
  }
  
  public void c(vgb paramvgb)
  {
    if ((paramvgb == null) || (this.a == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[onCompletion] videoTitle: ");
    if (paramvgb.jdField_a_of_type_Vgi != null) {}
    for (Object localObject = paramvgb.jdField_a_of_type_Vgi.d;; localObject = "videoInfo is null!")
    {
      vmp.e("WSFollowPlayerStatusListenerImpl", (String)localObject);
      localObject = this.a.a();
      if ((localObject == null) || (!((WSPlayerManager)localObject).j())) {
        break;
      }
      vmp.e("WSFollowPlayerStatusListenerImpl", "[onCompletion] loopPlayMode: true");
      ((WSPlayerManager)localObject).b(paramvgb, false);
      return;
    }
  }
  
  public void d(vgb paramvgb)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onVideoPause] video: ");
    if ((paramvgb != null) && (paramvgb.jdField_a_of_type_Vhc != null)) {}
    for (paramvgb = paramvgb.jdField_a_of_type_Vgi.d;; paramvgb = "")
    {
      vmp.b("WSFollowPlayerStatusListenerImpl", paramvgb);
      return;
    }
  }
  
  public void e(vgb paramvgb)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onVideoRestart] video: ");
    if ((paramvgb != null) && (paramvgb.jdField_a_of_type_Vhc != null)) {}
    for (paramvgb = paramvgb.jdField_a_of_type_Vgi.d;; paramvgb = "")
    {
      vmp.b("WSFollowPlayerStatusListenerImpl", paramvgb);
      return;
    }
  }
  
  public void f(vgb paramvgb)
  {
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhz
 * JD-Core Version:    0.7.0.1
 */