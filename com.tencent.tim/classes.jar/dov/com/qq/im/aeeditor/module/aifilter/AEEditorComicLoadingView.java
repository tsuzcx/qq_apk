package dov.com.qq.im.aeeditor.module.aifilter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import axiy;
import java.io.File;

public class AEEditorComicLoadingView
  extends AEEditorAILoadingView
{
  public AEEditorComicLoadingView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public AEEditorComicLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AEEditorComicLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public String HR()
  {
    return cVi + cVj + File.separator;
  }
  
  public String HS()
  {
    return cVi + cVk + File.separator;
  }
  
  public void setShowResult(boolean paramBoolean)
  {
    axiy.d("AEEditorComicLoadingView", "setShowResult: " + paramBoolean);
    if (this.mt != null)
    {
      this.mt.post(new AEEditorComicLoadingView.1(this));
      return;
    }
    this.nX.post(new AEEditorComicLoadingView.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.AEEditorComicLoadingView
 * JD-Core Version:    0.7.0.1
 */