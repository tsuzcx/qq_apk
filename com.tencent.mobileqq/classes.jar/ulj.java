import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.text.TextUtils;

class ulj
  extends ulp
{
  ulj(ulh paramulh) {}
  
  public void delete()
  {
    if (ulh.a(this.a) != null) {
      TextUtils.backspace(ulh.a(this.a));
    }
  }
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    ulh.a(this.a, paramEmoticonInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulj
 * JD-Core Version:    0.7.0.1
 */