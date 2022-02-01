import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class agzm
  extends agzi
{
  private String bJy;
  private int cWz;
  private String mTroopUin;
  
  public agzm(apcy paramapcy)
  {
    this.bJy = paramapcy.FilePath;
    this.cWz = 1;
    this.mTroopUin = String.valueOf(paramapcy.TroopUin);
  }
  
  public String vU()
  {
    if ((TextUtils.isEmpty(this.bJy)) || (TextUtils.isEmpty(this.mTroopUin)))
    {
      QLog.e("TroopFileControlReq<QFile>", 1, "key params is null");
      return "";
    }
    return C(this.cWz + "", this.mTroopUin, this.bJy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agzm
 * JD-Core Version:    0.7.0.1
 */