import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;

public class aftd
{
  public long XK;
  public long XL;
  public String bFu;
  public String bFv;
  public String bFz;
  public int cUi;
  public String company;
  public String constellation;
  public String declaration;
  public int distance;
  public int gender;
  public ArrayList<String> labels;
  public String nick;
  public long pushTime;
  public String uin;
  public String voiceUrl;
  
  public static aftd a(aftr paramaftr)
  {
    aftd localaftd = new aftd();
    localaftd.pushTime = paramaftr.timeStamp;
    localaftd.uin = paramaftr.bFC;
    localaftd.nick = paramaftr.nickName;
    if (paramaftr.a != null)
    {
      localaftd.XK = paramaftr.a.XK;
      Object localObject;
      if ((paramaftr.a.ws != null) && (!paramaftr.a.ws.isEmpty()))
      {
        localObject = (aftz)paramaftr.a.ws.get(0);
        localaftd.bFv = ((aftz)localObject).schoolName;
        localaftd.XL = ((aftz)localObject).XL;
        localaftd.bFz = ((aftz)localObject).schoolId;
      }
      localaftd.distance = paramaftr.a.distance;
      localaftd.bFu = paramaftr.a.bFu;
      localaftd.gender = paramaftr.a.mGender;
      if (paramaftr.a.wr != null)
      {
        localaftd.labels = new ArrayList(paramaftr.a.wr.size());
        localObject = paramaftr.a.wr.iterator();
        while (((Iterator)localObject).hasNext())
        {
          afty localafty = (afty)((Iterator)localObject).next();
          localaftd.labels.add(localafty.tagName);
        }
      }
      localaftd.declaration = paramaftr.a.mDeclaration;
      localaftd.voiceUrl = paramaftr.a.mVoiceUrl;
      localaftd.cUi = paramaftr.a.mVoiceDuration;
      localaftd.distance = paramaftr.a.distance;
      localaftd.constellation = paramaftr.a.constellation;
      localaftd.company = paramaftr.a.company;
    }
    return localaftd;
  }
  
  public static aftr a(aftd paramaftd)
  {
    aftr localaftr = new aftr();
    localaftr.bFC = paramaftd.uin;
    localaftr.tagId = 0;
    localaftr.timeStamp = paramaftd.pushTime;
    localaftr.nickName = paramaftd.nick;
    localaftr.a = new afsy();
    localaftr.a.XK = paramaftd.XK;
    localaftr.a.ws = new ArrayList(1);
    Object localObject = new aftz(paramaftd.bFz, paramaftd.bFv, paramaftd.XL);
    localaftr.a.ws.add(localObject);
    localaftr.a.bFu = paramaftd.bFu;
    localaftr.a.mGender = paramaftd.gender;
    if (paramaftd.labels != null)
    {
      localaftr.a.wr = new ArrayList(paramaftd.labels.size());
      localObject = paramaftd.labels.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        afty localafty = new afty();
        localafty.tagName = str;
        localaftr.a.wr.add(localafty);
      }
    }
    localaftr.a.mDeclaration = paramaftd.declaration;
    localaftr.a.mVoiceDuration = paramaftd.cUi;
    localaftr.a.mVoiceUrl = paramaftd.voiceUrl;
    localaftr.a.distance = paramaftd.distance;
    localaftr.a.constellation = paramaftd.constellation;
    localaftr.a.company = paramaftd.company;
    return localaftr;
  }
  
  public boolean akk()
  {
    return this.XL == 2L;
  }
  
  @NonNull
  public String toString()
  {
    return String.format("uin:%s,nick:%s,dis:%d", new Object[] { this.uin, this.nick, Integer.valueOf(this.distance) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aftd
 * JD-Core Version:    0.7.0.1
 */