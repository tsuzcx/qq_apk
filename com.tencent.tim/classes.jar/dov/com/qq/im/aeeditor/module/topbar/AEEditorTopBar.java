package dov.com.qq.im.aeeditor.module.topbar;

import acfp;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import axiz;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AEEditorTopBar
  extends RelativeLayout
  implements View.OnClickListener
{
  private TextView Dk;
  private ImageView Iw;
  private a a;
  private TextView ahr;
  private TextView ahs;
  private boolean cSH;
  private TextView titleTextView;
  
  public AEEditorTopBar(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public AEEditorTopBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public AEEditorTopBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    this.cSH = axiz.aOK();
    paramContext = View.inflate(paramContext, 2131558618, this);
    this.Iw = ((ImageView)paramContext.findViewById(2131362301));
    this.ahr = ((TextView)paramContext.findViewById(2131362302));
    this.titleTextView = ((TextView)paramContext.findViewById(2131362305));
    this.Dk = ((TextView)paramContext.findViewById(2131362303));
    this.ahs = ((TextView)paramContext.findViewById(2131362304));
    this.Iw.setOnClickListener(this);
    this.ahr.setOnClickListener(this);
    this.Dk.setOnClickListener(this);
    this.ahs.setOnClickListener(this);
  }
  
  public void cox()
  {
    this.Iw.setVisibility(0);
    this.Dk.setVisibility(0);
  }
  
  public void coy()
  {
    this.Iw.setVisibility(4);
    this.Dk.setVisibility(4);
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
      if (this.a != null)
      {
        this.a.eMh();
        continue;
        if (this.a != null) {
          this.a.eMi();
        }
      }
    }
  }
  
  public void setLeftButtonAsBackArray()
  {
    this.Iw.setVisibility(0);
    this.ahr.setVisibility(4);
    this.Dk.setVisibility(0);
    this.ahs.setVisibility(4);
    this.Dk.setText(acfp.m(2131689961));
  }
  
  public void setStyleAsCancelAndFinish()
  {
    this.Iw.setVisibility(0);
    this.ahr.setVisibility(4);
    this.Dk.setVisibility(4);
    this.ahs.setVisibility(0);
    this.ahs.setText(acfp.m(2131689958));
  }
  
  public void setTitle(String paramString)
  {
    this.titleTextView.setText(paramString);
  }
  
  public void setTopBarClickListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void eMh();
    
    public abstract void eMi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.topbar.AEEditorTopBar
 * JD-Core Version:    0.7.0.1
 */