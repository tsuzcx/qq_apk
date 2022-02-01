import android.arch.lifecycle.ViewModel;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class rxi
  extends ViewModel
{
  protected pcx a;
  protected int bvH = -1;
  
  public void a(int paramInt, VSBaseRequest paramVSBaseRequest, rxc.a parama)
  {
    VSNetworkHelper.a().a(paramInt, paramVSBaseRequest, parama);
    if (paramVSBaseRequest != null) {
      QLog.d(getLogTag(), 1, getLogTag() + "->sendQCircleRequest: CmdName:" + paramVSBaseRequest.getCmdName() + "| TraceId:" + paramVSBaseRequest.getTraceId() + " | SeqId:" + paramVSBaseRequest.getCurrentSeq());
    }
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, rxc.a parama)
  {
    a(this.bvH, paramVSBaseRequest, parama);
  }
  
  public abstract String getLogTag();
  
  public void onDestroy() {}
  
  public void sO(String paramString)
  {
    QLog.d(getLogTag(), 1, "loadPreloadResult:" + paramString);
    ryo.a(paramString, new rxi.a(this));
  }
  
  public void setContextHashCode(int paramInt)
  {
    this.bvH = paramInt;
  }
  
  protected void t(Object[] paramArrayOfObject) {}
  
  public static class a
    implements ryu
  {
    private WeakReference<rxi> dn;
    
    a(rxi paramrxi)
    {
      this.dn = new WeakReference(paramrxi);
    }
    
    public void s(Object[] paramArrayOfObject)
    {
      if (this.dn != null)
      {
        rxi localrxi = (rxi)this.dn.get();
        if (localrxi != null) {
          localrxi.t(paramArrayOfObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rxi
 * JD-Core Version:    0.7.0.1
 */