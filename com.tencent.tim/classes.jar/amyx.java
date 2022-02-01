import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageView;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class amyx
  extends amuu
{
  private amyx.a a;
  private View mRootView;
  
  public amyx(amuk paramamuk, Context paramContext)
  {
    super(paramamuk, paramContext);
  }
  
  private void initData()
  {
    String str = getData();
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RichTemplateOneSearchResultView", 2, "data->" + str);
      }
      this.a.resetData();
      this.a.pZ(str);
      this.a.bindData();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("RichTemplateOneSearchResultView", 2, "empty data");
  }
  
  private void initView(Context paramContext)
  {
    this.mRootView = LayoutInflater.from(paramContext).inflate(2131560015, null, false);
    this.a.u(this.mRootView);
  }
  
  public View n(Context paramContext)
  {
    this.a = new amyx.a(paramContext);
    initView(paramContext);
    initData();
    return this.mRootView;
  }
  
  public void update()
  {
    initData();
  }
  
  static class a
    implements View.OnClickListener
  {
    private TextView BM;
    private ImageView DA;
    private ImageView DB;
    private View Hi;
    private View Hj;
    private TextView Zo;
    private TextView Zp;
    private int aLx;
    private String ccw;
    private String ccx;
    private String ccy;
    private int dEc;
    private int dEd;
    private final String[] gs = new String[3];
    private final String[] gt = new String[3];
    private int mAppId;
    private Context mContext;
    private String mDetail;
    private String mIconUrl;
    private String mKeyword;
    private String mTitleName;
    private final TextView[] s = new TextView[3];
    private final View[] y = new View[3];
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    private void Qd(String paramString)
    {
      Intent localIntent = new Intent(this.mContext, QQBrowserDelegationActivity.class);
      localIntent.putExtra("param_force_internal_browser", true);
      localIntent.putExtra("url", paramString);
      wgv.c(this.mContext, localIntent, paramString);
    }
    
    private void e(String paramString, ImageView paramImageView)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.e("RichTemplateOneSearchResultView", 2, "setImageUrl " + paramString);
        }
        paramImageView.setImageDrawable(URLDrawable.getDrawable(new URL(paramString), 0, 0, new ColorDrawable(-1315339), new ColorDrawable(-1315339), true));
        return;
      }
      catch (MalformedURLException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RichTemplateOneSearchResultView", 2, "setImageUrl error " + paramString.toString());
        }
        paramImageView.setImageDrawable(new ColorDrawable(-1315339));
      }
    }
    
    void bindData()
    {
      label36:
      label58:
      String str;
      label91:
      label116:
      int i;
      if (this.mTitleName != null)
      {
        this.BM.setText(this.mTitleName);
        if (this.mDetail == null) {
          break label257;
        }
        this.Zo.setText(this.mDetail);
        if (TextUtils.isEmpty(this.mIconUrl)) {
          break label269;
        }
        e(this.mIconUrl, this.DA);
        if (TextUtils.isEmpty(this.ccw)) {
          break label288;
        }
        this.Hi.setOnClickListener(this);
        View localView = this.Hi;
        if (this.ccx != null) {
          break label280;
        }
        str = "";
        localView.setContentDescription(str);
        this.Hi.setVisibility(0);
        e(this.ccw, this.DB);
        if (TextUtils.isEmpty(this.ccx)) {
          break label308;
        }
        this.Zp.setVisibility(0);
        this.Zp.setText(this.ccx);
        label145:
        i = 0;
        label147:
        if (i >= 3) {
          break label359;
        }
        if (TextUtils.isEmpty(this.gs[i])) {
          break label320;
        }
        this.s[i].setVisibility(0);
        this.s[i].setText(this.gs[i]);
        this.s[i].setOnClickListener(this);
        this.y[i].setVisibility(0);
        label209:
        if (this.dEc != 1) {
          break label345;
        }
        this.y[i].setBackgroundColor(this.mContext.getResources().getColor(2131167233));
      }
      for (;;)
      {
        i += 1;
        break label147;
        this.BM.setText("");
        break;
        label257:
        this.Zo.setText("");
        break label36;
        label269:
        this.DA.setImageDrawable(null);
        break label58;
        label280:
        str = this.ccx;
        break label91;
        label288:
        this.Hi.setVisibility(8);
        this.DB.setImageDrawable(null);
        break label116;
        label308:
        this.Zp.setVisibility(8);
        break label145;
        label320:
        this.s[i].setVisibility(8);
        this.y[i].setVisibility(8);
        break label209;
        label345:
        this.y[i].setBackgroundColor(-1315339);
      }
      label359:
      this.Hj.setOnClickListener(new amza(this));
    }
    
    public void onClick(View paramView)
    {
      String str;
      int i;
      switch (paramView.getId())
      {
      default: 
        str = null;
        i = 0;
        if (this.dEd == 1)
        {
          amub.a(null, this.aLx, 0, "0X8009D2D", this.mAppId, i, this.mKeyword);
          label80:
          if (str != null)
          {
            if (QLog.isColorLevel()) {
              QLog.e("RichTemplateOneSearchResultView", 2, "onClick " + str);
            }
            if (!str.startsWith("http")) {
              break label207;
            }
            Qd(str);
          }
        }
        break;
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        str = this.ccy;
        i = 4;
        break;
        str = this.gt[0];
        i = 1;
        break;
        str = this.gt[1];
        i = 2;
        break;
        str = this.gt[2];
        i = 3;
        break;
        amub.a(null, this.aLx, 0, "0X8009D41", this.mAppId, i, this.mKeyword);
        break label80;
        label207:
        aqhv localaqhv = aqik.c((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.mContext, str);
        if (localaqhv != null)
        {
          localaqhv.ace();
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.e("RichTemplateOneSearchResultView", 2, "wrong url " + str);
          }
          Qd(str);
        }
      }
    }
    
    void pZ(String paramString)
    {
      for (;;)
      {
        JSONObject localJSONObject1;
        int i;
        try
        {
          localJSONObject1 = new JSONObject(paramString).optJSONObject("data");
          if (localJSONObject1 != null)
          {
            paramString = localJSONObject1.get("serverdata");
            if (paramString != null) {
              if ((paramString instanceof String))
              {
                paramString = new JSONObject((String)paramString);
                this.mAppId = paramString.optInt("appid");
                this.mIconUrl = paramString.optString("thumbnail");
                this.mTitleName = paramString.optString("title");
                this.mDetail = paramString.optString("sub_title");
                this.ccw = paramString.optString("bg_pic_url");
                this.ccx = paramString.optString("bg_main_btn_text");
                this.ccy = paramString.optString("bg_main_btn_url");
                paramString = paramString.optJSONArray("bottom_btn_list");
                if (paramString != null)
                {
                  int j = paramString.length();
                  i = 0;
                  if (i < j)
                  {
                    JSONObject localJSONObject2 = paramString.optJSONObject(i);
                    if ((localJSONObject2 == null) || (i >= 3)) {
                      break label324;
                    }
                    this.gs[i] = localJSONObject2.optString("bottom_btn_text");
                    this.gt[i] = localJSONObject2.optString("bottom_btn_url");
                    break label324;
                  }
                }
              }
              else
              {
                if ((paramString instanceof JSONObject))
                {
                  paramString = (JSONObject)paramString;
                  continue;
                }
                paramString = new JSONObject();
                continue;
              }
            }
          }
          else
          {
            return;
          }
        }
        catch (JSONException paramString)
        {
          if (QLog.isColorLevel()) {
            QLog.e("RichTemplateOneSearchResultView", 2, "initData error " + paramString.toString());
          }
        }
        do
        {
          paramString = localJSONObject1.getJSONObject("extradata");
        } while (paramString == null);
        this.aLx = paramString.getInt("entry");
        this.dEd = paramString.getInt("match");
        this.mKeyword = paramString.getString("keyword");
        this.dEc = paramString.optInt("nightmode", 0);
        return;
        label324:
        i += 1;
      }
    }
    
    void resetData()
    {
      int i = 0;
      this.mAppId = 0;
      this.mIconUrl = null;
      this.mTitleName = null;
      this.mDetail = null;
      this.ccw = null;
      this.ccx = null;
      this.ccy = null;
      this.dEc = 0;
      this.aLx = 0;
      this.dEd = 0;
      this.mKeyword = null;
      while (i < 3)
      {
        this.gs[i] = null;
        this.gt[i] = null;
        i += 1;
      }
    }
    
    void u(View paramView)
    {
      if (paramView != null)
      {
        this.DA = ((ImageView)paramView.findViewById(2131368702));
        this.DB = ((ImageView)paramView.findViewById(2131363396));
        this.BM = ((TextView)paramView.findViewById(2131372194));
        this.Zo = ((TextView)paramView.findViewById(2131365757));
        this.Zp = ((TextView)paramView.findViewById(2131371083));
        this.s[0] = ((TextView)paramView.findViewById(2131364085));
        this.s[1] = ((TextView)paramView.findViewById(2131364086));
        this.s[2] = ((TextView)paramView.findViewById(2131364087));
        this.Hi = paramView.findViewById(2131363398);
        this.y[0] = paramView.findViewById(2131363585);
        this.y[1] = paramView.findViewById(2131363587);
        this.y[2] = paramView.findViewById(2131363586);
        this.Hj = paramView.findViewById(2131364088);
        if ((this.DA instanceof ThemeImageView)) {
          ((ThemeImageView)this.DA).setMaskShape(auvj.euM);
        }
        if ((this.DB instanceof ThemeImageView)) {
          ((ThemeImageView)this.DB).setMaskShape(auvj.euM);
        }
        this.DB.getViewTreeObserver().addOnGlobalLayoutListener(new amyy(this));
        paramView.setOnClickListener(new amyz(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amyx
 * JD-Core Version:    0.7.0.1
 */