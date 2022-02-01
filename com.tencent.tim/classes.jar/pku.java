import com.tencent.mobileqq.data.Card;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class pku
{
  public static int dN(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    case 5: 
    case 6: 
    default: 
      return 6;
    case 4: 
      return 10;
    }
    return 10;
  }
  
  public static class a
  {
    public String asR;
    public int bje;
    public List<String> lZ;
    public int mTextId;
    public String mTransId;
    public int type;
    
    public a() {}
    
    public a(pjp.c paramc)
    {
      this.type = paramc.type;
      if (paramc.bja > 0) {}
      for (int i = paramc.bja;; i = pku.dN(this.type))
      {
        this.bje = i;
        this.asR = paramc.asR;
        this.mTransId = paramc.transId;
        this.mTextId = paramc.textId;
        this.lZ = paramc.lN;
        return;
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder("BaseSplitConfig =[");
      localStringBuilder1.append(" type=").append(this.type);
      localStringBuilder1.append(" mTransId=").append(this.mTransId);
      localStringBuilder1.append(" mTextId=").append(this.mTextId);
      localStringBuilder1.append(" mAlbumMinPicCount=").append(this.bje);
      localStringBuilder1.append(" mAlbumDesc=").append(this.asR);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(" mTransList=");
      if (this.lZ == null) {}
      for (String str = "";; str = this.lZ.toString())
      {
        localStringBuilder2.append(str);
        localStringBuilder1.append("]");
        return localStringBuilder1.toString();
      }
    }
  }
  
  public static class b
    extends pku.a
  {
    public String mAlbumName;
    public long mEndTime;
    public long mStartTime;
    
    public b(pjp.b paramb, int paramInt)
      throws ParseException
    {
      super();
      if (paramb.type == 1) {}
      for (;;)
      {
        rom.assertTrue(bool);
        this.mAlbumName = paramb.name;
        int i = paramInt;
        if (paramInt == 0) {
          i = paramb.year;
        }
        String str = i + "-" + paramb.asP;
        paramb = i + "-" + paramb.asQ;
        long l1 = pjp.e.parse(str).getTime() / 1000L;
        long l2 = pjp.e.parse(paramb).getTime() / 1000L;
        this.mStartTime = l1;
        this.mEndTime = l2;
        return;
        bool = false;
      }
    }
    
    public b(pjp.b paramb, Card paramCard, int paramInt)
      throws ParseException
    {
      super();
      boolean bool;
      int i;
      label48:
      int j;
      if (paramb.type == 6)
      {
        bool = true;
        rom.assertTrue(bool);
        this.mAlbumName = paramb.name;
        if (paramCard == null) {
          break label239;
        }
        i = (int)((paramCard.lBirthday & 0xFF00) >> 8);
        if (paramCard == null) {
          break label245;
        }
        j = (int)(paramCard.lBirthday & 0xFF);
        label63:
        if ((i <= 0) || (j <= 0)) {
          break label270;
        }
        if (i >= 10) {
          break label251;
        }
        paramCard = "0" + i;
        label101:
        if (j >= 10) {
          break label260;
        }
      }
      label260:
      for (String str = "0" + j;; str = String.valueOf(j))
      {
        paramCard = paramInt + "-" + paramCard + "-" + str + " " + paramb.asP;
        paramCard = pjp.e.parse(paramCard);
        long l1 = paramCard.getTime() / 1000L;
        long l2 = paramCard.getTime() / 1000L;
        long l3 = paramb.duration * 60 * 60;
        this.mStartTime = l1;
        this.mEndTime = (l2 + l3);
        return;
        bool = false;
        break;
        label239:
        i = 0;
        break label48;
        label245:
        j = 0;
        break label63;
        label251:
        paramCard = String.valueOf(i);
        break label101;
      }
      label270:
      this.mStartTime = 0L;
      this.mEndTime = 0L;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("TimeSplitConfig =[");
      localStringBuilder.append(" mStartTime=").append(this.mStartTime);
      localStringBuilder.append(" mEndTime=").append(this.mEndTime);
      localStringBuilder.append(" mAlbumName=").append(this.mAlbumName);
      localStringBuilder.append("] ");
      return localStringBuilder.toString() + super.toString();
    }
  }
  
  public static class c
    extends pku.a
  {
    public int bjf = -1;
    public int bjg = -1;
    
    public c() {}
    
    public c(pjp.c paramc)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("TreeGatherConfig =[");
      localStringBuilder.append(" mStartGatherLevel=").append(this.bjf);
      localStringBuilder.append(" mEndGatherLevel=").append(this.bjg);
      localStringBuilder.append("] ");
      return localStringBuilder.toString() + super.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pku
 * JD-Core Version:    0.7.0.1
 */