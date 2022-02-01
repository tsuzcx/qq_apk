package com.tencent.TMG.sdk;

public class InternalEnterParam
  extends AVRoomMulti.EnterParam
{
  protected int bussType;
  protected byte[] extraData;
  protected byte[] freeFlowSignature;
  protected int relationType;
  
  public InternalEnterParam(InternalEnterRoomParamBuilder paramInternalEnterRoomParamBuilder)
  {
    super(paramInternalEnterRoomParamBuilder);
    this.bussType = paramInternalEnterRoomParamBuilder.bussType;
    this.relationType = paramInternalEnterRoomParamBuilder.relationType;
    this.extraData = paramInternalEnterRoomParamBuilder.extraData;
    this.freeFlowSignature = paramInternalEnterRoomParamBuilder.freeFlowSignature;
  }
  
  public static class InternalEnterRoomParamBuilder
    extends AVRoomMulti.EnterParam.Builder
  {
    protected int bussType = 7;
    protected byte[] extraData;
    protected byte[] freeFlowSignature;
    protected int relationType = 6;
    
    public InternalEnterRoomParamBuilder(int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.sdk.InternalEnterParam
 * JD-Core Version:    0.7.0.1
 */