import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class aoii
  implements Cloneable
{
  public long apd;
  public long ape;
  public String ckN = "";
  public String ckO = "";
  @Nullable
  public String creatorNick;
  public int dOD = -1;
  public int dOE;
  public int dOF = 0;
  public int deR;
  public int serviceType;
  public int status;
  public long timeStamp;
  public int type;
  public String uin = "";
  public int videoType;
  
  public String a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    return "";
  }
  
  public String h(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return aqgv.h(paramQQAppInterface, paramString1, paramString2);
  }
  
  public boolean isValid()
  {
    return ((this.type == 2) || (this.type == 1)) && (!TextUtils.isEmpty(this.uin));
  }
  
  public String p(QQAppInterface paramQQAppInterface, String paramString)
  {
    return aqgv.p(paramQQAppInterface, paramString);
  }
  
  public String v(QQAppInterface paramQQAppInterface)
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoii
 * JD-Core Version:    0.7.0.1
 */