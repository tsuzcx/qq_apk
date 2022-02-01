package dov.com.qq.im.aeeditor.module.toolbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import axiz;
import axoc;
import axod;

public class VideoEditToolBar
  extends AEEditorToolBar
{
  private boolean cSH;
  private boolean dvy;
  
  public VideoEditToolBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoEditToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoEditToolBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void YB(boolean paramBoolean)
  {
    this.cSH = axiz.aOK();
    this.dvy = paramBoolean;
    if (this.dvy)
    {
      hi("music", 2130837985);
      return;
    }
    hi("music", 2130837984);
  }
  
  void adf(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.a != null)
    {
      localObject1 = localObject2;
      if ((this.a instanceof a)) {
        localObject1 = (a)this.a;
      }
    }
    if (paramString.equals("clip")) {
      if (localObject1 != null) {
        ((a)localObject1).eMK();
      }
    }
    do
    {
      do
      {
        return;
        if (!paramString.equals("text")) {
          break;
        }
      } while (localObject1 == null);
      ((a)localObject1).eMF();
      return;
    } while ((!paramString.equals("music")) || (localObject1 == null));
    ((a)localObject1).eML();
  }
  
  protected void eNd()
  {
    this.cSH = axiz.aOK();
    j(0, "clip", 2130837952, 2130837748);
    j(1, "text", 2130837956, 2130837748);
    j(2, "music", 2130837984, 2130837748);
  }
  
  public void eNe()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(350L);
    localAnimationSet.setAnimationListener(new axoc(this));
    startAnimation(localAnimationSet);
  }
  
  public void ewk()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(350L);
    localAnimationSet.setAnimationListener(new axod(this));
    startAnimation(localAnimationSet);
  }
  
  public static abstract interface a
    extends AEEditorToolBar.a
  {
    public abstract void eMF();
    
    public abstract void eMK();
    
    public abstract void eML();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.toolbar.VideoEditToolBar
 * JD-Core Version:    0.7.0.1
 */