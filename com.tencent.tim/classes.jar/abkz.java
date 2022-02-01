import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class abkz
  extends abkx
{
  public int actionId;
  public int bubbleId;
  public String content = "";
  public int cpA;
  public int cpB;
  int cpC = 7;
  public int cpz;
  public WeakReference<QQSettingMe> fz;
  public String iconUrl;
  public String jumpUrl = "";
  public String scheme;
  public long seq;
  private int showCount;
  
  public abkz(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject, QQSettingMe paramQQSettingMe)
  {
    super(paramQQAppInterface);
    this.priority = 98;
    this.cpz = paramJSONObject.optInt("entry_id", 1);
    this.seq = paramJSONObject.optLong("seq", 0L);
    this.content = paramJSONObject.optString("wording");
    this.jumpUrl = paramJSONObject.optString("jump_url");
    this.cpA = paramJSONObject.optInt("is_red", 0);
    this.iconUrl = paramJSONObject.optString("icon_url");
    this.actionId = paramJSONObject.optInt("action_id", 0);
    this.bubbleId = paramJSONObject.optInt("bubble_id", 0);
    this.scheme = paramJSONObject.optString("scheme");
    this.cpB = paramJSONObject.optInt("show_sum", 1);
    this.fz = new WeakReference(paramQQSettingMe);
  }
  
  public void b(abrs paramabrs, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.showCount >= this.cpB) {}
    do
    {
      do
      {
        return;
        this.showCount += 1;
        if (!TextUtils.isEmpty(this.content)) {
          abrj.a(paramabrs, this.content, 9, this.bubbleId);
        }
      } while ((TextUtils.isEmpty(this.iconUrl)) || (this.fz == null));
      paramabrs = (QQSettingMe)this.fz.get();
    } while (paramabrs == null);
    paramabrs.wc(this.iconUrl);
  }
  
  public void c(abrs paramabrs, Context paramContext, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExploreDrawerStatus", 2, "[onBubbleClick] " + this.scheme + "|" + this.jumpUrl);
    }
    ((abhh)paramQQAppInterface.getManager(153)).b(paramQQAppInterface, paramContext, this.scheme, this.jumpUrl, "drawer");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abkz
 * JD-Core Version:    0.7.0.1
 */