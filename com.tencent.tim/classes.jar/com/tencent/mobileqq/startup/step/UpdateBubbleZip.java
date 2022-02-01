package com.tencent.mobileqq.startup.step;

import aqhq;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;
import yxe;

public class UpdateBubbleZip
  extends Step
{
  protected boolean doStep()
  {
    yxe.cmD();
    aqhq.cn(BaseApplicationImpl.sApplication.getDir("classic_emoticon", 0).getPath());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdateBubbleZip
 * JD-Core Version:    0.7.0.1
 */