package dov.com.qq.im.aeeditor.module.topbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.aeeditor.view.AEEditorClipIndexView;

public class AEEditorClipPageTopBar
  extends RelativeLayout
  implements View.OnClickListener
{
  private ImageView Iv;
  private a jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorClipPageTopBar$a;
  private AEEditorClipIndexView jdField_a_of_type_DovComQqImAeeditorViewAEEditorClipIndexView;
  
  public AEEditorClipPageTopBar(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public AEEditorClipPageTopBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public AEEditorClipPageTopBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    paramContext = View.inflate(paramContext, 2131558604, this);
    this.Iv = ((ImageView)paramContext.findViewById(2131362296));
    this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorClipIndexView = ((AEEditorClipIndexView)paramContext.findViewById(2131362297));
    this.Iv.setOnClickListener(this);
    this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorClipIndexView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131362296) {
      if (this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorClipPageTopBar$a != null) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorClipPageTopBar$a.eLT();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((i == 2131362297) && (this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorClipPageTopBar$a != null)) {
        this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorClipPageTopBar$a.eLU();
      }
    }
  }
  
  public void setClipPageTopBarClickListener(a parama)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleTopbarAEEditorClipPageTopBar$a = parama;
  }
  
  public void setIndex(int paramInt)
  {
    if (this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorClipIndexView != null) {
      this.jdField_a_of_type_DovComQqImAeeditorViewAEEditorClipIndexView.setIndex(paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract void eLT();
    
    public abstract void eLU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.topbar.AEEditorClipPageTopBar
 * JD-Core Version:    0.7.0.1
 */