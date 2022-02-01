package oicq.wlogin_sdk.tlv_type;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ljava.lang.String;>;

public class tlv_t511
  extends tlv_t
{
  public tlv_t511()
  {
    this._cmd = 1297;
  }
  
  public byte[] get_tlv_511(List<String> paramList)
  {
    Object localObject1 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject2 = (String)paramList.next();
      if ((localObject2 != null) && (((String)localObject2).length() != 0)) {
        ((List)localObject1).add(localObject2);
      }
    }
    Object localObject2 = ByteBuffer.allocate(1024);
    ((ByteBuffer)localObject2).putShort((short)((List)localObject1).size());
    Iterator localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (String)localIterator.next();
      if ((localObject1 != null) && (((String)localObject1).length() != 0))
      {
        int i = ((String)localObject1).indexOf('(');
        int k = ((String)localObject1).indexOf(')');
        byte b2 = 1;
        paramList = (List<String>)localObject1;
        byte b1 = b2;
        if (i == 0)
        {
          paramList = (List<String>)localObject1;
          b1 = b2;
          if (k > 0)
          {
            int j = Integer.valueOf(((String)localObject1).substring(i + 1, k)).intValue();
            b1 = 0;
            if ((0x100000 & j) > 0) {
              i = 1;
            } else {
              i = 0;
            }
            if ((j & 0x8000000) > 0) {
              j = 1;
            } else {
              j = 0;
            }
            if (i != 0) {
              b1 = (byte)1;
            }
            if (j != 0) {
              b1 = (byte)(b1 | 0x2);
            }
            paramList = ((String)localObject1).substring(k + 1);
          }
        }
        ((ByteBuffer)localObject2).put(b1);
        ((ByteBuffer)localObject2).putShort((short)paramList.length());
        ((ByteBuffer)localObject2).put(paramList.getBytes());
      }
    }
    fill_head(this._cmd);
    fill_body(((ByteBuffer)localObject2).array(), ((ByteBuffer)localObject2).position());
    set_length();
    return get_buf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tlv_type.tlv_t511
 * JD-Core Version:    0.7.0.1
 */