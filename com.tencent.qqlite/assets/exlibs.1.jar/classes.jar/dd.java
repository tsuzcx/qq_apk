import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.dataline.mpfile.MpFileConstant;
import com.dataline.mpfile.MpfileDataCenter;
import java.util.TimerTask;

public class dd
  extends TimerTask
{
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private long b = 0L;
  
  private dd(MpfileDataCenter paramMpfileDataCenter) {}
  
  public void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComDatalineMpfileMpfileDataCenter.jdField_a_of_type_Boolean) {
      cancel();
    }
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
    } while ((l <= this.jdField_a_of_type_Long) || (l - this.jdField_a_of_type_Long <= 30000L));
    cancel();
    Bundle localBundle = new Bundle();
    localBundle.putInt(MpFileConstant.e, MpfileDataCenter.q);
    localBundle.putLong(MpFileConstant.f, this.b);
    Intent localIntent = new Intent();
    localIntent.setAction(MpFileConstant.d);
    localIntent.putExtras(localBundle);
    this.jdField_a_of_type_ComDatalineMpfileMpfileDataCenter.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dd
 * JD-Core Version:    0.7.0.1
 */