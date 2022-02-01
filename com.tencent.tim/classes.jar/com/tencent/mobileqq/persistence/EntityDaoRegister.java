package com.tencent.mobileqq.persistence;

import akux;
import akuy;
import akuz;
import akva;
import akvc;
import akvd;
import akve;
import akvf;
import akvg;
import akvh;
import akvi;
import akvj;
import akvk;
import akvl;
import akvn;
import akvp;
import akvq;
import akvr;
import akvs;
import akvt;
import akvu;
import akvv;
import akvw;
import akvx;
import akvy;
import akvz;
import akwa;
import akwb;
import akwc;
import akwd;
import akwe;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.data.ExpiredPushBanner;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.data.RoamSetting;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.ShieldListInfo;
import com.tencent.mobileqq.data.Stranger;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.data.TroopRemindSettingData;
import com.tencent.mobileqq.statistics.Reporting;
import java.util.HashMap;

public class EntityDaoRegister
{
  private static HashMap<Class, OGAbstractDao> mh = new HashMap(31);
  private static HashMap<Class, Class> mi = new HashMap(31);
  
  static
  {
    System.nanoTime();
    mi.put(ExpiredPushBanner.class, akvh.class);
    mi.put(ContactCard.class, akuz.class);
    mi.put(Groups.class, akvk.class);
    mi.put(TroopRemindSettingData.class, akwe.class);
    mi.put(ShieldListInfo.class, akvy.class);
    mi.put(Setting.class, akvx.class);
    mi.put(Emoticon.class, akve.class);
    mi.put(NearbyPeopleCard.class, akvn.class);
    mi.put(TroopInfo.class, akwc.class);
    mi.put(SearchHistory.class, akvw.class);
    mi.put(CommonlyUsedTroop.class, akuy.class);
    mi.put(TroopMemberInfo.class, akwd.class);
    mi.put(RoamSetting.class, akvv.class);
    mi.put(Friends.class, akvj.class);
    mi.put(ExtensionInfo.class, akvi.class);
    mi.put(TroopAssistantData.class, akwb.class);
    mi.put(HotChatInfo.class, akvl.class);
    mi.put(Card.class, akux.class);
    mi.put(QZoneCover.class, akvs.class);
    mi.put(DiscussionMemberInfo.class, akvd.class);
    mi.put(DiscussionInfo.class, akvc.class);
    mi.put(ResourcePluginInfo.class, akvu.class);
    mi.put(Stranger.class, akvz.class);
    mi.put(SubAccountInfo.class, akwa.class);
    mi.put(EmoticonTab.class, akvg.class);
    mi.put(PhoneContact.class, akvp.class);
    mi.put(ConversationInfo.class, akva.class);
    mi.put(EmoticonPackage.class, akvf.class);
    mi.put(QQOperationViopTipTask.class, akvr.class);
    mi.put(Reporting.class, akvt.class);
    mi.put(PublicAccountInfo.class, akvq.class);
  }
  
  public static OGAbstractDao getEntityDao(Class paramClass)
  {
    localObject1 = (OGAbstractDao)mh.get(paramClass);
    if (localObject1 != null) {}
    Object localObject3;
    do
    {
      return localObject1;
      localObject3 = (Class)mi.get(paramClass);
    } while (localObject3 == null);
    synchronized (mh)
    {
      localObject2 = (OGAbstractDao)mh.get(paramClass);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.EntityDaoRegister
 * JD-Core Version:    0.7.0.1
 */