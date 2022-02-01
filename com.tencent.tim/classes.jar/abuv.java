import com.tencent.qphone.base.util.QLog;
import java.io.File;

class abuv
  implements abto.b
{
  abuv(abuk paramabuk, File paramFile, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc onDownLoadFinish:" + paramInt1 + " sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.val$file.exists())
      {
        this.a.M(this.val$callbackId, 0, paramInt1 + acfp.m(2131702654));
        return;
      }
      this.a.M(this.val$callbackId, 2, paramInt1 + acfp.m(2131702630));
      return;
    }
    this.a.M(this.val$callbackId, 2, paramInt1 + acfp.m(2131702648));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abuv
 * JD-Core Version:    0.7.0.1
 */