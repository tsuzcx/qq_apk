package net.jarlehansen.protobuf;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.util.LinkedList;
import net.jarlehansen.protobuf.original.output.CodedOutputStream;

public class ComputeSizeUtil
{
  public static int computeBooleanSize(int paramInt, boolean paramBoolean)
  {
    return CodedOutputStream.computeBoolSize(paramInt, paramBoolean);
  }
  
  public static int computeByteStringSize(int paramInt, ByteString paramByteString)
  {
    return CodedOutputStream.computeBytesSize(paramInt, paramByteString);
  }
  
  public static int computeDelimitedIntSize(int paramInt)
  {
    return CodedOutputStream.computeRawVarint32Size(paramInt);
  }
  
  public static int computeDoubleSize(int paramInt, double paramDouble)
  {
    return CodedOutputStream.computeDoubleSize(paramInt, paramDouble);
  }
  
  public static int computeFloatSize(int paramInt, float paramFloat)
  {
    return CodedOutputStream.computeFloatSize(paramInt, paramFloat);
  }
  
  public static int computeIntSize(int paramInt1, int paramInt2)
  {
    return CodedOutputStream.computeInt32Size(paramInt1, paramInt2);
  }
  
  public static int computeIntegerSize(int paramInt1, int paramInt2)
  {
    return computeIntSize(paramInt1, paramInt2);
  }
  
  public static int computeListSize(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
  {
    if (paramLinkedList != null)
    {
      switch (paramInt2)
      {
      default: 
        throw new IllegalArgumentException("The data type was not found, the id used was " + paramInt2);
      case 6: 
        j = 0;
        i = 0;
        for (;;)
        {
          paramInt2 = i;
          if (j >= paramLinkedList.size()) {
            break;
          }
          i += computeByteStringSize(paramInt1, (ByteString)paramLinkedList.get(j));
          j += 1;
        }
      case 4: 
        j = 0;
        i = 0;
        for (;;)
        {
          paramInt2 = i;
          if (j >= paramLinkedList.size()) {
            break;
          }
          i += computeDoubleSize(paramInt1, ((Double)paramLinkedList.get(j)).doubleValue());
          j += 1;
        }
      case 5: 
        j = 0;
        i = 0;
        for (;;)
        {
          paramInt2 = i;
          if (j >= paramLinkedList.size()) {
            break;
          }
          i += computeFloatSize(paramInt1, ((Float)paramLinkedList.get(j)).floatValue());
          j += 1;
        }
      case 2: 
        j = 0;
        i = 0;
        for (;;)
        {
          paramInt2 = i;
          if (j >= paramLinkedList.size()) {
            break;
          }
          i += computeIntSize(paramInt1, ((Integer)paramLinkedList.get(j)).intValue());
          j += 1;
        }
      case 3: 
        j = 0;
        i = 0;
        for (;;)
        {
          paramInt2 = i;
          if (j >= paramLinkedList.size()) {
            break;
          }
          i += computeLongSize(paramInt1, ((Long)paramLinkedList.get(j)).longValue());
          j += 1;
        }
      case 1: 
        j = 0;
        i = 0;
        for (;;)
        {
          paramInt2 = i;
          if (j >= paramLinkedList.size()) {
            break;
          }
          i += computeStringSize(paramInt1, (String)paramLinkedList.get(j));
          j += 1;
        }
      case 7: 
        j = 0;
        i = 0;
        for (;;)
        {
          paramInt2 = i;
          if (j >= paramLinkedList.size()) {
            break;
          }
          i += computeBooleanSize(paramInt1, ((Boolean)paramLinkedList.get(j)).booleanValue());
          j += 1;
        }
      }
      int j = 0;
      int i = 0;
      for (;;)
      {
        paramInt2 = i;
        if (j >= paramLinkedList.size()) {
          break;
        }
        i += computeMessageSize(paramInt1, ((BaseProtoBuf)paramLinkedList.get(j)).computeSize());
        j += 1;
      }
    }
    paramInt2 = 0;
    return paramInt2;
  }
  
  public static int computeLongSize(int paramInt, long paramLong)
  {
    return CodedOutputStream.computeInt64Size(paramInt, paramLong);
  }
  
  public static int computeMessageSize(int paramInt1, int paramInt2)
  {
    return CodedOutputStream.computeTagSize(paramInt1) + CodedOutputStream.computeRawVarint32Size(paramInt2) + paramInt2;
  }
  
  public static int computeStringSize(int paramInt, String paramString)
  {
    return CodedOutputStream.computeStringSize(paramInt, paramString);
  }
  
  public static int computeVarIntListSize(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
  {
    int j = 0;
    int i = j;
    if (paramLinkedList != null) {
      switch (paramInt2)
      {
      default: 
        throw new IllegalArgumentException("The data type was not found, the id used was " + paramInt2);
      case 2: 
        i = j;
        if (paramLinkedList.size() > 0)
        {
          paramInt2 = 0;
          i = 0;
          while (paramInt2 < paramLinkedList.size())
          {
            i += CodedOutputStream.computeRawVarint32Size(((Integer)paramLinkedList.get(paramInt2)).intValue());
            paramInt2 += 1;
          }
          i = CodedOutputStream.computeRawVarint32Size(i) + i + CodedOutputStream.computeTagSize(paramInt1);
        }
        break;
      }
    }
    do
    {
      return i;
      i = j;
    } while (paramLinkedList.size() <= 0);
    paramInt2 = 0;
    i = 0;
    while (paramInt2 < paramLinkedList.size())
    {
      i += CodedOutputStream.computeRawVarint64Size(((Long)paramLinkedList.get(paramInt2)).longValue());
      paramInt2 += 1;
    }
    return CodedOutputStream.computeRawVarint32Size(i) + i + CodedOutputStream.computeTagSize(paramInt1);
  }
  
  public static int computeVarIntListSize(int paramInt, LinkedList<?> paramLinkedList)
  {
    int j = 0;
    int i = j;
    if (paramLinkedList != null) {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("The data type was not found, the id used was " + paramInt);
      case 2: 
        i = j;
        if (paramLinkedList.size() > 0)
        {
          i = 0;
          paramInt = 0;
          while (i < paramLinkedList.size())
          {
            paramInt += CodedOutputStream.computeRawVarint32Size(((Integer)paramLinkedList.get(i)).intValue());
            i += 1;
          }
          i = paramInt;
        }
        break;
      }
    }
    do
    {
      return i;
      i = j;
    } while (paramLinkedList.size() <= 0);
    paramInt = 0;
    i = 0;
    while (paramInt < paramLinkedList.size())
    {
      i += CodedOutputStream.computeRawVarint64Size(((Long)paramLinkedList.get(paramInt)).longValue());
      paramInt += 1;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.jarlehansen.protobuf.ComputeSizeUtil
 * JD-Core Version:    0.7.0.1
 */