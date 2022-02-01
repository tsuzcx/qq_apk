import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.leba.widget.LebaRoundLayout;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.TextHook;
import com.tencent.widget.ThemeImageView;

public class aina
{
  public ImageView AL;
  public TextView Uh;
  public TextView Ui;
  public aers a;
  public LebaRoundLayout a;
  private RelativeLayout aN;
  private int ddM = 18;
  private TextView fe;
  private ThemeImageView i;
  public RedTouch redTouch;
  public View rootView;
  
  public aina(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561405, null);
    this.jdField_a_of_type_ComTencentMobileqqLebaWidgetLebaRoundLayout = ((LebaRoundLayout)paramLayoutInflater.findViewById(2131377582));
    this.aN = ((RelativeLayout)paramLayoutInflater.findViewById(2131370334));
    this.i = ((ThemeImageView)paramLayoutInflater.findViewById(2131369780));
    this.i.setMaskShape(auvj.euM);
    this.fe = ((TextView)paramLayoutInflater.findViewById(2131380814));
    this.AL = ((ImageView)paramLayoutInflater.findViewById(2131369960));
    this.Uh = ((TextView)paramLayoutInflater.findViewById(2131380886));
    this.Ui = ((TextView)paramLayoutInflater.findViewById(2131380887));
    this.redTouch = new RedTouch(paramContext, paramLayoutInflater).a(17).b(16).e(28).a();
    this.redTouch.XW = this.Uh;
    this.redTouch.XX = this.Ui;
    this.redTouch.Dd = this.AL;
    this.rootView = this.redTouch;
  }
  
  private boolean a(Context paramContext, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Aers == null) {
      this.jdField_a_of_type_Aers = aert.c();
    }
    if (!this.jdField_a_of_type_Aers.aht()) {}
    for (;;)
    {
      return false;
      String str = this.jdField_a_of_type_Aers.kk(String.valueOf(paramInt));
      if (str != null) {
        try
        {
          paramInt = paramContext.getResources().getIdentifier(str, "drawable", "com.tencent.mobileqq");
          if (SkinEngine.getInstances().checkResExist(paramInt))
          {
            paramView.setBackground(paramContext.getResources().getDrawable(paramInt));
            return true;
          }
        }
        catch (Exception paramContext) {}
      }
    }
    return false;
  }
  
  private void l(TextView paramTextView, String paramString)
  {
    try
    {
      QLog.i("LebaTableViewHolder", 1, paramString + " thread:" + Thread.currentThread().getId() + " v:" + paramTextView.getVisibility() + " w:" + paramTextView.getWidth() + " h:" + paramTextView.getHeight() + " x:" + paramTextView.getX() + " y:" + paramTextView.getY() + " colors:" + paramTextView.getTextColors() + " text:" + paramTextView.getText());
      return;
    }
    catch (Exception paramTextView)
    {
      QLog.i("LebaTableViewHolder", 1, "", paramTextView);
    }
  }
  
  public void a(@NonNull aina.a parama)
  {
    aevs localaevs = parama.d;
    Context localContext = parama.context;
    Object localObject = parama.dm;
    int k = parama.ddY;
    QQAppInterface localQQAppInterface = parama.app;
    aimo localaimo = parama.b;
    boolean bool1 = parama.isNight;
    boolean bool2 = parama.ckF;
    int j = parama.index;
    if (bool1) {
      this.aN.setBackgroundResource(2130841227);
    }
    while ((localaevs == null) || (localaevs.a == null))
    {
      this.rootView.setOnClickListener(null);
      this.rootView.setEnabled(false);
      this.i.setVisibility(8);
      this.fe.setVisibility(8);
      if (AppSetting.enableTalkBack) {
        aqcl.changeAccessibilityForView(this.redTouch, "", Button.class.getName());
      }
      this.redTouch.dGB();
      this.Uh.setVisibility(8);
      this.Ui.setVisibility(8);
      this.AL.setVisibility(8);
      return;
      this.aN.setBackgroundResource(2130839642);
    }
    this.redTouch.setOnClickListener(parama.onClickListener);
    this.rootView.setEnabled(true);
    this.i.setVisibility(0);
    if (!TextUtils.isEmpty(localaevs.a.strGridIconUrl))
    {
      parama = URLDrawable.URLDrawableOptions.obtain();
      parama.mRequestWidth = wja.dp2px(32.0F, localContext.getResources());
      parama.mRequestHeight = parama.mRequestWidth;
      parama.mLoadingDrawable = ((Drawable)localObject);
      parama.mFailedDrawable = ((Drawable)localObject);
      parama = URLDrawable.getDrawable(localaevs.a.strGridIconUrl, parama);
      parama.setTargetDensity(k);
      if (parama.getStatus() == 2) {
        parama.restartDownload();
      }
      if (a(localContext, this.i, (int)localaevs.a.uiResId))
      {
        parama.setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        localObject = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
        k = ((RelativeLayout.LayoutParams)localObject).width;
        int m = ((RelativeLayout.LayoutParams)localObject).height;
        int n = ankt.dip2px(this.ddM);
        this.i.setPadding((k - n) / 2, (m - n) / 2, (k - n) / 2, (m - n) / 2);
        label392:
        this.i.setImageDrawable(parama);
        this.i.invalidate();
        label407:
        this.fe.setVisibility(0);
        if (!TextUtils.isEmpty(localaevs.a.strResName)) {
          break label678;
        }
      }
    }
    label678:
    for (parama = "";; parama = localaevs.a.strResName)
    {
      this.fe.setText(parama);
      TextHook.updateFont(this.rootView);
      if (TextUtils.isEmpty(localaevs.a.strResName)) {
        l(this.fe, " tvName.setText:" + parama + " index:" + j);
      }
      if (AppSetting.enableTalkBack) {
        aqcl.changeAccessibilityForView(this.redTouch, parama, Button.class.getName());
      }
      if (localaimo == null) {
        break;
      }
      this.redTouch.bYg = localaevs.a.resConf;
      this.redTouch.czn = bool2;
      parama = new zjo.b();
      parama.app = localQQAppInterface;
      parama.context = localContext;
      parama.redTouch = this.redTouch;
      parama.Lg = localaevs.WP;
      parama.bal = localaevs.a.strPkgName;
      parama.index = j;
      localaimo.a(parama);
      this.redTouch.dJA();
      return;
      parama.setColorFilter(-1, PorterDuff.Mode.DST_IN);
      this.i.setImageDrawable(parama);
      this.i.setBackground(null);
      this.i.setPadding(0, 0, 0, 0);
      break label392;
      this.i.setPadding(0, 0, 0, 0);
      this.i.setImageDrawable((Drawable)localObject);
      break label407;
    }
  }
  
  public static class a
  {
    public QQAppInterface app;
    public aimo b;
    public boolean ckF;
    public Context context;
    public aevs d;
    public int ddY;
    public Drawable dm;
    public int index;
    public boolean isNight;
    public View.OnClickListener onClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aina
 * JD-Core Version:    0.7.0.1
 */