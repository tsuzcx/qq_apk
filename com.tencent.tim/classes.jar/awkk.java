import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.ARMapHongBaoListView;
import cooperation.vip.ad.TianshuPendantHolder;
import cooperation.vip.pb.TianShuAccess.AdItem;
import cooperation.vip.pb.TianShuAccess.AdPlacementInfo;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import cooperation.vip.pb.TianShuAccess.RspEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class awkk
{
  private awkn jdField_a_of_type_Awkn;
  private awks jdField_a_of_type_Awks;
  private Conversation jdField_a_of_type_ComTencentMobileqqActivityConversation;
  private TianshuPendantHolder jdField_a_of_type_CooperationVipAdTianshuPendantHolder;
  private awms jdField_c_of_type_Awms = new awkl(this);
  private ARMapHongBaoListView jdField_c_of_type_ComTencentWidgetARMapHongBaoListView;
  private QQAppInterface mApp;
  
  public awkk(QQAppInterface paramQQAppInterface, Conversation paramConversation, ARMapHongBaoListView paramARMapHongBaoListView)
  {
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.jdField_c_of_type_ComTencentWidgetARMapHongBaoListView = paramARMapHongBaoListView;
  }
  
  private void a(TianShuAccess.AdItem paramAdItem)
  {
    if (this.jdField_a_of_type_Awkn == null) {
      this.jdField_a_of_type_Awkn = new awkn(this.jdField_a_of_type_ComTencentMobileqqActivityConversation);
    }
    this.jdField_a_of_type_Awkn.d(paramAdItem);
  }
  
  private void a(TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if ((this.mApp == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityConversation == null)) {}
    do
    {
      HashMap localHashMap;
      do
      {
        for (;;)
        {
          return;
          if (paramGetAdsRsp.mapAds.has()) {}
          for (paramGetAdsRsp = paramGetAdsRsp.mapAds.get(); paramGetAdsRsp != null; paramGetAdsRsp = null)
          {
            localHashMap = new HashMap();
            paramGetAdsRsp = paramGetAdsRsp.iterator();
            while (paramGetAdsRsp.hasNext())
            {
              TianShuAccess.RspEntry localRspEntry = (TianShuAccess.RspEntry)paramGetAdsRsp.next();
              if ((localRspEntry != null) && (localRspEntry.key.has())) {
                localHashMap.put(Integer.valueOf(localRspEntry.key.get()), localRspEntry);
              }
            }
          }
        }
        paramGetAdsRsp = (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(340));
        if ((paramGetAdsRsp != null) && (paramGetAdsRsp.value != null) && (paramGetAdsRsp.value.lst.size() != 0) && (paramGetAdsRsp.value.lst.get(0) != null)) {
          a((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0));
        }
        paramGetAdsRsp = (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(341));
        if ((paramGetAdsRsp != null) && (paramGetAdsRsp.value != null) && (paramGetAdsRsp.value.lst.size() != 0) && (paramGetAdsRsp.value.lst.get(0) != null)) {
          b((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0));
        }
      } while ((this.jdField_c_of_type_ComTencentWidgetARMapHongBaoListView == null) || (this.jdField_c_of_type_ComTencentWidgetARMapHongBaoListView.b != null));
      paramGetAdsRsp = (TianShuAccess.RspEntry)localHashMap.get(Integer.valueOf(339));
    } while ((paramGetAdsRsp == null) || (paramGetAdsRsp.value == null) || (paramGetAdsRsp.value.lst.size() == 0) || (paramGetAdsRsp.value.lst.get(0) == null));
    c((TianShuAccess.AdItem)paramGetAdsRsp.value.lst.get(0));
  }
  
  private void b(TianShuAccess.AdItem paramAdItem)
  {
    if (this.jdField_c_of_type_ComTencentWidgetARMapHongBaoListView != null)
    {
      if (this.jdField_a_of_type_CooperationVipAdTianshuPendantHolder == null)
      {
        this.jdField_a_of_type_CooperationVipAdTianshuPendantHolder = new TianshuPendantHolder(this.mApp, this.jdField_c_of_type_ComTencentWidgetARMapHongBaoListView);
        this.jdField_a_of_type_CooperationVipAdTianshuPendantHolder.cUo();
      }
      this.jdField_a_of_type_CooperationVipAdTianshuPendantHolder.e(paramAdItem);
      this.jdField_c_of_type_ComTencentWidgetARMapHongBaoListView.setPendantHolder(this.jdField_a_of_type_CooperationVipAdTianshuPendantHolder);
      this.jdField_c_of_type_ComTencentWidgetARMapHongBaoListView.setOnPendentClickListener(this.jdField_a_of_type_CooperationVipAdTianshuPendantHolder);
    }
  }
  
  private void c(TianShuAccess.AdItem paramAdItem)
  {
    if (this.jdField_c_of_type_ComTencentWidgetARMapHongBaoListView != null)
    {
      if (this.jdField_a_of_type_Awks == null)
      {
        this.jdField_a_of_type_Awks = new awks(this.mApp, this.jdField_c_of_type_ComTencentWidgetARMapHongBaoListView);
        this.jdField_a_of_type_Awks.cUo();
      }
      this.jdField_a_of_type_Awks.e(paramAdItem);
      this.jdField_c_of_type_ComTencentWidgetARMapHongBaoListView.a(this.jdField_a_of_type_Awks);
    }
  }
  
  public void bMd()
  {
    awmt.a().a(awkm.hC(), this.jdField_c_of_type_Awms);
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    if (this.jdField_c_of_type_ComTencentWidgetARMapHongBaoListView != null)
    {
      this.jdField_c_of_type_ComTencentWidgetARMapHongBaoListView.setPendantHolder(null);
      this.jdField_c_of_type_ComTencentWidgetARMapHongBaoListView.ewD();
      this.jdField_c_of_type_ComTencentWidgetARMapHongBaoListView.setOnPendentClickListener(null);
    }
    this.jdField_a_of_type_Awks = null;
    this.jdField_a_of_type_CooperationVipAdTianshuPendantHolder = null;
  }
  
  public void onDestroy()
  {
    this.mApp = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awkk
 * JD-Core Version:    0.7.0.1
 */