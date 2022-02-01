import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class apfl
  extends apfa
{
  protected long arq = 2000L;
  protected boolean cQk;
  protected boolean cQl;
  
  protected apfl(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    super(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramList, paramString2, paramString3, paramBoolean2, paramString4);
    this.cQk = paramBoolean1;
  }
  
  public static apfl a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, List<String> paramList, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    String str = "";
    if (paramString1 == null) {
      str = "strSavePath is null";
    }
    while (!TextUtils.isEmpty(str))
    {
      apef.b.e("TroopFileThumbDownloader", apef.b.USR, "getFileDownloader " + str);
      return null;
      if (paramString1.length() == 0) {
        str = "strSavePath is empty";
      } else if (paramList == null) {
        str = "lstUrl is null";
      } else if (paramList.size() == 0) {
        str = "lstUrl is empty";
      } else if (paramString2 == null) {
        str = "urlParams is null";
      } else if (paramString2.length() == 0) {
        str = "urlParams is empty";
      }
    }
    return new apfl(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramList, paramString2, paramString3, paramBoolean1, paramBoolean2, paramString4);
  }
  
  public void RA(boolean paramBoolean)
  {
    this.cQi = paramBoolean;
  }
  
  public void RB(boolean paramBoolean)
  {
    this.cQl = paramBoolean;
  }
  
  public void dYS()
  {
    this.jdField_a_of_type_Apee.dYS();
  }
  
  public void e(aqog paramaqog)
  {
    int k = 0;
    if (!this.cQk) {
      break label10;
    }
    label10:
    while (this.cQl) {
      return;
    }
    paramaqog = paramaqog.pK("Set-Cookie");
    i = k;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramaqog))
        {
          i = k;
          if (paramaqog.contains("duration"))
          {
            paramaqog = paramaqog.trim().split(";");
            i = k;
            if (paramaqog != null)
            {
              i = k;
              if (paramaqog.length > 0)
              {
                j = 0;
                i = k;
                if (j < paramaqog.length)
                {
                  String[] arrayOfString = paramaqog[j].split("=");
                  if ((arrayOfString == null) || (arrayOfString.length != 2) || (!"duration".equals(arrayOfString[0]))) {
                    continue;
                  }
                  i = Integer.parseInt(arrayOfString[1]);
                }
              }
            }
          }
        }
      }
      catch (Exception paramaqog)
      {
        int j;
        i = 0;
        continue;
      }
      if ((i == 0) || (this.jdField_a_of_type_Apev == null) || (!(this.jdField_a_of_type_Apev instanceof apfl.a))) {
        break;
      }
      ((apfl.a)this.jdField_a_of_type_Apev).WF(i);
      return;
      j += 1;
    }
  }
  
  public long hq()
  {
    if (this.arq <= 6000L)
    {
      long l = this.arq;
      this.arq = (2000L + this.arq);
      return l;
    }
    return 2000L;
  }
  
  public static abstract interface a
    extends apev
  {
    public abstract void WF(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apfl
 * JD-Core Version:    0.7.0.1
 */