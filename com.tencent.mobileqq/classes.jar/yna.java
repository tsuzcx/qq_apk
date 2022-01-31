import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;

public class yna
  extends oxe
{
  public yna(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("rowKey", paramString1);
    localBundle.putString("action", paramString2);
    localBundle.putInt("seq", paramInt);
    localBundle.putString("processName", ymk.a());
    this.a.a(137, localBundle);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("rowKey", paramString1);
      localBundle.putString("commentId", paramString2);
      localBundle.putString("action", paramString3);
      localBundle.putInt("seq", paramInt1);
      localBundle.putInt("totalDeleteCount", paramInt2);
      localBundle.putString("processName", ymk.a());
      this.a.a(136, localBundle);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5)
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
      localBundle.putString("processName", ymk.a());
      this.a.a(134, localBundle);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    if (paramBoolean)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("rowKey", paramString1);
      localBundle.putString("commentId", paramString2);
      localBundle.putString("likeStatus", paramString3);
      localBundle.putString("action", paramString4);
      localBundle.putInt("seq", paramInt);
      localBundle.putString("processName", ymk.a());
      this.a.a(135, localBundle);
    }
  }
  
  public void g(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("seq", paramInt);
    localBundle.putString("processName", ymk.a());
    this.a.a(138, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yna
 * JD-Core Version:    0.7.0.1
 */