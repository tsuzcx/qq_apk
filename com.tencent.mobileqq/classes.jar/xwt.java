import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView;
import com.tencent.biz.qqstory.view.widget.StoryQIMBadgeView.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import friendlist.GetOnlineInfoResp;
import mqq.os.MqqHandler;

public class xwt
  extends altm
{
  public xwt(StoryQIMBadgeView paramStoryQIMBadgeView) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    super.onGetOnlineInfoByUinOrMobile(paramBoolean, paramLong, paramString, paramGetOnlineInfoResp);
    if ((StoryQIMBadgeView.a(this.a) == null) || (paramGetOnlineInfoResp == null) || (TextUtils.isEmpty(StoryQIMBadgeView.a(this.a).qq))) {}
    while ((!paramBoolean) || (!bdeu.a(StoryQIMBadgeView.a(this.a).qq, paramString))) {
      return;
    }
    ThreadManager.getUIHandler().post(new StoryQIMBadgeView.1.1(this, paramGetOnlineInfoResp, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xwt
 * JD-Core Version:    0.7.0.1
 */