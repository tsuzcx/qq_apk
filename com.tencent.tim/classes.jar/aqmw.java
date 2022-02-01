import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class aqmw
{
  public static CharSequence a(Context paramContext, ajws paramajws, String paramString)
  {
    if ((paramajws == null) || (TextUtils.isEmpty(paramajws.getTopicName()))) {
      return paramString;
    }
    String str = "#" + paramajws.getTopicName() + "#";
    paramString = new SpannableString(str + paramString);
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicName is " + str);
    }
    paramString.setSpan(new aqmx(paramContext, paramajws), 0, str.length(), 33);
    return paramString;
  }
  
  public static CharSequence b(Context paramContext, ajws paramajws, String paramString)
  {
    if ((paramajws == null) || (TextUtils.isEmpty(paramajws.getTopicName()))) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append("\n").append("#").append(paramajws.getTopicName()).append("#");
    SpannableString localSpannableString = new SpannableString(localStringBuilder.toString());
    if (QLog.isColorLevel()) {
      QLog.i("TopicHelper", 2, "topicAndDescWithLine is " + localStringBuilder);
    }
    localSpannableString.setSpan(new aqmy(paramContext, paramajws), paramString.length(), localStringBuilder.length(), 33);
    return localSpannableString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqmw
 * JD-Core Version:    0.7.0.1
 */