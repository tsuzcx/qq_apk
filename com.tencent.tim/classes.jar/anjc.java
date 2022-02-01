import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class anjc
{
  List<anjb> Gx;
  anjc[] a;
  anjc b;
  int dHD;
  int dHE;
  int dHF = -1;
  
  anjc(anjc paramanjc, List<anjb> paramList)
  {
    this.b = paramanjc;
    this.a = new anjc[anjb.dHC];
    this.Gx = paramList;
    this.dHE = ((anjb)paramList.get(0)).nE.length;
    this.dHD = -1;
    paramanjc = new int[2];
    anjc tmp57_56 = paramanjc;
    tmp57_56[0] = 0;
    anjc tmp61_57 = tmp57_56;
    tmp61_57[1] = 0;
    tmp61_57;
    paramList = this.Gx.iterator();
    while (paramList.hasNext())
    {
      i = ((anjb)paramList.next()).label;
      paramanjc[i] += 1;
    }
    if (paramanjc[0] > paramanjc[1]) {}
    for (int i = 0;; i = 1)
    {
      this.dHF = i;
      return;
    }
  }
  
  private void a(PrintWriter paramPrintWriter)
  {
    int j = 0;
    if (this.dHD != -1)
    {
      paramPrintWriter.println("<branch>");
      paramPrintWriter.print("<attribute name=\"name\" value=\"");
      if (this.b != null) {
        break label93;
      }
      paramPrintWriter.print("root");
    }
    for (;;)
    {
      paramPrintWriter.println("\" />");
      if (this.dHD == -1) {
        break label167;
      }
      int i = j;
      while (i < anjb.dHC)
      {
        if (this.a[i] != null) {
          this.a[i].a(paramPrintWriter);
        }
        i += 1;
      }
      paramPrintWriter.println("<leaf>");
      break;
      label93:
      i = 0;
      while (i < anjb.dHC)
      {
        if (this == this.b.a[i]) {
          paramPrintWriter.print("fts" + this.b.dHD + " = " + i);
        }
        i += 1;
      }
    }
    paramPrintWriter.println("</branch>");
    return;
    label167:
    paramPrintWriter.println("<attribute name=\"weight\" value=\"" + this.Gx.size() + "\" />");
    paramPrintWriter.println("</leaf>");
  }
  
  public void Qz(String paramString)
  {
    try
    {
      paramString = new PrintWriter(new FileWriter(paramString));
      paramString.println("<?xml version=\"1.0\" ?>");
      paramString.println("<tree>");
      paramString.println("<declarations>");
      paramString.println("<attributeDecl name=\"name\" type=\"String\" />");
      paramString.println("<attributeDecl name=\"weight\" type=\"Real\" />");
      paramString.println("</declarations>");
      a(paramString);
      paramString.println("</tree>");
      paramString.close();
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int a(anjb paramanjb)
  {
    int i = -1;
    if (this.dHD == -1) {
      i = this.dHF;
    }
    while (this.a[paramanjb.nE[this.dHD]] == null) {
      return i;
    }
    return this.a[paramanjb.nE[this.dHD]].a(paramanjb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anjc
 * JD-Core Version:    0.7.0.1
 */