package com.tencent.mobileqq.activity.miniaio;

import acff;
import acfp;
import acle;
import acrb;
import ajlc;
import ajlg;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aofy;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jof;
import ku;
import mqq.os.MqqHandler;
import top;
import ujt;
import ujt.d;
import wja;
import wkj;
import wyv;
import zni;
import zos;

public class MiniMultiForwardFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  zni a;
  public boolean blg;
  ViewGroup cL;
  ChatXListView d;
  private int forwardType;
  RelativeLayout iA;
  QQAppInterface mApp;
  Context mContext;
  TextView mTitleText;
  private float rb = 0.78F;
  float rc = 0.86F;
  float rd = 16.0F;
  private SessionInfo sessionInfo = new SessionInfo();
  private long uniseq;
  
  private Intent a(Activity paramActivity)
  {
    return paramActivity.getIntent();
  }
  
  private Window a(Activity paramActivity)
  {
    return paramActivity.getWindow();
  }
  
  private WindowManager a(Activity paramActivity)
  {
    return paramActivity.getWindowManager();
  }
  
  private ArrayList<ChatMessage> aa(ArrayList<ChatMessage> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      int i = 0;
      if (i < paramArrayList.size())
      {
        Object localObject1 = (ChatMessage)paramArrayList.get(i);
        QLog.i("MiniMultiForwardPreviewFragment", 2, "generateFakeSeperateMsg  " + ((ChatMessage)localObject1).msgtype);
        label74:
        Object localObject2;
        if (!C((ChatMessage)localObject1))
        {
          localObject1 = c((ChatMessage)localObject1);
          if (localObject1 != null)
          {
            ((ChatMessage)localObject1).fakeSenderType = 1;
            ((ChatMessage)localObject1).saveExtInfoToExtStr("self_nickname", this.mApp.getCurrentNickname());
            if ((((ChatMessage)localObject1).msgtype == -1000) || (((ChatMessage)localObject1).msgtype == -1049))
            {
              localObject2 = ((acff)this.mApp.getManager(51)).a(this.mApp.getCurrentUin(), false);
              if (localObject2 != null)
              {
                ((ChatMessage)localObject1).saveExtInfoToExtStr("vip_font_id", String.valueOf(ku.a((ExtensionInfo)localObject2)));
                ((ChatMessage)localObject1).saveExtInfoToExtStr("vip_sub_font_id", String.valueOf(ku.d(((ExtensionInfo)localObject2).uVipFont)));
                if (1 != ((ExtensionInfo)localObject2).magicFont) {
                  break label415;
                }
                ((ChatMessage)localObject1).saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(0));
              }
            }
          }
        }
        for (;;)
        {
          localObject2 = (acle)this.mApp.getBusinessHandler(13);
          ((ChatMessage)localObject1).vipBubbleID = ((acle)localObject2).AS();
          ((ChatMessage)localObject1).vipBubbleDiyTextId = ((acle)localObject2).AV();
          ((acle)localObject2).W((MessageRecord)localObject1);
          if (jof.a((MessageRecord)localObject1)) {
            ((ChatMessage)localObject1).extLong &= 0xFFFFFFFC;
          }
          localArrayList.add(localObject1);
          i += 1;
          break;
          if (((ChatMessage)localObject1).msgtype == -1049)
          {
            localObject2 = (MessageForReplyText)localObject1;
            localObject1 = ((ChatMessage)localObject1).msg;
            ujt.d locald = new ujt.d();
            locald.aTw = true;
            locald.aTy = true;
            locald.mSourceMsgInfo = new MessageForReplyText.SourceMsgInfo(((MessageForReplyText)localObject2).mSourceMsgInfo);
            locald.mSourceMsgInfo.mSourceMsgTroopName = null;
            localObject1 = ujt.a(this.mApp, this.sessionInfo, (String)localObject1, null, locald);
            ((MessageForReplyText)localObject1).setSourceMessageRecord(((MessageForReplyText)localObject2).getSourceMessage());
            break label74;
          }
          localObject2 = ajlg.d(this.mApp, (MessageRecord)localObject1);
          localObject1 = (ChatMessage)this.mApp.a().a((MessageRecord)localObject1, (String)localObject2, false);
          ((ChatMessage)localObject1).setStatus(1000);
          ((ChatMessage)localObject1).msgData = ((ChatMessage)localObject1).msg.getBytes();
          break label74;
          label415:
          ((ChatMessage)localObject1).saveExtInfoToExtStr("vip_font_effect_id", String.valueOf(((ExtensionInfo)localObject2).fontEffect));
        }
      }
    }
    return localArrayList;
  }
  
  private ArrayList<ChatMessage> bZ()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    if (this.uniseq != 0L)
    {
      localObject1 = ajlc.a().a(this.mApp, this.uniseq);
      if (localObject1 != null)
      {
        i = 0;
        while (i < ((List)localObject1).size())
        {
          localObject2 = (ChatMessage)((List)localObject1).get(i);
          localObject3 = c((ChatMessage)localObject2);
          if (localObject3 != null)
          {
            QLog.i("MiniMultiForwardPreviewFragment", 2, "generateFakeCombineMsg s:" + this.uniseq + " : " + ((ChatMessage)localObject2).msgtype);
            ((ChatMessage)localObject3).fakeSenderType = 2;
            localArrayList.add(localObject3);
          }
          i += 1;
        }
      }
    }
    else
    {
      localObject3 = ajlc.a().xL;
      HashMap localHashMap = ajlc.a().lD;
      if (localObject3 != null)
      {
        i = 0;
        while (i < ((List)localObject3).size())
        {
          localObject1 = (ChatMessage)((List)localObject3).get(i);
          ChatMessage localChatMessage = c((ChatMessage)localObject1);
          if (localChatMessage != null)
          {
            QLog.i("MiniMultiForwardPreviewFragment", 2, "generateFakeCombineMsg   " + ((ChatMessage)localObject1).msgtype);
            localChatMessage.fakeSenderType = 2;
            localObject1 = "";
            if (localHashMap != null) {
              localObject1 = (String)localHashMap.get(top.g(localChatMessage));
            }
            localObject2 = localObject1;
            if (localChatMessage.istroop == 1)
            {
              localObject2 = localObject1;
              if (localObject1 != null) {
                localObject2 = aofy.oj((String)localObject1);
              }
            }
            localChatMessage.saveExtInfoToExtStr("self_nickname", (String)localObject2);
            localArrayList.add(localChatMessage);
          }
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  private void cqj()
  {
    Intent localIntent = getIntent();
    this.sessionInfo.aTl = localIntent.getStringExtra("uin");
    this.sessionInfo.cZ = localIntent.getIntExtra("uintype", -1);
    this.sessionInfo.aTn = localIntent.getStringExtra("uinname");
    this.sessionInfo.a = new wkj();
    this.sessionInfo.a.img = this.mContext.getResources().getDrawable(2130851037);
    this.sessionInfo.a.k = this.mContext.getResources().getColorStateList(2131165375);
    this.sessionInfo.cN = ChatTextSizeSettingActivity.ag(this.mContext);
    this.forwardType = localIntent.getIntExtra("multi_forward_type", 0);
    this.uniseq = localIntent.getLongExtra("structmsg_uniseq", 0L);
  }
  
  private void cqk()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniMultiForwardPreviewFragment", 2, "loadFirstData");
    }
    ThreadManager.excute(new MiniMultiForwardFragment.1(this), 16, null, true);
  }
  
  private void dl(ArrayList<ChatMessage> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QLog.e("MiniMultiForwardPreviewFragment", 2, "SetTitle With emptyMsg");
      return;
    }
    Object localObject2 = (ChatMessage)paramArrayList.get(0);
    if ((((ChatMessage)localObject2).istroop == 1) || (((ChatMessage)localObject2).istroop == 3000)) {
      paramArrayList = acfp.m(2131708442);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new MiniMultiForwardFragment.2(this, paramArrayList));
      return;
      if (((ChatMessage)localObject2).istroop == 0)
      {
        Object localObject1 = ((ChatMessage)localObject2).senderuin;
        Object localObject3 = ((ChatMessage)localObject2).getExtInfoFromExtStr("self_nickname");
        int i = 0;
        if (i < paramArrayList.size())
        {
          ChatMessage localChatMessage = (ChatMessage)paramArrayList.get(i);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localObject2 = localChatMessage.senderuin;
          }
          do
          {
            i += 1;
            localObject1 = localObject2;
            break;
            localObject2 = localObject1;
          } while (TextUtils.equals((CharSequence)localObject1, localChatMessage.senderuin));
          localObject2 = localChatMessage.senderuin;
          paramArrayList = localChatMessage.getExtInfoFromExtStr("self_nickname");
        }
        for (boolean bool = false;; bool = true)
        {
          if ((localObject3 == null) || (((String)localObject3).trim().length() == 0)) {}
          for (localObject1 = ajlg.me((String)localObject1);; localObject1 = localObject3)
          {
            if (paramArrayList != null)
            {
              localObject3 = paramArrayList;
              if (paramArrayList.trim().length() != 0) {}
            }
            else
            {
              localObject3 = paramArrayList;
              if (!bool) {
                localObject3 = ajlg.me((String)localObject2);
              }
            }
            paramArrayList = new Paint();
            paramArrayList.setTextSize(TypedValue.applyDimension(2, this.rd, this.mContext.getResources().getDisplayMetrics()));
            int j = a(getActivity()).getDefaultDisplay().getWidth() - wja.dp2px(80.0F, this.mContext.getResources());
            i = j;
            if (j < 300) {
              i = wja.dp2px(150.0F, this.mContext.getResources());
            }
            localObject1 = ujt.a(this.mContext, (String)localObject1, (String)localObject3, 1, i, 2048, paramArrayList, bool);
            paramArrayList = (ArrayList<ChatMessage>)localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            paramArrayList = acfp.m(2131708446);
            break;
          }
          paramArrayList = "";
          localObject2 = "";
        }
      }
      paramArrayList = "";
    }
  }
  
  private Intent getIntent()
  {
    return getActivity().getIntent();
  }
  
  private void initListView()
  {
    this.d = ((ChatXListView)this.cL.findViewById(2131371537));
    View localView = new View(this.mContext);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(2131299627)));
    localView.setId(2131362463);
    this.d.setStackFromBottom(false);
    this.d.setTranscriptMode(0);
    new View(this.mContext).setLayoutParams(new AbsListView.LayoutParams(-1, (int)TypedValue.applyDimension(1, 10.0F, this.mContext.getResources().getDisplayMetrics())));
    localView = LayoutInflater.from(this.mContext).inflate(2131559032, null);
    this.d.setOverScrollHeader(localView);
    this.a = new zni(this.mApp, this.mContext, this.sessionInfo);
    this.a.setFrom(true);
    this.d.setAdapter(this.a);
  }
  
  private void tP()
  {
    Object localObject = (RelativeLayout)this.cL.findViewById(2131377496);
    if (localObject != null)
    {
      int i = this.mContext.getResources().getDimensionPixelSize(2131297368);
      if ((this.rb > 0.0F) && (this.rb <= 1.0F))
      {
        i = (int)(i / this.rb);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.height = i;
          ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
        }
        i = (int)(16.0D / this.rb);
        localObject = (TextView)this.cL.findViewById(2131379562);
        if (localObject != null)
        {
          this.rd = i;
          ((TextView)localObject).setTextSize(2, i);
          ((TextView)localObject).setTypeface(Typeface.defaultFromStyle(0));
        }
        localObject = (ImageView)this.cL.findViewById(2131368962);
        if (localObject != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
          if (localLayoutParams != null)
          {
            localLayoutParams.height = ((int)(localLayoutParams.height / this.rb));
            localLayoutParams.width = ((int)(localLayoutParams.width / this.rb));
            ((ImageView)localObject).setLayoutParams(localLayoutParams);
          }
        }
      }
    }
    localObject = getIntent();
    this.mTitleText = ((TextView)this.cL.findViewById(2131379562));
    this.iA = ((RelativeLayout)this.cL.findViewById(2131369093));
    this.iA.setOnClickListener(this);
    localObject = ((Intent)localObject).getStringExtra("multi_forward_title");
    if (this.forwardType == 2)
    {
      if ((localObject != null) && ((((String)localObject).equals(acfp.m(2131708445))) || (((String)localObject).equals(acfp.m(2131708444)))))
      {
        this.mTitleText.setText((CharSequence)localObject);
        return;
      }
      this.mTitleText.setText("");
      return;
    }
    if (this.forwardType == 1)
    {
      this.mTitleText.setText(acfp.m(2131708443));
      return;
    }
    if (this.forwardType == 3)
    {
      this.mTitleText.setText((CharSequence)localObject);
      return;
    }
    this.mTitleText.setText("");
  }
  
  public boolean C(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.msgtype != -1000) && (paramChatMessage.msgtype != -2000) && (paramChatMessage.msgtype != -2011) && (paramChatMessage.msgtype != -5008) && (paramChatMessage.msgtype != -5017) && (paramChatMessage.msgtype != -5016) && (paramChatMessage.msgtype != -5013) && (paramChatMessage.msgtype != -1035) && (paramChatMessage.msgtype != -1036) && (paramChatMessage.msgtype != -2022) && (!(paramChatMessage instanceof MessageForFile)) && (!(paramChatMessage instanceof MessageForTroopFile));
  }
  
  public ChatMessage c(ChatMessage paramChatMessage)
  {
    ChatMessage localChatMessage = (ChatMessage)paramChatMessage.deepCopyByReflect();
    if (localChatMessage != null)
    {
      if ((localChatMessage instanceof MessageForArkApp)) {
        ((MessageForArkApp)localChatMessage).arkContainer = null;
      }
      if ((localChatMessage instanceof MessageForArkFlashChat)) {
        ((MessageForArkFlashChat)localChatMessage).arkContainer = null;
      }
      Object localObject1;
      Object localObject2;
      if ((localChatMessage instanceof MessageForArkBabyqReply))
      {
        localObject1 = (MessageForArkBabyqReply)localChatMessage;
        if ((((MessageForArkBabyqReply)localObject1).mArkBabyqReplyCardList != null) && (((MessageForArkBabyqReply)localObject1).mArkBabyqReplyCardList.size() > 0))
        {
          localObject1 = ((MessageForArkBabyqReply)localObject1).mArkBabyqReplyCardList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ArkBabyqCardInfo)((Iterator)localObject1).next();
            if (localObject2 != null) {
              ((ArkBabyqCardInfo)localObject2).mArkBabyqContainer = null;
            }
          }
        }
      }
      if (((localChatMessage instanceof MessageForReplyText)) && ((paramChatMessage instanceof MessageForReplyText)))
      {
        localObject1 = (MessageForReplyText)localChatMessage;
        localObject2 = (MessageForReplyText)paramChatMessage;
        if ((((MessageForReplyText)localObject1).mSourceMsgInfo != null) && (((MessageForReplyText)localObject2).mSourceMsgInfo != null))
        {
          ((MessageForReplyText)localObject1).mSourceMsgInfo = new MessageForReplyText.SourceMsgInfo(((MessageForReplyText)localObject2).mSourceMsgInfo);
          ((MessageForReplyText)localObject1).mSourceMsgInfo.mSourceMsgTroopName = null;
        }
        ((MessageForReplyText)localObject1).setSourceMessageRecord(((MessageForReplyText)localObject2).getSourceMessage());
      }
      if (((paramChatMessage instanceof MessageForMixedMsg)) && ((localChatMessage instanceof MessageForMixedMsg)))
      {
        localObject1 = (MessageForMixedMsg)paramChatMessage;
        paramChatMessage = (MessageForMixedMsg)localChatMessage;
        if ((((MessageForMixedMsg)localObject1).getReplyMessage(this.mApp) != null) && (paramChatMessage.getReplyMessage(this.mApp) != null))
        {
          localObject1 = (MessageForReplyText)c(((MessageForMixedMsg)localObject1).getReplyMessage(this.mApp));
          if (((MessageForReplyText)localObject1).getSourceMessage() != null) {
            paramChatMessage.getReplyMessage(this.mApp).setSourceMessageRecord(((MessageForReplyText)localObject1).getSourceMessage());
          }
        }
      }
    }
    return localChatMessage;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Display localDisplay = a(getActivity()).getDefaultDisplay();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    paramMotionEvent.offsetLocation((f1 - localDisplay.getWidth() * (1.0F - this.rb) / 2.0F) / this.rb - f1, (f2 - localDisplay.getHeight() * (1.0F - this.rb) / 2.0F) / this.rb - f2);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    a(paramActivity).setFormat(-2);
    Object localObject = a(paramActivity).getAttributes();
    Display localDisplay = a(paramActivity).getDefaultDisplay();
    this.rc = a(paramActivity).getFloatExtra("minaio_height_ration", 0.6F);
    ((WindowManager.LayoutParams)localObject).height = ((int)(localDisplay.getHeight() * this.rc));
    a(paramActivity).setAttributes((WindowManager.LayoutParams)localObject);
    localObject = a(paramActivity).getDecorView();
    if (zos.VB())
    {
      this.rb = a(paramActivity).getFloatExtra("minaio_scaled_ration", 0.95F);
      ((View)localObject).setScaleX(this.rb);
      ((View)localObject).setScaleY(this.rb);
      QLog.i("MiniMultiForwardPreviewFragment", 2, "surport scale ");
      return;
    }
    this.rb = 1.0F;
    QLog.i("MiniMultiForwardPreviewFragment", 2, "not surport scale ");
  }
  
  public boolean needDispatchTouchEvent()
  {
    return true;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    getActivity().finish();
    getActivity().overridePendingTransition(0, 0);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      onBackEvent();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mContext = getActivity();
    this.mApp = getActivity().app;
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.mApp == null) {
      paramLayoutInflater = null;
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      paramLayoutInflater = paramLayoutInflater.inflate(2131559626, paramViewGroup, false);
      if (paramLayoutInflater == null) {
        getActivity().finish();
      }
      this.cL = ((ViewGroup)paramLayoutInflater.findViewById(2131362332));
      cqj();
      tP();
      initListView();
      cqk();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((MediaPlayerManager)this.mApp.getManager(24)).c(this.d);
    this.a.destroy();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    ApngImage.pauseByTag(0);
    ApngImage.pauseAll();
    AbstractGifImage.pauseAll();
    BaseChatItemLayout.bdx = this.blg;
    wyv.Da(0);
    wyv.Da(0);
    ArkFlashChatContainerWrapper.Da(0);
    NativeVideoImage.pauseAll();
    AbstractGifImage.pauseAll();
    AbstractVideoImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(0);
    ApngImage.resumeAll();
    this.blg = BaseChatItemLayout.bdx;
    BaseChatItemLayout.bdx = false;
    com.etrump.mixlayout.ETTextView.enableAnimation = true;
    wyv.Da(1);
    ArkFlashChatContainerWrapper.Da(1);
    NativeVideoImage.resumeAll();
    AbstractGifImage.resumeAll();
    AbstractVideoImage.resumeAll();
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMultiForwardFragment
 * JD-Core Version:    0.7.0.1
 */