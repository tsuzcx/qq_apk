import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class wfd
{
  public int a;
  public List<QQUserUIItem> a;
  public List<Long> b;
  
  public wfd(AppInterface paramAppInterface, qqstory_struct.VideoReaderConf paramVideoReaderConf)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Int = paramVideoReaderConf.ban_type.get();
    List localList = paramVideoReaderConf.user_list.get();
    paramVideoReaderConf = paramVideoReaderConf.user_unionid_list.get();
    wpy localwpy = (wpy)wpm.a(2);
    if ((localList != null) && (!localList.isEmpty()) && (paramVideoReaderConf != null) && (!paramVideoReaderConf.isEmpty()) && (localList.size() == paramVideoReaderConf.size()))
    {
      int j = localList.size();
      this.jdField_a_of_type_JavaUtilList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        String str = String.valueOf(localList.get(i));
        Object localObject = ((ByteStringMicro)paramVideoReaderConf.get(i)).toStringUtf8();
        localwpy.a((String)localObject, str);
        localObject = a(paramAppInterface, (String)localObject, str, false);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilList.add(localObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "StoryPlayVideoPrivacyActivity " + i + ": qq = " + str + ", user = " + localObject);
        }
        i += 1;
      }
    }
  }
  
  private static QQUserUIItem a(AppInterface paramAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    QQUserUIItem localQQUserUIItem = new QQUserUIItem();
    localQQUserUIItem.qq = paramString2;
    localQQUserUIItem.uid = paramString1;
    paramAppInterface = ((anmw)paramAppInterface.getManager(51)).e(String.valueOf(paramString2));
    if (paramAppInterface == null) {
      return null;
    }
    localQQUserUIItem.nickName = paramAppInterface.name;
    localQQUserUIItem.remark = paramAppInterface.remark;
    return localQQUserUIItem;
  }
  
  public String toString()
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder().append("QQStoryBanInfo banType = ").append(this.jdField_a_of_type_Int).append(", uinSize = ");
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      i = 0;
      localStringBuilder = localStringBuilder.append(i).append(", grouplistSize =");
      if (this.b != null) {
        break label78;
      }
    }
    label78:
    for (int i = j;; i = this.b.size())
    {
      return i;
      i = this.jdField_a_of_type_JavaUtilList.size();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wfd
 * JD-Core Version:    0.7.0.1
 */