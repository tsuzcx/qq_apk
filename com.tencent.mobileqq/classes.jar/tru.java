import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class tru
  extends rlt
{
  tru(trt paramtrt) {}
  
  public void a(rwf paramrwf, Object paramObject)
  {
    QLog.d("KandianAdPandent", 2, "onVideoPrepared");
    trt.a(this.a).d();
  }
  
  public void b(rwf paramrwf)
  {
    super.b(paramrwf);
    QLog.d("KandianAdPandent", 2, "onCompletion");
    trt.a(this.a).sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tru
 * JD-Core Version:    0.7.0.1
 */