import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.FMActivity;

public class atnw
  implements View.OnClickListener
{
  public atnw(FMActivity paramFMActivity, View paramView) {}
  
  public void onClick(View paramView)
  {
    this.KE.setVisibility(8);
    BaseApplication.getContext().getSharedPreferences("CloudWeiYunFile", 0).edit().putBoolean("cloud_weiyun_tip_save", true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atnw
 * JD-Core Version:    0.7.0.1
 */