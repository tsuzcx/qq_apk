package net.jarlehansen.protobuf.output;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.original.output.CodedOutputStream;

public class OutputWriter
{
  private final CodedOutputStream codedOutput;
  private final byte[] dataHolder;
  private final OutputStream output;
  
  public OutputWriter(byte[] paramArrayOfByte)
  {
    this.dataHolder = paramArrayOfByte;
    this.output = null;
    this.codedOutput = CodedOutputStream.newInstance(paramArrayOfByte);
  }
  
  public OutputWriter(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    this.output = paramOutputStream;
    this.dataHolder = paramArrayOfByte;
    this.codedOutput = CodedOutputStream.newInstance(this.dataHolder);
  }
  
  public void writeBoolean(int paramInt, boolean paramBoolean)
    throws IOException
  {
    this.codedOutput.writeBool(paramInt, paramBoolean);
  }
  
  public void writeByteString(int paramInt, ByteString paramByteString)
    throws IOException
  {
    this.codedOutput.writeBytes(paramInt, paramByteString);
  }
  
  public void writeData()
    throws IOException
  {
    if (this.output != null)
    {
      this.output.write(this.dataHolder);
      this.output.flush();
    }
  }
  
  public void writeDelimitedSize(int paramInt)
    throws IOException
  {
    this.codedOutput.writeDelimitedSize(paramInt);
  }
  
  public void writeDouble(int paramInt, double paramDouble)
    throws IOException
  {
    this.codedOutput.writeDouble(paramInt, paramDouble);
  }
  
  public void writeFloat(int paramInt, float paramFloat)
    throws IOException
  {
    this.codedOutput.writeFloat(paramInt, paramFloat);
  }
  
  public void writeInt(int paramInt1, int paramInt2)
    throws IOException
  {
    this.codedOutput.writeInt32(paramInt1, paramInt2);
  }
  
  public void writeInteger(int paramInt1, int paramInt2)
    throws IOException
  {
    writeInt(paramInt1, paramInt2);
  }
  
  public void writeList(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
    throws IOException
  {
    if (paramLinkedList != null)
    {
      switch (paramInt2)
      {
      default: 
        throw new IllegalArgumentException("The data type was not found, the id used was " + paramInt2);
      case 6: 
        paramInt2 = 0;
      }
      while (paramInt2 < paramLinkedList.size())
      {
        writeByteString(paramInt1, (ByteString)paramLinkedList.get(paramInt2));
        paramInt2 += 1;
        continue;
        paramInt2 = 0;
        while (paramInt2 < paramLinkedList.size())
        {
          writeDouble(paramInt1, ((Double)paramLinkedList.get(paramInt2)).doubleValue());
          paramInt2 += 1;
          continue;
          paramInt2 = 0;
          while (paramInt2 < paramLinkedList.size())
          {
            writeFloat(paramInt1, ((Float)paramLinkedList.get(paramInt2)).floatValue());
            paramInt2 += 1;
            continue;
            paramInt2 = 0;
            while (paramInt2 < paramLinkedList.size())
            {
              writeInt(paramInt1, ((Integer)paramLinkedList.get(paramInt2)).intValue());
              paramInt2 += 1;
              continue;
              paramInt2 = 0;
              while (paramInt2 < paramLinkedList.size())
              {
                writeLong(paramInt1, ((Long)paramLinkedList.get(paramInt2)).longValue());
                paramInt2 += 1;
                continue;
                paramInt2 = 0;
                while (paramInt2 < paramLinkedList.size())
                {
                  writeString(paramInt1, (String)paramLinkedList.get(paramInt2));
                  paramInt2 += 1;
                  continue;
                  paramInt2 = 0;
                  while (paramInt2 < paramLinkedList.size())
                  {
                    writeBoolean(paramInt1, ((Boolean)paramLinkedList.get(paramInt2)).booleanValue());
                    paramInt2 += 1;
                    continue;
                    paramInt2 = 0;
                    while (paramInt2 < paramLinkedList.size())
                    {
                      BaseProtoBuf localBaseProtoBuf = (BaseProtoBuf)paramLinkedList.get(paramInt2);
                      writeMessage(paramInt1, localBaseProtoBuf.computeSize());
                      localBaseProtoBuf.writeFields(this);
                      paramInt2 += 1;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void writeLong(int paramInt, long paramLong)
    throws IOException
  {
    this.codedOutput.writeInt64(paramInt, paramLong);
  }
  
  public void writeMessage(int paramInt1, int paramInt2)
    throws IOException
  {
    this.codedOutput.writeMessage(paramInt1, paramInt2);
  }
  
  public void writeString(int paramInt, String paramString)
    throws IOException
  {
    this.codedOutput.writeString(paramInt, paramString);
  }
  
  public void writeVarIntList(int paramInt1, int paramInt2, LinkedList<?> paramLinkedList)
    throws IOException
  {
    if (paramLinkedList != null) {
      switch (paramInt2)
      {
      default: 
        throw new IllegalArgumentException("The data type was not found, the id used was " + paramInt2);
      case 2: 
        if (paramLinkedList.size() > 0)
        {
          this.codedOutput.writeTag(paramInt1, 2);
          this.codedOutput.writeDelimitedSize(ComputeSizeUtil.computeVarIntListSize(paramInt2, paramLinkedList));
          paramInt1 = 0;
        }
        break;
      case 3: 
        while (paramInt1 < paramLinkedList.size())
        {
          this.codedOutput.writeRawVarint32(((Integer)paramLinkedList.get(paramInt1)).intValue());
          paramInt1 += 1;
          continue;
          if (paramLinkedList.size() > 0)
          {
            this.codedOutput.writeTag(paramInt1, 2);
            this.codedOutput.writeDelimitedSize(ComputeSizeUtil.computeVarIntListSize(paramInt2, paramLinkedList));
            paramInt1 = 0;
            while (paramInt1 < paramLinkedList.size())
            {
              this.codedOutput.writeRawVarint64(((Long)paramLinkedList.get(paramInt1)).longValue());
              paramInt1 += 1;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.jarlehansen.protobuf.output.OutputWriter
 * JD-Core Version:    0.7.0.1
 */