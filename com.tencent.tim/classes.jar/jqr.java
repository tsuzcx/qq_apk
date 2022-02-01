import android.view.View;
import com.tencent.biz.eqq.CrmIvrText.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class jqr
  extends aofk
{
  QQAppInterface app = null;
  String frienduin = "";
  String selfuin = "";
  
  public jqr(CharSequence paramCharSequence, int paramInt1, int paramInt2, MessageRecord paramMessageRecord, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    super(paramCharSequence, paramInt1, paramInt2, paramMessageRecord);
    this.frienduin = paramString1;
    this.selfuin = paramString2;
    this.app = paramQQAppInterface;
  }
  
  static void a(View paramView, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    paramView.post(new CrmIvrText.1(paramQQAppInterface, paramView, paramString1));
  }
  
  protected void ayY()
  {
    super.ayY();
    Matcher localMatcher = Pattern.compile(aofv.aOv + "|" + "QQ语音").matcher(this.mText);
    while (localMatcher.find())
    {
      int i = localMatcher.start();
      int j = localMatcher.end();
      b(new jqr.a(this.mText.substring(i, j)), i, j, 33);
    }
  }
  
  public class a
    extends aofk.b
  {
    public a(String paramString)
    {
      super(paramString);
    }
    
    public void onClick(View paramView)
    {
      if (jqs.G.matcher(this.mUrl).find())
      {
        jqr.a(paramView, jqr.this.frienduin, jqr.this.selfuin, jqr.this.app);
        return;
      }
      super.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jqr
 * JD-Core Version:    0.7.0.1
 */