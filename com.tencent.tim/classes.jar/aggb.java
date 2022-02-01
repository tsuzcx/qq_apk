import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aggb
  implements View.OnClickListener
{
  aggb(agga paramagga) {}
  
  public void onClick(View paramView)
  {
    Object localObject = ahav.a((FileInfo)((agga.a)paramView.getTag()).entity);
    localObject = new agvl(agga.a(this.a).app, agga.a(this.a), (FileManagerEntity)localObject, 10000);
    localObject = new agvn(agga.a(this.a), (agvq)localObject);
    ((agvn)localObject).Oy(8);
    ((agvn)localObject).k(sxx.getViewRect(paramView));
    ((agvn)localObject).djN();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aggb
 * JD-Core Version:    0.7.0.1
 */