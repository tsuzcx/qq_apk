import com.tencent.qphone.base.util.QLog;
import java.io.File;

class abuw
  implements abto.b
{
  abuw(abuk paramabuk, int paramInt, File paramFile, String paramString) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPluginRscLoader", 2, "getApolloRsc onDownLoadFinish:" + this.csX + " sucess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      if (this.val$file.exists())
      {
        this.a.M(this.val$callbackId, 0, this.csX + acfp.m(2131702635));
        return;
      }
      this.a.M(this.val$callbackId, 2, this.csX + acfp.m(2131702634));
      return;
    }
    this.a.M(this.val$callbackId, 2, this.csX + acfp.m(2131702656));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abuw
 * JD-Core Version:    0.7.0.1
 */