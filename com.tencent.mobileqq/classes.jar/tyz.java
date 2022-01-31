import android.arch.lifecycle.ViewModel;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;

public abstract class tyz
  extends ViewModel
{
  protected int a = -1;
  protected tys a;
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(int paramInt, VSBaseRequest paramVSBaseRequest, yvn paramyvn)
  {
    VSNetworkHelper.a().a(paramInt, paramVSBaseRequest, paramyvn);
  }
  
  public void a(VSBaseRequest paramVSBaseRequest, yvn paramyvn)
  {
    a(this.a, paramVSBaseRequest, paramyvn);
  }
  
  protected void a(Object[] paramArrayOfObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyz
 * JD-Core Version:    0.7.0.1
 */