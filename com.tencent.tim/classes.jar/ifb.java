import com.tencent.qphone.base.util.Cryptor;

public class ifb
{
  private final String LE = "ZaDA32%dkn_vs4dAjg";
  
  protected String b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new String(new Cryptor().decrypt(paramArrayOfByte1, paramArrayOfByte2));
  }
  
  protected byte[] u()
  {
    return "ZaDA32%dkn_vs4dAjg".getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ifb
 * JD-Core Version:    0.7.0.1
 */