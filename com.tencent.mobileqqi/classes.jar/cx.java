import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.dataline.mpfile.LiteMpFileActionListActivity;
import com.dataline.mpfile.MpFileConstant;
import com.dataline.util.DatalineMathUtil;

public class cx
  extends BroadcastReceiver
{
  public cx(LiteMpFileActionListActivity paramLiteMpFileActionListActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if ((paramContext != null) && (paramContext.equals(MpFileConstant.d)))
      {
        paramContext = paramIntent.getExtras();
        paramIntent = DatalineMathUtil.a(paramContext.getLong("ip"));
        int i = paramContext.getInt("port");
        LiteMpFileActionListActivity.jdField_a_of_type_JavaLangString = paramIntent;
        LiteMpFileActionListActivity.jdField_a_of_type_Int = i;
        LiteMpFileActionListActivity.a(this.a, String.format("http://%s:%d/qqmpfile/?action=fileList&offset=0&limit=100", new Object[] { LiteMpFileActionListActivity.jdField_a_of_type_JavaLangString, Integer.valueOf(LiteMpFileActionListActivity.jdField_a_of_type_Int) }));
        LiteMpFileActionListActivity.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     cx
 * JD-Core Version:    0.7.0.1
 */