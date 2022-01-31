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

public class xls
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
  private xma jdField_a_of_type_Xma;
  public boolean a;
  public ViewGroup b;
  public boolean b;
  boolean c;
  
  static
  {
    jdField_b_of_type_Int = 10000;
    jdField_c_of_type_Int = 10001;
  }
  
  public xls()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 40;
    this.mPluginNameSpace = "pubAccountUI";
  }
  
  private int a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDisplayMetrics().widthPixels;
    int j = this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList.size();
    return (i - bbll.a(12.0F) * 2 - bbll.a(24.0F) * j) / (j - 1);
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
    this.jdField_a_of_type_Xma = new xma();
    this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (this.jdField_b_of_type_Boolean) {}
    for (this.jdField_a_of_type_Xma.jdField_a_of_type_Int = -16777216;; this.jdField_a_of_type_Xma.jdField_a_of_type_Int = -1)
    {
      xlz localxlz = new xlz();
      localxlz.jdField_a_of_type_Int = 10000;
      this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList.add(localxlz);
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
    localScaleAnimation1.setAnimationListener(new xlu(this, paramURLImageView, paramURLDrawable, localScaleAnimation2));
    localScaleAnimation2.setAnimationListener(new xlv(this, paramURLImageView, localScaleAnimation3));
    localScaleAnimation3.setAnimationListener(new xlw(this, paramURLImageView, localScaleAnimation4));
    localScaleAnimation4.setAnimationListener(new xlx(this, paramURLImageView, localScaleAnimation5));
    localScaleAnimation5.setAnimationListener(new xly(this, paramURLImageView, localScaleAnimation6));
  }
  
  private void a(xlz paramxlz, int paramInt)
  {
    Object localObject1 = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(bbll.a(24.0F), bbll.a(24.0F));
    if ((paramxlz.jdField_a_of_type_JavaLangString != null) || (!TextUtils.isEmpty(paramxlz.jdField_a_of_type_JavaLangString)))
    {
      Object localObject2 = new ColorDrawable(Color.parseColor("#dddfe2"));
      localObject2 = URLDrawable.getDrawable(paramxlz.jdField_a_of_type_JavaLangString, bbll.a(24.0F), bbll.a(24.0F), (Drawable)localObject2, (Drawable)localObject2, true);
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
      ((URLImageView)localObject1).setTag(paramxlz);
      ((URLImageView)localObject1).setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1);
      if ((paramxlz.jdField_b_of_type_JavaLangString != null) && (paramInt != this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList.size() - 1))
      {
        localObject1 = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
        localObject2 = new RelativeLayout.LayoutParams(-2, -1);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = (localLayoutParams.leftMargin + bbll.a(27.0F));
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(9);
        ((RelativeLayout.LayoutParams)localObject2).addRule(15);
        ((TextView)localObject1).setGravity(16);
        ((TextView)localObject1).setText(paramxlz.jdField_b_of_type_JavaLangString);
        if (paramxlz.jdField_b_of_type_Int == 0) {
          break label623;
        }
        ((TextView)localObject1).setTextColor(paramxlz.jdField_b_of_type_Int);
      }
    }
    for (;;)
    {
      ((TextView)localObject1).setTextSize(11.0F);
      ((TextView)localObject1).setTag(paramxlz);
      ((TextView)localObject1).setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject1);
      do
      {
        return;
        if (paramxlz.jdField_a_of_type_Int == jdField_b_of_type_Int)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841163));
            break;
          }
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841162));
          break;
        }
        if (paramxlz.jdField_a_of_type_Int == jdField_c_of_type_Int)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841165));
            break;
          }
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841164));
          break;
        }
        if (paramxlz.jdField_a_of_type_Int == d)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841172));
            break;
          }
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841171));
          break;
        }
        if (paramxlz.jdField_a_of_type_Int == e)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841169));
            break;
          }
          ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841168));
          break;
        }
      } while (paramxlz.jdField_a_of_type_Int != f);
      if (this.jdField_b_of_type_Boolean)
      {
        ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841167));
        break;
      }
      ((URLImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841166));
      break;
      label604:
      localLayoutParams.leftMargin = ((a() + bbll.a(24.0F)) * paramInt);
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
      localObject = (ViewGroup)LayoutInflater.from(this.mRuntime.a()).inflate(2131559755, null);
      if (this.mRuntime.a().jdField_a_of_type_Bcfx.d != null) {
        this.mRuntime.a().jdField_a_of_type_Bcfx.d.addView((View)localObject);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131372076));
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        break;
      }
      return;
      ((ViewStub)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131371183)).inflate();
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    Object localObject = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131365268);
    if (this.jdField_b_of_type_Boolean) {
      ((ImageView)localObject).setBackgroundColor(Color.parseColor("#333333"));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.findViewById(2131363352));
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(new xlt(this));
      this.jdField_b_of_type_AndroidViewViewGroup.setEnabled(false);
      if (this.jdField_a_of_type_Xma == null) {
        break;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(this.jdField_a_of_type_Xma.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList == null) {
        break;
      }
      int j = this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList.size();
      while (i < j)
      {
        a((xlz)this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList.get(i), i);
        i += 1;
      }
      break;
      ((ImageView)localObject).setBackgroundColor(Color.parseColor("#dedfe0"));
    }
  }
  
  private void b(xma paramxma)
  {
    if (paramxma != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramxma.jdField_a_of_type_Int != 0)
      {
        this.jdField_a_of_type_Xma.jdField_a_of_type_Int = paramxma.jdField_a_of_type_Int;
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(paramxma.jdField_a_of_type_Int);
        localStringBuilder.append("color=" + Integer.toHexString(this.jdField_a_of_type_Xma.jdField_a_of_type_Int));
      }
      if (paramxma.jdField_a_of_type_JavaLangString != null)
      {
        this.jdField_a_of_type_Xma.jdField_a_of_type_JavaLangString = paramxma.jdField_a_of_type_JavaLangString;
        localStringBuilder.append(";callback=" + this.jdField_a_of_type_Xma.jdField_a_of_type_JavaLangString);
      }
      int j;
      int i;
      if (paramxma.jdField_a_of_type_JavaUtilList != null)
      {
        if (paramxma.jdField_a_of_type_JavaUtilList.size() > g) {}
        for (this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList = paramxma.jdField_a_of_type_JavaUtilList.subList(0, g);; this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList = paramxma.jdField_a_of_type_JavaUtilList)
        {
          this.jdField_b_of_type_AndroidViewViewGroup.removeAllViews();
          j = this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList.size();
          i = 0;
          while (i < j)
          {
            a((xlz)this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList.get(i), i);
            localStringBuilder.append(";buttonInfo index=" + i + ";id=" + ((xlz)this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int + ";icon=" + ((xlz)this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString + ";text=" + ((xlz)this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString + ";textColor=" + Integer.toHexString(((xlz)this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_Int));
            i += 1;
          }
        }
      }
      if (paramxma.b != null)
      {
        this.jdField_a_of_type_Xma.b = paramxma.b;
        j = this.jdField_a_of_type_Xma.b.size();
        i = 0;
        while (i < j)
        {
          paramxma = URLDrawable.getDrawable((String)this.jdField_a_of_type_Xma.b.get(i), bbll.a(24.0F), bbll.a(24.0F), null, null, true);
          if ((paramxma != null) && (paramxma.getStatus() == 2)) {
            paramxma.restartDownload();
          }
          localStringBuilder.append(";emoIcons index=" + i + ",url=" + (String)this.jdField_a_of_type_Xma.b.get(i));
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
  
  public void a(xlz paramxlz)
  {
    if (!this.jdField_a_of_type_Boolean) {
      break label7;
    }
    label7:
    while ((this.jdField_a_of_type_Xma == null) || (this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList == null) || (paramxlz == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountUIPlugin", 2, "updateButton buttonInfo id=" + paramxlz.jdField_a_of_type_Int + ",icon=" + paramxlz.jdField_a_of_type_JavaLangString + ",text=" + paramxlz.jdField_b_of_type_JavaLangString + ",textColor=" + Integer.toHexString(paramxlz.jdField_b_of_type_Int));
    }
    int k = this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    label122:
    int j;
    TextView localTextView;
    Object localObject2;
    label162:
    Object localObject1;
    if (i < k) {
      if (((xlz)this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Int == paramxlz.jdField_a_of_type_Int)
      {
        j = 0;
        localTextView = null;
        localObject2 = null;
        if (j < this.jdField_b_of_type_AndroidViewViewGroup.getChildCount())
        {
          localObject1 = this.jdField_b_of_type_AndroidViewViewGroup.getChildAt(j);
          if ((!(((View)localObject1).getTag() instanceof xlz)) || (((xlz)((View)localObject1).getTag()).jdField_a_of_type_Int != paramxlz.jdField_a_of_type_Int)) {
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
      if ((paramxlz.jdField_a_of_type_JavaLangString != null) && (!TextUtils.isEmpty(paramxlz.jdField_a_of_type_JavaLangString)))
      {
        ((xlz)this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_JavaLangString = paramxlz.jdField_a_of_type_JavaLangString;
        if (paramxlz.jdField_a_of_type_Int != jdField_c_of_type_Int) {
          break label554;
        }
        if (!this.jdField_b_of_type_Boolean) {
          break label536;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841165);
        label334:
        localObject1 = URLDrawable.getDrawable(paramxlz.jdField_a_of_type_JavaLangString, bbll.a(24.0F), bbll.a(24.0F), (Drawable)localObject1, (Drawable)localObject1, true);
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 2)) {
          ((URLDrawable)localObject1).restartDownload();
        }
        if ((localObject1 != null) && (((URLDrawable)localObject1).getStatus() == 1)) {
          QLog.d("PubAccountUIPlugin", 2, "updateButton download newImage Successed url = " + paramxlz.jdField_a_of_type_JavaLangString);
        }
        if (localObject2 != null) {
          a(localObject2, (URLDrawable)localObject1);
        }
      }
      localObject1 = localTextView;
      if (paramxlz.jdField_b_of_type_JavaLangString != null)
      {
        if (localTextView != null)
        {
          localTextView.setText(paramxlz.jdField_b_of_type_JavaLangString);
          label458:
          ((xlz)this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString = paramxlz.jdField_b_of_type_JavaLangString;
          localObject1 = localTextView;
        }
      }
      else
      {
        if (paramxlz.jdField_b_of_type_Int == 0) {
          break label730;
        }
        if (localObject1 != null)
        {
          ((TextView)localObject1).setTextColor(paramxlz.jdField_b_of_type_Int);
          ((xlz)this.jdField_a_of_type_Xma.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_Int = paramxlz.jdField_b_of_type_Int;
        }
      }
      for (;;)
      {
        i += 1;
        break label122;
        break;
        label536:
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841164);
        break label334;
        label554:
        if (paramxlz.jdField_a_of_type_Int == d)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841172);
            break label334;
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getDrawable(2130841171);
          break label334;
        }
        localObject1 = null;
        break label334;
        localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity);
        localObject1 = new RelativeLayout.LayoutParams(-2, -1);
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = (((RelativeLayout.LayoutParams)localObject2.getLayoutParams()).leftMargin + bbll.a(27.0F));
        localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(9);
        ((RelativeLayout.LayoutParams)localObject1).addRule(15);
        localTextView.setGravity(16);
        localTextView.setTextSize(11.0F);
        localTextView.setTag(paramxlz);
        localTextView.setOnClickListener(this);
        localTextView.setText(paramxlz.jdField_b_of_type_JavaLangString);
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
  
  public void a(xma paramxma)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      b(paramxma);
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
        a(this.jdField_a_of_type_Xma);
        this.jdField_c_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      return super.handleEvent(paramString, paramLong, paramMap);
      if (paramLong == 8589934611L)
      {
        a(this.jdField_a_of_type_Xma);
      }
      else if ((paramLong == 1L) && (a()) && (b(paramString)))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bcfx.a.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bcfx.a.c = 0L;
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bcfx.jdField_b_of_type_Int = -16777216;
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof xlz))
    {
      paramView = (xlz)paramView.getTag();
      if (paramView.jdField_a_of_type_Int != jdField_b_of_type_Int) {
        break label86;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.onBackPressed();
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Xma.jdField_a_of_type_JavaLangString))
      {
        paramView = a(paramView.jdField_a_of_type_Int);
        if (paramView != null) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView().callJs(this.jdField_a_of_type_Xma.jdField_a_of_type_JavaLangString, new String[] { paramView });
        }
      }
      return;
      label86:
      ArrayList localArrayList;
      bcfh localbcfh;
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
        localbcfh = (bcfh)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bcee.a(4);
        if (localbcfh != null)
        {
          localbcfh.a.addAll(localArrayList);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.c();
          localbcfh.a.clear();
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
        localbcfh = (bcfh)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Bcee.a(4);
        if (localbcfh != null)
        {
          localbcfh.a.addAll(localArrayList);
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.c();
          localbcfh.a.clear();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xls
 * JD-Core Version:    0.7.0.1
 */