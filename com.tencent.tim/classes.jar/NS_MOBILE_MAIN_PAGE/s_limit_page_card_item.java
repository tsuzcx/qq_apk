package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_limit_page_card_item
  extends JceStruct
{
  public String img = "";
  public String text = "";
  
  public s_limit_page_card_item() {}
  
  public s_limit_page_card_item(String paramString1, String paramString2)
  {
    this.img = paramString1;
    this.text = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.img = paramJceInputStream.readString(0, true);
    this.text = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.img, 0);
    paramJceOutputStream.write(this.text, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.s_limit_page_card_item
 * JD-Core Version:    0.7.0.1
 */