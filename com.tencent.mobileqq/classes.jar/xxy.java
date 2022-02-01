import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget.SubscribeStatusReceiver.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.Dispatcher;

public class xxy
  extends wjd
{
  public String a;
  
  private xxy(xxn paramxxn) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt, paramString);
    boolean bool = TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString);
    if (bool) {
      this.jdField_a_of_type_JavaLangString = null;
    }
    StoryVideoItem localStoryVideoItem;
    if (this.jdField_a_of_type_Xxn.a != null)
    {
      localStoryVideoItem = this.jdField_a_of_type_Xxn.a.a();
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
        wtt localwtt;
        QQUserUIItem localQQUserUIItem;
        do
        {
          return;
          localStoryVideoItem = null;
          break;
          localwtt = (wtt)wth.a(2);
          localQQUserUIItem = localwtt.b(localStoryVideoItem.mOwnerUid);
        } while ((localQQUserUIItem == null) || (!TextUtils.equals(paramString, localQQUserUIItem.getUnionId())));
        if (paramBoolean1)
        {
          if (paramBoolean2) {}
          for (paramInt = 1;; paramInt = 0)
          {
            localQQUserUIItem.isSubscribe = paramInt;
            ThreadManager.post(new DetailVideoInfoWidget.SubscribeStatusReceiver.1(this, localwtt, localQQUserUIItem), 5, null, false);
            if (paramBoolean2)
            {
              paramString = (wjb)xiz.a().getManager(181);
              if (!paramString.g())
              {
                paramString.c();
                QQToast.a(xiz.a(), 2, anzj.a(2131702057), 0).a();
              }
              paramString = new yov(2);
              wjj.a().dispatch(paramString);
            }
            xxn.a(this.jdField_a_of_type_Xxn, localStoryVideoItem, localQQUserUIItem);
            if (!bool) {
              break;
            }
            yup.a("play_video", "follow_suc", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
            return;
          }
        }
        if (!paramBoolean2) {
          break label326;
        }
        QQToast.a(xiz.a(), 1, anzj.a(2131702056), 0).a();
      } while (!bool);
      yup.a("play_video", "follow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
      return;
      QQToast.a(xiz.a(), 1, anzj.a(2131702054), 0).a();
    } while (!bool);
    yup.a("play_video", "unfollow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxy
 * JD-Core Version:    0.7.0.1
 */