package com.tencent.qqmail.bottle.fragment;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.bottle.controller.OnActionCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.util.List;

class BottleListFragment$12$1$1
  implements OnActionCallback
{
  BottleListFragment$12$1$1(BottleListFragment.12.1 param1, List paramList) {}
  
  public void onErrorInMainThread(QMNetworkError paramQMNetworkError)
  {
    if (this.this$2.this$1.this$0.getActivity() != null) {
      Toast.makeText(QMApplicationContext.sharedInstance(), 2131690970, 1).show();
    }
  }
  
  public void onSuccessInMainThread(String paramString1, String paramString2)
  {
    if (this.this$2.this$1.this$0.getActivity() != null) {
      BottleListFragment.access$1300(this.this$2.this$1.this$0, this.val$bottleList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleListFragment.12.1.1
 * JD-Core Version:    0.7.0.1
 */