package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemProgress;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import gkq;
import gkv;
import gkw;
import gkx;
import gky;
import gkz;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.List;

public class StructMsgForGeneralShare
  extends AbsShareMsg
{
  private static View.OnClickListener a = new gkz();
  
  StructMsgForGeneralShare()
  {
    this.mMsgServiceID = 1;
    this.mMsgAction = "web";
  }
  
  StructMsgForGeneralShare(Bundle paramBundle)
  {
    super(paramBundle);
    this.mContentLayout = 2;
    this.mMsgServiceID = paramBundle.getInt("req_type", 1);
    this.mSourceUrl = paramBundle.getString("source_url");
    paramBundle = paramBundle.getString("category");
    AbsStructMsgItem localAbsStructMsgItem1 = StructMsgElementFactory.a(2);
    if (!TextUtils.isEmpty(paramBundle))
    {
      AbsStructMsgItem localAbsStructMsgItem2 = StructMsgElementFactory.a(0);
      localAbsStructMsgItem2.b(paramBundle);
      addItem(localAbsStructMsgItem2);
      localAbsStructMsgItem1.a(this.mContentCover, this.mContentTitle, this.mContentSummary, 1);
    }
    for (;;)
    {
      addItem(localAbsStructMsgItem1);
      if (this.mMsgAction == null) {
        this.mMsgAction = "web";
      }
      return;
      localAbsStructMsgItem1.a(this.mContentCover, this.mContentTitle, this.mContentSummary);
    }
  }
  
  StructMsgForGeneralShare(StructMsgNode paramStructMsgNode)
  {
    super(paramStructMsgNode);
  }
  
  public boolean LayoutEquals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == null);
      bool1 = bool2;
    } while (getClass() != paramObject.getClass());
    paramObject = (StructMsgForGeneralShare)paramObject;
    return getLayoutStr().equals(paramObject.getLayoutStr());
  }
  
  public String getLayoutStr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.mStructMsgItemLists != null)
    {
      Iterator localIterator = this.mStructMsgItemLists.iterator();
      while (localIterator.hasNext()) {
        localStringBuffer.append(((AbsStructMsgElement)localIterator.next()).a());
      }
    }
    return localStringBuffer.toString();
  }
  
  public View.OnClickListener getOnClickListener()
  {
    return a;
  }
  
  public int getProgress()
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("progress");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemProgress))) {
      return ((StructMsgItemProgress)localAbsStructMsgElement).b();
    }
    return -1;
  }
  
  public View getView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    int j = 0;
    int i = 0;
    if (paramView == null)
    {
      localObject1 = (ViewGroup)super.getView(paramContext, paramView, paramOnLongClickAndTouchListener);
      if (localObject1 == null) {
        return null;
      }
      j = getItemCount();
      if (j > 0) {
        if (i < j)
        {
          localObject2 = getItemByIndex(i);
          if (((AbsStructMsgElement)localObject2).a() == 0)
          {
            if (i == 0) {
              ((AbsStructMsgElement)localObject2).b(1);
            }
            if (i == j - 1) {
              ((AbsStructMsgElement)localObject2).b(2);
            }
          }
          View localView = ((AbsStructMsgElement)localObject2).a(paramContext, paramView);
          if (localView != null)
          {
            if (!TextUtils.isEmpty(((AbsStructMsgElement)localObject2).c))
            {
              localView.setTag(localObject2);
              localView.setClickable(true);
              localView.setOnClickListener((View.OnClickListener)localObject2);
              localView.setOnLongClickListener(new gkv(this, paramOnLongClickAndTouchListener));
              localView.setOnTouchListener(new gkw(this, paramOnLongClickAndTouchListener));
            }
            ((ViewGroup)localObject1).addView(localView);
          }
          for (;;)
          {
            i += 1;
            break;
            if (QLog.isDevelopLevel()) {
              QLog.e("StructMsg", 4, "Create item view failure by #StructMsgItemViewFactory");
            }
          }
        }
      }
      paramContext = ((ViewGroup)localObject1).getLayoutParams();
      if (paramContext == null)
      {
        paramContext = new LinearLayout.LayoutParams(BaseChatItemLayout.g, -2);
        if (hasFlag(4))
        {
          paramContext.width = -1;
          ((ViewGroup)localObject1).setBackgroundResource(2130837691);
        }
        ((ViewGroup)localObject1).setLayoutParams(paramContext);
      }
    }
    int k;
    do
    {
      do
      {
        ((View)localObject1).setId(2131230767);
        ((View)localObject1).setTag(2131230767, this);
        return localObject1;
        paramContext.width = BaseChatItemLayout.g;
        paramContext.height = -2;
        break;
        k = getItemCount();
        localObject1 = paramView;
      } while (k <= 0);
      i = j;
      localObject1 = paramView;
    } while (i >= k);
    Object localObject1 = getItemByIndex(i);
    Object localObject2 = ((AbsStructMsgElement)localObject1).a(paramContext, ((ViewGroup)paramView).getChildAt(i));
    if (localObject2 != null) {
      if (!TextUtils.isEmpty(((AbsStructMsgElement)localObject1).c))
      {
        ((View)localObject2).setTag(localObject1);
        ((View)localObject2).setClickable(true);
        ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
        ((View)localObject2).setOnLongClickListener(new gkx(this, paramOnLongClickAndTouchListener));
        ((View)localObject2).setOnTouchListener(new gky(this, paramOnLongClickAndTouchListener));
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (QLog.isDevelopLevel()) {
        QLog.e("StructMsg", 4, "Create item view failure by #StructMsgItemViewFactory");
      }
    }
  }
  
  protected boolean parseContentNode(StructMsgNode paramStructMsgNode)
  {
    boolean bool = false;
    if (paramStructMsgNode == null) {
      bool = true;
    }
    Object localObject;
    do
    {
      return bool;
      if ("item".equals(paramStructMsgNode.b)) {}
      for (localObject = paramStructMsgNode.a("layout");; localObject = StructMsgElementFactory.a(paramStructMsgNode.b))
      {
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject)) {}
          for (int i = Integer.parseInt((String)localObject);; i = 0)
          {
            localObject = StructMsgElementFactory.a(i);
            if (localObject != null) {
              break;
            }
            return true;
          }
          if (!QLog.isDevelopLevel()) {
            break;
          }
        }
        catch (NumberFormatException paramStructMsgNode) {}
        QLog.d("StructMsg", 4, "Item layout value is " + 0);
        return false;
      }
    } while (!((AbsStructMsgElement)localObject).a(paramStructMsgNode));
    addItem((AbsStructMsgElement)localObject);
    return true;
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
    }
    for (;;)
    {
      if ((!this.mHasSource) && ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon)))) {
        this.mHasSource = true;
      }
      return;
      if ((j == 2) || (j == 3))
      {
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
        this.mCommentText = paramObjectInput.readUTF();
        if (j == 3) {
          this.mCompatibleText = paramObjectInput.readUTF();
        }
      }
    }
  }
  
  @Deprecated
  public void setProgress(int paramInt)
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("progress");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemProgress))) {
      ((StructMsgItemProgress)localAbsStructMsgElement).d(paramInt);
    }
  }
  
  @Deprecated
  public void setSummary(String paramString)
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("summary");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemSummary))) {
      ((StructMsgItemSummary)localAbsStructMsgElement).a(paramString);
    }
  }
  
  @Deprecated
  public void setTitle(String paramString)
  {
    AbsStructMsgElement localAbsStructMsgElement = findXmlNode("title");
    if ((localAbsStructMsgElement != null) && ((localAbsStructMsgElement instanceof StructMsgItemTitle))) {
      ((StructMsgItemTitle)localAbsStructMsgElement).a(paramString);
    }
  }
  
  protected void toContentXml(gkq paramgkq)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      ((AbsStructMsgElement)localIterator.next()).a(paramgkq);
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
        break label427;
      }
      localObject = "";
      label265:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceUrl != null) {
        break label435;
      }
      localObject = "";
      label283:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceAction != null) {
        break label443;
      }
      localObject = "";
      label301:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSourceActionData != null) {
        break label451;
      }
      localObject = "";
      label319:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_A_ActionData != null) {
        break label459;
      }
      localObject = "";
      label337:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mSource_I_ActionData != null) {
        break label467;
      }
      localObject = "";
      label355:
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.fwFlag);
      paramObjectOutput.writeInt(this.mFlag);
      if (this.mCommentText != null) {
        break label475;
      }
      localObject = "";
      label393:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.mCompatibleText != null) {
        break label483;
      }
    }
    label427:
    label435:
    label443:
    label451:
    label459:
    label467:
    label475:
    label483:
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
      break label393;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForGeneralShare
 * JD-Core Version:    0.7.0.1
 */