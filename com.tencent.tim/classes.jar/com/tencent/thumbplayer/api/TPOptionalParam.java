package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;

public class TPOptionalParam
{
  public static final int TP_OPTIONAL_PARAM_TYPE_BOOLEAN = 1;
  public static final int TP_OPTIONAL_PARAM_TYPE_FLOAT = 6;
  public static final int TP_OPTIONAL_PARAM_TYPE_LONG = 2;
  public static final int TP_OPTIONAL_PARAM_TYPE_QUEUE_INT = 4;
  public static final int TP_OPTIONAL_PARAM_TYPE_QUEUE_STRING = 5;
  public static final int TP_OPTIONAL_PARAM_TYPE_STRING = 3;
  public static final int TP_OPTIONAL_PARAM_TYPE_UNKNOWN = -1;
  public static final int TP_OPTIONAL_RARAM_TYPE_OBJECT = 7;
  @TPCommonEnum.TPOptionalId
  private int key;
  private OptionalParamBoolean paramBoolean;
  private OptionalParamFloat paramFloat;
  private OptionalParamLong paramLong;
  private OptionalParamObject paramObject;
  private OptionalParamQueueInt paramQueueInt;
  private OptionalParamQueueString paramQueueString;
  private OptionalParamString paramString;
  private int paramType = -1;
  
  public TPOptionalParam buildBoolean(@TPCommonEnum.TPOptionalId int paramInt, boolean paramBoolean1)
  {
    this.paramType = 1;
    this.key = paramInt;
    this.paramBoolean = new OptionalParamBoolean();
    this.paramBoolean.value = paramBoolean1;
    return this;
  }
  
  public TPOptionalParam buildFloat(@TPCommonEnum.TPOptionalId int paramInt, float paramFloat1)
  {
    this.paramType = 6;
    this.key = paramInt;
    this.paramFloat = new OptionalParamFloat();
    this.paramFloat.value = paramFloat1;
    return this;
  }
  
  public TPOptionalParam buildFloat(@TPCommonEnum.TPOptionalId int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.paramType = 6;
    this.key = paramInt;
    this.paramFloat = new OptionalParamFloat();
    this.paramFloat.value = paramFloat1;
    this.paramFloat.param1 = paramFloat2;
    this.paramFloat.param2 = paramFloat3;
    return this;
  }
  
  public TPOptionalParam buildLong(@TPCommonEnum.TPOptionalId int paramInt, long paramLong1)
  {
    this.paramType = 2;
    this.key = paramInt;
    this.paramLong = new OptionalParamLong();
    this.paramLong.value = paramLong1;
    return this;
  }
  
  public TPOptionalParam buildLong(@TPCommonEnum.TPOptionalId int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    this.paramType = 2;
    this.key = paramInt;
    this.paramLong = new OptionalParamLong();
    this.paramLong.value = paramLong1;
    this.paramLong.param1 = paramLong2;
    this.paramLong.param2 = paramLong3;
    return this;
  }
  
  public TPOptionalParam buildObject(int paramInt, Object paramObject1)
  {
    this.paramType = 7;
    this.key = paramInt;
    this.paramObject = new OptionalParamObject();
    this.paramObject.objectValue = paramObject1;
    return this;
  }
  
  public TPOptionalParam buildQueueInt(@TPCommonEnum.TPOptionalId int paramInt, int[] paramArrayOfInt)
  {
    this.paramType = 4;
    this.key = paramInt;
    this.paramQueueInt = new OptionalParamQueueInt();
    this.paramQueueInt.queueValue = paramArrayOfInt;
    return this;
  }
  
  public TPOptionalParam buildQueueString(@TPCommonEnum.TPOptionalId int paramInt, String[] paramArrayOfString)
  {
    this.paramType = 5;
    this.key = paramInt;
    this.paramQueueString = new OptionalParamQueueString();
    this.paramQueueString.queueValue = paramArrayOfString;
    return this;
  }
  
  public TPOptionalParam buildString(@TPCommonEnum.TPOptionalId int paramInt, String paramString1)
  {
    this.paramType = 3;
    this.key = paramInt;
    this.paramString = new OptionalParamString();
    this.paramString.value = paramString1;
    return this;
  }
  
  public TPOptionalParam buildString(@TPCommonEnum.TPOptionalId int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.paramType = 3;
    this.key = paramInt;
    this.paramString = new OptionalParamString();
    this.paramString.value = paramString1;
    this.paramString.param1 = paramString2;
    this.paramString.param2 = paramString3;
    return this;
  }
  
