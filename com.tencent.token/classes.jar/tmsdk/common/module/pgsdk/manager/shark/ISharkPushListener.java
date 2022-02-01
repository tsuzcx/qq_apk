package tmsdk.common.module.pgsdk.manager.shark;

import com.qq.taf.jce.JceStruct;

public abstract interface ISharkPushListener
{
  public abstract Triple<Long, Integer, JceStruct> onRecvPush(int paramInt1, long paramLong, int paramInt2, JceStruct paramJceStruct);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.manager.shark.ISharkPushListener
 * JD-Core Version:    0.7.0.1
 */