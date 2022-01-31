package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import goy;
import gpi;
import java.io.File;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StructMsgForImageShare
  extends AbsShareMsg
{
  private static final int F = 288;
  private static View.OnClickListener a = new gpi();
  public int mIsSend = 1;
  public int mMsgType = 0;
  public long mUniseq = 0L;
  
  StructMsgForImageShare()
  {
    this.mMsgServiceID = 5;
  }
  
  StructMsgForImageShare(Bundle paramBundle)
  {
    super(paramBundle);
    if (paramBundle.getInt("req_type", 1) != 5) {
      return;
    }
    this.mMsgServiceID = 5;
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(0);
    localAbsStructMsgItem.d(paramBundle.getString("image_url"));
    this.mStructMsgItemLists.add(localAbsStructMsgItem);
  }
  
  StructMsgForImageShare(StructMsgNode paramStructMsgNode)
  {
    super(paramStructMsgNode);
  }
  
  public static boolean resendAndUploadImageShare(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, StructMsgForImageShare paramStructMsgForImageShare)
  {
    if (paramStructMsgForImageShare == null) {}
    do
    {
      return false;
      paramStructMsgForImageShare = paramStructMsgForImageShare.getFirstImageElement();
      if (paramStructMsgForImageShare != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, "handleAppShareAction firstImageElement NULL!!!");
    return false;
    String str = paramQQAppInterface.a();
    MessageRecord localMessageRecord = MessageRecordFactory.a(paramMessageRecord);
    paramQQAppInterface.a().a(localMessageRecord, str);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_JavaLangString = str;
    localTransferRequest.jdField_b_of_type_JavaLangString = paramMessageRecord.frienduin;
    localTransferRequest.jdField_a_of_type_Int = paramMessageRecord.istroop;
    localTransferRequest.jdField_b_of_type_Int = 1;
    localTransferRequest.jdField_a_of_type_Long = localMessageRecord.uniseq;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.d = 1030;
    localTransferRequest.g = paramStructMsgForImageShare.h;
    paramQQAppInterface.a().a(localTransferRequest);
    return true;
  }
  
  public static final String scaleLocalImage(Context paramContext, ImageInfo paramImageInfo, String paramString, int paramInt)
  {
    if ((paramContext == null) || (paramImageInfo == null) || (paramString == null)) {
      paramImageInfo = null;
    }
    long l1;
    do
    {
      do
      {
        String str1;
        do
        {
          return paramImageInfo;
          File localFile = new File(paramString);
          if (!localFile.exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d("StructMsg", 2, "handleAppShareAction mShareImageUrl NULL!!!");
            }
            return null;
          }
          String str2 = null;
          str1 = str2;
          for (;;)
          {
            try
            {
              if (!GifDrawable.isGifFile(localFile)) {
                continue;
              }
              str1 = str2;
              l1 = localFile.length();
              if (l1 >= 12582912L) {
                continue;
              }
              paramContext = paramString;
            }
            catch (Exception paramImageInfo)
            {
              boolean bool;
              paramContext = str1;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("StructMsg", 2, paramImageInfo.getMessage());
              paramContext = str1;
              continue;
              paramImageInfo = paramContext;
            }
            if (!TextUtils.isEmpty(paramContext)) {
              continue;
            }
            return null;
            str1 = str2;
            localFile = new File(AbsStructMsg.at);
            str1 = str2;
            if (!localFile.exists())
            {
              str1 = str2;
              localFile.mkdirs();
            }
            str1 = str2;
            str2 = AbsStructMsg.at + System.currentTimeMillis() + ".jpg";
            str1 = str2;
            bool = com.tencent.mobileqq.utils.ImageUtil.a(4, paramContext, paramString, str2, true, paramImageInfo, paramInt);
            paramContext = str2;
            if (!bool) {
              paramContext = paramString;
            }
          }
        } while (!QLog.isColorLevel());
        paramImageInfo = paramContext;
      } while (paramContext == null);
      paramImageInfo = paramContext;
    } while (paramString == null);
    try
    {
      paramImageInfo = new BitmapFactory.Options();
      paramImageInfo.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, paramImageInfo);
      paramInt = paramImageInfo.outWidth;
      int i = paramImageInfo.outHeight;
      BitmapFactory.decodeFile(paramContext, paramImageInfo);
      int j = paramImageInfo.outWidth;
      int k = paramImageInfo.outHeight;
      l1 = new File(paramString).length();
      long l2 = new File(paramContext).length();
      QLog.d("StructMsg", 2, "srcBmp = " + paramString + ", length = " + l1 + ", srcWidth = " + paramInt + ", srcHeight = " + i + ", destBmp = " + paramContext + ", length = " + l2 + ", destWidth = " + j + ", distHeight = " + k);
      return paramContext;
    }
    catch (Exception paramImageInfo)
    {
      QLog.d("StructMsg", 2, paramImageInfo.getMessage());
    }
    return paramContext;
  }
  
  public static boolean sendAndUploadImageShare(QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, String paramString, int paramInt)
  {
    if (paramStructMsgForImageShare == null) {}
    StructMsgItemImage localStructMsgItemImage;
    do
    {
      return false;
      localStructMsgItemImage = paramStructMsgForImageShare.getFirstImageElement();
      if (localStructMsgItemImage != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, "handleAppShareAction firstImageElement NULL!!!");
    return false;
    int i = MobileQQService.c;
    MobileQQService.c = i + 1;
    long l = i;
    String str = paramQQAppInterface.a();
    localStructMsgItemImage.c = 0L;
    paramStructMsgForImageShare = MessageRecordFactory.a(paramQQAppInterface, str, paramString, str, paramInt, l, paramStructMsgForImageShare);
    paramQQAppInterface.a().a(paramStructMsgForImageShare, str);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_JavaLangString = str;
    localTransferRequest.jdField_b_of_type_JavaLangString = paramString;
    localTransferRequest.jdField_a_of_type_Int = paramInt;
    localTransferRequest.jdField_b_of_type_Int = 1;
    localTransferRequest.jdField_a_of_type_Long = paramStructMsgForImageShare.uniseq;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.d = 1030;
    localTransferRequest.g = localStructMsgItemImage.h;
    paramQQAppInterface.a().a(localTransferRequest);
    return true;
  }
  
  public StructMsgItemImage getFirstImageElement()
  {
    if (this.mStructMsgItemLists != null)
    {
      int i = 0;
      while (i < this.mStructMsgItemLists.size())
      {
        AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)this.mStructMsgItemLists.get(i);
        if ((localAbsStructMsgElement instanceof AbsStructMsgItem))
        {
          AbsStructMsgItem localAbsStructMsgItem = (AbsStructMsgItem)localAbsStructMsgElement;
          if ((localAbsStructMsgElement != null) && (localAbsStructMsgItem.a != null))
          {
            int j = 0;
            while (j < localAbsStructMsgItem.a.size())
            {
              localAbsStructMsgElement = (AbsStructMsgElement)localAbsStructMsgItem.a.get(i);
              if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemImage))) {
                return (StructMsgItemImage)localAbsStructMsgElement;
              }
              j += 1;
            }
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return a;
  }
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    Object localObject1 = paramContext.getResources();
    int i = (int)((Resources)localObject1).getDisplayMetrics().density;
    paramView = new ImageView(paramContext);
    paramView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    paramView.setMaxHeight(i * 288);
    paramView.setAdjustViewBounds(true);
    paramView.setPadding(0, 10, 0, 10);
    Object localObject2 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    paramView.setMinimumHeight(i * 120);
    paramView.setContentDescription(paramContext.getString(2131558458));
    paramContext = ((Resources)localObject1).getDrawable(2130840239);
    localObject1 = getFirstImageElement();
    if ((localObject1 != null) && (((StructMsgItemImage)localObject1).h != null))
    {
      localObject2 = ((StructMsgItemImage)localObject1).h;
      if ((!((String)localObject2).startsWith("http://")) && (!((String)localObject2).startsWith("https://")))
      {
        localObject1 = com.tencent.biz.common.util.ImageUtil.b(((StructMsgItemImage)localObject1).h, i * 288);
        if (localObject1 != null)
        {
          paramView.setImageBitmap((Bitmap)localObject1);
          return paramView;
        }
        paramView.setImageDrawable(paramContext);
        return paramView;
      }
      paramView.setImageDrawable(URLDrawable.getDrawable((String)localObject2, paramContext, paramContext));
      return paramView;
    }
    paramView.setImageDrawable(paramContext);
    return paramView;
  }
  
  public View getView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramOnLongClickAndTouchListener = (ViewGroup)super.getView(paramContext, paramView, paramOnLongClickAndTouchListener);
    StructMsgItemImage localStructMsgItemImage = getFirstImageElement();
    if (localStructMsgItemImage != null)
    {
      localStructMsgItemImage.a = this;
      paramOnLongClickAndTouchListener.addView(localStructMsgItemImage.a(paramContext, paramView));
    }
    paramContext = paramOnLongClickAndTouchListener.getLayoutParams();
    if (paramContext == null) {
      paramContext = new LinearLayout.LayoutParams(-2, -2);
    }
    for (;;)
    {
      paramOnLongClickAndTouchListener.setLayoutParams(paramContext);
      paramOnLongClickAndTouchListener.setBackgroundDrawable(null);
      paramOnLongClickAndTouchListener.setId(2131230767);
      paramOnLongClickAndTouchListener.setTag(2131230767, this);
      return paramOnLongClickAndTouchListener;
      paramContext.height = -2;
      paramContext.width = -2;
    }
  }
  
  protected boolean parseContentNode(StructMsgNode paramStructMsgNode)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramStructMsgNode == null)
    {
      bool1 = true;
      return bool1;
    }
    if ("item".equals(paramStructMsgNode.jdField_b_of_type_JavaLangString)) {}
    for (Object localObject = paramStructMsgNode.a("layout");; localObject = StructMsgElementFactory.a(paramStructMsgNode.jdField_b_of_type_JavaLangString))
    {
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {}
        for (int i = Integer.parseInt((String)localObject);; i = 0)
        {
          localObject = StructMsgElementFactory.a(i);
          bool1 = bool2;
          if (localObject == null) {
            break;
          }
          bool1 = bool2;
          if (!((AbsStructMsgElement)localObject).a(paramStructMsgNode)) {
            break;
          }
          addItem((AbsStructMsgElement)localObject);
          return true;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (NumberFormatException paramStructMsgNode)
      {
        bool1 = bool2;
      }
      QLog.d("StructMsg", 2, "Item layout value is " + 0);
      return false;
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    int j = paramObjectInput.readInt();
    this.mVersion = j;
    Object localObject;
    if (j == 1)
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
      this.mContentTitle = paramObjectInput.readUTF();
      this.mContentSummary = paramObjectInput.readUTF();
      localObject = StructMsgElementFactory.a(this.mContentLayout);
      ((AbsStructMsgItem)localObject).a(new StructMsgItemCover(this.mContentCover));
      ((AbsStructMsgItem)localObject).a(new StructMsgItemTitle(this.mContentTitle));
      ((AbsStructMsgItem)localObject).a(new StructMsgItemSummary(this.mContentSummary));
      addItem((AbsStructMsgElement)localObject);
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
    do
    {
      do
      {
        return;
      } while ((j != 2) && (j != 3));
      this.mMsgTemplateID = paramObjectInput.readInt();
      this.mMsgAction = paramObjectInput.readUTF();
      this.mMsgActionData = paramObjectInput.readUTF();
      this.mMsg_A_ActionData = paramObjectInput.readUTF();
      this.mMsg_I_ActionData = paramObjectInput.readUTF();
      this.mMsgUrl = paramObjectInput.readUTF();
      this.mMsgBrief = paramObjectInput.readUTF();
      int k = paramObjectInput.readInt();
      int i = 0;
      if (i < k)
      {
        localObject = paramObjectInput.readUTF();
        if ("item".equals(localObject)) {
          localObject = StructMsgElementFactory.a(paramObjectInput.readInt());
        }
        for (;;)
        {
          if (localObject != null)
          {
            ((AbsStructMsgElement)localObject).a(paramObjectInput);
            addItem((AbsStructMsgElement)localObject);
          }
          i += 1;
          break;
          AbsStructMsgElement localAbsStructMsgElement = StructMsgElementFactory.a((String)localObject);
          localObject = localAbsStructMsgElement;
          if (localAbsStructMsgElement != null)
          {
            localObject = localAbsStructMsgElement;
            if (AbsStructMsgItem.class.isInstance(localAbsStructMsgElement))
            {
              paramObjectInput.readInt();
              localObject = localAbsStructMsgElement;
            }
          }
        }
      }
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
    } while (j != 3);
    this.mCompatibleText = paramObjectInput.readUTF();
  }
  
  protected void toContentXml(goy paramgoy)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      ((AbsStructMsgElement)localIterator.next()).a(paramgoy);
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mMsgTemplateID);
    if (this.mMsgAction == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgActionData != null) {
        break label186;
      }
      localObject = "";
      label59:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsg_A_ActionData != null) {
        break label194;
      }
      localObject = "";
      label77:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsg_I_ActionData != null) {
        break label202;
      }
      localObject = "";
      label95:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgUrl != null) {
        break label210;
      }
      localObject = "";
      label113:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mMsgBrief != null) {
        break label218;
      }
    }
    label186:
    label194:
    label202:
    label210:
    label218:
    for (Object localObject = "";; localObject = this.mMsgBrief)
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(getItemCount());
      localObject = iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramObjectOutput);
      }
      localObject = this.mMsgAction;
      break;
      localObject = this.mMsgActionData;
      break label59;
      localObject = this.mMsg_A_ActionData;
      break label77;
      localObject = this.mMsg_I_ActionData;
      break label95;
      localObject = this.mMsgUrl;
      break label113;
    }
    paramObjectOutput.writeLong(this.mSourceAppid);
    if (this.mSourceIcon == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceName != null) {
        break label437;
      }
      localObject = "";
      label265:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceUrl != null) {
        break label445;
      }
      localObject = "";
      label283:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceAction != null) {
        break label453;
      }
      localObject = "";
      label301:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceActionData != null) {
        break label461;
      }
      localObject = "";
      label319:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_A_ActionData != null) {
        break label469;
      }
      localObject = "";
      label337:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_I_ActionData != null) {
        break label477;
      }
      localObject = "";
      label355:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.fwFlag);
      paramObjectOutput.writeInt(this.mFlag);
      paramObjectOutput.writeBoolean(this.mHasSource);
      if (this.mCommentText != null) {
        break label485;
      }
      localObject = "";
      label403:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCompatibleText != null) {
        break label493;
      }
    }
    label437:
    label445:
    label453:
    label461:
    label469:
    label477:
    label485:
    label493:
    for (localObject = "";; localObject = this.mCompatibleText)
    {
      paramObjectOutput.writeUTF((String)localObject);
      return;
      localObject = this.mSourceIcon;
      break;
      localObject = this.mSourceName;
      break label265;
      localObject = this.mSourceUrl;
      break label283;
      localObject = this.mSourceAction;
      break label301;
      localObject = this.mSourceActionData;
      break label319;
      localObject = this.mSource_A_ActionData;
      break label337;
      localObject = this.mSource_I_ActionData;
      break label355;
      localObject = this.mCommentText;
      break label403;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForImageShare
 * JD-Core Version:    0.7.0.1
 */