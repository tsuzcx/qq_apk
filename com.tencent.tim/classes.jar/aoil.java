import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import java.util.Map;
import javax.annotation.Nullable;

public abstract interface aoil
{
  public abstract int FB();
  
  public abstract void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, @Nullable Map<String, aoii> paramMap, @Nullable Bundle paramBundle);
  
  public abstract void a(Context paramContext, SessionInfo paramSessionInfo, int paramInt);
  
  public abstract void a(aoii paramaoii, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, @Nullable Map<String, aoii> paramMap, @Nullable Bundle paramBundle);
  
  public abstract boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Map<String, aoii> paramMap, @Nullable Bundle paramBundle);
  
  public abstract boolean b(Context paramContext, String paramString, int paramInt1, int paramInt2, @Nullable Map<String, aoii> paramMap, @Nullable Bundle paramBundle);
  
  public abstract aqju d();
  
  public abstract String getBusinessName();
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoil
 * JD-Core Version:    0.7.0.1
 */