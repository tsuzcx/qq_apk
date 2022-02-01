package com.tencent.mobileqq.structmsg;

import acfp;
import akum;
import anbk;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anqu;
import anre;
import anrf;
import anrg;
import ansf;
import ansi;
import aoiz;
import aoop;
import aqgb;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.QQPlayerService.c;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import java.util.Date;
import ocp;
import wja;
import wlz;

public class StructMsgForAudioShare
  extends AbsShareMsg
  implements QQPlayerService.c
{
  private static View.OnClickListener fM = new anrf();
  private WeakReference<URLImageView> mCoverImage;
  private boolean mIsShowCommentLayout;
  private View.OnClickListener musicShareCoverClikListener = new anrg(this);
  
  public StructMsgForAudioShare()
  {
    this.mMsgServiceID = 2;
  }
  
  public StructMsgForAudioShare(Bundle paramBundle)
  {
    super(paramBundle);
    this.mContentSrc = paramBundle.getString("audio_url");
    this.mContentLayout = 2;
    this.mMsgServiceID = 2;
    this.mMsgAction = "web";
  }
  
  public StructMsgForAudioShare(ansf paramansf)
  {
    super(paramansf);
    this.mMsgServiceID = 2;
  }
  
  public static StructMsgForAudioShare getTestObj()
  {
    StructMsgForAudioShare localStructMsgForAudioShare = new StructMsgForAudioShare();
    localStructMsgForAudioShare.mMsgServiceID = 2;
    localStructMsgForAudioShare.fwFlag = 0;
    localStructMsgForAudioShare.mContentCover = "https://url.cn/R3i1JD";
    localStructMsgForAudioShare.mContentLayout = 2;
    localStructMsgForAudioShare.mContentSrc = "https://url.cn/JpkdzT";
    localStructMsgForAudioShare.mContentSummary = acfp.m(2131715020);
    localStructMsgForAudioShare.mContentTitle = (acfp.m(2131715023) + new Date());
    localStructMsgForAudioShare.mMsgUrl = "https://y.qq.com/i/song.html?songid=625023&source=qq";
    localStructMsgForAudioShare.mSourceName = "QQ音乐";
    localStructMsgForAudioShare.mMsgBrief = acfp.m(2131715032);
    localStructMsgForAudioShare.mMsgAction = "web";
    localStructMsgForAudioShare.mMsgActionData = "y.qq.com";
    localStructMsgForAudioShare.mMsg_A_ActionData = "com.tencent.qqmusic";
    localStructMsgForAudioShare.mSource_I_ActionData = "tencent100497308://";
    localStructMsgForAudioShare.mSourceAction = "app";
    localStructMsgForAudioShare.mMsgTemplateID = 1;
    localStructMsgForAudioShare.mSourceAppid = 100497308L;
    localStructMsgForAudioShare.mSourceUrl = "https://web.p.qq.com/qqmpmobile/aio/app.html?id=100497308";
    localStructMsgForAudioShare.mSourceIcon = "https://p.qpic.cn/qqconnect_app_logo/1LlgQzJVOyA9xucianwgfHru8JA97ERytRa0lHcRRGGw/0";
    return localStructMsgForAudioShare;
  }
  
  public static void onClickEvent(Context paramContext, StructMsgForAudioShare paramStructMsgForAudioShare)
  {
    int j = 1;
    if ("web".equals(paramStructMsgForAudioShare.mMsgAction))
    {
      akum.b().sourceType = 1;
      Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
      localIntent.putExtra("big_brother_source_key", "biz_src_jc_aio");
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", paramStructMsgForAudioShare.mMsgUrl);
      localIntent.putExtra("param_force_internal_browser", true);
      localIntent.putExtra("isAppShare", true);
      localIntent.putExtra("appShareID", aqgb.W(paramStructMsgForAudioShare.mSourceAppid));
      paramContext.sendBroadcast(new Intent("qqplayer_exit_action"));
      ocp.a(paramStructMsgForAudioShare.message, localIntent, paramStructMsgForAudioShare.mMsgUrl);
      paramContext.startActivity(localIntent);
      anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramStructMsgForAudioShare.mMsgUrl, "", "", "");
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {}
      for (i = j;; i = 0)
      {
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForAudioShare.uin, "0X80055C7", "0X80055C7", 0, i, "" + paramStructMsgForAudioShare.msgId, paramStructMsgForAudioShare.templateIDForPortal, "", paramStructMsgForAudioShare.mMsgUrl);
        paramContext = new StringBuilder().append("MSGID=").append(Long.toString(paramStructMsgForAudioShare.msgId)).append(";TEPLATEID=").append(paramStructMsgForAudioShare.templateIDForPortal).append(";ARTICALID=").append("").append(";REFERRER=").append(anqu.nH(paramStructMsgForAudioShare.mMsgUrl));
        anot.a(null, "P_CliOper", "Pb_account_lifeservice", paramStructMsgForAudioShare.uin, "0X8005D49", "0X8005D49", 0, i, paramContext.toString(), "", "", "");
        return;
      }
    }
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return fM;
  }
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    ImageView localImageView;
    Object localObject;
    TextView localTextView;
    String str1;
    if (paramView != null)
    {
      localImageView = (ImageView)paramView.findViewById(2131369004);
      localObject = (TextView)paramView.findViewById(2131380976);
      localTextView = (TextView)paramView.findViewById(2131380951);
      str1 = this.mContentCover;
      String str2 = this.mContentTitle;
      String str3 = this.mContentSummary;
      ((TextView)localObject).setText(str2);
      localTextView.setText(str3);
      if (TextUtils.isEmpty(str2)) {
        break label158;
      }
      localTextView.setMaxLines(2);
      ((TextView)localObject).setVisibility(0);
      label92:
      if (!TextUtils.isEmpty(str3)) {
        break label174;
      }
    }
    label158:
    label174:
    for (int i = 3;; i = 2)
    {
      ((TextView)localObject).setMaxLines(i);
      localObject = paramContext.getResources().getDrawable(2130851475);
      localImageView.setBackgroundDrawable(null);
      if (!TextUtils.isEmpty(str1)) {
        break label179;
      }
      localImageView.setImageDrawable((Drawable)localObject);
      return paramView;
      paramView = LayoutInflater.from(paramContext).inflate(2131563122, null);
      break;
      ((TextView)localObject).setVisibility(8);
      localTextView.setMaxLines(4);
      break label92;
    }
    label179:
    if ((!str1.startsWith("http://")) && (!str1.startsWith("https://"))) {}
    for (paramContext = Uri.fromFile(new File(str1)).toString();; paramContext = str1)
    {
      localImageView.setImageDrawable(URLDrawable.getDrawable(paramContext, (Drawable)localObject, (Drawable)localObject));
      return paramView;
    }
  }
  
  public String getToken()
  {
    return QQPlayerService.I(1, String.valueOf(this.uniseq));
  }
  
  public View getView(Context paramContext, View paramView, wlz paramwlz, Bundle paramBundle)
  {
    if (this.mMsgException)
    {
      paramContext = getVersionExceptionView(paramContext, paramView, paramwlz, paramBundle);
      paramContext.setId(2131378856);
      paramContext.setTag(2131378856, this);
      return paramContext;
    }
    paramBundle = paramContext.getResources();
    paramView = LayoutInflater.from(paramContext).inflate(2131563119, null);
    paramwlz = (URLImageView)paramView.findViewById(2131369004);
    this.mCoverImage = new WeakReference(paramwlz);
    Object localObject1 = (TextView)paramView.findViewById(2131380976);
    Object localObject2 = (TextView)paramView.findViewById(2131380951);
    ((TextView)localObject1).setText(this.mContentTitle);
    ((TextView)localObject2).setText(this.mContentSummary);
    int i;
    if (!TextUtils.isEmpty(this.mContentTitle))
    {
      ((TextView)localObject2).setMaxLines(2);
      ((TextView)localObject1).setVisibility(0);
      if (!TextUtils.isEmpty(this.mContentSummary)) {
        break label344;
      }
      i = 3;
      label151:
      ((TextView)localObject1).setMaxLines(i);
      paramwlz.setVisibility(0);
      if (!QQPlayerService.a(this)) {
        break label350;
      }
      paramwlz.setImageResource(2130846331);
      paramwlz.setContentDescription(paramBundle.getString(2131690640));
      label189:
      if (TextUtils.isEmpty(this.mContentCover)) {
        break label418;
      }
      localObject1 = this.mContentCover;
      localObject2 = paramBundle.getDrawable(2130851475);
    }
    for (;;)
    {
      try
      {
        i = wja.dp2px(70.0F, paramBundle);
        paramBundle = URLDrawable.getDrawable((String)localObject1, i, i, (Drawable)localObject2, (Drawable)localObject2);
        if (aoiz.hasFile((String)localObject1)) {
          break label444;
        }
        if (aoop.bD(paramContext)) {
          continue;
        }
      }
      catch (Exception paramContext)
      {
        label344:
        label350:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AudioShareMsg", 2, "getView " + paramContext.getMessage());
        continue;
      }
      paramBundle.setAutoDownload(bool);
      paramwlz.setBackgroundDrawable(paramBundle);
      paramContext = paramView.getLayoutParams();
      if (paramContext == null)
      {
        paramContext = new RelativeLayout.LayoutParams(BaseChatItemLayout.bOj, -2);
        paramView.setLayoutParams(paramContext);
        paramwlz.setTag(this);
        paramwlz.setOnClickListener(this.musicShareCoverClikListener);
        paramView.setId(2131378856);
        paramView.setTag(2131378856, this);
        return paramView;
        ((TextView)localObject1).setVisibility(8);
        ((TextView)localObject2).setMaxLines(4);
        break;
        i = 2;
        break label151;
        paramwlz.setImageResource(2130846330);
        paramwlz.setContentDescription(paramBundle.getString(2131690638));
        break label189;
        bool = false;
        continue;
        label418:
        paramwlz.setBackgroundResource(2130851475);
        continue;
      }
      paramContext.width = BaseChatItemLayout.bOj;
      paramContext.height = -2;
      continue;
      label444:
      boolean bool = true;
    }
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo) {}
  
  public void onPlayStateChanged(int paramInt)
  {
    if ((this.mCoverImage == null) || (this.mCoverImage.get() == null)) {
      return;
    }
    URLImageView localURLImageView = (URLImageView)this.mCoverImage.get();
    Resources localResources = localURLImageView.getContext().getResources();
    if ((paramInt == 2) || (paramInt == 1))
    {
      localURLImageView.post(new StructMsgForAudioShare.3(this, localURLImageView));
      localURLImageView.setContentDescription(localResources.getString(2131690640));
      return;
    }
    localURLImageView.post(new StructMsgForAudioShare.4(this, localURLImageView));
    localURLImageView.setContentDescription(localResources.getString(2131690638));
  }
  
  protected boolean parseContentNode(ansf paramansf)
  {
    if (paramansf == null) {}
    do
    {
      do
      {
        return true;
        this.mContentLayout = ansi.getIntValue(paramansf.getAttribute("layout"));
      } while ((paramansf == null) || (paramansf.Ks() < 3));
      ansf localansf = paramansf.a(0);
      if (localansf != null)
      {
        this.mContentCover = localansf.getAttribute("cover");
        this.mContentSrc = localansf.getAttribute("src");
      }
      localansf = paramansf.a(1);
      if (localansf != null) {
        this.mContentTitle = anbk.w(anre.a(localansf), false);
      }
      paramansf = paramansf.a(2);
    } while (paramansf == null);
    this.mContentSummary = anbk.w(anre.a(paramansf), false);
    return true;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException
  {
    try
    {
      int i = paramObjectInput.readInt();
      this.mVersion = i;
      if (i == 1)
      {
        this.mMsgTemplateID = paramObjectInput.readInt();
        this.mMsgAction = paramObjectInput.readUTF();
        this.mMsgActionData = paramObjectInput.readUTF();
        this.mMsg_A_ActionData = paramObjectInput.readUTF();
        this.mMsg_I_ActionData = paramObjectInput.readUTF();
        this.mMsgUrl = paramObjectInput.readUTF();
        this.mMsgBrief = paramObjectInput.readUTF();
        this.mContentLayout = paramObjectInput.readInt();
        this.mContentCover = paramObjectInput.readUTF();
        this.mContentSrc = paramObjectInput.readUTF();
        this.mContentTitle = paramObjectInput.readUTF();
        this.mContentSummary = paramObjectInput.readUTF();
        this.mSourceAppid = paramObjectInput.readLong();
        this.mSourceIcon = paramObjectInput.readUTF();
        this.mSourceName = paramObjectInput.readUTF();
        this.mSourceUrl = paramObjectInput.readUTF();
        this.mSourceAction = paramObjectInput.readUTF();
        this.mSourceActionData = paramObjectInput.readUTF();
        this.mSource_A_ActionData = paramObjectInput.readUTF();
        this.mSource_I_ActionData = paramObjectInput.readUTF();
        this.fwFlag = paramObjectInput.readInt();
        if ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon))) {
          this.mHasSource = true;
        }
      }
      else if (i >= 2)
      {
        this.mMsgTemplateID = paramObjectInput.readInt();
        this.mMsgAction = paramObjectInput.readUTF();
        this.mMsgActionData = paramObjectInput.readUTF();
        this.mMsg_A_ActionData = paramObjectInput.readUTF();
        this.mMsg_I_ActionData = paramObjectInput.readUTF();
        this.mMsgUrl = paramObjectInput.readUTF();
        this.mMsgBrief = paramObjectInput.readUTF();
        this.mContentLayout = paramObjectInput.readInt();
        this.mContentCover = paramObjectInput.readUTF();
        this.mContentSrc = paramObjectInput.readUTF();
        this.mContentTitle = paramObjectInput.readUTF();
        this.mContentSummary = paramObjectInput.readUTF();
        this.mSourceAppid = paramObjectInput.readLong();
        this.mSourceIcon = paramObjectInput.readUTF();
        this.mSourceName = paramObjectInput.readUTF();
        this.mSourceUrl = paramObjectInput.readUTF();
        this.mSourceAction = paramObjectInput.readUTF();
        this.mSourceActionData = paramObjectInput.readUTF();
        this.mSource_A_ActionData = paramObjectInput.readUTF();
        this.mSource_I_ActionData = paramObjectInput.readUTF();
        this.fwFlag = paramObjectInput.readInt();
        this.mFlag = paramObjectInput.readInt();
        this.mHasSource = paramObjectInput.readBoolean();
        this.mCommentText = paramObjectInput.readUTF();
        if (i >= 3)
        {
          this.mCompatibleText = paramObjectInput.readUTF();
          this.msgId = paramObjectInput.readLong();
          this.mPromotionType = paramObjectInput.readInt();
          this.mPromotionMsg = paramObjectInput.readUTF();
          this.mPromotionMenus = paramObjectInput.readUTF();
          this.mPromotionMenuDestructiveIndex = paramObjectInput.readInt();
          if (i >= 5)
          {
            this.source_puin = paramObjectInput.readUTF();
            if (i >= 7)
            {
              this.adverSign = paramObjectInput.readInt();
              this.adverKey = paramObjectInput.readUTF();
              this.index = paramObjectInput.readUTF();
              this.index_name = paramObjectInput.readUTF();
              this.index_type = paramObjectInput.readUTF();
              if (i >= 15)
              {
                this.forwardType = paramObjectInput.readInt();
                this.shareData.readExternal(paramObjectInput);
                if (i >= 16) {}
              }
            }
          }
        }
      }
      else
      {
        this.mMsgException = true;
        return;
      }
    }
    catch (IOException paramObjectInput)
    {
      if ((paramObjectInput.getMessage() != null) && (paramObjectInput.getMessage().equals("structmsg_version_error"))) {
        this.mMsgException = true;
      }
    }
  }
  
  public void report(Object paramObject)
  {
    anot.a(null, "dc00898", "", "", "0X800A62F", "0X800A62F", 0, 0, "2", ForwardUtils.cy(this.uinType), this.mContentTitle, "");
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, new Object[] { "音乐曝光=0X800A62F, type=", "2", ", title=", this.mContentTitle, ", uinType=", ForwardUtils.cy(this.uinType) });
    }
  }
  
  protected void toContentXml(AbsStructMsg.a parama)
    throws IOException
  {
    parama.startTag(null, "item");
    parama.attribute(null, "layout", String.valueOf(this.mContentLayout));
    parama.startTag(null, "audio");
    if (this.mContentCover == null)
    {
      str = "";
      parama.attribute(null, "cover", str);
      if (this.mContentSrc != null) {
        break label169;
      }
      str = "";
      label64:
      parama.attribute(null, "src", str);
      parama.endTag(null, "audio");
      parama.startTag(null, "title");
      if (this.mContentTitle != null) {
        break label177;
      }
      str = "";
      label102:
      parama.text(str);
      parama.endTag(null, "title");
      parama.startTag(null, "summary");
      if (this.mContentSummary != null) {
        break label185;
      }
    }
    label169:
    label177:
    label185:
    for (String str = "";; str = this.mContentSummary)
    {
      parama.text(str);
      parama.endTag(null, "summary");
      parama.endTag(null, "item");
      return;
      str = this.mContentCover;
      break;
      str = this.mContentSrc;
      break label64;
      str = this.mContentTitle;
      break label102;
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mMsgTemplateID);
    if (this.mMsgAction == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsgActionData != null) {
        break label606;
      }
      str = "";
      label57:
      paramObjectOutput.writeUTF(str);
      if (this.mMsg_A_ActionData != null) {
        break label614;
      }
      str = "";
      label74:
      paramObjectOutput.writeUTF(str);
      if (this.mMsg_I_ActionData != null) {
        break label622;
      }
      str = "";
      label91:
      paramObjectOutput.writeUTF(str);
      if (this.mMsgUrl != null) {
        break label630;
      }
      str = "";
      label108:
      paramObjectOutput.writeUTF(str);
      if (this.mMsgBrief != null) {
        break label638;
      }
      str = "";
      label125:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.mContentLayout);
      if (this.mContentCover != null) {
        break label646;
      }
      str = "";
      label152:
      paramObjectOutput.writeUTF(str);
      if (this.mContentSrc != null) {
        break label654;
      }
      str = "";
      label169:
      paramObjectOutput.writeUTF(str);
      if (this.mContentTitle != null) {
        break label662;
      }
      str = "";
      label186:
      paramObjectOutput.writeUTF(str);
      if (this.mContentSummary != null) {
        break label674;
      }
      str = "";
      label203:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.mSourceAppid);
      if (this.mSourceIcon != null) {
        break label686;
      }
      str = "";
      label230:
      paramObjectOutput.writeUTF(str);
      if (this.mSourceName != null) {
        break label694;
      }
      str = "";
      label247:
      paramObjectOutput.writeUTF(str);
      if (this.mSourceUrl != null) {
        break label702;
      }
      str = "";
      label264:
      paramObjectOutput.writeUTF(str);
      if (this.mSourceAction != null) {
        break label710;
      }
      str = "";
      label281:
      paramObjectOutput.writeUTF(str);
      if (this.mSourceActionData != null) {
        break label718;
      }
      str = "";
      label298:
      paramObjectOutput.writeUTF(str);
      if (this.mSource_A_ActionData != null) {
        break label726;
      }
      str = "";
      label315:
      paramObjectOutput.writeUTF(str);
      if (this.mSource_I_ActionData != null) {
        break label734;
      }
      str = "";
      label332:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.fwFlag);
      paramObjectOutput.writeInt(this.mFlag);
      paramObjectOutput.writeBoolean(this.mHasSource);
      if (this.mCommentText != null) {
        break label742;
      }
      str = "";
      label379:
      paramObjectOutput.writeUTF(str);
      if (this.mCompatibleText != null) {
        break label750;
      }
      str = "";
      label396:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.msgId);
      paramObjectOutput.writeInt(this.mPromotionType);
      if (this.mPromotionMsg != null) {
        break label758;
      }
      str = "";
      label433:
      paramObjectOutput.writeUTF(str);
      if (this.mPromotionMenus != null) {
        break label766;
      }
      str = "";
      label450:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
      if (this.source_puin != null) {
        break label774;
      }
      str = "";
      label477:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.adverSign);
      if (this.adverKey != null) {
        break label782;
      }
      str = "";
      label504:
      paramObjectOutput.writeUTF(str);
      if (this.index != null) {
        break label790;
      }
      str = "";
      label521:
      paramObjectOutput.writeUTF(str);
      if (this.index_name != null) {
        break label798;
      }
      str = "";
      label538:
      paramObjectOutput.writeUTF(str);
      if (this.index_type != null) {
        break label806;
      }
      str = "";
      label555:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.forwardType);
      this.shareData.writeExternal(paramObjectOutput);
      if (this.mCommonData != null) {
        break label814;
      }
    }
    label646:
    label654:
    label662:
    label674:
    label806:
    label814:
    for (String str = "";; str = this.mCommonData)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.mMsgAction;
      break;
      label606:
      str = this.mMsgActionData;
      break label57;
      label614:
      str = this.mMsg_A_ActionData;
      break label74;
      label622:
      str = this.mMsg_I_ActionData;
      break label91;
      label630:
      str = this.mMsgUrl;
      break label108;
      label638:
      str = this.mMsgBrief;
      break label125;
      str = this.mContentCover;
      break label152;
      str = this.mContentSrc;
      break label169;
      str = anbk.w(this.mContentTitle, false);
      break label186;
      str = anbk.w(this.mContentSummary, false);
      break label203;
      label686:
      str = this.mSourceIcon;
      break label230;
      label694:
      str = this.mSourceName;
      break label247;
      label702:
      str = this.mSourceUrl;
      break label264;
      label710:
      str = this.mSourceAction;
      break label281;
      label718:
      str = this.mSourceActionData;
      break label298;
      label726:
      str = this.mSource_A_ActionData;
      break label315;
      label734:
      str = this.mSource_I_ActionData;
      break label332;
      label742:
      str = this.mCommentText;
      break label379;
      label750:
      str = this.mCompatibleText;
      break label396;
      label758:
      str = this.mPromotionMsg;
      break label433;
      label766:
      str = this.mPromotionMenus;
      break label450;
      str = this.source_puin;
      break label477;
      str = this.adverKey;
      break label504;
      str = this.index;
      break label521;
      str = this.index_name;
      break label538;
      str = this.index_type;
      break label555;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForAudioShare
 * JD-Core Version:    0.7.0.1
 */