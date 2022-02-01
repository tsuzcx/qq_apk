import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class aash
  extends ReportDialog
  implements View.OnClickListener
{
  aash.a a;
  String bed;
  String bee;
  String bef;
  String beg;
  
  public aash(@NonNull Context paramContext)
  {
    super(paramContext, 2131756669);
    paramContext = getLayoutInflater().inflate(2131563084, null);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    super.setContentView(paramContext);
  }
  
  public void a(aash.a parama)
  {
    this.a = parama;
  }
  
  public void initView()
  {
    if (!aqmr.isEmpty(this.bed))
    {
      localObject = URLDrawable.getDrawable(this.bed);
      CornerImageView localCornerImageView = (CornerImageView)findViewById(2131374684);
      float f = (int)getContext().getResources().getDimension(2131298563);
      localCornerImageView.setRadius(new float[] { f, f, f, f, 0.0F, 0.0F, 0.0F, 0.0F });
      localCornerImageView.setImageDrawable((Drawable)localObject);
    }
    if (!aqmr.isEmpty(this.bee)) {
      ((TextView)findViewById(2131374686)).setText(this.bee);
    }
    int i;
    if (!aqmr.isEmpty(this.bef))
    {
      ((TextView)findViewById(2131374688)).setText(this.bef);
      localObject = (RelativeLayout)findViewById(2131374687);
      ((RelativeLayout)localObject).setOnClickListener(this);
      if (!aqmr.isEmpty(this.beg)) {
        i = Color.parseColor("#57d4d9");
      }
    }
    try
    {
      int j = Color.parseColor(this.beg);
      i = j;
    }
    catch (Exception localException)
    {
      label190:
      break label190;
    }
    ((GradientDrawable)((RelativeLayout)localObject).getBackground()).setColor(i);
    Object localObject = (ImageView)findViewById(2131364687);
    if (localObject != null) {
      ((ImageView)localObject).setOnClickListener(this);
    }
  }
  
  public void onClick(View paramView)
  {
    if ((this.a == null) || (paramView == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131374687) {
        this.a.cxP();
      } else if (paramView.getId() == 2131364687) {
        this.a.cxQ();
      }
    }
  }
  
  public void x(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.bef = paramString3;
    this.bed = paramString1;
    this.bee = paramString2;
    this.beg = paramString4;
  }
  
  public static abstract interface a
  {
    public abstract void cxP();
    
    public abstract void cxQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aash
 * JD-Core Version:    0.7.0.1
 */