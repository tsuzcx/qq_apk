import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.MagicFaceViewBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class fsy
  extends EmoticonPackageDownloadListener
{
  public fsy(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  private void a(EmoticonPackage paramEmoticonPackage)
  {
    int j;
    int i;
    if ((this.a.getVisibility() == 0) && (EmoticonMainPanel.b() == 2) && (paramEmoticonPackage.jobType == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "refresh magic face panel: " + paramEmoticonPackage.epId);
      }
      if (EmoticonMainPanel.c(this.a) != null)
      {
        j = EmoticonMainPanel.c(this.a).size();
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        paramEmoticonPackage = (EmoticonViewBinder)EmoticonMainPanel.c(this.a).get(i);
        if ((paramEmoticonPackage != null) && ((paramEmoticonPackage instanceof MagicFaceViewBinder)) && (EmoticonMainPanel.c() == i))
        {
          paramEmoticonPackage = (MagicFaceViewBinder)paramEmoticonPackage;
          this.a.post(new fsz(this, paramEmoticonPackage));
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void onPackageEnd(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "magicfaceDownloadListener, onPackageEnd");
    }
    if (paramEmoticonPackage == null) {}
    while ((paramEmoticonPackage.jobType != 3) || (paramInt != 0)) {
      return;
    }
    a(paramEmoticonPackage);
  }
  
  public void onPackageStart(EmoticonPackage paramEmoticonPackage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "magicfaceDownloadListener, onPackageStart");
    }
    if (paramEmoticonPackage == null) {}
    while (paramEmoticonPackage.jobType != 3) {
      return;
    }
    a(paramEmoticonPackage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fsy
 * JD-Core Version:    0.7.0.1
 */