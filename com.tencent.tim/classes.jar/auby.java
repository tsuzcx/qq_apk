import android.app.Activity;
import android.content.res.Configuration;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;

public class auby
  extends aubi
  implements atzy.d
{
  protected aucs a;
  private aulg a;
  private atxy.a b;
  protected boolean cfm = true;
  private SpannableString k;
  
  public auby(atzy paramatzy, Activity paramActivity)
  {
    super(paramatzy, paramActivity);
    this.jdField_a_of_type_Aulg = new aubz(this);
    this.jdField_b_of_type_Atxy$a = new aucb(this);
    this.jdField_a_of_type_Aucs = new aucs(this.mContext);
    a(this.jdField_a_of_type_Aucs);
  }
  
  public void aO(float paramFloat)
  {
    aP(paramFloat);
  }
  
  public boolean amj()
  {
    return (!this.cfm) || (!this.cfm);
  }
  
  public boolean amk()
  {
    return this.cfm;
  }
  
  public void c(Configuration paramConfiguration)
  {
    super.c(paramConfiguration);
    paramConfiguration = new DisplayMetrics();
    this.mContext.getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    int i = paramConfiguration.widthPixels;
    int j = paramConfiguration.heightPixels;
    this.jdField_a_of_type_Aucs.ig(i, j);
  }
  
  public void cqt()
  {
    if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Aulg);
    }
    if (this.jdField_a_of_type_Aucs != null) {
      this.jdField_a_of_type_Aucs.dkx();
    }
    super.cqt();
  }
  
  public void djE()
  {
    this.jdField_a_of_type_Aucs.JJ(false);
    this.jdField_a_of_type_Aucs.JK(true);
    aP(this.jdField_a_of_type_Atzy.k());
  }
  
  public void djF()
  {
    this.jdField_a_of_type_Aucs.JJ(true);
    this.jdField_a_of_type_Aucs.JK(false);
    djT();
  }
  
  public void djG()
  {
    this.jdField_a_of_type_Aucs.JJ(true);
    this.jdField_a_of_type_Aucs.JK(false);
    djT();
    if (this.jdField_b_of_type_Agsa != null) {
      this.jdField_b_of_type_Agsa.ir();
    }
  }
  
  public void djH()
  {
    djX();
  }
  
  protected void djR()
  {
    int i = this.jdField_a_of_type_Atzy.getFileType();
    if (i == 5)
    {
      this.jdField_a_of_type_Aucs.OP(2130845117);
      this.jdField_a_of_type_Aucs.Ju(this.jdField_a_of_type_Atzy.aB());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Atzy.aC())) && (16 != this.jdField_a_of_type_Atzy.bF())) {
        break label141;
      }
      this.jdField_a_of_type_Aucs.JR(false);
      label69:
      if (i != 1) {
        break label158;
      }
      this.jdField_a_of_type_Aucs.Jt(BaseApplicationImpl.getContext().getString(2131694107));
      label89:
      if (this.jdField_a_of_type_Atzy.bF() != 16) {
        break label199;
      }
      this.jdField_a_of_type_Aucs.Jt(BaseApplicationImpl.getContext().getString(2131693595));
      euF();
    }
    label141:
    label158:
    label199:
    do
    {
      return;
      this.jdField_a_of_type_Aucs.OO(audx.r(this.jdField_a_of_type_Atzy.getFileName()));
      break;
      this.jdField_a_of_type_Aucs.Js(this.jdField_a_of_type_Atzy.aC());
      break label69;
      if (i == 2)
      {
        this.jdField_a_of_type_Aucs.Jt(BaseApplicationImpl.getContext().getString(2131694111));
        break label89;
      }
      this.jdField_a_of_type_Aucs.Jt(BaseApplicationImpl.getContext().getString(2131694108));
      break label89;
      if (this.jdField_a_of_type_Atzy.isFromProcessingForward2c2cOrDiscItem())
      {
        this.jdField_a_of_type_Aucs.Jt(BaseApplicationImpl.getContext().getString(2131693824));
        return;
      }
      if ((this.jdField_a_of_type_Atzy.ci()) && (this.jdField_a_of_type_Atzy.bG() != 9))
      {
        this.jdField_a_of_type_Aucs.Jt(BaseApplicationImpl.getContext().getString(2131693595));
        return;
      }
    } while ((!this.jdField_a_of_type_Atzy.cn()) || (this.jdField_a_of_type_Atzy.a() == null));
    this.jdField_a_of_type_Atzy.a().iE();
    this.jdField_a_of_type_Aucs.JK(true);
    this.jdField_a_of_type_Aucs.JJ(false);
    aP(0.0F);
  }
  
  protected void djW()
  {
    if ((this.jdField_a_of_type_Atzy.bL() == 2) && (this.jdField_a_of_type_Atzy.bL() == 2)) {
      atxy.a().a(this.mContext, this.jdField_a_of_type_Atzy.getFilePath(), this.jdField_b_of_type_Atxy$a, true);
    }
    this.jdField_a_of_type_Aucs.OO(audx.r(this.jdField_a_of_type_Atzy.getFileName()));
    this.jdField_a_of_type_Aucs.Js(this.jdField_a_of_type_Atzy.aA());
    this.mContext.getString(2131693595);
    String str;
    if (this.jdField_a_of_type_Atzy.bF() == 16)
    {
      str = BaseApplicationImpl.getContext().getString(2131693595);
      this.jdField_a_of_type_Aucs.Jt(str);
      euF();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aucs.showTip(true);
      return;
      if (QbSdk.isSuportOpenFile(audx.lb(this.jdField_a_of_type_Atzy.getFileName()), 2))
      {
        this.k = audx.a(BaseApplicationImpl.getContext().getString(2131694127), BaseApplicationImpl.getContext().getString(2131696669), new auca(this));
        this.jdField_a_of_type_Aucs.a(this.k);
      }
      else
      {
        str = BaseApplicationImpl.getContext().getString(2131694126);
        this.jdField_a_of_type_Aucs.Jt(str);
      }
    }
  }
  
  protected void euF()
  {
    Object localObject = (CardHandler)this.jdField_b_of_type_Agsa.getApp().getBusinessHandler(2);
    if (aqmj.ac(this.jdField_b_of_type_Agsa.getApp(), "tim_cloudfile_autosave_flag")) {
      return;
    }
    localObject = audx.a(BaseApplicationImpl.getContext().getString(2131693816), BaseApplicationImpl.getContext().getString(2131693815), new aucc(this));
    this.jdField_a_of_type_Aucs.b((SpannableString)localObject);
    this.jdField_a_of_type_Aucs.VG(true);
  }
  
  public void init()
  {
    super.init();
    QLog.w("SimpleFilePresenter", 4, "FileBrowserPresenter init: type = simple");
    this.jdField_a_of_type_Atzy.a(this);
    this.jdField_a_of_type_Aucs.Jr(this.jdField_a_of_type_Atzy.getFileName());
    this.jdField_a_of_type_Aucs.VG(false);
    if (audx.isLocalFile(this.jdField_a_of_type_Atzy.getFilePath())) {
      djW();
    }
    for (;;)
    {
      if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
        ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.jdField_a_of_type_Aulg);
      }
      return;
      djR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auby
 * JD-Core Version:    0.7.0.1
 */