import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class wlr
  extends ahpp
{
  wlr(wll paramwll) {}
  
  protected void Z(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onBandIntimateRelationship");
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(this.this$0.mFriendUin)) || (!paramBoolean))
    {
      QLog.d("intimate_relationship", 1, String.format("onBandIntimateRelationship return, friendUin: %s", new Object[] { paramString }));
      return;
    }
    this.this$0.bZg();
  }
  
  protected void a(boolean paramBoolean, String paramString, IntimateInfo paramIntimateInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onGetIntimateInfo");
    }
    if ((this.this$0.a != null) && (this.this$0.a.getMode() == 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetIntimateInfo, in card mode, return");
      }
    }
    do
    {
      return;
      if (this.this$0.a != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetIntimateInfo, mViewDelegate == null:" + wll.b(this.this$0));
      }
    } while (wll.b(this.this$0));
    while ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(this.this$0.mFriendUin)))
    {
      QLog.d("intimate_relationship", 1, String.format("onGetIntimateInfo return, friendUin: %s", new Object[] { paramString }));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetIntimateInfo, mode: " + this.this$0.a.getMode());
      }
    }
    if (paramBoolean)
    {
      paramString = wll.a(this.this$0).obtainMessage();
      paramString.what = 0;
      paramString.obj = paramIntimateInfo;
      wll.a(this.this$0).removeMessages(0);
      wll.a(this.this$0).sendMessage(paramString);
      return;
    }
    paramString = wll.a(this.this$0).obtainMessage();
    paramString.what = 1;
    paramString.obj = this.this$0.mContext.getResources().getString(2131695064);
    wll.a(this.this$0).sendMessage(paramString);
  }
  
  protected void a(boolean paramBoolean, HashMap<Long, IntimateInfo> paramHashMap, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos");
    }
    if ((this.this$0.a != null) && (this.this$0.a.getMode() == 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, in card mode, return");
      }
    }
    do
    {
      return;
      if (this.this$0.a != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, mViewDelegate == null : " + wll.b(this.this$0));
      }
    } while (wll.b(this.this$0));
    paramObject = null;
    if ((paramBoolean) && (paramHashMap != null))
    {
      long l1 = 0L;
      try
      {
        long l2 = Long.valueOf(this.this$0.mFriendUin).longValue();
        l1 = l2;
      }
      catch (NumberFormatException paramObject)
      {
        for (;;)
        {
          QLog.e("intimate_relationship", 2, "valueOf string err ");
        }
      }
    }
    for (paramHashMap = (IntimateInfo)paramHashMap.get(Long.valueOf(l1));; paramHashMap = paramObject)
    {
      if (paramHashMap == null) {
        break label272;
      }
      paramObject = wll.a(this.this$0).obtainMessage();
      paramObject.what = 0;
      paramObject.obj = paramHashMap;
      wll.a(this.this$0).removeMessages(0);
      wll.a(this.this$0).sendMessage(paramObject);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("intimate_relationship", 2, "onGetGroupIntimateInfos, mode: " + this.this$0.a.getMode());
      break;
      QLog.e("intimate_relationship", 2, "onGetGroupIntimateInfos failed !");
    }
    label272:
    paramHashMap = wll.a(this.this$0).obtainMessage();
    paramHashMap.what = 1;
    paramHashMap.obj = this.this$0.mContext.getResources().getString(2131695064);
    wll.a(this.this$0).sendMessage(paramHashMap);
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onHandleGetLoverIntimateInfo isSuccess = " + paramBoolean + " data = " + paramArrayOfObject);
    }
    if (paramBoolean)
    {
      Message localMessage = wll.a(this.this$0).obtainMessage();
      localMessage.what = 7;
      localMessage.obj = paramArrayOfObject;
      wll.a(this.this$0).removeMessages(7);
      wll.a(this.this$0).sendMessage(localMessage);
      return;
    }
    paramArrayOfObject = wll.a(this.this$0).obtainMessage();
    paramArrayOfObject.what = 8;
    paramArrayOfObject.obj = null;
    wll.a(this.this$0).sendMessage(paramArrayOfObject);
  }
  
  protected void c(boolean paramBoolean, int paramInt, ArrayList<yxd> paramArrayList)
  {
    if (paramBoolean)
    {
      this.this$0.bPh = paramInt;
      this.this$0.mDataList = yyx.a(paramArrayList, this.this$0.mApp);
      yyx.cH(this.this$0.mFriendUin, paramInt);
      yyx.u(this.this$0.mFriendUin, paramArrayList);
      paramArrayList = wll.a(this.this$0).obtainMessage();
      paramArrayList.what = 9;
      paramArrayList.obj = null;
      wll.a(this.this$0).removeMessages(9);
      wll.a(this.this$0).sendMessage(paramArrayList);
      return;
    }
    paramArrayList = wll.a(this.this$0).obtainMessage();
    paramArrayList.what = 10;
    paramArrayList.obj = null;
    wll.a(this.this$0).sendMessage(paramArrayList);
  }
  
  protected void k(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "onDisbandIntimateRelationship");
    }
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(this.this$0.mFriendUin)))
    {
      QLog.d("intimate_relationship", 1, String.format("onDisbandIntimateRelationship return, friendUin: %s", new Object[] { paramString }));
      return;
    }
    Message localMessage = wll.a(this.this$0).obtainMessage();
    if (!paramBoolean1)
    {
      localMessage.what = 5;
      wll.a(this.this$0).sendMessage(localMessage);
      return;
    }
    if (paramBoolean2)
    {
      this.this$0.bZg();
      return;
    }
    localMessage.what = 6;
    localMessage.obj = paramString;
    wll.a(this.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wlr
 * JD-Core Version:    0.7.0.1
 */