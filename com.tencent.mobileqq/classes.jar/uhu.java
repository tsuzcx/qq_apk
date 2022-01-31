import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget.SubscribeStatusReceiver.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.Dispatcher;

public class uhu
  extends ssy
{
  public String a;
  
  private uhu(uhj paramuhj) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt, paramString);
    boolean bool = TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString);
    if (bool) {
      this.jdField_a_of_type_JavaLangString = null;
    }
    StoryVideoItem localStoryVideoItem;
    if (this.jdField_a_of_type_Uhj.a != null)
    {
      localStoryVideoItem = this.jdField_a_of_type_Uhj.a.a();
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
        tdo localtdo;
        QQUserUIItem localQQUserUIItem;
        do
        {
          return;
          localStoryVideoItem = null;
          break;
          localtdo = (tdo)tdc.a(2);
          localQQUserUIItem = localtdo.b(localStoryVideoItem.mOwnerUid);
        } while ((localQQUserUIItem == null) || (!TextUtils.equals(paramString, localQQUserUIItem.getUnionId())));
        if (paramBoolean1)
        {
          if (paramBoolean2) {}
          for (paramInt = 1;; paramInt = 0)
          {
            localQQUserUIItem.isSubscribe = paramInt;
            ThreadManager.post(new DetailVideoInfoWidget.SubscribeStatusReceiver.1(this, localtdo, localQQUserUIItem), 5, null, false);
            if (paramBoolean2)
            {
              paramString = (ssw)tsu.a().getManager(181);
              if (!paramString.g())
              {
                paramString.c();
                bcpw.a(tsu.a(), 2, ajyc.a(2131703158), 0).a();
              }
              paramString = new uyr(2);
              ste.a().dispatch(paramString);
            }
            uhj.a(this.jdField_a_of_type_Uhj, localStoryVideoItem, localQQUserUIItem);
            if (!bool) {
              break;
            }
            vel.a("play_video", "follow_suc", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
            return;
          }
        }
        if (!paramBoolean2) {
          break label326;
        }
        bcpw.a(tsu.a(), 1, ajyc.a(2131703157), 0).a();
      } while (!bool);
      vel.a("play_video", "follow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
      return;
      bcpw.a(tsu.a(), 1, ajyc.a(2131703155), 0).a();
    } while (!bool);
    vel.a("play_video", "unfollow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhu
 * JD-Core Version:    0.7.0.1
 */