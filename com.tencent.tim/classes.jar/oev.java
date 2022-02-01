import UserGrowth.stAnnexation;
import UserGrowth.stGlobalConfig;
import UserGrowth.stPopWindowsButton;
import UserGrowth.stPopWindowsConfig;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.event.WSBlockDialogDismissEvent;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.image.URLImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class oev
  extends sdz
  implements View.OnClickListener
{
  private URLImageView L;
  private final String TAG = "RichBlockDialog";
  private stGlobalConfig jdField_a_of_type_UserGrowthStGlobalConfig;
  public stPopWindowsConfig a;
  private ofe jdField_a_of_type_Ofe;
  private boolean awJ;
  public final int beD = 1;
  public final int beE = 2;
  public final int beF = 3;
  private int beG = 12;
  private int beH = 5;
  private TextView em;
  private ImageView mCloseBtn;
  private Context mContext;
  private View mRootView;
  private String mScheme = "weishi://main";
  private TextView ua;
  private TextView ub;
  private TextView uc;
  private TextView ud;
  private TextView ue;
  private long yG;
  
  public oev(Context paramContext)
  {
    this(paramContext, -1, -1);
    this.mContext = paramContext;
  }
  
  private oev(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, 2131756599, paramInt1, paramInt2);
  }
  
  private oev(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, paramInt1);
    initView();
    paramContext = getWindow();
    if (paramContext == null)
    {
      ooz.d("RichBlockDialog", 2, "ScrollMoreDialog() window == null.");
      return;
    }
    paramContext = paramContext.getAttributes();
    if (paramContext == null)
    {
      ooz.d("RichBlockDialog", 2, "ScrollMoreDialog() params == null.");
      return;
    }
    paramContext.width = paramInt2;
    paramContext.height = paramInt3;
  }
  
  private String bJ(int paramInt)
  {
    String str2 = String.format("%.3f", new Object[] { Double.valueOf(paramInt / 100.0D) });
    String str1 = str2;
    if (str2.indexOf(".") > 0) {
      str1 = str2.replaceAll("0+?$", "").replaceAll("[.]$", "");
    }
    return str1;
  }
  
  private void bdT()
  {
    if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null) && (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type != 1))
    {
      this.em.setVisibility(4);
      this.ub.setVisibility(4);
      this.uc.setVisibility(4);
      this.ud.setVisibility(4);
      this.ue.setVisibility(4);
      this.ua.setVisibility(4);
      ooz.i("weishi-813", "展示图片");
      return;
    }
    ooz.i("weishi-813", "展示红包");
  }
  
  private void bdV()
  {
    if (isShowing()) {
      dismiss();
    }
  }
  
  private void bdW()
  {
    if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.title)) {
        this.em.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.title);
      }
      if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type != 1) {
        break label256;
      }
      if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation != null) && (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation.money > 0))
      {
        String str = bJ(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation.money);
        this.ub.setText(str);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig.jp_button != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.jp_button.title))) {
        this.ua.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.jp_button.title);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.text)) {
        this.uc.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.text);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.remark)) {
        this.ud.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.remark);
      }
      show();
      ong.Y(6, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
      ond.reportRichBlockDialog(6, this.beG, this.beH, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
      WSPublicAccReport.getInstance().reportExposeRichBlockPop(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.trace_id);
      bdU();
      return;
      label256:
      if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation != null) {
        this.ub.setText(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.annexation.money + "");
      }
    }
  }
  
  private void initView()
  {
    this.awJ = false;
    this.mRootView = LayoutInflater.from(getContext()).inflate(2131562814, null, false);
    setContentView(this.mRootView);
    this.L = ((URLImageView)this.mRootView.findViewById(2131376569));
    this.em = ((TextView)this.mRootView.findViewById(2131376573));
    this.ub = ((TextView)this.mRootView.findViewById(2131376570));
    this.uc = ((TextView)this.mRootView.findViewById(2131376572));
    this.ud = ((TextView)this.mRootView.findViewById(2131376571));
    this.mCloseBtn = ((ImageView)this.mRootView.findViewById(2131376567));
    this.ua = ((TextView)this.mRootView.findViewById(2131376566));
    this.ue = ((TextView)this.mRootView.findViewById(2131376574));
    this.mCloseBtn.setOnClickListener(this);
    this.ua.setOnClickListener(this);
    this.L.setOnClickListener(this);
  }
  
  private int rk()
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
  
  private void uA(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.yG < 1500L)
    {
      ooz.i("RichBlockDialog", 1, "点击时间小于1.5秒，不做响应");
      return;
    }
    this.yG = l;
    Context localContext;
    if ((this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null) && (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.jp_button != null))
    {
      ong.Y(112, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
      ond.reportRichBlockDialog(112, this.beG, this.beH, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
      localContext = getContext();
      if (!(localContext instanceof ContextThemeWrapper)) {
        break label165;
      }
      localContext = ((ContextThemeWrapper)localContext).getBaseContext();
    }
    label165:
    for (;;)
    {
      String str1 = this.jdField_a_of_type_UserGrowthStPopWindowsConfig.schema_url;
      String str2 = this.jdField_a_of_type_UserGrowthStPopWindowsConfig.h5url;
      opn.a(this.mContext, str1, str2, "", this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, new oew(this, localContext));
      bdV();
      return;
    }
  }
  
  public void a(stGlobalConfig paramstGlobalConfig)
  {
    bdU();
    if (paramstGlobalConfig != null)
    {
      this.jdField_a_of_type_UserGrowthStGlobalConfig = paramstGlobalConfig;
      if ((paramstGlobalConfig.windows_config == null) || (paramstGlobalConfig.windows_config.size() <= 0)) {
        break label127;
      }
      paramstGlobalConfig = (stPopWindowsConfig)paramstGlobalConfig.windows_config.get(0);
      if (paramstGlobalConfig == null) {
        break label116;
      }
      if (paramstGlobalConfig.type != 1) {
        break label92;
      }
      this.jdField_a_of_type_UserGrowthStPopWindowsConfig = paramstGlobalConfig;
      ooz.i("weishi-813", "阻断页rich化 type是：" + paramstGlobalConfig.type);
    }
    for (;;)
    {
      bdT();
      return;
      label92:
      if (paramstGlobalConfig.type == 2)
      {
        this.jdField_a_of_type_UserGrowthStPopWindowsConfig = paramstGlobalConfig;
        break;
      }
      this.jdField_a_of_type_UserGrowthStPopWindowsConfig = paramstGlobalConfig;
      break;
      label116:
      ooz.i("weishi-813", "阻断页rich化 windowsConfig为null");
      continue;
      label127:
      ooz.w("weishi-813", "瀑布流阻断页rich化 windowsConfig size为0");
    }
  }
  
  public void bdU() {}
  
  public void cp(Context paramContext)
  {
    if (paramContext == null) {}
    while (this.jdField_a_of_type_UserGrowthStPopWindowsConfig == null) {
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStPopWindowsConfig.bg_img_url))
    {
      paramContext = getContext().getResources().getDrawable(2130842541);
      switch (this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type)
      {
      case 2: 
      default: 
        bdV();
        return;
      }
      this.jdField_a_of_type_Ofe = new ofe();
      this.jdField_a_of_type_Ofe.a(this.L, paramContext, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.bg_img_url);
      bdW();
      return;
    }
    bdV();
  }
  
  public void dismiss()
  {
    ooz.d("RichBlockDialog", 2, "dismiss()");
    try
    {
      this.awJ = false;
      oiv.a().b(new WSBlockDialogDismissEvent());
      if (this.jdField_a_of_type_Ofe != null)
      {
        this.jdField_a_of_type_Ofe.destroy();
        this.jdField_a_of_type_Ofe = null;
      }
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      ooz.e("RichBlockDialog", 2, localException.getLocalizedMessage());
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
      case 2131376568: 
      default: 
        break;
      case 2131376566: 
        ooz.i("weishi-813", "点击了红包 提现");
        uA(1);
        break;
      case 2131376567: 
        bdV();
        if (this.jdField_a_of_type_UserGrowthStPopWindowsConfig != null)
        {
          ong.Y(117, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.type, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
          ond.reportRichBlockDialog(117, this.beG, this.beH, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid);
          WSPublicAccReport.getInstance().reportClickRichBlockPop(1000005, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.windowsid, this.jdField_a_of_type_UserGrowthStPopWindowsConfig.trace_id);
        }
        break;
      case 2131376569: 
        ooz.i("weishi-813", "点击了图片 背景图");
        uA(2);
      }
    }
  }
  
  public void setScheme(String paramString)
  {
    this.mScheme = paramString;
  }
  
  public void show()
  {
    ooz.d("RichBlockDialog", 2, "show()");
    try
    {
      super.show();
      this.awJ = true;
      return;
    }
    catch (Exception localException)
    {
      ooz.e("RichBlockDialog", 2, localException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oev
 * JD-Core Version:    0.7.0.1
 */