import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import org.xmlpull.v1.XmlSerializer;

public class anqy
  implements XmlSerializer
{
  private BufferedWriter a;
  private int auto;
  private boolean cJJ;
  private boolean cJK;
  private int depth;
  private String encoding;
  private String[] hd = new String[12];
  private String[] he = new String[8];
  private int[] oh = new int[4];
  private boolean[] v = new boolean[4];
  
  private final String b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    int i = this.oh[(this.depth + 1)] * 2 - 2;
    Object localObject;
    int j;
    if (i >= 0) {
      if ((this.he[(i + 1)].equals(paramString)) && ((paramBoolean1) || (this.he[i].length() != 0)))
      {
        localObject = this.he[i];
        j = i + 2;
        label70:
        if (j >= this.oh[(this.depth + 1)] * 2) {
          break label275;
        }
        if (this.he[j].equals(localObject)) {
          localObject = null;
        }
      }
    }
    label275:
    for (;;)
    {
      if (localObject != null)
      {
        return localObject;
        j += 1;
        break label70;
      }
      i -= 2;
      break;
      if (!paramBoolean2) {
        return null;
      }
      if (paramString.length() == 0)
      {
        localObject = "";
        paramBoolean1 = this.cJJ;
        this.cJJ = false;
        setPrefix((String)localObject, paramString);
        this.cJJ = paramBoolean1;
        return localObject;
      }
      label174:
      localObject = new StringBuilder().append("n");
      i = this.auto;
      this.auto = (i + 1);
      String str = i;
      i = this.oh[(this.depth + 1)] * 2 - 2;
      for (;;)
      {
        localObject = str;
        if (i >= 0)
        {
          if (str.equals(this.he[i])) {
            localObject = null;
          }
        }
        else
        {
          if (localObject == null) {
            break label174;
          }
          break;
        }
        i -= 2;
      }
    }
  }
  
  private final void check(boolean paramBoolean)
    throws IOException
  {
    if (!this.cJJ) {
      return;
    }
    this.depth += 1;
    this.cJJ = false;
    if (this.v.length <= this.depth)
    {
      localObject = new boolean[this.depth + 4];
      System.arraycopy(this.v, 0, localObject, 0, this.depth);
      this.v = ((boolean[])localObject);
    }
    this.v[this.depth] = this.v[(this.depth - 1)];
    int i = this.oh[(this.depth - 1)];
    if (i < this.oh[this.depth])
    {
      this.a.write(32);
      this.a.write("xmlns");
      if (this.he[(i * 2)].length() != 0)
      {
        this.a.write(58);
        this.a.write(this.he[(i * 2)]);
      }
      while ((getNamespace() == null) || (getNamespace().length() != 0) || (this.he[(i * 2 + 1)].length() == 0))
      {
        this.a.write("=\"");
        fZ(this.he[(i * 2 + 1)], 34);
        this.a.write(34);
        i += 1;
        break;
      }
      throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
    }
    if (this.oh.length <= this.depth + 1)
    {
      localObject = new int[this.depth + 8];
      System.arraycopy(this.oh, 0, localObject, 0, this.depth + 1);
      this.oh = ((int[])localObject);
    }
    this.oh[(this.depth + 1)] = this.oh[this.depth];
    BufferedWriter localBufferedWriter = this.a;
    if (paramBoolean) {}
    for (Object localObject = " />";; localObject = ">")
    {
      localBufferedWriter.write((String)localObject);
      return;
    }
  }
  
  private static void d(char paramChar)
  {
    throw new IllegalArgumentException("Illegal character (" + Integer.toHexString(paramChar) + ")");
  }
  
  private final void fZ(String paramString, int paramInt)
    throws IOException
  {
    int i = 0;
    if (i < paramString.length())
    {
      int k = paramString.charAt(i);
      String str;
      switch (k)
      {
      default: 
        if (k == paramInt)
        {
          BufferedWriter localBufferedWriter = this.a;
          if (k == 34)
          {
            str = "&quot;";
            label99:
            localBufferedWriter.write(str);
          }
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramInt == -1)
        {
          this.a.write(k);
        }
        else
        {
          this.a.write("&#" + k + ';');
          continue;
          this.a.write("&amp;");
          continue;
          this.a.write("&gt;");
          continue;
          this.a.write("&lt;");
          continue;
          str = "&apos;";
          break label99;
          if (((k >= 32) && (k <= 55295)) || ((k >= 57344) && (k <= 65533))) {}
          for (int j = 1;; j = 0)
          {
            if ((j == 0) && ((!this.cJK) && (k >= 127))) {
              break label276;
            }
            this.a.write(k);
            break;
          }
          label276:
          this.a.write("&#" + k + ";");
        }
      }
    }
  }
  
  public XmlSerializer attribute(String paramString1, String paramString2, String paramString3)
    throws IOException
  {
    if (!this.cJJ) {
      throw new IllegalStateException("illegal position for attribute");
    }
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    if (str.length() == 0)
    {
      paramString1 = "";
      this.a.write(32);
      if (paramString1.length() != 0)
      {
        this.a.write(paramString1);
        this.a.write(58);
      }
      this.a.write(paramString2);
      this.a.write(61);
      if (paramString3.indexOf('"') != -1) {
        break label142;
      }
    }
    label142:
    for (int i = 34;; i = 39)
    {
      this.a.write(i);
      fZ(paramString3, i);
      this.a.write(i);
      return this;
      paramString1 = b(str, false, true);
      break;
    }
  }
  
  public void cdsect(String paramString)
    throws IOException
  {
    check(false);
    paramString = paramString.replace("]]>", "]]]]><![CDATA[>").toCharArray();
    int m = paramString.length;
    int j = 0;
    if (j < m)
    {
      int i = paramString[j];
      if (((i >= 32) && (i <= 55295)) || (i == 9) || (i == 10) || (i == 13) || ((i >= 57344) && (i <= 65533))) {}
      for (int k = 1;; k = 0)
      {
        if (k == 0) {
          d(i);
        }
        j += 1;
        break;
      }
    }
    this.a.write("<![CDATA[");
    this.a.write(paramString, 0, paramString.length);
    this.a.write("]]>");
  }
  
  public void comment(String paramString)
    throws IOException
  {
    check(false);
    this.a.write("<!--");
    this.a.write(paramString);
    this.a.write("-->");
  }
  
  public void docdecl(String paramString)
    throws IOException
  {
    this.a.write("<!DOCTYPE");
    this.a.write(paramString);
    this.a.write(">");
  }
  
  public void endDocument()
    throws IOException
  {
    while (this.depth > 0) {
      endTag(this.hd[(this.depth * 3 - 3)], this.hd[(this.depth * 3 - 1)]);
    }
    flush();
  }
  
  public XmlSerializer endTag(String paramString1, String paramString2)
    throws IOException
  {
    if (!this.cJJ) {
      this.depth -= 1;
    }
    if (((paramString1 == null) && (this.hd[(this.depth * 3)] != null)) || ((paramString1 != null) && (!paramString1.equals(this.hd[(this.depth * 3)]))) || (!this.hd[(this.depth * 3 + 2)].equals(paramString2))) {
      throw new IllegalArgumentException("</{" + paramString1 + "}" + paramString2 + "> does not match start");
    }
    if (this.cJJ)
    {
      check(true);
      this.depth -= 1;
    }
    for (;;)
    {
      this.oh[(this.depth + 1)] = this.oh[this.depth];
      return this;
      if (this.v[(this.depth + 1)] != 0)
      {
        this.a.write("\r\n");
        int i = 0;
        while (i < this.depth)
        {
          this.a.write("  ");
          i += 1;
        }
      }
      this.a.write("</");
      paramString1 = this.hd[(this.depth * 3 + 1)];
      if (paramString1.length() != 0)
      {
        this.a.write(paramString1);
        this.a.write(58);
      }
      this.a.write(paramString2);
      this.a.write(62);
    }
  }
  
  public void entityRef(String paramString)
    throws IOException
  {
    check(false);
    this.a.write(38);
    this.a.write(paramString);
    this.a.write(59);
  }
  
  public void flush()
    throws IOException
  {
    check(false);
    this.a.flush();
  }
  
  public int getDepth()
  {
    if (this.cJJ) {
      return this.depth + 1;
    }
    return this.depth;
  }
  
  public boolean getFeature(String paramString)
  {
    if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(paramString)) {
      return this.v[this.depth];
    }
    return false;
  }
  
  public String getName()
  {
    if (getDepth() == 0) {
      return null;
    }
    return this.hd[(getDepth() * 3 - 1)];
  }
  
  public String getNamespace()
  {
    if (getDepth() == 0) {
      return null;
    }
    return this.hd[(getDepth() * 3 - 3)];
  }
  
  public String getPrefix(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = b(paramString, false, paramBoolean);
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new RuntimeException(paramString.toString());
    }
  }
  
  public Object getProperty(String paramString)
  {
    throw new RuntimeException("Unsupported property");
  }
  
  public void ignorableWhitespace(String paramString)
    throws IOException
  {
    text(paramString);
  }
  
  public void processingInstruction(String paramString)
    throws IOException
  {
    check(false);
    this.a.write("<?");
    this.a.write(paramString);
    this.a.write("?>");
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
  {
    if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(paramString))
    {
      this.v[this.depth] = paramBoolean;
      return;
    }
    throw new RuntimeException("Unsupported Feature");
  }
  
  public void setOutput(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("os == null");
    }
    if (paramString == null) {}
    for (paramOutputStream = new OutputStreamWriter(paramOutputStream);; paramOutputStream = new OutputStreamWriter(paramOutputStream, paramString))
    {
      setOutput(paramOutputStream);
      this.encoding = paramString;
      if ((paramString != null) && (paramString.toLowerCase(Locale.US).startsWith("utf"))) {
        this.cJK = true;
      }
      return;
    }
  }
  
  public void setOutput(Writer paramWriter)
  {
    if ((paramWriter instanceof BufferedWriter)) {}
    for (this.a = ((BufferedWriter)paramWriter);; this.a = new BufferedWriter(paramWriter, 500))
    {
      this.oh[0] = 2;
      this.oh[1] = 2;
      this.he[0] = "";
      this.he[1] = "";
      this.he[2] = "xml";
      this.he[3] = "https://www.w3.org/XML/1998/namespace";
      this.cJJ = false;
      this.auto = 0;
      this.depth = 0;
      this.cJK = false;
      return;
    }
  }
  
  public void setPrefix(String paramString1, String paramString2)
    throws IOException
  {
    check(false);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    if (str.equals(b(paramString1, true, false))) {
      return;
    }
    paramString2 = this.oh;
    int i = this.depth + 1;
    int j = paramString2[i];
    paramString2[i] = (j + 1);
    i = j << 1;
    if (this.he.length < i + 1)
    {
      paramString2 = new String[this.he.length + 16];
      System.arraycopy(this.he, 0, paramString2, 0, i);
      this.he = paramString2;
    }
    this.he[i] = str;
    this.he[(i + 1)] = paramString1;
  }
  
  public void setProperty(String paramString, Object paramObject)
  {
    throw new RuntimeException("Unsupported Property:" + paramObject);
  }
  
  public void startDocument(String paramString, Boolean paramBoolean)
    throws IOException
  {
    this.a.write("<?xml version='1.0' ");
    if (paramString != null)
    {
      this.encoding = paramString;
      if (paramString.toLowerCase(Locale.US).startsWith("utf")) {
        this.cJK = true;
      }
    }
    if (this.encoding != null)
    {
      this.a.write("encoding='");
      this.a.write(this.encoding);
      this.a.write("' ");
    }
    BufferedWriter localBufferedWriter;
    if (paramBoolean != null)
    {
      this.a.write("standalone='");
      localBufferedWriter = this.a;
      if (!paramBoolean.booleanValue()) {
        break label133;
      }
    }
    label133:
    for (paramString = "yes";; paramString = "no")
    {
      localBufferedWriter.write(paramString);
      this.a.write("' ");
      this.a.write("?>");
      return;
    }
  }
  
  public XmlSerializer startTag(String paramString1, String paramString2)
    throws IOException
  {
    check(false);
    if (this.v[this.depth] != 0)
    {
      this.a.write("\r\n");
      i = 0;
      while (i < this.depth)
      {
        this.a.write("  ");
        i += 1;
      }
    }
    int j = this.depth * 3;
    Object localObject;
    if (this.hd.length < j + 3)
    {
      localObject = new String[this.hd.length + 12];
      System.arraycopy(this.hd, 0, localObject, 0, j);
      this.hd = ((String[])localObject);
    }
    if (paramString1 == null)
    {
      localObject = "";
      if ((paramString1 != null) && (paramString1.length() == 0)) {
        i = this.oh[this.depth];
      }
    }
    else
    {
      for (;;)
      {
        if (i >= this.oh[(this.depth + 1)]) {
          break label207;
        }
        if ((this.he[(i * 2)].length() == 0) && (this.he[(i * 2 + 1)].length() != 0))
        {
          throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
          localObject = b(paramString1, true, true);
          break;
        }
        i += 1;
      }
    }
    label207:
    String[] arrayOfString = this.hd;
    int i = j + 1;
    arrayOfString[j] = paramString1;
    this.hd[i] = localObject;
    this.hd[(i + 1)] = paramString2;
    this.a.write(60);
    if (((String)localObject).length() != 0)
    {
      this.a.write((String)localObject);
      this.a.write(58);
    }
    this.a.write(paramString2);
    this.cJJ = true;
    return this;
  }
  
  public XmlSerializer text(String paramString)
    throws IOException
  {
    check(false);
    this.v[this.depth] = false;
    fZ(paramString, -1);
    return this;
  }
  
  public XmlSerializer text(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    text(new String(paramArrayOfChar, paramInt1, paramInt2));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anqy
 * JD-Core Version:    0.7.0.1
 */