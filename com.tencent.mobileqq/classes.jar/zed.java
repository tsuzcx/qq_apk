import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive.RoomIcon;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.Iterator;
import java.util.List;

class zed
  implements View.OnClickListener
{
  zed(zec paramzec, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.roomId.has())) {}
    for (String str1 = String.valueOf(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.roomId.get());; str1 = "")
    {
      if (zds.a(this.jdField_a_of_type_Zec.a) == 0)
      {
        zds.a(this.jdField_a_of_type_Zec.a, 6);
        MobileReportManager.getInstance().reportActionLive(str1 + "", "25", "qq_live", "tab_page", "subscribe", 102, 1, System.currentTimeMillis(), str1 + "");
      }
      for (;;)
      {
        Object localObject2 = "";
        Object localObject1 = localObject2;
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.rtmpURL != null)
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.rtmpURL.has()) {
              localObject1 = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.rtmpURL.get();
            }
          }
        }
        String str2 = "";
        Iterator localIterator = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.roomIcon.get().iterator();
        do
        {
          localObject2 = str2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = (CertifiedAccountMeta.StLive.RoomIcon)localIterator.next();
        } while (!"1:1".equals(((CertifiedAccountMeta.StLive.RoomIcon)localObject2).size.get()));
        localObject2 = ((CertifiedAccountMeta.StLive.RoomIcon)localObject2).url.get();
        this.jdField_a_of_type_Zec.a.a(this.jdField_a_of_type_Zec.itemView.getContext(), str1, (String)localObject1, this.jdField_a_of_type_Zec.a.b(), zds.b(this.jdField_a_of_type_Zec.a), (String)localObject2);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (zds.a(this.jdField_a_of_type_Zec.a) == 1)
        {
          zds.a(this.jdField_a_of_type_Zec.a, 5);
          MobileReportManager.getInstance().reportActionLive(str1 + "", "25", "qq_live", "find_page", "hot_push", 102, 1, System.currentTimeMillis(), str1 + "");
        }
        else if (zds.a(this.jdField_a_of_type_Zec.a) == 2)
        {
          zds.a(this.jdField_a_of_type_Zec.a, 2);
          MobileReportManager.getInstance().reportActionLive(str1 + "", "25", "qq_live", "shopcart_page", "hot_push", 102, 1, System.currentTimeMillis(), str1 + "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zed
 * JD-Core Version:    0.7.0.1
 */