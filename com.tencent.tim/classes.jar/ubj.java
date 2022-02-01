import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.Doraemon.test.TestAppFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.IOException;

public class ubj
  implements CompoundButton.OnCheckedChangeListener
{
  public ubj(TestAppFragment paramTestAppFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    File localFile;
    if (paramBoolean)
    {
      new File(this.a.aKu).mkdirs();
      localFile = new File(this.a.aKu, this.a.CONF_FILE);
    }
    for (;;)
    {
      try
      {
        localFile.createNewFile();
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        continue;
      }
      new File(this.a.aKu, this.a.CONF_FILE).delete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ubj
 * JD-Core Version:    0.7.0.1
 */