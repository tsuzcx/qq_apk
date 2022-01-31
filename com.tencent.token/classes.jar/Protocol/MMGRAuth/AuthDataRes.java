package Protocol.MMGRAuth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AuthDataRes
  extends JceStruct
{
  public long commSoluId = 0L;
  public long extSoluId = 0L;
  public String policyId = "";
  
  public JceStruct newInit()
  {
    return new AuthDataRes();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.policyId = paramJceInputStream.readString(0, false);
    this.commSoluId = paramJceInputStream.read(this.commSoluId, 1, false);
    this.extSoluId = paramJceInputStream.read(this.extSoluId, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.policyId != null) {
      paramJceOutputStream.write(this.policyId, 0);
    }
    if (this.commSoluId != 0L) {
      paramJceOutputStream.write(this.commSoluId, 1);
    }
    if (this.extSoluId != 0L) {
      paramJceOutputStream.write(this.extSoluId, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     Protocol.MMGRAuth.AuthDataRes
 * JD-Core Version:    0.7.0.1
 */