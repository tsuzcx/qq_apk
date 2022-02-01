package com.tencent.tmediacodec.pools;

import android.support.annotation.NonNull;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;

public abstract interface PoolActionCallback
{
  public abstract void onErase(@NonNull ReuseCodecWrapper paramReuseCodecWrapper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.pools.PoolActionCallback
 * JD-Core Version:    0.7.0.1
 */