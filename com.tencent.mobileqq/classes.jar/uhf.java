import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;

public class uhf
{
  public static boolean a(QQUserUIItem paramQQUserUIItem)
  {
    return (paramQQUserUIItem != null) && (paramQQUserUIItem.isVip()) && (!paramQQUserUIItem.isMe()) && (!paramQQUserUIItem.isFriend()) && (!paramQQUserUIItem.isSubscribe());
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.equals("0_1000", paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhf
 * JD-Core Version:    0.7.0.1
 */