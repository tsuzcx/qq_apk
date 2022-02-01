import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget.SubscribeStatusReceiver.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.Dispatcher;

public class xoe
  extends vzx
{
  public String a;
  
  private xoe(xnt paramxnt) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt, paramString);
    boolean bool = TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString);
    if (bool) {
      this.jdField_a_of_type_JavaLangString = null;
    }
    StoryVideoItem localStoryVideoItem;
    if (this.jdField_a_of_type_Xnt.a != null)
    {
      localStoryVideoItem = this.jdField_a_of_type_Xnt.a.a();
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
        wke localwke;
        QQUserUIItem localQQUserUIItem;
        do
        {
          return;
          localStoryVideoItem = null;
          break;
          localwke = (wke)wjs.a(2);
          localQQUserUIItem = localwke.b(localStoryVideoItem.mOwnerUid);
        } while ((localQQUserUIItem == null) || (!TextUtils.equals(paramString, localQQUserUIItem.getUnionId())));
        if (paramBoolean1)
        {
          if (paramBoolean2) {}
          for (paramInt = 1;; paramInt = 0)
          {
            localQQUserUIItem.isSubscribe = paramInt;
            ThreadManager.post(new DetailVideoInfoWidget.SubscribeStatusReceiver.1(this, localwke, localQQUserUIItem), 5, null, false);
            if (paramBoolean2)
            {
              paramString = (vzv)wzk.a().getManager(QQManagerFactory.QQSTORY_MANAGER);
              if (!paramString.g())
              {
                paramString.c();
                QQToast.a(wzk.a(), 2, anvx.a(2131702643), 0).a();
              }
              paramString = new yfb(2);
              wad.a().dispatch(paramString);
            }
            xnt.a(this.jdField_a_of_type_Xnt, localStoryVideoItem, localQQUserUIItem);
            if (!bool) {
              break;
            }
            ykv.a("play_video", "follow_suc", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
            return;
          }
        }
        if (!paramBoolean2) {
          break label326;
        }
        QQToast.a(wzk.a(), 1, anvx.a(2131702642), 0).a();
      } while (!bool);
      ykv.a("play_video", "follow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
      return;
      QQToast.a(wzk.a(), 1, anvx.a(2131702640), 0).a();
    } while (!bool);
    ykv.a("play_video", "unfollow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xoe
 * JD-Core Version:    0.7.0.1
 */