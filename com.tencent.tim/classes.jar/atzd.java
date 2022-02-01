public class atzd
  extends atzc
{
  private String cIp;
  private String cloudId;
  
  public atzd(agsd paramagsd, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    super(paramagsd);
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      this.cloudId = new String(paramArrayOfByte1);
      this.cIp = new String(paramArrayOfByte2);
    }
  }
  
  public boolean S(String paramString)
  {
    return paramString.equals(this.cloudId + this.cIp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atzd
 * JD-Core Version:    0.7.0.1
 */