import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng.CUOpenCardClickableSpan.1;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng.CUOpenCardClickableSpan.2;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng.GuideConfigData.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Locale;
import mqq.manager.Manager;
import org.json.JSONObject;

public class aiyw
  implements Manager
{
  public static final String[] fs = { "entry_setting", "entry_aio_video", "entry_file", "entry_chat_audio", "entry_chat_video", "entry_kandian_video" };
  final aiyw.b a;
  
  public aiyw(QQAppInterface paramQQAppInterface)
  {
    this.a = new aiyw.b(paramQQAppInterface.getAccount());
  }
  
  public static CharSequence a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramQQAppInterface != null) {}
    for (;;)
    {
      try
      {
        localObject1 = (aiyw)paramQQAppInterface.getManager(221);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
          if (((aiyw)localObject1).isInit())
          {
            localObject1 = ((aiyw)localObject1).a(paramInt);
            i = 0;
            j = i;
            localObject2 = paramString;
            if (localObject1 != null)
            {
              j = i;
              localObject2 = paramString;
            }
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        Object localObject1;
        i = 0;
      }
      try
      {
        if (!TextUtils.isEmpty(((aiyw.c)localObject1).tip))
        {
          j = i;
          localObject2 = paramString;
          if (!TextUtils.isEmpty(((aiyw.c)localObject1).keyWord))
          {
            j = i;
            localObject2 = paramString;
            if (((aiyw.c)localObject1).tip.contains(((aiyw.c)localObject1).keyWord))
            {
              j = i;
              localObject2 = paramString;
              if (!TextUtils.isEmpty(((aiyw.c)localObject1).jumpUrl))
              {
                String str = String.format("%s\n%s", new Object[] { paramString, ((aiyw.c)localObject1).tip });
                localObject2 = new SpannableString(str);
                j = str.indexOf(((aiyw.c)localObject1).keyWord);
                int k = ((aiyw.c)localObject1).keyWord.length();
                ((SpannableString)localObject2).setSpan(new aiyw.a(paramContext, ((aiyw.c)localObject1).jumpUrl, paramQQAppInterface.getCurrentUin(), paramInt), j, k + j, 17);
                j = i;
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("CUOpenCardGuideMng", 2, String.format(Locale.getDefault(), "getGuideEntry entry: %d retCode: %d context: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramContext }));
        }
        return localObject2;
      }
      catch (Exception paramQQAppInterface)
      {
        break label301;
      }
      localObject1 = null;
      int i = 3;
      continue;
      localObject1 = ((aiyw)localObject1).a(paramInt);
      i = 0;
      continue;
      label301:
      int j = i;
      Object localObject2 = paramString;
      if (QLog.isColorLevel())
      {
        QLog.i("CUOpenCardGuideMng", 2, "getGuideEnty", paramQQAppInterface);
        j = i;
        localObject2 = paramString;
        continue;
        j = 0;
        localObject2 = paramString;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    int i = aqiw.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext());
    Object localObject1 = null;
    long l2 = 0L;
    long l1 = 0L;
    aqux.a locala;
    if (i != 1)
    {
      l2 = aqmj.n(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin());
      l1 = System.currentTimeMillis();
      locala = aqux.a(paramString2, true, false);
      if (QLog.isColorLevel()) {
        QLog.d("CUOpenCardGuideMng", 2, "WL_DEBUG addCallGrayTip info.mPopUpType = " + locala.edc + ", info.mGuideJumpUrl = " + locala.cxV);
      }
      paramString2 = (aiyw)paramQQAppInterface.getManager(221);
      if (paramString2 == null) {
        break label622;
      }
      if (!paramBoolean) {
        break label579;
      }
      paramString2 = paramString2.a(4);
    }
    for (;;)
    {
      String[] arrayOfString2;
      String[] arrayOfString1;
      Bundle localBundle;
      Object localObject3;
      Object localObject2;
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2.tip)) && (!TextUtils.isEmpty(paramString2.keyWord)) && (!TextUtils.isEmpty(locala.cxV)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CUOpenCardGuideMng", 2, "WL_DEBUG addCallGrayTip entry.tip = " + paramString2.tip + ", entry.keyWord = " + paramString2.keyWord);
        }
        arrayOfString2 = paramString2.tip.split("\\|");
        arrayOfString1 = paramString2.keyWord.split("\\|");
        localBundle = null;
        localObject3 = null;
        localObject1 = localObject3;
        localObject2 = localBundle;
        if (arrayOfString2.length >= 2)
        {
          localObject1 = localObject3;
          localObject2 = localBundle;
          if (arrayOfString1.length >= 2)
          {
            if (locala.edc != 2) {
              break label590;
            }
            localObject2 = arrayOfString2[0];
            localObject1 = arrayOfString1[0];
          }
        }
      }
      for (;;)
      {
        if ((localObject2 != null) && (localObject1 != null))
        {
          localBundle = new Bundle();
          localBundle.putInt("key_action", 1);
          localBundle.putString("textColor", "#1e6fff");
          localBundle.putString("key_action_DATA", locala.cxV);
          int j = ((String)localObject2).indexOf((String)localObject1);
          int k = ((String)localObject1).length();
          localObject1 = new ahwa(paramString1, paramQQAppInterface.getCurrentUin(), (String)localObject2, paramInt, -5020, 3145729, anaz.gQ());
          localObject2 = new MessageForUniteGrayTip();
          if (j >= 0) {
            ((ahwa)localObject1).addHightlightItem(j, k + j, localBundle);
          }
          ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramQQAppInterface, (ahwa)localObject1);
          ahwb.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject2);
          anot.a(null, "dc00898", "", "", "0X800812A", "0X800812A", 0, 0, "", "", "", "");
          aqmj.t(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentUin(), System.currentTimeMillis());
        }
        localObject1 = paramString2;
        if (QLog.isColorLevel()) {
          QLog.i("CUOpenCardGuideMng", 2, "addCallGrayTip, friendUin= " + paramString1 + ",isVideoMsg=" + paramBoolean + ",netType=" + i + ",uinType=" + paramInt + ",lastAlertTime=" + l2 + ",currentTime=" + l1 + ",entry=" + localObject1);
        }
        return;
        label579:
        paramString2 = paramString2.a(3);
        break;
        label590:
        localObject1 = localObject3;
        localObject2 = localBundle;
        if (locala.edc == 3)
        {
          localObject2 = arrayOfString2[1];
          localObject1 = arrayOfString1[1];
        }
      }
      label622:
      paramString2 = null;
    }
  }
  
  public void Me(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CUOpenCardGuideMng", 2, String.format(Locale.getDefault(), "onGetConfig isInit: %b, config: %s", new Object[] { Boolean.valueOf(this.a.mIsInit), paramString }));
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("ChinaUnicomPhoneCard" + this.a.mAccount, 4).edit();
    paramString.putString("config_content", str);
    paramString.commit();
    this.a.bj(str);
  }
  
  public aiyw.c a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CUOpenCardGuideMng", 2, String.format(Locale.getDefault(), "getGuideEntry entry: %d, isInit: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.a.mIsInit) }));
    }
    this.a.eX();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.a.cmN)
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < this.a.a.length) {
          localObject1 = this.a.a[paramInt];
        }
      }
    }
    return localObject1;
  }
  
  public void init()
  {
    this.a.eX();
  }
  
  public boolean isInit()
  {
    return this.a.mIsInit;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CUOpenCardGuideMng", 2, "onDestroy");
    }
  }
  
  public static class a
    extends ClickableSpan
  {
    public final int RH;
    final Context context;
    final int linkColor;
    final String uin;
    final String url;
    
    public a(Context paramContext, String paramString1, String paramString2, int paramInt)
    {
      this.context = paramContext;
      this.url = paramString1;
      this.uin = paramString2;
      this.RH = paramInt;
      this.linkColor = Color.parseColor("#00a5e0");
      ThreadManager.post(new CUOpenCardGuideMng.CUOpenCardClickableSpan.1(this), 5, null, false);
    }
    
    public void onClick(View paramView)
    {
      paramView = new Intent(this.context, QQBrowserActivity.class);
      paramView.putExtra("uin", this.uin);
      paramView.putExtra("url", this.url);
      paramView.putExtra("hide_more_button", true);
      this.context.startActivity(paramView);
      ThreadManager.post(new CUOpenCardGuideMng.CUOpenCardClickableSpan.2(this), 5, null, false);
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      paramTextPaint.setColor(this.linkColor);
      paramTextPaint.setUnderlineText(false);
    }
  }
  
  public static class b
  {
    public aiyw.c[] a;
    public long abZ;
    public String bQh;
    public boolean cmN;
    public final String mAccount;
    public boolean mIsInit;
    public final ArrayList<Integer> xx;
    
    public b(String paramString)
    {
      this.mAccount = paramString;
      this.bQh = "";
      this.cmN = false;
      this.a = new aiyw.c[6];
      int i = 0;
      while (i < this.a.length)
      {
        this.a[i] = null;
        i += 1;
      }
      this.abZ = 0L;
      this.xx = aqgz.dZ();
      ThreadManager.post(new CUOpenCardGuideMng.GuideConfigData.1(this), 5, null, false);
    }
    
    public void bj(String paramString)
    {
      int j = 0;
      int i = 0;
      this.mIsInit = true;
      this.abZ = SystemClock.elapsedRealtime();
      if ((this.bQh != null) && (this.bQh.equals(paramString))) {
        if (QLog.isColorLevel()) {
          QLog.i("CUOpenCardGuideMng", 2, "parseConfig config not change");
        }
      }
      do
      {
        return;
        if (!TextUtils.isEmpty(paramString)) {
          break;
        }
        this.cmN = false;
        while (i < this.a.length)
        {
          this.a[i] = null;
          i += 1;
        }
        this.bQh = "";
      } while (!QLog.isColorLevel());
      QLog.i("CUOpenCardGuideMng", 2, "parseConfig config is empty");
      return;
      for (;;)
      {
        Object localObject;
        try
        {
          localObject = new JSONObject(paramString);
          if (!((JSONObject)localObject).has("isNeedShowGuide")) {
            break label359;
          }
          this.cmN = ((JSONObject)localObject).getBoolean("isNeedShowGuide");
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return;
        }
        finally {}
        if ((i < this.a.length) && (i < aiyw.fs.length))
        {
          if (((JSONObject)localObject).has(aiyw.fs[i])) {
            this.a[i] = aiyw.c.a(((JSONObject)localObject).getJSONObject(aiyw.fs[i]));
          } else {
            this.a[i] = null;
          }
        }
        else
        {
          this.bQh = paramString;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localObject = new StringBuilder(300);
          ((StringBuilder)localObject).append("parseConfig:").append("\n");
          ((StringBuilder)localObject).append("config: ").append(paramString).append("\n");
          ((StringBuilder)localObject).append("mIsShowGuide: ").append(this.cmN).append("\n");
          i = j;
          while ((i < this.a.length) && (i < aiyw.fs.length))
          {
            ((StringBuilder)localObject).append(aiyw.fs[i]).append(": ").append(this.a[i]).append("\n");
            i += 1;
          }
          QLog.i("CUOpenCardGuideMng", 2, ((StringBuilder)localObject).toString());
          continue;
          label359:
          i = 0;
          continue;
        }
        i += 1;
      }
    }
    
    public void eX()
    {
      if (this.mIsInit) {}
      do
      {
        return;
        bj(BaseApplicationImpl.getApplication().getSharedPreferences("ChinaUnicomPhoneCard" + this.mAccount, 4).getString("config_content", ""));
      } while (!QLog.isColorLevel());
      QLog.i("CUOpenCardGuideMng", 2, "init");
    }
  }
  
  public static class c
  {
    public String jumpUrl;
    public String keyWord;
    public String tip;
    
    public static c a(JSONObject paramJSONObject)
    {
      if (paramJSONObject != null) {
        for (;;)
        {
          try
          {
            localObject = new c();
            try
            {
              if (paramJSONObject.has("tip"))
              {
                ((c)localObject).tip = paramJSONObject.getString("tip");
                if (!paramJSONObject.has("key_word")) {
                  continue;
                }
                ((c)localObject).keyWord = paramJSONObject.getString("key_word");
                if (!paramJSONObject.has("jump_url")) {
                  continue;
                }
                ((c)localObject).jumpUrl = paramJSONObject.getString("jump_url");
                return localObject;
              }
              ((c)localObject).tip = "";
              continue;
              localObject = paramJSONObject;
            }
            catch (Exception localException1)
            {
              paramJSONObject = (JSONObject)localObject;
            }
          }
          catch (Exception localException2)
          {
            paramJSONObject = null;
            continue;
          }
          if (!QLog.isColorLevel()) {
            return localObject;
          }
          QLog.i("CUOpenCardGuideMng", 2, "GuideEntry-parse", localException1);
          return paramJSONObject;
          ((c)localObject).keyWord = "";
          continue;
          ((c)localObject).jumpUrl = "";
          return localObject;
        }
      }
      Object localObject = null;
      return localObject;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append("[tip:").append(this.tip).append(", key_word:").append(this.keyWord).append(", jump_url:").append(this.jumpUrl).append("]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiyw
 * JD-Core Version:    0.7.0.1
 */