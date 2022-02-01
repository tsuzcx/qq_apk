import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONArray;

class abup
  implements abis.b
{
  abup(abuk paramabuk, int paramInt, int[] paramArrayOfInt, List paramList, AppInterface paramAppInterface, JSONArray paramJSONArray, String paramString) {}
  
  public void a(boolean paramBoolean, abis.a parama)
  {
    abuk.a(this.a).remove(this.val$requestId);
    QLog.i("ApolloPluginRscLoader", 1, "checkRoomRsc onCheckFinish success:" + paramBoolean);
    if (paramBoolean)
    {
      i = 0;
      while (i < this.jX.length)
      {
        parama = abip.a().a(8, this.jX[i]);
        if (parama != null) {
          this.wB.add(parama);
        }
        i += 1;
      }
      abiq.a(this.b, "", new abuq(this), this.wB, false, null);
      return;
    }
    int i = 0;
    if (i < this.jX.length)
    {
      parama = abip.a().a(8, this.jX[i]);
      int j;
      if (parama != null)
      {
        abuk localabuk = this.a;
        int k = parama.mId;
        if (parama.isResourceReady())
        {
          j = 0;
          label167:
          parama = abuk.a(localabuk, 8, String.valueOf(k), j);
          this.val$jsonArray.put(parama);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 2;
        break label167;
        parama = abuk.a(this.a, 8, String.valueOf(this.jX[i]), 2);
        this.val$jsonArray.put(parama);
      }
    }
    this.a.a(this.val$callbackId, acfp.m(2131702643), this.val$jsonArray);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abup
 * JD-Core Version:    0.7.0.1
 */