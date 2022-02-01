import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;

public class uto
  implements uru
{
  private ujh a;
  
  public uto(ujh paramujh)
  {
    this.a = paramujh;
  }
  
  public void a(urt paramurt) {}
  
  public void a(urt paramurt, int paramInt) {}
  
  public void a(urt paramurt, int paramInt1, int paramInt2, String paramString)
  {
    paramString = new StringBuilder().append("[onVideoError] video: ");
    if ((paramurt != null) && (paramurt.jdField_a_of_type_Usr != null)) {}
    for (paramurt = paramurt.jdField_a_of_type_Urx.d;; paramurt = "")
    {
      uya.b("WSFollowPlayerStatusListenerImpl", paramurt);
      return;
    }
  }
  
  public void a(urt paramurt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onVideoStop] video: ");
    if ((paramurt != null) && (paramurt.jdField_a_of_type_Usr != null)) {}
    for (String str = paramurt.jdField_a_of_type_Urx.d;; str = "")
    {
      uya.b("WSFollowPlayerStatusListenerImpl", str);
      uvm.a(paramurt, paramBoolean);
      uvr.a(paramurt, paramBoolean);
      return;
    }
  }
  
  public void b(urt paramurt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onVideoStart] video: ");
    if ((paramurt != null) && (paramurt.jdField_a_of_type_Urx != null)) {}
    for (String str = paramurt.jdField_a_of_type_Urx.d;; str = "")
    {
      uya.b("WSFollowPlayerStatusListenerImpl", str);
      uvm.a(paramurt);
      if (this.a != null) {
        this.a.a();
      }
      return;
    }
  }
  
  public void c(urt paramurt)
  {
    if ((paramurt == null) || (this.a == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[onCompletion] videoTitle: ");
    if (paramurt.jdField_a_of_type_Urx != null) {}
    for (Object localObject = paramurt.jdField_a_of_type_Urx.d;; localObject = "videoInfo is null!")
    {
      uya.e("WSFollowPlayerStatusListenerImpl", (String)localObject);
      localObject = this.a.a();
      if ((localObject == null) || (!((WSPlayerManager)localObject).j())) {
        break;
      }
      uya.e("WSFollowPlayerStatusListenerImpl", "[onCompletion] loopPlayMode: true");
      ((WSPlayerManager)localObject).b(paramurt, false);
      return;
    }
  }
  
  public void d(urt paramurt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onVideoPause] video: ");
    if ((paramurt != null) && (paramurt.jdField_a_of_type_Usr != null)) {}
    for (paramurt = paramurt.jdField_a_of_type_Urx.d;; paramurt = "")
    {
      uya.b("WSFollowPlayerStatusListenerImpl", paramurt);
      return;
    }
  }
  
  public void e(urt paramurt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onVideoRestart] video: ");
    if ((paramurt != null) && (paramurt.jdField_a_of_type_Usr != null)) {}
    for (paramurt = paramurt.jdField_a_of_type_Urx.d;; paramurt = "")
    {
      uya.b("WSFollowPlayerStatusListenerImpl", paramurt);
      return;
    }
  }
  
  public void f(urt paramurt)
  {
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uto
 * JD-Core Version:    0.7.0.1
 */