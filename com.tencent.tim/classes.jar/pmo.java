import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.concurrent.atomic.AtomicBoolean;

class pmo
  implements ppv.b<pzq, qax>
{
  pmo(pmm parampmm) {}
  
  public void a(pzq arg1, qax paramqax, ErrorMessage paramErrorMessage)
  {
    this.a.Ad = System.currentTimeMillis();
    if (paramErrorMessage.isSuccess()) {}
    for (;;)
    {
      synchronized (this.a.bj)
      {
        this.a.a = paramqax.b;
        this.a.a.save();
        ram.d("Q.qqstory.publish:VideoServerInfoManager", "get server inf %s", this.a.a);
        this.a.aD.set(false);
        this.a.aC.set(false);
      }
      synchronized (this.a.bi)
      {
        this.a.bi.notifyAll();
        return;
        paramqax = finally;
        throw paramqax;
        ram.w("Q.qqstory.publish:VideoServerInfoManager", "get server info:%s", paramErrorMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pmo
 * JD-Core Version:    0.7.0.1
 */