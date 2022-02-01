import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import friendlist.GetOnlineInfoResp;
import mqq.os.MqqHandler;

public class rsx
  extends acfd
{
  public rsx(StoryQIMBadgeView paramStoryQIMBadgeView) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    super.onGetOnlineInfoByUinOrMobile(paramBoolean, paramLong, paramString, paramGetOnlineInfoResp);
    if ((StoryQIMBadgeView.a(this.b) == null) || (paramGetOnlineInfoResp == null) || (TextUtils.isEmpty(StoryQIMBadgeView.a(this.b).qq))) {}
    while ((!paramBoolean) || (!aqft.equalsWithNullCheck(StoryQIMBadgeView.a(this.b).qq, paramString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new StoryQIMBadgeView.1.1(this, paramGetOnlineInfoResp, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rsx
 * JD-Core Version:    0.7.0.1
 */