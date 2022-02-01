import org.json.JSONObject;

public abstract class apkn
{
  protected boolean cRd = true;
  protected JSONObject mData;
  public int mPosition;
  
  public void SX(String paramString) {}
  
  public boolean aBi()
  {
    return this.cRd;
  }
  
  public JSONObject af()
  {
    return this.mData;
  }
  
  public abstract int getSize();
  
  public abstract int getType();
  
  public String toString()
  {
    if (this.mData != null) {
      return this.mData.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apkn
 * JD-Core Version:    0.7.0.1
 */