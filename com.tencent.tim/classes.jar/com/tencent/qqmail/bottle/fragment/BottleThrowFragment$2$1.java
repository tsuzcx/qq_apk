package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.bottle.controller.BottleThrowController;
import com.tencent.qqmail.permission.PermissionUtils;
import moai.oss.KvHelper;
import rx.functions.Action1;

class BottleThrowFragment$2$1
  implements Action1<Boolean>
{
  BottleThrowFragment$2$1(BottleThrowFragment.2 param2) {}
  
  public void call(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      KvHelper.eventPermissionAcceptLocation(new double[0]);
      BottleThrowFragment.access$000(this.this$1.this$0);
      BottleThrowFragment.access$100(this.this$1.this$0).setOpenedLBS(true);
      BottleThrowFragment.access$100(this.this$1.this$0).loadLocality(true);
      return;
    }
    KvHelper.eventPermissionDenyLocation(new double[0]);
    PermissionUtils.permissionWarn(this.this$1.this$0.getActivity(), 2131718907, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleThrowFragment.2.1
 * JD-Core Version:    0.7.0.1
 */