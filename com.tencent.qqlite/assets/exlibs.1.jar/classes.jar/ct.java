import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.dataline.mpfile.LiteMpFileMainActivity;
import com.dataline.mpfile.MpFileConstant;
import com.dataline.mpfile.MpFileDataReportCenter;
import com.dataline.mpfile.MpfileDataCenter;
import com.dataline.mpfile.MpfileDataReportInfo;
import com.dataline.util.DBNetworkUtil;
import com.dataline.util.DatalineMathUtil;

public class ct
  extends BroadcastReceiver
{
  public ct(LiteMpFileMainActivity paramLiteMpFileMainActivity) {}
  
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
    } while (LiteMpFileMainActivity.a(this.a) != l);
    int i = paramContext.getInt(MpFileConstant.e);
    if (i == 0)
    {
      paramIntent = DatalineMathUtil.a(paramContext.getLong("ip"));
      i = paramContext.getInt("port");
      int j = paramContext.getInt("result");
      paramContext = new MpfileDataReportInfo();
      paramContext.jdField_b_of_type_Int = j;
      paramContext.jdField_a_of_type_Int = 1;
      paramContext.jdField_b_of_type_JavaLangString = DBNetworkUtil.b();
      if (j == 0)
      {
        MpfileDataCenter.k = paramIntent;
        MpfileDataCenter.E = i;
        paramContext.jdField_a_of_type_JavaLangString = paramIntent;
        paramContext.d = i;
        paramContext = String.format(LiteMpFileMainActivity.a(this.a), new Object[] { MpfileDataCenter.k, Integer.valueOf(MpfileDataCenter.E), Integer.valueOf(LiteMpFileMainActivity.a(this.a)), Integer.valueOf(LiteMpFileMainActivity.b(this.a)) });
        LiteMpFileMainActivity.a(this.a, paramContext);
        return;
      }
      if (j == 2)
      {
        paramContext.jdField_b_of_type_Int = MpfileDataCenter.x;
        MpFileDataReportCenter.a(this.a.app, paramContext);
        this.a.a(7);
        return;
      }
      if (j == 3)
      {
        this.a.a(MpfileDataCenter.w);
        return;
      }
      paramContext.jdField_b_of_type_Int = MpfileDataCenter.y;
      MpFileDataReportCenter.a(this.a.app, paramContext);
      this.a.a(MpfileDataCenter.r);
      return;
    }
    paramContext = new MpfileDataReportInfo();
    paramContext.jdField_b_of_type_Int = i;
    paramContext.jdField_b_of_type_JavaLangString = DBNetworkUtil.b();
    paramContext.jdField_a_of_type_Int = 1;
    MpFileDataReportCenter.a(this.a.app, paramContext);
    this.a.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ct
 * JD-Core Version:    0.7.0.1
 */