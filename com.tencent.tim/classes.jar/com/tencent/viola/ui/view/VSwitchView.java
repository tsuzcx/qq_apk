package com.tencent.viola.ui.view;

import android.content.Context;
import android.widget.Switch;
import com.tencent.viola.ui.component.VSwitch;
import java.lang.ref.WeakReference;

public class VSwitchView
  extends Switch
  implements IVView<VSwitch>
{
  private WeakReference<VSwitch> mWeakReference;
  
  public VSwitchView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void bindComponent(VSwitch paramVSwitch)
  {
    this.mWeakReference = new WeakReference(paramVSwitch);
  }
  
  public VSwitch getComponent()
  {
    if (this.mWeakReference != null) {
      return (VSwitch)this.mWeakReference.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.view.VSwitchView
 * JD-Core Version:    0.7.0.1
 */