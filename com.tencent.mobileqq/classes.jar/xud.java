import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.playerwidget.DetailVideoInfoWidget.SubscribeStatusReceiver.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.dispatch.Dispatcher;

public class xud
  extends wfi
{
  public String a;
  
  private xud(xts paramxts) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt, paramString);
    boolean bool = TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramString);
    if (bool) {
      this.jdField_a_of_type_JavaLangString = null;
    }
    StoryVideoItem localStoryVideoItem;
    if (this.jdField_a_of_type_Xts.a != null)
    {
      localStoryVideoItem = this.jdField_a_of_type_Xts.a.a();
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
        wpy localwpy;
        QQUserUIItem localQQUserUIItem;
        do
        {
          return;
          localStoryVideoItem = null;
          break;
          localwpy = (wpy)wpm.a(2);
          localQQUserUIItem = localwpy.b(localStoryVideoItem.mOwnerUid);
        } while ((localQQUserUIItem == null) || (!TextUtils.equals(paramString, localQQUserUIItem.getUnionId())));
        if (paramBoolean1)
        {
          if (paramBoolean2) {}
          for (paramInt = 1;; paramInt = 0)
          {
            localQQUserUIItem.isSubscribe = paramInt;
            ThreadManager.post(new DetailVideoInfoWidget.SubscribeStatusReceiver.1(this, localwpy, localQQUserUIItem), 5, null, false);
            if (paramBoolean2)
            {
              paramString = (wfg)xfe.a().getManager(181);
              if (!paramString.g())
              {
                paramString.c();
                QQToast.a(xfe.a(), 2, anni.a(2131701950), 0).a();
              }
              paramString = new yla(2);
              wfo.a().dispatch(paramString);
            }
            xts.a(this.jdField_a_of_type_Xts, localStoryVideoItem, localQQUserUIItem);
            if (!bool) {
              break;
            }
            yqu.a("play_video", "follow_suc", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
            return;
          }
        }
        if (!paramBoolean2) {
          break label326;
        }
        QQToast.a(xfe.a(), 1, anni.a(2131701949), 0).a();
      } while (!bool);
      yqu.a("play_video", "follow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
      return;
      QQToast.a(xfe.a(), 1, anni.a(2131701947), 0).a();
    } while (!bool);
    yqu.a("play_video", "unfollow_fail", 0, 0, new String[] { "", "", "", localStoryVideoItem.mVid });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xud
 * JD-Core Version:    0.7.0.1
 */