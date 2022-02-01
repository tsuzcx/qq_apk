import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aucj
  extends aubi
  implements atzy.c, atzy.d, atzy.e
{
  private List<agxi.a> BK = new ArrayList();
  protected auda a;
  private boolean cfI;
  private boolean isNight;
  
  public aucj(atzy paramatzy, Activity paramActivity)
  {
    super(paramatzy, paramActivity);
    this.jdField_a_of_type_Auda = new auda(paramActivity);
    a(this.jdField_a_of_type_Auda);
  }
  
  private void dkn()
  {
    int i = this.jdField_a_of_type_Atzy.bL();
    if (i == 4)
    {
      this.jdField_a_of_type_Auda.JK(true);
      this.jdField_a_of_type_Auda.JY(false);
      return;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Auda.JY(false);
      return;
    }
    if (i == 6)
    {
      this.jdField_a_of_type_Auda.a(true, "继续下载(" + aqhp.bO(this.jdField_a_of_type_Atzy.getFileSize()) + ")", new aucn(this));
      return;
    }
    this.jdField_a_of_type_Auda.a(true, "下载(" + aqhp.bO(this.jdField_a_of_type_Atzy.getFileSize()) + ")", new auco(this));
  }
  
  private void jP(long paramLong)
  {
    if (aueh.fileExistsAndNotEmpty(this.jdField_a_of_type_Atzy.getFilePath()))
    {
      this.jdField_a_of_type_Auda.b(true, new auck(this));
      this.jdField_a_of_type_Auda.f("用其他应用打开", new aucl(this));
      this.jdField_a_of_type_Auda.JJ(true);
      SpannableString localSpannableString = audx.a(this.mContext.getString(2131694127), "用QQ浏览器打开", new aucm(this));
      this.jdField_a_of_type_Auda.a(localSpannableString, LinkMovementMethod.getInstance());
      return;
    }
    if ((paramLong == -7003L) || (paramLong == -6101L))
    {
      this.jdField_a_of_type_Atzy.aA(16);
      this.jdField_a_of_type_Auda.a(this.mContext.getString(2131693595), null);
    }
    for (;;)
    {
      this.jdField_a_of_type_Auda.b(false, null);
      return;
      this.jdField_a_of_type_Auda.a(this.mContext.getString(2131721519), null);
    }
  }
  
  public void aO(float paramFloat)
  {
    this.jdField_a_of_type_Auda.JY(false);
    this.jdField_a_of_type_Auda.JK(true);
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
  
  public void b(List<agxi.a> paramList, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramList != null)
    {
      this.BK = paramList;
      this.jdField_a_of_type_Auda.a(paramList, this.jdField_a_of_type_Atzy.getFilePath(), this.jdField_a_of_type_Atzy.V(), this.jdField_a_of_type_Atzy.getUin(), paramString2, paramString3, paramString4, paramString1);
      this.jdField_a_of_type_Auda.JA("共" + this.BK.size() + "项  " + aueh.g(this.jdField_a_of_type_Atzy.getFileSize()));
      return;
    }
    QLog.e("FileBrowserPresenterBase", 1, "onGetZipFileList, mFiles is null");
    jP(1L);
  }
  
  public void djE()
  {
    this.jdField_a_of_type_Auda.JY(false);
    this.jdField_a_of_type_Auda.JK(true);
    aP(this.jdField_a_of_type_Atzy.k());
  }
  
  public void djF()
  {
    this.jdField_a_of_type_Auda.JY(true);
    this.jdField_a_of_type_Auda.JK(false);
    dkn();
  }
  
  public void djG()
  {
    this.jdField_a_of_type_Auda.dkE();
    this.jdField_a_of_type_Auda.JK(false);
    if (this.b != null) {
      this.b.ir();
    }
  }
  
  public void djH()
  {
    djX();
  }
  
  protected void djX()
  {
    int i = this.jdField_a_of_type_Atzy.bK();
    if ((i == 2) || (i == 3)) {
      if (this.jdField_a_of_type_Atzy.a() != null) {
        this.jdField_a_of_type_Atzy.a().iF();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Auda.JK(false);
      dkn();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_Atzy.a() != null) {
          this.jdField_a_of_type_Atzy.a().djq();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserPresenterBase", 2, "zip file stop trans, but can not handle trans type");
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if (this.cfI) {
      this.jdField_a_of_type_Auda.fT("", "");
    }
  }
  
  public void fP(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Auda.fT(paramString1, paramString2);
  }
  
  public void fQ(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Auda.fS(paramString1, paramString2);
  }
  
  public void init()
  {
    super.init();
    QLog.w("FileBrowserPresenterBase", 4, "FileBrowserPresenter init: type = zip");
    boolean bool;
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      bool = true;
      this.isNight = bool;
      this.jdField_a_of_type_Auda.Jy(this.jdField_a_of_type_Atzy.getFileName());
      this.jdField_a_of_type_Auda.JA("共" + this.BK.size() + "项  " + aueh.g(this.jdField_a_of_type_Atzy.getFileSize()));
      this.jdField_a_of_type_Auda.Kc(this.isNight);
      this.jdField_a_of_type_Atzy.a(this);
      this.jdField_a_of_type_Atzy.a(this);
      dkn();
      if (aqiw.isNetworkAvailable(this.mContext)) {
        break label276;
      }
      QQToast.a(this.mContext, 1, this.mContext.getString(2131693404), 1).show(this.jdField_a_of_type_Atzy.getTitleBarHeight());
    }
    for (;;)
    {
      if (aueh.fileExistsAndNotEmpty(this.jdField_a_of_type_Atzy.getFilePath()))
      {
        this.jdField_a_of_type_Auda.dkE();
        this.jdField_a_of_type_Auda.JK(false);
      }
      if ((this.jdField_a_of_type_Atzy.cn()) && (this.jdField_a_of_type_Atzy.a() != null))
      {
        aP(this.jdField_a_of_type_Atzy.k());
        this.jdField_a_of_type_Auda.JK(true);
        this.jdField_a_of_type_Auda.JY(false);
        this.jdField_a_of_type_Atzy.a().iE();
      }
      this.jdField_a_of_type_Atzy.a(this);
      return;
      bool = false;
      break;
      label276:
      if (!this.cfI)
      {
        this.jdField_a_of_type_Atzy.iC();
        this.cfI = true;
      }
    }
  }
  
  public void jM(long paramLong)
  {
    jP(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aucj
 * JD-Core Version:    0.7.0.1
 */