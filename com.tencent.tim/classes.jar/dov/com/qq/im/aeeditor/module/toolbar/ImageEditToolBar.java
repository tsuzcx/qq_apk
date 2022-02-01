package dov.com.qq.im.aeeditor.module.toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import axiz;

public class ImageEditToolBar
  extends AEEditorToolBar
{
  private boolean cSH;
  
  public ImageEditToolBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public ImageEditToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ImageEditToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  void adf(String paramString)
  {
    if ((paramString.equals("text")) && (this.a != null) && ((this.a instanceof a))) {
      ((a)this.a).eMF();
    }
  }
  
  protected void eNd()
  {
    this.cSH = axiz.aOK();
    j(0, "text", 2130837956, 2130837748);
  }
  
  public static abstract interface a
    extends AEEditorToolBar.a
  {
    public abstract void eMF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.toolbar.ImageEditToolBar
 * JD-Core Version:    0.7.0.1
 */