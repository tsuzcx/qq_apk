import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.Doraemon.test.TestAppFragment;
import java.io.File;
import java.io.IOException;

public class zuo
  implements CompoundButton.OnCheckedChangeListener
{
  public zuo(TestAppFragment paramTestAppFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      new File(this.a.a).mkdirs();
      paramCompoundButton = new File(this.a.a, this.a.b);
      try
      {
        paramCompoundButton.createNewFile();
        return;
      }
      catch (IOException paramCompoundButton)
      {
        paramCompoundButton.printStackTrace();
        return;
      }
    }
    new File(this.a.a, this.a.b).delete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zuo
 * JD-Core Version:    0.7.0.1
 */