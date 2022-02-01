import android.os.Bundle;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class afkg
  extends aquy
{
  afkg(afke paramafke, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    Object localObject = paramaquz.getParams();
    int j = ((Bundle)localObject).getInt(paramaquz.currUrl);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "coverDownloadListener| onDone:epId=" + ((EmoticonPackage)localObject).epId + " task:" + paramaquz + " localVersion=" + ((EmoticonPackage)localObject).localVersion + ",latestVersion=" + ((EmoticonPackage)localObject).latestVersion + ",updateFlag=" + ((EmoticonPackage)localObject).updateFlag);
    }
    int i = 0;
    if (paramaquz.getStatus() != 3)
    {
      i = afgc.hg(paramaquz.errCode);
      if (afke.jj(j)) {
        afke.b.a((EmoticonPackage)localObject, j, -1, i);
      }
      afke.b.a((EmoticonPackage)localObject, i, this.this$0.mApp);
    }
    for (;;)
    {
      long l1 = paramaquz.aua;
      long l2 = paramaquz.atZ;
      this.this$0.a((EmoticonPackage)localObject, i, l1 - l2, paramaquz.bqw);
      return;
      afke.b.a((EmoticonPackage)localObject, j, 0, 0);
    }
  }
  
  public void onDoneFile(aquz paramaquz)
  {
    Object localObject = paramaquz.getParams();
    int i = ((Bundle)localObject).getInt(paramaquz.currUrl);
    localObject = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.TAG, 2, "coverDownloadListener | onProgress:epId=" + ((EmoticonPackage)localObject).epId + paramaquz);
    }
    if (afke.jj(i)) {
      afke.b.a((EmoticonPackage)localObject, i, 0, 0);
    }
  }
  
  public boolean onStart(aquz paramaquz)
  {
    return super.onStart(paramaquz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afkg
 * JD-Core Version:    0.7.0.1
 */