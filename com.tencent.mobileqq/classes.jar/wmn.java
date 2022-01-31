import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch.RefreshCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.campuscircle.CampusCircleHelper;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.NumRedPointManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.wholepeople.WholePeopleConstant;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.storage.ReadInJoyNotifyRedTouchInfo;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class wmn
  implements Runnable
{
  public wmn(LebaTabRedTouch paramLebaTabRedTouch, LebaTabRedTouch.RefreshCallback paramRefreshCallback) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch.a == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch.a.app == null)) {
      return;
    }
    oidb_0x791.RedDotInfo localRedDotInfo;
    int i;
    Object localObject3;
    try
    {
      Object localObject1 = (TroopRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch.a.app.getManager(69);
      localRedDotInfo = ((TroopRedTouchManager)localObject1).a();
      i = -1;
      if (localRedDotInfo != null) {
        i = localRedDotInfo.uint32_appid.get();
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch.a.app.a().a) && (i == 11))
      {
        localObject3 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_type.set(4);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_content.set(localRedDotInfo.str_custom_buffer.get().toStringUtf8());
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject3).red_desc.set("{'cn':'#FF0000', 'av':1}");
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.qqstory.redPointMainAssistObserver", 2, "story文字、图片红点,storyAppid:" + i);
          localObject1 = localObject3;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch$RefreshCallback.a((BusinessInfoCheckUpdate.RedTypeInfo)localObject1);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify Exception was thrown when update red point.", localException);
      return;
    }
    int i2 = localException.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch.a.app);
    int i3 = localException.a();
    int i4 = ((NumRedPointManager)this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch.a.app.getManager(63)).a(0);
    if (QLog.isColorLevel()) {
      QLog.i("MainAssistObserver.LebaTabRedTouch", 2, "troop red point-->redPointNums=" + i2 + ", redNumPointNums=" + i3 + ", numRedNums=" + i4);
    }
    Object localObject2 = ((LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch.a.app.getManager(159)).a(100510);
    label357:
    boolean bool1;
    label373:
    int j;
    label466:
    int i5;
    int k;
    label558:
    boolean bool2;
    label574:
    int m;
    label701:
    int i1;
    if ((localObject2 != null) && (((RedTouchItem)localObject2).unReadFlag) && (((RedTouchItem)localObject2).redtouchType == 2))
    {
      i = ((RedTouchItem)localObject2).count;
      if ((localObject2 != null) && (((RedTouchItem)localObject2).unReadFlag))
      {
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.i("MainAssistObserver.LebaTabRedTouch", 2, "nearby red point-->nearbyNum=" + i + ", nearbyHasRedPoint=" + bool1);
        }
        localObject2 = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch.a.app.getManager(35)).a();
        if ((localObject2 != null) && (((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.get() == 5))
        {
          j = Integer.parseInt(((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.get());
          if (QLog.isColorLevel()) {
            QLog.i("MainAssistObserver.LebaTabRedTouch", 2, "business red point-->numRedTouch=" + j);
          }
          i5 = LebaTabRedTouch.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch);
          if (QLog.isColorLevel()) {
            QLog.i("MainAssistObserver.LebaTabRedTouch", 2, "QZone red point-->qzonMsgCount=" + i5);
          }
          localObject3 = LebaTabRedTouch.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch);
          if (localObject3 == null) {
            break label1142;
          }
          k = ((ReadInJoyNotifyRedTouchInfo)localObject3).a();
          if ((localObject3 == null) || (!((ReadInJoyNotifyRedTouchInfo)localObject3).a())) {
            break label1147;
          }
          bool2 = true;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("readInJoy red point-->readInJoyNotifyCount=").append(k).append(", isReadinjoyNotifyNeedsDisplay=").append(bool2);
            QLog.i("MainAssistObserver.LebaTabRedTouch", 2, ((StringBuilder)localObject3).toString());
          }
          if ((localRedDotInfo != null) && ((localRedDotInfo.uint32_appid.get() == 28) || (localRedDotInfo.uint32_appid.get() == 49)) && (!this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch.a.app.a().a) && (this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch.a.app.a().b()))
          {
            m = localRedDotInfo.uint32_number.get();
            i1 = CampusCircleHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch.a.app, 2, true);
            if (i1 <= 0) {
              break label1153;
            }
          }
        }
      }
    }
    label1153:
    for (int n = i1;; n = 0)
    {
      int i6 = WholePeopleConstant.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch.a.app, true);
      int i7 = WholePeopleConstant.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch.a.app, false);
      int i8 = i5 + j + i3 + i4 + k + i + m + n + i6;
      QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify: totalCount=" + i8 + ", qz=" + i5 + ", numRedTouch=" + j + ", redNumPointNums=" + i3 + ", numRedNums=" + i4 + ", readInJoyNotifyCount=" + k + ", nearbyNum=" + i + ", storyRedNum=" + m + ", campusRedTouchCountForAdd=" + n + ", allPeopleVoteRedNumCount=" + i6);
      if (i8 > 0)
      {
        localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(5);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set(i8 + "");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("{'cn':'#FF0000'}");
        break;
      }
      if (localObject2 != null)
      {
        QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify redTypeInfo != null.");
        break;
      }
      if ((i2 > 0) || (LebaTabRedTouch.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainLebaTabRedTouch)) || (bool2) || (bool1) || (i1 == 0) || (i7 > 0))
      {
        localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(0);
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_content.set("");
        ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_desc.set("");
        QLog.i("MainAssistObserver.LebaTabRedTouch", 1, "updateTabLebaNotify hasReddot; redpointMums = " + i2 + ",isReadinjoyNotifyNeedsDisplay" + bool2 + ",nearbyHasRedPoint = " + bool1 + ", allPeopleVotePointCount=" + i7);
        break;
      }
      localObject2 = null;
      break;
      m = 0;
      break label701;
      j = 0;
      break label466;
      bool1 = false;
      break label373;
      i = 0;
      break label357;
      label1142:
      k = 0;
      break label558;
      label1147:
      bool2 = false;
      break label574;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wmn
 * JD-Core Version:    0.7.0.1
 */