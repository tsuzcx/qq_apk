package com.tencent.thumbplayer.adapter.strategy;

import com.tencent.thumbplayer.adapter.strategy.model.TPStrategyConfig;
import com.tencent.thumbplayer.adapter.strategy.model.TPStrategyContext;

public class TPDefaultStrategy
  extends TPBaseStrategy
{
  public TPDefaultStrategy(TPStrategyConfig paramTPStrategyConfig)
  {
    super(paramTPStrategyConfig);
  }
  
  protected boolean checkNeedDoRetry(TPStrategyContext paramTPStrategyContext)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.TPDefaultStrategy
 * JD-Core Version:    0.7.0.1
 */