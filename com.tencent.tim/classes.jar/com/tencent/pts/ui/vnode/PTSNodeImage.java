package com.tencent.pts.ui.vnode;

import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.view.PTSImageView;

public class PTSNodeImage
  extends PTSNodeVirtual<PTSImageView>
{
  public PTSNodeImage(PTSAppInstance paramPTSAppInstance)
  {
    super(paramPTSAppInstance);
  }
  
  private void setImageSrc(String paramString) {}
  
  protected boolean setAttribute(String paramString, Object paramObject)
  {
    if (super.setAttribute(paramString, paramObject)) {
      return true;
    }
    if (("src".equalsIgnoreCase(paramString)) && ((paramObject instanceof String)))
    {
      setImageSrc((String)paramObject);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.vnode.PTSNodeImage
 * JD-Core Version:    0.7.0.1
 */