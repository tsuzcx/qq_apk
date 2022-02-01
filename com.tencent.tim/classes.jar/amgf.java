import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignatureEditFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class amgf
  implements Observer
{
  public amgf(SignatureEditFragment paramSignatureEditFragment) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Signature.Fragment", 2, "mSignatureObserver type = " + paramObject);
    }
    if ((paramObject instanceof ArrayList))
    {
      paramObject = (ArrayList)paramObject;
      switch (((Integer)paramObject.get(0)).intValue())
      {
      }
    }
    label395:
    while (SignatureEditFragment.a(this.a) == null)
    {
      return;
      paramObservable = (RichStatus)paramObject.get(1);
      this.a.c = paramObservable;
      this.a.cCy = false;
      if (this.a.c.plainText != null)
      {
        paramObject = amhd.a().k;
        if (paramObject != null)
        {
          paramObject.plainText = ((ArrayList)this.a.c.plainText.clone());
          paramObject.topics.clear();
          paramObject.topics.addAll(this.a.c.topics);
        }
      }
      if (paramObservable != null)
      {
        this.a.i.copyFrom(paramObservable);
        amhd.a().a(this.a.i.tplId);
      }
      this.a.cCx = false;
      if (SignatureEditFragment.a(this.a) != null) {
        SignatureEditFragment.a(this.a).sendEmptyMessage(257);
      }
      SignatureEditFragment.b(this.a);
      return;
      int i = ((Integer)paramObject.get(1)).intValue();
      paramObservable = (HashMap)paramObject.get(2);
      if ((i == 100) || (i == 0))
      {
        this.a.cCx = false;
        SignatureEditFragment.a(this.a, true);
        this.a.cCy = false;
        if ((this.a.mApp.getAccount() == null) && (((Integer)paramObject.get(3)).intValue() != 1)) {
          break label395;
        }
        this.a.c = RichStatus.getEmptyStatus();
        amhd.a().h(this.a.c);
      }
      for (;;)
      {
        paramObject = new Message();
        paramObject.what = 259;
        paramObject.obj = paramObservable;
        SignatureEditFragment.a(this.a).sendMessage(paramObject);
        return;
        amhd.a().j = null;
        amhd.a().k = null;
        SignatureEditFragment.c(this.a);
        this.a.dNo();
      }
      ((Integer)paramObject.get(1)).intValue();
      return;
      i = ((Integer)paramObject.get(1)).intValue();
      paramObservable = SignatureEditFragment.a(this.a).obtainMessage();
      paramObservable.what = 262;
      paramObservable.arg1 = i;
      SignatureEditFragment.a(this.a).sendMessage(paramObservable);
      return;
    }
    SignatureEditFragment.a(this.a).sendEmptyMessage(257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amgf
 * JD-Core Version:    0.7.0.1
 */