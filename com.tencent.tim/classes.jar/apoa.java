import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.screendetect.ScreenShotDetector;
import com.tencent.mobileqq.screendetect.ScreenShotDetector.b;
import com.tencent.mobileqq.troop.quickat.ui.AIOAtSearchManager;
import com.tencent.mobileqq.troop.quickat.ui.AIOAtSearchManager.a;
import com.tencent.mobileqq.troop.quickat.ui.AtPanel.3;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

public class apoa
  implements PopupWindow.OnDismissListener, apod, ScreenShotDetector.b, AIOAtSearchManager.a
{
  private View II;
  apnv jdField_a_of_type_Apnv;
  private apoj jdField_a_of_type_Apoj;
  private apok jdField_a_of_type_Apok;
  private final TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie;
  private AIOAtSearchManager jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager;
  private acnd b;
  private boolean cRG;
  private boolean cRH;
  private boolean cRI;
  private String cqi;
  private SessionInfo k;
  private QQAppInterface mApp;
  private BaseActivity mContext;
  private boolean mShowing;
  
  public apoa(TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie = paramTroopChatPie;
    this.mContext = paramTroopChatPie.a();
    this.mApp = paramTroopChatPie.app;
    this.k = paramTroopChatPie.sessionInfo;
    this.jdField_a_of_type_Apnv = new apnv(this.mApp);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager = new AIOAtSearchManager(this.mApp, this.k);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(this);
  }
  
  private void Fb()
  {
    Object localObject = this.mContext.findViewById(2131369276);
    View localView = this.mContext.findViewById(2131362412);
    this.jdField_a_of_type_Apok = apok.a(this.mContext, -1, -1);
    this.jdField_a_of_type_Apok.setTouchInterceptor(new apoc(this, localView, (View)localObject));
    this.jdField_a_of_type_Apok.setOnDismissListener(this);
    localObject = (XListView)this.jdField_a_of_type_Apok.getContentView().findViewById(2131380348);
    this.jdField_a_of_type_Apoj = new apoj(this.mApp, BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie, this.jdField_a_of_type_Apok.getContentView(), (XListView)localObject);
    this.jdField_a_of_type_Apoj.b.a(this);
    this.jdField_a_of_type_Apok.a(this.jdField_a_of_type_Apoj.b.a());
    bpM();
    ((acms)this.mApp.getBusinessHandler(20)).Fh(this.k.aTl);
  }
  
  private void bpM()
  {
    if (this.b == null) {
      this.b = new apob(this);
    }
    this.mApp.addObserver(this.b);
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, " addObservers =" + this.b);
    }
  }
  
  private void eaQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, "initMultiSelectMode: invoked. ");
    }
    this.jdField_a_of_type_Apoj.b.a().cRO = false;
    TextView localTextView = (TextView)this.jdField_a_of_type_Apok.getContentView().findViewById(2131363028);
    if (localTextView != null) {
      localTextView.setText(2131696127);
    }
  }
  
  public void Tr(String paramString)
  {
    if ((this.jdField_a_of_type_Apoj != null) && (this.jdField_a_of_type_Apok != null) && (this.jdField_a_of_type_Apok.isShowing())) {
      this.jdField_a_of_type_Apoj.b.Ts(paramString);
    }
  }
  
  public void a(apoo.a parama)
  {
    if (!this.mShowing) {
      if (QLog.isColorLevel()) {
        QLog.d("AtPanel", 2, "refreshUI =" + this.mShowing);
      }
    }
    do
    {
      do
      {
        return;
        if ((parama.Bu == null) || (parama.Bu.isEmpty()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AtPanel", 2, "resultList = null");
          }
          azJ();
          return;
        }
        this.jdField_a_of_type_Apok.jT(8, 2131690101);
        eaR();
        if (this.jdField_a_of_type_Apoj != null) {
          this.jdField_a_of_type_Apoj.b.b(parama);
        }
        if (!this.cRH) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("AtPanel", 2, "From Multi");
      return;
    } while (this.jdField_a_of_type_Apoj == null);
    this.jdField_a_of_type_Apoj.listView.setAdapter(this.jdField_a_of_type_Apoj.listView.getAdapter());
    this.jdField_a_of_type_Apoj.listView.setSelection(0);
  }
  
  public boolean aBo()
  {
    if (this.jdField_a_of_type_Apoj != null) {
      return this.jdField_a_of_type_Apoj.b.cRM;
    }
    return false;
  }
  
  public boolean azJ()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Apok != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Apok.isShowing())
      {
        this.jdField_a_of_type_Apok.dismiss();
        bool1 = true;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.eaN();
    return bool1;
  }
  
  public void b(View paramView, String paramString, boolean paramBoolean)
  {
    abrb.b(this.mApp, "aio_at", true);
    if (this.jdField_a_of_type_Apok == null) {
      Fb();
    }
    this.mShowing = true;
    this.cRH = false;
    this.II = paramView;
    if ((TextUtils.isEmpty(paramString)) && (TextUtils.isEmpty(this.cqi))) {
      eaQ();
    }
    this.cqi = paramString;
    this.cRG = paramBoolean;
    paramView = this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.gA();
    boolean bool;
    if ((TextUtils.isEmpty(paramString)) || (paramView.isEmpty()))
    {
      eaR();
      if ((!paramView.isEmpty()) && (this.jdField_a_of_type_Apnv.qE(this.k.aTl)) && (!this.cRI))
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("AtPanel", 2, new Object[] { "showDialogAtView: invoked. ", " noNeedToFetch: ", Boolean.valueOf(bool) });
        }
        if (!bool) {
          break label232;
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.q(paramString, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.SW());
      }
    }
    for (;;)
    {
      anot.a(this.mApp, "dc00898", "", "", "0X800A48E", "0X800A48E", 0, 0, "", "", "", "");
      return;
      bool = false;
      break;
      label232:
      this.jdField_a_of_type_Apok.jT(0, 2131690101);
      this.jdField_a_of_type_Apnv.Tp(this.k.aTl);
      this.cRI = false;
      continue;
      this.jdField_a_of_type_Apok.jT(8, 2131690101);
      this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.q(paramString, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.SW());
    }
  }
  
  public void dNJ()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      azJ();
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new AtPanel.3(this));
  }
  
  public void dUK()
  {
    if (this.b != null) {
      this.mApp.removeObserver(this.b);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AtPanel", 2, " removeObserver =" + this.b);
    }
    azJ();
    this.jdField_a_of_type_Apok = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.a(null);
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.cancelAllTask();
    if ((this.jdField_a_of_type_Apoj != null) && (this.jdField_a_of_type_Apoj.b != null)) {
      this.jdField_a_of_type_Apoj.b.destroy();
    }
  }
  
  public void de(String paramString, boolean paramBoolean)
  {
    this.cRH = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopQuickatUiAIOAtSearchManager.q(paramString, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildTroopChatPie.SW());
  }
  
  public void eaR()
  {
    ScreenShotDetector.getInstance().a(this);
    apop.co(this.mContext);
    this.jdField_a_of_type_Apok.eaS();
    this.jdField_a_of_type_Apok.showAtLocation(this.II, 48, 0, 0);
    this.jdField_a_of_type_Apok.bf(apop.t(this.mContext), apop.dVc, -1);
    this.jdField_a_of_type_Apoj.b.eaW();
  }
  
  public void onDismiss()
  {
    this.cRH = false;
    this.mShowing = false;
    this.cqi = null;
    ScreenShotDetector.getInstance().a(null);
    abrb.b(this.mApp, "aio_at", false);
    if (this.jdField_a_of_type_Apoj != null) {
      this.jdField_a_of_type_Apoj.b.eaX();
    }
    int i = apop.t(this.mContext);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.mContext.getSystemService("input_method");
    View localView = this.mContext.findViewById(2131369276);
    if ((i == 2) && (localInputMethodManager != null) && (localView != null)) {
      localInputMethodManager.showSoftInput(localView, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apoa
 * JD-Core Version:    0.7.0.1
 */