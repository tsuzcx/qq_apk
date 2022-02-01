import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import QQService.RespFavorite;
import QQService.RespHead;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import appoint.define.appoint_define.InterestItem;
import appoint.define.appoint_define.LBSInfo;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.nowsummarycard.NowSummaryCard.NowSummaryCardReq;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.HeadInfo;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.ReqBody;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.RichHead;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyRankConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686.ReqBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686.RspBody;
import tencent.im.oidb.cmd0x8b4.GroupInfo;
import tencent.im.oidb.cmd0x8b4.ReqBody;
import tencent.im.oidb.cmd0x8b4.RspBody;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7.ReqBody;
import tencent.im.oidb.cmd0x9c8.cmd0x9c8.ReqBody;
import tencent.im.oidb.cmd0x9c8.cmd0x9c8.RspBody;
import tencent.im.oidb.cmd0x9c9.cmd0x9c9.ReqBody;
import tencent.im.oidb.cmd0x9c9.cmd0x9c9.RspBody;
import tencent.im.oidb.cmd0xb5b.cmd0xb5b.ReqBody;
import tencent.im.oidb.cmd0xb5b.cmd0xb5b.RspBody;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.LoginSig;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.ReqBody;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.RspBody;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.VoteInfo;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6.VoteResult;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ExtParam;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.LoginSig;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ReqBody;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.RspBody;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.StockRsp;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.UserZanInfo;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.WarnMsg;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7.ZanLimitInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.nearby.nearby_ice_break.IceReq;

