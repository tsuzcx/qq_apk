import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class axdl
{
  public static final List<axdl.a> colorList = new ArrayList(Arrays.asList(new axdl.a[] { new axdl.a("#ffffff", "#000000"), new axdl.a("#000000", "#ffffff"), new axdl.a("#ff596a", "#ffffff"), new axdl.a("#ffcc00", "#b96300"), new axdl.a("#64ecde", "#1d70c0"), new axdl.a("#8173ff", "#ffffff") }));
  public static final int[] tO = { 1, 2, 3, 4, 5 };
  
  public static class a
  {
    public String cTQ;
    public String textColor;
    
    public a(String paramString1, String paramString2)
    {
      this.textColor = paramString1;
      this.cTQ = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axdl
 * JD-Core Version:    0.7.0.1
 */