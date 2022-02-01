import android.app.Activity;
import android.content.res.Configuration;
import com.tencent.qphone.base.util.QLog;

public abstract class aubi
{
  public atzy a;
  protected agsa b;
  protected atyr b;
  private aucp b;
  protected boolean cfn;
  public Activity mContext;
  
  public aubi(atzy paramatzy, Activity paramActivity)
  {
    this.a = paramatzy;
    this.mContext = paramActivity;
  }
  
  public aucp a()
  {
    return this.jdField_b_of_type_Aucp;
  }
  
  public void a(agsa paramagsa)
  {
    this.jdField_b_of_type_Agsa = paramagsa;
  }
  
  protected void a(aucp paramaucp)
  {
    this.jdField_b_of_type_Aucp = paramaucp;
  }
  
  protected void aP(float paramFloat)
  {
    int i = (int)((float)this.a.getFileSize() * paramFloat);
    int j = this.a.bK();
    if (j == 1) {
      this.jdField_b_of_type_Aucp.Jn(this.mContext.getString(2131694158) + "(" + aueh.g(i) + "/" + aueh.g(this.a.getFileSize()) + ")");
    }
    for (;;)
    {
      this.jdField_b_of_type_Aucp.OJ((int)(100.0F * paramFloat));
      return;
      if (j == 4) {
        this.jdField_b_of_type_Aucp.Jn(this.mContext.getString(2131694136) + "(" + aueh.g(i) + "/" + aueh.g(this.a.getFileSize()) + ")");
      } else {
        this.jdField_b_of_type_Aucp.Jn(this.mContext.getString(2131694118) + "(" + aueh.g(i) + "/" + aueh.g(this.a.getFileSize()) + ")");
      }
    }
  }
  
  public abstract boolean amj();
  
  public abstract boolean amk();
  
  public void b(atyr paramatyr)
  {
    this.jdField_b_of_type_Atyr = paramatyr;
  }
  
  public void c(Configuration paramConfiguration) {}
  
  public void cqt() {}
  
  protected void djT()
  {
    int i = this.a.bL();
    if (i == 6)
    {
      if (this.a.bK() == 1) {}
      for (String str = "继续上传";; str = "继续下载")
      {
        this.jdField_b_of_type_Aucp.f(str + "(" + aqhp.bO(this.a.getFileSize()) + ")", new aubk(this));
        this.jdField_b_of_type_Aucp.JK(false);
        this.jdField_b_of_type_Aucp.JJ(true);
        return;
      }
    }
    if (i == 2)
    {
      this.jdField_b_of_type_Aucp.f("用其他应用打开", new aubl(this));
      this.jdField_b_of_type_Aucp.JJ(true);
      return;
    }
    if (i == 4)
    {
      this.jdField_b_of_type_Aucp.JK(true);
      aP(this.a.k());
      this.jdField_b_of_type_Aucp.JJ(false);
      return;
    }
    if (i == 5)
    {
      this.jdField_b_of_type_Aucp.JJ(false);
      return;
    }
    this.jdField_b_of_type_Aucp.f("下载(" + aqhp.bO(this.a.getFileSize()) + ")", new aubm(this));
    this.jdField_b_of_type_Aucp.JK(false);
    this.jdField_b_of_type_Aucp.JJ(true);
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
      this.jdField_b_of_type_Aucp.JK(false);
      djT();
      return;
      if ((i == 1) && (this.a.a() != null)) {
        this.a.a().djq();
      }
    }
  }
  
  public void doOnPause() {}
  
  public void doOnResume() {}
  
  public void init()
  {
    if (this.a == null) {
      QLog.w("FileBrowserPresenterBase", 4, "FileBrowserPresenter init: but model is null");
    }
    do
    {
      return;
      if (this.jdField_b_of_type_Aucp == null)
      {
        QLog.w("FileBrowserPresenterBase", 4, "FileBrowserPresenter init: but fileViewer is null");
        return;
      }
      this.jdField_b_of_type_Aucp.dkq();
      djT();
      this.jdField_b_of_type_Aucp.D(new aubj(this));
    } while (this.a.bL() != 4);
    this.jdField_b_of_type_Aucp.JK(true);
    this.jdField_b_of_type_Aucp.JJ(false);
    aP(this.a.k());
  }
  
  public String vE()
  {
    return this.a.getFileName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aubi
 * JD-Core Version:    0.7.0.1
 */