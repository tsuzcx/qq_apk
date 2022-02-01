import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;

public class ulu
  implements ula
{
  private ucr a;
  
  public ulu(ucr paramucr)
  {
    this.a = paramucr;
  }
  
  public void a(ukz paramukz) {}
  
  public void a(ukz paramukz, int paramInt) {}
  
  public void a(ukz paramukz, int paramInt1, int paramInt2, String paramString)
  {
    paramString = new StringBuilder().append("[onVideoError] video: ");
    if ((paramukz != null) && (paramukz.jdField_a_of_type_AndroidViewView != null)) {}
    for (paramukz = paramukz.jdField_a_of_type_Uld.d;; paramukz = "")
    {
      uqf.b("WSFollowPlayerStatusListenerImpl", paramukz);
      return;
    }
  }
  
  public void a(ukz paramukz, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onVideoStop] video: ");
    if ((paramukz != null) && (paramukz.jdField_a_of_type_AndroidViewView != null)) {}
    for (String str = paramukz.jdField_a_of_type_Uld.d;; str = "")
    {
      uqf.b("WSFollowPlayerStatusListenerImpl", str);
      uns.a(paramukz, paramBoolean);
      unx.a(paramukz, paramBoolean);
      return;
    }
  }
  
  public void b(ukz paramukz)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onVideoStart] video: ");
    if ((paramukz != null) && (paramukz.jdField_a_of_type_AndroidViewView != null)) {}
    for (String str = paramukz.jdField_a_of_type_Uld.d;; str = "")
    {
      uqf.b("WSFollowPlayerStatusListenerImpl", str);
      uns.a(paramukz);
      if (this.a != null) {
        this.a.a();
      }
      return;
    }
  }
  
  public void c(ukz paramukz)
  {
    if ((paramukz == null) || (this.a == null)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("[onCompletion] videoTitle: ");
    if (paramukz.jdField_a_of_type_Uld != null) {}
    for (Object localObject = paramukz.jdField_a_of_type_Uld.d;; localObject = "videoInfo is null!")
    {
      uqf.e("WSFollowPlayerStatusListenerImpl", (String)localObject);
      localObject = this.a.a();
      if ((localObject == null) || (!((WSPlayerManager)localObject).j())) {
        break;
      }
      uqf.e("WSFollowPlayerStatusListenerImpl", "[onCompletion] loopPlayMode: true");
      ((WSPlayerManager)localObject).b(paramukz, false);
      return;
    }
  }
  
  public void d(ukz paramukz)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onVideoPause] video: ");
    if ((paramukz != null) && (paramukz.jdField_a_of_type_AndroidViewView != null)) {}
    for (paramukz = paramukz.jdField_a_of_type_Uld.d;; paramukz = "")
    {
      uqf.b("WSFollowPlayerStatusListenerImpl", paramukz);
      return;
    }
  }
  
  public void e(ukz paramukz)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("[onVideoRestart] video: ");
    if ((paramukz != null) && (paramukz.jdField_a_of_type_AndroidViewView != null)) {}
    for (paramukz = paramukz.jdField_a_of_type_Uld.d;; paramukz = "")
    {
      uqf.b("WSFollowPlayerStatusListenerImpl", paramukz);
      return;
    }
  }
  
  public void f(ukz paramukz)
  {
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulu
 * JD-Core Version:    0.7.0.1
 */