import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;

public class ajuy
  extends PopupWindow
{
  private ImageView Bo;
  private TextView Vf;
  private long adm;
  private ajuy.a b;
  private View.OnClickListener fu = new ajuz(this);
  private String mTagName;
  private int mWidth;
  private float sG;
  
  public ajuy(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.sG = paramContext.getResources().getDisplayMetrics().density;
    this.mWidth = paramInt2;
    setWidth(this.mWidth);
    setHeight((int)(this.sG * 42.0F + 0.5D));
    View localView = LayoutInflater.from(paramContext).inflate(2131559778, null);
    setContentView(localView);
    a(paramContext, localView, paramInt1);
    setOutsideTouchable(true);
  }
  
  private void a(Context paramContext, View paramView, int paramInt)
  {
    this.Vf = ((TextView)paramView.findViewById(2131381134));
    this.Vf.getTextSize();
    this.Bo = ((ImageView)paramView.findViewById(2131363841));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.findViewById(2131369090).getLayoutParams();
    int i = (int)(10.0F * this.sG + 0.5D);
    if (paramInt <= 0) {
      localLayoutParams.leftMargin = 0;
    }
    for (;;)
    {
      paramView.setOnClickListener(this.fu);
      setBackgroundDrawable(paramContext.getResources().getDrawable(2130851770));
      return;
      if (paramInt < (this.mWidth - i) / 2)
      {
        localLayoutParams.leftMargin = ((int)((this.sG * 40.0F - i) / 2.0F) + paramInt);
      }
      else if (paramInt > paramContext.getResources().getDisplayMetrics().widthPixels - (int)(this.sG * 40.0F + 0.5D) - (this.mWidth - i) / 2)
      {
        int j = this.mWidth;
        localLayoutParams.leftMargin = ((int)((this.sG * 40.0F - i) / 2.0F) + (j + paramInt) - paramContext.getResources().getDisplayMetrics().widthPixels);
      }
      else
      {
        localLayoutParams.leftMargin = ((int)((this.mWidth - i) / 2 + 0.5D));
      }
    }
  }
  
  public void a(ajuy.a parama)
  {
    this.b = parama;
  }
  
  public void f(InterestTagInfo paramInterestTagInfo)
  {
    if (paramInterestTagInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramInterestTagInfo.tagName))
    {
      this.mTagName = paramInterestTagInfo.tagName;
      this.Vf.setText(this.mTagName);
    }
    this.adm = paramInterestTagInfo.tagId;
  }
  
  public static abstract interface a
  {
    public abstract void km(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajuy
 * JD-Core Version:    0.7.0.1
 */