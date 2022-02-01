import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.barrage.BarrageView;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class abtw
  implements abiy
{
  abtw(abtv paramabtv) {}
  
  public void B(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "[onCompleteRender] taskId=", Integer.valueOf(paramInt1), ", roleName=", paramString, ", errCode=", Integer.valueOf(paramInt2) });
    }
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("ApolloViewController", 1, "[onCompleteRender] roleName null");
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!abtv.a(this.this$0).containsKey(paramString))
          {
            QLog.e("ApolloViewController", 1, "[onCompleteRender] roleName not showing");
            return;
          }
          if ((abtv.a(this.this$0) == null) || (TextUtils.isEmpty(abtv.a(this.this$0).apolloId)) || (!abtv.a(this.this$0).apolloId.equals(paramString))) {
            break;
          }
          abtv.b(this.this$0);
          if (this.this$0.Sy != 5) {
            this.this$0.crJ = 1;
          }
          paramString = abtv.a(this.this$0).obtainMessage(18, 1, 0);
          abtv.a(this.this$0).sendMessage(paramString);
          this.this$0.a.stopLoopDelayed(15000L);
        } while (TextUtils.isEmpty(abtv.a(this.this$0)));
        if (!abtv.a(this.this$0)) {
          break;
        }
      } while ((abtv.a(this.this$0) != 1) || (this.this$0.b == null));
      this.this$0.b.cCw();
      return;
      if (abtv.a(this.this$0) != 1) {
        break;
      }
    } while (this.this$0.b == null);
    this.this$0.b.DI(true);
    return;
    this.this$0.a.getRenderImpl().u(1, abtv.a(this.this$0).apolloId, "Bubble");
    return;
    synchronized (abtv.a(this.this$0))
    {
      if (abtv.a(this.this$0).containsKey(paramString))
      {
        Message localMessage = abtv.a(this.this$0).obtainMessage(28);
        localMessage.obj = paramString;
        abtv.a(this.this$0).sendMessage(localMessage);
        this.this$0.a.stopLoopDelayed(15000L);
      }
      return;
    }
  }
  
  public void bH(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewController", 2, new Object[] { "[onStartRender] taskId=", Integer.valueOf(paramInt), ", roleName=", paramString });
    }
    if ((abtv.a(this.this$0) != null) && (!TextUtils.isEmpty(abtv.a(this.this$0).apolloId)) && (abtv.a(this.this$0).apolloId.equals(paramString))) {
      abtv.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abtw
 * JD-Core Version:    0.7.0.1
 */