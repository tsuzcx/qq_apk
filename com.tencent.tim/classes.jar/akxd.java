import android.content.Intent;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.CompressInfo;
import java.util.ArrayList;

public abstract interface akxd
{
  public abstract akxm a(Intent paramIntent);
  
  public abstract akxm a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3);
  
  public abstract akxy a(Intent paramIntent);
  
  public abstract CompressInfo a(Intent paramIntent);
  
  public abstract ArrayList<akxm> a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt, String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akxd
 * JD-Core Version:    0.7.0.1
 */