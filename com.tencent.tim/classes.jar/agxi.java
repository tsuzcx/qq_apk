import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.2;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;
import java.util.List;

public class agxi
  extends agwc
  implements aguk.c, aguk.d, aguk.e
{
  private List<agxi.a> BK = new ArrayList();
  protected agyh a;
  private boolean cfI;
  private boolean cfJ;
  private boolean isNight;
  
  public agxi(aguk paramaguk, Activity paramActivity)
  {
    super(paramaguk, paramActivity);
    this.jdField_a_of_type_Agyh = new agyh(paramActivity);
    a(this.jdField_a_of_type_Agyh);
  }
  
  private void dkm()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new ZipFilePresenter.2(this), 3000L);
  }
  
  private void dkn()
  {
    int i = this.jdField_a_of_type_Aguk.bL();
    if (i == 4)
    {
      this.jdField_a_of_type_Agyh.JK(true);
      this.jdField_a_of_type_Agyh.JY(false);
      return;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Agyh.JY(false);
      return;
    }
    if (i == 6)
    {
      this.jdField_a_of_type_Agyh.a(true, acfp.m(2131717003) + "(" + aqhp.bO(this.jdField_a_of_type_Aguk.getFileSize()) + ")", new agxm(this));
      return;
    }
    this.jdField_a_of_type_Agyh.a(true, acfp.m(2131717000) + "(" + aqhp.bO(this.jdField_a_of_type_Aguk.getFileSize()) + ")", new agxn(this));
  }
  
  private void jP(long paramLong)
  {
    this.jdField_a_of_type_Agyh.Ka(false);
    this.jdField_a_of_type_Agyh.JZ(true);
    djU();
    if (ahbj.fileExistsAndNotEmpty(this.jdField_a_of_type_Aguk.getFilePath()))
    {
      this.jdField_a_of_type_Agyh.f(acfp.m(2131694133), new agxj(this));
      this.jdField_a_of_type_Agyh.JJ(true);
    }
    while (paramLong == -1000L) {
      return;
    }
    if ((paramLong == -7003L) || (paramLong == -6101L))
    {
      this.jdField_a_of_type_Aguk.aA(16);
      this.jdField_a_of_type_Agyh.JB(this.mContext.getString(2131693595));
      this.jdField_a_of_type_Agyh.JQ(false);
      return;
    }
    this.jdField_a_of_type_Agyh.JQ(false);
  }
  
  public void a(List<agxi.a> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort)
  {
    if (!this.cfJ) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.BK = paramList;
      this.jdField_a_of_type_Agyh.a(paramList, this.jdField_a_of_type_Aguk.getFilePath(), this.jdField_a_of_type_Aguk.V(), this.jdField_a_of_type_Aguk.getUin(), paramString2, paramString3, paramString4, paramString1, paramBoolean, paramString5, paramShort);
      this.jdField_a_of_type_Agyh.JA(acfp.m(2131717001) + this.BK.size() + acfp.m(2131717002) + ahbj.g(this.jdField_a_of_type_Aguk.getFileSize()));
      dkn();
    }
    for (;;)
    {
      this.cfJ = false;
      return;
      QLog.e("ZipFilePresenter<QFile>", 1, "onGetZipFileList, mFiles is null");
      jP(-1000L);
    }
  }
  
  public void aO(float paramFloat)
  {
    this.jdField_a_of_type_Agyh.JY(false);
    this.jdField_a_of_type_Agyh.JK(true);
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
    this.jdField_a_of_type_Agyh.JY(false);
    this.jdField_a_of_type_Agyh.JJ(false);
    this.jdField_a_of_type_Agyh.JK(true);
    aP(this.jdField_a_of_type_Aguk.k());
  }
  
  public void djF()
  {
    this.jdField_a_of_type_Agyh.JY(true);
    this.jdField_a_of_type_Agyh.JK(false);
    dkn();
    djT();
    djU();
  }
  
  public void djG()
  {
    this.jdField_a_of_type_Agyh.dkE();
    this.jdField_a_of_type_Agyh.JK(false);
    if (this.b != null) {
      this.b.ir();
    }
    djT();
    djU();
  }
  
  public void djH()
  {
    djX();
    djT();
    djU();
  }
  
  protected void djU()
  {
    String str;
    if (aqhq.fileExistsAndNotEmpty(this.jdField_a_of_type_Aguk.getFilePath())) {
      if (QbSdk.isSuportOpenFile(ahav.lb(this.jdField_a_of_type_Aguk.getFileName()), 2))
      {
        str = this.mContext.getString(2131696669);
        this.jdField_a_of_type_Agyh.g(str, new agxk(this));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aguk.bL() == 4) {
        this.jdField_a_of_type_Agyh.JQ(false);
      }
      return;
      str = this.mContext.getString(2131694129);
      this.jdField_a_of_type_Agyh.g(str, new agxl(this));
    }
  }
  
  protected void djX()
  {
    int i = this.jdField_a_of_type_Aguk.bK();
    if ((i == 2) || (i == 3)) {
      if (this.jdField_a_of_type_Aguk.a() != null) {
        this.jdField_a_of_type_Aguk.a().iF();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Agyh.JK(false);
      dkn();
      djT();
      djU();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_Aguk.a() != null) {
          this.jdField_a_of_type_Aguk.a().djq();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("ZipFilePresenter<QFile>", 2, "zip file stop trans, but can not handle trans type");
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
      this.jdField_a_of_type_Agyh.fT("", "");
    }
  }
  
  public void fP(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Agyh.fT(paramString1, paramString2);
  }
  
  public void fQ(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Agyh.fS(paramString1, paramString2);
  }
  
  public void init()
  {
    super.init();
    if (QLog.isColorLevel()) {
      QLog.i("ZipFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = zip");
    }
    boolean bool;
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      bool = true;
      this.isNight = bool;
      this.jdField_a_of_type_Agyh.Kc(this.isNight);
      this.jdField_a_of_type_Agyh.Jy(this.jdField_a_of_type_Aguk.getFileName());
      this.jdField_a_of_type_Agyh.Jz(this.jdField_a_of_type_Aguk.aA());
      this.jdField_a_of_type_Agyh.JA(acfp.m(2131716999) + this.BK.size() + acfp.m(2131717004) + ahbj.g(this.jdField_a_of_type_Aguk.getFileSize()));
      this.jdField_a_of_type_Aguk.a(this);
      this.jdField_a_of_type_Aguk.a(this);
      if (aqiw.isNetworkAvailable(this.mContext)) {
        break label270;
      }
      jP(-1000L);
    }
    for (;;)
    {
      if ((!ahbj.fileExistsAndNotEmpty(this.jdField_a_of_type_Aguk.getFilePath())) && (this.jdField_a_of_type_Aguk.cn()) && (this.jdField_a_of_type_Aguk.a() != null))
      {
        aP(this.jdField_a_of_type_Aguk.k());
        this.jdField_a_of_type_Agyh.JK(true);
        this.jdField_a_of_type_Agyh.JY(false);
        this.jdField_a_of_type_Agyh.JJ(false);
        this.jdField_a_of_type_Aguk.a().iE();
      }
      this.jdField_a_of_type_Aguk.a(this);
      return;
      bool = false;
      break;
      label270:
      if (!this.cfI)
      {
        this.jdField_a_of_type_Aguk.iC();
        this.cfI = true;
        this.jdField_a_of_type_Agyh.Ka(true);
        this.cfJ = true;
        dkm();
      }
    }
  }
  
  public void jM(long paramLong)
  {
    this.cfJ = false;
    jP(paramLong);
  }
  
  public static class a
  {
    public boolean isDir;
    public String name;
    public long sessionId;
    public long size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agxi
 * JD-Core Version:    0.7.0.1
 */