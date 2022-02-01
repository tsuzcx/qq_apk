import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ThemeImageView;

public class ysu
  extends ysa
  implements View.OnClickListener
{
  private boolean boD;
  
  public ysu(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv)
  {
    super(paramContext, paramQQAppInterface, paramytd, paramytv);
  }
  
  public void AJ(boolean paramBoolean)
  {
    this.boD = paramBoolean;
  }
  
  public View a(int paramInt, View paramView)
  {
    ysu.a locala;
    Object localObject;
    if ((paramView == null) || (!(paramView.getTag() instanceof ysu.a)))
    {
      locala = new ysu.a();
      paramView = LayoutInflater.from(this.mContext).inflate(2131561508, null);
      locala.hA = ((LinearLayout)paramView.findViewById(2131365345));
      locala.hB = ((LinearLayout)paramView.findViewById(2131365340));
      localObject = (ThemeImageView)paramView.findViewById(2131366425);
      ((ThemeImageView)localObject).setSupportMaskView(true);
      ((ThemeImageView)localObject).setMaskShape(auvj.euL);
      paramView.setTag(locala);
    }
    for (;;)
    {
      paramView.setOnClickListener(this);
      localObject = new Rect();
      ((Activity)this.mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      paramInt = ((Rect)localObject).height() - this.mContext.getResources().getDimensionPixelSize(2131299627) - aqnm.dip2px(80.0F);
      if (!this.boD) {
        break;
      }
      Y(paramView, paramInt);
      locala.hA.setVisibility(8);
      locala.hB.setVisibility(0);
      return paramView;
      locala = (ysu.a)paramView.getTag();
    }
    Y(paramView, paramInt);
    locala.hA.setVisibility(0);
    locala.hB.setVisibility(8);
    return paramView;
  }
  
  public void onClick(View paramView) {}
  
  public static class a
  {
    public LinearLayout hA;
    public LinearLayout hB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ysu
 * JD-Core Version:    0.7.0.1
 */