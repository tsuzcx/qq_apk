package com.tencent.mobileqq.structmsg;

import acfp;
import anbk;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anrc;
import ansf;
import ansi;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;
import wja;
import wlz;

public abstract class AbsStructMsg
  implements anrc, Externalizable
{
  public static final String DEFAULT_MSG_BRIEF = acfp.m(2131701965);
  public static final String PA_DEFAULT_MSG_BRIEF = acfp.m(2131701964);
  public static int SOURCE_ACCOUNT_TYPE_PA = 7;
  public String adverKey;
  public int adverSign;
  public String currentAccountUin;
  public int dynamicMsgMergeIndex = -1;
  public String dynamicMsgMergeKey = "";
  public int forwardID;
  public int fwFlag;
  public String index;
  public String index_name;
  public String index_type;
  public String mAlgorithmIds;
  public String mArticleIds;
  public String mCommentText;
  public String mCommonData;
  public String mCompatibleText = "";
  public String mCreateTime;
  public boolean mEmptyMsgBriefModified;
  public String mExtraData;
  public String mFileName;
  public long mFileSize;
  public int mFlag;
  public String mInnerUniqIds;
  public String mMergeSeq;
  public String mMsgAction = "web";
  public String mMsgActionData;
  public String mMsgBrief;
  public String mMsgOldText;
  public int mMsgServiceID = -1;
  public int mMsgTemplateID = -1;
  public String mMsgUrl;
  public String mMsg_A_ActionData;
  public String mMsg_I_ActionData;
  public String mNeedRound;
  public String mOrangeWord;
  public int mPromotionMenuDestructiveIndex = -1;
  public String mPromotionMenus = "";
  public String mPromotionMsg = "";
  public int mPromotionType;
  public String mQQStoryExtra;
  public String mQidianBulkTaskId;
  public String mQzoneExtraMsg;
  public String mResid;
  public String mSType;
  public long mSortKey;
  public String mSourceThirdName;
  public String mStrategyIds;
  public int mTSum;
  public String mTagName;
  public String mTribeShortVideoExtra;
  int mVersion = 1;
  public MessageRecord message;
  public int messageVersion;
  public long msgId;
  public int multiMsgFlag;
  public long parentUniseq;
  public String readInjoy = "QQ看点";
  public String reportEventFolderStatusValue;
  public String rijAlbumActionData;
  public int sourceAccoutType;
  public String source_puin = "";
  public String templateIDForPortal = "";
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
    this.mQzoneExtraMsg = paramBundle.getString("qzone_extra_msg");
    this.mMsg_A_ActionData = "";
    this.mCommentText = paramBundle.getString("share_comment_message");
    this.source_puin = paramBundle.getString("source_puin");
    if ((this.source_puin == null) || (this.source_puin.equals(""))) {
      this.source_puin = paramBundle.getString("struct_uin");
    }
    if (this.source_puin == null) {
      this.source_puin = "";
    }
    if (this.msgId == 0L) {
      paramBundle = paramBundle.getString("strurt_msgid");
    }
    try
    {
      this.msgId = Long.parseLong(paramBundle);
      return;
    }
    catch (Exception paramBundle) {}
  }
  
  AbsStructMsg(ansf paramansf)
  {
    parseMsgAttrubutes(paramansf);
  }
  
  public static View getExceptionView(Context paramContext, View paramView, wlz paramwlz, Bundle paramBundle, int paramInt)
  {
    return getExceptionView(paramContext, paramView, paramwlz, paramBundle, paramContext.getResources().getString(paramInt));
  }
  
  public static View getExceptionView(Context paramContext, View paramView, wlz paramwlz, Bundle paramBundle, String paramString)
  {
    paramwlz = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof RelativeLayout))) {
      ((RelativeLayout)paramView).removeAllViews();
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView;
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
      paramBundle = new TextView(paramContext);
      paramBundle.setText(paramString);
      paramBundle.setTextSize(2, 14.0F);
      paramBundle.setTextColor(Color.parseColor("#777777"));
      int i = wja.dp2px(15.0F, paramwlz);
      int j = wja.dp2px(7.5F, paramwlz);
      paramContext = new RelativeLayout(paramContext);
      paramContext.setBackgroundResource(2130838395);
      paramContext.setPadding(i, j, i, j);
      paramContext.addView(paramBundle);
      paramContext.setId(2131378839);
      paramwlz = new RelativeLayout.LayoutParams(-2, -2);
      paramwlz.addRule(13);
      paramView.addView(paramContext, paramwlz);
      return paramView;
      paramView = new RelativeLayout(paramContext);
    }
  }
  
  public static View getInCompatibleView(Context paramContext, View paramView, String paramString)
  {
    if ((paramView != null) && ((paramView instanceof RelativeLayout))) {
      ((RelativeLayout)paramView).removeAllViews();
    }
    for (;;)
    {
      paramView = (RelativeLayout)paramView;
      paramContext = new TextView(paramContext);
      paramContext.setText(paramString);
      paramContext.setTextSize(2, 16.0F);
      paramContext.setTextColor(Color.parseColor("#000000"));
      int i = BaseChatItemLayout.bOc;
      int j = BaseChatItemLayout.bOd;
      paramView.setBackgroundResource(2130838395);
      paramContext.setPadding(i, BaseChatItemLayout.bOa, j, BaseChatItemLayout.bOb);
      paramView.addView(paramContext, new RelativeLayout.LayoutParams(-1, -1));
      return paramView;
      paramView = new RelativeLayout(paramContext);
    }
  }
  
  public static View getVersionExceptionView(Context paramContext, View paramView, wlz paramwlz, Bundle paramBundle)
  {
    return getExceptionView(paramContext, paramView, paramwlz, paramBundle, 2131700696);
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
  
  public abstract String getSourceName();
  
  public abstract View getSourceView(Context paramContext, View paramView);
  
  public View getView(Context paramContext, View paramView, wlz paramwlz, Bundle paramBundle)
  {
    paramwlz = paramView;
    if (paramView == null)
    {
      paramwlz = new LinearLayout(paramContext);
      paramwlz.setOrientation(1);
      paramContext = paramwlz.getLayoutParams();
      if (paramContext != null) {
        break label49;
      }
      paramContext = new LinearLayout.LayoutParams(BaseChatItemLayout.bOj, -2);
    }
    for (;;)
    {
      paramwlz.setLayoutParams(paramContext);
      return paramwlz;
      label49:
      paramContext.width = BaseChatItemLayout.bOj;
      paramContext.height = -2;
    }
  }
  
  public final String getXml()
  {
    Object localObject = new ByteArrayOutputStream();
    toXml((ByteArrayOutputStream)localObject, "UTF-8");
    try
    {
      localObject = ((ByteArrayOutputStream)localObject).toString("UTF-8");
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public final byte[] getXmlBytes()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    toXml(localByteArrayOutputStream, "UTF-8");
    byte[] arrayOfByte;
    if (QLog.isDevelopLevel()) {
      arrayOfByte = null;
    }
    try
    {
      localObject = localByteArrayOutputStream.toString("UTF-8");
      QLog.d("StructMsg", 4, "Obj[" + System.identityHashCode(this) + "]getXmlBytes xmlStr:" + (String)localObject);
      localObject = ansi.compress(localByteArrayOutputStream.toByteArray());
      int i = localObject.length;
      arrayOfByte = new byte[i + 1];
      arrayOfByte[0] = 1;
      System.arraycopy(localObject, 0, arrayOfByte, 1, i);
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject = arrayOfByte;
        if (QLog.isColorLevel())
        {
          QLog.d("StructMsg", 2, localUnsupportedEncodingException.getMessage(), localUnsupportedEncodingException);
          localObject = arrayOfByte;
        }
      }
    }
  }
  
  public boolean hasFlag(int paramInt)
  {
    return (this.mFlag & paramInt) == paramInt;
  }
  
  public boolean hasTSum()
  {
    return this.mTSum > 0;
  }
  
  protected void parseMsgAttrubutes(ansf paramansf)
  {
    if (paramansf == null) {}
    for (;;)
    {
      return;
      String str1 = paramansf.getAttribute("templateID");
      if (!TextUtils.isEmpty(str1)) {
        this.mMsgTemplateID = Integer.parseInt(str1);
      }
      this.mMsgUrl = paramansf.getAttribute("url");
      this.mMsgAction = paramansf.getAttribute("action");
      this.mMsgActionData = paramansf.getAttribute("actionData");
      this.mMsg_A_ActionData = paramansf.getAttribute("a_actionData");
      this.mMsg_I_ActionData = paramansf.getAttribute("i_actionData");
      this.rijAlbumActionData = paramansf.getAttribute("rijAlbumActionData");
      this.mQzoneExtraMsg = paramansf.getAttribute("qzFloatExtra");
      str1 = paramansf.getAttribute("fwflag");
      if (!TextUtils.isEmpty(str1)) {}
      try
      {
        this.fwFlag = Integer.parseInt(str1);
        label128:
        str1 = paramansf.getAttribute("flag");
        if (!TextUtils.isEmpty(str1)) {}
        try
        {
          this.mFlag = Integer.parseInt(str1);
          label151:
          str1 = paramansf.getAttribute("serviceID");
          if (!TextUtils.isEmpty(str1)) {
            this.mMsgServiceID = Integer.parseInt(str1);
          }
          this.mMsgBrief = paramansf.getAttribute("brief");
          this.mResid = paramansf.getAttribute("m_resid");
          this.mFileName = paramansf.getAttribute("m_fileName");
          str1 = paramansf.getAttribute("tSum");
          if (!TextUtils.isEmpty(str1)) {
            this.mTSum = Integer.parseInt(str1);
          }
          str1 = paramansf.getAttribute("m_fileSize");
          if (!TextUtils.isEmpty(str1)) {}
          try
          {
            this.mFileSize = Long.parseLong(str1);
            label253:
            str1 = paramansf.getAttribute("promotionType");
            this.mPromotionMsg = paramansf.getAttribute("promotionMsg");
            this.mPromotionMenus = paramansf.getAttribute("promotionMenus");
            String str2 = paramansf.getAttribute("promotionMenuDestructiveIndex");
            label392:
            label426:
            try
            {
              if (!TextUtils.isEmpty(str1)) {
                this.mPromotionType = Integer.parseInt(str1);
              }
              if (!TextUtils.isEmpty(str2)) {
                this.mPromotionMenuDestructiveIndex = Integer.parseInt(str2);
              }
            }
            catch (NumberFormatException localNumberFormatException4)
            {
              label321:
              label449:
              break label321;
            }
            this.source_puin = paramansf.getAttribute("sourcePublicUin");
            if (this.source_puin == null) {
              this.source_puin = "";
            }
            this.mSourceThirdName = paramansf.getAttribute("sourceName");
            if (this.mSourceThirdName == null) {
              this.mSourceThirdName = "";
            }
            str1 = paramansf.getAttribute("sourceMsgId");
            try
            {
              if (!TextUtils.isEmpty(str1)) {
                this.msgId = Long.parseLong(str1);
              }
              this.mSType = paramansf.getAttribute("sType");
              str1 = paramansf.getAttribute("accostType");
              try
              {
                if (!TextUtils.isEmpty(str1)) {
                  this.sourceAccoutType = Integer.parseInt(str1);
                }
                str1 = paramansf.getAttribute("adverSign");
                try
                {
                  if (!TextUtils.isEmpty(str1)) {
                    this.adverSign = Integer.parseInt(str1);
                  }
                  this.adverKey = paramansf.getAttribute("adverKey");
                  this.index = paramansf.getAttribute("index");
                  this.index_name = paramansf.getAttribute("index_name");
                  this.index_type = paramansf.getAttribute("index_type");
                  this.mExtraData = paramansf.getAttribute("extraData");
                  this.mCreateTime = paramansf.getAttribute("createTime");
                  this.mTagName = paramansf.getAttribute("tagName");
                  this.mArticleIds = paramansf.getAttribute("articleIds");
                  this.mOrangeWord = paramansf.getAttribute("orangeWord");
                  this.mAlgorithmIds = paramansf.getAttribute("algorithmIds");
                  this.mStrategyIds = paramansf.getAttribute("strategyIds");
                  this.reportEventFolderStatusValue = paramansf.getAttribute("reportEventFolderStatusValue");
                  this.mQidianBulkTaskId = paramansf.getAttribute("qf_task_id");
                  this.mInnerUniqIds = paramansf.getAttribute("uuids");
                  this.mQQStoryExtra = paramansf.getAttribute("qqstoryExtra");
                  this.mTribeShortVideoExtra = paramansf.getAttribute("qqtribeVideoInfoExtra");
                  this.mNeedRound = paramansf.getAttribute("needRoundView");
                  this.mCommonData = paramansf.getAttribute("msgCommonData");
                  this.mMergeSeq = paramansf.getAttribute("mergeSeq");
                  paramansf = paramansf.getAttribute("sortKey");
                  try
                  {
                    if (!TextUtils.isEmpty(paramansf)) {
                      this.mSortKey = Long.parseLong(paramansf);
                    }
                    if (((this.mMsgServiceID != 142) && (this.mMsgServiceID != 500)) || (!TextUtils.isEmpty(this.mExtraData)) || (TextUtils.isEmpty(this.mMsgActionData))) {
                      continue;
                    }
                    try
                    {
                      this.mExtraData = new JSONObject(this.mMsgActionData).getString("push_ext_data");
                      return;
                    }
                    catch (Exception paramansf)
                    {
                      paramansf.getStackTrace();
                      return;
                    }
                  }
                  catch (NumberFormatException paramansf)
                  {
                    for (;;)
                    {
                      paramansf.printStackTrace();
                    }
                  }
                }
                catch (NumberFormatException localNumberFormatException1)
                {
                  break label449;
                }
              }
              catch (NumberFormatException localNumberFormatException2)
              {
                break label426;
              }
            }
            catch (NumberFormatException localNumberFormatException3)
            {
              break label392;
            }
          }
          catch (NumberFormatException localNumberFormatException5)
          {
            break label253;
          }
        }
        catch (NumberFormatException localNumberFormatException6)
        {
          break label151;
        }
      }
      catch (NumberFormatException localNumberFormatException7)
      {
        break label128;
      }
    }
  }
  
  public void removeFlag(int paramInt)
  {
    this.mFlag &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public void setFlag(int paramInt)
  {
    this.mFlag = paramInt;
  }
  
  protected abstract void toXml(ByteArrayOutputStream paramByteArrayOutputStream, String paramString);
  
  public class a
    implements XmlSerializer
  {
    XmlSerializer a;
    
    public a(XmlSerializer paramXmlSerializer)
    {
      this.a = paramXmlSerializer;
    }
    
    public XmlSerializer attribute(String paramString1, String paramString2, String paramString3)
      throws IOException, IllegalArgumentException, IllegalStateException
    {
      return this.a.attribute(paramString1, paramString2, paramString3);
    }
    
    public void cdsect(String paramString)
      throws IOException, IllegalArgumentException, IllegalStateException
    {
      this.a.cdsect(paramString);
    }
    
    public void comment(String paramString)
      throws IOException, IllegalArgumentException, IllegalStateException
    {
      this.a.comment(paramString);
    }
    
    public void docdecl(String paramString)
      throws IOException, IllegalArgumentException, IllegalStateException
    {
      this.a.docdecl(paramString);
    }
    
    public void endDocument()
      throws IOException, IllegalArgumentException, IllegalStateException
    {
      this.a.endDocument();
    }
    
    public XmlSerializer endTag(String paramString1, String paramString2)
      throws IOException, IllegalArgumentException, IllegalStateException
    {
      return this.a.endTag(paramString1, paramString2);
    }
    
    public void entityRef(String paramString)
      throws IOException, IllegalArgumentException, IllegalStateException
    {
      this.a.entityRef(paramString);
    }
    
    public void flush()
      throws IOException
    {
      this.a.flush();
    }
    
    public int getDepth()
    {
      return this.a.getDepth();
    }
    
    public boolean getFeature(String paramString)
    {
      return this.a.getFeature(paramString);
    }
    
    public String getName()
    {
      return this.a.getName();
    }
    
    public String getNamespace()
    {
      return this.a.getNamespace();
    }
    
    public String getPrefix(String paramString, boolean paramBoolean)
      throws IllegalArgumentException
    {
      return this.a.getPrefix(paramString, paramBoolean);
    }
    
    public Object getProperty(String paramString)
    {
      return this.a.getProperty(paramString);
    }
    
    public void ignorableWhitespace(String paramString)
      throws IOException, IllegalArgumentException, IllegalStateException
    {
      this.a.ignorableWhitespace(paramString);
    }
    
    public void processingInstruction(String paramString)
      throws IOException, IllegalArgumentException, IllegalStateException
    {
      this.a.processingInstruction(paramString);
    }
    
    public void setFeature(String paramString, boolean paramBoolean)
      throws IllegalArgumentException, IllegalStateException
    {
      this.a.setFeature(paramString, paramBoolean);
    }
    
    public void setOutput(OutputStream paramOutputStream, String paramString)
      throws IOException, IllegalArgumentException, IllegalStateException
    {
      this.a.setOutput(paramOutputStream, paramString);
    }
    
    public void setOutput(Writer paramWriter)
      throws IOException, IllegalArgumentException, IllegalStateException
    {
      this.a.setOutput(paramWriter);
    }
    
    public void setPrefix(String paramString1, String paramString2)
      throws IOException, IllegalArgumentException, IllegalStateException
    {
      this.a.setPrefix(paramString1, paramString2);
    }
    
    public void setProperty(String paramString, Object paramObject)
      throws IllegalArgumentException, IllegalStateException
    {
      this.a.setProperty(paramString, paramObject);
    }
    
    public void startDocument(String paramString, Boolean paramBoolean)
      throws IOException, IllegalArgumentException, IllegalStateException
    {
      this.a.startDocument(paramString, paramBoolean);
    }
    
    public XmlSerializer startTag(String paramString1, String paramString2)
      throws IOException, IllegalArgumentException, IllegalStateException
    {
      return this.a.startTag(paramString1, paramString2);
    }
    
    public XmlSerializer text(String paramString)
      throws IOException, IllegalArgumentException, IllegalStateException
    {
      if (paramString != null) {
        try
        {
          XmlSerializer localXmlSerializer = this.a.text(anbk.w(paramString, false));
          return localXmlSerializer;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("StructMsg", 4, "XmlSerializer . text  IllegalArgumentException。。。。。");
          }
        }
      }
      return this.a.text(paramString);
    }
    
    public XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws IOException, IllegalArgumentException, IllegalStateException
    {
      return this.a.text(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsStructMsg
 * JD-Core Version:    0.7.0.1
 */