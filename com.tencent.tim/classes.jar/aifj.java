import android.content.Intent;
import com.tencent.mobileqq.intervideo.now.ShareToQQActivity;

public class aifj
  extends acfd
{
  public aifj(ShareToQQActivity paramShareToQQActivity) {}
  
  protected void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if ((paramLong != 0L) && (this.a.bNE != null) && (this.a.bNE.equals(paramLong + "")))
    {
      paramString = new Intent();
      paramString.putExtra("isSuccess", paramBoolean2);
      paramString.putExtra("isCancelShield", false);
      this.a.setResult(-1, paramString);
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aifj
 * JD-Core Version:    0.7.0.1
 */