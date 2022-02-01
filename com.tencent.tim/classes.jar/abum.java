import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;

class abum
  implements abto.e
{
  abum(abul paramabul) {}
  
  public void aR(boolean paramBoolean, int paramInt)
  {
    QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc checkDownloadFaceData onDownLoadFinish: sucess:" + paramBoolean);
    Object localObject = this.a.a;
    String str = this.a.bhV;
    if (this.a.ae.exists()) {}
    for (paramInt = 0;; paramInt = 2)
    {
      localObject = abuk.a((abuk)localObject, 6, str, paramInt);
      this.a.val$jsonArray.put(localObject);
      if ((this.a.jW != null) && (this.a.jW.length > 0)) {
        break;
      }
      this.a.a.a(this.a.val$callbackId, acfp.m(2131702632), this.a.val$jsonArray);
      return;
    }
    abuk.a(this.a.a, this.a.jW, this.a.val$callbackId, this.a.val$jsonArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abum
 * JD-Core Version:    0.7.0.1
 */