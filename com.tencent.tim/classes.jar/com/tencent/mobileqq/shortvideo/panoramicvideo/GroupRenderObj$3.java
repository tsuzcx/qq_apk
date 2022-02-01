package com.tencent.mobileqq.shortvideo.panoramicvideo;

import java.util.List;

class GroupRenderObj$3
  implements Runnable
{
  GroupRenderObj$3(GroupRenderObj paramGroupRenderObj, BaseRenderObj paramBaseRenderObj) {}
  
  public void run()
  {
    if (this.this$0.renderObjLists.size() > 0) {
      ((BaseRenderObj)this.this$0.renderObjLists.remove(this.this$0.renderObjLists.size() - 1)).destroy();
    }
    this.val$filter.init();
    this.this$0.renderObjLists.add(this.val$filter);
    this.this$0.onRenderObjChanged(this.this$0.surfaceWidth, this.this$0.surfaceHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.GroupRenderObj.3
 * JD-Core Version:    0.7.0.1
 */