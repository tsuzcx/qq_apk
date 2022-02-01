import android.arch.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import rx.Subscription;
import rx.functions.Action1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Long;)V"}, k=3, mv={1, 1, 16})
final class tie<T>
  implements Action1<Long>
{
  tie(tic paramtic) {}
  
  public final void call(Long paramLong)
  {
    paramLong = this.b;
    tic.a(paramLong, tic.a(paramLong) - 1);
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingViewModel", 2, "onCountDown subscribe value : " + tic.a(this.b));
    }
    if (tic.a(this.b) <= 0)
    {
      tic.a(this.b, tic.a(this.b));
      tic.b(this.b, (Subscription)null);
    }
    this.b.t().setValue(new tif(1, null, tic.a(this.b), 2, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tie
 * JD-Core Version:    0.7.0.1
 */