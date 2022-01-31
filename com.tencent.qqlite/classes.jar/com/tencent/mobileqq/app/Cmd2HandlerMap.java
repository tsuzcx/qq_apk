package com.tencent.mobileqq.app;

import java.util.HashMap;
import java.util.Map;

public class Cmd2HandlerMap
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a;
  private static Map jdField_a_of_type_JavaUtilMap;
  
  static
  {
    jdField_a_of_type_JavaLangString = Cmd2HandlerMap.class.getName();
  }
  
  public static Map a()
  {
    if (jdField_a_of_type_JavaUtilMap == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_JavaUtilMap == null) {
        a();
      }
      return jdField_a_of_type_JavaUtilMap;
    }
  }
  
  private static void a()
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put("AccostSvc.SvrMsg", new int[] { 0, 2 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.getGroupInfoReq", new int[] { 17, 2 });
    jdField_a_of_type_JavaUtilMap.put("AccostSvc.ClientMsg", new int[] { 0, 2 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.GetSimpleInfo", new int[] { 6, 1 });
    jdField_a_of_type_JavaUtilMap.put("AccostSvc.ReqDeleteBlackList", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("AccostSvc.ReqInsertBlackList", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("AccostSvc.ReqGetBlackList", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("TransService.ReqGetSign", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.GroupMsgReadConfirm", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("SharpSvr.s2c", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.PbGetRoamMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.DelRoamMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("SharpSvr.c2sack", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.RequestPushStatus", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.DisMsgReadConfirm", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("ADMsgSvc.PushMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("StreamSvr.PushStreamMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("OnlinePush.ReqPush", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("OnlinePush.PbPushTransMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("OnlinePush.PbC2CMsgSync", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.PbBindUinGetMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("PbMessageSvc.PbBindUinMsgReadedConfirm", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("OnlinePush.PbPushDisMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.PullGroupMsgSeq", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.PbGetOneDayRoamMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("StreamSvr.RespUploadStreamMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.SetRoamMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("TransService.ReqOffFilePack", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.PbGetGroupMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.PbGetDiscussMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.DelMsgV2", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.SetRoamMsgAllUser", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("OnlinePush.PbPushGroupMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("VideoSvc.Send", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("VideoCCSvc.PutInfo", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("StreamSvr.UploadStreamMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("NearFieldTranFileSvr.NotifyList", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.MsgReadedReport", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.PbSendMsg", new int[] { 0, 8 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.PushReaded", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("OnlinePush.RespPush", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("TransService.ReqTmpChatPicDownload", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.PbGetMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("PbMessageSvc.PbDelOneRoamMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.PushNotify", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("MessageSvc.GetMsgV4", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("RegPrxySvc.PullDisMsgSeq", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("RegPrxySvc.PbGetMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("RegPrxySvc.GetMsgV2", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("RegPrxySvc.PbGetDiscussMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("RegPrxySvc.PbGetGroupMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("RegPrxySvc.PullDisGroupSeq", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("RegPrxySvc.NoticeEnd", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("RegPrxySvc.infoLogin", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("RegPrxySvc.PullGroupMsgSeq", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("RegPrxySvc.getOffMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.Pb.ReqNextSystemMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.Pb.ReqSystemMsgRead", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.Pb.ReqSystemMsg", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.Pb.ReqSystemMsgNew", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.Pb.ReqSystemMsgNew.Friend", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.Pb.ReqSystemMsgNew.Group", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.Pb.ReqSystemMsgAction", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("PbMessageSvc.PbMsgReadedReport", new int[] { 0 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x5e1_8", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("friendlist.delFriend", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("friendlist.GetAutoInfoReq", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("friendlist.SetGroupReq", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("friendlist.GetLastLoginInfoReq", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("friendlist.getFriendGroupList", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("friendlist.MovGroupMemReq", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("friendlist.GetSimpleOnlineFriendInfoReq", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("BumpSvc.ReqComfirmContactFriend", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("friendlist.addFriend", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("friendlist.getUserAddFriendSetting", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x5d1_0", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x4fc_30", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("DevLockAuthSvc.RecommendAuth", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("DevLockAuthSvc.ConfirmAuth", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("SummaryCard.ReqSearch", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("SummaryCard.ReqCondSearch", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("AvatarInfoSvr.QQHeadUrlReq", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.ReqGetSettings", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("StatSvc.register", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.GetRichSig", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("StatSvc.DelDevLoginInfo", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.ReqSetSettings", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("StatSvc.SvcReqKikOut", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.CheckUpdateReq", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.ChangeFriendName", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.SetRichSig", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("IncreaseURLSvr.QQHeadUrlReq", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("MultibusidURLSvr.HeadUrlReq", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("StatSvc.GetDevLoginInfo", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("friendlist.GetOnlineInfoReq", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x49d_107", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x476_146", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x476_147", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x491_107", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x490_107", new int[] { 1 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.ReqBatchProcess", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x8c9_2", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x88d_0", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x88d_7", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x8b8_1", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x88d_10", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.GroupMngReq", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("friendlist.GetMultiTroopInfoReq", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x8fd_0", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("friendlist.GetTroopListReqV2", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("friendlist.GetTroopAppointRemarkReq", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x899_0", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("friendlist.ModifyGroupInfoReq", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("friendlist.getTroopMemberList", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("group_member_card.get_group_member_card_info", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x89e_0", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("friendlist.getTroopRemark", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x88d_1", new int[] { 19, 17 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x8a0_0", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("friendlist.ModifyGroupCardReq", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x8bb_2", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("anony_msg.group", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x8bb_3", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x8b4", new int[] { 17, 19 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x5d6_3", new int[] { 17, 19 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x787_0", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x8a7_0", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x8ca_2", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x787_1", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("VisitorSvc.ReqFavorite", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("MCardSvc.ReqUpdateQQFace", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x491_100", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("MCardSvc.ReqUpdateIntro", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("VisitorSvc.ReqGetVoterList", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("PttCenterSvr.ReqBody", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("MCardSvc.ReqHYMakeFriendsCard", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("MCardSvc.ReqCommonCard", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("VisitorSvc.ReqGetVisitorList", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("VisitorSvc.ReqGetFavoriteList", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("SummaryCard.ReqSummaryCard", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("MCardSvc.ReqFaceInfo", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("SummaryCard.ReqVoiceManage", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("MCardSvc.ReqGetFace", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("MCardSvc.ReqDelFace", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("MCardSvc.ReqGetCardSwitch", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("MCardSvc.ReqPicSafetyCheck", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("MobileQQ.SendPortraitDownloadVerifyCode", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("MCardSvc.ReqMakeFriendsCard", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("MCardSvc.ReqSetCard", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("MCardSvc.ReqSetCardSwitch", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x490_100", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("VisitorSvc.ReqVote", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("MCardSvc.ReqAddFace", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("MCardSvc.ReqHYCommonCard", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("SummaryCard.SetLabel", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("SummaryCard.LikeIt", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.SetUserInfoReq", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.GetSglUsrFullInfo", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("ProfileService.getFriendInfoReq", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x480_9", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x4ff_9", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x5ea_1", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x5ea_2", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x5ea_3", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x5ea_4", new int[] { 2 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x82f_0", new int[] { 4 });
    jdField_a_of_type_JavaUtilMap.put("NearbyGroup.GetGroupList", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("EncounterSvc.ReqGetEncounter", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("LBS.AddressService", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("NeighborSvc.ReqGetSwitches", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("NeighborSvc.ReqSetStateSwitch", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("NeighborSvc.ReqGetPoint", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("NeighborSvc.ReqSetUserState", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("QzoneService.knrsNew", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("NearbyGroup.ReqGetAreaList", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("NearbyGroup.ReqGetGroupInArea", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x568_20", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("LbsShareSvr.nearby_shops", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("LbsShareSvr.location", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("LbsShareSvr.get_shops_by_ids", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("FanpaiziSvc.ReqGetList", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("FanpaiziSvc.Prise", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("FanpaiziSvc.Dislike", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("RoamClientSvr.GetQualify", new int[] { 3 });
    jdField_a_of_type_JavaUtilMap.put("ConfigService.ClientReq", new int[] { 4 });
    jdField_a_of_type_JavaUtilMap.put("ConfigService.GetResourceReq", new int[] { 4 });
    jdField_a_of_type_JavaUtilMap.put("MobileTipsSvc.TipsReport", new int[] { 4 });
    jdField_a_of_type_JavaUtilMap.put("QQServiceDiscussSvc.ReqGetDiscussInteRemark", new int[] { 6 });
    jdField_a_of_type_JavaUtilMap.put("QRCodeSvc.discuss_geturl", new int[] { 6 });
    jdField_a_of_type_JavaUtilMap.put("QQServiceDiscussSvc.ReqGetDiscuss", new int[] { 6 });
    jdField_a_of_type_JavaUtilMap.put("QQServiceDiscussSvc.ReqCreateDiscuss", new int[] { 6 });
    jdField_a_of_type_JavaUtilMap.put("QRCodeSvc.discuss_decode", new int[] { 6 });
    jdField_a_of_type_JavaUtilMap.put("QQServiceDiscussSvc.ReqJoinDiscuss", new int[] { 6 });
    jdField_a_of_type_JavaUtilMap.put("QQServiceDiscussSvc.ReqSetDiscussFlag", new int[] { 6 });
    jdField_a_of_type_JavaUtilMap.put("QQServiceDiscussSvc.ReqChangeDiscussName", new int[] { 6 });
    jdField_a_of_type_JavaUtilMap.put("QQServiceDiscussSvc.ReqAddDiscussMember", new int[] { 6 });
    jdField_a_of_type_JavaUtilMap.put("QQServiceDiscussSvc.ReqSetDiscussAttr", new int[] { 6 });
    jdField_a_of_type_JavaUtilMap.put("QQServiceDiscussSvc.ReqGetDiscussInfo", new int[] { 6 });
    jdField_a_of_type_JavaUtilMap.put("QQServiceDiscussSvc.ReqQuitDiscuss", new int[] { 6 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x865_3", new int[] { 6 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x921_0", new int[] { 6 });
    jdField_a_of_type_JavaUtilMap.put("QzoneService.GetNewAndUnread", new int[] { 7 });
    jdField_a_of_type_JavaUtilMap.put("TransService.FileDeleteReq", new int[] { 8 });
    jdField_a_of_type_JavaUtilMap.put("RegPrxySvc.PushParam", new int[] { 9 });
    jdField_a_of_type_JavaUtilMap.put("RegPrxySvc.infoAndroid", new int[] { 9 });
    jdField_a_of_type_JavaUtilMap.put("BQMallSvc.TabOpReq", new int[] { 11 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x490_92", new int[] { 11 });
    jdField_a_of_type_JavaUtilMap.put("AvatarUpdate.checkUpdate", new int[] { 12 });
    jdField_a_of_type_JavaUtilMap.put("AuthSvr.ThemeAuth", new int[] { 13 });
    jdField_a_of_type_JavaUtilMap.put("ClubContentUpdate.Req", new int[] { 14 });
    jdField_a_of_type_JavaUtilMap.put("SsoSnsSession.Cmd0x3_SubCmd0x3_FuncDelBlockList", new int[] { 15 });
    jdField_a_of_type_JavaUtilMap.put("SsoSnsSession.Cmd0x3_SubCmd0x1_FuncGetBlockList", new int[] { 15 });
    jdField_a_of_type_JavaUtilMap.put("SsoSnsSession.Cmd0x3_SubCmd0x2_FuncAddBlockList", new int[] { 15 });
    jdField_a_of_type_JavaUtilMap.put("StatSvc.InSaveTraffic", new int[] { 16 });
    jdField_a_of_type_JavaUtilMap.put("StatSvc.OutSaveTraffic", new int[] { 16 });
    jdField_a_of_type_JavaUtilMap.put("GroupSvc.JoinGroupLink", new int[] { 17 });
    jdField_a_of_type_JavaUtilMap.put("mq_crm.get_menu", new int[] { 18 });
    jdField_a_of_type_JavaUtilMap.put("mq_crm.send_key", new int[] { 18 });
    jdField_a_of_type_JavaUtilMap.put("EqqAccountSvc.get_eqq_list", new int[] { 18 });
    jdField_a_of_type_JavaUtilMap.put("CrmSvcEx.ReportLbs", new int[] { 18 });
    jdField_a_of_type_JavaUtilMap.put("GroupFileAppSvr.CopyTo", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x897_0", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x89b_1", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x8a1_0", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("OpenGroupSvc.GroupActivityInfo", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("GroupFileAppSvr.DelFile", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("GroupFileAppSvr.FeedMsgV2", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("GroupFileAppSvr.Upload", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("GroupFileAppSvr.TransFile", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("CommunityForum.GetLatestPost", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x8cf_6", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x8d3_1", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("GroupFileAppSvr.Download", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("GroupFileAppSvr.Resend", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("GroupActivity.GetList", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x78f_1", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("GroupFileAppSvr.GetFileList", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x88c_1", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("GroupFileAppSvr.GetFileListV2", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x852_35", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x580_1", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x852_48", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x89a_0", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x89a_8", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x570_8", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("VideoShareSrv.get_video_src", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x568_21", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x568_22", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("GrpMemberLBS.ReportLBS", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("GrpMemberLBS.GetNeighbours", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("ModifyExamine.GetModifyTimes", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("GroupFileAppSvr.GetFileSearch", new int[] { 19 });
    jdField_a_of_type_JavaUtilMap.put("SecCheckSigSvc.UploadReq", new int[] { 20, 21, 23 });
    jdField_a_of_type_JavaUtilMap.put("SecSafeChkSvc.MainCmd", new int[] { 25 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x5d2_0", new int[] { 26 });
    jdField_a_of_type_JavaUtilMap.put("OidbSvc.0x5d4_0", new int[] { 26 });
    jdField_a_of_type_JavaUtilMap.put("ClubInfoSvc.GetVipInfoReq", new int[] { 27 });
    jdField_a_of_type_JavaUtilMap.put("CardPayControl.queryChannel", new int[] { 28 });
    jdField_a_of_type_JavaUtilMap.put("CardPayControl.queryOrderIndex", new int[] { 28 });
    jdField_a_of_type_JavaUtilMap.put("CardPayControl.queryPayOrder", new int[] { 28 });
    jdField_a_of_type_JavaUtilMap.put("CardPayControl.queryOrderDetail", new int[] { 28 });
    jdField_a_of_type_JavaUtilMap.put("OpenPayServer.getOpenId", new int[] { 29 });
    jdField_a_of_type_JavaUtilMap.put("OpenPayServer.getApiList", new int[] { 29 });
    jdField_a_of_type_JavaUtilMap.put("OpenPayServer.checkPayAuth", new int[] { 29 });
    jdField_a_of_type_JavaUtilMap.put("RedTouchSvc.EntranceSetting", new int[] { 30 });
    jdField_a_of_type_JavaUtilMap.put("IndividPub.ExpTips", new int[] { 34 });
    jdField_a_of_type_JavaUtilMap.put("SecuritySvc.GetConfig", new int[] { 33 });
    jdField_a_of_type_JavaUtilMap.put("DevLockAuthSvc.WxMsgOpt", new int[] { 33 });
    jdField_a_of_type_JavaUtilMap.put("DevLockSecSvc.DevLockQuery", new int[] { 33 });
    jdField_a_of_type_JavaUtilMap.put("WalletRecommend.getWalletRecommendAPP", new int[] { 31 });
    jdField_a_of_type_JavaUtilMap.put("WalletRecommend.getWalletRealAPP", new int[] { 31 });
    jdField_a_of_type_JavaUtilMap.put("NearFieldDiscussSvr.ReqJoinDiscuss", new int[] { 32 });
    jdField_a_of_type_JavaUtilMap.put("NearFieldDiscussSvr.ReqGetList", new int[] { 32 });
    jdField_a_of_type_JavaUtilMap.put("NearFieldDiscussSvr.ReqExit", new int[] { 32 });
    jdField_a_of_type_JavaUtilMap.put("NearFieldDiscussSvr.NotifyList", new int[] { 32 });
    jdField_a_of_type_JavaUtilMap.put("hrtxformqq.getUsrSimpleInfo", new int[] { 35 });
    jdField_a_of_type_JavaUtilMap.put("QQWalletPayAuthServer.checkChangePwdAuth", new int[] { 36 });
    jdField_a_of_type_JavaUtilMap.put("VipSTCheckServer.UinPay", new int[] { 38 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.Cmd2HandlerMap
 * JD-Core Version:    0.7.0.1
 */