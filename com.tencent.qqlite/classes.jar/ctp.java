import com.tencent.mobileqq.app.EmoticonManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class ctp
  extends EmoticonPackageDownloadListener
{
  public ctp(EmoticonManagerImp paramEmoticonManagerImp) {}
  
  public void onJsonComplete(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EmoticonManagerImp", 2, "json is complete,result ok: " + paramEmoticonPackage.epId);
      }
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.a.a.get(paramEmoticonPackage.epId);
      if (localEmoticonPackage != null)
      {
        localEmoticonPackage.name = paramEmoticonPackage.name;
        localEmoticonPackage.mark = paramEmoticonPackage.mark;
        localEmoticonPackage.mobileFeetype = paramEmoticonPackage.mobileFeetype;
        localEmoticonPackage.downloadCount = paramEmoticonPackage.downloadCount;
        localEmoticonPackage.type = paramEmoticonPackage.type;
        this.a.a(localEmoticonPackage);
        this.a.a(localEmoticonPackage.epId);
        ((EmojiManager)EmoticonManagerImp.a(this.a).getManager(39)).b(paramEmoticonPackage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ctp
 * JD-Core Version:    0.7.0.1
 */