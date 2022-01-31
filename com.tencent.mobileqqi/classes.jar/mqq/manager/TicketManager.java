package mqq.manager;

import android.content.Context;
import java.util.HashMap;

public abstract interface TicketManager
  extends Manager
{
  public abstract String getA2(String paramString);
  
  public abstract String getPskey(String paramString1, String paramString2);
  
  public abstract String getSid(String paramString);
  
  public abstract String getSkey(String paramString);
  
  public abstract String getStweb(String paramString);
  
  public abstract String getSuperkey(String paramString);
  
  public abstract String getVkey(String paramString);
  
  public abstract void notifyRelogin(String paramString);
  
  public abstract void reloadCache(Context paramContext);
  
  public abstract void setAlterTicket(HashMap<String, String> paramHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     mqq.manager.TicketManager
 * JD-Core Version:    0.7.0.1
 */