import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class abuu
  implements abiq.a
{
  abuu(abuk paramabuk, String paramString, File paramFile, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, List<abip.a> paramList, String paramString2)
  {
    QLog.i("ApolloPluginRscLoader", 1, "downloadApolloRes onDownLoadFinish success:" + paramBoolean);
    paramString1 = abuk.access$300(this.bhW);
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + this.bhW);
      return;
    }
    if (paramBoolean)
    {
      if (this.val$file.exists())
      {
        this.a.M(paramString1, 0, this.csW + acfp.m(2131702639));
        return;
      }
      this.a.M(paramString1, 2, this.csW + acfp.m(2131702638));
      return;
    }
    this.a.M(paramString1, 2, this.csW + acfp.m(2131702633));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abuu
 * JD-Core Version:    0.7.0.1
 */