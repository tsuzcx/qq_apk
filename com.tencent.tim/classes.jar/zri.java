import com.tencent.mobileqq.activity.photo.TroopClipPic;
import java.util.List;
import java.util.Set;

public class zri
{
  public static String baD = "-5";
  public static int ceC = -5;
  public boolean aYK;
  public String baE;
  public String baF;
  public String clipInfo;
  public int fromType;
  public boolean isSelected;
  public boolean isUploading;
  public int progress;
  public boolean started;
  public long ts;
  public int type = 0;
  
  public static final zri a(TroopClipPic paramTroopClipPic, Set<String> paramSet)
  {
    zri localzri = new zri();
    localzri.baF = paramTroopClipPic.id;
    localzri.clipInfo = paramTroopClipPic.clipInfo;
    localzri.type = paramTroopClipPic.type;
    localzri.fromType = 1;
    if (paramSet != null) {
      localzri.aYK = paramSet.contains(paramTroopClipPic.id);
    }
    return localzri;
  }
  
  public static final boolean i(List<zri> paramList1, List<zri> paramList2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramList1 == paramList2) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramList1 == null);
        bool1 = bool2;
      } while (paramList2 == null);
      bool1 = bool2;
    } while (paramList1.size() != paramList2.size());
    int i = 0;
    for (;;)
    {
      if (i >= paramList1.size()) {
        break label89;
      }
      bool1 = bool2;
      if (!((zri)paramList1.get(i)).equals(paramList2.get(i))) {
        break;
      }
      i += 1;
    }
    label89:
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof zri))) {}
    do
    {
      return false;
      paramObject = (zri)paramObject;
    } while ((!aqft.equalsWithNullCheck(this.baF, paramObject.baF)) || (!aqft.equalsWithNullCheck(this.baE, paramObject.baE)) || (this.fromType != paramObject.fromType) || (this.isUploading != paramObject.isUploading) || (this.aYK != paramObject.aYK) || (this.isSelected != paramObject.isSelected) || (!aqft.equalsWithNullCheck(this.clipInfo, paramObject.clipInfo)) || (this.type != paramObject.type) || (this.ts != paramObject.ts));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AvatarInfo=[").append("seq").append("=").append(this.baF);
    localStringBuilder.append(" ").append("fromType").append("=").append(this.fromType);
    localStringBuilder.append(" ").append("type").append("=").append(this.type);
    localStringBuilder.append(" ").append("isUploading").append("=").append(this.isUploading);
    localStringBuilder.append(" ").append("isVerifying").append("=").append(this.aYK);
    localStringBuilder.append(" ").append("clipInfo").append("=").append(this.clipInfo);
    localStringBuilder.append(" ").append("ts").append("=").append(this.ts);
    localStringBuilder.append(" ").append("localFile").append("=").append(this.baE);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zri
 * JD-Core Version:    0.7.0.1
 */