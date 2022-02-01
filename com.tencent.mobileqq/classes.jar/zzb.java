import WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import java.lang.ref.WeakReference;

final class zzb
  implements VSDispatchObserver.onVSRspCallBack<WEISHI.stGetPersonalPageRsp>
{
  private final WeakReference<zyx> a;
  
  public zzb(zyx paramzyx)
  {
    this.a = new WeakReference(paramzyx);
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, WEISHI.stGetPersonalPageRsp paramstGetPersonalPageRsp)
  {
    paramVSBaseRequest = (zyx)this.a.get();
    if (paramVSBaseRequest == null) {}
    do
    {
      return;
      paramVSBaseRequest.a(paramstGetPersonalPageRsp, false);
    } while (paramstGetPersonalPageRsp == null);
    zyx.a(paramVSBaseRequest, paramstGetPersonalPageRsp.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzb
 * JD-Core Version:    0.7.0.1
 */