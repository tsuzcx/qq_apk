import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget.SubscribeStatusReceiver.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.Dispatcher;

public class vwj
  extends uhn
{
  public String a;
  
  private vwj(vvy paramvvy) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt, paramString);
    boolean bool = TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString);
    if (bool) {
      this.jdField_a_of_type_JavaLangString = null;
    }
    StoryVideoItem localStoryVideoItem;
    if (this.jdField_a_of_type_Vvy.a != null)
    {
      localStoryVideoItem = this.jdField_a_of_type_Vvy.a.a();
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
        usd localusd;
        QQUserUIItem localQQUserUIItem;
        do
        {
          return;
          localStoryVideoItem = null;
          break;
          localusd = (usd)urr.a(2);
          localQQUserUIItem = localusd.b(localStoryVideoItem.mOwnerUid);
        } while ((localQQUserUIItem == null) || (!TextUtils.equals(paramString, localQQUserUIItem.getUnionId())));
        if (paramBoolean1)
        {
          if (paramBoolean2) {}
          for (paramInt = 1;; paramInt = 0)
          {
            localQQUserUIItem.isSubscribe = paramInt;
            ThreadManager.post(new DetailVideoInfoWidget.SubscribeStatusReceiver.1(this, localusd, localQQUserUIItem), 5, null, false);
            if (paramBoolean2)
            {
              paramString = (uhl)vhj.a().getManager(181);
              if (!paramString.g())
              {
                paramString.c();
                QQToast.a(vhj.a(), 2, alpo.a(2131703541), 0).a();
              }
              paramString = new wng(2);
              uht.a().dispatch(paramString);
            }
            vvy.a(this.jdField_a_of_type_Vvy, localStoryVideoItem, localQQUserUIItem);
            if (!bool) {
              break;
            }
            wta.a("play_video", "follow_suc", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
            return;
          }
        }
        if (!paramBoolean2) {
          break label326;
        }
        QQToast.a(vhj.a(), 1, alpo.a(2131703540), 0).a();
      } while (!bool);
      wta.a("play_video", "follow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
      return;
      QQToast.a(vhj.a(), 1, alpo.a(2131703538), 0).a();
    } while (!bool);
    wta.a("play_video", "unfollow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vwj
 * JD-Core Version:    0.7.0.1
 */