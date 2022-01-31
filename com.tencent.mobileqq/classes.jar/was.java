import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget.SubscribeStatusReceiver.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.Dispatcher;

public class was
  extends ulw
{
  public String a;
  
  private was(wah paramwah) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt, paramString);
    boolean bool = TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString);
    if (bool) {
      this.jdField_a_of_type_JavaLangString = null;
    }
    StoryVideoItem localStoryVideoItem;
    if (this.jdField_a_of_type_Wah.a != null)
    {
      localStoryVideoItem = this.jdField_a_of_type_Wah.a.a();
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
        uwm localuwm;
        QQUserUIItem localQQUserUIItem;
        do
        {
          return;
          localStoryVideoItem = null;
          break;
          localuwm = (uwm)uwa.a(2);
          localQQUserUIItem = localuwm.b(localStoryVideoItem.mOwnerUid);
        } while ((localQQUserUIItem == null) || (!TextUtils.equals(paramString, localQQUserUIItem.getUnionId())));
        if (paramBoolean1)
        {
          if (paramBoolean2) {}
          for (paramInt = 1;; paramInt = 0)
          {
            localQQUserUIItem.isSubscribe = paramInt;
            ThreadManager.post(new DetailVideoInfoWidget.SubscribeStatusReceiver.1(this, localuwm, localQQUserUIItem), 5, null, false);
            if (paramBoolean2)
            {
              paramString = (ulu)vls.a().getManager(181);
              if (!paramString.g())
              {
                paramString.c();
                QQToast.a(vls.a(), 2, alud.a(2131703553), 0).a();
              }
              paramString = new wrp(2);
              umc.a().dispatch(paramString);
            }
            wah.a(this.jdField_a_of_type_Wah, localStoryVideoItem, localQQUserUIItem);
            if (!bool) {
              break;
            }
            wxj.a("play_video", "follow_suc", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
            return;
          }
        }
        if (!paramBoolean2) {
          break label326;
        }
        QQToast.a(vls.a(), 1, alud.a(2131703552), 0).a();
      } while (!bool);
      wxj.a("play_video", "follow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
      return;
      QQToast.a(vls.a(), 1, alud.a(2131703550), 0).a();
    } while (!bool);
    wxj.a("play_video", "unfollow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     was
 * JD-Core Version:    0.7.0.1
 */