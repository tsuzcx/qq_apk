package com.tencent.mobileqq.data;

import ajpc;
import ajqy;
import ajri;
import anaz;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import anot;
import aqft;
import aqhv;
import aqik;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForNearbyMarketGrayTips
  extends ChatMessage
{
  public static final int ACTION_AUTO_INPUT = 3;
  public static final int ACTION_AUTO_INPUT_FACE_SCORE = 4;
  public static final int ACTION_DEFAULT = 0;
  public static final int ACTION_JUMP_NATIVE = 2;
  public static final int ACTION_JUMP_WEB = 1;
  private static final String NAME_AIO_TYPE = "aioType";
  private static final String NAME_CONTENT = "content";
  private static final String NAME_HIGHTLIGHT = "high_light";
  private static final String NAME_ID = "id";
  private static final String NAME_LINK = "link";
  private static final String NAME_SCENE = "scene";
  public static final int SCENE_AIO = 8;
  public static final int SCENE_AIO_FACE_SCORE = 16;
  public static final int SCENE_DEFAULT = 0;
  public static final int SCENE_KEYWORD = 4;
  public static final int SCENE_SAY_HI = 1;
  public static final int SCENE_SAY_HI_FREQ = 2;
  public static final String TAG = "MessageForNearbyMarketGrayTips";
  public int AioType;
  public int gender;
  private String mContent;
  private String mHighLight;
  private int mId;
  private String mLink;
  private int mScene;
  
  public static String makeGrayTipMsg(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", paramInt1);
      localJSONObject.put("content", paramString1);
      localJSONObject.put("high_light", paramString2);
      localJSONObject.put("scene", paramInt2);
      localJSONObject.put("link", paramString3);
      localJSONObject.put("aioType", paramInt3);
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
    if (QLog.isDevelopLevel()) {
      QLog.i("MessageForNearbyMarketGrayTips", 4, "doParse: " + this.msg);
    }
    String str = this.msg;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(str);
        this.mId = localJSONObject.getInt("id");
        this.mContent = localJSONObject.getString("content");
        if (localJSONObject.has("high_light"))
        {
          this.mHighLight = localJSONObject.getString("high_light");
          if (localJSONObject.has("scene"))
          {
            this.mScene = localJSONObject.getInt("scene");
            if (!localJSONObject.has("link")) {
              break label192;
            }
            this.mLink = localJSONObject.getString("link");
            if (!localJSONObject.has("aioType")) {
              break;
            }
            this.AioType = localJSONObject.getInt("aioType");
          }
        }
        else
        {
          this.mHighLight = null;
          continue;
        }
        this.mScene = 0;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        this.mContent = str;
        this.mHighLight = null;
        this.mScene = 0;
        this.mLink = null;
        this.AioType = 0;
        return;
      }
      continue;
      label192:
      this.mLink = null;
    }
    this.AioType = 0;
  }
  
  public SpannableString getHightlightMsgText(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((!TextUtils.isEmpty(this.mContent)) && (!TextUtils.isEmpty(this.mHighLight))) {}
    for (int j = this.mContent.indexOf(this.mHighLight);; j = -1)
    {
      if (j >= 0) {}
      for (int k = this.mHighLight.length() + j;; k = 0)
      {
        SpannableString localSpannableString = new SpannableString(this.mContent);
        int i;
        if ((j >= 0) && (k > j)) {
          switch (this.mScene)
          {
          default: 
            i = 0;
          }
        }
        for (;;)
        {
          localSpannableString.setSpan(new a(paramQQAppInterface, paramContext, this.mId, -14782465, i, this.mLink, this.mScene, this), j, k, 33);
          return localSpannableString;
          if (TextUtils.isEmpty(this.mLink)) {
            break;
          }
          if (this.mLink.startsWith("mqqapi://"))
          {
            i = 2;
          }
          else
          {
            i = 1;
            continue;
            i = 3;
            continue;
            i = 4;
          }
        }
      }
    }
  }
  
  static class a
    extends ClickableSpan
  {
    private long Xd;
    private MessageForNearbyMarketGrayTips a;
    private WeakReference<QQAppInterface> eg;
    private WeakReference<Context> eh;
    private int mAction;
    private int mColor;
    private String mData;
    private int mGender = 2147483647;
    private int mId;
    private int mScene;
    
    public a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, MessageForNearbyMarketGrayTips paramMessageForNearbyMarketGrayTips)
    {
      this.eg = new WeakReference(paramQQAppInterface);
      this.eh = new WeakReference(paramContext);
      this.mId = paramInt1;
      this.mColor = paramInt2;
      this.mAction = paramInt3;
      this.mData = paramString;
      this.mScene = paramInt4;
      this.a = paramMessageForNearbyMarketGrayTips;
    }
    
    public void HC(String paramString)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("MessageForNearbyMarketGrayTips", 4, "clickJumpWeb, url = " + paramString);
      }
      if (TextUtils.isEmpty(paramString)) {}
      Context localContext;
      do
      {
        return;
        localContext = (Context)this.eh.get();
      } while (localContext == null);
      Object localObject = paramString;
      if (paramString.contains("strangerUin=xxx")) {
        localObject = paramString.replace("strangerUin=xxx", "strangerUin=" + this.a.frienduin);
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)this.eg.get();
      paramString = (String)localObject;
      if (localQQAppInterface != null)
      {
        paramString = (String)localObject;
        if (((String)localObject).contains("sign=xxx"))
        {
          if (1001 != this.a.istroop) {
            break label352;
          }
          paramString = ((String)localObject).replace("sign=xxx", "sign=" + aqft.bytesToHexString(localQQAppInterface.a().T(this.a.frienduin)));
        }
        localObject = paramString;
        if (paramString.contains("sourceType=xxx"))
        {
          if (1001 != this.a.istroop) {
            break label472;
          }
          localObject = paramString.replace("sourceType=xxx", "sourceType=1");
        }
      }
      for (;;)
      {
        paramString = (String)localObject;
        if (((String)localObject).equals("https://imgcache.qq.com/club/client/flower/release/html/index.html"))
        {
          paramString = this.a.frienduin;
          localObject = aqft.bytesToHexString(localQQAppInterface.a().T(paramString));
          localObject = String.format("https://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { ajri.encode(paramString), ((String)localObject).toLowerCase(), Integer.valueOf(1), "aio.plus.s", "" });
          paramString = (String)localObject;
          if (QLog.isColorLevel())
          {
            QLog.i("MessageForNearbyMarketGrayTips", 2, "jump flow store, " + (String)localObject);
            paramString = (String)localObject;
          }
        }
        localObject = new Intent(localContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", URLUtil.guessUrl(paramString));
        localContext.startActivity((Intent)localObject);
        return;
        label352:
        if (1010 == this.a.istroop)
        {
          paramString = ((String)localObject).replace("sign=xxx", "sign=" + aqft.bytesToHexString(localQQAppInterface.a().W(this.a.frienduin)));
          break;
        }
        paramString = (String)localObject;
        if (10002 != this.a.istroop) {
          break;
        }
        paramString = ((String)localObject).replace("sign=xxx", "sign=" + aqft.bytesToHexString(localQQAppInterface.a().R(this.a.frienduin)));
        break;
        label472:
        localObject = paramString;
        if (1010 == this.a.istroop) {
          localObject = paramString.replace("sourceType=xxx", "sourceType=2");
        }
      }
    }
    
    public void HD(String paramString)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("MessageForNearbyMarketGrayTips", 4, "clickJumpNative, schema = " + paramString);
      }
      if (TextUtils.isEmpty(paramString)) {}
      Context localContext;
      do
      {
        return;
        localObject = (QQAppInterface)this.eg.get();
        localContext = (Context)this.eh.get();
      } while ((localObject == null) || (localContext == null));
      Object localObject = aqik.c((QQAppInterface)localObject, localContext, paramString);
      if (localObject != null)
      {
        ((aqhv)localObject).ace();
        return;
      }
      HC(paramString);
    }
    
    public void HE(String paramString)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("MessageForNearbyMarketGrayTips", 4, "clickAutoInput, content = " + paramString);
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)this.eg.get();
      if (localQQAppInterface == null) {}
      long l;
      do
      {
        return;
        l = Math.abs(System.currentTimeMillis() - this.Xd);
        if (l <= 5000L) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("MessageForNearbyMarketGrayTips", 2, "clickAutoInput, time = " + l);
      return;
      ((ajqy)localQQAppInterface.getBusinessHandler(66)).g("tag_nearby_chat", paramString, null);
      ThreadManager.post(new MessageForNearbyMarketGrayTips.HightlightClickableSpan.4(this, localQQAppInterface), 2, null, false);
    }
    
    public String k(int paramInt, boolean paramBoolean)
    {
      Object localObject = (QQAppInterface)this.eg.get();
      if (localObject == null) {
        return null;
      }
      localObject = (NearbyGrayTipsManager)((QQAppInterface)localObject).getManager(93);
      if (localObject != null) {
        return ((NearbyGrayTipsManager)localObject).a(this.mId, paramInt, paramBoolean);
      }
      return "";
    }
    
    public void onClick(View paramView)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)this.eg.get();
      if (localQQAppInterface != null)
      {
        anot.a(localQQAppInterface, "CliOper", "", "", "0X800524C", "0X800524C", 0, 0, String.valueOf(this.mId), "", "", "");
        if (this.a.AioType == 0)
        {
          paramView = "0";
          anot.a(localQQAppInterface, "dc00899", "grp_lbs", "", "tmp_grey", "clk_link", 0, 0, paramView, "", "", "");
        }
      }
      else
      {
        switch (this.mAction)
        {
        }
      }
      label343:
      label350:
      do
      {
        do
        {
          return;
          paramView = "1";
          break;
          HC(this.mData);
          return;
          HD(this.mData);
          return;
          this.Xd = System.currentTimeMillis();
          paramView = r(false);
          if (TextUtils.isEmpty(paramView))
          {
            ThreadManager.post(new MessageForNearbyMarketGrayTips.HightlightClickableSpan.1(this), 5, null, true);
            return;
          }
          HE(paramView);
          return;
          this.Xd = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("MessageForNearbyMarketGrayTipsQ..troop.faceScore", 2, "ACTION_AUTO_INPUT_FACE_SCORE. mGender=" + this.mGender);
          }
        } while (localQQAppInterface == null);
        if (ajpc.a(this.a, "isFaceScoreSecondMember"))
        {
          paramView = "2";
          if (!ajpc.a(this.a, "isFaceScoreSpecialLike")) {
            break label343;
          }
        }
        for (String str = "2";; str = "1")
        {
          ajpc.b("clk_hi", this.a.frienduin, new String[] { paramView, "", "", str });
          if (this.mGender != 2147483647) {
            break label350;
          }
          ThreadManager.post(new MessageForNearbyMarketGrayTips.HightlightClickableSpan.2(this, localQQAppInterface), 5, null, true);
          return;
          paramView = "1";
          break;
        }
        paramView = k(this.mGender, false);
        if (TextUtils.isEmpty(paramView))
        {
          ThreadManager.post(new MessageForNearbyMarketGrayTips.HightlightClickableSpan.3(this), 5, null, true);
          return;
        }
        HE(paramView);
      } while (!QLog.isColorLevel());
      QLog.d("MessageForNearbyMarketGrayTipsQ..troop.faceScore", 2, "ACTION_AUTO_INPUT_FACE_SCORE. from cache. FaceScoreWording=" + paramView);
    }
    
    public String r(boolean paramBoolean)
    {
      Object localObject = (QQAppInterface)this.eg.get();
      if (localObject == null) {
        return null;
      }
      localObject = (NearbyGrayTipsManager)((QQAppInterface)localObject).getManager(93);
      if (localObject != null) {
        return ((NearbyGrayTipsManager)localObject).j(this.mId, paramBoolean);
      }
      return "";
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      if (this.mColor == -1) {
        paramTextPaint.setColor(paramTextPaint.linkColor);
      }
      for (;;)
      {
        paramTextPaint.setUnderlineText(false);
        return;
        paramTextPaint.setColor(this.mColor);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips
 * JD-Core Version:    0.7.0.1
 */