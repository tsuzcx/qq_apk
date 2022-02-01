import android.app.Activity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.AdapterView.e;
import java.util.List;

public class aubs
  extends aubi
  implements atzy.c, atzy.d
{
  private List<atzy.a> BI = this.jdField_a_of_type_Atzy.u();
  protected aucr a;
  private AdapterView.e b;
  private boolean bFullScreen;
  boolean cfs = false;
  private AdapterView.c d = new aubt(this);
  private int mCurIndex = this.jdField_a_of_type_Atzy.getCurrentIndex();
  
  public aubs(atzy paramatzy, Activity paramActivity)
  {
    super(paramatzy, paramActivity);
    this.jdField_b_of_type_ComTencentWidgetAdapterView$e = new aubu(this);
    this.jdField_a_of_type_Aucr = new aucr(paramActivity);
    a(this.jdField_a_of_type_Aucr);
  }
  
  public void OH(int paramInt)
  {
    this.jdField_a_of_type_Atzy.aH(paramInt);
    if ((this.jdField_a_of_type_Atzy.cn()) && (this.jdField_a_of_type_Atzy.a() != null))
    {
      this.jdField_a_of_type_Aucr.JK(true);
      this.jdField_a_of_type_Aucr.JJ(false);
      aP(0.0F);
      this.jdField_a_of_type_Atzy.a().iE();
    }
    djT();
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
    return false;
  }
  
  public void djE()
  {
    this.jdField_a_of_type_Aucr.JJ(false);
    this.jdField_a_of_type_Aucr.JK(true);
    aP(this.jdField_a_of_type_Atzy.k());
  }
  
  public void djF()
  {
    djT();
  }
  
  public void djG()
  {
    djT();
    ((atzy.a)this.BI.get(this.jdField_a_of_type_Atzy.getCurrentIndex())).aB(this.jdField_a_of_type_Atzy.getFilePath());
    this.jdField_a_of_type_Aucr.dkt();
    this.jdField_a_of_type_Aucr.dku();
    if (this.jdField_b_of_type_Agsa != null) {
      this.jdField_b_of_type_Agsa.it();
    }
  }
  
  public void djH()
  {
    this.jdField_a_of_type_Aucr.JJ(true);
    this.jdField_a_of_type_Aucr.JK(false);
    djT();
  }
  
  protected void djT()
  {
    int i = this.jdField_a_of_type_Atzy.bL();
    if ((i == 2) || (i == 5))
    {
      this.jdField_a_of_type_Aucr.JJ(false);
      this.jdField_a_of_type_Aucr.JK(false);
      return;
    }
    if (i == 6)
    {
      this.jdField_a_of_type_Aucr.JJ(true);
      this.jdField_a_of_type_Aucr.JK(false);
    }
    super.djT();
  }
  
  public void fP(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (QLog.isColorLevel()) {
        QLog.e("FileBrowserPresenterBase", 1, "onThumbDownload error : picture fileid is null!");
      }
    }
    atzy.a locala;
    do
    {
      return;
      locala = (atzy.a)this.BI.get(this.jdField_a_of_type_Atzy.getCurrentIndex());
    } while (!locala.S(paramString1));
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileBrowserPresenterBase", 1, "onThumbDownload error : picture thumbPath is null!");
      }
      locala.setState(3);
      return;
    }
    locala.aA(paramString2);
    locala.setState(2);
    this.jdField_a_of_type_Aucr.dkt();
  }
  
  public void init()
  {
    super.init();
    QLog.w("FileBrowserPresenterBase", 4, "FileBrowserPresenter init: type = picture");
    if ((this.BI != null) && (this.BI.get(this.mCurIndex) != null) && (this.jdField_a_of_type_Atzy.ci())) {
      auds.JE(BaseApplicationImpl.getContext().getString(2131693595));
    }
    this.jdField_a_of_type_Aucr.kN(this.BI);
    this.jdField_a_of_type_Aucr.a(this.d);
    this.jdField_a_of_type_Aucr.a(this.jdField_b_of_type_ComTencentWidgetAdapterView$e);
    this.jdField_a_of_type_Aucr.ON(this.jdField_a_of_type_Atzy.getCurrentIndex());
    djT();
    this.jdField_a_of_type_Atzy.a(this);
    this.jdField_a_of_type_Atzy.a(this);
  }
  
  public String vE()
  {
    return this.jdField_a_of_type_Atzy.getFileName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aubs
 * JD-Core Version:    0.7.0.1
 */