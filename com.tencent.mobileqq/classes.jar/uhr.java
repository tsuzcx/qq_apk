import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget.SubscribeStatusReceiver.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.Dispatcher;

public class uhr
  extends ssv
{
  public String a;
  
  private uhr(uhg paramuhg) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt, paramString);
    boolean bool = TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString);
    if (bool) {
      this.jdField_a_of_type_JavaLangString = null;
    }
    StoryVideoItem localStoryVideoItem;
    if (this.jdField_a_of_type_Uhg.a != null)
    {
      localStoryVideoItem = this.jdField_a_of_type_Uhg.a.a();
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
        tdl localtdl;
        QQUserUIItem localQQUserUIItem;
        do
        {
          return;
          localStoryVideoItem = null;
          break;
          localtdl = (tdl)tcz.a(2);
          localQQUserUIItem = localtdl.b(localStoryVideoItem.mOwnerUid);
        } while ((localQQUserUIItem == null) || (!TextUtils.equals(paramString, localQQUserUIItem.getUnionId())));
        if (paramBoolean1)
        {
          if (paramBoolean2) {}
          for (paramInt = 1;; paramInt = 0)
          {
            localQQUserUIItem.isSubscribe = paramInt;
            ThreadManager.post(new DetailVideoInfoWidget.SubscribeStatusReceiver.1(this, localtdl, localQQUserUIItem), 5, null, false);
            if (paramBoolean2)
            {
              paramString = (sst)tsr.a().getManager(181);
              if (!paramString.g())
              {
                paramString.c();
                bcql.a(tsr.a(), 2, ajya.a(2131703169), 0).a();
              }
              paramString = new uyo(2);
              stb.a().dispatch(paramString);
            }
            uhg.a(this.jdField_a_of_type_Uhg, localStoryVideoItem, localQQUserUIItem);
            if (!bool) {
              break;
            }
            vei.a("play_video", "follow_suc", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
            return;
          }
        }
        if (!paramBoolean2) {
          break label326;
        }
        bcql.a(tsr.a(), 1, ajya.a(2131703168), 0).a();
      } while (!bool);
      vei.a("play_video", "follow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
      return;
      bcql.a(tsr.a(), 1, ajya.a(2131703166), 0).a();
    } while (!bool);
    vei.a("play_video", "unfollow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhr
 * JD-Core Version:    0.7.0.1
 */