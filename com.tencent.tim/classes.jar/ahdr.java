import android.content.Intent;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import java.util.ArrayList;

public class ahdr
  implements ahal.a
{
  public ahdr(SendBottomBar paramSendBottomBar) {}
  
  public void aD()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(agmz.D());
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
    SendBottomBar.a(this.this$0).setResult(-1, localIntent);
    SendBottomBar.a(this.this$0).finish();
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahdr
 * JD-Core Version:    0.7.0.1
 */