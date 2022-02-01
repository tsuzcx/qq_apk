import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.TroopFileZipPreviewActivity;

public class atpd
  implements View.OnClickListener
{
  public atpd(TroopFileZipPreviewActivity paramTroopFileZipPreviewActivity, FileManagerEntity paramFileManagerEntity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("isNeedFinish", true);
    this.a.setResult(-1, localIntent);
    TroopFileZipPreviewActivity.a(this.a);
    anot.a(this.a.app, "dc00899", "Grp_files", null, "oper", "pre_arc_close", 0, 0, "" + this.b.TroopUin, "", "", "1");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atpd
 * JD-Core Version:    0.7.0.1
 */