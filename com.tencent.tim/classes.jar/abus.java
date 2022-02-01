import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class abus
  implements abis.b
{
  abus(abuk paramabuk, int paramInt, String paramString, AppInterface paramAppInterface, File paramFile) {}
  
  public void a(boolean paramBoolean, abis.a parama)
  {
    parama = abip.a().a(8, this.csW);
    Object localObject = new StringBuilder().append("downloadApolloRes onCheckFinish success:").append(paramBoolean).append(" downloadItem:");
    if (parama == null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.i("ApolloPluginRscLoader", 1, paramBoolean);
      localObject = abuk.access$300(this.bhW);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      QLog.e("ApolloPluginRscLoader", 1, "getApolloRsc error callbackId is null resourceUrl:" + this.bhW);
      return;
    }
    if (parama == null)
    {
      this.a.M((String)localObject, 2, this.csW + " json里无此id");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(parama);
    abiq.a(this.b, "", new abut(this, (String)localObject), localArrayList, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abus
 * JD-Core Version:    0.7.0.1
 */