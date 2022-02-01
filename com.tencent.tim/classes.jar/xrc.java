import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.h;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class xrc
  extends BaseBubbleBuilder
{
  private static final int bTs = BaseChatItemLayout.bNV + BaseChatItemLayout.bOa;
  private static final int bTt = BaseChatItemLayout.bNW + BaseChatItemLayout.bOb;
  private static final int bTu = BaseChatItemLayout.bNX + BaseChatItemLayout.bOc;
  private static final int bTv = BaseChatItemLayout.bNY + BaseChatItemLayout.bOd;
  private boolean big = true;
  private View.OnClickListener onClickListener = new xrd(this);
  
  public xrc(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt, boolean paramBoolean)
  {
    QLog.w("ChatItemBuilder", 1, "qqVideo_group, avType[" + paramInt + "], isVideo[" + paramBoolean + "]");
    if (paramInt == 2)
    {
      localObject = new HashMap();
      ((Map)localObject).put("MultiAVType", String.valueOf(paramInt));
      ((Map)localObject).put("from", "itemBuilder");
      ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.cZ, paramSessionInfo.aTl, (Map)localObject);
      long l = Long.valueOf(paramSessionInfo.aTl).longValue();
      if (paramSessionInfo.cZ == 3000) {
        if (paramQQAppInterface.a().bG() != l) {
          anot.a(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_disobj_launch", 0, 0, "", "", "", "");
        }
      }
      while ((paramSessionInfo.cZ != 1) || (paramQQAppInterface.a().j(1, l))) {
        return;
      }
      if (paramInt == 10)
      {
        if (paramQQAppInterface.a().bG() == 0L)
        {
          paramContext = paramQQAppInterface.a().a(l, 10);
          if ((paramContext == null) || (paramContext.memberNum <= 0)) {
            break label242;
          }
        }
        for (;;)
        {
          anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005DC6", "0X8005DC6", 0, 0, "", "", "", "");
          return;
          label242:
          anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005925", "0X8005925", 0, 0, "", "", "", "");
        }
      }
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X80046CB", "0X80046CB", 0, 0, "", "", "", "");
      return;
    }
    boolean bool = aqji.a("qqVideoEx", paramQQAppInterface, paramSessionInfo.aTl);
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("MultiAVType", paramInt);
    ((Bundle)localObject).putBoolean("enableInvite", bool);
    ((Bundle)localObject).putBoolean("isVideo", paramBoolean);
    ChatActivityUtils.a(paramQQAppInterface, paramContext, paramSessionInfo.cZ, paramSessionInfo.aTl, true, true, null, (Bundle)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, int paramInt, boolean paramBoolean, String paramString1, String paramString2)
  {
    long l1 = AudioHelper.hG();
    int j = paramSessionInfo.cZ;
    String str = paramSessionInfo.aTl;
    long l2 = alkt.getLong(str);
    QLog.w("ChatItemBuilder", 1, "showGroupQavActionSheet, avType[" + paramInt + "], isVideo[" + paramBoolean + "], msgSelfUin[" + paramString1 + "], uinType[" + j + "], groupId[" + str + "], curFriendNick[" + paramSessionInfo.aTn + "], troopUin[" + paramSessionInfo.troopUin + "], fromWhere[" + paramString2 + "], isVideoActionSheetShown[" + jln.xR() + "], seq[" + l1 + "]");
    if (10 == paramInt)
    {
      i = 0;
      boolean bool = false;
      paramString1 = paramQQAppInterface.a().a(l2, paramInt);
      if ((paramString1 == null) || (paramString1.memberNum <= 0))
      {
        paramString1 = aqji.b(paramQQAppInterface, str);
        bool = paramString1.getBoolean("forceDisableInviteBox");
        i = paramString1.getInt("errId", 2131697826);
      }
      if (bool) {
        aqha.a(paramContext, 230, null, paramContext.getResources().getString(i), 2131697614, 2131721737, new xre(), null).show();
      }
    }
    while (paramQQAppInterface.a().a(paramContext, paramSessionInfo.cZ, paramSessionInfo.aTl, paramBoolean)) {
      return;
    }
    if (AudioHelper.jY(19) == 1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        AudioHelper.UA(acfp.m(2131716412));
      }
      if ((!paramQQAppInterface.a().e(l1, str)) && (i == 0)) {
        break;
      }
      paramSessionInfo = new Bundle();
      paramSessionInfo.putInt("MultiAVType", jll.cK(j));
      if (paramBoolean) {
        paramSessionInfo.putBoolean("isVideo", true);
      }
      if (j == 1) {
        paramSessionInfo.putBoolean("enableInvite", aqji.a("showGroupQavActionSheet", paramQQAppInterface, str));
      }
      paramSessionInfo.putString("Fromwhere", paramString2);
      ChatActivityUtils.a(paramQQAppInterface, paramContext, j, str, true, true, null, paramSessionInfo);
      return;
    }
    paramString1 = paramQQAppInterface.a().a(alkt.getLong(str));
    if ((paramString1 == null) || (paramString1.aqy != paramInt))
    {
      VideoMsgTools.a(paramQQAppInterface, paramContext, j, str, paramSessionInfo.aTn, paramBoolean, paramString2);
      return;
    }
    if ((paramString1 != null) && (paramString1.aqy == 2) && (paramString1.ang == 2) && (paramString1.gameId == 4)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      VideoStatusTipsBar.a(paramQQAppInterface, paramContext, j, str, paramInt, paramBoolean, paramString2);
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, MessageForVideo paramMessageForVideo)
  {
    if ((!imm.isSupportSharpAudio()) || (jln.xR())) {
      return;
    }
    if (paramMessageForVideo.type == 13) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label77;
      }
      i = paramMessageForVideo.istroop;
      if ((i != 1) && (i != 3000)) {
        break;
      }
      a(paramQQAppInterface, paramContext, paramSessionInfo, paramMessageForVideo.extInt, paramMessageForVideo.isVideo, paramMessageForVideo.selfuin, "");
      return;
    }
    label77:
    b(paramQQAppInterface, paramSessionInfo, paramMessageForVideo.isVideo, paramMessageForVideo.type);
    if (paramMessageForVideo.isVideo)
    {
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005642", "0X8005642", 0, 0, "", "", "", "");
      return;
    }
    anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005243", "0X8005243", 0, 0, "", "", "", "");
  }
  
  static void a(QQAppInterface paramQQAppInterface, Context paramContext, MessageForVideo paramMessageForVideo, SessionInfo paramSessionInfo)
  {
    wja.bcO = true;
    if (imm.isSupportSharpAudio())
    {
      a(paramQQAppInterface, paramMessageForVideo, paramSessionInfo);
      if ((paramSessionInfo.cZ != 1) || (paramMessageForVideo.extInt == 10)) {}
    }
    else
    {
      try
      {
        l = Long.parseLong(paramSessionInfo.aTl);
        i = jll.cL(paramSessionInfo.cZ);
        l = paramQQAppInterface.a().d(i, l);
        Object localObject = (apsw)paramQQAppInterface.getManager(48);
        bool1 = ((apsw)localObject).bg(paramSessionInfo.aTl, paramQQAppInterface.getCurrentAccountUin());
        boolean bool2 = ((apsw)localObject).hs(paramSessionInfo.aTl);
        boolean bool3 = ((apsw)localObject).eL(paramSessionInfo.aTl);
        localObject = ((apsw)localObject).a(paramSessionInfo.aTl);
        if ((l == 0L) && (((!bool3) && (bool1)) || ((!bool2) && (localObject != null) && (((apsw.f)localObject).gagTimeStamp > 0L))))
        {
          QQToast.a(paramQQAppInterface.getApp(), acfp.m(2131716411), 0).show(paramQQAppInterface.getApp().getResources().getDimensionPixelSize(2131299627));
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          long l = 0L;
        }
        int i = paramMessageForVideo.extInt;
        boolean bool1 = paramMessageForVideo.isVideo;
        if (i == 2)
        {
          QQToast.a(paramQQAppInterface.getApp(), acfp.m(2131700838), 0).show(paramQQAppInterface.getApp().getResources().getDimensionPixelSize(2131299627));
          return;
        }
        a(paramQQAppInterface, paramContext, paramSessionInfo, i, bool1);
        return;
      }
    }
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramMessageForVideo);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, int paramInt)
  {
    String str1;
    String str2;
    if (!paramBoolean)
    {
      str1 = "Two_call";
      str2 = "Two_call_launch";
      switch (paramSessionInfo.cZ)
      {
      default: 
        paramSessionInfo = "0";
        label72:
        anot.a(paramQQAppInterface, "CliOper", "", "", str1, str2, 0, 0, paramSessionInfo, "", "", "");
        if (paramInt == 2) {
          anot.a(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "2", "", "", "");
        }
        break;
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        break label238;
      }
      anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005643", "0X8005643", 0, 0, "", "", "", "");
      return;
      str1 = "Two_video_call";
      str2 = "Two_video_call_launch";
      break;
      paramSessionInfo = "0";
      break label72;
      paramSessionInfo = "1";
      break label72;
      paramSessionInfo = "2";
      break label72;
      paramSessionInfo = "3";
      break label72;
      paramSessionInfo = "4";
      break label72;
      if (paramInt == 0) {
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "2", "", "", "");
      }
    }
    label238:
    anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005244", "0X8005244", 0, 0, "", "", "", "");
  }
  
  static void a(QQAppInterface paramQQAppInterface, MessageForVideo paramMessageForVideo, SessionInfo paramSessionInfo)
  {
    int i = paramMessageForVideo.istroop;
    if (paramMessageForVideo.type == 13)
    {
      if (i != 3000) {
        break label123;
      }
      anot.a(paramQQAppInterface, "CliOper", "", "", "Multi_call", "Multi_call_disobj", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if ((paramMessageForVideo.type == 2) || (paramMessageForVideo.type == 24)) {
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X8004009", "", 0, 0, "1", "", "", "");
      }
      if (paramMessageForVideo.type == 0) {
        anot.a(paramQQAppInterface, "CliOper", "", "", "0X800400A", "", 0, 0, "1", "", "", "");
      }
      return;
      label123:
      if (i == 1) {
        if (paramMessageForVideo.extInt == 10) {
          anot.a(paramQQAppInterface, "CliOper", "", "", "0X8005924", "0X8005924", 0, 0, "", "", "", "");
        } else {
          anot.a(null, "dc00899", "Grp_video", "", "notice", "video", 0, 0, paramSessionInfo.aTl, "" + apuh.n(paramQQAppInterface, paramSessionInfo.aTl), "0", "");
        }
      }
    }
  }
  
  private void a(MessageForVideo paramMessageForVideo, Context paramContext, View paramView)
  {
    Object localObject1 = "";
    if (paramMessageForVideo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "setMsgAccDescription-->message is null");
      }
    }
    do
    {
      return;
      if ((paramMessageForVideo.senderuin != null) && (paramMessageForVideo.selfuin != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ChatItemBuilder", 2, "setMsgAccDescription-->uin is null");
    return;
    int i;
    if (paramMessageForVideo.selfuin.equals(paramMessageForVideo.senderuin))
    {
      if (-2016 == paramMessageForVideo.msgtype) {
        localObject1 = acfp.m(2131716405);
      }
      Object localObject2 = localObject1;
      if (paramMessageForVideo.msgtype == -2009)
      {
        localObject1 = new StringBuilder().append((String)localObject1);
        localObject2 = paramView.getResources();
        if (!paramMessageForVideo.isVideo) {
          break label259;
        }
        i = 2131721261;
        label132:
        localObject2 = ((Resources)localObject2).getString(i);
      }
      localObject1 = (String)localObject2 + paramMessageForVideo.text;
      if (!paramMessageForVideo.text.contains(paramContext.getResources().getString(2131721734))) {
        break label267;
      }
      localObject1 = (String)localObject1 + a(paramMessageForVideo, paramContext, paramView);
    }
    for (;;)
    {
      paramView.setContentDescription(((String)localObject1).replace(acfp.m(2131716413), acfp.m(2131716404)));
      return;
      localObject1 = aqgv.d(this.app, paramMessageForVideo.senderuin, 0);
      break;
      label259:
      i = 2131721239;
      break label132;
      label267:
      if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131721723)))
      {
        paramContext = paramContext.getResources();
        if (paramMessageForVideo.isVideo) {}
        for (i = 2131721740;; i = 2131690634)
        {
          localObject1 = paramContext.getString(i);
          break;
        }
      }
      if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131698176))) {
        localObject1 = paramContext.getResources().getString(2131719472);
      } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131698175))) {
        localObject1 = paramContext.getResources().getString(2131718835);
      } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131697569))) {
        localObject1 = paramContext.getResources().getString(2131719472);
      } else if (paramMessageForVideo.text.contains(paramContext.getResources().getString(2131697568))) {
        localObject1 = paramContext.getResources().getString(2131718835);
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean, int paramInt)
  {
    QLog.w("ChatItemBuilder", 1, "qqVideoEx, isVideo[" + paramBoolean + "], closeType[" + paramInt + "]");
    a(paramQQAppInterface, paramSessionInfo, paramBoolean, paramInt);
    paramInt = paramSessionInfo.cZ;
    String str3 = paramSessionInfo.aTn;
    String str2;
    String str1;
    BaseApplication localBaseApplication;
    if (paramInt == 1006)
    {
      str2 = paramSessionInfo.aTl;
      str1 = null;
      localBaseApplication = paramQQAppInterface.getApp();
      if (paramBoolean) {
        break label125;
      }
    }
    label125:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ChatActivityUtils.a(paramQQAppInterface, localBaseApplication, paramInt, str1, str3, str2, paramBoolean, paramSessionInfo.troopUin, true, true, null, "from_internal");
      return;
      str1 = paramSessionInfo.aTl;
      str2 = null;
      break;
    }
  }
  
  private void c(TextView paramTextView, int paramInt)
  {
    Resources localResources = this.mContext.getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt);
    int i = localDrawable.getIntrinsicWidth();
    int j = localDrawable.getIntrinsicHeight();
    switch (this.mContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0))
    {
    default: 
      paramInt = j;
    }
    for (;;)
    {
      localDrawable.setBounds(0, 0, i, paramInt);
      paramTextView.setCompoundDrawables(localDrawable, null, null, null);
      paramTextView.setCompoundDrawablePadding(BaseChatItemLayout.contentPadding);
      return;
      int k = localResources.getDimensionPixelSize(2131298061);
      int m = localResources.getDimensionPixelSize(2131298062);
      paramInt = k;
      if (k == 0) {
        paramInt = 1;
      }
      i = i * this.sessionInfo.cN / paramInt;
      paramInt = j * this.sessionInfo.cN / paramInt + m;
      i += m;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    xrc.a locala = (xrc.a)parame;
    paramBaseChatItemLayout = paramBaseChatItemLayout.getContext();
    Resources localResources = this.mContext.getResources();
    parame = paramView;
    if (paramView == null)
    {
      parame = new TextView(this.mContext);
      parame.setId(2131364506);
      parame.setTextColor(localResources.getColorStateList(2131167322));
      parame.setTextSize(localResources.getDimensionPixelOffset(2131296478));
      parame.setGravity(16);
      locala.mTextView = parame;
    }
    paramView = (MessageForVideo)paramChatMessage;
    int i = VideoMsgTools.a(paramBaseChatItemLayout, paramView.type, paramView.text, paramView.isVideo, paramChatMessage.isSendFromLocal());
    c(locala.mTextView, i);
    i = VideoMsgTools.a(paramBaseChatItemLayout, paramView.type, paramView.text, paramChatMessage.isSendFromLocal());
    locala.mTextView.setTextColor(localResources.getColor(i));
    locala.mTextView.setText(paramView.text);
    if ((paramView.istroop == 1) && (this.mContext.getResources().getString(2131697770).equals(paramView.text))) {
      anot.a(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, paramView.frienduin, "" + apuh.n(this.app, paramView.frienduin), "", "");
    }
    parame.setOnTouchListener(paramwlz);
    parame.setOnLongClickListener(paramwlz);
    parame.setOnClickListener(this.onClickListener);
    if (aTl) {
      a(paramView, paramBaseChatItemLayout, parame);
    }
    return parame;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xrc.a();
  }
  
  String a(MessageForVideo paramMessageForVideo, Context paramContext, View paramView)
  {
    int j = 0;
    Object localObject = "";
    String str2 = paramMessageForVideo.text;
    String str1 = paramContext.getResources().getString(2131721734) + ",";
    paramContext = str2.substring(str2.indexOf(':') - 2, str2.lastIndexOf(':') + 3).split(":");
    int k;
    int i;
    if (paramContext.length == 3)
    {
      k = Integer.valueOf(paramContext[0]).intValue();
      j = Integer.valueOf(paramContext[1]).intValue();
      i = Integer.valueOf(paramContext[2]).intValue();
    }
    for (;;)
    {
      if ((k <= 0) && (j <= 0))
      {
        paramContext = (Context)localObject;
        if (i <= 0) {}
      }
      else
      {
        if (k <= 0) {
          break label331;
        }
      }
      label331:
      for (localObject = str1 + k + acfp.m(2131716407);; localObject = str1)
      {
        paramContext = (Context)localObject;
        if (j > 0) {
          paramContext = (String)localObject + j + acfp.m(2131716409);
        }
        localObject = paramContext;
        if (i > 0) {
          localObject = paramContext + i + acfp.m(2131716408);
        }
        paramContext = paramView.getResources();
        if (paramMessageForVideo.isVideo) {}
        for (i = 2131721261;; i = 2131721239)
        {
          paramMessageForVideo = paramContext.getString(i);
          paramContext = paramMessageForVideo + (String)localObject;
          return paramContext;
          if (paramContext.length != 2) {
            break label338;
          }
          j = Integer.valueOf(paramContext[0]).intValue();
          i = Integer.valueOf(paramContext[1]).intValue();
          k = 0;
          break;
        }
      }
      label338:
      i = 0;
      k = 0;
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131365686)
    {
      ujt.b(this.mContext, this.app, paramChatMessage);
      return;
    }
    if (paramInt == 2131372073)
    {
      super.m(paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(bTv, bTs, bTu, bTt);
      return;
    }
    paramView.setPadding(bTu, bTs, bTv, bTt);
  }
  
  public void a(BaseBubbleBuilder.e parame, View paramView, ChatMessage paramChatMessage, adxp paramadxp)
  {
    xrc.a locala = (xrc.a)parame;
    locala.mTextView.setTextSize(0, this.sessionInfo.cN);
    if ((paramadxp.bubbleId == 0) || (!paramadxp.isLoaded()))
    {
      paramView = paramView.getResources();
      if (locala.mTextView.getText().toString().contains(this.mContext.getString(2131721720)))
      {
        parame = paramView.getColorStateList(2131166197);
        locala.mTextView.setTextColor(parame);
        return;
      }
      if (paramChatMessage.isSend())
      {
        parame = paramView.getColorStateList(2131167326);
        locala.mTextView.setTextColor(parame);
        if (!paramChatMessage.isSend()) {
          break label151;
        }
      }
      label151:
      for (parame = paramView.getColorStateList(2131167325);; parame = paramView.getColorStateList(2131167324))
      {
        locala.mTextView.setLinkTextColor(parame);
        return;
        parame = paramView.getColorStateList(2131167322);
        break;
      }
    }
    if (paramadxp.mTextColor == 0) {
      locala.mTextView.setTextColor(-16777216);
    }
    while (paramadxp.mLinkColor == 0)
    {
      locala.mTextView.setLinkTextColor(paramView.getResources().getColorStateList(2131167324));
      return;
      locala.mTextView.setTextColor(paramadxp.mTextColor);
    }
    locala.mTextView.setLinkTextColor(paramadxp.mLinkColor);
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    wja.a(paramView);
    ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
    super.c(localaqoa, this.mContext);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return acfp.m(2131716410);
  }
  
  public void zw(boolean paramBoolean)
  {
    this.big = paramBoolean;
  }
  
  class a
    extends BaseBubbleBuilder.e
  {
    TextView mTextView;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xrc
 * JD-Core Version:    0.7.0.1
 */