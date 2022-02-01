import android.text.TextUtils;
import com.tencent.mobileqq.comment.DanmuItemBean;

public class aefd
{
  public long VT;
  public long VU;
  public boolean bTz;
  public String bwD;
  public int cMq;
  public String comment;
  public long createTime;
  public String nickName;
  public String uin;
  
  public aefd(DanmuItemBean paramDanmuItemBean)
  {
    this.VT = paramDanmuItemBean.VT;
    this.uin = String.valueOf(paramDanmuItemBean.VS);
    this.nickName = paramDanmuItemBean.nickName;
    this.comment = paramDanmuItemBean.content;
    this.createTime = paramDanmuItemBean.createTime;
    this.VU = paramDanmuItemBean.VU;
    this.bTz = paramDanmuItemBean.bTv;
    this.bwD = paramDanmuItemBean.bwD;
    this.cMq = paramDanmuItemBean.cMq;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof aefd))
    {
      paramObject = (aefd)paramObject;
      bool1 = bool2;
      if (this.VT == paramObject.VT)
      {
        bool1 = bool2;
        if (this.createTime == paramObject.createTime)
        {
          bool1 = bool2;
          if (this.VU == paramObject.VU)
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(this.uin))
            {
              bool1 = bool2;
              if (!TextUtils.isEmpty(paramObject.uin))
              {
                bool1 = bool2;
                if (this.uin.equals(paramObject.uin)) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return String.valueOf(this.VT).hashCode();
  }
  
  public String td()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.bTz) {}
    for (String str = this.bwD;; str = this.nickName) {
      return str + " : " + this.comment;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aefd
 * JD-Core Version:    0.7.0.1
 */