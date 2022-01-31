import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.IRenderCallback;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.store.ApolloViewController;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;

public class yuf
  implements IRenderCallback
{
  private WeakReference a;
  
  public yuf(ApolloViewController paramApolloViewController)
  {
    this.a = new WeakReference(paramApolloViewController);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "mOtherSurfaceView onCompleteRender, roleName=", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if (this.a != null)
      {
        ApolloViewController localApolloViewController = (ApolloViewController)this.a.get();
        ApolloWebAvatarParam localApolloWebAvatarParam;
        if (localApolloViewController != null)
        {
          localApolloWebAvatarParam = ApolloViewController.a(localApolloViewController);
          if ((localApolloWebAvatarParam != null) && (paramString.equals(localApolloWebAvatarParam.apolloId)) && (localApolloViewController.b != null))
          {
            ApolloViewController.b(localApolloViewController);
            ApolloViewController.a(localApolloViewController).removeMessages(24);
            localApolloViewController.b.stopLoopDelayed(1000L);
            if (!TextUtils.isEmpty(ApolloViewController.a(localApolloViewController)))
            {
              if (!ApolloViewController.a(localApolloViewController)) {
                break label173;
              }
              if ((ApolloViewController.a(localApolloViewController) == 1) && (localApolloViewController.a != null)) {
                localApolloViewController.a.b();
              }
            }
          }
        }
        while ((localApolloViewController != null) && (localApolloViewController.b != null))
        {
          return;
          label173:
          if (ApolloViewController.a(localApolloViewController) == 1)
          {
            if (localApolloViewController.a != null) {
              localApolloViewController.a.a(true);
            }
          }
          else {
            localApolloViewController.b.getRenderImpl().a(1, localApolloWebAvatarParam.apolloId, "Bubble");
          }
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "mOtherSurfaceView onStartRender, roleName=", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {}
    ApolloViewController localApolloViewController;
    ApolloWebAvatarParam localApolloWebAvatarParam;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a == null);
        localApolloViewController = (ApolloViewController)this.a.get();
      } while (localApolloViewController == null);
      localApolloWebAvatarParam = ApolloViewController.a(localApolloViewController);
    } while ((localApolloWebAvatarParam == null) || (!paramString.equals(localApolloWebAvatarParam.apolloId)));
    ApolloViewController.a(localApolloViewController);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yuf
 * JD-Core Version:    0.7.0.1
 */