import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.QLog;

class agvw
  implements agil.b
{
  agvw(agvt paramagvt) {}
  
  public void dgE()
  {
    int i = ahbr.hP(this.a.jdField_a_of_type_Aguk.getFileType());
    anot.a(null, "dc00898", "", "", "0X800A688", "0X800A688", 0, 0, i + "", "", "", "");
    agss localagss = this.a.jdField_a_of_type_Aguk.a();
    if (localagss != null)
    {
      localagss.iE();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JQ(false);
    }
  }
  
  public void dgF()
  {
    agil localagil = agvt.a(this.a);
    if (localagil == null) {
      return;
    }
    String str = this.a.jdField_a_of_type_Aguk.vN();
    if (localagil.alf())
    {
      if (!TextUtils.isEmpty(str))
      {
        agil.eC(str, 1);
        return;
      }
      QLog.i("ApkForAppStoreFilePresenter", 1, "app store has installed, but apk package name is null!");
      return;
    }
    localagil.bx(this.a.mContext, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agvw
 * JD-Core Version:    0.7.0.1
 */