import android.arch.lifecycle.ViewModel;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;

public abstract class ubk
  extends ViewModel
{
  protected int a = -1;
  protected uae a;
  
  public abstract String a();
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(int paramInt, VSBaseRequest paramVSBaseRequest, zac paramzac)
  {
    VSNetworkHelper.a().a(paramInt, paramVSBaseRequest, paramzac);
    if (paramVSBaseRequest != null) {
      QLog.d(a(), 1, a() + "->sendQCircleRequest: CmdName:" + paramVSBaseRequest.getCmdName() + "| TraceId:" + paramVSBaseRequest.getTraceId() + " | SeqId:" + paramVSBaseRequest.getCurrentSeq());
    }
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, zac paramzac)
  {
    a(this.a, paramVSBaseRequest, paramzac);
  }
  
  public void a(String paramString)
  {
    QLog.d(a(), 1, "loadPreloadResult:" + paramString);
    ykb.a(paramString, new ubl(this));
  }
  
  protected void a(Object[] paramArrayOfObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubk
 * JD-Core Version:    0.7.0.1
 */