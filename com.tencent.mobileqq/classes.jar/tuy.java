import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget.SubscribeStatusReceiver.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.Dispatcher;

public class tuy
  extends sgc
{
  public String a;
  
  private tuy(tun paramtun) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt, paramString);
    boolean bool = TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString);
    if (bool) {
      this.jdField_a_of_type_JavaLangString = null;
    }
    StoryVideoItem localStoryVideoItem;
    if (this.jdField_a_of_type_Tun.a != null)
    {
      localStoryVideoItem = this.jdField_a_of_type_Tun.a.a();
      if (localStoryVideoItem != null) {
        break label64;
      }
    }
    label64:
    label326:
    do
    {
      do
      {
        sqs localsqs;
        QQUserUIItem localQQUserUIItem;
        do
        {
          return;
          localStoryVideoItem = null;
          break;
          localsqs = (sqs)sqg.a(2);
          localQQUserUIItem = localsqs.b(localStoryVideoItem.mOwnerUid);
        } while ((localQQUserUIItem == null) || (!TextUtils.equals(paramString, localQQUserUIItem.getUnionId())));
        if (paramBoolean1)
        {
          if (paramBoolean2) {}
          for (paramInt = 1;; paramInt = 0)
          {
            localQQUserUIItem.isSubscribe = paramInt;
            ThreadManager.post(new DetailVideoInfoWidget.SubscribeStatusReceiver.1(this, localsqs, localQQUserUIItem), 5, null, false);
            if (paramBoolean2)
            {
              paramString = (sga)tfy.a().getManager(181);
              if (!paramString.g())
              {
                paramString.c();
                bbmy.a(tfy.a(), 2, ajjy.a(2131637373), 0).a();
              }
              paramString = new ulv(2);
              sgi.a().dispatch(paramString);
            }
            tun.a(this.jdField_a_of_type_Tun, localStoryVideoItem, localQQUserUIItem);
            if (!bool) {
              break;
            }
            urp.a("play_video", "follow_suc", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
            return;
          }
        }
        if (!paramBoolean2) {
          break label326;
        }
        bbmy.a(tfy.a(), 1, ajjy.a(2131637372), 0).a();
      } while (!bool);
      urp.a("play_video", "follow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
      return;
      bbmy.a(tfy.a(), 1, ajjy.a(2131637370), 0).a();
    } while (!bool);
    urp.a("play_video", "unfollow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tuy
 * JD-Core Version:    0.7.0.1
 */