package dov.com.qq.im.aeeditor.module.controlpanel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import axmw;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;

public abstract class AEEditorControlPanelContainer
  extends FrameLayout
{
  protected AEEditorFilterControlPanel a;
  protected Context context;
  
  public AEEditorControlPanelContainer(@NonNull Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    init();
  }
  
  public AEEditorControlPanelContainer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
    init();
  }
  
  public AEEditorControlPanelContainer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    init();
  }
  
  public AEEditorFilterControlPanel a(axmw paramaxmw)
  {
    removeAllViews();
    if (this.a == null)
    {
      this.a = new AEEditorFilterControlPanel(this.context);
      this.a.setFilterChangedComparator(paramaxmw);
    }
    paramaxmw = new FrameLayout.LayoutParams(-1, -1);
    addView(this.a, paramaxmw);
    return this.a;
  }
  
  public void hide()
  {
    removeAllViews();
  }
  
  abstract void init();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.controlpanel.AEEditorControlPanelContainer
 * JD-Core Version:    0.7.0.1
 */