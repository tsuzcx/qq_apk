import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class nhm
  extends ReportDialog
  implements View.OnClickListener
{
  private LinearLayout ej;
  private RelativeLayout fo;
  private TextView tf;
  private TextView tg;
  
  public nhm(@NonNull Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public nhm(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, 2131755362);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    requestWindowFeature(1);
    setContentView(2131560272);
    getWindow().setLayout(-1, -1);
    setCancelable(true);
    this.tf = ((TextView)findViewById(2131380630));
    this.tg = ((TextView)findViewById(2131380629));
    this.fo = ((RelativeLayout)findViewById(2131370962));
    this.ej = ((LinearLayout)findViewById(2131370966));
    this.fo.setOnClickListener(this);
    this.tg.setOnClickListener(this);
    odc.a(this.tg, wja.dp2px(3.0F, paramContext.getResources()), Color.parseColor("#00CAFC"));
    odc.a(this.ej, wja.dp2px(3.0F, paramContext.getResources()), Color.parseColor("#ffffff"));
    getWindow().setWindowAnimations(2131755546);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nhm
 * JD-Core Version:    0.7.0.1
 */