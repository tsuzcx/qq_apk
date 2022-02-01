import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class abze
  implements abiy, abja
{
  private WeakReference<abiy> fW;
  public WeakReference<BaseChatPie> fj;
  
  public abze(BaseChatPie paramBaseChatPie)
  {
    if (((paramBaseChatPie instanceof xys)) || ((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof xyi)) || ((paramBaseChatPie instanceof yam))) {
      this.fj = new WeakReference(paramBaseChatPie);
    }
  }
  
  public void B(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBackgroundViewListener", 2, "onCompleteRender");
    }
    if ((this.fW != null) && (this.fW.get() != null)) {
      ((abiy)this.fW.get()).B(paramInt1, paramInt2, paramString);
    }
  }
  
  public void bH(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBackgroundViewListener", 2, "onStartRender");
    }
    if ((this.fW != null) && (this.fW.get() != null)) {
      ((abiy)this.fW.get()).bH(paramInt, paramString);
    }
  }
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    Object localObject2 = (BaseChatPie)this.fj.get();
    if ((localObject2 == null) || (((BaseChatPie)localObject2).a == null)) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject1 = ((BaseChatPie)localObject2).app;
        localObject2 = ((BaseChatPie)localObject2).a.a();
      } while ((localObject1 == null) || (localObject2 == null));
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBackgroundViewListener", 2, "surfaceView.getWidth():" + ((ApolloTextureView)localObject2).getWidth());
      }
      ((ApolloTextureView)localObject2).getRenderImpl().a(1, null, 0, 1.0F, 250.0F, 0.0F);
      ((ApolloTextureView)localObject2).getRenderImpl().stopLoopDelayed(1000L);
      localObject1 = ((abrg)((AppInterface)localObject1).getManager(249)).a();
    } while (localObject1 == null);
    ((abqy)localObject1).cEw();
  }
  
  public void setRenderCallback(abiy paramabiy)
  {
    this.fW = new WeakReference(paramabiy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abze
 * JD-Core Version:    0.7.0.1
 */