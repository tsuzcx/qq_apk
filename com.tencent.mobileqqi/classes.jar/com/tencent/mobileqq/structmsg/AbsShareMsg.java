package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.international.LocaleString;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.widget.HeightLimitedLinearLayout;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gov;
import gow;
import goy;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbsShareMsg
  extends AbsStructMsg
  implements Iterable
{
  private static final int F = 3;
  protected static final int PACKAGE_NAME_INDEX = 0;
  protected static final int URL_DATA_INDEX = 1;
  public String mContentCover = null;
  public int mContentLayout = -1;
  public String mContentSrc = null;
  public String mContentSummary = null;
  public String mContentTitle = null;
  boolean mHasSource;
  public String mSourceAction = null;
  public String mSourceActionData = null;
  public long mSourceAppid = -1L;
  public String mSourceIcon = null;
  public String mSourceName = null;
  protected View.OnClickListener mSourceOnClickListener = new gow(this);
  public String mSourceUrl = null;
  public String mSource_A_ActionData = null;
  public String mSource_I_ActionData = null;
  public List mStructMsgItemLists = new ArrayList();
  private URLDrawableDownListener.Adapter mUrlAdapter = new gov(this);
  
  AbsShareMsg()
  {
    this.mVersion = 3;
  }
  
  AbsShareMsg(Bundle paramBundle)
  {
    super(paramBundle);
    this.mVersion = 3;
    this.mContentCover = paramBundle.getString("image_url_remote");
    this.mContentTitle = paramBundle.getString("title");
    this.mContentSummary = paramBundle.getString("desc");
    if (this.mContentTitle != null) {
      this.mContentTitle = MessageUtils.a(this.mContentTitle, false);
    }
    if (this.mContentSummary != null) {
      this.mContentSummary = MessageUtils.a(this.mContentSummary, false);
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
    this.mSourceName = paramBundle.getString("app_name");
    if (TextUtils.isEmpty(this.mSourceName)) {
      this.mSourceName = paramBundle.getString("struct_share_key_source_name");
    }
    this.mMsgBrief = paramBundle.getString("brief_key");
    if (TextUtils.isEmpty(this.mMsgBrief))
    {
      if (!TextUtils.isEmpty(this.mSourceName)) {
        this.mMsgBrief = String.format("%s 的分享", new Object[] { this.mSourceName });
      }
    }
    else
    {
      this.mCompatibleText = paramBundle.getString("compatible_text");
      this.fwFlag = paramBundle.getInt("is_share_flag", 0);
      if ((!this.mHasSource) && ((!TextUtils.isEmpty(this.mSourceName)) || (!TextUtils.isEmpty(this.mSourceIcon)))) {
        this.mHasSource = true;
      }
      if ((TextUtils.isEmpty(this.mContentTitle)) && (TextUtils.isEmpty(this.mContentSummary))) {
        if (!TextUtils.isEmpty(this.mSourceName)) {
          break label851;
        }
      }
    }
    label851:
    for (this.mContentTitle = "这个不错, 分享之";; this.mContentTitle = String.format("刚在%s看到, 分享之", new Object[] { this.mSourceName }))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, new StringBuilder().append("msgUrl = ").append(this.mMsgUrl).toString() + new StringBuilder().append(", mVersion = ").append(this.mVersion).toString() + ", mContentCover = " + this.mContentCover + ", mContentTitle = " + this.mContentTitle + ", mContentSummary = " + this.mContentSummary + ", mMsgAction = " + this.mMsgAction + ", mMsgActionData = " + this.mMsgActionData + ", mMsg_A_ActionData = " + this.mMsg_A_ActionData + ", mMsg_I_ActionData = " + this.mMsg_I_ActionData + ", mSourceAppid = " + this.mSourceAppid + ", mSourceUrl = " + this.mSourceUrl + ", mSourceAction = " + this.mSourceAction + ", mSourceActionData = " + this.mSourceActionData + ", mSource_A_ActionData = " + this.mSource_A_ActionData + ", mSource_I_ActionData = " + this.mSource_I_ActionData + ", mSourceIcon = " + this.mSourceIcon + ", mSourceName = " + this.mSourceName + ", mMsgBrief = " + this.mMsgBrief + ", mCompatibleText = " + this.mCompatibleText + ", fwFlag = " + this.fwFlag + ", mHasSource = " + this.mHasSource);
      }
      return;
      this.mMsgBrief = "应用分享";
      break;
    }
  }
  
  AbsShareMsg(StructMsgNode paramStructMsgNode)
  {
    super(paramStructMsgNode);
    this.mVersion = 3;
    int m = paramStructMsgNode.a();
    int i = 0;
    if (i < m)
    {
      StructMsgNode localStructMsgNode = paramStructMsgNode.a(i);
      int k;
      if (localStructMsgNode == null) {
        k = j;
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        if (localStructMsgNode.b.equals("source"))
        {
          parseSourceNode(localStructMsgNode);
          k = j;
          if (j != 0)
          {
            parseDefaultContentNode();
            k = j;
          }
        }
        else
        {
          k = j;
          if (j == 0)
          {
            k = j;
            if (!parseContentNode(localStructMsgNode))
            {
              this.mStructMsgItemLists.clear();
              k = 1;
            }
          }
        }
      }
    }
  }
  
  public static final void doReport(QQAppInterface paramQQAppInterface, AbsShareMsg paramAbsShareMsg)
  {
    StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramAbsShareMsg.uin, "Structured_msg", "Clk_smsg", 0, 1, null, String.valueOf(paramAbsShareMsg.mSourceAppid), String.valueOf(paramAbsShareMsg.mMsgServiceID), paramAbsShareMsg.mMsgAction, null);
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
  
  public void addItem(AbsStructMsgElement paramAbsStructMsgElement)
  {
    this.mStructMsgItemLists.add(paramAbsStructMsgElement);
  }
  
  public void addItems(List paramList)
  {
    this.mStructMsgItemLists.addAll(paramList);
  }
  
  public AbsStructMsgElement findXmlNode(String paramString)
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
          if (!(localObject instanceof AbsStructMsgItem)) {
            break label98;
          }
          localObject = ((AbsStructMsgItem)localObject).a.iterator();
        } while (!((Iterator)localObject).hasNext());
        AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
        if (!paramString.equals(localAbsStructMsgElement.a)) {
          break label32;
        }
        return localAbsStructMsgElement;
      } while (!paramString.equals(((AbsStructMsgElement)localObject).a));
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
  
  public AbsStructMsgElement getItemByIndex(int paramInt)
  {
    return (AbsStructMsgElement)this.mStructMsgItemLists.get(paramInt);
  }
  
  public int getItemCount()
  {
    return this.mStructMsgItemLists.size();
  }
  
  public abstract View.OnClickListener getOnClickListener();
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    HeightLimitedLinearLayout localHeightLimitedLinearLayout = new HeightLimitedLinearLayout(paramContext);
    Object localObject1 = new LinearLayout.LayoutParams(-1, -2);
    localHeightLimitedLinearLayout.setOrientation(1);
    try
    {
      localHeightLimitedLinearLayout.setMaxHeight(paramContext.getResources().getDisplayMetrics().heightPixels >> 1);
      ((LinearLayout.LayoutParams)localObject1).gravity = 1;
      localHeightLimitedLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.mStructMsgItemLists.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
        if ((localObject2 instanceof StructMsgItemLayout2))
        {
          Object localObject3 = (StructMsgItemTitle)((StructMsgItemLayout2)localObject2).a.get(1);
          ((StructMsgItemTitle)localObject3).k = LocaleString.i(paramContext, ((StructMsgItemTitle)localObject3).k);
          ((StructMsgItemLayout2)localObject2).a.remove(1);
          ((StructMsgItemLayout2)localObject2).a.add(1, localObject3);
          localObject3 = (StructMsgItemSummary)((StructMsgItemLayout2)localObject2).a.get(2);
          ((StructMsgItemSummary)localObject3).k = LocaleString.i(paramContext, ((StructMsgItemSummary)localObject3).k);
          ((StructMsgItemLayout2)localObject2).a.remove(2);
          ((StructMsgItemLayout2)localObject2).a.add(2, localObject3);
        }
        localObject2 = ((AbsStructMsgElement)localObject2).a(paramContext, paramView);
        if (localObject2 != null) {
          localHeightLimitedLinearLayout.addView((View)localObject2);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, "shareMsg preDialogView setMaxHeight error!");
        }
      }
    }
    return localHeightLimitedLinearLayout;
  }
  
  public View getSourceView(Context paramContext, View paramView)
  {
    if (!this.mHasSource) {
      return null;
    }
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(paramContext).inflate(2130903995, null);
    }
    Object localObject2 = paramContext.getResources();
    Object localObject1 = (TextView)localView.findViewById(2131234546);
    paramView = (URLImageView)localView.findViewById(2131234545);
    ((TextView)localObject1).setText(LocaleString.s(paramContext, this.mSourceName));
    boolean bool;
    if (!TextUtils.isEmpty(this.mSourceIcon))
    {
      paramView.setVisibility(0);
      localObject1 = this.mSourceIcon;
      localObject2 = ((Resources)localObject2).getDrawable(2130840240);
      localObject2 = URLDrawable.getDrawable((String)localObject1, (Drawable)localObject2, (Drawable)localObject2);
      if ((AbsDownloader.a((String)localObject1)) || (!URLDrawableHelper.a(paramContext)))
      {
        bool = true;
        ((URLDrawable)localObject2).setAutoDownload(bool);
        paramView.setImageDrawable((Drawable)localObject2);
        paramView.setURLDrawableDownListener(this.mUrlAdapter);
        if (((URLDrawable)localObject2).getStatus() != 1) {
          break label189;
        }
        paramView.setBackgroundDrawable(null);
      }
    }
    for (;;)
    {
      localView.setTag(this);
      localView.setOnClickListener(this.mSourceOnClickListener);
      return localView;
      bool = false;
      break;
      label189:
      paramView.setBackgroundColor(15790320);
      continue;
      paramView.setVisibility(8);
    }
  }
  
  /* Error */
  public byte[] getXmlBytes()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 423	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: invokespecial 424	java/io/ByteArrayOutputStream:<init>	()V
    //   9: astore 4
    //   11: new 625	goy
    //   14: dup
    //   15: aload_0
    //   16: invokestatic 631	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
    //   19: invokespecial 634	goy:<init>	(Lcom/tencent/mobileqq/structmsg/AbsStructMsg;Lorg/xmlpull/v1/XmlSerializer;)V
    //   22: astore 5
    //   24: aload 5
    //   26: aload 4
    //   28: ldc_w 636
    //   31: invokevirtual 640	goy:setOutput	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   34: aload 5
    //   36: ldc_w 636
    //   39: iconst_1
    //   40: invokestatic 645	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   43: invokevirtual 649	goy:startDocument	(Ljava/lang/String;Ljava/lang/Boolean;)V
    //   46: aload 5
    //   48: aconst_null
    //   49: ldc_w 651
    //   52: invokevirtual 655	goy:startTag	(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   55: pop
    //   56: aload 5
    //   58: aconst_null
    //   59: ldc_w 657
    //   62: aload_0
    //   63: getfield 348	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgServiceID	I
    //   66: invokestatic 351	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   69: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   72: pop
    //   73: aload 5
    //   75: aconst_null
    //   76: ldc_w 663
    //   79: aload_0
    //   80: getfield 666	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgTemplateID	I
    //   83: invokestatic 351	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   86: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   89: pop
    //   90: aload_0
    //   91: getfield 115	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgAction	Ljava/lang/String;
    //   94: ifnonnull +490 -> 584
    //   97: ldc_w 363
    //   100: astore_2
    //   101: aload 5
    //   103: aconst_null
    //   104: ldc_w 668
    //   107: aload_2
    //   108: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   111: pop
    //   112: aload_0
    //   113: getfield 120	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgActionData	Ljava/lang/String;
    //   116: ifnonnull +476 -> 592
    //   119: ldc_w 363
    //   122: astore_2
    //   123: aload 5
    //   125: aconst_null
    //   126: ldc_w 670
    //   129: aload_2
    //   130: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   133: pop
    //   134: aload_0
    //   135: getfield 125	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsg_A_ActionData	Ljava/lang/String;
    //   138: ifnonnull +462 -> 600
    //   141: ldc_w 363
    //   144: astore_2
    //   145: aload 5
    //   147: aconst_null
    //   148: ldc_w 672
    //   151: aload_2
    //   152: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   155: pop
    //   156: aload_0
    //   157: getfield 130	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsg_I_ActionData	Ljava/lang/String;
    //   160: ifnonnull +448 -> 608
    //   163: ldc_w 363
    //   166: astore_2
    //   167: aload 5
    //   169: aconst_null
    //   170: ldc_w 674
    //   173: aload_2
    //   174: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   177: pop
    //   178: aload_0
    //   179: getfield 187	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgBrief	Ljava/lang/String;
    //   182: ifnonnull +434 -> 616
    //   185: ldc_w 363
    //   188: astore_2
    //   189: aload 5
    //   191: aconst_null
    //   192: ldc_w 676
    //   195: aload_2
    //   196: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   199: pop
    //   200: aload_0
    //   201: getfield 203	com/tencent/mobileqq/structmsg/AbsShareMsg:fwFlag	I
    //   204: iconst_1
    //   205: if_icmpne +20 -> 225
    //   208: aload 5
    //   210: aconst_null
    //   211: ldc_w 678
    //   214: aload_0
    //   215: getfield 203	com/tencent/mobileqq/structmsg/AbsShareMsg:fwFlag	I
    //   218: invokestatic 351	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   221: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   224: pop
    //   225: aload_0
    //   226: getfield 227	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgUrl	Ljava/lang/String;
    //   229: ifnonnull +395 -> 624
    //   232: ldc_w 363
    //   235: astore_2
    //   236: aload 5
    //   238: aconst_null
    //   239: ldc_w 680
    //   242: aload_2
    //   243: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   246: pop
    //   247: aload 5
    //   249: aconst_null
    //   250: ldc_w 682
    //   253: aload_0
    //   254: getfield 685	com/tencent/mobileqq/structmsg/AbsShareMsg:mFlag	I
    //   257: invokestatic 351	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   260: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   263: pop
    //   264: aload_0
    //   265: aload 5
    //   267: invokevirtual 689	com/tencent/mobileqq/structmsg/AbsShareMsg:toContentXml	(Lgoy;)V
    //   270: aload 5
    //   272: aconst_null
    //   273: ldc_w 307
    //   276: invokevirtual 655	goy:startTag	(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   279: pop
    //   280: aload_0
    //   281: getfield 69	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceName	Ljava/lang/String;
    //   284: ifnonnull +348 -> 632
    //   287: ldc_w 363
    //   290: astore_2
    //   291: aload 5
    //   293: aconst_null
    //   294: ldc_w 691
    //   297: aload_2
    //   298: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   301: pop
    //   302: aload_0
    //   303: getfield 67	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceIcon	Ljava/lang/String;
    //   306: ifnonnull +334 -> 640
    //   309: ldc_w 363
    //   312: astore_2
    //   313: aload 5
    //   315: aconst_null
    //   316: ldc_w 693
    //   319: aload_2
    //   320: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   323: pop
    //   324: aload_0
    //   325: getfield 57	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceUrl	Ljava/lang/String;
    //   328: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   331: ifne +25 -> 356
    //   334: aload_0
    //   335: getfield 57	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceUrl	Ljava/lang/String;
    //   338: ifnonnull +310 -> 648
    //   341: ldc_w 363
    //   344: astore_2
    //   345: aload 5
    //   347: aconst_null
    //   348: ldc_w 680
    //   351: aload_2
    //   352: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   355: pop
    //   356: aload_0
    //   357: getfield 59	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceAction	Ljava/lang/String;
    //   360: ifnonnull +296 -> 656
    //   363: ldc_w 363
    //   366: astore_2
    //   367: aload 5
    //   369: aconst_null
    //   370: ldc_w 668
    //   373: aload_2
    //   374: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   377: pop
    //   378: aload_0
    //   379: getfield 61	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceActionData	Ljava/lang/String;
    //   382: ifnonnull +282 -> 664
    //   385: ldc_w 363
    //   388: astore_2
    //   389: aload 5
    //   391: aconst_null
    //   392: ldc_w 670
    //   395: aload_2
    //   396: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   399: pop
    //   400: aload_0
    //   401: getfield 63	com/tencent/mobileqq/structmsg/AbsShareMsg:mSource_A_ActionData	Ljava/lang/String;
    //   404: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   407: ifne +25 -> 432
    //   410: aload_0
    //   411: getfield 63	com/tencent/mobileqq/structmsg/AbsShareMsg:mSource_A_ActionData	Ljava/lang/String;
    //   414: ifnonnull +258 -> 672
    //   417: ldc_w 363
    //   420: astore_2
    //   421: aload 5
    //   423: aconst_null
    //   424: ldc_w 672
    //   427: aload_2
    //   428: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   431: pop
    //   432: aload_0
    //   433: getfield 65	com/tencent/mobileqq/structmsg/AbsShareMsg:mSource_I_ActionData	Ljava/lang/String;
    //   436: invokestatic 146	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   439: ifne +25 -> 464
    //   442: aload_0
    //   443: getfield 65	com/tencent/mobileqq/structmsg/AbsShareMsg:mSource_I_ActionData	Ljava/lang/String;
    //   446: ifnonnull +234 -> 680
    //   449: ldc_w 363
    //   452: astore_2
    //   453: aload 5
    //   455: aconst_null
    //   456: ldc_w 674
    //   459: aload_2
    //   460: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   463: pop
    //   464: aload 5
    //   466: aconst_null
    //   467: ldc_w 695
    //   470: aload_0
    //   471: getfield 73	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceAppid	J
    //   474: invokestatic 345	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   477: invokevirtual 661	goy:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   480: pop
    //   481: aload 5
    //   483: aconst_null
    //   484: ldc_w 307
    //   487: invokevirtual 698	goy:endTag	(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   490: pop
    //   491: aload 5
    //   493: aconst_null
    //   494: ldc_w 651
    //   497: invokevirtual 698	goy:endTag	(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   500: pop
    //   501: aload 5
    //   503: invokevirtual 701	goy:endDocument	()V
    //   506: aload 5
    //   508: invokevirtual 702	goy:flush	()V
    //   511: invokestatic 705	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   514: ifeq +38 -> 552
    //   517: aload 4
    //   519: ldc_w 636
    //   522: invokevirtual 707	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   525: astore_2
    //   526: ldc 215
    //   528: iconst_4
    //   529: new 217	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   536: ldc_w 709
    //   539: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload_2
    //   543: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   552: aload 4
    //   554: invokevirtual 442	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   557: invokestatic 714	com/tencent/mobileqq/structmsg/StructMsgUtils:b	([B)[B
    //   560: astore_2
    //   561: aload_2
    //   562: arraylength
    //   563: istore_1
    //   564: iload_1
    //   565: iconst_1
    //   566: iadd
    //   567: newarray byte
    //   569: astore_3
    //   570: aload_3
    //   571: iconst_0
    //   572: iconst_1
    //   573: bastore
    //   574: aload_2
    //   575: iconst_0
    //   576: aload_3
    //   577: iconst_1
    //   578: iload_1
    //   579: invokestatic 720	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   582: aload_3
    //   583: areturn
    //   584: aload_0
    //   585: getfield 115	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgAction	Ljava/lang/String;
    //   588: astore_2
    //   589: goto -488 -> 101
    //   592: aload_0
    //   593: getfield 120	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgActionData	Ljava/lang/String;
    //   596: astore_2
    //   597: goto -474 -> 123
    //   600: aload_0
    //   601: getfield 125	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsg_A_ActionData	Ljava/lang/String;
    //   604: astore_2
    //   605: goto -460 -> 145
    //   608: aload_0
    //   609: getfield 130	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsg_I_ActionData	Ljava/lang/String;
    //   612: astore_2
    //   613: goto -446 -> 167
    //   616: aload_0
    //   617: getfield 187	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgBrief	Ljava/lang/String;
    //   620: astore_2
    //   621: goto -432 -> 189
    //   624: aload_0
    //   625: getfield 227	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgUrl	Ljava/lang/String;
    //   628: astore_2
    //   629: goto -393 -> 236
    //   632: aload_0
    //   633: getfield 69	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceName	Ljava/lang/String;
    //   636: astore_2
    //   637: goto -346 -> 291
    //   640: aload_0
    //   641: getfield 67	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceIcon	Ljava/lang/String;
    //   644: astore_2
    //   645: goto -332 -> 313
    //   648: aload_0
    //   649: getfield 57	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceUrl	Ljava/lang/String;
    //   652: astore_2
    //   653: goto -308 -> 345
    //   656: aload_0
    //   657: getfield 59	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceAction	Ljava/lang/String;
    //   660: astore_2
    //   661: goto -294 -> 367
    //   664: aload_0
    //   665: getfield 61	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceActionData	Ljava/lang/String;
    //   668: astore_2
    //   669: goto -280 -> 389
    //   672: aload_0
    //   673: getfield 63	com/tencent/mobileqq/structmsg/AbsShareMsg:mSource_A_ActionData	Ljava/lang/String;
    //   676: astore_2
    //   677: goto -256 -> 421
    //   680: aload_0
    //   681: getfield 65	com/tencent/mobileqq/structmsg/AbsShareMsg:mSource_I_ActionData	Ljava/lang/String;
    //   684: astore_2
    //   685: goto -232 -> 453
    //   688: astore_2
    //   689: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   692: ifeq -181 -> 511
    //   695: ldc 215
    //   697: iconst_2
    //   698: aload_2
    //   699: invokevirtual 721	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   702: aload_2
    //   703: invokestatic 724	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   706: goto -195 -> 511
    //   709: astore_2
    //   710: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   713: ifeq -202 -> 511
    //   716: ldc 215
    //   718: iconst_2
    //   719: aload_2
    //   720: invokevirtual 725	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   723: aload_2
    //   724: invokestatic 724	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   727: goto -216 -> 511
    //   730: astore_2
    //   731: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   734: ifeq -223 -> 511
    //   737: ldc 215
    //   739: iconst_2
    //   740: aload_2
    //   741: invokevirtual 445	java/io/IOException:getMessage	()Ljava/lang/String;
    //   744: aload_2
    //   745: invokestatic 724	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   748: goto -237 -> 511
    //   751: astore 5
    //   753: aload_3
    //   754: astore_2
    //   755: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   758: ifeq -232 -> 526
    //   761: ldc 215
    //   763: iconst_2
    //   764: aload 5
    //   766: invokevirtual 726	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   769: aload 5
    //   771: invokestatic 724	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   774: aload_3
    //   775: astore_2
    //   776: goto -250 -> 526
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	779	0	this	AbsShareMsg
    //   563	16	1	i	int
    //   100	585	2	localObject	Object
    //   688	15	2	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   709	15	2	localIllegalStateException	java.lang.IllegalStateException
    //   730	15	2	localIOException	IOException
    //   754	22	2	arrayOfByte1	byte[]
    //   1	774	3	arrayOfByte2	byte[]
    //   9	544	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   22	485	5	localgoy	goy
    //   751	19	5	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   24	97	688	java/lang/IllegalArgumentException
    //   101	119	688	java/lang/IllegalArgumentException
    //   123	141	688	java/lang/IllegalArgumentException
    //   145	163	688	java/lang/IllegalArgumentException
    //   167	185	688	java/lang/IllegalArgumentException
    //   189	225	688	java/lang/IllegalArgumentException
    //   225	232	688	java/lang/IllegalArgumentException
    //   236	287	688	java/lang/IllegalArgumentException
    //   291	309	688	java/lang/IllegalArgumentException
    //   313	341	688	java/lang/IllegalArgumentException
    //   345	356	688	java/lang/IllegalArgumentException
    //   356	363	688	java/lang/IllegalArgumentException
    //   367	385	688	java/lang/IllegalArgumentException
    //   389	417	688	java/lang/IllegalArgumentException
    //   421	432	688	java/lang/IllegalArgumentException
    //   432	449	688	java/lang/IllegalArgumentException
    //   453	464	688	java/lang/IllegalArgumentException
    //   464	511	688	java/lang/IllegalArgumentException
    //   584	589	688	java/lang/IllegalArgumentException
    //   592	597	688	java/lang/IllegalArgumentException
    //   600	605	688	java/lang/IllegalArgumentException
    //   608	613	688	java/lang/IllegalArgumentException
    //   616	621	688	java/lang/IllegalArgumentException
    //   624	629	688	java/lang/IllegalArgumentException
    //   632	637	688	java/lang/IllegalArgumentException
    //   640	645	688	java/lang/IllegalArgumentException
    //   648	653	688	java/lang/IllegalArgumentException
    //   656	661	688	java/lang/IllegalArgumentException
    //   664	669	688	java/lang/IllegalArgumentException
    //   672	677	688	java/lang/IllegalArgumentException
    //   680	685	688	java/lang/IllegalArgumentException
    //   24	97	709	java/lang/IllegalStateException
    //   101	119	709	java/lang/IllegalStateException
    //   123	141	709	java/lang/IllegalStateException
    //   145	163	709	java/lang/IllegalStateException
    //   167	185	709	java/lang/IllegalStateException
    //   189	225	709	java/lang/IllegalStateException
    //   225	232	709	java/lang/IllegalStateException
    //   236	287	709	java/lang/IllegalStateException
    //   291	309	709	java/lang/IllegalStateException
    //   313	341	709	java/lang/IllegalStateException
    //   345	356	709	java/lang/IllegalStateException
    //   356	363	709	java/lang/IllegalStateException
    //   367	385	709	java/lang/IllegalStateException
    //   389	417	709	java/lang/IllegalStateException
    //   421	432	709	java/lang/IllegalStateException
    //   432	449	709	java/lang/IllegalStateException
    //   453	464	709	java/lang/IllegalStateException
    //   464	511	709	java/lang/IllegalStateException
    //   584	589	709	java/lang/IllegalStateException
    //   592	597	709	java/lang/IllegalStateException
    //   600	605	709	java/lang/IllegalStateException
    //   608	613	709	java/lang/IllegalStateException
    //   616	621	709	java/lang/IllegalStateException
    //   624	629	709	java/lang/IllegalStateException
    //   632	637	709	java/lang/IllegalStateException
    //   640	645	709	java/lang/IllegalStateException
    //   648	653	709	java/lang/IllegalStateException
    //   656	661	709	java/lang/IllegalStateException
    //   664	669	709	java/lang/IllegalStateException
    //   672	677	709	java/lang/IllegalStateException
    //   680	685	709	java/lang/IllegalStateException
    //   24	97	730	java/io/IOException
    //   101	119	730	java/io/IOException
    //   123	141	730	java/io/IOException
    //   145	163	730	java/io/IOException
    //   167	185	730	java/io/IOException
    //   189	225	730	java/io/IOException
    //   225	232	730	java/io/IOException
    //   236	287	730	java/io/IOException
    //   291	309	730	java/io/IOException
    //   313	341	730	java/io/IOException
    //   345	356	730	java/io/IOException
    //   356	363	730	java/io/IOException
    //   367	385	730	java/io/IOException
    //   389	417	730	java/io/IOException
    //   421	432	730	java/io/IOException
    //   432	449	730	java/io/IOException
    //   453	464	730	java/io/IOException
    //   464	511	730	java/io/IOException
    //   584	589	730	java/io/IOException
    //   592	597	730	java/io/IOException
    //   600	605	730	java/io/IOException
    //   608	613	730	java/io/IOException
    //   616	621	730	java/io/IOException
    //   624	629	730	java/io/IOException
    //   632	637	730	java/io/IOException
    //   640	645	730	java/io/IOException
    //   648	653	730	java/io/IOException
    //   656	661	730	java/io/IOException
    //   664	669	730	java/io/IOException
    //   672	677	730	java/io/IOException
    //   680	685	730	java/io/IOException
    //   517	526	751	java/io/UnsupportedEncodingException
  }
  
  public Iterator iterator()
  {
    return this.mStructMsgItemLists.iterator();
  }
  
  protected abstract boolean parseContentNode(StructMsgNode paramStructMsgNode);
  
  protected void parseDefaultContentNode()
  {
    AbsStructMsgItem localAbsStructMsgItem = StructMsgElementFactory.a(2);
    localAbsStructMsgItem.a("", this.mMsgBrief, "出错了");
    addItem(localAbsStructMsgItem);
  }
  
  protected void parseSourceNode(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return;
    }
    this.mSourceAppid = StructMsgUtils.a(paramStructMsgNode.a("appid"));
    this.mSourceName = paramStructMsgNode.a("name");
    if (TextUtils.isEmpty(this.mMsgBrief)) {
      if (TextUtils.isEmpty(this.mSourceName)) {
        break label169;
      }
    }
    label169:
    for (this.mMsgBrief = String.format("%s 的分享", new Object[] { this.mSourceName });; this.mMsgBrief = "应用分享")
    {
      this.mSourceIcon = paramStructMsgNode.a("icon");
      this.mSourceUrl = paramStructMsgNode.a("url");
      this.mSourceAction = paramStructMsgNode.a("action");
      this.mSourceActionData = paramStructMsgNode.a("actionData");
      this.mSource_A_ActionData = paramStructMsgNode.a("a_actionData");
      this.mSource_I_ActionData = paramStructMsgNode.a("i_actionData");
      if ((this.mHasSource) || ((TextUtils.isEmpty(this.mSourceName)) && (TextUtils.isEmpty(this.mSourceIcon)))) {
        break;
      }
      this.mHasSource = true;
      return;
    }
  }
  
  protected abstract void toContentXml(goy paramgoy);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsShareMsg
 * JD-Core Version:    0.7.0.1
 */