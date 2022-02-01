package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import nkq;
import nnf;
import nng;
import rwt;

public class FastWebActivity$39$1
  implements Runnable
{
  public FastWebActivity$39$1(nkq paramnkq, boolean paramBoolean, int paramInt, String paramString, nnf paramnnf) {}
  
  public void run()
  {
    if (this.atg)
    {
      nng localnng = FastWebActivity.a(this.jdField_a_of_type_Nkq.this$0);
      ArticleInfo localArticleInfo = FastWebActivity.a(this.jdField_a_of_type_Nkq.this$0);
      int i = this.val$action;
      FastWebActivity localFastWebActivity = this.jdField_a_of_type_Nkq.this$0;
      String str2 = this.rc;
      if (FastWebActivity.d(this.jdField_a_of_type_Nkq.this$0)) {}
      for (String str1 = "0X8008994";; str1 = "0X800898D")
      {
        localnng.a(localArticleInfo, i, localFastWebActivity, str2, str1, this.jdField_a_of_type_Nnf.bF(this.val$action), FastWebActivity.d(this.jdField_a_of_type_Nkq.this$0), FastWebActivity.h(this.jdField_a_of_type_Nkq.this$0), FastWebActivity.e(this.jdField_a_of_type_Nkq.this$0));
        return;
      }
    }
    rwt.ez(1, 2131689537);
    QLog.d("Q.readinjoy.fast_web", 2, "shareJson get false ! action : " + this.val$action);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.39.1
 * JD-Core Version:    0.7.0.1
 */