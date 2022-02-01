import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class acyk
  implements View.OnClickListener
{
  acyk(acyi paramacyi, ArrayList paramArrayList, QIMNotifyAddFriend.VideoInfo paramVideoInfo) {}
  
  public void onClick(View paramView)
  {
    OpenPlayerBuilder localOpenPlayerBuilder = new OpenPlayerBuilder(new VidListPlayInfo(this.np, this.a.videoVid), 120);
    localOpenPlayerBuilder.a();
    qgg.a(this.b.a, localOpenPlayerBuilder.b(), null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acyk
 * JD-Core Version:    0.7.0.1
 */