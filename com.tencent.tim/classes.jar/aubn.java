import android.app.Activity;
import android.content.res.Resources;
import android.text.format.Time;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.fileviewer.presenter.MusicFilePresenter.3;
import com.tencent.tim.filemanager.fileviewer.presenter.MusicFilePresenter.5;
import java.util.Timer;

public class aubn
  extends aubi
  implements atys, atzy.d
{
  public atyk a;
  public aucq a;
  private String bJr;
  private boolean cfq;
  private Timer mTimer;
  
  public aubn(atzy paramatzy, Activity paramActivity)
  {
    super(paramatzy, paramActivity);
    this.jdField_a_of_type_Aucq = new aucq(paramActivity);
    a(this.jdField_a_of_type_Aucq);
  }
  
  private void Ye()
  {
    audw.JH("0X8004BE0");
    if (!this.jdField_a_of_type_Atyk.mD(this.bJr))
    {
      this.jdField_a_of_type_Atyk.a(this);
      if (!this.jdField_a_of_type_Atyk.init(this.bJr)) {
        return;
      }
    }
    this.jdField_a_of_type_Atyk.start();
    setPlaying(true);
  }
  
  private void Zx()
  {
    audw.JH("0X8004BE1");
    this.jdField_a_of_type_Atyk.pause();
    setPlaying(false);
  }
  
  private boolean amB()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Atyk != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Atyk.mD(this.bJr))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Atyk.isPlaying()) {
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
    this.jdField_a_of_type_Aucq.Jr(this.jdField_a_of_type_Atzy.getFileName());
    this.jdField_a_of_type_Aucq.Js(aueh.g(this.jdField_a_of_type_Atzy.getFileSize()));
    this.jdField_a_of_type_Aucq.dks();
    djT();
    this.bJr = this.jdField_a_of_type_Atzy.getFilePath();
    dkb();
    this.jdField_a_of_type_Aucq.JL(true);
    if (this.jdField_a_of_type_Atyk.mD(this.bJr))
    {
      OB(this.jdField_a_of_type_Atyk.getCurrentPosition());
      return;
    }
    this.jdField_a_of_type_Aucq.Jq("00:00");
  }
  
  private void setPlaying(boolean paramBoolean)
  {
    this.cfq = paramBoolean;
    if (this.cfq)
    {
      int i = this.jdField_a_of_type_Atyk.getCurrentPosition();
      OB(i);
      this.jdField_a_of_type_Aucq.OL(i);
      dkc();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aucq.JM(this.cfq);
      return;
      dkd();
    }
  }
  
  public void OA(int paramInt)
  {
    Object localObject = new Time();
    ((Time)localObject).set(paramInt);
    localObject = ((Time)localObject).format("%M:%S");
    this.mContext.runOnUiThread(new MusicFilePresenter.3(this, (String)localObject, paramInt));
  }
  
  public void OB(int paramInt)
  {
    Time localTime = new Time();
    localTime.set(paramInt);
    this.jdField_a_of_type_Aucq.Jq(localTime.format("%M:%S"));
  }
  
  public void aO(float paramFloat)
  {
    aP(paramFloat);
  }
  
  public boolean amj()
  {
    return false;
  }
  
  public boolean amk()
  {
    return true;
  }
  
  public void cqt()
  {
    super.cqt();
    if (this.jdField_a_of_type_Atyk != null) {
      this.jdField_a_of_type_Atyk.a(null);
    }
    dkd();
    if ((this.cfq) && (this.jdField_a_of_type_Atyk != null) && (this.jdField_a_of_type_Atyk.mD(this.bJr))) {
      this.jdField_a_of_type_Atyk.stop();
    }
    this.jdField_a_of_type_Atyk = null;
  }
  
  public void djE()
  {
    this.jdField_a_of_type_Aucq.JJ(false);
    this.jdField_a_of_type_Aucq.JK(true);
    aP(this.jdField_a_of_type_Atzy.k());
  }
  
  public void djF()
  {
    this.jdField_a_of_type_Aucq.JJ(true);
    this.jdField_a_of_type_Aucq.JK(false);
    djT();
  }
  
  public void djG()
  {
    this.jdField_a_of_type_Aucq.JJ(true);
    this.jdField_a_of_type_Aucq.JK(false);
    djT();
    if (this.b != null) {
      this.b.ir();
    }
  }
  
  public void djH()
  {
    this.jdField_a_of_type_Aucq.JJ(true);
    this.jdField_a_of_type_Aucq.JK(false);
    djT();
  }
  
  protected void djT()
  {
    super.djT();
    if (this.jdField_a_of_type_Atzy.bL() == 2) {
      this.jdField_a_of_type_Aucq.JJ(false);
    }
  }
  
  public void dkb()
  {
    this.bJr = this.jdField_a_of_type_Atzy.getFilePath();
    if (this.jdField_a_of_type_Atyk == null) {
      this.jdField_a_of_type_Atyk = atyk.a();
    }
    this.jdField_a_of_type_Atyk.a(this.bJr, new aubq(this));
    if (this.jdField_a_of_type_Atyk.mD(this.bJr)) {
      this.jdField_a_of_type_Atyk.a(this);
    }
    if (this.jdField_a_of_type_Atzy.cg()) {
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
    QLog.w("FileBrowserPresenterBase", 4, "FileBrowserPresenter init: type = music");
    this.jdField_a_of_type_Aucq.OL(0);
    this.jdField_a_of_type_Aucq.a(new aubo(this));
    this.jdField_a_of_type_Aucq.E(new aubp(this));
    this.jdField_a_of_type_Atzy.a(this);
    refreshView();
  }
  
  public void onCompletion()
  {
    this.jdField_a_of_type_Aucq.Jq("00:00");
    this.jdField_a_of_type_Aucq.OL(0);
    setPlaying(false);
  }
  
  public void onError(String paramString)
  {
    QQToast.a(this.mContext, 0, this.mContext.getString(2131694109), 1).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
    this.jdField_a_of_type_Aucq.Jq("00:00");
    this.jdField_a_of_type_Aucq.OL(0);
    setPlaying(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aubn
 * JD-Core Version:    0.7.0.1
 */