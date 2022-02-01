import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;

public class yts
  extends ytv
{
  public MayKnowRecommend b;
  
  public yts(MayKnowRecommend paramMayKnowRecommend)
  {
    this.b = paramMayKnowRecommend;
    this.Kz = paramMayKnowRecommend.timestamp;
  }
  
  public String getUin()
  {
    return this.b.uin;
  }
  
  public boolean isReaded()
  {
    return true;
  }
  
  public String o(QQAppInterface paramQQAppInterface)
  {
    if (TextUtils.isEmpty(this.message))
    {
      paramQQAppInterface = (achg)paramQQAppInterface.getManager(159);
      if (paramQQAppInterface == null) {
        break label67;
      }
    }
    label67:
    for (boolean bool = paramQQAppInterface.aaC();; bool = false)
    {
      paramQQAppInterface = this.b.getDisplayName(bool);
      this.message = String.format(BaseApplicationImpl.sApplication.getString(2131689913), new Object[] { paramQQAppInterface });
      return this.message;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yts
 * JD-Core Version:    0.7.0.1
 */