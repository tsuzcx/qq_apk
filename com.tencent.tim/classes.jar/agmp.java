import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class agmp
  implements awqd.b
{
  agmp(agmf paramagmf, String paramString, int paramInt, Object paramObject) {}
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    int i;
    if ((paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists()))
    {
      i = 1;
      if (i == 0) {
        break label128;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb onSucceed. filePath[" + paramString2 + "]");
      }
      agmf.a(this.b).a().b(true, 39, new Object[] { this.bIg, Integer.valueOf(this.cXR), paramString2, this.dK });
    }
    label128:
    while (!QLog.isColorLevel())
    {
      return;
      i = 0;
      break;
    }
    QLog.i("WeiYunLogicCenter<FileAssistant>", 2, "getWeiYunThumb onFailed: errcode[" + paramInt + "], errmsg[" + paramString3 + "]");
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     agmp
 * JD-Core Version:    0.7.0.1
 */