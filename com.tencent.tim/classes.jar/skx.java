import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;

public class skx
  extends lce
{
  public skx(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void b(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("rowKey", paramString1);
      localBundle.putString("commentId", paramString2);
      localBundle.putString("action", paramString3);
      localBundle.putInt("seq", paramInt1);
      localBundle.putInt("totalDeleteCount", paramInt2);
      localBundle.putString("processName", skj.getCurrentProcessName());
      this.d.j(136, localBundle);
    }
  }
  
  public void b(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5)
  {
    if (paramBoolean)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("rowKey", paramString1);
      localBundle.putString("commentId", paramString2);
      localBundle.putString("commentContent", paramString3);
      localBundle.putInt("commentLevel", paramInt1);
      localBundle.putString("action", paramString4);
      localBundle.putString("parentCommentId", paramString5);
      localBundle.putInt("seq", paramInt2);
      localBundle.putString("processName", skj.getCurrentProcessName());
      this.d.j(134, localBundle);
    }
  }
  
  public void b(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (paramBoolean)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("rowKey", paramString1);
      localBundle.putString("commentId", paramString2);
      localBundle.putString("likeStatus", paramString3);
      localBundle.putString("action", paramString4);
      localBundle.putInt("seq", paramInt);
      localBundle.putString("processName", skj.getCurrentProcessName());
      this.d.j(135, localBundle);
    }
  }
  
  public void j(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("rowKey", paramString1);
    localBundle.putString("action", paramString2);
    localBundle.putInt("seq", paramInt);
    localBundle.putString("processName", skj.getCurrentProcessName());
    this.d.j(137, localBundle);
  }
  
  public void qB(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", paramInt);
    localBundle.putString("processName", skj.getCurrentProcessName());
    this.d.j(138, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     skx
 * JD-Core Version:    0.7.0.1
 */