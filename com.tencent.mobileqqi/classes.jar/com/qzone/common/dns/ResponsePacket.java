package com.qzone.common.dns;

import com.qzone.common.logging.QDLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ResponsePacket
{
  private static final int LABEL_COMPRESSION = 192;
  private static final int LABEL_MASK = 192;
  private static final int LABEL_NORMAL = 0;
  private static final int MAXLABEL = 64;
  private static final int SECTION_ADDRESS = 1;
  private static final int SECTION_QUESTION = 0;
  private int[] counts = new int[4];
  private long expireTime = 0L;
  private int flags;
  private String host = "";
  private DNSInput in;
  private byte[] label = new byte[64];
  private StringBuilder nameBuilder = new StringBuilder();
  private int reqId;
  private ArrayList[] sections;
  
  public ResponsePacket(DNSInput paramDNSInput, String paramString)
    throws WireParseException, UnknownHostException, Exception
  {
    this.in = paramDNSInput;
    this.host = paramString;
    this.sections = new ArrayList[4];
    initHeader();
    check(this.flags);
    parseAnswer();
  }
  
  private void check(int paramInt)
    throws UnknownHostException, Exception
  {
    String str = Integer.toBinaryString(paramInt);
    if (str.length() < 4) {
      throw new Exception("exception cause [FBS - " + str + "]");
    }
    str = str.substring(str.length() - 4);
    if (str.equals("0011")) {
      throw new UnknownHostException("Unable to resolve host \"" + this.host + "\": No address associated with hostname");
    }
    if (!str.equals("0000")) {
      throw new Exception("exception cause [RCODE - " + str + "][HOST - " + this.host + "]");
    }
  }
  
  private void initHeader()
    throws WireParseException
  {
    this.reqId = this.in.readU16();
    this.flags = this.in.readU16();
    int i = 0;
    for (;;)
    {
      if (i >= this.counts.length) {
        return;
      }
      this.counts[i] = this.in.readU16();
      i += 1;
    }
  }
  
  private void parseAnswer()
    throws WireParseException
  {
    int i = 0;
    if (i >= 2) {
      return;
    }
    label211:
    label225:
    label230:
    for (;;)
    {
      int k;
      try
      {
        k = this.counts[i];
        if (k <= 0) {
          break label211;
        }
        this.sections[i] = new ArrayList(k);
      }
      catch (WireParseException localWireParseException)
      {
        AnswerRecord localAnswerRecord;
        throw localWireParseException;
      }
      localAnswerRecord = new AnswerRecord();
      int j;
      if (i == 0)
      {
        localAnswerRecord.domain = retrieveName();
        localAnswerRecord.type = this.in.readU16();
        localAnswerRecord.qclass = this.in.readU16();
        this.sections[i].add(localAnswerRecord);
      }
      else
      {
        retrieveName();
        localAnswerRecord.domain = this.host;
        localAnswerRecord.type = this.in.readU16();
        localAnswerRecord.qclass = this.in.readU16();
        localAnswerRecord.ttl = this.in.readU32();
        this.in.setActive(this.in.readU16());
        localAnswerRecord.ip = this.in.readByteArray();
        if (localAnswerRecord.type == 1)
        {
          setExpireTime(localAnswerRecord.ttl);
          this.sections[i].add(localAnswerRecord);
          break label225;
          j = 0;
        }
      }
      for (;;)
      {
        if (j < k) {
          break label230;
        }
        i += 1;
        break;
        j += 1;
      }
    }
  }
  
  private String retrieveName()
    throws WireParseException
  {
    int k = 0;
    int m = 0;
    int i = k;
    int j = m;
    if (this.nameBuilder.length() > 0)
    {
      this.nameBuilder.delete(0, this.nameBuilder.length());
      j = m;
      i = k;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (j != 0) {
          this.in.restore();
        }
        if (this.nameBuilder.length() > 0) {
          this.nameBuilder.deleteCharAt(this.nameBuilder.length() - 1);
        }
        return this.nameBuilder.toString();
      }
      k = this.in.readU8();
      switch (k & 0xC0)
      {
      default: 
        throw new WireParseException("bad label type");
      case 0: 
        if (k == 0)
        {
          i = 1;
        }
        else
        {
          this.in.readByteArray(this.label, 0, k);
          this.nameBuilder.append(ByteBase.byteString(this.label, k));
          this.nameBuilder.append(".");
        }
        break;
      case 192: 
        m = this.in.readU8() + ((k & 0xFFFFFF3F) << 8);
        if (m >= this.in.current() - 2) {
          throw new WireParseException("bad compression");
        }
        k = j;
        if (j == 0)
        {
          this.in.save();
          k = 1;
        }
        this.in.jump(m);
        j = k;
      }
    }
  }
  
  private void setExpireTime(long paramLong)
  {
    if ((this.expireTime == 0L) && (paramLong > 0L)) {
      this.expireTime = (System.currentTimeMillis() + 1000L * paramLong);
    }
  }
  
  public ArrayList<AnswerRecord> getAnswers()
  {
    return this.sections[1];
  }
  
  public InetAddress[] getByAddress()
  {
    if ((this.sections[1] != null) && (this.sections[1].size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      for (;;)
      {
        if (i >= this.sections[1].size()) {
          return (InetAddress[])localArrayList.toArray(new InetAddress[localArrayList.size()]);
        }
        Object localObject = (AnswerRecord)this.sections[1].get(i);
        try
        {
          localObject = InetAddress.getByAddress(((AnswerRecord)localObject).domain, ((AnswerRecord)localObject).ip);
          if ((localObject != null) && (((InetAddress)localObject).getHostName() != null) && (!((InetAddress)localObject).getHostName().equals(((InetAddress)localObject).getHostAddress()))) {
            localArrayList.add(localObject);
          }
        }
        catch (UnknownHostException localUnknownHostException)
        {
          for (;;)
          {
            QDLog.e("ResponsePacket", "getByAddress>>>", localUnknownHostException);
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public long getExpireTime()
  {
    return this.expireTime;
  }
  
  public int getReqId()
  {
    return this.reqId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.common.dns.ResponsePacket
 * JD-Core Version:    0.7.0.1
 */