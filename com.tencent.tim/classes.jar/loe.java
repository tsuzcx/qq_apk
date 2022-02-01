import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.tencent.biz.pubaccount.readinjoy.notecard.SoundCheckRunnable;
import com.tencent.biz.pubaccount.readinjoy.notecard.SoundCheckRunnable.a;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.NoteCardProteusItem.5;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class loe
  implements SoundCheckRunnable.a, lpi
{
  private SoundCheckRunnable a;
  private boolean akI;
  private lie c;
  private Context mContext;
  private boolean mIsResume;
  
  private SpannableStringBuilder a(JSONArray paramJSONArray)
    throws Exception
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject = new JSONObject(paramJSONArray.get(i).toString());
      String str = ((JSONObject)localObject).optString("word", "    ");
      int j = Color.parseColor(((JSONObject)localObject).optString("color", "#C3C0D6"));
      int k = Integer.valueOf(((JSONObject)localObject).optString("size", "15")).intValue();
      localObject = new SpannableString(str);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(j), 0, str.length(), 33);
      ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(k, true), 0, str.length(), 33);
      localSpannableStringBuilder.append((CharSequence)localObject);
      i += 1;
    }
    return localSpannableStringBuilder;
  }
  
  private void aK(Activity paramActivity)
  {
    try
    {
      new akwo(this.mContext, this.mContext.getPackageName()).dDC();
      jll.openPermissionActivity(paramActivity);
      return;
    }
    catch (Exception paramActivity)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("NoteCardProteusItem", 1, paramActivity, new Object[0]);
    }
  }
  
  private void aMO()
  {
    if ((this.a == null) || (!this.a.isRecording()))
    {
      this.a = new SoundCheckRunnable();
      this.a.a(this);
      ThreadManager.excute(this.a, 16, null, true);
      ThreadManager.getUIHandler().removeCallbacksAndMessages(null);
      ThreadManager.getUIHandler().postDelayed(new NoteCardProteusItem.5(this), 60000L);
    }
  }
  
  private void aMP()
  {
    if (this.a != null)
    {
      this.a.stop();
      this.a.a(null);
      this.a = null;
    }
    ThreadManager.getUIHandler().removeCallbacksAndMessages(null);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
    throws JSONException
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
    throws JSONException
  {
    int i = 0;
    paramInt = 0;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInjoy_zhitiao_view");
    for (;;)
    {
      mhz localmhz;
      try
      {
        localmhz = paramBaseArticleInfo.scripCmsInfo;
        if (localmhz == null) {
          break;
        }
        if ((localmhz.JP == 1) || ((TextUtils.isEmpty(localmhz.ahI)) && (TextUtils.isEmpty(localmhz.ahJ))))
        {
          paramBaseArticleInfo = new JSONObject(localmhz.py).getJSONArray("S");
          Object localObject = new JSONObject(localmhz.subTitle).getJSONArray("S");
          localJSONObject.put("main_title_rich", a(paramBaseArticleInfo));
          localJSONObject.put("sub_title_rich", a((JSONArray)localObject));
          localJSONObject.put("privacy_text", localmhz.ahF);
          paramBaseArticleInfo = ljp.jx();
          localObject = BaseApplicationImpl.getContext();
          if ((Build.VERSION.SDK_INT < 23) || (localObject == null)) {
            break label408;
          }
          if (((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
            paramInt = 1;
          }
          if ((paramInt == 0) && (ljp.oH() == 1))
          {
            localJSONObject.put("tips_text", ((Context)localObject).getString(2131718455));
            localJSONObject.put("icon_image_url", localmhz.ahG);
            localJSONObject.put("bg_image_url", localmhz.backgroundUrl);
            localJSONObject.put("animation_url", localmhz.ahH);
            return localJSONObject;
          }
          localJSONObject.put("tips_text", paramBaseArticleInfo);
          continue;
        }
        localJSONObject.put("main_title_rich", localmhz.ahI.replace("#$%", ljp.jv()));
      }
      catch (Exception paramBaseArticleInfo)
      {
        QLog.d("NoteCardProteusItem", 2, paramBaseArticleInfo.getMessage());
        return localJSONObject;
      }
      paramBaseArticleInfo = BaseApplicationImpl.getContext();
      if ((Build.VERSION.SDK_INT >= 23) && (paramBaseArticleInfo != null))
      {
        paramInt = i;
        if (paramBaseArticleInfo.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {}
      }
      for (paramInt = 1;; paramInt = 1)
      {
        if ((paramInt == 0) && (ljp.oH() == 1)) {}
        for (paramBaseArticleInfo = localmhz.ahJ.replace("#$%", paramBaseArticleInfo.getString(2131718454));; paramBaseArticleInfo = localmhz.ahJ.replace("#$%", ljp.jw()))
        {
          localJSONObject.put("sub_title_rich", paramBaseArticleInfo);
          localJSONObject.put("bg_image_url", localmhz.ahK);
          return localJSONObject;
        }
      }
      label408:
      paramInt = 1;
    }
    return localJSONObject;
  }
  
  public void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    ndi localndi;
    if ((paramlie != null) && (paramlie.b() != null))
    {
      localndi = paramlie.b();
      this.mContext = paramContainer.getContext();
      this.c = paramlie;
      localObject = paramContainer.getViewIdMapping();
      if ((((Map)localObject).get("id_lottie_view") == null) || (!(((Map)localObject).get("id_lottie_view") instanceof lsb))) {
        break label102;
      }
    }
    label102:
    for (Object localObject = (lsb)((Map)localObject).get("id_lottie_view");; localObject = null)
    {
      localndi.a(new lof(this, (lsb)localObject, paramlie, paramContainer));
      return;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, lie paramlie, ViewBase paramViewBase)
  {
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return false;
    case 1162: 
      paramViewBase.setOnClickListener(new log(this, paramlie, paramContainer));
      return true;
    case 1163: 
      paramViewBase.setOnClickListener(new loh(this, paramContainer));
      return true;
    }
    paramViewBase.setOnClickListener(new loi(this, paramContainer));
    return true;
  }
  
  public void aMH()
  {
    if (this.mContext != null)
    {
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      if (ljp.n(this.mContext, str) >= mhz.aSF) {
        break label51;
      }
      if (this.c != null) {
        this.c.b().aVZ();
      }
    }
    return;
    label51:
    QQToast.a(this.mContext, 0, this.mContext.getString(2131718541), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     loe
 * JD-Core Version:    0.7.0.1
 */