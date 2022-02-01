import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25.2;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25.3;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class nkd
  extends lce
{
  public nkd(FastWebActivity paramFastWebActivity) {}
  
  public void aCi()
  {
    super.aCi();
    if ((FastWebActivity.f(this.this$0)) || (FastWebActivity.a(this.this$0) == null)) {
      return;
    }
    this.this$0.runOnUiThread(new FastWebActivity.25.1(this));
  }
  
  public void aJC()
  {
    super.aJC();
    if ((FastWebActivity.g(this.this$0)) || (FastWebActivity.a(this.this$0) == null) || (FastWebActivity.a(this.this$0) == null) || (FastWebActivity.a(this.this$0) == null)) {
      return;
    }
    FastWebActivity.a(this.this$0).eS(FastWebActivity.a(this.this$0).xK);
    FastWebActivity.g(this.this$0);
    FastWebActivity.a(this.this$0).notifyDataSetChanged();
  }
  
  public void aJD()
  {
    if (FastWebActivity.a(this.this$0) == null) {
      return;
    }
    FastWebActivity.g(this.this$0);
    FastWebActivity.a(this.this$0).notifyDataSetChanged();
  }
  
  public void mh(String paramString)
  {
    int j = 0;
    QLog.d("Q.readinjoy.fast_web", 2, " onWebCallback : " + paramString);
    if (!FastWebActivity.h(this.this$0)) {
      return;
    }
    int i;
    if ("onPageStarted".equals(paramString)) {
      i = 300;
    }
    for (;;)
    {
      ThreadManager.getUIHandler().postDelayed(new FastWebActivity.25.2(this), i);
      return;
      i = j;
      if ("onConversationJumpRestoreStack".equals(paramString)) {
        i = j;
      }
    }
  }
  
  public void o(String paramString, int paramInt1, int paramInt2)
  {
    if (FastWebActivity.a(this.this$0) == null) {
      return;
    }
    nnj.a(FastWebActivity.a(this.this$0), paramString, paramInt1, paramInt2);
    FastWebActivity.a(this.this$0).notifyDataSetChanged();
  }
  
  public void o(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      int[] arrayOfInt = new int[2];
      FastWebActivity.a(this.this$0).postDelayed(new FastWebActivity.25.3(this, arrayOfInt, paramString), 200L);
      return;
    }
    QLog.i(FastWebActivity.a(this.this$0), 1, " red packet task do not get Tips!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nkd
 * JD-Core Version:    0.7.0.1
 */