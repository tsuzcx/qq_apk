import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.text.TextUtils;

class uzj
  extends uzp
{
  uzj(uzh paramuzh) {}
  
  public void delete()
  {
    if (uzh.a(this.a) != null) {
      TextUtils.backspace(uzh.a(this.a));
    }
  }
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    uzh.a(this.a, paramEmoticonInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uzj
 * JD-Core Version:    0.7.0.1
 */