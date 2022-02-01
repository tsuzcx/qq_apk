import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.1;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardPresenter.8;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.cmd0x899.oidb_0x899.memberlist;>;
import java.util.Observer;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class appx
{
  private List<TroopClipPic> If = new ArrayList();
  private appf jdField_a_of_type_Appf;
  private apru jdField_a_of_type_Apru;
  private TroopInfoData jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
  protected jqk a;
  private ztd.b jdField_a_of_type_Ztd$b = new apqa(this);
  private ztd jdField_a_of_type_Ztd;
  private boolean aRg;
  private TroopManager b;
  public int bFL;
  private Handler bJ;
  private aqdf.a c = new appz(this);
  private acms jdField_d_of_type_Acms;
  public aprb.a d;
  private aqdf jdField_d_of_type_Aqdf;
  private QQAppInterface jdField_d_of_type_ComTencentMobileqqAppQQAppInterface;
  private Observer k = new apqb(this);
  private String mOpenID;
  private acnd r = new apqc(this);
  private List<TroopClipPic> sH = new ArrayList();
  
  public appx()
  {
    this.jdField_a_of_type_Jqk = new appy(this);
    this.jdField_d_of_type_Aprb$a = new apqd(this);
  }
  
  private VisitorTroopCardFragment a()
  {
    if (this.jdField_a_of_type_Appf != null) {
      return (VisitorTroopCardFragment)this.jdField_a_of_type_Appf;
    }
    return null;
  }
  
  /* Error */
  private void a(KQQ.BatchResponse paramBatchResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 120	KQQ/BatchResponse:result	I
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   15: dup
    //   16: invokespecial 123	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   19: astore 9
    //   21: aload 9
    //   23: aload_1
    //   24: getfield 127	KQQ/BatchResponse:buffer	[B
    //   27: invokevirtual 131	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   30: pop
    //   31: aload_1
    //   32: getfield 134	KQQ/BatchResponse:seq	I
    //   35: ifne +240 -> 275
    //   38: aload 9
    //   40: getfield 138	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   43: invokevirtual 144	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   46: ifeq +229 -> 275
    //   49: aload 9
    //   51: getfield 138	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   54: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   57: invokevirtual 154	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   60: astore 7
    //   62: new 156	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   65: dup
    //   66: invokespecial 157	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   69: astore 8
    //   71: aload 8
    //   73: aload 7
    //   75: invokevirtual 158	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   78: pop
    //   79: aload 8
    //   81: getfield 162	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   84: invokevirtual 167	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   87: astore 10
    //   89: aload 10
    //   91: ifnonnull +49 -> 140
    //   94: iconst_0
    //   95: istore_2
    //   96: goto +797 -> 893
    //   99: aload 7
    //   101: ifnonnull +174 -> 275
    //   104: iload_3
    //   105: iload_2
    //   106: if_icmpge +169 -> 275
    //   109: aload 10
    //   111: iload_3
    //   112: invokeinterface 172 2 0
    //   117: checkcast 174	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   120: astore 8
    //   122: aload 8
    //   124: ifnonnull +27 -> 151
    //   127: iload_3
    //   128: iconst_1
    //   129: iadd
    //   130: istore_3
    //   131: goto -32 -> 99
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 177	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   139: return
    //   140: aload 10
    //   142: invokeinterface 181 1 0
    //   147: istore_2
    //   148: goto +745 -> 893
    //   151: aload 8
    //   153: getfield 185	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   156: invokevirtual 189	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   159: istore 4
    //   161: iload 4
    //   163: bipush 72
    //   165: if_icmpne +35 -> 200
    //   168: iload_3
    //   169: ifne +31 -> 200
    //   172: aload_0
    //   173: invokespecial 88	appx:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   176: ifnull +635 -> 811
    //   179: aload_0
    //   180: getfield 91	appx:jdField_a_of_type_Appf	Lappf;
    //   183: aload_0
    //   184: invokespecial 88	appx:getActivity	()Landroid/support/v4/app/FragmentActivity;
    //   187: ldc 190
    //   189: invokevirtual 196	android/support/v4/app/FragmentActivity:getString	(I)Ljava/lang/String;
    //   192: invokeinterface 202 2 0
    //   197: goto -70 -> 127
    //   200: iload 4
    //   202: ifne +581 -> 783
    //   205: aload 8
    //   207: getfield 206	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   210: invokevirtual 209	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   213: ifeq +570 -> 783
    //   216: aload 8
    //   218: getfield 206	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   221: invokevirtual 212	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   224: checkcast 208	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   227: astore 8
    //   229: aload 8
    //   231: astore 7
    //   233: aload 8
    //   235: ifnull -108 -> 127
    //   238: aload_0
    //   239: getfield 91	appx:jdField_a_of_type_Appf	Lappf;
    //   242: aload 8
    //   244: invokeinterface 215 2 0
    //   249: aload 8
    //   251: astore 7
    //   253: goto -126 -> 127
    //   256: astore 7
    //   258: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +14 -> 275
    //   264: ldc 222
    //   266: iconst_2
    //   267: aload 7
    //   269: invokevirtual 226	java/lang/Exception:toString	()Ljava/lang/String;
    //   272: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: aload_1
    //   276: getfield 134	KQQ/BatchResponse:seq	I
    //   279: iconst_1
    //   280: if_icmpne +117 -> 397
    //   283: aload 9
    //   285: getfield 138	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   288: invokevirtual 144	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   291: ifeq +106 -> 397
    //   294: aload 9
    //   296: getfield 138	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   299: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   302: invokevirtual 154	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   305: astore 7
    //   307: new 232	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   310: dup
    //   311: invokespecial 233	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   314: astore 8
    //   316: aload 8
    //   318: aload 7
    //   320: invokevirtual 234	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   323: pop
    //   324: aload 8
    //   326: getfield 237	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   329: invokevirtual 238	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   332: ifeq +65 -> 397
    //   335: aload_0
    //   336: getfield 106	appx:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   339: getfield 243	com/tencent/mobileqq/troopinfo/TroopInfoData:isMember	Z
    //   342: ifeq +20 -> 362
    //   345: aload_0
    //   346: invokespecial 103	appx:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   349: ifnull +465 -> 814
    //   352: aload_0
    //   353: invokespecial 103	appx:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   356: getfield 246	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment:cRT	Z
    //   359: ifeq +455 -> 814
    //   362: aload_0
    //   363: invokespecial 103	appx:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   366: ifnull +31 -> 397
    //   369: aload_0
    //   370: invokespecial 103	appx:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   373: getfield 249	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   376: ifnull +21 -> 397
    //   379: aload_0
    //   380: invokespecial 103	appx:a	()Lcom/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment;
    //   383: getfield 249	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardFragment:jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView	Lcom/tencent/mobileqq/troop/widget/TroopMoreDetailView;
    //   386: aload 8
    //   388: getfield 237	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   391: invokevirtual 167	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   394: invokevirtual 255	com/tencent/mobileqq/troop/widget/TroopMoreDetailView:mY	(Ljava/util/List;)V
    //   397: aload_1
    //   398: getfield 134	KQQ/BatchResponse:seq	I
    //   401: iconst_2
    //   402: if_icmpne -391 -> 11
    //   405: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +13 -> 421
    //   411: ldc_w 257
    //   414: iconst_2
    //   415: ldc_w 259
    //   418: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: aload 9
    //   423: getfield 138	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   426: invokevirtual 144	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   429: ifeq -418 -> 11
    //   432: aload 9
    //   434: getfield 138	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   437: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   440: invokevirtual 154	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   443: astore_1
    //   444: new 263	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   447: dup
    //   448: invokespecial 264	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   451: astore 7
    //   453: aload 7
    //   455: aload_1
    //   456: invokevirtual 265	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   459: pop
    //   460: aload 7
    //   462: getfield 269	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   465: invokevirtual 272	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   468: ifeq -457 -> 11
    //   471: aload 7
    //   473: getfield 275	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   476: invokevirtual 278	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   479: ifne +409 -> 888
    //   482: aload 7
    //   484: getfield 275	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   487: invokevirtual 167	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   490: astore_1
    //   491: aload_0
    //   492: getfield 97	appx:jdField_d_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   495: bipush 52
    //   497: invokevirtual 284	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   500: checkcast 286	com/tencent/mobileqq/app/TroopManager
    //   503: astore 8
    //   505: aload 7
    //   507: getfield 269	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   510: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   513: lstore 5
    //   515: aload 8
    //   517: lload 5
    //   519: invokestatic 295	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   522: invokevirtual 298	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   525: astore 9
    //   527: aload 9
    //   529: ifnull -518 -> 11
    //   532: aload_1
    //   533: ifnull +69 -> 602
    //   536: aload 9
    //   538: aload_1
    //   539: invokevirtual 303	com/tencent/mobileqq/data/TroopInfo:setTroopLevelMap787	(Ljava/util/List;)V
    //   542: aload 7
    //   544: getfield 306	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   547: invokevirtual 307	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   550: ifeq +301 -> 851
    //   553: aload 7
    //   555: getfield 306	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   558: invokevirtual 189	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   561: istore_2
    //   562: aload 9
    //   564: iload_2
    //   565: i2l
    //   566: putfield 311	com/tencent/mobileqq/data/TroopInfo:dwGroupLevelSeq	J
    //   569: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   572: ifeq +30 -> 602
    //   575: ldc_w 257
    //   578: iconst_2
    //   579: new 313	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   586: ldc_w 316
    //   589: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: iload_2
    //   593: invokevirtual 323	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   596: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: aload 9
    //   604: aload 7
    //   606: getfield 327	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   609: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   612: invokevirtual 330	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   615: putfield 333	com/tencent/mobileqq/data/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   618: aload 9
    //   620: aload 7
    //   622: getfield 336	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   625: invokevirtual 148	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   628: invokevirtual 330	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   631: putfield 339	com/tencent/mobileqq/data/TroopInfo:adminNameShow	Ljava/lang/String;
    //   634: aload 7
    //   636: getfield 342	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   639: invokevirtual 307	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   642: ifeq +241 -> 883
    //   645: aload 9
    //   647: aload 7
    //   649: getfield 342	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   652: invokevirtual 189	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   655: i2b
    //   656: putfield 346	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   659: aload 9
    //   661: getfield 346	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   664: istore_2
    //   665: aload 7
    //   667: getfield 349	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   670: invokevirtual 307	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   673: ifeq +205 -> 878
    //   676: aload 9
    //   678: aload 7
    //   680: getfield 349	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   683: invokevirtual 189	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   686: i2b
    //   687: putfield 352	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   690: aload 9
    //   692: getfield 352	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   695: istore_3
    //   696: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   699: ifeq +45 -> 744
    //   702: ldc_w 257
    //   705: iconst_2
    //   706: new 313	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   713: lload 5
    //   715: invokevirtual 355	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   718: ldc_w 357
    //   721: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: iload_2
    //   725: invokevirtual 323	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   728: ldc_w 359
    //   731: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: iload_3
    //   735: invokevirtual 323	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   738: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   741: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   744: new 361	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter$7
    //   747: dup
    //   748: aload_0
    //   749: aload 8
    //   751: aload 9
    //   753: invokespecial 364	com/tencent/mobileqq/troop/troopCard/VisitorTroopCardPresenter$7:<init>	(Lappx;Lcom/tencent/mobileqq/app/TroopManager;Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   756: bipush 8
    //   758: aconst_null
    //   759: iconst_0
    //   760: invokestatic 370	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   763: return
    //   764: astore_1
    //   765: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   768: ifeq -757 -> 11
    //   771: ldc_w 257
    //   774: iconst_2
    //   775: aload_1
    //   776: invokevirtual 226	java/lang/Exception:toString	()Ljava/lang/String;
    //   779: invokestatic 373	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   782: return
    //   783: ldc_w 375
    //   786: iconst_1
    //   787: new 313	java/lang/StringBuilder
    //   790: dup
    //   791: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   794: ldc_w 377
    //   797: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: iload 4
    //   802: invokevirtual 323	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   805: invokevirtual 324	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   808: invokestatic 373	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   811: goto -684 -> 127
    //   814: aload_0
    //   815: aload 8
    //   817: getfield 237	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   820: invokevirtual 167	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   823: invokespecial 380	appx:fJ	(Ljava/util/List;)V
    //   826: goto -429 -> 397
    //   829: astore 7
    //   831: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   834: ifeq -437 -> 397
    //   837: ldc 222
    //   839: iconst_2
    //   840: aload 7
    //   842: invokevirtual 226	java/lang/Exception:toString	()Ljava/lang/String;
    //   845: invokestatic 230	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   848: goto -451 -> 397
    //   851: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   854: ifeq -252 -> 602
    //   857: ldc_w 257
    //   860: iconst_2
    //   861: ldc_w 382
    //   864: invokestatic 261	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   867: goto -265 -> 602
    //   870: astore_1
    //   871: aload_1
    //   872: invokevirtual 383	java/lang/Exception:printStackTrace	()V
    //   875: goto -241 -> 634
    //   878: iconst_m1
    //   879: istore_3
    //   880: goto -184 -> 696
    //   883: iconst_m1
    //   884: istore_2
    //   885: goto -220 -> 665
    //   888: aconst_null
    //   889: astore_1
    //   890: goto -399 -> 491
    //   893: iconst_0
    //   894: istore_3
    //   895: aconst_null
    //   896: astore 7
    //   898: goto -799 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	901	0	this	appx
    //   0	901	1	paramBatchResponse	KQQ.BatchResponse
    //   95	790	2	i	int
    //   104	791	3	j	int
    //   159	642	4	m	int
    //   513	201	5	l	long
    //   60	192	7	localObject1	Object
    //   256	12	7	localException1	Exception
    //   305	374	7	localObject2	Object
    //   829	12	7	localException2	Exception
    //   896	1	7	localObject3	Object
    //   69	747	8	localObject4	Object
    //   19	733	9	localObject5	Object
    //   87	54	10	localList	List
    // Exception table:
    //   from	to	target	type
    //   21	31	134	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   62	89	256	java/lang/Exception
    //   109	122	256	java/lang/Exception
    //   140	148	256	java/lang/Exception
    //   151	161	256	java/lang/Exception
    //   172	197	256	java/lang/Exception
    //   205	229	256	java/lang/Exception
    //   238	249	256	java/lang/Exception
    //   783	811	256	java/lang/Exception
    //   444	491	764	java/lang/Exception
    //   491	527	764	java/lang/Exception
    //   536	602	764	java/lang/Exception
    //   634	665	764	java/lang/Exception
    //   665	696	764	java/lang/Exception
    //   696	744	764	java/lang/Exception
    //   744	763	764	java/lang/Exception
    //   851	867	764	java/lang/Exception
    //   871	875	764	java/lang/Exception
    //   307	362	829	java/lang/Exception
    //   362	397	829	java/lang/Exception
    //   814	826	829	java/lang/Exception
    //   602	634	870	java/lang/Exception
  }
  
  private void addListener()
  {
    this.jdField_a_of_type_Ztd.a(this.jdField_a_of_type_Ztd$b);
    this.jdField_d_of_type_Aqdf.a(this.c);
  }
  
  private void addObserver()
  {
    this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.r);
  }
  
  private void fJ(List<oidb_0x899.memberlist> paramList)
  {
    acms localacms = (acms)this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20);
    ArrayList localArrayList1 = new ArrayList();
    Object localObject2 = (aptw)this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface.getManager(203);
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      localObject1 = (oidb_0x899.memberlist)localIterator.next();
      String str = String.valueOf(((oidb_0x899.memberlist)localObject1).uint64_member_uin.get());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin)) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin))) {
        paramList = (List<oidb_0x899.memberlist>)localObject1;
      } else if (((aptw)localObject2).gM(str)) {
        localArrayList1.add(localObject1);
      } else if (apuh.g(this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, str)) {
        localArrayList2.add(localObject1);
      } else {
        localArrayList3.add(localObject1);
      }
    }
    localObject2 = new ArrayList();
    Object localObject1 = paramList;
    if (paramList == null) {}
    try
    {
      localObject1 = new oidb_0x899.memberlist();
      ((oidb_0x899.memberlist)localObject1).uint64_member_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopowneruin));
      ((List)localObject2).add(0, localObject1);
    }
    catch (NumberFormatException paramList)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, paramList.toString());
        }
      }
      if (a() == null) {
        break label418;
      }
      localObject1 = apuh.a(this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, a().b, paramList);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label418;
      }
      a().b.memberListToShow = ((String)localObject1);
      localacms.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramList, true, null);
    }
    ((List)localObject2).addAll(localArrayList2);
    if ((a() != null) && (a().jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView != null)) {
      a().jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.mY((List)localObject2);
    }
    ((List)localObject2).addAll(localArrayList3);
    ((List)localObject2).addAll(localArrayList1);
    paramList = new ArrayList();
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.add(String.valueOf(((oidb_0x899.memberlist)((Iterator)localObject1).next()).uint64_member_uin.get()));
    }
    label418:
  }
  
  private FragmentActivity getActivity()
  {
    if (this.jdField_a_of_type_Appf != null) {
      return ((VisitorTroopCardFragment)this.jdField_a_of_type_Appf).getActivity();
    }
    return null;
  }
  
  private void removeListener()
  {
    if (this.jdField_d_of_type_Aqdf != null) {
      this.jdField_d_of_type_Aqdf.a(null);
    }
    this.c = null;
    if (this.jdField_a_of_type_Ztd != null) {
      this.jdField_a_of_type_Ztd.a(null);
    }
    this.jdField_a_of_type_Ztd$b = null;
    this.jdField_d_of_type_Aprb$a = null;
  }
  
  private void removeObserver()
  {
    this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.r);
    this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Jqk);
  }
  
  public void Tx(String paramString)
  {
    if (this.jdField_a_of_type_Apru != null) {
      this.jdField_a_of_type_Apru.Tx(paramString);
    }
  }
  
  public void a(appf paramappf)
  {
    this.jdField_a_of_type_Appf = paramappf;
    if (a() == null) {
      return;
    }
    this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface = a().app;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = a().jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData;
    this.jdField_d_of_type_Acms = ((acms)this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20));
    this.b = ((TroopManager)this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
    this.jdField_a_of_type_Apru = new apru(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, apug.class, this.jdField_d_of_type_Acms);
    this.jdField_a_of_type_Apru.addObserver(this.k);
    this.jdField_d_of_type_Aqdf = new aqdf(getActivity(), this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Ztd = new zta(getActivity(), getActivity(), this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    addListener();
    addObserver();
  }
  
  public void aC(List<TroopClipPic> paramList, boolean paramBoolean)
  {
    if ((this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.jdField_a_of_type_Appf == null)) {
      return;
    }
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
    Object localObject;
    boolean bool;
    label71:
    ArrayList localArrayList;
    if (QLog.isColorLevel())
    {
      if (paramList == null)
      {
        localObject = "null";
        if (localTroopInfo != null) {
          break label237;
        }
        bool = true;
        QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, String.format("setAvatarList isServer=%b piclist=%s troopinfo=null %b", new Object[] { Boolean.valueOf(paramBoolean), localObject, Boolean.valueOf(bool) }));
      }
    }
    else
    {
      localArrayList = new ArrayList();
      localObject = paramList;
      if (localTroopInfo != null)
      {
        localObject = paramList;
        if (paramList == null)
        {
          localObject = new ArrayList();
          zti.b((List)localObject, localTroopInfo);
        }
      }
      if (localObject == null) {
        break label314;
      }
      this.If.clear();
      this.sH.clear();
      paramList = ((List)localObject).iterator();
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label271;
      }
      localObject = (TroopClipPic)paramList.next();
      if (((TroopClipPic)localObject).type == 1)
      {
        this.sH.add(localObject);
        continue;
        localObject = Integer.valueOf(paramList.size());
        break;
        label237:
        bool = false;
        break label71;
      }
      localArrayList.add(zri.a((TroopClipPic)localObject, null));
      this.If.add(localObject);
    }
    label271:
    if (this.sH.size() == 0)
    {
      paramList = new TroopClipPic();
      paramList.id = zri.baD;
      paramList.type = 1;
      this.sH.add(paramList);
    }
    label314:
    this.jdField_a_of_type_Appf.V(false, localArrayList);
  }
  
  public void b(Bundle paramBundle, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ztd$b != null)
    {
      paramBundle.putInt("troop_auth_submit_time", this.bFL);
      paramBundle.putBoolean("troop_info_is_member", paramBoolean);
      this.jdField_a_of_type_Ztd$b.bw(paramBundle);
    }
  }
  
  protected void bWy()
  {
    if ((a() != null) && (a().b != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)) {
      ThreadManager.post(new VisitorTroopCardPresenter.8(this), 5, null, false);
    }
  }
  
  public void bc(String paramString1, String paramString2, String paramString3)
  {
    if ((this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {}
    do
    {
      do
      {
        return;
        this.mOpenID = paramString2;
        if ((!TextUtils.isEmpty(paramString3)) && (!paramString3.equals(this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
        {
          this.jdField_a_of_type_Appf.ebb();
          return;
        }
      } while (TextUtils.isEmpty(paramString2));
      paramString2 = this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1);
      if (paramString2 == null)
      {
        this.jdField_a_of_type_Appf.atg();
        this.bJ = new Handler();
        this.bJ.postDelayed(new VisitorTroopCardPresenter.1(this), 3000L);
        this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Jqk);
        this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface.a().Eo(paramString1);
        return;
      }
    } while (this.mOpenID.equals(paramString2.openID));
    this.jdField_a_of_type_Appf.ebb();
  }
  
  public void crH()
  {
    if (this.jdField_a_of_type_Ztd != null) {
      this.jdField_a_of_type_Ztd.crH();
    }
  }
  
  public void dZq()
  {
    if ((this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (a() == null)) {}
    while (this.jdField_d_of_type_Acms == null) {
      return;
    }
    acms localacms = this.jdField_d_of_type_Acms;
    long l = accc.Z(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) && (!a().cRT)) {}
    for (boolean bool = true;; bool = false)
    {
      localacms.j(l, bool, 0);
      return;
    }
  }
  
  public void detachView()
  {
    removeListener();
    removeObserver();
    if (this.bJ != null) {
      this.bJ.removeCallbacksAndMessages(null);
    }
    this.jdField_d_of_type_Acms = null;
    if (this.jdField_d_of_type_Aqdf != null) {
      this.jdField_d_of_type_Aqdf.destory();
    }
    if (this.jdField_a_of_type_Ztd != null) {
      this.jdField_a_of_type_Ztd.onDestroy();
    }
    if (this.b != null) {
      this.b.onDestroy();
    }
    if (this.jdField_a_of_type_Apru != null)
    {
      this.jdField_a_of_type_Apru.f(this.k);
      this.jdField_a_of_type_Apru.onDestroy();
    }
    this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = null;
    this.jdField_a_of_type_Appf = null;
  }
  
  public void gm(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_Appf == null) || (this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    do
    {
      acms localacms;
      do
      {
        return;
        localacms = (acms)this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20);
      } while (localacms == null);
      try
      {
        long l = Long.parseLong(paramString);
        this.jdField_a_of_type_Appf.atg();
        localacms.aA(l, paramInt);
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.i("VisitorTroopCardFragment.VisitorTroopCardPresenter", 2, paramString.toString());
  }
  
  public void hW(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Ztd != null) {
      this.jdField_a_of_type_Ztd.ag(paramString1, paramString2);
    }
  }
  
  public void hX(String paramString1, String paramString2)
  {
    if ((this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)) {
      return;
    }
    ((acms)this.jdField_d_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20)).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption(), paramString1, paramString2, null, null);
  }
  
  public Drawable q(String paramString)
  {
    Object localObject = null;
    if (this.jdField_d_of_type_Aqdf != null)
    {
      Bitmap localBitmap = this.jdField_d_of_type_Aqdf.b(4, paramString);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = localBitmap;
        if (!this.jdField_d_of_type_Aqdf.isPausing())
        {
          this.jdField_d_of_type_Aqdf.i(paramString, 4, true);
          localObject = localBitmap;
        }
      }
    }
    paramString = localObject;
    if (localObject == null) {
      paramString = aqhu.G();
    }
    return new BitmapDrawable(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     appx
 * JD-Core Version:    0.7.0.1
 */