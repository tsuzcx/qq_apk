import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForAIOStoryVideo;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForCmGameTips;
import com.tencent.mobileqq.data.MessageForColorRing;
import com.tencent.mobileqq.data.MessageForCommonHobbyForAIOShow;
import com.tencent.mobileqq.data.MessageForConfessCard;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageForDanceMachine;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForDeviceText;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageForLocationShare;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQQStoryFeed;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForSplitLineTips;
import com.tencent.mobileqq.data.MessageForStarLeague;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTimDouFuGuide;
import com.tencent.mobileqq.data.MessageForTofuBaseProfile;
import com.tencent.mobileqq.data.MessageForTofuIntimateAnniversary;
import com.tencent.mobileqq.data.MessageForTofuNicePics;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopNotification;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShareHotChatGrayTips;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.dingdong.MessageForDingdongSchedule;
import com.tencent.tim.todo.MessageForToDo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class xeh
{
  private static ArrayMap<Class<? extends MessageRecord>, Integer> e;
  private static ArrayMap<Class<? extends ChatMessage>, xeh.b> f;
  private BaseChatPie a;
  protected znn a;
  protected QQAppInterface app;
  private Set<wko> bn;
  private SparseArray<xeh.a> bw = new SparseArray();
  protected SessionInfo d;
  protected AIOAnimationConatiner e;
  protected Context mContext;
  
  static
  {
    jdField_e_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForNewGrayTips.class, Integer.valueOf(15));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForSafeGrayTips.class, Integer.valueOf(15));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForIncompatibleGrayTips.class, Integer.valueOf(15));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForNearbyMarketGrayTips.class, Integer.valueOf(15));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopEffectPic.class, Integer.valueOf(80));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDevPtt.class, Integer.valueOf(33));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForPtt.class, Integer.valueOf(2));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForVideo.class, Integer.valueOf(11));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForLocationShare.class, Integer.valueOf(113));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForMarketFace.class, Integer.valueOf(12));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForRichState.class, Integer.valueOf(13));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQQStory.class, Integer.valueOf(67));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTribeShortVideo.class, Integer.valueOf(89));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopPobing.class, Integer.valueOf(77));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopNotification.class, Integer.valueOf(28));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForFunnyFace.class, Integer.valueOf(19));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQzoneFeed.class, Integer.valueOf(21));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForPLNews.class, Integer.valueOf(79));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForConfessCard.class, Integer.valueOf(92));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForConfessNews.class, Integer.valueOf(91));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopConfess.class, Integer.valueOf(97));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForEnterTroop.class, Integer.valueOf(22));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForMyEnterTroop.class, Integer.valueOf(23));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForShakeWindow.class, Integer.valueOf(26));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopUnreadTips.class, Integer.valueOf(27));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForSplitLineTips.class, Integer.valueOf(70));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDevShortVideo.class, Integer.valueOf(35));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDevLittleVideo.class, Integer.valueOf(45));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForColorRing.class, Integer.valueOf(31));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopFee.class, Integer.valueOf(44));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDeviceSingleStruct.class, Integer.valueOf(34));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQQWalletTips.class, Integer.valueOf(15));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDeviceText.class, Integer.valueOf(39));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(ShareHotChatGrayTips.class, Integer.valueOf(15));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDeliverGiftTips.class, Integer.valueOf(15));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForArkFlashChat.class, Integer.valueOf(76));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForCmGameTips.class, Integer.valueOf(100));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForReplyText.class, Integer.valueOf(50));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForApproval.class, Integer.valueOf(52));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForVIPDonate.class, Integer.valueOf(58));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForFoldMsgGrayTips.class, Integer.valueOf(57));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForPokeEmo.class, Integer.valueOf(96));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQQStoryComment.class, Integer.valueOf(68));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopStory.class, Integer.valueOf(73));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForScribble.class, Integer.valueOf(75));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQQStoryFeed.class, Integer.valueOf(87));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTimDouFuGuide.class, Integer.valueOf(85));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForCommonHobbyForAIOShow.class, Integer.valueOf(94));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForLimitChatTopic.class, Integer.valueOf(102));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForStarLeague.class, Integer.valueOf(101));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForFuDai.class, Integer.valueOf(104));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForBirthdayNotice.class, Integer.valueOf(108));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForAIOStoryVideo.class, Integer.valueOf(109));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTofuIntimateAnniversary.class, Integer.valueOf(115));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTofuBaseProfile.class, Integer.valueOf(116));
    jdField_e_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTofuNicePics.class, Integer.valueOf(117));
    f = new ArrayMap();
    f.put(MessageForText.class, new xei());
    f.put(MessageForTroopGift.class, new xfk());
    f.put(MessageForGrayTips.class, new xfv());
    f.put(MessageForPic.class, new xgg());
    f.put(MessageForFile.class, new xgr());
    f.put(MessageForPubAccount.class, new xhc());
    f.put(MessageForTroopSign.class, new xhn());
    f.put(MessageForStructing.class, new xhy());
    f.put(MessageForLongMsg.class, new xij());
    f.put(MessageForMixedMsg.class, new xej());
    f.put(MessageForTroopFile.class, new xeu());
    xfc localxfc = new xfc();
    f.put(MessageForShortVideo.class, localxfc);
    f.put(MessageForLightVideo.class, localxfc);
    f.put(MessageForDanceMachine.class, localxfc);
    f.put(MessageForBlessPTV.class, localxfc);
    f.put(MessageForQQWalletMsg.class, new xfd());
    f.put(MessageForDeviceFile.class, new xfe());
    f.put(MessageForArkApp.class, new xff());
    f.put(MessageForArkBabyqReply.class, new xfg());
    f.put(MessageForApollo.class, new xfh());
    f.put(MessageForTroopReward.class, new xfi());
    f.put(MessageForPoke.class, new xfj());
    f.put(MessageForUniteGrayTip.class, new xfl());
    f.put(MessageForHiBoom.class, new xfm());
    f.put(MessageForDingdongSchedule.class, new xfn());
    f.put(MessageForToDo.class, new xfo());
  }
  
  public xeh(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    this.bw.put(61, new xfp(this));
    this.bw.put(65, new xfq(this));
    this.bw.put(3, new xfr(this));
    this.bw.put(1, new xfs(this));
    this.bw.put(24, new xft(this));
    this.bw.put(2, new xfu(this));
    this.bw.put(33, new xfw(this));
    this.bw.put(15, new xfx(this));
    this.bw.put(72, new xfy(this));
    this.bw.put(6, new xfz(this));
    this.bw.put(7, new xga(this));
    this.bw.put(8, new xgb(this));
    this.bw.put(5, new xgc(this));
    this.bw.put(114, new xgd(this));
    this.bw.put(10, new xge(this));
    this.bw.put(11, new xgf(this));
    this.bw.put(113, new xgh(this));
    this.bw.put(13, new xgi(this));
    this.bw.put(9, new xgj(this));
    this.bw.put(12, new xgk(this));
    this.bw.put(16, new xgl(this));
    this.bw.put(22, new xgm(this));
    this.bw.put(23, new xgn(this));
    this.bw.put(17, new xgo(this));
    this.bw.put(18, new xgp(this));
    this.bw.put(21, new xgq(this));
    this.bw.put(108, new xgs(this));
    this.bw.put(79, new xgt(this));
    this.bw.put(94, new xgu(this));
    this.bw.put(91, new xgv(this));
    this.bw.put(92, new xgw(this));
    this.bw.put(97, new xgx(this));
    this.bw.put(26, new xgy(this));
    this.bw.put(62, new xgz(this));
    this.bw.put(96, new xha(this));
    this.bw.put(27, new xhb(this));
    this.bw.put(70, new xhd(this));
    this.bw.put(28, new xhe(this));
    this.bw.put(29, new xhf(this));
    Object localObject = new xhg(this);
    this.bw.put(38, localObject);
    this.bw.put(40, localObject);
    this.bw.put(41, localObject);
    this.bw.put(46, new xhh(this));
    this.bw.put(103, new xhi(this));
    this.bw.put(31, new xhj(this));
    this.bw.put(32, new xhk(this));
    this.bw.put(90, new xhl(this));
    this.bw.put(44, new xhm(this));
    this.bw.put(48, new xho(this));
    this.bw.put(49, new xhp(this));
    this.bw.put(35, new xhq(this));
    this.bw.put(45, new xhr(this));
    this.bw.put(34, new xhs(this));
    this.bw.put(36, new xht(this));
    this.bw.put(37, new xhu(this));
    this.bw.put(39, new xhv(this));
    localObject = new xhw(this);
    this.bw.put(42, localObject);
    this.bw.put(66, localObject);
    this.bw.put(56, new xhx(this));
    this.bw.put(55, new xhz(this));
    this.bw.put(118, new xia(this));
    this.bw.put(88, new xib(this));
    this.bw.put(100, new xic(this));
    this.bw.put(47, new xid(this));
    this.bw.put(81, new xie(this));
    this.bw.put(112, new xif(this));
    this.bw.put(76, new xig(this));
    this.bw.put(50, new xih(this));
    this.bw.put(52, new xii(this));
    this.bw.put(58, new xik(this));
    this.bw.put(57, new xil(this));
    this.bw.put(63, new xim(this));
    this.bw.put(64, new xin(this));
    this.bw.put(67, new xio(this));
    this.bw.put(89, new xip(this));
    this.bw.put(77, new xiq(this));
    this.bw.put(68, new xir(this));
    this.bw.put(71, new xis(this));
    this.bw.put(84, new xit(this));
    this.bw.put(73, new xek(this));
    this.bw.put(78, new xel(this));
    this.bw.put(75, new xem(this));
    this.bw.put(80, new xen(this));
    this.bw.put(87, new xeo(this));
    this.bw.put(85, new xep(this));
    this.bw.put(93, new xeq(this));
    this.bw.put(102, new xer(this));
    this.bw.put(101, new xes(this));
    this.bw.put(104, new xet(this));
    this.bw.put(109, new xev(this));
    this.bw.put(110, new xew(this));
    this.bw.put(111, new xex(this));
    localObject = new xey(this);
    this.bw.put(19, localObject);
    this.bw.put(0, localObject);
    this.bw.put(115, new xez(this));
    this.bw.put(116, new xfa(this));
    this.bw.put(117, new xfb(this));
    this.mContext = paramContext;
    this.app = paramQQAppInterface;
    this.d = paramSessionInfo;
    this.jdField_e_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.a = paramBaseChatPie;
    this.bn = new HashSet();
  }
  
  public static int a(QQAppInterface paramQQAppInterface, @Nullable ChatMessage paramChatMessage)
  {
    int i;
    if (paramChatMessage == null)
    {
      QLog.e("ItemBuilderFactory", 1, "message is null");
      i = 0;
    }
    int j;
    do
    {
      return i;
      if (!f.containsKey(paramChatMessage.getClass())) {
        break;
      }
      j = ((xeh.b)f.get(paramChatMessage.getClass())).b(paramQQAppInterface, paramChatMessage);
      i = j;
    } while (j != -1);
    if (jdField_e_of_type_AndroidSupportV4UtilArrayMap.containsKey(paramChatMessage.getClass())) {
      return ((Integer)jdField_e_of_type_AndroidSupportV4UtilArrayMap.get(paramChatMessage.getClass())).intValue();
    }
    return 0;
  }
  
  public wko a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ItemBuilderFactory", 2, "findItemBuilder: invoked. info: message = " + paramChatMessage);
    }
    int i = a(this.app, paramChatMessage);
    if (this.bw.get(i) != null) {
      return ((xeh.a)this.bw.get(i)).c(paramChatMessage, paramBaseAdapter);
    }
    return ((xeh.a)this.bw.get(0)).c(paramChatMessage, paramBaseAdapter);
  }
  
  protected wko a(wko paramwko, BaseAdapter paramBaseAdapter)
  {
    if (((paramwko instanceof BaseBubbleBuilder)) && ((paramBaseAdapter instanceof wki)))
    {
      paramBaseAdapter = (wki)paramBaseAdapter;
      ((BaseBubbleBuilder)paramwko).a(paramBaseAdapter.a);
    }
    this.bn.add(paramwko);
    return paramwko;
  }
  
  public void destroy()
  {
    Iterator localIterator = this.bn.iterator();
    while (localIterator.hasNext()) {
      ((wko)localIterator.next()).destroy();
    }
  }
  
  abstract class a<T extends wko>
  {
    private T a;
    
    private a() {}
    
    protected boolean Sy()
    {
      return true;
    }
    
    protected abstract T b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter);
    
    protected T c(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
    {
      if (this.a == null) {
        this.a = b(paramChatMessage, paramBaseAdapter);
      }
      if (Sy()) {
        xeh.this.a(this.a, paramBaseAdapter);
      }
      return this.a;
    }
  }
  
  static abstract interface b
  {
    public abstract int b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xeh
 * JD-Core Version:    0.7.0.1
 */