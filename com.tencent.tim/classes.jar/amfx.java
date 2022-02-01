import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

public class amfx
  implements Observer
{
  public amfx(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!SignTextEditFragment.a(this.a).get()) {}
    do
    {
      return;
      SignTextEditFragment.a(this.a).set(false);
    } while (!(paramObject instanceof Integer));
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    case 3: 
      paramObservable = amhd.a().a(this.a.c.tplId);
      if ((paramObservable != null) && (!TextUtils.isEmpty(paramObservable.id)) && (Integer.parseInt(paramObservable.id) > 0) && (paramObservable.materialVersion < 2)) {
        if (BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getBoolean(this.a.mApp.getCurrentAccountUin() + "new_signature_version_826", true)) {
          aqnl.a(this.a.getActivity(), this.a.getActivity().app, 0, "signature_chouti");
        }
      }
      for (;;)
      {
        amhd.a().deleteObserver(this.a.g);
        return;
        this.a.dF(100, SignTextEditFragment.a(this.a));
      }
    }
    if (BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getBoolean(this.a.mApp.getCurrentAccountUin() + "new_signature_version_826", true)) {
      aqnl.a(this.a.getActivity(), this.a.getActivity().app, 0, "signature_chouti");
    }
    for (;;)
    {
      amhd.a().deleteObserver(this.a.g);
      return;
      this.a.dF(100, SignTextEditFragment.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amfx
 * JD-Core Version:    0.7.0.1
 */