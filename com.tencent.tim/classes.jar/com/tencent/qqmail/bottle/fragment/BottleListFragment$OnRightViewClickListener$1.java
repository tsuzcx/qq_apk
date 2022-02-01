package com.tencent.qqmail.bottle.fragment;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.bottle.controller.OnActionCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;

class BottleListFragment$OnRightViewClickListener$1
  implements OnActionCallback
{
  BottleListFragment$OnRightViewClickListener$1(BottleListFragment.OnRightViewClickListener paramOnRightViewClickListener) {}
  
  public void onErrorInMainThread(QMNetworkError paramQMNetworkError)
  {
    if (this.this$1.this$0.getActivity() != null) {
      Toast.makeText(QMApplicationContext.sharedInstance(), 2131690970, 1).show();
    }
  }
  
  public void onSuccessInMainThread(String paramString1, String paramString2)
  {
    if (this.this$1.this$0.getActivity() != null) {
      BottleListFragment.access$000(this.this$1.this$0, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleListFragment.OnRightViewClickListener.1
 * JD-Core Version:    0.7.0.1
 */