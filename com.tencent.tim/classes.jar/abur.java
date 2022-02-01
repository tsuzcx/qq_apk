import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class abur
  implements abiq.a
{
  abur(abuk paramabuk, int[] paramArrayOfInt, JSONArray paramJSONArray, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString1, List<abip.a> paramList, String paramString2)
  {
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc downloadApolloRes onDownLoadFinish success:" + paramBoolean);
    int i = 0;
    if (i < this.jX.length)
    {
      paramString1 = abip.a().a(8, this.jX[i]);
      int j;
      if (paramString1 != null)
      {
        paramList = this.a;
        int k = paramString1.mId;
        if (paramString1.isResourceReady())
        {
          j = 0;
          label79:
          paramString1 = abuk.a(paramList, 8, String.valueOf(k), j);
          this.val$jsonArray.put(paramString1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 2;
        break label79;
        paramString1 = abuk.a(this.a, 8, String.valueOf(this.jX[i]), 2);
        this.val$jsonArray.put(paramString1);
      }
    }
    this.a.a(this.val$callbackId, acfp.m(2131702655), this.val$jsonArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abur
 * JD-Core Version:    0.7.0.1
 */