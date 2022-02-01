import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.1;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.3;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.4;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.5;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.6;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.7;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.8;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class nkq
  extends lhu.a
{
  public nkq(FastWebActivity paramFastWebActivity) {}
  
  public void B(long paramLong, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (FastWebActivity.a(this.this$0) == null) || (!paramString.equals(FastWebActivity.a(this.this$0).innerUniqueID)) || (FastWebActivity.a(this.this$0) == null))
    {
      QLog.d(FastWebActivity.a(this.this$0), 2, "handleBiuCntInfoResp fail, msg not match !");
      return;
    }
    ThreadManager.getUIHandler().post(new FastWebActivity.39.3(this, paramLong));
  }
  
  public void a(FastWebArticleInfo paramFastWebArticleInfo, int paramInt, String paramString)
  {
    this.this$0.runOnUiThread(new FastWebActivity.39.8(this, paramInt, paramFastWebArticleInfo, paramString));
  }
  
  public void a(FastWebArticleInfo paramFastWebArticleInfo, String paramString)
  {
    this.this$0.runOnUiThread(new FastWebActivity.39.7(this, paramString));
  }
  
  public void a(boolean paramBoolean, int paramInt, nnf paramnnf)
  {
    super.a(paramBoolean, paramInt, paramnnf);
    String str;
    if (FastWebActivity.a(this.this$0) != null)
    {
      str = FastWebActivity.a(this.this$0).mArticleContentUrl;
      if ((!paramBoolean) || (paramnnf == null) || (TextUtils.isEmpty(paramnnf.bF(paramInt))) || (TextUtils.isEmpty(str))) {
        break label86;
      }
    }
    label86:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ThreadManager.getUIHandler().post(new FastWebActivity.39.1(this, paramBoolean, paramInt, str, paramnnf));
      return;
      str = "";
      break;
    }
  }
  
  public void au(int paramInt, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (FastWebActivity.a(this.this$0) == null) || (!paramString.equals(FastWebActivity.a(this.this$0).innerUniqueID)) || (FastWebActivity.a(this.this$0) == null))
    {
      QLog.d(FastWebActivity.a(this.this$0), 2, "handleLikeCntInfoResp fail, msg not match !");
      return;
    }
    ThreadManager.getUIHandler().post(new FastWebActivity.39.4(this, paramInt));
  }
  
  public void nm(String paramString)
  {
    this.this$0.runOnUiThread(new FastWebActivity.39.6(this, paramString));
  }
  
  public void u(boolean paramBoolean, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (FastWebActivity.a(this.this$0) == null) || (!paramString.equals(FastWebActivity.a(this.this$0).innerUniqueID)) || (FastWebActivity.a(this.this$0) == null))
    {
      QLog.d(FastWebActivity.a(this.this$0), 2, "handleLikeStateResp fail, msg not match !");
      return;
    }
    ThreadManager.getUIHandler().post(new FastWebActivity.39.5(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nkq
 * JD-Core Version:    0.7.0.1
 */