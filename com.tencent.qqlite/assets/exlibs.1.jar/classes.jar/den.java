import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.MagicFaceViewBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class den
  extends EmoticonPackageDownloadListener
{
  public den(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  private void a(EmoticonPackage paramEmoticonPackage)
  {
    int j;
    int i;
    if ((this.a.getVisibility() == 0) && (EmoticonMainPanel.g == 2) && (paramEmoticonPackage.jobType == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "refresh magic face panel: " + paramEmoticonPackage.epId);
      }
      if (this.a.a != null)
      {
        j = this.a.a.size();
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        paramEmoticonPackage = (EmoticonViewBinder)this.a.a.get(i);
        if ((paramEmoticonPackage != null) && ((paramEmoticonPackage instanceof MagicFaceViewBinder)) && (EmoticonMainPanel.i == i))
        {
          paramEmoticonPackage = (MagicFaceViewBinder)paramEmoticonPackage;
          this.a.post(new deo(this, paramEmoticonPackage));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     den
 * JD-Core Version:    0.7.0.1
 */