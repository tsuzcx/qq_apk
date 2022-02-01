import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.text.TextUtils;

class xxe
  implements EmoticonCallback
{
  xxe(xxc paramxxc) {}
  
  public void delete()
  {
    if (xxc.a(this.a) != null) {
      TextUtils.backspace(xxc.a(this.a));
    }
  }
  
  public void emoticonMall() {}
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void send() {}
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    if (((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) && (xxc.a(this.a) != null)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).send(xxc.a(), xxc.a(this.a), xxc.a(this.a), null);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxe
 * JD-Core Version:    0.7.0.1
 */