import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.richstatus.RichStatus;

public class amig
  extends amib
{
  public amig(Context paramContext, AppInterface paramAppInterface, View paramView, String paramString)
  {
    super(paramContext, paramAppInterface, paramView, paramString);
    this.type = 0;
  }
  
  public View a(RichStatus paramRichStatus)
  {
    paramRichStatus = super.a(paramRichStatus);
    dNF();
    return paramRichStatus;
  }
  
  protected CharSequence a(RichStatus paramRichStatus, amii.a parama, int paramInt)
  {
    if (paramRichStatus == null) {
      parama = "";
    }
    do
    {
      return parama;
      localObject1 = paramRichStatus.toSpannableStringWithoutAction(parama);
      parama = (amii.a)localObject1;
    } while (TextUtils.isEmpty(paramRichStatus.actionText));
    Object localObject2 = paramRichStatus.actionText;
    parama = (amii.a)localObject2;
    if (!TextUtils.isEmpty(paramRichStatus.dataText)) {
      parama = (String)localObject2 + paramRichStatus.dataText;
    }
    Drawable localDrawable = this.context.getResources().getDrawable(2130850442);
    localObject2 = new SpannableStringBuilder((CharSequence)localObject1);
    ((SpannableStringBuilder)localObject2).insert(0, "[S] ");
    Object localObject1 = this.context.getResources().getDrawable(2130850435);
    String str = amhd.a().eU(paramRichStatus.actionId);
    paramRichStatus = (RichStatus)localObject1;
    if (!TextUtils.isEmpty(str))
    {
      paramRichStatus = URLDrawable.URLDrawableOptions.obtain();
      paramRichStatus.mLoadingDrawable = ((Drawable)localObject1);
      paramRichStatus.mFailedDrawable = ((Drawable)localObject1);
      paramRichStatus.mRequestWidth = paramInt;
      paramRichStatus.mRequestHeight = paramInt;
      paramRichStatus = URLDrawable.getDrawable(str, paramRichStatus);
      paramRichStatus.setCallback(this.l);
    }
    paramRichStatus.setBounds(0, 0, paramInt, paramInt);
    int i = Color.parseColor("#ffa8a8a8");
    if ((Build.VERSION.SDK_INT >= 4) && (Build.VERSION.SDK_INT != 20)) {}
    for (paramRichStatus = new amfz(paramRichStatus, 1, parama, i, localDrawable, paramInt);; paramRichStatus = new amfz(paramRichStatus, 0, parama, i, localDrawable, paramInt))
    {
      ((SpannableStringBuilder)localObject2).setSpan(paramRichStatus, 0, "[S]".length(), 17);
      return localObject2;
    }
  }
  
  protected boolean avS()
  {
    return false;
  }
  
  protected boolean avU()
  {
    return false;
  }
  
  protected void dNx()
  {
    int i = mZ[6];
    this.kj.setPadding(i, i, i, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amig
 * JD-Core Version:    0.7.0.1
 */