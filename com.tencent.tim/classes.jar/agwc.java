import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public abstract class agwc
  implements agxu.a
{
  public aguk a;
  public agsa b;
  protected agsb b;
  private agxu b;
  protected Bundle ba;
  protected boolean cfn;
  protected boolean cfo;
  private boolean cfp = true;
  public Activity mContext;
  
  public agwc(aguk paramaguk, Activity paramActivity)
  {
    this.a = paramaguk;
    this.mContext = paramActivity;
  }
  
  public agxu a()
  {
    return this.jdField_b_of_type_Agxu;
  }
  
  public void a(agsa paramagsa)
  {
    this.jdField_b_of_type_Agsa = paramagsa;
  }
  
  protected void a(agxu paramagxu)
  {
    this.jdField_b_of_type_Agxu = paramagxu;
  }
  
  protected void aP(float paramFloat)
  {
    int i = (int)((float)this.a.getFileSize() * paramFloat);
    int j = this.a.bK();
    if (j == 1) {
      this.jdField_b_of_type_Agxu.Jn(this.mContext.getString(2131694158) + "(" + ahbj.g(i) + "/" + ahbj.g(this.a.getFileSize()) + ")");
    }
    for (;;)
    {
      this.jdField_b_of_type_Agxu.OJ((int)(100.0F * paramFloat));
      return;
      if (j == 4) {
        this.jdField_b_of_type_Agxu.Jn(this.mContext.getString(2131694136) + "(" + ahbj.g(i) + "/" + ahbj.g(this.a.getFileSize()) + ")");
      } else {
        this.jdField_b_of_type_Agxu.Jn(this.mContext.getString(2131694118) + "(" + ahbj.g(i) + "/" + ahbj.g(this.a.getFileSize()) + ")");
      }
    }
  }
  
  public abstract boolean amj();
  
  public abstract boolean amk();
  
  public void b(agsb paramagsb)
  {
    this.jdField_b_of_type_Agsb = paramagsb;
  }
  
  public void c(Configuration paramConfiguration) {}
  
  public void cB(Bundle paramBundle)
  {
    this.ba = paramBundle;
  }
  
  public void cqt() {}
  
  protected void djT()
  {
    this.cfo = false;
    this.cfn = false;
    int i = this.a.bL();
    Object localObject;
    if (i == 6)
    {
      this.mContext.getString(2131693616);
      if (this.a.bK() == 1) {}
      for (localObject = this.mContext.getString(2131693617);; localObject = this.mContext.getString(2131693616))
      {
        this.jdField_b_of_type_Agxu.f((String)localObject + "(" + aqhp.bO(this.a.getFileSize()) + ")", new agwe(this));
        this.jdField_b_of_type_Agxu.JK(false);
        this.jdField_b_of_type_Agxu.JJ(true);
        return;
        this.cfo = true;
      }
    }
    if (i == 2)
    {
      this.jdField_b_of_type_Agxu.f(acfp.m(2131706211), new agwf(this));
      this.jdField_b_of_type_Agxu.JJ(true);
      return;
    }
    if (i == 4)
    {
      this.jdField_b_of_type_Agxu.JK(true);
      aP(this.a.k());
      this.jdField_b_of_type_Agxu.JJ(false);
      return;
    }
    if (i == 5)
    {
      this.jdField_b_of_type_Agxu.JJ(false);
      return;
    }
    if ((this.a.bH() == 9501) && (aqiw.isWifiConnected(this.mContext)))
    {
      localObject = this.a.a();
      if (localObject != null) {
        ((agss)localObject).iE();
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Agxu.JK(false);
      this.jdField_b_of_type_Agxu.JJ(true);
      return;
      this.cfo = true;
      this.jdField_b_of_type_Agxu.f(acfp.m(2131706208) + aqhp.bO(this.a.getFileSize()) + ")", new agwg(this));
    }
  }
  
  protected void djX()
  {
    int i = this.a.bK();
    if ((i == 2) || (i == 4)) {
      if (this.a.a() != null) {
        this.a.a().iF();
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Agxu.JK(false);
      djT();
      return;
      if ((i == 1) && (this.a.a() != null)) {
        this.a.a().djq();
      }
    }
  }
  
  protected void djY()
  {
    this.mContext.finish();
    this.mContext.overridePendingTransition(0, 0);
  }
  
  public void djZ()
  {
    djY();
  }
  
  public void dka() {}
  
  public void doBeforeFinish() {}
  
  public void doOnPause() {}
  
  public void doOnResume() {}
  
  public void init()
  {
    if (this.a == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but model is null");
      return;
    }
    if (this.jdField_b_of_type_Agxu == null)
    {
      QLog.w("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: but fileViewer is null");
      return;
    }
    this.jdField_b_of_type_Agxu.cB(this.ba);
    this.jdField_b_of_type_Agxu.dkq();
    djT();
    this.jdField_b_of_type_Agxu.D(new agwd(this));
    if (this.a.bL() == 4)
    {
      this.jdField_b_of_type_Agxu.JK(true);
      this.jdField_b_of_type_Agxu.JJ(false);
      aP(this.a.k());
    }
    this.jdField_b_of_type_Agxu.a(this);
    if ((!this.a.cn()) && (this.cfp) && (this.cfo)) {
      anot.a(null, "dc00898", "", "", "0X800A687", "0X800A687", 0, 0, "", "", "", "");
    }
    this.cfp = false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public String vE()
  {
    return this.a.getFileName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwc
 * JD-Core Version:    0.7.0.1
 */