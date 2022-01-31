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
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.widget.HeightLimitedLinearLayout;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ees;
import eet;
import eev;
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
  private static final int I = 3;
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
  protected View.OnClickListener mSourceOnClickListener = new eet(this);
  public String mSourceUrl = null;
  public String mSource_A_ActionData = null;
  public String mSource_I_ActionData = null;
  List mStructMsgItemLists = new ArrayList();
  private URLDrawableDownListener.Adapter mUrlAdapter = new ees(this);
  
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
          break label928;
        }
      }
    }
    label928:
    for (this.mContentTitle = "这个不错, 分享之";; this.mContentTitle = String.format("刚在%s看到, 分享之", new Object[] { this.mSourceName }))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, new StringBuilder().append("msgUrl = ").append(this.mMsgUrl).toString() + new StringBuilder().append(", mVersion = ").append(this.mVersion).toString() + ", mContentCover = " + this.mContentCover + ", mContentTitle = " + this.mContentTitle + ", mContentSummary = " + this.mContentSummary + ", mMsgAction = " + this.mMsgAction + ", mMsgActionData = " + this.mMsgActionData + ", mMsg_A_ActionData = " + this.mMsg_A_ActionData + ", mMsg_I_ActionData = " + this.mMsg_I_ActionData + ", mSourceAppid = " + this.mSourceAppid + ", mSourceUrl = " + this.mSourceUrl + ", mSourceAction = " + this.mSourceAction + ", mSourceActionData = " + this.mSourceActionData + ", mSource_A_ActionData = " + this.mSource_A_ActionData + ", mSource_I_ActionData = " + this.mSource_I_ActionData + ", mSourceIcon = " + this.mSourceIcon + ", mSourceName = " + this.mSourceName + ", mMsgBrief = " + this.mMsgBrief + ", mResid = " + this.mResid + ", mFileName = " + this.mFileName + ", mFileSize = " + this.mFileSize + ", mCompatibleText = " + this.mCompatibleText + ", fwFlag = " + this.fwFlag + ", mHasSource = " + this.mHasSource);
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
    Object localObject = new LinearLayout.LayoutParams(-1, -2);
    localHeightLimitedLinearLayout.setOrientation(1);
    try
    {
      localHeightLimitedLinearLayout.setMaxHeight(paramContext.getResources().getDisplayMetrics().heightPixels >> 1);
      ((LinearLayout.LayoutParams)localObject).gravity = 1;
      localHeightLimitedLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = this.mStructMsgItemLists.iterator();
      while (((Iterator)localObject).hasNext())
      {
        View localView = ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramContext, paramView);
        if (localView != null) {
          localHeightLimitedLinearLayout.addView(localView);
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
      localView = LayoutInflater.from(paramContext).inflate(2130903668, null);
    }
    Object localObject2 = paramContext.getResources();
    Object localObject1 = (TextView)localView.findViewById(2131298883);
    paramView = (URLImageView)localView.findViewById(2131298882);
    ((TextView)localObject1).setText(this.mSourceName);
    boolean bool;
    if (!TextUtils.isEmpty(this.mSourceIcon))
    {
      paramView.setVisibility(0);
      localObject1 = this.mSourceIcon;
      localObject2 = ((Resources)localObject2).getDrawable(2130839401);
      localObject2 = URLDrawable.getDrawable((String)localObject1, (Drawable)localObject2, (Drawable)localObject2);
      if ((AbsDownloader.a((String)localObject1)) || (!URLDrawableHelper.a(paramContext)))
      {
        bool = true;
        ((URLDrawable)localObject2).setAutoDownload(bool);
        paramView.setImageDrawable((Drawable)localObject2);
        paramView.setURLDrawableDownListener(this.mUrlAdapter);
        if (((URLDrawable)localObject2).getStatus() != 1) {
          break label185;
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
      label185:
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
    //   2: new 446	java/io/ByteArrayOutputStream
    //   5: dup
    //   6: invokespecial 447	java/io/ByteArrayOutputStream:<init>	()V
    //   9: astore 4
    //   11: new 621	eev
    //   14: dup
    //   15: aload_0
    //   16: new 623	com/tencent/mobileqq/structmsg/QQXmlSerializer
    //   19: dup
    //   20: invokespecial 624	com/tencent/mobileqq/structmsg/QQXmlSerializer:<init>	()V
    //   23: invokespecial 627	eev:<init>	(Lcom/tencent/mobileqq/structmsg/AbsStructMsg;Lorg/xmlpull/v1/XmlSerializer;)V
    //   26: astore 5
    //   28: aload 5
    //   30: aload 4
    //   32: ldc_w 629
    //   35: invokevirtual 633	eev:setOutput	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   38: aload 5
    //   40: ldc_w 629
    //   43: iconst_1
    //   44: invokestatic 638	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   47: invokevirtual 642	eev:startDocument	(Ljava/lang/String;Ljava/lang/Boolean;)V
    //   50: aload 5
    //   52: aconst_null
    //   53: ldc_w 644
    //   56: invokevirtual 648	eev:startTag	(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   59: pop
    //   60: aload 5
    //   62: aconst_null
    //   63: ldc_w 650
    //   66: aload_0
    //   67: getfield 371	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgServiceID	I
    //   70: invokestatic 374	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   73: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   76: pop
    //   77: aload 5
    //   79: aconst_null
    //   80: ldc_w 656
    //   83: aload_0
    //   84: getfield 659	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgTemplateID	I
    //   87: invokestatic 374	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   90: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   93: pop
    //   94: aload_0
    //   95: getfield 114	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgAction	Ljava/lang/String;
    //   98: ifnonnull +551 -> 649
    //   101: ldc_w 386
    //   104: astore_2
    //   105: aload 5
    //   107: aconst_null
    //   108: ldc_w 661
    //   111: aload_2
    //   112: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   115: pop
    //   116: aload_0
    //   117: getfield 119	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgActionData	Ljava/lang/String;
    //   120: ifnonnull +537 -> 657
    //   123: ldc_w 386
    //   126: astore_2
    //   127: aload 5
    //   129: aconst_null
    //   130: ldc_w 663
    //   133: aload_2
    //   134: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   137: pop
    //   138: aload_0
    //   139: getfield 124	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsg_A_ActionData	Ljava/lang/String;
    //   142: ifnonnull +523 -> 665
    //   145: ldc_w 386
    //   148: astore_2
    //   149: aload 5
    //   151: aconst_null
    //   152: ldc_w 665
    //   155: aload_2
    //   156: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   159: pop
    //   160: aload_0
    //   161: getfield 129	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsg_I_ActionData	Ljava/lang/String;
    //   164: ifnonnull +509 -> 673
    //   167: ldc_w 386
    //   170: astore_2
    //   171: aload 5
    //   173: aconst_null
    //   174: ldc_w 667
    //   177: aload_2
    //   178: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   181: pop
    //   182: aload_0
    //   183: getfield 186	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgBrief	Ljava/lang/String;
    //   186: ifnonnull +495 -> 681
    //   189: ldc_w 386
    //   192: astore_2
    //   193: aload 5
    //   195: aconst_null
    //   196: ldc_w 669
    //   199: aload_2
    //   200: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   203: pop
    //   204: aload_0
    //   205: getfield 193	com/tencent/mobileqq/structmsg/AbsShareMsg:mResid	Ljava/lang/String;
    //   208: ifnonnull +481 -> 689
    //   211: ldc_w 386
    //   214: astore_2
    //   215: aload 5
    //   217: aconst_null
    //   218: ldc_w 671
    //   221: aload_2
    //   222: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   225: pop
    //   226: aload_0
    //   227: getfield 198	com/tencent/mobileqq/structmsg/AbsShareMsg:mFileName	Ljava/lang/String;
    //   230: ifnonnull +467 -> 697
    //   233: ldc_w 386
    //   236: astore_2
    //   237: aload 5
    //   239: aconst_null
    //   240: ldc_w 673
    //   243: aload_2
    //   244: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   247: pop
    //   248: aload 5
    //   250: aconst_null
    //   251: ldc_w 675
    //   254: aload_0
    //   255: getfield 206	com/tencent/mobileqq/structmsg/AbsShareMsg:mFileSize	J
    //   258: invokestatic 368	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   261: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   264: pop
    //   265: aload_0
    //   266: getfield 220	com/tencent/mobileqq/structmsg/AbsShareMsg:fwFlag	I
    //   269: iconst_1
    //   270: if_icmpne +20 -> 290
    //   273: aload 5
    //   275: aconst_null
    //   276: ldc_w 677
    //   279: aload_0
    //   280: getfield 220	com/tencent/mobileqq/structmsg/AbsShareMsg:fwFlag	I
    //   283: invokestatic 374	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   286: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   289: pop
    //   290: aload_0
    //   291: getfield 244	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgUrl	Ljava/lang/String;
    //   294: ifnonnull +411 -> 705
    //   297: ldc_w 386
    //   300: astore_2
    //   301: aload 5
    //   303: aconst_null
    //   304: ldc_w 679
    //   307: aload_2
    //   308: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   311: pop
    //   312: aload 5
    //   314: aconst_null
    //   315: ldc_w 681
    //   318: aload_0
    //   319: getfield 684	com/tencent/mobileqq/structmsg/AbsShareMsg:mFlag	I
    //   322: invokestatic 374	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   325: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   328: pop
    //   329: aload_0
    //   330: aload 5
    //   332: invokevirtual 688	com/tencent/mobileqq/structmsg/AbsShareMsg:toContentXml	(Leev;)V
    //   335: aload 5
    //   337: aconst_null
    //   338: ldc_w 330
    //   341: invokevirtual 648	eev:startTag	(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   344: pop
    //   345: aload_0
    //   346: getfield 68	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceName	Ljava/lang/String;
    //   349: ifnonnull +364 -> 713
    //   352: ldc_w 386
    //   355: astore_2
    //   356: aload 5
    //   358: aconst_null
    //   359: ldc_w 690
    //   362: aload_2
    //   363: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   366: pop
    //   367: aload_0
    //   368: getfield 66	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceIcon	Ljava/lang/String;
    //   371: ifnonnull +350 -> 721
    //   374: ldc_w 386
    //   377: astore_2
    //   378: aload 5
    //   380: aconst_null
    //   381: ldc_w 692
    //   384: aload_2
    //   385: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   388: pop
    //   389: aload_0
    //   390: getfield 56	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceUrl	Ljava/lang/String;
    //   393: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   396: ifne +25 -> 421
    //   399: aload_0
    //   400: getfield 56	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceUrl	Ljava/lang/String;
    //   403: ifnonnull +326 -> 729
    //   406: ldc_w 386
    //   409: astore_2
    //   410: aload 5
    //   412: aconst_null
    //   413: ldc_w 679
    //   416: aload_2
    //   417: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   420: pop
    //   421: aload_0
    //   422: getfield 58	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceAction	Ljava/lang/String;
    //   425: ifnonnull +312 -> 737
    //   428: ldc_w 386
    //   431: astore_2
    //   432: aload 5
    //   434: aconst_null
    //   435: ldc_w 661
    //   438: aload_2
    //   439: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   442: pop
    //   443: aload_0
    //   444: getfield 60	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceActionData	Ljava/lang/String;
    //   447: ifnonnull +298 -> 745
    //   450: ldc_w 386
    //   453: astore_2
    //   454: aload 5
    //   456: aconst_null
    //   457: ldc_w 663
    //   460: aload_2
    //   461: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   464: pop
    //   465: aload_0
    //   466: getfield 62	com/tencent/mobileqq/structmsg/AbsShareMsg:mSource_A_ActionData	Ljava/lang/String;
    //   469: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   472: ifne +25 -> 497
    //   475: aload_0
    //   476: getfield 62	com/tencent/mobileqq/structmsg/AbsShareMsg:mSource_A_ActionData	Ljava/lang/String;
    //   479: ifnonnull +274 -> 753
    //   482: ldc_w 386
    //   485: astore_2
    //   486: aload 5
    //   488: aconst_null
    //   489: ldc_w 665
    //   492: aload_2
    //   493: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   496: pop
    //   497: aload_0
    //   498: getfield 64	com/tencent/mobileqq/structmsg/AbsShareMsg:mSource_I_ActionData	Ljava/lang/String;
    //   501: invokestatic 145	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   504: ifne +25 -> 529
    //   507: aload_0
    //   508: getfield 64	com/tencent/mobileqq/structmsg/AbsShareMsg:mSource_I_ActionData	Ljava/lang/String;
    //   511: ifnonnull +250 -> 761
    //   514: ldc_w 386
    //   517: astore_2
    //   518: aload 5
    //   520: aconst_null
    //   521: ldc_w 667
    //   524: aload_2
    //   525: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   528: pop
    //   529: aload 5
    //   531: aconst_null
    //   532: ldc_w 694
    //   535: aload_0
    //   536: getfield 72	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceAppid	J
    //   539: invokestatic 368	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   542: invokevirtual 654	eev:attribute	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   545: pop
    //   546: aload 5
    //   548: aconst_null
    //   549: ldc_w 330
    //   552: invokevirtual 697	eev:endTag	(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   555: pop
    //   556: aload 5
    //   558: aconst_null
    //   559: ldc_w 644
    //   562: invokevirtual 697	eev:endTag	(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
    //   565: pop
    //   566: aload 5
    //   568: invokevirtual 700	eev:endDocument	()V
    //   571: aload 5
    //   573: invokevirtual 701	eev:flush	()V
    //   576: invokestatic 704	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   579: ifeq +38 -> 617
    //   582: aload 4
    //   584: ldc_w 629
    //   587: invokevirtual 706	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   590: astore_2
    //   591: ldc 232
    //   593: iconst_4
    //   594: new 234	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   601: ldc_w 708
    //   604: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: aload_2
    //   608: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   617: aload 4
    //   619: invokevirtual 465	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   622: invokestatic 713	com/tencent/mobileqq/structmsg/StructMsgUtils:b	([B)[B
    //   625: astore_2
    //   626: aload_2
    //   627: arraylength
    //   628: istore_1
    //   629: iload_1
    //   630: iconst_1
    //   631: iadd
    //   632: newarray byte
    //   634: astore_3
    //   635: aload_3
    //   636: iconst_0
    //   637: iconst_1
    //   638: bastore
    //   639: aload_2
    //   640: iconst_0
    //   641: aload_3
    //   642: iconst_1
    //   643: iload_1
    //   644: invokestatic 719	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   647: aload_3
    //   648: areturn
    //   649: aload_0
    //   650: getfield 114	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgAction	Ljava/lang/String;
    //   653: astore_2
    //   654: goto -549 -> 105
    //   657: aload_0
    //   658: getfield 119	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgActionData	Ljava/lang/String;
    //   661: astore_2
    //   662: goto -535 -> 127
    //   665: aload_0
    //   666: getfield 124	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsg_A_ActionData	Ljava/lang/String;
    //   669: astore_2
    //   670: goto -521 -> 149
    //   673: aload_0
    //   674: getfield 129	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsg_I_ActionData	Ljava/lang/String;
    //   677: astore_2
    //   678: goto -507 -> 171
    //   681: aload_0
    //   682: getfield 186	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgBrief	Ljava/lang/String;
    //   685: astore_2
    //   686: goto -493 -> 193
    //   689: aload_0
    //   690: getfield 193	com/tencent/mobileqq/structmsg/AbsShareMsg:mResid	Ljava/lang/String;
    //   693: astore_2
    //   694: goto -479 -> 215
    //   697: aload_0
    //   698: getfield 198	com/tencent/mobileqq/structmsg/AbsShareMsg:mFileName	Ljava/lang/String;
    //   701: astore_2
    //   702: goto -465 -> 237
    //   705: aload_0
    //   706: getfield 244	com/tencent/mobileqq/structmsg/AbsShareMsg:mMsgUrl	Ljava/lang/String;
    //   709: astore_2
    //   710: goto -409 -> 301
    //   713: aload_0
    //   714: getfield 68	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceName	Ljava/lang/String;
    //   717: astore_2
    //   718: goto -362 -> 356
    //   721: aload_0
    //   722: getfield 66	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceIcon	Ljava/lang/String;
    //   725: astore_2
    //   726: goto -348 -> 378
    //   729: aload_0
    //   730: getfield 56	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceUrl	Ljava/lang/String;
    //   733: astore_2
    //   734: goto -324 -> 410
    //   737: aload_0
    //   738: getfield 58	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceAction	Ljava/lang/String;
    //   741: astore_2
    //   742: goto -310 -> 432
    //   745: aload_0
    //   746: getfield 60	com/tencent/mobileqq/structmsg/AbsShareMsg:mSourceActionData	Ljava/lang/String;
    //   749: astore_2
    //   750: goto -296 -> 454
    //   753: aload_0
    //   754: getfield 62	com/tencent/mobileqq/structmsg/AbsShareMsg:mSource_A_ActionData	Ljava/lang/String;
    //   757: astore_2
    //   758: goto -272 -> 486
    //   761: aload_0
    //   762: getfield 64	com/tencent/mobileqq/structmsg/AbsShareMsg:mSource_I_ActionData	Ljava/lang/String;
    //   765: astore_2
    //   766: goto -248 -> 518
    //   769: astore_2
    //   770: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   773: ifeq -197 -> 576
    //   776: ldc 232
    //   778: iconst_2
    //   779: aload_2
    //   780: invokevirtual 720	java/lang/IllegalArgumentException:getMessage	()Ljava/lang/String;
    //   783: aload_2
    //   784: invokestatic 723	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   787: goto -211 -> 576
    //   790: astore_2
    //   791: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   794: ifeq -218 -> 576
    //   797: ldc 232
    //   799: iconst_2
    //   800: aload_2
    //   801: invokevirtual 724	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   804: aload_2
    //   805: invokestatic 723	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   808: goto -232 -> 576
    //   811: astore_2
    //   812: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   815: ifeq -239 -> 576
    //   818: ldc 232
    //   820: iconst_2
    //   821: aload_2
    //   822: invokevirtual 468	java/io/IOException:getMessage	()Ljava/lang/String;
    //   825: aload_2
    //   826: invokestatic 723	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   829: goto -253 -> 576
    //   832: astore 5
    //   834: aload_3
    //   835: astore_2
    //   836: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   839: ifeq -248 -> 591
    //   842: ldc 232
    //   844: iconst_2
    //   845: aload 5
    //   847: invokevirtual 725	java/io/UnsupportedEncodingException:getMessage	()Ljava/lang/String;
    //   850: aload 5
    //   852: invokestatic 723	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   855: aload_3
    //   856: astore_2
    //   857: goto -266 -> 591
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	860	0	this	AbsShareMsg
    //   628	16	1	i	int
    //   104	662	2	localObject	Object
    //   769	15	2	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   790	15	2	localIllegalStateException	java.lang.IllegalStateException
    //   811	15	2	localIOException	IOException
    //   835	22	2	arrayOfByte1	byte[]
    //   1	855	3	arrayOfByte2	byte[]
    //   9	609	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   26	546	5	localeev	eev
    //   832	19	5	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    // Exception table:
    //   from	to	target	type
    //   28	101	769	java/lang/IllegalArgumentException
    //   105	123	769	java/lang/IllegalArgumentException
    //   127	145	769	java/lang/IllegalArgumentException
    //   149	167	769	java/lang/IllegalArgumentException
    //   171	189	769	java/lang/IllegalArgumentException
    //   193	211	769	java/lang/IllegalArgumentException
    //   215	233	769	java/lang/IllegalArgumentException
    //   237	290	769	java/lang/IllegalArgumentException
    //   290	297	769	java/lang/IllegalArgumentException
    //   301	352	769	java/lang/IllegalArgumentException
    //   356	374	769	java/lang/IllegalArgumentException
    //   378	406	769	java/lang/IllegalArgumentException
    //   410	421	769	java/lang/IllegalArgumentException
    //   421	428	769	java/lang/IllegalArgumentException
    //   432	450	769	java/lang/IllegalArgumentException
    //   454	482	769	java/lang/IllegalArgumentException
    //   486	497	769	java/lang/IllegalArgumentException
    //   497	514	769	java/lang/IllegalArgumentException
    //   518	529	769	java/lang/IllegalArgumentException
    //   529	576	769	java/lang/IllegalArgumentException
    //   649	654	769	java/lang/IllegalArgumentException
    //   657	662	769	java/lang/IllegalArgumentException
    //   665	670	769	java/lang/IllegalArgumentException
    //   673	678	769	java/lang/IllegalArgumentException
    //   681	686	769	java/lang/IllegalArgumentException
    //   689	694	769	java/lang/IllegalArgumentException
    //   697	702	769	java/lang/IllegalArgumentException
    //   705	710	769	java/lang/IllegalArgumentException
    //   713	718	769	java/lang/IllegalArgumentException
    //   721	726	769	java/lang/IllegalArgumentException
    //   729	734	769	java/lang/IllegalArgumentException
    //   737	742	769	java/lang/IllegalArgumentException
    //   745	750	769	java/lang/IllegalArgumentException
    //   753	758	769	java/lang/IllegalArgumentException
    //   761	766	769	java/lang/IllegalArgumentException
    //   28	101	790	java/lang/IllegalStateException
    //   105	123	790	java/lang/IllegalStateException
    //   127	145	790	java/lang/IllegalStateException
    //   149	167	790	java/lang/IllegalStateException
    //   171	189	790	java/lang/IllegalStateException
    //   193	211	790	java/lang/IllegalStateException
    //   215	233	790	java/lang/IllegalStateException
    //   237	290	790	java/lang/IllegalStateException
    //   290	297	790	java/lang/IllegalStateException
    //   301	352	790	java/lang/IllegalStateException
    //   356	374	790	java/lang/IllegalStateException
    //   378	406	790	java/lang/IllegalStateException
    //   410	421	790	java/lang/IllegalStateException
    //   421	428	790	java/lang/IllegalStateException
    //   432	450	790	java/lang/IllegalStateException
    //   454	482	790	java/lang/IllegalStateException
    //   486	497	790	java/lang/IllegalStateException
    //   497	514	790	java/lang/IllegalStateException
    //   518	529	790	java/lang/IllegalStateException
    //   529	576	790	java/lang/IllegalStateException
    //   649	654	790	java/lang/IllegalStateException
    //   657	662	790	java/lang/IllegalStateException
    //   665	670	790	java/lang/IllegalStateException
    //   673	678	790	java/lang/IllegalStateException
    //   681	686	790	java/lang/IllegalStateException
    //   689	694	790	java/lang/IllegalStateException
    //   697	702	790	java/lang/IllegalStateException
    //   705	710	790	java/lang/IllegalStateException
    //   713	718	790	java/lang/IllegalStateException
    //   721	726	790	java/lang/IllegalStateException
    //   729	734	790	java/lang/IllegalStateException
    //   737	742	790	java/lang/IllegalStateException
    //   745	750	790	java/lang/IllegalStateException
    //   753	758	790	java/lang/IllegalStateException
    //   761	766	790	java/lang/IllegalStateException
    //   28	101	811	java/io/IOException
    //   105	123	811	java/io/IOException
    //   127	145	811	java/io/IOException
    //   149	167	811	java/io/IOException
    //   171	189	811	java/io/IOException
    //   193	211	811	java/io/IOException
    //   215	233	811	java/io/IOException
    //   237	290	811	java/io/IOException
    //   290	297	811	java/io/IOException
    //   301	352	811	java/io/IOException
    //   356	374	811	java/io/IOException
    //   378	406	811	java/io/IOException
    //   410	421	811	java/io/IOException
    //   421	428	811	java/io/IOException
    //   432	450	811	java/io/IOException
    //   454	482	811	java/io/IOException
    //   486	497	811	java/io/IOException
    //   497	514	811	java/io/IOException
    //   518	529	811	java/io/IOException
    //   529	576	811	java/io/IOException
    //   649	654	811	java/io/IOException
    //   657	662	811	java/io/IOException
    //   665	670	811	java/io/IOException
    //   673	678	811	java/io/IOException
    //   681	686	811	java/io/IOException
    //   689	694	811	java/io/IOException
    //   697	702	811	java/io/IOException
    //   705	710	811	java/io/IOException
    //   713	718	811	java/io/IOException
    //   721	726	811	java/io/IOException
    //   729	734	811	java/io/IOException
    //   737	742	811	java/io/IOException
    //   745	750	811	java/io/IOException
    //   753	758	811	java/io/IOException
    //   761	766	811	java/io/IOException
    //   582	591	832	java/io/UnsupportedEncodingException
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
  
  protected abstract void toContentXml(eev parameev);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsShareMsg
 * JD-Core Version:    0.7.0.1
 */