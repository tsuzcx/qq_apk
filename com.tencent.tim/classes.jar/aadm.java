import org.json.JSONObject;

public class aadm
{
  public String bcs;
  public String bct;
  public String icon;
  public String id;
  public String name;
  public JSONObject params;
  public int type;
  
  public aadm() {}
  
  public aadm(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.id = paramString1;
    this.type = paramInt;
    this.name = paramString2;
    this.icon = paramString3;
    this.bcs = paramString4;
    this.bct = paramString5;
  }
  
  public String toString()
  {
    return "id: " + this.id + " type: " + this.type + " name: " + this.name + " params: " + this.params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aadm
 * JD-Core Version:    0.7.0.1
 */