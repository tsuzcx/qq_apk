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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class zal
  extends WebViewPlugin
  implements View.OnClickListener
{
  public static int b;
  public static int c;
  public static int d = 10002;
  public static int e = 10003;
  public static int f = 10004;
  public static int g = 5;
  public int a;
  public ViewGroup a;
  private QQBrowserActivity jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity;
  private WebViewFragment jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment;
  private zat jdField_a_of_type_Zat;
  public boolean a;
  public ViewGroup b;
  public boolean b;
  boolean c;
  
  static
  {
    jdField_b_of_type_Int = 10000;
    jdField_c_of_type_Int = 10001;
  }
  
  public zal()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 40;
    this.mPluginNameSpace = "pubAccountUI";
  }
  
  private int a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDisplayMetrics().widthPixels;
    int j = this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList.size();
    return (i - bdkf.a(12.0F) * 2 - bdkf.a(24.0F) * j) / (j - 1);
  }
  
  private static String a(int paramInt)
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
  
  private void a()
  {
    this.jdField_a_of_type_Zat = new zat();
    this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (this.jdField_b_of_type_Boolean) {}
    for (this.jdField_a_of_type_Zat.jdField_a_of_type_Int = -16777216;; this.jdField_a_of_type_Zat.jdField_a_of_type_Int = -1)
    {
      zas localzas = new zas();
      localzas.jdField_a_of_type_Int = 10000;
      this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList.add(localzas);
      return;
    }
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
    localScaleAnimation1.setAnimationListener(new zan(this, paramURLImageView, paramURLDrawable, localScaleAnimation2));
    localScaleAnimation2.setAnimationListener(new zao(this, paramURLImageView, localScaleAnimation3));
    localScaleAnimation3.setAnimationListener(new zap(this, paramURLImageView, localScaleAnimation4));
    localScaleAnimation4.setAnimationListener(new zaq(this, paramURLImageView, localScaleAnimation5));
    localScaleAnimation5.setAnimationListener(new zar(this, paramURLImageView, localScaleAnimation6));
  }
  
  private void a(zas paramzas, int paramInt)
  {
    Object localObject1 = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(bdkf.a(24.0F), bdkf.a(24.0F));
    if ((paramzas.jdField_a_of_type_JavaLangString != null) || (!TextUtils.isEmpty(paramzas.jdField_a_of_type_JavaLangString)))
    {
      Object localObject2 = new ColorDrawable(Color.parseColor("#dddfe2"));
      localObject2 = URLDrawable.getDrawable(paramzas.jdField_a_of_type_JavaLangString, bdkf.a(24.0F), bdkf.a(24.0F), (Drawable)localObject2, (Drawable)localObject2, true);
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
      ((URLImageView)localObject1).setTag(paramzas);
      ((URLImageView)localObject1).setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1);
      if ((paramzas.jdField_b_of_type_JavaLangString != null) && (paramInt != this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList.size() - 1))
      {
        localObject1 = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
        localObject2 = new RelativeLayout.LayoutParams(-2, -1);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = (localLayoutParams.leftMargin + bdkf.a(27.0F));
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(9);
        ((RelativeLayout.LayoutParams)localObject2).addRule(15);
        ((TextView)localObject1).setGravity(16);
        ((TextView)localObject1).setText(paramzas.jdField_b_of_type_JavaLangString);
        if (paramzas.jdField_b_of_type_Int == 0) {
          break label623;
        }
        ((TextView)localObject1).setTextColor(paramzas.jdField_b_of_type_Int);
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setTextSize(11.0F);
      ((TextView)localObject1).setTag(paramzas);
      ((TextView)localObject1).setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1);
      do
      {
        return;
        if (paramzas.jdField_a_of_type_Int == jdField_b_of_type_Int)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841283));
            break;
          }
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841282));
          break;
        }
        if (paramzas.jdField_a_of_type_Int == jdField_c_of_type_Int)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841285));
            break;
          }
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841284));
          break;
        }
        if (paramzas.jdField_a_of_type_Int == d)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841292));
            break;
          }
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841291));
          break;
        }
        if (paramzas.jdField_a_of_type_Int == e)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841289));
            break;
          }
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841288));
          break;
        }
      } while (paramzas.jdField_a_of_type_Int != f);
      if (this.jdField_b_of_type_Boolean)
      {
        ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841287));
        break;
      }
      ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841286));
      break;
      label604:
      localLayoutParams.leftMargin = ((a() + bdkf.a(24.0F)) * paramInt);
      break label121;
      label623:
      if (this.jdField_b_of_type_Boolean) {
        ((TextView)localObject1).setTextColor(Color.parseColor("#999999"));
      } else {
        ((TextView)localObject1).setTextColor(Color.parseColor("#919191"));
      }
    }
  }
  
  private boolean a()
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
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.contains("mp.qq.com"));
  }
  
  private void b()
  {
    int i = 0;
    if (this.mRuntime.a() != null)
    {
      localObject = (ViewGroup)LayoutInflater.from(this.mRuntime.a()).inflate(2131559816, null);
      if (this.mRuntime.a().jdField_a_of_type_Beey.d != null) {
        this.mRuntime.a().jdField_a_of_type_Beey.d.addView((View)localObject);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131372394));
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        break;
      }
      return;
      ((ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131371495)).inflate();
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    Object localObject = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131365353);
    if (this.jdField_b_of_type_Boolean) {
      ((ImageView)localObject).setBackgroundColor(Color.parseColor("#333333"));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131363390));
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(new zam(this));
      this.jdField_b_of_type_AndroidViewViewGroup.setEnabled(false);
      if (this.jdField_a_of_type_Zat == null) {
        break;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(this.jdField_a_of_type_Zat.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList == null) {
        break;
      }
      int j = this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList.size();
      while (i < j)
      {
        a((zas)this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList.get(i), i);
        i += 1;
      }
      break;
      ((ImageView)localObject).setBackgroundColor(Color.parseColor("#dedfe0"));
    }
  }
  
  private void b(zat paramzat)
  {
    if (paramzat != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramzat.jdField_a_of_type_Int != 0)
      {
        this.jdField_a_of_type_Zat.jdField_a_of_type_Int = paramzat.jdField_a_of_type_Int;
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(paramzat.jdField_a_of_type_Int);
        localStringBuilder.append("color=" + Integer.toHexString(this.jdField_a_of_type_Zat.jdField_a_of_type_Int));
      }
      if (paramzat.jdField_a_of_type_JavaLangString != null)
      {
        this.jdField_a_of_type_Zat.jdField_a_of_type_JavaLangString = paramzat.jdField_a_of_type_JavaLangString;
        localStringBuilder.append(";callback=" + this.jdField_a_of_type_Zat.jdField_a_of_type_JavaLangString);
      }
      int j;
      int i;
      if (paramzat.jdField_a_of_type_JavaUtilList != null)
      {
        if (paramzat.jdField_a_of_type_JavaUtilList.size() > g) {}
        for (this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList = paramzat.jdField_a_of_type_JavaUtilList.subList(0, g);; this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList = paramzat.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_b_of_type_AndroidViewViewGroup.removeAllViews();
          j = this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList.size();
          i = 0;
          while (i < j)
          {
            a((zas)this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList.get(i), i);
            localStringBuilder.append(";buttonInfo index=" + i + ";id=" + ((zas)this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int + ";icon=" + ((zas)this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString + ";text=" + ((zas)this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString + ";textColor=" + Integer.toHexString(((zas)this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_Int));
            i += 1;
          }
        }
      }
      if (paramzat.b != null)
      {
        this.jdField_a_of_type_Zat.b = paramzat.b;
        j = this.jdField_a_of_type_Zat.b.size();
        i = 0;
        while (i < j)
        {
          paramzat = URLDrawable.getDrawable((String)this.jdField_a_of_type_Zat.b.get(i), bdkf.a(24.0F), bdkf.a(24.0F), null, null, true);
          if ((paramzat != null) && (paramzat.getStatus() == 2)) {
            paramzat.restartDownload();
          }
          localStringBuilder.append(";emoIcons index=" + i + ",url=" + (String)this.jdField_a_of_type_Zat.b.get(i));
          i += 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountUIPlugin", 2, "updatePAArticleBottomBar" + localStringBuilder.toString());
      }
    }
  }
  
  private boolean b(String paramString)
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
                this.jdField_b_of_type_Boolean = true;
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
  
  public void a(zas paramzas)
  {
    if (!this.jdField_a_of_type_Boolean) {
      break label7;
    }
    label7:
    while ((this.jdField_a_of_type_Zat == null) || (this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList == null) || (paramzas == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountUIPlugin", 2, "updateButton buttonInfo id=" + paramzas.jdField_a_of_type_Int + ",icon=" + paramzas.jdField_a_of_type_JavaLangString + ",text=" + paramzas.jdField_b_of_type_JavaLangString + ",textColor=" + Integer.toHexString(paramzas.jdField_b_of_type_Int));
    }
    int k = this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    label122:
    int j;
    TextView localTextView;
    Object localObject2;
    label162:
    Object localObject1;
    if (i < k) {
      if (((zas)this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == paramzas.jdField_a_of_type_Int)
      {
        j = 0;
        localTextView = null;
        localObject2 = null;
        if (j < this.jdField_b_of_type_AndroidViewViewGroup.getChildCount())
        {
          localObject1 = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(j);
          if ((!(((View)localObject1).getTag() instanceof zas)) || (((zas)((View)localObject1).getTag()).jdField_a_of_type_Int != paramzas.jdField_a_of_type_Int)) {
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
      if ((paramzas.jdField_a_of_type_JavaLangString != null) && (!TextUtils.isEmpty(paramzas.jdField_a_of_type_JavaLangString)))
      {
        ((zas)this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString = paramzas.jdField_a_of_type_JavaLangString;
        if (paramzas.jdField_a_of_type_Int != jdField_c_of_type_Int) {
          break label554;
        }
        if (!this.jdField_b_of_type_Boolean) {
          break label536;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841285);
        label334:
        localObject1 = URLDrawable.getDrawable(paramzas.jdField_a_of_type_JavaLangString, bdkf.a(24.0F), bdkf.a(24.0F), (Drawable)localObject1, (Drawable)localObject1, true);
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 2)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1)) {
          QLog.d("PubAccountUIPlugin", 2, "updateButton download newImage Successed url = " + paramzas.jdField_a_of_type_JavaLangString);
        }
        if (localObject2 != null) {
          a(localObject2, (URLDrawable)localObject1);
        }
      }
      localObject1 = localTextView;
      if (paramzas.jdField_b_of_type_JavaLangString != null)
      {
        if (localTextView != null)
        {
          localTextView.setText(paramzas.jdField_b_of_type_JavaLangString);
          label458:
          ((zas)this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString = paramzas.jdField_b_of_type_JavaLangString;
          localObject1 = localTextView;
        }
      }
      else
      {
        if (paramzas.jdField_b_of_type_Int == 0) {
          break label730;
        }
        if (localObject1 != null)
        {
          ((TextView)localObject1).setTextColor(paramzas.jdField_b_of_type_Int);
          ((zas)this.jdField_a_of_type_Zat.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_Int = paramzas.jdField_b_of_type_Int;
        }
      }
      for (;;)
      {
        i += 1;
        break label122;
        break;
        label536:
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841284);
        break label334;
        label554:
        if (paramzas.jdField_a_of_type_Int == d)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841292);
            break label334;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841291);
          break label334;
        }
        localObject1 = null;
        break label334;
        localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
        localObject1 = new RelativeLayout.LayoutParams(-2, -1);
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = (((RelativeLayout.LayoutParams)localObject2.getLayoutParams()).leftMargin + bdkf.a(27.0F));
        localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(9);
        ((RelativeLayout.LayoutParams)localObject1).addRule(15);
        localTextView.setGravity(16);
        localTextView.setTextSize(11.0F);
        localTextView.setTag(paramzas);
        localTextView.setOnClickListener(this);
        localTextView.setText(paramzas.jdField_b_of_type_JavaLangString);
        this.jdField_b_of_type_AndroidViewViewGroup.addView(localTextView);
        break label458;
        label730:
        if (this.jdField_b_of_type_Boolean) {
          ((TextView)localObject1).setTextColor(Color.parseColor("#999999"));
        } else {
          ((TextView)localObject1).setTextColor(Color.parseColor("#919191"));
        }
      }
      label765:
      localObject1 = localObject2;
    }
  }
  
  public void a(zat paramzat)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      b(paramzat);
      return;
    }
    b();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {}
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
          } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
          i = this.jdField_a_of_type_AndroidViewViewGroup.getHeight();
          if (!paramBoolean) {
            break;
          }
          this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        } while (paramInt == 0);
        localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, i, 0.0F);
        localTranslateAnimation.setDuration(paramInt);
        localTranslateAnimation.setFillAfter(true);
        this.jdField_a_of_type_AndroidViewViewGroup.startAnimation(localTranslateAnimation);
        return;
      } while (paramBoolean);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    } while (paramInt == 0);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, i);
    localTranslateAnimation.setDuration(paramInt);
    localTranslateAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewViewGroup.startAnimation(localTranslateAnimation);
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof QQBrowserActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity = ((QQBrowserActivity)this.mRuntime.a());
    }
    if ((this.mRuntime == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity == null)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = this.mRuntime.a();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null)
    {
      QLog.e("PubAccountUIPlugin", 1, "handleEvent webViewFragment is null");
      return false;
    }
    if (paramLong == 8589934593L)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return false;
      }
      if (!this.jdField_c_of_type_Boolean)
      {
        a();
        a(this.jdField_a_of_type_Zat);
        this.jdField_c_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      return super.handleEvent(paramString, paramLong, paramMap);
      if (paramLong == 8589934611L)
      {
        a(this.jdField_a_of_type_Zat);
      }
      else if ((paramLong == 1L) && (a()) && (b(paramString)))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Beey.a.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Beey.a.c = 0L;
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Beey.jdField_b_of_type_Int = -16777216;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof zas))
    {
      paramView = (zas)paramView.getTag();
      if (paramView.jdField_a_of_type_Int != jdField_b_of_type_Int) {
        break label86;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.onBackPressed();
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Zat.jdField_a_of_type_JavaLangString))
      {
        paramView = a(paramView.jdField_a_of_type_Int);
        if (paramView != null) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView().callJs(this.jdField_a_of_type_Zat.jdField_a_of_type_JavaLangString, new String[] { paramView });
        }
      }
      return;
      label86:
      ArrayList localArrayList;
      beei localbeei;
      if (paramView.jdField_a_of_type_Int == e)
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
        localbeei = (beei)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bedf.a(4);
        if (localbeei != null)
        {
          localbeei.a.addAll(localArrayList);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.c();
          localbeei.a.clear();
        }
      }
      else if (paramView.jdField_a_of_type_Int == f)
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
        localbeei = (beei)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bedf.a(4);
        if (localbeei != null)
        {
          localbeei.a.addAll(localArrayList);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.c();
          localbeei.a.clear();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zal
 * JD-Core Version:    0.7.0.1
 */