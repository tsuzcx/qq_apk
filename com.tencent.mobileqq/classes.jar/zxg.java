import android.arch.lifecycle.ViewModel;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;

public abstract class zxg
  extends ViewModel
{
  protected int a = -1;
  protected vrp a;
  
  public abstract String a();
  
  public void a() {}
  
  public void a(int paramInt, VSBaseRequest paramVSBaseRequest, zxa paramzxa)
  {
    VSNetworkHelper.a().a(paramInt, paramVSBaseRequest, paramzxa);
    if (paramVSBaseRequest != null) {
      QLog.d(a(), 1, a() + "->sendQCircleRequest: CmdName:" + paramVSBaseRequest.getCmdName() + "| TraceId:" + paramVSBaseRequest.getTraceId() + " | SeqId:" + paramVSBaseRequest.getCurrentSeq());
    }
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, zxa paramzxa)
  {
    a(this.a, paramVSBaseRequest, paramzxa);
  }
  
  protected void a(Object[] paramArrayOfObject) {}
  
  public void b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void d(String paramString)
  {
    QLog.d(a(), 1, "loadPreloadResult:" + paramString);
    zzk.a(paramString, new zxh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxg
 * JD-Core Version:    0.7.0.1
 */