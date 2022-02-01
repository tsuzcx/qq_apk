import android.content.Intent;
import com.tencent.tim.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.tim.filemanager.widget.SendBottomBar;
import java.util.ArrayList;

class aufl
  implements ahal.a
{
  aufl(aufk paramaufk) {}
  
  public void aD()
  {
    ArrayList localArrayList = atwb.ep();
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
    SendBottomBar.a(this.a.this$0).setResult(-1, localIntent);
    SendBottomBar.a(this.a.this$0).finish();
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aufl
 * JD-Core Version:    0.7.0.1
 */