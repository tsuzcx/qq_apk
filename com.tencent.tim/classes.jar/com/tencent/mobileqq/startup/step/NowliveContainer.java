package com.tencent.mobileqq.startup.step;

import aibx;
import com.tencent.shadow.core.common.LoggerFactory;

public class NowliveContainer
  extends Step
{
  protected boolean doStep()
  {
    LoggerFactory.setILoggerFactory(aibx.a());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.NowliveContainer
 * JD-Core Version:    0.7.0.1
 */