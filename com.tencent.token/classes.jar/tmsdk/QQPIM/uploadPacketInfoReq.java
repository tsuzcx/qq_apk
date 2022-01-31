package tmsdk.QQPIM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class uploadPacketInfoReq
  extends JceStruct
{
  public String checksum_type = "";
  public int checksun_len = 0;
  public long packet_pos = 0L;
  public int packet_size = 0;
  public String software_id = "";
  public int zip_type = 0;
  
  static
  {
    if (!uploadPacketInfoReq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public uploadPacketInfoReq()
  {
    setSoftware_id(this.software_id);
    setPacket_pos(this.packet_pos);
    setPacket_size(this.packet_size);
    setChecksum_type(this.checksum_type);
    setChecksun_len(this.checksun_len);
    setZip_type(this.zip_type);
  }
  
  public uploadPacketInfoReq(String paramString1, long paramLong, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    setSoftware_id(paramString1);
    setPacket_pos(paramLong);
    setPacket_size(paramInt1);
    setChecksum_type(paramString2);
    setChecksun_len(paramInt2);
    setZip_type(paramInt3);
  }
  
  public String className()
  {
    return "tmsdk.QQPIM.uploadPacketInfoReq";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (uploadPacketInfoReq)paramObject;
    return (JceUtil.equals(this.software_id, paramObject.software_id)) && (JceUtil.equals(this.packet_pos, paramObject.packet_pos)) && (JceUtil.equals(this.packet_size, paramObject.packet_size)) && (JceUtil.equals(this.checksum_type, paramObject.checksum_type)) && (JceUtil.equals(this.checksun_len, paramObject.checksun_len)) && (JceUtil.equals(this.zip_type, paramObject.zip_type));
  }
  
  public String getChecksum_type()
  {
    return this.checksum_type;
  }
  
  public int getChecksun_len()
  {
    return this.checksun_len;
  }
  
  public long getPacket_pos()
  {
    return this.packet_pos;
  }
  
  public int getPacket_size()
  {
    return this.packet_size;
  }
  
  public String getSoftware_id()
  {
    return this.software_id;
  }
  
  public int getZip_type()
  {
    return this.zip_type;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    setSoftware_id(paramJceInputStream.readString(0, true));
    setPacket_pos(paramJceInputStream.read(this.packet_pos, 1, true));
    setPacket_size(paramJceInputStream.read(this.packet_size, 2, true));
    setChecksum_type(paramJceInputStream.readString(3, true));
    setChecksun_len(paramJceInputStream.read(this.checksun_len, 4, true));
    setZip_type(paramJceInputStream.read(this.zip_type, 5, false));
  }
  
  public void setChecksum_type(String paramString)
  {
    this.checksum_type = paramString;
  }
  
  public void setChecksun_len(int paramInt)
  {
    this.checksun_len = paramInt;
  }
  
  public void setPacket_pos(long paramLong)
  {
    this.packet_pos = paramLong;
  }
  
  public void setPacket_size(int paramInt)
  {
    this.packet_size = paramInt;
  }
  
  public void setSoftware_id(String paramString)
  {
    this.software_id = paramString;
  }
  
  public void setZip_type(int paramInt)
  {
    this.zip_type = paramInt;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.software_id, 0);
    paramJceOutputStream.write(this.packet_pos, 1);
    paramJceOutputStream.write(this.packet_size, 2);
    paramJceOutputStream.write(this.checksum_type, 3);
    paramJceOutputStream.write(this.checksun_len, 4);
    paramJceOutputStream.write(this.zip_type, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.QQPIM.uploadPacketInfoReq
 * JD-Core Version:    0.7.0.1
 */