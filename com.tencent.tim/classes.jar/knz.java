import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.ad.view.KandianAdPandentMask.KandianAdPandentView;
import com.tencent.qphone.base.util.QLog;

public class knz
  extends msc
{
  public knz(KandianAdPandentMask.KandianAdPandentView paramKandianAdPandentView) {}
  
  public void a(myi parammyi)
  {
    super.a(parammyi);
    QLog.d("KandianAdPandent", 2, "onCompletion");
    KandianAdPandentMask.KandianAdPandentView.a(this.b).sendEmptyMessage(2);
  }
  
  public void a(myi parammyi, Object paramObject)
  {
    QLog.d("KandianAdPandent", 2, "onVideoPrepared");
    KandianAdPandentMask.KandianAdPandentView.a(this.b).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     knz
 * JD-Core Version:    0.7.0.1
 */