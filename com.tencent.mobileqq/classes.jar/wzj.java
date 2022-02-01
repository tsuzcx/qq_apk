import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget.SubscribeStatusReceiver.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.Dispatcher;

public class wzj
  extends vlc
{
  public String a;
  
  private wzj(wyy paramwyy) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt, paramString);
    boolean bool = TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString);
    if (bool) {
      this.jdField_a_of_type_JavaLangString = null;
    }
    StoryVideoItem localStoryVideoItem;
    if (this.jdField_a_of_type_Wyy.a != null)
    {
      localStoryVideoItem = this.jdField_a_of_type_Wyy.a.a();
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
        vvj localvvj;
        QQUserUIItem localQQUserUIItem;
        do
        {
          return;
          localStoryVideoItem = null;
          break;
          localvvj = (vvj)vux.a(2);
          localQQUserUIItem = localvvj.b(localStoryVideoItem.mOwnerUid);
        } while ((localQQUserUIItem == null) || (!TextUtils.equals(paramString, localQQUserUIItem.getUnionId())));
        if (paramBoolean1)
        {
          if (paramBoolean2) {}
          for (paramInt = 1;; paramInt = 0)
          {
            localQQUserUIItem.isSubscribe = paramInt;
            ThreadManager.post(new DetailVideoInfoWidget.SubscribeStatusReceiver.1(this, localvvj, localQQUserUIItem), 5, null, false);
            if (paramBoolean2)
            {
              paramString = (vla)wkp.a().getManager(181);
              if (!paramString.g())
              {
                paramString.c();
                QQToast.a(wkp.a(), 2, amtj.a(2131702292), 0).a();
              }
              paramString = new xqg(2);
              vli.a().dispatch(paramString);
            }
            wyy.a(this.jdField_a_of_type_Wyy, localStoryVideoItem, localQQUserUIItem);
            if (!bool) {
              break;
            }
            xwa.a("play_video", "follow_suc", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
            return;
          }
        }
        if (!paramBoolean2) {
          break label326;
        }
        QQToast.a(wkp.a(), 1, amtj.a(2131702291), 0).a();
      } while (!bool);
      xwa.a("play_video", "follow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
      return;
      QQToast.a(wkp.a(), 1, amtj.a(2131702289), 0).a();
    } while (!bool);
    xwa.a("play_video", "unfollow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzj
 * JD-Core Version:    0.7.0.1
 */