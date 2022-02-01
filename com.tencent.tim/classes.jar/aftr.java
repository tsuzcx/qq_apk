import android.text.TextUtils;

public class aftr
{
  public afsy a;
  public String aeN = "0";
  public String bFC = "";
  public int matchExpiredTime = 30;
  public String nickName = "";
  public byte[] sig;
  public int tagId = 1;
  public String tagName = "";
  public long timeStamp = -1L;
  public String tipsWording = "";
  public String uin = "";
  
  public aftr a()
  {
    aftr localaftr = new aftr();
    localaftr.uin = this.uin;
    localaftr.sig = ((byte[])this.sig.clone());
    localaftr.bFC = this.bFC;
    localaftr.tipsWording = this.tipsWording;
    localaftr.timeStamp = this.timeStamp;
    localaftr.matchExpiredTime = this.matchExpiredTime;
    localaftr.aeN = this.aeN;
    return localaftr;
  }
  
  public boolean akm()
  {
    String str = aqft.bytesToHexString(this.sig);
    return (!TextUtils.isEmpty(this.bFC)) && (!TextUtils.isEmpty(this.bFC)) && (!TextUtils.isEmpty(str));
  }
  
  public void clear()
  {
    this.uin = "";
    this.sig = aqft.p("");
    this.bFC = "";
    this.tipsWording = "";
    this.timeStamp = -1L;
    this.matchExpiredTime = -1;
    this.aeN = "0";
    this.tagId = 0;
    this.tagName = "";
    this.a = null;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((TextUtils.isEmpty(this.uin)) || (TextUtils.isEmpty(this.bFC))) {}
    do
    {
      do
      {
        return false;
      } while (!(paramObject instanceof aftr));
      paramObject = (aftr)paramObject;
    } while ((!this.uin.equals(paramObject.uin)) || (!this.bFC.equals(paramObject.bFC)) || (this.timeStamp != paramObject.timeStamp));
    return true;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{uin: ").append(this.uin).append("}");
    String str = aqft.bytesToHexString(this.sig);
    int i = 0;
    if (str != null) {
      i = str.length();
    }
    localStringBuilder.append("{sig: ").append(i).append("}");
    localStringBuilder.append("{matchUin: ").append(this.bFC).append("}");
    localStringBuilder.append("{tipsWording: ").append(this.tipsWording).append("}");
    localStringBuilder.append("{timeStamp: ").append(this.timeStamp).append("}");
    localStringBuilder.append("{nickName: ").append(this.nickName).append("}");
    localStringBuilder.append("{algorithmID: ").append(this.aeN).append("}");
    localStringBuilder.append("{tagId: ").append(this.tagId).append("}");
    localStringBuilder.append("{tagName: ").append(this.tagName).append("}");
    if (this.a != null) {
      localStringBuilder.append(this.a.toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aftr
 * JD-Core Version:    0.7.0.1
 */