import java.util.ArrayList;

public class afsy
{
  public long XK;
  public String bFu;
  public String bFv;
  public String bFw;
  public String bFx = "";
  public String bFy = "";
  public int cUg = -1;
  public String city;
  public String company;
  public String constellation;
  public int distance = -1;
  public String friendUin;
  public String mDeclaration;
  public int mGender;
  public int mVoiceDuration;
  public String mVoiceUrl;
  public ArrayList<afty> wr;
  public ArrayList<aftz> ws;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{friendUin: ").append(this.friendUin).append("}");
    localStringBuilder.append("{age: ").append(this.bFu).append("}");
    localStringBuilder.append("{constellation: ").append(this.constellation).append("}");
    localStringBuilder.append("{city: ").append(this.city).append("}");
    localStringBuilder.append("{school: ").append(this.bFv).append("}");
    localStringBuilder.append("{constel:").append(this.constellation).append("}");
    localStringBuilder.append("{company:").append(this.company).append("}");
    localStringBuilder.append("{mGender: ").append(this.mGender).append("}");
    localStringBuilder.append("{mDeclaration: ").append(this.mDeclaration).append("}");
    localStringBuilder.append("{mVoiceUrl: ").append(this.mVoiceUrl).append("}");
    localStringBuilder.append("{mVoiceDuration: ").append(this.mVoiceDuration).append("}");
    localStringBuilder.append("{signWords: ").append(this.bFw).append("}");
    if (this.wr == null)
    {
      localStringBuilder.append("{personalTags: is empty ").append("}");
      localStringBuilder.append("{popular: ").append(this.XK).append("}");
      if (this.ws != null) {
        break label399;
      }
      localStringBuilder.append("{schoolInfo: is empty ").append("}");
    }
    for (;;)
    {
      localStringBuilder.append("{distance: ").append(this.distance).append("}");
      localStringBuilder.append("{signalBombMatchPool: ").append(this.cUg).append("}");
      localStringBuilder.append("{strFromCity: ").append(this.bFx).append("}");
      localStringBuilder.append("{strToCity: ").append(this.bFy).append("}");
      return localStringBuilder.toString();
      localStringBuilder.append("{personalTags:size  ").append(this.wr.size()).append("}");
      break;
      label399:
      localStringBuilder.append("{schoolInfo:size  ").append(this.ws.size()).append("}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afsy
 * JD-Core Version:    0.7.0.1
 */