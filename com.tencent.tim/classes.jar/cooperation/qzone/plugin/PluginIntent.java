package cooperation.qzone.plugin;

import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.ArrayList;
import mqq.app.NewIntent;
import mqq.app.Servlet;

public class PluginIntent
  extends NewIntent
{
  public ArrayList<UPDATE_INFO> Fg;
  public ArrayList<UPDATE_INFO> Fh;
  a a;
  
  public PluginIntent(Context paramContext, Class<? extends Servlet> paramClass)
  {
    super(paramContext, paramClass);
  }
  
  public a a()
  {
    return this.a;
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void S(Intent paramIntent, FromServiceMsg paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.PluginIntent
 * JD-Core Version:    0.7.0.1
 */