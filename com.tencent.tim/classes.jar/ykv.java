import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;

public class ykv
{
  public ykw a;
  public String aYv;
  public String aYw;
  @Nullable
  public yla.a b;
  public int bZJ;
  public boolean bnc;
  public boolean bnd;
  public boolean bne;
  @Nullable
  public Drawable drawable;
  @Nullable
  public Drawable ea;
  public String gJ;
  public boolean isChecked;
  public boolean isGif;
  public String path;
  public String pic_md5;
  public String uploadUrl;
  public String url;
  
  public void k(ykv paramykv)
  {
    this.url = paramykv.url;
    this.path = paramykv.path;
    this.gJ = paramykv.gJ;
    this.pic_md5 = paramykv.pic_md5;
    this.bZJ = paramykv.bZJ;
    this.aYv = paramykv.aYv;
    this.drawable = paramykv.drawable;
    this.isGif = paramykv.isGif;
    this.a = paramykv.a;
    this.b = paramykv.b;
    this.bnc = paramykv.bnc;
    this.isChecked = paramykv.isChecked;
    this.bne = paramykv.bne;
    this.ea = paramykv.ea;
  }
  
  public String toString()
  {
    return "ZhituPicData{url='" + this.url + '\'' + ", path='" + this.path + '\'' + ", originPath='" + this.gJ + '\'' + ", drawTextParam=" + this.b + ", inCache=" + this.bnc + ", reqKey='" + this.aYv + '\'' + ", idxInRes=" + this.bZJ + ", pic_md5='" + this.pic_md5 + '\'' + ", drawable=" + this.drawable + ", originDrawable=" + this.ea + ", isGif=" + this.isGif + ", reportData=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ykv
 * JD-Core Version:    0.7.0.1
 */