import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class sun
  extends WebViewPlugin
  implements View.OnClickListener
{
  public static int bze = 10000;
  public static int bzf = 10001;
  public static int bzg = 10002;
  public static int bzh = 10003;
  public static int bzi = 10004;
  public static int bzj = 5;
  private QQBrowserActivity jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
  private sun.b jdField_a_of_type_Sun$b;
  public boolean aNi;
  public boolean aNj;
  private WebViewFragment b;
  public int bzd = 40;
  public ViewGroup cG;
  public ViewGroup cH;
  boolean isInit = false;
  
  public sun()
  {
    this.mPluginNameSpace = "pubAccountUI";
  }
  
  private boolean Nm()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (!BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + str, 0).getBoolean("public_account_bottom_bar", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountUIPlugin", 2, "config is false");
      }
      return false;
    }
    return true;
  }
  
  private void a(URLImageView paramURLImageView, URLDrawable paramURLDrawable)
  {
    ScaleAnimation localScaleAnimation1 = new ScaleAnimation(1.0F, 0.1F, 1.0F, 0.1F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation1.setDuration(300L);
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(0.1F, 1.2F, 0.1F, 1.2F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation2.setDuration(100L);
    ScaleAnimation localScaleAnimation3 = new ScaleAnimation(1.2F, 0.9F, 1.2F, 0.9F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation3.setDuration(100L);
    ScaleAnimation localScaleAnimation4 = new ScaleAnimation(0.9F, 1.1F, 0.9F, 1.1F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation4.setDuration(100L);
    ScaleAnimation localScaleAnimation5 = new ScaleAnimation(1.1F, 0.95F, 1.1F, 0.95F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation5.setDuration(100L);
    ScaleAnimation localScaleAnimation6 = new ScaleAnimation(0.95F, 1.0F, 0.95F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation6.setDuration(100L);
    paramURLImageView.startAnimation(localScaleAnimation1);
    localScaleAnimation1.setAnimationListener(new sup(this, paramURLImageView, paramURLDrawable, localScaleAnimation2));
    localScaleAnimation2.setAnimationListener(new suq(this, paramURLImageView, localScaleAnimation3));
    localScaleAnimation3.setAnimationListener(new sur(this, paramURLImageView, localScaleAnimation4));
    localScaleAnimation4.setAnimationListener(new sus(this, paramURLImageView, localScaleAnimation5));
    localScaleAnimation5.setAnimationListener(new sut(this, paramURLImageView, localScaleAnimation6));
  }
  
  private void a(sun.a parama, int paramInt)
  {
    Object localObject1 = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(aqnm.dip2px(24.0F), aqnm.dip2px(24.0F));
    if ((parama.iconUrl != null) || (!TextUtils.isEmpty(parama.iconUrl)))
    {
      Object localObject2 = new ColorDrawable(Color.parseColor("#dddfe2"));
      localObject2 = URLDrawable.getDrawable(parama.iconUrl, aqnm.dip2px(24.0F), aqnm.dip2px(24.0F), (Drawable)localObject2, (Drawable)localObject2, true);
      ((URLImageView)localObject1).setImageDrawable((Drawable)localObject2);
      if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 2)) {
        ((URLDrawable)localObject2).restartDownload();
      }
      if (paramInt != 0) {
        break label604;
      }
      localLayoutParams.leftMargin = 0;
      label121:
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(15);
      ((URLImageView)localObject1).setLayoutParams(localLayoutParams);
      ((URLImageView)localObject1).setTag(parama);
      ((URLImageView)localObject1).setOnClickListener(this);
      this.cH.addView((View)localObject1);
      if ((parama.text != null) && (paramInt != this.jdField_a_of_type_Sun$b.pC.size() - 1))
      {
        localObject1 = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
        localObject2 = new RelativeLayout.LayoutParams(-2, -1);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = (localLayoutParams.leftMargin + aqnm.dip2px(27.0F));
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(9);
        ((RelativeLayout.LayoutParams)localObject2).addRule(15);
        ((TextView)localObject1).setGravity(16);
        ((TextView)localObject1).setText(parama.text);
        if (parama.textColor == 0) {
          break label623;
        }
        ((TextView)localObject1).setTextColor(parama.textColor);
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setTextSize(11.0F);
      ((TextView)localObject1).setTag(parama);
      ((TextView)localObject1).setOnClickListener(this);
      this.cH.addView((View)localObject1);
      do
      {
        return;
        if (parama.id == bze)
        {
          if (this.aNj)
          {
            ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130842448));
            break;
          }
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130842447));
          break;
        }
        if (parama.id == bzf)
        {
          if (this.aNj)
          {
            ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130842450));
            break;
          }
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130842449));
          break;
        }
        if (parama.id == bzg)
        {
          if (this.aNj)
          {
            ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130842457));
            break;
          }
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130842456));
          break;
        }
        if (parama.id == bzh)
        {
          if (this.aNj)
          {
            ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130842454));
            break;
          }
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130842453));
          break;
        }
      } while (parama.id != bzi);
      if (this.aNj)
      {
        ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130842452));
        break;
      }
      ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130842451));
      break;
      label604:
      localLayoutParams.leftMargin = ((getMarginLeft() + aqnm.dip2px(24.0F)) * paramInt);
      break label121;
      label623:
      if (this.aNj) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#999999"));
      } else {
        ((TextView)localObject1).setTextColor(Color.parseColor("#919191"));
      }
    }
  }
  
  private void b(sun.b paramb)
  {
    if (paramb != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramb.backColor != 0)
      {
        this.jdField_a_of_type_Sun$b.backColor = paramb.backColor;
        this.cG.setBackgroundColor(paramb.backColor);
        localStringBuilder.append("color=" + Integer.toHexString(this.jdField_a_of_type_Sun$b.backColor));
      }
      if (paramb.callback != null)
      {
        this.jdField_a_of_type_Sun$b.callback = paramb.callback;
        localStringBuilder.append(";callback=" + this.jdField_a_of_type_Sun$b.callback);
      }
      int j;
      int i;
      if (paramb.pC != null)
      {
        if (paramb.pC.size() > bzj) {}
        for (this.jdField_a_of_type_Sun$b.pC = paramb.pC.subList(0, bzj);; this.jdField_a_of_type_Sun$b.pC = paramb.pC)
        {
          this.cH.removeAllViews();
          j = this.jdField_a_of_type_Sun$b.pC.size();
          i = 0;
          while (i < j)
          {
            a((sun.a)this.jdField_a_of_type_Sun$b.pC.get(i), i);
            localStringBuilder.append(";buttonInfo index=" + i + ";id=" + ((sun.a)this.jdField_a_of_type_Sun$b.pC.get(i)).id + ";icon=" + ((sun.a)this.jdField_a_of_type_Sun$b.pC.get(i)).iconUrl + ";text=" + ((sun.a)this.jdField_a_of_type_Sun$b.pC.get(i)).text + ";textColor=" + Integer.toHexString(((sun.a)this.jdField_a_of_type_Sun$b.pC.get(i)).textColor));
            i += 1;
          }
        }
      }
      if (paramb.pD != null)
      {
        this.jdField_a_of_type_Sun$b.pD = paramb.pD;
        j = this.jdField_a_of_type_Sun$b.pD.size();
        i = 0;
        while (i < j)
        {
          paramb = URLDrawable.getDrawable((String)this.jdField_a_of_type_Sun$b.pD.get(i), aqnm.dip2px(24.0F), aqnm.dip2px(24.0F), null, null, true);
          if ((paramb != null) && (paramb.getStatus() == 2)) {
            paramb.restartDownload();
          }
          localStringBuilder.append(";emoIcons index=" + i + ",url=" + (String)this.jdField_a_of_type_Sun$b.pD.get(i));
          i += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountUIPlugin", 2, "updatePAArticleBottomBar" + localStringBuilder.toString());
      }
    }
  }
  
  private void bBa()
  {
    this.jdField_a_of_type_Sun$b = new sun.b();
    this.jdField_a_of_type_Sun$b.pC = new ArrayList();
    if (this.aNj) {}
    for (this.jdField_a_of_type_Sun$b.backColor = -16777216;; this.jdField_a_of_type_Sun$b.backColor = -1)
    {
      sun.a locala = new sun.a();
      locala.id = 10000;
      this.jdField_a_of_type_Sun$b.pC.add(locala);
      return;
    }
  }
  
  private void bBb()
  {
    int i = 0;
    if (this.mRuntime.b() != null)
    {
      localObject = (ViewGroup)LayoutInflater.from(this.mRuntime.getActivity()).inflate(2131560156, null);
      if (this.mRuntime.b().jdField_a_of_type_Arcd.mRootView != null) {
        this.mRuntime.b().jdField_a_of_type_Arcd.mRootView.addView((View)localObject);
      }
    }
    for (;;)
    {
      this.cG = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131373751));
      if (this.cG != null) {
        break;
      }
      return;
      ((ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131372784)).inflate();
    }
    this.cG.setVisibility(0);
    Object localObject = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131365990);
    if (this.aNj) {
      ((ImageView)localObject).setBackgroundColor(Color.parseColor("#333333"));
    }
    for (;;)
    {
      this.cH = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131363642));
      this.cH.setOnClickListener(new suo(this));
      this.cH.setEnabled(false);
      if (this.jdField_a_of_type_Sun$b == null) {
        break;
      }
      this.cG.setBackgroundColor(this.jdField_a_of_type_Sun$b.backColor);
      if (this.jdField_a_of_type_Sun$b.pC == null) {
        break;
      }
      int j = this.jdField_a_of_type_Sun$b.pC.size();
      while (i < j)
      {
        a((sun.a)this.jdField_a_of_type_Sun$b.pC.get(i), i);
        i += 1;
      }
      break;
      ((ImageView)localObject).setBackgroundColor(Color.parseColor("#dedfe0"));
    }
  }
  
  private static String cn(int paramInt)
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("type", "click");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("btnId", paramInt);
      ((JSONObject)localObject2).put("data", localJSONObject);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PubAccountUIPlugin", 2, "getClickBottomBarCallBackResult json error!");
    }
    return localObject1;
    return null;
  }
  
  private int getMarginLeft()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDisplayMetrics().widthPixels;
    int j = this.jdField_a_of_type_Sun$b.pC.size();
    return (i - aqnm.dip2px(12.0F) * 2 - aqnm.dip2px(24.0F) * j) / (j - 1);
  }
  
  public static boolean gk(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.contains("mp.qq.com"));
  }
  
  private boolean gl(String paramString)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("mp.qq.com")))
      {
        Uri localUri2 = Uri.parse(paramString);
        Uri localUri1 = localUri2;
        if (paramString.contains("www.urlshare.cn/umirror_url_check")) {
          localUri1 = Uri.parse(localUri2.getQueryParameter("url"));
        }
        paramString = localUri1.getQueryParameter("_pflag");
        if (paramString != null) {
          try
          {
            long l = Long.parseLong(paramString, 10);
            if (((l & 0x7) == 1L) || ((l & 0x7) == 2L))
            {
              if ((l & 0x7) == 2L) {
                this.aNj = true;
              }
              return true;
            }
          }
          catch (NumberFormatException paramString)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("PubAccountUIPlugin", 4, "_pflag param not found");
            }
          }
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("PubAccountUIPlugin", 1, "isPflagRulesNeedShowBottomBar exception: " + paramString);
      }
    }
    return false;
  }
  
  public void a(sun.a parama)
  {
    if (!this.aNi) {
      break label7;
    }
    label7:
    while ((this.jdField_a_of_type_Sun$b == null) || (this.jdField_a_of_type_Sun$b.pC == null) || (parama == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountUIPlugin", 2, "updateButton buttonInfo id=" + parama.id + ",icon=" + parama.iconUrl + ",text=" + parama.text + ",textColor=" + Integer.toHexString(parama.textColor));
    }
    int k = this.jdField_a_of_type_Sun$b.pC.size();
    int i = 0;
    label122:
    int j;
    TextView localTextView;
    Object localObject2;
    label162:
    Object localObject1;
    if (i < k) {
      if (((sun.a)this.jdField_a_of_type_Sun$b.pC.get(i)).id == parama.id)
      {
        j = 0;
        localTextView = null;
        localObject2 = null;
        if (j < this.cH.getChildCount())
        {
          localObject1 = this.cH.getChildAt(j);
          if ((!(((View)localObject1).getTag() instanceof sun.a)) || (((sun.a)((View)localObject1).getTag()).id != parama.id)) {
            break label765;
          }
          if ((localObject1 instanceof TextView))
          {
            localTextView = (TextView)localObject1;
            localObject1 = localObject2;
          }
        }
      }
    }
    for (;;)
    {
      j += 1;
      localObject2 = localObject1;
      break label162;
      localObject1 = (URLImageView)localObject1;
      continue;
      if ((localObject2 == null) && (localTextView == null)) {
        break;
      }
      if ((parama.iconUrl != null) && (!TextUtils.isEmpty(parama.iconUrl)))
      {
        ((sun.a)this.jdField_a_of_type_Sun$b.pC.get(i)).iconUrl = parama.iconUrl;
        if (parama.id != bzf) {
          break label554;
        }
        if (!this.aNj) {
          break label536;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130842450);
        label334:
        localObject1 = URLDrawable.getDrawable(parama.iconUrl, aqnm.dip2px(24.0F), aqnm.dip2px(24.0F), (Drawable)localObject1, (Drawable)localObject1, true);
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 2)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1)) {
          QLog.d("PubAccountUIPlugin", 2, "updateButton download newImage Successed url = " + parama.iconUrl);
        }
        if (localObject2 != null) {
          a(localObject2, (URLDrawable)localObject1);
        }
      }
      localObject1 = localTextView;
      if (parama.text != null)
      {
        if (localTextView != null)
        {
          localTextView.setText(parama.text);
          label458:
          ((sun.a)this.jdField_a_of_type_Sun$b.pC.get(i)).text = parama.text;
          localObject1 = localTextView;
        }
      }
      else
      {
        if (parama.textColor == 0) {
          break label730;
        }
        if (localObject1 != null)
        {
          ((TextView)localObject1).setTextColor(parama.textColor);
          ((sun.a)this.jdField_a_of_type_Sun$b.pC.get(i)).textColor = parama.textColor;
        }
      }
      for (;;)
      {
        i += 1;
        break label122;
        break;
        label536:
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130842449);
        break label334;
        label554:
        if (parama.id == bzg)
        {
          if (this.aNj)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130842457);
            break label334;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130842456);
          break label334;
        }
        localObject1 = null;
        break label334;
        localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
        localObject1 = new RelativeLayout.LayoutParams(-2, -1);
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = (((RelativeLayout.LayoutParams)localObject2.getLayoutParams()).leftMargin + aqnm.dip2px(27.0F));
        localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(9);
        ((RelativeLayout.LayoutParams)localObject1).addRule(15);
        localTextView.setGravity(16);
        localTextView.setTextSize(11.0F);
        localTextView.setTag(parama);
        localTextView.setOnClickListener(this);
        localTextView.setText(parama.text);
        this.cH.addView(localTextView);
        break label458;
        label730:
        if (this.aNj) {
          ((TextView)localObject1).setTextColor(Color.parseColor("#999999"));
        } else {
          ((TextView)localObject1).setTextColor(Color.parseColor("#919191"));
        }
      }
      label765:
      localObject1 = localObject2;
    }
  }
  
  public void a(sun.b paramb)
  {
    if (!this.aNi) {
      return;
    }
    if (this.cG != null)
    {
      this.cG.setVisibility(0);
      b(paramb);
      return;
    }
    bBb();
  }
  
  public void ak(boolean paramBoolean, int paramInt)
  {
    if (!this.aNi) {}
    label7:
    int i;
    do
    {
      do
      {
        do
        {
          break label7;
          do
          {
            return;
          } while (this.cG == null);
          i = this.cG.getHeight();
          if (!paramBoolean) {
            break;
          }
          this.cG.setVisibility(0);
        } while (paramInt == 0);
        localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, i, 0.0F);
        localTranslateAnimation.setDuration(paramInt);
        localTranslateAnimation.setFillAfter(true);
        this.cG.startAnimation(localTranslateAnimation);
        return;
      } while (paramBoolean);
      this.cG.setVisibility(8);
    } while (paramInt == 0);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, i);
    localTranslateAnimation.setDuration(paramInt);
    localTranslateAnimation.setFillAfter(true);
    this.cG.startAnimation(localTranslateAnimation);
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((this.mRuntime != null) && ((this.mRuntime.getActivity() instanceof QQBrowserActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)this.mRuntime.getActivity());
    }
    if ((this.mRuntime == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null)) {
      return false;
    }
    this.b = this.mRuntime.b();
    if (this.b == null)
    {
      QLog.e("PubAccountUIPlugin", 1, "handleEvent webViewFragment is null");
      return false;
    }
    if (paramLong == 8589934593L)
    {
      if (!this.aNi) {
        return false;
      }
      if (!this.isInit)
      {
        bBa();
        a(this.jdField_a_of_type_Sun$b);
        this.isInit = true;
      }
    }
    for (;;)
    {
      return super.handleEvent(paramString, paramLong, paramMap);
      if (paramLong == 8589934611L)
      {
        a(this.jdField_a_of_type_Sun$b);
      }
      else if ((paramLong == 1L) && (Nm()) && (gl(paramString)))
      {
        this.aNi = true;
        this.b.jdField_a_of_type_Arcd.a.isFullScreen = true;
        this.b.jdField_a_of_type_Arcd.a.Dr = 0L;
        if (this.aNj) {
          this.b.jdField_a_of_type_Arcd.ees = -16777216;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((paramView.getTag() instanceof sun.a))
    {
      localObject = (sun.a)paramView.getTag();
      if (((sun.a)localObject).id != bze) {
        break label93;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.onBackPressed();
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Sun$b.callback))
      {
        localObject = cn(((sun.a)localObject).id);
        if (localObject != null) {
          this.b.getWebView().callJs(this.jdField_a_of_type_Sun$b.callback, new String[] { localObject });
        }
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label93:
      ArrayList localArrayList;
      arbt localarbt;
      if (((sun.a)localObject).id == bzh)
      {
        localArrayList = new ArrayList();
        localArrayList.add("menuItem:openWithQQBrowser");
        localArrayList.add("menuItem:openWithSafari");
        localArrayList.add("menuItem:favorite");
        localArrayList.add("menuItem:copyUrl");
        localArrayList.add("menuItem:exposeArticle");
        localArrayList.add("menuItem:screenShotShare");
        localArrayList.add("menuItem:setFont");
        localArrayList.add("menuItem:share:kandian");
        localArrayList.add("menuItem:share:diandian");
        localArrayList.add("menuItem:exportTencentDocs");
        localarbt = (arbt)this.b.jdField_a_of_type_Araz.q(4);
        if (localarbt != null)
        {
          localarbt.qo.addAll(localArrayList);
          this.b.Qq();
          localarbt.qo.clear();
        }
      }
      else if (((sun.a)localObject).id == bzi)
      {
        localArrayList = new ArrayList();
        localArrayList.add("menuItem:share:qq");
        localArrayList.add("menuItem:share:QZone");
        localArrayList.add("menuItem:share:appMessage");
        localArrayList.add("menuItem:share:timeline");
        localArrayList.add("menuItem:share:sinaWeibo");
        localArrayList.add("menuItem:share:qiDian");
        localArrayList.add("menuItem:share:qiYeQQ");
        localArrayList.add("menuItem:share:kandian");
        localarbt = (arbt)this.b.jdField_a_of_type_Araz.q(4);
        if (localarbt != null)
        {
          localarbt.qo.addAll(localArrayList);
          this.b.Qq();
          localarbt.qo.clear();
        }
      }
    }
  }
  
  public static class a
  {
    public String iconUrl;
    public int id;
    public String text;
    public int textColor;
  }
  
  public static class b
  {
    public int backColor;
    public String callback;
    public List<sun.a> pC;
    public List<String> pD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sun
 * JD-Core Version:    0.7.0.1
 */