import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.GroupBusinessMsg;

public class apsb
{
  public static final String TAG = apsb.class.getName();
  
  public static apsb.a a(MessageRecord paramMessageRecord)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessageRecord != null)
    {
      localObject1 = localObject2;
      if ("1".equals(paramMessageRecord.getExtInfoFromExtStr("troop_msg_has")))
      {
        localObject1 = new apsb.a();
        ((apsb.a)localObject1).flag = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_flag"));
        ((apsb.a)localObject1).headUrl = paramMessageRecord.getExtInfoFromExtStr("troop_msg_head_url");
        ((apsb.a)localObject1).cqX = paramMessageRecord.getExtInfoFromExtStr("troop_msg_head_click_url");
        ((apsb.a)localObject1).nickname = paramMessageRecord.getExtInfoFromExtStr("troop_msg_nickname");
        ((apsb.a)localObject1).cqY = paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_name");
      }
    }
    try
    {
      ((apsb.a)localObject1).dVB = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_nick_color"));
      ((apsb.a)localObject1).dVC = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_color"));
      ((apsb.a)localObject1).dVD = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("troop_msg_rank_bg_color"));
      return localObject1;
    }
    catch (Exception paramMessageRecord)
    {
      QLog.e(TAG, 2, "the color string cannot parse to int. " + paramMessageRecord.getMessage());
    }
    return localObject1;
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, apsb.a parama)
  {
    try
    {
      if (TextUtils.isEmpty(parama.cqX)) {
        return;
      }
      if (parama.cqX.startsWith("http"))
      {
        paramAppInterface = new Intent(paramContext, QQBrowserActivity.class);
        paramAppInterface.putExtra("url", parama.cqX);
        ocp.f(paramAppInterface, parama.cqX);
        paramContext.startActivity(paramAppInterface);
        return;
      }
      if (!parama.cqX.startsWith("mqqapi")) {
        return;
      }
      if ((paramAppInterface instanceof QQAppInterface))
      {
        aqik.c((QQAppInterface)paramAppInterface, paramContext, parama.cqX).ace();
        return;
      }
    }
    catch (Exception paramAppInterface)
    {
      paramAppInterface.printStackTrace();
      return;
    }
    paramContext.startActivity(new Intent(paramContext, JumpActivity.class).setData(Uri.parse(parama.cqX)));
  }
  
  public static void b(MessageRecord paramMessageRecord, apsb.a parama)
  {
    if ((parama == null) || (paramMessageRecord == null)) {
      return;
    }
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_has", "1");
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_flag", String.valueOf(parama.flag));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_head_url", parama.headUrl);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_head_click_url", parama.cqX);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_nickname", parama.nickname);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_nick_color", String.valueOf(parama.dVB));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_name", parama.cqY);
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_color", String.valueOf(parama.dVC));
    paramMessageRecord.saveExtInfoToExtStr("troop_msg_rank_bg_color", String.valueOf(parama.dVD));
  }
  
  public static class a
  {
    public String cqX;
    public String cqY;
    public int dVB;
    public int dVC;
    public int dVD;
    public int flag = 1;
    public String headUrl;
    public String nickname;
    
    public static a a(im_msg_body.GroupBusinessMsg paramGroupBusinessMsg)
    {
      a locala = new a();
      locala.flag = paramGroupBusinessMsg.uint32_flags.get();
      locala.headUrl = paramGroupBusinessMsg.bytes_head_url.get().toStringUtf8();
      locala.cqX = paramGroupBusinessMsg.bytes_head_clk_url.get().toStringUtf8();
      locala.nickname = paramGroupBusinessMsg.bytes_nick.get().toStringUtf8();
      locala.cqY = paramGroupBusinessMsg.bytes_rank.get().toStringUtf8();
      try
      {
        locala.dVB = Color.parseColor(paramGroupBusinessMsg.bytes_nick_color.get().toStringUtf8());
        locala.dVC = Color.parseColor(paramGroupBusinessMsg.bytes_rank_color.get().toStringUtf8());
        locala.dVD = Color.parseColor(paramGroupBusinessMsg.bytes_rank_bgcolor.get().toStringUtf8());
        return locala;
      }
      catch (Exception paramGroupBusinessMsg)
      {
        QLog.e(apsb.TAG, 2, "the color string cannot parse to color. " + paramGroupBusinessMsg.getMessage());
      }
      return locala;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TroopBusinessMessage");
      localStringBuilder.append(",").append("nick").append("=").append(this.nickname);
      localStringBuilder.append(",").append("flag").append("=").append(this.flag);
      localStringBuilder.append(",").append("clk").append("=").append(this.cqX);
      localStringBuilder.append(",").append("head").append("=").append(this.headUrl);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apsb
 * JD-Core Version:    0.7.0.1
 */