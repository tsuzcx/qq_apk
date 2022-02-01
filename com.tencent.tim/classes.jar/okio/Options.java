package okio;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class Options
  extends AbstractList<ByteString>
  implements RandomAccess
{
  final ByteString[] byteStrings;
  final int[] trie;
  
  private Options(ByteString[] paramArrayOfByteString, int[] paramArrayOfInt)
  {
    this.byteStrings = paramArrayOfByteString;
    this.trie = paramArrayOfInt;
  }
  
  private static void buildTrieRecursive(long paramLong, Buffer paramBuffer, int paramInt1, List<ByteString> paramList, int paramInt2, int paramInt3, List<Integer> paramList1)
  {
    if (paramInt2 >= paramInt3) {
      throw new AssertionError();
    }
    int i = paramInt2;
    while (i < paramInt3)
    {
      if (((ByteString)paramList.get(i)).size() < paramInt1) {
        throw new AssertionError();
      }
      i += 1;
    }
    Object localObject = (ByteString)paramList.get(paramInt2);
    ByteString localByteString = (ByteString)paramList.get(paramInt3 - 1);
    int j = -1;
    if (paramInt1 == ((ByteString)localObject).size())
    {
      j = ((Integer)paramList1.get(paramInt2)).intValue();
      paramInt2 += 1;
      localObject = (ByteString)paramList.get(paramInt2);
    }
    for (;;)
    {
      int k;
      if (((ByteString)localObject).getByte(paramInt1) != localByteString.getByte(paramInt1))
      {
        i = 1;
        k = paramInt2 + 1;
        if (k < paramInt3)
        {
          if (((ByteString)paramList.get(k - 1)).getByte(paramInt1) == ((ByteString)paramList.get(k)).getByte(paramInt1)) {
            break label777;
          }
          i += 1;
        }
      }
      label770:
      label777:
      for (;;)
      {
        k += 1;
        break;
        paramLong = intCount(paramBuffer) + paramLong + 2L + i * 2;
        paramBuffer.writeInt(i);
        paramBuffer.writeInt(j);
        i = paramInt2;
        while (i < paramInt3)
        {
          j = ((ByteString)paramList.get(i)).getByte(paramInt1);
          if ((i == paramInt2) || (j != ((ByteString)paramList.get(i - 1)).getByte(paramInt1))) {
            paramBuffer.writeInt(j & 0xFF);
          }
          i += 1;
        }
        localObject = new Buffer();
        i = paramInt2;
        if (i < paramInt3)
        {
          j = ((ByteString)paramList.get(i)).getByte(paramInt1);
          paramInt2 = i + 1;
          label379:
          if (paramInt2 >= paramInt3) {
            break label770;
          }
          if (j == ((ByteString)paramList.get(paramInt2)).getByte(paramInt1)) {}
        }
        for (;;)
        {
          if ((i + 1 == paramInt2) && (paramInt1 + 1 == ((ByteString)paramList.get(i)).size())) {
            paramBuffer.writeInt(((Integer)paramList1.get(i)).intValue());
          }
          for (;;)
          {
            i = paramInt2;
            break;
            paramInt2 += 1;
            break label379;
            paramBuffer.writeInt((int)(-1L * (intCount((Buffer)localObject) + paramLong)));
            buildTrieRecursive(paramLong, (Buffer)localObject, paramInt1 + 1, paramList, i, paramInt2, paramList1);
          }
          paramBuffer.write((Buffer)localObject, ((Buffer)localObject).size());
          return;
          int m = Math.min(((ByteString)localObject).size(), localByteString.size());
          i = 0;
          k = paramInt1;
          while ((k < m) && (((ByteString)localObject).getByte(k) == localByteString.getByte(k)))
          {
            i += 1;
            k += 1;
          }
          paramLong = intCount(paramBuffer) + paramLong + 2L + i + 1L;
          paramBuffer.writeInt(-i);
          paramBuffer.writeInt(j);
          j = paramInt1;
          while (j < paramInt1 + i)
          {
            paramBuffer.writeInt(((ByteString)localObject).getByte(j) & 0xFF);
            j += 1;
          }
          if (paramInt2 + 1 == paramInt3)
          {
            if (paramInt1 + i != ((ByteString)paramList.get(paramInt2)).size()) {
              throw new AssertionError();
            }
            paramBuffer.writeInt(((Integer)paramList1.get(paramInt2)).intValue());
            return;
          }
          localObject = new Buffer();
          paramBuffer.writeInt((int)(-1L * (intCount((Buffer)localObject) + paramLong)));
          buildTrieRecursive(paramLong, (Buffer)localObject, paramInt1 + i, paramList, paramInt2, paramInt3, paramList1);
          paramBuffer.write((Buffer)localObject, ((Buffer)localObject).size());
          return;
          paramInt2 = paramInt3;
        }
      }
    }
  }
  
  private static int intCount(Buffer paramBuffer)
  {
    return (int)(paramBuffer.size() / 4L);
  }
  
  public static Options of(ByteString... paramVarArgs)
  {
    int k = 0;
    if (paramVarArgs.length == 0) {
      return new Options(new ByteString[0], new int[] { 0, -1 });
    }
    Object localObject1 = new ArrayList(Arrays.asList(paramVarArgs));
    Collections.sort((List)localObject1);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < ((List)localObject1).size())
    {
      localArrayList.add(Integer.valueOf(-1));
      i += 1;
    }
    i = 0;
    while (i < ((List)localObject1).size())
    {
      localArrayList.set(Collections.binarySearch((List)localObject1, paramVarArgs[i]), Integer.valueOf(i));
      i += 1;
    }
    if (((ByteString)((List)localObject1).get(0)).size() == 0) {
      throw new IllegalArgumentException("the empty byte string is not a supported option");
    }
    int j = 0;
    while (j < ((List)localObject1).size())
    {
      localObject2 = (ByteString)((List)localObject1).get(j);
      i = j + 1;
      ByteString localByteString;
      if (i < ((List)localObject1).size())
      {
        localByteString = (ByteString)((List)localObject1).get(i);
        if (localByteString.startsWith((ByteString)localObject2)) {}
      }
      else
      {
        j += 1;
        continue;
      }
      if (localByteString.size() == ((ByteString)localObject2).size()) {
        throw new IllegalArgumentException("duplicate option: " + localByteString);
      }
      if (((Integer)localArrayList.get(i)).intValue() > ((Integer)localArrayList.get(j)).intValue())
      {
        ((List)localObject1).remove(i);
        localArrayList.remove(i);
      }
      for (;;)
      {
        break;
        i += 1;
      }
    }
    Object localObject2 = new Buffer();
    buildTrieRecursive(0L, (Buffer)localObject2, 0, (List)localObject1, 0, ((List)localObject1).size(), localArrayList);
    localObject1 = new int[intCount((Buffer)localObject2)];
    i = k;
    while (i < localObject1.length)
    {
      localObject1[i] = ((Buffer)localObject2).readInt();
      i += 1;
    }
    if (!((Buffer)localObject2).exhausted()) {
      throw new AssertionError();
    }
    return new Options((ByteString[])paramVarArgs.clone(), (int[])localObject1);
  }
  
  public ByteString get(int paramInt)
  {
    return this.byteStrings[paramInt];
  }
  
  public final int size()
  {
    return this.byteStrings.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okio.Options
 * JD-Core Version:    0.7.0.1
 */