public class ajrs
  extends accg
{
  protected Set<String> allowCmdSet;
  
  public ajrs(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  /* Error */
  private void a(boolean paramBoolean, Object paramObject, Bundle paramBundle, SummaryCard.RespHead paramRespHead)
  {
    // Byte code:
    //   0: aload_3
    //   1: ldc 23
    //   3: invokevirtual 29	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   6: istore 10
    //   8: aload_3
    //   9: ldc 31
    //   11: invokevirtual 35	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   14: istore 8
    //   16: iload_1
    //   17: ifeq +5996 -> 6013
    //   20: aload_2
    //   21: checkcast 37	SummaryCard/RespSummaryCard
    //   24: astore 18
    //   26: aload_0
    //   27: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   30: invokevirtual 46	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   33: invokevirtual 52	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   36: astore 16
    //   38: aload 16
    //   40: invokevirtual 58	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   43: astore 17
    //   45: aload 17
    //   47: invokevirtual 64	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   50: aload_3
    //   51: ldc 66
    //   53: lconst_0
    //   54: invokevirtual 70	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   57: lstore 11
    //   59: aload_3
    //   60: ldc 72
    //   62: invokevirtual 75	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   65: lstore 13
    //   67: aload_3
    //   68: ldc 77
    //   70: invokevirtual 35	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   73: istore 5
    //   75: aconst_null
    //   76: astore_2
    //   77: iload 5
    //   79: ifne +880 -> 959
    //   82: lload 11
    //   84: lconst_0
    //   85: lcmp
    //   86: ifle +28 -> 114
    //   89: aload 16
    //   91: ldc 79
    //   93: ldc 81
    //   95: iconst_1
    //   96: anewarray 83	java/lang/String
    //   99: dup
    //   100: iconst_0
    //   101: lload 11
    //   103: invokestatic 87	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   106: aastore
    //   107: invokevirtual 91	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   110: checkcast 79	com/tencent/mobileqq/data/NearbyPeopleCard
    //   113: astore_2
    //   114: aload_2
    //   115: ifnonnull +5927 -> 6042
    //   118: aload 18
    //   120: getfield 95	SummaryCard/RespSummaryCard:lUIN	J
    //   123: lconst_0
    //   124: lcmp
    //   125: ifle +5917 -> 6042
    //   128: aload 16
    //   130: ldc 79
    //   132: ldc 97
    //   134: iconst_1
    //   135: anewarray 83	java/lang/String
    //   138: dup
    //   139: iconst_0
    //   140: aload 18
    //   142: getfield 95	SummaryCard/RespSummaryCard:lUIN	J
    //   145: invokestatic 87	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   148: aastore
    //   149: invokevirtual 91	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   152: checkcast 79	com/tencent/mobileqq/data/NearbyPeopleCard
    //   155: astore_2
    //   156: aload_2
    //   157: ifnonnull +838 -> 995
    //   160: new 79	com/tencent/mobileqq/data/NearbyPeopleCard
    //   163: dup
    //   164: invokespecial 99	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   167: astore 15
    //   169: aload 18
    //   171: getfield 103	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   174: astore_2
    //   175: aload 15
    //   177: aload 18
    //   179: getfield 95	SummaryCard/RespSummaryCard:lUIN	J
    //   182: invokestatic 87	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   185: putfield 107	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   188: lload 11
    //   190: lconst_0
    //   191: lcmp
    //   192: ifle +994 -> 1186
    //   195: aload 15
    //   197: lload 11
    //   199: putfield 109	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   202: aload 15
    //   204: aload_3
    //   205: ldc 72
    //   207: invokevirtual 75	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   210: putfield 111	com/tencent/mobileqq/data/NearbyPeopleCard:nowId	J
    //   213: aload 15
    //   215: aload_3
    //   216: ldc 77
    //   218: invokevirtual 35	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   221: putfield 114	com/tencent/mobileqq/data/NearbyPeopleCard:nowUserType	I
    //   224: iload 8
    //   226: ifeq +21 -> 247
    //   229: aload 15
    //   231: getfield 107	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   234: aload_0
    //   235: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   238: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   241: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   244: ifeq +954 -> 1198
    //   247: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +45 -> 295
    //   253: ldc 130
    //   255: iconst_2
    //   256: new 132	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   263: ldc 135
    //   265: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload 18
    //   270: getfield 142	SummaryCard/RespSummaryCard:iVoteCount	I
    //   273: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   276: ldc 147
    //   278: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload 18
    //   283: getfield 150	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   286: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   289: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: aload 15
    //   297: aload 18
    //   299: getfield 142	SummaryCard/RespSummaryCard:iVoteCount	I
    //   302: putfield 160	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   305: aload 15
    //   307: aload 18
    //   309: getfield 150	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   312: putfield 163	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   315: aload 15
    //   317: aload 18
    //   319: getfield 167	SummaryCard/RespSummaryCard:vPraiseList	Ljava/util/ArrayList;
    //   322: putfield 171	com/tencent/mobileqq/data/NearbyPeopleCard:praiseList	Ljava/util/List;
    //   325: aload 15
    //   327: aload 18
    //   329: getfield 174	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   332: putfield 177	com/tencent/mobileqq/data/NearbyPeopleCard:nickname	Ljava/lang/String;
    //   335: aload 15
    //   337: aload 18
    //   339: getfield 181	SummaryCard/RespSummaryCard:vRichSign	[B
    //   342: putfield 184	com/tencent/mobileqq/data/NearbyPeopleCard:xuanYan	[B
    //   345: aload 15
    //   347: aload_2
    //   348: getfield 190	SummaryCard/DateCard:bMarriage	B
    //   351: putfield 193	com/tencent/mobileqq/data/NearbyPeopleCard:maritalStatus	B
    //   354: aload 15
    //   356: aload 18
    //   358: getfield 196	SummaryCard/RespSummaryCard:bSex	B
    //   361: putfield 199	com/tencent/mobileqq/data/NearbyPeopleCard:gender	B
    //   364: aload 15
    //   366: aload 18
    //   368: getfield 202	SummaryCard/RespSummaryCard:bAge	B
    //   371: putfield 205	com/tencent/mobileqq/data/NearbyPeopleCard:age	I
    //   374: aload 15
    //   376: aload 18
    //   378: getfield 208	SummaryCard/RespSummaryCard:iBirthday	I
    //   381: putfield 211	com/tencent/mobileqq/data/NearbyPeopleCard:birthday	I
    //   384: aload 15
    //   386: aload_2
    //   387: getfield 214	SummaryCard/DateCard:uProfession	J
    //   390: l2i
    //   391: putfield 217	com/tencent/mobileqq/data/NearbyPeopleCard:job	I
    //   394: aload 15
    //   396: aload_2
    //   397: getfield 220	SummaryCard/DateCard:bConstellation	B
    //   400: putfield 223	com/tencent/mobileqq/data/NearbyPeopleCard:constellation	B
    //   403: aload 15
    //   405: aload_2
    //   406: getfield 226	SummaryCard/DateCard:strDistance	Ljava/lang/String;
    //   409: putfield 229	com/tencent/mobileqq/data/NearbyPeopleCard:distance	Ljava/lang/String;
    //   412: aload 15
    //   414: aload_2
    //   415: getfield 232	SummaryCard/DateCard:strElapse	Ljava/lang/String;
    //   418: putfield 235	com/tencent/mobileqq/data/NearbyPeopleCard:timeDiff	Ljava/lang/String;
    //   421: aload 15
    //   423: aload 18
    //   425: getfield 238	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   428: putfield 241	com/tencent/mobileqq/data/NearbyPeopleCard:oldPhotoCount	I
    //   431: aload 15
    //   433: aload_2
    //   434: getfield 244	SummaryCard/DateCard:vDateInfo	[B
    //   437: putfield 247	com/tencent/mobileqq/data/NearbyPeopleCard:dateInfo	[B
    //   440: aload 15
    //   442: aload_2
    //   443: getfield 250	SummaryCard/DateCard:strCompany	Ljava/lang/String;
    //   446: putfield 253	com/tencent/mobileqq/data/NearbyPeopleCard:company	Ljava/lang/String;
    //   449: aload 15
    //   451: aload_2
    //   452: getfield 256	SummaryCard/DateCard:strSchool	Ljava/lang/String;
    //   455: putfield 259	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   458: aload 15
    //   460: aload_2
    //   461: getfield 262	SummaryCard/DateCard:uHomeCountry	J
    //   464: invokestatic 267	accv:bi	(J)Ljava/lang/String;
    //   467: putfield 270	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCountry	Ljava/lang/String;
    //   470: aload 15
    //   472: aload_2
    //   473: getfield 273	SummaryCard/DateCard:uHomeProvince	J
    //   476: invokestatic 267	accv:bi	(J)Ljava/lang/String;
    //   479: putfield 276	com/tencent/mobileqq/data/NearbyPeopleCard:hometownProvice	Ljava/lang/String;
    //   482: aload 15
    //   484: aload_2
    //   485: getfield 279	SummaryCard/DateCard:uHomeCity	J
    //   488: invokestatic 267	accv:bi	(J)Ljava/lang/String;
    //   491: putfield 282	com/tencent/mobileqq/data/NearbyPeopleCard:hometownCity	Ljava/lang/String;
    //   494: aload 15
    //   496: aload_2
    //   497: getfield 285	SummaryCard/DateCard:uHomeZone	J
    //   500: invokestatic 267	accv:bi	(J)Ljava/lang/String;
    //   503: putfield 288	com/tencent/mobileqq/data/NearbyPeopleCard:hometownDistrict	Ljava/lang/String;
    //   506: aload 15
    //   508: aload 18
    //   510: getfield 291	SummaryCard/RespSummaryCard:strQzoneFeedsDesc	Ljava/lang/String;
    //   513: putfield 294	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneFeed	Ljava/lang/String;
    //   516: aload 15
    //   518: aload 18
    //   520: getfield 297	SummaryCard/RespSummaryCard:strSpaceName	Ljava/lang/String;
    //   523: putfield 300	com/tencent/mobileqq/data/NearbyPeopleCard:qzoneName	Ljava/lang/String;
    //   526: aload 15
    //   528: aload 18
    //   530: getfield 303	SummaryCard/RespSummaryCard:ulShowControl	J
    //   533: putfield 306	com/tencent/mobileqq/data/NearbyPeopleCard:uiShowControl	J
    //   536: aload 15
    //   538: aload 18
    //   540: getfield 309	SummaryCard/RespSummaryCard:lUserFlag	J
    //   543: putfield 312	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   546: aload 15
    //   548: aload 18
    //   550: getfield 315	SummaryCard/RespSummaryCard:vSeed	[B
    //   553: putfield 316	com/tencent/mobileqq/data/NearbyPeopleCard:vSeed	[B
    //   556: aload 15
    //   558: aload 18
    //   560: getfield 319	SummaryCard/RespSummaryCard:lCacheControl	J
    //   563: invokevirtual 323	com/tencent/mobileqq/data/NearbyPeopleCard:setPhotoUseCache	(J)V
    //   566: aload 15
    //   568: invokestatic 329	java/lang/System:currentTimeMillis	()J
    //   571: putfield 332	com/tencent/mobileqq/data/NearbyPeopleCard:lastUpdateNickTime	J
    //   574: aload 15
    //   576: iload 8
    //   578: putfield 335	com/tencent/mobileqq/data/NearbyPeopleCard:favoriteSource	I
    //   581: aload 15
    //   583: aload 18
    //   585: getfield 338	SummaryCard/RespSummaryCard:vTempChatSig	[B
    //   588: putfield 339	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   591: aload 15
    //   593: getfield 339	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   596: ifnull +625 -> 1221
    //   599: aload 15
    //   601: getfield 339	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   604: arraylength
    //   605: ifne +63 -> 668
    //   608: aload_0
    //   609: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   612: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   615: aload 15
    //   617: getfield 107	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   620: invokestatic 344	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   623: ifne +45 -> 668
    //   626: aload_0
    //   627: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   630: ldc_w 346
    //   633: ldc_w 348
    //   636: ldc_w 350
    //   639: ldc_w 352
    //   642: ldc_w 354
    //   645: iconst_0
    //   646: iconst_0
    //   647: aload_0
    //   648: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   651: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   654: aload 15
    //   656: getfield 107	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   659: ldc_w 350
    //   662: ldc_w 350
    //   665: invokestatic 359	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   668: aload_0
    //   669: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   672: invokevirtual 362	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
    //   675: aload 15
    //   677: getfield 107	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   680: invokevirtual 368	anaz:T	(Ljava/lang/String;)[B
    //   683: ifnonnull +23 -> 706
    //   686: aload_0
    //   687: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   690: invokevirtual 362	com/tencent/mobileqq/app/QQAppInterface:a	()Lanaz;
    //   693: aload 15
    //   695: getfield 107	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   698: aload 15
    //   700: getfield 339	com/tencent/mobileqq/data/NearbyPeopleCard:vTempChatSig	[B
    //   703: invokevirtual 372	anaz:s	(Ljava/lang/String;[B)V
    //   706: aload 15
    //   708: aload_2
    //   709: getfield 375	SummaryCard/DateCard:uSchoolId	J
    //   712: putfield 378	com/tencent/mobileqq/data/NearbyPeopleCard:collegeId	J
    //   715: aload 15
    //   717: aload_2
    //   718: getfield 381	SummaryCard/DateCard:vGroupList	[B
    //   721: putfield 382	com/tencent/mobileqq/data/NearbyPeopleCard:vGroupList	[B
    //   724: aload 15
    //   726: aload_2
    //   727: getfield 385	SummaryCard/DateCard:vNearbyInfo	[B
    //   730: putfield 388	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   733: aload 15
    //   735: aload_2
    //   736: getfield 391	SummaryCard/DateCard:vActivityList	[B
    //   739: putfield 392	com/tencent/mobileqq/data/NearbyPeopleCard:vActivityList	[B
    //   742: aload 15
    //   744: aload 18
    //   746: getfield 309	SummaryCard/RespSummaryCard:lUserFlag	J
    //   749: putfield 393	com/tencent/mobileqq/data/NearbyPeopleCard:lUserFlag	J
    //   752: aload 15
    //   754: aload 18
    //   756: getfield 396	SummaryCard/RespSummaryCard:strRemark	Ljava/lang/String;
    //   759: putfield 397	com/tencent/mobileqq/data/NearbyPeopleCard:strRemark	Ljava/lang/String;
    //   762: aload 18
    //   764: getfield 401	SummaryCard/RespSummaryCard:stHeartInfo	LSummaryCard/HeartInfo;
    //   767: ifnull +16 -> 783
    //   770: aload 15
    //   772: aload 18
    //   774: getfield 401	SummaryCard/RespSummaryCard:stHeartInfo	LSummaryCard/HeartInfo;
    //   777: getfield 406	SummaryCard/HeartInfo:iHeartCount	I
    //   780: putfield 409	com/tencent/mobileqq/data/NearbyPeopleCard:mHeartNum	I
    //   783: aload 18
    //   785: getfield 413	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   788: ifnull +478 -> 1266
    //   791: aload 15
    //   793: aload 18
    //   795: getfield 413	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   798: getfield 418	SummaryCard/TNearbyGodInfo:strJumpUrl	Ljava/lang/String;
    //   801: putfield 421	com/tencent/mobileqq/data/NearbyPeopleCard:strGodJumpUrl	Ljava/lang/String;
    //   804: aload 15
    //   806: aload 18
    //   808: getfield 413	SummaryCard/RespSummaryCard:stNearbyGodInfo	LSummaryCard/TNearbyGodInfo;
    //   811: getfield 424	SummaryCard/TNearbyGodInfo:iIsGodFlag	I
    //   814: putfield 425	com/tencent/mobileqq/data/NearbyPeopleCard:iIsGodFlag	I
    //   817: aload 18
    //   819: getfield 428	SummaryCard/RespSummaryCard:vCommLabel	[B
    //   822: astore_3
    //   823: aload_3
    //   824: ifnull +487 -> 1311
    //   827: aload 15
    //   829: new 430	java/util/ArrayList
    //   832: dup
    //   833: invokespecial 431	java/util/ArrayList:<init>	()V
    //   836: putfield 434	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   839: new 436	appoint/define/appoint_define$CommonLabel
    //   842: dup
    //   843: invokespecial 437	appoint/define/appoint_define$CommonLabel:<init>	()V
    //   846: astore 19
    //   848: aload 19
    //   850: aload_3
    //   851: invokevirtual 441	appoint/define/appoint_define$CommonLabel:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   854: pop
    //   855: aload 19
    //   857: getfield 445	appoint/define/appoint_define$CommonLabel:rpt_interst_name	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   860: invokevirtual 451	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   863: astore_3
    //   864: aload 19
    //   866: getfield 454	appoint/define/appoint_define$CommonLabel:rpt_interst_type	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   869: invokevirtual 451	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   872: astore 20
    //   874: new 456	org/json/JSONArray
    //   877: dup
    //   878: invokespecial 457	org/json/JSONArray:<init>	()V
    //   881: astore 19
    //   883: aload_3
    //   884: invokeinterface 463 1 0
    //   889: aload 20
    //   891: invokeinterface 463 1 0
    //   896: if_icmpne +405 -> 1301
    //   899: iconst_0
    //   900: istore 5
    //   902: iload 5
    //   904: aload_3
    //   905: invokeinterface 463 1 0
    //   910: if_icmpge +391 -> 1301
    //   913: aload_3
    //   914: iload 5
    //   916: invokeinterface 466 2 0
    //   921: checkcast 468	com/tencent/mobileqq/pb/ByteStringMicro
    //   924: invokevirtual 471	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   927: astore 20
    //   929: aload 15
    //   931: getfield 434	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabels	Ljava/util/List;
    //   934: aload 20
    //   936: invokeinterface 474 2 0
    //   941: pop
    //   942: aload 19
    //   944: aload 20
    //   946: invokevirtual 478	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   949: pop
    //   950: iload 5
    //   952: iconst_1
    //   953: iadd
    //   954: istore 5
    //   956: goto -54 -> 902
    //   959: lload 13
    //   961: lconst_0
    //   962: lcmp
    //   963: ifle +5074 -> 6037
    //   966: aload 16
    //   968: ldc 79
    //   970: ldc_w 480
    //   973: iconst_1
    //   974: anewarray 83	java/lang/String
    //   977: dup
    //   978: iconst_0
    //   979: lload 13
    //   981: invokestatic 87	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   984: aastore
    //   985: invokevirtual 91	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   988: checkcast 79	com/tencent/mobileqq/data/NearbyPeopleCard
    //   991: astore_2
    //   992: goto -836 -> 156
    //   995: aload_2
    //   996: invokevirtual 483	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   999: istore 5
    //   1001: aload_2
    //   1002: invokevirtual 486	com/tencent/mobileqq/data/NearbyPeopleCard:getId	()J
    //   1005: lstore 13
    //   1007: new 79	com/tencent/mobileqq/data/NearbyPeopleCard
    //   1010: dup
    //   1011: invokespecial 99	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   1014: astore 15
    //   1016: aload 15
    //   1018: aload_2
    //   1019: getfield 490	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   1022: putfield 490	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   1025: aload 15
    //   1027: aload_2
    //   1028: getfield 493	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   1031: putfield 493	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   1034: aload 15
    //   1036: aload_2
    //   1037: getfield 496	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   1040: putfield 496	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   1043: aload 15
    //   1045: aload_2
    //   1046: getfield 499	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   1049: putfield 499	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   1052: aload 15
    //   1054: aload_2
    //   1055: getfield 502	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   1058: putfield 502	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   1061: aload 15
    //   1063: aload_2
    //   1064: getfield 505	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   1067: putfield 505	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   1070: aload 15
    //   1072: aload_2
    //   1073: getfield 508	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   1076: putfield 508	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   1079: aload 15
    //   1081: aload_2
    //   1082: getfield 511	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   1085: putfield 511	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   1088: aload 15
    //   1090: aload_2
    //   1091: getfield 514	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   1094: putfield 514	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   1097: aload 15
    //   1099: aload_2
    //   1100: getfield 517	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   1103: putfield 517	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   1106: aload 15
    //   1108: aload_2
    //   1109: getfield 520	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   1112: putfield 520	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   1115: aload 15
    //   1117: aload_2
    //   1118: getfield 523	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   1121: putfield 523	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   1124: aload 15
    //   1126: aload_2
    //   1127: getfield 526	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1130: putfield 526	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1133: aload 15
    //   1135: aload_2
    //   1136: getfield 529	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   1139: putfield 529	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   1142: aload 15
    //   1144: aload_2
    //   1145: getfield 532	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   1148: putfield 532	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   1151: aload 15
    //   1153: aload_2
    //   1154: getfield 535	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   1157: putfield 535	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   1160: aload 15
    //   1162: aload_2
    //   1163: getfield 526	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1166: putfield 526	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   1169: aload 15
    //   1171: iload 5
    //   1173: invokevirtual 539	com/tencent/mobileqq/data/NearbyPeopleCard:setStatus	(I)V
    //   1176: aload 15
    //   1178: lload 13
    //   1180: invokevirtual 542	com/tencent/mobileqq/data/NearbyPeopleCard:setId	(J)V
    //   1183: goto -1014 -> 169
    //   1186: aload 15
    //   1188: aload_2
    //   1189: getfield 545	SummaryCard/DateCard:lTinyId	J
    //   1192: putfield 109	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   1195: goto -993 -> 202
    //   1198: aload 15
    //   1200: aload 18
    //   1202: getfield 142	SummaryCard/RespSummaryCard:iVoteCount	I
    //   1205: putfield 160	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   1208: aload 15
    //   1210: aload 18
    //   1212: getfield 150	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   1215: putfield 163	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   1218: goto -893 -> 325
    //   1221: aload_0
    //   1222: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1225: ldc_w 346
    //   1228: ldc_w 348
    //   1231: ldc_w 350
    //   1234: ldc_w 352
    //   1237: ldc_w 547
    //   1240: iconst_0
    //   1241: iconst_0
    //   1242: aload_0
    //   1243: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1246: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1249: aload 15
    //   1251: getfield 107	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1254: ldc_w 350
    //   1257: ldc_w 350
    //   1260: invokestatic 359	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1263: goto -557 -> 706
    //   1266: invokestatic 550	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1269: ifeq -452 -> 817
    //   1272: ldc 130
    //   1274: iconst_2
    //   1275: new 132	java/lang/StringBuilder
    //   1278: dup
    //   1279: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   1282: ldc_w 552
    //   1285: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: aconst_null
    //   1289: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1292: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1295: invokestatic 558	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1298: goto -481 -> 817
    //   1301: aload 15
    //   1303: aload 19
    //   1305: invokevirtual 559	org/json/JSONArray:toString	()Ljava/lang/String;
    //   1308: putfield 562	com/tencent/mobileqq/data/NearbyPeopleCard:commonLabelString	Ljava/lang/String;
    //   1311: invokestatic 550	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1314: ifeq +32 -> 1346
    //   1317: ldc 130
    //   1319: iconst_4
    //   1320: new 132	java/lang/StringBuilder
    //   1323: dup
    //   1324: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   1327: ldc_w 564
    //   1330: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: aload_2
    //   1334: getfield 375	SummaryCard/DateCard:uSchoolId	J
    //   1337: invokevirtual 567	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1340: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1343: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1346: aload 15
    //   1348: aload 18
    //   1350: getfield 570	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1353: putfield 571	com/tencent/mobileqq/data/NearbyPeopleCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1356: aload 15
    //   1358: aload 18
    //   1360: getfield 575	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   1363: putfield 576	com/tencent/mobileqq/data/NearbyPeopleCard:bHaveVotedCnt	S
    //   1366: aload 15
    //   1368: aload 18
    //   1370: getfield 579	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   1373: putfield 580	com/tencent/mobileqq/data/NearbyPeopleCard:bAvailVoteCnt	S
    //   1376: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1379: ifeq +62 -> 1441
    //   1382: ldc_w 582
    //   1385: iconst_2
    //   1386: new 132	java/lang/StringBuilder
    //   1389: dup
    //   1390: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   1393: ldc_w 584
    //   1396: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: aload 18
    //   1401: getfield 570	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   1404: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1407: ldc_w 586
    //   1410: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: aload 18
    //   1415: getfield 575	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   1418: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1421: ldc_w 588
    //   1424: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: aload 18
    //   1429: getfield 579	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   1432: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1435: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1438: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1441: aload 18
    //   1443: getfield 592	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1446: ifnull +58 -> 1504
    //   1449: aload 15
    //   1451: aload 18
    //   1453: getfield 592	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1456: getfield 597	SummaryCard/PanSocialInfo:uCharm	J
    //   1459: putfield 600	com/tencent/mobileqq/data/NearbyPeopleCard:charm	J
    //   1462: aload 15
    //   1464: aload 18
    //   1466: getfield 592	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1469: getfield 603	SummaryCard/PanSocialInfo:uCharmLevel	J
    //   1472: l2i
    //   1473: putfield 606	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   1476: aload 15
    //   1478: aload 18
    //   1480: getfield 592	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1483: getfield 609	SummaryCard/PanSocialInfo:uNextLevelCharm	J
    //   1486: l2i
    //   1487: putfield 612	com/tencent/mobileqq/data/NearbyPeopleCard:nextThreshold	I
    //   1490: aload 15
    //   1492: aload 18
    //   1494: getfield 592	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1497: getfield 615	SummaryCard/PanSocialInfo:uCurLevelCharm	J
    //   1500: l2i
    //   1501: putfield 618	com/tencent/mobileqq/data/NearbyPeopleCard:curThreshold	I
    //   1504: iload 8
    //   1506: ifeq +21 -> 1527
    //   1509: aload 15
    //   1511: getfield 107	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   1514: aload_0
    //   1515: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1518: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1521: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1524: ifeq +251 -> 1775
    //   1527: iconst_1
    //   1528: istore_1
    //   1529: aload 15
    //   1531: aload_2
    //   1532: getfield 621	SummaryCard/DateCard:vFaces	[B
    //   1535: aload 18
    //   1537: getfield 625	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   1540: iload_1
    //   1541: invokevirtual 629	com/tencent/mobileqq/data/NearbyPeopleCard:updateDisplayPicInfos	([BLSummaryCard/TVideoHeadInfo;Z)Ljava/util/List;
    //   1544: pop
    //   1545: aload 15
    //   1547: aload 18
    //   1549: getfield 633	SummaryCard/RespSummaryCard:stQiqiVideoInfo	LSummaryCard/QiqiVideoInfo;
    //   1552: getfield 638	SummaryCard/QiqiVideoInfo:uRoomid	J
    //   1555: putfield 639	com/tencent/mobileqq/data/NearbyPeopleCard:uRoomid	J
    //   1558: aload 18
    //   1560: getfield 642	SummaryCard/RespSummaryCard:bValid4Vote	B
    //   1563: ifne +217 -> 1780
    //   1566: aload 15
    //   1568: iconst_1
    //   1569: putfield 645	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1572: aload 4
    //   1574: ifnull +13 -> 1587
    //   1577: aload 15
    //   1579: aload 4
    //   1581: getfield 650	SummaryCard/RespHead:vCookies	[B
    //   1584: putfield 651	com/tencent/mobileqq/data/NearbyPeopleCard:vCookies	[B
    //   1587: aload 15
    //   1589: getfield 312	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1592: ldc2_w 652
    //   1595: land
    //   1596: lconst_0
    //   1597: lcmp
    //   1598: ifeq +191 -> 1789
    //   1601: aload 15
    //   1603: iconst_1
    //   1604: putfield 656	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1607: aload 15
    //   1609: getfield 312	com/tencent/mobileqq/data/NearbyPeopleCard:userFlag	J
    //   1612: ldc2_w 657
    //   1615: land
    //   1616: lconst_0
    //   1617: lcmp
    //   1618: ifeq +180 -> 1798
    //   1621: aload 15
    //   1623: iconst_1
    //   1624: putfield 661	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1627: aload 15
    //   1629: invokevirtual 664	com/tencent/mobileqq/data/NearbyPeopleCard:isPhotoUseCache	()Z
    //   1632: ifne +233 -> 1865
    //   1635: aload 15
    //   1637: ldc_w 350
    //   1640: putfield 667	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1643: aload 15
    //   1645: ldc_w 350
    //   1648: putfield 670	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1651: aload 15
    //   1653: ldc_w 350
    //   1656: putfield 673	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1659: aload 18
    //   1661: getfield 677	SummaryCard/RespSummaryCard:oLatestPhotos	LSummaryCard/AlbumInfo;
    //   1664: astore_2
    //   1665: aload_2
    //   1666: ifnull +199 -> 1865
    //   1669: aload_2
    //   1670: getfield 682	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1673: ifnull +192 -> 1865
    //   1676: aload_2
    //   1677: getfield 682	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1680: invokevirtual 683	java/util/ArrayList:size	()I
    //   1683: ifle +182 -> 1865
    //   1686: iconst_0
    //   1687: istore 5
    //   1689: iload 5
    //   1691: aload_2
    //   1692: getfield 682	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1695: invokevirtual 683	java/util/ArrayList:size	()I
    //   1698: if_icmpge +167 -> 1865
    //   1701: iload 5
    //   1703: ifne +104 -> 1807
    //   1706: aload 15
    //   1708: aload_2
    //   1709: getfield 682	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1712: iload 5
    //   1714: invokevirtual 684	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1717: checkcast 686	SummaryCard/PhotoInfo
    //   1720: getfield 689	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1723: putfield 667	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_1	Ljava/lang/String;
    //   1726: iload 5
    //   1728: iconst_1
    //   1729: iadd
    //   1730: istore 5
    //   1732: goto -43 -> 1689
    //   1735: astore_3
    //   1736: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1739: ifeq -428 -> 1311
    //   1742: ldc_w 582
    //   1745: iconst_2
    //   1746: new 132	java/lang/StringBuilder
    //   1749: dup
    //   1750: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   1753: ldc_w 691
    //   1756: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: aload_3
    //   1760: invokevirtual 694	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1763: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1766: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1769: invokestatic 697	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1772: goto -461 -> 1311
    //   1775: iconst_0
    //   1776: istore_1
    //   1777: goto -248 -> 1529
    //   1780: aload 15
    //   1782: iconst_0
    //   1783: putfield 645	com/tencent/mobileqq/data/NearbyPeopleCard:bVoted	B
    //   1786: goto -214 -> 1572
    //   1789: aload 15
    //   1791: iconst_0
    //   1792: putfield 656	com/tencent/mobileqq/data/NearbyPeopleCard:switchQzone	Z
    //   1795: goto -188 -> 1607
    //   1798: aload 15
    //   1800: iconst_0
    //   1801: putfield 661	com/tencent/mobileqq/data/NearbyPeopleCard:switchHobby	Z
    //   1804: goto -177 -> 1627
    //   1807: iload 5
    //   1809: iconst_1
    //   1810: if_icmpne +26 -> 1836
    //   1813: aload 15
    //   1815: aload_2
    //   1816: getfield 682	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1819: iload 5
    //   1821: invokevirtual 684	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1824: checkcast 686	SummaryCard/PhotoInfo
    //   1827: getfield 689	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1830: putfield 670	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_2	Ljava/lang/String;
    //   1833: goto -107 -> 1726
    //   1836: iload 5
    //   1838: iconst_2
    //   1839: if_icmpne -113 -> 1726
    //   1842: aload 15
    //   1844: aload_2
    //   1845: getfield 682	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1848: iload 5
    //   1850: invokevirtual 684	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1853: checkcast 686	SummaryCard/PhotoInfo
    //   1856: getfield 689	SummaryCard/PhotoInfo:strPicUrl	Ljava/lang/String;
    //   1859: putfield 673	com/tencent/mobileqq/data/NearbyPeopleCard:qzonePicUrl_3	Ljava/lang/String;
    //   1862: goto -136 -> 1726
    //   1865: aload 18
    //   1867: getfield 592	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1870: astore_2
    //   1871: aload_2
    //   1872: ifnull +27 -> 1899
    //   1875: aload_2
    //   1876: getfield 700	SummaryCard/PanSocialInfo:uCharmRank	J
    //   1879: lconst_1
    //   1880: lcmp
    //   1881: ifne +153 -> 2034
    //   1884: aload 15
    //   1886: iconst_1
    //   1887: putfield 703	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   1890: aload 15
    //   1892: aload_2
    //   1893: getfield 706	SummaryCard/PanSocialInfo:strLevelType	Ljava/lang/String;
    //   1896: putfield 707	com/tencent/mobileqq/data/NearbyPeopleCard:strLevelType	Ljava/lang/String;
    //   1899: aload 18
    //   1901: getfield 710	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1904: ifnull +30 -> 1934
    //   1907: aload 15
    //   1909: aload_0
    //   1910: aload 18
    //   1912: getfield 710	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1915: ldc_w 712
    //   1918: new 714	GameCenter/RespLastGameInfo
    //   1921: dup
    //   1922: invokespecial 715	GameCenter/RespLastGameInfo:<init>	()V
    //   1925: invokevirtual 719	ajrs:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1928: checkcast 714	GameCenter/RespLastGameInfo
    //   1931: invokevirtual 723	com/tencent/mobileqq/data/NearbyPeopleCard:updateLastGameInfo	(LGameCenter/RespLastGameInfo;)V
    //   1934: aload 18
    //   1936: getfield 592	SummaryCard/RespSummaryCard:stPanSocialInfo	LSummaryCard/PanSocialInfo;
    //   1939: astore_2
    //   1940: aload_2
    //   1941: ifnull +13 -> 1954
    //   1944: aload 15
    //   1946: aload_2
    //   1947: getfield 726	SummaryCard/PanSocialInfo:uChatflag	J
    //   1950: l2i
    //   1951: putfield 729	com/tencent/mobileqq/data/NearbyPeopleCard:sayHelloFlag	I
    //   1954: new 430	java/util/ArrayList
    //   1957: dup
    //   1958: invokespecial 431	java/util/ArrayList:<init>	()V
    //   1961: astore_2
    //   1962: aload 18
    //   1964: getfield 732	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1967: ifnull +745 -> 2712
    //   1970: aload 18
    //   1972: getfield 732	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1975: invokevirtual 683	java/util/ArrayList:size	()I
    //   1978: ifle +734 -> 2712
    //   1981: iconst_0
    //   1982: istore 5
    //   1984: iload 5
    //   1986: aload 18
    //   1988: getfield 732	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   1991: invokevirtual 683	java/util/ArrayList:size	()I
    //   1994: if_icmpge +718 -> 2712
    //   1997: aload 18
    //   1999: getfield 732	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2002: iload 5
    //   2004: invokevirtual 684	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2007: checkcast 733	[B
    //   2010: astore_3
    //   2011: aload_3
    //   2012: ifnonnull +31 -> 2043
    //   2015: iconst_0
    //   2016: istore 6
    //   2018: iload 6
    //   2020: bipush 10
    //   2022: if_icmpgt +28 -> 2050
    //   2025: iload 5
    //   2027: iconst_1
    //   2028: iadd
    //   2029: istore 5
    //   2031: goto -47 -> 1984
    //   2034: aload 15
    //   2036: iconst_0
    //   2037: putfield 703	com/tencent/mobileqq/data/NearbyPeopleCard:godFlag	Z
    //   2040: goto -150 -> 1890
    //   2043: aload_3
    //   2044: arraylength
    //   2045: istore 6
    //   2047: goto -29 -> 2018
    //   2050: aload_3
    //   2051: iconst_1
    //   2052: invokestatic 739	aqoj:getLongData	([BI)J
    //   2055: l2i
    //   2056: istore 7
    //   2058: aload_3
    //   2059: iconst_5
    //   2060: invokestatic 739	aqoj:getLongData	([BI)J
    //   2063: l2i
    //   2064: istore 9
    //   2066: iload 7
    //   2068: ifle -43 -> 2025
    //   2071: iload 7
    //   2073: bipush 9
    //   2075: iadd
    //   2076: iload 6
    //   2078: if_icmpge -53 -> 2025
    //   2081: iload 7
    //   2083: newarray byte
    //   2085: astore 4
    //   2087: aload 4
    //   2089: iconst_0
    //   2090: aload_3
    //   2091: bipush 9
    //   2093: iload 7
    //   2095: invokestatic 743	aqoj:copyData	([BI[BII)V
    //   2098: new 745	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   2101: dup
    //   2102: invokespecial 746	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   2105: astore_3
    //   2106: aload_3
    //   2107: aload 4
    //   2109: invokevirtual 747	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2112: pop
    //   2113: aload_3
    //   2114: getfield 751	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2117: invokevirtual 755	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2120: istore 9
    //   2122: new 757	alda
    //   2125: dup
    //   2126: invokespecial 758	alda:<init>	()V
    //   2129: astore 4
    //   2131: iload 9
    //   2133: ifne +485 -> 2618
    //   2136: aload 4
    //   2138: aload_3
    //   2139: getfield 762	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2142: getfield 768	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2145: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2148: putfield 774	alda:strName	Ljava/lang/String;
    //   2151: aload 4
    //   2153: aload_3
    //   2154: getfield 762	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2157: getfield 777	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strServiceUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2160: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2163: putfield 780	alda:bVJ	Ljava/lang/String;
    //   2166: aload 4
    //   2168: aload_3
    //   2169: getfield 784	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2172: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2175: putfield 790	alda:serviceType	I
    //   2178: new 430	java/util/ArrayList
    //   2181: dup
    //   2182: invokespecial 431	java/util/ArrayList:<init>	()V
    //   2185: astore 19
    //   2187: iconst_0
    //   2188: istore 6
    //   2190: iload 6
    //   2192: aload_3
    //   2193: getfield 762	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2196: getfield 794	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2199: invokevirtual 797	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2202: if_icmpge +409 -> 2611
    //   2205: aload_3
    //   2206: getfield 762	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2209: getfield 794	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2212: iload 6
    //   2214: invokevirtual 800	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2217: checkcast 802	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info
    //   2220: astore 20
    //   2222: new 804	aldb
    //   2225: dup
    //   2226: invokespecial 805	aldb:<init>	()V
    //   2229: astore 21
    //   2231: aload 21
    //   2233: aload 20
    //   2235: getfield 808	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitle	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2238: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2241: putfield 810	aldb:strTitle	Ljava/lang/String;
    //   2244: aload 21
    //   2246: aload 20
    //   2248: getfield 813	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strCoverUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2251: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2254: putfield 815	aldb:strCoverUrl	Ljava/lang/String;
    //   2257: aload 21
    //   2259: aload 20
    //   2261: getfield 818	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strJmpUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2264: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2267: putfield 820	aldb:strJmpUrl	Ljava/lang/String;
    //   2270: aload 21
    //   2272: aload 20
    //   2274: getfield 823	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strSubInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2277: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2280: putfield 826	aldb:bVL	Ljava/lang/String;
    //   2283: aload 21
    //   2285: aload 20
    //   2287: getfield 829	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strDesc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2290: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2293: putfield 831	aldb:strDesc	Ljava/lang/String;
    //   2296: aload 21
    //   2298: aload 20
    //   2300: getfield 834	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitleIconUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2303: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2306: putfield 837	aldb:bVM	Ljava/lang/String;
    //   2309: aload 21
    //   2311: aload 20
    //   2313: getfield 841	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2316: invokevirtual 845	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2319: putfield 848	aldb:agt	J
    //   2322: aload 21
    //   2324: aload 4
    //   2326: getfield 790	alda:serviceType	I
    //   2329: putfield 849	aldb:serviceType	I
    //   2332: aload 20
    //   2334: getfield 852	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2337: invokevirtual 797	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2340: ifle +254 -> 2594
    //   2343: new 430	java/util/ArrayList
    //   2346: dup
    //   2347: invokespecial 431	java/util/ArrayList:<init>	()V
    //   2350: astore 22
    //   2352: iconst_0
    //   2353: istore 7
    //   2355: iload 7
    //   2357: aload 20
    //   2359: getfield 852	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2362: invokevirtual 797	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2365: if_icmpge +222 -> 2587
    //   2368: aload 20
    //   2370: getfield 852	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2373: iload 7
    //   2375: invokevirtual 800	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2378: checkcast 854	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label
    //   2381: astore 23
    //   2383: new 856	alcz
    //   2386: dup
    //   2387: invokespecial 857	alcz:<init>	()V
    //   2390: astore 24
    //   2392: aload 24
    //   2394: aload 23
    //   2396: getfield 861	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2399: invokevirtual 866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2402: invokevirtual 471	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   2405: putfield 869	alcz:strWording	Ljava/lang/String;
    //   2408: aload 24
    //   2410: aload 23
    //   2412: getfield 872	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2415: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2418: i2l
    //   2419: putfield 875	alcz:type	J
    //   2422: aload 24
    //   2424: aload 23
    //   2426: getfield 878	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_attr	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2429: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2432: i2l
    //   2433: putfield 881	alcz:ags	J
    //   2436: new 883	alcx
    //   2439: dup
    //   2440: invokespecial 884	alcx:<init>	()V
    //   2443: astore 25
    //   2445: aload 25
    //   2447: aload 23
    //   2449: getfield 888	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2452: getfield 893	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2455: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2458: i2l
    //   2459: putfield 896	alcx:R	J
    //   2462: aload 25
    //   2464: aload 23
    //   2466: getfield 888	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2469: getfield 899	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2472: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2475: i2l
    //   2476: putfield 902	alcx:G	J
    //   2479: aload 25
    //   2481: aload 23
    //   2483: getfield 888	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2486: getfield 905	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2489: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2492: i2l
    //   2493: putfield 907	alcx:B	J
    //   2496: aload 24
    //   2498: aload 25
    //   2500: putfield 911	alcz:b	Lalcx;
    //   2503: new 883	alcx
    //   2506: dup
    //   2507: invokespecial 884	alcx:<init>	()V
    //   2510: astore 25
    //   2512: aload 25
    //   2514: aload 23
    //   2516: getfield 914	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2519: getfield 893	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2522: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2525: i2l
    //   2526: putfield 896	alcx:R	J
    //   2529: aload 25
    //   2531: aload 23
    //   2533: getfield 914	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2536: getfield 899	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2539: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2542: i2l
    //   2543: putfield 902	alcx:G	J
    //   2546: aload 25
    //   2548: aload 23
    //   2550: getfield 914	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   2553: getfield 905	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2556: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2559: i2l
    //   2560: putfield 907	alcx:B	J
    //   2563: aload 24
    //   2565: aload 25
    //   2567: putfield 916	alcz:a	Lalcx;
    //   2570: aload 22
    //   2572: aload 24
    //   2574: invokevirtual 917	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2577: pop
    //   2578: iload 7
    //   2580: iconst_1
    //   2581: iadd
    //   2582: istore 7
    //   2584: goto -229 -> 2355
    //   2587: aload 21
    //   2589: aload 22
    //   2591: putfield 920	aldb:labels	Ljava/util/ArrayList;
    //   2594: aload 19
    //   2596: aload 21
    //   2598: invokevirtual 917	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2601: pop
    //   2602: iload 6
    //   2604: iconst_1
    //   2605: iadd
    //   2606: istore 6
    //   2608: goto -418 -> 2190
    //   2611: aload 4
    //   2613: aload 19
    //   2615: putfield 923	alda:yC	Ljava/util/ArrayList;
    //   2618: aload_2
    //   2619: aload 4
    //   2621: invokeinterface 474 2 0
    //   2626: pop
    //   2627: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2630: ifeq -605 -> 2025
    //   2633: ldc 130
    //   2635: iconst_2
    //   2636: new 132	java/lang/StringBuilder
    //   2639: dup
    //   2640: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   2643: ldc_w 925
    //   2646: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2649: aload_3
    //   2650: getfield 784	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2653: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2656: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2659: ldc_w 927
    //   2662: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2665: iload 9
    //   2667: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2670: ldc_w 929
    //   2673: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2676: aload_3
    //   2677: getfield 932	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2680: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2683: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2686: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2689: goto -664 -> 2025
    //   2692: astore_3
    //   2693: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2696: ifeq -671 -> 2025
    //   2699: ldc 130
    //   2701: iconst_2
    //   2702: aload_3
    //   2703: invokevirtual 933	java/lang/Exception:toString	()Ljava/lang/String;
    //   2706: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2709: goto -684 -> 2025
    //   2712: new 430	java/util/ArrayList
    //   2715: dup
    //   2716: invokespecial 431	java/util/ArrayList:<init>	()V
    //   2719: astore_2
    //   2720: aload 18
    //   2722: getfield 936	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2725: ifnull +381 -> 3106
    //   2728: aload 18
    //   2730: getfield 936	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2733: invokevirtual 683	java/util/ArrayList:size	()I
    //   2736: ifle +370 -> 3106
    //   2739: iconst_0
    //   2740: istore 5
    //   2742: iload 5
    //   2744: aload 18
    //   2746: getfield 936	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2749: invokevirtual 683	java/util/ArrayList:size	()I
    //   2752: if_icmpge +354 -> 3106
    //   2755: aload 18
    //   2757: getfield 936	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   2760: iload 5
    //   2762: invokevirtual 684	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2765: checkcast 733	[B
    //   2768: astore 4
    //   2770: aload 4
    //   2772: ifnonnull +22 -> 2794
    //   2775: iconst_0
    //   2776: istore 6
    //   2778: iload 6
    //   2780: bipush 10
    //   2782: if_icmpgt +20 -> 2802
    //   2785: iload 5
    //   2787: iconst_1
    //   2788: iadd
    //   2789: istore 5
    //   2791: goto -49 -> 2742
    //   2794: aload 4
    //   2796: arraylength
    //   2797: istore 6
    //   2799: goto -21 -> 2778
    //   2802: aload 4
    //   2804: iconst_1
    //   2805: invokestatic 739	aqoj:getLongData	([BI)J
    //   2808: l2i
    //   2809: istore 7
    //   2811: aload 4
    //   2813: iconst_5
    //   2814: invokestatic 739	aqoj:getLongData	([BI)J
    //   2817: l2i
    //   2818: istore 9
    //   2820: iload 7
    //   2822: ifle -37 -> 2785
    //   2825: iload 7
    //   2827: bipush 9
    //   2829: iadd
    //   2830: iload 6
    //   2832: if_icmpge -47 -> 2785
    //   2835: iload 7
    //   2837: newarray byte
    //   2839: astore_3
    //   2840: aload_3
    //   2841: iconst_0
    //   2842: aload 4
    //   2844: bipush 9
    //   2846: iload 7
    //   2848: invokestatic 743	aqoj:copyData	([BI[BII)V
    //   2851: new 745	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   2854: dup
    //   2855: invokespecial 746	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   2858: astore 4
    //   2860: aload 4
    //   2862: aload_3
    //   2863: invokevirtual 747	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2866: pop
    //   2867: aload 4
    //   2869: getfield 751	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2872: invokevirtual 755	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2875: istore 6
    //   2877: iload 6
    //   2879: ifne +160 -> 3039
    //   2882: new 938	alck
    //   2885: dup
    //   2886: invokespecial 939	alck:<init>	()V
    //   2889: astore_3
    //   2890: aload_3
    //   2891: aload 4
    //   2893: getfield 784	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2896: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2899: putfield 942	alck:drE	I
    //   2902: aload 4
    //   2904: getfield 946	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2907: ifnull +101 -> 3008
    //   2910: aload_3
    //   2911: aload 4
    //   2913: getfield 946	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2916: getfield 951	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2919: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2922: putfield 954	alck:bVk	Ljava/lang/String;
    //   2925: aload_3
    //   2926: aload 4
    //   2928: getfield 946	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2931: getfield 957	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2934: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2937: putfield 958	alck:strTitle	Ljava/lang/String;
    //   2940: aload_3
    //   2941: aload 4
    //   2943: getfield 946	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2946: getfield 961	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2949: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2952: putfield 964	alck:strContent	Ljava/lang/String;
    //   2955: aload_3
    //   2956: aload 4
    //   2958: getfield 946	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   2961: getfield 967	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2964: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2967: putfield 968	alck:strJumpUrl	Ljava/lang/String;
    //   2970: aload_3
    //   2971: invokevirtual 971	alck:isEmpty	()Z
    //   2974: ifne -189 -> 2785
    //   2977: aload_2
    //   2978: aload_3
    //   2979: invokeinterface 474 2 0
    //   2984: pop
    //   2985: goto -200 -> 2785
    //   2988: astore_3
    //   2989: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2992: ifeq -207 -> 2785
    //   2995: ldc 130
    //   2997: iconst_2
    //   2998: aload_3
    //   2999: invokevirtual 933	java/lang/Exception:toString	()Ljava/lang/String;
    //   3002: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3005: goto -220 -> 2785
    //   3008: aload_3
    //   3009: ldc_w 350
    //   3012: putfield 954	alck:bVk	Ljava/lang/String;
    //   3015: aload_3
    //   3016: ldc_w 350
    //   3019: putfield 958	alck:strTitle	Ljava/lang/String;
    //   3022: aload_3
    //   3023: ldc_w 350
    //   3026: putfield 964	alck:strContent	Ljava/lang/String;
    //   3029: aload_3
    //   3030: ldc_w 350
    //   3033: putfield 968	alck:strJumpUrl	Ljava/lang/String;
    //   3036: goto -66 -> 2970
    //   3039: invokestatic 550	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3042: ifeq -257 -> 2785
    //   3045: ldc 130
    //   3047: iconst_4
    //   3048: new 132	java/lang/StringBuilder
    //   3051: dup
    //   3052: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   3055: ldc_w 973
    //   3058: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3061: aload 4
    //   3063: getfield 784	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3066: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3069: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3072: ldc_w 975
    //   3075: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3078: iload 6
    //   3080: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3083: ldc_w 975
    //   3086: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3089: aload 4
    //   3091: getfield 932	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3094: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3097: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3100: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3103: goto -318 -> 2785
    //   3106: aload 15
    //   3108: aload_2
    //   3109: invokevirtual 979	com/tencent/mobileqq/data/NearbyPeopleCard:saveBusiEntrys	(Ljava/util/List;)V
    //   3112: aload 18
    //   3114: getfield 983	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   3117: ifnonnull +125 -> 3242
    //   3120: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3123: ifeq +12 -> 3135
    //   3126: ldc 130
    //   3128: iconst_2
    //   3129: ldc_w 985
    //   3132: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3135: aload 18
    //   3137: getfield 988	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   3140: ifnull +1670 -> 4810
    //   3143: new 990	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody
    //   3146: dup
    //   3147: invokespecial 991	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:<init>	()V
    //   3150: astore_2
    //   3151: aload_2
    //   3152: aload 18
    //   3154: getfield 988	SummaryCard/RespSummaryCard:vHotChatInfo	[B
    //   3157: invokevirtual 992	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3160: pop
    //   3161: aload_2
    //   3162: ifnull +2870 -> 6032
    //   3165: aload_2
    //   3166: getfield 995	tencent/im/oidb/hotchat/GetJoinedHotChatList$RspBody:rpt_msg_wifi_poi_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3169: invokevirtual 996	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3172: astore_2
    //   3173: new 430	java/util/ArrayList
    //   3176: dup
    //   3177: invokespecial 431	java/util/ArrayList:<init>	()V
    //   3180: astore_3
    //   3181: aload_2
    //   3182: ifnull +154 -> 3336
    //   3185: aload_2
    //   3186: invokeinterface 1000 1 0
    //   3191: astore_2
    //   3192: aload_2
    //   3193: invokeinterface 1005 1 0
    //   3198: ifeq +138 -> 3336
    //   3201: aload_2
    //   3202: invokeinterface 1009 1 0
    //   3207: checkcast 1011	tencent/im/oidb/hotchat/Common$WifiPOIInfo
    //   3210: astore 4
    //   3212: aload 4
    //   3214: getfield 1014	tencent/im/oidb/hotchat/Common$WifiPOIInfo:uint32_wifi_poi_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3217: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3220: iconst_1
    //   3221: if_icmpne +110 -> 3331
    //   3224: iconst_1
    //   3225: istore_1
    //   3226: aload_3
    //   3227: aload 4
    //   3229: iload_1
    //   3230: invokestatic 1020	com/tencent/mobileqq/data/HotChatInfo:createHotChat	(Ltencent/im/oidb/hotchat/Common$WifiPOIInfo;Z)Lcom/tencent/mobileqq/data/HotChatInfo;
    //   3233: invokeinterface 474 2 0
    //   3238: pop
    //   3239: goto -47 -> 3192
    //   3242: aload 18
    //   3244: getfield 983	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   3247: getfield 1025	SummaryCard/InterestTagInfo:uFlag	J
    //   3250: lstore 11
    //   3252: new 1027	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody
    //   3255: dup
    //   3256: invokespecial 1028	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:<init>	()V
    //   3259: astore_2
    //   3260: aload_2
    //   3261: aload 18
    //   3263: getfield 983	SummaryCard/RespSummaryCard:stInterestTag	LSummaryCard/InterestTagInfo;
    //   3266: getfield 1031	SummaryCard/InterestTagInfo:vGiftInfo	[B
    //   3269: invokevirtual 1032	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3272: pop
    //   3273: aload 15
    //   3275: lload 11
    //   3277: aload_2
    //   3278: getfield 1035	tencent/im/oidb/cmd0x9c5/cmd0x9c5$RspBody:msg_interest_tags	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3281: invokevirtual 996	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3284: invokevirtual 1039	com/tencent/mobileqq/data/NearbyPeopleCard:updateInterestTags	(JLjava/util/List;)V
    //   3287: goto -152 -> 3135
    //   3290: astore_2
    //   3291: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3294: ifeq -159 -> 3135
    //   3297: ldc_w 1041
    //   3300: iconst_2
    //   3301: aload_2
    //   3302: invokevirtual 933	java/lang/Exception:toString	()Ljava/lang/String;
    //   3305: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3308: goto -173 -> 3135
    //   3311: astore_3
    //   3312: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3315: ifeq -154 -> 3161
    //   3318: ldc 130
    //   3320: iconst_2
    //   3321: aload_3
    //   3322: invokevirtual 933	java/lang/Exception:toString	()Ljava/lang/String;
    //   3325: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3328: goto -167 -> 3161
    //   3331: iconst_0
    //   3332: istore_1
    //   3333: goto -107 -> 3226
    //   3336: aload_3
    //   3337: invokeinterface 463 1 0
    //   3342: ifle +2690 -> 6032
    //   3345: iconst_0
    //   3346: istore 5
    //   3348: iload 5
    //   3350: aload_3
    //   3351: invokeinterface 463 1 0
    //   3356: if_icmpge +2676 -> 6032
    //   3359: aload_3
    //   3360: iload 5
    //   3362: invokeinterface 466 2 0
    //   3367: checkcast 1016	com/tencent/mobileqq/data/HotChatInfo
    //   3370: astore_2
    //   3371: aload_2
    //   3372: ifnull +1429 -> 4801
    //   3375: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3378: ifeq +29 -> 3407
    //   3381: ldc 130
    //   3383: iconst_2
    //   3384: new 132	java/lang/StringBuilder
    //   3387: dup
    //   3388: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   3391: ldc_w 1043
    //   3394: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3397: aload_2
    //   3398: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3401: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3404: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3407: aload_2
    //   3408: ifnull +9 -> 3417
    //   3411: aload 15
    //   3413: aload_2
    //   3414: invokevirtual 1047	com/tencent/mobileqq/data/NearbyPeopleCard:updateHotChatInfo	(Lcom/tencent/mobileqq/data/HotChatInfo;)V
    //   3417: aload 15
    //   3419: getfield 388	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   3422: ifnull +788 -> 4210
    //   3425: new 1049	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody
    //   3428: dup
    //   3429: invokespecial 1050	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:<init>	()V
    //   3432: astore_2
    //   3433: aload_2
    //   3434: aload 15
    //   3436: getfield 388	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyInfo	[B
    //   3439: invokevirtual 1051	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3442: pop
    //   3443: iload 8
    //   3445: bipush 51
    //   3447: if_icmpne +1391 -> 4838
    //   3450: aload_2
    //   3451: getfield 1054	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3454: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3457: iconst_1
    //   3458: if_icmpne +1370 -> 4828
    //   3461: iconst_1
    //   3462: istore_1
    //   3463: aload 15
    //   3465: iload_1
    //   3466: putfield 505	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsgForTribar	Z
    //   3469: aload_2
    //   3470: getfield 1057	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3473: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3476: iconst_1
    //   3477: if_icmpne +1356 -> 4833
    //   3480: iconst_1
    //   3481: istore_1
    //   3482: aload 15
    //   3484: iload_1
    //   3485: putfield 493	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsgForTribar	Z
    //   3488: aload 15
    //   3490: aload_2
    //   3491: getfield 1060	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3494: invokevirtual 866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3497: invokevirtual 471	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3500: putfield 517	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTipsForTribar	Ljava/lang/String;
    //   3503: aload 15
    //   3505: aload_2
    //   3506: getfield 1063	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3509: invokevirtual 866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3512: invokevirtual 471	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3515: putfield 511	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTipsForTribar	Ljava/lang/String;
    //   3518: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3521: ifeq +1428 -> 4949
    //   3524: ldc_w 1065
    //   3527: iconst_2
    //   3528: new 132	java/lang/StringBuilder
    //   3531: dup
    //   3532: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   3535: ldc_w 1067
    //   3538: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3541: iload 8
    //   3543: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3546: ldc_w 1069
    //   3549: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3552: aload_2
    //   3553: getfield 1054	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3556: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3559: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3562: ldc_w 1071
    //   3565: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3568: aload_2
    //   3569: getfield 1060	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3572: invokevirtual 866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3575: invokevirtual 471	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3578: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3581: ldc_w 1073
    //   3584: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3587: aload_0
    //   3588: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3591: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3594: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3597: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3600: invokestatic 1076	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3603: aload 15
    //   3605: aload_2
    //   3606: getfield 1079	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_high_score_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3609: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3612: putfield 502	com/tencent/mobileqq/data/NearbyPeopleCard:highScoreNum	I
    //   3615: aload_2
    //   3616: getfield 1083	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3619: invokevirtual 1088	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:has	()Z
    //   3622: ifeq +1433 -> 5055
    //   3625: aload 15
    //   3627: aload_2
    //   3628: getfield 1083	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3631: invokevirtual 1091	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3634: checkcast 1085	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3637: getfield 1094	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3640: invokevirtual 866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3643: invokevirtual 471	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3646: putfield 535	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   3649: aload 15
    //   3651: aload_2
    //   3652: getfield 1083	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3655: invokevirtual 1091	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3658: checkcast 1085	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3661: getfield 1097	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_tail_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3664: invokevirtual 866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3667: invokevirtual 471	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3670: putfield 532	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   3673: aload 15
    //   3675: aload_2
    //   3676: getfield 1083	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3679: invokevirtual 1091	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3682: checkcast 1085	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3685: getfield 1100	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_tail_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3688: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3691: putfield 529	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   3694: aload 15
    //   3696: aload_2
    //   3697: getfield 1083	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3700: invokevirtual 1091	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3703: checkcast 1085	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3706: getfield 1103	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:bytes_card_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3709: invokevirtual 866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3712: invokevirtual 471	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3715: putfield 520	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   3718: aload 15
    //   3720: aload_2
    //   3721: getfield 1083	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3724: invokevirtual 1091	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3727: checkcast 1085	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3730: getfield 1106	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_card_wording_color	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3733: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3736: putfield 523	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   3739: aload 15
    //   3741: aload_2
    //   3742: getfield 1083	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_face_score_config	Lcom/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig;
    //   3745: invokevirtual 1091	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3748: checkcast 1085	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig
    //   3751: getfield 1109	com/tencent/jungle/nearby/nio/proto/oidb_common$DataCardConfig:uint32_entry_ability	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3754: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3757: putfield 526	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   3760: aload_2
    //   3761: getfield 1112	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_jump_app_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3764: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3767: iconst_1
    //   3768: if_icmpne +2277 -> 6045
    //   3771: iconst_1
    //   3772: istore_1
    //   3773: aload 15
    //   3775: iload_1
    //   3776: putfield 1115	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   3779: aload 15
    //   3781: aload_2
    //   3782: getfield 1118	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_result_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3785: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3788: putfield 1121	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   3791: aload 15
    //   3793: aload_2
    //   3794: getfield 1124	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_jump_app_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3797: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3800: putfield 1127	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   3803: aload 15
    //   3805: aload_2
    //   3806: getfield 1130	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:str_plus_download_app_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3809: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3812: putfield 1133	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   3815: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3818: ifeq +104 -> 3922
    //   3821: ldc_w 1135
    //   3824: iconst_2
    //   3825: new 132	java/lang/StringBuilder
    //   3828: dup
    //   3829: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   3832: ldc_w 1137
    //   3835: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3838: aload 15
    //   3840: getfield 107	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   3843: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3846: ldc_w 1139
    //   3849: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3852: aload 15
    //   3854: getfield 1115	com/tencent/mobileqq/data/NearbyPeopleCard:isSendMsgBtnDownloadAppOpen	Z
    //   3857: invokevirtual 1142	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3860: ldc_w 1144
    //   3863: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3866: aload 15
    //   3868: invokevirtual 1147	com/tencent/mobileqq/data/NearbyPeopleCard:isAddPicBtnDownloadAppOpen	()Z
    //   3871: invokevirtual 1142	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3874: ldc_w 1149
    //   3877: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3880: aload 15
    //   3882: getfield 1121	com/tencent/mobileqq/data/NearbyPeopleCard:sendMsgBtnDownloadAppTips	Ljava/lang/String;
    //   3885: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3888: ldc_w 1151
    //   3891: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3894: aload 15
    //   3896: getfield 1133	com/tencent/mobileqq/data/NearbyPeopleCard:addPicBtnDownloadAppTips	Ljava/lang/String;
    //   3899: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3902: ldc_w 1153
    //   3905: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3908: aload 15
    //   3910: getfield 1127	com/tencent/mobileqq/data/NearbyPeopleCard:tribeAppDownloadPageUrl	Ljava/lang/String;
    //   3913: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3916: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3919: invokestatic 1076	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3922: aload_2
    //   3923: getfield 1157	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3926: invokevirtual 1160	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:has	()Z
    //   3929: ifeq +1171 -> 5100
    //   3932: aload 15
    //   3934: aload_2
    //   3935: getfield 1157	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3938: getfield 1163	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3941: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3944: putfield 1166	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTip	Ljava/lang/String;
    //   3947: aload 15
    //   3949: aload_2
    //   3950: getfield 1157	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3953: getfield 1169	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_left_btn	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3956: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3959: putfield 1172	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipLeftBtn	Ljava/lang/String;
    //   3962: aload 15
    //   3964: aload_2
    //   3965: getfield 1157	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3968: getfield 1175	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_right_btn_installed	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3971: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3974: putfield 1178	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnInstalled	Ljava/lang/String;
    //   3977: aload 15
    //   3979: aload_2
    //   3980: getfield 1157	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3983: getfield 1181	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:tip_right_btn_not_installed	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3986: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3989: putfield 1184	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnNotInstalled	Ljava/lang/String;
    //   3992: aload 15
    //   3994: aload_2
    //   3995: getfield 1157	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   3998: getfield 1187	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:android_app_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4001: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4004: putfield 1190	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowPackage	Ljava/lang/String;
    //   4007: aload 15
    //   4009: aload_2
    //   4010: getfield 1157	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   4013: getfield 1193	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:jump_uri	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4016: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4019: putfield 1196	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowJumpUri	Ljava/lang/String;
    //   4022: aload 15
    //   4024: aload_2
    //   4025: getfield 1157	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:nearby_popover_info	Lcom/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo;
    //   4028: getfield 1199	com/tencent/jungle/nearby/nio/proto/nearby$NearbyJumpInfo:app_download_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4031: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4034: putfield 1202	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowDownloadUrl	Ljava/lang/String;
    //   4037: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4040: ifeq +170 -> 4210
    //   4043: new 132	java/lang/StringBuilder
    //   4046: dup
    //   4047: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   4050: astore_2
    //   4051: aload_2
    //   4052: ldc_w 1204
    //   4055: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4058: ldc_w 1206
    //   4061: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4064: aload 15
    //   4066: getfield 1166	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTip	Ljava/lang/String;
    //   4069: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4072: ldc_w 1208
    //   4075: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4078: ldc_w 1210
    //   4081: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4084: aload 15
    //   4086: getfield 1172	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipLeftBtn	Ljava/lang/String;
    //   4089: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4092: ldc_w 1208
    //   4095: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4098: ldc_w 1212
    //   4101: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4104: aload 15
    //   4106: getfield 1178	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnInstalled	Ljava/lang/String;
    //   4109: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4112: ldc_w 1208
    //   4115: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4118: ldc_w 1214
    //   4121: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4124: aload 15
    //   4126: getfield 1184	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowTipRightBtnNotInstalled	Ljava/lang/String;
    //   4129: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4132: ldc_w 1208
    //   4135: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4138: ldc_w 1216
    //   4141: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4144: aload 15
    //   4146: getfield 1190	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowPackage	Ljava/lang/String;
    //   4149: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4152: ldc_w 1208
    //   4155: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4158: ldc_w 1218
    //   4161: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4164: aload 15
    //   4166: getfield 1196	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowJumpUri	Ljava/lang/String;
    //   4169: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4172: ldc_w 1208
    //   4175: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4178: ldc_w 1220
    //   4181: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4184: aload 15
    //   4186: getfield 1202	com/tencent/mobileqq/data/NearbyPeopleCard:guideAppNowDownloadUrl	Ljava/lang/String;
    //   4189: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4192: ldc_w 1208
    //   4195: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4198: pop
    //   4199: ldc_w 582
    //   4202: iconst_2
    //   4203: aload_2
    //   4204: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4207: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4210: aload 18
    //   4212: getfield 1224	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   4215: ifnull +29 -> 4244
    //   4218: aload 15
    //   4220: aload 18
    //   4222: getfield 1224	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   4225: getfield 1229	SummaryCard/GiftInfo:uOpenFlag	J
    //   4228: putfield 1232	com/tencent/mobileqq/data/NearbyPeopleCard:switchGiftVisible	J
    //   4231: aload 15
    //   4233: aload 18
    //   4235: getfield 1224	SummaryCard/RespSummaryCard:stGiftInfo	LSummaryCard/GiftInfo;
    //   4238: getfield 1233	SummaryCard/GiftInfo:vGiftInfo	[B
    //   4241: putfield 1234	com/tencent/mobileqq/data/NearbyPeopleCard:vGiftInfo	[B
    //   4244: aload 18
    //   4246: getfield 1237	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   4249: ifnull +165 -> 4414
    //   4252: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4255: ifeq +13 -> 4268
    //   4258: ldc_w 582
    //   4261: iconst_2
    //   4262: ldc_w 1239
    //   4265: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4268: new 1241	tencent/im/group/group_member_info$RspGroupCardGetStory
    //   4271: dup
    //   4272: invokespecial 1242	tencent/im/group/group_member_info$RspGroupCardGetStory:<init>	()V
    //   4275: astore_2
    //   4276: aload_2
    //   4277: aload 18
    //   4279: getfield 1237	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   4282: invokevirtual 1243	tencent/im/group/group_member_info$RspGroupCardGetStory:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4285: pop
    //   4286: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4289: ifeq +84 -> 4373
    //   4292: ldc_w 582
    //   4295: iconst_2
    //   4296: new 132	java/lang/StringBuilder
    //   4299: dup
    //   4300: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   4303: ldc_w 1245
    //   4306: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4309: aload_2
    //   4310: getfield 1248	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4313: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4316: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4319: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4322: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4325: aload_2
    //   4326: getfield 1251	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4329: invokevirtual 1252	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4332: ifeq +41 -> 4373
    //   4335: ldc_w 582
    //   4338: iconst_2
    //   4339: new 132	java/lang/StringBuilder
    //   4342: dup
    //   4343: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   4346: ldc_w 1254
    //   4349: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4352: aload_2
    //   4353: getfield 1251	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4356: invokevirtual 996	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4359: invokeinterface 463 1 0
    //   4364: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4367: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4370: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4373: aload_2
    //   4374: getfield 1248	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4377: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4380: iconst_1
    //   4381: if_icmpne +738 -> 5119
    //   4384: iconst_1
    //   4385: istore_1
    //   4386: aload 15
    //   4388: iload_1
    //   4389: putfield 1257	com/tencent/mobileqq/data/NearbyPeopleCard:mHasStory	Z
    //   4392: aload_2
    //   4393: getfield 1251	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4396: invokevirtual 1252	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4399: ifeq +15 -> 4414
    //   4402: aload 15
    //   4404: aload_2
    //   4405: getfield 1251	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4408: invokevirtual 996	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4411: invokevirtual 1260	com/tencent/mobileqq/data/NearbyPeopleCard:addQQStoryList	(Ljava/util/List;)V
    //   4414: aload 18
    //   4416: getfield 1263	SummaryCard/RespSummaryCard:vNearbyTaskInfo	[B
    //   4419: astore_2
    //   4420: aload_2
    //   4421: ifnull +41 -> 4462
    //   4424: new 1265	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody
    //   4427: dup
    //   4428: invokespecial 1266	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:<init>	()V
    //   4431: astore_3
    //   4432: aload_3
    //   4433: aload_2
    //   4434: invokevirtual 1267	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4437: pop
    //   4438: aload 15
    //   4440: aload_3
    //   4441: getfield 1270	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:uint32_finish_task_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4444: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4447: putfield 1273	com/tencent/mobileqq/data/NearbyPeopleCard:taskFinished	I
    //   4450: aload 15
    //   4452: aload_3
    //   4453: getfield 1276	tencent/im/oidb/cmd0xa5c/oidb_0xa5c$RspBody:uint32_all_task_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4456: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4459: putfield 1279	com/tencent/mobileqq/data/NearbyPeopleCard:taskTotal	I
    //   4462: aload 18
    //   4464: getfield 1282	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   4467: astore_2
    //   4468: aload_2
    //   4469: ifnull +708 -> 5177
    //   4472: aload 15
    //   4474: new 430	java/util/ArrayList
    //   4477: dup
    //   4478: invokespecial 431	java/util/ArrayList:<init>	()V
    //   4481: putfield 1285	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanList	Ljava/util/List;
    //   4484: new 1287	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData
    //   4487: dup
    //   4488: invokespecial 1288	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:<init>	()V
    //   4491: astore_3
    //   4492: aload_3
    //   4493: aload_2
    //   4494: invokevirtual 1289	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4497: pop
    //   4498: aload_3
    //   4499: getfield 1292	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NearbyNowData:rpt_msg_now_haiwan	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4502: invokevirtual 996	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4505: astore_2
    //   4506: aload_2
    //   4507: ifnull +670 -> 5177
    //   4510: new 456	org/json/JSONArray
    //   4513: dup
    //   4514: invokespecial 457	org/json/JSONArray:<init>	()V
    //   4517: astore_3
    //   4518: iconst_0
    //   4519: istore 5
    //   4521: iload 5
    //   4523: aload_2
    //   4524: invokeinterface 463 1 0
    //   4529: if_icmpge +635 -> 5164
    //   4532: new 1294	org/json/JSONObject
    //   4535: dup
    //   4536: invokespecial 1295	org/json/JSONObject:<init>	()V
    //   4539: astore 4
    //   4541: new 1297	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem
    //   4544: dup
    //   4545: invokespecial 1298	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:<init>	()V
    //   4548: astore 19
    //   4550: aload 19
    //   4552: aload_2
    //   4553: iload 5
    //   4555: invokeinterface 466 2 0
    //   4560: checkcast 1300	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4563: getfield 1303	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4566: invokevirtual 866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4569: invokevirtual 471	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4572: putfield 1305	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4575: aload 19
    //   4577: getfield 1305	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4580: invokestatic 1308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4583: ifne +17 -> 4600
    //   4586: aload 4
    //   4588: ldc_w 1309
    //   4591: aload 19
    //   4593: getfield 1305	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:title	Ljava/lang/String;
    //   4596: invokevirtual 1312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4599: pop
    //   4600: aload 19
    //   4602: aload_2
    //   4603: iload 5
    //   4605: invokeinterface 466 2 0
    //   4610: checkcast 1300	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4613: getfield 1315	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_icon	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4616: invokevirtual 866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4619: invokevirtual 471	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4622: putfield 1318	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4625: aload 19
    //   4627: getfield 1318	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4630: invokestatic 1308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4633: ifne +17 -> 4650
    //   4636: aload 4
    //   4638: ldc_w 1319
    //   4641: aload 19
    //   4643: getfield 1318	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:icon	Ljava/lang/String;
    //   4646: invokevirtual 1312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4649: pop
    //   4650: aload 19
    //   4652: aload_2
    //   4653: iload 5
    //   4655: invokeinterface 466 2 0
    //   4660: checkcast 1300	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4663: getfield 1322	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4666: invokevirtual 866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4669: invokevirtual 471	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4672: putfield 1324	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4675: aload 19
    //   4677: getfield 1324	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4680: invokestatic 1308	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4683: ifne +17 -> 4700
    //   4686: aload 4
    //   4688: ldc_w 1325
    //   4691: aload 19
    //   4693: getfield 1324	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:url	Ljava/lang/String;
    //   4696: invokevirtual 1312	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4699: pop
    //   4700: aload 19
    //   4702: aload_2
    //   4703: iload 5
    //   4705: invokeinterface 466 2 0
    //   4710: checkcast 1300	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4713: getfield 1328	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:uint32_status	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4716: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4719: putfield 1331	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:status	I
    //   4722: aload 4
    //   4724: ldc_w 1332
    //   4727: aload 19
    //   4729: getfield 1331	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:status	I
    //   4732: invokevirtual 1335	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4735: pop
    //   4736: aload 19
    //   4738: aload_2
    //   4739: iload 5
    //   4741: invokeinterface 466 2 0
    //   4746: checkcast 1300	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan
    //   4749: getfield 1338	com/tencent/mobileqq/troop/org/pb/oidb_0xac5$NowHaiWan:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4752: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4755: putfield 1340	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:type	I
    //   4758: aload 4
    //   4760: ldc_w 1341
    //   4763: aload 19
    //   4765: getfield 1340	com/tencent/mobileqq/data/NearbyPeopleCard$HiWanItem:type	I
    //   4768: invokevirtual 1335	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4771: pop
    //   4772: aload 15
    //   4774: getfield 1285	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanList	Ljava/util/List;
    //   4777: aload 19
    //   4779: invokeinterface 474 2 0
    //   4784: pop
    //   4785: aload_3
    //   4786: aload 4
    //   4788: invokevirtual 478	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   4791: pop
    //   4792: iload 5
    //   4794: iconst_1
    //   4795: iadd
    //   4796: istore 5
    //   4798: goto -277 -> 4521
    //   4801: iload 5
    //   4803: iconst_1
    //   4804: iadd
    //   4805: istore 5
    //   4807: goto -1459 -> 3348
    //   4810: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4813: ifeq -1396 -> 3417
    //   4816: ldc 130
    //   4818: iconst_2
    //   4819: ldc_w 1343
    //   4822: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4825: goto -1408 -> 3417
    //   4828: iconst_0
    //   4829: istore_1
    //   4830: goto -1367 -> 3463
    //   4833: iconst_0
    //   4834: istore_1
    //   4835: goto -1353 -> 3482
    //   4838: aload 15
    //   4840: aload_2
    //   4841: getfield 1054	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4844: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4847: putfield 499	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   4850: aload 15
    //   4852: getfield 499	com/tencent/mobileqq/data/NearbyPeopleCard:maskMsgFlag	I
    //   4855: iconst_1
    //   4856: if_icmpne +83 -> 4939
    //   4859: iconst_1
    //   4860: istore_1
    //   4861: aload 15
    //   4863: iload_1
    //   4864: putfield 496	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendMsg	Z
    //   4867: aload_2
    //   4868: getfield 1057	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_gift	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4871: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4874: iconst_1
    //   4875: if_icmpne +69 -> 4944
    //   4878: iconst_1
    //   4879: istore_1
    //   4880: aload 15
    //   4882: iload_1
    //   4883: putfield 490	com/tencent/mobileqq/data/NearbyPeopleCard:isForbidSendGiftMsg	Z
    //   4886: aload 15
    //   4888: aload_2
    //   4889: getfield 1060	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4892: invokevirtual 866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4895: invokevirtual 471	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4898: putfield 514	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendMsgBtnTips	Ljava/lang/String;
    //   4901: aload 15
    //   4903: aload_2
    //   4904: getfield 1063	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_gift_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4907: invokevirtual 866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4910: invokevirtual 471	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   4913: putfield 508	com/tencent/mobileqq/data/NearbyPeopleCard:disableSendGiftBtnTips	Ljava/lang/String;
    //   4916: goto -1398 -> 3518
    //   4919: astore_2
    //   4920: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4923: ifeq -713 -> 4210
    //   4926: ldc_w 582
    //   4929: iconst_2
    //   4930: ldc_w 1345
    //   4933: invokestatic 1076	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4936: goto -726 -> 4210
    //   4939: iconst_0
    //   4940: istore_1
    //   4941: goto -80 -> 4861
    //   4944: iconst_0
    //   4945: istore_1
    //   4946: goto -66 -> 4880
    //   4949: ldc_w 1065
    //   4952: iconst_1
    //   4953: new 132	java/lang/StringBuilder
    //   4956: dup
    //   4957: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   4960: ldc_w 1067
    //   4963: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4966: iload 8
    //   4968: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4971: ldc_w 1069
    //   4974: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4977: aload_2
    //   4978: getfield 1054	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:uint32_if_mask_msg	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4981: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4984: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4987: ldc_w 1071
    //   4990: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4993: aload_2
    //   4994: getfield 1060	com/tencent/jungle/nearby/nio/proto/nearby$Cmd0x1RspBody:bytes_mask_msg_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4997: invokevirtual 866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5000: invokevirtual 471	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5003: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5006: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5009: invokestatic 1076	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5012: goto -1409 -> 3603
    //   5015: astore_3
    //   5016: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5019: ifeq -1416 -> 3603
    //   5022: ldc_w 582
    //   5025: iconst_2
    //   5026: new 132	java/lang/StringBuilder
    //   5029: dup
    //   5030: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   5033: ldc_w 1347
    //   5036: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5039: aload_3
    //   5040: invokevirtual 933	java/lang/Exception:toString	()Ljava/lang/String;
    //   5043: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5046: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5049: invokestatic 697	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5052: goto -1449 -> 3603
    //   5055: aload 15
    //   5057: ldc_w 350
    //   5060: putfield 535	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreIconUrl	Ljava/lang/String;
    //   5063: aload 15
    //   5065: ldc_w 350
    //   5068: putfield 532	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWording	Ljava/lang/String;
    //   5071: aload 15
    //   5073: iconst_0
    //   5074: putfield 529	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreTailWordingColor	I
    //   5077: aload 15
    //   5079: ldc_w 350
    //   5082: putfield 520	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWording	Ljava/lang/String;
    //   5085: aload 15
    //   5087: iconst_0
    //   5088: putfield 523	com/tencent/mobileqq/data/NearbyPeopleCard:faceScoreWordingColor	I
    //   5091: aload 15
    //   5093: iconst_0
    //   5094: putfield 526	com/tencent/mobileqq/data/NearbyPeopleCard:entryAbility	I
    //   5097: goto -1337 -> 3760
    //   5100: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5103: ifeq -893 -> 4210
    //   5106: ldc_w 582
    //   5109: iconst_2
    //   5110: ldc_w 1349
    //   5113: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5116: goto -906 -> 4210
    //   5119: iconst_0
    //   5120: istore_1
    //   5121: goto -735 -> 4386
    //   5124: astore_2
    //   5125: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5128: ifeq -714 -> 4414
    //   5131: ldc_w 582
    //   5134: iconst_2
    //   5135: new 132	java/lang/StringBuilder
    //   5138: dup
    //   5139: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   5142: ldc_w 1351
    //   5145: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5148: aload_2
    //   5149: invokevirtual 1352	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   5152: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5155: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5158: invokestatic 697	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5161: goto -747 -> 4414
    //   5164: aload_3
    //   5165: ifnull +12 -> 5177
    //   5168: aload 15
    //   5170: aload_3
    //   5171: invokevirtual 559	org/json/JSONArray:toString	()Ljava/lang/String;
    //   5174: putfield 1355	com/tencent/mobileqq/data/NearbyPeopleCard:hiWanInfo	Ljava/lang/String;
    //   5177: aload 15
    //   5179: aload 18
    //   5181: getfield 1282	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   5184: putfield 1358	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowDataBytes	[B
    //   5187: new 1360	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData
    //   5190: dup
    //   5191: invokespecial 1361	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:<init>	()V
    //   5194: astore_3
    //   5195: aload_3
    //   5196: aload 18
    //   5198: getfield 1282	SummaryCard/RespSummaryCard:vNowInfo	[B
    //   5201: invokevirtual 1362	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5204: pop
    //   5205: aload_3
    //   5206: astore_2
    //   5207: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5210: ifeq +70 -> 5280
    //   5213: ldc_w 582
    //   5216: iconst_2
    //   5217: new 132	java/lang/StringBuilder
    //   5220: dup
    //   5221: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   5224: ldc_w 1364
    //   5227: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5230: aload_3
    //   5231: getfield 1367	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:bytes_more_video_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5234: invokevirtual 1368	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   5237: invokevirtual 1142	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5240: ldc_w 1370
    //   5243: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5246: aload_3
    //   5247: getfield 1373	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_video_feed	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5250: invokevirtual 1252	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   5253: invokevirtual 1142	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5256: ldc_w 1375
    //   5259: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5262: aload_3
    //   5263: getfield 1378	tencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData:rpt_msg_now_follow_anchor	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5266: invokevirtual 1252	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   5269: invokevirtual 1142	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5272: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5275: invokestatic 1076	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5278: aload_3
    //   5279: astore_2
    //   5280: aload 15
    //   5282: aload_2
    //   5283: putfield 1382	com/tencent/mobileqq/data/NearbyPeopleCard:nearbyNowData	Ltencent/im/oidb/cmd0xac5/cmd0xac5$NearbyNowData;
    //   5286: aload_0
    //   5287: bipush 51
    //   5289: iconst_1
    //   5290: aload 15
    //   5292: iload 10
    //   5294: invokevirtual 1386	ajrs:notifyUI	(IZLjava/lang/Object;Z)V
    //   5297: aload_0
    //   5298: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5301: bipush 106
    //   5303: invokevirtual 1390	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5306: checkcast 1392	ajpj
    //   5309: astore_2
    //   5310: iload 8
    //   5312: bipush 51
    //   5314: if_icmpne +458 -> 5772
    //   5317: aload_2
    //   5318: aload 15
    //   5320: getfield 107	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5323: invokestatic 1397	android/os/SystemClock:elapsedRealtime	()J
    //   5326: invokevirtual 1401	ajpj:aq	(Ljava/lang/String;J)V
    //   5329: invokestatic 550	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   5332: ifeq +46 -> 5378
    //   5335: ldc_w 1403
    //   5338: iconst_4
    //   5339: new 132	java/lang/StringBuilder
    //   5342: dup
    //   5343: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   5346: ldc_w 1405
    //   5349: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5352: aload 15
    //   5354: getfield 109	com/tencent/mobileqq/data/NearbyPeopleCard:tinyId	J
    //   5357: invokevirtual 567	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5360: ldc_w 1407
    //   5363: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5366: invokestatic 1397	android/os/SystemClock:elapsedRealtime	()J
    //   5369: invokevirtual 567	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5372: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5375: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5378: aload_0
    //   5379: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5382: bipush 51
    //   5384: invokevirtual 1390	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5387: checkcast 1409	acff
    //   5390: astore_2
    //   5391: invokestatic 1412	ajrk:isColorLevel	()Z
    //   5394: ifeq +56 -> 5450
    //   5397: ldc_w 582
    //   5400: iconst_5
    //   5401: anewarray 1414	java/lang/Object
    //   5404: dup
    //   5405: iconst_0
    //   5406: ldc_w 1416
    //   5409: aastore
    //   5410: dup
    //   5411: iconst_1
    //   5412: iload 8
    //   5414: invokestatic 1421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5417: aastore
    //   5418: dup
    //   5419: iconst_2
    //   5420: aload 15
    //   5422: getfield 107	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5425: aastore
    //   5426: dup
    //   5427: iconst_3
    //   5428: aload_0
    //   5429: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5432: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5435: aastore
    //   5436: dup
    //   5437: iconst_4
    //   5438: aload 18
    //   5440: getfield 95	SummaryCard/RespSummaryCard:lUIN	J
    //   5443: invokestatic 1426	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5446: aastore
    //   5447: invokestatic 1430	ajrk:m	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   5450: iload 8
    //   5452: ifeq +21 -> 5473
    //   5455: aload 15
    //   5457: getfield 107	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5460: aload_0
    //   5461: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5464: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5467: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5470: ifeq +76 -> 5546
    //   5473: aload_2
    //   5474: aload 15
    //   5476: getfield 107	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5479: invokevirtual 1434	acff:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   5482: astore_3
    //   5483: aload_3
    //   5484: aload 15
    //   5486: getfield 163	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   5489: putfield 1439	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   5492: aload_3
    //   5493: aload 15
    //   5495: getfield 160	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   5498: i2l
    //   5499: putfield 1442	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   5502: aload_0
    //   5503: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5506: invokevirtual 1445	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   5509: aload_3
    //   5510: getfield 1442	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   5513: aload_3
    //   5514: getfield 1439	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   5517: invokestatic 1450	ajrb:b	(Ljava/lang/String;JI)Z
    //   5520: pop
    //   5521: aload_2
    //   5522: aload_3
    //   5523: invokevirtual 1453	acff:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   5526: pop
    //   5527: aload_0
    //   5528: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5531: invokevirtual 1445	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   5534: ldc_w 1455
    //   5537: aload 15
    //   5539: getfield 259	com/tencent/mobileqq/data/NearbyPeopleCard:college	Ljava/lang/String;
    //   5542: invokestatic 1458	ajrb:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)Z
    //   5545: pop
    //   5546: aload_0
    //   5547: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5550: invokevirtual 118	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5553: aload 15
    //   5555: getfield 107	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5558: invokevirtual 122	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5561: ifeq +31 -> 5592
    //   5564: aload 15
    //   5566: getfield 606	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   5569: ifle +23 -> 5592
    //   5572: aload_0
    //   5573: getfield 41	ajrs:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5576: bipush 60
    //   5578: invokevirtual 1390	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5581: checkcast 1460	com/tencent/mobileqq/app/HotChatManager
    //   5584: aload 15
    //   5586: getfield 606	com/tencent/mobileqq/data/NearbyPeopleCard:charmLevel	I
    //   5589: invokevirtual 1463	com/tencent/mobileqq/app/HotChatManager:Jf	(I)V
    //   5592: aload_2
    //   5593: aload 15
    //   5595: invokevirtual 1466	acff:a	(Lcom/tencent/mobileqq/data/NearbyPeopleCard;)V
    //   5598: aload 15
    //   5600: invokevirtual 483	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5603: sipush 1000
    //   5606: if_icmpne +347 -> 5953
    //   5609: aload 16
    //   5611: iconst_0
    //   5612: ldc 79
    //   5614: invokevirtual 1471	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   5617: aconst_null
    //   5618: aconst_null
    //   5619: aconst_null
    //   5620: aconst_null
    //   5621: aconst_null
    //   5622: aconst_null
    //   5623: aconst_null
    //   5624: invokevirtual 1475	com/tencent/mobileqq/persistence/EntityManager:query	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   5627: astore_3
    //   5628: aload_3
    //   5629: ifnull +287 -> 5916
    //   5632: aload_3
    //   5633: astore_2
    //   5634: aload_3
    //   5635: invokeinterface 1480 1 0
    //   5640: istore 5
    //   5642: aload_3
    //   5643: astore_2
    //   5644: aload_3
    //   5645: invokeinterface 1483 1 0
    //   5650: pop
    //   5651: iload 5
    //   5653: sipush 200
    //   5656: if_icmple +260 -> 5916
    //   5659: iload 5
    //   5661: bipush 100
    //   5663: if_icmple +132 -> 5795
    //   5666: aload_3
    //   5667: astore_2
    //   5668: aload_3
    //   5669: invokeinterface 1486 1 0
    //   5674: pop
    //   5675: iload 5
    //   5677: iconst_1
    //   5678: isub
    //   5679: istore 5
    //   5681: goto -22 -> 5659
    //   5684: astore_2
    //   5685: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5688: ifeq -511 -> 5177
    //   5691: ldc_w 582
    //   5694: iconst_2
    //   5695: new 132	java/lang/StringBuilder
    //   5698: dup
    //   5699: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   5702: ldc_w 1488
    //   5705: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5708: aload_2
    //   5709: invokevirtual 694	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   5712: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5715: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5718: invokestatic 697	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5721: goto -544 -> 5177
    //   5724: astore 4
    //   5726: aconst_null
    //   5727: astore_3
    //   5728: aload_3
    //   5729: astore_2
    //   5730: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5733: ifeq -453 -> 5280
    //   5736: ldc_w 582
    //   5739: iconst_2
    //   5740: new 132	java/lang/StringBuilder
    //   5743: dup
    //   5744: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   5747: ldc_w 1490
    //   5750: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5753: aload 4
    //   5755: invokevirtual 933	java/lang/Exception:toString	()Ljava/lang/String;
    //   5758: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5761: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5764: invokestatic 558	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   5767: aload_3
    //   5768: astore_2
    //   5769: goto -489 -> 5280
    //   5772: aload_2
    //   5773: aload 15
    //   5775: getfield 107	com/tencent/mobileqq/data/NearbyPeopleCard:uin	Ljava/lang/String;
    //   5778: invokestatic 1397	android/os/SystemClock:elapsedRealtime	()J
    //   5781: invokevirtual 1493	ajpj:ap	(Ljava/lang/String;J)V
    //   5784: goto -455 -> 5329
    //   5787: astore_3
    //   5788: aload_3
    //   5789: invokevirtual 1496	java/lang/Exception:printStackTrace	()V
    //   5792: goto -246 -> 5546
    //   5795: aload_3
    //   5796: astore_2
    //   5797: aload_3
    //   5798: aload_3
    //   5799: ldc_w 1498
    //   5802: invokeinterface 1501 2 0
    //   5807: invokeinterface 1504 2 0
    //   5812: istore 5
    //   5814: aload_3
    //   5815: astore_2
    //   5816: new 132	java/lang/StringBuilder
    //   5819: dup
    //   5820: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   5823: astore 4
    //   5825: aload_3
    //   5826: astore_2
    //   5827: aload 4
    //   5829: ldc_w 1506
    //   5832: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5835: pop
    //   5836: aload_3
    //   5837: astore_2
    //   5838: aload 4
    //   5840: ldc 79
    //   5842: invokevirtual 1471	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   5845: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5848: pop
    //   5849: aload_3
    //   5850: astore_2
    //   5851: aload 4
    //   5853: ldc_w 1508
    //   5856: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5859: pop
    //   5860: aload_3
    //   5861: astore_2
    //   5862: aload 4
    //   5864: ldc_w 1498
    //   5867: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5870: pop
    //   5871: aload_3
    //   5872: astore_2
    //   5873: aload 4
    //   5875: ldc_w 1510
    //   5878: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5881: pop
    //   5882: aload_3
    //   5883: astore_2
    //   5884: aload 4
    //   5886: iload 5
    //   5888: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5891: pop
    //   5892: aload_3
    //   5893: astore_2
    //   5894: aload 4
    //   5896: ldc_w 1512
    //   5899: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5902: pop
    //   5903: aload_3
    //   5904: astore_2
    //   5905: aload 16
    //   5907: aload 4
    //   5909: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5912: invokevirtual 1515	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   5915: pop
    //   5916: aload_3
    //   5917: astore_2
    //   5918: aload 16
    //   5920: aload 15
    //   5922: invokevirtual 1519	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   5925: aload_3
    //   5926: astore_2
    //   5927: aload 17
    //   5929: invokevirtual 1522	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   5932: aload_3
    //   5933: ifnull +9 -> 5942
    //   5936: aload_3
    //   5937: invokeinterface 1525 1 0
    //   5942: aload 17
    //   5944: invokevirtual 1528	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   5947: aload 16
    //   5949: invokevirtual 1529	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   5952: return
    //   5953: aload 15
    //   5955: invokevirtual 483	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5958: sipush 1001
    //   5961: if_icmpeq +14 -> 5975
    //   5964: aload 15
    //   5966: invokevirtual 483	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   5969: sipush 1002
    //   5972: if_icmpne +11 -> 5983
    //   5975: aload 16
    //   5977: aload 15
    //   5979: invokevirtual 1533	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   5982: pop
    //   5983: aconst_null
    //   5984: astore_3
    //   5985: goto -60 -> 5925
    //   5988: astore_3
    //   5989: aconst_null
    //   5990: astore_2
    //   5991: aload_2
    //   5992: ifnull +9 -> 6001
    //   5995: aload_2
    //   5996: invokeinterface 1525 1 0
    //   6001: aload 17
    //   6003: invokevirtual 1528	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   6006: aload 16
    //   6008: invokevirtual 1529	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   6011: aload_3
    //   6012: athrow
    //   6013: aload_0
    //   6014: bipush 51
    //   6016: iconst_0
    //   6017: aconst_null
    //   6018: iload 10
    //   6020: invokevirtual 1386	ajrs:notifyUI	(IZLjava/lang/Object;Z)V
    //   6023: return
    //   6024: astore_3
    //   6025: goto -34 -> 5991
    //   6028: astore_2
    //   6029: goto -1567 -> 4462
    //   6032: aconst_null
    //   6033: astore_2
    //   6034: goto -2659 -> 3375
    //   6037: aconst_null
    //   6038: astore_2
    //   6039: goto -5883 -> 156
    //   6042: goto -5886 -> 156
    //   6045: iconst_0
    //   6046: istore_1
    //   6047: goto -2274 -> 3773
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6050	0	this	ajrs
    //   0	6050	1	paramBoolean	boolean
    //   0	6050	2	paramObject	Object
    //   0	6050	3	paramBundle	Bundle
    //   0	6050	4	paramRespHead	SummaryCard.RespHead
    //   73	5814	5	i	int
    //   2016	1063	6	j	int
    //   2056	791	7	k	int
    //   14	5437	8	m	int
    //   2064	755	9	n	int
    //   6	6013	10	bool	boolean
    //   57	3219	11	l1	long
    //   65	1114	13	l2	long
    //   167	5811	15	localNearbyPeopleCard	NearbyPeopleCard
    //   36	5971	16	localEntityManager	EntityManager
    //   43	5959	17	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   24	5415	18	localRespSummaryCard	SummaryCard.RespSummaryCard
    //   846	3932	19	localObject1	Object
    //   872	1497	20	localObject2	Object
    //   2229	368	21	localaldb	aldb
    //   2350	240	22	localArrayList	ArrayList
    //   2381	168	23	localLabel	com.tencent.pb.profilecard.SummaryCardBusiEntry.Label
    //   2390	183	24	localalcz	alcz
    //   2443	123	25	localalcx	alcx
    // Exception table:
    //   from	to	target	type
    //   848	899	1735	java/lang/Exception
    //   902	950	1735	java/lang/Exception
    //   1301	1311	1735	java/lang/Exception
    //   2106	2131	2692	java/lang/Exception
    //   2136	2187	2692	java/lang/Exception
    //   2190	2352	2692	java/lang/Exception
    //   2355	2578	2692	java/lang/Exception
    //   2587	2594	2692	java/lang/Exception
    //   2594	2602	2692	java/lang/Exception
    //   2611	2618	2692	java/lang/Exception
    //   2618	2689	2692	java/lang/Exception
    //   2860	2877	2988	java/lang/Exception
    //   2882	2970	2988	java/lang/Exception
    //   2970	2985	2988	java/lang/Exception
    //   3008	3036	2988	java/lang/Exception
    //   3039	3103	2988	java/lang/Exception
    //   3252	3287	3290	java/lang/Exception
    //   3151	3161	3311	java/lang/Exception
    //   3433	3443	4919	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3450	3461	4919	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3463	3480	4919	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3482	3518	4919	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3518	3603	4919	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3603	3760	4919	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3760	3771	4919	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3773	3922	4919	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3922	4210	4919	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4838	4859	4919	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4861	4878	4919	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4880	4916	4919	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4949	5012	4919	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5016	5052	4919	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5055	5097	4919	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5100	5116	4919	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3518	3603	5015	java/lang/Exception
    //   4949	5012	5015	java/lang/Exception
    //   4252	4268	5124	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4268	4373	5124	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4373	4384	5124	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4386	4414	5124	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4492	4506	5684	java/lang/Exception
    //   4510	4518	5684	java/lang/Exception
    //   4521	4600	5684	java/lang/Exception
    //   4600	4650	5684	java/lang/Exception
    //   4650	4700	5684	java/lang/Exception
    //   4700	4792	5684	java/lang/Exception
    //   5168	5177	5684	java/lang/Exception
    //   5187	5205	5724	java/lang/Exception
    //   5207	5278	5724	java/lang/Exception
    //   5527	5546	5787	java/lang/Exception
    //   5598	5628	5988	finally
    //   5953	5975	5988	finally
    //   5975	5983	5988	finally
    //   5634	5642	6024	finally
    //   5644	5651	6024	finally
    //   5668	5675	6024	finally
    //   5797	5814	6024	finally
    //   5816	5825	6024	finally
    //   5827	5836	6024	finally
    //   5838	5849	6024	finally
    //   5851	5860	6024	finally
    //   5862	5871	6024	finally
    //   5873	5882	6024	finally
    //   5884	5892	6024	finally
    //   5894	5903	6024	finally
    //   5905	5916	6024	finally
    //   5918	5925	6024	finally
    //   5927	5932	6024	finally
    //   4432	4462	6028	java/lang/Exception
  }
  
  private void bO(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("uin");
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_cover_rsp))) {
      paramToServiceMsg = (mobile_sub_get_cover_rsp)paramObject;
    }
    for (boolean bool = true;; bool = false)
    {
      notifyUI(40, bool, new Object[] { str, paramToServiceMsg });
      return;
      paramToServiceMsg = null;
    }
  }
  
  private void c(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCardHandler", 2, "handleGetShowExtTroopListRsp");
    }
    if ((!paramBoolean) || (paramOIDBSSOPkg == null)) {
      notifyUI(57, paramBoolean, null);
    }
    for (;;)
    {
      return;
      paramObject = paramToServiceMsg.extraData.getString("target_uin");
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = new cmd0x8b4.RspBody();
      try
      {
        ((cmd0x8b4.RspBody)localObject1).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        paramOIDBSSOPkg = new Object[2];
        paramOIDBSSOPkg[0] = Integer.valueOf(((cmd0x8b4.RspBody)localObject1).uint32_result.get());
        paramOIDBSSOPkg[1] = null;
        if ((paramFromServiceMsg.isSuccess()) && (((cmd0x8b4.RspBody)localObject1).uint32_result.get() == 0)) {
          if (!((cmd0x8b4.RspBody)localObject1).rpt_group_info.has())
          {
            notifyUI(57, paramBoolean, paramOIDBSSOPkg);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramOIDBSSOPkg)
      {
        notifyUI(57, paramBoolean, null);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("NearbyCardHandler.troop.get_show_external_troop_list", 2, "handleGetShowExtTroopListRsp, handle rsp begin==>" + "|ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + "|ServiceCmd:" + paramToServiceMsg.getServiceCmd() + "|destUin:" + paramObject + "|seTroopArray:" + localStringBuilder.toString());
        return;
        paramOIDBSSOPkg = new ArrayList();
        localObject2 = ((cmd0x8b4.RspBody)localObject1).rpt_group_info.get();
        localStringBuilder.append("groupInfoList size:").append(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          cmd0x8b4.GroupInfo localGroupInfo = (cmd0x8b4.GroupInfo)((Iterator)localObject2).next();
          paramOIDBSSOPkg.add(new ShowExternalTroop(localGroupInfo));
          localStringBuilder.append("[uint64_gc:").append(localGroupInfo.uint64_gc.get()).append(",addedTimestamp:").append(localGroupInfo.uint32_set_display_time.get()).append("], ");
        }
      }
      catch (NullPointerException paramOIDBSSOPkg)
      {
        for (;;)
        {
          notifyUI(57, paramBoolean, null);
          continue;
          localObject1 = ((cmd0x8b4.RspBody)localObject1).bytes_text_label.get();
          Object localObject2 = new ArrayList();
          int i = 0;
          while (i < ((List)localObject1).size())
          {
            ((List)localObject2).add(((ByteStringMicro)((List)localObject1).get(i)).toStringUtf8());
            i += 1;
          }
          notifyUI(57, paramBoolean, new Object[] { Integer.valueOf(0), paramOIDBSSOPkg, localObject2 });
          continue;
          notifyUI(57, paramBoolean, paramOIDBSSOPkg);
        }
      }
    }
  }
  
  private void gT(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyCardHandler", 2, "handle0x8b4Rsp");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000) {}
    for (boolean bool = false;; bool = true)
    {
      Object localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        localObject = localOIDBSSOPkg;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NearbyCardHandler", 2, "handle0x8b4Rsp InvalidProtocolBufferMicroException");
          }
          bool = false;
        }
      }
      if (localObject == null) {
        break;
      }
      if ((!((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) || (!((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() == null)) {
        bool = false;
      }
      if (((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get() != 4) {
        break;
      }
      c(bool, paramToServiceMsg, paramFromServiceMsg, (oidb_sso.OIDBSSOPkg)localObject, paramObject);
      return;
    }
  }
  
  private void kj(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  private void kk(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(1, false, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), null, null, "", Integer.valueOf(-1), Integer.valueOf(-1), acfp.m(2131708665) });
      return;
    }
    String str;
    label92:
    int i;
    label102:
    int j;
    label112:
    int i2;
    int k;
    label152:
    int m;
    label171:
    label189:
    label207:
    Object localObject;
    if (paramToServiceMsg.extraData == null)
    {
      str = "";
      if (paramToServiceMsg.extraData != null) {
        break label547;
      }
      if (paramToServiceMsg.extraData != null) {
        break label561;
      }
      i = -1;
      if (paramToServiceMsg.extraData != null) {
        break label576;
      }
      j = -1;
      paramToServiceMsg = new cmd0x9c8.RspBody();
      i2 = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i2 != 0) {
        break label849;
      }
      if (!paramToServiceMsg.uint32_tag_type.has()) {
        break label591;
      }
      k = paramToServiceMsg.uint32_tag_type.get();
      if (!paramToServiceMsg.uint32_next_pos.has()) {
        break label597;
      }
      m = paramToServiceMsg.uint32_next_pos.get();
      if (!paramToServiceMsg.rpt_msg_tag_list.has()) {
        break label603;
      }
      paramFromServiceMsg = paramToServiceMsg.rpt_msg_tag_list.get();
      if (!paramToServiceMsg.rpt_msg_sel_list.has()) {
        break label608;
      }
      paramToServiceMsg = paramToServiceMsg.rpt_msg_sel_list.get();
      localObject = this.app.getEntityManagerFactory(this.app.getAccount()).createEntityManager();
      if ((i != 0) || (!TextUtils.isEmpty(str)) || (paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
        break label613;
      }
    }
    label547:
    label561:
    label576:
    label591:
    label597:
    label603:
    label608:
    label613:
    for (int n = 1;; n = 0)
    {
      if (n != 0)
      {
        paramObject = new StringBuilder();
        paramObject.append("DELETE FROM ");
        paramObject.append(InterestTagInfo.class.getSimpleName());
        paramObject.append(" WHERE ");
        paramObject.append("tagType = ");
        paramObject.append(k);
        paramObject.append(";");
        ((EntityManager)localObject).execSQL(paramObject.toString());
        paramObject = this.app.getApplication().getSharedPreferences("dating_pref" + this.app.getCurrentAccountUin(), 0).edit();
        paramObject.putLong("list_last_update_time_" + k, NetConnInfoCenter.getServerTimeMillis());
        paramObject.putInt("list_fetch_pos_" + k, m);
        paramObject.commit();
      }
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.isEmpty())) {
        break label967;
      }
      paramObject = new ArrayList();
      int i1 = 0;
      while (i1 < paramFromServiceMsg.size())
      {
        InterestTagInfo localInterestTagInfo = InterestTagInfo.convertFrom((appoint_define.InterestItem)paramFromServiceMsg.get(i1));
        if (localInterestTagInfo != null)
        {
          localInterestTagInfo.tagType = k;
          paramObject.add(localInterestTagInfo);
          if (n != 0) {
            ((EntityManager)localObject).persist(localInterestTagInfo);
          }
        }
        i1 += 1;
      }
      str = paramToServiceMsg.extraData.getString("key_word");
      break;
      paramToServiceMsg.extraData.getInt("tag_type");
      break label92;
      i = paramToServiceMsg.extraData.getInt("fetch_start");
      break label102;
      j = paramToServiceMsg.extraData.getInt("person_flag");
      break label112;
      k = -1;
      break label152;
      m = -1;
      break label171;
      paramFromServiceMsg = null;
      break label189;
      paramToServiceMsg = null;
      break label207;
    }
    label967:
    for (paramFromServiceMsg = paramObject;; paramFromServiceMsg = null)
    {
      ((EntityManager)localObject).close();
      localObject = null;
      paramObject = localObject;
      if (paramToServiceMsg != null)
      {
        paramObject = localObject;
        if (!paramToServiceMsg.isEmpty())
        {
          paramObject = new ArrayList();
          n = 0;
          while (n < paramToServiceMsg.size())
          {
            localObject = InterestTagInfo.convertFrom((appoint_define.InterestItem)paramToServiceMsg.get(n));
            if (localObject != null) {
              paramObject.add(localObject);
            }
            n += 1;
          }
        }
      }
      notifyUI(1, true, new Object[] { Integer.valueOf(k), Integer.valueOf(m), paramFromServiceMsg, paramObject, str, Integer.valueOf(i), Integer.valueOf(j), null });
      ajrk.f("Q.nearby_people_card.", "handle_oidb_0x9c8_0", new Object[] { Integer.valueOf(i2), Boolean.valueOf(true), Integer.valueOf(k), Integer.valueOf(m), paramFromServiceMsg, paramObject, str, Integer.valueOf(i), Integer.valueOf(j) });
      return;
      label849:
      if (paramToServiceMsg.str_error.has()) {}
      for (paramToServiceMsg = paramToServiceMsg.str_error.get();; paramToServiceMsg = "")
      {
        notifyUI(1, false, new Object[] { Integer.valueOf(-1), Integer.valueOf(-1), null, null, str, Integer.valueOf(i), Integer.valueOf(j), paramToServiceMsg });
        ajrk.f("Q.nearby_people_card.", "handle_oidb_0x9c8_0", new Object[] { Integer.valueOf(i2), Boolean.valueOf(false), paramToServiceMsg });
        return;
      }
    }
  }
  
  private void kl(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((ajrr.cpV) && (QLog.isColorLevel())) {
      QLog.d("Q.nearby_people_card.", 2, "handleEditProfileCard");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      notifyUI(3, false, null);
      return;
    }
    Object localObject = new cmd0x9c9.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    long l2 = SystemClock.elapsedRealtime();
    long l3 = paramToServiceMsg.extraData.getLong("startSaveTime");
    boolean bool1;
    EntityManager localEntityManager;
    if (paramToServiceMsg.extraData.containsKey("is_head_changed"))
    {
      bool1 = paramToServiceMsg.extraData.getBoolean("is_head_changed");
      if (i != 0) {
        break label1056;
      }
      localEntityManager = this.app.getEntityManagerFactory(this.app.getAccount()).createEntityManager();
      paramFromServiceMsg = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { this.app.getCurrentAccountUin() });
      if (paramFromServiceMsg != null) {
        break label1095;
      }
      paramFromServiceMsg = new NearbyPeopleCard();
      paramFromServiceMsg.uin = this.app.getCurrentAccountUin();
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby_people_card.", 2, "handleEditProfileCard get nearbyCard from db is null.");
      }
    }
    label1026:
    label1056:
    label1095:
    for (;;)
    {
      for (;;)
      {
        if (paramToServiceMsg.extraData.getBoolean("is_lost_god_flag")) {
          paramFromServiceMsg.godFlag = false;
        }
        if (((cmd0x9c9.RspBody)localObject).bytes_rspbody_5ea.has())
        {
          paramObject = ((cmd0x9c9.RspBody)localObject).bytes_rspbody_5ea.get().toByteArray();
          label229:
          paramObject = paramFromServiceMsg.updateEditPicInfos(paramObject, (PicInfo)paramToServiceMsg.extraData.getParcelable("avatar_picinfo"));
          if ((paramObject != null) && (!paramObject.isEmpty())) {
            ajrb.c(this.app.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(1));
          }
          paramObject = paramToServiceMsg.extraData.getByteArray("9c7_body");
          if ((paramObject == null) || (paramObject.length <= 0)) {}
        }
        try
        {
          localObject = new cmd0x9c7.ReqBody();
          ((cmd0x9c7.ReqBody)localObject).mergeFrom(paramObject);
          paramFromServiceMsg.updateInterestTags(paramFromServiceMsg.tagFlag, ((cmd0x9c7.ReqBody)localObject).rpt_msg_tags.get());
          if (paramToServiceMsg.extraData.containsKey("key_xuan_yan")) {
            paramFromServiceMsg.xuanYan = paramToServiceMsg.extraData.getByteArray("key_xuan_yan");
          }
          if (paramToServiceMsg.extraData.containsKey("key_new_nickname")) {
            paramFromServiceMsg.nickname = paramToServiceMsg.extraData.getString("key_new_nickname");
          }
          if (paramToServiceMsg.extraData.containsKey("key_marital_status")) {
            paramFromServiceMsg.maritalStatus = paramToServiceMsg.extraData.getByte("key_marital_status");
          }
          if (paramToServiceMsg.extraData.containsKey("sex"))
          {
            paramFromServiceMsg.gender = paramToServiceMsg.extraData.getByte("sex");
            paramObject = (ajpj)this.app.getManager(106);
            if (paramObject != null) {
              paramObject.Rk(paramFromServiceMsg.gender);
            }
          }
          if (paramToServiceMsg.extraData.containsKey("birthday"))
          {
            paramFromServiceMsg.birthday = paramToServiceMsg.extraData.getInt("birthday");
            paramFromServiceMsg.age = paramToServiceMsg.extraData.getInt("age");
            paramFromServiceMsg.constellation = ((byte)paramToServiceMsg.extraData.getInt("key_constellation"));
            paramObject = (ajpj)this.app.getManager(106);
            if (paramObject != null) {
              paramObject.Rj(paramFromServiceMsg.age);
            }
          }
          if (paramToServiceMsg.extraData.containsKey("profession")) {
            paramFromServiceMsg.job = paramToServiceMsg.extraData.getInt("profession");
          }
          if (paramToServiceMsg.extraData.containsKey("company")) {
            paramFromServiceMsg.company = paramToServiceMsg.extraData.getString("company");
          }
          if (paramToServiceMsg.extraData.containsKey("college")) {
            paramFromServiceMsg.college = paramToServiceMsg.extraData.getString("college");
          }
        }
        catch (Exception paramObject)
        {
          try
          {
            do
            {
              ajrb.c(this.app.getCurrentAccountUin(), "self_school_name", paramFromServiceMsg.college);
              if (paramToServiceMsg.extraData.containsKey("hometown"))
              {
                paramObject = paramToServiceMsg.extraData.getStringArray("hometown");
                paramFromServiceMsg.hometownCountry = paramObject[0];
                paramFromServiceMsg.hometownProvice = paramObject[1];
                paramFromServiceMsg.hometownCity = paramObject[2];
                paramFromServiceMsg.hometownDistrict = paramObject[3];
              }
              if (paramToServiceMsg.extraData.containsKey("key_qzone_switch"))
              {
                if (paramToServiceMsg.extraData.getShort("key_qzone_switch") != 0) {
                  break label1008;
                }
                bool2 = true;
                paramFromServiceMsg.switchQzone = bool2;
              }
              if (paramToServiceMsg.extraData.containsKey("key_hobby_switch"))
              {
                if (paramToServiceMsg.extraData.getShort("key_hobby_switch") != 0) {
                  break label1014;
                }
                bool2 = true;
                paramFromServiceMsg.switchHobby = bool2;
              }
              if (paramToServiceMsg.extraData.containsKey("key_flower_visible_switch"))
              {
                if (paramToServiceMsg.extraData.getShort("key_flower_visible_switch") != 0) {
                  break label1020;
                }
                l1 = 0L;
                paramFromServiceMsg.switchGiftVisible = l1;
              }
              if (paramFromServiceMsg.getStatus() != 1000) {
                break label1026;
              }
              localEntityManager.persistOrReplace(paramFromServiceMsg);
              bool2 = true;
              paramToServiceMsg = paramFromServiceMsg;
              paramFromServiceMsg = "";
              notifyUI(3, bool2, new Object[] { paramToServiceMsg, Boolean.valueOf(bool1), paramFromServiceMsg });
              paramObject = new HashMap();
              paramObject.put("errorCode", String.valueOf(i));
              anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.mApp.getCurrentAccountUin(), "actEditNearbyProfile", bool2, l2 - l3, 0L, paramObject, "");
              ajrk.f("Q.nearby_people_card.", "handle_oidb_0x9c9_0", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool2), paramToServiceMsg, paramFromServiceMsg });
              return;
              bool1 = false;
              break;
              paramObject = null;
              break label229;
              paramObject = paramObject;
            } while ((!ajrr.cpV) || (!QLog.isColorLevel()));
            QLog.d("Q.nearby_people_card.", 2, "rsp_9c7" + paramObject.getMessage());
          }
          catch (Throwable paramObject)
          {
            for (;;)
            {
              paramObject.printStackTrace();
              continue;
              label1008:
              bool2 = false;
              continue;
              label1014:
              bool2 = false;
              continue;
              label1020:
              long l1 = 1L;
              continue;
              if ((paramFromServiceMsg.getStatus() == 1001) || (paramFromServiceMsg.getStatus() == 1002)) {
                localEntityManager.update(paramFromServiceMsg);
              }
            }
          }
        }
      }
      boolean bool2 = false;
      if (((cmd0x9c9.RspBody)localObject).str_errorinfo.has()) {}
      for (paramToServiceMsg = ((cmd0x9c9.RspBody)localObject).str_errorinfo.get();; paramToServiceMsg = "")
      {
        paramObject = null;
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = paramObject;
        break;
      }
    }
  }
  
  private void km(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    acic.e(this, 9, paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void kn(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    int i = -1;
    try
    {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      boolean bool1 = bool2;
      int j;
      if (paramFromServiceMsg != null)
      {
        j = paramFromServiceMsg.uint32_result.get();
        i = j;
        bool1 = bool2;
        if (j == 0)
        {
          bool1 = true;
          i = j;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby", 2, "rspNearbyCharmEvent,result code：" + i + ",isSuccess:" + bool1);
      }
      if (bool1)
      {
        Oidb_0x686.RspBody localRspBody = new Oidb_0x686.RspBody();
        i = paramFromServiceMsg.uint32_service_type.get();
        localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (localRspBody.uint32_config_seq.has())
        {
          j = localRspBody.uint32_config_seq.get();
          ajrb.a(this.mApp.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "toplist_hide_boygod_seq", Integer.valueOf(j));
        }
        if (localRspBody.uint32_config_time.has())
        {
          j = localRspBody.uint32_config_time.get();
          ajrb.a(this.mApp.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "key_last_config_time", Integer.valueOf(j));
        }
        paramFromServiceMsg = null;
        paramObject = null;
        Object localObject3 = null;
        Object localObject4 = null;
        if (localRspBody.msg_rank_config.has()) {
          paramFromServiceMsg = (Oidb_0x686.NearbyRankConfig)localRspBody.msg_rank_config.get();
        }
        if (localRspBody.msg_feed_config.has()) {
          paramObject = (Oidb_0x686.NearbyFeedConfig)localRspBody.msg_feed_config.get();
        }
        Object localObject1;
        Object localObject2;
        if ((i == 2) && (localRspBody.msg_charm_event.has()))
        {
          localObject1 = (Oidb_0x686.CharmEvent)localRspBody.msg_charm_event.get();
          localObject2 = localObject4;
        }
        int k;
        int m;
        int n;
        int i1;
        for (;;)
        {
          this.app.a().a(paramToServiceMsg.getUin(), paramFromServiceMsg, paramObject, (Oidb_0x686.CharmEvent)localObject1, (Oidb_0x686.NearbyCharmNotify)localObject2);
          if ((localObject1 == null) || (((Oidb_0x686.CharmEvent)localObject1).uint32_pop_flag.get() != 1)) {
            break;
          }
          i = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm.get();
          j = ((Oidb_0x686.CharmEvent)localObject1).uint32_old_charm_level.get();
          k = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm.get();
          m = ((Oidb_0x686.CharmEvent)localObject1).uint32_new_charm_level.get();
          n = ((Oidb_0x686.CharmEvent)localObject1).uint32_cur_level_threshold.get();
          i1 = ((Oidb_0x686.CharmEvent)localObject1).uint32_next_level_threshold.get();
          paramFromServiceMsg = ((Oidb_0x686.CharmEvent)localObject1).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          notifyUI(60, true, new Object[] { Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), paramToServiceMsg });
          paramToServiceMsg = "0X80052B1";
          if (k - i < 0) {
            paramToServiceMsg = "0X80052B2";
          }
          this.mApp.reportClickEvent("CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
          return;
          localObject1 = localObject3;
          localObject2 = localObject4;
          if (i == 1)
          {
            localObject1 = localObject3;
            localObject2 = localObject4;
            if (localRspBody.msg_notify_event.has())
            {
              localObject2 = (Oidb_0x686.NearbyCharmNotify)localRspBody.msg_notify_event.get();
              localObject1 = localObject3;
            }
          }
        }
        if ((localObject2 != null) && (((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_pop_flag.get() == 1))
        {
          i = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm.get();
          j = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_charm_level.get();
          k = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm.get();
          m = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_charm_level.get();
          n = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_cur_level_threshold.get();
          i1 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_next_level_threshold.get();
          int i2 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_old_prof_percent.get();
          int i3 = ((Oidb_0x686.NearbyCharmNotify)localObject2).uint32_new_prof_percent.get();
          paramFromServiceMsg = ((Oidb_0x686.NearbyCharmNotify)localObject2).str_tips_content.get();
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null) {
            paramToServiceMsg = "";
          }
          notifyUI(61, true, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), paramToServiceMsg });
          paramToServiceMsg = "0X80052AE";
          if (k - i < 0) {
            paramToServiceMsg = "0X80052AF";
          }
          this.mApp.reportClickEvent("CliOper", "", "", paramToServiceMsg, paramToServiceMsg, 0, 0, "", "", "", "");
          return;
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("NearbyCardHandler", 2, paramToServiceMsg, new Object[0]);
      }
    }
  }
  
  /* Error */
  private void ko(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 1561	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 2038
    //   7: invokevirtual 29	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   10: ifne +4 -> 14
    //   13: return
    //   14: aload_1
    //   15: getfield 1561	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   18: ldc_w 2040
    //   21: invokevirtual 75	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   24: lstore 8
    //   26: invokestatic 1397	android/os/SystemClock:elapsedRealtime	()J
    //   29: lstore 10
    //   31: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +32 -> 66
    //   37: ldc 130
    //   39: iconst_2
    //   40: new 132	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   47: ldc_w 2042
    //   50: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_2
    //   54: invokevirtual 1637	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   57: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: invokestatic 550	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   69: ifeq +308 -> 377
    //   72: invokestatic 329	java/lang/System:currentTimeMillis	()J
    //   75: lstore 6
    //   77: aload_2
    //   78: invokevirtual 1637	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   81: istore 4
    //   83: aload_2
    //   84: invokevirtual 1547	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   87: ifeq +218 -> 305
    //   90: aload_3
    //   91: instanceof 37
    //   94: ifeq +211 -> 305
    //   97: iconst_1
    //   98: istore 13
    //   100: iload 13
    //   102: ifeq +270 -> 372
    //   105: aload_0
    //   106: aload_2
    //   107: invokevirtual 2045	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   110: ldc_w 2047
    //   113: new 647	SummaryCard/RespHead
    //   116: dup
    //   117: invokespecial 2048	SummaryCard/RespHead:<init>	()V
    //   120: invokevirtual 719	ajrs:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   123: checkcast 647	SummaryCard/RespHead
    //   126: astore 14
    //   128: aload 14
    //   130: ifnull +181 -> 311
    //   133: aload 14
    //   135: getfield 2051	SummaryCard/RespHead:iResult	I
    //   138: ifne +173 -> 311
    //   141: iconst_1
    //   142: istore 12
    //   144: aload 14
    //   146: astore_2
    //   147: iload 12
    //   149: istore 13
    //   151: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +49 -> 203
    //   157: new 132	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   164: ldc_w 2053
    //   167: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: astore 15
    //   172: aload 14
    //   174: ifnonnull +143 -> 317
    //   177: ldc_w 2055
    //   180: astore_2
    //   181: ldc 130
    //   183: iconst_2
    //   184: aload 15
    //   186: aload_2
    //   187: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: iload 12
    //   198: istore 13
    //   200: aload 14
    //   202: astore_2
    //   203: aload_0
    //   204: iload 13
    //   206: aload_3
    //   207: aload_1
    //   208: getfield 1561	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   211: aload_2
    //   212: invokespecial 17	ajrs:a	(ZLjava/lang/Object;Landroid/os/Bundle;LSummaryCard/RespHead;)V
    //   215: new 1865	java/util/HashMap
    //   218: dup
    //   219: invokespecial 1866	java/util/HashMap:<init>	()V
    //   222: astore_1
    //   223: aload_1
    //   224: ldc_w 1868
    //   227: iload 4
    //   229: invokestatic 1870	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   232: invokevirtual 1873	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   235: pop
    //   236: invokestatic 1879	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   239: invokestatic 1884	anpc:a	(Landroid/content/Context;)Lanpc;
    //   242: aload_0
    //   243: getfield 1888	ajrs:mApp	Lcom/tencent/common/app/AppInterface;
    //   246: invokevirtual 1891	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   249: ldc_w 2057
    //   252: iload 13
    //   254: lload 10
    //   256: lload 8
    //   258: lsub
    //   259: lconst_0
    //   260: aload_1
    //   261: ldc_w 350
    //   264: invokevirtual 1897	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   267: invokestatic 550	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   270: ifeq -257 -> 13
    //   273: ldc 130
    //   275: iconst_4
    //   276: new 132	java/lang/StringBuilder
    //   279: dup
    //   280: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   283: ldc_w 2059
    //   286: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokestatic 329	java/lang/System:currentTimeMillis	()J
    //   292: lload 6
    //   294: lsub
    //   295: invokevirtual 567	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   298: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: return
    //   305: iconst_0
    //   306: istore 13
    //   308: goto -208 -> 100
    //   311: iconst_0
    //   312: istore 12
    //   314: goto -170 -> 144
    //   317: aload 14
    //   319: getfield 2051	SummaryCard/RespHead:iResult	I
    //   322: istore 5
    //   324: iload 5
    //   326: invokestatic 1421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   329: astore_2
    //   330: goto -149 -> 181
    //   333: astore 14
    //   335: aconst_null
    //   336: astore_2
    //   337: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   340: ifeq +14 -> 354
    //   343: ldc 130
    //   345: iconst_2
    //   346: aload 14
    //   348: invokevirtual 933	java/lang/Exception:toString	()Ljava/lang/String;
    //   351: invokestatic 157	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: iconst_0
    //   355: istore 13
    //   357: goto -154 -> 203
    //   360: astore 15
    //   362: aload 14
    //   364: astore_2
    //   365: aload 15
    //   367: astore 14
    //   369: goto -32 -> 337
    //   372: aconst_null
    //   373: astore_2
    //   374: goto -171 -> 203
    //   377: lconst_0
    //   378: lstore 6
    //   380: goto -303 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	this	ajrs
    //   0	383	1	paramToServiceMsg	ToServiceMsg
    //   0	383	2	paramFromServiceMsg	FromServiceMsg
    //   0	383	3	paramObject	Object
    //   81	147	4	i	int
    //   322	3	5	j	int
    //   75	304	6	l1	long
    //   24	233	8	l2	long
    //   29	226	10	l3	long
    //   142	171	12	bool1	boolean
    //   98	258	13	bool2	boolean
    //   126	192	14	localRespHead	SummaryCard.RespHead
    //   333	30	14	localException1	Exception
    //   367	1	14	localObject	Object
    //   170	15	15	localStringBuilder	StringBuilder
    //   360	6	15	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   105	128	333	java/lang/Exception
    //   133	141	360	java/lang/Exception
    //   151	172	360	java/lang/Exception
    //   181	196	360	java/lang/Exception
    //   317	324	360	java/lang/Exception
  }
  
  private void kp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_auth_video", 2, "CardHandler.handleUpdateNearbyPeopleAuthVideo, isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    Object localObject = null;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      bool1 = bool4;
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg != null)
        {
          bool1 = bool4;
          if (paramToServiceMsg.uint32_result.get() == 0) {
            bool3 = true;
          }
          bool2 = bool3;
          bool1 = bool3;
          if (QLog.isColorLevel())
          {
            bool1 = bool3;
            QLog.d("Q.nearby_people_card.update_auth_video", 2, "CardHandler.handleUpdateNearbyPeopleAuthVideo(), oidbPkg.uint32_result = " + paramToServiceMsg.uint32_result.get());
            bool2 = bool3;
          }
        }
        if (!bool2) {
          break label254;
        }
        bool1 = bool2;
        paramToServiceMsg = ((UpdatePhotoList.RspBody)new UpdatePhotoList.RspBody().mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray())).msg_verify_video_info.get();
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          bool2 = bool1;
          bool1 = bool2;
          paramToServiceMsg = localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.nearby_people_card.update_auth_video", 2, paramFromServiceMsg.toString());
            bool1 = bool2;
            paramToServiceMsg = localObject;
            continue;
            paramToServiceMsg = null;
          }
        }
      }
      bool1 = bool2;
    }
    for (;;)
    {
      notifyUI(47, bool1, paramToServiceMsg);
      return;
      label254:
      bool1 = false;
      paramToServiceMsg = localObject;
    }
  }
  
  private void kq(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    bool2 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.delete_auth_video", 2, "CardHandler.handleDeleteNearbyPeopleAuthVideo, isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    bool1 = bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      bool1 = bool2;
      if (paramObject != null)
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool4;
      }
    }
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg != null)
      {
        bool1 = bool5;
        bool2 = bool4;
        if (paramToServiceMsg.uint32_result.get() == 0) {
          bool1 = true;
        }
        bool3 = bool1;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          QLog.d("Q.nearby_people_card.delete_auth_video", 2, "CardHandler.handleUpdateNearbyPeopleAuthVideo(), oidbPkg.uint32_result = " + paramToServiceMsg.uint32_result.get());
          bool3 = bool1;
        }
      }
      bool1 = bool3;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.delete_auth_video", 2, paramToServiceMsg.toString());
          bool1 = bool2;
        }
      }
    }
    notifyUI(49, bool1, null);
  }
  
  private void kr(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.handleUpdateNearbyPeoplePhotoList(), isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      bool2 = bool4;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg != null)
        {
          bool2 = bool4;
          if (paramToServiceMsg.uint32_result.get() == 0) {
            bool1 = true;
          }
          bool3 = bool1;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            bool2 = bool1;
            QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.handleUpdateNearbyPeoplePhotoList(), oidbPkg.uint32_result = " + paramToServiceMsg.uint32_result.get());
            bool3 = bool1;
          }
        }
        bool1 = bool3;
        if (bool3) {}
        bool1 = bool3;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        try
        {
          ajpj.dv(this.app);
          bool1 = bool3;
          notifyUI(46, bool1, null);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          break label194;
        }
        paramToServiceMsg = paramToServiceMsg;
        bool3 = bool2;
      }
      label194:
      if (QLog.isColorLevel())
      {
        QLog.d("Q.nearby_people_card.update_photo_list", 2, paramToServiceMsg.toString());
        bool1 = bool3;
        continue;
        bool1 = false;
      }
    }
  }
  
  private void ks(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool2 = false;
    boolean bool4 = false;
    boolean bool6 = false;
    boolean bool5 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "CardHandler.handleImportQzonePhotoes(), FromServiceMsg isSuccess: " + paramFromServiceMsg.isSuccess());
    }
    Object localObject = null;
    paramToServiceMsg = null;
    localToServiceMsg = paramToServiceMsg;
    bool1 = bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      localToServiceMsg = paramToServiceMsg;
      bool1 = bool2;
      if (paramObject != null)
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg = localObject;
        bool2 = bool4;
      }
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      bool3 = bool6;
      if (paramFromServiceMsg == null) {
        break label409;
      }
      paramToServiceMsg = localObject;
      bool2 = bool4;
      bool3 = bool6;
      if (!paramFromServiceMsg.uint32_result.has()) {
        break label409;
      }
      bool1 = bool5;
      paramToServiceMsg = localObject;
      bool2 = bool4;
      if (paramFromServiceMsg.uint32_result.get() == 0) {
        bool1 = true;
      }
      paramToServiceMsg = localObject;
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = localObject;
        bool2 = bool1;
        QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "oidbPkg.uint32_result = " + paramFromServiceMsg.uint32_result.get());
      }
      bool3 = bool1;
      if (!bool1) {
        break label409;
      }
      paramToServiceMsg = localObject;
      bool2 = bool1;
      paramObject = (UpdatePhotoList.RspBody)new UpdatePhotoList.RspBody().mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramToServiceMsg = localObject;
      bool2 = bool1;
      paramFromServiceMsg = new Object[5];
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[0] = paramObject.rpt_msg_headinfo.get();
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[1] = Integer.valueOf(paramObject.uint32_import_state.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[2] = Integer.valueOf(paramObject.uint32_import_count.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[3] = Integer.valueOf(paramObject.uint32_import_rest_count.get());
      paramToServiceMsg = paramFromServiceMsg;
      bool2 = bool1;
      paramFromServiceMsg[4] = Integer.valueOf(paramObject.uint32_rest_count_in_qzone.get());
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        boolean bool3;
        localToServiceMsg = paramToServiceMsg;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.nearby_people_card.import_qzone_photo", 2, paramFromServiceMsg.toString());
          localToServiceMsg = paramToServiceMsg;
          bool1 = bool2;
          continue;
          paramToServiceMsg = null;
          bool1 = bool3;
        }
      }
    }
    localToServiceMsg = paramToServiceMsg;
    notifyUI(48, bool1, localToServiceMsg);
  }
  
  /* Error */
  private void kt(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 9
    //   9: iconst_0
    //   10: istore 4
    //   12: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +33 -> 48
    //   18: ldc_w 2119
    //   21: iconst_2
    //   22: new 132	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 2121
    //   32: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_2
    //   36: invokevirtual 1547	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   39: invokevirtual 1142	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 1076	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aconst_null
    //   49: astore 10
    //   51: aconst_null
    //   52: astore 11
    //   54: aload 11
    //   56: astore_1
    //   57: iload 8
    //   59: istore 7
    //   61: aload_2
    //   62: invokevirtual 1547	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   65: ifeq +392 -> 457
    //   68: aload 11
    //   70: astore_1
    //   71: iload 8
    //   73: istore 7
    //   75: aload_3
    //   76: ifnull +381 -> 457
    //   79: new 1572	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   82: dup
    //   83: invokespecial 1638	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   86: astore_1
    //   87: aload_1
    //   88: aload_3
    //   89: checkcast 733	[B
    //   92: checkcast 733	[B
    //   95: invokevirtual 1639	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 1572	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +422 -> 525
    //   106: aload_1
    //   107: getfield 1640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 1641	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   113: ifeq +412 -> 525
    //   116: aload_1
    //   117: getfield 1640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   120: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   123: istore 5
    //   125: iload 5
    //   127: ifne +406 -> 533
    //   130: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +36 -> 169
    //   136: ldc_w 2119
    //   139: iconst_2
    //   140: new 132	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 2123
    //   150: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_1
    //   154: getfield 1640	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 1076	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: iload 6
    //   171: ifeq +349 -> 520
    //   174: new 2068	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   177: dup
    //   178: invokespecial 2069	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:<init>	()V
    //   181: aload_1
    //   182: getfield 1575	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   185: invokevirtual 866	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   188: invokevirtual 1579	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   191: invokevirtual 2070	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   194: checkcast 2068	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody
    //   197: astore_2
    //   198: iconst_5
    //   199: anewarray 1414	java/lang/Object
    //   202: astore_1
    //   203: aload_1
    //   204: iconst_0
    //   205: aload_2
    //   206: getfield 2104	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:rpt_msg_headinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   209: invokevirtual 996	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   212: aastore
    //   213: aload_1
    //   214: iconst_1
    //   215: aload_2
    //   216: getfield 2107	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_state	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   219: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   222: invokestatic 1421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: aload_1
    //   227: iconst_2
    //   228: aload_2
    //   229: getfield 2110	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   232: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   235: invokestatic 1421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: aastore
    //   239: aload_1
    //   240: iconst_3
    //   241: aload_2
    //   242: getfield 2113	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_import_rest_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   245: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   248: invokestatic 1421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: aastore
    //   252: aload_1
    //   253: iconst_4
    //   254: aload_2
    //   255: getfield 2116	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$RspBody:uint32_rest_count_in_qzone	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   258: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   261: invokestatic 1421	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: aastore
    //   265: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +185 -> 453
    //   271: new 132	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   278: astore_2
    //   279: aload_2
    //   280: ldc_w 2125
    //   283: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload_1
    //   288: iconst_0
    //   289: aaload
    //   290: ifnull +102 -> 392
    //   293: aload_1
    //   294: iconst_0
    //   295: aaload
    //   296: checkcast 459	java/util/List
    //   299: astore_3
    //   300: iload 4
    //   302: aload_3
    //   303: invokeinterface 463 1 0
    //   308: if_icmpge +84 -> 392
    //   311: aload_3
    //   312: iload 4
    //   314: invokeinterface 466 2 0
    //   319: checkcast 2076	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo
    //   322: astore 10
    //   324: aload_2
    //   325: ldc_w 2127
    //   328: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload 10
    //   333: getfield 2130	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_headid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   336: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   339: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: ldc_w 2132
    //   345: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 10
    //   350: getfield 2135	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:str_headurl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   353: invokevirtual 772	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   356: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc_w 2137
    //   362: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 10
    //   367: getfield 2140	tencent/im/oidb/cmd0x5ea/UpdatePhotoList$HeadInfo:uint32_is_curhead	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   370: invokevirtual 787	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   373: invokevirtual 145	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc_w 2142
    //   379: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: iload 4
    //   385: iconst_1
    //   386: iadd
    //   387: istore 4
    //   389: goto -89 -> 300
    //   392: aload_2
    //   393: ldc_w 2144
    //   396: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_1
    //   400: iconst_1
    //   401: aaload
    //   402: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   405: ldc_w 2146
    //   408: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload_1
    //   412: iconst_2
    //   413: aaload
    //   414: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   417: ldc_w 2148
    //   420: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: aload_1
    //   424: iconst_3
    //   425: aaload
    //   426: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   429: ldc_w 2150
    //   432: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_1
    //   436: iconst_4
    //   437: aaload
    //   438: invokevirtual 555	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: ldc_w 2119
    //   445: iconst_2
    //   446: aload_2
    //   447: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 1076	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: iload 6
    //   455: istore 7
    //   457: aload_0
    //   458: bipush 50
    //   460: iload 7
    //   462: aload_1
    //   463: invokevirtual 1552	ajrs:notifyUI	(IZLjava/lang/Object;)V
    //   466: return
    //   467: astore_2
    //   468: iload 9
    //   470: istore 6
    //   472: aload 10
    //   474: astore_3
    //   475: aload_3
    //   476: astore_1
    //   477: iload 6
    //   479: istore 7
    //   481: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq -27 -> 457
    //   487: ldc_w 2119
    //   490: iconst_2
    //   491: aload_2
    //   492: invokevirtual 2078	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   495: invokestatic 1076	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: aload_3
    //   499: astore_1
    //   500: iload 6
    //   502: istore 7
    //   504: goto -47 -> 457
    //   507: astore_2
    //   508: aload 10
    //   510: astore_3
    //   511: goto -36 -> 475
    //   514: astore_2
    //   515: aload_1
    //   516: astore_3
    //   517: goto -42 -> 475
    //   520: aconst_null
    //   521: astore_1
    //   522: goto -69 -> 453
    //   525: aconst_null
    //   526: astore_1
    //   527: iconst_0
    //   528: istore 6
    //   530: goto -77 -> 453
    //   533: iconst_0
    //   534: istore 6
    //   536: goto -406 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	this	ajrs
    //   0	539	1	paramToServiceMsg	ToServiceMsg
    //   0	539	2	paramFromServiceMsg	FromServiceMsg
    //   0	539	3	paramObject	Object
    //   10	378	4	i	int
    //   123	3	5	j	int
    //   1	534	6	bool1	boolean
    //   59	444	7	bool2	boolean
    //   4	68	8	bool3	boolean
    //   7	462	9	bool4	boolean
    //   49	460	10	localHeadInfo	UpdatePhotoList.HeadInfo
    //   52	17	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   87	102	467	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   106	125	467	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   130	169	507	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   174	203	507	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   203	287	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   293	300	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   300	383	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   392	453	514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void ku(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!paramToServiceMsg.extraData.getBoolean("nearby_people")) {
      return;
    }
    Object localObject = paramFromServiceMsg.getAttribute("result");
    paramObject = new HashMap();
    boolean bool2 = false;
    boolean bool1 = false;
    paramFromServiceMsg = new Bundle();
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("selfUin");
    int i = paramToServiceMsg.extraData.getInt("favoriteSource");
    int j = paramToServiceMsg.extraData.getInt("iCount");
    int k = paramToServiceMsg.extraData.getInt("from");
    paramFromServiceMsg.putString("targetUin", Long.toString(l1));
    paramFromServiceMsg.putString("selfUin", Long.toString(l2));
    paramFromServiceMsg.putInt("favoriteSource", i);
    paramFromServiceMsg.putInt("iCount", j);
    paramFromServiceMsg.putInt("from", k);
    if ((localObject != null) && ((localObject instanceof RespFavorite)))
    {
      paramToServiceMsg = (RespFavorite)localObject;
      if (paramToServiceMsg.stHeader.iReplyCode == 0)
      {
        bool1 = true;
        paramObject.put("param_FailCode", "0");
      }
      for (;;)
      {
        anpc.a(this.mApp.getApp()).collectPerformance(String.valueOf(l2), "profileCardSendFavorite", bool1, 0L, 0L, paramObject, "", false);
        if ((bool1) && (l1 > 0L))
        {
          paramToServiceMsg = this.app.a().createEntityManager();
          paramObject = (NearbyPeopleCard)paramToServiceMsg.find(NearbyPeopleCard.class, "uin=?", new String[] { String.valueOf(l1) });
          if (paramObject != null)
          {
            paramObject.likeCount += j;
            paramObject.bVoted = 1;
            paramObject.bAvailVoteCnt = ((short)(paramObject.bAvailVoteCnt - j));
            if (paramObject.bAvailVoteCnt < 0) {
              paramObject.bAvailVoteCnt = 0;
            }
            paramToServiceMsg.update(paramObject);
          }
          aqfu.f(this.app, l1, j);
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + bool1 + "," + l1 + "," + j);
        }
        notifyUI(32, bool1, paramFromServiceMsg);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + false + "," + l1 + ",replyCode=" + paramToServiceMsg.stHeader.iReplyCode);
        }
        paramObject.put("param_FailCode", String.valueOf(paramToServiceMsg.stHeader.iReplyCode));
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("back reqFavorite| result = ").append(false).append(",").append(l1).append(",obj is");
      if (localObject != null)
      {
        paramToServiceMsg = "not RespFavorite";
        label535:
        QLog.i("Q.profilecard.", 2, paramToServiceMsg);
      }
    }
    else
    {
      if (localObject == null) {
        break label612;
      }
    }
    label612:
    for (paramToServiceMsg = "-201";; paramToServiceMsg = "-202")
    {
      paramObject.put("param_FailCode", paramToServiceMsg);
      anpc.a(this.mApp.getApp()).collectPerformance(String.valueOf(l2), "profileCardSendFavorite", false, 0L, 0L, paramObject, "", false);
      bool1 = bool2;
      break;
      paramToServiceMsg = "null";
      break label535;
    }
  }
  
  public void D(ArrayList<ajqh.a> paramArrayList, int paramInt)
  {
    int j = 0;
    Object localObject1;
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("nearbyPeopleLikeNew, reqList.size=");
      if (paramArrayList == null)
      {
        i = 0;
        QLog.d("NearbyLikeLimitManager", 2, i + ", from=" + paramInt);
      }
    }
    else
    {
      if ((paramArrayList != null) && (paramArrayList.size() != 0)) {
        break label92;
      }
      if (QLog.isColorLevel()) {
        QLog.w("NearbyLikeLimitManager", 2, "nearbyPeopleLikeNew, reqList is empty, return");
      }
    }
    label92:
    Object localObject2;
    label142:
    do
    {
      do
      {
        return;
        i = paramArrayList.size();
        break;
        localObject2 = ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin());
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label142;
        }
      } while (!QLog.isColorLevel());
      QLog.w("NearbyLikeLimitManager", 2, "nearbyPeopleLikeNew, skey is empty, return");
      return;
      localObject1 = new oidb_0x8e6.ReqBody();
      ((oidb_0x8e6.ReqBody)localObject1).uint32_portal.set(paramInt);
      ((oidb_0x8e6.ReqBody)localObject1).uint32_client.set(1);
      ((oidb_0x8e6.ReqBody)localObject1).bytes_version.set(ByteStringMicro.copyFrom(AppSetting.getVersion().getBytes()));
      Object localObject3 = new oidb_0x8e6.LoginSig();
      ((oidb_0x8e6.LoginSig)localObject3).uint32_type.set(1);
      ((oidb_0x8e6.LoginSig)localObject3).bytes_sig.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
      ((oidb_0x8e6.ReqBody)localObject1).msg_login_sig.set((MessageMicro)localObject3);
      localObject3 = new ArrayList();
      int k = paramArrayList.size();
      localObject2 = new StringBuilder();
      i = j;
      while (i < k)
      {
        ajqh.a locala = (ajqh.a)paramArrayList.get(i);
        if (QLog.isColorLevel()) {
          ((StringBuilder)localObject2).append(locala).append(" | ");
        }
        oidb_0x8e6.VoteInfo localVoteInfo = new oidb_0x8e6.VoteInfo();
        localVoteInfo.uint64_uin.set(locala.uin);
        localVoteInfo.uint32_free_vote_count.set(locala.dkt);
        localVoteInfo.uint32_pay_vote_count.set(locala.dku);
        localVoteInfo.uint32_source.set(locala.source);
        ((ArrayList)localObject3).add(localVoteInfo);
        i += 1;
      }
      ((oidb_0x8e6.ReqBody)localObject1).rpt_vote_info.set((List)localObject3);
      paramArrayList = makeOIDBPkg("OidbSvc.0x8e6_1", 2278, 1, ((oidb_0x8e6.ReqBody)localObject1).toByteArray());
      paramArrayList.extraData.putInt("from", paramInt);
      sendPbReq(paramArrayList);
    } while (!QLog.isColorLevel());
    QLog.d("NearbyLikeLimitManager", 2, "nearbyPeopleLikeNew, reqList=[" + ((StringBuilder)localObject2).toString() + "]");
  }
  
  public void MW(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewNearbyMyTab", 2, "getRandomUserInfo| uin = " + paramString);
    }
    Oidb_0x66b.ReqBody localReqBody = new Oidb_0x66b.ReqBody();
    oidb_0x5eb.ReqBody localReqBody1 = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(paramString)));
    localReqBody1.rpt_uint64_uins.set(localArrayList);
    localReqBody1.uint32_req_nick.set(1);
    localReqBody1.uint32_req_stranger_nick.set(1);
    localReqBody1.uint32_req_gender.set(1);
    localReqBody1.uint32_req_god_flag.set(1);
    localReqBody1.uint32_req_age.set(1);
    localReqBody.bytes_reqbody_5eb.set(ByteStringMicro.copyFrom(localReqBody1.toByteArray()));
    paramString = makeOIDBPkg("OidbSvc.0x66b", 1643, 0, localReqBody.toByteArray());
    paramString.extraData.putBoolean("req_pb_protocol_flag", true);
    send(paramString);
  }
  
  public void Mm(boolean paramBoolean)
  {
    cmd0xb5b.ReqBody localReqBody = new cmd0xb5b.ReqBody();
    PBUInt32Field localPBUInt32Field = localReqBody.is_review;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      sendPbReq(makeOIDBPkg("OidbSvc.0xb5b", 2907, 1, localReqBody.toByteArray()));
      return;
    }
  }
  
  public void Rr(int paramInt)
  {
    Object localObject1 = new Oidb_0x686.ReqBody();
    Object localObject2 = ajpf.a(getClass().getSimpleName());
    if (localObject2 != null) {
      ((Oidb_0x686.ReqBody)localObject1).msg_lbs_info.set((MessageMicro)localObject2);
    }
    int i = ((Integer)ajrb.a(this.mApp.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "toplist_hide_boygod_seq", Integer.valueOf(0))).intValue();
    ((Oidb_0x686.ReqBody)localObject1).uint32_last_config_seq.set(i);
    i = ((Integer)ajrb.a(this.mApp.getCurrentAccountUin(), "NEW_FRESH_SP", 0, "key_last_config_time", Integer.valueOf(0))).intValue();
    ((Oidb_0x686.ReqBody)localObject1).uint32_last_config_time.set(i);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1670);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(paramInt);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x686.ReqBody)localObject1).toByteArray()));
    ((oidb_sso.OIDBSSOPkg)localObject2).str_client_version.set(AppSetting.getVersion());
    localObject1 = createToServiceMsg("OidbSvc.0x686");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Charm", 2, "reqCharmEvent() uin=" + ((ToServiceMsg)localObject1).getUin() + ", type=" + paramInt + ", seqNum=" + i);
    }
  }
  
  public void a(Bundle paramBundle, ArrayList<PicInfo> paramArrayList, ajuu[] paramArrayOfajuu, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((ajrr.cpV) && (QLog.isColorLevel())) {
      QLog.d("Q.nearby_people_card.", 2, "editProfileCard");
    }
    cmd0x9c9.ReqBody localReqBody = new cmd0x9c9.ReqBody();
    Object localObject2;
    Object localObject1;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localObject2 = new UpdatePhotoList.ReqBody();
      Iterator localIterator = paramArrayList.iterator();
      for (paramBoolean3 = false; localIterator.hasNext(); paramBoolean3 = true)
      {
        PicInfo localPicInfo = (PicInfo)localIterator.next();
        if (localPicInfo.photoId < 0) {
          break label2404;
        }
        localObject1 = new UpdatePhotoList.RichHead();
        ((UpdatePhotoList.RichHead)localObject1).uint32_headid.set(localPicInfo.photoId);
        if (!TextUtils.isEmpty(localPicInfo.videoId)) {
          ((UpdatePhotoList.RichHead)localObject1).str_video_id.set(localPicInfo.videoId);
        }
        if (localObject1 == null) {
          break label2401;
        }
        ((UpdatePhotoList.ReqBody)localObject2).rpt_msg_rich_headids.add((MessageMicro)localObject1);
      }
      label154:
      if (paramBoolean3)
      {
        localObject1 = ajpf.a(getClass().getSimpleName());
        if (localObject1 != null) {
          ((UpdatePhotoList.ReqBody)localObject2).msg_lbs_info.set((MessageMicro)localObject1);
        }
        localReqBody.bytes_reqbody_5ea.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject2).toByteArray()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_people_card.", 2, "editProfileCard, photoList = " + paramArrayList + ", isHasNearbyAvatar = " + paramBoolean3);
      }
    }
    for (;;)
    {
      int j;
      int i;
      if ((paramArrayOfajuu != null) && (paramArrayOfajuu.length > 0))
      {
        localObject1 = new cmd0x9c7.ReqBody();
        ((cmd0x9c7.ReqBody)localObject1).uint32_set_mode.set(0);
        j = paramArrayOfajuu.length;
        i = 0;
        if (i < j)
        {
          localObject2 = paramArrayOfajuu[i];
          if (localObject2 == null) {}
          for (;;)
          {
            i += 1;
            break;
            ((cmd0x9c7.ReqBody)localObject1).rpt_msg_tags.add(((ajuu)localObject2).a());
          }
        }
        localReqBody.bytes_reqbody_9c7.set(ByteStringMicro.copyFrom(((cmd0x9c7.ReqBody)localObject1).toByteArray()));
        if ((ajrr.cpV) && (QLog.isColorLevel()))
        {
          localObject2 = new StringBuilder();
          i = 0;
          while (i < paramArrayOfajuu.length)
          {
            ((StringBuilder)localObject2).append(paramArrayOfajuu[i].toString()).append(",");
            i += 1;
          }
          QLog.d("Q.nearby_people_card.", 2, "editProfileCard, tags = " + ((StringBuilder)localObject2).toString());
        }
      }
      for (paramArrayOfajuu = (ajuu[])localObject1;; paramArrayOfajuu = null)
      {
        i = 0;
        j = 0;
        if (paramBundle != null)
        {
          if (paramBundle.containsKey("nick"))
          {
            i = 1;
            localObject1 = paramBundle.getString("nick");
            localReqBody.str_nick.set((String)localObject1);
            j = i;
            if (ajrr.cpV)
            {
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_nick|" + (String)localObject1);
                j = i;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("sex"))
          {
            j += 1;
            k = paramBundle.getByte("sex") + 1;
            localReqBody.uint32_gender.set(k);
            i = j;
            if (ajrr.cpV)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_gender|" + k);
                i = j;
              }
            }
          }
          int k = i;
          if (paramBundle.containsKey("college"))
          {
            i += 1;
            localObject1 = paramBundle.getString("college");
            localReqBody.str_college.set((String)localObject1);
            k = i;
            if (ajrr.cpV)
            {
              k = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_college|" + (String)localObject1);
                k = i;
              }
            }
          }
          j = k;
          if (paramBundle.containsKey("key_constellation"))
          {
            i = k + 1;
            k = paramBundle.getInt("key_constellation");
            localReqBody.uint32_constellation.set(k);
            j = i;
            if (ajrr.cpV)
            {
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_constellation|" + k);
                j = i;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("birthday"))
          {
            j += 1;
            k = paramBundle.getInt("birthday");
            localReqBody.bytes_birthday.set(ByteStringMicro.copyFrom(aqoj.k(k)));
            i = j;
            if (ajrr.cpV)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "bytes_birthday|" + k);
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("hometown"))
          {
            localObject2 = new byte[12];
            localObject1 = paramBundle.getStringArray("hometown");
            j = 0;
            while (j < 3)
            {
              aqoj.b((byte[])localObject2, j * 4, aqoj.k(accv.cm(localObject1[j])), 4);
              j += 1;
            }
            localReqBody.bytes_hometown.set(ByteStringMicro.copyFrom((byte[])localObject2));
            j = accv.cm(localObject1[3]);
            localReqBody.bytes_hometown_district.set(ByteStringMicro.copyFrom(aqoj.k(j)));
            if ((ajrr.cpV) && (QLog.isColorLevel()))
            {
              localObject2 = new StringBuilder();
              j = 0;
              while (j < localObject1.length)
              {
                ((StringBuilder)localObject2).append(localObject1[j]).append(", ");
                j += 1;
              }
              QLog.d("Q.nearby_people_card.", 2, "bytes_city_id|" + ((StringBuilder)localObject2).toString());
            }
            j = i + 2;
          }
          k = j;
          if (paramBundle.containsKey("location"))
          {
            localObject2 = new byte[12];
            localObject1 = paramBundle.getStringArray("location");
            i = 0;
            while (i < 3)
            {
              aqoj.b((byte[])localObject2, i * 4, aqoj.k(accv.cm(localObject1[i])), 4);
              i += 1;
            }
            localReqBody.bytes_location.set(ByteStringMicro.copyFrom((byte[])localObject2));
            i = accv.cm(localObject1[3]);
            localReqBody.bytes_location_district.set(ByteStringMicro.copyFrom(aqoj.k(i)));
            if ((ajrr.cpV) && (QLog.isColorLevel()))
            {
              localObject2 = new StringBuilder();
              i = 0;
              while (i < localObject1.length)
              {
                ((StringBuilder)localObject2).append(localObject1[i]).append(", ");
                i += 1;
              }
              QLog.d("Q.nearby_people_card.", 2, "bytes_location|" + ((StringBuilder)localObject2).toString());
            }
            k = j + 2;
          }
          i = k;
          if (paramBundle.containsKey("age"))
          {
            j = k + 1;
            i = paramBundle.getInt("age");
            localReqBody.uint32_age.set(i);
            i = j;
            if (ajrr.cpV)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "set birthday|age = " + paramBundle.getInt("age"));
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("company"))
          {
            i += 1;
            localObject1 = paramBundle.getString("company");
            localReqBody.str_company.set((String)localObject1);
            j = i;
            if (ajrr.cpV)
            {
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_company|" + (String)localObject1);
                j = i;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("key_new_nickname"))
          {
            j += 1;
            localObject1 = paramBundle.getString("key_new_nickname");
            localReqBody.str_stranger_nick.set((String)localObject1);
            i = j;
            if (ajrr.cpV)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "str_stranger_nick|" + (String)localObject1);
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("key_xuan_yan"))
          {
            localObject1 = paramBundle.getByteArray("key_xuan_yan");
            if (localObject1 != null) {
              localReqBody.bytes_stranger_declare.set(ByteStringMicro.copyFrom((byte[])localObject1));
            }
            if ((ajrr.cpV) && (QLog.isColorLevel()))
            {
              localObject2 = new StringBuilder().append("str_stranger_declare|");
              if (localObject1 != null) {
                break label2356;
              }
              localObject1 = "null";
              QLog.d("Q.nearby_people_card.", 2, localObject1);
            }
            j = i + 1;
          }
          i = j;
          if (paramBundle.containsKey("key_marital_status"))
          {
            j += 1;
            k = paramBundle.getByte("key_marital_status");
            localReqBody.uint32_love_status.set(k);
            i = j;
            if (ajrr.cpV)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_love_status|" + k);
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("profession"))
          {
            int m = paramBundle.getInt("profession");
            k = i;
            if (aqek.ay(m))
            {
              k = i + 1;
              localReqBody.uint32_profession.set(m);
            }
            j = k;
            if (ajrr.cpV)
            {
              j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_profession|" + m);
                j = k;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("key_qzone_switch"))
          {
            j += 1;
            k = paramBundle.getShort("key_qzone_switch");
            localReqBody.uint32_qzone_visible.set(k);
            i = j;
            if (ajrr.cpV)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_qzone_visible|" + k);
                i = j;
              }
            }
          }
          j = i;
          if (paramBundle.containsKey("key_hobby_switch"))
          {
            i += 1;
            k = paramBundle.getShort("key_hobby_switch");
            localReqBody.uint32_interest_visible.set(k);
            j = i;
            if (ajrr.cpV)
            {
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_interest_visible|" + k);
                j = i;
              }
            }
          }
          i = j;
          if (paramBundle.containsKey("key_flower_visible_switch"))
          {
            j += 1;
            k = paramBundle.getShort("key_flower_visible_switch");
            localReqBody.uint32_gift_visible.set(k);
            i = j;
            if (ajrr.cpV)
            {
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.nearby_people_card.", 2, "uint32_gift_visible|" + k);
                i = j;
              }
            }
          }
        }
        localReqBody.uint32_stranger_profile_flag.set(1);
        if (paramBoolean3) {
          localReqBody.uint32_face_flag.set(1);
        }
        localReqBody.uint32_guide_flag.set(0);
        if ((ajrr.cpV) && (QLog.isColorLevel())) {
          QLog.d("Q.nearby_people_card.", 2, "fieldCount|" + (i + 1));
        }
        if (paramBoolean4)
        {
          localObject1 = makeOIDBPkg("OidbSvc.0x9c9_1", 2505, 1, localReqBody.toByteArray());
          label2246:
          if (paramBundle != null) {
            ((ToServiceMsg)localObject1).extraData.putAll(paramBundle);
          }
          if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
            ((ToServiceMsg)localObject1).extraData.putParcelable("avatar_picinfo", (Parcelable)paramArrayList.get(0));
          }
          paramArrayList = ((ToServiceMsg)localObject1).extraData;
          if (paramArrayOfajuu != null) {
            break label2388;
          }
        }
        label2356:
        label2388:
        for (paramBundle = null;; paramBundle = paramArrayOfajuu.toByteArray())
        {
          paramArrayList.putByteArray("9c7_body", paramBundle);
          ((ToServiceMsg)localObject1).extraData.putBoolean("is_lost_god_flag", paramBoolean1);
          ((ToServiceMsg)localObject1).extraData.putBoolean("is_head_changed", paramBoolean2);
          ((ToServiceMsg)localObject1).extraData.putLong("startSaveTime", SystemClock.elapsedRealtime());
          sendPbReq((ToServiceMsg)localObject1);
          return;
          localObject1 = Integer.valueOf(localObject1.length);
          break;
          localObject1 = makeOIDBPkg("OidbSvc.0x9c9_0", 2505, 0, localReqBody.toByteArray());
          break label2246;
        }
      }
      label2401:
      break label154;
      label2404:
      localObject1 = null;
      break;
      paramBoolean3 = false;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, long paramLong5, boolean paramBoolean1, boolean paramBoolean2, long paramLong6, boolean paramBoolean3, long paramLong7, int paramInt3)
  {
    try
    {
      l1 = Long.parseLong(paramString1);
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        for (;;)
        {
          l2 = Long.parseLong(paramString2);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getSummaryCard()").append(",selfUin = ").append(paramString1).append(",destUin = ").append(paramString2).append(",comeFromType = ").append(paramInt1).append(",qzoneFeedTimeStamp = ").append(paramLong1).append(",isFriend = ").append(paramByte).append(",troopCode = ").append(paramLong2).append(",troopUin = ").append(paramLong3).append(",vseed = ").append(paramArrayOfByte1).append(",strSearchName = ").append(paramString3).append(",lGetControl = ").append(paramLong4).append(",nAddFriendSource = ").append(paramInt2).append(", vSecureSig = ").append(paramArrayOfByte2).append(", tinyId = ").append(paramLong5).append(", isNearbyPeopleCard = ").append(paramBoolean1).append(",uLikeSource = ").append(paramLong6);
            QLog.i("Q.profilecard.SummaryCard", 2, localStringBuilder.toString());
          }
          paramString1 = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "SummaryCard.ReqSummaryCard");
          paramString1.extraData.putLong("selfUin", l1);
          paramString1.extraData.putLong("targetUin", l2);
          paramString1.extraData.putInt("comeFromType", paramInt1);
          paramString1.extraData.putLong("qzoneFeedTimeStamp", paramLong1);
          paramString1.extraData.putByte("isFriend", paramByte);
          paramString1.extraData.putLong("troopCode", paramLong2);
          paramString1.extraData.putLong("troopUin", paramLong3);
          paramString1.extraData.putByteArray("vSeed", paramArrayOfByte1);
          paramString1.extraData.putString("strSearchName", paramString3);
          paramString1.extraData.putLong("lGetControl", paramLong4);
          paramString1.extraData.putInt("bReqCommLabel", 1);
          paramString1.extraData.putInt("EAddFriendSource", paramInt2);
          paramString1.extraData.putByteArray("vSecureSig", paramArrayOfByte2);
          paramString1.extraData.putLong("tinyId", paramLong5);
          paramString1.extraData.putBoolean("isNearbyPeopleCard", paramBoolean1);
          paramString1.extraData.putBoolean("partlyRefresh", paramBoolean2);
          paramString1.extraData.putLong("startFetchTime", SystemClock.elapsedRealtime());
          paramString1.extraData.putLong("likeSource", paramLong6);
          paramString1.extraData.putLong("nowId", paramLong7);
          paramString1.extraData.putInt("nowUserType", paramInt3);
          if (!paramBoolean3) {
            break;
          }
          send(paramString1);
          return;
          localNumberFormatException1 = localNumberFormatException1;
          long l1 = 0L;
        }
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;)
        {
          long l2 = 0L;
        }
        paramString2 = new NowSummaryCard.NowSummaryCardReq();
        paramString2.id.set(paramLong7);
        paramString2.id_type.set(paramInt3);
        paramArrayOfByte1 = new UniPacket(true);
        paramArrayOfByte1.setEncodeName("utf-8");
        anau.Y(paramString1, paramArrayOfByte1);
        paramArrayOfByte1 = paramArrayOfByte1.encode();
        paramInt1 = paramArrayOfByte1.length - 4;
        paramString3 = new byte[paramInt1];
        aqoj.copyData(paramString3, 0, paramArrayOfByte1, 4, paramInt1);
        paramString2.jce_data.set(ByteStringMicro.copyFrom(paramString3));
        jnm.a(this.app, new ajrt(this, false, paramString1), paramString2.toByteArray(), "NowSummaryCard.NowSummaryCardReq");
      }
    }
  }
  
  public void ad(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyCardHandler", 2, "getShowExternalTroopList destUin is null");
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString = paramString.trim();
          long l = Long.parseLong(paramString);
          if (l != 0L)
          {
            Object localObject1 = new cmd0x8b4.ReqBody();
            ((cmd0x8b4.ReqBody)localObject1).uint64_dst_uin.set(l);
            ((cmd0x8b4.ReqBody)localObject1).uint32_start.set(paramInt1);
            ((cmd0x8b4.ReqBody)localObject1).uint32_cnt.set(paramInt2);
            Object localObject2 = (TroopManager)this.app.getManager(52);
            localObject2 = new oidb_sso.OIDBSSOPkg();
            ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2228);
            ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8b4.ReqBody)localObject1).toByteArray()));
            ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(4);
            localObject1 = createToServiceMsg("OidbSvc.0x8b4");
            ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
            ((ToServiceMsg)localObject1).extraData.putString("0x8d4_cmd_key", "setShowExternalStatus0x8d4");
            ((ToServiceMsg)localObject1).extraData.putString("target_uin", paramString);
            sendPbReq((ToServiceMsg)localObject1);
            if (QLog.isColorLevel())
            {
              QLog.d("NearbyCardHandler.troop.get_show_external_troop_list", 2, "getShowExternalTroopList, request begin==>" + "|ssoSeq:" + ((ToServiceMsg)localObject1).getRequestSsoSeq() + "|ServiceCmd:" + ((ToServiceMsg)localObject1).getServiceCmd() + "|destUin:" + paramString);
              return;
            }
          }
        }
        catch (NumberFormatException paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("NearbyCardHandler", 2, "NumberFormatException");
  }
  
  public void ar(String paramString, long paramLong)
  {
    nearby_ice_break.IceReq localIceReq = new nearby_ice_break.IceReq();
    try
    {
      localIceReq.uin.set(Long.parseLong(paramString));
      localIceReq.tinyid.set(String.valueOf(paramLong));
      new ajwu(this.app).a(13569).b(1).a(new ajrv(this)).a(new ajru(this)).a(localIceReq.toByteArray());
      return;
    }
    catch (NumberFormatException paramString)
    {
      QLog.i("NearbyCardHandler", 1, "sendPoBingMsg. error=" + QLog.getStackTraceString(paramString));
    }
  }
  
  public void b(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    acic.a(this, paramLong, paramInt, paramArrayOfByte);
  }
  
  public void b(long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.profilecard.", 4, String.format("nearbyPeopleLike|%d|%d|likeSource=%d", new Object[] { Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "VisitorSvc.ReqFavorite");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("targetUin", paramLong2);
    localToServiceMsg.extraData.putByteArray("vCookies", paramArrayOfByte);
    localToServiceMsg.extraData.putBoolean("nearby_people", true);
    localToServiceMsg.extraData.putInt("favoriteSource", paramInt1);
    localToServiceMsg.extraData.putInt("iCount", paramInt2);
    localToServiceMsg.extraData.putInt("from", paramInt3);
    send(localToServiceMsg);
  }
  
  public void bB(String paramString, int paramInt)
  {
    notifyUI(10, true, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public void dyX()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.query_import_qzone_photoes_status", 2, "CardHandler.queryImportQzonePhotoesStatus()");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    localOIDBSSOPkg.uint32_service_type.set(4);
    localOIDBSSOPkg.uint32_result.set(0);
    Object localObject = new UpdatePhotoList.ReqBody();
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x5ea_4");
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void e(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject = new cmd0x9c8.ReqBody();
    ((cmd0x9c8.ReqBody)localObject).str_keyword.set(paramString);
    ((cmd0x9c8.ReqBody)localObject).uint32_tag_type.set(paramInt1);
    ((cmd0x9c8.ReqBody)localObject).uint32_fetch_start.set(paramInt2);
    ((cmd0x9c8.ReqBody)localObject).uint32_fetch_count.set(paramInt3);
    ((cmd0x9c8.ReqBody)localObject).uint32_match_op.set(paramInt4);
    ((cmd0x9c8.ReqBody)localObject).uint32_personal_info_flag.set(paramInt5);
    localObject = makeOIDBPkg("OidbSvc.0x9c8_0", 2504, 0, ((cmd0x9c8.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("key_word", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("tag_type", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("fetch_start", paramInt2);
    ((ToServiceMsg)localObject).extraData.putInt("person_flag", paramInt5);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void e(List<ajuu> paramList, int paramInt1, int paramInt2)
  {
    acic.a(this, 4, paramList, paramInt1, paramInt2);
  }
  
  public void eA(ArrayList<Integer> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      int i = 0;
      while (i < paramArrayList.size())
      {
        ((StringBuilder)localObject).append(paramArrayList.get(i)).append(", ");
        i += 1;
      }
      QLog.d("Q.nearby_people_card.update_photo_list", 2, "CardHandler.updateNearbyPeoplePhotoList(), photo_ids = " + ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1514);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    UpdatePhotoList.ReqBody localReqBody = new UpdatePhotoList.ReqBody();
    localReqBody.rpt_uint32_headids.set(paramArrayList);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramArrayList = createToServiceMsg("OidbSvc.0x5ea_1");
    paramArrayList.setTimeout(30000L);
    paramArrayList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    sendPbReq(paramArrayList);
  }
  
  public void iO(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.import_qzone_photo", 2, "CardHandler.importQzonePhotoes()");
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.uint32_result.set(0);
    Object localObject = new UpdatePhotoList.ReqBody();
    ((UpdatePhotoList.ReqBody)localObject).uint32_copy_count_from_qzone.set(paramInt1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((UpdatePhotoList.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x5ea_3");
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void ki(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.nearby.now", 2, "handleNotifyFaceChange req == null || res == null");
      }
      return;
    }
    paramToServiceMsg = new cmd0xb5b.RspBody();
    parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    QLog.i("Q.nearby.now", 1, "handleNotifyFaceChange code:" + paramToServiceMsg.result.get() + "   " + paramToServiceMsg.err_msg.get());
  }
  
  public void kv(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewNearbyMyTab", 2, "handleGetRandomUserInfo");
    }
    paramToServiceMsg = new Oidb_0x66b.RspBody();
    oidb_0x5eb.RspBody localRspBody;
    String str;
    int k;
    int m;
    if (parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0)
    {
      localRspBody = new oidb_0x5eb.RspBody();
      paramObject = null;
      str = "";
      k = -1;
      m = 0;
      if (paramToServiceMsg.bytes_rspbody_5eb.has()) {
        paramToServiceMsg = paramToServiceMsg.bytes_rspbody_5eb.get().toByteArray();
      }
    }
    try
    {
      localRspBody.mergeFrom(paramToServiceMsg);
      int j = m;
      int i = k;
      paramFromServiceMsg = str;
      paramToServiceMsg = paramObject;
      if (localRspBody.rpt_msg_uin_data.has())
      {
        j = m;
        i = k;
        paramFromServiceMsg = str;
        paramToServiceMsg = paramObject;
        if (localRspBody.rpt_msg_uin_data.size() > 0)
        {
          paramObject = (oidb_0x5eb.UdcUinData)localRspBody.rpt_msg_uin_data.get().get(0);
          paramToServiceMsg = Long.valueOf(paramObject.uint64_uin.get());
          paramFromServiceMsg = paramObject.bytes_stranger_nick.get().toStringUtf8();
          i = paramObject.uint32_gender.get();
          j = paramObject.uint32_age.get();
        }
      }
      notifyUI(13, true, new Object[] { paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i), Integer.valueOf(j) });
      if (QLog.isDevelopLevel()) {
        QLog.d("NewNearbyMyTab", 2, "handleGetRandomUserInfo---->uin =" + paramToServiceMsg + "nickName = " + paramFromServiceMsg + " gender = " + i + "age =" + j);
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("NewNearbyMyTab", 2, "fail to decode 5eb_rspBody", paramToServiceMsg);
        }
      }
    }
    notifyUI(13, false, new Object[] { Integer.valueOf(-1), null, Integer.valueOf(-1), Integer.valueOf(-1) });
  }
  
  public void kw(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0x8e7.RspBody localRspBody = new oidb_0x8e7.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("uin", "");
    int j = paramToServiceMsg.extraData.getInt("from", 509);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "handleNearbyLikeLimitInfo, uin=" + paramFromServiceMsg + ", ret=" + i);
    }
    if (i == 0)
    {
      for (;;)
      {
        oidb_0x8e7.UserZanInfo localUserZanInfo;
        long l;
        try
        {
          paramToServiceMsg = new ajqh.c();
          paramToServiceMsg.bSi = localRspBody.bytes_recharge_url.get().toStringUtf8();
          paramToServiceMsg.bSj = localRspBody.bytes_update_url.get().toStringUtf8();
          if (localRspBody.msg_zan_limit.has())
          {
            Object localObject = (oidb_0x8e7.ZanLimitInfo)localRspBody.msg_zan_limit.get();
            paramToServiceMsg.level = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_level.get());
            paramToServiceMsg.dkB = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_can_free_zan_user_limit.get());
            paramToServiceMsg.dkC = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_free_zan_total_limit.get());
            paramToServiceMsg.dkA = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_price.get());
            paramToServiceMsg.dkE = ((int)((oidb_0x8e7.ZanLimitInfo)localObject).uint64_free_zan_user.get());
            paramObject = new ArrayList();
            if (!((oidb_0x8e7.ZanLimitInfo)localObject).rpt_msg_user_zan_info.has()) {
              break;
            }
            localObject = ((oidb_0x8e7.ZanLimitInfo)localObject).rpt_msg_user_zan_info.get().iterator();
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localUserZanInfo = (oidb_0x8e7.UserZanInfo)((Iterator)localObject).next();
            ajqh.a locala = new ajqh.a();
            l = 0L;
            if (localUserZanInfo.uint64_uin.has())
            {
              l = localUserZanInfo.uint64_uin.get();
              locala.uin = l;
              locala.dkt = ((int)localUserZanInfo.uint64_free_zan.get());
              locala.dku = ((int)localUserZanInfo.uint64_pay_zan.get());
              locala.dkv = ((int)localUserZanInfo.uint64_pay_stock.get());
              if (l <= 0L) {
                continue;
              }
              paramObject.add(locala);
              continue;
            }
          }
          else
          {
            return;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          notifyUI(16, false, paramFromServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.e("NearbyLikeLimitManager", 2, "handleNearbyLikeLimitInfo, " + paramToServiceMsg.toString());
          }
        }
        if (localUserZanInfo.uint64_tinyid.has()) {
          l = localUserZanInfo.uint64_tinyid.get();
        }
      }
      if (localRspBody.msg_warn.has()) {
        paramToServiceMsg.a = ((oidb_0x8e7.WarnMsg)localRspBody.msg_warn.get());
      }
      if (localRspBody.msg_stock_rsp.has()) {
        paramToServiceMsg.dkD = ((oidb_0x8e7.StockRsp)localRspBody.msg_stock_rsp.get()).int32_total.get();
      }
      ((ajqh)this.app.getManager(207)).a(paramToServiceMsg, paramObject, j);
      notifyUI(16, true, paramFromServiceMsg);
      return;
    }
    notifyUI(16, false, paramFromServiceMsg);
  }
  
  public void kx(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = paramToServiceMsg.extraData.getInt("from", 0);
    Object localObject1 = new oidb_0x8e6.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "handleNearbyPeopleLikeNew, ret=" + i + ", from=" + j);
    }
    paramToServiceMsg = new ArrayList();
    if (i == 0)
    {
      int k = ((oidb_0x8e6.RspBody)localObject1).uint32_level.get();
      int m = ((oidb_0x8e6.RspBody)localObject1).uint32_can_vote_free_user_count.get();
      int n = ((oidb_0x8e6.RspBody)localObject1).uint32_can_vote_free_count.get();
      ((oidb_0x8e6.RspBody)localObject1).uint32_remain_total.get();
      paramFromServiceMsg = (ajqh)this.app.getManager(207);
      paramObject = ((oidb_0x8e6.RspBody)localObject1).rpt_vote_result.get();
      int i1 = paramObject.size();
      i = 0;
      while (i < i1)
      {
        Object localObject2 = (oidb_0x8e6.VoteResult)paramObject.get(i);
        localObject1 = new ajqh.b();
        ((ajqh.b)localObject1).ret = ((oidb_0x8e6.VoteResult)localObject2).uint32_ret.get();
        ((ajqh.b)localObject1).errMsg = ((oidb_0x8e6.VoteResult)localObject2).bytes_err_msg.get().toStringUtf8();
        ((ajqh.b)localObject1).uin = ((oidb_0x8e6.VoteResult)localObject2).uint64_uin.get();
        ((ajqh.b)localObject1).dkw = ((oidb_0x8e6.VoteResult)localObject2).uint32_succ_free_vote_count.get();
        ((ajqh.b)localObject1).dkx = ((oidb_0x8e6.VoteResult)localObject2).uint32_succ_pay_vote_count.get();
        ((ajqh.b)localObject1).dky = ((oidb_0x8e6.VoteResult)localObject2).uint32_vote_count.get();
        ((ajqh.b)localObject1).dkz = ((int)((oidb_0x8e6.VoteResult)localObject2).uint64_pay_stock.get());
        paramToServiceMsg.add(localObject1);
        int i2 = ((ajqh.b)localObject1).dkw;
        i2 = ((ajqh.b)localObject1).dkx + i2;
        if ((((ajqh.b)localObject1).ret == 0) && (((ajqh.b)localObject1).uin > 0L) && (i2 > 0))
        {
          aqfu.f(this.app, ((ajqh.b)localObject1).uin, i2);
          localObject2 = this.app.a().createEntityManager();
          NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)((EntityManager)localObject2).find(NearbyPeopleCard.class, "uin=?", new String[] { String.valueOf(((ajqh.b)localObject1).uin) });
          if (localNearbyPeopleCard != null)
          {
            localNearbyPeopleCard.likeCount += i2;
            localNearbyPeopleCard.bVoted = 1;
            localNearbyPeopleCard.bAvailVoteCnt = ((short)(localNearbyPeopleCard.bAvailVoteCnt - i2));
            if (localNearbyPeopleCard.bAvailVoteCnt < 0) {
              localNearbyPeopleCard.bAvailVoteCnt = 0;
            }
            ((EntityManager)localObject2).update(localNearbyPeopleCard);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("NearbyLikeLimitManager", 2, "handleNearbyPeopleLikeNew: " + localObject1);
        }
        paramFromServiceMsg.cz(((ajqh.b)localObject1).uin + "", true);
        i += 1;
      }
      paramFromServiceMsg.aS(k, m, n);
      notifyUI(17, true, new Object[] { paramToServiceMsg, Integer.valueOf(j) });
      return;
    }
    notifyUI(17, false, new Object[] { paramToServiceMsg, Integer.valueOf(j) });
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("SummaryCard.ReqSummaryCard");
      this.allowCmdSet.add("OidbSvc.0x9c8_0");
      this.allowCmdSet.add("OidbSvc.0x9c5_0");
      this.allowCmdSet.add("OidbSvc.0x9c9_0");
      this.allowCmdSet.add("OidbSvc.0x9c9_1");
      this.allowCmdSet.add("OidbSvc.0x9c7_0");
      this.allowCmdSet.add("OidbSvc.0x682");
      this.allowCmdSet.add("OidbSvc.0x686");
      this.allowCmdSet.add("OidbSvc.0x5ea_1");
      this.allowCmdSet.add("OidbSvc.0x5ea_3");
      this.allowCmdSet.add("OidbSvc.0x5ea_4");
      this.allowCmdSet.add("SQQzoneSvc.getCover");
      this.allowCmdSet.add("OidbSvc.0x8b4");
      this.allowCmdSet.add("OidbSvc.0x5ea_6");
      this.allowCmdSet.add("OidbSvc.0x5ea_7");
      this.allowCmdSet.add("VisitorSvc.ReqFavorite");
      this.allowCmdSet.add("OidbSvc.0x66b");
      this.allowCmdSet.add("OidbSvc.0x66b");
      this.allowCmdSet.add("OidbSvc.0x66b");
      this.allowCmdSet.add("OidbSvc.0x8e6_1");
      this.allowCmdSet.add("OidbSvc.0x8e7_1");
      this.allowCmdSet.add("OidbSvc.0xb5b");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public void o(long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "getNearbyLikeLimitInfo, uin=" + paramLong1 + ", tinyId=" + paramLong2 + ", from=" + paramInt);
    }
    Object localObject2 = ((TicketManager)this.app.getManager(2)).getSkey(this.app.getCurrentAccountUin());
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.w("NearbyLikeLimitManager", 2, "getNearbyLikeLimitInfo, skey==null, return");
      }
      return;
    }
    Object localObject1 = new oidb_0x8e7.ReqBody();
    ((oidb_0x8e7.ReqBody)localObject1).bool_stock.set(true);
    ((oidb_0x8e7.ReqBody)localObject1).bool_is_first.set(true);
    ((oidb_0x8e7.ReqBody)localObject1).bool_need_warn.set(true);
    ((oidb_0x8e7.ReqBody)localObject1).bool_need_update_url.set(true);
    if (paramLong1 > 0L) {
      ((oidb_0x8e7.ReqBody)localObject1).uint64_uin.set(paramLong1);
    }
    for (;;)
    {
      oidb_0x8e7.LoginSig localLoginSig = new oidb_0x8e7.LoginSig();
      localLoginSig.uint32_type.set(1);
      localLoginSig.bytes_sig.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
      localObject2 = new oidb_0x8e7.ExtParam();
      ((oidb_0x8e7.ExtParam)localObject2).uint32_client.set(1);
      ((oidb_0x8e7.ExtParam)localObject2).uint32_portal.set(paramInt);
      ((oidb_0x8e7.ExtParam)localObject2).bytes_version.set(ByteStringMicro.copyFrom(AppSetting.getVersion().getBytes()));
      ((oidb_0x8e7.ExtParam)localObject2).msg_login_sig.set(localLoginSig);
      ((oidb_0x8e7.ReqBody)localObject1).msg_ext_parm.set((MessageMicro)localObject2);
      localObject1 = makeOIDBPkg("OidbSvc.0x8e7_1", 2279, 1, ((oidb_0x8e7.ReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("uin", paramLong1 + "");
      ((ToServiceMsg)localObject1).extraData.putInt("from", paramInt);
      sendPbReq((ToServiceMsg)localObject1);
      return;
      if (paramLong2 > 0L) {
        ((oidb_0x8e7.ReqBody)localObject1).uint64_tinyid.set(paramLong2);
      }
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return ajrw.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    do
    {
      do
      {
        return;
      } while (msgCmdFilter(paramFromServiceMsg.getServiceCmd()));
      String str = paramFromServiceMsg.getServiceCmd();
      if ("SummaryCard.ReqSummaryCard".equals(paramFromServiceMsg.getServiceCmd()))
      {
        ko(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c8_0".equals(str))
      {
        kk(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c5_0".equals(str))
      {
        kj(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (("OidbSvc.0x9c9_0".equals(str)) || ("OidbSvc.0x9c9_1".equals(str)))
      {
        kl(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9c7_0".equals(str))
      {
        acic.c(this, 4, paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x682".equals(str))
      {
        km(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x686".equals(paramFromServiceMsg.getServiceCmd()))
      {
        kn(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        kr(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        ks(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_6".equals(paramFromServiceMsg.getServiceCmd()))
      {
        kp(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_7".equals(paramFromServiceMsg.getServiceCmd()))
      {
        kq(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5ea_4".equals(paramFromServiceMsg.getServiceCmd()))
      {
        kt(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("SQQzoneSvc.getCover".equals(paramFromServiceMsg.getServiceCmd()))
      {
        bO(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd()))
      {
        ku(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8b4".equals(paramFromServiceMsg.getServiceCmd()))
      {
        gT(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x66b".equals(paramFromServiceMsg.getServiceCmd()))
      {
        kv(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8e7_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        kw(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8e6_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        kx(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xb5b".equals(paramFromServiceMsg.getServiceCmd()));
    ki(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void q(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.nearby_people_card.update_auth_video", 2, "CardHandler.updateNearbyPeopleAuthVideo(), videoId = " + paramString + ",photoId =" + paramInt);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1514);
    if (paramBoolean)
    {
      localOIDBSSOPkg.uint32_service_type.set(6);
      localOIDBSSOPkg.uint32_result.set(0);
      UpdatePhotoList.ReqBody localReqBody = new UpdatePhotoList.ReqBody();
      UpdatePhotoList.RichHead localRichHead = new UpdatePhotoList.RichHead();
      localRichHead.uint32_headid.set(paramInt);
      localRichHead.str_video_id.set(paramString);
      localReqBody.msg_verify_video_info.set(localRichHead);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      if (!paramBoolean) {
        break label195;
      }
    }
    label195:
    for (paramString = createToServiceMsg("OidbSvc.0x5ea_6");; paramString = createToServiceMsg("OidbSvc.0x5ea_7"))
    {
      paramString.setTimeout(30000L);
      paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
      sendPbReq(paramString);
      return;
      localOIDBSSOPkg.uint32_service_type.set(7);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajrs
 * JD-Core Version:    0.7.0.1
 */