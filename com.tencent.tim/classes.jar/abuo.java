import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;

class abuo
  implements abto.e
{
  abuo(abuk paramabuk, String paramString1, File paramFile, JSONArray paramJSONArray, int[] paramArrayOfInt, String paramString2) {}
  
  public void aR(boolean paramBoolean, int paramInt)
  {
    QLog.d("ApolloPluginRscLoader", 1, "getApolloRsc checkDownloadFaceData onDownLoadFinish: sucess:" + paramBoolean);
    Object localObject = this.a;
    String str = this.bhV;
    if (this.ae.exists()) {}
    for (paramInt = 0;; paramInt = 2)
    {
      localObject = abuk.a((abuk)localObject, 6, str, paramInt);
      this.val$jsonArray.put(localObject);
      if ((this.jW != null) && (this.jW.length > 0)) {
        break;
      }
      this.a.a(this.val$callbackId, acfp.m(2131702647), this.val$jsonArray);
      return;
    }
    abuk.a(this.a, this.jW, this.val$callbackId, this.val$jsonArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abuo
 * JD-Core Version:    0.7.0.1
 */