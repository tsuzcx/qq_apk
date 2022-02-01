import android.content.Intent;
import com.dataline.activities.PrinterActivity;
import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;

class aciq
  implements ahal.a
{
  aciq(acio paramacio, BaseActivity paramBaseActivity, String paramString) {}
  
  public void aD()
  {
    Intent localIntent = new Intent(this.val$activity, PrinterActivity.class);
    localIntent.putExtra(aqfx.REQUEST_CODE, 55);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.val$localPath);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    this.val$activity.startActivity(localIntent);
    anot.a(this.this$0.app, "CliOper", "", "", "0X8004059", "0X8004059", 0, 0, "", "", "", "");
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aciq
 * JD-Core Version:    0.7.0.1
 */