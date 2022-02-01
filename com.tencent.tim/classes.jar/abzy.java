import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;

public class abzy
{
  public String bkj;
  public ApolloActionData c;
  public int cre;
  public int cud;
  public int cue;
  public int cuf;
  public int drawableId;
  public int iconType;
  public int mBinderType;
  public int mType;
  public String mUin;
  public float sC;
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    return aofy.i(paramContext.getResources(), this.drawableId);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo) {}
  
  public String toString()
  {
    if (this.c != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("[");
      localStringBuilder.append("id: ").append(this.c.actionId).append(", name: ").append(this.c.actionName).append(", peerUin: ").append(this.c.peerUin).append(", peopleNum: ").append(this.c.personNum).append(", feeType: ").append(this.c.feeType).append(", inputText: ").append(this.c.inputText).append(",actionText: ").append(this.bkj).append(",textType: ").append(this.cue).append("]");
      return localStringBuilder.toString();
    }
    return "ApolloActionData is null";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abzy
 * JD-Core Version:    0.7.0.1
 */