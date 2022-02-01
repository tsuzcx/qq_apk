import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity.5.1;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class khz
  implements auuw.b
{
  public khz(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity, KandianMergeManager paramKandianMergeManager) {}
  
  public void a(auuw.a parama)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    switch (parama.id)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      do
      {
        return;
        if (!this.a.By()) {}
        for (;;)
        {
          this.a.mS(bool1);
          if (!bool1) {
            break;
          }
          QQToast.a(this.this$0, this.this$0.getResources().getString(2131701905), 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(2131299627));
          kbp.a(null, "CliOper", "", "", "0X80067D6", "0X80067D6", 0, 0, "", "", "", kxm.iQ(), false);
          return;
          bool1 = false;
        }
        kbp.a(null, "CliOper", "", "", "0X800705C", "0X800705C", 0, 0, "", "", "", kxm.iQ(), false);
        return;
        ThreadManager.postImmediately(new ReadInJoyFeedsActivity.5.1(this), null, true);
        parama = new Intent(this.this$0, ReadInJoySettingActivity.class);
        this.this$0.startActivity(parama);
        anot.a(null, "CliOper", "", "", "0X800705B", "0X800705B", 0, 0, "", "", "", kxm.iQ());
        return;
        parama = this.this$0.getAppRuntime();
        if (!awit.s(this.this$0.getAppRuntime())) {}
        for (bool1 = bool2;; bool1 = false)
        {
          awit.g(parama, bool1);
          lcc.a().aCi();
          return;
        }
        if (parama.id == 3) {
          kxm.aMv = -2;
        }
        for (;;)
        {
          QLog.d("ReadInJoyBaseActivity", 1, "readinjoy setting feeds type:" + kxm.aMv);
          return;
          if (parama.id == 4) {
            kxm.aMv = -1;
          } else if (parama.id == 5) {
            kxm.aMv = 1;
          } else if (parama.id == 6) {
            kxm.aMv = 0;
          }
        }
        parama = kxm.getAccount();
        if (TextUtils.isEmpty(parama)) {
          QLog.e("ReadInJoyBaseActivity", 2, "click personal page , but uin is empty !");
        }
        for (;;)
        {
          kbp.a(null, "CliOper", "", "", "0X8007384", "0X8007384", 0, 0, "", "", "", kxm.iQ(), false);
          return;
          parama = kwt.acF + aqgo.encodeToString(parama.getBytes(), 2);
          kxm.aJ(this.this$0, parama);
        }
        kbp.a(null, "CliOper", "", "", "0X8007383", "0X8007383", 0, 0, "", "", "", kxm.iQ(), false);
      } while (Boolean.valueOf(awit.H(kxm.getAppRuntime())).booleanValue());
      kxm.aJ(this.this$0, kwt.acC);
      return;
    case 9: 
      parama = this.this$0.getAppRuntime();
      if (!awit.u(this.this$0.getAppRuntime())) {}
      for (bool1 = bool3;; bool1 = false)
      {
        awit.j(parama, bool1);
        return;
      }
    }
    parama = this.this$0.getAppRuntime();
    if (!awit.w(this.this$0.getAppRuntime())) {}
    for (bool1 = bool4;; bool1 = false)
    {
      awit.l(parama, bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     khz
 * JD-Core Version:    0.7.0.1
 */