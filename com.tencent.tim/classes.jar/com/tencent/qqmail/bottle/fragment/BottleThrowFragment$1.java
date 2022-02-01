package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.permission.PermissionUtils;
import moai.oss.KvHelper;
import rx.functions.Action1;

class BottleThrowFragment$1
  implements Action1<Boolean>
{
  BottleThrowFragment$1(BottleThrowFragment paramBottleThrowFragment) {}
  
  public void call(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      KvHelper.eventPermissionAcceptLocation(new double[0]);
      BottleThrowFragment.access$000(this.this$0);
      return;
    }
    KvHelper.eventPermissionDenyLocation(new double[0]);
    PermissionUtils.permissionWarn(this.this$0.getActivity(), 2131718907, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleThrowFragment.1
 * JD-Core Version:    0.7.0.1
 */