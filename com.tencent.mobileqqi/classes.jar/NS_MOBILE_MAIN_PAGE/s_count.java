package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_count
  extends JceStruct
{
  public int blog_allnum = 0;
  public int message_allnum = 0;
  public int pic_allnum = 0;
  public int shuoshuo_allnum = 0;
  
  public s_count() {}
  
  public s_count(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.pic_allnum = paramInt1;
    this.blog_allnum = paramInt2;
    this.shuoshuo_allnum = paramInt3;
    this.message_allnum = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.pic_allnum = paramJceInputStream.read(this.pic_allnum, 0, false);
    this.blog_allnum = paramJceInputStream.read(this.blog_allnum, 1, false);
    this.shuoshuo_allnum = paramJceInputStream.read(this.shuoshuo_allnum, 2, false);
    this.message_allnum = paramJceInputStream.read(this.message_allnum, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.pic_allnum, 0);
    paramJceOutputStream.write(this.blog_allnum, 1);
    paramJceOutputStream.write(this.shuoshuo_allnum, 2);
    paramJceOutputStream.write(this.message_allnum, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_count
 * JD-Core Version:    0.7.0.1
 */