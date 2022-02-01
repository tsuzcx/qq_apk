import android.app.Activity;
import android.content.res.Resources;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.3;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter.5;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class agwh
  extends agwc
  implements agsc, aguk.d
{
  public agrt a;
  public agxv a;
  private ajat.c a;
  private String bJr;
  private boolean cfq;
  private boolean cfr = true;
  private Timer mTimer;
  
  public agwh(aguk paramaguk, Activity paramActivity)
  {
    super(paramaguk, paramActivity);
    this.jdField_a_of_type_Ajat$c = new agwl(this);
    this.jdField_a_of_type_Agxv = new agxv(paramActivity);
    a(this.jdField_a_of_type_Agxv);
  }
  
  private void Ye()
  {
    ahau.JH("0X8004BE0");
    if (this.jdField_a_of_type_Agrt == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "playMusic error. MusicService is null");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Agrt.mD(this.bJr)) {
        break;
      }
      this.jdField_a_of_type_Agrt.a(this);
    } while (!this.jdField_a_of_type_Agrt.init(this.bJr));
    this.jdField_a_of_type_Agrt.start();
    setPlaying(true);
    ajat.a().requestMediaFocus(1, this.jdField_a_of_type_Ajat$c);
  }
  
  private void Zx()
  {
    ahau.JH("0X8004BE1");
    if (this.jdField_a_of_type_Agrt == null) {
      QLog.e("FileBrowserPresenter<FileAssistant>", 1, "pauseMusic error. MusicService is null");
    }
    while (!this.jdField_a_of_type_Agrt.mD(this.bJr)) {
      return;
    }
    this.jdField_a_of_type_Agrt.pause();
    setPlaying(false);
    ajat.a().abandonMediaFocus(this.jdField_a_of_type_Ajat$c);
  }
  
  private boolean amB()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Agrt != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Agrt.mD(this.bJr))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Agrt.isPlaying()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void dkc()
  {
    dkd();
    this.mTimer = new Timer();
    this.mTimer.scheduleAtFixedRate(new MusicFilePresenter.5(this), 0L, 1000L);
  }
  
  private void dkd()
  {
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
  }
  
  private void refreshView()
  {
    this.jdField_a_of_type_Agxv.Jr(this.jdField_a_of_type_Aguk.getFileName());
    this.jdField_a_of_type_Agxv.Js(ahbj.g(this.jdField_a_of_type_Aguk.getFileSize()));
    this.jdField_a_of_type_Agxv.dks();
    djT();
    this.bJr = this.jdField_a_of_type_Aguk.getFilePath();
    dkb();
    this.jdField_a_of_type_Agxv.JL(true);
    if (this.jdField_a_of_type_Agrt.mD(this.bJr))
    {
      OB(this.jdField_a_of_type_Agrt.getCurrentPosition());
      return;
    }
    this.jdField_a_of_type_Agxv.Jq(ahbr.br(0L));
  }
  
  private void setPlaying(boolean paramBoolean)
  {
    this.cfq = paramBoolean;
    if (this.cfq)
    {
      int i = this.jdField_a_of_type_Agrt.getCurrentPosition();
      OB(i);
      this.jdField_a_of_type_Agxv.OL(i);
      dkc();
    }
    for (;;)
    {
      this.jdField_a_of_type_Agxv.JM(this.cfq);
      return;
      dkd();
    }
  }
  
  public void OA(int paramInt)
  {
    String str = ahbr.br(paramInt);
    this.mContext.runOnUiThread(new MusicFilePresenter.3(this, str, paramInt));
  }
  
  public void OB(int paramInt)
  {
    this.jdField_a_of_type_Agxv.Jq(ahbr.br(paramInt));
  }
  
  public void aO(float paramFloat)
  {
    aP(paramFloat);
  }
  
  public boolean amj()
  {
    this.mContext.setRequestedOrientation(1);
    return false;
  }
  
  public boolean amk()
  {
    return this.cfr;
  }
  
  public void cqt()
  {
    super.cqt();
    if (this.jdField_a_of_type_Agrt != null) {
      this.jdField_a_of_type_Agrt.a(null);
    }
    dkd();
    if ((this.cfq) && (this.jdField_a_of_type_Agrt != null) && (this.jdField_a_of_type_Agrt.mD(this.bJr))) {
      this.jdField_a_of_type_Agrt.stop();
    }
    ajat.a().a(this.jdField_a_of_type_Ajat$c);
    this.jdField_a_of_type_Agrt = null;
  }
  
  public void djE()
  {
    this.jdField_a_of_type_Agxv.JJ(false);
    this.jdField_a_of_type_Agxv.JK(true);
    aP(this.jdField_a_of_type_Aguk.k());
  }
  
  public void djF()
  {
    this.jdField_a_of_type_Agxv.JJ(true);
    this.jdField_a_of_type_Agxv.JK(false);
    djT();
  }
  
  public void djG()
  {
    this.jdField_a_of_type_Agxv.JJ(true);
    this.jdField_a_of_type_Agxv.JK(false);
    djT();
    if (this.b != null) {
      this.b.ir();
    }
  }
  
  public void djH()
  {
    this.jdField_a_of_type_Agxv.JJ(true);
    this.jdField_a_of_type_Agxv.JK(false);
    djT();
  }
  
  protected void djT()
  {
    super.djT();
    if (this.jdField_a_of_type_Aguk.bL() == 2) {
      this.jdField_a_of_type_Agxv.JJ(false);
    }
  }
  
  public void dkb()
  {
    this.bJr = this.jdField_a_of_type_Aguk.getFilePath();
    if (this.jdField_a_of_type_Agrt == null) {
      this.jdField_a_of_type_Agrt = agrt.a();
    }
    this.jdField_a_of_type_Agrt.a(this.bJr, new agwk(this));
    if (this.jdField_a_of_type_Agrt.mD(this.bJr)) {
      this.jdField_a_of_type_Agrt.a(this);
    }
    if (this.jdField_a_of_type_Aguk.cg()) {
      Ye();
    }
    setPlaying(amB());
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    dkd();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    refreshView();
  }
  
  public void init()
  {
    super.init();
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = music");
    }
    refreshView();
    this.jdField_a_of_type_Agxv.OL(0);
    this.jdField_a_of_type_Agxv.a(new agwi(this));
    this.jdField_a_of_type_Agxv.E(new agwj(this));
    this.jdField_a_of_type_Aguk.a(this);
  }
  
  public void onCompletion()
  {
    this.jdField_a_of_type_Agxv.Jq(ahbr.br(0L));
    this.jdField_a_of_type_Agxv.OL(0);
    setPlaying(false);
  }
  
  public void onError(String paramString)
  {
    QQToast.a(this.mContext, 0, this.mContext.getString(2131694109), 1).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
    this.jdField_a_of_type_Agxv.Jq(ahbr.br(0L));
    this.jdField_a_of_type_Agxv.OL(0);
    setPlaying(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwh
 * JD-Core Version:    0.7.0.1
 */