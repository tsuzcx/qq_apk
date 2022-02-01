package com.tencent.qqmail.protocol;

import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.uma.QMUmaManager;

public class CloudProtocolService
{
  private static QMUmaManager umaManager = ;
  
  static
  {
    QMPrivateProtocolManager.sharedInstance().registerGeneralCallback();
  }
  
  public static void AddADBWContact(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.addADBWContact(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void AddAccount(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.addAccount(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void CheckPendingTips(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.checkPendingTips(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void CheckUpgrade(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.checkUpgrade(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void ClearContactType(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.clearContactType(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void ContactCreateNewContact(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.contactCreateNewContact(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void ContactDelContactList(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.contactDelContactList(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void ContactModifyContactInfo(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.contactModifyContactInfo(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void ContactSyncContactList(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.contactSyncContactList(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void DelADBWContact(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.delADBWContact(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void DelPhoto(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.delEmailPhoto(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void DeleteAccount(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.deleteAccount(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void DeleteGreetingCard(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.deleteGreetingCard(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void GetBirthFriendList(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.getBirthFriendList(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void GetGreetingCards(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.getGreetingCards(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void GetRsa(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.getRsa(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void GetThankFriendList(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.getThankFriendList(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static String GetUmaLoginSessionKey()
  {
    return umaManager.getUmaLoginSessionKey();
  }
  
  public static void GetUserSetting(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.getUserSetting(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void Login(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.login(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void Logout(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.logout(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void LstADBWContact(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.lstADBWContact(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void LstAccount(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.lstAccount(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void ModAccount(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.modAccount(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void OpenMobileAcct(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.openMobileAcct(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void ParsePhoto(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.getParsePhoto(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void PushConfigHandle(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.pushConfigHandle(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void QueryConfigUpdate(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.queryConfigUpdate(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void QueryDomainConfig(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.queryDomainConfig(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void QueryEmailType(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.queryEmailType(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void QuerySecApp(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.querySecApp(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void Register(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.register(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void SaveGreetingCard(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.saveGreetingCard(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void SetCloudProtocolLoginCallback(OnProtocolListener paramOnProtocolListener)
  {
    umaManager.setCloudProtocolLoginCallback(paramOnProtocolListener);
  }
  
  public static void SetContactType(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.setContactType(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void SetNick(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.setNick(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void SetPhoto(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.setPhoto(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void SetUserSetting(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.setUserSetting(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void SyncGreetingCardList(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.syncGreetingCardList(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void SyncNick(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.syncNick(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void SyncPhoto(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.syncPhoto(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void SyncPhotoBy302(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.syncPhotoBy302(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void ThankGreetingCard(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.thankGreetingCard(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void Translate(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.translate(paramCloudProtocolInfo, paramOnProtocolListener);
  }
  
  public static void adMailReportDeleteAndUnlike(CloudProtocolInfo paramCloudProtocolInfo, OnProtocolListener paramOnProtocolListener)
  {
    umaManager.reportAdMailDeleteAndUnlike(paramCloudProtocolInfo, paramOnProtocolListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.CloudProtocolService
 * JD-Core Version:    0.7.0.1
 */