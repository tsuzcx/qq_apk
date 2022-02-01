import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class abut
  implements abiq.a
{
  abut(abus paramabus, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString1, List<abip.a> paramList, String paramString2)
  {
    QLog.i("ApolloPluginRscLoader", 1, "downloadApolloRes onDownLoadFinish success:" + paramBoolean);
    if (paramBoolean)
    {
      if (this.a.val$file.exists())
      {
        this.a.a.M(this.val$callbackId, 0, this.a.csW + acfp.m(2131702642));
        return;
      }
      this.a.a.M(this.val$callbackId, 2, this.a.csW + acfp.m(2131702653));
      return;
    }
    this.a.a.M(this.val$callbackId, 2, this.a.csW + acfp.m(2131702650));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abut
 * JD-Core Version:    0.7.0.1
 */