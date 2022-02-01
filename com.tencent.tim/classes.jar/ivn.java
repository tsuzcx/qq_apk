import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.smallscreen.BaseSmallScreenService;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout;
import com.tencent.av.smallscreen.SmallScreenRelativeLayout.a;
import com.tencent.av.smallscreen.SmallScreenService;

public class ivn
  extends ivq
{
  protected int aub;
  protected int auc;
  protected int aud;
  protected int aue;
  protected int auf;
  protected int aug;
  protected int auh;
  protected int aui;
  public ImageView gp;
  protected View hM;
  protected TextView mTitleView;
  
  public ivn(Context paramContext)
  {
    this.TAG = "SmallScreenAudio";
    paramContext = paramContext.getResources();
    this.mLayout = 2131559970;
    this.mWidth = paramContext.getDimensionPixelSize(2131298319);
    this.mHeight = paramContext.getDimensionPixelSize(2131298313);
    this.aub = paramContext.getDimensionPixelSize(2131298320);
    this.auc = paramContext.getDimensionPixelSize(2131298314);
    this.aud = paramContext.getDimensionPixelSize(2131298315);
    this.aue = paramContext.getDimensionPixelSize(2131298317);
    this.auf = paramContext.getDimensionPixelSize(2131298316);
    this.aug = paramContext.getDimensionPixelSize(2131298318);
    this.auh = paramContext.getDimensionPixelSize(2131298311);
    this.aui = paramContext.getDimensionPixelSize(2131298312);
  }
  
  public void a(Context paramContext, LayoutInflater paramLayoutInflater, SmallScreenRelativeLayout.a parama)
  {
    super.a(paramContext, paramLayoutInflater, parama);
    paramContext = paramContext.getResources();
    this.a.setTitleHeight(paramContext.getDimensionPixelSize(2131299627) * 5 / 2);
    this.mTitleView = ((TextView)this.a.findViewById(2131374248));
    this.gp = ((ImageView)this.a.findViewById(2131374223));
    this.gp.setImageResource(2130772234);
    paramContext = this.gp.getDrawable();
    if ((paramContext instanceof AnimationDrawable)) {
      ((AnimationDrawable)paramContext).start();
    }
    this.hM = this.a.findViewById(2131373969);
  }
  
  public void a(BaseSmallScreenService paramBaseSmallScreenService)
  {
    Object localObject1;
    Object localObject2;
    if ((paramBaseSmallScreenService instanceof SmallScreenService))
    {
      localObject1 = ((SmallScreenService)paramBaseSmallScreenService).a;
      localObject2 = igv.a().a();
      if ((localObject1 == null) || (!((VideoController)localObject1).sw()) || (((iiv)localObject2).a == null) || (((iiv)localObject2).a.Nf == null) || (!((iiv)localObject2).a.Nf.equals("1"))) {}
    }
    for (int i = 1;; i = 0)
    {
      localObject1 = (RelativeLayout.LayoutParams)this.gp.getLayoutParams();
      localObject2 = (RelativeLayout.LayoutParams)this.hM.getLayoutParams();
      if (paramBaseSmallScreenService.Vp)
      {
        this.a.setSize(this.mWidth, this.mHeight);
        if (i != 0) {
          this.a.setBackgroundResource(2130843117);
        }
        for (;;)
        {
          this.mTitleView.setVisibility(0);
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.aud;
          ((RelativeLayout.LayoutParams)localObject1).topMargin = this.aue;
          ((RelativeLayout.LayoutParams)localObject2).bottomMargin = this.auh;
          this.gp.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.hM.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.a.updateLayout();
          return;
          this.a.setBackgroundResource(2130843114);
        }
      }
      this.a.setSize(this.aub, this.auc);
      if (i != 0) {
        this.a.setBackgroundResource(2130843118);
      }
      for (;;)
      {
        this.mTitleView.setVisibility(8);
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = this.auf;
        ((RelativeLayout.LayoutParams)localObject1).topMargin = this.aug;
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = this.aui;
        break;
        this.a.setBackgroundResource(2130843116);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ivn
 * JD-Core Version:    0.7.0.1
 */