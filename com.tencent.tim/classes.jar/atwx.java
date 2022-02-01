import java.io.PrintStream;

public class atwx
{
  public static boolean jL(int paramInt)
  {
    return (paramInt == 9052) || (paramInt == 9050) || (paramInt == 9055) || (paramInt == 9053) || (paramInt == 9054);
  }
  
  public static String t(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramArrayOfByte == null) {
      return "";
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      String str1 = str2;
      if (str2.length() == 1) {
        str1 = '0' + str2;
      }
      System.out.print(str1.toUpperCase() + " ");
      localStringBuffer.append(str1.toUpperCase() + "");
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atwx
 * JD-Core Version:    0.7.0.1
 */