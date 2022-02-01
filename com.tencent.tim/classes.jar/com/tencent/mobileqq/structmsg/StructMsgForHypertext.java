package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anra;
import anre;
import anrr;
import anrs;
import ansf;
import aoiz;
import aoop;
import asgx;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ocp;
import org.xmlpull.v1.XmlSerializer;
import wja;
import wlz;

public class StructMsgForHypertext
  extends AbsStructMsg
{
  private String KEY_QD_HYPERTEXT_CLICK_STATE = "qd_hypertext_click_state_";
  public ArrayList<a> mHpertextArray;
  protected boolean mHyperClick;
  public int mHypertextContentLayout = 0;
  public String mSourceIcon;
  public String mSourceName;
  protected View.OnClickListener mSourceOnClickListener = new anrs(this);
  public String mSourceUrl;
  private URLDrawableDownListener.Adapter mUrlAdapter = new anrr(this);
  
  public StructMsgForHypertext() {}
  
  public StructMsgForHypertext(Bundle paramBundle)
  {
    super(paramBundle);
    this.mMsgServiceID = 3;
    Ru(paramBundle.getString("forward_text"));
    this.mSourceName = paramBundle.getString("struct_share_key_source_name");
    this.mSourceIcon = paramBundle.getString("struct_share_key_source_icon");
    this.mSourceUrl = paramBundle.getString("struct_share_key_source_url");
  }
  
  public StructMsgForHypertext(ansf paramansf, int paramInt)
  {
    super(paramansf);
    this.mMsgServiceID = paramInt;
    int i = paramansf.Ks();
    paramInt = 0;
    if (paramInt < i)
    {
      ansf localansf = paramansf.a(paramInt);
      if (localansf == null) {}
      for (;;)
      {
        paramInt += 1;
        break;
        if (localansf.name.equals("source"))
        {
          parseSourceNode(localansf);
        }
        else if (localansf.type == 1)
        {
          for (localansf = localansf.b(); (localansf != null) && (localansf.type != 1); localansf = anre.a(localansf)) {}
          parseItem(localansf);
        }
      }
    }
  }
  
  private void Ru(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mHpertextArray = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    Matcher localMatcher = Pattern.compile("<a.*?/a>").matcher(paramString);
    for (int i = 0; localMatcher.find(); i = localMatcher.end())
    {
      String str = paramString.substring(i, localMatcher.start());
      this.mHpertextArray.add(new a(str));
      localStringBuilder.append(str);
      Object localObject2 = localMatcher.group();
      str = "";
      Object localObject1 = Pattern.compile(">.*?</a>").matcher((CharSequence)localObject2);
      while (((Matcher)localObject1).find()) {
        str = ((Matcher)localObject1).group().replaceAll(">|</a>", "");
      }
      localObject1 = "";
      localObject2 = Pattern.compile("href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))").matcher((CharSequence)localObject2);
      while (((Matcher)localObject2).find()) {
        localObject1 = ((Matcher)localObject2).group().replaceAll("href\\s*=\\s*(['|\"]*)|['|\"]*", "");
      }
      this.mHpertextArray.add(new a((String)localObject1, "web", null, null, null, null, null, str));
      localStringBuilder.append(str);
    }
    paramString = paramString.substring(i);
    this.mHpertextArray.add(new a(paramString));
    localStringBuilder.append(paramString);
    this.mMsgBrief = localStringBuilder.toString();
  }
  
  public byte[] getBytes()
  {
    try
    {
      Object localObject = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
      writeExternal(localObjectOutputStream);
      localObjectOutputStream.close();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HypertextMsg", 2, "getBytes failure");
      }
    }
    return null;
  }
  
  public View getPreDialogView(Context paramContext, View paramView)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    paramView = localLinearLayout.getLayoutParams();
    if (paramView == null) {
      paramView = new LinearLayout.LayoutParams(BaseChatItemLayout.bOj, -2);
    }
    for (;;)
    {
      localLinearLayout.setLayoutParams(paramView);
      paramView = new HyperTextView(paramContext);
      Resources localResources = paramContext.getResources();
      paramView.setPadding((int)localResources.getDimension(2131299517), (int)localResources.getDimension(2131299519), (int)localResources.getDimension(2131299518), (int)localResources.getDimension(2131299516));
      paramView.setText(getSpannableString(false));
      paramView.setMaxLines(10);
      paramView.setTextSize(0, ChatTextSizeSettingActivity.ag(paramContext));
      paramView.setTextColor(paramContext.getResources().getColor(2131165548));
      paramView.setLinkTextColor(paramContext.getResources().getColor(2131166114));
      paramView.setLinksClickable(false);
      paramView.setMovementMethod(LinkMovementMethod.getInstance());
      localLinearLayout.addView(paramView);
      localLinearLayout.setLongClickable(true);
      localLinearLayout.setTag(2131378856, this);
      return localLinearLayout;
      paramView.width = BaseChatItemLayout.bOj;
      paramView.height = -2;
    }
  }
  
  public String getSourceName()
  {
    return this.mSourceName;
  }
  
  public View getSourceView(Context paramContext, View paramView)
  {
    boolean bool2 = true;
    if ((TextUtils.isEmpty(this.mSourceName)) && (TextUtils.isEmpty(this.mSourceIcon))) {
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
      paramView.setPadding(wja.dp2px(5.0F, localResources), 0, wja.dp2px(5.0F, localResources), 0);
      paramView.setBackgroundResource(2130843454);
    }
    TextView localTextView;
    for (;;)
    {
      localTextView = (TextView)paramView;
      localTextView.setText(this.mSourceName);
      try
      {
        new URL(this.mSourceIcon);
        i = 1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          String str;
          Object localObject;
          ColorDrawable localColorDrawable;
          localMalformedURLException.printStackTrace();
          int i = 0;
          continue;
          boolean bool1 = false;
          continue;
          localTextView.setCompoundDrawables(null, null, null, null);
        }
      }
      if ((!TextUtils.isEmpty(this.mSourceIcon)) && (i != 0))
      {
        str = this.mSourceIcon;
        localObject = localResources.getDrawable(2130851467);
        ((Drawable)localObject).setBounds(0, 0, wja.dp2px(12.0F, localResources), wja.dp2px(12.0F, localResources));
        localColorDrawable = new ColorDrawable(15790320);
        localColorDrawable.setBounds(0, 0, wja.dp2px(12.0F, localResources), wja.dp2px(12.0F, localResources));
        localObject = URLDrawable.getDrawable(str, (Drawable)localObject, localColorDrawable);
        bool1 = bool2;
        if (!aoiz.hasFile(str))
        {
          if (!aoop.bD(paramContext)) {
            bool1 = bool2;
          }
        }
        else
        {
          ((URLDrawable)localObject).setAutoDownload(bool1);
          ((URLDrawable)localObject).setBounds(0, 0, wja.dp2px(12.0F, localResources), wja.dp2px(12.0F, localResources));
          localTextView.setCompoundDrawablePadding(wja.dp2px(3.0F, localResources));
          localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
          localTextView.setPadding(wja.dp2px(5.0F, localResources), 0, wja.dp2px(5.0F, localResources), 0);
          paramView.setTag(this);
          paramView.setOnClickListener(this.mSourceOnClickListener);
          return paramView;
        }
      }
    }
  }
  
  /* Error */
  public android.text.SpannableStringBuilder getSpannableString(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 135	com/tencent/mobileqq/structmsg/StructMsgForHypertext:mHpertextArray	Ljava/util/ArrayList;
    //   4: ifnonnull +13 -> 17
    //   7: new 463	android/text/SpannableStringBuilder
    //   10: dup
    //   11: ldc 178
    //   13: invokespecial 465	android/text/SpannableStringBuilder:<init>	(Ljava/lang/CharSequence;)V
    //   16: areturn
    //   17: new 463	android/text/SpannableStringBuilder
    //   20: dup
    //   21: invokespecial 466	android/text/SpannableStringBuilder:<init>	()V
    //   24: astore 8
    //   26: aload_0
    //   27: getfield 135	com/tencent/mobileqq/structmsg/StructMsgForHypertext:mHpertextArray	Ljava/util/ArrayList;
    //   30: invokevirtual 470	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   33: astore 9
    //   35: aload 9
    //   37: invokeinterface 475 1 0
    //   42: ifeq +256 -> 298
    //   45: aload 9
    //   47: invokeinterface 479 1 0
    //   52: checkcast 12	com/tencent/mobileqq/structmsg/StructMsgForHypertext$a
    //   55: astore 7
    //   57: aload 7
    //   59: getfield 482	com/tencent/mobileqq/structmsg/StructMsgForHypertext$a:text	Ljava/lang/String;
    //   62: astore 10
    //   64: aload 7
    //   66: getfield 485	com/tencent/mobileqq/structmsg/StructMsgForHypertext$a:action	Ljava/lang/String;
    //   69: invokestatic 130	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: ifne +215 -> 287
    //   75: aload 8
    //   77: invokevirtual 486	android/text/SpannableStringBuilder:toString	()Ljava/lang/String;
    //   80: invokevirtual 489	java/lang/String:length	()I
    //   83: istore 5
    //   85: aload 10
    //   87: invokevirtual 489	java/lang/String:length	()I
    //   90: iload 5
    //   92: iadd
    //   93: istore 6
    //   95: aload 8
    //   97: aload 10
    //   99: invokevirtual 492	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   102: pop
    //   103: iload_1
    //   104: ifeq -69 -> 35
    //   107: aload 8
    //   109: new 6	com/tencent/mobileqq/structmsg/StructMsgForHypertext$HyperSpannable
    //   112: dup
    //   113: aload_0
    //   114: aload 7
    //   116: invokespecial 495	com/tencent/mobileqq/structmsg/StructMsgForHypertext$HyperSpannable:<init>	(Lcom/tencent/mobileqq/structmsg/StructMsgForHypertext;Lcom/tencent/mobileqq/structmsg/StructMsgForHypertext$a;)V
    //   119: iload 5
    //   121: iload 6
    //   123: bipush 33
    //   125: invokevirtual 499	android/text/SpannableStringBuilder:setSpan	(Ljava/lang/Object;III)V
    //   128: aload_0
    //   129: getfield 503	com/tencent/mobileqq/structmsg/StructMsgForHypertext:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   132: ifnull -97 -> 35
    //   135: aload 7
    //   137: getfield 506	com/tencent/mobileqq/structmsg/StructMsgForHypertext$a:key	Ljava/lang/String;
    //   140: invokestatic 130	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: ifne -108 -> 35
    //   146: aload_0
    //   147: getfield 503	com/tencent/mobileqq/structmsg/StructMsgForHypertext:message	Lcom/tencent/mobileqq/data/MessageRecord;
    //   150: new 137	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   157: aload_0
    //   158: getfield 37	com/tencent/mobileqq/structmsg/StructMsgForHypertext:KEY_QD_HYPERTEXT_CLICK_STATE	Ljava/lang/String;
    //   161: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 7
    //   166: getfield 506	com/tencent/mobileqq/structmsg/StructMsgForHypertext$a:key	Ljava/lang/String;
    //   169: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokevirtual 511	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   178: astore 10
    //   180: aload 7
    //   182: getfield 514	com/tencent/mobileqq/structmsg/StructMsgForHypertext$a:chZ	Ljava/lang/String;
    //   185: invokestatic 130	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   188: ifne +118 -> 306
    //   191: aload 7
    //   193: getfield 514	com/tencent/mobileqq/structmsg/StructMsgForHypertext$a:chZ	Ljava/lang/String;
    //   196: invokestatic 520	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   199: invokevirtual 523	java/lang/Integer:intValue	()I
    //   202: istore_2
    //   203: iload_2
    //   204: istore_3
    //   205: aload 10
    //   207: invokestatic 130	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   210: ifne +69 -> 279
    //   213: aload 10
    //   215: invokestatic 520	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   218: invokevirtual 523	java/lang/Integer:intValue	()I
    //   221: istore_3
    //   222: iload_2
    //   223: istore 4
    //   225: iload_3
    //   226: istore_2
    //   227: iload_2
    //   228: ifle -193 -> 35
    //   231: iload_2
    //   232: iload 4
    //   234: if_icmplt -199 -> 35
    //   237: aload 8
    //   239: new 525	android/text/style/ForegroundColorSpan
    //   242: dup
    //   243: ldc_w 526
    //   246: invokespecial 527	android/text/style/ForegroundColorSpan:<init>	(I)V
    //   249: iload 5
    //   251: iload 6
    //   253: bipush 33
    //   255: invokevirtual 499	android/text/SpannableStringBuilder:setSpan	(Ljava/lang/Object;III)V
    //   258: goto -223 -> 35
    //   261: astore 7
    //   263: iconst_0
    //   264: istore_2
    //   265: ldc_w 529
    //   268: iconst_1
    //   269: aload 7
    //   271: invokevirtual 532	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   274: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   277: iload_2
    //   278: istore_3
    //   279: iconst_0
    //   280: istore_2
    //   281: iload_3
    //   282: istore 4
    //   284: goto -57 -> 227
    //   287: aload 8
    //   289: aload 10
    //   291: invokevirtual 492	android/text/SpannableStringBuilder:append	(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    //   294: pop
    //   295: goto -260 -> 35
    //   298: aload 8
    //   300: areturn
    //   301: astore 7
    //   303: goto -38 -> 265
    //   306: iconst_0
    //   307: istore_2
    //   308: goto -105 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	StructMsgForHypertext
    //   0	311	1	paramBoolean	boolean
    //   202	106	2	i	int
    //   204	78	3	j	int
    //   223	60	4	k	int
    //   83	167	5	m	int
    //   93	159	6	n	int
    //   55	137	7	locala	a
    //   261	9	7	localNumberFormatException1	NumberFormatException
    //   301	1	7	localNumberFormatException2	NumberFormatException
    //   24	275	8	localSpannableStringBuilder	android.text.SpannableStringBuilder
    //   33	13	9	localIterator	Iterator
    //   62	228	10	str	String
    // Exception table:
    //   from	to	target	type
    //   180	203	261	java/lang/NumberFormatException
    //   205	222	301	java/lang/NumberFormatException
  }
  
  public View getView(Context paramContext, View paramView, wlz paramwlz, Bundle paramBundle)
  {
    paramView = (ViewGroup)super.getView(paramContext, paramView, paramwlz, paramBundle);
    paramBundle = new HyperTextView(paramContext);
    Resources localResources = paramContext.getResources();
    paramBundle.setPadding((int)localResources.getDimension(2131299517), (int)localResources.getDimension(2131299519), (int)localResources.getDimension(2131299518), (int)localResources.getDimension(2131299516));
    paramBundle.setText(getSpannableString(true));
    paramBundle.setTextSize(0, ChatTextSizeSettingActivity.ag(paramContext));
    paramBundle.setTextColor(paramContext.getResources().getColor(2131165548));
    paramBundle.setLinkTextColor(paramContext.getResources().getColor(2131166114));
    paramBundle.setLinksClickable(false);
    paramBundle.setMovementMethod(LinkMovementMethod.getInstance());
    paramBundle.setOnTouchListener(paramwlz);
    paramBundle.setOnLongClickListener(paramwlz);
    paramBundle.setTag(2131368694, this);
    paramView.addView(paramBundle);
    paramContext = paramView.getLayoutParams();
    if (paramContext == null) {
      new LinearLayout.LayoutParams(BaseChatItemLayout.bOj, -2);
    }
    for (;;)
    {
      paramView.setLongClickable(true);
      paramView.setTag(2131378856, this);
      return paramView;
      paramContext.width = BaseChatItemLayout.bOj;
      paramContext.height = -2;
    }
  }
  
  protected void parseItem(ansf paramansf)
  {
    if (paramansf == null) {
      return;
    }
    this.mHpertextArray = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramansf.Ks())
    {
      Object localObject3 = paramansf.a(i);
      if (localObject3 == null) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject1;
        Object localObject2;
        if (((ansf)localObject3).hasAttributes())
        {
          localObject1 = ((ansf)localObject3).getAttribute("url");
          localObject2 = ((ansf)localObject3).getAttribute("action");
          String str1 = ((ansf)localObject3).getAttribute("actionData");
          String str2 = ((ansf)localObject3).getAttribute("a_actionData");
          String str3 = ((ansf)localObject3).getAttribute("i_actionData");
          String str4 = ((ansf)localObject3).getAttribute("key");
          String str5 = ((ansf)localObject3).getAttribute("clickcnt");
          localObject3 = anre.a((ansf)localObject3);
          localObject1 = new a((String)localObject1, (String)localObject2, str1, str2, str3, str4, str5, (String)localObject3);
          this.mHpertextArray.add(localObject1);
          localStringBuilder.append((String)localObject3);
        }
        else
        {
          localObject1 = anre.a((ansf)localObject3);
          localObject2 = new a((String)localObject1);
          this.mHpertextArray.add(localObject2);
          localStringBuilder.append((String)localObject1);
        }
      }
    }
    this.mMsgBrief = localStringBuilder.toString();
  }
  
  protected void parseSourceNode(ansf paramansf)
  {
    this.mSourceName = paramansf.getAttribute("name");
    this.mSourceIcon = paramansf.getAttribute("icon");
    this.mSourceUrl = paramansf.getAttribute("url");
  }
  
  public void readExternal(ObjectInput paramObjectInput)
    throws IOException, ClassNotFoundException
  {
    int i = paramObjectInput.readInt();
    this.mVersion = i;
    if (i == 1) {}
    try
    {
      this.mMsgTemplateID = paramObjectInput.readInt();
      this.mMsgAction = paramObjectInput.readUTF();
      this.mMsgActionData = paramObjectInput.readUTF();
      this.mMsg_A_ActionData = paramObjectInput.readUTF();
      this.mMsg_I_ActionData = paramObjectInput.readUTF();
      this.mMsgUrl = paramObjectInput.readUTF();
      this.mMsgBrief = paramObjectInput.readUTF();
      int j = paramObjectInput.readInt();
      if (j > 0)
      {
        this.mHpertextArray = new ArrayList();
        i = 0;
        while (i < j)
        {
          a locala = new a(paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF(), paramObjectInput.readUTF());
          this.mHpertextArray.add(locala);
          i += 1;
        }
      }
      this.fwFlag = paramObjectInput.readInt();
      this.mSourceName = paramObjectInput.readUTF();
      this.mSourceIcon = paramObjectInput.readUTF();
      this.mSourceUrl = paramObjectInput.readUTF();
      this.msgId = paramObjectInput.readLong();
      this.mPromotionType = paramObjectInput.readInt();
      this.mPromotionMsg = paramObjectInput.readUTF();
      this.mPromotionMenus = paramObjectInput.readUTF();
      this.mPromotionMenuDestructiveIndex = paramObjectInput.readInt();
      return;
    }
    catch (IOException paramObjectInput) {}
  }
  
  protected void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    XmlSerializer localXmlSerializer = Xml.newSerializer();
    try
    {
      localXmlSerializer.setOutput(paramByteArrayOutputStream, paramString);
      localXmlSerializer.startDocument(paramString, Boolean.valueOf(true));
      localXmlSerializer.startTag(null, "msg");
      localXmlSerializer.attribute(null, "serviceID", String.valueOf(this.mMsgServiceID));
      localXmlSerializer.attribute(null, "templateID", String.valueOf(this.mMsgTemplateID));
      label187:
      int i;
      if (this.mMsgAction == null)
      {
        paramByteArrayOutputStream = "";
        localXmlSerializer.attribute(null, "action", paramByteArrayOutputStream);
        if (!TextUtils.isEmpty(this.mMsgActionData)) {
          localXmlSerializer.attribute(null, "actionData", this.mMsgActionData);
        }
        if (!TextUtils.isEmpty(this.mMsg_A_ActionData)) {
          localXmlSerializer.attribute(null, "a_actionData", this.mMsg_A_ActionData);
        }
        if (!TextUtils.isEmpty(this.mMsg_I_ActionData)) {
          localXmlSerializer.attribute(null, "i_actionData", this.mMsg_I_ActionData);
        }
        if (this.mMsgUrl != null) {
          break label542;
        }
        paramByteArrayOutputStream = "";
        localXmlSerializer.attribute(null, "url", paramByteArrayOutputStream);
        if (this.fwFlag == 1) {
          localXmlSerializer.attribute(null, "fwflag", String.valueOf(this.fwFlag));
        }
        localXmlSerializer.startTag(null, "item");
        localXmlSerializer.attribute(null, "layout", String.valueOf(this.mHypertextContentLayout));
        localXmlSerializer.startTag(null, "hypertext");
        if (this.mHpertextArray == null) {
          break label558;
        }
        i = 0;
        label279:
        if (i >= this.mHpertextArray.size()) {
          break label558;
        }
        paramByteArrayOutputStream = (a)this.mHpertextArray.get(i);
        localXmlSerializer.startTag(null, "text");
        if (!TextUtils.isEmpty(paramByteArrayOutputStream.action))
        {
          if (!TextUtils.isEmpty(paramByteArrayOutputStream.url)) {
            localXmlSerializer.attribute(null, "url", paramByteArrayOutputStream.url);
          }
          localXmlSerializer.attribute(null, "action", paramByteArrayOutputStream.action);
          if (!TextUtils.isEmpty(paramByteArrayOutputStream.actionData)) {
            localXmlSerializer.attribute(null, "actionData", paramByteArrayOutputStream.actionData);
          }
          if (!TextUtils.isEmpty(paramByteArrayOutputStream.a_actionData)) {
            localXmlSerializer.attribute(null, "a_actionData", paramByteArrayOutputStream.a_actionData);
          }
          if (!TextUtils.isEmpty(paramByteArrayOutputStream.i_actionData)) {
            localXmlSerializer.attribute(null, "i_actionData", paramByteArrayOutputStream.i_actionData);
          }
          if (!TextUtils.isEmpty(paramByteArrayOutputStream.key)) {
            localXmlSerializer.attribute(null, "key", paramByteArrayOutputStream.key);
          }
          if (!TextUtils.isEmpty(paramByteArrayOutputStream.chZ)) {
            localXmlSerializer.attribute(null, "clickcnt", paramByteArrayOutputStream.chZ);
          }
        }
        if (paramByteArrayOutputStream.text != null) {
          break label550;
        }
      }
      label542:
      label550:
      for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = paramByteArrayOutputStream.text)
      {
        localXmlSerializer.text(paramByteArrayOutputStream);
        localXmlSerializer.endTag(null, "text");
        i += 1;
        break label279;
        paramByteArrayOutputStream = this.mMsgAction;
        break;
        paramByteArrayOutputStream = this.mMsgUrl;
        break label187;
      }
      label558:
      localXmlSerializer.endTag(null, "hypertext");
      localXmlSerializer.endTag(null, "item");
      localXmlSerializer.startTag(null, "source");
      if (this.mSourceName == null)
      {
        paramByteArrayOutputStream = "";
        localXmlSerializer.attribute(null, "name", paramByteArrayOutputStream);
        if (this.mSourceIcon != null) {
          break label708;
        }
        paramByteArrayOutputStream = "";
        label626:
        localXmlSerializer.attribute(null, "icon", paramByteArrayOutputStream);
        if (this.mSourceUrl != null) {
          break label716;
        }
      }
      label708:
      label716:
      for (paramByteArrayOutputStream = "";; paramByteArrayOutputStream = this.mSourceUrl)
      {
        localXmlSerializer.attribute(null, "url", paramByteArrayOutputStream);
        localXmlSerializer.endTag(null, "source");
        localXmlSerializer.endTag(null, "msg");
        localXmlSerializer.endDocument();
        localXmlSerializer.flush();
        return;
        paramByteArrayOutputStream = this.mSourceName;
        break;
        paramByteArrayOutputStream = this.mSourceIcon;
        break label626;
      }
      return;
    }
    catch (Exception paramByteArrayOutputStream)
    {
      if (QLog.isColorLevel()) {
        QLog.d("structMsg", 2, paramByteArrayOutputStream.getMessage(), paramByteArrayOutputStream);
      }
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
    throws IOException
  {
    paramObjectOutput.writeInt(this.mMsgServiceID);
    paramObjectOutput.writeInt(this.mVersion);
    paramObjectOutput.writeInt(this.mMsgTemplateID);
    label57:
    label74:
    label91:
    label108:
    label125:
    a locala;
    if (this.mMsgAction == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsgActionData != null) {
        break label359;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsg_A_ActionData != null) {
        break label367;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsg_I_ActionData != null) {
        break label375;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsgUrl != null) {
        break label383;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mMsgBrief != null) {
        break label391;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mHpertextArray == null) {
        break label447;
      }
      paramObjectOutput.writeInt(this.mHpertextArray.size());
      Iterator localIterator = this.mHpertextArray.iterator();
      label160:
      if (!localIterator.hasNext()) {
        break label454;
      }
      locala = (a)localIterator.next();
      if (locala.url == null) {
        break label399;
      }
      str = locala.url;
      label194:
      paramObjectOutput.writeUTF(str);
      if (locala.action == null) {
        break label405;
      }
      str = locala.action;
      label215:
      paramObjectOutput.writeUTF(str);
      if (locala.actionData == null) {
        break label411;
      }
      str = locala.actionData;
      label236:
      paramObjectOutput.writeUTF(str);
      if (locala.a_actionData == null) {
        break label417;
      }
      str = locala.a_actionData;
      label257:
      paramObjectOutput.writeUTF(str);
      if (locala.i_actionData == null) {
        break label423;
      }
      str = locala.i_actionData;
      label278:
      paramObjectOutput.writeUTF(str);
      if (locala.key == null) {
        break label429;
      }
      str = locala.key;
      label299:
      paramObjectOutput.writeUTF(str);
      if (locala.chZ == null) {
        break label435;
      }
      str = locala.chZ;
      label320:
      paramObjectOutput.writeUTF(str);
      if (locala.text == null) {
        break label441;
      }
    }
    label391:
    label399:
    label405:
    label411:
    label417:
    label423:
    label429:
    label435:
    label441:
    for (String str = locala.text;; str = "")
    {
      paramObjectOutput.writeUTF(str);
      break label160;
      str = this.mMsgAction;
      break;
      label359:
      str = this.mMsgActionData;
      break label57;
      label367:
      str = this.mMsg_A_ActionData;
      break label74;
      label375:
      str = this.mMsg_I_ActionData;
      break label91;
      label383:
      str = this.mMsgUrl;
      break label108;
      str = this.mMsgBrief;
      break label125;
      str = "";
      break label194;
      str = "";
      break label215;
      str = "";
      break label236;
      str = "";
      break label257;
      str = "";
      break label278;
      str = "";
      break label299;
      str = "";
      break label320;
    }
    label447:
    paramObjectOutput.writeInt(0);
    label454:
    paramObjectOutput.writeInt(this.fwFlag);
    if (this.mSourceName == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.mSourceIcon != null) {
        break label588;
      }
      str = "";
      label491:
      paramObjectOutput.writeUTF(str);
      if (this.mSourceUrl != null) {
        break label596;
      }
      str = "";
      label508:
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeLong(this.msgId);
      paramObjectOutput.writeInt(this.mPromotionType);
      if (this.mPromotionMsg != null) {
        break label604;
      }
      str = "";
      label545:
      paramObjectOutput.writeUTF(str);
      if (this.mPromotionMenus != null) {
        break label612;
      }
    }
    label588:
    label596:
    label604:
    label612:
    for (str = "";; str = this.mPromotionMenus)
    {
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.mPromotionMenuDestructiveIndex);
      return;
      str = this.mSourceName;
      break;
      str = this.mSourceIcon;
      break label491;
      str = this.mSourceUrl;
      break label508;
      str = this.mPromotionMsg;
      break label545;
    }
  }
  
  public class HyperSpannable
    extends URLSpan
  {
    private StructMsgForHypertext.a jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a;
    long time = -1L;
    
    public HyperSpannable(StructMsgForHypertext.a parama)
    {
      super();
      this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a = parama;
    }
    
    public void onClick(View paramView)
    {
      if (SystemClock.uptimeMillis() - this.time < 1000L) {}
      do
      {
        return;
        this.time = SystemClock.uptimeMillis();
      } while ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a == null) || ((paramView != null) && ((paramView instanceof StructMsgForHypertext.HyperTextView)) && (!((StructMsgForHypertext.HyperTextView)paramView).ayX())));
      label196:
      int m;
      int j;
      int i;
      int k;
      Object localObject1;
      if (("web".equals(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.action)) || ("auto".equals(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.action)) || ("replyMsg".equals(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.action)) || ("replyCmd".equals(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.action)) || ("plugin".equals(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.action)))
      {
        new anra(null, paramView, StructMsgForHypertext.this.message).a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.action, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.url, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.actionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.a_actionData, StructMsgForHypertext.this.message.msgseq, new Object[0]);
        StructMsgForHypertext.this.mHyperClick = true;
        if ((!(StructMsgForHypertext.this.message instanceof MessageForStructing)) || (((MessageForStructing)StructMsgForHypertext.this.message).structingMsg.mMsgServiceID != 120)) {
          break label766;
        }
        m = 0;
        j = 0;
        i = 0;
        k = 0;
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.key)) {
          break label1170;
        }
        localObject1 = StructMsgForHypertext.this.message.getExtInfoFromExtStr(StructMsgForHypertext.this.KEY_QD_HYPERTEXT_CLICK_STATE + this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.key);
        j = m;
      }
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            j = m;
            i = Integer.valueOf((String)localObject1).intValue();
          }
          j = i;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.chZ))
          {
            j = i;
            k = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.chZ).intValue();
          }
          if (((i != 0) && (i >= k)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.action))) {
            break;
          }
          localObject1 = paramView.getContext();
          paramView = ((FragmentActivity)localObject1).getChatFragment();
          if (paramView == null) {
            break label1178;
          }
          paramView = paramView.getApp();
          if (paramView == null) {
            break;
          }
          ((asgx)paramView.getManager(165)).c(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.action, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.a_actionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.actionData, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.url, 1, "");
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.key))
          {
            i += 1;
            if (i <= k)
            {
              StructMsgForHypertext.this.message.saveExtInfoToExtStr(StructMsgForHypertext.this.KEY_QD_HYPERTEXT_CLICK_STATE + this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.key, "" + i);
              paramView.b().a(StructMsgForHypertext.this.message.frienduin, StructMsgForHypertext.this.message.istroop, StructMsgForHypertext.this.message.uniseq, "extStr", StructMsgForHypertext.this.message.extStr);
            }
          }
          ((FragmentActivity)localObject1).getChatFragment().a().refresh(131077);
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          Context localContext;
          PackageManager localPackageManager;
          Object localObject3;
          label766:
          QLog.d("StructMsg", 1, localNumberFormatException.getMessage());
        }
        if (!"app".equals(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.action)) {
          break label196;
        }
        localContext = paramView.getContext();
        localPackageManager = localContext.getPackageManager();
        localObject1 = "";
        localObject3 = localObject1;
        try
        {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.a_actionData)) {
            continue;
          }
          localObject3 = localObject1;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.actionData;
          localObject3 = localObject1;
          i = ((String)localObject2).indexOf("://");
          if (i != -1) {
            continue;
          }
          localObject3 = localObject1;
          if (localPackageManager.getPackageInfo((String)localObject2, 1) == null) {
            continue;
          }
          localObject3 = localObject1;
          localObject2 = localPackageManager.getLaunchIntentForPackage((String)localObject2);
          if (localObject2 == null) {
            continue;
          }
          localObject3 = localObject1;
          ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_aio");
          localObject3 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject3 = localObject1;
            ((Intent)localObject2).setData(Uri.parse((String)localObject1));
          }
          localObject3 = localObject1;
          localContext.startActivity((Intent)localObject2);
        }
        catch (Exception localException)
        {
          String str;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("HypertextMsg", 2, localException.getMessage(), localException);
          if ((TextUtils.isEmpty((CharSequence)localObject3)) || ((!((String)localObject3).startsWith("http://")) && (!((String)localObject3).startsWith("https://")))) {
            continue;
          }
          Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
          localIntent.putExtra("url", (String)localObject3);
          localIntent.putExtra("big_brother_source_key", "biz_src_jc_aio");
          localIntent.putExtra("key_isReadModeEnabled", true);
          ocp.f(localIntent, (String)localObject3);
          localIntent.putExtra("fromAio", true);
          localContext.startActivity(localIntent);
          anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, (String)localObject3, "", "", "");
          continue;
          localObject3 = localIntent;
          if (TextUtils.isEmpty(localIntent)) {
            continue;
          }
          localObject3 = localIntent;
          if (localIntent.startsWith("http://")) {
            continue;
          }
          localObject3 = localIntent;
          if (!localIntent.startsWith("https://")) {
            continue;
          }
          localObject3 = localIntent;
          Object localObject2 = new Intent(localContext, QQBrowserActivity.class);
          localObject3 = localIntent;
          ((Intent)localObject2).putExtra("big_brother_source_key", "biz_src_jc_aio");
          localObject3 = localIntent;
          ((Intent)localObject2).putExtra("url", localIntent);
          localObject3 = localIntent;
          ((Intent)localObject2).putExtra("key_isReadModeEnabled", true);
          localObject3 = localIntent;
          ocp.a(StructMsgForHypertext.this.message, (Intent)localObject2, localIntent);
          localObject3 = localIntent;
          localContext.startActivity((Intent)localObject2);
          localObject3 = localIntent;
          anot.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, localIntent, "", "", "");
          continue;
        }
        StructMsgForHypertext.this.mHyperClick = true;
        break label196;
        break;
        localObject3 = localObject1;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$a.a_actionData;
        continue;
        localObject3 = localObject1;
        str = ((String)localObject2).substring(0, i);
        localObject3 = localObject1;
        localObject1 = ((String)localObject2).substring(i + 3);
        localObject2 = str;
        continue;
        localObject3 = localObject1;
        QLog.w("StructMsg", 1, "intent is null");
        continue;
        label1170:
        k = 0;
        i = j;
        continue;
        label1178:
        paramView = BaseApplicationImpl.getApplication().getRuntime();
        if ((paramView instanceof QQAppInterface)) {
          paramView = (QQAppInterface)paramView;
        } else {
          paramView = null;
        }
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      paramTextPaint.setUnderlineText(true);
    }
  }
  
  public static final class HyperTextView
    extends TextView
    implements View.OnClickListener
  {
    Context mContext = null;
    boolean mIsClicked = false;
    
    public HyperTextView(Context paramContext)
    {
      super();
      setOnClickListener(this);
      this.mContext = paramContext;
    }
    
    public boolean D(Object paramObject)
    {
      try
      {
        Field localField = Class.forName("android.view.View").getDeclaredField("mHasPerformedLongPress");
        localField.setAccessible(true);
        boolean bool = ((Boolean)localField.get(paramObject)).booleanValue();
        return bool;
      }
      catch (NoSuchFieldException paramObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, paramObject.getMessage(), paramObject);
        }
        return false;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, paramObject.getMessage(), paramObject);
          }
        }
      }
    }
    
    public boolean ayX()
    {
      if ((this.mIsClicked) || (D(this)))
      {
        this.mIsClicked = false;
        return false;
      }
      return true;
    }
    
    public void onClick(View paramView)
    {
      Object localObject = paramView.getTag(2131378856);
      if ((localObject != null) && ((localObject instanceof StructMsgForHypertext)))
      {
        localObject = (StructMsgForHypertext)localObject;
        if (!((StructMsgForHypertext)localObject).mHyperClick) {
          break label43;
        }
        ((StructMsgForHypertext)localObject).mHyperClick = false;
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        label43:
        if ("web".equals(((StructMsgForHypertext)localObject).mMsgAction))
        {
          Context localContext = paramView.getContext();
          Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
          localIntent.putExtra("big_brother_source_key", "biz_src_jc_aio");
          localIntent.putExtra("url", ((StructMsgForHypertext)localObject).mMsgUrl);
          ocp.a(((StructMsgForHypertext)localObject).message, localIntent, ((StructMsgForHypertext)localObject).mMsgUrl);
          localContext.startActivity(localIntent);
          this.mIsClicked = true;
        }
      }
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      if (paramMotionEvent.getAction() == 0) {
        this.mIsClicked = false;
      }
      return super.onTouchEvent(paramMotionEvent);
    }
  }
  
  public static class a
  {
    public String a_actionData;
    public String action;
    public String actionData;
    public String chZ;
    public String i_actionData;
    public String key;
    public String text;
    public String url;
    
    public a(String paramString)
    {
      this(null, null, null, null, null, null, null, paramString);
    }
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
    {
      this.url = paramString1;
      this.action = paramString2;
      this.actionData = paramString3;
      this.a_actionData = paramString4;
      this.i_actionData = paramString5;
      this.key = paramString6;
      this.chZ = paramString7;
      this.text = paramString8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForHypertext
 * JD-Core Version:    0.7.0.1
 */