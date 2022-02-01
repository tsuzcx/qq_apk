package dov.com.qq.im.aeeditor.module.toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import aqnm;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.view.AECompoundButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AEEditorToolBar
  extends LinearLayout
  implements View.OnClickListener
{
  private static final String TAG = AEEditorToolBar.class.getSimpleName();
  protected a a;
  private List<AECompoundButton> pC = new ArrayList();
  
  public AEEditorToolBar(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public AEEditorToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public AEEditorToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    setOrientation(1);
    eNd();
  }
  
  abstract void adf(String paramString);
  
  abstract void eNd();
  
  public void hi(String paramString, int paramInt)
  {
    Iterator localIterator = this.pC.iterator();
    while (localIterator.hasNext())
    {
      AECompoundButton localAECompoundButton = (AECompoundButton)localIterator.next();
      if (paramString.equals(localAECompoundButton.getTag())) {
        localAECompoundButton.setForegroundResource(paramInt);
      }
    }
  }
  
  public void hide()
  {
    setVisibility(4);
  }
  
  protected void j(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    AECompoundButton localAECompoundButton = new AECompoundButton(getContext());
    localAECompoundButton.setTag(paramString);
    localAECompoundButton.setOnClickListener(this);
    localAECompoundButton.setBackgroundResource(paramInt3);
    localAECompoundButton.setForegroundResource(paramInt2);
    localAECompoundButton.setForegroundSize(aqnm.dip2px(56.0F), aqnm.dip2px(56.0F));
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.width = aqnm.dip2px(56.0F);
    paramString.height = aqnm.dip2px(56.0F);
    addView(localAECompoundButton, paramInt1, paramString);
    this.pC.add(paramInt1, localAECompoundButton);
  }
  
  public void onClick(View paramView)
  {
    adf((String)paramView.getTag());
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setToolBarListener(a parama)
  {
    this.a = parama;
  }
  
  public void show()
  {
    setVisibility(0);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.toolbar.AEEditorToolBar
 * JD-Core Version:    0.7.0.1
 */