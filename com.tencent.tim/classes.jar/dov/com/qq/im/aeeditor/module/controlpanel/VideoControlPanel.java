package dov.com.qq.im.aeeditor.module.controlpanel;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import axnb.a;
import axng;
import axng.a;
import java.util.LinkedList;
import java.util.List;

public class VideoControlPanel
  extends AEEditorControlPanelContainer
{
  private axng a;
  
  public VideoControlPanel(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoControlPanel(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(@NonNull axnb.a parama)
  {
    if (this.a != null) {
      this.a.a(parama);
    }
  }
  
  public void aej(int paramInt)
  {
    if (this.a != null) {
      this.a.aej(paramInt);
    }
  }
  
  public void eMj()
  {
    if (this.a != null) {
      this.a.show();
    }
  }
  
  public void eMk()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
  }
  
  @NonNull
  public List<axnb.a> hS()
  {
    if (this.a != null) {
      return this.a.hS();
    }
    return new LinkedList();
  }
  
  public void hide()
  {
    super.hide();
    eMk();
  }
  
  void init()
  {
    int i = this.context.getResources().getDimensionPixelSize(2131296369);
    this.a = new axng(this.context, i);
  }
  
  public void oH(@NonNull List<axnb.a> paramList)
  {
    if (this.a != null) {
      this.a.oH(paramList);
    }
  }
  
  public void setBackgroundMusicChecked(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.setBackgroundMusicChecked(paramBoolean);
    }
  }
  
  public void setMusicOperationCallback(@Nullable axng.a parama)
  {
    if (this.a != null) {
      this.a.a(parama);
    }
  }
  
  public void setOriginalSoundChecked(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.setOriginalSoundChecked(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel
 * JD-Core Version:    0.7.0.1
 */