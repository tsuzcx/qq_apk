package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import com.tencent.ttpic.openapi.model.VideoMaterial;
import ram;
import rig;

public class PersonalityOperator$1
  implements Runnable
{
  public PersonalityOperator$1(rig paramrig, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.this$0.ApplyGLSLFilter(this.val$material.getId());
    this.this$0.updateVideoSize(this.this$0.mWidth, this.this$0.mHeight, 1.0D);
    long l2 = System.currentTimeMillis();
    ram.d("PersonalityOperator", "setVideoFilter " + this.val$material.getId() + " t:" + (l2 - l1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.PersonalityOperator.1
 * JD-Core Version:    0.7.0.1
 */