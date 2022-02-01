import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class rrt
  extends ReportDialog
  implements View.OnClickListener
{
  private rrt.a a;
  private String aBL = "";
  private String aBM = "";
  private String aBN = "";
  private String aBO;
  protected boolean aFr;
  protected Button cu;
  private String dP;
  private ImageView ij;
  private Context mContext;
  private String mUrl;
  private View pe;
  protected int source;
  protected String wsSchema;
  private TextView zd;
  
  public rrt(@NonNull Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, paramInt);
    this.mContext = paramContext;
    this.dP = paramString;
  }
  
  public rrt(@NonNull Context paramContext, String paramString)
  {
    this(paramContext, 2131756467, paramString);
    this.mContext = paramContext;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if (rpw.isWeishiInstalled(paramContext))
    {
      rpw.p(paramContext, "biz_src_jc_hyws", paramString4);
      return null;
    }
    paramContext = new rrt(paramContext, "biz_src_jc_hyws").a(paramString1, paramString2, paramString3).a(paramInt, paramString4);
    paramContext.show();
    return paramContext;
  }
  
  private void initView()
  {
    this.cu = ((Button)findViewById(2131363846));
    this.ij = ((ImageView)findViewById(2131369705));
    this.pe = findViewById(2131370636);
    this.zd = ((TextView)findViewById(2131380789));
    this.cu.setOnClickListener(this);
    this.ij.setOnClickListener(this);
    this.cu.setText(acfp.m(2131716929));
    bwa();
    if (TextUtils.isEmpty(this.mUrl)) {
      this.mUrl = "https://pub.idqqimg.com/pc/misc/files/20180423/03d546703c3f49a3857c67be2e94f928.png";
    }
    this.zd.setVisibility(0);
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(-16777216);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
    localObject = URLDrawable.getDrawable(this.mUrl, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setURLDrawableListener(new rrt.b(this.zd));
    this.pe.setBackgroundDrawable((Drawable)localObject);
    int i = ((URLDrawable)localObject).getStatus();
    if (i != 1)
    {
      if (i == 2) {
        ((URLDrawable)localObject).restartDownload();
      }
      return;
    }
    this.zd.setVisibility(8);
  }
  
  private void xS(int paramInt)
  {
    if (this.a != null) {
      this.a.a(this, paramInt);
    }
  }
  
  public rrt a(int paramInt, String paramString)
  {
    this.source = paramInt;
    this.wsSchema = paramString;
    return this;
  }
  
  public rrt a(String paramString)
  {
    this.mUrl = paramString;
    return this;
  }
  
  public rrt a(String paramString1, String paramString2, String paramString3)
  {
    this.aBL = paramString1;
    this.aBM = paramString2;
    this.aBN = paramString3;
    return this;
  }
  
  public void bwa()
  {
    boolean bool = rpw.isWeishiInstalled(getContext());
    if (this.aFr != bool)
    {
      this.aFr = bool;
      if (this.aFr) {
        this.cu.setText(acfp.m(2131716930));
      }
    }
    else
    {
      return;
    }
    this.cu.setText(acfp.m(2131716933));
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    xS(-1);
  }
  
  public void onClick(View paramView)
  {
    int m = 1;
    int i;
    label117:
    int k;
    label182:
    int j;
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    case 2131363846: 
      bwa();
      if (TextUtils.isEmpty(this.aBO))
      {
        if (this.aFr) {
          rpw.p(getContext(), this.dP, this.wsSchema);
        }
        for (i = 0;; i = 1)
        {
          rar.a("weishi_share", "cover_clk", 0, 0, new String[] { this.aBM, this.aBL, "weishi", this.aBN });
          dismiss();
          xS(i);
          break;
          QQToast.a(getContext(), acfp.m(2131716931), 0).show();
          rpw.aU(getContext(), this.dP);
        }
      }
      if (this.aFr)
      {
        oem.aT(getContext(), this.aBO);
        i = 0;
        if (!(this.mContext instanceof Activity)) {
          break label514;
        }
        k = ((Activity)this.mContext).getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
        j = ((Activity)this.mContext).getIntent().getIntExtra("VIDEO_FROM_TYPE", -1);
        if ((j != 9) && (j != 12)) {
          break label387;
        }
        j = 1;
      }
      break;
    }
    for (;;)
    {
      label243:
      JSONObject localJSONObject = new JSONObject();
      for (;;)
      {
        try
        {
          if (!this.aFr) {
            continue;
          }
          str = "0";
          localJSONObject.put("download", str);
          if (j == 0) {
            continue;
          }
          j = m;
          kct.a(localJSONObject, j);
        }
        catch (JSONException localJSONException)
        {
          String str;
          label387:
          localJSONException.printStackTrace();
          continue;
          kbp.a(null, null, "0X80092A9", "0X80092A9", 0, 0, String.valueOf(k), "", "", kct.a(null, null, "", "", localJSONObject), false);
        }
        if (!"video_type_videopublic".equals(this.aBO)) {
          continue;
        }
        kbp.a(null, null, "0X80092A7", "0X80092A7", 0, 0, String.valueOf(k), "", "", kct.a(null, null, "", "", localJSONObject), false);
        break;
        QQToast.a(getContext(), -1, acfp.m(2131716932), 0).show(getContext().getResources().getDimensionPixelSize(2131299627));
        oem.aU(getContext(), this.aBO);
        i = 1;
        break label182;
        j = 0;
        break label243;
        str = "1";
        continue;
        j = 0;
      }
      break label117;
      dismiss();
      xS(-1);
      if (!TextUtils.isEmpty(this.aBO)) {
        break;
      }
      rar.a("weishi_share", "cover_close", 0, 0, new String[] { this.aBM, this.aBL, "weishi", this.aBN });
      break;
      label514:
      j = 0;
      k = 0;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131562045);
    initView();
    setCanceledOnTouchOutside(false);
  }
  
  public void show()
  {
    super.show();
    if (TextUtils.isEmpty(this.aBO)) {
      rar.a("weishi_share", "cover_exp", 0, 0, new String[] { this.aBM, this.aBL, "weishi", this.aBN });
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(DialogInterface paramDialogInterface, int paramInt);
  }
  
  public static class b
    implements URLDrawable.URLDrawableListener
  {
    private final WeakReference<TextView> weakReference;
    
    public b(TextView paramTextView)
    {
      this.weakReference = new WeakReference(paramTextView);
    }
    
    public void onLoadCanceled(URLDrawable paramURLDrawable) {}
    
    public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
    
    public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
    
    public void onLoadSuccessed(URLDrawable paramURLDrawable)
    {
      paramURLDrawable = (TextView)this.weakReference.get();
      if (paramURLDrawable != null) {
        paramURLDrawable.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rrt
 * JD-Core Version:    0.7.0.1
 */