  @TPCommonEnum.TPOptionalId
  public int getKey()
  {
    return this.key;
  }
  
  public OptionalParamBoolean getParamBoolean()
  {
    return this.paramBoolean;
  }
  
  public OptionalParamFloat getParamFloat()
  {
    return this.paramFloat;
  }
  
  public OptionalParamLong getParamLong()
  {
    return this.paramLong;
  }
  
  public OptionalParamObject getParamObject()
  {
    return this.paramObject;
  }
  
  public OptionalParamQueueInt getParamQueueInt()
  {
    return this.paramQueueInt;
  }
  
  public OptionalParamQueueString getParamQueueString()
  {
    return this.paramQueueString;
  }
  
  public OptionalParamString getParamString()
  {
    return this.paramString;
  }
  
  public int getParamType()
  {
    return this.paramType;
  }
  
  public String toString()
  {
    int j = 0;
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    switch (this.paramType)
    {
    default: 
      localStringBuilder.append("type:unknown");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("type:long, key:");
      localStringBuilder.append(this.key);
      localStringBuilder.append(", \nname:");
      localStringBuilder.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
      localStringBuilder.append(", value:");
      localStringBuilder.append(this.paramBoolean.value);
      continue;
      localStringBuilder.append("type:long, key:");
      localStringBuilder.append(this.key);
      localStringBuilder.append(", \nname:");
      localStringBuilder.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
      localStringBuilder.append(", value:");
      localStringBuilder.append(this.paramLong.value);
      localStringBuilder.append(", param1:");
      localStringBuilder.append(this.paramLong.param1);
      localStringBuilder.append(", param2:");
      localStringBuilder.append(this.paramLong.param2);
      continue;
      localStringBuilder.append("type:float, key:");
      localStringBuilder.append(this.key);
      localStringBuilder.append(", \nname:");
      localStringBuilder.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
      localStringBuilder.append(", value:");
      localStringBuilder.append(this.paramFloat.value);
      localStringBuilder.append(", param1:");
      localStringBuilder.append(this.paramFloat.param1);
      localStringBuilder.append(", param2:");
      localStringBuilder.append(this.paramFloat.param2);
      continue;
      localStringBuilder.append("type:string, key:");
      localStringBuilder.append(this.key);
      localStringBuilder.append(", \nname:");
      localStringBuilder.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
      localStringBuilder.append(", value:");
      localStringBuilder.append(this.paramString.value);
      localStringBuilder.append(", param1:");
      localStringBuilder.append(this.paramString.param1);
      localStringBuilder.append(", param2:");
      localStringBuilder.append(this.paramString.param2);
      continue;
      localStringBuilder.append("type:quint_int, key:");
      localStringBuilder.append(this.key);
      localStringBuilder.append(", \nname:");
      localStringBuilder.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
      localStringBuilder.append(", value:");
      if (this.paramQueueInt.queueValue != null)
      {
        Object localObject = this.paramQueueInt.queueValue;
        j = localObject.length;
        while (i < j)
        {
          localStringBuilder.append(localObject[i]);
          localStringBuilder.append(", ");
          i += 1;
        }
        localStringBuilder.append("type:quint_string, key:");
        localStringBuilder.append(this.key);
        localStringBuilder.append(", \nname:");
        localStringBuilder.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
        localStringBuilder.append(", value:");
        if (this.paramQueueString.queueValue != null)
        {
          localObject = this.paramQueueString.queueValue;
          int k = localObject.length;
          i = j;
          while (i < k)
          {
            localStringBuilder.append(localObject[i]);
            localStringBuilder.append(", ");
            i += 1;
          }
        }
      }
    }
  }
  
  public static class OptionalParamBoolean
  {
    public boolean value;
  }
  
  public static class OptionalParamFloat
  {
    public float param1;
    public float param2;
    public float value;
  }
  
  public static class OptionalParamLong
  {
    public long param1;
    public long param2;
    public long value;
  }
  
  public static class OptionalParamObject
  {
    public Object objectValue;
  }
  
  public static class OptionalParamQueueInt
  {
    public int[] queueValue;
  }
  
  public static class OptionalParamQueueString
  {
    public String[] queueValue;
  }
  
  public static class OptionalParamString
  {
    public String param1;
    public String param2;
    public String value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPOptionalParam
 * JD-Core Version:    0.7.0.1
 */