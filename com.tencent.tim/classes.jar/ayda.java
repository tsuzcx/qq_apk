import android.app.Activity;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import org.json.JSONObject;

public class ayda
  extends ayfh
{
  public static final String TAG = ayda.class.getSimpleName();
  private static final String cWM = acfp.m(2131705269);
  private View Nd;
  private TextView ahR;
  private String cWN;
  private int dRR = -1;
  private String mFrom = "barindex";
  private RelativeLayout of;
  private TextView yk;
  
  public ayda(aygz paramaygz, long paramLong)
  {
    super(paramaygz, paramLong);
  }
  
  private void adx(String paramString)
  {
    int i = -1;
    paramString = new SpannableString(paramString);
    if (this.dRR == -1) {}
    for (;;)
    {
      paramString.setSpan(new rsz(getContext(), 2130843432), 0, 1, 33);
      this.ahR.setText(paramString);
      this.ahR.setTextColor(i);
      return;
      i = -18432;
    }
  }
  
  private void dXf()
  {
    if ((this.dRR != -1) && (!TextUtils.isEmpty(this.cWN))) {
      adx("#" + this.cWN);
    }
    for (;;)
    {
      this.ahR.setTextColor(-1);
      this.ahR.setTextSize(16.0F);
      this.ahR.setOnClickListener(new aydb(this));
      return;
      adx(cWM);
    }
  }
  
  private void ex(Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      int i = paramIntent.getIntExtra("theme_id", -1);
      paramIntent = paramIntent.getStringExtra("theme_name");
      this.dRR = i;
      if (i == -1)
      {
        adx(cWM);
        this.cWN = "";
      }
      while (QLog.isColorLevel())
      {
        QLog.d(TAG, 2, "handleSelectedTheme mThemeID = " + this.dRR + " mThemeName = " + this.cWN);
        return;
        if (paramIntent != null)
        {
          adx("#" + paramIntent);
          this.cWN = paramIntent;
        }
      }
    }
  }
  
  private void iF(String paramString)
  {
    if ("barindex".equals(this.mFrom)) {}
    for (int i = 1;; i = 2)
    {
      anot.a(null, "dc00899", "Grp_tribe", "", "video_edit", paramString, i, 0, "", "", "", "");
      return;
    }
  }
  
  public String Ip()
  {
    return this.cWN;
  }
  
  public int RO()
  {
    return this.dRR;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    }
    ex(paramIntent);
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.of = ((RelativeLayout)y(2131364118));
    this.Nd = ((ImageView)y(2131380030));
    this.yk = ((TextView)y(2131365426));
    this.Nd.setVisibility(8);
    this.yk.setText(acfp.m(2131705268));
    this.ahR = new TextView(getContext());
    this.ahR.setGravity(17);
    this.ahR.setMaxWidth(aqcx.dip2px(getContext(), 192.0F));
    this.ahR.setEllipsize(TextUtils.TruncateAt.END);
    this.ahR.setSingleLine(true);
    int i = aqcx.dip2px(getContext(), 10.0F);
    this.ahR.setPadding(i, 0, i, 0);
    this.ahR.setBackgroundResource(2130843433);
    Object localObject = new RelativeLayout.LayoutParams(-2, aqcx.dip2px(getContext(), 28.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(15);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = aqcx.dip2px(getContext(), 10.0F);
    this.of.addView(this.ahR, (ViewGroup.LayoutParams)localObject);
    localObject = aorf.d(((EditVideoParams)((Activity)getContext()).getIntent().getParcelableExtra(EditVideoParams.class.getName())).mExtra);
    if (localObject != null)
    {
      boolean bool = ((JSONObject)localObject).optBoolean("needTheme", false);
      this.mFrom = ((JSONObject)localObject).optString("from", "");
      this.dRR = ((JSONObject)localObject).optInt("theme_id", -1);
      this.cWN = ((JSONObject)localObject).optString("theme_name", "");
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onCreate mThemeID = " + this.dRR + " mThemeName = " + this.cWN);
      }
      dXf();
      if (!bool) {
        this.ahR.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayda
 * JD-Core Version:    0.7.0.1
 */