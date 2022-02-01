import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.11.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class njr
  implements ktr.c
{
  public njr(FastWebActivity paramFastWebActivity, String paramString1, String paramString2) {}
  
  public void onCommentListLoad(int paramInt1, boolean paramBoolean1, List<ktm> paramList, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    QLog.d(FastWebActivity.a(this.this$0), 2, "onCommentListLoad");
    this.this$0.getIntent().removeExtra("intent_key_anchor_data");
    if (!paramBoolean1) {}
    do
    {
      return;
      paramList = FastWebActivity.a(this.this$0).a().a();
    } while (paramList == null);
    if (!TextUtils.isEmpty(paramList.acs))
    {
      this.this$0.b(true, this.alA, this.alB, 2130772415, 0);
      FastWebActivity.a(this.this$0, 1000L);
    }
    for (;;)
    {
      paramList = new njs(this);
      FastWebActivity.a(this.this$0).registerDataSetObserver(paramList);
      ThreadManager.getUIHandler().postDelayed(new FastWebActivity.11.2(this, paramList), 2000L);
      return;
      FastWebActivity.a(this.this$0, 100L);
    }
  }
  
  public void onCommentStateError(int paramInt)
  {
    if (paramInt == 1001) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     njr
 * JD-Core Version:    0.7.0.1
 */