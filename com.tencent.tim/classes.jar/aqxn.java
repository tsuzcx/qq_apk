public class aqxn
{
  public String aHD;
  public int bitRate;
  public int changeType;
  public int channel = 2;
  public int sampleRate;
  public int sampleSize = 2;
  public int voiceType;
  
  public aqxn(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.aHD = paramString;
    this.sampleRate = paramInt1;
    this.bitRate = paramInt2;
    this.voiceType = paramInt3;
    this.changeType = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqxn
 * JD-Core Version:    0.7.0.1
 */