import android.app.Activity;
import android.content.res.Configuration;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.DocExportFilePresenter.1;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import mqq.os.MqqHandler;

public class agvz
  extends agwc
  implements aguk.d
{
  protected SimpleFileViewer a;
  private agrd.a b;
  protected boolean cfm = true;
  private SpannableString k;
  
  public agvz(aguk paramaguk, Activity paramActivity)
  {
    super(paramaguk, paramActivity);
    this.jdField_b_of_type_Agrd$a = new agwb(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer = new SimpleFileViewer(this.mContext);
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer);
  }
  
  public void aO(float paramFloat)
  {
    aP(paramFloat);
  }
  
  protected void aP(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jn(acfp.m(2131705184) + (int)paramFloat + "%");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.OJ((int)paramFloat);
  }
  
  public boolean amj()
  {
    if (this.cfm) {
      this.mContext.setRequestedOrientation(1);
    }
    return !this.cfm;
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.ig(i, j);
  }
  
  public void cqt()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.dkx();
    }
    super.cqt();
  }
  
  public void djE()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JJ(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JK(true);
    aP(this.jdField_a_of_type_Aguk.k());
  }
  
  public void djF()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JJ(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JK(false);
    djT();
  }
  
  public void djG()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JJ(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JK(false);
    djT();
    if (this.jdField_b_of_type_Agsa != null) {
      this.jdField_b_of_type_Agsa.ir();
    }
  }
  
  public void djH()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JK(false);
    djT();
  }
  
  protected void djR()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleCloudFile: fileName[" + this.jdField_a_of_type_Aguk.getFileName() + "]");
    }
    int i = this.jdField_a_of_type_Aguk.getFileType();
    if (i == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.OP(2130845117);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Ju(this.jdField_a_of_type_Aguk.aB());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Aguk.aC())) && (16 != this.jdField_a_of_type_Aguk.bF())) {
        break label179;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JR(false);
      label111:
      if (i != 1) {
        break label196;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(BaseApplicationImpl.getContext().getString(2131694107));
      label131:
      if (this.jdField_a_of_type_Aguk.bF() != 16) {
        break label237;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(BaseApplicationImpl.getContext().getString(2131693595));
    }
    label179:
    label196:
    label237:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.OO(ahav.r(this.jdField_a_of_type_Aguk.getFileName()));
      break;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Js(this.jdField_a_of_type_Aguk.aC());
      break label111;
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(BaseApplicationImpl.getContext().getString(2131694111));
        break label131;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(BaseApplicationImpl.getContext().getString(2131694108));
      break label131;
      if (this.jdField_a_of_type_Aguk.isFromProcessingForward2c2cOrDiscItem())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(BaseApplicationImpl.getContext().getString(2131693824));
        return;
      }
      if (this.jdField_a_of_type_Aguk.ci())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(BaseApplicationImpl.getContext().getString(2131693595));
        return;
      }
    } while ((!this.jdField_a_of_type_Aguk.cn()) || (this.jdField_a_of_type_Aguk.a() == null));
    this.jdField_a_of_type_Aguk.a().iE();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JK(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JJ(false);
    aP(0.0F);
  }
  
  protected void djW()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleLocalFile: fileName[" + this.jdField_a_of_type_Aguk.getFileName() + "] filePath[" + this.jdField_a_of_type_Aguk.getFilePath() + "]");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.ca();
    if ((localObject != null) && (((View)localObject).getParent() != null) && (((View)localObject).getParent().getParent() != null) && (this.jdField_b_of_type_Agsa != null) && (this.jdField_b_of_type_Agsa.getApp() != null) && (this.jdField_b_of_type_Agsa.getApp().getCurrentUin() != null) && (aqmj.aQ(this.mContext, this.jdField_b_of_type_Agsa.getApp().getCurrentUin())) && (((View)localObject).getParent() != null) && (((View)localObject).getParent().getParent() != null))
    {
      localObject = ((ViewGroup)((View)localObject).getParent().getParent()).findViewById(2131377953);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        aqmj.A(this.mContext, this.jdField_b_of_type_Agsa.getApp().getCurrentUin(), false);
        new MqqHandler().postDelayed(new DocExportFilePresenter.1(this, (View)localObject), 5000L);
      }
    }
    if (this.jdField_a_of_type_Aguk.bL() == 2) {
      agrd.a().a(this.mContext, this.jdField_a_of_type_Aguk.getFilePath(), this.jdField_b_of_type_Agrd$a, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.OO(ahav.r(this.jdField_a_of_type_Aguk.getFileName()));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Js(this.jdField_a_of_type_Aguk.aA());
    this.mContext.getString(2131693595);
    if (this.jdField_a_of_type_Aguk.bF() == 16)
    {
      localObject = BaseApplicationImpl.getContext().getString(2131693595);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt((String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.showTip(true);
      return;
    }
    if (QbSdk.isSuportOpenFile(ahav.lb(this.jdField_a_of_type_Aguk.getFileName()), 2))
    {
      this.k = ahav.a(BaseApplicationImpl.getContext().getString(2131694127), BaseApplicationImpl.getContext().getString(2131696669), new agwa(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.k);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.showTip(true);
      return;
      localObject = BaseApplicationImpl.getContext().getString(2131694126);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt((String)localObject);
    }
  }
  
  public void init()
  {
    super.init();
    if (QLog.isColorLevel()) {
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = simple");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jr(this.jdField_a_of_type_Aguk.getFileName());
    if (ahav.isLocalFile(this.jdField_a_of_type_Aguk.getFilePath())) {
      djW();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aguk.a(this);
      View localView1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.ca();
      if (localView1 != null)
      {
        View localView2 = localView1.findViewById(2131380125);
        if (localView2 != null) {
          localView2.setVisibility(8);
        }
        localView2 = localView1.findViewById(2131367040);
        if (localView2 != null) {
          localView2.setVisibility(8);
        }
        localView1 = localView1.findViewById(2131367029);
        if (localView1 != null) {
          localView1.setVisibility(8);
        }
      }
      return;
      djR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agvz
 * JD-Core Version:    0.7.0.1
 */