import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo.a;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyUgcSearchTopicFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class mkb
  extends lce
{
  public mkb(ReadInJoyUgcSearchTopicFragment paramReadInJoyUgcSearchTopicFragment) {}
  
  public void c(int paramInt, long paramLong, String paramString)
  {
    if ((0L != paramLong) && (!TextUtils.isEmpty(paramString)) && (ReadInJoyUgcSearchTopicFragment.a(this.this$0) != null) && (ReadInJoyUgcSearchTopicFragment.a(this.this$0).size() == 1))
    {
      TopicInfo localTopicInfo = (TopicInfo)ReadInJoyUgcSearchTopicFragment.a(this.this$0).get(0);
      long l = localTopicInfo.cO();
      String str1 = localTopicInfo.jS();
      String str2 = localTopicInfo.jT();
      String str3 = localTopicInfo.jU();
      localTopicInfo.jV();
      localTopicInfo = TopicInfo.a().a(l).a("#" + str1).b(str2).c(str3).d(paramString).a();
      ReadInJoyUgcSearchTopicFragment.a(this.this$0, localTopicInfo);
      kxm.a("0X800980A", ReadInJoyUgcSearchTopicFragment.a(this.this$0), paramLong, "1");
    }
    ReadInJoyUgcSearchTopicFragment.a(this.this$0, false);
    QLog.d("ReadInJoyUgcSearchTopicFragment", 1, "handle0xc16CreateTopic, topicID:" + paramLong + "  topicUrl:" + paramString + " result:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mkb
 * JD-Core Version:    0.7.0.1
 */