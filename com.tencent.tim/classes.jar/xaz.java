import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.customviews.MessageProgressTextView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceFile.a;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xaz
  extends BaseBubbleBuilder
  implements BaseBubbleBuilder.d, MessageForDeviceFile.a
{
  protected final float mDensity;
  
  public xaz(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramView = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    if (("device_groupchat".equals(((MessageForDeviceFile)paramChatMessage).extStr)) && (paramView != null))
    {
      paramChatMessage = (MessageForDeviceFile)paramChatMessage;
      if ((TextUtils.isEmpty(paramChatMessage.filePath)) || (ahav.getFileSizes(paramChatMessage.filePath) == 0L))
      {
        paramViewGroup = (szy)this.app.getBusinessHandler(49);
        if (!TextUtils.isEmpty(paramChatMessage.strMediaKey)) {
          paramViewGroup.a().a(paramChatMessage, paramView, this);
        }
      }
    }
    return paramView;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    xaz.a locala = (xaz.a)parame;
    parame = paramView;
    if (paramView == null)
    {
      parame = new RelativeLayout(this.mContext);
      paramView = new AsyncImageView(this.mContext);
      paramView.setId(2131373231);
      if (!bdm) {
        paramView.setAdjustViewBounds(true);
      }
      paramView.setMaxWidth((int)(this.mDensity * 100.0F + 0.5F));
      paramView.setMaxHeight((int)(this.mDensity * 100.0F + 0.5F));
      paramView.setAsyncClipSize((int)(this.mDensity * 100.0F + 0.5F), (int)(this.mDensity * 100.0F + 0.5F));
      paramView.setDefaultImageByMargin();
      paramView.setIsDrawRound(true);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      parame.addView(paramView, localLayoutParams);
      locala.n = paramView;
      paramView = new MessageProgressTextView(this.mContext);
      paramView.setTextColor(-1);
      int i = (int)TypedValue.applyDimension(2, 15.0F, this.mContext.getResources().getDisplayMetrics());
      paramView.setTextSize(2, 15.0F);
      paramView.setGravity(17);
      if (bdm) {
        paramView.setDisplayInTextView(false, i, -1);
      }
      paramView.setBackgroundDrawable(new wyf(2130706432, this.mDensity * 12.0F));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(6, 2131373231);
      localLayoutParams.addRule(8, 2131373231);
      localLayoutParams.addRule(5, 2131373231);
      localLayoutParams.addRule(7, 2131373231);
      parame.addView(paramView, localLayoutParams);
      paramView.setVisibility(8);
      locala.b = paramView;
      parame.setOnClickListener(this);
      parame.setOnTouchListener(paramwlz);
      parame.setOnLongClickListener(paramwlz);
    }
    paramBaseChatItemLayout.setTag(locala);
    paramChatMessage = (MessageForDeviceFile)paramChatMessage;
    if (("device_groupchat".equals(paramChatMessage.extStr)) && (paramChatMessage.msgStatus == 2))
    {
      paramView = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramView instanceof QQAppInterface))
      {
        paramView = (QQAppInterface)paramView;
        if (!aqiw.isNetSupport(BaseApplication.getContext()))
        {
          paramChatMessage.nFileStatus = 6;
          paramChatMessage.msgStatus = 1;
          paramChatMessage.serial();
          paramView.b().c(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq, paramChatMessage.msgData);
        }
      }
    }
    a(paramBaseChatItemLayout, paramChatMessage, locala);
    ((szy)this.app.getBusinessHandler(49)).a().a(parame, this);
    return parame;
  }
  
  public BaseBubbleBuilder.d a(View paramView)
  {
    paramView = wja.a(paramView);
    if (paramView != null)
    {
      if (paramView.vipBubbleID == 0L) {
        return this;
      }
      return null;
    }
    return null;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xaz.a();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForDeviceFile)))
    {
      paramContext = (MessageForDeviceFile)paramChatMessage;
      if (paramInt != 2131365686) {
        break label36;
      }
      ujt.b(this.mContext, this.app, paramChatMessage);
    }
    label36:
    do
    {
      return;
      if (paramInt == 2131372073)
      {
        super.m(paramChatMessage);
        return;
      }
    } while (paramInt != 2131367523);
    paramChatMessage = new Bundle();
    paramChatMessage.putInt("forward_type", 1);
    paramChatMessage.putInt("forward_source_uin_type", this.sessionInfo.cZ);
    paramChatMessage.putInt("selection_mode", this.bOY);
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_filepath", paramContext.filePath);
    localIntent.putExtra("BUSI_TYPE", 1009);
    localIntent.putExtra("forward_download_image_org_uin", paramContext.frienduin);
    localIntent.putExtra("forward_download_image_org_uin_type", paramContext.istroop);
    localIntent.putExtra("forward_photo_isSend", paramContext.issend);
    localIntent.putExtras(paramChatMessage);
    ahgq.f((Activity)this.mContext, localIntent, 21);
  }
  
  public void a(View paramView, MessageForDeviceFile paramMessageForDeviceFile)
  {
    paramView = (xaz.a)wja.a(paramView);
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("DevicePicItemBuilder", 2, "error get holder in updateview");
      }
    }
    MessageForDeviceFile localMessageForDeviceFile;
    do
    {
      return;
      localMessageForDeviceFile = (MessageForDeviceFile)paramView.mMessage;
    } while (localMessageForDeviceFile.uniseq != paramMessageForDeviceFile.uniseq);
    localMessageForDeviceFile.msgStatus = paramMessageForDeviceFile.msgStatus;
    localMessageForDeviceFile.nFileStatus = paramMessageForDeviceFile.nFileStatus;
    localMessageForDeviceFile.progress = paramMessageForDeviceFile.progress;
    localMessageForDeviceFile.msg = paramMessageForDeviceFile.msg;
    a(paramView.a, localMessageForDeviceFile, paramView);
  }
  
  public void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForDeviceFile paramMessageForDeviceFile, xaz.a parama)
  {
    boolean bool = false;
    String str = paramMessageForDeviceFile.filePath;
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    default: 
      if (!TextUtils.isEmpty(str)) {
        parama.n.setAsyncImage(str);
      }
      break;
    }
    for (;;)
    {
      paramBaseChatItemLayout.setFailedIconVisable(bool, this);
      return;
      if (paramMessageForDeviceFile.issend == 0)
      {
        parama.b.setVisibility(4);
        break;
      }
      parama.b.setVisibility(0);
      parama.b.setProgress(0);
      break;
      parama.b.setVisibility(0);
      parama.b.setProgress((int)(paramMessageForDeviceFile.progress * 100.0F));
      break;
      parama.b.setVisibility(4);
      break;
      parama.b.setVisibility(4);
      break;
      parama.b.setVisibility(4);
      bool = true;
      break;
      parama.n.setImageDrawableDefault();
    }
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
    if (!TextUtils.isEmpty(((MessageForDeviceFile)((xaz.a)wja.a(paramView)).mMessage).filePath)) {
      localaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
    }
    super.c(localaqoa, this.mContext);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return acfp.m(2131704997);
  }
  
  public void bYO()
  {
    super.bYO();
  }
  
  void d(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!aqiw.isNetSupport(this.mContext))
    {
      ahao.OS(2131693819);
      return;
    }
    if (aqhq.fileExistsAndNotEmpty(paramMessageForDeviceFile.filePath)) {
      ((szy)this.app.getBusinessHandler(49)).a().a(szy.aIl, paramMessageForDeviceFile);
    }
    notifyDataSetChanged();
  }
  
  public void e(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return;
      paramView = paramView.getBackground();
    } while (paramView == null);
    paramView.setColorFilter(null);
    paramView.invalidateSelf();
  }
  
  public void e(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!aqiw.isNetSupport(this.mContext))
    {
      ahao.OS(2131693819);
      return;
    }
    ((szy)this.app.getBusinessHandler(49)).a().b(paramMessageForDeviceFile);
  }
  
  public void ei(View paramView)
  {
    super.ei(paramView);
    if (wja.a(paramView).isMultiMsg) {
      return;
    }
    paramView = (MessageForDeviceFile)((xaz.a)wja.a(paramView)).mMessage;
    if (paramView.isSendFromLocal())
    {
      localausj = (ausj)auss.a(this.mContext, null);
      localausj.addButton(2131690230, 5);
      localausj.addCancelButton(2131721058);
      localausj.a(new xba(this, paramView, localausj));
      localausj.show();
      return;
    }
    ausj localausj = ausj.b(this.mContext);
    localausj.setMainTitle(2131692583);
    localausj.addButton(2131692582);
    localausj.addCancelButton(2131721058);
    localausj.a(new xbb(this, paramView, localausj));
    localausj.show();
  }
  
  public void ej(View paramView)
  {
    ChatMessage localChatMessage = wja.a(paramView);
    if (localChatMessage == null) {}
    do
    {
      do
      {
        return;
      } while (localChatMessage.istroop != 9501);
      if (localChatMessage.isSendFromLocal())
      {
        super.ej(paramView);
        return;
      }
    } while (!"device_groupchat".equals(localChatMessage.extStr));
    super.ej(paramView);
  }
  
  public void onClick(View paramView)
  {
    if (super.Rk())
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Object localObject1;
    Intent localIntent;
    if (paramView.getId() == 2131364503) {
      try
      {
        Object localObject2 = (MessageForDeviceFile)wja.a(paramView);
        FileManagerEntity localFileManagerEntity = ahav.a((MessageForDeviceFile)localObject2);
        localObject1 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject1).setType(10009);
        ((ForwardFileInfo)localObject1).Oj(8);
        ((ForwardFileInfo)localObject1).p(localFileManagerEntity.nSessionId);
        ((ForwardFileInfo)localObject1).setFileName(localFileManagerEntity.fileName);
        ((ForwardFileInfo)localObject1).jB(localFileManagerEntity.uniseq);
        ((ForwardFileInfo)localObject1).setFileSize(localFileManagerEntity.fileSize);
        ((ForwardFileInfo)localObject1).setLocalPath(localFileManagerEntity.getFilePath());
        localIntent = new Intent(this.mContext, FileBrowserActivity.class);
        localIntent.putExtra("fileinfo", (Parcelable)localObject1);
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(String.valueOf(localFileManagerEntity.nSessionId));
        if (localFileManagerEntity.nFileType == 0)
        {
          localObject2 = this.app.b().f(((MessageForDeviceFile)localObject2).frienduin, ((MessageForDeviceFile)localObject2).istroop);
          if ((localObject2 != null) && (((List)localObject2).size() != 0))
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Object localObject3 = (ChatMessage)((Iterator)localObject2).next();
              if (((ChatMessage)localObject3).msgtype == -4500)
              {
                localObject3 = (MessageForDeviceFile)localObject3;
                if (ahav.getFileType(((MessageForDeviceFile)localObject3).filePath) == localFileManagerEntity.nFileType)
                {
                  localObject3 = ahav.a((MessageForDeviceFile)localObject3);
                  if (!((ArrayList)localObject1).contains(String.valueOf(((FileManagerEntity)localObject3).nSessionId)))
                  {
                    ((ArrayList)localObject1).add(String.valueOf(((FileManagerEntity)localObject3).nSessionId));
                    continue;
                    super.onClick(paramView);
                  }
                }
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    for (;;)
    {
      break;
      localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject1);
      ((Activity)this.mContext).startActivityForResult(localIntent, 102);
    }
  }
  
  public void v(View paramView, boolean paramBoolean)
  {
    Drawable localDrawable = paramView.getBackground();
    if (localDrawable != null) {
      if (!paramBoolean) {
        break label25;
      }
    }
    label25:
    for (paramView = null;; paramView = d)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
    }
  }
  
  public class a
    extends BaseBubbleBuilder.e
  {
    public MessageProgressTextView b;
    public AsyncImageView n;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xaz
 * JD-Core Version:    0.7.0.1
 */