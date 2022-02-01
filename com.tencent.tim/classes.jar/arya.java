import android.text.TextUtils;

public class arya
{
  public String aIR = "";
  public String actionType = "";
  public String appId = "";
  public String cDm = "";
  public String cDn = "";
  public String cDo = "";
  public String cDp = "";
  public String cDq = "";
  public String network = "";
  public String qua = "";
  public String uin = "";
  public String via = "";
  
  public boolean aHj()
  {
    return (!TextUtils.isEmpty(this.actionType)) && (!TextUtils.isEmpty(this.appId)) && (!TextUtils.isEmpty(this.network)) && (!TextUtils.isEmpty(this.aIR)) && (!TextUtils.isEmpty(this.uin)) && (!TextUtils.isEmpty(this.via));
  }
  
  public String getNetwork()
  {
    if (TextUtils.isEmpty(this.network)) {
      return arwo.bE(aroi.a().getContext());
    }
    return this.network;
  }
  
  public String toString()
  {
    return this.uin + "_" + this.appId + "_" + this.via + "_" + this.actionType + "_" + this.network + "_" + this.aIR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arya
 * JD-Core Version:    0.7.0.1
 */