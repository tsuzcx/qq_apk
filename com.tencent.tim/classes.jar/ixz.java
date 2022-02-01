import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.config.ConfigInfo;

class ixz
  extends BroadcastReceiver
{
  ixz(ixy paramixy) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    if (paramIntent.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE"))
    {
      if (!ixy.a(this.b))
      {
        ixy.a(this.b, true);
        if (ixy.b(this.b)) {
          ixy.a(this.b);
        }
      }
      int i = ConfigInfo.getSharpConfigVersionFromFile(paramContext);
      itl.a().al("update", i);
    }
    do
    {
      do
      {
        return;
      } while ((!paramIntent.equals("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD")) || (ixy.b(this.b)));
      ixy.b(this.b, true);
    } while (!ixy.a(this.b));
    ixy.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ixz
 * JD-Core Version:    0.7.0.1
 */