package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import java.io.Externalizable;

public abstract class AbsStructMsg
  implements StructMsgConstants, Externalizable
{
  protected static final String DEFAULT_MSG_BRIEF = "应用分享";
  public String currentAccountUin;
  public int fwFlag = 0;
  public String mCommentText = null;
  public String mCompatibleText = "";
  public String mFileName = null;
  public long mFileSize = 0L;
  int mFlag;
  public String mMsgAction = "web";
  public String mMsgActionData = null;
  public String mMsgBrief = null;
  public String mMsgOldText = null;
  public int mMsgServiceID = -1;
  public int mMsgTemplateID = -1;
  public String mMsgUrl = null;
  public String mMsg_A_ActionData = null;
  public String mMsg_I_ActionData = null;
  public String mResid = null;
  int mVersion = 1;
  public int messageVersion;
  public String uin;
  public int uinType;
  public long uniseq;
  
  AbsStructMsg() {}
  
  AbsStructMsg(Bundle paramBundle)
  {
    this.mMsgTemplateID = 1;
    this.mMsgServiceID = 1;
    this.mMsgAction = "web";
    this.mMsgActionData = "";
    this.mMsgUrl = paramBundle.getString("detail_url");
    this.mMsg_A_ActionData = "";
    this.mCommentText = paramBundle.getString("share_comment_message");
  }
  
  AbsStructMsg(StructMsgNode paramStructMsgNode)
  {
    parseMsgAttrubutes(paramStructMsgNode);
  }
  
  public boolean LayoutEquals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public void addFlag(int paramInt)
  {
    if ((this.mFlag & paramInt) == paramInt) {
      return;
    }
    this.mFlag |= paramInt;
  }
  
  public abstract byte[] getBytes();
  
  public abstract View getPreDialogView(Context paramContext, View paramView);
  
  public abstract View getSourceView(Context paramContext, View paramView);
  
  public View getView(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramOnLongClickAndTouchListener = paramView;
    if (paramView == null)
    {
      paramOnLongClickAndTouchListener = new LinearLayout(paramContext);
      paramOnLongClickAndTouchListener.setOrientation(1);
      paramOnLongClickAndTouchListener.setBackgroundResource(2130839399);
      paramContext = paramOnLongClickAndTouchListener.getLayoutParams();
      if (paramContext != null) {
        break label55;
      }
      paramContext = new LinearLayout.LayoutParams(BaseChatItemLayout.g, -2);
    }
    for (;;)
    {
      paramOnLongClickAndTouchListener.setLayoutParams(paramContext);
      return paramOnLongClickAndTouchListener;
      label55:
      paramContext.width = BaseChatItemLayout.g;
      paramContext.height = -2;
    }
  }
  
  public abstract byte[] getXmlBytes();
  
  public boolean hasFlag(int paramInt)
  {
    return (this.mFlag & paramInt) == paramInt;
  }
  
  protected void parseMsgAttrubutes(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    for (;;)
    {
      return;
      String str = paramStructMsgNode.a("templateID");
      if (!TextUtils.isEmpty(str)) {
        this.mMsgTemplateID = Integer.parseInt(str);
      }
      this.mMsgUrl = paramStructMsgNode.a("url");
      this.mMsgAction = paramStructMsgNode.a("action");
      this.mMsgActionData = paramStructMsgNode.a("actionData");
      this.mMsg_A_ActionData = paramStructMsgNode.a("a_actionData");
      this.mMsg_I_ActionData = paramStructMsgNode.a("i_actionData");
      str = paramStructMsgNode.a("fwflag");
      if (!TextUtils.isEmpty(str)) {}
      try
      {
        this.fwFlag = Integer.parseInt(str);
        label99:
        str = paramStructMsgNode.a("flag");
        if (!TextUtils.isEmpty(str)) {}
        try
        {
          this.mFlag = Integer.parseInt(str);
          label121:
          str = paramStructMsgNode.a("serviceID");
          if (!TextUtils.isEmpty(str)) {
            this.mMsgServiceID = Integer.parseInt(str);
          }
          this.mMsgBrief = paramStructMsgNode.a("brief");
          this.mResid = paramStructMsgNode.a("m_resid");
          this.mFileName = paramStructMsgNode.a("m_fileName");
          paramStructMsgNode = paramStructMsgNode.a("m_fileSize");
          if (TextUtils.isEmpty(paramStructMsgNode)) {
            continue;
          }
          try
          {
            this.mFileSize = Long.parseLong(paramStructMsgNode);
            return;
          }
          catch (NumberFormatException paramStructMsgNode) {}
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          break label121;
        }
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        break label99;
      }
    }
  }
  
  public void setFlag(int paramInt)
  {
    this.mFlag = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsg
 * JD-Core Version:    0.7.0.1
 */