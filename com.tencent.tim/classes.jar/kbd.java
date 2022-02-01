import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.SendMenuEventResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

class kbd
  implements BusinessObserver
{
  kbd(kaw paramkaw, NewIntent paramNewIntent, Context paramContext, String paramString, BusinessObserver paramBusinessObserver, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1 = null;
    this.a.setObserver(null);
    if (!paramBoolean) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject2 = paramBundle.getByteArray("data");
        paramBundle = new mobileqq_mp.SendMenuEventResponse();
      }
      catch (Exception paramBundle)
      {
        try
        {
          paramBundle.mergeFrom((byte[])localObject2);
          Object localObject2 = this.val$context.getSharedPreferences("menuEventSharePre", 0);
          localObject1 = paramBundle;
          if (((SharedPreferences)localObject2).contains(this.VL))
          {
            localObject1 = paramBundle;
            if (paramBundle.seqno.has())
            {
              localObject1 = paramBundle;
              if (paramBundle.seqno.get() != ((SharedPreferences)localObject2).getInt(this.VL, 0))
              {
                if (this.val$observer != null) {
                  this.this$0.a(this.val$context, this.val$app, this.VL, this.val$observer, true);
                }
                localObject1 = ((SharedPreferences)localObject2).edit();
                ((SharedPreferences.Editor)localObject1).putInt(this.VL, paramBundle.seqno.get());
                ((SharedPreferences.Editor)localObject1).commit();
                localObject1 = paramBundle;
              }
            }
          }
          if (localObject1 != null) {
            break;
          }
          return;
        }
        catch (Exception localException)
        {
          break label187;
        }
        paramBundle = paramBundle;
        paramBundle = (Bundle)localObject1;
      }
      label187:
      localObject1 = paramBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbd
 * JD-Core Version:    0.7.0.1
 */