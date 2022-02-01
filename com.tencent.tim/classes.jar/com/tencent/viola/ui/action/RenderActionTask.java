package com.tencent.viola.ui.action;

import com.tencent.viola.ui.context.RenderActionContext;

public class RenderActionTask
  implements IRenderTask
{
  private final RenderActionContext mContext;
  private final RenderAction mRenderTask;
  
  public RenderActionTask(RenderAction paramRenderAction, RenderActionContext paramRenderActionContext)
  {
    this.mRenderTask = paramRenderAction;
    this.mContext = paramRenderActionContext;
  }
  
  public void execute()
  {
    this.mRenderTask.executeRender(this.mContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.ui.action.RenderActionTask
 * JD-Core Version:    0.7.0.1
 */