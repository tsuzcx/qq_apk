import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.dataline.mpfile.LiteMpFileFileListActivity;
import com.dataline.mpfile.MpFileConstant;
import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.util.DatalineMathUtil;

public class cf
  extends BroadcastReceiver
{
  public cf(LiteMpFileFileListActivity paramLiteMpFileFileListActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    long l;
    do
    {
      do
      {
        return;
        paramContext = paramIntent.getAction();
      } while ((paramContext == null) || (!paramContext.equals(MpFileConstant.d)));
      paramContext = paramIntent.getExtras();
      l = paramIntent.getLongExtra(MpFileConstant.f, 0L);
    } while (LiteMpFileFileListActivity.a(this.a) != l);
    int i = paramContext.getInt(MpFileConstant.e);
    if (i == 0)
    {
      paramIntent = DatalineMathUtil.a(paramContext.getLong("ip"));
      int j = paramContext.getInt("port");
      if (paramContext.getInt("result") == 0)
      {
        MpfileDataCenter.k = paramIntent;
        MpfileDataCenter.E = j;
        LiteMpFileFileListActivity.a(this.a, 0);
        this.a.c();
        paramContext = String.format(LiteMpFileFileListActivity.a(this.a), new Object[] { MpfileDataCenter.k, Integer.valueOf(MpfileDataCenter.E), Integer.valueOf(LiteMpFileFileListActivity.a(this.a)), Integer.valueOf(LiteMpFileFileListActivity.b(this.a)), this.a.a });
        LiteMpFileFileListActivity.a(this.a, paramContext);
        return;
      }
      if (i == 2)
      {
        this.a.a(7);
        return;
      }
      if (i == 3)
      {
        this.a.a(MpfileDataCenter.w);
        return;
      }
      this.a.a(MpfileDataCenter.r);
      return;
    }
    this.a.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cf
 * JD-Core Version:    0.7.0.1
 */