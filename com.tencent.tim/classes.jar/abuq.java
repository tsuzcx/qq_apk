import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class abuq
  implements abiq.a
{
  abuq(abup paramabup) {}
  
  public void a(boolean paramBoolean, String paramString1, List<abip.a> paramList, String paramString2)
  {
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc downloadApolloRes onDownLoadFinish success:" + paramBoolean);
    int i = 0;
    if (i < this.a.jX.length)
    {
      paramString1 = abip.a().a(8, this.a.jX[i]);
      int j;
      if (paramString1 != null)
      {
        paramList = this.a.a;
        int k = paramString1.mId;
        if (paramString1.isResourceReady())
        {
          j = 0;
          label88:
          paramString1 = abuk.a(paramList, 8, String.valueOf(k), j);
          this.a.val$jsonArray.put(paramString1);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 2;
        break label88;
        paramString1 = abuk.a(this.a.a, 8, String.valueOf(this.a.jX[i]), 2);
        this.a.val$jsonArray.put(paramString1);
      }
    }
    this.a.a.a(this.a.val$callbackId, acfp.m(2131702644), this.a.val$jsonArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abuq
 * JD-Core Version:    0.7.0.1
 */