import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.AdapterView.e;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import java.util.List;

public class agwn
  extends agwc
  implements aguk.c, aguk.d
{
  private List<aguk.a> BI = this.jdField_a_of_type_Aguk.u();
  protected agxw a;
  private AdapterView.e b;
  private boolean bFullScreen;
  boolean cfs = false;
  private AdapterView.c d = new agwq(this);
  private int eY = this.jdField_a_of_type_Aguk.getCurrentIndex();
  private View.OnClickListener fb = new agwp(this);
  private int mCurIndex = this.jdField_a_of_type_Aguk.getCurrentIndex();
  
  public agwn(aguk paramaguk, Activity paramActivity)
  {
    super(paramaguk, paramActivity);
    this.jdField_b_of_type_ComTencentWidgetAdapterView$e = new agwr(this);
    this.jdField_a_of_type_Agxw = new agxw(paramActivity);
    a(this.jdField_a_of_type_Agxw);
  }
  
  private void dkf()
  {
    Object localObject = vQ();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.i("PictureFilePresenter<QFile>", 1, "startEditPicture. but file path is null.");
      return;
    }
    localObject = EditPicActivity.a(this.mContext, (String)localObject, true, true, true, true, true, 2, 130, 7);
    ((Intent)localObject).putExtra("open_chatfragment", true);
    ((Intent)localObject).putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1041);
    ((Intent)localObject).putExtra("key_enable_edit_title_bar", true);
    ((Intent)localObject).putExtra("key_help_forward_pic", true);
    ((Intent)localObject).putExtra("key_allow_multiple_forward_from_limit", false);
    this.mContext.startActivity((Intent)localObject);
    int i;
    switch (this.jdField_a_of_type_Aguk.EJ())
    {
    case 5: 
    case 6: 
    case 10: 
    default: 
      i = 0;
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X800A1E2", "0X800A1E2", i, 0, "", "", "", "");
      this.mContext.overridePendingTransition(2130772077, 2130772079);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  private boolean mE(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  private String vQ()
  {
    aguk.a locala = (aguk.a)this.BI.get(this.jdField_a_of_type_Aguk.getCurrentIndex());
    if (locala == null) {
      return null;
    }
    String str = locala.av();
    if (TextUtils.isEmpty(str)) {
      return locala.aw();
    }
    return str;
  }
  
  public void OH(int paramInt)
  {
    this.jdField_a_of_type_Aguk.aH(paramInt);
    if ((this.jdField_a_of_type_Aguk.cn()) && (this.jdField_a_of_type_Aguk.a() != null))
    {
      this.jdField_a_of_type_Agxw.JK(true);
      this.jdField_a_of_type_Agxw.JJ(false);
      aP(0.0F);
      this.jdField_a_of_type_Aguk.a().iE();
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
    this.jdField_a_of_type_Agxw.JJ(false);
    this.jdField_a_of_type_Agxw.JK(true);
    aP(this.jdField_a_of_type_Aguk.k());
  }
  
  public void djF()
  {
    djT();
  }
  
  public void djG()
  {
    djT();
    ((aguk.a)this.BI.get(this.jdField_a_of_type_Aguk.getCurrentIndex())).aB(this.jdField_a_of_type_Aguk.getFilePath());
    this.jdField_a_of_type_Agxw.dkt();
    this.jdField_a_of_type_Agxw.dku();
    if (this.jdField_b_of_type_Agsa != null) {
      this.jdField_b_of_type_Agsa.it();
    }
  }
  
  public void djH()
  {
    this.jdField_a_of_type_Agxw.JJ(true);
    this.jdField_a_of_type_Agxw.JK(false);
    djT();
  }
  
  protected void djT()
  {
    int i = this.jdField_a_of_type_Aguk.bL();
    if ((i == 2) || (i == 5))
    {
      this.jdField_a_of_type_Agxw.JJ(false);
      this.jdField_a_of_type_Agxw.JK(false);
    }
    do
    {
      return;
      if (i == 6)
      {
        this.jdField_a_of_type_Agxw.JJ(true);
        this.jdField_a_of_type_Agxw.JK(false);
      }
      super.djT();
    } while (this.jdField_a_of_type_Aguk.bH() != 9501);
    this.jdField_a_of_type_Agxw.dkr();
  }
  
  public void fP(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      if (QLog.isColorLevel()) {
        QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload error : picture fileid is null!");
      }
    }
    aguk.a locala;
    do
    {
      return;
      locala = (aguk.a)this.BI.get(this.jdField_a_of_type_Aguk.getCurrentIndex());
    } while (!locala.S(paramString1));
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload error : picture thumbPath is null!");
      }
      locala.setState(3);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("PictureFilePresenter<QFile>", 1, "PictureFilePresenter onThumbDownload suc : fileId[" + paramString1 + "] thumbPath[" + paramString2 + "]");
    }
    locala.aA(paramString2);
    locala.setState(2);
    this.jdField_a_of_type_Agxw.dkt();
  }
  
  public void init()
  {
    super.init();
    if (QLog.isColorLevel()) {
      QLog.w("PictureFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = picture");
    }
    if ((this.BI != null) && (this.BI.get(this.mCurIndex) != null) && (this.jdField_a_of_type_Aguk.ci()))
    {
      this.jdField_a_of_type_Agxw.JN(mE(vQ()));
      ahao.JE(BaseApplicationImpl.getContext().getString(2131693595));
    }
    this.jdField_a_of_type_Agxw.kN(this.BI);
    this.jdField_a_of_type_Agxw.a(this.d);
    this.jdField_a_of_type_Agxw.a(new agwo(this));
    this.jdField_a_of_type_Agxw.a(this.jdField_b_of_type_ComTencentWidgetAdapterView$e);
    this.jdField_a_of_type_Agxw.F(this.fb);
    this.jdField_a_of_type_Agxw.ON(this.jdField_a_of_type_Aguk.getCurrentIndex());
    djT();
    this.jdField_a_of_type_Aguk.a(this);
    this.jdField_a_of_type_Aguk.a(this);
  }
  
  public String vE()
  {
    return this.jdField_a_of_type_Aguk.getFileName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwn
 * JD-Core Version:    0.7.0.1
 */