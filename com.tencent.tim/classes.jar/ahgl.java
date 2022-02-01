import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ahgl
  extends ahgq
{
  public ahgl(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  protected boolean ank()
  {
    int i = this.bf.getInt("uintype");
    return i(this.bf.getString("uin"), i, this.bf.getString("troop_uin"));
  }
  
  protected boolean anl()
  {
    if (anq())
    {
      Iterator localIterator = fg().iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        i(localResultRecord.uin, localResultRecord.lk(), localResultRecord.QD);
      }
      return super.anl();
    }
    ank();
    return super.anl();
  }
  
  protected void dnr()
  {
    if (anv()) {
      this.cs.add(U);
    }
    if (anw()) {
      this.cs.add(T);
    }
    if (anx()) {
      this.cs.add(S);
    }
  }
  
  protected boolean i(String paramString1, int paramInt, String paramString2)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.cZ = paramInt;
    localSessionInfo.aTl = paramString1;
    localSessionInfo.troopUin = paramString2;
    paramString1 = this.bf.getString("forward_flashchat_rawcontent");
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    paramString2 = new ArkFlashChatMessage();
    paramString2.fromAppXml(paramString1);
    paramInt = this.bf.getInt("KEY_MSG_FORWARD_ID");
    ujt.a(this.app, localSessionInfo, paramString2, paramInt);
    return true;
  }
  
  public String wn()
  {
    if (TextUtils.isEmpty(this.bKu))
    {
      this.bKu = this.bf.getString("forward_ark_app_prompt");
      if (TextUtils.isEmpty(this.bKu)) {
        this.bKu = this.bf.getString("forward_ark_app_desc");
      }
    }
    return this.bKu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahgl
 * JD-Core Version:    0.7.0.1
 */