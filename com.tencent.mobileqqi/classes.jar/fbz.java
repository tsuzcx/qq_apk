import com.tencent.mobileqq.app.EmoticonManagerImp;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class fbz
  extends EmoticonPackageDownloadListener
{
  public fbz(EmoticonManagerImp paramEmoticonManagerImp) {}
  
  public void onJsonComplete(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonManagerImp", 2, "json is complete,result ok: " + paramEmoticonPackage.epId);
      }
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)EmoticonManagerImp.a(this.a).get(paramEmoticonPackage.epId);
      if (localEmoticonPackage != null)
      {
        localEmoticonPackage.name = paramEmoticonPackage.name;
        localEmoticonPackage.mark = paramEmoticonPackage.mark;
        localEmoticonPackage.mobileFeetype = paramEmoticonPackage.mobileFeetype;
        localEmoticonPackage.downloadCount = paramEmoticonPackage.downloadCount;
        this.a.a(localEmoticonPackage);
        this.a.a(localEmoticonPackage.epId);
        EmoticonController.a(EmoticonManagerImp.a(this.a)).f(paramEmoticonPackage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fbz
 * JD-Core Version:    0.7.0.1
 */