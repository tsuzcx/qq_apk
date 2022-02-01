import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class usj
  extends accd
{
  public usj(Conversation paramConversation) {}
  
  public void a(int paramInt1, int paramInt2, Map<String, Integer> paramMap, String paramString)
  {
    paramString = this.this$0.a();
    String str1 = this.this$0.app.getCurrentAccountUin();
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      Iterator localIterator = paramMap.keySet().iterator();
      paramInt1 = 0;
      if (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        paramInt2 = ((Integer)paramMap.get(str2)).intValue();
        if (paramInt2 == 4000) {
          aqmj.W(paramString, str1, str2);
        }
      }
    }
    for (;;)
    {
      break;
      if (paramInt2 != 0)
      {
        paramInt1 = 1;
        continue;
        if (paramInt1 == 0) {
          aqmj.cx(this.this$0.a(), this.this$0.app.getCurrentAccountUin());
        }
        return;
      }
    }
  }
  
  protected void c(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (paramInt2 != 0)
    {
      paramString1 = paramString2;
      if (!this.this$0.a().isFinishing())
      {
        paramString1 = paramString2;
        if (Conversation.a(this.this$0))
        {
          paramString1 = paramString2;
          if (!"troop_delete_top_from_conversation".equals(paramString3))
          {
            paramString1 = paramString2;
            if (TextUtils.isEmpty(paramString2)) {
              paramString1 = this.this$0.getResources().getString(2131696690);
            }
            QQToast.a(this.this$0.a(), 1, paramString1, 0).show();
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "onSetCommonUsedTroop, retCode = " + paramInt2 + " , wording = " + paramString1);
      }
      return;
      this.this$0.n(9, paramString1, 1);
      paramString1 = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     usj
 * JD-Core Version:    0.7.0.1
 */