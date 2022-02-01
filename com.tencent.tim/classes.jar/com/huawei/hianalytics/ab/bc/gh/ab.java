package com.huawei.hianalytics.ab.bc.gh;

import android.content.Context;
import com.huawei.hianalytics.ab.bc.ab.bc.ab;
import com.huawei.hianalytics.ab.bc.kl.de;
import java.io.File;
import java.io.IOException;

public class ab
{
  private String ab = com.huawei.hianalytics.ab.ab.bc.ik().getFilesDir().getPath();
  
  private String ab(String paramString)
  {
    paramString = new File(bc(paramString), "hianalytics_" + paramString);
    if (ab(paramString)) {
      return de.ab(paramString);
    }
    String str = com.huawei.hianalytics.ab.bc.ab.bc.ab().bc(bc.ab.bc);
    de.ab(paramString, str);
    return str;
  }
  
  private void ab(String paramString1, String paramString2)
  {
    File localFile = new File(bc(paramString1));
    paramString1 = new File(bc(paramString1), "hianalytics_" + paramString1);
    if ((!localFile.exists()) && (localFile.mkdirs())) {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("ComponentManager", "file directory is mkdirs");
    }
    if (ab(paramString1))
    {
      de.ab(paramString1, paramString2);
      return;
    }
    com.huawei.hianalytics.ab.bc.ef.ab.cd("ComponentManager", "refreshComponent():file is not found,and file is create failed");
  }
  
  private boolean ab(File paramFile)
  {
    if (paramFile.exists()) {
      return true;
    }
    try
    {
      boolean bool = paramFile.createNewFile();
      return bool;
    }
    catch (IOException paramFile)
    {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("ComponentManager", "create new file error!");
    }
    return false;
  }
  
  private char[] ab(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString1 = com.huawei.hianalytics.ab.bc.ab.bc.ab().bc(paramString1);
    paramString2 = com.huawei.hianalytics.ab.bc.ab.bc.ab().bc(paramString2);
    paramString3 = com.huawei.hianalytics.ab.bc.ab.bc.ab().bc(paramString3);
    paramString4 = com.huawei.hianalytics.ab.bc.ab.bc.ab().bc(paramString4);
    int j = paramString1.length;
    int i = j;
    if (j > paramString2.length) {
      i = paramString2.length;
    }
    j = i;
    if (i > paramString3.length) {
      j = paramString3.length;
    }
    i = j;
    if (j > paramString4.length) {
      i = paramString4.length;
    }
    char[] arrayOfChar = new char[i];
    j = 0;
    while (j < i)
    {
      arrayOfChar[j] = ((char)(paramString1[j] ^ paramString2[j] ^ paramString3[j] ^ paramString4[j]));
      j += 1;
    }
    return arrayOfChar;
  }
  
  private String bc(String paramString)
  {
    return this.ab + "/hms/component/".replace("component", paramString);
  }
  
  private boolean bc()
  {
    long l = com.huawei.hianalytics.ab.bc.ij.ab.bc(com.huawei.hianalytics.ab.ab.bc.ik(), "Privacy_MY", "assemblyFlash", -1L);
    if (-1L == l) {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("ComponentManager", "First init components");
    }
    while (System.currentTimeMillis() - l > 31536000000L) {
      return true;
    }
    return false;
  }
  
  private String cd()
  {
    return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
  }
  
  public String ab()
  {
    String str3 = cd();
    String str2;
    String str1;
    Object localObject2;
    Object localObject1;
    if (bc())
    {
      com.huawei.hianalytics.ab.bc.ef.ab.bc("ComponentManager", "refresh components");
      str2 = com.huawei.hianalytics.ab.bc.ab.bc.ab().bc(bc.ab.bc);
      ab("aprpap", str2);
      str1 = com.huawei.hianalytics.ab.bc.ab.bc.ab().bc(bc.ab.bc);
      ab("febdoc", str1);
      localObject2 = com.huawei.hianalytics.ab.bc.ab.bc.ab().bc(bc.ab.bc);
      ab("marfil", (String)localObject2);
      localObject1 = com.huawei.hianalytics.ab.bc.ab.bc.ab().bc(bc.ab.bc);
      ab("maywnj", (String)localObject1);
      com.huawei.hianalytics.ab.bc.ij.ab.ab(com.huawei.hianalytics.ab.ab.bc.ik(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
    }
    for (;;)
    {
      localObject2 = ab(str2, str1, (String)localObject2, str3);
      localObject1 = com.huawei.hianalytics.ab.bc.ab.bc.ab().bc((String)localObject1);
      return com.huawei.hianalytics.ab.bc.ab.bc.ab().ab((char[])localObject2, (byte[])localObject1);
      str2 = ab("aprpap");
      str1 = ab("febdoc");
      localObject2 = ab("marfil");
      localObject1 = ab("maywnj");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.gh.ab
 * JD-Core Version:    0.7.0.1
 */