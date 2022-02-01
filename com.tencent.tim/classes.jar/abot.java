import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;

class abot
  extends BroadcastReceiver
{
  abot(abos paramabos) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (abos.a(this.this$0) == null) {}
    do
    {
      do
      {
        return;
        if ("android.intent.action.SCREEN_ON".equals(paramIntent.getAction()))
        {
          if (abos.a(this.this$0))
          {
            abos.a(this.this$0).runRenderTask(abos.a(this.this$0));
            return;
          }
          abos.a(this.this$0);
          return;
        }
      } while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction()));
      if (!abos.a(this.this$0)) {
        break;
      }
    } while (abos.a(this.this$0) == null);
    abos.a(this.this$0).runRenderTask(abos.b(this.this$0));
    return;
    abos.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abot
 * JD-Core Version:    0.7.0.1
 */