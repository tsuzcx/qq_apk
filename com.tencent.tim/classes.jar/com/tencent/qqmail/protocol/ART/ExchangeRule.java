package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ExchangeRule
  extends BaseProtoBuf
{
  private static final int fieldNumberActions_ = 6;
  private static final int fieldNumberConditions_ = 5;
  private static final int fieldNumberDisplay_name_ = 2;
  private static final int fieldNumberId_ = 1;
  private static final int fieldNumberIs_enabled_ = 4;
  private static final int fieldNumberPriority_ = 3;
  public Actions actions_;
  public Conditions conditions_;
  public String display_name_;
  public String id_;
  public boolean is_enabled_;
  public int priority_ = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.id_ != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.id_);
    }
    int i = j;
    if (this.display_name_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.display_name_);
    }
    j = i;
    if (this.priority_ != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.priority_);
    }
    j += ComputeSizeUtil.computeBooleanSize(4, this.is_enabled_);
    i = j;
    if (this.conditions_ != null) {
      i = j + ComputeSizeUtil.computeMessageSize(5, this.conditions_.computeSize());
    }
    j = i;
    if (this.actions_ != null) {
      j = i + ComputeSizeUtil.computeMessageSize(6, this.actions_.computeSize());
    }
    return j;
  }
  
  public final ExchangeRule parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ExchangeRule paramExchangeRule, int paramInt)
    throws IOException
  {
    Object localObject2;
    Object localObject1;
    boolean bool;
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramExchangeRule.id_ = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramExchangeRule.display_name_ = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramExchangeRule.priority_ = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramExchangeRule.is_enabled_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 5: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new Conditions();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((Conditions)localObject1).populateBuilderWithField((InputReader)localObject2, (Conditions)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeRule.conditions_ = ((Conditions)localObject1);
        paramInt += 1;
      }
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      localObject2 = (byte[])paramInputReader.get(paramInt);
      localObject1 = new Actions();
      localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
      for (bool = true; bool; bool = ((Actions)localObject1).populateBuilderWithField((InputReader)localObject2, (Actions)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
      paramExchangeRule.actions_ = ((Actions)localObject1);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.id_ != null) {
      paramOutputWriter.writeString(1, this.id_);
    }
    if (this.display_name_ != null) {
      paramOutputWriter.writeString(2, this.display_name_);
    }
    if (this.priority_ != -2147483648) {
      paramOutputWriter.writeInteger(3, this.priority_);
    }
    paramOutputWriter.writeBoolean(4, this.is_enabled_);
    if (this.conditions_ != null)
    {
      paramOutputWriter.writeMessage(5, this.conditions_.computeSize());
      this.conditions_.writeFields(paramOutputWriter);
    }
    if (this.actions_ != null)
    {
      paramOutputWriter.writeMessage(6, this.actions_.computeSize());
      this.actions_.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.ExchangeRule
 * JD-Core Version:    0.7.0.1
 */