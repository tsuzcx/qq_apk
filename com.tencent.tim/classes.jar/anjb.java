public class anjb
{
  static int dHC = 3;
  int label;
  int[] nE;
  int uniqueId;
  
  public anjb(String paramString, int paramInt)
    throws Exception
  {
    this.uniqueId = paramInt;
    paramString = paramString.split(" ");
    if (paramString.length != 2) {
      throw new Exception("data illegal");
    }
    if (paramString[1].equals("1")) {}
    for (this.label = 1;; this.label = 0)
    {
      paramString = paramString[0].toCharArray();
      this.nE = new int[paramString.length];
      paramInt = i;
      while (paramInt < paramString.length)
      {
        this.nE[paramInt] = (Integer.valueOf(paramString[paramInt]).intValue() - Integer.valueOf(48).intValue());
        paramInt += 1;
      }
      if (!paramString[1].equals("0")) {
        break;
      }
    }
    throw new Exception("data illegal");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anjb
 * JD-Core Version:    0.7.0.1
 */