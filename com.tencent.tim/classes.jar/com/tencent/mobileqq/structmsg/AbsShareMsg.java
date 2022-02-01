package com.tencent.mobileqq.structmsg;

import acly;
import akyf;
import alte;
import amzo;
import anbi;
import anbk;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anpc;
import anqt;
import anqu;
import anqv;
import anqy;
import anra;
import anrd;
import ansf;
import ansi;
import ansr;
import ansu;
import ansv;
import antd;
import antp;
import anug;
import anux;
import anve;
import aokr;
import aooi;
import aoop;
import aqgc;
import arue;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.widget.HeightLimitedLinearLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ocp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wja;
import wte;

public abstract class AbsShareMsg
  extends AbsStructMsg
  implements Iterable<anqu>
{
  public static final int PACKAGE_NAME_INDEX = 0;
  public static final int URL_DATA_INDEX = 1;
  public int forwardType;
  public String mAdSourceIcon;
  public String mAdSourceMenu;
  public String mAdSourceName;
  public String mContentCover;
  public int mContentLayout = -1;
  public String mContentSrc;
  public String mContentSummary;
  public String mContentTitle;
  JSONObject mDatas = null;
  public boolean mHasAdSource;
  boolean mHasSource;
  public boolean mMsgException;
  public String mSourceAction;
  public String mSourceActionData;
  public long mSourceAppid = -1L;
  public String mSourceIcon;
  public String mSourceName;
  protected View.OnClickListener mSourceOnClickListener = new anqt(this);
  public String mSourceUrl;
  public String mSource_A_ActionData;
  public String mSource_I_ActionData;
  public List<anqu> mStructMsgItemLists = new ArrayList();
  public ShareData shareData = new ShareData();
  
  AbsShareMsg()
  {
    this.mVersion = 28;
  }
  
  AbsShareMsg(Bundle paramBundle)
  {
    super(paramBundle);
    this.mVersion = 28;
    this.mContentCover = paramBundle.getString("image_url_remote");
    if (this.mContentCover != null)
    {
      this.shareData.imageUrlStatus = paramBundle.getByte("struct_share_key_image_url_status", (byte)4).byteValue();
      this.mContentTitle = paramBundle.getString("title");
      this.mContentSummary = paramBundle.getString("desc");
      if (this.mContentTitle != null) {
        this.mContentTitle = anbk.w(this.mContentTitle, false);
      }
      if (this.mContentSummary != null) {
        this.mContentSummary = anbk.w(this.mContentSummary, false);
      }
      this.mMsgAction = paramBundle.getString("struct_share_key_content_action");
      this.mMsgActionData = paramBundle.getString("struct_share_key_content_action_DATA");
      this.mMsg_A_ActionData = paramBundle.getString("struct_share_key_content_a_action_DATA");
      this.mMsg_I_ActionData = paramBundle.getString("struct_share_key_content_i_action_DATA");
      this.mSourceAppid = paramBundle.getLong("req_share_id", -1L);
      this.mSourceUrl = paramBundle.getString("struct_share_key_source_url");
      this.mSourceAction = paramBundle.getString("struct_share_key_source_action");
      if (TextUtils.isEmpty(this.mSourceAction)) {
        this.mSourceAction = "app";
      }
      this.mSourceActionData = paramBundle.getString("struct_share_key_source_action_data");
      this.mSource_A_ActionData = paramBundle.getString("struct_share_key_source_a_action_data");
      this.mSource_I_ActionData = paramBundle.getString("struct_share_key_source_i_action_data");
      if ((TextUtils.isEmpty(this.mSource_I_ActionData)) && (this.mSourceAppid > 0L) && (!"plugin".equals(this.mSourceAction))) {
        this.mSource_I_ActionData = String.format("tencent%d://", new Object[] { Long.valueOf(this.mSourceAppid) });
      }
      this.mSourceIcon = paramBundle.getString("struct_share_key_source_icon");
      this.mSourceName = paramBundle.getString("struct_share_key_source_name");
      this.forwardType = paramBundle.getInt("forward_type");
      if ((this.forwardType != 11) && (TextUtils.isEmpty(this.mSourceName))) {
        this.mSourceName = paramBundle.getString("app_name");
      }
      this.mMsgBrief = paramBundle.getString("brief_key");
      if (TextUtils.isEmpty(this.mMsgBrief))
      {
        if (TextUtils.isEmpty(this.mSourceName)) {
          break label1019;
        }
        this.mMsgBrief = String.format(chU, new Object[] { this.mSourceName });
      }
      label437:
      this.mResid = paramBundle.getString("mm_resid");
      this.mFileName = paramBundle.getString("mm_file_name");
      this.mFileSize = paramBundle.getLong("mm_file_size");
      this.mCompatibleText = paramBundle.getString("compatible_text");
      this.fwFlag = paramBundle.getInt("is_share_flag", 0);
      if ((!this.mHasSource) && ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon)))) {
        this.mHasSource = true;
      }
      if ((TextUtils.isEmpty(this.mContentTitle)) && (TextUtils.isEmpty(this.mContentSummary))) {
        if (!TextUtils.isEmpty(this.mSourceName)) {
          break label1029;
        }
      }
    }
    label1029:
    for (this.mContentTitle = chT;; this.mContentTitle = String.format(chS, new Object[] { this.mSourceName }))
    {
      this.mNeedRound = paramBundle.getString("icon_need_round");
      this.mFlag = paramBundle.getInt("flag");
      this.shareData.appInfoStatus = paramBundle.getByte("struct_share_key_app_info_status", (byte)0).byteValue();
      this.shareData.sourceIconBig = paramBundle.getString("struct_share_key_source_icon_big");
      this.shareData.pkgName = paramBundle.getString("pkg_name");
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, new StringBuilder().append("msgUrl = ").append(this.mMsgUrl).toString() + new StringBuilder().append(", mVersion = ").append(this.mVersion).toString() + ", mContentCover = " + this.mContentCover + ", mContentTitle = " + this.mContentTitle + ", mContentSummary = " + this.mContentSummary + ", mMsgAction = " + this.mMsgAction + ", mMsgActionData = " + this.mMsgActionData + ", mMsg_A_ActionData = " + this.mMsg_A_ActionData + ", mMsg_I_ActionData = " + this.mMsg_I_ActionData + ", mSourceAppid = " + this.mSourceAppid + ", mSourceUrl = " + this.mSourceUrl + ", mSourceAction = " + this.mSourceAction + ", mSourceActionData = " + this.mSourceActionData + ", mSource_A_ActionData = " + this.mSource_A_ActionData + ", mSource_I_ActionData = " + this.mSource_I_ActionData + ", mSourceIcon = " + this.mSourceIcon + ", mSourceName = " + this.mSourceName + ", mMsgBrief = " + this.mMsgBrief + ", mResid = " + this.mResid + ", mFileName = " + this.mFileName + ", mFileSize = " + this.mFileSize + ", mCompatibleText = " + this.mCompatibleText + ", fwFlag = " + this.fwFlag + ", mHasSource = " + this.mHasSource + ", mSType = " + this.mSType);
      }
      return;
      this.mContentCover = paramBundle.getString("image_url");
      this.shareData.imageUrlStatus = 2;
      break;
      label1019:
      this.mMsgBrief = DEFAULT_MSG_BRIEF;
      break label437;
    }
  }
  
  AbsShareMsg(ansf paramansf)
  {
    super(paramansf);
    this.mVersion = 28;
    int m = paramansf.Ks();
    int i = 0;
    if (i < m)
    {
      ansf localansf = paramansf.a(i);
      int k;
      if (localansf == null) {
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        if (localansf.name.equals("source"))
        {
          parseSourceNode(localansf);
          k = j;
          if (j != 0)
          {
            parseDefaultContentNode();
            k = j;
          }
        }
        else if (localansf.name.equals("sourceAd"))
        {
          parseAdSourceNode(localansf);
          k = j;
          if (j != 0)
          {
            parseDefaultContentNode();
            k = j;
          }
        }
        else if ((this.mMsgServiceID == 128) && (localansf.name.equals("data")))
        {
          parseDataNode(localansf);
          k = j;
        }
        else
        {
          k = j;
          if (j == 0)
          {
            k = j;
            if (!parseContentNode(localansf))
            {
              this.mStructMsgItemLists.clear();
              k = 1;
            }
          }
        }
      }
    }
  }
  
  private boolean ayU()
  {
    if (!TextUtils.isEmpty(this.mSourceAction)) {
      return false;
    }
    if ((this.mStructMsgItemLists == null) || (this.mStructMsgItemLists.isEmpty())) {
      return false;
    }
    Object localObject = (anqu)this.mStructMsgItemLists.get(0);
    if (!(localObject instanceof anug)) {
      return false;
    }
    localObject = (anug)localObject;
    if ((((anug)localObject).rz == null) || (((anug)localObject).rz.isEmpty())) {
      return false;
    }
    localObject = (anqu)((anug)localObject).rz.get(0);
    if (!(localObject instanceof ansu)) {
      return false;
    }
    return ((ansu)localObject).useCustomSize();
  }
  
  public static final void doReport(QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg)
  {
    anpc.a(BaseApplication.getContext()).a(paramQQAppInterface, paramAbsShareMsg.uin, "Structured_msg", "Clk_smsg", 0, 1, null, String.valueOf(paramAbsShareMsg.mSourceAppid), String.valueOf(paramAbsShareMsg.mMsgServiceID), paramAbsShareMsg.mMsgAction, null);
    if (QLog.isColorLevel()) {
      QLog.d("StructMsg", 2, "doReport msg:" + paramAbsShareMsg);
    }
  }
  
  public static final String[] parsePackageNameAndData(String paramString1, String paramString2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (TextUtils.isEmpty(paramString2)) {
      if (!TextUtils.isEmpty(paramString1)) {
        break label49;
      }
    }
    label49:
    for (int i = -1;; i = paramString1.indexOf("://"))
    {
      if (i != -1) {
        break label60;
      }
      arrayOfString[0] = paramString1;
      return arrayOfString;
      paramString1 = paramString2;
      break;
    }
    label60:
    arrayOfString[0] = paramString1.substring(0, i);
    arrayOfString[1] = paramString1.substring(i + 3);
    return arrayOfString;
  }
  
  public static void resendSdkFakeMessage(MessageForArkApp paramMessageForArkApp, JSONObject paramJSONObject, akyf paramakyf)
  {
    paramMessageForArkApp = aokr.a(paramMessageForArkApp, paramJSONObject, paramakyf);
    ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().a(paramMessageForArkApp);
  }
  
  public static void resendSdkShareMessage(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, AbsShareMsg paramAbsShareMsg)
  {
    paramMessageRecord = anbi.e(paramMessageRecord);
    wte.a().i(paramMessageRecord.uniseq, paramAbsShareMsg.parentUniseq, paramAbsShareMsg.forwardID);
    paramQQAppInterface.b().b(paramMessageRecord, MessageHandler.cwL);
    paramMessageRecord = aokr.a(paramMessageRecord, paramAbsShareMsg);
    paramQQAppInterface.a().a(paramMessageRecord);
  }
  
  public static MessageForArkApp sendSdkFakeMessage(Bundle paramBundle, QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg, String paramString1, int paramInt, String paramString2, akyf paramakyf)
  {
    paramBundle = aqgc.a(paramBundle, paramQQAppInterface, paramString1, paramInt, paramString2);
    wte.a().i(paramBundle.uniseq, paramAbsShareMsg.parentUniseq, paramAbsShareMsg.forwardID);
    paramQQAppInterface.b().b(paramBundle, MessageHandler.cwL);
    paramAbsShareMsg = aokr.a(paramBundle, paramAbsShareMsg, paramakyf);
    QLog.d("StructMsg", 1, new Object[] { "sendSdkFakeMessage uinType=", Integer.valueOf(paramInt), ", groupUin=", paramString2, ", done=", Boolean.valueOf(paramQQAppInterface.a().a(paramAbsShareMsg)) });
    return paramBundle;
  }
  
  public static void sendSdkShareMessage(QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg, String paramString1, int paramInt, String paramString2)
  {
    int i = amzo.seq;
    amzo.seq = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = str;
    }
    for (;;)
    {
      paramString1 = anbi.a(paramQQAppInterface, str, paramString1, paramString2, paramInt, l, paramAbsShareMsg);
      wte.a().i(paramString1.uniseq, paramAbsShareMsg.parentUniseq, paramAbsShareMsg.forwardID);
      paramQQAppInterface.b().b(paramString1, MessageHandler.cwM);
      paramAbsShareMsg = aokr.a(paramString1, paramAbsShareMsg);
      paramQQAppInterface.a().a(paramAbsShareMsg);
      return;
    }
  }
  
  public static void sendSdkShareMessageByServer(QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg, String paramString1, int paramInt, String paramString2, akyf paramakyf)
  {
    int i = amzo.seq;
    amzo.seq = i + 1;
    long l = i;
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = str;
    }
    for (;;)
    {
      paramString1 = anbi.a(paramQQAppInterface, str, paramString1, paramString2, paramInt, l, paramAbsShareMsg);
      wte.a().i(paramString1.uniseq, paramAbsShareMsg.parentUniseq, paramAbsShareMsg.forwardID);
      paramAbsShareMsg = aokr.a(paramString1, paramAbsShareMsg, paramakyf);
      QLog.d("StructMsg", 1, new Object[] { "sendSdkShareMessageByServer done=", Boolean.valueOf(paramQQAppInterface.a().a(paramAbsShareMsg)) });
      return;
    }
  }
  
  public void addItem(anqu paramanqu)
  {
    this.mStructMsgItemLists.add(paramanqu);
  }
  
  public void addItems(List<anqu> paramList)
  {
    this.mStructMsgItemLists.addAll(paramList);
  }
  
  public void clearItems()
  {
    this.mStructMsgItemLists.clear();
  }
  
  public anqu findXmlNode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int j = getItemCount();
    int i = 0;
    if (i < j)
    {
      Object localObject = getItemByIndex(i);
      if (localObject == null) {
        label32:
        break label61;
      }
      label61:
      label98:
      do
      {
        do
        {
          i += 1;
          break;
          if (!(localObject instanceof anqv)) {
            break label98;
          }
          localObject = ((anqv)localObject).rz.iterator();
        } while (!((Iterator)localObject).hasNext());
        anqu localanqu = (anqu)((Iterator)localObject).next();
        if (!paramString.equals(localanqu.mTypeName)) {
          break label32;
        }
        return localanqu;
      } while (!paramString.equals(((anqu)localObject).mTypeName));
      return localObject;
    }
    return null;
  }
  
  public byte[] getBytes()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      writeExternal(localObjectOutputStream);
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, localIOException.getMessage());
      }
    }
    return null;
  }
  
  public anqu getItemByIndex(int paramInt)
  {
    return (anqu)this.mStructMsgItemLists.get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.mStructMsgItemLists.size();
  }
  
  public abstract View.OnClickListener getOnClickListener();
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[@]", 2, "AbsShareMsg getPreDialogView start!");
    }
    HeightLimitedLinearLayout localHeightLimitedLinearLayout = new HeightLimitedLinearLayout(paramContext);
    Object localObject1 = new LinearLayout.LayoutParams(-1, -2);
    localHeightLimitedLinearLayout.setOrientation(1);
    try
    {
      localHeightLimitedLinearLayout.setMaxHeight(paramContext.getResources().getDisplayMetrics().heightPixels >> 1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      localHeightLimitedLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("pre_dialog", true);
      Iterator localIterator = this.mStructMsgItemLists.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label310;
        }
        Object localObject2 = (anqu)localIterator.next();
        View localView = ((anqu)localObject2).a(paramContext, paramView, (Bundle)localObject1);
        if ((localView != null) && ((!(localObject2 instanceof anug)) || (((anug)localObject2).dMi != 1)))
        {
          if ((localObject2 instanceof antd))
          {
            localTextView = (TextView)localView.findViewById(2131380976);
            if (localTextView != null)
            {
              localObject2 = (antd)localObject2;
              if ((((antd)localObject2).dMi != 1) && (((antd)localObject2).dMi != 3)) {
                break;
              }
              localTextView.setTextColor(-8355712);
            }
          }
          localHeightLimitedLinearLayout.addView(localView);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TextView localTextView;
        if (QLog.isColorLevel())
        {
          QLog.d("StructMsg", 2, "shareMsg preDialogView setMaxHeight error!");
          continue;
          localTextView.setGravity(16);
          localTextView.setMaxLines(2);
          localTextView.setTextSize(14.0F);
          localTextView.setTextColor(paramContext.getResources().getColor(2131165827));
          if (TextUtils.isEmpty(localTextView.getText()))
          {
            localTextView.setText("");
            localTextView.setVisibility(0);
          }
        }
      }
      label310:
      if (QLog.isColorLevel()) {
        QLog.d("[@]", 2, "AbsShareMsg getPreDialogView end!");
      }
    }
    return localHeightLimitedLinearLayout;
  }
  
  public String getSourceName()
  {
    return this.mSourceName;
  }
  
  public View getSourceView(Context paramContext, View paramView)
  {
    boolean bool = this.mHasSource;
    if (this.mMsgServiceID == 35) {
      bool = false;
    }
    if (!bool) {
      return null;
    }
    Resources localResources = paramContext.getResources();
    if (paramView == null)
    {
      paramView = new TextView(paramContext);
      paramView.setSingleLine(true);
      paramView.setGravity(16);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-1);
      paramView.setTextSize(2, 12.0F);
    }
    for (;;)
    {
      TextView localTextView = (TextView)paramView;
      localTextView.setText(this.mSourceName);
      localTextView.setBackgroundResource(2130843455);
      Drawable localDrawable1;
      if (!TextUtils.isEmpty(this.mSourceIcon))
      {
        Object localObject = this.mSourceIcon;
        Drawable localDrawable2 = localResources.getDrawable(2130851467);
        localDrawable2.setBounds(0, 0, wja.dp2px(12.0F, localResources), wja.dp2px(12.0F, localResources));
        localDrawable1 = localResources.getDrawable(2130851468);
        localDrawable1.setBounds(0, 0, wja.dp2px(12.0F, localResources), wja.dp2px(12.0F, localResources));
        try
        {
          localObject = URLDrawable.getDrawable((String)localObject, localDrawable2, localDrawable1);
          if (aoop.bD(paramContext)) {
            break label278;
          }
          bool = true;
          ((URLDrawable)localObject).setAutoDownload(bool);
          paramContext = (Context)localObject;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            QLog.e("StructMsg", 1, paramContext.getMessage(), paramContext);
            paramContext = localDrawable1;
          }
        }
        setCompoundDrawable(localTextView, paramContext, localResources);
      }
      for (;;)
      {
        localTextView.setPadding(wja.dp2px(5.0F, localResources), 0, wja.dp2px(5.0F, localResources), 0);
        paramView.setTag(this);
        paramView.setOnClickListener(this.mSourceOnClickListener);
        if (!ayU()) {
          break label314;
        }
        paramView.setClickable(false);
        QLog.d("StructMsg", 1, "mSourceOnClickListener =========forbidClickForImageShare ========= ");
        return paramView;
        label278:
        bool = false;
        break;
        localTextView.setCompoundDrawables(null, null, null, null);
      }
      label314:
      paramView.setClickable(true);
      return paramView;
    }
  }
  
  public List<anqu> getStructMsgItemLists()
  {
    return this.mStructMsgItemLists;
  }
  
  public String getTalkBackStr()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    anqu localanqu;
    label118:
    do
    {
      for (;;)
      {
        try
        {
          if (this.mStructMsgItemLists != null)
          {
            Iterator localIterator = this.mStructMsgItemLists.iterator();
            if (localIterator.hasNext())
            {
              localObject = (anqu)localIterator.next();
              if (!(localObject instanceof ansv)) {
                break label118;
              }
              localObject = ((ansv)localObject).rz.iterator();
              if (((Iterator)localObject).hasNext())
              {
                localanqu = (anqu)((Iterator)localObject).next();
                if (!(localanqu instanceof StructMsgItemTitle)) {
                  continue;
                }
                localStringBuffer.append(((StructMsgItemTitle)localanqu).text);
                continue;
              }
              continue;
            }
          }
          return localStringBuffer.toString();
        }
        catch (Exception localException) {}
        if (!(localObject instanceof antd)) {
          break;
        }
        localObject = (antd)localObject;
        localStringBuffer.append("链接");
        localObject = ((antd)localObject).rz.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localanqu = (anqu)((Iterator)localObject).next();
          if ((localanqu instanceof StructMsgItemTitle)) {
            localStringBuffer.append(((StructMsgItemTitle)localanqu).text);
          } else if ((localanqu instanceof anux)) {
            localStringBuffer.append(((anux)localanqu).text);
          }
        }
      }
    } while (!(localObject instanceof antp));
    Object localObject = (antp)localObject;
    int i = 0;
    localObject = ((antp)localObject).rz.iterator();
    label248:
    if (((Iterator)localObject).hasNext())
    {
      localanqu = (anqu)((Iterator)localObject).next();
      if (("type".equals(localanqu.mTypeName)) && ((localanqu instanceof anve))) {
        i = ((anve)localanqu).type;
      }
    }
    for (;;)
    {
      localStringBuffer.append("文本");
      for (;;)
      {
        localStringBuffer.append("回执消息");
        if (!this.message.isSend()) {
          break label363;
        }
        localStringBuffer.append(",查看阅读状态");
        break;
        localStringBuffer.append("图片");
        continue;
        localStringBuffer.append("语音");
      }
      label363:
      if ("1".equals(alte.u(this.message)))
      {
        localStringBuffer.append(",已读");
        break;
      }
      localStringBuffer.append(",未读");
      break;
      break label248;
      switch (i)
      {
      }
    }
  }
  
  public boolean isSdkShareMsg()
  {
    return ForwardUtils.au(this.forwardType, this.mMsgServiceID);
  }
  
  public Iterator<anqu> iterator()
  {
    return this.mStructMsgItemLists.iterator();
  }
  
  protected void parseAdSourceNode(ansf paramansf)
  {
    if (paramansf == null) {}
    do
    {
      JSONObject localJSONObject1;
      for (;;)
      {
        return;
        this.mAdSourceName = paramansf.getAttribute("name");
        if (!this.mAdSourceName.equals("")) {
          this.mHasAdSource = true;
        }
        try
        {
          if (this.mHasAdSource)
          {
            localJSONObject1 = new JSONObject();
            JSONArray localJSONArray = new JSONArray();
            paramansf = paramansf.children;
            if ((paramansf != null) && (!paramansf.isEmpty()))
            {
              paramansf = paramansf.iterator();
              while (paramansf.hasNext())
              {
                Object localObject = ((ansf)paramansf.next()).children;
                if ((localObject != null) && (!((List)localObject).isEmpty()))
                {
                  localObject = ((List)localObject).iterator();
                  while (((Iterator)localObject).hasNext())
                  {
                    ansf localansf = (ansf)((Iterator)localObject).next();
                    JSONObject localJSONObject2 = new JSONObject();
                    localJSONObject2.put("icon_url", localansf.getAttribute("icon_url"));
                    localJSONObject2.put("action_type", localansf.getAttribute("action_type"));
                    localJSONObject2.put("title", localansf.getAttribute("title"));
                    localJSONObject2.put("action_url", localansf.getAttribute("action_url"));
                    localJSONArray.put(localJSONObject2);
                  }
                }
              }
            }
            localJSONObject1.put("menus", localJSONArray);
          }
        }
        catch (Exception paramansf)
        {
          paramansf.printStackTrace();
          return;
        }
      }
      this.mAdSourceMenu = localJSONObject1.toString();
    } while (!QLog.isColorLevel());
    QLog.d("StructMsg", 2, "mAdSourceMenu: " + this.mAdSourceMenu);
  }
  
  protected abstract boolean parseContentNode(ansf paramansf);
  
  protected void parseDataNode(ansf paramansf)
  {
    if (this.mDatas == null) {
      this.mDatas = new JSONObject();
    }
    if (("data".equals(paramansf.name)) && (this.mMsgServiceID == 128) && (TextUtils.equals("2", paramansf.getAttribute("msgtype")))) {}
    try
    {
      this.mDatas.put("groupcode", paramansf.getAttribute("groupcode"));
      this.mDatas.put("groupname", paramansf.getAttribute("groupname"));
      this.mDatas.put("msgseq", paramansf.getAttribute("msgseq"));
      this.mDatas.put("msgtype", paramansf.getAttribute("msgtype"));
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "parseDataNode json:" + this.mDatas.toString());
      }
      return;
    }
    catch (JSONException paramansf)
    {
      for (;;)
      {
        QLog.d("StructMsg", 1, "parseDataNode error:" + paramansf.getMessage());
      }
    }
  }
  
  protected void parseDefaultContentNode()
  {
    anqv localanqv = anrd.a(2);
    localanqv.aU("", this.mMsgBrief, chV);
    addItem(localanqv);
  }
  
  protected void parseSourceNode(ansf paramansf)
  {
    if (paramansf == null) {
      return;
    }
    this.mSourceAppid = ansi.getLongValue(paramansf.getAttribute("appid"));
    this.mSourceName = paramansf.getAttribute("name");
    if (TextUtils.isEmpty(this.mMsgBrief))
    {
      this.mEmptyMsgBriefModified = true;
      if (TextUtils.isEmpty(this.mSourceName)) {
        break label175;
      }
    }
    label175:
    for (this.mMsgBrief = String.format(chU, new Object[] { this.mSourceName });; this.mMsgBrief = DEFAULT_MSG_BRIEF)
    {
      this.mSourceIcon = paramansf.getAttribute("icon");
      this.mSourceUrl = paramansf.getAttribute("url");
      this.mSourceAction = paramansf.getAttribute("action");
      this.mSourceActionData = paramansf.getAttribute("actionData");
      this.mSource_A_ActionData = paramansf.getAttribute("a_actionData");
      this.mSource_I_ActionData = paramansf.getAttribute("i_actionData");
      if ((this.mHasSource) || ((TextUtils.isEmpty(this.mSourceName)) && (TextUtils.isEmpty(this.mSourceIcon)))) {
        break;
      }
      this.mHasSource = true;
      return;
    }
  }
  
  public abstract void report(Object paramObject);
  
  protected void setCompoundDrawable(TextView paramTextView, Drawable paramDrawable, Resources paramResources)
  {
    paramDrawable = new BitmapDrawable(ansr.e(paramDrawable));
    paramTextView.setCompoundDrawablePadding(wja.dp2px(3.0F, paramResources));
    paramDrawable.setBounds(0, 0, wja.dp2px(14.0F, paramResources), wja.dp2px(14.0F, paramResources));
    paramTextView.setCompoundDrawables(paramDrawable, null, null, null);
  }
  
  public void setHasSource(boolean paramBoolean)
  {
    this.mHasSource = paramBoolean;
  }
  
  public void setSourceIcon(String paramString)
  {
    this.mSourceIcon = paramString;
  }
  
  public void setSourceName(String paramString)
  {
    this.mSourceName = paramString;
  }
  
  public void setStructMsgItemLists(List<anqu> paramList)
  {
    this.mStructMsgItemLists = paramList;
  }
  
  protected abstract void toContentXml(AbsStructMsg.a parama)
    throws IOException;
  
  protected void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    int i = 1;
    AbsStructMsg.a locala = new AbsStructMsg.a(this, new anqy());
    label797:
    label1064:
    try
    {
      locala.setOutput(paramByteArrayOutputStream, paramString);
      locala.startDocument(paramString, Boolean.valueOf(true));
      locala.startTag(null, "msg");
      locala.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      locala.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      if (this.mMsgAction != null) {
        break label996;
      }
      paramByteArrayOutputStream = "";
      locala.attribute(null, "action", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.mMsgActionData)) {
        locala.attribute(null, "actionData", this.mMsgActionData);
      }
      if (!TextUtils.isEmpty(this.mMsg_A_ActionData)) {
        locala.attribute(null, "a_actionData", this.mMsg_A_ActionData);
      }
      if (!TextUtils.isEmpty(this.mMsg_I_ActionData)) {
        locala.attribute(null, "i_actionData", this.mMsg_I_ActionData);
      }
      if (this.mMsgBrief != null) {
        break label1004;
      }
      paramByteArrayOutputStream = "";
      label185:
      locala.attribute(null, "brief", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.mResid)) {
        locala.attribute(null, "m_resid", this.mResid);
      }
      if (!TextUtils.isEmpty(this.mFileName)) {
        locala.attribute(null, "m_fileName", this.mFileName);
      }
      if (this.mTSum > 0) {
        locala.attribute(null, "tSum", String.valueOf(this.mTSum));
      }
      if (this.mFileSize > 0L) {
        locala.attribute(null, "m_fileSize", String.valueOf(this.mFileSize));
      }
      if (!TextUtils.isEmpty(this.source_puin)) {
        locala.attribute(null, "sourcePublicUin", this.source_puin);
      }
      locala.attribute(null, "sourceMsgId", String.valueOf(this.msgId));
      if (this.fwFlag == 1) {
        locala.attribute(null, "fwflag", String.valueOf(this.fwFlag));
      }
      if (this.mMsgUrl != null) {
        break label1012;
      }
      paramByteArrayOutputStream = "";
      label371:
      locala.attribute(null, "url", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.rijAlbumActionData)) {
        locala.attribute(null, "rijAlbumActionData", this.rijAlbumActionData);
      }
      locala.attribute(null, "flag", String.valueOf(this.mFlag));
      if (!TextUtils.isEmpty(this.mSType)) {
        locala.attribute(null, "sType", this.mSType);
      }
      if (this.sourceAccoutType == SOURCE_ACCOUNT_TYPE_PA) {
        locala.attribute(null, "accostType", String.valueOf(SOURCE_ACCOUNT_TYPE_PA));
      }
      paramByteArrayOutputStream = String.valueOf(this.adverSign);
      if (!TextUtils.isEmpty(paramByteArrayOutputStream)) {
        locala.attribute(null, "adverSign", paramByteArrayOutputStream);
      }
      if (!TextUtils.isEmpty(this.adverKey)) {
        locala.attribute(null, "adverKey", this.adverKey);
      }
      if (!TextUtils.isEmpty(this.mExtraData)) {
        locala.attribute(null, "extraData", this.mExtraData);
      }
      if (!TextUtils.isEmpty(this.mCreateTime)) {
        locala.attribute(null, "createTime", this.mCreateTime);
      }
      if (!TextUtils.isEmpty(this.mTagName)) {
        locala.attribute(null, "tagName", this.mTagName);
      }
      if (!TextUtils.isEmpty(this.mSourceThirdName)) {
        locala.attribute(null, "sourceName", this.mSourceThirdName);
      }
      if (!TextUtils.isEmpty(this.mQQStoryExtra)) {
        locala.attribute(null, "qqstoryExtra", this.mQQStoryExtra);
      }
      if (!TextUtils.isEmpty(this.mTribeShortVideoExtra)) {
        locala.attribute(null, "qqtribeVideoInfoExtra", this.mTribeShortVideoExtra);
      }
      if (!TextUtils.isEmpty(this.mNeedRound)) {
        locala.attribute(null, "needRoundView", this.mNeedRound);
      }
      if (!TextUtils.isEmpty(this.mCommonData)) {
        locala.attribute(null, "msgCommonData", this.mCommonData);
      }
      locala.attribute(null, "multiMsgFlag", String.valueOf(this.multiMsgFlag));
      if (!TextUtils.isEmpty(this.mQzoneExtraMsg)) {
        locala.attribute(null, "qzFloatExtra", this.mQzoneExtraMsg);
      }
      toContentXml(locala);
      if (this.mMsgServiceID != 128) {
        break label1064;
      }
    }
    catch (Exception paramByteArrayOutputStream)
    {
      label819:
      label996:
      label1004:
      label1012:
      label1020:
      while (QLog.isColorLevel())
      {
        QLog.d("StructMsg", 2, paramByteArrayOutputStream.getMessage(), paramByteArrayOutputStream);
        return;
        i = 0;
      }
    }
    if (i == 0)
    {
      locala.startTag(null, "source");
      if (this.mSourceName != null) {
        break label1020;
      }
      paramByteArrayOutputStream = "";
      locala.attribute(null, "name", paramByteArrayOutputStream);
      if (this.mSourceIcon != null) {
        break label1028;
      }
      paramByteArrayOutputStream = "";
      locala.attribute(null, "icon", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.mSourceUrl)) {
        locala.attribute(null, "url", this.mSourceUrl);
      }
      if (this.mSourceAction != null) {
        break label1036;
      }
    }
    label1028:
    label1036:
    for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mSourceAction)
    {
      locala.attribute(null, "action", paramByteArrayOutputStream);
      if (!TextUtils.isEmpty(this.mSourceActionData)) {
        locala.attribute(null, "actionData", this.mSourceActionData);
      }
      if (!TextUtils.isEmpty(this.mSource_A_ActionData)) {
        locala.attribute(null, "a_actionData", this.mSource_A_ActionData);
      }
      if (!TextUtils.isEmpty(this.mSource_I_ActionData)) {
        locala.attribute(null, "i_actionData", this.mSource_I_ActionData);
      }
      locala.attribute(null, "appid", String.valueOf(this.mSourceAppid));
      locala.endTag(null, "source");
      locala.endTag(null, "msg");
      locala.endDocument();
      locala.flush();
      return;
      paramByteArrayOutputStream = this.mMsgAction;
      break;
      paramByteArrayOutputStream = this.mMsgBrief;
      break label185;
      paramByteArrayOutputStream = this.mMsgUrl;
      break label371;
      paramByteArrayOutputStream = this.mSourceName;
      break label797;
      paramByteArrayOutputStream = this.mSourceIcon;
      break label819;
    }
  }
  
  public void updateCover(String paramString)
  {
    this.mContentCover = paramString;
  }
  
  public void updateTitleSummaryAndCover(String paramString1, String paramString2, String paramString3)
  {
    this.mContentTitle = paramString1;
    this.mContentSummary = paramString2;
    this.mContentCover = paramString3;
  }
  
  public static class ShareData
    implements Externalizable
  {
    public static final byte APP_INFO_STATUS_INIT = 0;
    public static final byte APP_INFO_STATUS_READY = 1;
    public static final byte IMAGE_URL_STATUS_INIT = 0;
    public static final byte IMAGE_URL_STATUS_LOCAL = 2;
    public static final byte IMAGE_URL_STATUS_OK = 1;
    public static final byte IMAGE_URL_STATUS_REMOTE = 4;
    public static final byte IMAGE_URL_STATUS_REMOTE_CHANGED = 3;
    public static final byte SHORT_URL_STATUS_CHANGED = 1;
    public static final byte SHORT_URL_STATUS_INIT = 0;
    public byte appInfoStatus = 0;
    public byte imageUrlStatus = 0;
    public String pkgName;
    public byte shortUrlStatus = 0;
    public String sourceIconBig;
    public int status;
    public byte version = 1;
    
    public boolean isFinish()
    {
      return this.status == 1003;
    }
    
    public void readExternal(ObjectInput paramObjectInput)
      throws IOException
    {
      this.version = paramObjectInput.readByte();
      this.appInfoStatus = paramObjectInput.readByte();
      this.imageUrlStatus = paramObjectInput.readByte();
      this.shortUrlStatus = paramObjectInput.readByte();
      this.status = paramObjectInput.readInt();
      this.pkgName = paramObjectInput.readUTF();
      this.sourceIconBig = paramObjectInput.readUTF();
    }
    
    public void writeExternal(ObjectOutput paramObjectOutput)
      throws IOException
    {
      paramObjectOutput.writeByte(this.version);
      paramObjectOutput.writeByte(this.appInfoStatus);
      paramObjectOutput.writeByte(this.imageUrlStatus);
      paramObjectOutput.writeByte(this.shortUrlStatus);
      paramObjectOutput.writeInt(this.status);
      if (this.pkgName == null)
      {
        str = "";
        paramObjectOutput.writeUTF(str);
        if (this.sourceIconBig != null) {
          break label93;
        }
      }
      label93:
      for (String str = "";; str = this.sourceIconBig)
      {
        paramObjectOutput.writeUTF(str);
        return;
        str = this.pkgName;
        break;
      }
    }
  }
  
  public static class a
  {
    int dLX;
    AbsShareMsg f;
    Class<? extends AbsShareMsg> mClass;
    String mCompatibleText = null;
    String mFileName = null;
    long mFileSize = 0L;
    int mFlag;
    boolean mHasSource;
    String mMsgAction = "web";
    String mMsgActionData = null;
    String mMsgBrief = null;
    int mMsgServiceID = -1;
    int mMsgTemplateID = -1;
    String mMsgUrl = null;
    String mMsg_A_ActionData = null;
    String mMsg_I_ActionData = null;
    String mResid = null;
    String mSType = null;
    String mSourceAction = null;
    String mSourceActionData = null;
    long mSourceAppid = -1L;
    String mSourceIcon = null;
    String mSourceName = null;
    String mSourceUrl = null;
    String mSource_A_ActionData = null;
    String mSource_I_ActionData = null;
    int mVersion;
    
    public a(Class<? extends AbsShareMsg> paramClass)
    {
      this.mClass = paramClass;
      this.mMsgTemplateID = 1;
      this.mMsgServiceID = 1;
      this.mMsgAction = "web";
      this.mVersion = 28;
    }
    
    public a a(int paramInt)
    {
      this.mFlag = paramInt;
      if ((paramInt & 0x1) == 1) {
        this.dLX = 1;
      }
      return this;
    }
    
    public a a(long paramLong)
    {
      this.mSourceAppid = paramLong;
      return this;
    }
    
    public a a(String paramString)
    {
      this.mMsgBrief = paramString;
      return this;
    }
    
    public a a(String paramString1, String paramString2)
    {
      this.mSourceName = paramString1;
      this.mSourceIcon = paramString2;
      if ((!TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString2))) {
        this.mHasSource = true;
      }
      return this;
    }
    
    public a a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.mMsgAction = paramString1;
      this.mMsgUrl = paramString2;
      this.mMsgActionData = paramString3;
      this.mMsg_A_ActionData = paramString4;
      this.mMsg_I_ActionData = paramString5;
      return this;
    }
    
    public AbsShareMsg a()
    {
      try
      {
        this.f = ((AbsShareMsg)this.mClass.newInstance());
        label14:
        if (this.f != null)
        {
          this.f.mMsgTemplateID = this.mMsgTemplateID;
          this.f.mMsgServiceID = this.mMsgServiceID;
          this.f.mVersion = this.mVersion;
          this.f.mMsgAction = this.mMsgAction;
          this.f.mMsgActionData = this.mMsgActionData;
          this.f.mMsg_A_ActionData = this.mMsg_A_ActionData;
          this.f.mMsg_I_ActionData = this.mMsg_I_ActionData;
          this.f.mMsgUrl = this.mMsgUrl;
          this.f.mMsgBrief = this.mMsgBrief;
          this.f.mCompatibleText = this.mCompatibleText;
          this.f.mFlag = this.mFlag;
          this.f.mSourceAction = this.mSourceAction;
          this.f.mSourceUrl = this.mSourceUrl;
          this.f.mSourceActionData = this.mSourceActionData;
          this.f.mSource_A_ActionData = this.mSource_A_ActionData;
          this.f.mSource_I_ActionData = this.mSource_I_ActionData;
          this.f.mSourceName = this.mSourceName;
          this.f.mSourceIcon = this.mSourceIcon;
          this.f.mHasSource = this.mHasSource;
          this.f.mResid = this.mResid;
          this.f.mFileName = this.mFileName;
          this.f.mFileSize = this.mFileSize;
          this.f.mSType = this.mSType;
        }
        return this.f;
      }
      catch (InstantiationException localInstantiationException)
      {
        break label14;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        break label14;
      }
    }
    
    public a b(int paramInt)
    {
      this.mMsgTemplateID = paramInt;
      return this;
    }
    
    public a b(String paramString)
    {
      this.mResid = paramString;
      return this;
    }
    
    public a b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.mSourceAction = paramString1;
      this.mSourceUrl = paramString2;
      this.mSourceActionData = paramString3;
      this.mSource_A_ActionData = paramString4;
      this.mSource_I_ActionData = paramString5;
      return this;
    }
    
    public a c(int paramInt)
    {
      this.mMsgServiceID = paramInt;
      return this;
    }
    
    public a c(String paramString)
    {
      this.mFileName = paramString;
      return this;
    }
    
    public a d(String paramString)
    {
      this.mCompatibleText = paramString;
      return this;
    }
    
    public a e(String paramString)
    {
      return a("web", paramString, null, null, null);
    }
    
    public a f(String paramString)
    {
      return b("web", paramString, null, null, null);
    }
  }
  
  public class b
    extends anra
  {
    public b(QQAppInterface paramQQAppInterface, View paramView)
    {
      super(paramView);
    }
    
    public boolean click2YYB(Activity paramActivity, long paramLong, String paramString1, String paramString2, String paramString3)
    {
      paramString1 = AbsShareMsg.parsePackageNameAndData(paramString2, paramString3)[0];
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "SourceClickHandler click2YYB  appid = " + paramLong + "; packageName=" + paramString1);
      }
      if (TextUtils.isEmpty(paramString1)) {
        return false;
      }
      paramString2 = new Bundle();
      paramString2.putString("packageName", paramString1);
      paramString2.putString("appId", paramLong + "");
      paramString2.putString("big_brother_source_key", "biz_src_jc_aio");
      arue.s(paramActivity, paramString2);
      return true;
    }
    
    public boolean clickWebMsg(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "SourceClickHandler clickWebMsg  url = " + paramString);
      }
      if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))) {
        return false;
      }
      Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("title", AbsShareMsg.this.mSourceName);
      localIntent.putExtra("url", paramString);
      ocp.a(AbsShareMsg.this.message, localIntent, paramString);
      this.mContext.startActivity(localIntent);
      anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString, "", "", "");
      return true;
    }
    
    public boolean j(String paramString1, String paramString2, String paramString3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, "SourceClickHandler clickAppMsg url = " + paramString1 + ", actionData = " + paramString2 + ", actionDataA = " + paramString3);
      }
      paramString1 = AbsShareMsg.parsePackageNameAndData(paramString2, paramString3);
      paramString2 = this.mContext.getPackageManager();
      try
      {
        if (paramString2.getPackageInfo(paramString1[0], 1) != null)
        {
          paramString2 = paramString2.getLaunchIntentForPackage(paramString1[0]);
          if (paramString2 == null) {
            return false;
          }
          paramString2.putExtra("big_brother_source_key", "biz_src_jc_aio");
          paramString2.addFlags(67108864);
          if (!TextUtils.isEmpty(paramString1[1])) {
            paramString2.setData(Uri.parse(paramString1[1]));
          }
          try
          {
            paramString3 = (acly)this.mApp.getBusinessHandler(23);
            paramString2.putExtra("report_open_type", "structmsg_source");
            paramString2.putExtra("report_url", "");
            paramString2.putExtra("report_from", "1");
            paramString2.putExtra("report_click_origin", "AIOTail");
            paramString2.putExtra("report_class_name", this.mContext.getClass().getName());
            paramString3.b(paramString1[0].trim(), this.mContext, paramString2);
            return true;
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler AbsShareMSG Failed!");
              }
              this.mContext.startActivity(paramString2);
            }
          }
        }
        return false;
      }
      catch (PackageManager.NameNotFoundException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, paramString1.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsShareMsg
 * JD-Core Version:    0.7.0.1
 */