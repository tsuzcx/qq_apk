import android.support.annotation.NonNull;
import android.widget.LinearLayout;
import com.tencent.mobileqq.troop.homework.arithmetic.ui.CheckArithHWResultFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

public class apgv
  extends SimpleObserver<apgq.c>
{
  public apgv(CheckArithHWResultFragment paramCheckArithHWResultFragment) {}
  
  public void a(apgq.c paramc)
  {
    super.onNext(paramc);
    ram.w("QQ.Troop.homework.CheckArithHWResultFragment", "requestSendHomeworkResult completed");
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
    rom.sF(paramc.url);
    rom.sF(paramc.coS);
    CheckArithHWResultFragment.a(this.a, paramc.url, paramc.coS);
  }
  
  public void onCancel()
  {
    super.onCancel();
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ram.e("QQ.Troop.homework.CheckArithHWResultFragment", "send homework error:" + paramError);
    QQToast.a(this.a.getActivity(), 1, acfp.m(2131703781), 0).show();
    CheckArithHWResultFragment.a(this.a).setVisibility(8);
    CheckArithHWResultFragment.a(this.a, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apgv
 * JD-Core Version:    0.7.0.1
 */