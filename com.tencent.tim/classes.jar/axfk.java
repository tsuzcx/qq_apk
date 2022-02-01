import java.io.File;
import java.util.List;

public class axfk
  extends axzy
{
  private axzu<axdl.a> q = new axzu();
  private axzu<String> r = new axzu();
  private axzu<axfq.a> s = new axzu();
  
  public void clearText()
  {
    this.q.postValue(new axdl.a("#ccffffff", "#000000"));
    this.r.postValue("");
  }
  
  public void jN(String paramString1, String paramString2)
  {
    axfq.a locala = new axfq.a();
    String[] arrayOfString = new File(paramString2).list();
    String str = paramString2 + File.separator + "snapshot.png";
    if (arrayOfString.length != 0) {
      awtg.p(paramString2 + File.separator + arrayOfString[0], 320, 320, str);
    }
    locala.cUd = paramString2;
    locala.text = paramString1;
    locala.cUf = str;
    this.s.postValue(locala);
  }
  
  public axzu<axdl.a> m()
  {
    return this.q;
  }
  
  public axzu<String> n()
  {
    return this.r;
  }
  
  public axzu<axfq.a> o()
  {
    return this.s;
  }
  
  public void setText(String paramString, int paramInt)
  {
    this.r.postValue(paramString);
    this.q.postValue(axdl.colorList.get(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axfk
 * JD-Core Version:    0.7.0.1
 */