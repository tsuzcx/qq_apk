import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;

public class afmi
  extends afom
{
  public String action;
  public String bEa;
  public int drawableId;
  public int emoId;
  public boolean isChecked;
  public int operateType = 0;
  public int src_type;
  public EmojiStickerManager.StickerInfo stickerInfo;
  public int type = -1;
  
  public Drawable a(Context paramContext, float paramFloat, int paramInt1, int paramInt2)
  {
    return aofy.i(paramContext.getResources(), this.drawableId);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo) {}
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    return aofy.i(paramContext.getResources(), this.drawableId);
  }
  
  public Drawable c(Context paramContext, float paramFloat)
  {
    return b(paramContext, paramFloat);
  }
  
  @NonNull
  public String toString()
  {
    return "EmoticonInfo[type: " + this.type + "  action: " + this.action + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afmi
 * JD-Core Version:    0.7.0.1
 */