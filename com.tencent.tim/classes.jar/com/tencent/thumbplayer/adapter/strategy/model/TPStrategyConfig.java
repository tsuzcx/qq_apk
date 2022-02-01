package com.tencent.thumbplayer.adapter.strategy.model;

import com.tencent.thumbplayer.adapter.TPPlaybackParams;
import com.tencent.thumbplayer.adapter.strategy.utils.TPStrategyUtils;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamLong;
import com.tencent.thumbplayer.api.TPOptionalParam.OptionalParamQueueInt;

public class TPStrategyConfig
{
  int decStrategy = 2;
  boolean mIsExtPlayerList = false;
  int[] mPlayerList;
  int playerStrategy = 2;
  
  public TPStrategyConfig(TPPlaybackParams paramTPPlaybackParams)
    throws IllegalArgumentException
  {
    if (TPStrategyUtils.isTVPlatform())
    {
      this.playerStrategy = 4;
      this.decStrategy = 2;
    }
    if (paramTPPlaybackParams == null) {
      return;
    }
    TPOptionalParam localTPOptionalParam = paramTPPlaybackParams.getOptionalParam(210);
    if ((localTPOptionalParam != null) && (localTPOptionalParam.getParamType() == 4))
    {
      this.mPlayerList = localTPOptionalParam.getParamQueueInt().queueValue;
      this.mIsExtPlayerList = true;
      return;
    }
    localTPOptionalParam = paramTPPlaybackParams.getOptionalParam(202);
    if ((localTPOptionalParam != null) && (localTPOptionalParam.getParamType() == 2) && (isPlayerStrategyVaild(localTPOptionalParam.getParamLong().value))) {
      this.playerStrategy = ((int)localTPOptionalParam.getParamLong().value);
    }
    paramTPPlaybackParams = paramTPPlaybackParams.getOptionalParam(203);
    if ((paramTPPlaybackParams != null) && (paramTPPlaybackParams.getParamType() == 2) && (isDecStrategyVaild(paramTPPlaybackParams.getParamLong().value))) {
      this.decStrategy = ((int)paramTPPlaybackParams.getParamLong().value);
    }
    checkParamsIllegal(this.playerStrategy, this.decStrategy);
  }
  
  private void checkParamsIllegal(int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    if ((paramInt1 == 3) && (paramInt2 == 3)) {
      throw new IllegalArgumentException("can not soft with systemplayer");
    }
  }
  
  private boolean isDecStrategyVaild(long paramLong)
  {
    return (paramLong > 0L) && (paramLong < 5L);
  }
  
  private boolean isPlayerStrategyVaild(long paramLong)
  {
    return (paramLong > 0L) && (paramLong < 5L);
  }
  
  public int getDecStrategy()
  {
    return this.decStrategy;
  }
  
  public int[] getPlayerList()
  {
    return this.mPlayerList;
  }
  
  public int getPlayerStrategy()
  {
    return this.playerStrategy;
  }
  
  public boolean isExtPlayerList()
  {
    return this.mIsExtPlayerList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.model.TPStrategyConfig
 * JD-Core Version:    0.7.0.1
 */