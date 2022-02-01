import android.os.Handler;
import com.tencent.qphone.base.util.QLog;

class tyn
  extends rst
{
  tyn(tym paramtym) {}
  
  public void a(sdj paramsdj, Object paramObject)
  {
    QLog.d("ReadInJoySuperMaskAd", 2, "onVideoPrepared");
    tym.a(this.a).d();
  }
  
  public void b(sdj paramsdj)
  {
    super.b(paramsdj);
    QLog.d("ReadInJoySuperMaskAd", 2, "onCompletion");
    tym.a(this.a).sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tyn
 * JD-Core Version:    0.7.0.1
 */