import UserGrowth.stAnnexation;
import UserGrowth.stGlobalConfig;
import UserGrowth.stPopWindowsButton;
import UserGrowth.stPopWindowsConfig;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ucn
  extends aake
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 12;
  private long jdField_a_of_type_Long;
  private stGlobalConfig jdField_a_of_type_UserGrowthStGlobalConfig;
  public stPopWindowsConfig a;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private String jdField_a_of_type_JavaLangString = "weishi://main";
  private udh jdField_a_of_type_Udh;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 5;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView d;
  private TextView e;
  private TextView f;
  
  public ucn(Context paramContext, int paramInt)
  {
    this(paramContext, -1, -1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_b_of_type_JavaLangString = "feeds";
  }
  
  private ucn(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, 2131755940, paramInt1, paramInt2);
  }
  
  private ucn(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramInt1);
    b();
    paramContext = getWindow();
    if (paramContext == null)
    {
      uqf.b("RichBlockDialog", 2, "ScrollMoreDialog() window == null.");
      return;
    }
    paramContext = paramContext.getAttributes();
    if (paramContext == null)
    {
      uqf.b("RichBlockDialog", 2, "ScrollMoreDialog() params == null.");
      return;
    }
    paramContext.width = paramInt2;
    paramContext.height = paramInt3;
  }
  
  private int a()
  {
    switch (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type)
    {
    case 1: 
    default: 
      return 6;
    case 2: 
      return 401;
    }
    return 7;
  }
  
  private String a(int paramInt)
  {
    String str2 = String.format("%.3f", new Object[] { Double.valueOf(paramInt / 100.0D) });
    String str1 = str2;
    if (str2.indexOf(".") > 0) {
      str1 = str2.replaceAll("0+?$", "").replaceAll("[.]$", "");
    }
    return str1;
  }
  
  private void a(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 1500L)
    {
      uqf.a("RichBlockDialog", 1, "点击时间小于1.5秒，不做响应");
      return;
    }
    this.jdField_a_of_type_Long = l;
    Context localContext;
    if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null) && (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.jp_button != null))
    {
      a(112, "popup_clk");
      uno.a(112, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
      localContext = getContext();
      if (!(localContext instanceof ContextThemeWrapper)) {
        break label153;
      }
      localContext = ((ContextThemeWrapper)localContext).getBaseContext();
    }
    label153:
    for (;;)
    {
      String str1 = this.jdField_a_of_type_UserGrowthStPopWindowsConfig.schema_url;
      String str2 = this.jdField_a_of_type_UserGrowthStPopWindowsConfig.h5url;
      uqt.a(this.jdField_a_of_type_AndroidContentContext, str1, str2, "", this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, new uco(this, localContext));
      d();
      return;
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    if (a())
    {
      unx.c(paramInt, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
      return;
    }
    uoi.b(paramString, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
  }
  
  private boolean a()
  {
    return this.jdField_c_of_type_Int == 0;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131562695, null, false);
    setContentView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376031));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376035));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376032));
    this.d = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376034));
    this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376033));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376029));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376028));
    this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376036));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null) && (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type != 1))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.d.setVisibility(4);
      this.e.setVisibility(4);
      this.f.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      uqf.a("weishi-813", "展示图片");
      return;
    }
    uqf.a("weishi-813", "展示红包");
  }
  
  private void d()
  {
    if (isShowing()) {
      dismiss();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.title)) {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.title);
      }
      if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type != 1) {
        break label250;
      }
      if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation != null) && (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation.money > 0))
      {
        String str = a(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation.money);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(str);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig.jp_button != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.jp_button.title))) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.jp_button.title);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.text)) {
        this.d.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.text);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.remark)) {
        this.e.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.remark);
      }
      show();
      a(6, "popup_exp");
      uno.a(6, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
      WSPublicAccReport.getInstance().reportExposeRichBlockPop(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.trace_id, this.jdField_b_of_type_JavaLangString);
      a();
      return;
      label250:
      if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation.money + "");
      }
    }
  }
  
  public void a() {}
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    a();
    if (paramstGlobalConfig != null)
    {
      this.jdField_a_of_type_UserGrowthStGlobalConfig = paramstGlobalConfig;
      if ((paramstGlobalConfig.windows_config == null) || (paramstGlobalConfig.windows_config.size() <= 0)) {
        break label129;
      }
      paramstGlobalConfig = (stPopWindowsConfig)paramstGlobalConfig.windows_config.get(0);
      if (paramstGlobalConfig == null) {
        break label117;
      }
      if (paramstGlobalConfig.type != 1) {
        break label93;
      }
      this.jdField_a_of_type_UserGrowthStPopWindowsConfig = paramstGlobalConfig;
      uqf.a("weishi-813", "阻断页rich化 type是：" + paramstGlobalConfig.type);
    }
    for (;;)
    {
      c();
      return;
      label93:
      if (paramstGlobalConfig.type == 2)
      {
        this.jdField_a_of_type_UserGrowthStPopWindowsConfig = paramstGlobalConfig;
        break;
      }
      this.jdField_a_of_type_UserGrowthStPopWindowsConfig = paramstGlobalConfig;
      break;
      label117:
      uqf.a("weishi-813", "阻断页rich化 windowsConfig为null");
      continue;
      label129:
      uqf.c("weishi-813", "瀑布流阻断页rich化 windowsConfig size为0");
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {}
    while (this.jdField_a_of_type_UserGrowthStPopWindowsConfig == null) {
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.bg_img_url))
    {
      paramContext = getContext().getResources().getDrawable(2130841690);
      switch (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type)
      {
      default: 
        d();
        return;
      case 3: 
        this.jdField_a_of_type_Udh = new udh();
        this.jdField_a_of_type_Udh.a(this.jdField_a_of_type_ComTencentImageURLImageView, paramContext, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.bg_img_url, true, false);
        e();
        return;
      }
      a(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.bg_img_url, paramContext, paramContext, anzj.a(2131712327));
      return;
    }
    d();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, Drawable paramDrawable1, Drawable paramDrawable2, String paramString2)
  {
    uhc.a(3);
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mFailedDrawable = paramDrawable1;
    paramString2.mLoadingDrawable = paramDrawable2;
    paramString1 = URLDrawable.getDrawable(paramString1, paramString2);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramString1);
    this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new ucp(this));
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramString1);
    if (1 == paramString1.getStatus())
    {
      e();
      uhc.b(3);
      return;
    }
    paramString1.startDownload();
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void dismiss()
  {
    uqf.b("RichBlockDialog", 2, "dismiss()");
    try
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Udh != null)
      {
        this.jdField_a_of_type_Udh.a();
        this.jdField_a_of_type_Udh = null;
      }
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      uqf.d("RichBlockDialog", 2, localException.getLocalizedMessage());
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      case 2131376030: 
      default: 
        break;
      case 2131376028: 
        uqf.a("weishi-813", "点击了红包 提现");
        a(1);
        break;
      case 2131376029: 
        d();
        if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null)
        {
          a(117, "popup_close");
          uno.a(117, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
          WSPublicAccReport.getInstance().reportClickRichBlockPop(1000005, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.trace_id, this.jdField_b_of_type_JavaLangString);
        }
        break;
      case 2131376031: 
        uqf.a("weishi-813", "点击了图片 背景图");
        a(2);
      }
    }
  }
  
  public void show()
  {
    uqf.b("RichBlockDialog", 2, "show()");
    try
    {
      super.show();
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      uqf.d("RichBlockDialog", 2, localException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ucn
 * JD-Core Version:    0.7.0.1
 */