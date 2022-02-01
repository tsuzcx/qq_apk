import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class agvt
  extends agwv
  implements View.OnClickListener
{
  private agil.b b = new agvw(this);
  
  public agvt(aguk paramaguk, Activity paramActivity)
  {
    super(paramaguk, paramActivity);
  }
  
  private agil a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime == null) || (!(localAppRuntime instanceof QQAppInterface))) {
      return null;
    }
    return ((QQAppInterface)localAppRuntime).a().a();
  }
  
  private void djV()
  {
    this.cfo = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(acfp.m(2131706208) + aqhp.bO(this.jdField_a_of_type_Aguk.getFileSize()) + ")", new agvv(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JK(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JJ(true);
  }
  
  protected void djR() {}
  
  protected void djS()
  {
    Object localObject = a();
    if (localObject == null) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((!this.jdField_a_of_type_Aguk.amt()) || (!((agil)localObject).alg()) || (TextUtils.isEmpty(this.jdField_a_of_type_Aguk.vN())));
      i = this.jdField_a_of_type_Aguk.bL();
    } while ((i == 6) || (i == 2) || (i == 4) || (i == 5));
    localObject = ((agil)localObject).aB(this.mContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g((String)localObject, this);
    anot.a(null, "dc00898", "", "", "0X800AE3B", "0X800AE3B", 0, 0, "", "", "", "");
  }
  
  protected void djT()
  {
    super.djT();
    int i = this.jdField_a_of_type_Aguk.bL();
    if ((i != 6) && (i != 2) && (i != 4) && (i != 5))
    {
      if (a() == null) {
        djV();
      }
    }
    else {
      return;
    }
    this.cfo = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(acfp.m(2131706208) + aqhp.bO(this.jdField_a_of_type_Aguk.getFileSize()) + ")", new agvu(this));
  }
  
  protected void djU()
  {
    Object localObject = a();
    if (localObject == null) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((!this.jdField_a_of_type_Aguk.amt()) || (!((agil)localObject).alg()) || (TextUtils.isEmpty(this.jdField_a_of_type_Aguk.vN())));
      i = this.jdField_a_of_type_Aguk.bL();
    } while ((i == 6) || (i == 2) || (i == 4) || (i == 5));
    localObject = ((agil)localObject).aB(this.mContext);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g((String)localObject, this);
  }
  
  public void init()
  {
    boolean bool = true;
    super.init();
    if (QLog.isColorLevel()) {
      QLog.i("ApkForAppStoreFilePresenter", 1, "FileBrowserPresenter init: type = preview simple");
    }
    Object localObject = this.jdField_a_of_type_Aguk.vP();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.OP(2130845117);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jv((String)localObject);
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Aguk.aC())) && (16 != this.jdField_a_of_type_Aguk.bF())) {
        break label224;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JR(false);
      label85:
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Aguk.aC())) && (16 != this.jdField_a_of_type_Aguk.bF())) {
        break label241;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JR(false);
      label118:
      if (this.jdField_a_of_type_Aguk.bF() != 16) {
        break label258;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(this.mContext.getString(2131693595));
      label146:
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer;
      if (this.jdField_a_of_type_Aguk.cn()) {
        break label287;
      }
    }
    for (;;)
    {
      ((SimpleFileViewer)localObject).showTip(bool);
      localObject = this.jdField_a_of_type_Aguk.vO();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jr((String)localObject);
      }
      if (!aqhq.fileExistsAndNotEmpty(this.jdField_a_of_type_Aguk.getFilePath())) {
        djS();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Ju(this.jdField_a_of_type_Aguk.aB());
      break;
      label224:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Js(this.jdField_a_of_type_Aguk.aC());
      break label85;
      label241:
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Js(this.jdField_a_of_type_Aguk.aC());
      break label118;
      label258:
      if (!this.jdField_a_of_type_Aguk.isFromProcessingForward2c2cOrDiscItem()) {
        break label146;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(this.mContext.getString(2131693824));
      break label146;
      label287:
      bool = false;
    }
  }
  
  public void onClick(View paramView)
  {
    agil localagil = a();
    if (localagil == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(null, "dc00898", "", "", "0X800AE3C", "0X800AE3C", 0, 0, "", "", "", "");
      String str = this.jdField_a_of_type_Aguk.vN();
      if (localagil.alf())
      {
        if (!TextUtils.isEmpty(str)) {
          agil.eC(str, 1);
        } else {
          QLog.i("ApkForAppStoreFilePresenter", 1, "app store has installed, but apk package name is null!");
        }
      }
      else {
        localagil.bx(this.mContext, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agvt
 * JD-Core Version:    0.7.0.1
 */