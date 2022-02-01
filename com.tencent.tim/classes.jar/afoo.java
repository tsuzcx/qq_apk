import com.tencent.mobileqq.data.EmoticonPackage;

public class afoo
{
  public int TL;
  public EmoticonPackage d;
  public int type;
  
  public afoo(int paramInt1, int paramInt2, EmoticonPackage paramEmoticonPackage)
  {
    this.type = paramInt1;
    this.TL = paramInt2;
    this.d = paramEmoticonPackage;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof afoo)) {
        return false;
      }
      paramObject = (afoo)paramObject;
      if ((this.type != paramObject.type) || (this.TL != paramObject.TL)) {
        break;
      }
    } while (((this.d == null) && (paramObject.d == null)) || ((this.d != null) && (paramObject.d != null) && (this.d.epId != null) && (this.d.epId.equals(paramObject.d.epId))));
    return false;
    return false;
  }
  
  public String toString()
  {
    String str = "";
    if (this.d != null) {
      str = this.d.epId;
    }
    return "EmotionPanelInfo [type=" + this.type + ", columnNum=" + this.TL + ", epid=" + str + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afoo
 * JD-Core Version:    0.7.0.1
 */