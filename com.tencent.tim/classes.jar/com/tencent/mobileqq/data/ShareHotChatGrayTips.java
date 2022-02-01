package com.tencent.mobileqq.data;

import acfp;
import acgi;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class ShareHotChatGrayTips
  extends ChatMessage
{
  private static final String HOT_NAME_CODE = "hotnamecode";
  private static final String JUMP_URL = "jump_url";
  private static final String MSG_CONTENT = "msg_content";
  private static final String MSG_CONTENT_HIGHLIGHT = "msg_content_highlight";
  public static final String SHARE_GRAY_TIP_CONTENT = acfp.m(2131714401);
  private static final String TROOP_NAME = "troop_name";
  private static final String TROOP_UIN = "troop_uin";
  public String mHotnamecode;
  public String mJumpUrl;
  public String mMsgContent;
  public String mMsgContentHighlight;
  public String mTroopName;
  public String mTroopUin;
  
  public static String makeShareGrayTip(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("msg_content", paramString1);
      localJSONObject.put("msg_content_highlight", paramString2);
      localJSONObject.put("troop_uin", paramString3);
      localJSONObject.put("troop_name", paramString4);
      localJSONObject.put("jump_url", paramString5);
      localJSONObject.put("hotnamecode", paramString6);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  protected void doParse()
  {
    String str = this.msg;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(str);
        if (localJSONObject.has("msg_content"))
        {
          this.mMsgContent = localJSONObject.getString("msg_content");
          if (localJSONObject.has("msg_content_highlight"))
          {
            this.mMsgContentHighlight = localJSONObject.getString("msg_content_highlight");
            if (!localJSONObject.has("troop_uin")) {
              break label176;
            }
            this.mTroopUin = localJSONObject.getString("troop_uin");
            if (!localJSONObject.has("troop_name")) {
              break label184;
            }
            this.mTroopName = localJSONObject.getString("troop_name");
            if (!localJSONObject.has("jump_url")) {
              break label192;
            }
            this.mJumpUrl = localJSONObject.getString("jump_url");
            if (!localJSONObject.has("hotnamecode")) {
              break;
            }
            this.mHotnamecode = localJSONObject.getString("hotnamecode");
          }
        }
        else
        {
          this.mMsgContent = null;
          continue;
        }
        this.mMsgContentHighlight = null;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        this.mMsgContent = str;
        this.mMsgContentHighlight = null;
        this.mTroopUin = null;
        this.mTroopName = null;
        this.mJumpUrl = null;
        return;
      }
      continue;
      label176:
      this.mTroopUin = null;
      continue;
      label184:
      this.mTroopName = null;
      continue;
      label192:
      this.mJumpUrl = null;
    }
    this.mHotnamecode = null;
  }
  
  public SpannableString getHighlightMsgText(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((!TextUtils.isEmpty(this.mMsgContent)) && (!TextUtils.isEmpty(this.mMsgContentHighlight))) {}
    for (int i = this.mMsgContent.indexOf(this.mMsgContentHighlight);; i = -1)
    {
      int j = 0;
      if (i >= 0) {
        j = this.mMsgContentHighlight.length() + i;
      }
      SpannableString localSpannableString = new SpannableString(this.mMsgContent);
      if ((i >= 0) && (j > i)) {
        localSpannableString.setSpan(new a(paramQQAppInterface, paramContext, this, this.mHotnamecode), i, j, 33);
      }
      return localSpannableString;
    }
  }
  
  static class a
    extends ClickableSpan
  {
    private acgi jdField_a_of_type_Acgi;
    private ShareHotChatGrayTips jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips;
    private String bCx;
    private WeakReference<QQAppInterface> eg;
    private WeakReference<Context> eh;
    
    public a(QQAppInterface paramQQAppInterface, Context paramContext, ShareHotChatGrayTips paramShareHotChatGrayTips, String paramString)
    {
      this.eg = new WeakReference(paramQQAppInterface);
      this.eh = new WeakReference(paramContext);
      this.jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips = paramShareHotChatGrayTips;
      this.bCx = paramString;
      this.jdField_a_of_type_Acgi = new acgi((BaseActivity)paramContext, paramQQAppInterface, null);
    }
    
    public void onClick(View paramView)
    {
      paramView = (QQAppInterface)this.eg.get();
      if (((Context)this.eh.get() != null) && (this.jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips != null))
      {
        paramView = ((HotChatManager)paramView.getManager(60)).a(this.jdField_a_of_type_ComTencentMobileqqDataShareHotChatGrayTips.mTroopUin);
        this.jdField_a_of_type_Acgi.b(paramView);
      }
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      paramTextPaint.setColor(-14782465);
      paramTextPaint.setUnderlineText(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ShareHotChatGrayTips
 * JD-Core Version:    0.7.0.1
 */