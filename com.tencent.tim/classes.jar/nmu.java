import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo.2;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo.2.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class nmu
  implements lhu.b
{
  public nmu(FastWebArticleInfo.2 param2) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramBoolean1) && (paramFastWebArticleInfo != null))
    {
      this.a.this$0.sN = paramFastWebArticleInfo.sN;
      if (paramFastWebArticleInfo.xK > this.a.this$0.xK) {
        this.a.this$0.xK = paramFastWebArticleInfo.xK;
      }
      this.a.this$0.aty = false;
      QLog.d("Q.readinjoy.fast_web", 2, "update fastweb info, rowkey : " + paramFastWebArticleInfo.rowKey + ",  commentCnt : " + paramFastWebArticleInfo.sN + ", readCnt :" + paramFastWebArticleInfo.xK);
    }
    ThreadManager.getUIHandler().post(new FastWebArticleInfo.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nmu
 * JD-Core Version:    0.7.0.1
 */