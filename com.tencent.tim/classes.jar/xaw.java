import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.d;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceFile.a;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xaw
  extends BaseBubbleBuilder
  implements BaseBubbleBuilder.d, MessageForDeviceFile.a
{
  boolean bgQ = false;
  
  public xaw(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  @SuppressLint({"ResourceAsColor"})
  @TargetApi(11)
  private RelativeLayout a(xaw.a parama)
  {
    int i = wja.dp2px(10.0F, this.mContext.getResources());
    int j = wja.dp2px(50.0F, this.mContext.getResources());
    int k = wja.dp2px(70.0F, this.mContext.getResources());
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    localRelativeLayout.setId(2131364503);
    Object localObject2 = new RelativeLayout(this.mContext);
    ((RelativeLayout)localObject2).setId(2131367049);
    ((RelativeLayout)localObject2).setBackgroundResource(2130845116);
    ((RelativeLayout)localObject2).setPadding(wja.dp2px(12.0F, this.mContext.getResources()), i, i, wja.dp2px(7.0F, this.mContext.getResources()));
    parama.hA = ((RelativeLayout)localObject2);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(10, 2131364503);
    localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout(this.mContext);
    ((RelativeLayout)localObject1).setId(2131367050);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, k);
    localLayoutParams.addRule(10, 2131367049);
    ((RelativeLayout)localObject2).addView((View)localObject1, localLayoutParams);
    localObject2 = new AsyncImageView(this.mContext);
    ((AsyncImageView)localObject2).setWidth(k);
    ((AsyncImageView)localObject2).setHeight(k);
    ((AsyncImageView)localObject2).setId(2131364472);
    ((AsyncImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(k, k);
    localLayoutParams.addRule(9, 2131367050);
    localLayoutParams.addRule(15, 2131367050);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView = ((AsyncImageView)localObject2);
    localObject2 = new ImageView(this.mContext);
    ((ImageView)localObject2).setId(2131364473);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.CENTER_CROP);
    localLayoutParams = new RelativeLayout.LayoutParams(j, j);
    localLayoutParams.addRule(9, 2131367050);
    localLayoutParams.addRule(15, 2131367050);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    parama.sU = ((ImageView)localObject2);
    localObject2 = new TextView(this.mContext);
    ((TextView)localObject2).setId(2131364474);
    ((TextView)localObject2).setGravity(16);
    ((TextView)localObject2).setIncludeFontPadding(false);
    ((TextView)localObject2).setMaxLines(2);
    ((TextView)localObject2).setTextSize(1, 14.0F);
    ((TextView)localObject2).setTextColor(this.mContext.getResources().getColorStateList(2131167322));
    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(1, 2131364472);
    localLayoutParams.addRule(11, 2131367050);
    localLayoutParams.addRule(10, 2131367050);
    localLayoutParams.setMargins(i, 0, 0, 0);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    parama.T = ((TextView)localObject2);
    localObject2 = new TextView(this.mContext);
    ((TextView)localObject2).setId(2131364471);
    ((TextView)localObject2).setSingleLine();
    if (VersionUtils.isHoneycomb()) {
      ((TextView)localObject2).setAlpha(0.75F);
    }
    ((TextView)localObject2).setGravity(17);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(5, 2131364474);
    localLayoutParams.addRule(6, 2131364476);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    parama.U = ((TextView)localObject2);
    localObject2 = new TextView(this.mContext);
    ((TextView)localObject2).setId(2131364476);
    ((TextView)localObject2).setGravity(5);
    ((TextView)localObject2).setTextColor(Color.parseColor("#777777"));
    ((TextView)localObject2).setTextSize(1, 12.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11, 2131367050);
    localLayoutParams.addRule(12, 2131367050);
    localLayoutParams.addRule(1, 2131364471);
    localLayoutParams.leftMargin = i;
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    parama.IX = ((TextView)localObject2);
    return localRelativeLayout;
  }
  
  private void a(BaseChatItemLayout paramBaseChatItemLayout, MessageForDeviceFile paramMessageForDeviceFile, xaw.a parama)
  {
    parama.T.setText(ahav.kY(paramMessageForDeviceFile.srcFileName));
    parama.U.setText(ahbj.g(paramMessageForDeviceFile.fileSize));
    ahav.a(parama.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetAsyncImageView, paramMessageForDeviceFile.filePath, ahav.getFileType(paramMessageForDeviceFile.filePath));
    parama.sU.setVisibility(8);
    if ((paramMessageForDeviceFile.strServiceName != null) && (paramMessageForDeviceFile.strServiceName.compareTo(szy.aIk) == 0)) {
      this.bgQ = true;
    }
    b(parama, paramMessageForDeviceFile);
    a(parama, paramMessageForDeviceFile);
    paramBaseChatItemLayout.setFailedIconVisable(a(paramMessageForDeviceFile), this);
  }
  
  private void a(xaw.a parama, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null) {
      parama.IX.setVisibility(8);
    }
    label193:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        return;
                                        if ((this.bgQ) && (paramMessageForDeviceFile.issend == 0)) {
                                          parama.IX.setMaxLines(3);
                                        }
                                        for (;;)
                                        {
                                          switch (paramMessageForDeviceFile.nFileStatus)
                                          {
                                          case 0: 
                                          case 11: 
                                          default: 
                                            return;
                                          case -1: 
                                            if (!paramMessageForDeviceFile.isSend()) {
                                              break label193;
                                            }
                                            parama.IX.setVisibility(8);
                                            return;
                                            parama.IX.setMaxLines(2);
                                          }
                                        }
                                        parama.IX.setVisibility(0);
                                        parama.IX.setText("" + this.mContext.getString(2131693600));
                                        return;
                                        if (this.bgQ)
                                        {
                                          parama.IX.setVisibility(0);
                                          if (paramMessageForDeviceFile.isSend())
                                          {
                                            parama.IX.setText("" + this.mContext.getString(2131721612));
                                            return;
                                          }
                                          parama.IX.setText("" + this.mContext.getString(2131692589));
                                          return;
                                        }
                                        parama.IX.setVisibility(4);
                                        return;
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          parama.IX.setVisibility(4);
                                          return;
                                        }
                                        parama.IX.setVisibility(0);
                                        parama.IX.setText("" + this.mContext.getString(2131695427));
                                        return;
                                        parama.IX.setVisibility(0);
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          parama.IX.setText("" + this.mContext.getString(2131693598));
                                          return;
                                        }
                                        if (this.bgQ)
                                        {
                                          parama.IX.setText("" + this.mContext.getString(2131692585));
                                          return;
                                        }
                                        parama.IX.setText("" + this.mContext.getString(2131693597));
                                        return;
                                        parama.IX.setVisibility(0);
                                        if (paramMessageForDeviceFile.isSend())
                                        {
                                          if (this.bgQ)
                                          {
                                            parama.IX.setText("" + this.mContext.getString(2131692595));
                                            return;
                                          }
                                          parama.IX.setText("" + this.mContext.getString(2131693599));
                                          return;
                                        }
                                        if (this.bgQ)
                                        {
                                          parama.IX.setText("" + this.mContext.getString(2131692590));
                                          return;
                                        }
                                        parama.IX.setText("" + this.mContext.getString(2131693591));
                                        return;
                                        parama.IX.setVisibility(0);
                                      } while ((paramMessageForDeviceFile.isSend()) || (!this.bgQ));
                                      parama.IX.setText("" + this.mContext.getString(2131692586));
                                      return;
                                      parama.IX.setVisibility(0);
                                    } while ((paramMessageForDeviceFile.isSend()) || (!this.bgQ));
                                    parama.IX.setText("" + this.mContext.getString(2131692587));
                                    return;
                                    parama.IX.setVisibility(0);
                                  } while ((paramMessageForDeviceFile.isSend()) || (!this.bgQ));
                                  parama.IX.setText("" + this.mContext.getString(2131692588));
                                  return;
                                  parama.IX.setVisibility(0);
                                } while ((paramMessageForDeviceFile.isSend()) || (!this.bgQ));
                                parama.IX.setText("" + this.mContext.getString(2131692591));
                                return;
                                parama.IX.setVisibility(0);
                              } while ((paramMessageForDeviceFile.isSend()) || (!this.bgQ));
                              parama.IX.setText("" + this.mContext.getString(2131692593) + "（错误01）");
                              return;
                              parama.IX.setVisibility(0);
                            } while ((paramMessageForDeviceFile.isSend()) || (!this.bgQ));
                            parama.IX.setText("" + this.mContext.getString(2131692593) + "（错误02）");
                            return;
                            parama.IX.setVisibility(0);
                          } while ((paramMessageForDeviceFile.isSend()) || (!this.bgQ));
                          parama.IX.setText("" + this.mContext.getString(2131692593) + "（错误03）");
                          return;
                          parama.IX.setVisibility(0);
                        } while ((paramMessageForDeviceFile.isSend()) || (!this.bgQ));
                        parama.IX.setText("" + this.mContext.getString(2131692593) + "（错误04）");
                        return;
                        parama.IX.setVisibility(0);
                      } while ((paramMessageForDeviceFile.isSend()) || (!this.bgQ));
                      parama.IX.setText("" + this.mContext.getString(2131692593) + "（错误05）");
                      return;
                      parama.IX.setVisibility(0);
                    } while ((paramMessageForDeviceFile.isSend()) || (!this.bgQ));
                    parama.IX.setText("" + this.mContext.getString(2131692593) + "（错误06）");
                    return;
                    parama.IX.setVisibility(0);
                  } while ((paramMessageForDeviceFile.isSend()) || (!this.bgQ));
                  parama.IX.setText("" + this.mContext.getString(2131692593) + "（错误07）");
                  return;
                  parama.IX.setVisibility(0);
                } while ((paramMessageForDeviceFile.isSend()) || (!this.bgQ));
                parama.IX.setText("" + this.mContext.getString(2131692593) + "（错误08）");
                return;
                parama.IX.setVisibility(0);
              } while ((paramMessageForDeviceFile.isSend()) || (!this.bgQ));
              parama.IX.setText("" + this.mContext.getString(2131692593) + "（错误09）");
              return;
              parama.IX.setVisibility(0);
            } while ((paramMessageForDeviceFile.isSend()) || (!this.bgQ));
            parama.IX.setText("" + this.mContext.getString(2131692593) + "（错误10）");
            return;
            parama.IX.setVisibility(0);
          } while ((paramMessageForDeviceFile.isSend()) || (!this.bgQ));
          parama.IX.setText("" + this.mContext.getString(2131692593) + "（错误11）");
          return;
          parama.IX.setVisibility(0);
        } while ((paramMessageForDeviceFile.isSend()) || (!this.bgQ));
        parama.IX.setText("" + this.mContext.getString(2131692593) + this.mContext.getString(2131692591));
        return;
        parama.IX.setVisibility(0);
      } while ((paramMessageForDeviceFile.isSend()) || (!this.bgQ));
      parama.IX.setText("" + this.mContext.getString(2131692592));
      return;
      parama.IX.setVisibility(0);
    } while (!this.bgQ);
    parama.IX.setText("" + this.mContext.getString(2131692594));
  }
  
  private boolean a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile == null) {
      return false;
    }
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    case 11: 
    default: 
      return false;
    }
    return true;
  }
  
  private void b(xaw.a parama, MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (paramMessageForDeviceFile != null) {}
    int i;
    switch (paramMessageForDeviceFile.nFileStatus)
    {
    default: 
      i = 0;
      if (i != 0)
      {
        if (parama.j == null)
        {
          localProgressBar = new ProgressBar(this.mContext, null, 16842872);
          localProgressBar.setId(2131364475);
          localProgressBar.setMax(100);
          localProgressBar.setMinimumHeight(wja.dp2px(4.0F, this.mContext.getResources()));
          localProgressBar.setProgressDrawable(this.mContext.getResources().getDrawable(2130838114));
          localLayoutParams = new RelativeLayout.LayoutParams(-1, wja.dp2px(4.0F, this.mContext.getResources()));
          localLayoutParams.addRule(3, 2131367050);
          localLayoutParams.addRule(12, 2131367049);
          localLayoutParams.setMargins(0, wja.dp2px(2.0F, this.mContext.getResources()), 0, 0);
          parama.hA.addView(localProgressBar, localLayoutParams);
          parama.j = localProgressBar;
        }
        parama.j.setProgress((int)(paramMessageForDeviceFile.progress * 100.0F));
        parama.j.setVisibility(0);
      }
      break;
    }
    while (parama.j == null)
    {
      ProgressBar localProgressBar;
      RelativeLayout.LayoutParams localLayoutParams;
      return;
      i = 1;
      break;
    }
    parama.j.setVisibility(8);
  }
  
  private void c(MessageForDeviceFile paramMessageForDeviceFile) {}
  
  private void onItemClick(View paramView)
  {
    Object localObject2 = (MessageForDeviceFile)wja.a(paramView);
    paramView = ahav.a((MessageForDeviceFile)localObject2);
    Object localObject1 = new ForwardFileInfo();
    if ((this.bgQ) && (paramView.nFileType != 0)) {
      ((ForwardFileInfo)localObject1).setType(10000);
    }
    Intent localIntent;
    for (;;)
    {
      ((ForwardFileInfo)localObject1).Oj(8);
      ((ForwardFileInfo)localObject1).p(paramView.nSessionId);
      ((ForwardFileInfo)localObject1).setFileName(paramView.fileName);
      ((ForwardFileInfo)localObject1).jB(paramView.uniseq);
      ((ForwardFileInfo)localObject1).setFileSize(paramView.fileSize);
      ((ForwardFileInfo)localObject1).setLocalPath(paramView.getFilePath());
      ((ForwardFileInfo)localObject1).setUuid(paramView.Uuid);
      localIntent = new Intent(this.mContext, FileBrowserActivity.class);
      localIntent.putExtra("fileinfo", (Parcelable)localObject1);
      localObject1 = new ArrayList();
      if ((paramView.nFileType != 0) && (paramView.nFileType != 1)) {
        break;
      }
      localObject2 = this.app.b().f(((MessageForDeviceFile)localObject2).frienduin, ((MessageForDeviceFile)localObject2).istroop);
      if ((localObject2 == null) || (((List)localObject2).size() == 0)) {
        break;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (ChatMessage)((Iterator)localObject2).next();
        if (((ChatMessage)localObject3).msgtype == -4500)
        {
          localObject3 = (MessageForDeviceFile)localObject3;
          if (ahav.getFileType(((MessageForDeviceFile)localObject3).filePath) == paramView.nFileType) {
            ((ArrayList)localObject1).add(String.valueOf(ahav.a((MessageForDeviceFile)localObject3).nSessionId));
          }
        }
      }
      ((ForwardFileInfo)localObject1).setType(10009);
    }
    localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", (ArrayList)localObject1);
    ((Activity)this.mContext).startActivityForResult(localIntent, 102);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, wlz paramwlz)
  {
    paramChatMessage = super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramwlz);
    ((xaw.a)paramChatMessage.getTag()).E.getLayoutParams().width = BaseChatItemLayout.bNS;
    return paramChatMessage;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    xaw.a locala = (xaw.a)parame;
    MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)paramChatMessage;
    paramChatMessage = paramView;
    if (paramView == null) {
      paramChatMessage = a((xaw.a)parame);
    }
    c(localMessageForDeviceFile);
    a(paramBaseChatItemLayout, localMessageForDeviceFile, locala);
    paramChatMessage.setOnLongClickListener(paramwlz);
    paramChatMessage.setOnTouchListener(paramwlz);
    paramChatMessage.setOnClickListener(this);
    locala.sU.setOnClickListener(this);
    ((szy)this.app.getBusinessHandler(49)).a().a(paramChatMessage, this);
    return paramChatMessage;
  }
  
  public BaseBubbleBuilder.d a(View paramView)
  {
    return this;
  }
  
  public BaseBubbleBuilder.e a()
  {
    return new xaw.a();
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
    paramChatMessage.putInt("forward_type", 0);
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
    paramView = (xaw.a)wja.a(paramView);
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, "error get holder in updateview");
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
    a(paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout, localMessageForDeviceFile, paramView);
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
    if (!TextUtils.isEmpty(((MessageForDeviceFile)((xaw.a)wja.a(paramView)).mMessage).filePath)) {
      localaqoa.Z(2131367523, this.mContext.getString(2131721067), 2130839086);
    }
    super.c(localaqoa, this.mContext);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return acfp.m(2131704964);
  }
  
  void d(MessageForDeviceFile paramMessageForDeviceFile)
  {
    if (!aqiw.isNetSupport(this.mContext))
    {
      ahao.OS(2131693819);
      return;
    }
    if (aqhq.fileExistsAndNotEmpty(paramMessageForDeviceFile.filePath)) {
      ((szy)this.app.getBusinessHandler(49)).a().a(paramMessageForDeviceFile.strServiceName, paramMessageForDeviceFile);
    }
    super.notifyDataSetChanged();
  }
  
  public void e(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = (xaw.a)wja.a(paramView);
    if (paramView == null) {}
    do
    {
      return;
      paramView = paramView.hA.getBackground();
    } while (paramView == null);
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return;
    case 0: 
      paramView.setColorFilter(BaseBubbleBuilder.d);
      paramView.invalidateSelf();
      return;
    }
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
    if (wja.a(paramView).isMultiMsg) {}
    do
    {
      return;
      paramView = (MessageForDeviceFile)((xaw.a)wja.a(paramView)).mMessage;
      if (paramView.isSendFromLocal())
      {
        localausj = (ausj)auss.a(this.mContext, null);
        localausj.addButton(2131690230, 5);
        localausj.addCancelButton(2131721058);
        localausj.a(new xax(this, paramView, localausj));
        localausj.show();
        return;
      }
    } while (this.bgQ);
    ausj localausj = ausj.b(this.mContext);
    localausj.setMainTitle(2131692583);
    localausj.addButton(2131692582);
    localausj.addCancelButton(2131721058);
    localausj.a(new xay(this, paramView, localausj));
    localausj.show();
  }
  
  public void onClick(View paramView)
  {
    wja.bcO = true;
    if (super.Rk()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      MessageForDeviceFile localMessageForDeviceFile = (MessageForDeviceFile)wja.a(paramView);
      if ((paramView.getId() != 2131364512) || (localMessageForDeviceFile == null) || (localMessageForDeviceFile.uint32_src_uin_type != 1))
      {
        super.onClick(paramView);
        switch (paramView.getId())
        {
        case 2131364473: 
        case 2131364511: 
        default: 
          break;
        case 2131364503: 
          onItemClick(paramView);
        }
      }
    }
  }
  
  public void v(View paramView, boolean paramBoolean)
  {
    paramView = (xaw.a)wja.a(paramView);
    if (paramView == null) {}
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = paramView.hA.getBackground();
    } while (localDrawable == null);
    if (paramBoolean) {}
    for (paramView = null;; paramView = d)
    {
      localDrawable.setColorFilter(paramView);
      localDrawable.invalidateSelf();
      return;
    }
  }
  
  class a
    extends BaseBubbleBuilder.e
  {
    public TextView IX;
    public TextView T;
    public TextView U;
    public AsyncImageView a;
    public RelativeLayout hA;
    public ProgressBar j;
    public ImageView sU;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xaw
 * JD-Core Version:    0.7.0.1
 */