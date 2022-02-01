import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public final class avom
  extends ReportDialog
{
  private long azP;
  private final boolean gH;
  private final View.OnClickListener s;
  private final View.OnClickListener t;
  
  private avom(avom.a parama)
  {
    super(avom.a.a(parama), 2131755547);
    Object localObject3 = new LinearLayout(avom.a.a(parama));
    ((LinearLayout)localObject3).setOrientation(1);
    ((LinearLayout)localObject3).setBackgroundColor(-1);
    ((LinearLayout)localObject3).setBackgroundDrawable(avoh.h(-1, aqcx.dip2px(avom.a.a(parama), 4.0F)));
    int i = aqcx.dip2px(avom.a.a(parama), 25.0F);
    ((LinearLayout)localObject3).setPadding(i, i, i, i);
    Object localObject4 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject4).gravity = 17;
    ((LinearLayout.LayoutParams)localObject4).setMargins(aqcx.dip2px(avom.a.a(parama), 30.0F), 0, aqcx.dip2px(avom.a.a(parama), 30.0F), 0);
    TextView localTextView = new TextView(avom.a.a(parama));
    Object localObject1 = new LinearLayout.LayoutParams(-2, -2);
    localTextView.setTextColor(-16777216);
    localTextView.setTextSize(2, 16.0F);
    localTextView.setTypeface(Typeface.DEFAULT_BOLD);
    ((LinearLayout)localObject3).addView(localTextView, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new TextView(avom.a.a(parama));
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).setMargins(aqcx.dip2px(avom.a.a(parama), 16.5F), 0, 0, aqcx.dip2px(avom.a.a(parama), 18.5F));
    ((TextView)localObject1).setTextColor(-16777216);
    ((LinearLayout)localObject3).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    Object localObject5 = new LinearLayout(avom.a.a(parama));
    ((LinearLayout)localObject5).setOrientation(0);
    ((LinearLayout)localObject5).setGravity(17);
    Object localObject6 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject6).setMargins(aqcx.dip2px(avom.a.a(parama), -5.0F), 0, aqcx.dip2px(avom.a.a(parama), -5.0F), 0);
    localObject2 = new Button(avom.a.a(parama));
    ((Button)localObject2).setBackgroundDrawable(avoh.h(-13544, aqcx.dip2px(avom.a.a(parama), 3.0F)));
    i = aqcx.dip2px(avom.a.a(parama), 9.0F);
    ((Button)localObject2).setPadding(0, i, 0, i);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
    localLayoutParams.setMargins(aqcx.dip2px(avom.a.a(parama), 5.0F), 0, aqcx.dip2px(avom.a.a(parama), 5.0F), 0);
    ((Button)localObject2).setGravity(17);
    ((Button)localObject2).setTextColor(-16777216);
    ((Button)localObject2).setTextSize(2, 14.0F);
    ((Button)localObject2).setTypeface(Typeface.DEFAULT_BOLD);
    ((LinearLayout)localObject5).addView((View)localObject2, localLayoutParams);
    Button localButton = new Button(avom.a.a(parama));
    localButton.setBackgroundDrawable(avoh.h(-1121584, aqcx.dip2px(avom.a.a(parama), 3.0F)));
    localButton.setPadding(0, i, 0, i);
    localButton.setGravity(17);
    localButton.setTextColor(-16777216);
    localButton.setTextSize(2, 14.0F);
    localButton.setTypeface(Typeface.DEFAULT_BOLD);
    ((LinearLayout)localObject5).addView(localButton, localLayoutParams);
    ((LinearLayout)localObject3).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
    addContentView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
    this.gH = avom.a.a(parama);
    localObject3 = avom.a.a(parama);
    localObject4 = avom.a.b(parama);
    localObject5 = avom.a.c(parama);
    localObject6 = avom.a.d(parama);
    this.s = avom.a.a(parama);
    this.t = avom.a.b(parama);
    boolean bool1 = avom.a.b(parama);
    boolean bool2 = avom.a.c(parama);
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localTextView.setVisibility(0);
      localTextView.setText((CharSequence)localObject3);
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        break label721;
      }
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText((CharSequence)localObject4);
      label631:
      if (TextUtils.isEmpty((CharSequence)localObject5)) {
        break label731;
      }
      ((Button)localObject2).setVisibility(0);
      ((Button)localObject2).setText((CharSequence)localObject5);
      ((Button)localObject2).setOnClickListener(new avon(this));
      label665:
      if (TextUtils.isEmpty((CharSequence)localObject6)) {
        break label741;
      }
      localButton.setVisibility(0);
      localButton.setText((CharSequence)localObject6);
      localButton.setOnClickListener(new avoo(this));
    }
    for (;;)
    {
      setCancelable(bool1);
      setCanceledOnTouchOutside(bool2);
      return;
      localTextView.setVisibility(8);
      break;
      label721:
      ((TextView)localObject1).setVisibility(8);
      break label631;
      label731:
      ((Button)localObject2).setVisibility(8);
      break label665;
      label741:
      localButton.setVisibility(8);
    }
  }
  
  private boolean aKV()
  {
    long l = System.currentTimeMillis();
    if (l - this.azP < 500L) {
      return false;
    }
    this.azP = l;
    return true;
  }
  
  public static class a
  {
    private String content;
    private final Context context;
    private boolean gJ = true;
    private boolean gK = true;
    private boolean gL = true;
    private String kn;
    private String kp;
    private String title;
    private View.OnClickListener u;
    private View.OnClickListener w;
    
    public a(Context paramContext)
    {
      this.context = paramContext;
    }
    
    public a a(String paramString)
    {
      this.content = paramString;
      return this;
    }
    
    public a a(String paramString, View.OnClickListener paramOnClickListener)
    {
      this.kp = paramString;
      this.w = paramOnClickListener;
      return this;
    }
    
    public avom a()
    {
      return new avom(this, null);
    }
    
    public a b(String paramString, View.OnClickListener paramOnClickListener)
    {
      this.kn = paramString;
      this.u = paramOnClickListener;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avom
 * JD-Core Version:    0.7.0.1
 */